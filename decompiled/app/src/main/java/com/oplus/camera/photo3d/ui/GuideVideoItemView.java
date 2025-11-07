package com.oplus.camera.photo3d.ui;

/* loaded from: classes2.dex */
public class GuideVideoItemView extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.widget.TextureVideoView f5033a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.ImageView f5034b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.ImageView f5035c;
    private android.net.Uri d_renamed;
    private java.lang.Thread e_renamed;
    private android.os.Handler f_renamed;
    private java.lang.Runnable g_renamed;

    public GuideVideoItemView(android.content.Context context) {
        this(context, null, 0);
    }

    public GuideVideoItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuideVideoItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        this.g_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.3
            @Override // java.lang.Runnable
            public void run() throws java.lang.SecurityException, java.io.IOException, java.lang.IllegalArgumentException {
                if (com.oplus.camera.photo3d.ui.GuideVideoItemView.this.d_renamed == null) {
                    return;
                }
                android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(com.oplus.camera.photo3d.ui.GuideVideoItemView.this.getContext(), com.oplus.camera.photo3d.ui.GuideVideoItemView.this.d_renamed);
                try {
                    try {
                        final android.graphics.Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(1);
                        if (frameAtIndex != null && com.oplus.camera.photo3d.ui.GuideVideoItemView.this.f_renamed != null) {
                            com.oplus.camera.photo3d.ui.GuideVideoItemView.this.f_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (com.oplus.camera.photo3d.ui.GuideVideoItemView.this.f5034b != null) {
                                        com.oplus.camera.photo3d.ui.GuideVideoItemView.this.f5034b.setImageBitmap(frameAtIndex);
                                    }
                                }
                            });
                        }
                    } catch (java.lang.Exception e_renamed) {
                        com.oplus.camera.e_renamed.f_renamed("GuideItemView", "LoadThumbTask error " + e_renamed.toString());
                    }
                } finally {
                    mediaMetadataRetriever.close();
                }
            }
        };
        c_renamed();
    }

    private void c_renamed() {
        android.view.View viewInflate = android.view.View.inflate(getContext(), com.oplus.camera.R_renamed.layout.guide_item_3d_photo_video_layout, this);
        this.f5034b = (android.widget.ImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_item_video_cover);
        this.f5033a = (com.oplus.camera.ui.widget.TextureVideoView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_item_video_view);
        this.f5035c = (android.widget.ImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_item_video_play_icon);
        this.f5033a.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i_renamed, int i2) {
                com.oplus.camera.e_renamed.b_renamed("GuideItemView", "onInfo, what: " + i_renamed + ", extra: " + i2);
                if (3 != i_renamed) {
                    return true;
                }
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(com.oplus.camera.photo3d.ui.GuideVideoItemView.this.f5034b, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.setRepeatCount(0);
                objectAnimatorOfFloat.start();
                com.oplus.camera.photo3d.ui.GuideVideoItemView.this.f5035c.setVisibility(8);
                return true;
            }
        });
        this.f5033a.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                com.oplus.camera.e_renamed.b_renamed("GuideItemView", "onCompletion");
                com.oplus.camera.photo3d.ui.GuideVideoItemView.this.b_renamed();
            }
        });
    }

    public void setRatio(double d_renamed) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (int) (layoutParams.width * d_renamed);
        setLayoutParams(layoutParams);
    }

    public void setVideoURI(android.net.Uri uri) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.d_renamed = uri;
        this.f5033a.setVideoURI(uri);
        this.e_renamed = new java.lang.Thread(this.g_renamed);
        this.e_renamed.start();
    }

    public void setVideoCover(int i_renamed) {
        this.f5034b.setImageResource(i_renamed);
    }

    public void a_renamed() throws java.lang.IllegalStateException {
        this.f5033a.pause();
        b_renamed();
    }

    public void b_renamed() {
        this.f5034b.setVisibility(0);
        this.f5034b.setAlpha(1.0f);
        this.f5035c.setVisibility(0);
    }

    @Override // android.view.View
    public void setSelected(boolean z_renamed) throws java.lang.IllegalStateException {
        if (!z_renamed && this.f5033a.isPlaying()) {
            a_renamed();
        } else if (z_renamed) {
            if (this.f5033a.isPlaying()) {
                a_renamed();
            } else {
                this.f5033a.start();
            }
        }
    }
}
