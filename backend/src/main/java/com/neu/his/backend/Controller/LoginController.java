package com.neu.his.backend.Controller;

import com.neu.his.backend.pojo.UserEntity;
import com.neu.his.backend.result.Result;
import com.neu.his.backend.result.ResultFactory;
import com.neu.his.backend.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  /**
   * 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。 给UserEntity对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
   * 在逻辑处理中我们判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
   */
  @CrossOrigin
  @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result login(@Valid @RequestBody UserEntity requestUser, BindingResult bindingResult) {
    String username = requestUser.getUsername();
    // 对 html 标签进行转义，防止 XSS 攻击
    username = HtmlUtils.htmlEscape(username);
    //获取对应username和password的user实体
    UserEntity user = userService.get(username, requestUser.getPassword());
    if (bindingResult.hasErrors()) {
      String message = String.format("登陆失败，详细信息[%s]。", Objects
          .requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
      return ResultFactory.buildFailResult(message);
    }
    //不存在对应的user实体
    if (null == user) {
      String message = "登陆失败，详细信息[用户名、密码信息不正确]。";
      return ResultFactory.buildFailResult(message);
    }
    return ResultFactory.buildSuccessResult(user);
  }
}