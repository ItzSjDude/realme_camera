package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class TextCenterView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private AppCompatTextView f22702a;

    public TextCenterView(Context context) {
        super(context);
        m24043a();
    }

    public TextCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24043a();
    }

    public TextCenterView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        m24043a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24043a() {
        setClipChildren(false);
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        appCompatImageView.setId(R.id_renamed.icon_image);
        appCompatImageView.setTranslationY(getResources().getDimensionPixelSize(R.dimen.double_exposure_guide_title_icon_offset_y));
        layoutParams.addRule(16, R.id_renamed.double_exposure_text);
        layoutParams.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.double_exposure_guide_title_left));
        appCompatImageView.setImageResource(R.drawable.panel_guides_tipsicon);
        addView(appCompatImageView, layoutParams);
        this.f22702a = new AppCompatTextView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.f22702a.setText(getResources().getString(R.string.camera_double_exposure_guide_hint));
        this.f22702a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f22702a.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.double_exposure_guide_title_text_size));
        this.f22702a.setTextColor(getResources().getColor(R.color.double_exposure_guide_text_color, null));
        this.f22702a.setId(R.id_renamed.double_exposure_text);
        this.f22702a.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.f22702a, layoutParams2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int measuredWidth = 0;
        TextView textView = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            measureChild(childAt, OplusGLSurfaceView_13, i2);
            if (!(childAt instanceof TextView)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                measuredWidth = measuredWidth + childAt.getMeasuredWidth() + layoutParams.rightMargin + layoutParams.leftMargin;
            } else {
                textView = (TextView) childAt;
            }
        }
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            int i4 = size - measuredWidth;
            boolean z = textView.getMeasuredWidth() >= i4;
            if (!z) {
                i4 = -2;
            }
            layoutParams2.width = i4;
            layoutParams2.addRule(z ? 11 : 14);
            textView.setLayoutParams(layoutParams2);
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    public void setText(int OplusGLSurfaceView_13) {
        this.f22702a.setText(OplusGLSurfaceView_13);
    }
}
