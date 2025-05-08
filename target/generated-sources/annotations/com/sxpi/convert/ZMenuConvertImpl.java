package com.sxpi.convert;

import com.sxpi.model.dto.ZMenuDTO;
import com.sxpi.model.entity.ZMenu;
import com.sxpi.model.vo.ZMenuVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ZMenuConvertImpl implements ZMenuConvert {

    @Override
    public List<ZMenuVO> convertEntityToVo(List<ZMenu> menuList) {
        if ( menuList == null ) {
            return null;
        }

        List<ZMenuVO> list = new ArrayList<ZMenuVO>( menuList.size() );
        for ( ZMenu zMenu : menuList ) {
            list.add( zMenuToZMenuVO( zMenu ) );
        }

        return list;
    }

    @Override
    public ZMenu convertDtoToEntity(ZMenuDTO menuDTO) {
        if ( menuDTO == null ) {
            return null;
        }

        ZMenu zMenu = new ZMenu();

        zMenu.setPageNo( menuDTO.getPageNo() );
        zMenu.setPageSize( menuDTO.getPageSize() );
        zMenu.setCreatedBy( menuDTO.getCreatedBy() );
        zMenu.setCreatedTime( menuDTO.getCreatedTime() );
        zMenu.setUpdateBy( menuDTO.getUpdateBy() );
        zMenu.setUpdateTime( menuDTO.getUpdateTime() );
        zMenu.setIsDeleted( menuDTO.getIsDeleted() );
        zMenu.setId( menuDTO.getId() );
        zMenu.setMenuName( menuDTO.getMenuName() );
        zMenu.setPath( menuDTO.getPath() );
        zMenu.setComponent( menuDTO.getComponent() );
        zMenu.setStatus( menuDTO.getStatus() );
        zMenu.setPerms( menuDTO.getPerms() );

        return zMenu;
    }

    protected ZMenuVO zMenuToZMenuVO(ZMenu zMenu) {
        if ( zMenu == null ) {
            return null;
        }

        ZMenuVO zMenuVO = new ZMenuVO();

        zMenuVO.setId( zMenu.getId() );
        zMenuVO.setMenuName( zMenu.getMenuName() );
        zMenuVO.setPath( zMenu.getPath() );
        zMenuVO.setComponent( zMenu.getComponent() );
        zMenuVO.setStatus( zMenu.getStatus() );
        zMenuVO.setPerms( zMenu.getPerms() );

        return zMenuVO;
    }
}
