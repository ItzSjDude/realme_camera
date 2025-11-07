package com.oplus.tingle.ipc.b_renamed.d_renamed;

/* compiled from: PackageManagerProxy.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.tingle.ipc.b_renamed.c_renamed<android.content.pm.IPackageManager> {
    private static java.lang.Class<?> h_renamed;

    public a_renamed() {
        this.f_renamed = "package";
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(android.content.Context context, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (h_renamed == null) {
            try {
                h_renamed = java.lang.Class.forName("android.app.ContextImpl");
            } catch (java.lang.Exception e_renamed) {
                com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("PackageManagerProxy", e_renamed.toString(), new java.lang.Object[0]);
            }
        }
        java.lang.Class<?> cls = h_renamed;
        if (cls == null || context == null) {
            return;
        }
        if (cls.isAssignableFrom(context.getClass())) {
            mirror.android.app.ContextImpl.mPackageManager.set(context, null);
        } else {
            mirror.android.app.ContextImpl.mPackageManager.set(((android.content.ContextWrapper) context).getBaseContext(), null);
        }
        mirror.android.app.ActivityThread.sPackageManager.set(null, obj);
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected java.lang.Object d_renamed(android.content.Context context) {
        return context.getPackageManager();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T_renamed, android.content.pm.IPackageManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T_renamed, android.content.pm.IPackageManager] */
    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(final android.content.Context context) {
        if (context.getPackageManager() != null) {
            this.f7750b = android.app.ActivityThread.getPackageManager();
            this.f7751c = new com.oplus.tingle.ipc.c_renamed(((android.content.pm.IPackageManager) this.f7750b).asBinder());
            this.d_renamed = (android.content.pm.IPackageManager) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{android.content.pm.IPackageManager.class}, new java.lang.reflect.InvocationHandler() { // from class: com.oplus.tingle.ipc.b_renamed.d_renamed.-$$Lambda$a_renamed$wEcsfKXJgFUnHToqQbJagIlVkjI
                @Override // java.lang.reflect.InvocationHandler
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                    return this.f_renamed$0.a_renamed(context, obj, method, objArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object a_renamed(android.content.Context context, java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        if (android.text.TextUtils.equals(this.e_renamed.get(), java.lang.Thread.currentThread().getName())) {
            b_renamed(context, this.f7750b);
            this.e_renamed.remove();
            return method.invoke(android.content.pm.IPackageManager.Stub.asInterface(this.f7751c), objArr);
        }
        return method.invoke(this.f7750b, objArr);
    }
}
