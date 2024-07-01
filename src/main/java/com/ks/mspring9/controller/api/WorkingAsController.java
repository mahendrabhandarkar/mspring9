package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.WorkingAsDTO;
import com.ks.mspring9.service.WorkingAsService;
import com.ks.mspring9.vo.WorkingAsQueryVO;
import com.ks.mspring9.vo.WorkingAsUpdateVO;
import com.ks.mspring9.vo.WorkingAsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/workingAs")
public class WorkingAsController {

    @Autowired
    private WorkingAsService workingAsService;

    @PostMapping
    public String save(@Valid @RequestBody WorkingAsVO vO) {
        return workingAsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        workingAsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody WorkingAsUpdateVO vO) {
        workingAsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public WorkingAsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return workingAsService.getById(id);
    }

    @GetMapping
    public Page<WorkingAsDTO> query(@Valid WorkingAsQueryVO vO) {
        return workingAsService.query(vO);
    }
}
