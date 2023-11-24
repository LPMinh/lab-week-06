package com.minh.labweek06.Controller;

import com.minh.labweek06.Repository.PostCommentRepository;
import com.minh.labweek06.Repository.PostRepository;
import com.minh.labweek06.model.Post;
import com.minh.labweek06.model.PostComment;
import com.minh.labweek06.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostCommentRepository postCommentRepository;
    @GetMapping(value = "/post/{id}")
    public String displayPost(Model model,@PathVariable(name = "id") Long id,HttpSession httpSession){
        System.out.println("id: "+id);
        Post post=postRepository.findById(id).get();

        System.out.println(post.getAuthor().getFirstName());
        if(post==null){
            post=new Post();
        }
        model.addAttribute("post",post);
        User user=(User) httpSession.getAttribute("user");
        List<PostComment> postComments= postCommentRepository.findAllByPostIdAndParentNull(id);
        model.addAttribute("postComments",postComments);
        model.addAttribute("user",user);
        System.out.println(user.getId());
        System.out.println(post.getAuthor().getId());
        return "detail-post :: modalContent";
    }
    @GetMapping(value = "/post/{id}/{page}")
    public String displayPost(Model model,@PathVariable(name = "id") Long id,@PathVariable(name = "page") int page,HttpSession httpSession){
        System.out.println("id: "+id);
        Post post=postRepository.findById(id).get();

        System.out.println(post.getAuthor().getFirstName());
        if(post==null){
            post=new Post();
        }
        model.addAttribute("post",post);
        User user=(User) httpSession.getAttribute("user");
        List<PostComment> postComments= postCommentRepository.findAllByPostIdAndParentNull(id);
        model.addAttribute("postComments",postComments);
        model.addAttribute("user",user);

        httpSession.setAttribute("page",page);
        return "detail-post :: modalContent";
    }
    @PostMapping(value = "/post")
    public String addPost(@RequestParam("postTitle") String title,@RequestParam("postContent") String conntent,@RequestParam("postImage") String image,@RequestParam("postMode") String published, Model model, HttpSession httpSession){
       User user=(User) httpSession.getAttribute("user");
         if(user==null) {
             return "redirect:/login";
         }else{
             boolean isPublished=true;
             if(published.equals("private")){
                 isPublished=false;
             }
             Post post=new Post(isPublished,conntent,null,null,null, Instant.now(),title,user,Instant.now(),Instant.now(),image);
             postRepository.save(post);
             return "redirect:/profile/"+user.getId();
         }
    }
    @PostMapping(value = "/post/{id}")
    public String editPost(@PathVariable("id") long id,@RequestParam("postTitle") String title,@RequestParam("postContent") String conntent,@RequestParam("postImage") String image,@RequestParam("postMode") String published, Model model, HttpSession httpSession){
        User user=(User) httpSession.getAttribute("user");
        Post post=postRepository.findById(id).get();
        if(post.getAuthor().getId()!=user.getId()){
            return "redirect:/profile/"+user.getId();
        } else if (post == null) {
            return "redirect:/profile/"+user.getId();
        }else{
            if(user==null) {
                return "redirect:/login";
            }else{
                boolean isPublished=true;
                if(published.equals("private")){
                    isPublished=false;
                }
                post.setPublished(isPublished);
                post.setTitle(title);
                post.setContent(conntent);
                post.setImage(image);
                post.setUpdatedAt(Instant.now());
                postRepository.save(post);
                return "redirect:/profile/"+user.getId();
            }
        }
    }
    @GetMapping(value = "/update-post/{id}")
    public String displayUpdatePost(Model model,@PathVariable(name = "id") long id,HttpSession httpSession){

        Post post=postRepository.findById(id).get();


        if(post==null){
            post=new Post();
        }
        model.addAttribute("post",post);
        User user=(User) httpSession.getAttribute("user");
        List<PostComment> postComments= postCommentRepository.findAllByPostIdAndParentNull(id);
        model.addAttribute("postComments",postComments);
        model.addAttribute("user",user);
        return "edit-post :: modaledit";
    }
    @GetMapping(value = "/delete-post/{id}")
    public String updatePost(@PathVariable long id,HttpSession httpSession){
        User user=(User) httpSession.getAttribute("user");
        Post post=postRepository.findById(id).get();
        if(post.getAuthor().getId()!=user.getId()){
            return "redirect:/profile/"+user.getId();
        } else if (post == null) {
            return "redirect:/profile/"+user.getId();
        }else{
            post.setPublished(false);
            postRepository.save(post);
            return "redirect:/profile/"+user.getId();
        }
    }


}
