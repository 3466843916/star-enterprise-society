package com.sxpi.convert;

import com.sxpi.model.dto.SystemNotificationDTO;
import com.sxpi.model.entity.SystemNotification;
import com.sxpi.model.vo.SystemNotificationVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class SystemNotificationConvertImpl implements SystemNotificationConvert {

    @Override
    public List<SystemNotificationVO> convertEntityToVo(List<SystemNotification> systemNotifications) {
        if ( systemNotifications == null ) {
            return null;
        }

        List<SystemNotificationVO> list = new ArrayList<SystemNotificationVO>( systemNotifications.size() );
        for ( SystemNotification systemNotification : systemNotifications ) {
            list.add( convertEntityToVo( systemNotification ) );
        }

        return list;
    }

    @Override
    public SystemNotificationVO convertEntityToVo(SystemNotification systemNotification) {
        if ( systemNotification == null ) {
            return null;
        }

        SystemNotificationVO systemNotificationVO = new SystemNotificationVO();

        systemNotificationVO.setPageNo( systemNotification.getPageNo() );
        systemNotificationVO.setPageSize( systemNotification.getPageSize() );
        systemNotificationVO.setCreatedBy( systemNotification.getCreatedBy() );
        systemNotificationVO.setCreatedTime( systemNotification.getCreatedTime() );
        systemNotificationVO.setUpdateBy( systemNotification.getUpdateBy() );
        systemNotificationVO.setUpdateTime( systemNotification.getUpdateTime() );
        systemNotificationVO.setIsDeleted( systemNotification.getIsDeleted() );
        systemNotificationVO.setId( systemNotification.getId() );
        systemNotificationVO.setUserId( systemNotification.getUserId() );
        systemNotificationVO.setTitle( systemNotification.getTitle() );
        systemNotificationVO.setContent( systemNotification.getContent() );
        systemNotificationVO.setNotificationType( systemNotification.getNotificationType() );
        systemNotificationVO.setRelatedId( systemNotification.getRelatedId() );
        systemNotificationVO.setRelatedType( systemNotification.getRelatedType() );
        systemNotificationVO.setIsRead( systemNotification.getIsRead() );
        systemNotificationVO.setReadTime( systemNotification.getReadTime() );
        systemNotificationVO.setPriority( systemNotification.getPriority() );
        systemNotificationVO.setExpireTime( systemNotification.getExpireTime() );
        systemNotificationVO.setPushStatus( systemNotification.getPushStatus() );
        systemNotificationVO.setPushTime( systemNotification.getPushTime() );

        return systemNotificationVO;
    }

    @Override
    public SystemNotification convertDtoToEntity(SystemNotificationDTO systemNotificationDTO) {
        if ( systemNotificationDTO == null ) {
            return null;
        }

        SystemNotification systemNotification = new SystemNotification();

        systemNotification.setPageNo( systemNotificationDTO.getPageNo() );
        systemNotification.setPageSize( systemNotificationDTO.getPageSize() );
        systemNotification.setCreatedBy( systemNotificationDTO.getCreatedBy() );
        systemNotification.setCreatedTime( systemNotificationDTO.getCreatedTime() );
        systemNotification.setUpdateBy( systemNotificationDTO.getUpdateBy() );
        systemNotification.setUpdateTime( systemNotificationDTO.getUpdateTime() );
        systemNotification.setIsDeleted( systemNotificationDTO.getIsDeleted() );
        systemNotification.setId( systemNotificationDTO.getId() );
        systemNotification.setUserId( systemNotificationDTO.getUserId() );
        systemNotification.setTitle( systemNotificationDTO.getTitle() );
        systemNotification.setContent( systemNotificationDTO.getContent() );
        systemNotification.setNotificationType( systemNotificationDTO.getNotificationType() );
        systemNotification.setRelatedId( systemNotificationDTO.getRelatedId() );
        systemNotification.setRelatedType( systemNotificationDTO.getRelatedType() );
        systemNotification.setIsRead( systemNotificationDTO.getIsRead() );
        systemNotification.setReadTime( systemNotificationDTO.getReadTime() );
        systemNotification.setPriority( systemNotificationDTO.getPriority() );
        systemNotification.setExpireTime( systemNotificationDTO.getExpireTime() );
        systemNotification.setPushStatus( systemNotificationDTO.getPushStatus() );
        systemNotification.setPushTime( systemNotificationDTO.getPushTime() );

        return systemNotification;
    }
}
