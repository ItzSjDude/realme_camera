package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class FixedListView extends android.widget.ListView {
    public FixedListView(android.content.Context context) {
        super(context);
    }

    public FixedListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedListView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    public FixedListView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action != 2) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }
}
