package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.oplus.camera.p172ui.RotateImageView;

/* loaded from: classes2.dex */
public class InertialZoomButton extends RotateImageView {

    /* renamed from: OplusGLSurfaceView_6 */
    private InterfaceC3496a f22605m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f22606n;

    /* renamed from: com.oplus.camera.ui.widget.InertialZoomButton$PlatformImplementations.kt_3 */
    public interface InterfaceC3496a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11573a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11574b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11575c();
    }

    public InertialZoomButton(Context context) {
        super(context);
        this.f22605m = null;
        this.f22606n = false;
    }

    public InertialZoomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22605m = null;
        this.f22606n = false;
    }

    public InertialZoomButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22605m = null;
        this.f22606n = false;
    }

    public void setOnInertialZoomButtonListener(InterfaceC3496a interfaceC3496a) {
        this.f22605m = interfaceC3496a;
    }

    @Override // android.view.View
    public boolean performClick() {
        InterfaceC3496a interfaceC3496a = this.f22605m;
        if (interfaceC3496a != null) {
            interfaceC3496a.mo11573a();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        this.f22606n = true;
        InterfaceC3496a interfaceC3496a = this.f22605m;
        if (interfaceC3496a != null) {
            interfaceC3496a.mo11574b();
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.f22606n) {
            InterfaceC3496a interfaceC3496a = this.f22605m;
            if (interfaceC3496a != null) {
                interfaceC3496a.mo11575c();
            }
            this.f22606n = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23974a() {
        return this.f22606n;
    }
}
