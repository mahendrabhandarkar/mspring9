package com.ks.mspring9.vo;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class WfQueueNodeProcessMasterVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long nodeProcessId;
    private @NotNull Long nodeId;
    private @NotNull Long processQueueNameId;

    private @NotNull Long roleProcessId;
}
