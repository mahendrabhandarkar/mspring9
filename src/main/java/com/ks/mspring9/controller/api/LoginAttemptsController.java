package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.LoginAttemptsDTO;
import com.ks.mspring9.service.LoginAttemptsService;
import com.ks.mspring9.vo.LoginAttemptsQueryVO;
import com.ks.mspring9.vo.LoginAttemptsUpdateVO;
import com.ks.mspring9.vo.LoginAttemptsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/loginAttempts")
public class LoginAttemptsController {

    @Autowired
    private LoginAttemptsService loginAttemptsService;

    @PostMapping
    public String save(@Valid @RequestBody LoginAttemptsVO vO) {
        return loginAttemptsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        loginAttemptsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LoginAttemptsUpdateVO vO) {
        loginAttemptsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public LoginAttemptsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return loginAttemptsService.getById(id);
    }

    @GetMapping
    public Page<LoginAttemptsDTO> query(@Valid LoginAttemptsQueryVO vO) {
        return loginAttemptsService.query(vO);
    }
}
