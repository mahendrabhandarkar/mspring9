package com.ks.mspring9.service;

import com.ks.mspring9.dto.CountriesDTO;
import com.ks.mspring9.entity.Countries;
import com.ks.mspring9.repository.CountriesRepository;
import com.ks.mspring9.vo.CountriesQueryVO;
import com.ks.mspring9.vo.CountriesUpdateVO;
import com.ks.mspring9.vo.CountriesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CountriesService {

    @Autowired
    private CountriesRepository countriesRepository;

    public Integer save(CountriesVO vO) {
        Countries bean = new Countries();
        BeanUtils.copyProperties(vO, bean);
        bean = countriesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        countriesRepository.deleteById(id);
    }

    public void update(Integer id, CountriesUpdateVO vO) {
        Countries bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        countriesRepository.save(bean);
    }

    public CountriesDTO getById(Integer id) {
        Countries original = requireOne(id);
        return toDTO(original);
    }

    public Page<CountriesDTO> query(CountriesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CountriesDTO toDTO(Countries original) {
        CountriesDTO bean = new CountriesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Countries requireOne(Integer id) {
        return countriesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
