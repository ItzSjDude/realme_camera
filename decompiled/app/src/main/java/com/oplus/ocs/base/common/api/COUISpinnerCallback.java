package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
final class p_renamed implements com.oplus.ocs.base.common.api.n_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    com.oplus.ocs.base.IServiceBroker f7578c;
    android.content.Context d_renamed;
    java.lang.String e_renamed;
    com.oplus.ocs.base.common.api.l_renamed f_renamed;
    com.oplus.ocs.base.common.api.t_renamed g_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.lang.String f7576a = com.oplus.ocs.base.common.api.j_renamed.class.getSimpleName();

    /* renamed from: b_renamed, reason: collision with root package name */
    com.oplus.ocs.base.common.api.p_renamed.a_renamed f7577b = null;
    android.os.IBinder.DeathRecipient h_renamed = new android.os.IBinder.DeathRecipient() { // from class: com.oplus.ocs.base.common.api.p_renamed.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            android.os.IBinder iBinderAsBinder;
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(com.oplus.ocs.base.common.api.p_renamed.this.f7576a, "binderDied()");
            com.oplus.ocs.base.common.api.p_renamed pVar = com.oplus.ocs.base.common.api.p_renamed.this;
            pVar.f7577b = null;
            if (pVar.f7578c == null || (iBinderAsBinder = com.oplus.ocs.base.common.api.p_renamed.this.f7578c.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            iBinderAsBinder.unlinkToDeath(com.oplus.ocs.base.common.api.p_renamed.this.h_renamed, 0);
            com.oplus.ocs.base.common.api.p_renamed.this.f7578c = null;
        }
    };

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final boolean b_renamed() {
        return false;
    }

    public p_renamed(android.content.Context context, java.lang.String str, com.oplus.ocs.base.common.api.l_renamed lVar, com.oplus.ocs.base.common.api.t_renamed tVar) {
        this.d_renamed = context;
        this.e_renamed = str;
        this.f_renamed = lVar;
        this.g_renamed = tVar;
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final boolean a_renamed() {
        com.oplus.ocs.base.common.api.t_renamed tVar = this.g_renamed;
        if (tVar != null) {
            tVar.onStateChange(2);
        }
        if (com.oplus.ocs.base.b_renamed.a_renamed.b_renamed(this.d_renamed)) {
            java.util.concurrent.Executors.newSingleThreadExecutor().execute(new java.lang.Runnable() { // from class: com.oplus.ocs.base.common.api.p_renamed.1
                @Override // java.lang.Runnable
                public final void run() {
                    final com.oplus.ocs.base.common.api.p_renamed pVar = com.oplus.ocs.base.common.api.p_renamed.this;
                    new com.oplus.ocs.base.common.api.d_renamed(pVar.d_renamed, pVar.d_renamed.getPackageName(), pVar.e_renamed, android.os.Process.myPid(), true, true, new com.oplus.ocs.base.IAuthenticationListener.Stub() { // from class: com.oplus.ocs.base.common.api.g_renamed.2
                        @Override // com.oplus.ocs.base.IAuthenticationListener
                        public final void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
                            com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(pVar.f7576a, "handleAsyncAuthenticate, onSuccess");
                            com.oplus.ocs.base.common.api.p_renamed.a_renamed(pVar, capabilityInfo);
                        }

                        @Override // com.oplus.ocs.base.IAuthenticationListener
                        public final void onFail(int i_renamed) throws android.os.RemoteException {
                            com.oplus.ocs.base.b_renamed.b_renamed.c_renamed(pVar.f7576a, "handleAsyncAuthenticate, onFailed errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
                            pVar.a_renamed(i_renamed);
                        }
                    }).b_renamed();
                }
            });
        } else {
            byte b2 = 0;
            try {
                if (this.d_renamed.getApplicationContext() != null) {
                    this.f7577b = new com.oplus.ocs.base.common.api.p_renamed.a_renamed(this, b2);
                    android.content.Context applicationContext = this.d_renamed.getApplicationContext();
                    android.content.Intent intent = new android.content.Intent("com.oplus.ocs.openauthenticate");
                    intent.setComponent(new android.content.ComponentName("com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService"));
                    boolean zBindService = applicationContext.bindService(intent, this.f7577b, 1);
                    com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(this.f7576a, "connect state ".concat(java.lang.String.valueOf(zBindService)));
                    if (!zBindService) {
                        a_renamed(3);
                    }
                } else {
                    if (this.g_renamed != null) {
                        this.g_renamed.onStateChange(2);
                    }
                    a_renamed(com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION);
                }
            } catch (java.lang.Exception e_renamed) {
                com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7576a, java.lang.String.format("out bind get an_renamed exception %s_renamed", e_renamed.getMessage()));
            }
        }
        return true;
    }

    final void a_renamed(int i_renamed) {
        com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(this.f7576a, "errorCode ".concat(java.lang.String.valueOf(i_renamed)));
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i_renamed;
        this.f_renamed.sendMessage(messageObtain);
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void c_renamed() {
        if (this.f7577b == null || this.d_renamed.getApplicationContext() == null) {
            return;
        }
        try {
            this.d_renamed.getApplicationContext().unbindService(this.f7577b);
            this.f7578c = null;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7576a, java.lang.String.format("out unbind get an_renamed exception %s_renamed", e_renamed.getMessage()));
        }
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void d_renamed() {
        android.os.IBinder iBinderAsBinder;
        try {
            if (this.f7578c == null || (iBinderAsBinder = this.f7578c.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            this.f7578c.a_renamed(this.e_renamed, "1.0.11", new com.oplus.ocs.base.IAuthenticationListener.Stub() { // from class: com.oplus.ocs.base.common.api.g_renamed.3
                @Override // com.oplus.ocs.base.IAuthenticationListener
                public final void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) {
                    com.oplus.ocs.base.common.api.p_renamed.a_renamed(this.f7554a, capabilityInfo);
                }

                @Override // com.oplus.ocs.base.IAuthenticationListener
                public final void onFail(int i_renamed) {
                    this.f7554a.a_renamed(i_renamed);
                }
            });
        } catch (java.lang.Exception e_renamed) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7576a, "the exception that service broker authenticates is_renamed" + e_renamed.getMessage());
            a_renamed(7);
        }
    }

    class a_renamed implements android.content.ServiceConnection {
        private a_renamed() {
        }

        /* synthetic */ a_renamed(com.oplus.ocs.base.common.api.p_renamed pVar, byte b2) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) throws android.os.RemoteException {
            com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(com.oplus.ocs.base.common.api.p_renamed.this.f7576a, "new ocs onServiceConnected");
            try {
                com.oplus.ocs.base.common.api.p_renamed.this.f7578c = com.oplus.ocs.base.IServiceBroker.Stub.a_renamed(iBinder);
                com.oplus.ocs.base.common.api.p_renamed.this.f7578c.asBinder().linkToDeath(com.oplus.ocs.base.common.api.p_renamed.this.h_renamed, 0);
                com.oplus.ocs.base.common.api.p_renamed.this.f_renamed.sendEmptyMessage(3);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            if (com.oplus.ocs.base.common.api.p_renamed.this.g_renamed != null) {
                com.oplus.ocs.base.common.api.p_renamed.this.g_renamed.onStateChange(13);
            }
            com.oplus.ocs.base.common.api.p_renamed pVar = com.oplus.ocs.base.common.api.p_renamed.this;
            pVar.f7577b = null;
            pVar.f7578c = null;
        }
    }

    static /* synthetic */ void a_renamed(com.oplus.ocs.base.common.api.p_renamed pVar, com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = capabilityInfo;
        pVar.f_renamed.sendMessage(messageObtain);
    }
}
