package com.sxpi.convert;

import com.sxpi.model.dto.ZRoleDTO;
import com.sxpi.model.entity.ZRole;
import com.sxpi.model.vo.ZRoleVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ZRoleConvertImpl implements ZRoleConvert {

    @Override
    public ZRole convertDtoToEntity(ZRoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        ZRole zRole = new ZRole();

        zRole.setPageNo( roleDTO.getPageNo() );
        zRole.setPageSize( roleDTO.getPageSize() );
        zRole.setCreatedBy( roleDTO.getCreatedBy() );
        zRole.setCreatedTime( roleDTO.getCreatedTime() );
        zRole.setUpdateBy( roleDTO.getUpdateBy() );
        zRole.setUpdateTime( roleDTO.getUpdateTime() );
        zRole.setIsDeleted( roleDTO.getIsDeleted() );
        zRole.setId( roleDTO.getId() );
        zRole.setName( roleDTO.getName() );
        zRole.setRoleKey( roleDTO.getRoleKey() );
        zRole.setStatus( roleDTO.getStatus() );

        return zRole;
    }

    @Override
    public List<ZRoleVO> convertEntityToVo(List<ZRole> roleList) {
        if ( roleList == null ) {
            return null;
        }

        List<ZRoleVO> list = new ArrayList<ZRoleVO>( roleList.size() );
        for ( ZRole zRole : roleList ) {
            list.add( convertEntityToVo( zRole ) );
        }

        return list;
    }

    @Override
    public ZRoleVO convertEntityToVo(ZRole roleList) {
        if ( roleList == null ) {
            return null;
        }

        ZRoleVO zRoleVO = new ZRoleVO();

        zRoleVO.setId( roleList.getId() );
        zRoleVO.setName( roleList.getName() );
        zRoleVO.setRoleKey( roleList.getRoleKey() );
        zRoleVO.setStatus( roleList.getStatus() );

        return zRoleVO;
    }
}
