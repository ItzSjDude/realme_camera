package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import coui.support.appcompat.R;

/* compiled from: SummaryAdapter.java */
/* renamed from: com.coui.appcompat.widget.z */
/* loaded from: classes.dex */
public class SummaryAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f8906a = R.layout.coui_alert_dialog_summary_item;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f8907b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f8908c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f8909d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence[] f8910e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence[] f8911f;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public SummaryAdapter(Context context, boolean z, boolean z2, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f8907b = z;
        this.f8908c = z2;
        this.f8909d = context;
        this.f8910e = charSequenceArr;
        this.f8911f = charSequenceArr2;
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f8909d).inflate(f8906a, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(android.R.id_renamed.text1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id_renamed.summary_text2);
        CharSequence item = getItem(OplusGLSurfaceView_13);
        CharSequence charSequenceM8285b = m8285b(OplusGLSurfaceView_13);
        textView.setText(item);
        if (TextUtils.isEmpty(charSequenceM8285b)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequenceM8285b);
        }
        m8283a(OplusGLSurfaceView_13, viewInflate);
        return viewInflate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8283a(int OplusGLSurfaceView_13, View view) throws Resources.NotFoundException {
        int dimensionPixelSize = this.f8909d.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
        int paddingTop = view.getPaddingTop();
        int paddingLeft = view.getPaddingLeft();
        int paddingBottom = view.getPaddingBottom();
        int paddingRight = view.getPaddingRight();
        if (getCount() > 1) {
            if (OplusGLSurfaceView_13 == getCount() - 1) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                return;
            } else {
                if (this.f8907b || this.f8908c) {
                    return;
                }
                if (OplusGLSurfaceView_13 == 0) {
                    view.setPadding(paddingLeft, paddingTop + dimensionPixelSize, paddingRight, paddingBottom);
                    view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                    return;
                } else {
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    return;
                }
            }
        }
        if (getCount() == 1) {
            if (!this.f8907b && !this.f8908c) {
                view.setPadding(paddingLeft, paddingTop + dimensionPixelSize, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + (dimensionPixelSize * 2));
            } else {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.f8910e;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f8910e;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m8285b(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f8911f;
        if (charSequenceArr != null && OplusGLSurfaceView_13 < charSequenceArr.length) {
            return charSequenceArr[OplusGLSurfaceView_13];
        }
        return null;
    }
}
