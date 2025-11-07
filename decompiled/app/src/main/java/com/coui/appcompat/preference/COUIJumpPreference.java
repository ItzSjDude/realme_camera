package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIJumpPreference extends COUIPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    Context f6920a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    CharSequence f6921b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    CharSequence f6922c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    CharSequence f6923d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    Drawable f6924e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6925f;

    public COUIJumpPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6925f = 0;
        this.f6920a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIJumpPreference, OplusGLSurfaceView_13, 0);
        this.f6924e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIJumpPreference_coui_jump_mark);
        this.f6921b = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status1);
        this.f6922c = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status2);
        this.f6923d = typedArrayObtainStyledAttributes.getText(R.styleable.COUIJumpPreference_coui_jump_status3);
        this.f6925f = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIJumpPreference_couiClickStyle, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public COUIJumpPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIJumpPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiJumpPreferenceStyle);
    }

    public COUIJumpPreference(Context context) {
        this(context, null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6900b(Drawable drawable) {
        if (this.f6924e != drawable) {
            this.f6924e = drawable;
            mo3748i();
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        int OplusGLSurfaceView_13;
        super.mo3736a(c0668l);
        ImageView imageView = (ImageView) c0668l.m4007a(R.id_renamed.coui_preference_widget_jump);
        if (imageView != null) {
            Drawable drawable = this.f6924e;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View viewM4007a = c0668l.m4007a(R.id_renamed.coui_preference);
        if (viewM4007a != null && (OplusGLSurfaceView_13 = this.f6925f) != 0) {
            if (OplusGLSurfaceView_13 == 1) {
                viewM4007a.setClickable(false);
            } else if (OplusGLSurfaceView_13 == 2) {
                viewM4007a.setClickable(true);
            }
        }
        TextView textView = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f6921b;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText2);
        if (textView2 != null) {
            CharSequence charSequence2 = this.f6922c;
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) c0668l.m4007a(R.id_renamed.coui_statusText3);
        if (textView3 != null) {
            CharSequence charSequence3 = this.f6923d;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
    }
}
