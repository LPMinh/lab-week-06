//package com.minh.labweek06.RestController;
//
//import com.minh.labweek06.Repository.PostRepository;
//import com.minh.labweek06.model.Post;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//public class PostController {
//    @Autowired
//    private PostRepository postRepository;
//    @PostMapping
//    public ResponseEntity<?> addPost(@RequestBody Post post){
//        if(postRepository.save(post)!=null){
//            return ResponseEntity.ok(post);
//        }else{
//            return ResponseEntity.badRequest().body("something went wrong");
//        }
//    }
//    @GetMapping
//    public ResponseEntity<?> getAllPost(){
//        List<Post> post=postRepository.findAll();
//        if(post!=null){
//            return ResponseEntity.ok(post);
//        }else{
//            return ResponseEntity.badRequest().body("not found");
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<?> updatePost(@RequestBody Post post){
//        if(postRepository.existsById(post.getId())){
//            return ResponseEntity.ok().body(postRepository.save(post));
//        }else{
//            return ResponseEntity.badRequest().body("not found post to updated");
//        }
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletePostByID(@PathVariable Long id){
//        try{
//            postRepository.deleteById(id);
//            return ResponseEntity.ok().body("Da xoa post ID: "+ id);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findPostByID(@PathVariable Long id){
//        try{
//            Post post=postRepository.findById(id).orElseThrow();
//            return ResponseEntity.ok().body(post);
//        }catch ( Exception e){
//            return ResponseEntity.badRequest().body("khong tim thay");
//        }
//    }
//}
