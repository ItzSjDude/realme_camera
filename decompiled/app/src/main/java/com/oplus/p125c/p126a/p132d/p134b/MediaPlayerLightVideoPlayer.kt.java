package com.oplus.p125c.p126a.p132d.p134b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import com.android.providers.downloads.Downloads;
import com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import java.io.IOException;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: MediaPlayerLightVideoPlayer.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public final class MediaPlayerLightVideoPlayer.kt extends BaseLightVideoPlayer.kt {

    /* renamed from: IntrinsicsJvm.kt_5 */
    @Deprecated
    public static final PlatformImplementations.kt_3 f10543d = new PlatformImplementations.kt_3(null);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private MediaPlayer f10544e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Context f10545f;

    public MediaPlayerLightVideoPlayer.kt(Context context) {
        Intrinsics.m5303c(context, "context");
        this.f10545f = context;
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {
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
        if (this.f10544e == null) {
            this.f10544e = new MediaPlayer();
        }
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(this.f10545f, uri);
            mediaPlayer.setOnPreparedListener(new IntrinsicsJvm.kt_4(mediaPlayer, this, uri, jCurrentTimeMillis, surface, aVar));
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnCompletionListener(new IntrinsicsJvm.kt_3(uri, jCurrentTimeMillis, surface, aVar));
            mediaPlayer.setOnErrorListener(new IntrinsicsJvm.kt_5(mediaPlayer, this, uri, jCurrentTimeMillis, surface, aVar));
        }
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 implements MediaPlayer.OnPreparedListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ MediaPlayer f10546a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ MediaPlayerLightVideoPlayer.kt f10547b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ Uri f10548c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final /* synthetic */ long f10549d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final /* synthetic */ Surface f10550e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        final /* synthetic */ ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10551f;

        IntrinsicsJvm.kt_4(MediaPlayer mediaPlayer, MediaPlayerLightVideoPlayer.kt c2447c, Uri uri, long OplusGLSurfaceView_15, Surface surface, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
            this.f10546a = mediaPlayer;
            this.f10547b = c2447c;
            this.f10548c = uri;
            this.f10549d = OplusGLSurfaceView_15;
            this.f10550e = surface;
            this.f10551f = aVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            PlatformImplementations.kt_3 unused = MediaPlayerLightVideoPlayer.kt.f10543d;
            Debugger.kt.m9503a("MediaLightVideoPlayer", "setOnPreparedListener uri = " + this.f10548c + ",  cost time = " + (System.currentTimeMillis() - this.f10549d));
            try {
                this.f10546a.setSurface(this.f10550e);
                this.f10546a.start();
                this.f10547b.m9495n();
                ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar = this.f10551f;
                if (aVar != null) {
                    aVar.mo9497a();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                PlatformImplementations.kt_3 unused2 = MediaPlayerLightVideoPlayer.kt.f10543d;
                Debugger.kt.m9507c("MediaLightVideoPlayer", "setOnPreparedListener, " + COUIBaseListPopupWindow_8.getMessage());
            }
        }
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    static final class IntrinsicsJvm.kt_3 implements MediaPlayer.OnCompletionListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ Uri f10553b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ long f10554c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final /* synthetic */ Surface f10555d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final /* synthetic */ ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10556e;

        IntrinsicsJvm.kt_3(Uri uri, long OplusGLSurfaceView_15, Surface surface, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
            this.f10553b = uri;
            this.f10554c = OplusGLSurfaceView_15;
            this.f10555d = surface;
            this.f10556e = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            PlatformImplementations.kt_3 unused = MediaPlayerLightVideoPlayer.kt.f10543d;
            Debugger.kt.m9503a("MediaLightVideoPlayer", "setOnCompletionListener uri = " + this.f10553b);
            MediaPlayerLightVideoPlayer.kt.this.m9493l();
            ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar = this.f10556e;
            if (aVar != null) {
                aVar.mo9499c();
            }
        }
    }

    /* compiled from: MediaPlayerLightVideoPlayer.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_5 */
    static final class IntrinsicsJvm.kt_5 implements MediaPlayer.OnErrorListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ MediaPlayer f10557a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ MediaPlayerLightVideoPlayer.kt f10558b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ Uri f10559c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final /* synthetic */ long f10560d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final /* synthetic */ Surface f10561e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        final /* synthetic */ ILightVideoPlayer.kt.PlatformImplementations.kt_3 f10562f;

        IntrinsicsJvm.kt_5(MediaPlayer mediaPlayer, MediaPlayerLightVideoPlayer.kt c2447c, Uri uri, long OplusGLSurfaceView_15, Surface surface, ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar) {
            this.f10557a = mediaPlayer;
            this.f10558b = c2447c;
            this.f10559c = uri;
            this.f10560d = OplusGLSurfaceView_15;
            this.f10561e = surface;
            this.f10562f = aVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int OplusGLSurfaceView_13, int i2) {
            PlatformImplementations.kt_3 unused = MediaPlayerLightVideoPlayer.kt.f10543d;
            Debugger.kt.m9503a("MediaLightVideoPlayer", "setOnErrorListener uri = " + this.f10559c);
            this.f10558b.m9496o();
            this.f10557a.reset();
            this.f10558b.f10544e = (MediaPlayer) null;
            ILightVideoPlayer.kt.PlatformImplementations.kt_3 aVar = this.f10562f;
            return aVar != null && aVar.mo9498a(OplusGLSurfaceView_13, i2, null);
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9471a() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        Debugger.kt.m9503a("MediaLightVideoPlayer", "start uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo9474b() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo9472a(float COUIBaseListPopupWindow_12) {
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt, com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo9475c() throws IllegalStateException {
        super.mo9475c();
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        Debugger.kt.m9503a("MediaLightVideoPlayer", "pause uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo9489h() throws IllegalStateException {
        super.mo9489h();
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        this.f10544e = (MediaPlayer) null;
        Debugger.kt.m9503a("MediaLightVideoPlayer", "stop uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo9490i() {
        super.mo9490i();
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        Debugger.kt.m9503a("MediaLightVideoPlayer", "reset uri = " + m9488g());
    }

    @Override // com.oplus.p125c.p126a.p132d.p134b.BaseLightVideoPlayer.kt, com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo9476d() throws IllegalStateException {
        super.mo9476d();
        MediaPlayer mediaPlayer = this.f10544e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.f10544e;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        this.f10544e = (MediaPlayer) null;
        Debugger.kt.m9503a("MediaLightVideoPlayer", "release uri = " + m9488g());
    }
}
