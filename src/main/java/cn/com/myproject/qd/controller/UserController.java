package cn.com.myproject.qd.controller;


import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/lluser")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public String user(Integer type ,HttpServletRequest request) {
        request.setAttribute("users",userService.getAll(type));
        return "/user/all";
    }

    @ResponseBody
    @RequestMapping("/add8")
    public String add(User user) {
        int i = userService.add(user);
        if(i==1) {
            return "成功";
        }
        return "失败";
    }

    @ResponseBody
    @RequestMapping("/update8")
    public String update(User user) {
        int i = userService.update(user);
        if(i==1) {
            return "成功";
        }
        return "失败";
    }

    @ResponseBody
    @RequestMapping("/delete8")
    public String delete(Integer id) {
        int i = userService.delete(id);
        if(i==1) {
            return "成功";
        }
        return "失败";
    }

}
