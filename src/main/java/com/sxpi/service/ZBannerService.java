package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZBannerDTO;
import com.sxpi.model.entity.ZBanner;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZBannerVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @author happy
 * @create 2024-01-03-{TIME}
 */
public interface ZBannerService extends IService<ZBanner> {
    PageResult<ZBannerVO> getList(ZBannerDTO zBannerDTO);

    Boolean updateBanner(ZBannerDTO zBannerDTO);

    Boolean addBanner(ZBannerDTO dto, MultipartFile imageFile);

    Result<String> del(List<Long> ids);
}
