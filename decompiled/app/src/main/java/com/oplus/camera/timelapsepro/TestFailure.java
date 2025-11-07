package com.oplus.camera.timelapsepro;

/* compiled from: TimeLapseProGuideLayout.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.camera.screen.ScreenRelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f5681a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.TextureView f5682b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.view.TextureView f5683c;
    private final android.view.TextureView d_renamed;
    private final com.oplus.camera.ui.widget.MyNestedScrollView e_renamed;
    private final android.os.Handler f_renamed;
    private final com.oplus.camera.timelapsepro.f_renamed.a_renamed g_renamed;
    private final androidx.appcompat.widget.AppCompatImageView h_renamed;
    private android.media.MediaPlayer i_renamed;
    private android.media.MediaPlayer j_renamed;
    private android.media.MediaPlayer k_renamed;
    private com.oplus.camera.screen.b_renamed.a_renamed l_renamed;
    private int m_renamed;
    private int n_renamed;
    private android.view.Surface o_renamed;
    private android.view.Surface p_renamed;
    private android.view.Surface q_renamed;

    /* compiled from: TimeLapseProGuideLayout.java */
    public interface a_renamed {
        void a_renamed();
    }

    public f_renamed(android.content.Context context, com.oplus.camera.timelapsepro.f_renamed.a_renamed aVar) {
        super(context);
        this.l_renamed = null;
        this.f5681a = context;
        this.g_renamed = aVar;
        final android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.oplus.camera.R_renamed.layout.time_lapse_pro_guide_layout, this);
        setBackgroundResource(com.oplus.camera.R_renamed.drawable.professional_mode_guide_background);
        setClickable(true);
        this.h_renamed = (androidx.appcompat.widget.AppCompatImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.close);
        this.h_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) throws java.lang.IllegalStateException {
                if (com.oplus.camera.timelapsepro.f_renamed.this.g_renamed != null) {
                    com.oplus.camera.timelapsepro.f_renamed.this.b_renamed();
                    com.oplus.camera.timelapsepro.f_renamed.this.g_renamed.a_renamed();
                }
            }
        });
        this.f5682b = (android.view.TextureView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.texture_car);
        this.f5683c = (android.view.TextureView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.texture_star);
        this.d_renamed = (android.view.TextureView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.texture_cloud);
        this.e_renamed = (com.oplus.camera.ui.widget.MyNestedScrollView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.scroll);
        this.e_renamed.setOnScrollChangeListener(new android.view.View.OnScrollChangeListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.2
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(android.view.View view, int i_renamed, int i2, int i3, int i4) {
                android.view.View viewFindViewById;
                if (com.oplus.camera.timelapsepro.f_renamed.this.getVisibility() == 0 && (viewFindViewById = viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.divider)) != null) {
                    viewFindViewById.setVisibility(!view.canScrollVertically(-1) ? 4 : 0);
                }
            }
        });
        this.f_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.timelapsepro.f_renamed.3
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
            }
        };
        c_renamed();
    }

    public void a_renamed() throws java.lang.IllegalStateException {
        android.media.MediaPlayer mediaPlayer = this.i_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        android.media.MediaPlayer mediaPlayer2 = this.j_renamed;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
        android.media.MediaPlayer mediaPlayer3 = this.k_renamed;
        if (mediaPlayer3 != null) {
            mediaPlayer3.start();
        }
        this.f_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$f_renamed$RyEy1EKPoKiDXSaqo7V7Eg1Zh3g
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.d_renamed();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed() {
        this.e_renamed.scrollTo(0, 0);
    }

    private void c_renamed() {
        this.f5682b.setSurfaceTextureListener(new android.view.TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.4
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
                android.net.Uri uri = android.net.Uri.parse("android.resource://" + com.oplus.camera.timelapsepro.f_renamed.this.f5681a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.time_lapse_pro_car_template);
                try {
                    com.oplus.camera.timelapsepro.f_renamed.this.i_renamed = new android.media.MediaPlayer();
                    com.oplus.camera.timelapsepro.f_renamed.this.i_renamed.setDataSource(com.oplus.camera.timelapsepro.f_renamed.this.getContext(), uri);
                    com.oplus.camera.timelapsepro.f_renamed.this.o_renamed = new android.view.Surface(surfaceTexture);
                    com.oplus.camera.timelapsepro.f_renamed.this.i_renamed.setSurface(com.oplus.camera.timelapsepro.f_renamed.this.o_renamed);
                    com.oplus.camera.timelapsepro.f_renamed.this.i_renamed.prepareAsync();
                    com.oplus.camera.timelapsepro.f_renamed.this.i_renamed.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.4.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(android.media.MediaPlayer mediaPlayer) throws java.lang.IllegalStateException {
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                } catch (java.io.IOException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
        this.f5683c.setSurfaceTextureListener(new android.view.TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
                android.net.Uri uri = android.net.Uri.parse("android.resource://" + com.oplus.camera.timelapsepro.f_renamed.this.f5681a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.time_lapse_pro_star_template);
                try {
                    com.oplus.camera.timelapsepro.f_renamed.this.j_renamed = new android.media.MediaPlayer();
                    com.oplus.camera.timelapsepro.f_renamed.this.j_renamed.setDataSource(com.oplus.camera.timelapsepro.f_renamed.this.getContext(), uri);
                    com.oplus.camera.timelapsepro.f_renamed.this.p_renamed = new android.view.Surface(surfaceTexture);
                    com.oplus.camera.timelapsepro.f_renamed.this.j_renamed.setSurface(com.oplus.camera.timelapsepro.f_renamed.this.p_renamed);
                    com.oplus.camera.timelapsepro.f_renamed.this.j_renamed.prepareAsync();
                    com.oplus.camera.timelapsepro.f_renamed.this.j_renamed.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(android.media.MediaPlayer mediaPlayer) throws java.lang.IllegalStateException {
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                } catch (java.io.IOException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
        this.d_renamed.setSurfaceTextureListener(new android.view.TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.6
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
                android.net.Uri uri = android.net.Uri.parse("android.resource://" + com.oplus.camera.timelapsepro.f_renamed.this.f5681a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.time_lapse_pro_cloud_template);
                try {
                    com.oplus.camera.timelapsepro.f_renamed.this.k_renamed = new android.media.MediaPlayer();
                    com.oplus.camera.timelapsepro.f_renamed.this.k_renamed.setDataSource(com.oplus.camera.timelapsepro.f_renamed.this.getContext(), uri);
                    com.oplus.camera.timelapsepro.f_renamed.this.q_renamed = new android.view.Surface(surfaceTexture);
                    com.oplus.camera.timelapsepro.f_renamed.this.k_renamed.setSurface(com.oplus.camera.timelapsepro.f_renamed.this.q_renamed);
                    com.oplus.camera.timelapsepro.f_renamed.this.k_renamed.prepareAsync();
                    com.oplus.camera.timelapsepro.f_renamed.this.k_renamed.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.timelapsepro.f_renamed.6.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(android.media.MediaPlayer mediaPlayer) throws java.lang.IllegalStateException {
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                } catch (java.io.IOException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.o_renamed != null) {
            this.i_renamed = null;
        }
        if (this.p_renamed != null) {
            this.p_renamed = null;
        }
        if (this.q_renamed != null) {
            this.q_renamed = null;
        }
        super.onDetachedFromWindow();
    }

    public void b_renamed() throws java.lang.IllegalStateException {
        this.e_renamed.scrollTo(0, 0);
        this.i_renamed.pause();
        this.j_renamed.pause();
        this.k_renamed.pause();
    }

    public void setCurrentScreenMode(com.oplus.camera.screen.b_renamed.a_renamed aVar) {
        this.l_renamed = aVar;
        a_renamed(this.l_renamed);
    }

    private void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar) {
        com.oplus.camera.screen.d_renamed.a_renamed(this);
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.h_renamed.getLayoutParams();
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_cancel_button_margin_start);
        int iJ = aVar.j_renamed();
        if (iJ == 1 || iJ == 3 || iJ == 4) {
            layoutParams.topMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_layout_close_margin_top_full);
            this.e_renamed.setPadding(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_layout_padding_left), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_padding_top), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_layout_padding_right), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_padding_bottom));
            if (4 == aVar.j_renamed() && 270 == aVar.k_renamed()) {
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_cancel_button_margin_start) + com.oplus.camera.util.Util.Z_renamed();
            }
        } else {
            layoutParams.topMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_layout_close_margin_top);
            this.e_renamed.setPadding(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_padding_horizontal), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_padding_top), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_padding_horizontal), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.professional_mode_guide_padding_bottom));
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) getLayoutParams();
        int iK = aVar.k_renamed();
        if (iK == 90) {
            setPadding(0, 0, 0, 0);
            this.m_renamed = com.oplus.camera.screen.f_renamed.f5372b;
            this.n_renamed = com.oplus.camera.screen.f_renamed.f5371a;
            layoutParams2.addRule(13);
            int i_renamed = this.n_renamed;
            int i2 = this.m_renamed;
            layoutParams2.topMargin = (-(i_renamed - i2)) / 2;
            layoutParams2.bottomMargin = (-(i_renamed - i2)) / 2;
            layoutParams2.leftMargin = (i_renamed - i2) / 2;
            layoutParams2.rightMargin = (i_renamed - i2) / 2;
            layoutParams2.width = i2;
            layoutParams2.height = i_renamed;
            super.setRotation(90.0f);
        } else if (iK == 270) {
            setPadding(0, 0, 0, 0);
            this.m_renamed = com.oplus.camera.screen.f_renamed.f5372b;
            this.n_renamed = com.oplus.camera.screen.f_renamed.f5371a;
            layoutParams2.addRule(13);
            int i3 = this.n_renamed;
            int i4 = this.m_renamed;
            layoutParams2.topMargin = (-(i3 - i4)) / 2;
            layoutParams2.bottomMargin = (-(i3 - i4)) / 2;
            layoutParams2.leftMargin = (i3 - i4) / 2;
            layoutParams2.rightMargin = (i3 - i4) / 2;
            layoutParams2.width = i4;
            layoutParams2.height = i3;
            super.setRotation(270.0f);
        } else {
            setPadding(0, 0, 0, com.oplus.camera.util.Util.Z_renamed());
            layoutParams2.width = com.oplus.camera.screen.f_renamed.f5371a;
            layoutParams2.height = com.oplus.camera.screen.f_renamed.f5372b;
            super.setRotation(0.0f);
        }
        this.h_renamed.requestLayout();
        requestLayout();
    }
}
