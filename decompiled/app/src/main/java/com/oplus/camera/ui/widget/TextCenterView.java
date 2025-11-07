package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class TextCenterView extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.AppCompatTextView f7240a;

    public TextCenterView(android.content.Context context) {
        super(context);
        a_renamed();
    }

    public TextCenterView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a_renamed();
    }

    public TextCenterView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        a_renamed();
    }

    private void a_renamed() {
        setClipChildren(false);
        androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        appCompatImageView.setId(com.oplus.camera.R_renamed.id_renamed.icon_image);
        appCompatImageView.setTranslationY(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.double_exposure_guide_title_icon_offset_y));
        layoutParams.addRule(16, com.oplus.camera.R_renamed.id_renamed.double_exposure_text);
        layoutParams.setMarginEnd(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.double_exposure_guide_title_left));
        appCompatImageView.setImageResource(com.oplus.camera.R_renamed.drawable.panel_guides_tipsicon);
        addView(appCompatImageView, layoutParams);
        this.f7240a = new androidx.appcompat.widget.AppCompatTextView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.f7240a.setText(getResources().getString(com.oplus.camera.R_renamed.string.camera_double_exposure_guide_hint));
        this.f7240a.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        this.f7240a.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.double_exposure_guide_title_text_size));
        this.f7240a.setTextColor(getResources().getColor(com.oplus.camera.R_renamed.color.double_exposure_guide_text_color, null));
        this.f7240a.setId(com.oplus.camera.R_renamed.id_renamed.double_exposure_text);
        this.f7240a.setEllipsize(android.text.TextUtils.TruncateAt.END);
        addView(this.f7240a, layoutParams2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int childCount = getChildCount();
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int measuredWidth = 0;
        android.widget.TextView textView = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            measureChild(childAt, i_renamed, i2);
            if (!(childAt instanceof android.widget.TextView)) {
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) childAt.getLayoutParams();
                measuredWidth = measuredWidth + childAt.getMeasuredWidth() + layoutParams.rightMargin + layoutParams.leftMargin;
            } else {
                textView = (android.widget.TextView) childAt;
            }
        }
        if (textView != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
            int i4 = size - measuredWidth;
            boolean z_renamed = textView.getMeasuredWidth() >= i4;
            if (!z_renamed) {
                i4 = -2;
            }
            layoutParams2.width = i4;
            layoutParams2.addRule(z_renamed ? 11 : 14);
            textView.setLayoutParams(layoutParams2);
        }
        super.onMeasure(i_renamed, i2);
    }

    public void setText(int i_renamed) {
        this.f7240a.setText(i_renamed);
    }
}
