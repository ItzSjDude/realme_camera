package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {

    /* renamed from: PlatformImplementations.kt_3 */
    TextureView.SurfaceTextureListener f22703a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Uri f22704b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Surface f22705c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private MediaPlayer f22706d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private MediaPlayer.OnCompletionListener f22707e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private MediaPlayer.OnPreparedListener f22708f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private MediaPlayer.OnErrorListener f22709g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private MediaPlayer.OnInfoListener f22710h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22711i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22712j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22713k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22714l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22715m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22716n;

    /* renamed from: o */
    private int f22717o;

    /* renamed from: p */
    private boolean f22718p;

    /* renamed from: q */
    private boolean f22719q;

    /* renamed from: r */
    private boolean f22720r;

    /* renamed from: s */
    private MediaPlayer.OnVideoSizeChangedListener f22721s;

    /* renamed from: t */
    private MediaPlayer.OnPreparedListener f22722t;

    /* renamed from: u */
    private MediaPlayer.OnCompletionListener f22723u;

    /* renamed from: v */
    private MediaPlayer.OnInfoListener f22724v;

    /* renamed from: w */
    private MediaPlayer.OnErrorListener f22725w;

    /* renamed from: x */
    private MediaPlayer.OnBufferingUpdateListener f22726x;

    public TextureVideoView(Context context) {
        this(context, null);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22705c = null;
        this.f22706d = null;
        this.f22711i = 0;
        this.f22712j = 0;
        this.f22713k = 0;
        this.f22714l = 0;
        this.f22715m = 0;
        this.f22716n = 0;
        this.f22717o = 0;
        this.f22718p = false;
        this.f22719q = false;
        this.f22720r = false;
        this.f22721s = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                TextureVideoView.this.f22714l = mediaPlayer.getVideoWidth();
                TextureVideoView.this.f22715m = mediaPlayer.getVideoHeight();
                if (TextureVideoView.this.f22714l == 0 || TextureVideoView.this.f22715m == 0) {
                    return;
                }
                TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.this.f22714l, TextureVideoView.this.f22715m);
                TextureVideoView.this.requestLayout();
            }
        };
        this.f22722t = new MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.f22711i = 2;
                TextureVideoView textureVideoView = TextureVideoView.this;
                textureVideoView.f22718p = textureVideoView.f22719q = textureVideoView.f22720r = true;
                if (TextureVideoView.this.f22708f != null) {
                    TextureVideoView.this.f22708f.onPrepared(TextureVideoView.this.f22706d);
                }
                TextureVideoView.this.f22714l = mediaPlayer.getVideoWidth();
                TextureVideoView.this.f22715m = mediaPlayer.getVideoHeight();
                int i2 = TextureVideoView.this.f22717o;
                if (i2 != 0) {
                    TextureVideoView.this.seekTo(i2);
                }
                if (TextureVideoView.this.f22714l == 0 || TextureVideoView.this.f22715m == 0) {
                    if (3 == TextureVideoView.this.f22712j) {
                        TextureVideoView.this.start();
                    }
                } else {
                    TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.this.f22714l, TextureVideoView.this.f22715m);
                    if (3 == TextureVideoView.this.f22712j) {
                        TextureVideoView.this.start();
                    }
                }
            }
        };
        this.f22723u = new MediaPlayer.OnCompletionListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                TextureVideoView.this.f22711i = 5;
                TextureVideoView.this.f22712j = 5;
                if (TextureVideoView.this.f22707e != null) {
                    TextureVideoView.this.f22707e.onCompletion(TextureVideoView.this.f22706d);
                }
            }
        };
        this.f22724v = new MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (TextureVideoView.this.f22710h == null) {
                    return true;
                }
                TextureVideoView.this.f22710h.onInfo(mediaPlayer, i2, i3);
                return true;
            }
        };
        this.f22725w = new MediaPlayer.OnErrorListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                TextureVideoView.this.f22711i = -1;
                TextureVideoView.this.f22712j = -1;
                if (TextureVideoView.this.f22709g == null) {
                    return true;
                }
                TextureVideoView.this.f22709g.onError(TextureVideoView.this.f22706d, i2, i3);
                return true;
            }
        };
        this.f22726x = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                TextureVideoView.this.f22716n = i2;
            }
        };
        this.f22703a = new TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.ui.widget.TextureVideoView.7
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) throws IllegalStateException {
                boolean z = TextureVideoView.this.f22712j == 3;
                boolean z2 = i2 > 0 && i3 > 0;
                if (TextureVideoView.this.f22706d != null && z && z2) {
                    if (TextureVideoView.this.f22717o != 0) {
                        TextureVideoView textureVideoView = TextureVideoView.this;
                        textureVideoView.seekTo(textureVideoView.f22717o);
                    }
                    TextureVideoView.this.start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                TextureVideoView.this.f22705c = new Surface(surfaceTexture);
                TextureVideoView.this.m24051b();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TextureVideoView.this.f22705c != null) {
                    TextureVideoView.this.f22705c.release();
                    TextureVideoView.this.f22705c = null;
                }
                TextureVideoView.this.m24047a(true);
                return true;
            }
        };
        this.f22714l = 0;
        this.f22715m = 0;
        setSurfaceTextureListener(this.f22703a);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f22711i = 0;
        this.f22712j = 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureVideoView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
    }

    public void setVideoURI(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f22704b = uri;
        this.f22717o = 0;
        m24051b();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24051b() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.f22704b == null || this.f22705c == null) {
            return;
        }
        m24047a(false);
        try {
            this.f22706d = new MediaPlayer();
            if (this.f22713k != 0) {
                this.f22706d.setAudioSessionId(this.f22713k);
            } else {
                this.f22713k = this.f22706d.getAudioSessionId();
            }
            this.f22706d.setOnPreparedListener(this.f22722t);
            this.f22706d.setOnVideoSizeChangedListener(this.f22721s);
            this.f22706d.setOnCompletionListener(this.f22723u);
            this.f22706d.setOnErrorListener(this.f22725w);
            this.f22706d.setOnInfoListener(this.f22724v);
            this.f22706d.setOnBufferingUpdateListener(this.f22726x);
            this.f22716n = 0;
            this.f22706d.setDataSource(getContext().getApplicationContext(), this.f22704b, (Map<String, String>) null);
            this.f22706d.setSurface(this.f22705c);
            this.f22706d.setAudioStreamType(3);
            this.f22706d.setScreenOnWhilePlaying(true);
            this.f22706d.prepareAsync();
            this.f22711i = 1;
        } catch (Exception unused) {
            this.f22711i = -1;
            this.f22712j = -1;
            this.f22725w.onError(this.f22706d, 1, 0);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f22708f = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f22707e = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f22709g = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f22710h = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m24047a(boolean z) {
        MediaPlayer mediaPlayer = this.f22706d;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f22706d.release();
            this.f22706d = null;
            this.f22711i = 0;
            if (z) {
                this.f22712j = 0;
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() throws IllegalStateException {
        if (m24055c()) {
            this.f22706d.start();
            this.f22711i = 3;
        }
        this.f22712j = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() throws IllegalStateException {
        if (m24055c() && this.f22706d.isPlaying()) {
            this.f22706d.pause();
            this.f22711i = 4;
        }
        this.f22712j = 4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24068a() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        m24051b();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (m24055c()) {
            return this.f22706d.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (m24055c()) {
            return this.f22706d.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (m24055c()) {
            this.f22706d.seekTo(OplusGLSurfaceView_13);
            this.f22717o = 0;
        } else {
            this.f22717o = OplusGLSurfaceView_13;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return m24055c() && this.f22706d.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f22706d != null) {
            return this.f22716n;
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m24055c() {
        int OplusGLSurfaceView_13;
        return (this.f22706d == null || -1 == (OplusGLSurfaceView_13 = this.f22711i) || OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.f22718p;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.f22719q;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.f22720r;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.f22713k == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f22713k = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f22713k;
    }
}
