package com.oplus.camera.p154m;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.util.Util;

/* compiled from: MemoryMonitor.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_6.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class MemoryMonitor {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f14708b;

    /* renamed from: PlatformImplementations.kt_3 */
    private Runtime f14707a = Runtime.getRuntime();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f14709c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f14710d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f14711e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f14712f = null;

    public MemoryMonitor() {
        this.f14708b = 0L;
        this.f14708b = this.f14707a.maxMemory();
        CameraLog.m12954a("MemoryMonitor", "MemoryMonitor, mMaxMemory: " + this.f14708b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14699a(long OplusGLSurfaceView_15) {
        String str;
        if (this.f14709c == 0 || (str = this.f14712f) == null || !str.equals(Storage.f12095u)) {
            this.f14709c = Storage.m11129c(Storage.f12095u) - 50000000;
            this.f14710d = 0L;
            this.f14711e = true;
            this.f14712f = Storage.f12095u;
        }
        this.f14710d += OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14700a(Activity activity, long OplusGLSurfaceView_15) {
        boolean z;
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo;
        long jFreeMemory = this.f14708b - (this.f14707a.totalMemory() - this.f14707a.freeMemory());
        if (jFreeMemory <= OplusGLSurfaceView_15) {
            CameraLog.m12966e("MemoryMonitor", "checkMemoryAndStorage, realfree(" + jFreeMemory + ") <= minLeftMemory(" + OplusGLSurfaceView_15 + ")");
            z = false;
        } else {
            z = true;
        }
        if (z && activity != null) {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo2);
            if (memoryInfo2.availMem <= memoryInfo2.threshold) {
                CameraLog.m12966e("MemoryMonitor", "checkMemoryAndStorage, availMem(" + memoryInfo2.availMem + ") <= threshold(" + memoryInfo2.threshold + ")");
                z = false;
            }
            if (Util.m24342ae() && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0 && (memoryInfo = processMemoryInfo[0]) != null) {
                CameraLog.m12954a("MemoryMonitor", "checkMemoryAndStorage, totalPss: " + memoryInfo.getTotalPss() + ", dalvikPss: " + memoryInfo.dalvikPss + ", nativePss: " + memoryInfo.nativePss + ", otherPss: " + memoryInfo.otherPss);
            }
        }
        String str = this.f14712f;
        if (str != null && !str.equals(Storage.f12095u)) {
            m14699a(0L);
        }
        if (this.f14711e && this.f14710d >= this.f14709c) {
            CameraLog.m12966e("MemoryMonitor", "mLeftStorage(" + this.f14709c + ") <= mUsedStorage(" + this.f14710d + ")");
        }
        return z;
    }
}
