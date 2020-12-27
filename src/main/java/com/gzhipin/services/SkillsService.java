package com.gzhipin.services;

import com.gzhipin.beans.Skills;
import com.gzhipin.repository.SkillsRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public List<Skills> getAllSkills(){
        return this.skillsRepository.findAll();
    }

    public void createSkill(Skills skills){
        this.skillsRepository.save(skills);
    }

    public Optional<Skills> getSkillsById(@NonNull Integer id) {
        Assert.notNull(id, "id can not be null");
        return this.skillsRepository.findById(id);
    }

}
