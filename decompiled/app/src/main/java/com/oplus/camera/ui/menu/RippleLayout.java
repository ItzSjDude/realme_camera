package com.oplus.camera.ui.menu;

/* loaded from: classes2.dex */
public class RippleLayout extends android.widget.FrameLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6329a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6330b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6331c;

    public RippleLayout(android.content.Context context) {
        super(context);
        this.f6329a = false;
        this.f6330b = 0;
        this.f6331c = 0;
        a_renamed();
    }

    public RippleLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6329a = false;
        this.f6330b = 0;
        this.f6331c = 0;
        a_renamed();
    }

    public RippleLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6329a = false;
        this.f6330b = 0;
        this.f6331c = 0;
        a_renamed();
    }

    private void a_renamed() {
        this.f6330b = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_setting_item_touch_width);
        this.f6331c = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_setting_item_touch_height);
    }

    public void setNeedForbidEvent(boolean z_renamed) {
        com.oplus.camera.e_renamed.f_renamed("RippleLayout", "setNeedForbidEvent, mbNeedForbidEvent: " + this.f6329a);
        this.f6329a = z_renamed;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.f6329a) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.f6329a) {
            int width = (getWidth() - this.f6330b) / 2;
            int height = (getHeight() - this.f6331c) / 2;
            android.graphics.Rect rect = new android.graphics.Rect();
            getDrawingRect(rect);
            rect.left += width;
            rect.top += height;
            rect.right -= width;
            rect.bottom -= height;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    return false;
                }
            } else if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
