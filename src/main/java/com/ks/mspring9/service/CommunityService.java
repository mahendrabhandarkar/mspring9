package com.ks.mspring9.service;

import com.ks.mspring9.dto.CommunityDTO;
import com.ks.mspring9.entity.Community;
import com.ks.mspring9.repository.CommunityRepository;
import com.ks.mspring9.vo.CommunityQueryVO;
import com.ks.mspring9.vo.CommunityUpdateVO;
import com.ks.mspring9.vo.CommunityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public Integer save(CommunityVO vO) {
        Community bean = new Community();
        BeanUtils.copyProperties(vO, bean);
        bean = communityRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        communityRepository.deleteById(id);
    }

    public void update(Integer id, CommunityUpdateVO vO) {
        Community bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        communityRepository.save(bean);
    }

    public CommunityDTO getById(Integer id) {
        Community original = requireOne(id);
        return toDTO(original);
    }

    public Page<CommunityDTO> query(CommunityQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CommunityDTO toDTO(Community original) {
        CommunityDTO bean = new CommunityDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Community requireOne(Integer id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
