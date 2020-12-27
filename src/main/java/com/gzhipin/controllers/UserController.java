package com.gzhipin.controllers;

import com.gzhipin.beans.Skills;
import com.gzhipin.beans.User;
import com.gzhipin.services.SkillsService;
import com.gzhipin.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SkillsService skillsService;

    public UserController(UserService userService, SkillsService skillsService) {
        this.userService = userService;
        this.skillsService = skillsService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<User> getAll() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody @Valid User user) {
        this.userService.createUser(user);
//        User u = new User();
//        u.setUsername(map.get("username").toString());
//        u.setPassword(map.get("password").toString());
//        if(map.get("type") != null){
//            u.setType(Integer.parseInt(map.get("type").toString()));
//        }
//        else{
//            u.setType(1);
//        }
//        int skills_id = Integer.parseInt(map.get("skills_id").toString());
//        Optional<Skills> skills = this.skillsService.getSkillsById(skills_id);
//        if (skills.isPresent()){
//            u.setSkills(skills.get());
////        System.out.println(user);
//            this.userService.createUser(u);
//        }
    }
}
