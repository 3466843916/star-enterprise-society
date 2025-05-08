package com.sxpi.convert;

import com.sxpi.model.dto.ReviewDTO;
import com.sxpi.model.entity.Review;
import com.sxpi.model.vo.ReviewVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Review转换器
 */
@Mapper
public interface ReviewConvert {
    ReviewConvert INSTANCE = Mappers.getMapper(ReviewConvert.class);

    List<ReviewVO> convertEntityToVo(List<Review> reviews);
    ReviewVO convertEntityToVo(Review review);
    Review convertDtoToEntity(ReviewDTO reviewDTO);
} 