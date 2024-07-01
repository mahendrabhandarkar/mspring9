package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.MessageInboxDTO;
import com.ks.mspring9.service.MessageInboxService;
import com.ks.mspring9.vo.MessageInboxQueryVO;
import com.ks.mspring9.vo.MessageInboxUpdateVO;
import com.ks.mspring9.vo.MessageInboxVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/api/v1/messageInbox")
public class MessageInboxController {

    @Autowired
    private MessageInboxService messageInboxService;

    @PostMapping
    public String save(@Valid @RequestBody MessageInboxVO vO) {
        return messageInboxService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        messageInboxService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MessageInboxUpdateVO vO) {
        messageInboxService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MessageInboxDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return messageInboxService.getById(id);
    }

    @GetMapping
    public Page<MessageInboxDTO> query(@Valid MessageInboxQueryVO vO) {
        return messageInboxService.query(vO);
    }
}
