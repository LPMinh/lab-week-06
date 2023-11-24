package com.minh.labweek06;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LabWeek06Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek06Application.class, args);
    }
//    @Bean
//    CommandLineRunner createSampleProduct(PostCommentRepository postCommentRepository,
//                                          PostRepository postRepository,
//                                          UserRepository userRepository
//                                          ){
//        return args -> {
//            Faker faker=new Faker();
//
//
//            for(int i=0;i<200;i++){
//                User user=new User(i+1L,faker.phoneNumber().cellPhone(),null,faker.name().lastName(),"i am student","21 yo", Instant.now(),"123456",faker.name().nameWithMiddle(),faker.name().firstName(),faker.internet().emailAddress(),faker.avatar().image());
//                userRepository.save(user);
//
//
//            }
//        };
//    }

}
