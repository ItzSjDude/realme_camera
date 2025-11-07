package com.oplus.tingle.ipc.b_renamed;

/* compiled from: CommonServiceProxy.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.tingle.ipc.b_renamed.c_renamed<android.os.IBinder> {
    private static java.lang.Object c_renamed(java.lang.String str) {
        return null;
    }

    private static void d_renamed(java.lang.Object obj) {
    }

    private static void e_renamed(java.lang.Object obj) {
    }

    private static java.lang.Object f_renamed(java.lang.Object obj) {
        return null;
    }

    public a_renamed(java.lang.String str) {
        this.f_renamed = str;
    }

    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(android.content.Context context, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        mirror.android.os.ServiceManager.sCache.get(null).put(this.f_renamed, (android.os.IBinder) obj);
        e_renamed(context);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T_renamed, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T_renamed, android.os.IBinder] */
    @Override // com.oplus.tingle.ipc.b_renamed.c_renamed
    protected void a_renamed(final android.content.Context context) {
        this.f7750b = mirror.android.os.ServiceManager.getService.call(null, this.f_renamed);
        this.f7751c = new com.oplus.tingle.ipc.c_renamed((android.os.IBinder) this.f7750b);
        this.d_renamed = (android.os.IBinder) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{android.os.IBinder.class}, new java.lang.reflect.InvocationHandler() { // from class: com.oplus.tingle.ipc.b_renamed.-$$Lambda$a_renamed$FNk99vNkx2BGPowqORPhVAokqWg
            @Override // java.lang.reflect.InvocationHandler
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
                return this.f_renamed$0.a_renamed(context, obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object a_renamed(android.content.Context context, java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        if (android.text.TextUtils.equals(this.e_renamed.get(), java.lang.Thread.currentThread().getName())) {
            if (android.text.TextUtils.equals(method.getName(), "transact")) {
                b_renamed(context, this.f7750b);
                this.e_renamed.remove();
            }
            return method.invoke(this.f7751c, objArr);
        }
        return method.invoke(this.f7750b, objArr);
    }

    private void e_renamed(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        java.lang.Object[] objArr;
        java.lang.Object objB = b_renamed(this.f_renamed);
        if (objB == null) {
            com.oplus.tingle.ipc.c_renamed.a_renamed.a_renamed("CommonServiceProxy", "getFetcher failed.", new java.lang.Object[0]);
            return;
        }
        java.lang.String canonicalName = objB.getClass().getSuperclass().getCanonicalName();
        if (canonicalName.contains("StaticApplicationContextServiceFetcher")) {
            a_renamed(objB);
            return;
        }
        if (canonicalName.contains("StaticServiceFetcher")) {
            b_renamed(objB);
            return;
        }
        if (canonicalName.contains("CachedServiceFetcher")) {
            int iC = c_renamed(objB);
            if (context instanceof android.content.ContextWrapper) {
                android.content.ContextWrapper contextWrapper = (android.content.ContextWrapper) context;
                if (contextWrapper.getBaseContext() instanceof android.app.Application) {
                    objArr = mirror.android.app.ContextImpl.mServiceCache.get(((android.app.Application) contextWrapper.getBaseContext()).getBaseContext());
                } else {
                    objArr = mirror.android.app.ContextImpl.mServiceCache.get(contextWrapper.getBaseContext());
                }
                objArr[iC] = null;
            }
        }
    }

    private static java.lang.Object b_renamed(java.lang.String str) {
        if (com.oplus.tingle.ipc.c_renamed.b_renamed.a_renamed()) {
            return mirror.android.app.SystemServiceRegistry.getFetcher(str);
        }
        if (com.oplus.tingle.ipc.c_renamed.b_renamed.b_renamed()) {
            return com.oplus.inner.app.SystemServiceRegistryWrapper.getFetcher(str);
        }
        return c_renamed(str);
    }

    private static void a_renamed(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (com.oplus.tingle.ipc.c_renamed.b_renamed.a_renamed()) {
            mirror.android.app.SystemServiceRegistry.StaticServiceFetcher.setCachedInstance(obj, null);
        } else if (com.oplus.tingle.ipc.c_renamed.b_renamed.b_renamed()) {
            com.oplus.inner.app.SystemServiceRegistryWrapper.StaticServiceFetcherWrapper.setCachedInstance(obj, (java.lang.Object) null);
        } else {
            d_renamed(obj);
        }
    }

    private static void b_renamed(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (com.oplus.tingle.ipc.c_renamed.b_renamed.a_renamed()) {
            mirror.android.app.SystemServiceRegistry.StaticServiceFetcher.setCachedInstance(obj, null);
        } else if (com.oplus.tingle.ipc.c_renamed.b_renamed.b_renamed()) {
            com.oplus.inner.app.SystemServiceRegistryWrapper.StaticServiceFetcherWrapper.setCachedInstance(obj, (java.lang.Object) null);
        } else {
            e_renamed(obj);
        }
    }

    private static int c_renamed(java.lang.Object obj) {
        if (com.oplus.tingle.ipc.c_renamed.b_renamed.a_renamed()) {
            return mirror.android.app.SystemServiceRegistry.CachedServiceFetcher.getCacheIndex(obj);
        }
        if (com.oplus.tingle.ipc.c_renamed.b_renamed.b_renamed()) {
            return com.oplus.inner.app.SystemServiceRegistryWrapper.CachedServiceFetcherWrapper.getCacheIndex(obj);
        }
        return ((java.lang.Integer) f_renamed(obj)).intValue();
    }
}
