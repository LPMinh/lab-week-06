package com.minh.labweek06.Controller;

import com.minh.labweek06.Repository.PostRepository;
import com.minh.labweek06.Repository.UserRepository;
import com.minh.labweek06.model.Post;
import com.minh.labweek06.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @GetMapping("/profile/{id}")
    public String displayProfile(Model model, HttpSession httpSession, @PathVariable(name = "id") Long id){
        User user=userRepository.findById(id).orElseThrow();
        User userSession=(User) httpSession.getAttribute("user");
        if(userSession==null){
            return "redirect:/login";
        }else{
            List<Post> posts;
            if(userSession.getId()==user.getId()) {
                posts = postRepository.findAllByAuthorId(user.getId());
            }else{
                posts=postRepository.findAllGetAllByPublishedTrue();
            }
            if(posts!=null){
                model.addAttribute("posts",posts);
            }else{
                posts=new ArrayList<Post>();
            }
            model.addAttribute("user",user);
            model.addAttribute("posts",posts);
            return "profile";
        }

    }
}
