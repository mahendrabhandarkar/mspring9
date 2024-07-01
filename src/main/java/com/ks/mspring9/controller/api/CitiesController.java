package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.CitiesDTO;
import com.ks.mspring9.service.CitiesService;
import com.ks.mspring9.vo.CitiesQueryVO;
import com.ks.mspring9.vo.CitiesUpdateVO;
import com.ks.mspring9.vo.CitiesVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/cities")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @PostMapping
    public String save(@Valid @RequestBody CitiesVO vO) {
        return citiesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        citiesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CitiesUpdateVO vO) {
        citiesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CitiesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return citiesService.getById(id);
    }

    @GetMapping
    public Page<CitiesDTO> query(@Valid CitiesQueryVO vO) {
        return citiesService.query(vO);
    }
}
