package com.sxpi.model.page;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @Author: codermzy
 * @Date: 2024/03/12/15:49
 * @Description: 分页信息
 */
public class PageInfo {
    @TableField(exist = false)
    private Integer pageNo = 1;

    @TableField(exist = false)
    private Integer pageSize = 10;


    public int getPageNo() {
        if (pageNo == null || pageNo < 0) {
            return 0;
        }
        return pageNo;
    }

    public int getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize >= Integer.MAX_VALUE) {
            return 10;
        }
        return pageSize;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
