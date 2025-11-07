package com.oplus.tingle.ipc.b_renamed.e_renamed;

/* compiled from: WindowManagerProxy.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.tingle.ipc.b_renamed.c_renamed<android.view.IWindowSession> {
    public a_renamed() {
        this.f_renamed = "window";
        this.g_renamed = false;
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(android.content.Context context, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        mirror.android.view.WindowManagerGlobal.sWindowSession.set(null, (android.view.IWindowSession) obj);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T_renamed, android.view.IWindowSession] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T_renamed, android.view.IWindowSession] */
    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(android.content.Context context) {
        this.f7750b = android.view.WindowManagerGlobal.getWindowSession();
        this.f7751c = new com.oplus.tingle.ipc.c_renamed(((android.view.IWindowSession) this.f7750b).asBinder());
        this.d_renamed = (android.view.IWindowSession) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{android.view.IWindowSession.class}, new java.lang.reflect.InvocationHandler() { // from class: com.oplus.tingle.ipc.b_renamed.e_renamed.-$$Lambda$a_renamed$avWnhh8zCgTMsPVrdMubI0WkPKA
            @Override // java.lang.reflect.InvocationHandler
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                return this.f_renamed$0.a_renamed(obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object a_renamed(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        return method.invoke(android.view.IWindowSession.Stub.asInterface(this.f7751c), objArr);
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed, com.oplus.tingle.ipc.b_renamed.b_renamed
    public void c_renamed(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        com.oplus.tingle.ipc.c_renamed.a_renamed.a_renamed(f7749a, "Reset Binder To Origin.", new java.lang.Object[0]);
        a_renamed(context, this.f7750b);
    }
}
