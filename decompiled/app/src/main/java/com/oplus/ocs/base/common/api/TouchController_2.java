package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
class m_renamed extends com.oplus.ocs.base.common.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    com.oplus.ocs.base.common.api.f_renamed f7569a;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.oplus.ocs.base.common.api.e_renamed f7570b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f7571c;
    private com.oplus.ocs.base.common.api.l_renamed d_renamed;

    m_renamed(android.os.Looper looper, com.oplus.ocs.base.common.api.l_renamed lVar) {
        super(looper);
        this.f7571c = com.oplus.ocs.base.common.api.m_renamed.class.getSimpleName();
        this.d_renamed = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        int i_renamed = message.what;
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(this.f7571c, "business handler what ".concat(java.lang.String.valueOf(i_renamed)));
        if (i_renamed == 100) {
            com.oplus.ocs.base.common.api.f_renamed fVar = this.f7569a;
            if (fVar != null) {
                fVar.a_renamed();
            }
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 5;
            this.d_renamed.sendMessage(messageObtain);
            return;
        }
        if (i_renamed != 101) {
            return;
        }
        int i2 = message.arg1;
        com.oplus.ocs.base.common.api.e_renamed eVar = this.f7570b;
        if (eVar != null) {
            eVar.a_renamed(new com.oplus.ocs.base.common.a_renamed(i2));
            return;
        }
        android.os.Message messageObtain2 = android.os.Message.obtain();
        messageObtain2.what = 5;
        this.d_renamed.sendMessage(messageObtain2);
    }
}
