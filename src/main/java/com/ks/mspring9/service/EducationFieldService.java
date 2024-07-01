package com.ks.mspring9.service;

import com.ks.mspring9.dto.EducationFieldDTO;
import com.ks.mspring9.entity.EducationField;
import com.ks.mspring9.repository.EducationFieldRepository;
import com.ks.mspring9.vo.EducationFieldQueryVO;
import com.ks.mspring9.vo.EducationFieldUpdateVO;
import com.ks.mspring9.vo.EducationFieldVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EducationFieldService {

    @Autowired
    private EducationFieldRepository educationFieldRepository;

    public Integer save(EducationFieldVO vO) {
        EducationField bean = new EducationField();
        BeanUtils.copyProperties(vO, bean);
        bean = educationFieldRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        educationFieldRepository.deleteById(id);
    }

    public void update(Integer id, EducationFieldUpdateVO vO) {
        EducationField bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        educationFieldRepository.save(bean);
    }

    public EducationFieldDTO getById(Integer id) {
        EducationField original = requireOne(id);
        return toDTO(original);
    }

    public Page<EducationFieldDTO> query(EducationFieldQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EducationFieldDTO toDTO(EducationField original) {
        EducationFieldDTO bean = new EducationFieldDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private EducationField requireOne(Integer id) {
        return educationFieldRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
