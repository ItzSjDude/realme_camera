package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class InertialZoomButton extends com.oplus.camera.ui.RotateImageView {
    private com.oplus.camera.ui.widget.InertialZoomButton.a_renamed m_renamed;
    private boolean n_renamed;

    public interface a_renamed {
        void a_renamed();

        void b_renamed();

        void c_renamed();
    }

    public InertialZoomButton(android.content.Context context) {
        super(context);
        this.m_renamed = null;
        this.n_renamed = false;
    }

    public InertialZoomButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_renamed = null;
        this.n_renamed = false;
    }

    public InertialZoomButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.m_renamed = null;
        this.n_renamed = false;
    }

    public void setOnInertialZoomButtonListener(com.oplus.camera.ui.widget.InertialZoomButton.a_renamed aVar) {
        this.m_renamed = aVar;
    }

    @Override // android.view.View
    public boolean performClick() {
        com.oplus.camera.ui.widget.InertialZoomButton.a_renamed aVar = this.m_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        this.n_renamed = true;
        com.oplus.camera.ui.widget.InertialZoomButton.a_renamed aVar = this.m_renamed;
        if (aVar != null) {
            aVar.b_renamed();
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.n_renamed) {
            com.oplus.camera.ui.widget.InertialZoomButton.a_renamed aVar = this.m_renamed;
            if (aVar != null) {
                aVar.c_renamed();
            }
            this.n_renamed = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean a_renamed() {
        return this.n_renamed;
    }
}
