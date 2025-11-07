package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class MyNestedScrollView extends androidx.core.widget.NestedScrollView {
    public MyNestedScrollView(android.content.Context context) {
        this(context, null);
    }

    public MyNestedScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyNestedScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
