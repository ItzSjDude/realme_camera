package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.sticker.p168ui.StickerMenu;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: StickerCategoryAdapter.java */
/* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class StickerCategoryAdapter extends RecyclerView.AbstractC0685a {

    /* renamed from: PlatformImplementations.kt_3 */
    private ArrayList<StickerMenu.IntrinsicsJvm.kt_4> f16353a = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HashMap<Integer, RecyclerView.AbstractC0707w> f16354b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f16355c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private StickerCategoryInterface f16356d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f16357e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f16358f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16359g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16360h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f16361i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f16362j;

    public StickerCategoryAdapter(Context context, StickerCategoryInterface interfaceC3014g, int OplusGLSurfaceView_13) {
        this.f16356d = null;
        this.f16358f = null;
        this.f16359g = 0;
        this.f16360h = 0;
        this.f16361i = 0;
        this.f16362j = 0;
        this.f16356d = interfaceC3014g;
        this.f16358f = context;
        this.f16362j = this.f16358f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_redpoint_radius);
        this.f16361i = this.f16358f.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_redpoint_margin_top);
        this.f16360h = this.f16358f.getResources().getDimensionPixelSize(R.dimen.sticker_type_thumbnail_display_size);
        this.f16357e = OplusGLSurfaceView_13;
        this.f16359g = this.f16358f.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_item_size);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17074a(ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList) {
        this.f16353a.clear();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f16353a.addAll(arrayList.subList(1, arrayList.size()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public StickerMenu.IntrinsicsJvm.kt_4 m17073a(int OplusGLSurfaceView_13) {
        return this.f16353a.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17075b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("StickerCategoryAdapter", "setSelectIndex, index: " + OplusGLSurfaceView_13);
        RecyclerView.AbstractC0707w abstractC0707w = this.f16354b.get(Integer.valueOf(this.f16355c));
        RecyclerView.AbstractC0707w abstractC0707w2 = this.f16354b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (abstractC0707w != null) {
            ((PlatformImplementations.kt_3) abstractC0707w).f16363a.setImageDrawable(m17070a(this.f16355c, false));
        }
        if (abstractC0707w2 != null && OplusGLSurfaceView_13 >= 0) {
            ((PlatformImplementations.kt_3) abstractC0707w2).f16363a.setImageDrawable(m17070a(OplusGLSurfaceView_13, true));
        }
        this.f16355c = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17076c(int OplusGLSurfaceView_13) {
        this.f16357e = OplusGLSurfaceView_13;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public RecyclerView.AbstractC0707w onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        RotateImageView rotateImageView = new RotateImageView(this.f16358f);
        int i2 = this.f16359g;
        rotateImageView.setLayoutParams(new RelativeLayout.LayoutParams(i2, i2));
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(rotateImageView, this.f16356d);
        rotateImageView.m18348a(this.f16357e, true);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onBindViewHolder(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) {
        this.f16354b.put(Integer.valueOf(OplusGLSurfaceView_13), abstractC0707w);
        PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) abstractC0707w;
        RotateImageView rotateImageView = aVar.f16363a;
        if (OplusGLSurfaceView_13 == this.f16355c) {
            rotateImageView.setImageDrawable(m17070a(OplusGLSurfaceView_13, true));
        } else {
            rotateImageView.setImageDrawable(m17070a(OplusGLSurfaceView_13, false));
        }
        rotateImageView.setOnClickListener(aVar);
        rotateImageView.m18348a(this.f16357e, true);
        rotateImageView.setTag(Integer.valueOf(OplusGLSurfaceView_13));
        rotateImageView.setContentDescription(this.f16358f.getResources().getString(R.string.camera_description_sticker_category_item) + OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m17070a(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 >= this.f16353a.size()) {
            return null;
        }
        Drawable drawable = this.f16353a.get(OplusGLSurfaceView_13).f16442b;
        if (z) {
            drawable = this.f16353a.get(OplusGLSurfaceView_13).f16441a;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        int i2 = this.f16360h;
        layerDrawable.setLayerSize(0, i2, i2);
        return this.f16353a.get(OplusGLSurfaceView_13).f16444d ? m17071a(layerDrawable) : layerDrawable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private LayerDrawable m17071a(Drawable drawable) {
        Drawable[] drawableArr = {drawable, this.f16358f.getResources().getDrawable(R.drawable.sticker_red_point)};
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int intrinsicWidth = drawableArr[0].getIntrinsicWidth();
        int intrinsicWidth2 = drawableArr[1].getIntrinsicWidth();
        int OplusGLSurfaceView_13 = this.f16359g;
        int i2 = (OplusGLSurfaceView_13 - intrinsicWidth) / 2;
        int i3 = i2 + 0;
        int i4 = OplusGLSurfaceView_13 - (intrinsicWidth + i2);
        int i5 = this.f16362j;
        int i6 = OplusGLSurfaceView_13 - ((intrinsicWidth2 / 2) + i5);
        int i7 = i5 - this.f16361i;
        int i8 = i6 + intrinsicWidth2;
        int i9 = i6 - 0;
        int i10 = i7 + 0;
        int i11 = OplusGLSurfaceView_13 - i8;
        int i12 = OplusGLSurfaceView_13 - (intrinsicWidth2 + i7);
        if (i3 < 0 || i3 < 0 || i4 > 0 || i4 > 0) {
            CameraLog.m12967f("StickerCategoryAdapter", "downloadSuccess, drawable0 out of thumbnail display!");
        }
        layerDrawable.setLayerInset(0, i3, i3, i4, i4);
        layerDrawable.setLayerInset(1, i9, i10, i11, i12);
        return layerDrawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f16353a.size();
    }

    /* compiled from: StickerCategoryAdapter.java */
    /* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w implements View.OnClickListener {

        /* renamed from: PlatformImplementations.kt_3 */
        public RotateImageView f16363a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private StickerCategoryInterface f16365c;

        public PlatformImplementations.kt_3(View view, StickerCategoryInterface interfaceC3014g) {
            super(view);
            this.f16363a = (RotateImageView) view;
            this.f16363a.setOnClickListener(this);
            this.f16365c = interfaceC3014g;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            CameraLog.m12959b("StickerCategoryAdapter", "onClick, clickIndex: " + iIntValue + ", mSelectedIndexInAdapter: " + StickerCategoryAdapter.this.f16355c);
            if (StickerCategoryAdapter.this.f16355c == iIntValue) {
                return;
            }
            StickerCategoryAdapter.this.m17075b(iIntValue);
            this.f16365c.mo17078a(StickerCategoryAdapter.this.f16355c + 1, StickerCategoryAdapter.this.f16355c, ((StickerMenu.IntrinsicsJvm.kt_4) StickerCategoryAdapter.this.f16353a.get(StickerCategoryAdapter.this.f16355c)).f16443c, false);
        }
    }
}
