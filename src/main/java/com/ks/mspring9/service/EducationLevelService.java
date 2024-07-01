package com.ks.mspring9.service;

import com.ks.mspring9.dto.EducationLevelDTO;
import com.ks.mspring9.entity.EducationLevel;
import com.ks.mspring9.repository.EducationLevelRepository;
import com.ks.mspring9.vo.EducationLevelQueryVO;
import com.ks.mspring9.vo.EducationLevelUpdateVO;
import com.ks.mspring9.vo.EducationLevelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EducationLevelService {

    @Autowired
    private EducationLevelRepository educationLevelRepository;

    public Integer save(EducationLevelVO vO) {
        EducationLevel bean = new EducationLevel();
        BeanUtils.copyProperties(vO, bean);
        bean = educationLevelRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        educationLevelRepository.deleteById(id);
    }

    public void update(Integer id, EducationLevelUpdateVO vO) {
        EducationLevel bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        educationLevelRepository.save(bean);
    }

    public EducationLevelDTO getById(Integer id) {
        EducationLevel original = requireOne(id);
        return toDTO(original);
    }

    public Page<EducationLevelDTO> query(EducationLevelQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EducationLevelDTO toDTO(EducationLevel original) {
        EducationLevelDTO bean = new EducationLevelDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private EducationLevel requireOne(Integer id) {
        return educationLevelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
