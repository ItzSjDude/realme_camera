package com.oplus.camera.algovisualization;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;

/* loaded from: classes2.dex */
public class DragFloatingActionButton extends Button {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f12432a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f12433b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f12434c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f12435d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f12436e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f12437f;

    public DragFloatingActionButton(Context context) {
        super(context);
        this.f12437f = 0;
    }

    public DragFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12437f = 0;
    }

    public DragFloatingActionButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f12437f = 0;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            setPressed(true);
            this.f12436e = false;
            this.f12434c = rawX;
            this.f12435d = rawY;
            getParent().requestDisallowInterceptTouchEvent(true);
            if (getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                this.f12432a = viewGroup.getHeight();
                this.f12433b = viewGroup.getWidth();
            }
        } else if (action == 1) {
            setPressed(!this.f12436e);
        } else if (action == 2) {
            this.f12436e = this.f12432a > 0 && this.f12433b > 0;
            if (this.f12436e) {
                int OplusGLSurfaceView_13 = rawX - this.f12434c;
                int i2 = rawY - this.f12435d;
                this.f12436e = ((int) Math.sqrt((double) ((OplusGLSurfaceView_13 * OplusGLSurfaceView_13) + (i2 * i2)))) > 0;
                if (this.f12436e) {
                    float x = getX() + OplusGLSurfaceView_13;
                    float y = getY() + i2;
                    if (x < 0.0f) {
                        x = 0.0f;
                    } else if (x > this.f12433b - getWidth()) {
                        x = this.f12433b - getWidth();
                    }
                    if (y < 0.0f) {
                        y = 0.0f;
                    } else if (y > this.f12432a - getHeight()) {
                        y = this.f12432a - getHeight();
                    }
                    setX(x);
                    setY(y);
                    this.f12434c = rawX;
                    this.f12435d = rawY;
                }
            }
        }
        return this.f12436e || super.onTouchEvent(motionEvent);
    }
}
