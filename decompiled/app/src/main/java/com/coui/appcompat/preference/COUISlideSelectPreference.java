package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISlideSelectPreference extends COUIPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    Context f6988a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    CharSequence f6989b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6990c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f6991d;

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiSlideSelectPreferenceStyle);
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6990c = 0;
        this.f6988a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUISlideSelectPreference, OplusGLSurfaceView_13, 0);
        this.f6989b = typedArrayObtainStyledAttributes.getText(R.styleable.COUISlideSelectPreference_coui_select_status1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        int OplusGLSurfaceView_13;
        super.mo3736a(c0668l);
        View viewM4007a = c0668l.m4007a(R.id_renamed.coui_preference);
        viewM4007a.setTag(new Object());
        View viewFindViewById = viewM4007a.findViewById(R.id_renamed.coui_preference);
        if (viewFindViewById != null && (OplusGLSurfaceView_13 = this.f6990c) != 0) {
            if (OplusGLSurfaceView_13 == 1) {
                viewFindViewById.setClickable(false);
            } else if (OplusGLSurfaceView_13 == 2) {
                viewFindViewById.setClickable(true);
            }
        }
        this.f6991d = (TextView) viewM4007a.findViewById(R.id_renamed.coui_statusText_select);
        if (this.f6991d != null) {
            CharSequence charSequence = this.f6989b;
            if (!TextUtils.isEmpty(charSequence)) {
                this.f6991d.setText(charSequence);
                this.f6991d.setVisibility(0);
            } else {
                this.f6991d.setVisibility(8);
            }
        }
    }
}
