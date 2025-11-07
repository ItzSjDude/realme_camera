package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class RippleLayout extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f18933a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18934b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18935c;

    public RippleLayout(Context context) {
        super(context);
        this.f18933a = false;
        this.f18934b = 0;
        this.f18935c = 0;
        m20303a();
    }

    public RippleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18933a = false;
        this.f18934b = 0;
        this.f18935c = 0;
        m20303a();
    }

    public RippleLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18933a = false;
        this.f18934b = 0;
        this.f18935c = 0;
        m20303a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20303a() {
        this.f18934b = getResources().getDimensionPixelSize(R.dimen.drawer_setting_item_touch_width);
        this.f18935c = getResources().getDimensionPixelSize(R.dimen.drawer_setting_item_touch_height);
    }

    public void setNeedForbidEvent(boolean z) {
        CameraLog.m12967f("RippleLayout", "setNeedForbidEvent, mbNeedForbidEvent: " + this.f18933a);
        this.f18933a = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f18933a) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f18933a) {
            int width = (getWidth() - this.f18934b) / 2;
            int height = (getHeight() - this.f18935c) / 2;
            Rect rect = new Rect();
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
