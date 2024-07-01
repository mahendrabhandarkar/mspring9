package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserEduDTO;
import com.ks.mspring9.service.UserEduService;
import com.ks.mspring9.vo.UserEduQueryVO;
import com.ks.mspring9.vo.UserEduUpdateVO;
import com.ks.mspring9.vo.UserEduVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userEdu")
public class UserEduController {

    @Autowired
    private UserEduService userEduService;

    @PostMapping
    public String save(@Valid @RequestBody UserEduVO vO) {
        return userEduService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userEduService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserEduUpdateVO vO) {
        userEduService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserEduDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userEduService.getById(id);
    }

    @GetMapping
    public Page<UserEduDTO> query(@Valid UserEduQueryVO vO) {
        return userEduService.query(vO);
    }
}
