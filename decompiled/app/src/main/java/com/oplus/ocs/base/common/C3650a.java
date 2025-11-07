package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import com.oplus.ocs.base.common.p194a.C3651a;
import com.oplus.ocs.base.p193b.C3646e;

/* renamed from: com.oplus.ocs.base.common.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class C3650a {

    /* renamed from: PlatformImplementations.kt_3 */
    private PendingIntent f23404a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23405b;

    public C3650a(int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_13, null);
    }

    protected C3650a(int OplusGLSurfaceView_13, PendingIntent pendingIntent) {
        this.f23405b = OplusGLSurfaceView_13;
        this.f23404a = pendingIntent;
    }

    public String toString() {
        return C3646e.m25033a(this).m25035a("statusCode", C3651a.m25036a(this.f23405b)).toString();
    }
}
