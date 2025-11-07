package com.oplus.tingle.ipc.b_renamed.c_renamed.a_renamed;

/* compiled from: WifiManagerProxy.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.tingle.ipc.b_renamed.c_renamed<android.net.wifi.IWifiManager> {
    private android.net.wifi.WifiManager h_renamed;

    public a_renamed() {
        this.f_renamed = "wifi";
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(android.content.Context context, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        mirror.android.net.wifi.WifiManager.mService.set(this.h_renamed, (android.net.wifi.IWifiManager) obj);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T_renamed, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T_renamed, android.net.wifi.IWifiManager] */
    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(final android.content.Context context) {
        this.h_renamed = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f7750b = mirror.android.net.wifi.WifiManager.mService.get(this.h_renamed);
        this.f7751c = new com.oplus.tingle.ipc.c_renamed(((android.net.wifi.IWifiManager) this.f7750b).asBinder());
        this.d_renamed = (android.net.wifi.IWifiManager) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{android.net.wifi.IWifiManager.class}, new java.lang.reflect.InvocationHandler() { // from class: com.oplus.tingle.ipc.b_renamed.c_renamed.a_renamed.-$$Lambda$a_renamed$mVTzedJbqMq30flonSZh0FEQ3es
            @Override // java.lang.reflect.InvocationHandler
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                return this.f_renamed$0.a_renamed(context, obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object a_renamed(android.content.Context context, java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        if (android.text.TextUtils.equals(this.e_renamed.get(), java.lang.Thread.currentThread().getName())) {
            b_renamed(context, this.f7750b);
            this.e_renamed.remove();
            return method.invoke(android.net.wifi.IWifiManager.Stub.asInterface(this.f7751c), objArr);
        }
        return method.invoke(this.f7750b, objArr);
    }
}
