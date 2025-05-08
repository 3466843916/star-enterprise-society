package com.sxpi.convert;

import com.sxpi.model.dto.ReviewDTO;
import com.sxpi.model.entity.Review;
import com.sxpi.model.vo.ReviewVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ReviewConvertImpl implements ReviewConvert {

    @Override
    public List<ReviewVO> convertEntityToVo(List<Review> reviews) {
        if ( reviews == null ) {
            return null;
        }

        List<ReviewVO> list = new ArrayList<ReviewVO>( reviews.size() );
        for ( Review review : reviews ) {
            list.add( convertEntityToVo( review ) );
        }

        return list;
    }

    @Override
    public ReviewVO convertEntityToVo(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewVO reviewVO = new ReviewVO();

        reviewVO.setPageNo( review.getPageNo() );
        reviewVO.setPageSize( review.getPageSize() );
        reviewVO.setCreatedBy( review.getCreatedBy() );
        reviewVO.setCreatedTime( review.getCreatedTime() );
        reviewVO.setUpdateBy( review.getUpdateBy() );
        reviewVO.setUpdateTime( review.getUpdateTime() );
        reviewVO.setIsDeleted( review.getIsDeleted() );
        reviewVO.setId( review.getId() );
        reviewVO.setOrderId( review.getOrderId() );
        reviewVO.setUserId( review.getUserId() );
        reviewVO.setMerchantId( review.getMerchantId() );
        reviewVO.setOrderRating( review.getOrderRating() );
        reviewVO.setFoodRating( review.getFoodRating() );
        reviewVO.setDeliveryRating( review.getDeliveryRating() );
        reviewVO.setContent( review.getContent() );
        reviewVO.setImages( review.getImages() );
        reviewVO.setMerchantReply( review.getMerchantReply() );
        reviewVO.setReplyTime( review.getReplyTime() );
        reviewVO.setIsAnonymous( review.getIsAnonymous() );
        reviewVO.setLikeCount( review.getLikeCount() );
        reviewVO.setStatus( review.getStatus() );

        return reviewVO;
    }

    @Override
    public Review convertDtoToEntity(ReviewDTO reviewDTO) {
        if ( reviewDTO == null ) {
            return null;
        }

        Review review = new Review();

        review.setPageNo( reviewDTO.getPageNo() );
        review.setPageSize( reviewDTO.getPageSize() );
        review.setCreatedBy( reviewDTO.getCreatedBy() );
        review.setCreatedTime( reviewDTO.getCreatedTime() );
        review.setUpdateBy( reviewDTO.getUpdateBy() );
        review.setUpdateTime( reviewDTO.getUpdateTime() );
        review.setIsDeleted( reviewDTO.getIsDeleted() );
        review.setId( reviewDTO.getId() );
        review.setOrderId( reviewDTO.getOrderId() );
        review.setUserId( reviewDTO.getUserId() );
        review.setMerchantId( reviewDTO.getMerchantId() );
        review.setOrderRating( reviewDTO.getOrderRating() );
        review.setFoodRating( reviewDTO.getFoodRating() );
        review.setDeliveryRating( reviewDTO.getDeliveryRating() );
        review.setContent( reviewDTO.getContent() );
        review.setImages( reviewDTO.getImages() );
        review.setMerchantReply( reviewDTO.getMerchantReply() );
        review.setReplyTime( reviewDTO.getReplyTime() );
        review.setIsAnonymous( reviewDTO.getIsAnonymous() );
        review.setLikeCount( reviewDTO.getLikeCount() );
        review.setStatus( reviewDTO.getStatus() );

        return review;
    }
}
