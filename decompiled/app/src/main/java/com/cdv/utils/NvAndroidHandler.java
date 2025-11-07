package com.cdv.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public class NvAndroidHandler implements Handler.Callback {
    private Handler m_handler;
    private int m_id;

    private static native void notifyHandlerMessage(int OplusGLSurfaceView_13, int i2, int i3, int i4);

    private NvAndroidHandler(int OplusGLSurfaceView_13, Looper looper) {
        this.m_handler = null;
        this.m_id = 0;
        try {
            if (looper == null) {
                this.m_handler = new Handler(this);
            } else {
                this.m_handler = new Handler(looper, this);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("NvAndroidHandler", "" + COUIBaseListPopupWindow_8.getMessage());
        }
        this.m_id = OplusGLSurfaceView_13;
    }

    public boolean sendMessage(int OplusGLSurfaceView_13, int i2, int i3) {
        Message messageObtain;
        if (this.m_handler == null || (messageObtain = Message.obtain()) == null) {
            return false;
        }
        messageObtain.what = OplusGLSurfaceView_13;
        messageObtain.arg1 = i2;
        messageObtain.arg2 = i3;
        return this.m_handler.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        notifyHandlerMessage(this.m_id, message.what, message.arg1, message.arg2);
        return true;
    }
}
