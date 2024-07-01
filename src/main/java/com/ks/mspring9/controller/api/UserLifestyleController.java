package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserLifestyleDTO;
import com.ks.mspring9.service.UserLifestyleService;
import com.ks.mspring9.vo.UserLifestyleQueryVO;
import com.ks.mspring9.vo.UserLifestyleUpdateVO;
import com.ks.mspring9.vo.UserLifestyleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userLifestyle")
public class UserLifestyleController {

    @Autowired
    private UserLifestyleService userLifestyleService;

    @PostMapping
    public String save(@Valid @RequestBody UserLifestyleVO vO) {
        return userLifestyleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userLifestyleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserLifestyleUpdateVO vO) {
        userLifestyleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserLifestyleDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userLifestyleService.getById(id);
    }

    @GetMapping
    public Page<UserLifestyleDTO> query(@Valid UserLifestyleQueryVO vO) {
        return userLifestyleService.query(vO);
    }
}
