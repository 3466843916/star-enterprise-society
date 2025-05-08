package com.sxpi.convert;

import com.sxpi.model.dto.CategoryDTO;
import com.sxpi.model.entity.Category;
import com.sxpi.model.vo.CategoryVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class CategoryConvertImpl implements CategoryConvert {

    @Override
    public List<CategoryVO> convertEntityToVo(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryVO> list = new ArrayList<CategoryVO>( categories.size() );
        for ( Category category : categories ) {
            list.add( convertEntityToVo( category ) );
        }

        return list;
    }

    @Override
    public CategoryVO convertEntityToVo(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryVO categoryVO = new CategoryVO();

        categoryVO.setPageNo( category.getPageNo() );
        categoryVO.setPageSize( category.getPageSize() );
        categoryVO.setCreatedBy( category.getCreatedBy() );
        categoryVO.setCreatedTime( category.getCreatedTime() );
        categoryVO.setUpdateBy( category.getUpdateBy() );
        categoryVO.setUpdateTime( category.getUpdateTime() );
        categoryVO.setIsDeleted( category.getIsDeleted() );
        categoryVO.setId( category.getId() );
        categoryVO.setCategoryName( category.getCategoryName() );
        categoryVO.setMerchantId( category.getMerchantId() );
        categoryVO.setParentId( category.getParentId() );
        categoryVO.setIcon( category.getIcon() );
        categoryVO.setSortOrder( category.getSortOrder() );
        categoryVO.setLevel( category.getLevel() );
        categoryVO.setStatus( category.getStatus() );
        categoryVO.setDescription( category.getDescription() );
        categoryVO.setIsRecommend( category.getIsRecommend() );

        return categoryVO;
    }

    @Override
    public Category convertDtoToEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setPageNo( categoryDTO.getPageNo() );
        category.setPageSize( categoryDTO.getPageSize() );
        category.setCreatedBy( categoryDTO.getCreatedBy() );
        category.setCreatedTime( categoryDTO.getCreatedTime() );
        category.setUpdateBy( categoryDTO.getUpdateBy() );
        category.setUpdateTime( categoryDTO.getUpdateTime() );
        category.setIsDeleted( categoryDTO.getIsDeleted() );
        category.setId( categoryDTO.getId() );
        category.setCategoryName( categoryDTO.getCategoryName() );
        category.setMerchantId( categoryDTO.getMerchantId() );
        category.setParentId( categoryDTO.getParentId() );
        category.setIcon( categoryDTO.getIcon() );
        category.setSortOrder( categoryDTO.getSortOrder() );
        category.setLevel( categoryDTO.getLevel() );
        category.setStatus( categoryDTO.getStatus() );
        category.setDescription( categoryDTO.getDescription() );
        category.setIsRecommend( categoryDTO.getIsRecommend() );

        return category;
    }
}
