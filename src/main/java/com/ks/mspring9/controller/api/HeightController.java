package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.HeightDTO;
import com.ks.mspring9.service.HeightService;
import com.ks.mspring9.vo.HeightQueryVO;
import com.ks.mspring9.vo.HeightUpdateVO;
import com.ks.mspring9.vo.HeightVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/height")
public class HeightController {

    @Autowired
    private HeightService heightService;

    @PostMapping
    public String save(@Valid @RequestBody HeightVO vO) {
        return heightService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        heightService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody HeightUpdateVO vO) {
        heightService.update(id, vO);
    }

    @GetMapping("/{id}")
    public HeightDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return heightService.getById(id);
    }

    @GetMapping
    public Page<HeightDTO> query(@Valid HeightQueryVO vO) {
        return heightService.query(vO);
    }
}
