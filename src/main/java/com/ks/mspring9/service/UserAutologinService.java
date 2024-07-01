package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserAutologinDTO;
import com.ks.mspring9.entity.UserAutologin;
import com.ks.mspring9.entity.ids.UserAutologinId;
import com.ks.mspring9.repository.UserAutologinRepository;
import com.ks.mspring9.vo.UserAutologinQueryVO;
import com.ks.mspring9.vo.UserAutologinUpdateVO;
import com.ks.mspring9.vo.UserAutologinVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserAutologinService {

    @Autowired
    private UserAutologinRepository userAutologinRepository;

    public String save(UserAutologinVO vO) {
        UserAutologin bean = new UserAutologin();
        BeanUtils.copyProperties(vO, bean);
        bean = userAutologinRepository.save(bean);
        return bean.getKeyId();
    }

    public void delete(UserAutologinId id) {
        userAutologinRepository.deleteById(id);
    }

    public void update(UserAutologinId id, UserAutologinUpdateVO vO) {
        UserAutologin bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userAutologinRepository.save(bean);
    }

    public UserAutologinDTO getById(UserAutologinId id) {
        UserAutologin original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserAutologinDTO> query(UserAutologinQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserAutologinDTO toDTO(UserAutologin original) {
        UserAutologinDTO bean = new UserAutologinDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserAutologin requireOne(UserAutologinId id) {
        return userAutologinRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
