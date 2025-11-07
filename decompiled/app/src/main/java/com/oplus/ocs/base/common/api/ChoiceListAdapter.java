package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public class v_renamed implements com.oplus.ocs.base.common.api.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7595a = "v_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.concurrent.locks.Lock f7596b = new java.util.concurrent.locks.ReentrantLock();

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.api.a_renamed f7597c;
    private com.oplus.ocs.base.common.api.a_renamed.e_renamed d_renamed;

    public v_renamed(android.content.Context context, com.oplus.ocs.base.common.api.a_renamed aVar, com.oplus.ocs.base.common.api.a_renamed.c_renamed cVar, com.oplus.ocs.base.internal.a_renamed aVar2) {
        this.f7597c = aVar;
        this.d_renamed = this.f7597c.a_renamed().buildClient(context, android.os.Looper.getMainLooper(), aVar2, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.concurrent.locks.Lock] */
    @Override // com.oplus.ocs.base.common.api.h_renamed
    public void a_renamed() {
        this.f7596b.lock();
        try {
            try {
                if (this.d_renamed != null) {
                    this.d_renamed.connect();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        } finally {
            this.f7596b.unlock();
        }
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public void b_renamed() {
        this.f7596b.lock();
        try {
            try {
                if (this.d_renamed != null && this.d_renamed.isConnected()) {
                    this.d_renamed.disconnect();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        } finally {
            this.f7596b.unlock();
        }
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public boolean c_renamed() {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            return eVar.isConnected();
        }
        return false;
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public android.os.IBinder d_renamed() {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            return eVar.getRemoteService();
        }
        return null;
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public <T_renamed> void a_renamed(com.oplus.ocs.base.common.api.i_renamed<T_renamed> iVar) {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            eVar.addQueue(iVar);
        }
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public int e_renamed() {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            return eVar.getMinApkVersion();
        }
        return 0;
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public com.oplus.ocs.base.common.AuthResult f_renamed() {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            return eVar.getAuthResult();
        }
        return null;
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public void a_renamed(com.oplus.ocs.base.common.api.f_renamed fVar, android.os.Handler handler) {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            eVar.setOnConnectionSucceedListener(fVar, handler);
        }
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public void a_renamed(com.oplus.ocs.base.common.api.e_renamed eVar, android.os.Handler handler) {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar2 = this.d_renamed;
        if (eVar2 != null) {
            eVar2.setOnConnectionFailedListener(eVar, handler);
        }
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public void a_renamed(com.oplus.ocs.base.common.api.s_renamed sVar) {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            eVar.setOnClearListener(sVar);
        }
    }

    @Override // com.oplus.ocs.base.common.api.h_renamed
    public void a_renamed(com.oplus.ocs.base.common.api.r_renamed rVar) {
        com.oplus.ocs.base.common.api.a_renamed.e_renamed eVar = this.d_renamed;
        if (eVar != null) {
            eVar.setOnCapabilityAuthListener(rVar);
        }
    }
}
