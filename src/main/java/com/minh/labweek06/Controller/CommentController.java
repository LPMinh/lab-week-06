package com.minh.labweek06.Controller;

import com.minh.labweek06.Repository.PostCommentRepository;
import com.minh.labweek06.Repository.PostRepository;
import com.minh.labweek06.Repository.UserRepository;
import com.minh.labweek06.model.Post;
import com.minh.labweek06.model.PostComment;
import com.minh.labweek06.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

@Controller
public class CommentController {
    @Autowired
    public PostCommentRepository postCommentRepository;
    @Autowired
    public PostRepository postRepository;
    @Autowired
    public UserRepository userRepository;
    @PostMapping(value = "/add-comment")
    public String addComment(@RequestParam("comment") String comment, @RequestParam("post_id") Long post_id, @RequestParam("user_id") Long user_id, HttpSession httpSession){
        User user=userRepository.findById(user_id).orElseThrow();
        Post post=postRepository.findById(post_id).orElseThrow();
        PostComment postComment=new PostComment(post,comment,new HashSet<PostComment>(),true,comment,null,user);
        postCommentRepository.save(postComment);
        Object page= httpSession.getAttribute("page");
        if(page!=null){
            page=(int)page;
            httpSession.removeAttribute("page");
            return "redirect:/paging?page="+page+"&size=5";
        }else{
            return "redirect:/profile/"+user_id;
        }

    }

    @PostMapping(value="/add-reply")
    public String addReply(@RequestParam("reply") String reply,@RequestParam("comment_id") Long comment_id,@RequestParam("user_id") Long user_id,HttpSession httpSession){
        User user=userRepository.findById(user_id).orElseThrow();
        PostComment postComment=postCommentRepository.findById(comment_id).orElseThrow();
        Post post=postComment.getPost();
        PostComment postComment1=new PostComment(post,null,new HashSet<PostComment>(),true,reply,postComment,user);
        postComment.getPostComments().add(postComment1);
        postCommentRepository.save(postComment);
        Object page= httpSession.getAttribute("page");
        if(page!=null){
            page=(int)page;
            httpSession.removeAttribute("page");
            return "redirect:/paging?page="+page+"&size=5";
        }else{
            return "redirect:/profile/"+user_id;
        }
        
    }
}
