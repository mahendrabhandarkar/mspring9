package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.AccountSettingDTO;
import com.ks.mspring9.service.AccountSettingService;
import com.ks.mspring9.vo.AccountSettingQueryVO;
import com.ks.mspring9.vo.AccountSettingUpdateVO;
import com.ks.mspring9.vo.AccountSettingVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/accountSetting")
public class AccountSettingController {

    @Autowired
    private AccountSettingService accountSettingService;

    @PostMapping
    public String save(@Valid @RequestBody AccountSettingVO vO) {
        return accountSettingService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        accountSettingService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AccountSettingUpdateVO vO) {
        accountSettingService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccountSettingDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return accountSettingService.getById(id);
    }

    @GetMapping
    public Page<AccountSettingDTO> query(@Valid AccountSettingQueryVO vO) {
        return accountSettingService.query(vO);
    }
}
