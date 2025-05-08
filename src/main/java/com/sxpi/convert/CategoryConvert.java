package com.sxpi.convert;

import com.sxpi.model.dto.CategoryDTO;
import com.sxpi.model.entity.Category;
import com.sxpi.model.vo.CategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Category转换器
 */
@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    List<CategoryVO> convertEntityToVo(List<Category> categories);
    CategoryVO convertEntityToVo(Category category);
    Category convertDtoToEntity(CategoryDTO categoryDTO);
} 