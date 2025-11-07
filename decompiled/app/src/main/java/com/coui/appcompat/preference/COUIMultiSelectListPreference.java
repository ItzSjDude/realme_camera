package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.MultiSelectListPreference;
import coui.support.appcompat.R;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class COUIMultiSelectListPreference extends MultiSelectListPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    Context f6949a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    CharSequence f6950b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    CharSequence f6951c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    CharSequence f6952d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    Drawable f6953e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Set<String> f6954f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CharSequence f6955g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CharSequence[] f6956h;

    public COUIMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6954f = new HashSet();
        this.f6949a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIJumpPreference, 0, 0);
        this.f6953e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIJumpPreference_coui_jump_mark);
        this.f6950b = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status1);
        this.f6951c = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status2);
        this.f6952d = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, 0, 0);
        this.f6955g = typedArrayObtainStyledAttributes2.getText(R.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public COUIMultiSelectListPreference(Context context) {
        super(context, null);
        this.f6954f = new HashSet();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        ImageView imageView = (ImageView) c0668l.m4007a(R.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            Drawable drawable = this.f6953e;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        TextView textView = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f6950b;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText2);
        if (textView2 != null) {
            CharSequence charSequence2 = this.f6951c;
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText3);
        if (textView3 != null) {
            CharSequence charSequence3 = this.f6952d;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView4 != null) {
            CharSequence charSequenceM6911o = m6911o();
            if (!TextUtils.isEmpty(charSequenceM6911o)) {
                textView4.setText(charSequenceM6911o);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    /* renamed from: o */
    public CharSequence m6911o() {
        return this.f6955g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6910c(CharSequence charSequence) {
        if (TextUtils.equals(this.f6955g, charSequence)) {
            return;
        }
        this.f6955g = charSequence;
        mo3748i();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6909b(CharSequence[] charSequenceArr) {
        this.f6956h = charSequenceArr;
    }

    /* renamed from: p */
    CharSequence[] m6912p() {
        return this.f6956h;
    }
}
