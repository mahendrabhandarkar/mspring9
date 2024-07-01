package com.ks.mspring9.service;

import com.ks.mspring9.dto.HeightDTO;
import com.ks.mspring9.entity.Height;
import com.ks.mspring9.repository.HeightRepository;
import com.ks.mspring9.vo.HeightQueryVO;
import com.ks.mspring9.vo.HeightUpdateVO;
import com.ks.mspring9.vo.HeightVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HeightService {

    @Autowired
    private HeightRepository heightRepository;

    public Integer save(HeightVO vO) {
        Height bean = new Height();
        BeanUtils.copyProperties(vO, bean);
        bean = heightRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        heightRepository.deleteById(id);
    }

    public void update(Integer id, HeightUpdateVO vO) {
        Height bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        heightRepository.save(bean);
    }

    public HeightDTO getById(Integer id) {
        Height original = requireOne(id);
        return toDTO(original);
    }

    public Page<HeightDTO> query(HeightQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private HeightDTO toDTO(Height original) {
        HeightDTO bean = new HeightDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Height requireOne(Integer id) {
        return heightRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
