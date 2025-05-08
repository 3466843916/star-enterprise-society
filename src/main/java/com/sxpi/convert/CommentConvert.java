package com.sxpi.convert;

import com.sxpi.model.dto.CommentDTO;
import com.sxpi.model.entity.Comment;
import com.sxpi.model.vo.CommentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Comment转换器
 */
@Mapper
public interface CommentConvert {
    CommentConvert INSTANCE = Mappers.getMapper(CommentConvert.class);

    List<CommentVO> convertEntityToVo(List<Comment> comments);
    CommentVO convertEntityToVo(Comment comment);
    Comment convertDtoToEntity(CommentDTO commentDTO);
} 