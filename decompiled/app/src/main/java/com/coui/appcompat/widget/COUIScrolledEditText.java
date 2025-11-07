package com.coui.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* compiled from: COUIScrolledEditText.java */
/* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class COUIScrolledEditText extends COUIEditText {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f8367a;

    public COUIScrolledEditText(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIEditText, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f8367a = (getLineHeight() * getMaxLines()) + getPaddingTop() + getPaddingBottom();
            if (getHeight() >= this.f8367a && getLineCount() > 1) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
