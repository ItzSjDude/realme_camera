package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.p193b.C3643b;

/* renamed from: com.oplus.ocs.base.common.api.o */
/* loaded from: classes2.dex */
class C3666o implements InterfaceC3665n {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f23476b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ServiceConnection f23477c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private IAuthenticationListener f23478d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private C3655d f23479e;

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f23475a = C3666o.class.getSimpleName();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private com.coloros.ocs.base.IAuthenticationListener f23480f = ;

    @Override // com.oplus.ocs.base.common.api.InterfaceC3665n
    /* renamed from: IntrinsicsJvm.kt_5 */
    public final void mo25083d() {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static /* synthetic */ ServiceConnection m25091d(C3666o c3666o) {
        c3666o.f23477c = null;
        return null;
    }

    public C3666o(Context context, C3655d c3655d, IAuthenticationListener iAuthenticationListener) {
        this.f23476b = context;
        this.f23479e = c3655d;
        this.f23478d = iAuthenticationListener;
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3665n
    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean mo25080a() {
        boolean z;
        byte b2 = 0;
        try {
            if (this.f23476b.getApplicationContext() != null) {
                this.f23477c = new PlatformImplementations.kt_3(this, b2);
                Context applicationContext = this.f23476b.getApplicationContext();
                com.coloros.ocs.base.IAuthenticationListener iAuthenticationListener = this.f23480f;
                Intent intentM25047a = this.f23479e.m25047a("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService");
                if (iAuthenticationListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBinder("internal_binder", iAuthenticationListener.asBinder());
                    intentM25047a.putExtra("internal_bundle", bundle);
                }
                boolean zBindService = applicationContext.bindService(intentM25047a, this.f23477c, 1);
                try {
                    C3643b.m25025d(this.f23475a, "connect state - ".concat(String.valueOf(zBindService)));
                    if (zBindService || this.f23478d == null) {
                        return zBindService;
                    }
                    this.f23478d.onFail(3);
                    return zBindService;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    z = zBindService;
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                    C3643b.m25025d(this.f23475a, String.format("in bind get an exception %s", COUIBaseListPopupWindow_8.getMessage()));
                    return z;
                }
            }
            if (this.f23478d != null) {
                this.f23478d.onFail(CommonStatusCodes.INTERNAL_EXCEPTION);
            }
            return false;
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            z = false;
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3665n
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final boolean mo25081b() {
        boolean zBindService;
        byte b2 = 0;
        try {
            if (this.f23476b.getApplicationContext() != null) {
                this.f23477c = new PlatformImplementations.kt_3(this, b2);
                zBindService = this.f23476b.getApplicationContext().bindService(this.f23479e.m25049b("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"), this.f23477c, 1);
                try {
                    C3643b.m25025d(this.f23475a, "connect stat state - ".concat(String.valueOf(zBindService)));
                    if (zBindService || this.f23478d == null) {
                        return zBindService;
                    }
                    this.f23478d.onFail(3);
                    return zBindService;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                    C3643b.m25025d(this.f23475a, String.format("in bind get an exception %s", COUIBaseListPopupWindow_8.getMessage()));
                    return zBindService;
                }
            }
            if (this.f23478d != null) {
                this.f23478d.onFail(CommonStatusCodes.INTERNAL_EXCEPTION);
            }
            return false;
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            zBindService = false;
        }
    }

    @Override // com.oplus.ocs.base.common.api.InterfaceC3665n
    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void mo25082c() {
        if (this.f23477c == null) {
            C3643b.m25025d(this.f23475a, "mServiceConnectionImpl is null");
        } else if (this.f23476b.getApplicationContext() != null) {
            try {
                this.f23476b.getApplicationContext().unbindService(this.f23477c);
            } catch (Exception COUIBaseListPopupWindow_8) {
                C3643b.m25025d(this.f23475a, String.format("in unbind get an exception %s", COUIBaseListPopupWindow_8.getMessage()));
            }
        }
    }

    /* renamed from: com.oplus.ocs.base.common.api.o$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 implements ServiceConnection {
        private PlatformImplementations.kt_3() {
        }

        /* synthetic */ PlatformImplementations.kt_3(C3666o c3666o, byte b2) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (C3666o.this.f23479e != null) {
                    C3666o.this.f23479e.m25048a();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            C3643b.m25023b(C3666o.this.f23475a, "onServiceDisconnected()");
            C3666o.m25091d(C3666o.this);
        }
    }
}
