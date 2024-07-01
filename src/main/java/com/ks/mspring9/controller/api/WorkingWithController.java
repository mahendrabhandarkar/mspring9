package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.WorkingWithDTO;
import com.ks.mspring9.service.WorkingWithService;
import com.ks.mspring9.vo.WorkingWithQueryVO;
import com.ks.mspring9.vo.WorkingWithUpdateVO;
import com.ks.mspring9.vo.WorkingWithVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/workingWith")
public class WorkingWithController {

    @Autowired
    private WorkingWithService workingWithService;

    @PostMapping
    public String save(@Valid @RequestBody WorkingWithVO vO) {
        return workingWithService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        workingWithService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody WorkingWithUpdateVO vO) {
        workingWithService.update(id, vO);
    }

    @GetMapping("/{id}")
    public WorkingWithDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return workingWithService.getById(id);
    }

    @GetMapping
    public Page<WorkingWithDTO> query(@Valid WorkingWithQueryVO vO) {
        return workingWithService.query(vO);
    }
}
