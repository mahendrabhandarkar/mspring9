package com.ks.mspring9.service;

import com.ks.mspring9.dto.LoginAttemptsDTO;
import com.ks.mspring9.entity.LoginAttempts;
import com.ks.mspring9.repository.LoginAttemptsRepository;
import com.ks.mspring9.vo.LoginAttemptsQueryVO;
import com.ks.mspring9.vo.LoginAttemptsUpdateVO;
import com.ks.mspring9.vo.LoginAttemptsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LoginAttemptsService {

    @Autowired
    private LoginAttemptsRepository loginAttemptsRepository;

    public Integer save(LoginAttemptsVO vO) {
        LoginAttempts bean = new LoginAttempts();
        BeanUtils.copyProperties(vO, bean);
        bean = loginAttemptsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        loginAttemptsRepository.deleteById(id);
    }

    public void update(Integer id, LoginAttemptsUpdateVO vO) {
        LoginAttempts bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        loginAttemptsRepository.save(bean);
    }

    public LoginAttemptsDTO getById(Integer id) {
        LoginAttempts original = requireOne(id);
        return toDTO(original);
    }

    public Page<LoginAttemptsDTO> query(LoginAttemptsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private LoginAttemptsDTO toDTO(LoginAttempts original) {
        LoginAttemptsDTO bean = new LoginAttemptsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private LoginAttempts requireOne(Integer id) {
        return loginAttemptsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
