package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class InverseTextView extends TextView implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f18734a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18735b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f18736c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InverseListener f18737d;

    public InverseTextView(Context context) {
        super(context);
        this.f18734a = false;
        this.f18735b = 0;
        this.f18736c = false;
        this.f18737d = null;
        m20146a(context);
    }

    public InverseTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18734a = false;
        this.f18735b = 0;
        this.f18736c = false;
        this.f18737d = null;
        m20146a(context);
    }

    public InverseTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18734a = false;
        this.f18735b = 0;
        this.f18736c = false;
        this.f18737d = null;
        m20146a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20146a(Context context) {
        InverseManager.INS.registerInverse(context, this);
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f18734a && m20147b()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20147b() {
        int OplusGLSurfaceView_13;
        InverseListener interfaceC3226d = this.f18737d;
        boolean z = interfaceC3226d == null || interfaceC3226d.inverseAble();
        return this.f18736c ? z : (!z || (OplusGLSurfaceView_13 = this.f18735b) == 90 || OplusGLSurfaceView_13 == 270) ? false : true;
    }

    public void setInverseColor(boolean z) {
        this.f18734a = z;
        refreshDrawableState();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20148a() {
        return this.f18734a;
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f18735b = OplusGLSurfaceView_13;
        refreshDrawableState();
    }

    public void setHorizontalInverseAble(boolean z) {
        this.f18736c = z;
    }

    public void setInverseListener(InverseListener interfaceC3226d) {
        this.f18737d = interfaceC3226d;
        postInvalidate();
    }
}
