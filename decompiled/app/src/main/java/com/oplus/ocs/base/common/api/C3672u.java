package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.HandlerC3674b;
import com.oplus.ocs.base.common.api.C3652a;
import com.oplus.ocs.base.common.api.C3652a.IntrinsicsJvm.kt_3;
import com.oplus.ocs.base.internal.C3676a;
import com.oplus.ocs.base.p193b.C3643b;
import com.oplus.ocs.base.p193b.C3645d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.oplus.ocs.base.common.api.u */
/* loaded from: classes2.dex */
class C3672u<O extends C3652a.IntrinsicsJvm.kt_3> implements Handler.Callback {

    /* renamed from: IntrinsicsJvm.kt_3 */
    static Map<C3652a.COUIBaseListPopupWindow_12, InterfaceC3659h> f23499c = new ConcurrentHashMap();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final String f23500d = "u";

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static volatile C3672u f23501f;

    /* renamed from: PlatformImplementations.kt_3 */
    Context f23502a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    HandlerC3674b f23503b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Looper f23504e;

    /* renamed from: PlatformImplementations.kt_3 */
    public static C3672u m25099a(Context context) {
        if (f23501f == null) {
            synchronized (C3672u.class) {
                if (f23501f == null) {
                    HandlerThread handlerThread = new HandlerThread("OplusApiManager", 9);
                    handlerThread.start();
                    if (handlerThread.getLooper() != null) {
                        f23501f = new C3672u(context, handlerThread.getLooper());
                    } else {
                        f23501f = new C3672u(context, Looper.getMainLooper());
                    }
                }
            }
        }
        return f23501f;
    }

    private C3672u(Context context, Looper looper) {
        if (context.getApplicationContext() != null) {
            this.f23502a = context.getApplicationContext();
        } else {
            this.f23502a = context;
        }
        this.f23504e = looper;
        this.f23503b = new HandlerC3674b(this.f23504e, this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m25108a(C3652a c3652a) {
        Message messageObtainMessage = this.f23503b.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = c3652a;
        this.f23503b.sendMessage(messageObtainMessage);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m25110a(final AbstractC3658g abstractC3658g, C3676a c3676a) {
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        C3645d.m25030a(c3676a, "clientsettings not be null");
        if (f23499c.containsKey(abstractC3658g.getApi().m25038b())) {
            return;
        }
        C3673v c3673v = new C3673v(this.f23502a, abstractC3658g.getApi(), abstractC3658g.f23438a, c3676a);
        c3673v.mo25059a(new InterfaceC3670s() { // from class: com.oplus.ocs.base.common.api.u.1
            @Override // com.oplus.ocs.base.common.api.InterfaceC3670s
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25098a() {
                C3672u.m25100a(abstractC3658g.getApi().m25038b());
            }
        });
        c3673v.mo25058a(new InterfaceC3669r() { // from class: com.oplus.ocs.base.common.api.u.2
            @Override // com.oplus.ocs.base.common.api.InterfaceC3669r
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25097a(CapabilityInfo capabilityInfo) {
                if (capabilityInfo != null) {
                    abstractC3658g.checkAuthResult(capabilityInfo);
                }
            }
        });
        f23499c.put(abstractC3658g.getApi().m25038b(), c3673v);
        m25108a(abstractC3658g.getApi());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m25101a(AbstractC3658g abstractC3658g) {
        CapabilityInfo capabilityInfoM25046a = C3654c.m25046a(abstractC3658g.getApi());
        if (capabilityInfoM25046a != null) {
            abstractC3658g.checkAuthResult(capabilityInfoM25046a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m25109a(AbstractC3658g abstractC3658g, final InterfaceC3657f interfaceC3657f, Handler handler) {
        InterfaceC3659h interfaceC3659h;
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return;
        }
        if (abstractC3658g.isConnected()) {
            new Handler(handler == null ? Looper.getMainLooper() : handler.getLooper()) { // from class: com.oplus.ocs.base.common.api.u.3
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    super.handleMessage(message);
                    InterfaceC3657f interfaceC3657f2 = interfaceC3657f;
                    if (interfaceC3657f2 != null) {
                        interfaceC3657f2.m25053a();
                    }
                }
            }.sendEmptyMessage(0);
        } else {
            interfaceC3659h.mo25056a(interfaceC3657f, handler);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m25102a(AbstractC3658g abstractC3658g, InterfaceC3656e interfaceC3656e, Handler handler) {
        InterfaceC3659h interfaceC3659h;
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return;
        }
        interfaceC3659h.mo25055a(interfaceC3656e, handler);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static IBinder m25104b(AbstractC3658g abstractC3658g) {
        InterfaceC3659h interfaceC3659h;
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return null;
        }
        return interfaceC3659h.mo25062d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static int m25105c(AbstractC3658g abstractC3658g) {
        InterfaceC3659h interfaceC3659h;
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return 0;
        }
        return interfaceC3659h.mo25063e();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static AuthResult m25106d(AbstractC3658g abstractC3658g) {
        InterfaceC3659h interfaceC3659h;
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return null;
        }
        return interfaceC3659h.mo25064f();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static boolean m25107e(AbstractC3658g abstractC3658g) {
        InterfaceC3659h interfaceC3659h;
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return false;
        }
        return interfaceC3659h.mo25061c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static <T> void m25103a(AbstractC3658g abstractC3658g, C3660i<T> c3660i) {
        InterfaceC3659h interfaceC3659h;
        C3643b.m25022a(f23500d, "addQueue " + abstractC3658g.getClass().getSimpleName());
        C3645d.m25030a(abstractC3658g, "oplusApi not be null");
        if (!f23499c.containsKey(abstractC3658g.getApi().m25038b()) || (interfaceC3659h = f23499c.get(abstractC3658g.getApi().m25038b())) == null) {
            return;
        }
        interfaceC3659h.mo25057a(c3660i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m25100a(C3652a.COUIBaseListPopupWindow_12 fVar) {
        f23499c.remove(fVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterfaceC3659h interfaceC3659h;
        C3652a c3652a;
        InterfaceC3659h interfaceC3659h2;
        C3643b.m25022a(f23500d, "handle message " + message.what);
        int OplusGLSurfaceView_13 = message.what;
        if (OplusGLSurfaceView_13 == 0) {
            C3652a c3652a2 = (C3652a) message.obj;
            if (c3652a2 == null || c3652a2.m25038b() == null || (interfaceC3659h = f23499c.get(c3652a2.m25038b())) == null) {
                return false;
            }
            interfaceC3659h.mo25054a();
            return false;
        }
        if (OplusGLSurfaceView_13 != 1 || (c3652a = (C3652a) message.obj) == null || c3652a.m25038b() == null || (interfaceC3659h2 = f23499c.get(c3652a.m25038b())) == null) {
            return false;
        }
        interfaceC3659h2.mo25060b();
        m25100a(c3652a.m25038b());
        return false;
    }
}
