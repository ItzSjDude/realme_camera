package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.p193b.C3643b;

/* renamed from: com.oplus.ocs.base.common.api.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class C3655d implements Handler.Callback {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23427a = "IntrinsicsJvm.kt_5";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f23428b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23429c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f23430d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f23431e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f23432f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f23433g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private IAuthenticationListener f23434h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Handler f23435i;

    /* renamed from: OplusGLSurfaceView_15 */
    private InterfaceC3665n f23436j;

    public C3655d(Context context, String str, String str2, int OplusGLSurfaceView_13, boolean z, IAuthenticationListener iAuthenticationListener) {
        this(context, str, str2, OplusGLSurfaceView_13, z, false, iAuthenticationListener);
    }

    public C3655d(Context context, String str, String str2, int OplusGLSurfaceView_13, boolean z, boolean z2, IAuthenticationListener iAuthenticationListener) {
        this.f23432f = false;
        this.f23428b = context.getApplicationContext();
        this.f23434h = iAuthenticationListener;
        this.f23430d = str;
        this.f23429c = str2;
        this.f23431e = OplusGLSurfaceView_13;
        this.f23432f = z;
        this.f23433g = z2;
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.f23435i = new Handler(handlerThread.getLooper(), this);
        } else {
            this.f23435i = new Handler(this);
        }
        C3662k.m25084a();
        this.f23436j = C3662k.m25085a(this.f23428b, this, this.f23434h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Intent m25047a(String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(str2, str3));
        intent.putExtra("bind_type", 1);
        intent.putExtra("internal_third_packagename", this.f23430d);
        intent.putExtra("internal_capability_client", this.f23429c);
        intent.putExtra("internal_third_pid", this.f23431e);
        intent.putExtra("internal_active_write_permits", this.f23432f);
        intent.putExtra("internal_base_version", "1.0.11");
        intent.putExtra("internal_wait_service", this.f23433g);
        intent.setType("internal_service_" + this.f23429c);
        return intent;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    Intent m25049b(String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(str2, str3));
        intent.putExtra("bind_type", 2);
        intent.putExtra("internal_third_packagename", this.f23430d);
        intent.putExtra("internal_capability_client", this.f23429c);
        intent.setType("internal_service_" + this.f23429c);
        return intent;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m25048a() {
        this.f23435i.sendEmptyMessage(CommonStatusCodes.AUTHENTICATE_SUCCESS);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m25050b() {
        InterfaceC3665n interfaceC3665n = this.f23436j;
        if (interfaceC3665n != null) {
            return interfaceC3665n.mo25080a();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m25051c() {
        InterfaceC3665n interfaceC3665n = this.f23436j;
        if (interfaceC3665n != null) {
            return interfaceC3665n.mo25081b();
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterfaceC3665n interfaceC3665n;
        C3643b.m25022a(f23427a, String.format("current thread - %s and what - %IntrinsicsJvm.kt_5", Thread.currentThread().getName(), Integer.valueOf(message.what)));
        if (message.what == 1001 && (interfaceC3665n = this.f23436j) != null) {
            interfaceC3665n.mo25082c();
        }
        return false;
    }
}
