package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.UserSearchDTO;
import com.ks.mspring9.service.UserSearchService;
import com.ks.mspring9.vo.UserSearchQueryVO;
import com.ks.mspring9.vo.UserSearchUpdateVO;
import com.ks.mspring9.vo.UserSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/userSearch")
public class UserSearchController {

    @Autowired
    private UserSearchService userSearchService;

    @PostMapping
    public String save(@Valid @RequestBody UserSearchVO vO) {
        return userSearchService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userSearchService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserSearchUpdateVO vO) {
        userSearchService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserSearchDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userSearchService.getById(id);
    }

    @GetMapping
    public Page<UserSearchDTO> query(@Valid UserSearchQueryVO vO) {
        return userSearchService.query(vO);
    }
}
