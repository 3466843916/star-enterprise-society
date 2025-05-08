package com.sxpi.convert;

import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.vo.ZUserRoleVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ZUserRoleConvertImpl implements ZUserRoleConvert {

    @Override
    public List<ZUserRoleVO> convertEntityToVo(List<ZUserRole> userRoles) {
        if ( userRoles == null ) {
            return null;
        }

        List<ZUserRoleVO> list = new ArrayList<ZUserRoleVO>( userRoles.size() );
        for ( ZUserRole zUserRole : userRoles ) {
            list.add( convertEntityToVo( zUserRole ) );
        }

        return list;
    }

    @Override
    public ZUserRoleVO convertEntityToVo(ZUserRole userRole) {
        if ( userRole == null ) {
            return null;
        }

        ZUserRoleVO zUserRoleVO = new ZUserRoleVO();

        zUserRoleVO.setPageNo( userRole.getPageNo() );
        zUserRoleVO.setPageSize( userRole.getPageSize() );
        zUserRoleVO.setCreatedBy( userRole.getCreatedBy() );
        zUserRoleVO.setCreatedTime( userRole.getCreatedTime() );
        zUserRoleVO.setUpdateBy( userRole.getUpdateBy() );
        zUserRoleVO.setUpdateTime( userRole.getUpdateTime() );
        zUserRoleVO.setIsDeleted( userRole.getIsDeleted() );
        zUserRoleVO.setUserId( userRole.getUserId() );
        zUserRoleVO.setRoleId( userRole.getRoleId() );

        return zUserRoleVO;
    }
}
