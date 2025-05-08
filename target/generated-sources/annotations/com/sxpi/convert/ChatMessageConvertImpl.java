package com.sxpi.convert;

import com.sxpi.model.dto.ChatMessageDTO;
import com.sxpi.model.entity.ChatMessage;
import com.sxpi.model.vo.ChatMessageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ChatMessageConvertImpl implements ChatMessageConvert {

    @Override
    public List<ChatMessageVO> convertEntityToVo(List<ChatMessage> chatMessages) {
        if ( chatMessages == null ) {
            return null;
        }

        List<ChatMessageVO> list = new ArrayList<ChatMessageVO>( chatMessages.size() );
        for ( ChatMessage chatMessage : chatMessages ) {
            list.add( convertEntityToVo( chatMessage ) );
        }

        return list;
    }

    @Override
    public ChatMessageVO convertEntityToVo(ChatMessage chatMessage) {
        if ( chatMessage == null ) {
            return null;
        }

        ChatMessageVO chatMessageVO = new ChatMessageVO();

        chatMessageVO.setPageNo( chatMessage.getPageNo() );
        chatMessageVO.setPageSize( chatMessage.getPageSize() );
        chatMessageVO.setCreatedBy( chatMessage.getCreatedBy() );
        chatMessageVO.setCreatedTime( chatMessage.getCreatedTime() );
        chatMessageVO.setUpdateBy( chatMessage.getUpdateBy() );
        chatMessageVO.setUpdateTime( chatMessage.getUpdateTime() );
        chatMessageVO.setIsDeleted( chatMessage.getIsDeleted() );
        chatMessageVO.setId( chatMessage.getId() );
        chatMessageVO.setSessionId( chatMessage.getSessionId() );
        chatMessageVO.setSenderId( chatMessage.getSenderId() );
        chatMessageVO.setMessageType( chatMessage.getMessageType() );
        chatMessageVO.setContent( chatMessage.getContent() );
        chatMessageVO.setMediaUrl( chatMessage.getMediaUrl() );
        chatMessageVO.setMediaSize( chatMessage.getMediaSize() );
        chatMessageVO.setMediaDuration( chatMessage.getMediaDuration() );
        chatMessageVO.setThumbnail( chatMessage.getThumbnail() );
        chatMessageVO.setLatitude( chatMessage.getLatitude() );
        chatMessageVO.setLongitude( chatMessage.getLongitude() );
        chatMessageVO.setAddress( chatMessage.getAddress() );
        chatMessageVO.setReferenceId( chatMessage.getReferenceId() );

        return chatMessageVO;
    }

    @Override
    public ChatMessage convertDtoToEntity(ChatMessageDTO chatMessageDTO) {
        if ( chatMessageDTO == null ) {
            return null;
        }

        ChatMessage chatMessage = new ChatMessage();

        chatMessage.setPageNo( chatMessageDTO.getPageNo() );
        chatMessage.setPageSize( chatMessageDTO.getPageSize() );
        chatMessage.setCreatedBy( chatMessageDTO.getCreatedBy() );
        chatMessage.setCreatedTime( chatMessageDTO.getCreatedTime() );
        chatMessage.setUpdateBy( chatMessageDTO.getUpdateBy() );
        chatMessage.setUpdateTime( chatMessageDTO.getUpdateTime() );
        chatMessage.setIsDeleted( chatMessageDTO.getIsDeleted() );
        chatMessage.setId( chatMessageDTO.getId() );
        chatMessage.setSessionId( chatMessageDTO.getSessionId() );
        chatMessage.setSenderId( chatMessageDTO.getSenderId() );
        chatMessage.setMessageType( chatMessageDTO.getMessageType() );
        chatMessage.setContent( chatMessageDTO.getContent() );
        chatMessage.setMediaUrl( chatMessageDTO.getMediaUrl() );
        chatMessage.setMediaSize( chatMessageDTO.getMediaSize() );
        chatMessage.setMediaDuration( chatMessageDTO.getMediaDuration() );
        chatMessage.setThumbnail( chatMessageDTO.getThumbnail() );
        chatMessage.setLatitude( chatMessageDTO.getLatitude() );
        chatMessage.setLongitude( chatMessageDTO.getLongitude() );
        chatMessage.setAddress( chatMessageDTO.getAddress() );
        chatMessage.setReferenceId( chatMessageDTO.getReferenceId() );

        return chatMessage;
    }
}
