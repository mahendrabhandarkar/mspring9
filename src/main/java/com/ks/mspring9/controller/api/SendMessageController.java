package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.SendMessageDTO;
import com.ks.mspring9.service.SendMessageService;
import com.ks.mspring9.vo.SendMessageQueryVO;
import com.ks.mspring9.vo.SendMessageUpdateVO;
import com.ks.mspring9.vo.SendMessageVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/sendMessage")
public class SendMessageController {

    @Autowired
    private SendMessageService sendMessageService;

    @PostMapping
    public String save(@Valid @RequestBody SendMessageVO vO) {
        return sendMessageService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        sendMessageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody SendMessageUpdateVO vO) {
        sendMessageService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SendMessageDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return sendMessageService.getById(id);
    }

    @GetMapping
    public Page<SendMessageDTO> query(@Valid SendMessageQueryVO vO) {
        return sendMessageService.query(vO);
    }
}
