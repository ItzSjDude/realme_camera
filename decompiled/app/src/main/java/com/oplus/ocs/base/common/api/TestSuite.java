package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public class i_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7555a = com.oplus.ocs.base.common.api.i_renamed.class.getSimpleName();

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.os.Looper f7556b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.a_renamed.b_renamed<T_renamed> f7557c;
    private int d_renamed;
    private com.oplus.ocs.base.common.api.i_renamed.b_renamed<T_renamed> e_renamed;
    private com.oplus.ocs.base.common.api.i_renamed.a_renamed<T_renamed> f_renamed;
    private com.oplus.ocs.base.common.api.i_renamed<T_renamed>.c_renamed g_renamed;

    public interface a_renamed<T_renamed> {
        void a_renamed(com.oplus.ocs.base.a_renamed.b_renamed<T_renamed> bVar, int i_renamed, java.lang.String str);
    }

    public interface b_renamed<T_renamed> {
        void a_renamed(com.oplus.ocs.base.a_renamed.b_renamed<T_renamed> bVar);
    }

    public i_renamed(android.os.Looper looper, com.oplus.ocs.base.a_renamed.b_renamed<T_renamed> bVar, com.oplus.ocs.base.common.api.i_renamed.b_renamed<T_renamed> bVar2, com.oplus.ocs.base.common.api.i_renamed.a_renamed<T_renamed> aVar) {
        this.f7556b = looper;
        this.f7557c = bVar;
        this.e_renamed = bVar2;
        this.f_renamed = aVar;
        this.g_renamed = new com.oplus.ocs.base.common.api.i_renamed.c_renamed(this.f7556b);
    }

    public void a_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.d_renamed;
        this.g_renamed.sendMessage(messageObtain);
    }

    class c_renamed extends com.oplus.ocs.base.common.b_renamed {
        public c_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                com.oplus.ocs.base.common.api.i_renamed.a_renamed(com.oplus.ocs.base.common.api.i_renamed.this, message.arg1);
                return;
            }
            throw new java.lang.IllegalArgumentException();
        }
    }

    static /* synthetic */ void a_renamed(com.oplus.ocs.base.common.api.i_renamed iVar, int i_renamed) {
        if (i_renamed == 0) {
            com.oplus.ocs.base.common.api.i_renamed.b_renamed<T_renamed> bVar = iVar.e_renamed;
            if (bVar != null) {
                bVar.a_renamed(iVar.f7557c);
                return;
            }
            return;
        }
        com.oplus.ocs.base.common.api.i_renamed.a_renamed<T_renamed> aVar = iVar.f_renamed;
        if (aVar != null) {
            aVar.a_renamed(iVar.f7557c, i_renamed, com.oplus.ocs.base.common.a_renamed.a_renamed.a_renamed(i_renamed));
        }
    }
}
