package com.oplus.tingle.ipc.p206b.p207a;

import android.app.INotificationManager;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p206b.SystemServiceProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mirror.android.app.NotificationManager;

/* compiled from: NotificationManagerProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class NotificationManagerProxy extends SystemServiceProxy<INotificationManager> {
    public NotificationManagerProxy() {
        this.f24147f = "notification";
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        NotificationManager.sService.set(null, obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, android.app.INotificationManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.app.INotificationManager] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(final Context context) {
        this.f24143b = android.app.NotificationManager.getService();
        this.f24144c = new SlaveBinder(((INotificationManager) this.f24143b).asBinder());
        this.f24145d = (INotificationManager) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{INotificationManager.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$vkVTz-ajI1RRYwslbOOdybGkA70
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.COUIBaseListPopupWindow_12$0.m25499a(context, obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25499a(Context context, Object obj, Method method, Object[] objArr) throws Throwable {
        if (TextUtils.equals(this.f24146e.get(), Thread.currentThread().getName())) {
            m25506b(context, this.f24143b);
            this.f24146e.remove();
            return method.invoke(INotificationManager.Stub.asInterface(this.f24144c), objArr);
        }
        return method.invoke(this.f24143b, objArr);
    }
}
