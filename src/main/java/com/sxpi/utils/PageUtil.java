package com.sxpi.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.page.PageInfo;
import com.sxpi.model.page.PageResult;

import java.util.List;

/**
 * @author happy
 * @create 2025-01-15-{TIME}
 */
public class PageUtil {
    /**
     * 构造分页结果
     *
     * @param pageInfo 当前页码
     * @param resultList 当前页数据
     * @param total 总记录数
     * @param <T> 泛型类型
     * @return 分页结果
     */
    public static <T> PageResult<T> createPageResult(PageInfo pageInfo, List<T> resultList, long total) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNo(pageInfo.getPageNo());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setResult(resultList);
        pageResult.setTotal((int) total);
        return pageResult;
    }

    public static <T> PageResult<T> createPageResult(Page pageInfo, List<T> resultList, long total) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNo((int) pageInfo.getCurrent());
        pageResult.setPageSize((int) pageInfo.getSize());
        pageResult.setResult(resultList);
        pageResult.setTotal((int) total);
        return pageResult;
    }

    /**
     * 构造分页结果
     *
     * @param pageNo 当前页码
     * @param pageSize 每页记录条数
     * @param resultList 当前页数据
     * @param total 总记录数
     * @param <T> 泛型类型
     * @return 分页结果
     */
    public static <T> PageResult<T> createPageResult(Integer pageNo, Integer pageSize, List<T> resultList, long total) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setResult(resultList);
        pageResult.setTotal((int) total);
        return pageResult;
    }
}
