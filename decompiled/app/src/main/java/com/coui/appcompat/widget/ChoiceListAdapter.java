package com.coui.appcompat.widget;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.HashSet;

/* compiled from: ChoiceListAdapter.java */
/* renamed from: com.coui.appcompat.widget.v */
/* loaded from: classes.dex */
public class ChoiceListAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f8846a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence[] f8847b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence[] f8848c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f8849d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f8850e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private HashSet<Integer> f8851f;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    public ChoiceListAdapter(Context context, int OplusGLSurfaceView_13, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean z) {
        this.f8850e = false;
        this.f8846a = context;
        this.f8849d = OplusGLSurfaceView_13;
        this.f8847b = charSequenceArr;
        this.f8848c = charSequenceArr2;
        this.f8850e = z;
        this.f8851f = new HashSet<>();
        if (zArr != null) {
            m8239a(zArr);
        }
    }

    public ChoiceListAdapter(Context context, int OplusGLSurfaceView_13, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this(context, OplusGLSurfaceView_13, charSequenceArr, charSequenceArr2, null, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m8240a(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f8848c;
        if (charSequenceArr != null && OplusGLSurfaceView_13 < charSequenceArr.length) {
            return charSequenceArr[OplusGLSurfaceView_13];
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8239a(boolean[] zArr) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < zArr.length; OplusGLSurfaceView_13++) {
            if (zArr[OplusGLSurfaceView_13]) {
                this.f8851f.add(Integer.valueOf(OplusGLSurfaceView_13));
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.f8847b;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f8847b;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[OplusGLSurfaceView_13];
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        View viewInflate;
        PlatformImplementations.kt_3 aVar;
        if (view == null) {
            aVar = new PlatformImplementations.kt_3();
            viewInflate = LayoutInflater.from(this.f8846a).inflate(this.f8849d, viewGroup, false);
            aVar.f8853b = (TextView) viewInflate.findViewById(R.id_renamed.text1);
            aVar.f8852a = (TextView) viewInflate.findViewById(coui.support.appcompat.R.id_renamed.summary_text2);
            if (this.f8850e) {
                aVar.f8854c = (COUICheckBox) viewInflate.findViewById(coui.support.appcompat.R.id_renamed.checkbox);
            } else {
                aVar.f8855d = (RadioButton) viewInflate.findViewById(coui.support.appcompat.R.id_renamed.radio_button);
            }
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (PlatformImplementations.kt_3) view.getTag();
        }
        if (this.f8850e) {
            aVar.f8854c.setState(this.f8851f.contains(Integer.valueOf(OplusGLSurfaceView_13)) ? 2 : 0);
        }
        CharSequence item = getItem(OplusGLSurfaceView_13);
        CharSequence charSequenceM8240a = m8240a(OplusGLSurfaceView_13);
        aVar.f8853b.setText(item);
        if (TextUtils.isEmpty(charSequenceM8240a)) {
            aVar.f8852a.setVisibility(8);
        } else {
            aVar.f8852a.setVisibility(0);
            aVar.f8852a.setText(charSequenceM8240a);
        }
        return viewInflate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8241a(int OplusGLSurfaceView_13, int i2, ListView listView) {
        int firstVisiblePosition = i2 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((PlatformImplementations.kt_3) listView.getChildAt(firstVisiblePosition).getTag()).f8854c.setState(OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 2) {
                this.f8851f.add(Integer.valueOf(i2));
            } else {
                this.f8851f.remove(Integer.valueOf(i2));
            }
        }
    }

    /* compiled from: ChoiceListAdapter.java */
    /* renamed from: com.coui.appcompat.widget.v$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        TextView f8852a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        TextView f8853b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        COUICheckBox f8854c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        RadioButton f8855d;

        PlatformImplementations.kt_3() {
        }
    }
}
