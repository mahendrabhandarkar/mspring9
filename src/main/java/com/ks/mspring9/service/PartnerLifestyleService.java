package com.ks.mspring9.service;

import com.ks.mspring9.dto.PartnerLifestyleDTO;
import com.ks.mspring9.entity.PartnerLifestyle;
import com.ks.mspring9.repository.PartnerLifestyleRepository;
import com.ks.mspring9.vo.PartnerLifestyleQueryVO;
import com.ks.mspring9.vo.PartnerLifestyleUpdateVO;
import com.ks.mspring9.vo.PartnerLifestyleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PartnerLifestyleService {

    @Autowired
    private PartnerLifestyleRepository partnerLifestyleRepository;

    public Integer save(PartnerLifestyleVO vO) {
        PartnerLifestyle bean = new PartnerLifestyle();
        BeanUtils.copyProperties(vO, bean);
        bean = partnerLifestyleRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        partnerLifestyleRepository.deleteById(id);
    }

    public void update(Integer id, PartnerLifestyleUpdateVO vO) {
        PartnerLifestyle bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        partnerLifestyleRepository.save(bean);
    }

    public PartnerLifestyleDTO getById(Integer id) {
        PartnerLifestyle original = requireOne(id);
        return toDTO(original);
    }

    public Page<PartnerLifestyleDTO> query(PartnerLifestyleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PartnerLifestyleDTO toDTO(PartnerLifestyle original) {
        PartnerLifestyleDTO bean = new PartnerLifestyleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PartnerLifestyle requireOne(Integer id) {
        return partnerLifestyleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
