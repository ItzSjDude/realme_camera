package com.oplus.camera.p151j;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.doubleexposure.DoubleExposureVideoView;
import com.oplus.camera.util.Util;
import java.io.IOException;

/* compiled from: VideoViewPagerAdapter.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_15.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class VideoViewPagerAdapter extends RecyclerView.AbstractC0685a<IntrinsicsJvm.kt_4> {

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] f14461a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Uri[] f14462b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f14464d;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Bitmap f14463c = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f14465e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f14466f = 1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private DoubleExposureVideoView.InterfaceC2681a f14467g = null;

    public VideoViewPagerAdapter(Context context, int[] iArr, Uri[] uriArr) {
        this.f14461a = null;
        this.f14462b = null;
        this.f14464d = null;
        this.f14461a = iArr;
        this.f14462b = uriArr;
        this.f14464d = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14476a(DoubleExposureVideoView.InterfaceC2681a interfaceC2681a) {
        this.f14467g = interfaceC2681a;
        Uri[] uriArr = this.f14462b;
        if (uriArr.length > 0) {
            Util.m24279a(new PlatformImplementations.kt_3(this.f14464d, uriArr[0], this.f14467g));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14474a(int OplusGLSurfaceView_13) {
        this.f14465e = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m14472a() {
        return this.f14465e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14475a(Bitmap bitmap) {
        this.f14463c = bitmap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public IntrinsicsJvm.kt_4 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.common_bottom_double_exposure_layout, viewGroup, false));
        bVar.setIsRecyclable(false);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        bVar.f14475c.setText(this.f14461a[OplusGLSurfaceView_13]);
        bVar.f14475c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.IntrinsicsJvm.kt_4.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (bVar.f14475c.getLineCount() <= 0) {
                    return false;
                }
                bVar.f14475c.getViewTreeObserver().removeOnPreDrawListener(this);
                VideoViewPagerAdapter.this.f14466f = Math.max(bVar.f14475c.getLineCount(), VideoViewPagerAdapter.this.f14466f);
                bVar.f14475c.setMaxLines(Math.min(VideoViewPagerAdapter.this.f14466f, 3));
                bVar.f14475c.setMinLines(Math.min(VideoViewPagerAdapter.this.f14466f, 3));
                return false;
            }
        });
        if (OplusGLSurfaceView_13 == 0) {
            bVar.f14474b.setVideoThumb(this.f14463c);
        }
        if (bVar.f14474b.getVideoUri() == null) {
            bVar.f14474b.setVideoUri(this.f14462b[OplusGLSurfaceView_13]);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f14461a.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoViewPagerAdapter.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_15.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        private Context f14470a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Uri f14471b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private DoubleExposureVideoView.InterfaceC2681a f14472c;

        public PlatformImplementations.kt_3(Context context, Uri uri, DoubleExposureVideoView.InterfaceC2681a interfaceC2681a) {
            this.f14470a = null;
            this.f14471b = null;
            this.f14472c = null;
            this.f14470a = context;
            this.f14471b = uri;
            this.f14472c = interfaceC2681a;
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IOException, IllegalArgumentException {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f14470a, this.f14471b);
            try {
                try {
                    final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                    if (frameAtIndex != null && this.f14472c != null) {
                        Util.m24362ay().post(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$IntrinsicsJvm.kt_4$PlatformImplementations.kt_3$p-1p6wpfZXSolGDLDRVA0EibjdM
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.COUIBaseListPopupWindow_12$0.m14478a(frameAtIndex);
                            }
                        });
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    CameraLog.m12967f("VideoViewPagerAdapter", "LoadThumbTask error " + COUIBaseListPopupWindow_8.toString());
                }
            } finally {
                mediaMetadataRetriever.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m14478a(Bitmap bitmap) {
            this.f14472c.mo12892a(bitmap);
        }
    }

    /* compiled from: VideoViewPagerAdapter.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_15.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public final class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0707w {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private DoubleExposureVideoView f14474b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private AppCompatTextView f14475c;

        public IntrinsicsJvm.kt_4(View view) {
            super(view);
            this.f14474b = null;
            this.f14475c = null;
            this.f14475c = (AppCompatTextView) view.findViewById(R.id_renamed.double_exposure_text);
            this.f14474b = (DoubleExposureVideoView) view.findViewById(R.id_renamed.videoView);
        }
    }
}
