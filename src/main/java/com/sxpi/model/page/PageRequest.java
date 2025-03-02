package com.sxpi.model.page;

/**
 * @Author: codermzy
 * @Date: 2024/03/12/15:49
 * @Description: 分页信息
 */
public class PageRequest {

    private Integer start = 0;

    private Integer size = 10;


    public int getStart() {
        if (start == null || start < 0) {
            return 0;
        }
        return start;
    }

    public int getSize() {
        if (size == null || size < 1 || size >= Integer.MAX_VALUE) {
            return 10;
        }
        return size;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
