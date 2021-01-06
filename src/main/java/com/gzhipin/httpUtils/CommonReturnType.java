package com.gzhipin.httpUtils;

public class CommonReturnType {
    private int status;
    private Object data;

    public CommonReturnType() {
    }

    public CommonReturnType(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonReturnType create(int status, Object data){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(data);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }

    public static CommonReturnType create(Object data){
        return CommonReturnType.create(200, data);
    }
}
