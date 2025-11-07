package com.oplus.camera.perf;

import com.oplus.camera.CameraLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: CPURunningInfo.java */
/* renamed from: com.oplus.camera.perf.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CPURunningInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Class f15161a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object f15162b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Method f15163c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Method f15164d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Method f15165e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static Method f15166f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static Method f15167g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Method f15168h;

    /* renamed from: OplusGLSurfaceView_13 */
    private static boolean f15169i;

    /* renamed from: OplusGLSurfaceView_15 */
    private static boolean f15170j;

    /* renamed from: OplusGLSurfaceView_5 */
    private static boolean f15171k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f15172l;

    /* renamed from: OplusGLSurfaceView_6 */
    private long f15173m;

    /* renamed from: OplusGLSurfaceView_11 */
    private long f15174n;

    /* renamed from: o */
    private long f15175o;

    /* renamed from: p */
    private long f15176p;

    /* renamed from: q */
    private long f15177q;

    /* renamed from: r */
    private long f15178r;

    /* renamed from: s */
    private boolean f15179s;

    public CPURunningInfo() {
        m15178a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15178a() {
        this.f15172l = 0L;
        this.f15173m = 0L;
        this.f15174n = 0L;
        this.f15175o = 0L;
        this.f15176p = 0L;
        this.f15177q = 0L;
        this.f15178r = 0L;
        this.f15179s = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15181b() {
        if (f15170j || f15171k) {
            return;
        }
        try {
            f15161a = Class.forName("vendor.oplus.hardware.performance.V1_0.IPerformance");
            Method declaredMethod = f15161a.getDeclaredMethod("getService", new Class[0]);
            f15163c = f15161a.getDeclaredMethod("writeMonitorStatus", String.class);
            f15162b = declaredMethod.invoke(f15161a, new Object[0]);
            f15164d = f15161a.getDeclaredMethod("readRealTime", new Class[0]);
            f15165e = f15161a.getDeclaredMethod("readNormalizeRealTime", new Class[0]);
            f15166f = f15161a.getDeclaredMethod("readRunningTime", new Class[0]);
            f15167g = f15161a.getDeclaredMethod("readNormalizeRunningTime", new Class[0]);
            f15168h = f15161a.getDeclaredMethod("readTargetProcess", String.class);
            f15170j = true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("CPURunningInfo", "getPerfMgrFunc, class or function not found");
            f15170j = false;
            this.f15179s = false;
            f15171k = true;
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15180a(boolean z) {
        if (z == f15169i || !f15170j) {
            return;
        }
        try {
            Method method = f15163c;
            Object obj = f15162b;
            Object[] objArr = new Object[1];
            objArr[0] = z ? "1" : "0";
            Object objInvoke = method.invoke(obj, objArr);
            if (objInvoke != null && ((Integer) objInvoke).intValue() != 1) {
                CameraLog.m12967f("CPURunningInfo", "openMonitor, return false");
                return;
            }
            f15169i = z;
            CameraLog.m12959b("CPURunningInfo", "openMonitor, " + z);
            if (z) {
                return;
            }
            m15178a();
        } catch (IllegalAccessException | NullPointerException | InvocationTargetException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("CPURunningInfo", "openMonitor fail");
            COUIBaseListPopupWindow_8.printStackTrace();
            f15169i = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15182c() {
        if (f15170j && f15169i) {
            try {
                this.f15172l = m15177a((String) f15164d.invoke(f15162b, new Object[0]));
                this.f15173m = m15177a((String) f15165e.invoke(f15162b, new Object[0]));
                this.f15174n = m15177a((String) f15166f.invoke(f15162b, new Object[0]));
                this.f15175o = m15177a((String) f15167g.invoke(f15162b, new Object[0]));
                this.f15176p = m15177a((String) f15168h.invoke(f15162b, "0"));
                this.f15177q = m15177a((String) f15168h.invoke(f15162b, "1"));
                this.f15178r = m15177a((String) f15168h.invoke(f15162b, "2"));
            } catch (IllegalAccessException | NullPointerException | InvocationTargetException COUIBaseListPopupWindow_8) {
                this.f15179s = false;
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.f15179s = true;
            return;
        }
        CameraLog.m12959b("CPURunningInfo", "getCpuInfo, monitor closed");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private long m15177a(String str) {
        if (str.isEmpty()) {
            CameraLog.m12967f("CPURunningInfo", "trimNParse, empty");
            this.f15179s = false;
            return -1L;
        }
        if (str.endsWith("\OplusGLSurfaceView_11")) {
            try {
                return Long.parseLong(str.substring(0, str.length() - 1));
            } catch (NumberFormatException unused) {
                CameraLog.m12967f("CPURunningInfo", "trimNParse, number read error: " + str);
                this.f15179s = false;
                return -1L;
            }
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused2) {
            CameraLog.m12967f("CPURunningInfo", "trimNParse, number read error:" + str);
            this.f15179s = false;
            return -1L;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15179a(CPURunningInfo c2861a) {
        if (!this.f15179s || !c2861a.f15179s) {
            CameraLog.m12967f("CPURunningInfo", "minusOp, invalid value: " + this + ", " + c2861a);
            return;
        }
        this.f15172l -= c2861a.f15172l;
        this.f15173m -= c2861a.f15173m;
        this.f15174n -= c2861a.f15174n;
        this.f15175o -= c2861a.f15175o;
        this.f15176p -= c2861a.f15176p;
        this.f15177q -= c2861a.f15177q;
        this.f15178r -= c2861a.f15178r;
        if (this.f15172l < 0 || this.f15175o < 0 || this.f15174n < 0 || this.f15173m < 0 || this.f15176p < 0 || this.f15177q < 0 || this.f15178r < 0) {
            CameraLog.m12967f("CPURunningInfo", "minusOp, invalid res: " + this);
            this.f15179s = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m15183d() {
        return this.f15179s;
    }

    public String toString() {
        return "realTime: " + this.f15172l + ", normalizeRealTime: " + this.f15173m + ", runningTime: " + this.f15174n + ", normalizeRunningTime: " + this.f15175o + ", cameraTime: " + this.f15176p + ", cameraserverTime: " + this.f15177q + ", providerTime: " + this.f15178r;
    }
}
