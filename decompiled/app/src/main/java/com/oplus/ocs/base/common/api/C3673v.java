package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.api.C3652a;
import com.oplus.ocs.base.internal.C3676a;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.oplus.ocs.base.common.api.v */
/* loaded from: classes2.dex */
public class C3673v implements InterfaceC3659h {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23511a = "v";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Lock f23512b = new ReentrantLock();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private C3652a f23513c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private C3652a.COUIBaseListPopupWindow_8 f23514d;

    public C3673v(Context context, C3652a c3652a, C3652a.IntrinsicsJvm.kt_3 cVar, C3676a c3676a) {
        this.f23513c = c3652a;
        this.f23514d = this.f23513c.m25037a().buildClient(context, Looper.getMainLooper(), c3676a, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.concurrent.locks.Lock] */
    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25054a() {
        this.f23512b.lock();
        try {
            try {
                if (this.f23514d != null) {
                    this.f23514d.connect();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } finally {
            this.f23512b.unlock();
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo25060b() {
        this.f23512b.lock();
        try {
            try {
                if (this.f23514d != null && this.f23514d.isConnected()) {
                    this.f23514d.disconnect();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } finally {
            this.f23512b.unlock();
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo25061c() {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            return eVar.isConnected();
        }
        return false;
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: IntrinsicsJvm.kt_5 */
    public IBinder mo25062d() {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            return eVar.getRemoteService();
        }
        return null;
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo25057a(C3660i<T> c3660i) {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            eVar.addQueue(c3660i);
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int mo25063e() {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            return eVar.getMinApkVersion();
        }
        return 0;
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: COUIBaseListPopupWindow_12 */
    public AuthResult mo25064f() {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            return eVar.getAuthResult();
        }
        return null;
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25056a(InterfaceC3657f interfaceC3657f, Handler handler) {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            eVar.setOnConnectionSucceedListener(interfaceC3657f, handler);
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25055a(InterfaceC3656e interfaceC3656e, Handler handler) {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            eVar.setOnConnectionFailedListener(interfaceC3656e, handler);
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25059a(InterfaceC3670s interfaceC3670s) {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            eVar.setOnClearListener(interfaceC3670s);
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3659h
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25058a(InterfaceC3669r interfaceC3669r) {
        C3652a.COUIBaseListPopupWindow_8 eVar = this.f23514d;
        if (eVar != null) {
            eVar.setOnCapabilityAuthListener(interfaceC3669r);
        }
    }
}
