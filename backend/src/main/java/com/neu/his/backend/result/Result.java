package com.neu.his.backend.result;

/**
 * @Desciption 响应码枚举，参考 HTTP状态码的语义
 */
public class Result {

  // 响应状态码
  private int code;
  //响应提示信息
  private String message;
  //响应结果对象
  private Object data;

  Result(int code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}