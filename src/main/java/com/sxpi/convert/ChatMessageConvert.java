package com.sxpi.convert;

import com.sxpi.model.dto.ChatMessageDTO;
import com.sxpi.model.entity.ChatMessage;
import com.sxpi.model.vo.ChatMessageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ChatMessage转换器
 */
@Mapper
public interface ChatMessageConvert {
    ChatMessageConvert INSTANCE = Mappers.getMapper(ChatMessageConvert.class);

    List<ChatMessageVO> convertEntityToVo(List<ChatMessage> chatMessages);
    ChatMessageVO convertEntityToVo(ChatMessage chatMessage);
    ChatMessage convertDtoToEntity(ChatMessageDTO chatMessageDTO);
} 