package com.minh.labweek06.Controller;

import com.minh.labweek06.Repository.PostRepository;
import com.minh.labweek06.model.Post;
import com.minh.labweek06.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller()
public class HomeController {
    @Autowired
    private PostRepository postRepository;
    @GetMapping("/paging")
    public String displayPageHome(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, HttpSession httpSession){
        User user=(User) httpSession.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        model.addAttribute("user",user);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> postPage= postRepository.findAllByPublishedTrue(PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("postPage",postPage);
        int totalPages=postPage.getTotalPages();
        if(totalPages>0){
            int start=Math.max(1,currentPage-2);
            int end=Math.min(currentPage+2,totalPages);
            if(totalPages>5){
                if(end==totalPages){
                    start=end-5;
                }else if(start==1){
                    end=start+5;
                }
            }
            model.addAttribute("start",start);
            model.addAttribute("end",end);
        }
        return "home";
    }
    @GetMapping("/paging/filter")
    public String displayPageHome(Model model, @RequestParam("query") String query, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, HttpSession httpSession){
        User user=(User) httpSession.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }

        model.addAttribute("user",user);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> postPage= postRepository.findByContentContainingAndPublishedIsTrue(query,PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("postPage",postPage);

        int totalPages=postPage.getTotalPages();

        if(totalPages>0){
            int start=Math.max(1,currentPage-2);
            int end=Math.min(currentPage+2,totalPages);
            if(totalPages>5){
                if(end==totalPages){
                    start=end-5;
                }else if(start==1){
                    end=start+5;
                }
            }
            model.addAttribute("start",start);
            model.addAttribute("end",end);
        }

        return "home";
    }
}
