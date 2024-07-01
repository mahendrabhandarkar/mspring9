package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserBackgroundDTO;
import com.ks.mspring9.service.UserBackgroundService;
import com.ks.mspring9.vo.UserBackgroundQueryVO;
import com.ks.mspring9.vo.UserBackgroundUpdateVO;
import com.ks.mspring9.vo.UserBackgroundVO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/userBackground")
public class UserBackgroundController {

    @Autowired
    private UserBackgroundService userBackgroundService;

    @PostMapping
    public String save(@Valid @RequestBody UserBackgroundVO vO) {
        return userBackgroundService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userBackgroundService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserBackgroundUpdateVO vO) {
        userBackgroundService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserBackgroundDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userBackgroundService.getById(id);
    }

    @GetMapping
    public Page<UserBackgroundDTO> query(@Valid UserBackgroundQueryVO vO) {
        return userBackgroundService.query(vO);
    }
}
