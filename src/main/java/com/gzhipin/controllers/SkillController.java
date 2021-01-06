package com.gzhipin.controllers;

import com.gzhipin.beans.Skills;
import com.gzhipin.httpUtils.CommonReturnType;
import com.gzhipin.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api1/skills")
public class SkillController {

    private final SkillsService skillsService;

    public SkillController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CommonReturnType create(@RequestBody @Valid Skills skills) {
        try{
            this.skillsService.createSkill(skills);
            return CommonReturnType.create(201, "创建skills成功！");
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("msg", e.getMessage());
            return CommonReturnType.create(400, map);
        }
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CommonReturnType getAll() {
        try{
            List<Skills> skills = this.skillsService.getAllSkills();
            return CommonReturnType.create(200, skills);
        }catch (Exception e){
            return CommonReturnType.create(400, e.getMessage());
        }
    }

}
