package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STCondition {
    private int preState;
    private int preStateModuleId;
    private int triggerCount;
    private com.sensetime.stmobile.model.STTriggerEvent[] triggers;

    public int getPreStateModuleId() {
        return this.preStateModuleId;
    }

    public void setPreStateModuleId(int i_renamed) {
        this.preStateModuleId = i_renamed;
    }

    public int getPreState() {
        return this.preState;
    }

    public void setPreState(int i_renamed) {
        this.preState = i_renamed;
    }

    public com.sensetime.stmobile.model.STTriggerEvent[] getTriggers() {
        return this.triggers;
    }

    public void setTriggers(com.sensetime.stmobile.model.STTriggerEvent[] sTTriggerEventArr) {
        this.triggers = sTTriggerEventArr;
    }

    public int getTriggerCount() {
        return this.triggerCount;
    }

    public void setTriggerCount(int i_renamed) {
        this.triggerCount = i_renamed;
    }
}
