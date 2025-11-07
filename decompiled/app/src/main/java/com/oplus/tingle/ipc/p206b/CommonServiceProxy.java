package com.oplus.tingle.ipc.p206b;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.text.TextUtils;
import com.oplus.inner.app.SystemServiceRegistryWrapper;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p213c.Logger;
import com.oplus.tingle.ipc.p213c.VersionUtils_2;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mirror.android.app.ContextImpl;
import mirror.android.app.SystemServiceRegistry;
import mirror.android.p218os.ServiceManager;

/* compiled from: CommonServiceProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CommonServiceProxy extends SystemServiceProxy<IBinder> {
    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Object m25491c(String str) {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static void m25492d(Object obj) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static void m25494e(Object obj) {
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static Object m25495f(Object obj) {
        return null;
    }

    public CommonServiceProxy(String str) {
        this.f24147f = str;
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        ServiceManager.sCache.get(null).put(this.f24147f, (IBinder) obj);
        m25493e(context);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, android.os.IBinder] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(final Context context) {
        this.f24143b = ServiceManager.getService.call(null, this.f24147f);
        this.f24144c = new SlaveBinder((IBinder) this.f24143b);
        this.f24145d = (IBinder) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IBinder.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.-$$Lambda$PlatformImplementations.kt_3$FNk99vNkx2BGPowqORPhVAokqWg
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.COUIBaseListPopupWindow_12$0.m25486a(context, obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25486a(Context context, Object obj, Method method, Object[] objArr) throws Throwable {
        if (TextUtils.equals(this.f24146e.get(), Thread.currentThread().getName())) {
            if (TextUtils.equals(method.getName(), "transact")) {
                m25506b(context, this.f24143b);
                this.f24146e.remove();
            }
            return method.invoke(this.f24144c, objArr);
        }
        return method.invoke(this.f24143b, objArr);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m25493e(Context context) throws IllegalAccessException, IllegalArgumentException {
        Object[] objArr;
        Object objM25488b = m25488b(this.f24147f);
        if (objM25488b == null) {
            Logger.m25512a("CommonServiceProxy", "getFetcher failed.", new Object[0]);
            return;
        }
        String canonicalName = objM25488b.getClass().getSuperclass().getCanonicalName();
        if (canonicalName.contains("StaticApplicationContextServiceFetcher")) {
            m25487a(objM25488b);
            return;
        }
        if (canonicalName.contains("StaticServiceFetcher")) {
            m25489b(objM25488b);
            return;
        }
        if (canonicalName.contains("CachedServiceFetcher")) {
            int iM25490c = m25490c(objM25488b);
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext() instanceof Application) {
                    objArr = ContextImpl.mServiceCache.get(((Application) contextWrapper.getBaseContext()).getBaseContext());
                } else {
                    objArr = ContextImpl.mServiceCache.get(contextWrapper.getBaseContext());
                }
                objArr[iM25490c] = null;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m25488b(String str) {
        if (VersionUtils_2.m25515a()) {
            return SystemServiceRegistry.getFetcher(str);
        }
        if (VersionUtils_2.m25516b()) {
            return SystemServiceRegistryWrapper.getFetcher(str);
        }
        return m25491c(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m25487a(Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (VersionUtils_2.m25515a()) {
            SystemServiceRegistry.StaticServiceFetcher.setCachedInstance(obj, null);
        } else if (VersionUtils_2.m25516b()) {
            SystemServiceRegistryWrapper.StaticServiceFetcherWrapper.setCachedInstance(obj, (Object) null);
        } else {
            m25492d(obj);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m25489b(Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (VersionUtils_2.m25515a()) {
            SystemServiceRegistry.StaticServiceFetcher.setCachedInstance(obj, null);
        } else if (VersionUtils_2.m25516b()) {
            SystemServiceRegistryWrapper.StaticServiceFetcherWrapper.setCachedInstance(obj, (Object) null);
        } else {
            m25494e(obj);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m25490c(Object obj) {
        if (VersionUtils_2.m25515a()) {
            return SystemServiceRegistry.CachedServiceFetcher.getCacheIndex(obj);
        }
        if (VersionUtils_2.m25516b()) {
            return SystemServiceRegistryWrapper.CachedServiceFetcherWrapper.getCacheIndex(obj);
        }
        return ((Integer) m25495f(obj)).intValue();
    }
}
