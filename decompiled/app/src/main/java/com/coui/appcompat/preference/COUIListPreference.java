package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.ListPreference;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIListPreference extends ListPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    CharSequence f6926a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    CharSequence f6927b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    CharSequence f6928c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    Drawable f6929d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    CharSequence[] f6930e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence f6931f;

    public COUIListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIJumpPreference, 0, 0);
        this.f6929d = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIJumpPreference_coui_jump_mark);
        this.f6926a = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status1);
        this.f6927b = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status2);
        this.f6928c = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, 0, 0);
        this.f6931f = typedArrayObtainStyledAttributes2.getText(R.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public COUIListPreference(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        ImageView imageView = (ImageView) c0668l.m4007a(R.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            Drawable drawable = this.f6929d;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        TextView textView = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f6926a;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText2);
        if (textView2 != null) {
            CharSequence charSequence2 = this.f6927b;
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText3);
        if (textView3 != null) {
            CharSequence charSequence3 = this.f6928c;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView4 != null) {
            CharSequence charSequenceM6904h = m6904h();
            if (!TextUtils.isEmpty(charSequenceM6904h)) {
                textView4.setText(charSequenceM6904h);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public CharSequence m6904h() {
        return this.f6931f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6903c(CharSequence charSequence) {
        if (TextUtils.equals(this.f6931f, charSequence)) {
            return;
        }
        this.f6931f = charSequence;
        mo3748i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6902a(CharSequence[] charSequenceArr) {
        this.f6930e = charSequenceArr;
    }

    /* renamed from: U */
    CharSequence[] m6901U() {
        return this.f6930e;
    }
}
