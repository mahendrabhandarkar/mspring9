package com.ks.mspring9.service;

import com.ks.mspring9.dto.PartnerEduDTO;
import com.ks.mspring9.entity.PartnerEdu;
import com.ks.mspring9.repository.PartnerEduRepository;
import com.ks.mspring9.vo.PartnerEduQueryVO;
import com.ks.mspring9.vo.PartnerEduUpdateVO;
import com.ks.mspring9.vo.PartnerEduVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PartnerEduService {

    @Autowired
    private PartnerEduRepository partnerEduRepository;

    public Integer save(PartnerEduVO vO) {
        PartnerEdu bean = new PartnerEdu();
        BeanUtils.copyProperties(vO, bean);
        bean = partnerEduRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        partnerEduRepository.deleteById(id);
    }

    public void update(Integer id, PartnerEduUpdateVO vO) {
        PartnerEdu bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        partnerEduRepository.save(bean);
    }

    public PartnerEduDTO getById(Integer id) {
        PartnerEdu original = requireOne(id);
        return toDTO(original);
    }

    public Page<PartnerEduDTO> query(PartnerEduQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PartnerEduDTO toDTO(PartnerEdu original) {
        PartnerEduDTO bean = new PartnerEduDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PartnerEdu requireOne(Integer id) {
        return partnerEduRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
