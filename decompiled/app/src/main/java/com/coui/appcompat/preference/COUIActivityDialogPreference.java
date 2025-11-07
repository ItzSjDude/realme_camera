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
public class COUIActivityDialogPreference extends ListPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    Context f6887a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    CharSequence f6888b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    CharSequence f6889c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    CharSequence f6890d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    Drawable f6891e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f6892f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CharSequence f6893g;

    public COUIActivityDialogPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet);
        this.f6892f = true;
        this.f6887a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIJumpPreference, OplusGLSurfaceView_13, 0);
        this.f6891e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIJumpPreference_coui_jump_mark);
        this.f6888b = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status1);
        this.f6889c = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status2);
        this.f6890d = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status3);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, 0);
        this.f6892f = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f6892f);
        this.f6893g = typedArrayObtainStyledAttributes2.getText(R.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public COUIActivityDialogPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIActivityDialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiActivityDialogPreferenceStyle);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        ImageView imageView = (ImageView) c0668l.m4007a(R.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            Drawable drawable = this.f6891e;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        TextView textView = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f6888b;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText2);
        if (textView2 != null) {
            CharSequence charSequence2 = this.f6889c;
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText3);
        if (textView3 != null) {
            CharSequence charSequence3 = this.f6890d;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView4 != null) {
            CharSequence charSequenceM6889h = m6889h();
            if (!TextUtils.isEmpty(charSequenceM6889h)) {
                textView4.setText(charSequenceM6889h);
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public CharSequence m6889h() {
        return this.f6893g;
    }
}
