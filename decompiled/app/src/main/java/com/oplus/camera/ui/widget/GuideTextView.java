package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class GuideTextView extends androidx.appcompat.widget.AppCompatTextView {
    public GuideTextView(android.content.Context context) {
        this(context, null);
    }

    public GuideTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuideTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        a_renamed(getTextSize());
    }

    private void a_renamed(float f_renamed) {
        super.setTextSize(0, f_renamed * com.oplus.camera.MyApplication.d_renamed().getResources().getConfiguration().fontScale);
    }
}
