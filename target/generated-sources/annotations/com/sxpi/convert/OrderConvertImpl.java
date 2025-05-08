package com.sxpi.convert;

import com.sxpi.model.dto.OrderDTO;
import com.sxpi.model.entity.Order;
import com.sxpi.model.vo.OrderVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class OrderConvertImpl implements OrderConvert {

    @Override
    public List<OrderVO> convertEntityToVo(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderVO> list = new ArrayList<OrderVO>( orders.size() );
        for ( Order order : orders ) {
            list.add( convertEntityToVo( order ) );
        }

        return list;
    }

    @Override
    public OrderVO convertEntityToVo(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderVO orderVO = new OrderVO();

        orderVO.setPageNo( order.getPageNo() );
        orderVO.setPageSize( order.getPageSize() );
        orderVO.setCreatedBy( order.getCreatedBy() );
        orderVO.setCreatedTime( order.getCreatedTime() );
        orderVO.setUpdateBy( order.getUpdateBy() );
        orderVO.setUpdateTime( order.getUpdateTime() );
        orderVO.setIsDeleted( order.getIsDeleted() );
        orderVO.setId( order.getId() );
        orderVO.setOrderNo( order.getOrderNo() );
        orderVO.setUserId( order.getUserId() );
        orderVO.setMerchantId( order.getMerchantId() );
        orderVO.setOrderType( order.getOrderType() );
        orderVO.setAddressId( order.getAddressId() );
        orderVO.setTotalAmount( order.getTotalAmount() );
        orderVO.setDeliveryFee( order.getDeliveryFee() );
        orderVO.setDiscountAmount( order.getDiscountAmount() );
        orderVO.setCouponId( order.getCouponId() );
        orderVO.setActualAmount( order.getActualAmount() );
        orderVO.setRemark( order.getRemark() );
        orderVO.setStatus( order.getStatus() );
        orderVO.setPaymentMethod( order.getPaymentMethod() );
        orderVO.setPaymentTime( order.getPaymentTime() );
        orderVO.setAcceptTime( order.getAcceptTime() );
        orderVO.setDeliveryTime( order.getDeliveryTime() );
        orderVO.setFinishTime( order.getFinishTime() );
        orderVO.setCancelTime( order.getCancelTime() );
        orderVO.setCancelReason( order.getCancelReason() );
        orderVO.setDeliveryManId( order.getDeliveryManId() );
        orderVO.setExpectedDeliveryTime( order.getExpectedDeliveryTime() );
        orderVO.setCommunityId( order.getCommunityId() );

        return orderVO;
    }

    @Override
    public Order convertDtoToEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setPageNo( orderDTO.getPageNo() );
        order.setPageSize( orderDTO.getPageSize() );
        order.setCreatedBy( orderDTO.getCreatedBy() );
        order.setCreatedTime( orderDTO.getCreatedTime() );
        order.setUpdateBy( orderDTO.getUpdateBy() );
        order.setUpdateTime( orderDTO.getUpdateTime() );
        order.setIsDeleted( orderDTO.getIsDeleted() );
        order.setId( orderDTO.getId() );
        order.setOrderNo( orderDTO.getOrderNo() );
        order.setUserId( orderDTO.getUserId() );
        order.setMerchantId( orderDTO.getMerchantId() );
        order.setOrderType( orderDTO.getOrderType() );
        order.setAddressId( orderDTO.getAddressId() );
        order.setTotalAmount( orderDTO.getTotalAmount() );
        order.setDeliveryFee( orderDTO.getDeliveryFee() );
        order.setDiscountAmount( orderDTO.getDiscountAmount() );
        order.setCouponId( orderDTO.getCouponId() );
        order.setActualAmount( orderDTO.getActualAmount() );
        order.setRemark( orderDTO.getRemark() );
        order.setStatus( orderDTO.getStatus() );
        order.setPaymentMethod( orderDTO.getPaymentMethod() );
        order.setPaymentTime( orderDTO.getPaymentTime() );
        order.setAcceptTime( orderDTO.getAcceptTime() );
        order.setDeliveryTime( orderDTO.getDeliveryTime() );
        order.setFinishTime( orderDTO.getFinishTime() );
        order.setCancelTime( orderDTO.getCancelTime() );
        order.setCancelReason( orderDTO.getCancelReason() );
        order.setDeliveryManId( orderDTO.getDeliveryManId() );
        order.setExpectedDeliveryTime( orderDTO.getExpectedDeliveryTime() );
        order.setCommunityId( orderDTO.getCommunityId() );

        return order;
    }
}
