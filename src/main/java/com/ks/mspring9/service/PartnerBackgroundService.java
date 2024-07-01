package com.ks.mspring9.service;

import com.ks.mspring9.dto.PartnerBackgroundDTO;
import com.ks.mspring9.entity.PartnerBackground;
import com.ks.mspring9.repository.PartnerBackgroundRepository;
import com.ks.mspring9.vo.PartnerBackgroundQueryVO;
import com.ks.mspring9.vo.PartnerBackgroundUpdateVO;
import com.ks.mspring9.vo.PartnerBackgroundVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PartnerBackgroundService {

    @Autowired
    private PartnerBackgroundRepository partnerBackgroundRepository;

    public Integer save(PartnerBackgroundVO vO) {
        PartnerBackground bean = new PartnerBackground();
        BeanUtils.copyProperties(vO, bean);
        bean = partnerBackgroundRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        partnerBackgroundRepository.deleteById(id);
    }

    public void update(Integer id, PartnerBackgroundUpdateVO vO) {
        PartnerBackground bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        partnerBackgroundRepository.save(bean);
    }

    public PartnerBackgroundDTO getById(Integer id) {
        PartnerBackground original = requireOne(id);
        return toDTO(original);
    }

    public Page<PartnerBackgroundDTO> query(PartnerBackgroundQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PartnerBackgroundDTO toDTO(PartnerBackground original) {
        PartnerBackgroundDTO bean = new PartnerBackgroundDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PartnerBackground requireOne(Integer id) {
        return partnerBackgroundRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
