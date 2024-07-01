package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.PartnerBackgroundDTO;
import com.ks.mspring9.service.PartnerBackgroundService;
import com.ks.mspring9.vo.PartnerBackgroundQueryVO;
import com.ks.mspring9.vo.PartnerBackgroundUpdateVO;
import com.ks.mspring9.vo.PartnerBackgroundVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/partnerBackground")
public class PartnerBackgroundController {

    @Autowired
    private PartnerBackgroundService partnerBackgroundService;

    @PostMapping
    public String save(@Valid @RequestBody PartnerBackgroundVO vO) {
        return partnerBackgroundService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        partnerBackgroundService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PartnerBackgroundUpdateVO vO) {
        partnerBackgroundService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PartnerBackgroundDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return partnerBackgroundService.getById(id);
    }

    @GetMapping
    public Page<PartnerBackgroundDTO> query(@Valid PartnerBackgroundQueryVO vO) {
        return partnerBackgroundService.query(vO);
    }
}
