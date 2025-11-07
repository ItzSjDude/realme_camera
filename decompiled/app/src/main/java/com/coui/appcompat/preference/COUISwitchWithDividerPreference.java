package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.PreferenceViewHolder;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISwitchWithDividerPreference extends COUISwitchPreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LinearLayout f7031b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearLayout f7032c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InterfaceC1337a f7033d;

    /* renamed from: com.coui.appcompat.preference.COUISwitchWithDividerPreference$PlatformImplementations.kt_3 */
    public interface InterfaceC1337a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m6938a();
    }

    public COUISwitchWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiSwitchWithDividerPreferenceStyle);
    }

    public COUISwitchWithDividerPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUISwitchWithDividerPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        this.f7031b = (LinearLayout) c0668l.itemView.findViewById(R.id_renamed.main_layout);
        LinearLayout linearLayout = this.f7031b;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUISwitchWithDividerPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUISwitchWithDividerPreference.this.f7033d != null) {
                        COUISwitchWithDividerPreference.this.f7033d.m6938a();
                    }
                }
            });
            this.f7031b.setClickable(m3858z());
        }
        this.f7032c = (LinearLayout) c0668l.itemView.findViewById(R.id_renamed.switch_layout);
        LinearLayout linearLayout2 = this.f7032c;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUISwitchWithDividerPreference.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUISwitchWithDividerPreference.super.mo3743g();
                }
            });
            this.f7032c.setClickable(m3858z());
        }
    }
}
