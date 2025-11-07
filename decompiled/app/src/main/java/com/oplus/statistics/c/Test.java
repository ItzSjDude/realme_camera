package com.oplus.statistics.c_renamed;

/* compiled from: ProxyRecorder.java */
/* loaded from: classes2.dex */
public class d_renamed implements com.oplus.statistics.c_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.statistics.c_renamed.c_renamed f7678a;

    /* compiled from: ProxyRecorder.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static com.oplus.statistics.c_renamed.d_renamed f7679a = new com.oplus.statistics.c_renamed.d_renamed();
    }

    private d_renamed() {
    }

    public static com.oplus.statistics.c_renamed.d_renamed a_renamed() {
        return com.oplus.statistics.c_renamed.d_renamed.a_renamed.f7679a;
    }

    @Override // com.oplus.statistics.c_renamed.c_renamed
    public void a_renamed(android.content.Context context, com.oplus.statistics.b_renamed.m_renamed mVar) {
        a_renamed(context);
        this.f7678a.a_renamed(context, mVar);
    }

    private void a_renamed(android.content.Context context) {
        if (this.f7678a != null) {
            return;
        }
        if (com.oplus.statistics.f_renamed.g_renamed.b_renamed(context)) {
            this.f7678a = new com.oplus.statistics.c_renamed.b_renamed();
        } else {
            this.f7678a = new com.oplus.statistics.c_renamed.e_renamed();
        }
    }
}
