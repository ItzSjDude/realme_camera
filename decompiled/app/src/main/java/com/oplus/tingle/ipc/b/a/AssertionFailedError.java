package com.oplus.tingle.ipc.b_renamed.a_renamed;

/* compiled from: NotificationManagerProxy.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.tingle.ipc.b_renamed.c_renamed<android.app.INotificationManager> {
    public b_renamed() {
        this.f_renamed = "notification";
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(android.content.Context context, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        mirror.android.app.NotificationManager.sService.set(null, obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T_renamed, android.app.INotificationManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T_renamed, android.app.INotificationManager] */
    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(final android.content.Context context) {
        this.f7750b = android.app.NotificationManager.getService();
        this.f7751c = new com.oplus.tingle.ipc.c_renamed(((android.app.INotificationManager) this.f7750b).asBinder());
        this.d_renamed = (android.app.INotificationManager) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{android.app.INotificationManager.class}, new java.lang.reflect.InvocationHandler() { // from class: com.oplus.tingle.ipc.b_renamed.a_renamed.-$$Lambda$b_renamed$vkVTz-ajI1RRYwslbOOdybGkA70
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
            return method.invoke(android.app.INotificationManager.Stub.asInterface(this.f7751c), objArr);
        }
        return method.invoke(this.f7750b, objArr);
    }
}
