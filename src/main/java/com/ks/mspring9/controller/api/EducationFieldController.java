package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.EducationFieldDTO;
import com.ks.mspring9.service.EducationFieldService;
import com.ks.mspring9.vo.EducationFieldQueryVO;
import com.ks.mspring9.vo.EducationFieldUpdateVO;
import com.ks.mspring9.vo.EducationFieldVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/educationField")
public class EducationFieldController {

    @Autowired
    private EducationFieldService educationFieldService;

    @PostMapping
    public String save(@Valid @RequestBody EducationFieldVO vO) {
        return educationFieldService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        educationFieldService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody EducationFieldUpdateVO vO) {
        educationFieldService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EducationFieldDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return educationFieldService.getById(id);
    }

    @GetMapping
    public Page<EducationFieldDTO> query(@Valid EducationFieldQueryVO vO) {
        return educationFieldService.query(vO);
    }
}
