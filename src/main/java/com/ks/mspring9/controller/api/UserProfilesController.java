package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserProfilesDTO;
import com.ks.mspring9.service.UserProfilesService;
import com.ks.mspring9.vo.UserProfilesQueryVO;
import com.ks.mspring9.vo.UserProfilesUpdateVO;
import com.ks.mspring9.vo.UserProfilesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userProfiles")
public class UserProfilesController {

    @Autowired
    private UserProfilesService userProfilesService;

    @PostMapping
    public String save(@Valid @RequestBody UserProfilesVO vO) {
        return userProfilesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userProfilesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserProfilesUpdateVO vO) {
        userProfilesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserProfilesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userProfilesService.getById(id);
    }

    @GetMapping
    public Page<UserProfilesDTO> query(@Valid UserProfilesQueryVO vO) {
        return userProfilesService.query(vO);
    }
}
