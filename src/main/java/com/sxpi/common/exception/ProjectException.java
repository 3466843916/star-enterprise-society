package com.sxpi.common.exception;

import com.sxpi.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectException extends RuntimeException {

    // 异常状态码
    private Integer code;


    /**
     * 通过状态码和错误消息创建异常对象
     */
    public ProjectException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     */
    public ProjectException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ProjectException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
