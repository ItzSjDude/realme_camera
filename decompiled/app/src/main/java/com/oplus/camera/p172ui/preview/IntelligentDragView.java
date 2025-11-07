package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class IntelligentDragView extends ImageView implements FocusIndicator {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20818a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20819b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20820c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20821d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20822e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f20823f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Rect f20824g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InterfaceC3384a f20825h;

    /* renamed from: OplusGLSurfaceView_13 */
    private GestureDetector f20826i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final GestureDetector.OnGestureListener f20827j;

    /* renamed from: com.oplus.camera.ui.preview.IntelligentDragView$PlatformImplementations.kt_3 */
    interface InterfaceC3384a {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo22171a(MotionEvent motionEvent);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo22172b(MotionEvent motionEvent);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo22173c(MotionEvent motionEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22168a() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22169a(int OplusGLSurfaceView_13, boolean z) {
    }

    @Override // com.oplus.camera.p172ui.preview.FocusIndicator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22148a(boolean z, boolean z2) {
    }

    public IntelligentDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20818a = 0;
        this.f20819b = 0;
        this.f20820c = 0;
        this.f20821d = 0;
        this.f20822e = 0;
        this.f20823f = false;
        this.f20824g = new Rect();
        this.f20825h = null;
        this.f20826i = null;
        this.f20827j = new GestureDetector.OnGestureListener() { // from class: com.oplus.camera.ui.preview.IntelligentDragView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                IntelligentDragView.this.f20823f = false;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (IntelligentDragView.this.f20825h != null) {
                    return IntelligentDragView.this.f20825h.mo22171a(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
                if (!IntelligentDragView.this.isEnabled()) {
                    return false;
                }
                IntelligentDragView.this.f20823f = true;
                Rect rectM22163a = IntelligentDragView.this.m22163a(motionEvent2.getX() - motionEvent.getX(), motionEvent2.getY() - motionEvent.getY());
                IntelligentDragView.this.layout(rectM22163a.left, rectM22163a.top, rectM22163a.right, rectM22163a.bottom);
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (IntelligentDragView.this.f20825h != null) {
                    IntelligentDragView.this.f20825h.mo22173c(motionEvent);
                }
            }
        };
        this.f20818a = getResources().getDimensionPixelSize(R.dimen.video_intelligent_high_frame_dectect_width);
        this.f20819b = getResources().getDimensionPixelSize(R.dimen.video_intelligent_high_frame_dectect_height);
        this.f20826i = new GestureDetector(context, this.f20827j);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        View view = (View) getParent();
        this.f20820c = view.getWidth();
        this.f20821d = view.getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f20823f && 1 == motionEvent.getAction()) {
            this.f20823f = false;
            InterfaceC3384a interfaceC3384a = this.f20825h;
            if (interfaceC3384a != null) {
                interfaceC3384a.mo22172b(motionEvent);
            }
        }
        return this.f20826i.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public Rect m22163a(float COUIBaseListPopupWindow_12, float f2) {
        int left = (int) (getLeft() + COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = this.f20818a + left;
        int top = (int) (getTop() + f2);
        int i2 = this.f20819b + top;
        if (left < 0) {
            OplusGLSurfaceView_13 = this.f20818a + 0;
            left = 0;
        } else {
            int i3 = this.f20820c;
            if (OplusGLSurfaceView_13 > i3) {
                left = i3 - this.f20818a;
                OplusGLSurfaceView_13 = i3;
            }
        }
        if (top < 0) {
            i2 = this.f20819b + 0;
            top = 0;
        } else {
            int i4 = this.f20821d;
            int i5 = this.f20822e;
            if (i2 > i4 - i5) {
                i2 = i4 - i5;
                top = i2 - this.f20819b;
            }
        }
        this.f20824g.set(left, top, OplusGLSurfaceView_13, i2);
        return this.f20824g;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.6028f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20824g.isEmpty()) {
            return;
        }
        layout(this.f20824g.left, this.f20824g.top, this.f20824g.right, this.f20824g.bottom);
    }

    @Override // android.view.View
    public void layout(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (!this.f20824g.isEmpty()) {
            OplusGLSurfaceView_13 = this.f20824g.left;
            i2 = this.f20824g.top;
            i3 = this.f20824g.right;
            i4 = this.f20824g.bottom;
        }
        super.layout(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m22170b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22170b() {
        this.f20824g.set(0, 0, 0, 0);
    }

    public void setBottomRestrict(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("IntelligentDragView", "setBottomRestrict: " + OplusGLSurfaceView_13);
        this.f20822e = OplusGLSurfaceView_13;
    }

    public void setIntelligentGestureListener(InterfaceC3384a interfaceC3384a) {
        this.f20825h = interfaceC3384a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public RectF m22167a(Size size, int OplusGLSurfaceView_13) {
        View view = (View) getParent();
        float height = size.getHeight() / view.getWidth();
        float width = size.getWidth() / view.getHeight();
        int left = getLeft();
        int top = getTop();
        int width2 = getWidth();
        int height2 = getHeight();
        RectF rectF = new RectF();
        if (OplusGLSurfaceView_13 == 0) {
            rectF.left = (int) (left * height);
            rectF.top = (int) (top * width);
            rectF.right = (int) (rectF.left + (width2 * width));
            rectF.bottom = (int) (rectF.top + (height2 * height));
        } else if (90 == OplusGLSurfaceView_13) {
            rectF.left = (int) (top * height);
            rectF.top = (int) (((view.getWidth() - left) - width2) * width);
            rectF.right = (int) (rectF.left + (height2 * width));
            rectF.bottom = (int) (rectF.top + (width2 * height));
        } else if (180 == OplusGLSurfaceView_13) {
            rectF.left = (int) (((view.getWidth() - left) - width2) * height);
            rectF.top = (int) (((view.getHeight() - top) - height2) * width);
            rectF.right = (int) (rectF.left + (height2 * width));
            rectF.bottom = (int) (rectF.top + (width2 * height));
        } else if (270 == OplusGLSurfaceView_13) {
            rectF.left = (int) (((view.getHeight() - top) - height2) * height);
            rectF.top = (int) (left * height);
            rectF.right = (int) (rectF.left + (height2 * width));
            rectF.bottom = (int) (rectF.top + (width2 * height));
        }
        return rectF;
    }
}
