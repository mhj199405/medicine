package com.inso.entity.vo;

/**
 * 封装统一的分页对象
 */
public class PageResult {
    private Integer code;   //状态码
    private String msg;     //返回信息
    private long count;     //总条数
    private Object data;    //数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
