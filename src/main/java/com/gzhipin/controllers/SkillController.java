package com.gzhipin.controllers;

import com.gzhipin.beans.Skills;
import com.gzhipin.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillsService skillsService;

    public SkillController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody @Valid Skills skills) {
        this.skillsService.createSkill(skills);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Skills> getAll() {
        return this.skillsService.getAllSkills();
    }

}
