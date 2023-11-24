package com.minh.labweek06.Controller;

import com.minh.labweek06.Repository.UserRepository;
import com.minh.labweek06.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userReposity;
    @GetMapping(value = {"/login","/",""})
    public String index() {
        return "login";
    }
    @GetMapping(value = {"/authenticcation"})
       public String authentication(@RequestParam (name = "email") String username,
                                    @RequestParam (name = "password") String password, HttpSession session, Model model){
            User user= userReposity.findByEmailAndPasswordHash(username,password);
            if(user!=null){
                session.setAttribute("user",user);
                return "redirect:/paging";
            }else{
                System.out.println("Login fail");
                model.addAttribute("message","Invalid username or password");
                return "login";
            }


     }

}
