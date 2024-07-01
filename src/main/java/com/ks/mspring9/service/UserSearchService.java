package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserSearchDTO;
import com.ks.mspring9.entity.UserSearch;
import com.ks.mspring9.repository.UserSearchRepository;
import com.ks.mspring9.vo.UserSearchQueryVO;
import com.ks.mspring9.vo.UserSearchUpdateVO;
import com.ks.mspring9.vo.UserSearchVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserSearchService {

    @Autowired
    private UserSearchRepository userSearchRepository;

    public Integer save(UserSearchVO vO) {
        UserSearch bean = new UserSearch();
        BeanUtils.copyProperties(vO, bean);
        bean = userSearchRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userSearchRepository.deleteById(id);
    }

    public void update(Integer id, UserSearchUpdateVO vO) {
        UserSearch bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userSearchRepository.save(bean);
    }

    public UserSearchDTO getById(Integer id) {
        UserSearch original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserSearchDTO> query(UserSearchQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserSearchDTO toDTO(UserSearch original) {
        UserSearchDTO bean = new UserSearchDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserSearch requireOne(Integer id) {
        return userSearchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
