package com.example.demo.controller;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Tang on 2020/8/18
 */
@Controller
public class HomeController {
    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        //初始登陆用户名密码long/longzhonghua,或者long/123456
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                msg = "验证码错误";
            } else {
                msg = "else >> " + exception;

            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }
    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }
}
