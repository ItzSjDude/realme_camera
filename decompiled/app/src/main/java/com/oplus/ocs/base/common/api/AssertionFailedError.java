package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public abstract class b_renamed<T_renamed extends android.os.IBinder> implements com.oplus.ocs.base.common.api.a_renamed.e_renamed, com.oplus.ocs.base.common.api.t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final java.lang.String f7537a = "b_renamed";

    /* renamed from: c_renamed, reason: collision with root package name */
    com.oplus.ocs.base.common.CapabilityInfo f7539c;
    com.oplus.ocs.base.common.api.s_renamed e_renamed;
    com.oplus.ocs.base.common.api.r_renamed f_renamed;
    com.oplus.ocs.base.common.api.n_renamed h_renamed;
    private android.content.Context i_renamed;
    private android.os.Looper j_renamed;
    private com.oplus.ocs.base.common.api.l_renamed k_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    volatile int f7538b = 4;
    java.util.Queue<com.oplus.ocs.base.common.api.i_renamed> d_renamed = new java.util.LinkedList();
    com.oplus.ocs.base.common.api.m_renamed g_renamed = null;

    public abstract java.lang.String getClientName();

    protected b_renamed(android.content.Context context, android.os.Looper looper) {
        if (context != null) {
            this.i_renamed = context;
            if (looper != null) {
                this.j_renamed = looper;
                this.k_renamed = com.oplus.ocs.base.common.api.l_renamed.a_renamed(this);
                com.oplus.ocs.base.common.api.k_renamed.a_renamed();
                this.h_renamed = com.oplus.ocs.base.common.api.k_renamed.a_renamed(this.i_renamed, getClientName(), this.k_renamed, this);
                return;
            }
            throw new java.lang.NullPointerException("Looper must not be_renamed null");
        }
        throw new java.lang.NullPointerException("null reference");
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public void connect() {
        com.oplus.ocs.base.common.api.n_renamed nVar = this.h_renamed;
        if (nVar != null) {
            nVar.a_renamed();
            return;
        }
        this.f7539c = b_renamed(3);
        a_renamed(3);
        com.oplus.ocs.base.common.api.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.a_renamed();
        }
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public void disconnect() {
        this.h_renamed.c_renamed();
    }

    private void a_renamed() {
        if (!isConnected()) {
            throw new java.lang.IllegalStateException("Not connected. Call connect() and wait for onConnected() to be_renamed called.");
        }
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public T_renamed getRemoteService() {
        a_renamed();
        return (T_renamed) this.f7539c.getBinder();
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public int getMinApkVersion() {
        a_renamed();
        return this.f7539c.getVersion();
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public com.oplus.ocs.base.common.AuthResult getAuthResult() {
        return this.f7539c.getAuthResult();
    }

    final void a_renamed(android.os.Handler handler) {
        com.oplus.ocs.base.common.api.m_renamed mVar = this.g_renamed;
        if (mVar == null) {
            if (handler == null) {
                this.g_renamed = new com.oplus.ocs.base.common.api.m_renamed(this.j_renamed, this.k_renamed);
                return;
            } else {
                this.g_renamed = new com.oplus.ocs.base.common.api.m_renamed(handler.getLooper(), this.k_renamed);
                return;
            }
        }
        if (handler == null || mVar.getLooper() == handler.getLooper()) {
            return;
        }
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(f7537a, "the new handler looper is_renamed not the same as_renamed the old one.");
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public void setOnConnectionSucceedListener(final com.oplus.ocs.base.common.api.f_renamed fVar, android.os.Handler handler) {
        com.oplus.ocs.base.common.CapabilityInfo capabilityInfo = this.f7539c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.f7539c.getAuthResult().getErrrorCode() != 1001) {
            a_renamed(handler);
            this.g_renamed.f7569a = fVar;
        } else if (fVar != null) {
            if (handler == null) {
                fVar.a_renamed();
            } else {
                handler.post(new java.lang.Runnable() { // from class: com.oplus.ocs.base.common.api.b_renamed.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        fVar.a_renamed();
                    }
                });
            }
        }
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public void setOnConnectionFailedListener(com.oplus.ocs.base.common.api.e_renamed eVar, android.os.Handler handler) {
        com.oplus.ocs.base.common.CapabilityInfo capabilityInfo = this.f7539c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.f7539c.getAuthResult().getErrrorCode() == 1001) {
            a_renamed(handler);
            this.g_renamed.f7570b = eVar;
        } else if (eVar != null) {
            eVar.a_renamed(new com.oplus.ocs.base.common.a_renamed(this.f7539c.getAuthResult().getErrrorCode()));
        }
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public void setOnClearListener(com.oplus.ocs.base.common.api.s_renamed sVar) {
        this.e_renamed = sVar;
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public void setOnCapabilityAuthListener(com.oplus.ocs.base.common.api.r_renamed rVar) {
        this.f_renamed = rVar;
    }

    public android.os.Looper getLooper() {
        return this.j_renamed;
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public boolean isConnected() {
        return this.f7538b == 1;
    }

    public boolean isConnecting() {
        return this.f7538b == 2;
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.e_renamed
    public <T_renamed> void addQueue(com.oplus.ocs.base.common.api.i_renamed<T_renamed> iVar) {
        if (isConnected()) {
            a_renamed(iVar);
            return;
        }
        if (this.f7538b == 13) {
            a_renamed(iVar, true);
        } else {
            a_renamed(iVar, false);
        }
    }

    private void a_renamed(com.oplus.ocs.base.common.api.i_renamed iVar, boolean z_renamed) {
        this.d_renamed.add(iVar);
        if (z_renamed) {
            connect();
        }
    }

    final void a_renamed(com.oplus.ocs.base.common.api.i_renamed iVar) {
        com.oplus.ocs.base.common.CapabilityInfo capabilityInfo = this.f7539c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null) {
            return;
        }
        if (this.f7539c.getAuthResult().getErrrorCode() == 1001) {
            iVar.a_renamed(0);
        } else {
            iVar.a_renamed(this.f7539c.getAuthResult().getErrrorCode());
        }
    }

    final void a_renamed(int i_renamed) {
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(f7537a, "handleAuthenticateFailure");
        if (this.g_renamed == null) {
            a_renamed((android.os.Handler) null);
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 101;
        messageObtain.arg1 = i_renamed;
        this.g_renamed.sendMessage(messageObtain);
    }

    static com.oplus.ocs.base.common.CapabilityInfo b_renamed(int i_renamed) {
        return new com.oplus.ocs.base.common.CapabilityInfo(new java.util.ArrayList(), 1, new com.oplus.ocs.base.common.AuthResult("", 0, 0, i_renamed, new byte[0]));
    }

    @Override // com.oplus.ocs.base.common.api.t_renamed
    public void onStateChange(int i_renamed) {
        this.f7538b = i_renamed;
    }
}
