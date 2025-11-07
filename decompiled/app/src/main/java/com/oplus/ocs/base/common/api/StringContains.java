package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
class j_renamed implements com.oplus.ocs.base.common.api.n_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.coloros.ocs.base.IServiceBroker f7561c;
    private android.content.Context d_renamed;
    private java.lang.String e_renamed;
    private com.oplus.ocs.base.common.api.l_renamed f_renamed;
    private com.oplus.ocs.base.common.api.t_renamed g_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7559a = com.oplus.ocs.base.common.api.j_renamed.class.getSimpleName();

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.api.j_renamed.a_renamed f7560b = null;
    private android.os.IBinder.DeathRecipient h_renamed = new android.os.IBinder.DeathRecipient() { // from class: com.oplus.ocs.base.common.api.j_renamed.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            android.os.IBinder iBinderAsBinder;
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(com.oplus.ocs.base.common.api.j_renamed.this.f7559a, "binderDied()");
            com.oplus.ocs.base.common.api.j_renamed.g_renamed(com.oplus.ocs.base.common.api.j_renamed.this);
            if (com.oplus.ocs.base.common.api.j_renamed.this.f7561c == null || (iBinderAsBinder = com.oplus.ocs.base.common.api.j_renamed.this.f7561c.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            iBinderAsBinder.unlinkToDeath(com.oplus.ocs.base.common.api.j_renamed.this.h_renamed, 0);
            com.oplus.ocs.base.common.api.j_renamed.this.f7561c = null;
        }
    };

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final boolean b_renamed() {
        return false;
    }

    static /* synthetic */ com.oplus.ocs.base.common.api.j_renamed.a_renamed g_renamed(com.oplus.ocs.base.common.api.j_renamed jVar) {
        jVar.f7560b = null;
        return null;
    }

    public j_renamed(android.content.Context context, java.lang.String str, com.oplus.ocs.base.common.api.l_renamed lVar, com.oplus.ocs.base.common.api.t_renamed tVar) {
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
            java.util.concurrent.Executors.newSingleThreadExecutor().execute(new java.lang.Runnable() { // from class: com.oplus.ocs.base.common.api.j_renamed.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.oplus.ocs.base.common.api.j_renamed.a_renamed(com.oplus.ocs.base.common.api.j_renamed.this);
                }
            });
        } else {
            byte b2 = 0;
            try {
                if (this.d_renamed.getApplicationContext() != null) {
                    this.f7560b = new com.oplus.ocs.base.common.api.j_renamed.a_renamed(this, b2);
                    android.content.Context applicationContext = this.d_renamed.getApplicationContext();
                    android.content.Intent intent = new android.content.Intent("com.coloros.opencapabilityservice");
                    intent.setComponent(new android.content.ComponentName("com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"));
                    boolean zBindService = applicationContext.bindService(intent, this.f7560b, 1);
                    com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(this.f7559a, "connect state ".concat(java.lang.String.valueOf(zBindService)));
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
                com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7559a, java.lang.String.format("out bind get an_renamed exception %s_renamed", e_renamed.getMessage()));
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed) {
        com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(this.f7559a, "errorCode ".concat(java.lang.String.valueOf(i_renamed)));
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i_renamed;
        this.f_renamed.sendMessage(messageObtain);
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void c_renamed() {
        if (this.f7560b == null || this.d_renamed.getApplicationContext() == null) {
            return;
        }
        try {
            this.d_renamed.getApplicationContext().unbindService(this.f7560b);
            this.f7561c = null;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7559a, java.lang.String.format("out unbind get an_renamed exception %s_renamed", e_renamed.getMessage()));
        }
    }

    @Override // com.oplus.ocs.base.common.api.n_renamed
    public final void d_renamed() {
        android.os.IBinder iBinderAsBinder;
        try {
            if (this.f7561c == null || (iBinderAsBinder = this.f7561c.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            this.f7561c.a_renamed(this.e_renamed, "1.0.11", new com.coloros.ocs.base.IAuthenticationListener.Stub() { // from class: com.oplus.ocs.base.common.api.a_renamed.3
                ParameterContainer_6() {
                }

                @Override // com.coloros.ocs.base.IAuthenticationListener
                public final void a_renamed(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) {
                    if (capabilityInfo == null) {
                        this.f7536a.a_renamed(7);
                    } else {
                        com.oplus.ocs.base.common.api.j_renamed.a_renamed(this.f7536a, capabilityInfo);
                    }
                }

                @Override // com.coloros.ocs.base.IAuthenticationListener
                public final void a_renamed(int i_renamed) {
                    this.f7536a.a_renamed(i_renamed);
                }
            });
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.ocs.base.b_renamed.b_renamed.d_renamed(this.f7559a, "the exception that service broker authenticates is_renamed" + e_renamed.getMessage());
            a_renamed(7);
        }
    }

    class a_renamed implements android.content.ServiceConnection {
        private a_renamed() {
        }

        /* synthetic */ a_renamed(com.oplus.ocs.base.common.api.j_renamed jVar, byte b2) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) throws android.os.RemoteException {
            com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(com.oplus.ocs.base.common.api.j_renamed.this.f7559a, "onServiceConnected");
            try {
                com.oplus.ocs.base.common.api.j_renamed.this.f7561c = com.coloros.ocs.base.IServiceBroker.Stub.a_renamed(iBinder);
                com.oplus.ocs.base.common.api.j_renamed.this.f7561c.asBinder().linkToDeath(com.oplus.ocs.base.common.api.j_renamed.this.h_renamed, 0);
                com.oplus.ocs.base.common.api.j_renamed.this.f_renamed.sendEmptyMessage(3);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            if (com.oplus.ocs.base.common.api.j_renamed.this.g_renamed != null) {
                com.oplus.ocs.base.common.api.j_renamed.this.g_renamed.onStateChange(13);
            }
            com.oplus.ocs.base.common.api.j_renamed.g_renamed(com.oplus.ocs.base.common.api.j_renamed.this);
            com.oplus.ocs.base.common.api.j_renamed.this.f7561c = null;
        }
    }

    static /* synthetic */ void a_renamed(final com.oplus.ocs.base.common.api.j_renamed jVar) {
        android.content.Context context = jVar.d_renamed;
        new com.oplus.ocs.base.common.api.d_renamed(context, context.getPackageName(), jVar.e_renamed, android.os.Process.myPid(), true, true, new com.oplus.ocs.base.IAuthenticationListener.Stub() { // from class: com.oplus.ocs.base.common.api.a_renamed.2
            XPanMode_2() {
            }

            @Override // com.oplus.ocs.base.IAuthenticationListener
            public final void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
                com.oplus.ocs.base.b_renamed.b_renamed.b_renamed(this.f7535a.f7559a, "handleAsyncAuthenticate, onSuccess");
                com.oplus.ocs.base.common.api.j_renamed.a_renamed(this.f7535a, capabilityInfo);
            }

            @Override // com.oplus.ocs.base.IAuthenticationListener
            public final void onFail(int i_renamed) throws android.os.RemoteException {
                com.oplus.ocs.base.b_renamed.b_renamed.c_renamed(this.f7535a.f7559a, "handleAsyncAuthenticate, onFailed errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
                this.f7535a.a_renamed(i_renamed);
            }
        }).b_renamed();
    }

    static /* synthetic */ void a_renamed(com.oplus.ocs.base.common.api.j_renamed jVar, com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = capabilityInfo;
        jVar.f_renamed.sendMessage(messageObtain);
    }
}
