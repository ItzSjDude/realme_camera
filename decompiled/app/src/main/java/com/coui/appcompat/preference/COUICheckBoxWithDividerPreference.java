package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.CheckBoxPreference;
import com.coui.appcompat.widget.COUICheckBox;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUICheckBoxWithDividerPreference extends CheckBoxPreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f6894b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearLayout f6895c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LinearLayout f6896d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InterfaceC1317a f6897e;

    /* renamed from: com.coui.appcompat.preference.COUICheckBoxWithDividerPreference$PlatformImplementations.kt_3 */
    public interface InterfaceC1317a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m6893a();
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiCheckBoxWithDividerPreferenceStyle);
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUICheckBoxPreference, OplusGLSurfaceView_13, 0);
        this.f6894b = typedArrayObtainStyledAttributes.getText(R.styleable.COUICheckBoxPreference_couiCheckBoxAssignment);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        View viewM4007a = c0668l.m4007a(android.R.id_renamed.checkbox);
        if (viewM4007a != null && (viewM4007a instanceof COUICheckBox)) {
            ((COUICheckBox) viewM4007a).setState(m3901b() ? 2 : 0);
        }
        this.f6895c = (LinearLayout) c0668l.itemView.findViewById(R.id_renamed.main_layout);
        LinearLayout linearLayout = this.f6895c;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUICheckBoxWithDividerPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUICheckBoxWithDividerPreference.this.f6897e != null) {
                        COUICheckBoxWithDividerPreference.this.f6897e.m6893a();
                    }
                }
            });
            this.f6895c.setClickable(m3858z());
        }
        this.f6896d = (LinearLayout) c0668l.itemView.findViewById(R.id_renamed.check_box_layout);
        LinearLayout linearLayout2 = this.f6896d;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUICheckBoxWithDividerPreference.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUICheckBoxWithDividerPreference.super.mo3743g();
                }
            });
            this.f6896d.setClickable(m3858z());
        }
        TextView textView = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView != null) {
            CharSequence charSequenceM6892c = m6892c();
            if (!TextUtils.isEmpty(charSequenceM6892c)) {
                textView.setText(charSequenceM6892c);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CharSequence m6892c() {
        return this.f6894b;
    }
}
