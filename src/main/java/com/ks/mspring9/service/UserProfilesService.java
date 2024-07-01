package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserProfilesDTO;
import com.ks.mspring9.entity.UserProfiles;
import com.ks.mspring9.repository.UserProfilesRepository;
import com.ks.mspring9.vo.UserProfilesQueryVO;
import com.ks.mspring9.vo.UserProfilesUpdateVO;
import com.ks.mspring9.vo.UserProfilesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserProfilesService {

    @Autowired
    private UserProfilesRepository userProfilesRepository;

    public Integer save(UserProfilesVO vO) {
        UserProfiles bean = new UserProfiles();
        BeanUtils.copyProperties(vO, bean);
        bean = userProfilesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userProfilesRepository.deleteById(id);
    }

    public void update(Integer id, UserProfilesUpdateVO vO) {
        UserProfiles bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userProfilesRepository.save(bean);
    }

    public UserProfilesDTO getById(Integer id) {
        UserProfiles original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserProfilesDTO> query(UserProfilesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserProfilesDTO toDTO(UserProfiles original) {
        UserProfilesDTO bean = new UserProfilesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserProfiles requireOne(Integer id) {
        return userProfilesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
