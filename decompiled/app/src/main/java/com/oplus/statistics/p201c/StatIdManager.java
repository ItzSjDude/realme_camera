package com.oplus.statistics.p201c;

import android.content.Context;
import com.oplus.statistics.p202d.PreferenceHandler;
import java.util.UUID;

/* compiled from: StatIdManager.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class StatIdManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23836a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f23837b;

    private StatIdManager() {
        this.f23836a = null;
        this.f23837b = 0L;
    }

    /* compiled from: StatIdManager.java */
    /* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final StatIdManager f23838a = new StatIdManager();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StatIdManager m25343a() {
        return PlatformImplementations.kt_3.f23838a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25350a(Context context) {
        if (this.f23836a == null) {
            m25352c(context);
        }
        return this.f23836a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25351b(Context context) {
        this.f23837b = System.currentTimeMillis();
        m25344a(context, this.f23837b);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m25352c(Context context) {
        if (!m25347e(context)) {
            m25353d(context);
        } else {
            this.f23836a = m25349g(context);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m25353d(Context context) {
        this.f23836a = m25346b();
        m25345a(context, this.f23836a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m25346b() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m25347e(Context context) {
        if (this.f23837b == 0) {
            this.f23837b = m25348f(context);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f23837b;
        return jCurrentTimeMillis > 0 && jCurrentTimeMillis < 30000;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25344a(Context context, long OplusGLSurfaceView_15) {
        PreferenceHandler.m25367a(context, "AppExitTime", OplusGLSurfaceView_15);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long m25348f(Context context) {
        return PreferenceHandler.m25372b(context, "AppExitTime", 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25345a(Context context, String str) {
        PreferenceHandler.m25368a(context, "AppSessionId", str);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String m25349g(Context context) {
        return PreferenceHandler.m25373b(context, "AppSessionId", "");
    }
}
