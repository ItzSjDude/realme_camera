package kotlinx.coroutines.internal;

import kotlinx.coroutines.MainCoroutineDispatcher.kt;
import p061c.ExceptionsH.kt;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: MainDispatchers.kt */
/* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
final class MainDispatchers.kt_2 extends MainCoroutineDispatcher.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Throwable f24712b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f24713d;

    public MainDispatchers.kt_2(Throwable th, String str) {
        this.f24712b = th;
        this.f24713d = str;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public MainCoroutineDispatcher.kt mo25639a() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25640a(CoroutineContext.kt_4 interfaceC0932g) {
        m25884c();
        throw new ExceptionsH.kt();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        m25884c();
        throw new ExceptionsH.kt();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void m25884c() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f24712b
            if (r0 == 0) goto L39
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f24713d
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r4 = r4.f24712b
            r1.<init>(r0, r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L39:
            kotlinx.coroutines.internal.MainDispatchers.kt.m25880a()
            IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 r4 = new IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.MainDispatchers.kt_2.m25884c():java.lang.Void");
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher.kt, kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f24712b != null) {
            str = ", cause=" + this.f24712b;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
