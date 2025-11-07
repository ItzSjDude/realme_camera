package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.util.Util;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class StickerGridViewLayout extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextView f16290a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FooterGridView f16291b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private GridAdapter f16292c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ImageDownloader f16293d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f16294e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private StickerMenuListener f16295f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16296g;

    public StickerGridViewLayout(Context context) {
        this(context, null);
    }

    public StickerGridViewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public StickerGridViewLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, -1, -1);
    }

    public StickerGridViewLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f16290a = null;
        this.f16291b = null;
        this.f16292c = null;
        this.f16293d = null;
        this.f16294e = null;
        this.f16295f = null;
        this.f16296g = 0;
        this.f16294e = context;
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f16296g = OplusGLSurfaceView_13;
        GridAdapter c3008a = this.f16292c;
        if (c3008a != null) {
            c3008a.m17008a(OplusGLSurfaceView_13);
        }
    }

    public void setStickerMenuListener(StickerMenuListener interfaceC3016i) {
        this.f16295f = interfaceC3016i;
        GridAdapter c3008a = this.f16292c;
        if (c3008a != null) {
            c3008a.m17011a(interfaceC3016i);
        }
    }

    public void setImageDownloader(ImageDownloader c3010c) {
        this.f16293d = c3010c;
        GridAdapter c3008a = this.f16292c;
        if (c3008a != null) {
            c3008a.m17010a(c3010c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17000a(List<Map<String, Object>> list, int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("StickerGridViewLayout", "setDataList, stickerItemList.size: " + list.size() + ", needNotify: " + z + ", getTag: " + ((String) getTag()));
        this.f16296g = OplusGLSurfaceView_13;
        GridAdapter c3008a = this.f16292c;
        if (c3008a != null) {
            c3008a.m17012a((String) getTag());
            this.f16292c.m17013a(list);
            this.f16292c.m17011a(this.f16295f);
            this.f16292c.m17008a(this.f16296g);
            if (z) {
                this.f16292c.notifyDataSetChanged();
            }
            if (this.f16290a == null || !StickerCategoryItem.isMyCategory((String) getTag())) {
                return;
            }
            this.f16290a.setVisibility(this.f16292c.getCount() <= 0 ? 0 : 4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16999a(int OplusGLSurfaceView_13, int i2, Drawable drawable, boolean z, StickerItem stickerItem) {
        GridAdapter c3008a = this.f16292c;
        if (c3008a != null) {
            c3008a.m17009a(OplusGLSurfaceView_13, i2, drawable, z, stickerItem);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16998a() {
        GridAdapter c3008a = this.f16292c;
        if (c3008a != null) {
            c3008a.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        if (StickerCategoryItem.isMyCategory((String) getTag()) && this.f16290a == null) {
            this.f16290a = new TextView(this.f16294e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            layoutParams.topMargin = this.f16294e.getResources().getDimensionPixelSize(R.dimen.sticker_tips_margin_top);
            if (StickerCategoryItem.isMyCategory((String) getTag())) {
                this.f16290a.setText(R.string.sticker_tips_none);
            }
            this.f16290a.setTextColor(this.f16294e.getColor(R.color.camera_white));
            this.f16290a.setTextSize(0, this.f16294e.getResources().getDimension(R.dimen.camera_text_size_smaller));
            this.f16290a.setTypeface(Util.m24473l(getContext()));
            this.f16290a.setVisibility(8);
            addView(this.f16290a, layoutParams);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f16291b = (FooterGridView) findViewById(R.id_renamed.sticker_grid_view);
        this.f16292c = new GridAdapter(this.f16294e, this.f16293d, this.f16296g);
        this.f16291b.setAdapter((BaseAdapter) this.f16292c);
        this.f16291b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.oplus.camera.sticker.ui.StickerGridViewLayout.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
                if (StickerGridViewLayout.this.f16295f != null && StickerGridViewLayout.this.f16295f.mo12675i() && StickerGridViewLayout.this.f16292c != null) {
                    StickerItem stickerItemM17015b = StickerGridViewLayout.this.f16292c.m17015b(OplusGLSurfaceView_13);
                    if (stickerItemM17015b == null || StickerGridViewLayout.this.f16295f.mo12665a(stickerItemM17015b, OplusGLSurfaceView_13)) {
                        return;
                    }
                    StickerGridViewLayout.this.f16292c.m17007a();
                    return;
                }
                CameraLog.m12954a("StickerGridViewLayout", "onItemClick, return");
            }
        });
        this.f16291b.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.oplus.camera.sticker.ui.StickerGridViewLayout.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
                CameraLog.m12959b("StickerGridViewLayout", "onItemLongClick, position: " + OplusGLSurfaceView_13 + ", id_renamed: " + OplusGLSurfaceView_15);
                if (StickerGridViewLayout.this.f16295f != null && StickerGridViewLayout.this.f16295f.mo12675i()) {
                    StickerItem stickerItemM17015b = StickerGridViewLayout.this.f16292c.m17015b(OplusGLSurfaceView_13);
                    return stickerItemM17015b == null || StickerGridViewLayout.this.f16295f.mo12664a(view, stickerItemM17015b, OplusGLSurfaceView_13);
                }
                CameraLog.m12954a("StickerGridViewLayout", "onItemLongClick, return");
                return false;
            }
        });
    }

    public void setGridViewEnable(boolean z) {
        FooterGridView footerGridView = this.f16291b;
        if (footerGridView != null) {
            footerGridView.setClickable(z);
            this.f16291b.setEnabled(z);
        }
    }
}
