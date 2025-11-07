package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class TextureVideoView extends android.view.TextureView implements android.widget.MediaController.MediaPlayerControl {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.view.TextureView.SurfaceTextureListener f7241a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.net.Uri f7242b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.Surface f7243c;
    private android.media.MediaPlayer d_renamed;
    private android.media.MediaPlayer.OnCompletionListener e_renamed;
    private android.media.MediaPlayer.OnPreparedListener f_renamed;
    private android.media.MediaPlayer.OnErrorListener g_renamed;
    private android.media.MediaPlayer.OnInfoListener h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private android.media.MediaPlayer.OnVideoSizeChangedListener s_renamed;
    private android.media.MediaPlayer.OnPreparedListener t_renamed;
    private android.media.MediaPlayer.OnCompletionListener u_renamed;
    private android.media.MediaPlayer.OnInfoListener v_renamed;
    private android.media.MediaPlayer.OnErrorListener w_renamed;
    private android.media.MediaPlayer.OnBufferingUpdateListener x_renamed;

    public TextureVideoView(android.content.Context context) {
        this(context, null);
    }

    public TextureVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7243c = null;
        this.d_renamed = null;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = new android.media.MediaPlayer.OnVideoSizeChangedListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i2, int i3) {
                com.oplus.camera.ui.widget.TextureVideoView.this.l_renamed = mediaPlayer.getVideoWidth();
                com.oplus.camera.ui.widget.TextureVideoView.this.m_renamed = mediaPlayer.getVideoHeight();
                if (com.oplus.camera.ui.widget.TextureVideoView.this.l_renamed == 0 || com.oplus.camera.ui.widget.TextureVideoView.this.m_renamed == 0) {
                    return;
                }
                com.oplus.camera.ui.widget.TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(com.oplus.camera.ui.widget.TextureVideoView.this.l_renamed, com.oplus.camera.ui.widget.TextureVideoView.this.m_renamed);
                com.oplus.camera.ui.widget.TextureVideoView.this.requestLayout();
            }
        };
        this.t_renamed = new android.media.MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer) throws java.lang.IllegalStateException {
                com.oplus.camera.ui.widget.TextureVideoView.this.i_renamed = 2;
                com.oplus.camera.ui.widget.TextureVideoView textureVideoView = com.oplus.camera.ui.widget.TextureVideoView.this;
                textureVideoView.p_renamed = textureVideoView.q_renamed = textureVideoView.r_renamed = true;
                if (com.oplus.camera.ui.widget.TextureVideoView.this.f_renamed != null) {
                    com.oplus.camera.ui.widget.TextureVideoView.this.f_renamed.onPrepared(com.oplus.camera.ui.widget.TextureVideoView.this.d_renamed);
                }
                com.oplus.camera.ui.widget.TextureVideoView.this.l_renamed = mediaPlayer.getVideoWidth();
                com.oplus.camera.ui.widget.TextureVideoView.this.m_renamed = mediaPlayer.getVideoHeight();
                int i2 = com.oplus.camera.ui.widget.TextureVideoView.this.o_renamed;
                if (i2 != 0) {
                    com.oplus.camera.ui.widget.TextureVideoView.this.seekTo(i2);
                }
                if (com.oplus.camera.ui.widget.TextureVideoView.this.l_renamed == 0 || com.oplus.camera.ui.widget.TextureVideoView.this.m_renamed == 0) {
                    if (3 == com.oplus.camera.ui.widget.TextureVideoView.this.j_renamed) {
                        com.oplus.camera.ui.widget.TextureVideoView.this.start();
                    }
                } else {
                    com.oplus.camera.ui.widget.TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(com.oplus.camera.ui.widget.TextureVideoView.this.l_renamed, com.oplus.camera.ui.widget.TextureVideoView.this.m_renamed);
                    if (3 == com.oplus.camera.ui.widget.TextureVideoView.this.j_renamed) {
                        com.oplus.camera.ui.widget.TextureVideoView.this.start();
                    }
                }
            }
        };
        this.u_renamed = new android.media.MediaPlayer.OnCompletionListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                com.oplus.camera.ui.widget.TextureVideoView.this.i_renamed = 5;
                com.oplus.camera.ui.widget.TextureVideoView.this.j_renamed = 5;
                if (com.oplus.camera.ui.widget.TextureVideoView.this.e_renamed != null) {
                    com.oplus.camera.ui.widget.TextureVideoView.this.e_renamed.onCompletion(com.oplus.camera.ui.widget.TextureVideoView.this.d_renamed);
                }
            }
        };
        this.v_renamed = new android.media.MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i2, int i3) {
                if (com.oplus.camera.ui.widget.TextureVideoView.this.h_renamed == null) {
                    return true;
                }
                com.oplus.camera.ui.widget.TextureVideoView.this.h_renamed.onInfo(mediaPlayer, i2, i3);
                return true;
            }
        };
        this.w_renamed = new android.media.MediaPlayer.OnErrorListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(android.media.MediaPlayer mediaPlayer, int i2, int i3) {
                com.oplus.camera.ui.widget.TextureVideoView.this.i_renamed = -1;
                com.oplus.camera.ui.widget.TextureVideoView.this.j_renamed = -1;
                if (com.oplus.camera.ui.widget.TextureVideoView.this.g_renamed == null) {
                    return true;
                }
                com.oplus.camera.ui.widget.TextureVideoView.this.g_renamed.onError(com.oplus.camera.ui.widget.TextureVideoView.this.d_renamed, i2, i3);
                return true;
            }
        };
        this.x_renamed = new android.media.MediaPlayer.OnBufferingUpdateListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i2) {
                com.oplus.camera.ui.widget.TextureVideoView.this.n_renamed = i2;
            }
        };
        this.f7241a = new android.view.TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.7
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i2, int i3) throws java.lang.IllegalStateException {
                boolean z_renamed = com.oplus.camera.ui.widget.TextureVideoView.this.j_renamed == 3;
                boolean z2 = i2 > 0 && i3 > 0;
                if (com.oplus.camera.ui.widget.TextureVideoView.this.d_renamed != null && z_renamed && z2) {
                    if (com.oplus.camera.ui.widget.TextureVideoView.this.o_renamed != 0) {
                        com.oplus.camera.ui.widget.TextureVideoView textureVideoView = com.oplus.camera.ui.widget.TextureVideoView.this;
                        textureVideoView.seekTo(textureVideoView.o_renamed);
                    }
                    com.oplus.camera.ui.widget.TextureVideoView.this.start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i2, int i3) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
                com.oplus.camera.ui.widget.TextureVideoView.this.f7243c = new android.view.Surface(surfaceTexture);
                com.oplus.camera.ui.widget.TextureVideoView.this.b_renamed();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                if (com.oplus.camera.ui.widget.TextureVideoView.this.f7243c != null) {
                    com.oplus.camera.ui.widget.TextureVideoView.this.f7243c.release();
                    com.oplus.camera.ui.widget.TextureVideoView.this.f7243c = null;
                }
                com.oplus.camera.ui.widget.TextureVideoView.this.a_renamed(true);
                return true;
            }
        };
        this.l_renamed = 0;
        this.m_renamed = 0;
        setSurfaceTextureListener(this.f7241a);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.i_renamed = 0;
        this.j_renamed = 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(com.oplus.camera.ui.widget.TextureVideoView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(com.oplus.camera.ui.widget.TextureVideoView.class.getName());
    }

    public void setVideoURI(android.net.Uri uri) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.f7242b = uri;
        this.o_renamed = 0;
        b_renamed();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed() throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        if (this.f7242b == null || this.f7243c == null) {
            return;
        }
        a_renamed(false);
        try {
            this.d_renamed = new android.media.MediaPlayer();
            if (this.k_renamed != 0) {
                this.d_renamed.setAudioSessionId(this.k_renamed);
            } else {
                this.k_renamed = this.d_renamed.getAudioSessionId();
            }
            this.d_renamed.setOnPreparedListener(this.t_renamed);
            this.d_renamed.setOnVideoSizeChangedListener(this.s_renamed);
            this.d_renamed.setOnCompletionListener(this.u_renamed);
            this.d_renamed.setOnErrorListener(this.w_renamed);
            this.d_renamed.setOnInfoListener(this.v_renamed);
            this.d_renamed.setOnBufferingUpdateListener(this.x_renamed);
            this.n_renamed = 0;
            this.d_renamed.setDataSource(getContext().getApplicationContext(), this.f7242b, (java.util.Map<java.lang.String, java.lang.String>) null);
            this.d_renamed.setSurface(this.f7243c);
            this.d_renamed.setAudioStreamType(3);
            this.d_renamed.setScreenOnWhilePlaying(true);
            this.d_renamed.prepareAsync();
            this.i_renamed = 1;
        } catch (java.lang.Exception unused) {
            this.i_renamed = -1;
            this.j_renamed = -1;
            this.w_renamed.onError(this.d_renamed, 1, 0);
        }
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f_renamed = onPreparedListener;
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener onCompletionListener) {
        this.e_renamed = onCompletionListener;
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onErrorListener) {
        this.g_renamed = onErrorListener;
    }

    public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener onInfoListener) {
        this.h_renamed = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed) {
        android.media.MediaPlayer mediaPlayer = this.d_renamed;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.d_renamed.release();
            this.d_renamed = null;
            this.i_renamed = 0;
            if (z_renamed) {
                this.j_renamed = 0;
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() throws java.lang.IllegalStateException {
        if (c_renamed()) {
            this.d_renamed.start();
            this.i_renamed = 3;
        }
        this.j_renamed = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() throws java.lang.IllegalStateException {
        if (c_renamed() && this.d_renamed.isPlaying()) {
            this.d_renamed.pause();
            this.i_renamed = 4;
        }
        this.j_renamed = 4;
    }

    public void a_renamed() throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        b_renamed();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (c_renamed()) {
            return this.d_renamed.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (c_renamed()) {
            return this.d_renamed.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i_renamed) throws java.lang.IllegalStateException {
        if (c_renamed()) {
            this.d_renamed.seekTo(i_renamed);
            this.o_renamed = 0;
        } else {
            this.o_renamed = i_renamed;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return c_renamed() && this.d_renamed.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.d_renamed != null) {
            return this.n_renamed;
        }
        return 0;
    }

    private boolean c_renamed() {
        int i_renamed;
        return (this.d_renamed == null || -1 == (i_renamed = this.i_renamed) || i_renamed == 0 || 1 == i_renamed) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.p_renamed;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.q_renamed;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.r_renamed;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.k_renamed == 0) {
            android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
            this.k_renamed = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.k_renamed;
    }
}
