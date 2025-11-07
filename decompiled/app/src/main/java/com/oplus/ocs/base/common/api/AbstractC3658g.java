package com.oplus.ocs.base.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.api.AbstractC3658g;
import com.oplus.ocs.base.common.api.C3652a;
import com.oplus.ocs.base.common.api.C3652a.IntrinsicsJvm.kt_3;
import com.oplus.ocs.base.common.api.C3660i;
import com.oplus.ocs.base.internal.C3676a;
import com.oplus.ocs.base.p192a.AbstractC3639a;
import com.oplus.ocs.base.p192a.C3640b;
import com.oplus.ocs.base.p193b.C3642a;
import com.oplus.ocs.base.p193b.C3643b;
import com.oplus.ocs.base.p193b.C3645d;

/* renamed from: com.oplus.ocs.base.common.api.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public abstract class AbstractC3658g<O extends C3652a.IntrinsicsJvm.kt_3, R extends AbstractC3658g> {

    /* renamed from: PlatformImplementations.kt_3 */
    O f23438a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f23439b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private C3652a<O> f23440c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private C3672u f23441d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private C3676a f23442e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f23443f;

    protected void checkAuthResult(CapabilityInfo capabilityInfo) {
    }

    protected String getClientName() {
        return "";
    }

    public abstract int getVersion();

    public abstract boolean hasFeature(String str);

    protected abstract void init();

    public AbstractC3658g(Context context, C3652a<O> c3652a, C3676a c3676a) {
        this(context, c3652a, null, c3676a, true);
    }

    public AbstractC3658g(Activity activity, C3652a<O> c3652a, O o, C3676a c3676a) {
        this(activity, c3652a, o, c3676a, true);
    }

    public AbstractC3658g(Context context, C3652a<O> c3652a, O o, C3676a c3676a) {
        this(context, c3652a, o, c3676a, true);
    }

    public AbstractC3658g(Context context, C3652a<O> c3652a, O o, C3676a c3676a, boolean z) {
        C3645d.m25030a(context, "Null context is not permitted.");
        C3645d.m25030a(c3652a, "Api must not be null.");
        this.f23439b = context;
        this.f23440c = c3652a;
        this.f23438a = o;
        this.f23442e = c3676a;
        this.f23443f = z;
        if (this.f23443f) {
            this.f23441d = C3672u.m25099a(this.f23439b);
            this.f23441d.m25110a(this, this.f23442e);
        } else {
            if (this.f23440c.m25039c()) {
                return;
            }
            Context context2 = this.f23439b;
            new C3655d(context2, context2.getPackageName(), getClientName(), 0, false, null).m25051c();
        }
    }

    protected C3652a<O> getApi() {
        return this.f23440c;
    }

    protected IBinder getRemoteService() {
        if (this.f23443f) {
            return C3672u.m25104b(this);
        }
        return null;
    }

    protected boolean isConnected() {
        if (this.f23443f) {
            return C3672u.m25107e(this);
        }
        return true;
    }

    protected void releaseClientKey() {
        if (this.f23443f) {
            C3672u.m25100a(this.f23440c.m25038b());
        }
    }

    protected int getRemoteVersion() {
        if (this.f23443f) {
            return C3672u.m25105c(this);
        }
        return 0;
    }

    protected void checkCapability() {
        if (this.f23441d != null) {
            C3672u.m25101a(this);
        }
    }

    protected void addThis2Cache() {
        if (this.f23443f) {
            this.f23441d.m25110a(this, this.f23442e);
        }
    }

    protected void disconnect() {
        if (this.f23443f) {
            C3672u c3672u = this.f23441d;
            C3652a<O> c3652a = this.f23440c;
            Message messageObtainMessage = c3672u.f23503b.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = c3652a;
            c3672u.f23503b.sendMessage(messageObtainMessage);
        }
    }

    protected static boolean checkInternal(Context context) {
        return C3642a.m25016a(context);
    }

    protected boolean checkExist() {
        return C3642a.m25017a(this.f23439b, "com.coloros.ocs.opencapabilityservice") || C3642a.m25017a(this.f23439b, "com.oplus.ocs");
    }

    protected AuthResult getAuthResult() {
        if (this.f23443f) {
            return C3672u.m25106d(this);
        }
        return null;
    }

    public R addOnConnectionSucceedListener(InterfaceC3657f interfaceC3657f) {
        return (R) addOnConnectionSucceedListener(interfaceC3657f, new Handler(Looper.getMainLooper()));
    }

    public R addOnConnectionFailedListener(InterfaceC3656e interfaceC3656e) {
        return (R) addOnConnectionFailedListener(interfaceC3656e, new Handler(Looper.getMainLooper()));
    }

    public R addOnConnectionSucceedListener(final InterfaceC3657f interfaceC3657f, Handler handler) {
        if (this.f23443f) {
            this.f23441d.m25109a(this, interfaceC3657f, handler);
        } else if (interfaceC3657f != null) {
            if (handler == null) {
                interfaceC3657f.m25053a();
            } else {
                handler.post(new Runnable() { // from class: com.oplus.ocs.base.common.api.COUIBaseListPopupWindow_11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC3657f.m25053a();
                    }
                });
            }
        }
        return this;
    }

    public R addOnConnectionFailedListener(InterfaceC3656e interfaceC3656e, Handler handler) {
        if (this.f23443f) {
            C3672u.m25102a(this, interfaceC3656e, handler);
        }
        return this;
    }

    protected <TResult> AbstractC3639a<TResult> doRegisterListener(C3660i.IntrinsicsJvm.kt_4<TResult> bVar, C3660i.PlatformImplementations.kt_3<TResult> aVar) {
        return doRegisterListener(Looper.getMainLooper(), bVar, aVar);
    }

    protected <TResult> AbstractC3639a<TResult> doRegisterListener(Looper looper, C3660i.IntrinsicsJvm.kt_4<TResult> bVar, C3660i.PlatformImplementations.kt_3<TResult> aVar) {
        C3643b.m25021a("capability doRegisterListener");
        C3640b c3640b = new C3640b();
        C3660i c3660i = new C3660i(looper, c3640b, bVar, aVar);
        if (this.f23443f) {
            C3672u.m25103a(this, c3660i);
        }
        return c3640b;
    }
}
