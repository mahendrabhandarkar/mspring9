package com.ks.mspring9.service;

import com.ks.mspring9.dto.ReligionDTO;
import com.ks.mspring9.entity.Religion;
import com.ks.mspring9.repository.ReligionRepository;
import com.ks.mspring9.vo.ReligionQueryVO;
import com.ks.mspring9.vo.ReligionUpdateVO;
import com.ks.mspring9.vo.ReligionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ReligionService {

    @Autowired
    private ReligionRepository religionRepository;

    public Integer save(ReligionVO vO) {
        Religion bean = new Religion();
        BeanUtils.copyProperties(vO, bean);
        bean = religionRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        religionRepository.deleteById(id);
    }

    public void update(Integer id, ReligionUpdateVO vO) {
        Religion bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        religionRepository.save(bean);
    }

    public ReligionDTO getById(Integer id) {
        Religion original = requireOne(id);
        return toDTO(original);
    }

    public Page<ReligionDTO> query(ReligionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ReligionDTO toDTO(Religion original) {
        ReligionDTO bean = new ReligionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Religion requireOne(Integer id) {
        return religionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
