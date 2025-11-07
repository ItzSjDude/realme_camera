package com.oplus.statistics.p204f;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TimeInfoUtil.java */
@SuppressLint({"SimpleDateFormat"})
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class TimeInfoUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25435a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25436a(long OplusGLSurfaceView_15) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(OplusGLSurfaceView_15));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m25437b() {
        return System.currentTimeMillis();
    }
}
