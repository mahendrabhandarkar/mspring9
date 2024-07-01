package com.ks.mspring9.service;

import com.ks.mspring9.dto.StatesDTO;
import com.ks.mspring9.entity.States;
import com.ks.mspring9.repository.StatesRepository;
import com.ks.mspring9.vo.StatesQueryVO;
import com.ks.mspring9.vo.StatesUpdateVO;
import com.ks.mspring9.vo.StatesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StatesService {

    @Autowired
    private StatesRepository statesRepository;

    public Integer save(StatesVO vO) {
        States bean = new States();
        BeanUtils.copyProperties(vO, bean);
        bean = statesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        statesRepository.deleteById(id);
    }

    public void update(Integer id, StatesUpdateVO vO) {
        States bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        statesRepository.save(bean);
    }

    public StatesDTO getById(Integer id) {
        States original = requireOne(id);
        return toDTO(original);
    }

    public Page<StatesDTO> query(StatesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private StatesDTO toDTO(States original) {
        StatesDTO bean = new StatesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private States requireOne(Integer id) {
        return statesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
