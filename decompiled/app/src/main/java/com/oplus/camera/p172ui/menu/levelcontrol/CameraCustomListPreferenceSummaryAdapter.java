package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.oplus.camera.R;

/* compiled from: CameraCustomListPreferenceSummaryAdapter.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class CameraCustomListPreferenceSummaryAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f19655a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f19656b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f19657c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f19658d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence[] f19659e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence[] f19660f;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public CameraCustomListPreferenceSummaryAdapter(Context context, boolean z, boolean z2, int OplusGLSurfaceView_13, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f19655a = z;
        this.f19656b = z2;
        this.f19657c = context;
        this.f19658d = OplusGLSurfaceView_13;
        this.f19659e = charSequenceArr;
        this.f19660f = charSequenceArr2;
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewInflate;
        PlatformImplementations.kt_3 aVar;
        if (view == null) {
            aVar = new PlatformImplementations.kt_3();
            viewInflate = LayoutInflater.from(this.f19657c).inflate(R.layout.oplus_preference_select_layout, viewGroup, false);
            aVar.f19661a = (TextView) viewInflate.findViewById(R.id_renamed.pref_title);
            aVar.f19662b = (TextView) viewInflate.findViewById(R.id_renamed.pref_summary);
            aVar.f19663c = (CheckBox) viewInflate.findViewById(R.id_renamed.pref_checkbox);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (PlatformImplementations.kt_3) view.getTag();
        }
        CharSequence item = getItem(OplusGLSurfaceView_13);
        CharSequence charSequenceM20838b = m20838b(OplusGLSurfaceView_13);
        aVar.f19661a.setText(item);
        if (TextUtils.isEmpty(charSequenceM20838b)) {
            aVar.f19662b.setVisibility(8);
        } else {
            aVar.f19662b.setVisibility(0);
            aVar.f19662b.setText(charSequenceM20838b);
        }
        aVar.f19663c.setChecked(this.f19658d == OplusGLSurfaceView_13);
        m20837a(OplusGLSurfaceView_13, viewInflate);
        return viewInflate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20837a(int OplusGLSurfaceView_13, View view) throws Resources.NotFoundException {
        int dimensionPixelSize = this.f19657c.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (getCount() > 1) {
            if (OplusGLSurfaceView_13 == getCount() - 1) {
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                view.setPadding(paddingLeft, 0, paddingRight, dimensionPixelSize + 0);
            }
            if (this.f19655a || this.f19656b || OplusGLSurfaceView_13 != 0) {
                return;
            }
            view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
            view.setPadding(paddingLeft, dimensionPixelSize + 0, paddingRight, 0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.f19659e;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f19659e;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence m20838b(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f19660f;
        if (charSequenceArr != null && OplusGLSurfaceView_13 < charSequenceArr.length) {
            return charSequenceArr[OplusGLSurfaceView_13];
        }
        return null;
    }

    /* compiled from: CameraCustomListPreferenceSummaryAdapter.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        TextView f19661a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        TextView f19662b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        CheckBox f19663c;

        private PlatformImplementations.kt_3() {
        }
    }
}
