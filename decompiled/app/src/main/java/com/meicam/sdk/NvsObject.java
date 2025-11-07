package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsObject {
    protected long m_internalObject = 0;
    private java.util.HashMap<java.lang.String, java.lang.Object> m_attachmentMap = new java.util.HashMap<>();

    public void setAttachment(java.lang.String str, java.lang.Object obj) {
        this.m_attachmentMap.put(str, obj);
    }

    public java.lang.Object getAttachment(java.lang.String str) {
        return this.m_attachmentMap.get(str);
    }

    protected void setInternalObject(long j_renamed) {
        this.m_internalObject = j_renamed;
    }

    protected long getInternalObject() {
        return this.m_internalObject;
    }
}
