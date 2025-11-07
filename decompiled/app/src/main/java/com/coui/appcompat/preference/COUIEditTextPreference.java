package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.EditTextPreference;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIEditTextPreference extends EditTextPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f6900a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f6901b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f6902c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence f6903d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Drawable f6904e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f6905f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Drawable f6906g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CharSequence f6907h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f6908i;

    public COUIEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6905f = true;
        this.f6900a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIJumpPreference, 0, 0);
        this.f6904e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIJumpPreference_coui_jump_mark);
        this.f6901b = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status1);
        this.f6902c = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status2);
        this.f6903d = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, 0, 0);
        this.f6905f = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f6905f);
        this.f6906g = typedArrayObtainStyledAttributes2.getDrawable(R.styleable.COUIPreference_couiDividerDrawable);
        this.f6907h = typedArrayObtainStyledAttributes2.getText(R.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, R.styleable.couiEditTextPreference, 0, 0);
        this.f6908i = typedArrayObtainStyledAttributes3.getBoolean(R.styleable.couiEditTextPreference_couiSupportEmptyInput, false);
        typedArrayObtainStyledAttributes3.recycle();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        ImageView imageView = (ImageView) c0668l.m4007a(R.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            Drawable drawable = this.f6904e;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        TextView textView = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f6901b;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText2);
        if (textView2 != null) {
            CharSequence charSequence2 = this.f6902c;
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText3);
        if (textView3 != null) {
            CharSequence charSequence3 = this.f6903d;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView4 != null) {
            CharSequence charSequenceM6894m = m6894m();
            if (!TextUtils.isEmpty(charSequenceM6894m)) {
                textView4.setText(charSequenceM6894m);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public CharSequence m6894m() {
        return this.f6907h;
    }

    /* renamed from: o */
    public boolean m6895o() {
        return this.f6908i;
    }
}
