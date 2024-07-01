package com.ks.mspring9.service;

import com.ks.mspring9.dto.WorkingWithDTO;
import com.ks.mspring9.entity.WorkingWith;
import com.ks.mspring9.repository.WorkingWithRepository;
import com.ks.mspring9.vo.WorkingWithQueryVO;
import com.ks.mspring9.vo.WorkingWithUpdateVO;
import com.ks.mspring9.vo.WorkingWithVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WorkingWithService {

    @Autowired
    private WorkingWithRepository workingWithRepository;

    public Integer save(WorkingWithVO vO) {
        WorkingWith bean = new WorkingWith();
        BeanUtils.copyProperties(vO, bean);
        bean = workingWithRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        workingWithRepository.deleteById(id);
    }

    public void update(Integer id, WorkingWithUpdateVO vO) {
        WorkingWith bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        workingWithRepository.save(bean);
    }

    public WorkingWithDTO getById(Integer id) {
        WorkingWith original = requireOne(id);
        return toDTO(original);
    }

    public Page<WorkingWithDTO> query(WorkingWithQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private WorkingWithDTO toDTO(WorkingWith original) {
        WorkingWithDTO bean = new WorkingWithDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private WorkingWith requireOne(Integer id) {
        return workingWithRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
