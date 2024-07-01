package com.ks.mspring9.controller.api;

import com.ks.mspring9.dto.FeedbackMessageDTO;
import com.ks.mspring9.service.FeedbackMessageService;
import com.ks.mspring9.vo.FeedbackMessageQueryVO;
import com.ks.mspring9.vo.FeedbackMessageUpdateVO;
import com.ks.mspring9.vo.FeedbackMessageVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/feedbackMessage")
public class FeedbackMessageController {

    @Autowired
    private FeedbackMessageService feedbackMessageService;

    @PostMapping
    public String save(@Valid @RequestBody FeedbackMessageVO vO) {
        return feedbackMessageService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        feedbackMessageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody FeedbackMessageUpdateVO vO) {
        feedbackMessageService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FeedbackMessageDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return feedbackMessageService.getById(id);
    }

    @GetMapping
    public Page<FeedbackMessageDTO> query(@Valid FeedbackMessageQueryVO vO) {
        return feedbackMessageService.query(vO);
    }
}
