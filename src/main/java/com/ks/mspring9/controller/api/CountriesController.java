package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.CountriesDTO;
import com.ks.mspring9.service.CountriesService;
import com.ks.mspring9.vo.CountriesQueryVO;
import com.ks.mspring9.vo.CountriesUpdateVO;
import com.ks.mspring9.vo.CountriesVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/countries")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @PostMapping
    public String save(@Valid @RequestBody CountriesVO vO) {
        return countriesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        countriesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CountriesUpdateVO vO) {
        countriesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CountriesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return countriesService.getById(id);
    }

    @GetMapping
    public Page<CountriesDTO> query(@Valid CountriesQueryVO vO) {
        return countriesService.query(vO);
    }
}
