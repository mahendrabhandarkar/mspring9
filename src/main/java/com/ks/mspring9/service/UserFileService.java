package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserFileDTO;
import com.ks.mspring9.entity.UserFile;
import com.ks.mspring9.repository.UserFileRepository;
import com.ks.mspring9.vo.UserFileQueryVO;
import com.ks.mspring9.vo.UserFileUpdateVO;
import com.ks.mspring9.vo.UserFileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFileService {

    @Autowired
    private UserFileRepository userFileRepository;

    public Integer save(UserFileVO vO) {
        UserFile bean = new UserFile();
        BeanUtils.copyProperties(vO, bean);
        bean = userFileRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userFileRepository.deleteById(id);
    }

    public void update(Integer id, UserFileUpdateVO vO) {
        UserFile bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userFileRepository.save(bean);
    }

    public UserFileDTO getById(Integer id) {
        UserFile original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserFileDTO> query(UserFileQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserFileDTO toDTO(UserFile original) {
        UserFileDTO bean = new UserFileDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserFile requireOne(Integer id) {
        return userFileRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
