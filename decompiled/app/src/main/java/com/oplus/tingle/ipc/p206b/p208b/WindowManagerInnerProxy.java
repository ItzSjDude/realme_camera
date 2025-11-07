package com.oplus.tingle.ipc.p206b.p208b;

import android.content.Context;
import android.os.IInterface;
import android.view.IWindowManager;
import android.view.IWindowSession;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p206b.SystemServiceProxy;
import com.oplus.tingle.ipc.p213c.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mirror.android.view.WindowManagerGlobal;

/* compiled from: WindowManagerInnerProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class WindowManagerInnerProxy extends SystemServiceProxy<IWindowSession> {
    public WindowManagerInnerProxy() {
        this.f24147f = "windowInner";
        this.f24148g = false;
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        WindowManagerGlobal.sWindowSession.set(null, (IWindowSession) obj);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, android.view.IWindowSession] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, android.view.IWindowSession] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(Context context) throws IllegalAccessException, IllegalArgumentException {
        IInterface windowManagerService = android.view.WindowManagerGlobal.getWindowManagerService();
        WindowManagerGlobal.sWindowManagerService.set(null, IWindowManager.Stub.asInterface(new SlaveBinder(windowManagerService.asBinder())));
        WindowManagerGlobal.sWindowSession.set(null, null);
        this.f24143b = android.view.WindowManagerGlobal.getWindowSession();
        WindowManagerGlobal.sWindowManagerService.set(null, windowManagerService);
        this.f24144c = new SlaveBinder(((IWindowSession) this.f24143b).asBinder());
        this.f24145d = (IWindowSession) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IWindowSession.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.-$$Lambda$PlatformImplementations.kt_3$D-ELU3VBkayE0kGG6BQRTAAekDk
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.COUIBaseListPopupWindow_12$0.m25503a(obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25503a(Object obj, Method method, Object[] objArr) throws Throwable {
        return method.invoke(IWindowSession.Stub.asInterface(this.f24144c), objArr);
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Object mo25504d(Context context) {
        return context.getSystemService("window");
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy, com.oplus.tingle.ipc.p206b.ISystemServiceProxy
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo25502c(Context context) throws IllegalAccessException, IllegalArgumentException {
        Logger.m25512a(f24142a, "Reset Binder To Origin.", new Object[0]);
        WindowManagerGlobal.sWindowManagerService.set(null, null);
        WindowManagerGlobal.sWindowSession.set(null, null);
        android.view.WindowManagerGlobal.getWindowSession();
    }
}
