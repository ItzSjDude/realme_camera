package com.oplus.camera.timelapsepro;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.MyNestedScrollView;
import com.oplus.camera.screen.LayoutUtil;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import java.io.IOException;

/* compiled from: TimeLapseProGuideLayout.java */
/* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class TimeLapseProGuideLayout extends ScreenRelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f16845a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final TextureView f16846b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final TextureView f16847c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final TextureView f16848d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final MyNestedScrollView f16849e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Handler f16850f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final PlatformImplementations.kt_3 f16851g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AppCompatImageView f16852h;

    /* renamed from: OplusGLSurfaceView_13 */
    private MediaPlayer f16853i;

    /* renamed from: OplusGLSurfaceView_15 */
    private MediaPlayer f16854j;

    /* renamed from: OplusGLSurfaceView_5 */
    private MediaPlayer f16855k;

    /* renamed from: OplusGLSurfaceView_14 */
    private BaseScreenMode f16856l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f16857m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f16858n;

    /* renamed from: o */
    private Surface f16859o;

    /* renamed from: p */
    private Surface f16860p;

    /* renamed from: q */
    private Surface f16861q;

    /* compiled from: TimeLapseProGuideLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17635a();
    }

    public TimeLapseProGuideLayout(Context context, PlatformImplementations.kt_3 aVar) {
        super(context);
        this.f16856l = null;
        this.f16845a = context;
        this.f16851g = aVar;
        final View viewInflate = LayoutInflater.from(context).inflate(R.layout.time_lapse_pro_guide_layout, this);
        setBackgroundResource(R.drawable.professional_mode_guide_background);
        setClickable(true);
        this.f16852h = (AppCompatImageView) viewInflate.findViewById(R.id_renamed.close);
        this.f16852h.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IllegalStateException {
                if (TimeLapseProGuideLayout.this.f16851g != null) {
                    TimeLapseProGuideLayout.this.m17634b();
                    TimeLapseProGuideLayout.this.f16851g.mo17635a();
                }
            }
        });
        this.f16846b = (TextureView) viewInflate.findViewById(R.id_renamed.texture_car);
        this.f16847c = (TextureView) viewInflate.findViewById(R.id_renamed.texture_star);
        this.f16848d = (TextureView) viewInflate.findViewById(R.id_renamed.texture_cloud);
        this.f16849e = (MyNestedScrollView) viewInflate.findViewById(R.id_renamed.scroll);
        this.f16849e.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.2
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                View viewFindViewById;
                if (TimeLapseProGuideLayout.this.getVisibility() == 0 && (viewFindViewById = viewInflate.findViewById(R.id_renamed.divider)) != null) {
                    viewFindViewById.setVisibility(!view.canScrollVertically(-1) ? 4 : 0);
                }
            }
        });
        this.f16850f = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        m17626c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17633a() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.f16853i;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        MediaPlayer mediaPlayer2 = this.f16854j;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
        MediaPlayer mediaPlayer3 = this.f16855k;
        if (mediaPlayer3 != null) {
            mediaPlayer3.start();
        }
        this.f16850f.postDelayed(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_12$RyEy1EKPoKiDXSaqo7V7Eg1Zh3g
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17628d();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m17628d() {
        this.f16849e.scrollTo(0, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17626c() {
        this.f16846b.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.4
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                Uri uri = Uri.parse("android.resource://" + TimeLapseProGuideLayout.this.f16845a.getPackageName() + "/" + R.raw.time_lapse_pro_car_template);
                try {
                    TimeLapseProGuideLayout.this.f16853i = new MediaPlayer();
                    TimeLapseProGuideLayout.this.f16853i.setDataSource(TimeLapseProGuideLayout.this.getContext(), uri);
                    TimeLapseProGuideLayout.this.f16859o = new Surface(surfaceTexture);
                    TimeLapseProGuideLayout.this.f16853i.setSurface(TimeLapseProGuideLayout.this.f16859o);
                    TimeLapseProGuideLayout.this.f16853i.prepareAsync();
                    TimeLapseProGuideLayout.this.f16853i.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.4.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
        this.f16847c.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                Uri uri = Uri.parse("android.resource://" + TimeLapseProGuideLayout.this.f16845a.getPackageName() + "/" + R.raw.time_lapse_pro_star_template);
                try {
                    TimeLapseProGuideLayout.this.f16854j = new MediaPlayer();
                    TimeLapseProGuideLayout.this.f16854j.setDataSource(TimeLapseProGuideLayout.this.getContext(), uri);
                    TimeLapseProGuideLayout.this.f16860p = new Surface(surfaceTexture);
                    TimeLapseProGuideLayout.this.f16854j.setSurface(TimeLapseProGuideLayout.this.f16860p);
                    TimeLapseProGuideLayout.this.f16854j.prepareAsync();
                    TimeLapseProGuideLayout.this.f16854j.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
        this.f16848d.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.6
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                Uri uri = Uri.parse("android.resource://" + TimeLapseProGuideLayout.this.f16845a.getPackageName() + "/" + R.raw.time_lapse_pro_cloud_template);
                try {
                    TimeLapseProGuideLayout.this.f16855k = new MediaPlayer();
                    TimeLapseProGuideLayout.this.f16855k.setDataSource(TimeLapseProGuideLayout.this.getContext(), uri);
                    TimeLapseProGuideLayout.this.f16861q = new Surface(surfaceTexture);
                    TimeLapseProGuideLayout.this.f16855k.setSurface(TimeLapseProGuideLayout.this.f16861q);
                    TimeLapseProGuideLayout.this.f16855k.prepareAsync();
                    TimeLapseProGuideLayout.this.f16855k.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_12.6.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.f16859o != null) {
            this.f16853i = null;
        }
        if (this.f16860p != null) {
            this.f16860p = null;
        }
        if (this.f16861q != null) {
            this.f16861q = null;
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17634b() throws IllegalStateException {
        this.f16849e.scrollTo(0, 0);
        this.f16853i.pause();
        this.f16854j.pause();
        this.f16855k.pause();
    }

    public void setCurrentScreenMode(BaseScreenMode abstractC2934a) {
        this.f16856l = abstractC2934a;
        m17619a(this.f16856l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17619a(BaseScreenMode abstractC2934a) {
        LayoutUtil.m16634a(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16852h.getLayoutParams();
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_cancel_button_margin_start);
        int iJ = abstractC2934a.mo16539j();
        if (iJ == 1 || iJ == 3 || iJ == 4) {
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_guide_layout_close_margin_top_full);
            this.f16849e.setPadding(getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_guide_layout_padding_left), getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_padding_top), getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_guide_layout_padding_right), getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_padding_bottom));
            if (4 == abstractC2934a.mo16539j() && 270 == abstractC2934a.mo16570k()) {
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_cancel_button_margin_start) + Util.m24198Z();
            }
        } else {
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_guide_layout_close_margin_top);
            this.f16849e.setPadding(getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_padding_horizontal), getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_padding_top), getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_padding_horizontal), getResources().getDimensionPixelOffset(R.dimen.professional_mode_guide_padding_bottom));
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
        int iK = abstractC2934a.mo16570k();
        if (iK == 90) {
            setPadding(0, 0, 0, 0);
            this.f16857m = ScreenModeConst.f16035b;
            this.f16858n = ScreenModeConst.f16034a;
            layoutParams2.addRule(13);
            int OplusGLSurfaceView_13 = this.f16858n;
            int i2 = this.f16857m;
            layoutParams2.topMargin = (-(OplusGLSurfaceView_13 - i2)) / 2;
            layoutParams2.bottomMargin = (-(OplusGLSurfaceView_13 - i2)) / 2;
            layoutParams2.leftMargin = (OplusGLSurfaceView_13 - i2) / 2;
            layoutParams2.rightMargin = (OplusGLSurfaceView_13 - i2) / 2;
            layoutParams2.width = i2;
            layoutParams2.height = OplusGLSurfaceView_13;
            super.setRotation(90.0f);
        } else if (iK == 270) {
            setPadding(0, 0, 0, 0);
            this.f16857m = ScreenModeConst.f16035b;
            this.f16858n = ScreenModeConst.f16034a;
            layoutParams2.addRule(13);
            int i3 = this.f16858n;
            int i4 = this.f16857m;
            layoutParams2.topMargin = (-(i3 - i4)) / 2;
            layoutParams2.bottomMargin = (-(i3 - i4)) / 2;
            layoutParams2.leftMargin = (i3 - i4) / 2;
            layoutParams2.rightMargin = (i3 - i4) / 2;
            layoutParams2.width = i4;
            layoutParams2.height = i3;
            super.setRotation(270.0f);
        } else {
            setPadding(0, 0, 0, Util.m24198Z());
            layoutParams2.width = ScreenModeConst.f16034a;
            layoutParams2.height = ScreenModeConst.f16035b;
            super.setRotation(0.0f);
        }
        this.f16852h.requestLayout();
        requestLayout();
    }
}
