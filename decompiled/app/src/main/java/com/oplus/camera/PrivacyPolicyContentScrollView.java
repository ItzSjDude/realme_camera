package com.oplus.camera;

/* loaded from: classes2.dex */
public class PrivacyPolicyContentScrollView extends android.widget.ScrollView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4063a;

    public PrivacyPolicyContentScrollView(android.content.Context context) {
        super(context);
        this.f4063a = 0;
    }

    public PrivacyPolicyContentScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyPolicyContentScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f4063a = 0;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.PrivacyPolicyContentScrollView);
        this.f4063a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.privacy_policy_text_max_height));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(android.view.View.MeasureSpec.getSize(i2), this.f4063a), android.view.View.MeasureSpec.getMode(i2)));
    }
}
