package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.C3650a;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.api.C3652a;
import com.oplus.ocs.base.p193b.C3643b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.oplus.ocs.base.common.api.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public abstract class AbstractC3653b<T extends IBinder> implements C3652a.COUIBaseListPopupWindow_8, InterfaceC3671t {

    /* renamed from: PlatformImplementations.kt_3 */
    static final String f23412a = "IntrinsicsJvm.kt_4";

    /* renamed from: IntrinsicsJvm.kt_3 */
    CapabilityInfo f23414c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    InterfaceC3670s f23416e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    InterfaceC3669r f23417f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    InterfaceC3665n f23419h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Context f23420i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Looper f23421j;

    /* renamed from: OplusGLSurfaceView_5 */
    private HandlerC3663l f23422k;

    /* renamed from: IntrinsicsJvm.kt_4 */
    volatile int f23413b = 4;

    /* renamed from: IntrinsicsJvm.kt_5 */
    Queue<C3660i> f23415d = new LinkedList();

    /* renamed from: COUIBaseListPopupWindow_11 */
    HandlerC3664m f23418g = null;

    public abstract String getClientName();

    protected AbstractC3653b(Context context, Looper looper) {
        if (context != null) {
            this.f23420i = context;
            if (looper != null) {
                this.f23421j = looper;
                this.f23422k = HandlerC3663l.m25087a(this);
                C3662k.m25084a();
                this.f23419h = C3662k.m25086a(this.f23420i, getClientName(), this.f23422k, this);
                return;
            }
            throw new NullPointerException("Looper must not be null");
        }
        throw new NullPointerException("null reference");
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public void connect() {
        InterfaceC3665n interfaceC3665n = this.f23419h;
        if (interfaceC3665n != null) {
            interfaceC3665n.mo25080a();
            return;
        }
        this.f23414c = m25042b(3);
        m25043a(3);
        InterfaceC3670s interfaceC3670s = this.f23416e;
        if (interfaceC3670s != null) {
            interfaceC3670s.mo25098a();
        }
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public void disconnect() {
        this.f23419h.mo25082c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25040a() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public T getRemoteService() {
        m25040a();
        return (T) this.f23414c.getBinder();
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public int getMinApkVersion() {
        m25040a();
        return this.f23414c.getVersion();
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public AuthResult getAuthResult() {
        return this.f23414c.getAuthResult();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m25044a(Handler handler) {
        HandlerC3664m handlerC3664m = this.f23418g;
        if (handlerC3664m == null) {
            if (handler == null) {
                this.f23418g = new HandlerC3664m(this.f23421j, this.f23422k);
                return;
            } else {
                this.f23418g = new HandlerC3664m(handler.getLooper(), this.f23422k);
                return;
            }
        }
        if (handler == null || handlerC3664m.getLooper() == handler.getLooper()) {
            return;
        }
        C3643b.m25022a(f23412a, "the new handler looper is not the same as the old one.");
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public void setOnConnectionSucceedListener(final InterfaceC3657f interfaceC3657f, Handler handler) {
        CapabilityInfo capabilityInfo = this.f23414c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.f23414c.getAuthResult().getErrrorCode() != 1001) {
            m25044a(handler);
            this.f23418g.f23471a = interfaceC3657f;
        } else if (interfaceC3657f != null) {
            if (handler == null) {
                interfaceC3657f.m25053a();
            } else {
                handler.post(new Runnable() { // from class: com.oplus.ocs.base.common.api.IntrinsicsJvm.kt_4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC3657f.m25053a();
                    }
                });
            }
        }
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public void setOnConnectionFailedListener(InterfaceC3656e interfaceC3656e, Handler handler) {
        CapabilityInfo capabilityInfo = this.f23414c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.f23414c.getAuthResult().getErrrorCode() == 1001) {
            m25044a(handler);
            this.f23418g.f23472b = interfaceC3656e;
        } else if (interfaceC3656e != null) {
            interfaceC3656e.m25052a(new C3650a(this.f23414c.getAuthResult().getErrrorCode()));
        }
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public void setOnClearListener(InterfaceC3670s interfaceC3670s) {
        this.f23416e = interfaceC3670s;
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public void setOnCapabilityAuthListener(InterfaceC3669r interfaceC3669r) {
        this.f23417f = interfaceC3669r;
    }

    public Looper getLooper() {
        return this.f23421j;
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public boolean isConnected() {
        return this.f23413b == 1;
    }

    public boolean isConnecting() {
        return this.f23413b == 2;
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.COUIBaseListPopupWindow_8
    public <T> void addQueue(C3660i<T> c3660i) {
        if (isConnected()) {
            m25045a(c3660i);
            return;
        }
        if (this.f23413b == 13) {
            m25041a(c3660i, true);
        } else {
            m25041a(c3660i, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25041a(C3660i c3660i, boolean z) {
        this.f23415d.add(c3660i);
        if (z) {
            connect();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m25045a(C3660i c3660i) {
        CapabilityInfo capabilityInfo = this.f23414c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null) {
            return;
        }
        if (this.f23414c.getAuthResult().getErrrorCode() == 1001) {
            c3660i.m25066a(0);
        } else {
            c3660i.m25066a(this.f23414c.getAuthResult().getErrrorCode());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m25043a(int OplusGLSurfaceView_13) {
        C3643b.m25022a(f23412a, "handleAuthenticateFailure");
        if (this.f23418g == null) {
            m25044a((Handler) null);
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 101;
        messageObtain.arg1 = OplusGLSurfaceView_13;
        this.f23418g.sendMessage(messageObtain);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static CapabilityInfo m25042b(int OplusGLSurfaceView_13) {
        return new CapabilityInfo(new ArrayList(), 1, new AuthResult("", 0, 0, OplusGLSurfaceView_13, new byte[0]));
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3671t
    public void onStateChange(int OplusGLSurfaceView_13) {
        this.f23413b = OplusGLSurfaceView_13;
    }
}
