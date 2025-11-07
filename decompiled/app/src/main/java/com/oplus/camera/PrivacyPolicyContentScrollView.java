package com.oplus.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class PrivacyPolicyContentScrollView extends ScrollView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f11243a;

    public PrivacyPolicyContentScrollView(Context context) {
        super(context);
        this.f11243a = 0;
    }

    public PrivacyPolicyContentScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyPolicyContentScrollView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f11243a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PrivacyPolicyContentScrollView);
        this.f11243a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, getResources().getDimensionPixelSize(R.dimen.privacy_policy_text_max_height));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f11243a), View.MeasureSpec.getMode(i2)));
    }
}
