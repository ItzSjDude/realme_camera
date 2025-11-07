package com.oplus.camera.p172ui.menu.facebeauty;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class TabContainerLayout extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f19193a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f19194b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f19195c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f19196d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19197e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f19198f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View f19199g;

    public TabContainerLayout(Context context) {
        super(context);
        this.f19193a = -1;
        this.f19194b = 0;
        this.f19195c = 0;
        this.f19196d = 0;
        this.f19197e = 0;
        this.f19198f = false;
        this.f19199g = null;
        this.f19194b = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_text_view_extra_touch_width);
        this.f19195c = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_text_view_extra_touch_height);
    }

    public TabContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19193a = -1;
        this.f19194b = 0;
        this.f19195c = 0;
        this.f19196d = 0;
        this.f19197e = 0;
        this.f19198f = false;
        this.f19199g = null;
        this.f19194b = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_text_view_extra_touch_width);
        this.f19195c = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_text_view_extra_touch_height);
    }

    public TabContainerLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19193a = -1;
        this.f19194b = 0;
        this.f19195c = 0;
        this.f19196d = 0;
        this.f19197e = 0;
        this.f19198f = false;
        this.f19199g = null;
        this.f19194b = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_text_view_extra_touch_width);
        this.f19195c = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_text_view_extra_touch_height);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        View childAt2;
        View childAt3;
        View childAt4;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f19199g != null && (1 == actionMasked || 3 == actionMasked)) {
            View view = this.f19199g;
            if (view instanceof ViewGroup) {
                ((TabContainerTextView) ((ViewGroup) view).getChildAt(0)).onTouchEvent(motionEvent);
            }
            this.f19199g = null;
        }
        if (actionMasked == 0) {
            this.f19196d = (int) motionEvent.getX();
            this.f19197e = (int) motionEvent.getY();
            int iM20511a = m20511a(this.f19196d, this.f19197e);
            if (iM20511a != -1 && (childAt = getChildAt(iM20511a)) != null && (childAt instanceof ViewGroup)) {
                ((TabContainerTextView) ((ViewGroup) childAt).getChildAt(0)).onTouchEvent(motionEvent);
                childAt.setPressed(true);
                this.f19199g = childAt;
            }
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (Math.abs(x - this.f19196d) > 10 || Math.abs(y - this.f19197e) > 10) {
                    this.f19198f = true;
                    int iM20511a2 = m20511a(this.f19196d, this.f19197e);
                    if (iM20511a2 != -1 && (childAt3 = getChildAt(iM20511a2)) != null && (childAt3 instanceof ViewGroup)) {
                        ((TabContainerTextView) ((ViewGroup) childAt3).getChildAt(0)).onTouchEvent(motionEvent);
                        childAt3.setPressed(false);
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f19198f) {
                    this.f19198f = false;
                }
                int iM20511a3 = m20511a(this.f19196d, this.f19197e);
                if (iM20511a3 != -1 && (childAt4 = getChildAt(iM20511a3)) != null && (childAt4 instanceof ViewGroup)) {
                    ((TabContainerTextView) ((ViewGroup) childAt4).getChildAt(0)).onTouchEvent(motionEvent);
                    childAt4.setPressed(false);
                }
            } else if (actionMasked != 5) {
            }
        } else if (this.f19198f) {
            this.f19198f = false;
            int iM20511a4 = m20511a(this.f19196d, this.f19197e);
            if (iM20511a4 != -1 && (childAt2 = getChildAt(iM20511a4)) != null && (childAt2 instanceof ViewGroup)) {
                ((TabContainerTextView) ((ViewGroup) childAt2).getChildAt(0)).onTouchEvent(motionEvent);
                childAt2.setPressed(false);
            }
        } else if (!m20512b((int) motionEvent.getX(), (int) motionEvent.getY())) {
            m20512b(this.f19196d, this.f19197e);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m20511a(int OplusGLSurfaceView_13, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                rect.left -= this.f19194b;
                rect.top -= this.f19195c;
                rect.right += this.f19194b;
                rect.bottom += this.f19195c;
                if (rect.contains(OplusGLSurfaceView_13, i2)) {
                    return childCount;
                }
            }
        }
        return -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20512b(int OplusGLSurfaceView_13, int i2) {
        int iM20511a = m20511a(OplusGLSurfaceView_13, i2);
        if (iM20511a == -1) {
            return false;
        }
        View childAt = getChildAt(iM20511a);
        if (childAt != null) {
            setPressed(false);
            childAt.setPressed(true);
        }
        if (childAt instanceof ViewGroup) {
            ((TabContainerTextView) ((ViewGroup) childAt).getChildAt(0)).performClick();
        }
        return true;
    }
}
