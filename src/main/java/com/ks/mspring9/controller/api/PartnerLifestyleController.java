package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.PartnerLifestyleDTO;
import com.ks.mspring9.service.PartnerLifestyleService;
import com.ks.mspring9.vo.PartnerLifestyleQueryVO;
import com.ks.mspring9.vo.PartnerLifestyleUpdateVO;
import com.ks.mspring9.vo.PartnerLifestyleVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/partnerLifestyle")
public class PartnerLifestyleController {

    @Autowired
    private PartnerLifestyleService partnerLifestyleService;

    @PostMapping
    public String save(@Valid @RequestBody PartnerLifestyleVO vO) {
        return partnerLifestyleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        partnerLifestyleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PartnerLifestyleUpdateVO vO) {
        partnerLifestyleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PartnerLifestyleDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return partnerLifestyleService.getById(id);
    }

    @GetMapping
    public Page<PartnerLifestyleDTO> query(@Valid PartnerLifestyleQueryVO vO) {
        return partnerLifestyleService.query(vO);
    }
}
