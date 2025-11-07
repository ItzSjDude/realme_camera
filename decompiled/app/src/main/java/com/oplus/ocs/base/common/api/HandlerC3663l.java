package com.oplus.ocs.base.common.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.HandlerC3674b;
import com.oplus.ocs.base.p193b.C3643b;

/* renamed from: com.oplus.ocs.base.common.api.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
class HandlerC3663l extends HandlerC3674b {

    /* renamed from: PlatformImplementations.kt_3 */
    static volatile int f23468a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f23469b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private AbstractC3653b f23470c;

    /* renamed from: PlatformImplementations.kt_3 */
    static synchronized HandlerC3663l m25087a(AbstractC3653b abstractC3653b) {
        StringBuilder sb = new StringBuilder("base_client_");
        int OplusGLSurfaceView_13 = f23468a;
        f23468a = OplusGLSurfaceView_13 + 1;
        sb.append(OplusGLSurfaceView_13);
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            return new HandlerC3663l(handlerThread.getLooper(), abstractC3653b);
        }
        return new HandlerC3663l(Looper.getMainLooper(), abstractC3653b);
    }

    private HandlerC3663l(Looper looper, AbstractC3653b abstractC3653b) {
        super(looper);
        this.f23469b = HandlerC3663l.class.getSimpleName();
        this.f23470c = abstractC3653b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int OplusGLSurfaceView_13 = message.what;
        C3643b.m25022a(this.f23469b, "base client handler what ".concat(String.valueOf(OplusGLSurfaceView_13)));
        if (OplusGLSurfaceView_13 == 1) {
            AbstractC3653b abstractC3653b = this.f23470c;
            CapabilityInfo capabilityInfo = (CapabilityInfo) message.obj;
            C3643b.m25023b(AbstractC3653b.f23412a, "onAuthenticateSucceed");
            abstractC3653b.f23413b = 1;
            abstractC3653b.f23414c = capabilityInfo;
            if (abstractC3653b.f23417f != null) {
                abstractC3653b.f23417f.mo25097a(capabilityInfo);
            }
            C3643b.m25022a(AbstractC3653b.f23412a, "handleAuthenticateSuccess");
            if (abstractC3653b.f23418g == null) {
                abstractC3653b.m25044a((Handler) null);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            abstractC3653b.f23418g.sendMessage(messageObtain);
            abstractC3653b.disconnect();
            return;
        }
        if (OplusGLSurfaceView_13 != 2) {
            if (OplusGLSurfaceView_13 == 3) {
                this.f23470c.f23419h.mo25083d();
                return;
            }
            if (OplusGLSurfaceView_13 != 5) {
                return;
            }
            AbstractC3653b abstractC3653b2 = this.f23470c;
            while (abstractC3653b2.f23415d.size() > 0) {
                C3643b.m25022a(AbstractC3653b.f23412a, "handleQue");
                abstractC3653b2.m25045a(abstractC3653b2.f23415d.poll());
            }
            C3643b.m25022a(AbstractC3653b.f23412a, "task queue is end");
            return;
        }
        AbstractC3653b abstractC3653b3 = this.f23470c;
        int i2 = message.arg1;
        abstractC3653b3.f23413b = 4;
        abstractC3653b3.disconnect();
        abstractC3653b3.f23414c = AbstractC3653b.m25042b(i2);
        if (abstractC3653b3.f23417f != null) {
            abstractC3653b3.f23417f.mo25097a(abstractC3653b3.f23414c);
        }
        C3643b.m25022a(AbstractC3653b.f23412a, "connect failed , error code is ".concat(String.valueOf(i2)));
        abstractC3653b3.m25043a(i2);
        if (abstractC3653b3.f23416e != null) {
            abstractC3653b3.f23416e.mo25098a();
        }
    }
}
