package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.DishesDTO;
import com.sxpi.model.entity.Dishes;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.DishesVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @author happy
 * @create 2025-03-10-{TIME}
 */
public interface DishesService extends IService<Dishes> {
    PageResult<DishesVO> pageList(DishesDTO dishesDTO);






    Boolean saveDishes(DishesDTO dishesDTO, List<MultipartFile> files);

}
