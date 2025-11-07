package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
class o_renamed implements com.oplus.ocs.base.common.api.n_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f7573b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.ServiceConnection f7574c;
    private com.oplus.ocs.base.IAuthenticationListener d_renamed;
    private com.oplus.ocs.base.common.api.d_renamed e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7572a = com.oplus.ocs.base.common.api.o_renamed.class.getSimpleName();
    private com.coloros.ocs.base.IAuthenticationListener f_renamed = ;

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void d_renamed() {
    }

    static /* synthetic */ android.content.ServiceConnection d_renamed(com.oplus.ocs.base.common.api.o_renamed oVar) {
        oVar.f7574c = null;
        return null;
    }

    public o_renamed(android.content.Context context, com.oplus.ocs.base.common.api.d_renamed dVar, com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener) {
        this.f7573b = context;
        this.e_renamed = dVar;
        this.d_renamed = iAuthenticationListener;
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final boolean a_renamed() {
        boolean z_renamed;
        byte b2 = 0;
        try {
            if (this.f7573b.getApplicationContext() != null) {
                this.f7574c = new com.oplus.ocs.base.common.api.o_renamed.a_renamed(this, b2);
                android.content.Context applicationContext = this.f7573b.getApplicationContext();
                com.coloros.ocs.base.IAuthenticationListener iAuthenticationListener = this.f_renamed;
                android.content.Intent intentA = this.e_renamed.a_renamed("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService");
                if (iAuthenticationListener != null) {
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putBinder("internal_binder", iAuthenticationListener.asBinder());
                    intentA.putExtra("internal_bundle", bundle);
                }
                boolean zBindService = applicationContext.bindService(intentA, this.f7574c, 1);
                try {
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7572a, "connect state - ".concat(java.lang.String.valueOf(zBindService)));
                    if (zBindService || this.d_renamed == null) {
                        return zBindService;
                    }
                    this.d_renamed.onFail(3);
                    return zBindService;
                } catch (java.lang.Exception e_renamed) {
                    z_renamed = zBindService;
                    e_renamed = e_renamed;
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7572a, java.lang.String.format("in_renamed bind get an_renamed exception %s_renamed", e_renamed.getMessage()));
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
            if (this.f7573b.getApplicationContext() != null) {
                this.f7574c = new com.oplus.ocs.base.common.api.o_renamed.a_renamed(this, b2);
                zBindService = this.f7573b.getApplicationContext().bindService(this.e_renamed.b_renamed("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"), this.f7574c, 1);
                try {
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7572a, "connect stat state - ".concat(java.lang.String.valueOf(zBindService)));
                    if (zBindService || this.d_renamed == null) {
                        return zBindService;
                    }
                    this.d_renamed.onFail(3);
                    return zBindService;
                } catch (java.lang.Exception e_renamed) {
                    e_renamed = e_renamed;
                    com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7572a, java.lang.String.format("in_renamed bind get an_renamed exception %s_renamed", e_renamed.getMessage()));
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
        if (this.f7574c == null) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7572a, "mServiceConnectionImpl is_renamed null");
        } else if (this.f7573b.getApplicationContext() != null) {
            try {
                this.f7573b.getApplicationContext().unbindService(this.f7574c);
            } catch (java.lang.Exception e_renamed) {
                com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7572a, java.lang.String.format("in_renamed unbind get an_renamed exception %s_renamed", e_renamed.getMessage()));
            }
        }
    }

    class a_renamed implements android.content.ServiceConnection {
        private a_renamed() {
        }

        /* synthetic */ a_renamed(com.oplus.ocs.base.common.api.o_renamed oVar, byte b2) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                if (com.oplus.ocs.base.common.api.o_renamed.this.e_renamed != null) {
                    com.oplus.ocs.base.common.api.o_renamed.this.e_renamed.a_renamed();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(com.oplus.ocs.base.common.api.o_renamed.this.f7572a, "onServiceDisconnected()");
            com.oplus.ocs.base.common.api.o_renamed.d_renamed(com.oplus.ocs.base.common.api.o_renamed.this);
        }
    }
}
