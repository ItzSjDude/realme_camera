package com.oplus.camera.p172ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseLinearLayout;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.util.ToastUtil;
import com.oplus.camera.util.Util;
import com.oplus.p125c.p126a.BitmapDecodeManager.kt;
import com.oplus.p125c.p126a.LightVideoPlayer.kt;
import com.oplus.p125c.p126a.MediaDataManager.kt;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: GalleryPreviewAdapter.java */
/* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class GalleryPreviewAdapter extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f18780a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18781b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18782c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18783d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18784e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f18786g;

    /* renamed from: OplusGLSurfaceView_15 */
    private Context f18789j;

    /* renamed from: u */
    private Handler f18800u;

    /* renamed from: x */
    private CameraUIListener f18803x;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18785f = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f18787h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f18788i = true;

    /* renamed from: OplusGLSurfaceView_5 */
    private Bitmap f18790k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private Bitmap f18791l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private HashMap<String, Integer> f18792m = new HashMap<>();

    /* renamed from: OplusGLSurfaceView_11 */
    private IntrinsicsJvm.kt_3 f18793n = null;

    /* renamed from: o */
    private ArrayList<MediaItem.kt> f18794o = null;

    /* renamed from: p */
    private Object f18795p = new Object();

    /* renamed from: q */
    private HashMap<String, LightVideoPlayer.kt> f18796q = new HashMap<>();

    /* renamed from: r */
    private HashMap<String, Surface> f18797r = new HashMap<>();

    /* renamed from: s */
    private HashMap<String, IntrinsicsJvm.kt_5> f18798s = new HashMap<>();

    /* renamed from: t */
    private RecyclerView f18799t = null;

    /* renamed from: v */
    private boolean f18801v = false;

    /* renamed from: w */
    private Object f18802w = new Object();

    /* renamed from: y */
    private volatile boolean f18804y = false;

    /* renamed from: z */
    private COUIBaseListPopupWindow_8 f18805z = null;

    /* renamed from: A */
    private InverseLinearLayout f18778A = null;

    /* renamed from: B */
    private RelativeLayout f18779B = null;

    /* compiled from: GalleryPreviewAdapter.java */
    /* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_5$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20024a(View view, Bitmap bitmap, int OplusGLSurfaceView_13);
    }

    public GalleryPreviewAdapter(Context context, int OplusGLSurfaceView_13, CameraUIListener cameraUIListener) {
        this.f18780a = 0;
        this.f18781b = 0;
        this.f18782c = 0;
        this.f18783d = 0;
        this.f18784e = 0;
        this.f18786g = 1.0f;
        this.f18789j = null;
        this.f18800u = null;
        this.f18803x = null;
        this.f18789j = context;
        this.f18782c = OplusGLSurfaceView_13;
        this.f18780a = this.f18789j.getResources().getDimensionPixelSize(R.dimen.gallery_preview_view_width);
        this.f18781b = this.f18789j.getResources().getDimensionPixelSize(R.dimen.gallery_preview_view_height);
        int i2 = this.f18780a;
        if (i2 != 0) {
            this.f18786g = this.f18781b / i2;
        }
        this.f18800u = new IntrinsicsJvm.kt_4(this.f18789j.getMainLooper());
        this.f18803x = cameraUIListener;
        this.f18783d = this.f18789j.getResources().getDimensionPixelOffset(R.dimen.gallery_preview_view_margin_top);
        this.f18784e = this.f18789j.getResources().getDimensionPixelOffset(R.dimen.gallery_preview_video_play_button_margin_top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        CameraLog.m12959b("GalleryPreviewAdapter", "onCreateViewHolder");
        return new PlatformImplementations.kt_3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_preview_view, viewGroup, false), OplusGLSurfaceView_13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        CameraLog.m12959b("GalleryPreviewAdapter", "onBindViewHolder, position:  " + OplusGLSurfaceView_13);
        if (aVar == null) {
            return;
        }
        MediaItem.kt c2436aM20218d = m20218d(OplusGLSurfaceView_13);
        if (c2436aM20218d == null) {
            CameraLog.m12959b("GalleryPreviewAdapter", "onBindViewHolder, mediaItem is null");
        } else if (c2436aM20218d.m9437j()) {
            m20212a(true, false, aVar);
            m20242a(aVar, c2436aM20218d);
        } else {
            m20212a(false, this.f18794o.get(OplusGLSurfaceView_13).m9438k(), aVar);
            m20215b(aVar, c2436aM20218d);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private MediaItem.kt m20218d(int OplusGLSurfaceView_13) {
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null) {
            return null;
        }
        MediaItem.kt c2436a = arrayList.get(OplusGLSurfaceView_13);
        if (c2436a != null && "-1".equals(c2436a.m9433f()) && !c2436a.m9437j()) {
            return c2436a;
        }
        for (int i2 = OplusGLSurfaceView_13; i2 >= 0; i2--) {
            if (new File(this.f18794o.get(i2).m9433f()).exists()) {
                return this.f18794o.get(i2);
            }
        }
        while (OplusGLSurfaceView_13 < this.f18794o.size()) {
            if (new File(this.f18794o.get(OplusGLSurfaceView_13).m9433f()).exists()) {
                return this.f18794o.get(OplusGLSurfaceView_13);
            }
            OplusGLSurfaceView_13++;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20212a(boolean z, boolean z2, PlatformImplementations.kt_3 aVar) {
        int OplusGLSurfaceView_13 = z ? 8 : 0;
        int i2 = z2 ? 0 : 8;
        int i3 = z ? 0 : 8;
        aVar.f18843c.setVisibility(OplusGLSurfaceView_13);
        aVar.f18845e.setVisibility(i2);
        aVar.f18844d.setVisibility(i3);
        aVar.f18846f.setVisibility(i3);
        if (!z) {
            this.f18778A = null;
            this.f18779B = null;
        } else {
            this.f18778A = aVar.f18848h;
            this.f18779B = aVar.f18847g;
            m20217c(!this.f18801v);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20215b(final PlatformImplementations.kt_3 aVar, final MediaItem.kt c2436a) {
        if (!"-1".equals(c2436a.m9433f())) {
            if (!this.f18804y || this.f18791l == null) {
                m20208a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GalleryPreviewAdapter.this.f18804y = false;
                        GalleryPreviewAdapter c3230k = GalleryPreviewAdapter.this;
                        int iM20189a = c3230k.m20189a(BitmapDecodeManager.kt.m9423b(c3230k.f18789j, c2436a, 1));
                        GalleryPreviewAdapter c3230k2 = GalleryPreviewAdapter.this;
                        c3230k2.f18791l = BitmapDecodeManager.kt.m9421a(c3230k2.f18789j, c2436a, iM20189a);
                        if (GalleryPreviewAdapter.this.f18791l == null) {
                            CameraLog.m12967f("GalleryPreviewAdapter", "setImage, decode failed, mediaItem: " + c2436a);
                            GalleryPreviewAdapter.this.m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (GalleryPreviewAdapter.this.f18790k != null) {
                                        aVar.f18843c.setImageBitmap(GalleryPreviewAdapter.this.f18790k);
                                        GalleryPreviewAdapter.this.m20197a(aVar.f18842b, GalleryPreviewAdapter.this.f18790k.getHeight(), GalleryPreviewAdapter.this.f18790k.getWidth());
                                    } else {
                                        CameraLog.m12959b("GalleryPreviewAdapter", "setImage, all available bitmap is null");
                                    }
                                }
                            });
                            return;
                        }
                        CameraLog.m12959b("GalleryPreviewAdapter", "setImage, mImageBitmap: width: " + GalleryPreviewAdapter.this.f18791l.getWidth() + ", height: " + GalleryPreviewAdapter.this.f18791l.getHeight() + ", bytes: " + GalleryPreviewAdapter.this.f18791l.getByteCount() + ", sampleSize: " + iM20189a);
                        GalleryPreviewAdapter.this.m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.f18843c.setImageBitmap(GalleryPreviewAdapter.this.f18791l);
                                GalleryPreviewAdapter.this.m20197a(aVar.f18842b, GalleryPreviewAdapter.this.f18791l.getHeight(), GalleryPreviewAdapter.this.f18791l.getWidth());
                            }
                        });
                    }
                }, "GalleryPreviewAdapter setImage");
                return;
            }
            aVar.f18843c.setImageBitmap(this.f18791l);
            m20197a(aVar.f18842b, this.f18791l.getHeight(), this.f18791l.getWidth());
            this.f18804y = false;
            return;
        }
        aVar.f18843c.setImageBitmap(this.f18790k);
        m20197a(aVar.f18842b, this.f18790k.getHeight(), this.f18790k.getWidth());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20242a(final PlatformImplementations.kt_3 aVar, final MediaItem.kt c2436a) {
        CameraLog.m12954a("GalleryPreviewAdapter", "setVideo, video path: " + c2436a.m9433f() + ", id_renamed: " + c2436a.m9432e());
        if (c2436a.m9427b() > 0 && c2436a.m9429c() > 0) {
            int iM9427b = c2436a.m9427b();
            int iM9429c = c2436a.m9429c();
            if (c2436a.m9424a() % 180 != 0) {
                iM9427b = c2436a.m9429c();
                iM9429c = c2436a.m9427b();
            }
            m20197a(aVar.f18844d, iM9429c, iM9427b);
        }
        m20239a(aVar.f18848h);
        CameraLog.m12954a("GalleryPreviewAdapter", "setVideo, id_renamed: " + c2436a.m9432e() + ", rotation: " + c2436a.m9424a() + ", width: " + c2436a.m9427b() + ", height: " + c2436a.m9429c());
        aVar.f18844d.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
                GalleryPreviewAdapter.this.m20195a(surfaceTexture, c2436a, aVar);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                CameraLog.m12954a("GalleryPreviewAdapter", "onSurfaceTextureDestroyed, item: " + c2436a.m9433f());
                synchronized (GalleryPreviewAdapter.this.f18802w) {
                    GalleryPreviewAdapter.this.m20209a(c2436a.m9433f());
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public int m20189a(int[] iArr) {
        CameraLog.m12959b("GalleryPreviewAdapter", "calSampleSize, imageBitmapSize: " + Arrays.toString(iArr));
        if (iArr == null || 2 != iArr.length || -1 == iArr[0] || -1 == iArr[1]) {
            return 2;
        }
        int OplusGLSurfaceView_13 = iArr[0];
        int i2 = iArr[1];
        int i3 = this.f18780a;
        int i4 = (int) (i3 * (i2 / OplusGLSurfaceView_13));
        if (OplusGLSurfaceView_13 <= i4 && i2 <= i3) {
            return 1;
        }
        int iFloorDiv = Math.floorDiv(OplusGLSurfaceView_13, i3);
        int iFloorDiv2 = Math.floorDiv(i2, i4);
        return iFloorDiv2 < iFloorDiv ? iFloorDiv2 : iFloorDiv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20197a(View view, int OplusGLSurfaceView_13, int i2) {
        int iRound;
        int iRound2;
        int i3;
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / i2;
        if (COUIBaseListPopupWindow_12 - this.f18786g > 0.01d) {
            iRound = this.f18781b;
            iRound2 = Math.round(iRound / COUIBaseListPopupWindow_12);
            i3 = 0;
        } else {
            iRound = Math.round(this.f18780a * COUIBaseListPopupWindow_12);
            iRound2 = this.f18780a;
            i3 = (this.f18781b - iRound) / 2;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = iRound;
        layoutParams.width = iRound2;
        layoutParams.topMargin = this.f18783d + i3;
        if (R.id_renamed.gallery_preview_surface == view.getId()) {
            this.f18785f = layoutParams.topMargin + layoutParams.height;
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f18799t = recyclerView;
        this.f18799t.setItemAnimator(null);
        this.f18799t.setHasFixedSize(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        m20230l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(PlatformImplementations.kt_3 aVar) {
        super.onViewDetachedFromWindow(aVar);
        m20230l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(PlatformImplementations.kt_3 aVar) {
        aVar.f18843c.setImageDrawable(null);
        super.onViewRecycled(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemViewType(int OplusGLSurfaceView_13) {
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null || arrayList.size() == 0) {
            return 4;
        }
        if (this.f18794o.get(OplusGLSurfaceView_13).m9437j()) {
            return 2;
        }
        return this.f18794o.get(OplusGLSurfaceView_13).m9438k() ? 3 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20247a() {
        return this.f18788i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20246a(boolean z) {
        CameraLog.m12959b("GalleryPreviewAdapter", "setShouldShowGallery, " + z);
        this.f18788i = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20245a(List<MediaItem.kt> list) {
        this.f18788i = true;
        if (list == null) {
            if (this.f18794o != null) {
                synchronized (this.f18795p) {
                    this.f18794o.clear();
                }
            }
            HashMap<String, Integer> map = this.f18792m;
            if (map != null) {
                map.clear();
            }
            notifyDataSetChanged();
            return;
        }
        if (this.f18794o == null) {
            this.f18794o = new ArrayList<>();
        }
        CameraLog.m12959b("GalleryPreviewAdapter", "setDataList, size: " + list.size() + ", first mediaItem: " + list.get(0) + ", last mediaItem: " + list.get(list.size() - 1));
        synchronized (this.f18795p) {
            this.f18794o.clear();
            this.f18794o.addAll(list);
        }
        this.f18792m.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f18794o.size(); OplusGLSurfaceView_13++) {
            this.f18792m.put(this.f18794o.get(OplusGLSurfaceView_13).m9432e(), Integer.valueOf(OplusGLSurfaceView_13));
        }
        notifyItemRangeChanged(0, this.f18794o.size());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20244a(final String str, boolean z, final int OplusGLSurfaceView_13) {
        if (str == null && z && this.f18794o.size() != 0) {
            if (this.f18794o.get(r1.size() - 1).m9438k()) {
                m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 1;
                        messageObtain.arg1 = GalleryPreviewAdapter.this.f18794o.size() - 1;
                        messageObtain.arg2 = 1;
                        GalleryPreviewAdapter.this.f18800u.sendMessage(messageObtain);
                    }
                });
                return;
            }
            return;
        }
        if (Util.m24329aR()) {
            m20208a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.7
                @Override // java.lang.Runnable
                public void run() {
                    GalleryPreviewAdapter.this.m20210a(str, OplusGLSurfaceView_13);
                }
            }, "GalleryPreviewAdapter addItem");
        } else {
            m20210a(str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20237a(Bitmap bitmap) {
        if (bitmap != null) {
            this.f18790k = bitmap;
        }
        CameraLog.m12959b("GalleryPreviewAdapter", "setCurThumbImage: " + bitmap);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20248b() {
        this.f18801v = true;
        m20226j();
        m20217c(false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20252c() {
        this.f18801v = false;
        m20217c(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20217c(final boolean z) {
        m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.8
            @Override // java.lang.Runnable
            public void run() {
                if (GalleryPreviewAdapter.this.f18778A == null || GalleryPreviewAdapter.this.f18779B == null) {
                    return;
                }
                if (GalleryPreviewAdapter.this.f18799t != null && GalleryPreviewAdapter.this.f18799t.findViewById(R.id_renamed.gallery_preview_video_play_button) != null) {
                    GalleryPreviewAdapter c3230k = GalleryPreviewAdapter.this;
                    c3230k.f18778A = (InverseLinearLayout) c3230k.f18799t.findViewById(R.id_renamed.gallery_preview_video_play_button);
                }
                if (GalleryPreviewAdapter.this.f18799t != null && GalleryPreviewAdapter.this.f18799t.findViewById(R.id_renamed.gallery_preview_video_play_button_touch_region) != null) {
                    GalleryPreviewAdapter c3230k2 = GalleryPreviewAdapter.this;
                    c3230k2.f18779B = (RelativeLayout) c3230k2.f18799t.findViewById(R.id_renamed.gallery_preview_video_play_button_touch_region);
                }
                GalleryPreviewAdapter.this.f18779B.setEnabled(z);
                int iM2254c = ContextCompat.m2254c(GalleryPreviewAdapter.this.f18789j, z ? R.color.color_play_button_enabled : R.color.color_play_button_disabled);
                ((ImageView) GalleryPreviewAdapter.this.f18778A.findViewById(R.id_renamed.gallery_preview_video_play_button_image)).setColorFilter(iM2254c);
                ((TextView) GalleryPreviewAdapter.this.f18778A.findViewById(R.id_renamed.gallery_preview_video_play_button_text)).setTextColor(iM2254c);
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m20226j() {
        LightVideoPlayer.kt c2442d;
        MediaItem.kt c2436aM20255e = m20255e();
        if (c2436aM20255e == null || (c2442d = this.f18796q.get(c2436aM20255e.m9433f())) == null || !c2442d.mo9477e()) {
            return;
        }
        c2442d.mo9475c();
        IntrinsicsJvm.kt_5 dVar = this.f18798s.get(c2436aM20255e.m9433f());
        if (dVar != null) {
            dVar.m20269b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20210a(final String str, int OplusGLSurfaceView_13) {
        if (str == null) {
            return;
        }
        final MediaItem.kt c2436aM9516a = MediaDataManager.kt.m9516a(this.f18789j, str);
        CameraLog.m12959b("GalleryPreviewAdapter", "insertMediaItem, mediaItem: " + c2436aM9516a + ", orientation: " + OplusGLSurfaceView_13);
        if (c2436aM9516a == null) {
            return;
        }
        if (c2436aM9516a.m9437j()) {
            c2436aM9516a.m9425a(OplusGLSurfaceView_13);
        }
        if (c2436aM9516a.m9438k()) {
            String strM9433f = c2436aM9516a.m9433f();
            if (!strM9433f.substring(strM9433f.lastIndexOf(47) + 1).contains("COVER")) {
                CameraLog.m12959b("GalleryPreviewAdapter", "insertMediaItem, not CShot Cover");
                return;
            }
        }
        m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.9
            @Override // java.lang.Runnable
            public void run() {
                if (GalleryPreviewAdapter.this.f18794o == null) {
                    GalleryPreviewAdapter.this.f18794o = new ArrayList();
                    GalleryPreviewAdapter.this.f18792m.clear();
                }
                boolean z = false;
                if (GalleryPreviewAdapter.this.f18792m.containsKey(str)) {
                    int iIntValue = ((Integer) GalleryPreviewAdapter.this.f18792m.get(str)).intValue();
                    if (iIntValue < GalleryPreviewAdapter.this.f18794o.size() - 1) {
                        synchronized (GalleryPreviewAdapter.this.f18795p) {
                            GalleryPreviewAdapter.this.f18794o.set(iIntValue, c2436aM9516a);
                        }
                        GalleryPreviewAdapter.this.notifyItemChanged(iIntValue);
                        return;
                    }
                    synchronized (GalleryPreviewAdapter.this.f18795p) {
                        GalleryPreviewAdapter.this.f18794o.set(iIntValue, c2436aM9516a);
                    }
                    z = true;
                } else {
                    GalleryPreviewAdapter.this.m20254d();
                    synchronized (GalleryPreviewAdapter.this.f18795p) {
                        GalleryPreviewAdapter.this.f18794o.add(c2436aM9516a);
                    }
                    GalleryPreviewAdapter.this.f18792m.put(str, Integer.valueOf(GalleryPreviewAdapter.this.f18794o.size() - 1));
                }
                if (c2436aM9516a.m9437j() || (!z && !c2436aM9516a.m9438k())) {
                    Message messageObtain = Message.obtain();
                    if (GalleryPreviewAdapter.this.f18799t != null && GalleryPreviewAdapter.this.f18799t.isShown()) {
                        messageObtain.what = 1;
                        messageObtain.obj = c2436aM9516a;
                        messageObtain.arg1 = GalleryPreviewAdapter.this.f18794o.size() - 1;
                        messageObtain.arg2 = 1;
                        if (GalleryPreviewAdapter.this.f18805z == null) {
                            GalleryPreviewAdapter.this.m20228k();
                        }
                        if (GalleryPreviewAdapter.this.f18805z != null) {
                            GalleryPreviewAdapter.this.f18805z.sendMessage(messageObtain);
                        }
                    } else {
                        messageObtain.what = 1;
                        messageObtain.arg1 = GalleryPreviewAdapter.this.f18794o.size() - 1;
                        messageObtain.arg2 = 1;
                        GalleryPreviewAdapter.this.f18800u.sendMessage(messageObtain);
                    }
                } else if (!c2436aM9516a.m9438k()) {
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 2;
                    messageObtain2.arg1 = GalleryPreviewAdapter.this.f18794o.size() - 1;
                    GalleryPreviewAdapter.this.f18800u.sendMessage(messageObtain2);
                }
                CameraLog.m12959b("GalleryPreviewAdapter", "insertMediaItem, size of DataList: " + GalleryPreviewAdapter.this.f18794o.size());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public void m20228k() {
        HandlerThread handlerThread = new HandlerThread("Pre Build");
        handlerThread.start();
        this.f18805z = new COUIBaseListPopupWindow_8(handlerThread.getLooper());
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m20230l() {
        COUIBaseListPopupWindow_8 eVar = this.f18805z;
        if (eVar != null) {
            eVar.getLooper().quitSafely();
            this.f18805z = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20254d() {
        if (this.f18794o.size() + 1 > 50) {
            this.f18792m.remove(this.f18794o.get(0).m9432e());
            synchronized (this.f18795p) {
                this.f18794o.remove(0);
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f18794o.size(); OplusGLSurfaceView_13++) {
                this.f18792m.put(this.f18794o.get(OplusGLSurfaceView_13).m9432e(), Integer.valueOf(OplusGLSurfaceView_13));
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.arg1 = 0;
            this.f18800u.sendMessage(messageObtain);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20238a(Thumbnail c3203e, boolean z) {
        if (z) {
            String string = c3203e.m19291e().toString();
            this.f18790k = c3203e.m19294h();
            String strSubstring = string.substring(string.lastIndexOf(47) + 1);
            MediaItem.kt c2436a = new MediaItem.kt(strSubstring, "-1", Uri.parse(string), 0, 10L, false, false);
            if (this.f18794o == null) {
                this.f18794o = new ArrayList<>();
            }
            if (this.f18792m.containsKey(strSubstring)) {
                return;
            }
            m20254d();
            synchronized (this.f18795p) {
                this.f18794o.add(c2436a);
                int size = this.f18794o.size() - 1;
                this.f18792m.put(strSubstring, Integer.valueOf(size));
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.arg1 = size;
                messageObtain.arg2 = 1;
                this.f18800u.sendMessage(messageObtain);
            }
            CameraLog.m12959b("GalleryPreviewAdapter", "addThumbnail, uri: " + string + ", path: " + c3203e.m19292f() + ", dataList size: " + this.f18794o.size());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MediaItem.kt m20235a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= this.f18794o.size()) {
            return null;
        }
        return this.f18794o.get(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public MediaItem.kt m20255e() {
        int iM20259i = m20259i();
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null || iM20259i >= arrayList.size() || -1 == iM20259i) {
            return null;
        }
        return this.f18794o.get(iM20259i);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public MediaItem.kt m20256f() {
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.f18794o.get(r1.size() - 1);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20257g() {
        View childAt = this.f18799t.getChildAt(0);
        if (childAt != null) {
            m20249b(((RecyclerView.C0694j) childAt.getLayoutParams()).m4159h());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20249b(final int OplusGLSurfaceView_13) {
        if (this.f18794o == null) {
            return;
        }
        CameraLog.m12959b("GalleryPreviewAdapter", "removeItem, position: " + OplusGLSurfaceView_13);
        final MediaItem.kt c2436a = this.f18794o.get(OplusGLSurfaceView_13);
        m20208a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.10
            @Override // java.lang.Runnable
            public void run() {
                if (GalleryPreviewAdapter.this.f18787h ? MediaDataManager.kt.m9520b(GalleryPreviewAdapter.this.f18789j, c2436a) : MediaDataManager.kt.m9518a(GalleryPreviewAdapter.this.f18789j, c2436a)) {
                    GalleryPreviewAdapter.this.f18803x.mo10821cf();
                    GalleryPreviewAdapter.this.m20198a(c2436a, OplusGLSurfaceView_13);
                }
            }
        }, "GalleryPreviewAdapter removemediaItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20198a(MediaItem.kt c2436a, final int OplusGLSurfaceView_13) {
        this.f18792m.remove(c2436a.m9432e());
        synchronized (this.f18795p) {
            this.f18794o.remove(OplusGLSurfaceView_13);
        }
        for (int i2 = OplusGLSurfaceView_13; i2 < this.f18794o.size(); i2++) {
            this.f18792m.replace(this.f18794o.get(i2).m9432e(), Integer.valueOf(i2));
        }
        m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.11
            @Override // java.lang.Runnable
            public void run() {
                Message messageObtain = Message.obtain();
                messageObtain.what = 3;
                messageObtain.arg1 = OplusGLSurfaceView_13;
                GalleryPreviewAdapter.this.f18800u.sendMessage(messageObtain);
                if (OplusGLSurfaceView_13 >= GalleryPreviewAdapter.this.f18794o.size()) {
                    GalleryPreviewAdapter.this.f18799t.scrollToPosition(GalleryPreviewAdapter.this.f18794o.size() - 1);
                } else if (OplusGLSurfaceView_13 == 0) {
                    GalleryPreviewAdapter.this.f18799t.scrollToPosition(0);
                } else {
                    GalleryPreviewAdapter.this.f18799t.scrollToPosition(OplusGLSurfaceView_13 - 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20195a(final SurfaceTexture surfaceTexture, final MediaItem.kt c2436a, final PlatformImplementations.kt_3 aVar) {
        final Surface surface = new Surface(surfaceTexture);
        final LightVideoPlayer.kt c2442d = new LightVideoPlayer.kt(this.f18789j, LightVideoPlayer.kt.PlatformImplementations.kt_3.TBL);
        final IntrinsicsJvm.kt_5 dVar = new IntrinsicsJvm.kt_5(c2442d, aVar);
        synchronized (this.f18802w) {
            this.f18796q.put(c2436a.m9433f(), c2442d);
            this.f18797r.put(c2436a.m9433f(), surface);
            this.f18798s.put(c2436a.m9433f(), dVar);
        }
        aVar.f18846f.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraLog.m12959b("GalleryPreviewAdapter", "prepareVideoPlayer, click the block region");
            }
        });
        aVar.f18847g.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GalleryPreviewAdapter.this.f18801v) {
                    return;
                }
                if (c2442d.mo9477e()) {
                    c2442d.mo9475c();
                    GalleryPreviewAdapter.this.m20211a(false, aVar);
                    GalleryPreviewAdapter.this.f18803x.mo10836f(82, 1);
                } else {
                    c2442d.mo9478f();
                    GalleryPreviewAdapter.this.m20211a(true, aVar);
                    GalleryPreviewAdapter.this.f18803x.mo10836f(82, 2);
                }
            }
        });
        m20208a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (GalleryPreviewAdapter.this.f18802w) {
                    if (!surfaceTexture.isReleased() && surface.isValid()) {
                        c2442d.mo9473a(c2436a.m9434g(), surface, dVar);
                    }
                }
            }
        }, "GalleryPreviewAdapter prepareVideoPlayer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20211a(final boolean z, final PlatformImplementations.kt_3 aVar) {
        m20207a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.4
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    aVar.f18850j.setText(GalleryPreviewAdapter.this.f18789j.getString(R.string.pause));
                    aVar.f18849i.setImageDrawable(ContextCompat.m2248a(GalleryPreviewAdapter.this.f18789j, R.drawable.ic_video_pause));
                } else {
                    aVar.f18850j.setText(GalleryPreviewAdapter.this.f18789j.getString(R.string.play));
                    aVar.f18849i.setImageDrawable(ContextCompat.m2248a(GalleryPreviewAdapter.this.f18789j, R.drawable.ic_video_play));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20209a(String str) {
        LightVideoPlayer.kt c2442d = this.f18796q.get(str);
        Surface surface = this.f18797r.get(str);
        if (c2442d != null) {
            CameraLog.m12954a("GalleryPreviewAdapter", "releaseVideoPlayer, key: " + str);
            c2442d.mo9476d();
            this.f18796q.remove(str);
        }
        if (surface != null) {
            surface.release();
            this.f18797r.remove(str);
        }
        this.f18798s.remove(str);
    }

    /* compiled from: GalleryPreviewAdapter.java */
    /* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_5$IntrinsicsJvm.kt_5 */
    class IntrinsicsJvm.kt_5 implements ILightVideoPlayer.kt.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ILightVideoPlayer.kt f18857b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private PlatformImplementations.kt_3 f18858c;

        public IntrinsicsJvm.kt_5(ILightVideoPlayer.kt interfaceC2446b, PlatformImplementations.kt_3 aVar) {
            this.f18857b = interfaceC2446b;
            this.f18858c = aVar;
        }

        @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo9497a() {
            if (!GalleryPreviewAdapter.this.f18801v) {
                GalleryPreviewAdapter.this.m20211a(true, this.f18858c);
            } else {
                this.f18857b.mo9475c();
                m20269b();
            }
            this.f18857b.mo9472a(0.0f);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m20269b() {
            GalleryPreviewAdapter.this.m20211a(false, this.f18858c);
        }

        @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo9498a(int OplusGLSurfaceView_13, int i2, String str) {
            CameraLog.m12967f("GalleryPreviewAdapter", "onError, " + str);
            return false;
        }

        @Override // com.oplus.p125c.p126a.p132d.p134b.ILightVideoPlayer.kt.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo9499c() {
            GalleryPreviewAdapter.this.m20211a(false, this.f18858c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20208a(Runnable runnable, String str) {
        CameraThreadExector.m24695a().m24696a(runnable, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20207a(Runnable runnable) {
        ((Activity) this.f18789j).runOnUiThread(runnable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20243a(IntrinsicsJvm.kt_3 cVar) {
        this.f18793n = cVar;
    }

    /* compiled from: GalleryPreviewAdapter.java */
    /* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private RelativeLayout f18842b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private ImageView f18843c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private TextureView f18844d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private RelativeLayout f18845e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private RelativeLayout f18846f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private RelativeLayout f18847g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private InverseLinearLayout f18848h;

        /* renamed from: OplusGLSurfaceView_13 */
        private ImageView f18849i;

        /* renamed from: OplusGLSurfaceView_15 */
        private TextView f18850j;

        public PlatformImplementations.kt_3(View view, int OplusGLSurfaceView_13) {
            super(view);
            if (4 == OplusGLSurfaceView_13) {
                return;
            }
            this.f18842b = (RelativeLayout) view.findViewById(R.id_renamed.gallery_image_container);
            this.f18843c = (ImageView) view.findViewById(R.id_renamed.gallery_preview_image);
            this.f18844d = (TextureView) view.findViewById(R.id_renamed.gallery_preview_surface);
            this.f18846f = (RelativeLayout) view.findViewById(R.id_renamed.gallery_preview_video_play_button_block_region);
            this.f18847g = (RelativeLayout) view.findViewById(R.id_renamed.gallery_preview_video_play_button_touch_region);
            this.f18848h = (InverseLinearLayout) view.findViewById(R.id_renamed.gallery_preview_video_play_button);
            this.f18849i = (ImageView) view.findViewById(R.id_renamed.gallery_preview_video_play_button_image);
            this.f18850j = (TextView) view.findViewById(R.id_renamed.gallery_preview_video_play_button_text);
            this.f18845e = (RelativeLayout) view.findViewById(R.id_renamed.gallery_preview_image_cshot_tag);
            this.f18842b.setClipToOutline(true);
            this.f18844d.setClipToOutline(true);
            this.f18842b.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.PlatformImplementations.kt_3.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    GalleryPreviewAdapter.this.m20196a(view2, PlatformImplementations.kt_3.this.getAbsoluteAdapterPosition());
                }
            });
            this.f18844d.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_5.PlatformImplementations.kt_3.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    GalleryPreviewAdapter.this.m20196a(view2, PlatformImplementations.kt_3.this.getAbsoluteAdapterPosition());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20196a(View view, int OplusGLSurfaceView_13) {
        View viewFindViewById;
        if (this.f18801v) {
            ToastUtil.m24640a(this.f18789j, R.string.camera_time_lapse_pro_recording_prevent_gallery_toast);
            return;
        }
        Bitmap bitmapCreateBitmap = null;
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null || OplusGLSurfaceView_13 >= arrayList.size() || OplusGLSurfaceView_13 <= -1) {
            return;
        }
        if (this.f18794o.get(OplusGLSurfaceView_13).m9437j()) {
            viewFindViewById = view.findViewById(R.id_renamed.gallery_preview_surface);
        } else {
            viewFindViewById = view.findViewById(R.id_renamed.gallery_preview_image);
        }
        if (viewFindViewById == null) {
            CameraLog.m12959b("GalleryPreviewAdapter", "onItemClick, current View is null");
            return;
        }
        viewFindViewById.setDrawingCacheEnabled(true);
        if (viewFindViewById.getDrawingCache() != null) {
            bitmapCreateBitmap = Bitmap.createBitmap(viewFindViewById.getDrawingCache());
        } else {
            CameraLog.m12959b("GalleryPreviewAdapter", "onItemClick, fail to get DrawingCache, width: " + viewFindViewById.getWidth() + ", height: " + viewFindViewById.getHeight());
        }
        viewFindViewById.setDrawingCacheEnabled(false);
        this.f18793n.mo20024a(view, bitmapCreateBitmap, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20251b(boolean z) {
        this.f18787h = z;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m20258h() {
        MediaItem.kt c2436aM20256f;
        if (this.f18799t == null || this.f18794o == null || (c2436aM20256f = m20256f()) == null) {
            return false;
        }
        return c2436aM20256f.m9437j();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m20253c(int OplusGLSurfaceView_13) {
        ArrayList<MediaItem.kt> arrayList = this.f18794o;
        if (arrayList == null || OplusGLSurfaceView_13 >= arrayList.size()) {
            return false;
        }
        return this.f18794o.get(OplusGLSurfaceView_13).m9437j();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20239a(InverseLinearLayout inverseLinearLayout) {
        if (inverseLinearLayout != null && inverseLinearLayout.getVisibility() == 0) {
            if (this.f18785f > this.f18784e) {
                InverseManager.INS.unRegisterInverse(this.f18789j, inverseLinearLayout);
                inverseLinearLayout.setInverseColor(true);
            } else {
                InverseManager.INS.registerInverse(this.f18789j, inverseLinearLayout);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m20259i() {
        View childAt;
        RecyclerView recyclerView = this.f18799t;
        if (recyclerView == null || (childAt = recyclerView.getChildAt(0)) == null) {
            return 0;
        }
        return ((RecyclerView.C0694j) childAt.getLayoutParams()).m4159h();
    }

    /* compiled from: GalleryPreviewAdapter.java */
    /* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_5$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 extends Handler {
        public COUIBaseListPopupWindow_8(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            MediaItem.kt c2436a = (MediaItem.kt) message.obj;
            GalleryPreviewAdapter c3230k = GalleryPreviewAdapter.this;
            int iM20189a = c3230k.m20189a(BitmapDecodeManager.kt.m9423b(c3230k.f18789j, c2436a, 1));
            GalleryPreviewAdapter c3230k2 = GalleryPreviewAdapter.this;
            c3230k2.f18791l = BitmapDecodeManager.kt.m9421a(c3230k2.f18789j, c2436a, iM20189a);
            GalleryPreviewAdapter.this.f18804y = true;
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.arg1 = message.arg1;
            messageObtain.arg2 = message.arg2;
            if (c2436a.m9433f().endsWith(".dng")) {
                GalleryPreviewAdapter.this.f18800u.sendMessageDelayed(messageObtain, 20L);
            } else {
                GalleryPreviewAdapter.this.f18800u.sendMessage(messageObtain);
            }
        }
    }

    /* compiled from: GalleryPreviewAdapter.java */
    /* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        public IntrinsicsJvm.kt_4(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12959b("GalleryPreviewAdapter", "handleMessage, msg.what: " + message.what);
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2) {
                    GalleryPreviewAdapter.this.notifyItemChanged(message.arg1);
                    return;
                } else {
                    if (OplusGLSurfaceView_13 != 3) {
                        return;
                    }
                    int i2 = message.arg1;
                    GalleryPreviewAdapter.this.notifyItemChanged(i2);
                    GalleryPreviewAdapter.this.notifyItemRangeRemoved(i2, 1);
                    return;
                }
            }
            int i3 = message.arg1;
            int i4 = message.arg2;
            GalleryPreviewAdapter.this.notifyItemInserted(i3);
            GalleryPreviewAdapter c3230k = GalleryPreviewAdapter.this;
            c3230k.notifyItemRangeChanged(i3, c3230k.f18794o.size() - i3);
            if (1 != i4 || GalleryPreviewAdapter.this.f18799t == null) {
                return;
            }
            GalleryPreviewAdapter.this.f18799t.scrollToPosition(i3);
        }
    }
}
