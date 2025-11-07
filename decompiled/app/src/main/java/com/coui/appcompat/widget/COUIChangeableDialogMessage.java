package com.coui.appcompat.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public class COUIChangeableDialogMessage extends AppCompatTextView {
    public COUIChangeableDialogMessage(Context context) {
        super(context);
    }

    public COUIChangeableDialogMessage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUIChangeableDialogMessage(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        Layout layout = getLayout();
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
