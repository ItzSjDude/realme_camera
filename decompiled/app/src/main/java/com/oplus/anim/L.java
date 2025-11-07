package com.oplus.anim;

import android.util.Log;
import androidx.core.p032d.TraceCompat;
import com.oplus.anim.p121f.OplusLog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: L.java */
/* renamed from: com.oplus.anim.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class L {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String[] f10445c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static long[] f10446d;

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Set<String> f10443a = new HashSet();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f10444b = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f10447e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static int f10448f = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9347a(String str) {
        if (OplusLog.f10385a) {
            Log.IntrinsicsJvm.kt_5("EffectiveAnimation", str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m9348b(String str) {
        if (f10443a.contains(str)) {
            return;
        }
        Log.w("EffectiveAnimation", str);
        f10443a.add(str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m9349c(String str) {
        if (f10444b) {
            int OplusGLSurfaceView_13 = f10447e;
            if (OplusGLSurfaceView_13 == 20) {
                f10448f++;
                return;
            }
            f10445c[OplusGLSurfaceView_13] = str;
            f10446d[OplusGLSurfaceView_13] = System.nanoTime();
            TraceCompat.m2449a(str);
            f10447e++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static float m9350d(String str) {
        int OplusGLSurfaceView_13 = f10448f;
        if (OplusGLSurfaceView_13 > 0) {
            f10448f = OplusGLSurfaceView_13 - 1;
            return 0.0f;
        }
        if (!f10444b) {
            return 0.0f;
        }
        f10447e--;
        int i2 = f10447e;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(f10445c[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f10445c[f10447e] + ".");
        }
        TraceCompat.m2448a();
        return (System.nanoTime() - f10446d[f10447e]) / 1000000.0f;
    }
}
