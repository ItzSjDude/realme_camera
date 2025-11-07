package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.opengl.GLES20;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.R;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: FilterMenuCanvas2D.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
class FilterMenuCanvas2D extends BaseFilterMenuCanvas {

    /* renamed from: H */
    private int f19741H;

    /* renamed from: I */
    private int f19742I;

    /* renamed from: J */
    private int f19743J;

    /* renamed from: K */
    private int f19744K;

    /* renamed from: L */
    private int f19745L;

    /* renamed from: M */
    private int f19746M;

    /* renamed from: N */
    private int f19747N;

    /* renamed from: O */
    private int f19748O;

    /* renamed from: P */
    private int f19749P;

    /* renamed from: Q */
    private int f19750Q;

    /* renamed from: R */
    private int f19751R;

    /* renamed from: S */
    private int f19752S;

    /* renamed from: T */
    private int f19753T;

    /* renamed from: U */
    private int f19754U;

    /* renamed from: V */
    private int f19755V;

    /* renamed from: W */
    private int f19756W;

    /* renamed from: X */
    private int f19757X;

    /* renamed from: Y */
    private int f19758Y;

    /* renamed from: Z */
    private float f19759Z;

    /* renamed from: w */
    private String f19760w = null;

    /* renamed from: x */
    private String f19761x = null;

    /* renamed from: y */
    private String f19762y = null;

    /* renamed from: z */
    private int f19763z = 0;

    /* renamed from: A */
    private int f19734A = 0;

    /* renamed from: B */
    private int f19735B = 0;

    /* renamed from: C */
    private int f19736C = 0;

    /* renamed from: D */
    private int f19737D = 0;

    /* renamed from: E */
    private int f19738E = 0;

    /* renamed from: F */
    private int f19739F = 0;

    /* renamed from: G */
    private int f19740G = 0;

    public FilterMenuCanvas2D(Context context, int OplusGLSurfaceView_13) {
        this.f19741H = OplusGLSurfaceView_13;
        m20892c(context);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20892c(Context context) {
        mo20797b(context);
        int OplusGLSurfaceView_13 = this.f19741H;
        this.f19747N = (1 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13) ? 1 : 0;
        this.f19748O = 1 == this.f19741H ? 1 : 0;
        this.f19759Z = Util.m24456h(R.dimen.effects_menu_fade_range);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20790a(GLModelParam c3284i) {
        this.f19579i.add(6);
        float[] fArr = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        float[] fArr2 = {1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        this.f19580j.add(floatBufferAsFloatBuffer);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(fArr2.length * 4);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2);
        floatBufferAsFloatBuffer2.position(0);
        this.f19581k.add(floatBufferAsFloatBuffer2);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo20797b(Context context) {
        this.f19760w = OpenGLUtils.m24591a("filter_menu.vert", context.getResources());
        this.f19761x = OpenGLUtils.m24591a("filter_menu.frag", context.getResources());
        this.f19763z = OpenGLUtils.m24596b(this.f19760w, this.f19761x);
        this.f19735B = GLES20.glGetAttribLocation(this.f19763z, "aPosition");
        this.f19736C = GLES20.glGetAttribLocation(this.f19763z, "aTexCoor");
        this.f19734A = GLES20.glGetUniformLocation(this.f19763z, "uMVPMatrix");
        this.f19742I = GLES20.glGetUniformLocation(this.f19763z, "fadeOn");
        this.f19743J = GLES20.glGetUniformLocation(this.f19763z, "isVertical");
        this.f19744K = GLES20.glGetUniformLocation(this.f19763z, "height");
        this.f19745L = GLES20.glGetUniformLocation(this.f19763z, "width");
        this.f19746M = GLES20.glGetUniformLocation(this.f19763z, "fadeRange");
        this.f19749P = GLES20.glGetUniformLocation(this.f19763z, "sTexture");
        this.f19750Q = GLES20.glGetUniformLocation(this.f19763z, "sFilterName");
        this.f19751R = GLES20.glGetUniformLocation(this.f19763z, "hasFilterName");
        this.f19752S = GLES20.glGetUniformLocation(this.f19763z, "uSurfaceSize");
        this.f19753T = GLES20.glGetUniformLocation(this.f19763z, "uRingRadius");
        this.f19754U = GLES20.glGetUniformLocation(this.f19763z, "uRingThickness");
        this.f19755V = GLES20.glGetUniformLocation(this.f19763z, "uRingOffsetCenterY");
        this.f19756W = GLES20.glGetUniformLocation(this.f19763z, "uRingOffsetCenterX");
        this.f19757X = GLES20.glGetUniformLocation(this.f19763z, "uDrawRing");
        this.f19758Y = GLES20.glGetUniformLocation(this.f19763z, "uRingTintColor");
        this.f19762y = OpenGLUtils.m24591a("frag_oes_tex.sh", context.getResources());
        this.f19737D = OpenGLUtils.m24596b(this.f19760w, this.f19762y);
        this.f19738E = GLES20.glGetAttribLocation(this.f19737D, "aPosition");
        this.f19740G = GLES20.glGetAttribLocation(this.f19737D, "aTexCoor");
        this.f19739F = GLES20.glGetUniformLocation(this.f19737D, "uMVPMatrix");
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo20802e(int OplusGLSurfaceView_13, int i2) {
        GLES20.glViewport(0, 0, this.f19571a, this.f19572b);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 0);
        GLES20.glUseProgram(this.f19763z);
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        GLES20.glUniformMatrix4fv(this.f19734A, 1, false, MatrixState.m21018e(), 0);
        GLES20.glUniform1i(this.f19742I, this.f19747N);
        GLES20.glUniform1f(this.f19745L, this.f19571a);
        GLES20.glUniform1f(this.f19744K, this.f19572b);
        GLES20.glUniform1i(this.f19743J, this.f19748O);
        GLES20.glUniform1f(this.f19746M, this.f19759Z);
        GLES20.glUniform1i(this.f19749P, 0);
        GLES20.glUniform1i(this.f19750Q, 1);
        GLES20.glUniform1i(this.f19751R, 1);
        GLES20.glUniform1i(this.f19757X, 0);
        GLES20.glVertexAttribPointer(this.f19735B, 3, 5126, false, 12, (Buffer) this.f19580j.get(i2));
        GLES20.glVertexAttribPointer(this.f19736C, 2, 5126, false, 8, (Buffer) this.f19581k.get(i2));
        GLES20.glEnableVertexAttribArray(this.f19735B);
        GLES20.glEnableVertexAttribArray(this.f19736C);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f19586p);
        GLES20.glDrawArrays(4, 0, this.f19579i.get(i2).intValue());
        m20893f();
        GLES20.glDisableVertexAttribArray(this.f19735B);
        GLES20.glDisableVertexAttribArray(this.f19736C);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20893f() {
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        MatrixState.m21008a();
        MatrixState.m21009a(this.f19577g, this.f19578h, 1.0f);
        MatrixState.m21014b(this.f19575e, this.f19576f, 1.0f);
        GLES20.glUniformMatrix4fv(this.f19734A, 1, false, MatrixState.m21018e(), 0);
        GLES20.glUniform1i(this.f19742I, 0);
        GLES20.glUniform1i(this.f19751R, 0);
        GLES20.glUniform1i(this.f19757X, 1);
        GLES20.glUniform1f(this.f19753T, this.f19588r);
        GLES20.glUniform1f(this.f19754U, this.f19589s);
        GLES20.glUniform1f(this.f19756W, this.f19590t);
        GLES20.glUniform1f(this.f19755V, this.f19591u);
        GLES20.glUniform2fv(this.f19752S, 1, this.f19587q, 0);
        GLES20.glUniform4fv(this.f19758Y, 1, this.f19592v, 0);
        GLES20.glDrawArrays(4, 0, this.f19579i.get(0).intValue());
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo20804f(int OplusGLSurfaceView_13, int i2) {
        MatrixState.m21013b();
        GLES20.glUseProgram(this.f19737D);
        GLES20.glUniformMatrix4fv(this.f19739F, 1, false, MatrixState.m21017d(), 0);
        GLES20.glVertexAttribPointer(this.f19738E, 3, 5126, false, 12, (Buffer) this.f19580j.get(0));
        GLES20.glVertexAttribPointer(this.f19740G, 2, 5126, false, 8, (Buffer) this.f19581k.get(0));
        GLES20.glEnableVertexAttribArray(this.f19738E);
        GLES20.glEnableVertexAttribArray(this.f19740G);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, OplusGLSurfaceView_13);
        GLES20.glDrawArrays(4, 0, this.f19579i.get(0).intValue());
        GLES20.glDisableVertexAttribArray(this.f19738E);
        GLES20.glDisableVertexAttribArray(this.f19740G);
        MatrixState.m21015c();
    }
}
