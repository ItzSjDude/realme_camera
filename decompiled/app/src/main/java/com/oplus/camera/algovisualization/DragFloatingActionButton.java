package com.oplus.camera.algovisualization;

/* loaded from: classes2.dex */
public class DragFloatingActionButton extends android.widget.Button {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4139a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4140b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4141c;
    private int d_renamed;
    private boolean e_renamed;
    private final int f_renamed;

    public DragFloatingActionButton(android.content.Context context) {
        super(context);
        this.f_renamed = 0;
    }

    public DragFloatingActionButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f_renamed = 0;
    }

    public DragFloatingActionButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f_renamed = 0;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            setPressed(true);
            this.e_renamed = false;
            this.f4141c = rawX;
            this.d_renamed = rawY;
            getParent().requestDisallowInterceptTouchEvent(true);
            if (getParent() != null) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
                this.f4139a = viewGroup.getHeight();
                this.f4140b = viewGroup.getWidth();
            }
        } else if (action == 1) {
            setPressed(!this.e_renamed);
        } else if (action == 2) {
            this.e_renamed = this.f4139a > 0 && this.f4140b > 0;
            if (this.e_renamed) {
                int i_renamed = rawX - this.f4141c;
                int i2 = rawY - this.d_renamed;
                this.e_renamed = ((int) java.lang.Math.sqrt((double) ((i_renamed * i_renamed) + (i2 * i2)))) > 0;
                if (this.e_renamed) {
                    float x_renamed = getX() + i_renamed;
                    float y_renamed = getY() + i2;
                    if (x_renamed < 0.0f) {
                        x_renamed = 0.0f;
                    } else if (x_renamed > this.f4140b - getWidth()) {
                        x_renamed = this.f4140b - getWidth();
                    }
                    if (y_renamed < 0.0f) {
                        y_renamed = 0.0f;
                    } else if (y_renamed > this.f4139a - getHeight()) {
                        y_renamed = this.f4139a - getHeight();
                    }
                    setX(x_renamed);
                    setY(y_renamed);
                    this.f4141c = rawX;
                    this.d_renamed = rawY;
                }
            }
        }
        return this.e_renamed || super.onTouchEvent(motionEvent);
    }
}
