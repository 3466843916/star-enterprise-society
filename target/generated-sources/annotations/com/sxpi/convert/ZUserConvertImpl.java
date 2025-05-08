package com.sxpi.convert;

import com.sxpi.model.dto.ZUserDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.vo.ZUserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ZUserConvertImpl implements ZUserConvert {

    @Override
    public List<ZUserVO> convertEntityToVo(List<ZUser> userList) {
        if ( userList == null ) {
            return null;
        }

        List<ZUserVO> list = new ArrayList<ZUserVO>( userList.size() );
        for ( ZUser zUser : userList ) {
            list.add( convertEntityToVo( zUser ) );
        }

        return list;
    }

    @Override
    public ZUserVO convertEntityToVo(ZUser user) {
        if ( user == null ) {
            return null;
        }

        ZUserVO zUserVO = new ZUserVO();

        zUserVO.setId( user.getId() );
        zUserVO.setUsername( user.getUsername() );
        zUserVO.setPhone( user.getPhone() );
        zUserVO.setGender( user.getGender() );
        zUserVO.setAvatar( user.getAvatar() );

        return zUserVO;
    }

    @Override
    public ZUser convertDtoToEntity(ZUserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        ZUser zUser = new ZUser();

        zUser.setId( userDTO.getId() );
        zUser.setUsername( userDTO.getUsername() );
        zUser.setPassword( userDTO.getPassword() );
        zUser.setPhone( userDTO.getPhone() );
        zUser.setGender( userDTO.getGender() );
        zUser.setAvatar( userDTO.getAvatar() );

        return zUser;
    }

    @Override
    public ZUserVO convertDtoToVo(ZUserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        ZUserVO zUserVO = new ZUserVO();

        zUserVO.setId( userDTO.getId() );
        zUserVO.setUsername( userDTO.getUsername() );
        zUserVO.setPhone( userDTO.getPhone() );
        zUserVO.setGender( userDTO.getGender() );
        zUserVO.setAvatar( userDTO.getAvatar() );

        return zUserVO;
    }

    @Override
    public ZUser convertVoToEntity(ZUserVO userVO) {
        if ( userVO == null ) {
            return null;
        }

        ZUser zUser = new ZUser();

        zUser.setId( userVO.getId() );
        zUser.setUsername( userVO.getUsername() );
        zUser.setPhone( userVO.getPhone() );
        zUser.setGender( userVO.getGender() );
        zUser.setAvatar( userVO.getAvatar() );

        return zUser;
    }
}
