package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsIconGenerator {
    private final java.lang.String TAG = "Meicam";
    private com.meicam.sdk.NvsIconGenerator.IconCallback m_iconCallback;
    private long m_iconGenerator;

    public interface IconCallback {
        void onIconReady(android.graphics.Bitmap bitmap, long j_renamed, long j2);
    }

    private native void nativeCancelTask(long j_renamed, long j2);

    private native void nativeClose(long j_renamed);

    private native long nativeGetIcon(long j_renamed, java.lang.String str, long j2, int i_renamed);

    private native android.graphics.Bitmap nativeGetIconFromCache(long j_renamed, java.lang.String str, long j2, int i_renamed);

    private native long nativeInit();

    public NvsIconGenerator() {
        this.m_iconGenerator = 0L;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_iconGenerator = nativeInit();
    }

    public void release() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return;
        }
        this.m_iconCallback = null;
        nativeClose(this.m_iconGenerator);
        this.m_iconGenerator = 0L;
    }

    public boolean isReleased() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_iconGenerator == 0;
    }

    public void setIconCallback(com.meicam.sdk.NvsIconGenerator.IconCallback iconCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_iconCallback = iconCallback;
    }

    public android.graphics.Bitmap getIconFromCache(java.lang.String str, long j_renamed, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIconFromCache(this.m_iconGenerator, str, j_renamed, i_renamed);
    }

    public long getIcon(java.lang.String str, long j_renamed, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return 0L;
        }
        return nativeGetIcon(this.m_iconGenerator, str, j_renamed, i_renamed);
    }

    public void cancelTask(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return;
        }
        nativeCancelTask(this.m_iconGenerator, j_renamed);
    }

    protected void notifyIconReady(android.graphics.Bitmap bitmap, long j_renamed, long j2) {
        com.meicam.sdk.NvsIconGenerator.IconCallback iconCallback = this.m_iconCallback;
        if (iconCallback != null) {
            iconCallback.onIconReady(bitmap, j_renamed, j2);
        }
    }
}
