package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import com.oplus.camera.p146gl.GLES20Canvas;

/* compiled from: GLProducerRender2DHorizontal.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class GLProducerRender2DHorizontal extends GLProducerRender2D {
    public GLProducerRender2DHorizontal(Context context, int OplusGLSurfaceView_13, int i2) {
        super(context, OplusGLSurfaceView_13);
        this.f19831H = i2;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender2D
    /* renamed from: OplusGLSurfaceView_5 */
    protected void mo20977k() {
        MatrixState.m21008a();
        MatrixState.m21010a(180.0f, 1.0f, 0.0f, 0.0f);
        float COUIBaseListPopupWindow_12 = -1.0f;
        MatrixState.m21014b(this.f19805d.f19584n, this.f19799E ? -1.0f : 1.0f, 1.0f);
        if (1 == this.f19830G) {
            MatrixState.m21009a((this.f19807f / this.f19805d.f19574d) * 1.0f * 2.0f, 0.0f, 0.0f);
            MatrixState.m21010a(180.0f, 0.0f, 0.0f, 1.0f);
        } else if (this.f19831H == 0) {
            float fM20940s = (this.f19807f / this.f19805d.f19574d) * (-1.0f) * 2.0f;
            if (this.f19817p.m20936o()) {
                fM20940s = ((this.f19807f - this.f19817p.m20940s()) / this.f19805d.f19574d) * (-1.0f) * 2.0f;
            }
            MatrixState.m21009a(fM20940s, 0.0f, 0.0f);
            if (this.f19817p.m20935n()) {
                if (!this.f19817p.m20936o()) {
                    MatrixState.m21010a(180.0f, 0.0f, 1.0f, 0.0f);
                }
            } else if (!this.f19799E) {
                MatrixState.m21010a(180.0f, 0.0f, 0.0f, 1.0f);
            }
        } else {
            if (this.f19817p.m20935n()) {
                MatrixState.m21014b(-1.0f, 1.0f, 1.0f);
                COUIBaseListPopupWindow_12 = 1.0f;
            }
            float fM20940s2 = (this.f19807f / this.f19805d.f19573c) * COUIBaseListPopupWindow_12 * 2.0f;
            if (this.f19817p.m20936o()) {
                fM20940s2 = COUIBaseListPopupWindow_12 * ((this.f19807f - this.f19817p.m20940s()) / this.f19805d.f19573c) * 2.0f;
            }
            MatrixState.m21009a(fM20940s2, 0.0f, 0.0f);
            MatrixState.m21010a(this.f19831H, 0.0f, 0.0f, 1.0f);
        }
        GLES20Canvas.m14010i();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender2D
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int mo20975c(GLModelParam c3284i) {
        if (this.f19831H == 0) {
            return Math.round((c3284i.m20939r() + c3284i.m20940s()) * c3284i.m20896a().size());
        }
        return Math.round(c3284i.m20939r());
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender2D
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int mo20976d(GLModelParam c3284i) {
        if (this.f19831H == 0) {
            return Math.round(c3284i.m20938q());
        }
        return Math.round(Math.round((c3284i.m20938q() + c3284i.m20940s()) * c3284i.m20896a().size()));
    }
}
