package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIChangeableDialogMessage extends androidx.appcompat.widget.AppCompatTextView {
    public COUIChangeableDialogMessage(android.content.Context context) {
        super(context);
    }

    public COUIChangeableDialogMessage(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUIChangeableDialogMessage(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        android.text.Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() > 1) {
                setTextAlignment(2);
            } else {
                setTextAlignment(4);
            }
            setText(getText());
        }
    }
}
