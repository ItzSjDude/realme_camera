package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class InverseImageView extends ImageView implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f18692a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18693b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f18694c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InverseListener f18695d;

    public InverseImageView(Context context) {
        super(context);
        this.f18692a = false;
        this.f18693b = 0;
        this.f18694c = false;
        this.f18695d = null;
        m20117a(context);
    }

    public InverseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18692a = false;
        this.f18693b = 0;
        this.f18694c = false;
        this.f18695d = null;
        m20117a(context);
    }

    public InverseImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18692a = false;
        this.f18693b = 0;
        this.f18694c = false;
        this.f18695d = null;
        m20117a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20117a(Context context) {
        InverseManager.INS.registerInverse(context, this);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f18692a && m20118a()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20118a() {
        int OplusGLSurfaceView_13;
        InverseListener interfaceC3226d = this.f18695d;
        boolean z = interfaceC3226d == null || interfaceC3226d.inverseAble();
        return this.f18694c ? z : (!z || (OplusGLSurfaceView_13 = this.f18693b) == 90 || OplusGLSurfaceView_13 == 270) ? false : true;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f18692a = z;
        refreshDrawableState();
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f18693b = OplusGLSurfaceView_13;
        refreshDrawableState();
    }

    public void setHorizontalInverseAble(boolean z) {
        this.f18694c = z;
    }

    public void setInverseListener(InverseListener interfaceC3226d) {
        this.f18695d = interfaceC3226d;
        postInvalidate();
    }
}
