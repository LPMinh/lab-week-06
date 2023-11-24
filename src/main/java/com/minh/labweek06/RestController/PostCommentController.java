//package com.minh.labweek06.RestController;
//
//import com.minh.labweek06.Repository.PostCommentRepository;
//import com.minh.labweek06.model.PostComment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//public class PostCommentController {
//    @Autowired
//    private PostCommentRepository postCommentRepository;
//    @PostMapping
//    public ResponseEntity<?> addPostComment(@RequestBody PostComment comment){
//        if(postCommentRepository.save(comment)!=null){
//            return ResponseEntity.ok(comment);
//        }else{
//            return ResponseEntity.badRequest().body("something went wrong");
//        }
//    }
//    @GetMapping
//    public ResponseEntity<?> getAllPostComment(){
//        List<PostComment> comments=postCommentRepository.findAll();
//        if(postCommentRepository!=null){
//            return ResponseEntity.ok(postCommentRepository);
//        }else{
//            return ResponseEntity.badRequest().body("not found");
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<?> updatePostComment(@RequestBody PostComment post){
//        if(postCommentRepository.existsById(post.getId())){
//            return ResponseEntity.ok().body(postCommentRepository.save(post));
//        }else{
//            return ResponseEntity.badRequest().body("not found comment to updated");
//        }
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletePostCommentByID(@PathVariable Long id){
//        try{
//            postCommentRepository.deleteById(id);
//            return ResponseEntity.ok().body("Da xoa post ID: "+ id);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findPostCommentByID(@PathVariable Long id){
//        try{
//            PostComment post=postCommentRepository.findById(id).orElseThrow();
//            return ResponseEntity.ok().body(post);
//        }catch ( Exception e){
//            return ResponseEntity.badRequest().body("khong tim thay");
//        }
//    }
//}
