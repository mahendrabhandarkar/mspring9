package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.EducationLevelDTO;
import com.ks.mspring9.service.EducationLevelService;
import com.ks.mspring9.vo.EducationLevelQueryVO;
import com.ks.mspring9.vo.EducationLevelUpdateVO;
import com.ks.mspring9.vo.EducationLevelVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/educationLevel")
public class EducationLevelController {

    @Autowired
    private EducationLevelService educationLevelService;

    @PostMapping
    public String save(@Valid @RequestBody EducationLevelVO vO) {
        return educationLevelService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        educationLevelService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody EducationLevelUpdateVO vO) {
        educationLevelService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EducationLevelDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return educationLevelService.getById(id);
    }

    @GetMapping
    public Page<EducationLevelDTO> query(@Valid EducationLevelQueryVO vO) {
        return educationLevelService.query(vO);
    }
}
