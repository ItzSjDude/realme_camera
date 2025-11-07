package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public abstract class g_renamed<O_renamed extends com.oplus.ocs.base.common.api.a_renamed.c_renamed, R_renamed extends com.oplus.ocs.base.common.api.g_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    O_renamed f7548a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f7549b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.ocs.base.common.api.a_renamed<O_renamed> f7550c;
    private com.oplus.ocs.base.common.api.u_renamed d_renamed;
    private com.oplus.ocs.base.internal.a_renamed e_renamed;
    private boolean f_renamed;

    protected void checkAuthResult(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) {
    }

    protected java.lang.String getClientName() {
        return "";
    }

    public abstract int getVersion();

    public abstract boolean hasFeature(java.lang.String str);

    protected abstract void init();

    public g_renamed(android.content.Context context, com.oplus.ocs.base.common.api.a_renamed<O_renamed> aVar, com.oplus.ocs.base.internal.a_renamed aVar2) {
        this(context, aVar, null, aVar2, true);
    }

    public g_renamed(android.app.Activity activity, com.oplus.ocs.base.common.api.a_renamed<O_renamed> aVar, O_renamed o_renamed, com.oplus.ocs.base.internal.a_renamed aVar2) {
        this(activity, aVar, o_renamed, aVar2, true);
    }

    public g_renamed(android.content.Context context, com.oplus.ocs.base.common.api.a_renamed<O_renamed> aVar, O_renamed o_renamed, com.oplus.ocs.base.internal.a_renamed aVar2) {
        this(context, aVar, o_renamed, aVar2, true);
    }

    public g_renamed(android.content.Context context, com.oplus.ocs.base.common.api.a_renamed<O_renamed> aVar, O_renamed o_renamed, com.oplus.ocs.base.internal.a_renamed aVar2, boolean z_renamed) {
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(context, "Null context is_renamed not permitted.");
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(aVar, "Api must not be_renamed null.");
        this.f7549b = context;
        this.f7550c = aVar;
        this.f7548a = o_renamed;
        this.e_renamed = aVar2;
        this.f_renamed = z_renamed;
        if (this.f_renamed) {
            this.d_renamed = com.oplus.ocs.base.common.api.u_renamed.a_renamed(this.f7549b);
            this.d_renamed.a_renamed(this, this.e_renamed);
        } else {
            if (this.f7550c.c_renamed()) {
                return;
            }
            android.content.Context context2 = this.f7549b;
            new com.oplus.ocs.base.common.api.d_renamed(context2, context2.getPackageName(), getClientName(), 0, false, null).c_renamed();
        }
    }

    protected com.oplus.ocs.base.common.api.a_renamed<O_renamed> getApi() {
        return this.f7550c;
    }

    protected android.os.IBinder getRemoteService() {
        if (this.f_renamed) {
            return com.oplus.ocs.base.common.api.u_renamed.b_renamed(this);
        }
        return null;
    }

    protected boolean isConnected() {
        if (this.f_renamed) {
            return com.oplus.ocs.base.common.api.u_renamed.e_renamed(this);
        }
        return true;
    }

    protected void releaseClientKey() {
        if (this.f_renamed) {
            com.oplus.ocs.base.common.api.u_renamed.a_renamed(this.f7550c.b_renamed());
        }
    }

    protected int getRemoteVersion() {
        if (this.f_renamed) {
            return com.oplus.ocs.base.common.api.u_renamed.c_renamed(this);
        }
        return 0;
    }

    protected void checkCapability() {
        if (this.d_renamed != null) {
            com.oplus.ocs.base.common.api.u_renamed.a_renamed(this);
        }
    }

    protected void addThis2Cache() {
        if (this.f_renamed) {
            this.d_renamed.a_renamed(this, this.e_renamed);
        }
    }

    protected void disconnect() {
        if (this.f_renamed) {
            com.oplus.ocs.base.common.api.u_renamed uVar = this.d_renamed;
            com.oplus.ocs.base.common.api.a_renamed<O_renamed> aVar = this.f7550c;
            android.os.Message messageObtainMessage = uVar.f7588b.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = aVar;
            uVar.f7588b.sendMessage(messageObtainMessage);
        }
    }

    protected static boolean checkInternal(android.content.Context context) {
        return com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(context);
    }

    protected boolean checkExist() {
        return com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(this.f7549b, "com.coloros.ocs.opencapabilityservice") || com.oplus.ocs.base.b_renamed.a_renamed.a_renamed(this.f7549b, "com.oplus.ocs");
    }

    protected com.oplus.ocs.base.common.AuthResult getAuthResult() {
        if (this.f_renamed) {
            return com.oplus.ocs.base.common.api.u_renamed.d_renamed(this);
        }
        return null;
    }

    public R_renamed addOnConnectionSucceedListener(com.oplus.ocs.base.common.api.f_renamed fVar) {
        return (R_renamed) addOnConnectionSucceedListener(fVar, new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public R_renamed addOnConnectionFailedListener(com.oplus.ocs.base.common.api.e_renamed eVar) {
        return (R_renamed) addOnConnectionFailedListener(eVar, new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public R_renamed addOnConnectionSucceedListener(final com.oplus.ocs.base.common.api.f_renamed fVar, android.os.Handler handler) {
        if (this.f_renamed) {
            this.d_renamed.a_renamed(this, fVar, handler);
        } else if (fVar != null) {
            if (handler == null) {
                fVar.a_renamed();
            } else {
                handler.post(new java.lang.Runnable() { // from class: com.oplus.ocs.base.common.api.g_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.a_renamed();
                    }
                });
            }
        }
        return this;
    }

    public R_renamed addOnConnectionFailedListener(com.oplus.ocs.base.common.api.e_renamed eVar, android.os.Handler handler) {
        if (this.f_renamed) {
            com.oplus.ocs.base.common.api.u_renamed.a_renamed(this, eVar, handler);
        }
        return this;
    }

    protected <TResult> com.oplus.ocs.base.a_renamed.a_renamed<TResult> doRegisterListener(com.oplus.ocs.base.common.api.i_renamed.b_renamed<TResult> bVar, com.oplus.ocs.base.common.api.i_renamed.a_renamed<TResult> aVar) {
        return doRegisterListener(android.os.Looper.getMainLooper(), bVar, aVar);
    }

    protected <TResult> com.oplus.ocs.base.a_renamed.a_renamed<TResult> doRegisterListener(android.os.Looper looper, com.oplus.ocs.base.common.api.i_renamed.b_renamed<TResult> bVar, com.oplus.ocs.base.common.api.i_renamed.a_renamed<TResult> aVar) {
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed("capability doRegisterListener");
        com.oplus.ocs.base.a_renamed.b_renamed bVar2 = new com.oplus.ocs.base.a_renamed.b_renamed();
        com.oplus.ocs.base.common.api.i_renamed iVar = new com.oplus.ocs.base.common.api.i_renamed(looper, bVar2, bVar, aVar);
        if (this.f_renamed) {
            com.oplus.ocs.base.common.api.u_renamed.a_renamed(this, iVar);
        }
        return bVar2;
    }
}
