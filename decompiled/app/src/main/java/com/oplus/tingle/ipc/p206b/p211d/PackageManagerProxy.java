package com.oplus.tingle.ipc.p206b.p211d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.IPackageManager;
import android.text.TextUtils;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p206b.SystemServiceProxy;
import com.oplus.tingle.ipc.p213c.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mirror.android.app.ActivityThread;
import mirror.android.app.ContextImpl;

/* compiled from: PackageManagerProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class PackageManagerProxy extends SystemServiceProxy<IPackageManager> {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Class<?> f24151h;

    public PackageManagerProxy() {
        this.f24147f = "package";
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (f24151h == null) {
            try {
                f24151h = Class.forName("android.app.ContextImpl");
            } catch (Exception COUIBaseListPopupWindow_8) {
                Logger.m25514b("PackageManagerProxy", COUIBaseListPopupWindow_8.toString(), new Object[0]);
            }
        }
        Class<?> cls = f24151h;
        if (cls == null || context == null) {
            return;
        }
        if (cls.isAssignableFrom(context.getClass())) {
            ContextImpl.mPackageManager.set(context, null);
        } else {
            ContextImpl.mPackageManager.set(((ContextWrapper) context).getBaseContext(), null);
        }
        ActivityThread.sPackageManager.set(null, obj);
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Object mo25504d(Context context) {
        return context.getPackageManager();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.content.pm.IPackageManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.content.pm.IPackageManager] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(final Context context) {
        if (context.getPackageManager() != null) {
            this.f24143b = android.app.ActivityThread.getPackageManager();
            this.f24144c = new SlaveBinder(((IPackageManager) this.f24143b).asBinder());
            this.f24145d = (IPackageManager) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IPackageManager.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5.-$$Lambda$PlatformImplementations.kt_3$wEcsfKXJgFUnHToqQbJagIlVkjI
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return this.COUIBaseListPopupWindow_12$0.m25508a(context, obj, method, objArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25508a(Context context, Object obj, Method method, Object[] objArr) throws Throwable {
        if (TextUtils.equals(this.f24146e.get(), Thread.currentThread().getName())) {
            m25506b(context, this.f24143b);
            this.f24146e.remove();
            return method.invoke(IPackageManager.Stub.asInterface(this.f24144c), objArr);
        }
        return method.invoke(this.f24143b, objArr);
    }
}
