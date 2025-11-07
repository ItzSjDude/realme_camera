package com.oplus.p125c.p126a;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.android.providers.downloads.Downloads;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.p125c.p126a.p132d.p134b.MediaPlayerLightVideoPlayer.kt;
import com.oplus.p125c.p126a.p132d.p134b.TBILightVideoPlayer.kt;
import com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt;
import p061c.NoWhenBranchMatchedException.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: LightVideoPlayer.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class LightVideoPlayer.kt implements ILightVideoPlayer.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private ILightVideoPlayer.kt f10532a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Context f10533b;

    /* compiled from: LightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        TBL,
        MEDIA_PLAYER
    }

    public LightVideoPlayer.kt(Context context, PlatformImplementations.kt_3 aVar) {
        MediaPlayerLightVideoPlayer.kt c2447c;
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(aVar, CameraParameter.TiltShiftParamKeys.TYPE);
        this.f10533b = context;
        int OplusGLSurfaceView_13 = C2449e.f10583a[aVar.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            c2447c = new MediaPlayerLightVideoPlayer.kt(this.f10533b);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                throw new NoWhenBranchMatchedException.kt();
            }
            c2447c = new TBILightVideoPlayer.kt(this.f10533b);
        }
        this.f10532a = c2447c;
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9473a(Uri uri, Surface surface, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
        Intrinsics.m5303c(uri, Downloads.Impl.COLUMN_URI);
        Intrinsics.m5303c(surface, "surface");
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9473a(uri, surface, aVar);
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9471a() {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9471a();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo9474b() {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9474b();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9472a(float COUIBaseListPopupWindow_12) {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9472a(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo9475c() {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9475c();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo9476d() {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9476d();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo9477e() {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        return interfaceC2446b != null && interfaceC2446b.mo9477e();
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo9478f() {
        ILightVideoPlayer.kt interfaceC2446b = this.f10532a;
        if (interfaceC2446b != null) {
            interfaceC2446b.mo9478f();
        }
    }
}
