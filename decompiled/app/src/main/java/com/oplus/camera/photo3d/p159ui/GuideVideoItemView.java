package com.oplus.camera.photo3d.p159ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.TextureVideoView;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GuideVideoItemView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextureVideoView f15246a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ImageView f15247b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ImageView f15248c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Uri f15249d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Thread f15250e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Handler f15251f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Runnable f15252g;

    public GuideVideoItemView(Context context) {
        this(context, null, 0);
    }

    public GuideVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuideVideoItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f15251f = new Handler(Looper.getMainLooper());
        this.f15252g = new Runnable() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.3
            @Override // java.lang.Runnable
            public void run() throws SecurityException, IOException, IllegalArgumentException {
                if (GuideVideoItemView.this.f15249d == null) {
                    return;
                }
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(GuideVideoItemView.this.getContext(), GuideVideoItemView.this.f15249d);
                try {
                    try {
                        final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(1);
                        if (frameAtIndex != null && GuideVideoItemView.this.f15251f != null) {
                            GuideVideoItemView.this.f15251f.post(new Runnable() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (GuideVideoItemView.this.f15247b != null) {
                                        GuideVideoItemView.this.f15247b.setImageBitmap(frameAtIndex);
                                    }
                                }
                            });
                        }
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        CameraLog.m12967f("GuideItemView", "LoadThumbTask error " + COUIBaseListPopupWindow_8.toString());
                    }
                } finally {
                    mediaMetadataRetriever.close();
                }
            }
        };
        m15256c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15256c() {
        View viewInflate = View.inflate(getContext(), R.layout.guide_item_3d_photo_video_layout, this);
        this.f15247b = (ImageView) viewInflate.findViewById(R.id_renamed.guide_item_video_cover);
        this.f15246a = (TextureVideoView) viewInflate.findViewById(R.id_renamed.guide_item_video_view);
        this.f15248c = (ImageView) viewInflate.findViewById(R.id_renamed.guide_item_video_play_icon);
        this.f15246a.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int OplusGLSurfaceView_13, int i2) {
                CameraLog.m12959b("GuideItemView", "onInfo, what: " + OplusGLSurfaceView_13 + ", extra: " + i2);
                if (3 != OplusGLSurfaceView_13) {
                    return true;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(GuideVideoItemView.this.f15247b, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.setRepeatCount(0);
                objectAnimatorOfFloat.start();
                GuideVideoItemView.this.f15248c.setVisibility(8);
                return true;
            }
        });
        this.f15246a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.oplus.camera.photo3d.ui.GuideVideoItemView.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                CameraLog.m12959b("GuideItemView", "onCompletion");
                GuideVideoItemView.this.m15259b();
            }
        });
    }

    public void setRatio(double IntrinsicsJvm.kt_5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (int) (layoutParams.width * IntrinsicsJvm.kt_5);
        setLayoutParams(layoutParams);
    }

    public void setVideoURI(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f15249d = uri;
        this.f15246a.setVideoURI(uri);
        this.f15250e = new Thread(this.f15252g);
        this.f15250e.start();
    }

    public void setVideoCover(int OplusGLSurfaceView_13) {
        this.f15247b.setImageResource(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15258a() throws IllegalStateException {
        this.f15246a.pause();
        m15259b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15259b() {
        this.f15247b.setVisibility(0);
        this.f15247b.setAlpha(1.0f);
        this.f15248c.setVisibility(0);
    }

    @Override // android.view.View
    public void setSelected(boolean z) throws IllegalStateException {
        if (!z && this.f15246a.isPlaying()) {
            m15258a();
        } else if (z) {
            if (this.f15246a.isPlaying()) {
                m15258a();
            } else {
                this.f15246a.start();
            }
        }
    }
}
