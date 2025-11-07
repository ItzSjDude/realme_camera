package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import p061c.Unit.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: HandlerDispatcher.kt */
/* renamed from: kotlinx.coroutines.android.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class HandlerDispatcher.kt_2 extends HandlerDispatcher.kt_4 {
    private volatile HandlerDispatcher.kt_2 _immediate;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final HandlerDispatcher.kt_2 f24581b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Handler f24582d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f24583e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f24584f;

    private HandlerDispatcher.kt_2(Handler handler, String str, boolean z) {
        super(null);
        this.f24582d = handler;
        this.f24583e = str;
        this.f24584f = z;
        this._immediate = this.f24584f ? this : null;
        HandlerDispatcher.kt_2 c3868a = this._immediate;
        if (c3868a == null) {
            c3868a = new HandlerDispatcher.kt_2(this.f24582d, this.f24583e, true);
            this._immediate = c3868a;
            Unit.kt c1025s = Unit.kt.f5071a;
        }
        this.f24581b = c3868a;
    }

    public /* synthetic */ HandlerDispatcher.kt_2(Handler handler, String str, int OplusGLSurfaceView_13, DefaultConstructorMarker c0970f) {
        this(handler, (OplusGLSurfaceView_13 & 2) != 0 ? (String) null : str);
    }

    public HandlerDispatcher.kt_2(Handler handler, String str) {
        this(handler, str, false);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher.kt
    /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
    public HandlerDispatcher.kt_2 mo25639a() {
        return this.f24581b;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25640a(CoroutineContext.kt_4 interfaceC0932g) {
        return !this.f24584f || (Intrinsics.m5299a(Looper.myLooper(), this.f24582d.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        this.f24582d.post(runnable);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher.kt, kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        String strB = m25786b();
        if (strB != null) {
            return strB;
        }
        HandlerDispatcher.kt_2 c3868a = this;
        String string = c3868a.f24583e;
        if (string == null) {
            string = c3868a.f24582d.toString();
        }
        if (!c3868a.f24584f) {
            return string;
        }
        return string + ".immediate";
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerDispatcher.kt_2) && ((HandlerDispatcher.kt_2) obj).f24582d == this.f24582d;
    }

    public int hashCode() {
        return System.identityHashCode(this.f24582d);
    }
}
