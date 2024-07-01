package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.CommunityDTO;
import com.ks.mspring9.service.CommunityService;
import com.ks.mspring9.vo.CommunityQueryVO;
import com.ks.mspring9.vo.CommunityUpdateVO;
import com.ks.mspring9.vo.CommunityVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping
    public String save(@Valid @RequestBody CommunityVO vO) {
        return communityService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        communityService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CommunityUpdateVO vO) {
        communityService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CommunityDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return communityService.getById(id);
    }

    @GetMapping
    public Page<CommunityDTO> query(@Valid CommunityQueryVO vO) {
        return communityService.query(vO);
    }
}
