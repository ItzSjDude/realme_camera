package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STTriggerEvent {
    private boolean isAppear;
    private int moduleId;
    private long trigger;
    private int triggerType;

    public int getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(int i_renamed) {
        this.triggerType = i_renamed;
    }

    public long getTrigger() {
        return this.trigger;
    }

    public void setTrigger(long j_renamed) {
        this.trigger = j_renamed;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(int i_renamed) {
        this.moduleId = i_renamed;
    }

    public boolean isAppear() {
        return this.isAppear;
    }

    public void setAppear(boolean z_renamed) {
        this.isAppear = z_renamed;
    }
}
