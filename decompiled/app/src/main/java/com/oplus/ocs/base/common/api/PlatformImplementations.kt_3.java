package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.api.C3652a.IntrinsicsJvm.kt_3;
import com.oplus.ocs.base.internal.C3676a;
import com.oplus.ocs.base.p193b.C3645d;

/* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class C3652a<O extends IntrinsicsJvm.kt_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3<?, O> f23406a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUIBaseListPopupWindow_12<?> f23407b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23408c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f23409d;

    /* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3<T extends COUIBaseListPopupWindow_8, O> extends IntrinsicsJvm.kt_5<T, O> {
        public abstract T buildClient(Context context, Looper looper, C3676a c3676a, O o);
    }

    /* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4<C> {
    }

    /* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
    }

    /* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    public static abstract class IntrinsicsJvm.kt_5<T, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        <T> void addQueue(C3660i<T> c3660i);

        void connect();

        void disconnect();

        AuthResult getAuthResult();

        int getMinApkVersion();

        IBinder getRemoteService();

        boolean isConnected();

        void setOnCapabilityAuthListener(InterfaceC3669r interfaceC3669r);

        void setOnClearListener(InterfaceC3670s interfaceC3670s);

        void setOnConnectionFailedListener(InterfaceC3656e interfaceC3656e, Handler handler);

        void setOnConnectionSucceedListener(InterfaceC3657f interfaceC3657f, Handler handler);
    }

    /* renamed from: com.oplus.ocs.base.common.api.PlatformImplementations.kt_3$COUIBaseListPopupWindow_12 */
    public static class COUIBaseListPopupWindow_12<C extends COUIBaseListPopupWindow_8> extends IntrinsicsJvm.kt_4<C> {
    }

    public <C extends COUIBaseListPopupWindow_8> C3652a(String str, PlatformImplementations.kt_3<C, O> aVar, COUIBaseListPopupWindow_12<C> fVar) {
        this(str, aVar, fVar, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends COUIBaseListPopupWindow_8> C3652a(String str, PlatformImplementations.kt_3<C, O> aVar, COUIBaseListPopupWindow_12<C> fVar, boolean z) {
        C3645d.m25030a(aVar, "can not construct whit the null AbstractClientBuilder");
        C3645d.m25030a(fVar, "can not construct with the null ClientKey");
        this.f23408c = str;
        this.f23406a = aVar;
        this.f23407b = fVar;
        this.f23409d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PlatformImplementations.kt_3<?, O> m25037a() {
        C3645d.m25032a(this.f23406a != null, "The ClientBuilder is null");
        return this.f23406a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public COUIBaseListPopupWindow_12<?> m25038b() {
        COUIBaseListPopupWindow_12<?> fVar = this.f23407b;
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalStateException("This API was constructed with null clientKey.");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m25039c() {
        return this.f23409d;
    }
}
