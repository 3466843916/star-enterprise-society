package com.sxpi.convert;

import com.sxpi.model.dto.OrderDTO;
import com.sxpi.model.entity.Order;
import com.sxpi.model.vo.OrderVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Order转换器
 */
@Mapper
public interface OrderConvert {
    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    List<OrderVO> convertEntityToVo(List<Order> orders);
    OrderVO convertEntityToVo(Order order);
    Order convertDtoToEntity(OrderDTO orderDTO);
} 