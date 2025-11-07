package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class IntelligentDragView extends android.widget.ImageView implements com.oplus.camera.ui.preview.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6795a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6796b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6797c;
    private int d_renamed;
    private int e_renamed;
    private boolean f_renamed;
    private android.graphics.Rect g_renamed;
    private com.oplus.camera.ui.preview.IntelligentDragView.a_renamed h_renamed;
    private android.view.GestureDetector i_renamed;
    private final android.view.GestureDetector.OnGestureListener j_renamed;

    interface a_renamed {
        boolean a_renamed(android.view.MotionEvent motionEvent);

        void b_renamed(android.view.MotionEvent motionEvent);

        void c_renamed(android.view.MotionEvent motionEvent);
    }

    public void a_renamed() {
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
    }

    @Override // com.oplus.camera.ui.preview.m_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
    }

    public IntelligentDragView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6795a = 0;
        this.f6796b = 0;
        this.f6797c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = new android.graphics.Rect();
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = new android.view.GestureDetector.OnGestureListener() { // from class: com.oplus.camera.ui.preview.IntelligentDragView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(android.view.MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(android.view.MotionEvent motionEvent) {
                com.oplus.camera.ui.preview.IntelligentDragView.this.f_renamed = false;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
                if (com.oplus.camera.ui.preview.IntelligentDragView.this.h_renamed != null) {
                    return com.oplus.camera.ui.preview.IntelligentDragView.this.h_renamed.a_renamed(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
                if (!com.oplus.camera.ui.preview.IntelligentDragView.this.isEnabled()) {
                    return false;
                }
                com.oplus.camera.ui.preview.IntelligentDragView.this.f_renamed = true;
                android.graphics.Rect rectA = com.oplus.camera.ui.preview.IntelligentDragView.this.a_renamed(motionEvent2.getX() - motionEvent.getX(), motionEvent2.getY() - motionEvent.getY());
                com.oplus.camera.ui.preview.IntelligentDragView.this.layout(rectA.left, rectA.top, rectA.right, rectA.bottom);
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(android.view.MotionEvent motionEvent) {
                if (com.oplus.camera.ui.preview.IntelligentDragView.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.IntelligentDragView.this.h_renamed.c_renamed(motionEvent);
                }
            }
        };
        this.f6795a = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_intelligent_high_frame_dectect_width);
        this.f6796b = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_intelligent_high_frame_dectect_height);
        this.i_renamed = new android.view.GestureDetector(context, this.j_renamed);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        android.view.View view = (android.view.View) getParent();
        this.f6797c = view.getWidth();
        this.d_renamed = view.getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.f_renamed && 1 == motionEvent.getAction()) {
            this.f_renamed = false;
            com.oplus.camera.ui.preview.IntelligentDragView.a_renamed aVar = this.h_renamed;
            if (aVar != null) {
                aVar.b_renamed(motionEvent);
            }
        }
        return this.i_renamed.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Rect a_renamed(float f_renamed, float f2) {
        int left = (int) (getLeft() + f_renamed);
        int i_renamed = this.f6795a + left;
        int top = (int) (getTop() + f2);
        int i2 = this.f6796b + top;
        if (left < 0) {
            i_renamed = this.f6795a + 0;
            left = 0;
        } else {
            int i3 = this.f6797c;
            if (i_renamed > i3) {
                left = i3 - this.f6795a;
                i_renamed = i3;
            }
        }
        if (top < 0) {
            i2 = this.f6796b + 0;
            top = 0;
        } else {
            int i4 = this.d_renamed;
            int i5 = this.e_renamed;
            if (i2 > i4 - i5) {
                i2 = i4 - i5;
                top = i2 - this.f6796b;
            }
        }
        this.g_renamed.set(left, top, i_renamed, i2);
        return this.g_renamed;
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        setAlpha(z_renamed ? 1.0f : 0.6028f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g_renamed.isEmpty()) {
            return;
        }
        layout(this.g_renamed.left, this.g_renamed.top, this.g_renamed.right, this.g_renamed.bottom);
    }

    @Override // android.view.View
    public void layout(int i_renamed, int i2, int i3, int i4) {
        if (!this.g_renamed.isEmpty()) {
            i_renamed = this.g_renamed.left;
            i2 = this.g_renamed.top;
            i3 = this.g_renamed.right;
            i4 = this.g_renamed.bottom;
        }
        super.layout(i_renamed, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b_renamed();
    }

    public void b_renamed() {
        this.g_renamed.set(0, 0, 0, 0);
    }

    public void setBottomRestrict(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("IntelligentDragView", "setBottomRestrict: " + i_renamed);
        this.e_renamed = i_renamed;
    }

    public void setIntelligentGestureListener(com.oplus.camera.ui.preview.IntelligentDragView.a_renamed aVar) {
        this.h_renamed = aVar;
    }

    public android.graphics.RectF a_renamed(android.util.Size size, int i_renamed) {
        android.view.View view = (android.view.View) getParent();
        float height = size.getHeight() / view.getWidth();
        float width = size.getWidth() / view.getHeight();
        int left = getLeft();
        int top = getTop();
        int width2 = getWidth();
        int height2 = getHeight();
        android.graphics.RectF rectF = new android.graphics.RectF();
        if (i_renamed == 0) {
            rectF.left = (int) (left * height);
            rectF.top = (int) (top * width);
            rectF.right = (int) (rectF.left + (width2 * width));
            rectF.bottom = (int) (rectF.top + (height2 * height));
        } else if (90 == i_renamed) {
            rectF.left = (int) (top * height);
            rectF.top = (int) (((view.getWidth() - left) - width2) * width);
            rectF.right = (int) (rectF.left + (height2 * width));
            rectF.bottom = (int) (rectF.top + (width2 * height));
        } else if (180 == i_renamed) {
            rectF.left = (int) (((view.getWidth() - left) - width2) * height);
            rectF.top = (int) (((view.getHeight() - top) - height2) * width);
            rectF.right = (int) (rectF.left + (height2 * width));
            rectF.bottom = (int) (rectF.top + (width2 * height));
        } else if (270 == i_renamed) {
            rectF.left = (int) (((view.getHeight() - top) - height2) * height);
            rectF.top = (int) (left * height);
            rectF.right = (int) (rectF.left + (height2 * width));
            rectF.bottom = (int) (rectF.top + (width2 * height));
        }
        return rectF;
    }
}
