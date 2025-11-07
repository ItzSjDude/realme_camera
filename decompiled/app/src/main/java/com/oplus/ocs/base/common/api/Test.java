package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
public class d_renamed implements android.os.Handler.Callback {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7544a = "d_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f7545b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7546c;
    private java.lang.String d_renamed;
    private int e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private com.oplus.ocs.base.IAuthenticationListener h_renamed;
    private android.os.Handler i_renamed;
    private com.oplus.ocs.base.common.api.n_renamed j_renamed;

    public d_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed, com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener) {
        this(context, str, str2, i_renamed, z_renamed, false, iAuthenticationListener);
    }

    public d_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed, boolean z2, com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener) {
        this.f_renamed = false;
        this.f7545b = context.getApplicationContext();
        this.h_renamed = iAuthenticationListener;
        this.d_renamed = str;
        this.f7546c = str2;
        this.e_renamed = i_renamed;
        this.f_renamed = z_renamed;
        this.g_renamed = z2;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("internal");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.i_renamed = new android.os.Handler(handlerThread.getLooper(), this);
        } else {
            this.i_renamed = new android.os.Handler(this);
        }
        com.oplus.ocs.base.common.api.k_renamed.a_renamed();
        this.j_renamed = com.oplus.ocs.base.common.api.k_renamed.a_renamed(this.f7545b, this, this.h_renamed);
    }

    android.content.Intent a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent(str);
        intent.setComponent(new android.content.ComponentName(str2, str3));
        intent.putExtra("bind_type", 1);
        intent.putExtra("internal_third_packagename", this.d_renamed);
        intent.putExtra("internal_capability_client", this.f7546c);
        intent.putExtra("internal_third_pid", this.e_renamed);
        intent.putExtra("internal_active_write_permits", this.f_renamed);
        intent.putExtra("internal_base_version", "1.0.11");
        intent.putExtra("internal_wait_service", this.g_renamed);
        intent.setType("internal_service_" + this.f7546c);
        return intent;
    }

    android.content.Intent b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent(str);
        intent.setComponent(new android.content.ComponentName(str2, str3));
        intent.putExtra("bind_type", 2);
        intent.putExtra("internal_third_packagename", this.d_renamed);
        intent.putExtra("internal_capability_client", this.f7546c);
        intent.setType("internal_service_" + this.f7546c);
        return intent;
    }

    void a_renamed() {
        this.i_renamed.sendEmptyMessage(com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS);
    }

    public boolean b_renamed() {
        com.oplus.ocs.base.common.api.n_renamed nVar = this.j_renamed;
        if (nVar != null) {
            return nVar.a_renamed();
        }
        return false;
    }

    public boolean c_renamed() {
        com.oplus.ocs.base.common.api.n_renamed nVar = this.j_renamed;
        if (nVar != null) {
            return nVar.b_renamed();
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        com.oplus.ocs.base.common.api.n_renamed nVar;
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(f7544a, java.lang.String.format("current thread - %s_renamed and what - %d_renamed", java.lang.Thread.currentThread().getName(), java.lang.Integer.valueOf(message.what)));
        if (message.what == 1001 && (nVar = this.j_renamed) != null) {
            nVar.c_renamed();
        }
        return false;
    }
}
