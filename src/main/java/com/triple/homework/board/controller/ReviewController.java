package com.triple.homework.board.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.triple.homework.board.domain.Place_infoVO;
import com.triple.homework.board.domain.Point_hstVO;
import com.triple.homework.board.domain.ReviewVO;
import com.triple.homework.board.domain.Review_dtlVO;
import com.triple.homework.board.domain.Review_mstVO;
import com.triple.homework.board.domain.User_infoVO;
import com.triple.homework.board.service.PlaceService;
import com.triple.homework.board.service.PointService;
import com.triple.homework.board.service.ReviewService;
import com.triple.homework.board.service.Review_dtlService;
import com.triple.homework.board.service.Review_mstService;
import com.triple.homework.board.service.UserService;

@Controller
public class ReviewController {

	@Resource(name = "com.triple.homework.board.service.PlaceService")
	PlaceService placeService;
	@Resource(name = "com.triple.homework.board.service.Review_mstService")
	Review_mstService review_mstService;
	@Resource(name = "com.triple.homework.board.service.Review_dtlService")
	Review_dtlService review_dtlService;
	@Resource(name = "com.triple.homework.board.service.ReviewService")
	ReviewService reviewService;
	@Resource(name = "com.triple.homework.board.service.UserService")
	UserService userService;
	@Resource(name = "com.triple.homework.board.service.PointService")
	PointService pointService;

	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	private String mCommentServiceInsert(ReviewVO reviewvo) throws Exception {
		try {

			Date now = new Date();
			int point = 0;
			//댓글에 첨부된 사진 리스트
			List<String> img = reviewvo.getAttachedPhotoIds();

			// 이전 포인트
			Integer before_point = 0;
			Integer a = userService.userPointService(reviewvo.getUser_id());
			if (a != null)
				before_point = a;
			
			// 이전 첫리뷰
			String before_first = placeService.first_reviewerService(reviewvo.getPlace_id());
			
			// 이전 댓글
			String before_review = review_mstService.review_mstContentService(reviewvo.getReview_id());
			
			// 이전 사진id
			List<String> before_img = review_dtlService.review_dtlListService(reviewvo.getReview_id());
			
			// 사진 마지막 seq
			Integer last_seq_img = 0;
			Integer b = review_dtlService.imgSeqService(reviewvo.getReview_id());
			if (b != null)
				last_seq_img = b;

			//댓글mst
			Review_mstVO mst = new Review_mstVO();
			mst.setPlace_id(reviewvo.getPlace_id());
			mst.setReview_id(reviewvo.getReview_id());
			mst.setReview_tm(now);
			mst.setReview_txt(reviewvo.getContent());
			mst.setUser_id(reviewvo.getUser_id());

			if (reviewvo.getType().equals("REVIEW")) {
				
				// 새로저장
				if (reviewvo.getAction().equals("ADD")) 
				{
					// 신규유저라면 유저 생성
					String user_check = userService.userCheckService(reviewvo.getUser_id());
					if (user_check == null || user_check.equals("")) {
						User_infoVO new_user = new User_infoVO();
						new_user.setUser_id(reviewvo.getUser_id());
						new_user.setUser_point(0);
						int new_user_save = userService.userInsertService(new_user);
					} 
					else 
					{
						// 있는 유저라면 해당 장소에 댓글이 있었는지 확인
						List<ReviewVO> review_exist = reviewService.reviewExistService(reviewvo.getPlace_id(),
								reviewvo.getUser_id());
						if (review_exist.size() > 0)
							return "redirect:/detail/" + reviewvo.getPlace_id();
					}

					// review_mst 저장
					int review_add = review_mstService.review_mstInsertService(mst);

					// review_dtl 저장 이미지
					for (int j = 0; j < img.size(); j++)
					{
						last_seq_img = last_seq_img + 1;
						Review_dtlVO dtl = new Review_dtlVO();

						dtl.setReview_id(reviewvo.getReview_id());
						dtl.setImg_sq(last_seq_img);
						dtl.setImg_id(img.get(j));
						int new_img = review_dtlService.review_dtlInsertService(dtl);
					}

					// 첫 댓글이면 +1, 장소테이블 update
					if (before_first == null || before_first.equals("")) {
						point++;
						Place_infoVO firstreview = new Place_infoVO();
						firstreview.setPlace_id(reviewvo.getPlace_id());
						firstreview.setFirst_review_id(reviewvo.getUser_id());
						int first = placeService.placeUpdateService(firstreview);
					}
				} 
				
				//수정
				else if (reviewvo.getAction().equals("MOD")) 
				{
					// review_mst 수정
					int review_mod = review_mstService.review_mstUpdateService(mst);

					// 사진 변경 확인 후 review_dtl수정
					List<String> before_pic = new ArrayList<>();  //이전 사진리스트
					List<String> now_pic = new ArrayList<>();     //현재 사진리스트

					for (int j = 0; j < img.size(); j++)
						now_pic.add(img.get(j));
					for (int k = 0; k < before_img.size(); k++)
						before_pic.add(before_img.get(k));

					// 최근꺼에 있는데 이전에 없으면 추가
					for (String str : now_pic) {
						if (!before_pic.contains(str)) {
							last_seq_img = last_seq_img + 1;
							Review_dtlVO dtl = new Review_dtlVO();

							dtl.setReview_id(reviewvo.getReview_id());
							dtl.setImg_sq(last_seq_img);
							dtl.setImg_id(str);
							int new_img = review_dtlService.review_dtlInsertService(dtl);
						}
					}

					// 이전꺼에 있는데 최근에 없으면 삭제
					for (String str : before_pic) {
						if (!now_pic.contains(str)) {
							Review_dtlVO dtl = new Review_dtlVO();
							dtl.setReview_id(reviewvo.getReview_id());
							dtl.setImg_id(str);
							int new_img = review_dtlService.review_dtlsqDeleteService(dtl);
						}
					}
				} 
				
				//삭제
				else 
				{
					// review_mst 삭제
					Review_mstVO mst_del = new Review_mstVO();
					int del_mst = review_mstService.review_mstDeleteService(reviewvo.getReview_id());

					// review_dtl 삭제
					Review_dtlVO dtl_del = new Review_dtlVO();
					dtl_del.setReview_id(reviewvo.getReview_id());
					int del_dtl = review_dtlService.review_dtlDeleteService(reviewvo.getReview_id());

					// 첫 작성자와 같은사람이면 -1점 및 장소테이블 초기화
					if (before_first.equals(reviewvo.getUser_id())) {
						point = point - 1;

						Place_infoVO place_update = new Place_infoVO();
						place_update.setPlace_id(reviewvo.getPlace_id());
						place_update.setFirst_review_id("");
						int first = placeService.placeUpdateService(place_update);
					}
				}
			}

			//ADD 또는 MOD일 경우
			if (!reviewvo.getAction().equals("DELETE")) {

				// 리뷰 1글자이상이라면 포인트 ++
				if ((reviewvo.getContent() == null || reviewvo.getContent().equals("")) && before_review!=null && !before_review.equals(""))
					point = point - 1;
				else if (reviewvo.getContent() != null && reviewvo.getContent().length() > 0 && (before_review == null || before_review.equals("")))
					point++;

				// 사진이 1장 이상이라면 포인트 ++
				if (img.size() == 0 && before_img.size() > 0)
					point = point - 1;
				else if (img.size() > 0 && before_img.size() == 0)
					point++;
			}
			
			//DELETE일 경우
			else 
			{
				// 리뷰가 있었다면 -1
				if (before_review!=null && !before_review.equals(""))
					point = point - 1;
				
				// 사진이 있었다면 -1
				if (before_img.size() > 0)
					point = point - 1;
			}

			// 점수 update
			User_infoVO user_point = new User_infoVO();
			user_point.setUser_id(reviewvo.getUser_id());
			user_point.setUser_point(before_point + point);
			int point_update = userService.userUpdateService(user_point);

			// 점수 update 이력저장
			Integer c = pointService.pointSeqService(reviewvo.getUser_id());
			int seq = 0;

			if (c == null)
				seq = 0;
			else
				seq = c + 1;

			Point_hstVO point_hst = new Point_hstVO();
			point_hst.setUser_id(reviewvo.getUser_id());
			point_hst.setHst_sq(seq);
			point_hst.setChange_status(reviewvo.getAction());
			point_hst.setReview_id(reviewvo.getReview_id());
			point_hst.setPlace_id(reviewvo.getPlace_id());
			point_hst.setChange_point(point);
			point_hst.setReview_tm(now);
			int point_save = pointService.pointInsertService(point_hst);

			return "redirect:/detail/" + reviewvo.getPlace_id();
		} catch (Exception e) {
			throw e;
		}

	}
}
