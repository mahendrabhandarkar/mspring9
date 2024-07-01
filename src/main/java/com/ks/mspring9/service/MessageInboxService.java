package com.ks.mspring9.service;

import com.ks.mspring9.dto.MessageInboxDTO;
import com.ks.mspring9.entity.MessageInbox;
import com.ks.mspring9.repository.MessageInboxRepository;
import com.ks.mspring9.vo.MessageInboxQueryVO;
import com.ks.mspring9.vo.MessageInboxUpdateVO;
import com.ks.mspring9.vo.MessageInboxVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MessageInboxService {

    @Autowired
    private MessageInboxRepository messageInboxRepository;

    public Integer save(MessageInboxVO vO) {
        MessageInbox bean = new MessageInbox();
        BeanUtils.copyProperties(vO, bean);
        bean = messageInboxRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        messageInboxRepository.deleteById(id);
    }

    public void update(Integer id, MessageInboxUpdateVO vO) {
        MessageInbox bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        messageInboxRepository.save(bean);
    }

    public MessageInboxDTO getById(Integer id) {
        MessageInbox original = requireOne(id);
        return toDTO(original);
    }

    public Page<MessageInboxDTO> query(MessageInboxQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MessageInboxDTO toDTO(MessageInbox original) {
        MessageInboxDTO bean = new MessageInboxDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MessageInbox requireOne(Integer id) {
        return messageInboxRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
