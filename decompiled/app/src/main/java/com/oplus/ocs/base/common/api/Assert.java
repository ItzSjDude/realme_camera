package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public class a_renamed<O_renamed extends com.oplus.ocs.base.common.api.a_renamed.c_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a<?, O_renamed> f7532a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.api.a_renamed.f_renamed<?> f7533b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7534c;
    private boolean d_renamed;

    /* renamed from: com.oplus.ocs.base.common.api.a_renamed$a_renamed, reason: collision with other inner class name */
    public static abstract class AbstractC0143a<T_renamed extends com.oplus.ocs.base.common.api.a_renamed.e_renamed, O_renamed> extends com.oplus.ocs.base.common.api.a_renamed.d_renamed<T_renamed, O_renamed> {
        public abstract T_renamed buildClient(android.content.Context context, android.os.Looper looper, com.oplus.ocs.base.internal.a_renamed aVar, O_renamed o_renamed);
    }

    public static class b_renamed<C_renamed> {
    }

    public interface c_renamed {
    }

    public static abstract class d_renamed<T_renamed, O_renamed> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface e_renamed {
        <T_renamed> void addQueue(com.oplus.ocs.base.common.api.i_renamed<T_renamed> iVar);

        void connect();

        void disconnect();

        com.oplus.ocs.base.common.AuthResult getAuthResult();

        int getMinApkVersion();

        android.os.IBinder getRemoteService();

        boolean isConnected();

        void setOnCapabilityAuthListener(com.oplus.ocs.base.common.api.r_renamed rVar);

        void setOnClearListener(com.oplus.ocs.base.common.api.s_renamed sVar);

        void setOnConnectionFailedListener(com.oplus.ocs.base.common.api.e_renamed eVar, android.os.Handler handler);

        void setOnConnectionSucceedListener(com.oplus.ocs.base.common.api.f_renamed fVar, android.os.Handler handler);
    }

    public static class f_renamed<C_renamed extends com.oplus.ocs.base.common.api.a_renamed.e_renamed> extends com.oplus.ocs.base.common.api.a_renamed.b_renamed<C_renamed> {
    }

    public <C_renamed extends com.oplus.ocs.base.common.api.a_renamed.e_renamed> a_renamed(java.lang.String str, com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a<C_renamed, O_renamed> abstractC0143a, com.oplus.ocs.base.common.api.a_renamed.f_renamed<C_renamed> fVar) {
        this(str, abstractC0143a, fVar, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C_renamed extends com.oplus.ocs.base.common.api.a_renamed.e_renamed> a_renamed(java.lang.String str, com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a<C_renamed, O_renamed> abstractC0143a, com.oplus.ocs.base.common.api.a_renamed.f_renamed<C_renamed> fVar, boolean z_renamed) {
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(abstractC0143a, "can not construct whit the null AbstractClientBuilder");
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(fVar, "can not construct with the null ClientKey");
        this.f7534c = str;
        this.f7532a = abstractC0143a;
        this.f7533b = fVar;
        this.d_renamed = z_renamed;
    }

    public com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a<?, O_renamed> a_renamed() {
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(this.f7532a != null, "The ClientBuilder is_renamed null");
        return this.f7532a;
    }

    public com.oplus.ocs.base.common.api.a_renamed.f_renamed<?> b_renamed() {
        com.oplus.ocs.base.common.api.a_renamed.f_renamed<?> fVar = this.f7533b;
        if (fVar != null) {
            return fVar;
        }
        throw new java.lang.IllegalStateException("This API was constructed with null clientKey.");
    }

    public boolean c_renamed() {
        return this.d_renamed;
    }
}
