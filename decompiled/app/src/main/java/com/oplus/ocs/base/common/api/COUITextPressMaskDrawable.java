package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
class q_renamed implements com.oplus.ocs.base.common.api.n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7582a = com.oplus.ocs.base.common.api.q_renamed.class.getSimpleName();

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f7583b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.ServiceConnection f7584c;
    private com.oplus.ocs.base.IAuthenticationListener d_renamed;
    private com.oplus.ocs.base.common.api.d_renamed e_renamed;

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void d_renamed() {
    }

    static /* synthetic */ android.content.ServiceConnection c_renamed(com.oplus.ocs.base.common.api.q_renamed qVar) {
        qVar.f7584c = null;
        return null;
    }

    public q_renamed(android.content.Context context, com.oplus.ocs.base.common.api.d_renamed dVar, com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener) {
        this.f7583b = context;
        this.e_renamed = dVar;
        this.d_renamed = iAuthenticationListener;
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final boolean a_renamed() {
        boolean z_renamed;
        byte b2 = 0;
        try {
            if (this.f7583b.getApplicationContext() != null) {
                this.f7584c = new com.oplus.ocs.base.common.api.q_renamed.a_renamed(this, b2);
                android.content.Context applicationContext = this.f7583b.getApplicationContext();
                com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener = this.d_renamed;
                android.content.Intent intentA = this.e_renamed.a_renamed("com.oplus.ocs.openauthenticate", "com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService");
                if (iAuthenticationListener != null) {
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putBinder("internal_binder", iAuthenticationListener.asBinder());
                    intentA.putExtra("internal_bundle", bundle);
                }
                boolean zBindService = applicationContext.bindService(intentA, this.f7584c, 1);
                try {
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7582a, "connect state - ".concat(java.lang.String.valueOf(zBindService)));
                    if (zBindService) {
                        return zBindService;
                    }
                    if (this.d_renamed == null) {
                        return zBindService;
                    }
                    try {
                        this.d_renamed.onFail(3);
                        return zBindService;
                    } catch (java.lang.Exception unused) {
                        return zBindService;
                    }
                } catch (java.lang.Exception e_renamed) {
                    z_renamed = zBindService;
                    e_renamed = e_renamed;
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7582a, java.lang.String.format("in_renamed bind get an_renamed exception %s_renamed", e_renamed.getMessage()));
                    return z_renamed;
                }
            }
            if (this.d_renamed != null) {
                this.d_renamed.onFail(com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION);
            }
            return false;
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            z_renamed = false;
        }
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final boolean b_renamed() {
        boolean zBindService;
        byte b2 = 0;
        try {
            if (this.f7583b.getApplicationContext() != null) {
                this.f7584c = new com.oplus.ocs.base.common.api.q_renamed.a_renamed(this, b2);
                zBindService = this.f7583b.getApplicationContext().bindService(this.e_renamed.b_renamed("com.oplus.ocs.openauthenticate", "com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService"), this.f7584c, 1);
                try {
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7582a, "connect stat state - ".concat(java.lang.String.valueOf(zBindService)));
                    if (zBindService || this.d_renamed == null) {
                        return zBindService;
                    }
                    this.d_renamed.onFail(3);
                    return zBindService;
                } catch (java.lang.Exception e_renamed) {
                    e_renamed = e_renamed;
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7582a, java.lang.String.format("in_renamed bind get an_renamed exception %s_renamed", e_renamed.getMessage()));
                    return zBindService;
                }
            }
            if (this.d_renamed != null) {
                this.d_renamed.onFail(com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION);
            }
            return false;
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            zBindService = false;
        }
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void c_renamed() {
        if (this.f7584c == null) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7582a, "mServiceConnectionImpl is_renamed null");
        } else if (this.f7583b.getApplicationContext() != null) {
            try {
                this.f7583b.getApplicationContext().unbindService(this.f7584c);
            } catch (java.lang.Exception e_renamed) {
                com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7582a, java.lang.String.format("in_renamed unbind get an_renamed exception %s_renamed", e_renamed.getMessage()));
            }
        }
    }

    class a_renamed implements android.content.ServiceConnection {
        private a_renamed() {
        }

        /* synthetic */ a_renamed(com.oplus.ocs.base.common.api.q_renamed qVar, byte b2) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                if (com.oplus.ocs.base.common.api.q_renamed.this.e_renamed != null) {
                    com.oplus.ocs.base.common.api.q_renamed.this.e_renamed.a_renamed();
                }
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(com.oplus.ocs.base.common.api.q_renamed.this.f7582a, "onServiceDisconnected()");
            com.oplus.ocs.base.common.api.q_renamed.c_renamed(com.oplus.ocs.base.common.api.q_renamed.this);
        }
    }
}
