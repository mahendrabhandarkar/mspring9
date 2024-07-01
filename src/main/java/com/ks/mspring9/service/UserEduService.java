package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserEduDTO;
import com.ks.mspring9.entity.UserEdu;
import com.ks.mspring9.repository.UserEduRepository;
import com.ks.mspring9.vo.UserEduQueryVO;
import com.ks.mspring9.vo.UserEduUpdateVO;
import com.ks.mspring9.vo.UserEduVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserEduService {

    @Autowired
    private UserEduRepository userEduRepository;

    public Integer save(UserEduVO vO) {
        UserEdu bean = new UserEdu();
        BeanUtils.copyProperties(vO, bean);
        bean = userEduRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userEduRepository.deleteById(id);
    }

    public void update(Integer id, UserEduUpdateVO vO) {
        UserEdu bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userEduRepository.save(bean);
    }

    public UserEduDTO getById(Integer id) {
        UserEdu original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserEduDTO> query(UserEduQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserEduDTO toDTO(UserEdu original) {
        UserEduDTO bean = new UserEduDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserEdu requireOne(Integer id) {
        return userEduRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
