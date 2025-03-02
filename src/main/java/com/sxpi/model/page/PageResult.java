package com.sxpi.model.page;

import java.util.Collections;
import java.util.List;

/**
 * @Author: codermzy
 * @Date: 2024/03/12/15:58
 * @Description:
 */
public class PageResult<T> {

    private Integer pageNo;

    private Integer pageSize;
    private List<T> result = Collections.emptyList();

    private Integer total = 0;
    private Integer totalPages = 0;

    private Integer start = 0;
    private Integer end = 0;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;

        if (result != null && !result.isEmpty()) {
            setTotal(result.size());
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;

        if (pageSize > 0) {
            totalPages = (total / pageSize) + ((total % pageSize) == 0 ? 0 : 1);
        } else {
            totalPages = 0;
        }

        this.start = (pageNo > 0 ? (pageNo - 1) * pageSize : 0) + 1;
        this.end = (start - 1 + pageSize * (pageNo > 0 ? 1 : 0));
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
