package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.SubCommunityDTO;
import com.ks.mspring9.service.SubCommunityService;
import com.ks.mspring9.vo.SubCommunityQueryVO;
import com.ks.mspring9.vo.SubCommunityUpdateVO;
import com.ks.mspring9.vo.SubCommunityVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/subCommunity")
public class SubCommunityController {

    @Autowired
    private SubCommunityService subCommunityService;

    @PostMapping
    public String save(@Valid @RequestBody SubCommunityVO vO) {
        return subCommunityService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        subCommunityService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody SubCommunityUpdateVO vO) {
        subCommunityService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SubCommunityDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return subCommunityService.getById(id);
    }

    @GetMapping
    public Page<SubCommunityDTO> query(@Valid SubCommunityQueryVO vO) {
        return subCommunityService.query(vO);
    }
}
