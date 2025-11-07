package com.oplus.camera.ui.menu.facebeauty;

/* loaded from: classes2.dex */
public class TabContainerLayout extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6395a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6396b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6397c;
    private int d_renamed;
    private int e_renamed;
    private boolean f_renamed;
    private android.view.View g_renamed;

    public TabContainerLayout(android.content.Context context) {
        super(context);
        this.f6395a = -1;
        this.f6396b = 0;
        this.f6397c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = null;
        this.f6396b = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_text_view_extra_touch_width);
        this.f6397c = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_text_view_extra_touch_height);
    }

    public TabContainerLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6395a = -1;
        this.f6396b = 0;
        this.f6397c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = null;
        this.f6396b = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_text_view_extra_touch_width);
        this.f6397c = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_text_view_extra_touch_height);
    }

    public TabContainerLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6395a = -1;
        this.f6396b = 0;
        this.f6397c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = null;
        this.f6396b = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_text_view_extra_touch_width);
        this.f6397c = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_text_view_extra_touch_height);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.View childAt;
        android.view.View childAt2;
        android.view.View childAt3;
        android.view.View childAt4;
        int actionMasked = motionEvent.getActionMasked();
        if (this.g_renamed != null && (1 == actionMasked || 3 == actionMasked)) {
            android.view.View view = this.g_renamed;
            if (view instanceof android.view.ViewGroup) {
                ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.view.ViewGroup) view).getChildAt(0)).onTouchEvent(motionEvent);
            }
            this.g_renamed = null;
        }
        if (actionMasked == 0) {
            this.d_renamed = (int) motionEvent.getX();
            this.e_renamed = (int) motionEvent.getY();
            int iA = a_renamed(this.d_renamed, this.e_renamed);
            if (iA != -1 && (childAt = getChildAt(iA)) != null && (childAt instanceof android.view.ViewGroup)) {
                ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.view.ViewGroup) childAt).getChildAt(0)).onTouchEvent(motionEvent);
                childAt.setPressed(true);
                this.g_renamed = childAt;
            }
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                int x_renamed = (int) motionEvent.getX();
                int y_renamed = (int) motionEvent.getY();
                if (java.lang.Math.abs(x_renamed - this.d_renamed) > 10 || java.lang.Math.abs(y_renamed - this.e_renamed) > 10) {
                    this.f_renamed = true;
                    int iA2 = a_renamed(this.d_renamed, this.e_renamed);
                    if (iA2 != -1 && (childAt3 = getChildAt(iA2)) != null && (childAt3 instanceof android.view.ViewGroup)) {
                        ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.view.ViewGroup) childAt3).getChildAt(0)).onTouchEvent(motionEvent);
                        childAt3.setPressed(false);
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f_renamed) {
                    this.f_renamed = false;
                }
                int iA3 = a_renamed(this.d_renamed, this.e_renamed);
                if (iA3 != -1 && (childAt4 = getChildAt(iA3)) != null && (childAt4 instanceof android.view.ViewGroup)) {
                    ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.view.ViewGroup) childAt4).getChildAt(0)).onTouchEvent(motionEvent);
                    childAt4.setPressed(false);
                }
            } else if (actionMasked != 5) {
            }
        } else if (this.f_renamed) {
            this.f_renamed = false;
            int iA4 = a_renamed(this.d_renamed, this.e_renamed);
            if (iA4 != -1 && (childAt2 = getChildAt(iA4)) != null && (childAt2 instanceof android.view.ViewGroup)) {
                ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.view.ViewGroup) childAt2).getChildAt(0)).onTouchEvent(motionEvent);
                childAt2.setPressed(false);
            }
        } else if (!b_renamed((int) motionEvent.getX(), (int) motionEvent.getY())) {
            b_renamed(this.d_renamed, this.e_renamed);
        }
        return true;
    }

    private int a_renamed(int i_renamed, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            if (childAt != null) {
                android.graphics.Rect rect = new android.graphics.Rect();
                childAt.getHitRect(rect);
                rect.left -= this.f6396b;
                rect.top -= this.f6397c;
                rect.right += this.f6396b;
                rect.bottom += this.f6397c;
                if (rect.contains(i_renamed, i2)) {
                    return childCount;
                }
            }
        }
        return -1;
    }

    private boolean b_renamed(int i_renamed, int i2) {
        int iA = a_renamed(i_renamed, i2);
        if (iA == -1) {
            return false;
        }
        android.view.View childAt = getChildAt(iA);
        if (childAt != null) {
            setPressed(false);
            childAt.setPressed(true);
        }
        if (childAt instanceof android.view.ViewGroup) {
            ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.view.ViewGroup) childAt).getChildAt(0)).performClick();
        }
        return true;
    }
}
