package com.ks.mspring9.service;

import com.ks.mspring9.dto.AccountSettingDTO;
import com.ks.mspring9.entity.AccountSetting;
import com.ks.mspring9.repository.AccountSettingRepository;
import com.ks.mspring9.vo.AccountSettingQueryVO;
import com.ks.mspring9.vo.AccountSettingUpdateVO;
import com.ks.mspring9.vo.AccountSettingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccountSettingService {

    @Autowired
    private AccountSettingRepository accountSettingRepository;

    public Integer save(AccountSettingVO vO) {
        AccountSetting bean = new AccountSetting();
        BeanUtils.copyProperties(vO, bean);
        bean = accountSettingRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        accountSettingRepository.deleteById(id);
    }

    public void update(Integer id, AccountSettingUpdateVO vO) {
        AccountSetting bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accountSettingRepository.save(bean);
    }

    public AccountSettingDTO getById(Integer id) {
        AccountSetting original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccountSettingDTO> query(AccountSettingQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AccountSettingDTO toDTO(AccountSetting original) {
        AccountSettingDTO bean = new AccountSettingDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AccountSetting requireOne(Integer id) {
        return accountSettingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
/*
    public AccountSetting findAccountSettingById(Integer id) {

    }
 */
}
