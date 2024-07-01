package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.CiSessionsDTO;
import com.ks.mspring9.service.CiSessionsService;
import com.ks.mspring9.vo.CiSessionsQueryVO;
import com.ks.mspring9.vo.CiSessionsUpdateVO;
import com.ks.mspring9.vo.CiSessionsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/ciSessions")
public class CiSessionsController {

    @Autowired
    private CiSessionsService ciSessionsService;

    @PostMapping
    public String save(@Valid @RequestBody CiSessionsVO vO) {
        return ciSessionsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        ciSessionsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody CiSessionsUpdateVO vO) {
        ciSessionsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CiSessionsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return ciSessionsService.getById(id);
    }

    @GetMapping
    public Page<CiSessionsDTO> query(@Valid CiSessionsQueryVO vO) {
        return ciSessionsService.query(vO);
    }
}
