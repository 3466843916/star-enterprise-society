package com.sxpi.convert;

import com.sxpi.model.dto.DishesDTO;
import com.sxpi.model.entity.Dishes;
import com.sxpi.model.vo.DishesVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class DishesConvertImpl implements DishesConvert {

    @Override
    public List<DishesVO> convertEntityToVo(List<Dishes> dishes) {
        if ( dishes == null ) {
            return null;
        }

        List<DishesVO> list = new ArrayList<DishesVO>( dishes.size() );
        for ( Dishes dishes1 : dishes ) {
            list.add( convertEntityToVo( dishes1 ) );
        }

        return list;
    }

    @Override
    public DishesVO convertEntityToVo(Dishes dishes) {
        if ( dishes == null ) {
            return null;
        }

        DishesVO dishesVO = new DishesVO();

        dishesVO.setPageNo( dishes.getPageNo() );
        dishesVO.setPageSize( dishes.getPageSize() );
        dishesVO.setCreatedBy( dishes.getCreatedBy() );
        dishesVO.setCreatedTime( dishes.getCreatedTime() );
        dishesVO.setUpdateBy( dishes.getUpdateBy() );
        dishesVO.setUpdateTime( dishes.getUpdateTime() );
        dishesVO.setIsDeleted( dishes.getIsDeleted() );
        dishesVO.setId( dishes.getId() );
        dishesVO.setDishName( dishes.getDishName() );
        dishesVO.setPrice( dishes.getPrice() );
        dishesVO.setUserId( dishes.getUserId() );
        dishesVO.setOriginalPrice( dishes.getOriginalPrice() );
        dishesVO.setDescription( dishes.getDescription() );
        dishesVO.setImageUrl( dishes.getImageUrl() );
        dishesVO.setSales( dishes.getSales() );
        dishesVO.setMonthlySales( dishes.getMonthlySales() );
        dishesVO.setRating( dishes.getRating() );
        dishesVO.setStatus( dishes.getStatus() );
        dishesVO.setIsRecommend( dishes.getIsRecommend() );
        dishesVO.setIsSpicy( dishes.getIsSpicy() );
        dishesVO.setRemark( dishes.getRemark() );

        return dishesVO;
    }

    @Override
    public Dishes convertDtoToEntity(DishesDTO dishesDTO) {
        if ( dishesDTO == null ) {
            return null;
        }

        Dishes dishes = new Dishes();

        dishes.setPageNo( dishesDTO.getPageNo() );
        dishes.setPageSize( dishesDTO.getPageSize() );
        dishes.setCreatedBy( dishesDTO.getCreatedBy() );
        dishes.setCreatedTime( dishesDTO.getCreatedTime() );
        dishes.setUpdateBy( dishesDTO.getUpdateBy() );
        dishes.setUpdateTime( dishesDTO.getUpdateTime() );
        dishes.setIsDeleted( dishesDTO.getIsDeleted() );
        dishes.setId( dishesDTO.getId() );
        dishes.setDishName( dishesDTO.getDishName() );
        dishes.setPrice( dishesDTO.getPrice() );
        dishes.setUserId( dishesDTO.getUserId() );
        dishes.setOriginalPrice( dishesDTO.getOriginalPrice() );
        dishes.setDescription( dishesDTO.getDescription() );
        dishes.setImageUrl( dishesDTO.getImageUrl() );
        dishes.setSales( dishesDTO.getSales() );
        dishes.setMonthlySales( dishesDTO.getMonthlySales() );
        dishes.setRating( dishesDTO.getRating() );
        dishes.setStatus( dishesDTO.getStatus() );
        dishes.setIsRecommend( dishesDTO.getIsRecommend() );
        dishes.setIsSpicy( dishesDTO.getIsSpicy() );
        dishes.setRemark( dishesDTO.getRemark() );

        return dishes;
    }
}
