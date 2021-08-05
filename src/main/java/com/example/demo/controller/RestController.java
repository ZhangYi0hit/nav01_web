package com.example.demo.controller;


import com.example.demo.model.Doctor;
import com.example.demo.model.Post;
import com.example.demo.service.postServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    postServiceImpl postService;

    Post post = new Post(1, "David", "2019-11-21", "headache", "Headache, dizziness, no significant visual, sensory, or motor deficits or irritation prior to onset",
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fjkcdn.pajk.com.cn%2Fimage%2FT19SDcBjLT1RyfOV6K.gif%3Fimg%3D%2Ftf%2Cd_jpg%2Cq_70%2Frs%2Cw_500&refer=http%3A%2F%2Fjkcdn.pajk.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628738373&t=789f0afcb29ab7d3842f4fe6e664d1f4");

    Post post1 = new Post(2, "Bennett", "2021-01-31", "stomachache", "Headache, dizziness, no significant visual, sensory, or motor deficits or irritation prior to onset",
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fjkcdn.pajk.com.cn%2Fimage%2FT19SDcBjLT1RyfOV6K.gif%3Fimg%3D%2Ftf%2Cd_jpg%2Cq_70%2Frs%2Cw_500&refer=http%3A%2F%2Fjkcdn.pajk.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628738373&t=789f0afcb29ab7d3842f4fe6e664d1f4");

    List<Post> postList = new ArrayList<Post>();


    Doctor doctor1 = new Doctor(1, "David", "Peking Union Medical College Hospital", "Dental Department");
    Doctor doctor2 = new Doctor(2, "Bennett", "University Health Centre (UHC)", "Internal Medicine-Neurology");
    List<Doctor> doctors = new ArrayList<Doctor>();


    @GetMapping("/post/list")
    public ResponseEntity<List<Post>> findAllPosts() {
        postList.add(post);
        postList.add(post1);

        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }

    @GetMapping("/doctor/list")
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        doctors.add(doctor1);
        doctors.add(doctor2);
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);


    }

    @RequestMapping(value = "/create/{userid}", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> createPost2(@PathVariable("userid") Integer userId,
                                            @RequestPart("post") String post) {

        //get the entity: post
        Post postJson = postService.getJson(post);
        //you can use the post


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
