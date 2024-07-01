package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserAlbumDTO;
import com.ks.mspring9.service.UserAlbumService;
import com.ks.mspring9.vo.UserAlbumQueryVO;
import com.ks.mspring9.vo.UserAlbumUpdateVO;
import com.ks.mspring9.vo.UserAlbumVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/userAlbum")
public class UserAlbumController {

    @Autowired
    private UserAlbumService userAlbumService;

    @PostMapping
    public String save(@Valid @RequestBody UserAlbumVO vO) {
        return userAlbumService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userAlbumService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserAlbumUpdateVO vO) {
        userAlbumService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserAlbumDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userAlbumService.getById(id);
    }

    @GetMapping
    public Page<UserAlbumDTO> query(@Valid UserAlbumQueryVO vO) {
        return userAlbumService.query(vO);
    }
}
