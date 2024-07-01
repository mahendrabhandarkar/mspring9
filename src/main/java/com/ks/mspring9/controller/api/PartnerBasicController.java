package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.PartnerBasicDTO;
import com.ks.mspring9.service.PartnerBasicService;
import com.ks.mspring9.vo.PartnerBasicQueryVO;
import com.ks.mspring9.vo.PartnerBasicUpdateVO;
import com.ks.mspring9.vo.PartnerBasicVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/partnerBasic")
public class PartnerBasicController {

    @Autowired
    private PartnerBasicService partnerBasicService;

    @PostMapping
    public String save(@Valid @RequestBody PartnerBasicVO vO) {
        return partnerBasicService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        partnerBasicService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PartnerBasicUpdateVO vO) {
        partnerBasicService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PartnerBasicDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return partnerBasicService.getById(id);
    }

    @GetMapping
    public Page<PartnerBasicDTO> query(@Valid PartnerBasicQueryVO vO) {
        return partnerBasicService.query(vO);
    }
}
