package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // 保存用户（写操作）→ 接口名不变，不用改
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 查询用户（读操作）
    // 原来：/find/{id}
    // 现在：改成 /get/{id}  ← 只改这里！
    @GetMapping("/get/{id}")
    public User findUser(@PathVariable("id") Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElse(null);
    }
}