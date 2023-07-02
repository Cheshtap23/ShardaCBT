package com.example.testspringdata;

import com.example.testspringdata.Userdetail;
import com.example.testspringdata.UserdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0.1")
public class MainRestController {
@Autowired
    UserdetailRepository userdetailRepository;
    @GetMapping("getusertypes")
    public List<> getUserType(@RequestParam("username") String username);

}
