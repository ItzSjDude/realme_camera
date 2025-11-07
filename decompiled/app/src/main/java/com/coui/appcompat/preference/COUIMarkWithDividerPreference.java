package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.PreferenceViewHolder;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIMarkWithDividerPreference extends COUIMarkPreference {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearLayout f6944c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LinearLayout f6945d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InterfaceC1322a f6946e;

    /* renamed from: com.coui.appcompat.preference.COUIMarkWithDividerPreference$PlatformImplementations.kt_3 */
    public interface InterfaceC1322a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m6908a();
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiRadioWithDividerPreferenceStyle);
    }

    @Override // com.coui.appcompat.preference.COUIMarkPreference, androidx.preference.CheckBoxPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        this.f6944c = (LinearLayout) c0668l.itemView.findViewById(R.id_renamed.main_layout);
        LinearLayout linearLayout = this.f6944c;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIMarkWithDividerPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUIMarkWithDividerPreference.this.f6946e != null) {
                        COUIMarkWithDividerPreference.this.f6946e.m6908a();
                    }
                }
            });
            this.f6944c.setClickable(m3858z());
        }
        this.f6945d = (LinearLayout) c0668l.itemView.findViewById(R.id_renamed.radio_layout);
        LinearLayout linearLayout2 = this.f6945d;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIMarkWithDividerPreference.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIMarkWithDividerPreference.super.mo3743g();
                }
            });
            this.f6945d.setClickable(m3858z());
        }
    }
}
