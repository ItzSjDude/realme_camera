package com.oplus.tingle.ipc.p206b.p212e;

import android.content.Context;
import android.view.IWindowSession;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p206b.SystemServiceProxy;
import com.oplus.tingle.ipc.p213c.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mirror.android.view.WindowManagerGlobal;

/* compiled from: WindowManagerProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class WindowManagerProxy extends SystemServiceProxy<IWindowSession> {
    public WindowManagerProxy() {
        this.f24147f = "window";
        this.f24148g = false;
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        WindowManagerGlobal.sWindowSession.set(null, (IWindowSession) obj);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, android.view.IWindowSession] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, android.view.IWindowSession] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(Context context) {
        this.f24143b = android.view.WindowManagerGlobal.getWindowSession();
        this.f24144c = new SlaveBinder(((IWindowSession) this.f24143b).asBinder());
        this.f24145d = (IWindowSession) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IWindowSession.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.-$$Lambda$PlatformImplementations.kt_3$avWnhh8zCgTMsPVrdMubI0WkPKA
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.COUIBaseListPopupWindow_12$0.m25509a(obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25509a(Object obj, Method method, Object[] objArr) throws Throwable {
        return method.invoke(IWindowSession.Stub.asInterface(this.f24144c), objArr);
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy, com.oplus.tingle.ipc.p206b.ISystemServiceProxy
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo25502c(Context context) throws IllegalAccessException, IllegalArgumentException {
        Logger.m25512a(f24142a, "Reset Binder To Origin.", new Object[0]);
        mo25497a(context, this.f24143b);
    }
}
