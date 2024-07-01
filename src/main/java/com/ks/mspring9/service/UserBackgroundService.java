package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserBackgroundDTO;
import com.ks.mspring9.entity.UserBackground;
import com.ks.mspring9.repository.UserBackgroundRepository;
import com.ks.mspring9.vo.UserBackgroundQueryVO;
import com.ks.mspring9.vo.UserBackgroundUpdateVO;
import com.ks.mspring9.vo.UserBackgroundVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserBackgroundService {

    @Autowired
    private UserBackgroundRepository userBackgroundRepository;

    public Integer save(UserBackgroundVO vO) {
        UserBackground bean = new UserBackground();
        BeanUtils.copyProperties(vO, bean);
        bean = userBackgroundRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userBackgroundRepository.deleteById(id);
    }

    public void update(Integer id, UserBackgroundUpdateVO vO) {
        UserBackground bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userBackgroundRepository.save(bean);
    }

    public UserBackgroundDTO getById(Integer id) {
        UserBackground original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserBackgroundDTO> query(UserBackgroundQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserBackgroundDTO toDTO(UserBackground original) {
        UserBackgroundDTO bean = new UserBackgroundDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserBackground requireOne(Integer id) {
        return userBackgroundRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
