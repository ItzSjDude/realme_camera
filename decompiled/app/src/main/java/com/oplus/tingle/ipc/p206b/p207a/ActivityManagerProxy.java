package com.oplus.tingle.ipc.p206b.p207a;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p206b.SystemServiceProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mirror.android.util.Singleton;

/* compiled from: ActivityManagerProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ActivityManagerProxy extends SystemServiceProxy<IActivityManager> {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Object f24141h;

    public ActivityManagerProxy() {
        this.f24147f = "activity";
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        Singleton.mInstance.set(this.f24141h, obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, android.app.IActivityManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.app.IActivityManager] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(final Context context) {
        this.f24143b = ActivityManager.getService();
        this.f24144c = new SlaveBinder(((IActivityManager) this.f24143b).asBinder());
        this.f24141h = mirror.android.app.ActivityManager.IActivityManagerSingleton.get(null);
        this.f24145d = (IActivityManager) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IActivityManager.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$OLERfB6euDXm6Z45XI_P55rff0A
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.COUIBaseListPopupWindow_12$0.m25498a(context, obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25498a(Context context, Object obj, Method method, Object[] objArr) throws Throwable {
        if (TextUtils.equals(this.f24146e.get(), Thread.currentThread().getName())) {
            m25506b(context, this.f24143b);
            this.f24146e.remove();
            return method.invoke(IActivityManager.Stub.asInterface(this.f24144c), objArr);
        }
        return method.invoke(this.f24143b, objArr);
    }
}
