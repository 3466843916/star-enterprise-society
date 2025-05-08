package com.sxpi.convert;

import com.sxpi.model.dto.ZBannerDTO;
import com.sxpi.model.entity.ZBanner;
import com.sxpi.model.vo.ZBannerVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class ZBannerConvertImpl implements ZBannerConvert {

    @Override
    public List<ZBannerVO> convertEntityToVo(List<ZBanner> bannerList) {
        if ( bannerList == null ) {
            return null;
        }

        List<ZBannerVO> list = new ArrayList<ZBannerVO>( bannerList.size() );
        for ( ZBanner zBanner : bannerList ) {
            list.add( convertEntityToVo( zBanner ) );
        }

        return list;
    }

    @Override
    public ZBannerVO convertEntityToVo(ZBanner banner) {
        if ( banner == null ) {
            return null;
        }

        ZBannerVO zBannerVO = new ZBannerVO();

        zBannerVO.setId( banner.getId() );
        zBannerVO.setTitle( banner.getTitle() );
        zBannerVO.setImg( banner.getImg() );
        zBannerVO.setIsPrimary( banner.getIsPrimary() );
        zBannerVO.setSort( banner.getSort() );

        return zBannerVO;
    }

    @Override
    public ZBanner convertDtoToEntity(ZBannerDTO bannerDTO) {
        if ( bannerDTO == null ) {
            return null;
        }

        ZBanner zBanner = new ZBanner();

        zBanner.setPageNo( bannerDTO.getPageNo() );
        zBanner.setPageSize( bannerDTO.getPageSize() );
        zBanner.setCreatedBy( bannerDTO.getCreatedBy() );
        zBanner.setCreatedTime( bannerDTO.getCreatedTime() );
        zBanner.setUpdateBy( bannerDTO.getUpdateBy() );
        zBanner.setUpdateTime( bannerDTO.getUpdateTime() );
        zBanner.setIsDeleted( bannerDTO.getIsDeleted() );
        zBanner.setId( bannerDTO.getId() );
        zBanner.setTitle( bannerDTO.getTitle() );
        zBanner.setImg( bannerDTO.getImg() );
        zBanner.setIsPrimary( bannerDTO.getIsPrimary() );
        zBanner.setSort( bannerDTO.getSort() );

        return zBanner;
    }

    @Override
    public ZBannerVO convertDtoToVo(ZBannerDTO bannerDTO) {
        if ( bannerDTO == null ) {
            return null;
        }

        ZBannerVO zBannerVO = new ZBannerVO();

        zBannerVO.setId( bannerDTO.getId() );
        zBannerVO.setTitle( bannerDTO.getTitle() );
        zBannerVO.setImg( bannerDTO.getImg() );
        zBannerVO.setIsPrimary( bannerDTO.getIsPrimary() );
        zBannerVO.setSort( bannerDTO.getSort() );

        return zBannerVO;
    }
}
