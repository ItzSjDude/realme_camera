package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
class l_renamed extends com.oplus.ocs.base.common.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static volatile int f7566a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f7567b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.api.b_renamed f7568c;

    static synchronized com.oplus.ocs.base.common.api.l_renamed a_renamed(com.oplus.ocs.base.common.api.b_renamed bVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("base_client_");
        int i_renamed = f7566a;
        f7566a = i_renamed + 1;
        sb.append(i_renamed);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(sb.toString());
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            return new com.oplus.ocs.base.common.api.l_renamed(handlerThread.getLooper(), bVar);
        }
        return new com.oplus.ocs.base.common.api.l_renamed(android.os.Looper.getMainLooper(), bVar);
    }

    private l_renamed(android.os.Looper looper, com.oplus.ocs.base.common.api.b_renamed bVar) {
        super(looper);
        this.f7567b = com.oplus.ocs.base.common.api.l_renamed.class.getSimpleName();
        this.f7568c = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        int i_renamed = message.what;
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(this.f7567b, "base client handler what ".concat(java.lang.String.valueOf(i_renamed)));
        if (i_renamed == 1) {
            com.oplus.ocs.base.common.api.b_renamed bVar = this.f7568c;
            com.oplus.ocs.base.common.CapabilityInfo capabilityInfo = (com.oplus.ocs.base.common.CapabilityInfo) message.obj;
            com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(com.oplus.ocs.base.common.api.b_renamed.f7537a, "onAuthenticateSucceed");
            bVar.f7538b = 1;
            bVar.f7539c = capabilityInfo;
            if (bVar.f_renamed != null) {
                bVar.f_renamed.a_renamed(capabilityInfo);
            }
            com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(com.oplus.ocs.base.common.api.b_renamed.f7537a, "handleAuthenticateSuccess");
            if (bVar.g_renamed == null) {
                bVar.a_renamed((android.os.Handler) null);
            }
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 100;
            bVar.g_renamed.sendMessage(messageObtain);
            bVar.disconnect();
            return;
        }
        if (i_renamed != 2) {
            if (i_renamed == 3) {
                this.f7568c.h_renamed.d_renamed();
                return;
            }
            if (i_renamed != 5) {
                return;
            }
            com.oplus.ocs.base.common.api.b_renamed bVar2 = this.f7568c;
            while (bVar2.d_renamed.size() > 0) {
                com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(com.oplus.ocs.base.common.api.b_renamed.f7537a, "handleQue");
                bVar2.a_renamed(bVar2.d_renamed.poll());
            }
            com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(com.oplus.ocs.base.common.api.b_renamed.f7537a, "task queue is_renamed end");
            return;
        }
        com.oplus.ocs.base.common.api.b_renamed bVar3 = this.f7568c;
        int i2 = message.arg1;
        bVar3.f7538b = 4;
        bVar3.disconnect();
        bVar3.f7539c = com.oplus.ocs.base.common.api.b_renamed.b_renamed(i2);
        if (bVar3.f_renamed != null) {
            bVar3.f_renamed.a_renamed(bVar3.f7539c);
        }
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(com.oplus.ocs.base.common.api.b_renamed.f7537a, "connect failed , error code is_renamed ".concat(java.lang.String.valueOf(i2)));
        bVar3.a_renamed(i2);
        if (bVar3.e_renamed != null) {
            bVar3.e_renamed.a_renamed();
        }
    }
}
