package com.oplus.camera.sticker.p168ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.p177a.ImageStickerTools;
import com.oplus.camera.sticker.data.StickerItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: StickerPageAdapter.java */
/* renamed from: com.oplus.camera.sticker.ui.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class StickerPageAdapter extends PagerAdapter {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f16459b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Activity f16461d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private StickerMenuListener f16462e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ImageDownloader f16463f;

    /* renamed from: PlatformImplementations.kt_3 */
    private ArrayList<StickerGridViewLayout> f16458a = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f16460c = 0;

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo5011a(View view, Object obj) {
        return view == obj;
    }

    public StickerPageAdapter(Activity activity, int OplusGLSurfaceView_13, StickerItem stickerItem, StickerMenuListener interfaceC3016i, ImageDownloader c3010c) {
        this.f16459b = 0;
        this.f16461d = null;
        this.f16462e = null;
        this.f16463f = null;
        this.f16459b = OplusGLSurfaceView_13;
        this.f16461d = activity;
        this.f16462e = interfaceC3016i;
        this.f16463f = c3010c;
        m17147a(stickerItem, true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17152c(int OplusGLSurfaceView_13) {
        this.f16460c = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m17153d() {
        return this.f16460c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17154d(int OplusGLSurfaceView_13) {
        this.f16459b = OplusGLSurfaceView_13;
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList != null) {
            Iterator<StickerGridViewLayout> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setOrientation(this.f16459b);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17151a(boolean z) {
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList != null) {
            Iterator<StickerGridViewLayout> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setGridViewEnable(z);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17149a(String str, final int OplusGLSurfaceView_13, final int i2, final Drawable drawable, final boolean z, final StickerItem stickerItem) {
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        final StickerGridViewLayout stickerGridViewLayoutM17146b = m17146b(str);
        Activity activity = this.f16461d;
        if (activity == null || stickerGridViewLayoutM17146b == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.sticker.ui.OplusGLSurfaceView_15.1
            @Override // java.lang.Runnable
            public void run() {
                stickerGridViewLayoutM17146b.m16999a(OplusGLSurfaceView_13, i2, drawable, z, stickerItem);
            }
        });
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo5000a() {
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public Object mo5004a(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        StickerGridViewLayout stickerGridViewLayout = this.f16458a.get(OplusGLSurfaceView_13);
        if (stickerGridViewLayout != null) {
            if (viewGroup.indexOfChild(stickerGridViewLayout) == -1) {
                viewGroup.addView(this.f16458a.get(OplusGLSurfaceView_13));
            }
            stickerGridViewLayout.setStickerMenuListener(this.f16462e);
            stickerGridViewLayout.setImageDownloader(this.f16463f);
        }
        return stickerGridViewLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5010a(ViewGroup viewGroup, int OplusGLSurfaceView_13, Object obj) {
        StickerGridViewLayout stickerGridViewLayout = this.f16458a.get(OplusGLSurfaceView_13);
        if (stickerGridViewLayout == null || viewGroup.indexOfChild(stickerGridViewLayout) == -1) {
            return;
        }
        viewGroup.removeView(stickerGridViewLayout);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17148a(String str) {
        StickerGridViewLayout stickerGridViewLayoutM17146b;
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList == null || arrayList.isEmpty() || (stickerGridViewLayoutM17146b = m17146b(str)) == null) {
            return;
        }
        stickerGridViewLayoutM17146b.m16998a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17150a(String str, boolean z) {
        StickerGridViewLayout stickerGridViewLayoutM17146b;
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList != null && !arrayList.isEmpty() && (stickerGridViewLayoutM17146b = m17146b(str)) != null) {
            stickerGridViewLayoutM17146b.m16998a();
        }
        if (z) {
            m5019c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17147a(StickerItem stickerItem, boolean z) {
        CameraLog.m12952a("makeGridView");
        ImageStickerTools.IntrinsicsJvm.kt_3 cVarM22718b = ImageStickerTools.m22687b(this.f16461d).m22718b();
        CopyOnWriteArrayList<ImageStickerTools.PlatformImplementations.kt_3> copyOnWriteArrayListM22745b = cVarM22718b.m22745b();
        if (copyOnWriteArrayListM22745b != null && copyOnWriteArrayListM22745b.size() > 0) {
            if (this.f16458a == null) {
                this.f16458a = new ArrayList<>();
            }
            Iterator<ImageStickerTools.PlatformImplementations.kt_3> it = copyOnWriteArrayListM22745b.iterator();
            while (it.hasNext()) {
                ImageStickerTools.PlatformImplementations.kt_3 next = it.next();
                ArrayList arrayList = new ArrayList();
                Iterator<StickerItem> it2 = next.m22725a().iterator();
                while (it2.hasNext()) {
                    StickerItem next2 = it2.next();
                    HashMap map = new HashMap();
                    map.put("state_icon", Integer.valueOf(next2.getDownloadState()));
                    map.put("sticker_item", next2);
                    arrayList.add(map);
                }
                StickerGridViewLayout stickerGridViewLayoutM17146b = m17146b(next.m22728b());
                String categoryId = null;
                if (stickerGridViewLayoutM17146b == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    StickerGridViewLayout stickerGridViewLayout = (StickerGridViewLayout) LayoutInflater.from(this.f16461d).inflate(R.layout.sticker_menu_grid_item, (ViewGroup) null);
                    stickerGridViewLayout.setLayoutParams(layoutParams);
                    stickerGridViewLayout.setTag(next.m22728b());
                    Integer numM22752e = cVarM22718b.m22752e(next.m22728b());
                    int iIntValue = numM22752e != null ? numM22752e.intValue() : -1;
                    if (iIntValue >= 0 && iIntValue < this.f16458a.size()) {
                        this.f16458a.add(iIntValue, stickerGridViewLayout);
                    } else {
                        this.f16458a.add(stickerGridViewLayout);
                    }
                    stickerGridViewLayoutM17146b = stickerGridViewLayout;
                }
                if (stickerItem != null) {
                    categoryId = stickerItem.getCategoryId();
                }
                stickerGridViewLayoutM17146b.m17000a(arrayList, this.f16459b, next.m22728b().equals(categoryId));
            }
            if (z) {
                m5019c();
            }
        }
        CameraLog.m12958b("makeGridView");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StickerGridViewLayout m17146b(String str) {
        ArrayList<StickerGridViewLayout> arrayList = this.f16458a;
        if (arrayList != null && !arrayList.isEmpty() && str != null) {
            Integer numM22752e = ImageStickerTools.m22687b(this.f16461d).m22718b().m22752e(str);
            int iIntValue = numM22752e != null ? numM22752e.intValue() : -1;
            if (iIntValue >= 0 && iIntValue < this.f16458a.size()) {
                return this.f16458a.get(iIntValue);
            }
        }
        return null;
    }
}
