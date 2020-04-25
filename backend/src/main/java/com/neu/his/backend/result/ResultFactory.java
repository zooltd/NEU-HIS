package com.neu.his.backend.result;

import java.util.Vector;

/**
 * @description 响应结果生成工厂类
 */
public class ResultFactory {

  public static Result buildSuccessResult(Object data) {
    return buidResult(ResultCode.SUCCESS, "成功", data);
  }

  public static Result buildFailResult(String message) {
    return buidResult(ResultCode.FAIL, message, null);
  }

  public static Result buidResult(ResultCode resultCode, String message, Object data) {
    return buidResult(resultCode.code, message, data);
  }

  public static Result buidResult(int resultCode, String message, Object data) {
    return new Result(resultCode, message, data);
  }

  public static Result buidResults(ResultCode resultCode, String message, Vector data) {
    return new Result(resultCode.code, message, data);
  }

}

