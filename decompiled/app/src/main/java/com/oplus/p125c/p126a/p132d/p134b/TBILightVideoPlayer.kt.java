package com.oplus.p125c.p126a.p132d.p134b;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.android.providers.downloads.Downloads;
import com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.TBLPlayerManager;
import java.io.IOException;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: TBILightVideoPlayer.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class TBILightVideoPlayer.kt extends BaseLightVideoPlayer.kt {

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final PlatformImplementations.kt_3 f10563d = new PlatformImplementations.kt_3(null);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IMediaPlayer f10564e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Context f10565f;

    public TBILightVideoPlayer.kt(Context context) {
        Intrinsics.m5303c(context, "context");
        this.f10565f = context;
    }

    /* compiled from: TBILightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9473a(Uri uri, Surface surface, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Intrinsics.m5303c(uri, Downloads.Impl.COLUMN_URI);
        Intrinsics.m5303c(surface, "surface");
        long jCurrentTimeMillis = System.currentTimeMillis();
        m9485a(uri);
        m9486a(surface);
        m9487a(aVar);
        if (this.f10564e == null) {
            this.f10564e = TBLPlayerManager.createPlayer(this.f10565f);
        }
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            iMediaPlayer.setDataSource(uri);
            iMediaPlayer.setSurface(surface);
            iMediaPlayer.setOnPreparedListener(new IntrinsicsJvm.kt_4(iMediaPlayer, this, uri, surface, jCurrentTimeMillis, aVar));
            iMediaPlayer.prepareAsync();
            iMediaPlayer.setOnCompletionListener(new IntrinsicsJvm.kt_3(uri, surface, jCurrentTimeMillis, aVar));
            iMediaPlayer.setOnErrorListener(new IntrinsicsJvm.kt_5(iMediaPlayer, this, uri, surface, jCurrentTimeMillis, aVar));
        }
    }

    /* compiled from: TBILightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 implements IMediaPlayer.OnPreparedListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ IMediaPlayer f10566a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ TBILightVideoPlayer.kt f10567b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ Uri f10568c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final /* synthetic */ Surface f10569d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final /* synthetic */ long f10570e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        final /* synthetic */ ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10571f;

        IntrinsicsJvm.kt_4(IMediaPlayer iMediaPlayer, TBILightVideoPlayer.kt c2448d, Uri uri, Surface surface, long OplusGLSurfaceView_15, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
            this.f10566a = iMediaPlayer;
            this.f10567b = c2448d;
            this.f10568c = uri;
            this.f10569d = surface;
            this.f10570e = OplusGLSurfaceView_15;
            this.f10571f = aVar;
        }

        @Override // com.oplus.tblplayer.IMediaPlayer.OnPreparedListener
        public final void onPrepared(IMediaPlayer iMediaPlayer) throws IllegalStateException {
            Debugger.kt.m9503a("TBILightVideoPlayer", "setOnPreparedListener uri = " + this.f10568c + ",  cost time = " + (System.currentTimeMillis() - this.f10570e));
            this.f10566a.setSurface(this.f10569d);
            this.f10566a.start();
            this.f10567b.m9495n();
            ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar = this.f10571f;
            if (aVar != null) {
                aVar.mo9497a();
            }
        }
    }

    /* compiled from: TBILightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    static final class IntrinsicsJvm.kt_3 implements IMediaPlayer.OnCompletionListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ Uri f10573b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ Surface f10574c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final /* synthetic */ long f10575d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final /* synthetic */ ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10576e;

        IntrinsicsJvm.kt_3(Uri uri, Surface surface, long OplusGLSurfaceView_15, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
            this.f10573b = uri;
            this.f10574c = surface;
            this.f10575d = OplusGLSurfaceView_15;
            this.f10576e = aVar;
        }

        @Override // com.oplus.tblplayer.IMediaPlayer.OnCompletionListener
        public final void onCompletion(IMediaPlayer iMediaPlayer) {
            Debugger.kt.m9503a("TBILightVideoPlayer", "setOnCompletionListener uri = " + this.f10573b);
            TBILightVideoPlayer.kt.this.m9494m();
            ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar = this.f10576e;
            if (aVar != null) {
                aVar.mo9499c();
            }
        }
    }

    /* compiled from: TBILightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_5 */
    static final class IntrinsicsJvm.kt_5 implements IMediaPlayer.OnErrorListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ IMediaPlayer f10577a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ TBILightVideoPlayer.kt f10578b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ Uri f10579c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final /* synthetic */ Surface f10580d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final /* synthetic */ long f10581e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        final /* synthetic */ ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10582f;

        IntrinsicsJvm.kt_5(IMediaPlayer iMediaPlayer, TBILightVideoPlayer.kt c2448d, Uri uri, Surface surface, long OplusGLSurfaceView_15, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
            this.f10577a = iMediaPlayer;
            this.f10578b = c2448d;
            this.f10579c = uri;
            this.f10580d = surface;
            this.f10581e = OplusGLSurfaceView_15;
            this.f10582f = aVar;
        }

        @Override // com.oplus.tblplayer.IMediaPlayer.OnErrorListener
        public final boolean onError(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, String str) {
            Debugger.kt.m9503a("TBILightVideoPlayer", "setOnErrorListener uri = " + this.f10579c);
            this.f10578b.m9496o();
            this.f10577a.release();
            this.f10578b.f10564e = (IMediaPlayer) null;
            ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar = this.f10582f;
            return aVar != null && aVar.mo9498a(OplusGLSurfaceView_13, i2, str);
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9471a() throws IllegalStateException {
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.start();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo9474b() throws IllegalStateException {
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.prepareAsync();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9472a(float COUIBaseListPopupWindow_12) {
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt, com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo9475c() throws IllegalStateException {
        super.mo9475c();
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.pause();
        }
        Debugger.kt.m9503a("TBILightVideoPlayer", "pause uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo9489h() throws IllegalStateException {
        super.mo9489h();
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
        }
        this.f10564e = (IMediaPlayer) null;
        Debugger.kt.m9503a("TBILightVideoPlayer", "stop uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo9490i() {
        super.mo9490i();
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
        }
        Debugger.kt.m9503a("TBILightVideoPlayer", "reset uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt, com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo9476d() {
        super.mo9476d();
        IMediaPlayer iMediaPlayer = this.f10564e;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
        }
        this.f10564e = (IMediaPlayer) null;
        Debugger.kt.m9503a("TBILightVideoPlayer", "release uri = " + m9488g());
    }
}
