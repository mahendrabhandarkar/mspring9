package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserfolderDTO;
import com.ks.mspring9.service.UserfolderService;
import com.ks.mspring9.vo.UserfolderQueryVO;
import com.ks.mspring9.vo.UserfolderUpdateVO;
import com.ks.mspring9.vo.UserfolderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userfolder")
public class UserfolderController {

    @Autowired
    private UserfolderService userfolderService;

    @PostMapping
    public String save(@Valid @RequestBody UserfolderVO vO) {
        return userfolderService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userfolderService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserfolderUpdateVO vO) {
        userfolderService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserfolderDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userfolderService.getById(id);
    }

    @GetMapping
    public Page<UserfolderDTO> query(@Valid UserfolderQueryVO vO) {
        return userfolderService.query(vO);
    }
}
