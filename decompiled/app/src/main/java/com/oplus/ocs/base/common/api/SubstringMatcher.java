package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.ocs.base.common.api.k_renamed f7565a;

    public static com.oplus.ocs.base.common.api.k_renamed a_renamed() {
        if (f7565a == null) {
            synchronized (com.oplus.ocs.base.common.api.k_renamed.class) {
                if (f7565a == null) {
                    f7565a = new com.oplus.ocs.base.common.api.k_renamed();
                }
            }
        }
        return f7565a;
    }

    private k_renamed() {
    }

    public static com.oplus.ocs.base.common.api.n_renamed a_renamed(android.content.Context context, java.lang.String str, com.oplus.ocs.base.common.api.l_renamed lVar, com.oplus.ocs.base.common.api.t_renamed tVar) {
        if (com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(context, "com.oplus.ocs")) {
            return new com.oplus.ocs.base.common.api.p_renamed(context, str, lVar, tVar);
        }
        if (com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(context, "com.coloros.ocs.opencapabilityservice")) {
            return new com.oplus.ocs.base.common.api.j_renamed(context, str, lVar, tVar);
        }
        return null;
    }

    public static com.oplus.ocs.base.common.api.n_renamed a_renamed(android.content.Context context, com.oplus.ocs.base.common.api.d_renamed dVar, com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener) {
        if (com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(context, "com.oplus.ocs")) {
            return new com.oplus.ocs.base.common.api.q_renamed(context, dVar, iAuthenticationListener);
        }
        if (com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(context, "com.coloros.ocs.opencapabilityservice")) {
            return new com.oplus.ocs.base.common.api.o_renamed(context, dVar, iAuthenticationListener);
        }
        return null;
    }
}
