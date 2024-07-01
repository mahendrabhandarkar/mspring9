package com.ks.mspring9.service;

import com.ks.mspring9.dto.FeedbackMessageDTO;
import com.ks.mspring9.entity.FeedbackMessage;
import com.ks.mspring9.repository.FeedbackMessageRepository;
import com.ks.mspring9.vo.FeedbackMessageQueryVO;
import com.ks.mspring9.vo.FeedbackMessageUpdateVO;
import com.ks.mspring9.vo.FeedbackMessageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FeedbackMessageService {

    @Autowired
    private FeedbackMessageRepository feedbackMessageRepository;

    public Integer save(FeedbackMessageVO vO) {
        FeedbackMessage bean = new FeedbackMessage();
        BeanUtils.copyProperties(vO, bean);
        bean = feedbackMessageRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        feedbackMessageRepository.deleteById(id);
    }

    public void update(Integer id, FeedbackMessageUpdateVO vO) {
        FeedbackMessage bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        feedbackMessageRepository.save(bean);
    }

    public FeedbackMessageDTO getById(Integer id) {
        FeedbackMessage original = requireOne(id);
        return toDTO(original);
    }

    public Page<FeedbackMessageDTO> query(FeedbackMessageQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private FeedbackMessageDTO toDTO(FeedbackMessage original) {
        FeedbackMessageDTO bean = new FeedbackMessageDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private FeedbackMessage requireOne(Integer id) {
        return feedbackMessageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
