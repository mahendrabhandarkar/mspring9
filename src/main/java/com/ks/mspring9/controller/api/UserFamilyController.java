package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserFamilyDTO;
import com.ks.mspring9.service.UserFamilyService;
import com.ks.mspring9.vo.UserFamilyQueryVO;
import com.ks.mspring9.vo.UserFamilyUpdateVO;
import com.ks.mspring9.vo.UserFamilyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userFamily")
public class UserFamilyController {

    @Autowired
    private UserFamilyService userFamilyService;

    @PostMapping
    public String save(@Valid @RequestBody UserFamilyVO vO) {
        return userFamilyService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userFamilyService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserFamilyUpdateVO vO) {
        userFamilyService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserFamilyDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userFamilyService.getById(id);
    }

    @GetMapping
    public Page<UserFamilyDTO> query(@Valid UserFamilyQueryVO vO) {
        return userFamilyService.query(vO);
    }
}
