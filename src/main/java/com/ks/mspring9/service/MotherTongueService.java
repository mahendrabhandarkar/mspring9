package com.ks.mspring9.service;

import com.ks.mspring9.dto.MotherTongueDTO;
import com.ks.mspring9.entity.MotherTongue;
import com.ks.mspring9.repository.MotherTongueRepository;
import com.ks.mspring9.vo.MotherTongueQueryVO;
import com.ks.mspring9.vo.MotherTongueUpdateVO;
import com.ks.mspring9.vo.MotherTongueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MotherTongueService {

    @Autowired
    private MotherTongueRepository motherTongueRepository;

    public Integer save(MotherTongueVO vO) {
        MotherTongue bean = new MotherTongue();
        BeanUtils.copyProperties(vO, bean);
        bean = motherTongueRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        motherTongueRepository.deleteById(id);
    }

    public void update(Integer id, MotherTongueUpdateVO vO) {
        MotherTongue bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        motherTongueRepository.save(bean);
    }

    public MotherTongueDTO getById(Integer id) {
        MotherTongue original = requireOne(id);
        return toDTO(original);
    }

    public Page<MotherTongueDTO> query(MotherTongueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MotherTongueDTO toDTO(MotherTongue original) {
        MotherTongueDTO bean = new MotherTongueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MotherTongue requireOne(Integer id) {
        return motherTongueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
