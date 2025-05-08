package com.sxpi.convert;

import com.sxpi.model.dto.SystemNotificationDTO;
import com.sxpi.model.entity.SystemNotification;
import com.sxpi.model.vo.SystemNotificationVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * SystemNotification转换器
 */
@Mapper
public interface SystemNotificationConvert {
    SystemNotificationConvert INSTANCE = Mappers.getMapper(SystemNotificationConvert.class);

    List<SystemNotificationVO> convertEntityToVo(List<SystemNotification> systemNotifications);
    SystemNotificationVO convertEntityToVo(SystemNotification systemNotification);
    SystemNotification convertDtoToEntity(SystemNotificationDTO systemNotificationDTO);
} 