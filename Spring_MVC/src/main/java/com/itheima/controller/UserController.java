package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile)throws IOException {
        System.out.println(username);
        for(MultipartFile multipartFile :uploadFile){
            String orginalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\upload"+orginalFilename));
        }

    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile)throws IOException {
        System.out.println(username);
       String orginalFilename = uploadFile.getOriginalFilename();
       uploadFile.transferTo(new File("C:\\upload"+orginalFilename));
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSION") String jsessionID)throws IOException {
        System.out.println(jsessionID);
    }


    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent") String user_agent)throws IOException {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date)throws IOException {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value="username") String username)throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value="name",required = false, defaultValue = "itcast") String username  )throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList)throws IOException {
        System.out.println(userList);
    }//集合类型参数2

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo)throws IOException {
        System.out.println(vo);
    }//集合类型参数1

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs)throws IOException {
        System.out.println(Arrays.asList(strs));
    }//数组类型参数

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user)throws IOException {
        System.out.println(user);
    }//POJO类型参数

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age)throws IOException {
        System.out.println(username);
        System.out.println(age);
    }//基本类型参数

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10()throws IOException {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(32);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9()throws IOException {
        User user = new User();
        user.setUsername("lisi");
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
