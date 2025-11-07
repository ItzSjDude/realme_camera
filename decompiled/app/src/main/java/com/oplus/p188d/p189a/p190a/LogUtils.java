package com.oplus.p188d.p189a.p190a;

import android.os.SystemProperties;
import android.util.Log;

/* compiled from: LogUtils.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class LogUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean f23308a = SystemProperties.getBoolean("persist.sys.assert.panic", false);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f23309b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int f23310c;

    static {
        if (f23308a) {
            f23310c = 3;
        } else {
            f23310c = 6;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24951a(String str, String str2) {
        m24950a(2, str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24952b(String str, String str2) {
        m24950a(3, str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m24953c(String str, String str2) {
        m24950a(5, str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m24954d(String str, String str2) {
        m24950a(6, str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24950a(int OplusGLSurfaceView_13, String str, String str2) {
        if (OplusGLSurfaceView_13 >= f23310c) {
            String str3 = "Download." + str;
            if (f23309b) {
                str2 = "[" + Thread.currentThread().getName() + "]" + str2;
            }
            if (OplusGLSurfaceView_13 == 2) {
                Log.v(str3, str2);
                return;
            }
            if (OplusGLSurfaceView_13 == 3) {
                Log.IntrinsicsJvm.kt_5(str3, str2);
                return;
            }
            if (OplusGLSurfaceView_13 == 4) {
                Log.OplusGLSurfaceView_13(str3, str2);
            } else if (OplusGLSurfaceView_13 == 5) {
                Log.w(str3, str2);
            } else {
                if (OplusGLSurfaceView_13 != 6) {
                    return;
                }
                Log.COUIBaseListPopupWindow_8(str3, str2);
            }
        }
    }
}
