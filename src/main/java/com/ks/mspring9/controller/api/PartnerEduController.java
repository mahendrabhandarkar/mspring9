package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.PartnerEduDTO;
import com.ks.mspring9.service.PartnerEduService;
import com.ks.mspring9.vo.PartnerEduQueryVO;
import com.ks.mspring9.vo.PartnerEduUpdateVO;
import com.ks.mspring9.vo.PartnerEduVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/partnerEdu")
public class PartnerEduController {

    @Autowired
    private PartnerEduService partnerEduService;

    @PostMapping
    public String save(@Valid @RequestBody PartnerEduVO vO) {
        return partnerEduService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        partnerEduService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PartnerEduUpdateVO vO) {
        partnerEduService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PartnerEduDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return partnerEduService.getById(id);
    }

    @GetMapping
    public Page<PartnerEduDTO> query(@Valid PartnerEduQueryVO vO) {
        return partnerEduService.query(vO);
    }
}
