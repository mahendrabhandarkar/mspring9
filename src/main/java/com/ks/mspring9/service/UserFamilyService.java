package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserFamilyDTO;
import com.ks.mspring9.entity.UserFamily;
import com.ks.mspring9.repository.UserFamilyRepository;
import com.ks.mspring9.vo.UserFamilyQueryVO;
import com.ks.mspring9.vo.UserFamilyUpdateVO;
import com.ks.mspring9.vo.UserFamilyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFamilyService {

    @Autowired
    private UserFamilyRepository userFamilyRepository;

    public Integer save(UserFamilyVO vO) {
        UserFamily bean = new UserFamily();
        BeanUtils.copyProperties(vO, bean);
        bean = userFamilyRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userFamilyRepository.deleteById(id);
    }

    public void update(Integer id, UserFamilyUpdateVO vO) {
        UserFamily bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userFamilyRepository.save(bean);
    }

    public UserFamilyDTO getById(Integer id) {
        UserFamily original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserFamilyDTO> query(UserFamilyQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserFamilyDTO toDTO(UserFamily original) {
        UserFamilyDTO bean = new UserFamilyDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserFamily requireOne(Integer id) {
        return userFamilyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
