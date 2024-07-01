package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.MotherTongueDTO;
import com.ks.mspring9.service.MotherTongueService;
import com.ks.mspring9.vo.MotherTongueQueryVO;
import com.ks.mspring9.vo.MotherTongueUpdateVO;
import com.ks.mspring9.vo.MotherTongueVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/motherTongue")
public class MotherTongueController {

    @Autowired
    private MotherTongueService motherTongueService;

    @PostMapping
    public String save(@Valid @RequestBody MotherTongueVO vO) {
        return motherTongueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        motherTongueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MotherTongueUpdateVO vO) {
        motherTongueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MotherTongueDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return motherTongueService.getById(id);
    }

    @GetMapping
    public Page<MotherTongueDTO> query(@Valid MotherTongueQueryVO vO) {
        return motherTongueService.query(vO);
    }
}
