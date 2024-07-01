package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserHobbiesDTO;
import com.ks.mspring9.service.UserHobbiesService;
import com.ks.mspring9.vo.UserHobbiesQueryVO;
import com.ks.mspring9.vo.UserHobbiesUpdateVO;
import com.ks.mspring9.vo.UserHobbiesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userHobbies")
public class UserHobbiesController {

    @Autowired
    private UserHobbiesService userHobbiesService;

    @PostMapping
    public String save(@Valid @RequestBody UserHobbiesVO vO) {
        return userHobbiesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userHobbiesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserHobbiesUpdateVO vO) {
        userHobbiesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserHobbiesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userHobbiesService.getById(id);
    }

    @GetMapping
    public Page<UserHobbiesDTO> query(@Valid UserHobbiesQueryVO vO) {
        return userHobbiesService.query(vO);
    }
}
