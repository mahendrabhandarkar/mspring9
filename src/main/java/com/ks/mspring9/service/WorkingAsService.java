package com.ks.mspring9.service;

import com.ks.mspring9.dto.WorkingAsDTO;
import com.ks.mspring9.entity.WorkingAs;
import com.ks.mspring9.repository.WorkingAsRepository;
import com.ks.mspring9.vo.WorkingAsQueryVO;
import com.ks.mspring9.vo.WorkingAsUpdateVO;
import com.ks.mspring9.vo.WorkingAsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WorkingAsService {

    @Autowired
    private WorkingAsRepository workingAsRepository;

    public Integer save(WorkingAsVO vO) {
        WorkingAs bean = new WorkingAs();
        BeanUtils.copyProperties(vO, bean);
        bean = workingAsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        workingAsRepository.deleteById(id);
    }

    public void update(Integer id, WorkingAsUpdateVO vO) {
        WorkingAs bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        workingAsRepository.save(bean);
    }

    public WorkingAsDTO getById(Integer id) {
        WorkingAs original = requireOne(id);
        return toDTO(original);
    }

    public Page<WorkingAsDTO> query(WorkingAsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private WorkingAsDTO toDTO(WorkingAs original) {
        WorkingAsDTO bean = new WorkingAsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private WorkingAs requireOne(Integer id) {
        return workingAsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
