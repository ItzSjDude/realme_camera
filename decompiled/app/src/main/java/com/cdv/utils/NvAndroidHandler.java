package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidHandler implements android.os.Handler.Callback {
    private android.os.Handler m_handler;
    private int m_id;

    private static native void notifyHandlerMessage(int i_renamed, int i2, int i3, int i4);

    private NvAndroidHandler(int i_renamed, android.os.Looper looper) {
        this.m_handler = null;
        this.m_id = 0;
        try {
            if (looper == null) {
                this.m_handler = new android.os.Handler(this);
            } else {
                this.m_handler = new android.os.Handler(looper, this);
            }
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("NvAndroidHandler", "" + e_renamed.getMessage());
        }
        this.m_id = i_renamed;
    }

    public boolean sendMessage(int i_renamed, int i2, int i3) {
        android.os.Message messageObtain;
        if (this.m_handler == null || (messageObtain = android.os.Message.obtain()) == null) {
            return false;
        }
        messageObtain.what = i_renamed;
        messageObtain.arg1 = i2;
        messageObtain.arg2 = i3;
        return this.m_handler.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        notifyHandlerMessage(this.m_id, message.what, message.arg1, message.arg2);
        return true;
    }
}
