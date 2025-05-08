package com.sxpi.convert;

import com.sxpi.model.dto.ChatSessionDTO;
import com.sxpi.model.entity.ChatSession;
import com.sxpi.model.vo.ChatSessionVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ChatSessionConvertImpl implements ChatSessionConvert {

    @Override
    public List<ChatSessionVO> convertEntityToVo(List<ChatSession> chatSessions) {
        if ( chatSessions == null ) {
            return null;
        }

        List<ChatSessionVO> list = new ArrayList<ChatSessionVO>( chatSessions.size() );
        for ( ChatSession chatSession : chatSessions ) {
            list.add( convertEntityToVo( chatSession ) );
        }

        return list;
    }

    @Override
    public ChatSessionVO convertEntityToVo(ChatSession chatSession) {
        if ( chatSession == null ) {
            return null;
        }

        ChatSessionVO chatSessionVO = new ChatSessionVO();

        chatSessionVO.setPageNo( chatSession.getPageNo() );
        chatSessionVO.setPageSize( chatSession.getPageSize() );
        chatSessionVO.setCreatedBy( chatSession.getCreatedBy() );
        chatSessionVO.setCreatedTime( chatSession.getCreatedTime() );
        chatSessionVO.setUpdateBy( chatSession.getUpdateBy() );
        chatSessionVO.setUpdateTime( chatSession.getUpdateTime() );
        chatSessionVO.setIsDeleted( chatSession.getIsDeleted() );
        chatSessionVO.setId( chatSession.getId() );
        chatSessionVO.setSessionType( chatSession.getSessionType() );
        chatSessionVO.setName( chatSession.getName() );
        chatSessionVO.setAvatar( chatSession.getAvatar() );
        chatSessionVO.setOwnerId( chatSession.getOwnerId() );
        chatSessionVO.setLastMessage( chatSession.getLastMessage() );
        chatSessionVO.setLastMessageTime( chatSession.getLastMessageTime() );
        chatSessionVO.setMemberCount( chatSession.getMemberCount() );
        chatSessionVO.setCommunityId( chatSession.getCommunityId() );

        return chatSessionVO;
    }

    @Override
    public ChatSession convertDtoToEntity(ChatSessionDTO chatSessionDTO) {
        if ( chatSessionDTO == null ) {
            return null;
        }

        ChatSession chatSession = new ChatSession();

        chatSession.setPageNo( chatSessionDTO.getPageNo() );
        chatSession.setPageSize( chatSessionDTO.getPageSize() );
        chatSession.setCreatedBy( chatSessionDTO.getCreatedBy() );
        chatSession.setCreatedTime( chatSessionDTO.getCreatedTime() );
        chatSession.setUpdateBy( chatSessionDTO.getUpdateBy() );
        chatSession.setUpdateTime( chatSessionDTO.getUpdateTime() );
        chatSession.setIsDeleted( chatSessionDTO.getIsDeleted() );
        chatSession.setId( chatSessionDTO.getId() );
        chatSession.setSessionType( chatSessionDTO.getSessionType() );
        chatSession.setName( chatSessionDTO.getName() );
        chatSession.setAvatar( chatSessionDTO.getAvatar() );
        chatSession.setOwnerId( chatSessionDTO.getOwnerId() );
        chatSession.setLastMessage( chatSessionDTO.getLastMessage() );
        chatSession.setLastMessageTime( chatSessionDTO.getLastMessageTime() );
        chatSession.setMemberCount( chatSessionDTO.getMemberCount() );
        chatSession.setCommunityId( chatSessionDTO.getCommunityId() );

        return chatSession;
    }
}
