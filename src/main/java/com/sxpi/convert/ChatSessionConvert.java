package com.sxpi.convert;

import com.sxpi.model.dto.ChatSessionDTO;
import com.sxpi.model.entity.ChatSession;
import com.sxpi.model.vo.ChatSessionVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ChatSession转换器
 */
@Mapper
public interface ChatSessionConvert {
    ChatSessionConvert INSTANCE = Mappers.getMapper(ChatSessionConvert.class);

    List<ChatSessionVO> convertEntityToVo(List<ChatSession> chatSessions);
    ChatSessionVO convertEntityToVo(ChatSession chatSession);
    ChatSession convertDtoToEntity(ChatSessionDTO chatSessionDTO);
} 