package com.gzhipin.controllers;

import com.gzhipin.beans.User;
import com.gzhipin.httpUtils.CommonReturnType;
import com.gzhipin.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CommonReturnType getAll() {
        try{
            List<User> users = this.userService.getAllUsers();
            return CommonReturnType.create(users);
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("msg", e.getMessage());
            return CommonReturnType.create(400, map);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CommonReturnType create(@RequestBody @Valid User user) {
        try{
            this.userService.createUser(user);
            return CommonReturnType.create(201, "创建用户成功！");
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("msg", e.getMessage());
            return CommonReturnType.create(400, map);
        }
    }
}
