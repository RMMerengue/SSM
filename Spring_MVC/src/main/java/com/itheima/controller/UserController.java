package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10()throws IOException {
        User user = new User();
        user.setUserName("zhangsan");
        user.setAge(32);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9()throws IOException {
        User user = new User();
        user.setUserName("lisi");
        user.setAge(30);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8()throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7(HttpServletResponse response)throws IOException {
        return "hello save7";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response)throws IOException {
        response.getWriter().print("hello save6");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username", "save5");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username", "save4");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username", "save3");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username", "save2");

        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save(){
        System.out.println("Controller save running...");
        return "success";
    }
}
