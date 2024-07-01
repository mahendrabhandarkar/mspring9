package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserAutologinDTO;
import com.ks.mspring9.entity.ids.UserAutologinId;
import com.ks.mspring9.service.UserAutologinService;
import com.ks.mspring9.vo.UserAutologinQueryVO;
import com.ks.mspring9.vo.UserAutologinUpdateVO;
import com.ks.mspring9.vo.UserAutologinVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;

@Validated
@RestController
@RequestMapping("/api/v1/userAutologin")
public class UserAutologinController {

    @Autowired
    private UserAutologinService userAutologinService;

    @PostMapping
    public String save(@Valid @RequestBody UserAutologinVO vO) {
        return userAutologinService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") UserAutologinId id) {
        userAutologinService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") UserAutologinId id,
                       @Valid @RequestBody UserAutologinUpdateVO vO) {
        userAutologinService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserAutologinDTO getById(@Valid @NotNull @PathVariable("id") UserAutologinId id) {
        return userAutologinService.getById(id);
    }

    @GetMapping
    public Page<UserAutologinDTO> query(@Valid UserAutologinQueryVO vO) {
        return userAutologinService.query(vO);
    }
}
