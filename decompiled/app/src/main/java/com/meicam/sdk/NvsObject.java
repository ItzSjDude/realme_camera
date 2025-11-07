package com.meicam.sdk;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class NvsObject {
    protected long m_internalObject = 0;
    private HashMap<String, Object> m_attachmentMap = new HashMap<>();

    public void setAttachment(String str, Object obj) {
        this.m_attachmentMap.put(str, obj);
    }

    public Object getAttachment(String str) {
        return this.m_attachmentMap.get(str);
    }

    protected void setInternalObject(long OplusGLSurfaceView_15) {
        this.m_internalObject = OplusGLSurfaceView_15;
    }

    protected long getInternalObject() {
        return this.m_internalObject;
    }
}
