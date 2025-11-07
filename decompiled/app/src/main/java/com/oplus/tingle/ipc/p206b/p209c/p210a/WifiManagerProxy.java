package com.oplus.tingle.ipc.p206b.p209c.p210a;

import android.content.Context;
import android.net.wifi.IWifiManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p206b.SystemServiceProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: WifiManagerProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class WifiManagerProxy extends SystemServiceProxy<IWifiManager> {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private WifiManager f24150h;

    public WifiManagerProxy() {
        this.f24147f = "wifi";
    }

    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25497a(Context context, Object obj) throws IllegalAccessException, IllegalArgumentException {
        mirror.android.net.wifi.WifiManager.mService.set(this.f24150h, (IWifiManager) obj);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.net.wifi.IWifiManager] */
    @Override // com.oplus.tingle.ipc.p206b.SystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo25496a(final Context context) {
        this.f24150h = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f24143b = mirror.android.net.wifi.WifiManager.mService.get(this.f24150h);
        this.f24144c = new SlaveBinder(((IWifiManager) this.f24143b).asBinder());
        this.f24145d = (IWifiManager) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IWifiManager.class}, new InvocationHandler() { // from class: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$mVTzedJbqMq30flonSZh0FEQ3es
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.COUIBaseListPopupWindow_12$0.m25507a(context, obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Object m25507a(Context context, Object obj, Method method, Object[] objArr) throws Throwable {
        if (TextUtils.equals(this.f24146e.get(), Thread.currentThread().getName())) {
            m25506b(context, this.f24143b);
            this.f24146e.remove();
            return method.invoke(IWifiManager.Stub.asInterface(this.f24144c), objArr);
        }
        return method.invoke(this.f24143b, objArr);
    }
}
