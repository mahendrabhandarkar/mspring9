package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserLifestyleDTO;
import com.ks.mspring9.entity.UserLifestyle;
import com.ks.mspring9.repository.UserLifestyleRepository;
import com.ks.mspring9.vo.UserLifestyleQueryVO;
import com.ks.mspring9.vo.UserLifestyleUpdateVO;
import com.ks.mspring9.vo.UserLifestyleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserLifestyleService {

    @Autowired
    private UserLifestyleRepository userLifestyleRepository;

    public Integer save(UserLifestyleVO vO) {
        UserLifestyle bean = new UserLifestyle();
        BeanUtils.copyProperties(vO, bean);
        bean = userLifestyleRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userLifestyleRepository.deleteById(id);
    }

    public void update(Integer id, UserLifestyleUpdateVO vO) {
        UserLifestyle bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userLifestyleRepository.save(bean);
    }

    public UserLifestyleDTO getById(Integer id) {
        UserLifestyle original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserLifestyleDTO> query(UserLifestyleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserLifestyleDTO toDTO(UserLifestyle original) {
        UserLifestyleDTO bean = new UserLifestyleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserLifestyle requireOne(Integer id) {
        return userLifestyleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
