package com.ycu.status;

public enum systemStatus
{
    SUCCESS(20000,"操作成功"),
    SELECT_SUCCESS(20000,"查询成功"),
    INSERT_SUCCESS(20000,"新增成功"),
    UPDATE_SUCCESS(20000,"修改成功"),
    DELETE_SUCCESS(20000,"删除成功"),
    UPDATE_ROOT_SUCCESS(20000,"修改权限成功"),
    UPDATE_TASK_STATUS_SUCCESS(20000,"修改任务状态成功"),
    SELECT_BY_ID_FAIL(-1,"抱歉，请选择正确你所查询的项目"),
    FAIL(-1,"操作失败");

    private Integer code;
    private String message;

    systemStatus(Integer code, String message) {
        this.code = code;
        this.message = message;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
