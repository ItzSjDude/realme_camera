package com.oplus.camera.doubleexposure;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.TextureVideoView;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DoubleExposureVideoView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextureVideoView f13163a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ImageView f13164b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Uri f13165c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Thread f13166d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InterfaceC2681a f13167e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Handler f13168f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f13169g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Runnable f13170h;

    /* renamed from: com.oplus.camera.doubleexposure.DoubleExposureVideoView$PlatformImplementations.kt_3 */
    public interface InterfaceC2681a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12891a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12892a(Bitmap bitmap);
    }

    public DoubleExposureVideoView(Context context) {
        super(context);
        this.f13163a = null;
        this.f13164b = null;
        this.f13165c = null;
        this.f13166d = null;
        this.f13167e = null;
        this.f13168f = new Handler(Looper.getMainLooper());
        this.f13169g = false;
        this.f13170h = new Runnable() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.4
            @Override // java.lang.Runnable
            public void run() throws SecurityException, IOException, IllegalArgumentException {
                if (DoubleExposureVideoView.this.f13165c == null) {
                    return;
                }
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(DoubleExposureVideoView.this.getContext(), DoubleExposureVideoView.this.f13165c);
                try {
                    try {
                        final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                        if (frameAtIndex != null && DoubleExposureVideoView.this.f13168f != null) {
                            DoubleExposureVideoView.this.f13168f.post(new Runnable() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (DoubleExposureVideoView.this.f13164b != null) {
                                        DoubleExposureVideoView.this.f13164b.setImageBitmap(frameAtIndex);
                                    }
                                    if (DoubleExposureVideoView.this.f13167e != null) {
                                        DoubleExposureVideoView.this.f13167e.mo12892a(frameAtIndex);
                                    }
                                }
                            });
                        }
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        if (DoubleExposureVideoView.this.f13167e != null) {
                            DoubleExposureVideoView.this.f13167e.mo12891a();
                        }
                        CameraLog.m12967f("DoubleExposureVideoView", "LoadThumbTask error " + COUIBaseListPopupWindow_8.toString());
                    }
                } finally {
                    mediaMetadataRetriever.close();
                }
            }
        };
        m12887d();
    }

    public DoubleExposureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13163a = null;
        this.f13164b = null;
        this.f13165c = null;
        this.f13166d = null;
        this.f13167e = null;
        this.f13168f = new Handler(Looper.getMainLooper());
        this.f13169g = false;
        this.f13170h = new Runnable() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.4
            @Override // java.lang.Runnable
            public void run() throws SecurityException, IOException, IllegalArgumentException {
                if (DoubleExposureVideoView.this.f13165c == null) {
                    return;
                }
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(DoubleExposureVideoView.this.getContext(), DoubleExposureVideoView.this.f13165c);
                try {
                    try {
                        final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                        if (frameAtIndex != null && DoubleExposureVideoView.this.f13168f != null) {
                            DoubleExposureVideoView.this.f13168f.post(new Runnable() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (DoubleExposureVideoView.this.f13164b != null) {
                                        DoubleExposureVideoView.this.f13164b.setImageBitmap(frameAtIndex);
                                    }
                                    if (DoubleExposureVideoView.this.f13167e != null) {
                                        DoubleExposureVideoView.this.f13167e.mo12892a(frameAtIndex);
                                    }
                                }
                            });
                        }
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        if (DoubleExposureVideoView.this.f13167e != null) {
                            DoubleExposureVideoView.this.f13167e.mo12891a();
                        }
                        CameraLog.m12967f("DoubleExposureVideoView", "LoadThumbTask error " + COUIBaseListPopupWindow_8.toString());
                    }
                } finally {
                    mediaMetadataRetriever.close();
                }
            }
        };
        m12887d();
    }

    public DoubleExposureVideoView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f13163a = null;
        this.f13164b = null;
        this.f13165c = null;
        this.f13166d = null;
        this.f13167e = null;
        this.f13168f = new Handler(Looper.getMainLooper());
        this.f13169g = false;
        this.f13170h = new Runnable() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.4
            @Override // java.lang.Runnable
            public void run() throws SecurityException, IOException, IllegalArgumentException {
                if (DoubleExposureVideoView.this.f13165c == null) {
                    return;
                }
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(DoubleExposureVideoView.this.getContext(), DoubleExposureVideoView.this.f13165c);
                try {
                    try {
                        final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                        if (frameAtIndex != null && DoubleExposureVideoView.this.f13168f != null) {
                            DoubleExposureVideoView.this.f13168f.post(new Runnable() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (DoubleExposureVideoView.this.f13164b != null) {
                                        DoubleExposureVideoView.this.f13164b.setImageBitmap(frameAtIndex);
                                    }
                                    if (DoubleExposureVideoView.this.f13167e != null) {
                                        DoubleExposureVideoView.this.f13167e.mo12892a(frameAtIndex);
                                    }
                                }
                            });
                        }
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        if (DoubleExposureVideoView.this.f13167e != null) {
                            DoubleExposureVideoView.this.f13167e.mo12891a();
                        }
                        CameraLog.m12967f("DoubleExposureVideoView", "LoadThumbTask error " + COUIBaseListPopupWindow_8.toString());
                    }
                } finally {
                    mediaMetadataRetriever.close();
                }
            }
        };
        m12887d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12887d() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.common_bottom_double_exposure_video_layout, (ViewGroup) this, false);
        this.f13163a = (TextureVideoView) viewInflate.findViewById(R.id_renamed.videoView);
        this.f13164b = (ImageView) viewInflate.findViewById(R.id_renamed.iv_video_thumb);
        this.f13163a.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int OplusGLSurfaceView_13, int i2) {
                if (3 != OplusGLSurfaceView_13 || DoubleExposureVideoView.this.f13164b == null) {
                    return true;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(DoubleExposureVideoView.this.f13164b, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.setRepeatCount(0);
                objectAnimatorOfFloat.start();
                return true;
            }
        });
        this.f13163a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        addView(viewInflate);
        this.f13163a.setEnabled(false);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: com.oplus.camera.doubleexposure.DoubleExposureVideoView.3
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), view.getContext().getResources().getDimension(R.dimen.common_bottom_guide_background_radius));
            }
        };
        this.f13163a.setOutlineProvider(viewOutlineProvider);
        ImageView imageView = this.f13164b;
        if (imageView != null) {
            imageView.setOutlineProvider(viewOutlineProvider);
        }
        this.f13163a.setClipToOutline(true);
        ImageView imageView2 = this.f13164b;
        if (imageView2 != null) {
            imageView2.setClipToOutline(true);
        }
    }

    public void setVideoUri(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f13165c = uri;
        this.f13163a.setVideoURI(this.f13165c);
        if (this.f13169g) {
            return;
        }
        this.f13166d = new Thread(this.f13170h);
        this.f13166d.start();
    }

    public void setVideoThumb(Bitmap bitmap) {
        this.f13169g = true;
        this.f13164b.setImageBitmap(bitmap);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12888a() throws IllegalStateException {
        TextureVideoView textureVideoView;
        if (this.f13165c == null || (textureVideoView = this.f13163a) == null || textureVideoView.isPlaying()) {
            return;
        }
        this.f13163a.seekTo(0);
        this.f13163a.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12889b() throws IllegalStateException {
        TextureVideoView textureVideoView = this.f13163a;
        if (textureVideoView != null) {
            textureVideoView.pause();
        }
        ImageView imageView = this.f13164b;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f13164b.setAlpha(1.0f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12890c() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        TextureVideoView textureVideoView = this.f13163a;
        if (textureVideoView != null) {
            textureVideoView.m24068a();
        }
    }

    public Uri getVideoUri() {
        return this.f13165c;
    }

    public void setThumbLoadListener(InterfaceC2681a interfaceC2681a) {
        this.f13167e = interfaceC2681a;
    }
}
