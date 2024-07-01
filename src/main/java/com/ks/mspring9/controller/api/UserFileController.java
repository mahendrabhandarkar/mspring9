package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserFileDTO;
import com.ks.mspring9.service.UserFileService;
import com.ks.mspring9.vo.UserFileQueryVO;
import com.ks.mspring9.vo.UserFileUpdateVO;
import com.ks.mspring9.vo.UserFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userFile")
public class UserFileController {

    @Autowired
    private UserFileService userFileService;

    @PostMapping
    public String save(@Valid @RequestBody UserFileVO vO) {
        return userFileService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userFileService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserFileUpdateVO vO) {
        userFileService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserFileDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userFileService.getById(id);
    }

    @GetMapping
    public Page<UserFileDTO> query(@Valid UserFileQueryVO vO) {
        return userFileService.query(vO);
    }
}
