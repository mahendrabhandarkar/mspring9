package com.ks.mspring9.service;

import com.ks.mspring9.dto.UserfolderDTO;
import com.ks.mspring9.entity.Userfolder;
import com.ks.mspring9.repository.UserfolderRepository;
import com.ks.mspring9.vo.UserfolderQueryVO;
import com.ks.mspring9.vo.UserfolderUpdateVO;
import com.ks.mspring9.vo.UserfolderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserfolderService {

    @Autowired
    private UserfolderRepository userfolderRepository;

    public Integer save(UserfolderVO vO) {
        Userfolder bean = new Userfolder();
        BeanUtils.copyProperties(vO, bean);
        bean = userfolderRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        userfolderRepository.deleteById(id);
    }

    public void update(Integer id, UserfolderUpdateVO vO) {
        Userfolder bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userfolderRepository.save(bean);
    }

    public UserfolderDTO getById(Integer id) {
        Userfolder original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserfolderDTO> query(UserfolderQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserfolderDTO toDTO(Userfolder original) {
        UserfolderDTO bean = new UserfolderDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Userfolder requireOne(Integer id) {
        return userfolderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
