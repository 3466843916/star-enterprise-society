package com.sxpi.convert;

import com.sxpi.model.dto.CommentDTO;
import com.sxpi.model.entity.Comment;
import com.sxpi.model.vo.CommentVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class CommentConvertImpl implements CommentConvert {

    @Override
    public List<CommentVO> convertEntityToVo(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentVO> list = new ArrayList<CommentVO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( convertEntityToVo( comment ) );
        }

        return list;
    }

    @Override
    public CommentVO convertEntityToVo(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentVO commentVO = new CommentVO();

        commentVO.setPageNo( comment.getPageNo() );
        commentVO.setPageSize( comment.getPageSize() );
        commentVO.setCreatedBy( comment.getCreatedBy() );
        commentVO.setCreatedTime( comment.getCreatedTime() );
        commentVO.setUpdateBy( comment.getUpdateBy() );
        commentVO.setUpdateTime( comment.getUpdateTime() );
        commentVO.setIsDeleted( comment.getIsDeleted() );
        commentVO.setId( comment.getId() );
        commentVO.setTargetType( comment.getTargetType() );
        commentVO.setTargetId( comment.getTargetId() );
        commentVO.setUserId( comment.getUserId() );
        commentVO.setParentId( comment.getParentId() );
        commentVO.setRootId( comment.getRootId() );
        commentVO.setContent( comment.getContent() );
        commentVO.setImageUrls( comment.getImageUrls() );
        commentVO.setLikeCount( comment.getLikeCount() );
        commentVO.setReplyCount( comment.getReplyCount() );
        commentVO.setIsAnonymous( comment.getIsAnonymous() );
        commentVO.setStatus( comment.getStatus() );

        return commentVO;
    }

    @Override
    public Comment convertDtoToEntity(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setPageNo( commentDTO.getPageNo() );
        comment.setPageSize( commentDTO.getPageSize() );
        comment.setCreatedBy( commentDTO.getCreatedBy() );
        comment.setCreatedTime( commentDTO.getCreatedTime() );
        comment.setUpdateBy( commentDTO.getUpdateBy() );
        comment.setUpdateTime( commentDTO.getUpdateTime() );
        comment.setIsDeleted( commentDTO.getIsDeleted() );
        comment.setId( commentDTO.getId() );
        comment.setTargetType( commentDTO.getTargetType() );
        comment.setTargetId( commentDTO.getTargetId() );
        comment.setUserId( commentDTO.getUserId() );
        comment.setParentId( commentDTO.getParentId() );
        comment.setRootId( commentDTO.getRootId() );
        comment.setContent( commentDTO.getContent() );
        comment.setImageUrls( commentDTO.getImageUrls() );
        comment.setLikeCount( commentDTO.getLikeCount() );
        comment.setReplyCount( commentDTO.getReplyCount() );
        comment.setIsAnonymous( commentDTO.getIsAnonymous() );
        comment.setStatus( commentDTO.getStatus() );

        return comment;
    }
}
