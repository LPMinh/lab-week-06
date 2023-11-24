//package com.minh.labweek06.RestController;
//
//import com.minh.labweek06.Repository.UserRepository;
//import com.minh.labweek06.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//    @PostMapping
//    public ResponseEntity<?> addUser(@RequestBody User user){
//        if(userRepository.save(user)!=null){
//            return ResponseEntity.ok(user);
//        }else{
//            return ResponseEntity.badRequest().body("something went wrong");
//        }
//    }
//    @GetMapping
//    public ResponseEntity<?> getAllUser(){
//        List<User> users=userRepository.findAll();
//        if(users!=null){
//            return ResponseEntity.ok(users);
//        }else{
//            return ResponseEntity.badRequest().body("not found");
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<?> updateUser(@RequestBody User user){
//        if(userRepository.existsById(user.getId())){
//            return ResponseEntity.ok().body(userRepository.save(user));
//        }else{
//            return ResponseEntity.badRequest().body("not found user to updated");
//        }
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUserByID(@PathVariable Long id){
//        try{
//             userRepository.deleteById(id);
//             return ResponseEntity.ok().body("Da xoa user ID: "+ id);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findUSerByID(@PathVariable Long id){
//        try{
//            User user=userRepository.findById(id).orElseThrow();
//            return ResponseEntity.ok().body(user);
//        }catch ( Exception e){
//            return ResponseEntity.badRequest().body("khong tim thay");
//        }
//    }
//
//
//}
