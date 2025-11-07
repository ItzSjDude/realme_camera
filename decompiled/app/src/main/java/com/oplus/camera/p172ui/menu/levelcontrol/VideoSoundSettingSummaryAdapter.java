package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.oplus.camera.R;

/* compiled from: VideoSoundSettingSummaryAdapter.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.s */
/* loaded from: classes2.dex */
public class VideoSoundSettingSummaryAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f19877a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f19878b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f19879c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f19880d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f19881e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence[] f19882f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CharSequence[] f19883g;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public VideoSoundSettingSummaryAdapter(Context context, boolean z, boolean z2, int OplusGLSurfaceView_13, boolean z3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f19877a = z;
        this.f19878b = z2;
        this.f19879c = context;
        this.f19880d = OplusGLSurfaceView_13;
        this.f19881e = z3;
        this.f19882f = charSequenceArr;
        this.f19883g = charSequenceArr2;
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        View viewInflate;
        PlatformImplementations.kt_3 aVar;
        if (view == null) {
            aVar = new PlatformImplementations.kt_3();
            viewInflate = LayoutInflater.from(this.f19879c).inflate(R.layout.oplus_preference_select_layout, viewGroup, false);
            aVar.f19884a = (TextView) viewInflate.findViewById(R.id_renamed.pref_title);
            aVar.f19885b = (TextView) viewInflate.findViewById(R.id_renamed.pref_summary);
            aVar.f19886c = (CheckBox) viewInflate.findViewById(R.id_renamed.pref_checkbox);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (PlatformImplementations.kt_3) view.getTag();
        }
        CharSequence item = getItem(OplusGLSurfaceView_13);
        CharSequence charSequenceM21032c = m21032c(OplusGLSurfaceView_13);
        aVar.f19884a.setText(item);
        if (TextUtils.isEmpty(charSequenceM21032c)) {
            aVar.f19885b.setVisibility(8);
        } else {
            aVar.f19885b.setVisibility(0);
            aVar.f19885b.setText(charSequenceM21032c);
        }
        aVar.f19886c.setChecked(this.f19880d == OplusGLSurfaceView_13);
        if (isEnabled(OplusGLSurfaceView_13)) {
            aVar.f19884a.setTextColor(this.f19879c.getResources().getColor(R.color.setting_pref_title_color));
            aVar.f19885b.setTextColor(this.f19879c.getResources().getColor(R.color.setting_pref_summary_color));
        } else {
            aVar.f19884a.setTextColor(this.f19879c.getResources().getColor(R.color.setting_pref_text_disable_color));
            aVar.f19885b.setTextColor(this.f19879c.getResources().getColor(R.color.setting_pref_text_disable_color));
        }
        return viewInflate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21033a(int OplusGLSurfaceView_13) {
        this.f19880d = OplusGLSurfaceView_13;
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int OplusGLSurfaceView_13) {
        return (this.f19881e && 2 == OplusGLSurfaceView_13) ? false : true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.f19882f;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f19882f;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence m21032c(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f19883g;
        if (charSequenceArr != null && OplusGLSurfaceView_13 < charSequenceArr.length) {
            return charSequenceArr[OplusGLSurfaceView_13];
        }
        return null;
    }

    /* compiled from: VideoSoundSettingSummaryAdapter.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.s$PlatformImplementations.kt_3 */
    private final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        TextView f19884a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        TextView f19885b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        CheckBox f19886c;

        private PlatformImplementations.kt_3() {
        }
    }
}
