package com.sxpi.convert;


import com.sxpi.model.dto.DishesDTO;
import com.sxpi.model.entity.Dishes;
import com.sxpi.model.vo.DishesVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Mapper
public interface DishesConvert {
    DishesConvert INSTANCE = Mappers.getMapper(DishesConvert.class);


    List<DishesVO> convertEntityToVo(List<Dishes> dishes);
    DishesVO convertEntityToVo(Dishes dishes);
    Dishes convertDtoToEntity(DishesDTO dishesDTO);

}
