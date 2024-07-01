package com.ks.mspring9.vo;

import jakarta.validation.constraints.NotNull;

public class WfQueueRoleProcessVO {
    private Long roleProcessId;
    private @NotNull Long roleId;
    private @NotNull Long processQueueNameId;
}
