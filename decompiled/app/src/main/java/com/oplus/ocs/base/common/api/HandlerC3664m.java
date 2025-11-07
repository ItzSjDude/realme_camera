package com.oplus.ocs.base.common.api;

import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.C3650a;
import com.oplus.ocs.base.common.HandlerC3674b;
import com.oplus.ocs.base.p193b.C3643b;

/* renamed from: com.oplus.ocs.base.common.api.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
class HandlerC3664m extends HandlerC3674b {

    /* renamed from: PlatformImplementations.kt_3 */
    InterfaceC3657f f23471a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    InterfaceC3656e f23472b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f23473c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private HandlerC3663l f23474d;

    HandlerC3664m(Looper looper, HandlerC3663l handlerC3663l) {
        super(looper);
        this.f23473c = HandlerC3664m.class.getSimpleName();
        this.f23474d = handlerC3663l;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int OplusGLSurfaceView_13 = message.what;
        C3643b.m25022a(this.f23473c, "business handler what ".concat(String.valueOf(OplusGLSurfaceView_13)));
        if (OplusGLSurfaceView_13 == 100) {
            InterfaceC3657f interfaceC3657f = this.f23471a;
            if (interfaceC3657f != null) {
                interfaceC3657f.m25053a();
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            this.f23474d.sendMessage(messageObtain);
            return;
        }
        if (OplusGLSurfaceView_13 != 101) {
            return;
        }
        int i2 = message.arg1;
        InterfaceC3656e interfaceC3656e = this.f23472b;
        if (interfaceC3656e != null) {
            interfaceC3656e.m25052a(new C3650a(i2));
            return;
        }
        Message messageObtain2 = Message.obtain();
        messageObtain2.what = 5;
        this.f23474d.sendMessage(messageObtain2);
    }
}
