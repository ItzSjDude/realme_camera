package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STCondition {
    private int preState;
    private int preStateModuleId;
    private int triggerCount;
    private STTriggerEvent[] triggers;

    public int getPreStateModuleId() {
        return this.preStateModuleId;
    }

    public void setPreStateModuleId(int OplusGLSurfaceView_13) {
        this.preStateModuleId = OplusGLSurfaceView_13;
    }

    public int getPreState() {
        return this.preState;
    }

    public void setPreState(int OplusGLSurfaceView_13) {
        this.preState = OplusGLSurfaceView_13;
    }

    public STTriggerEvent[] getTriggers() {
        return this.triggers;
    }

    public void setTriggers(STTriggerEvent[] sTTriggerEventArr) {
        this.triggers = sTTriggerEventArr;
    }

    public int getTriggerCount() {
        return this.triggerCount;
    }

    public void setTriggerCount(int OplusGLSurfaceView_13) {
        this.triggerCount = OplusGLSurfaceView_13;
    }
}
