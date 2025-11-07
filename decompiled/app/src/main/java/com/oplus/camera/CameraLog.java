package com.oplus.camera;

import android.content.Context;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import android.util.LogPrinter;
import com.oplus.camera.sticker.p167c.PrefUtils;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.SystemPropertiesNative;
import com.oplus.compat.p187os.TraceNative;
import com.oplus.ocs.camera.CameraUnitClient;

/* compiled from: CameraLog.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class CameraLog {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Long f13212a = 1L;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f13213b = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f13214c = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String m12961c(String str) {
        return str == null ? "OplusCamera" : str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12951a(Context context) {
        try {
            f13213b = SystemPropertiesNative.getBoolean("persist.sys.assert.panic", false);
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        f13214c = PrefUtils.m16835e(context);
        CameraUnitClient.initLog(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12954a(String str, String str2) {
        if (f13213b) {
            Log.v(m12961c(str), str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12956a(String str, String str2, Throwable th) {
        if (f13213b) {
            Log.v(m12961c(str), str2, th);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m12959b(String str, String str2) {
        if (f13213b) {
            Log.IntrinsicsJvm.kt_5(m12961c(str), str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m12962c(String str, String str2) {
        if (f13213b) {
            Log.OplusGLSurfaceView_13(m12961c(str), str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m12960b(String str, String str2, Throwable th) {
        if (f13213b) {
            Log.OplusGLSurfaceView_13(m12961c(str), str2, th);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12952a(String str) {
        if (f13214c) {
            m12954a("OplusCamera_TRACE", "traceBeginSection, msg: " + str);
            try {
                TraceNative.traceBegin(f13212a.longValue(), str);
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (Throwable unused) {
                m12967f("OplusCamera", "reflect error");
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12955a(String str, String str2, long OplusGLSurfaceView_15) {
        if (f13214c) {
            m12954a("OplusCamera_TRACE", "traceBeginSection, msg: " + str);
            try {
                String str3 = "O_" + str2;
                if (OplusGLSurfaceView_15 == 0) {
                    OplusGLSurfaceView_15 = CameraConstant.f13119d.longValue();
                }
                Trace.setCounter(str3, OplusGLSurfaceView_15);
                TraceNative.traceBegin(f13212a.longValue(), str);
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (Throwable unused) {
                m12967f("OplusCamera", "reflect error");
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m12958b(String str) {
        if (f13214c) {
            m12954a("OplusCamera_TRACE", "traceEndSection, msg: " + str);
            try {
                TraceNative.traceEnd(f13212a.longValue());
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (Throwable unused) {
                m12967f("OplusCamera", "reflect error");
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m12964d(String str, String str2) {
        if (f13214c) {
            m12954a("OplusCamera_TRACE", "traceEndSection, msg: " + str);
            try {
                Trace.setCounter("O_" + str2, CameraConstant.f13121f.longValue());
                TraceNative.traceEnd(f13212a.longValue());
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (Throwable unused) {
                m12967f("OplusCamera", "reflect error");
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12953a(String str, Handler handler, String str2) {
        if (f13213b) {
            if (handler == null) {
                Log.COUIBaseListPopupWindow_8(m12961c(str), "dumpHandlerMsg, handler is null!");
            } else {
                handler.dump(new LogPrinter(6, "handler info"), str2);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m12966e(String str, String str2) {
        Log.w(m12961c(str), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m12963c(String str, String str2, Throwable th) {
        Log.w(m12961c(str), str2, th);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m12967f(String str, String str2) {
        Log.COUIBaseListPopupWindow_8(m12961c(str), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m12965d(String str, String str2, Throwable th) {
        Log.COUIBaseListPopupWindow_8(m12961c(str), str2, th);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m12957a() {
        return f13213b;
    }
}
