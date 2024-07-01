package com.ks.mspring9.service;

import com.ks.mspring9.dto.SubCommunityDTO;
import com.ks.mspring9.entity.SubCommunity;
import com.ks.mspring9.repository.SubCommunityRepository;
import com.ks.mspring9.vo.SubCommunityQueryVO;
import com.ks.mspring9.vo.SubCommunityUpdateVO;
import com.ks.mspring9.vo.SubCommunityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SubCommunityService {

    @Autowired
    private SubCommunityRepository subCommunityRepository;

    public Integer save(SubCommunityVO vO) {
        SubCommunity bean = new SubCommunity();
        BeanUtils.copyProperties(vO, bean);
        bean = subCommunityRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        subCommunityRepository.deleteById(id);
    }

    public void update(Integer id, SubCommunityUpdateVO vO) {
        SubCommunity bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        subCommunityRepository.save(bean);
    }

    public SubCommunityDTO getById(Integer id) {
        SubCommunity original = requireOne(id);
        return toDTO(original);
    }

    public Page<SubCommunityDTO> query(SubCommunityQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SubCommunityDTO toDTO(SubCommunity original) {
        SubCommunityDTO bean = new SubCommunityDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SubCommunity requireOne(Integer id) {
        return subCommunityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
