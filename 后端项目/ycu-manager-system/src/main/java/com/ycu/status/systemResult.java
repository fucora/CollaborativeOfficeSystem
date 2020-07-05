package com.ycu.status;


import lombok.Data;

@Data
public class systemResult
{
    private Integer code;
    private String message;
    private Object  data;

    public systemResult(systemStatus status, Object data) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }

  public static systemResult insertSuccess(systemStatus status)
  {
      return new systemResult(status,null);
  }
    public static systemResult updateSuccess(systemStatus status)
    {
        return new systemResult(status,null);
    }
    public static systemResult deleteSuccess(systemStatus status)
    {
        return new systemResult(status,null);
    }
    public static systemResult querySuccess(systemStatus status,Object data)
    {
        return new systemResult(status,data);
    }

    public static systemResult failure(systemStatus status)
    {
        return new systemResult(status,null);
    }


}
