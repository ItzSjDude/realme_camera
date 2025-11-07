package com.coui.appcompat.dialog.panel;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.widget.COUICheckBox;
import java.util.HashSet;

/* compiled from: COUIBottomSheetChoiceListAdapter.java */
/* renamed from: com.coui.appcompat.dialog.panel.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
class COUIBottomSheetChoiceListAdapter extends RecyclerView.AbstractC0685a<IntrinsicsJvm.kt_4> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f6699a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence[] f6700b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence[] f6701c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f6702d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f6703e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private HashSet<Integer> f6704f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f6705g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6706h;

    /* compiled from: COUIBottomSheetChoiceListAdapter.java */
    /* renamed from: com.coui.appcompat.dialog.panel.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo6696a(View view, int OplusGLSurfaceView_13, int i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    public COUIBottomSheetChoiceListAdapter(Context context, int OplusGLSurfaceView_13, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i2, boolean[] zArr, boolean z) {
        this.f6706h = -1;
        this.f6699a = context;
        this.f6702d = OplusGLSurfaceView_13;
        this.f6700b = charSequenceArr;
        this.f6701c = charSequenceArr2;
        this.f6703e = z;
        this.f6704f = new HashSet<>();
        this.f6706h = i2;
        if (zArr != null) {
            m6685a(zArr);
        }
    }

    public COUIBottomSheetChoiceListAdapter(Context context, int OplusGLSurfaceView_13, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i2) {
        this(context, OplusGLSurfaceView_13, charSequenceArr, charSequenceArr2, i2, null, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m6692a(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f6701c;
        if (charSequenceArr == null || OplusGLSurfaceView_13 >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m6695b(int OplusGLSurfaceView_13) {
        CharSequence[] charSequenceArr = this.f6700b;
        if (charSequenceArr == null || OplusGLSurfaceView_13 >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[OplusGLSurfaceView_13];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6693a(PlatformImplementations.kt_3 aVar) {
        this.f6705g = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6685a(boolean[] zArr) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < zArr.length; OplusGLSurfaceView_13++) {
            if (zArr[OplusGLSurfaceView_13]) {
                this.f6704f.add(Integer.valueOf(OplusGLSurfaceView_13));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        CharSequence[] charSequenceArr = this.f6700b;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public IntrinsicsJvm.kt_4 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        return new IntrinsicsJvm.kt_4(LayoutInflater.from(this.f6699a).inflate(this.f6702d, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final IntrinsicsJvm.kt_4 bVar, final int OplusGLSurfaceView_13) {
        if (this.f6703e) {
            bVar.f6712c.setState(this.f6704f.contains(Integer.valueOf(OplusGLSurfaceView_13)) ? 2 : 0);
        } else {
            bVar.f6713d.setChecked(this.f6706h == OplusGLSurfaceView_13);
        }
        CharSequence charSequenceM6695b = m6695b(OplusGLSurfaceView_13);
        CharSequence charSequenceM6692a = m6692a(OplusGLSurfaceView_13);
        bVar.f6711b.setText(charSequenceM6695b);
        if (TextUtils.isEmpty(charSequenceM6692a)) {
            bVar.f6710a.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f6711b.getLayoutParams();
            layoutParams.addRule(15);
            bVar.f6711b.setLayoutParams(layoutParams);
        } else {
            bVar.f6710a.setVisibility(0);
            bVar.f6710a.setText(charSequenceM6692a);
        }
        if (this.f6705g != null) {
            bVar.f6714e.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.dialog.panel.PlatformImplementations.kt_3.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i2;
                    if (!COUIBottomSheetChoiceListAdapter.this.f6703e) {
                        if (OplusGLSurfaceView_13 == COUIBottomSheetChoiceListAdapter.this.f6706h) {
                            COUIBottomSheetChoiceListAdapter.this.f6705g.mo6696a(view, OplusGLSurfaceView_13, 0);
                            return;
                        }
                        boolean zIsChecked = bVar.f6713d.isChecked();
                        i2 = !zIsChecked ? 1 : 0;
                        bVar.f6713d.setChecked(!zIsChecked);
                        COUIBottomSheetChoiceListAdapter c1308a = COUIBottomSheetChoiceListAdapter.this;
                        c1308a.notifyItemChanged(c1308a.f6706h);
                        COUIBottomSheetChoiceListAdapter.this.f6706h = OplusGLSurfaceView_13;
                    } else {
                        if (bVar.f6712c.getState() != 2) {
                            COUIBottomSheetChoiceListAdapter.this.f6704f.add(Integer.valueOf(OplusGLSurfaceView_13));
                        } else {
                            COUIBottomSheetChoiceListAdapter.this.f6704f.remove(Integer.valueOf(OplusGLSurfaceView_13));
                        }
                        i2 = COUIBottomSheetChoiceListAdapter.this.f6704f.contains(Integer.valueOf(OplusGLSurfaceView_13)) ? 2 : 0;
                        bVar.f6712c.setState(i2);
                    }
                    COUIBottomSheetChoiceListAdapter.this.f6705g.mo6696a(view, OplusGLSurfaceView_13, i2);
                }
            });
        }
    }

    /* compiled from: COUIBottomSheetChoiceListAdapter.java */
    /* renamed from: com.coui.appcompat.dialog.panel.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        TextView f6710a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        TextView f6711b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        COUICheckBox f6712c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        RadioButton f6713d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        View f6714e;

        public IntrinsicsJvm.kt_4(View view) {
            super(view);
            this.f6711b = (TextView) view.findViewById(R.id_renamed.text1);
            this.f6710a = (TextView) view.findViewById(coui.support.appcompat.R.id_renamed.summary_text2);
            if (COUIBottomSheetChoiceListAdapter.this.f6703e) {
                this.f6712c = (COUICheckBox) view.findViewById(coui.support.appcompat.R.id_renamed.checkbox);
            } else {
                this.f6713d = (RadioButton) view.findViewById(coui.support.appcompat.R.id_renamed.radio_button);
            }
            view.setBackground(COUIBottomSheetChoiceListAdapter.this.f6699a.getDrawable(coui.support.appcompat.R.drawable.coui_list_selector_background));
            this.f6714e = view;
        }
    }
}
