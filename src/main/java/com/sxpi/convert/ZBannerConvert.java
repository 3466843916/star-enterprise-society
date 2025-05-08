package com.sxpi.convert;


import com.sxpi.model.dto.ZBannerDTO;
import com.sxpi.model.entity.ZBanner;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.vo.ZBannerVO;
import com.sxpi.model.vo.ZUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Mapper
public interface ZBannerConvert {
    ZBannerConvert INSTANCE = Mappers.getMapper(ZBannerConvert.class);

    List<ZBannerVO> convertEntityToVo(List<ZBanner> bannerList);
    ZBannerVO convertEntityToVo(ZBanner banner);

    ZBanner convertDtoToEntity(ZBannerDTO bannerDTO);
    ZBannerVO convertDtoToVo(ZBannerDTO bannerDTO);
}
