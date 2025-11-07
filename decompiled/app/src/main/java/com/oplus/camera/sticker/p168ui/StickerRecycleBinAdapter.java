package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.sticker.StickerItemDBHelper;
import com.oplus.camera.sticker.data.StickerItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StickerRecycleBinAdapter.java */
/* renamed from: com.oplus.camera.sticker.ui.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class StickerRecycleBinAdapter extends CursorAdapter implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private HashMap<String, StickerItem> f16471a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f16472b;

    /* compiled from: StickerRecycleBinAdapter.java */
    /* renamed from: com.oplus.camera.sticker.ui.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17164a(StickerRecycleBinAdapter viewOnClickListenerC3018k);
    }

    public StickerRecycleBinAdapter(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f16471a = new HashMap<>();
        this.f16472b = null;
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.editor_sticker_recycle_bin_item_layout, viewGroup, false);
        relativeLayout.setTag(new IntrinsicsJvm.kt_4(relativeLayout));
        return relativeLayout;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) view.getTag();
        StickerItem stickerItemM16953a = StickerItemDBHelper.m16953a(cursor);
        CameraLog.m12954a("StickerRecycleBinAdapter", "bindView, item: " + stickerItemM16953a);
        bVar.f16473a.setNormalDrawableUri(stickerItemM16953a.getThumbnailFileUri());
        view.setTag(R.id_renamed.sticker_recycle_bin_item_tag, stickerItemM16953a);
        view.setOnClickListener(this);
        if (this.f16471a.containsKey(stickerItemM16953a.getStickerUUID())) {
            bVar.f16474b.setChecked(true);
        } else {
            bVar.f16474b.setChecked(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17156a() {
        for (StickerItem stickerItem : m17155g()) {
            this.f16471a.put(stickerItem.getStickerUUID(), stickerItem);
        }
        PlatformImplementations.kt_3 aVar = this.f16472b;
        if (aVar != null) {
            aVar.mo17164a(this);
        }
        notifyDataSetChanged();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17159b() {
        this.f16471a.clear();
        PlatformImplementations.kt_3 aVar = this.f16472b;
        if (aVar != null) {
            aVar.mo17164a(this);
        }
        notifyDataSetChanged();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m17160c() {
        return getCount() != 0 && getCount() == this.f16471a.size();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m17161d() {
        return this.f16471a.size();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Map<String, StickerItem> m17162e() {
        return this.f16471a;
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        Cursor cursor = getCursor();
        if (cursor == null || cursor.isClosed()) {
            CameraLog.m12966e("StickerRecycleBinAdapter", "getCount, cursor is null or closed! cursor: " + cursor);
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int OplusGLSurfaceView_13) {
        Cursor cursor = getCursor();
        if (cursor == null || OplusGLSurfaceView_13 >= cursor.getCount()) {
            return null;
        }
        cursor.moveToPosition(OplusGLSurfaceView_13);
        return StickerItemDBHelper.m16953a(cursor);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17163f() {
        this.f16471a.clear();
        if (getCursor() != null) {
            getCursor().close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17157a(StickerItem stickerItem) {
        if (stickerItem == null || TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            return;
        }
        if (this.f16471a.size() > 0 && this.f16471a.remove(stickerItem.getStickerUUID()) != null) {
            CameraLog.m12959b("StickerRecycleBinAdapter", "onStickerDelete, remove PlatformImplementations.kt_3 selected sticker item!");
            PlatformImplementations.kt_3 aVar = this.f16472b;
            if (aVar != null) {
                aVar.mo17164a(this);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag(R.id_renamed.sticker_recycle_bin_item_tag);
        if (tag instanceof StickerItem) {
            StickerItem stickerItem = (StickerItem) tag;
            if (this.f16471a.containsKey(stickerItem.getStickerUUID())) {
                this.f16471a.remove(stickerItem.getStickerUUID());
            } else {
                this.f16471a.put(stickerItem.getStickerUUID(), stickerItem);
            }
            PlatformImplementations.kt_3 aVar = this.f16472b;
            if (aVar != null) {
                aVar.mo17164a(this);
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17158a(PlatformImplementations.kt_3 aVar) {
        this.f16472b = aVar;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private List<StickerItem> m17155g() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                arrayList.add(StickerItemDBHelper.m16953a(cursor));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    /* compiled from: StickerRecycleBinAdapter.java */
    /* renamed from: com.oplus.camera.sticker.ui.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private StickerRecycleBinThumbnailView f16473a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private CheckBox f16474b;

        public IntrinsicsJvm.kt_4(View view) {
            this.f16473a = null;
            this.f16474b = null;
            this.f16473a = (StickerRecycleBinThumbnailView) view.findViewById(R.id_renamed.sticker_thumbnail);
            this.f16474b = (CheckBox) view.findViewById(R.id_renamed.sticker_check_box);
        }
    }
}
