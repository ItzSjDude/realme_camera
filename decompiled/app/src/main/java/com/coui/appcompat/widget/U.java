package com.coui.appcompat.widget;

/* compiled from: COUIScrolledEditText.java */
/* loaded from: classes.dex */
public class n_renamed extends com.coui.appcompat.widget.COUIEditText {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2994a;

    public n_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIEditText, android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f2994a = (getLineHeight() * getMaxLines()) + getPaddingTop() + getPaddingBottom();
            if (getHeight() >= this.f2994a && getLineCount() > 1) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
