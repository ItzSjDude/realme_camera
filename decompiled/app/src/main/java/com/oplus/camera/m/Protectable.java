package com.oplus.camera.m_renamed;

/* compiled from: MemoryMonitor.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f4881b;

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Runtime f4880a = java.lang.Runtime.getRuntime();

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f4882c = 0;
    private long d_renamed = 0;
    private boolean e_renamed = false;
    private java.lang.String f_renamed = null;

    public c_renamed() {
        this.f4881b = 0L;
        this.f4881b = this.f4880a.maxMemory();
        com.oplus.camera.e_renamed.a_renamed("MemoryMonitor", "MemoryMonitor, mMaxMemory: " + this.f4881b);
    }

    public void a_renamed(long j_renamed) {
        java.lang.String str;
        if (this.f4882c == 0 || (str = this.f_renamed) == null || !str.equals(com.oplus.camera.Storage.u_renamed)) {
            this.f4882c = com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage.u_renamed) - 50000000;
            this.d_renamed = 0L;
            this.e_renamed = true;
            this.f_renamed = com.oplus.camera.Storage.u_renamed;
        }
        this.d_renamed += j_renamed;
    }

    public boolean a_renamed(android.app.Activity activity, long j_renamed) {
        boolean z_renamed;
        android.os.Debug.MemoryInfo[] processMemoryInfo;
        android.os.Debug.MemoryInfo memoryInfo;
        long jFreeMemory = this.f4881b - (this.f4880a.totalMemory() - this.f4880a.freeMemory());
        if (jFreeMemory <= j_renamed) {
            com.oplus.camera.e_renamed.e_renamed("MemoryMonitor", "checkMemoryAndStorage, realfree(" + jFreeMemory + ") <= minLeftMemory(" + j_renamed + ")");
            z_renamed = false;
        } else {
            z_renamed = true;
        }
        if (z_renamed && activity != null) {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) activity.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo2 = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo2);
            if (memoryInfo2.availMem <= memoryInfo2.threshold) {
                com.oplus.camera.e_renamed.e_renamed("MemoryMonitor", "checkMemoryAndStorage, availMem(" + memoryInfo2.availMem + ") <= threshold(" + memoryInfo2.threshold + ")");
                z_renamed = false;
            }
            if (com.oplus.camera.util.Util.ae_renamed() && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{android.os.Process.myPid()})) != null && processMemoryInfo.length > 0 && (memoryInfo = processMemoryInfo[0]) != null) {
                com.oplus.camera.e_renamed.a_renamed("MemoryMonitor", "checkMemoryAndStorage, totalPss: " + memoryInfo.getTotalPss() + ", dalvikPss: " + memoryInfo.dalvikPss + ", nativePss: " + memoryInfo.nativePss + ", otherPss: " + memoryInfo.otherPss);
            }
        }
        java.lang.String str = this.f_renamed;
        if (str != null && !str.equals(com.oplus.camera.Storage.u_renamed)) {
            a_renamed(0L);
        }
        if (this.e_renamed && this.d_renamed >= this.f4882c) {
            com.oplus.camera.e_renamed.e_renamed("MemoryMonitor", "mLeftStorage(" + this.f4882c + ") <= mUsedStorage(" + this.d_renamed + ")");
        }
        return z_renamed;
    }
}
