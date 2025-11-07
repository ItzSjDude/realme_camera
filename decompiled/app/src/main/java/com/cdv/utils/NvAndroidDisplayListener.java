package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidDisplayListener implements android.hardware.display.DisplayManager.DisplayListener {
    private int m_id;

    private static native void notifyDisplayChanged(int i_renamed, int i2);

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i_renamed) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i_renamed) {
    }

    private NvAndroidDisplayListener(int i_renamed) {
        this.m_id = 0;
        this.m_id = i_renamed;
    }

    public boolean Register(android.content.Context context) {
        java.lang.Object systemService;
        if (context == null || (systemService = context.getSystemService("display")) == null) {
            return false;
        }
        try {
            ((android.hardware.display.DisplayManager) systemService).registerDisplayListener(this, new android.os.Handler(android.os.Looper.getMainLooper()));
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("NvAndroidDisplayListener", "" + e_renamed.getMessage());
            return false;
        }
    }

    public void Unregister(android.content.Context context) {
        java.lang.Object systemService;
        if (context == null || (systemService = context.getSystemService("display")) == null) {
            return;
        }
        ((android.hardware.display.DisplayManager) systemService).unregisterDisplayListener(this);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i_renamed) {
        notifyDisplayChanged(this.m_id, i_renamed);
    }
}
