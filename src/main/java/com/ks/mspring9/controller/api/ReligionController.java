package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.ReligionDTO;
import com.ks.mspring9.service.ReligionService;
import com.ks.mspring9.vo.ReligionQueryVO;
import com.ks.mspring9.vo.ReligionUpdateVO;
import com.ks.mspring9.vo.ReligionVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/religion")
public class ReligionController {

    @Autowired
    private ReligionService religionService;

    @PostMapping
    public String save(@Valid @RequestBody ReligionVO vO) {
        return religionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        religionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ReligionUpdateVO vO) {
        religionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ReligionDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return religionService.getById(id);
    }

    @GetMapping
    public Page<ReligionDTO> query(@Valid ReligionQueryVO vO) {
        return religionService.query(vO);
    }
}
