package com.ks.mspring9.service;

import com.ks.mspring9.dto.CiSessionsDTO;
import com.ks.mspring9.entity.CiSessions;
import com.ks.mspring9.repository.CiSessionsRepository;
import com.ks.mspring9.vo.CiSessionsQueryVO;
import com.ks.mspring9.vo.CiSessionsUpdateVO;
import com.ks.mspring9.vo.CiSessionsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CiSessionsService {

    @Autowired
    private CiSessionsRepository ciSessionsRepository;

    public String save(CiSessionsVO vO) {
        CiSessions bean = new CiSessions();
        BeanUtils.copyProperties(vO, bean);
        bean = ciSessionsRepository.save(bean);
        return bean.getSessionId();
    }

    public void delete(String id) {
        ciSessionsRepository.deleteById(id);
    }

    public void update(String id, CiSessionsUpdateVO vO) {
        CiSessions bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        ciSessionsRepository.save(bean);
    }

    public CiSessionsDTO getById(String id) {
        CiSessions original = requireOne(id);
        return toDTO(original);
    }

    public Page<CiSessionsDTO> query(CiSessionsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CiSessionsDTO toDTO(CiSessions original) {
        CiSessionsDTO bean = new CiSessionsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CiSessions requireOne(String id) {
        return ciSessionsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
