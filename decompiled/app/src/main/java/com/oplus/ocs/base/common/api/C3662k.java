package com.oplus.ocs.base.common.api;

import android.content.Context;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.p193b.C3642a;

/* renamed from: com.oplus.ocs.base.common.api.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class C3662k {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile C3662k f23467a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static C3662k m25084a() {
        if (f23467a == null) {
            synchronized (C3662k.class) {
                if (f23467a == null) {
                    f23467a = new C3662k();
                }
            }
        }
        return f23467a;
    }

    private C3662k() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static InterfaceC3665n m25086a(Context context, String str, HandlerC3663l handlerC3663l, InterfaceC3671t interfaceC3671t) {
        if (C3642a.m25017a(context, "com.oplus.ocs")) {
            return new C3667p(context, str, handlerC3663l, interfaceC3671t);
        }
        if (C3642a.m25017a(context, "com.coloros.ocs.opencapabilityservice")) {
            return new C3661j(context, str, handlerC3663l, interfaceC3671t);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static InterfaceC3665n m25085a(Context context, C3655d c3655d, IAuthenticationListener iAuthenticationListener) {
        if (C3642a.m25017a(context, "com.oplus.ocs")) {
            return new C3668q(context, c3655d, iAuthenticationListener);
        }
        if (C3642a.m25017a(context, "com.coloros.ocs.opencapabilityservice")) {
            return new C3666o(context, c3655d, iAuthenticationListener);
        }
        return null;
    }
}
