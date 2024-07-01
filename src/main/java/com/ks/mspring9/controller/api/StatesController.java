package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.StatesDTO;
import com.ks.mspring9.service.StatesService;
import com.ks.mspring9.vo.StatesQueryVO;
import com.ks.mspring9.vo.StatesUpdateVO;
import com.ks.mspring9.vo.StatesVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/states")
public class StatesController {

    @Autowired
    private StatesService statesService;

    @PostMapping
    public String save(@Valid @RequestBody StatesVO vO) {
        return statesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        statesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody StatesUpdateVO vO) {
        statesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public StatesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return statesService.getById(id);
    }

    @GetMapping
    public Page<StatesDTO> query(@Valid StatesQueryVO vO) {
        return statesService.query(vO);
    }
}
