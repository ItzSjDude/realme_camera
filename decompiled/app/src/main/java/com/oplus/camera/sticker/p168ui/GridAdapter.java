package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.LoaddingProgress;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: GridAdapter.java */
/* renamed from: com.oplus.camera.sticker.ui.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class GridAdapter extends BaseAdapter {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f16309b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ImageDownloader f16310c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<Map<String, Object>> f16311d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private LayoutInflater f16312e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f16313f;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f16316i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f16317j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f16318k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f16319l;

    /* renamed from: PlatformImplementations.kt_3 */
    private StickerMenuListener f16308a = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16314g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Drawable f16315h = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f16320m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f16321n = false;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    public GridAdapter(Context context, ImageDownloader c3010c, int OplusGLSurfaceView_13) {
        this.f16309b = 0;
        this.f16310c = null;
        this.f16311d = null;
        this.f16312e = null;
        this.f16313f = null;
        this.f16316i = 0;
        this.f16317j = 0;
        this.f16318k = 0;
        this.f16319l = 0;
        this.f16310c = c3010c;
        this.f16311d = new ArrayList();
        this.f16313f = context;
        this.f16312e = LayoutInflater.from(context);
        this.f16309b = OplusGLSurfaceView_13;
        this.f16318k = this.f16313f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_image_width);
        this.f16317j = this.f16313f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_highlight_width);
        this.f16316i = this.f16313f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_item_size);
        this.f16319l = this.f16313f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_image_padding);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17012a(String str) {
        this.f16314g = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (StickerCategoryItem.isMyCategory(this.f16314g)) {
            List<Map<String, Object>> list = this.f16311d;
            if (list == null) {
                return 0;
            }
            int size = list.size();
            if (size > 1) {
                return size;
            }
            CameraLog.m12959b("GridAdapter", "getCount, myCategory only has the recycle bin sticker");
            return 0;
        }
        List<Map<String, Object>> list2 = this.f16311d;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int OplusGLSurfaceView_13) {
        return this.f16311d.get(OplusGLSurfaceView_13);
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        GridItemViewTag c3009b;
        CameraLog.m12952a("GridAdapter_getView_" + OplusGLSurfaceView_13 + "_" + this.f16320m);
        if (view == null) {
            view = this.f16312e.inflate(R.layout.sticker_view, (ViewGroup) null);
            int iMax = Math.max(this.f16316i, Math.max(this.f16318k, this.f16317j));
            view.setLayoutParams(new AbsListView.LayoutParams(iMax, iMax));
            c3009b = new GridItemViewTag((LoaddingProgress) view.findViewById(R.id_renamed.loadingView), (RotateImageView) view.findViewById(R.id_renamed.sticker_image), (ImageView) view.findViewById(R.id_renamed.highlight));
            view.setTag(c3009b);
        } else {
            c3009b = (GridItemViewTag) view.getTag();
        }
        if (this.f16320m) {
            CameraLog.m12958b("GridAdapter_getView_" + OplusGLSurfaceView_13 + "_" + this.f16320m);
            return view;
        }
        int iIntValue = ((Integer) this.f16311d.get(OplusGLSurfaceView_13).get("state_icon")).intValue();
        StickerItem stickerItem = (StickerItem) this.f16311d.get(OplusGLSurfaceView_13).get("sticker_item");
        if (this.f16315h == null) {
            this.f16315h = this.f16313f.getResources().getDrawable(R.drawable.sticker_undownload, null);
        }
        if (this.f16310c != null) {
            ImageTagInfo c3011d = new ImageTagInfo();
            c3011d.m17060a(c3009b);
            c3011d.m17061a(stickerItem.getStickerUUID());
            c3011d.m17062a(stickerItem.isStickerNew());
            c3011d.m17064b(stickerItem.hasMusic());
            c3011d.m17059a(iIntValue);
            this.f16310c.m17044a(stickerItem.getThumbnailFileUri(), "parse_url", c3011d);
        }
        m17006a(c3009b, stickerItem.getStickerUUID());
        if (c3009b.f16323b != null) {
            c3009b.f16323b.m18348a(this.f16309b, true);
            if (StickerCategoryItem.isMyCategory(this.f16314g) && OplusGLSurfaceView_13 == 0) {
                c3009b.f16323b.setPadding(0, 0, 0, 0);
            } else {
                RotateImageView rotateImageView = c3009b.f16323b;
                int i2 = this.f16319l;
                rotateImageView.setPadding(i2, i2, i2, i2);
            }
        }
        CameraLog.m12958b("GridAdapter_getView_" + OplusGLSurfaceView_13 + "_" + this.f16320m);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.f16321n = false;
        super.notifyDataSetChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17007a() {
        this.f16321n = true;
        super.notifyDataSetChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17014a(boolean z) {
        this.f16320m = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17011a(StickerMenuListener interfaceC3016i) {
        this.f16308a = interfaceC3016i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17013a(List<Map<String, Object>> list) {
        List<Map<String, Object>> list2 = this.f16311d;
        if (list2 != null) {
            list2.clear();
            this.f16311d.addAll(list);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17009a(int OplusGLSurfaceView_13, int i2, Drawable drawable, boolean z, StickerItem stickerItem) {
        List<Map<String, Object>> list = this.f16311d;
        if (list == null || OplusGLSurfaceView_13 >= list.size() || OplusGLSurfaceView_13 < 0) {
            return;
        }
        this.f16311d.get(OplusGLSurfaceView_13).put("state_icon", Integer.valueOf(i2));
        this.f16311d.get(OplusGLSurfaceView_13).put("sticker_item", stickerItem);
        if (z) {
            notifyDataSetChanged();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17010a(ImageDownloader c3010c) {
        this.f16310c = c3010c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17008a(int OplusGLSurfaceView_13) {
        if (this.f16309b != OplusGLSurfaceView_13) {
            this.f16309b = OplusGLSurfaceView_13;
            notifyDataSetChanged();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public StickerItem m17015b(int OplusGLSurfaceView_13) {
        List<Map<String, Object>> list = this.f16311d;
        if (list == null || OplusGLSurfaceView_13 >= list.size()) {
            return null;
        }
        return (StickerItem) this.f16311d.get(OplusGLSurfaceView_13).get("sticker_item");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17006a(GridItemViewTag c3009b, String str) {
        StickerMenuListener interfaceC3016i;
        if (c3009b.f16324c == null || (interfaceC3016i = this.f16308a) == null) {
            return;
        }
        if (interfaceC3016i.mo12672f() != null && str.equals(this.f16308a.mo12672f().getStickerUUID())) {
            c3009b.m17016a(true, this.f16321n);
        } else {
            c3009b.m17016a(false, this.f16321n);
        }
    }
}
