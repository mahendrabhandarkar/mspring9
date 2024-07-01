package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserAlbumDTO;
import com.ks.mspring9.entity.UserAlbum;
import com.ks.mspring9.repository.UserAlbumRepository;
import com.ks.mspring9.vo.UserAlbumQueryVO;
import com.ks.mspring9.vo.UserAlbumUpdateVO;
import com.ks.mspring9.vo.UserAlbumVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserAlbumService {

    @Autowired
    private UserAlbumRepository userAlbumRepository;

    public Integer save(UserAlbumVO vO) {
        UserAlbum bean = new UserAlbum();
        BeanUtils.copyProperties(vO, bean);
        bean = userAlbumRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userAlbumRepository.deleteById(id);
    }

    public void update(Integer id, UserAlbumUpdateVO vO) {
        UserAlbum bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userAlbumRepository.save(bean);
    }

    public UserAlbumDTO getById(Integer id) {
        UserAlbum original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserAlbumDTO> query(UserAlbumQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserAlbumDTO toDTO(UserAlbum original) {
        UserAlbumDTO bean = new UserAlbumDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserAlbum requireOne(Integer id) {
        return userAlbumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
