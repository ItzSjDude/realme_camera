package com.oplus.p125c.p126a.p132d.p134b;

import android.net.Uri;
import android.view.Surface;
import com.android.providers.downloads.Downloads;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: BaseLightVideoPlayer.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseLightVideoPlayer.kt implements ILightVideoPlayer.kt {

    /* renamed from: IntrinsicsJvm.kt_3 */
    @Deprecated
    public static final PlatformImplementations.kt_3 f10534c = new PlatformImplementations.kt_3(null);

    /* renamed from: PlatformImplementations.kt_3 */
    public Uri f10535a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Surface f10536b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10537d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f10538e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f10539f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f10540g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f10541h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f10542i;

    /* compiled from: BaseLightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9485a(Uri uri) {
        Intrinsics.m5303c(uri, "<set-?>");
        this.f10535a = uri;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final Uri m9488g() {
        Uri uri = this.f10535a;
        if (uri == null) {
            Intrinsics.m5302b(Downloads.Impl.COLUMN_URI);
        }
        return uri;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9486a(Surface surface) {
        Intrinsics.m5303c(surface, "<set-?>");
        this.f10536b = surface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9487a(ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
        this.f10537d = aVar;
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo9475c() {
        this.f10538e = true;
        this.f10539f = false;
        this.f10540g = false;
        this.f10541h = false;
        this.f10542i = false;
        m9484a(VideoRecordMsgData.EVENT_PAUSE);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m9484a(String str) {
        Comparable comparable;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",  ");
        sb.append("isPauseState = ");
        sb.append(this.f10538e);
        sb.append(", ");
        sb.append("isStopState = ");
        sb.append(this.f10539f);
        sb.append(", ");
        sb.append("isPlayingState = ");
        sb.append(this.f10540g);
        sb.append(", ");
        sb.append("isCompleteState = ");
        sb.append(this.f10541h);
        sb.append(", ");
        sb.append("isErrorState = ");
        sb.append(this.f10542i);
        sb.append(", ");
        sb.append("uri = ");
        if (this.f10535a != null) {
            comparable = this.f10535a;
            if (comparable == null) {
                Intrinsics.m5302b(Downloads.Impl.COLUMN_URI);
            }
        } else {
            comparable = "unInit";
        }
        sb.append(comparable);
        Debugger.kt.m9503a("BaseLightVideoPlayer", sb.toString());
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo9489h() {
        this.f10538e = false;
        this.f10539f = true;
        this.f10540g = false;
        this.f10541h = false;
        this.f10542i = false;
        m9484a("stop");
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void mo9490i() {
        this.f10538e = false;
        this.f10539f = false;
        this.f10540g = false;
        this.f10541h = false;
        this.f10542i = false;
        m9484a("reset");
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo9476d() {
        mo9489h();
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo9477e() {
        return this.f10540g;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m9491j() {
        return this.f10538e;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m9492k() {
        return this.f10541h;
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo9478f() {
        if (m9491j()) {
            mo9471a();
            m9495n();
            return;
        }
        if (m9492k()) {
            mo9490i();
            mo9474b();
            mo9471a();
            m9495n();
            return;
        }
        BaseLightVideoPlayer.kt abstractC2445a = this;
        if (abstractC2445a.f10535a == null || abstractC2445a.f10536b == null) {
            return;
        }
        Uri uri = this.f10535a;
        if (uri == null) {
            Intrinsics.m5302b(Downloads.Impl.COLUMN_URI);
        }
        Surface surface = this.f10536b;
        if (surface == null) {
            Intrinsics.m5302b("surfaceView");
        }
        mo9473a(uri, surface, this.f10537d);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    protected final void m9493l() {
        this.f10538e = true;
        this.f10539f = false;
        this.f10540g = false;
        this.f10541h = false;
        this.f10542i = false;
        m9484a("setCompletionStatus");
    }

    /* renamed from: OplusGLSurfaceView_6 */
    protected final void m9494m() {
        this.f10538e = false;
        this.f10539f = false;
        this.f10540g = false;
        this.f10541h = true;
        this.f10542i = false;
        m9484a("setCompletionStatus");
    }

    /* renamed from: OplusGLSurfaceView_11 */
    protected final void m9495n() {
        this.f10538e = false;
        this.f10539f = false;
        this.f10540g = true;
        this.f10541h = false;
        this.f10542i = false;
        m9484a("setPlayingStatus");
    }

    /* renamed from: o */
    protected final void m9496o() {
        this.f10538e = false;
        this.f10539f = false;
        this.f10540g = false;
        this.f10541h = false;
        this.f10542i = true;
        m9484a("setErrorStatus");
    }
}
