package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserHobbiesDTO;
import com.ks.mspring9.entity.UserHobbies;
import com.ks.mspring9.repository.UserHobbiesRepository;
import com.ks.mspring9.vo.UserHobbiesQueryVO;
import com.ks.mspring9.vo.UserHobbiesUpdateVO;
import com.ks.mspring9.vo.UserHobbiesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserHobbiesService {

    @Autowired
    private UserHobbiesRepository userHobbiesRepository;

    public Integer save(UserHobbiesVO vO) {
        UserHobbies bean = new UserHobbies();
        BeanUtils.copyProperties(vO, bean);
        bean = userHobbiesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userHobbiesRepository.deleteById(id);
    }

    public void update(Integer id, UserHobbiesUpdateVO vO) {
        UserHobbies bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userHobbiesRepository.save(bean);
    }

    public UserHobbiesDTO getById(Integer id) {
        UserHobbies original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserHobbiesDTO> query(UserHobbiesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserHobbiesDTO toDTO(UserHobbies original) {
        UserHobbiesDTO bean = new UserHobbiesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserHobbies requireOne(Integer id) {
        return userHobbiesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
