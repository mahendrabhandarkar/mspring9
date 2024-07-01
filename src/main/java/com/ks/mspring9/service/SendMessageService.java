package com.ks.mspring9.service;

import com.ks.mspring9.dto.SendMessageDTO;
import com.ks.mspring9.entity.SendMessage;
import com.ks.mspring9.repository.SendMessageRepository;
import com.ks.mspring9.vo.SendMessageQueryVO;
import com.ks.mspring9.vo.SendMessageUpdateVO;
import com.ks.mspring9.vo.SendMessageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SendMessageService {

    @Autowired
    private SendMessageRepository sendMessageRepository;

    public Integer save(SendMessageVO vO) {
        SendMessage bean = new SendMessage();
        BeanUtils.copyProperties(vO, bean);
        bean = sendMessageRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        sendMessageRepository.deleteById(id);
    }

    public void update(Integer id, SendMessageUpdateVO vO) {
        SendMessage bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sendMessageRepository.save(bean);
    }

    public SendMessageDTO getById(Integer id) {
        SendMessage original = requireOne(id);
        return toDTO(original);
    }

    public Page<SendMessageDTO> query(SendMessageQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SendMessageDTO toDTO(SendMessage original) {
        SendMessageDTO bean = new SendMessageDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SendMessage requireOne(Integer id) {
        return sendMessageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
