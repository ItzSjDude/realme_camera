package com.google.android.material.dialog;

/* loaded from: classes.dex */
public class InsetDialogOnTouchListener implements android.view.View.OnTouchListener {
    private final android.app.Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(android.app.Dialog dialog, android.graphics.Rect rect) {
        this.dialog = dialog;
        this.leftInset = rect.left;
        this.topInset = rect.top;
        this.prePieSlop = android.view.ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        android.view.View viewFindViewById = view.findViewById(android.R_renamed.id_renamed.content);
        int left = this.leftInset + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new android.graphics.RectF(left, this.topInset + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (android.os.Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i_renamed = this.prePieSlop;
            motionEventObtain.setLocation((-i_renamed) - 1, (-i_renamed) - 1);
        }
        view.performClick();
        return this.dialog.onTouchEvent(motionEventObtain);
    }
}
