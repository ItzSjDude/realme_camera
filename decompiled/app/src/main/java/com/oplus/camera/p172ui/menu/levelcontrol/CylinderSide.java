package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.opengl.GLES20;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: CylinderSide.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class CylinderSide extends BaseFilterMenuCanvas {

    /* renamed from: w */
    private int f19698w = 0;

    /* renamed from: x */
    private int f19699x = 0;

    /* renamed from: y */
    private int f19700y = 0;

    /* renamed from: z */
    private int f19701z = 0;

    /* renamed from: A */
    private int f19680A = 0;

    /* renamed from: B */
    private int f19681B = 0;

    /* renamed from: C */
    private int f19682C = 0;

    /* renamed from: D */
    private String f19683D = null;

    /* renamed from: E */
    private String f19684E = null;

    /* renamed from: F */
    private int f19685F = 0;

    /* renamed from: G */
    private int f19686G = 0;

    /* renamed from: H */
    private int f19687H = 0;

    /* renamed from: I */
    private int f19688I = 0;

    /* renamed from: J */
    private int f19689J = 0;

    /* renamed from: K */
    private int f19690K = 0;

    /* renamed from: L */
    private int f19691L = 0;

    /* renamed from: M */
    private String f19692M = null;

    /* renamed from: N */
    private String f19693N = null;

    /* renamed from: O */
    private int f19694O = 0;

    /* renamed from: P */
    private FloatBuffer f19695P = null;

    /* renamed from: Q */
    private FloatBuffer f19696Q = null;

    /* renamed from: R */
    private int[] f19697R = new int[1];

    /* renamed from: PlatformImplementations.kt_3 */
    private float m20846a(double IntrinsicsJvm.kt_5, double d2, double d3, boolean z) {
        return (float) (z ? ((IntrinsicsJvm.kt_5 - d2) / 2.0d) + d3 : ((IntrinsicsJvm.kt_5 + d2) / 2.0d) - d3);
    }

    public CylinderSide(Context context) {
        mo20797b(context);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20785a(float COUIBaseListPopupWindow_12, float f2, float f3, int OplusGLSurfaceView_13, float f4, float f5, boolean z, GLModelParam c3284i) {
        float[] fArr;
        CylinderSide c3281f = this;
        int iCeil = (int) Math.ceil(OplusGLSurfaceView_13 * 3 * 2 * (f5 / 360.0f));
        boolean zM20934m = c3284i.m20934m();
        boolean zM20935n = c3284i.m20935n();
        boolean zM20943v = c3284i.m20943v();
        int iM20929h = c3284i.m20929h();
        int iM20930i = c3284i.m20930i();
        float f6 = COUIBaseListPopupWindow_12 * f2;
        float f7 = COUIBaseListPopupWindow_12 * f3;
        int i2 = iCeil * 3;
        float[] fArr2 = new float[i2];
        float[] fArr3 = new float[iCeil * 2];
        float f8 = 360.0f / OplusGLSurfaceView_13;
        double dM20990c = MathUtil.m20990c();
        double IntrinsicsJvm.kt_5 = z ? -1.0d : 0.0d;
        float f9 = f4;
        double dM20845a = IntrinsicsJvm.kt_5;
        double d2 = IntrinsicsJvm.kt_5;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            float f10 = f4 + f5;
            if (f9 >= f10 || i3 + 18 >= i2) {
                break;
            }
            double d3 = dM20990c;
            double radians = Math.toRadians(f9);
            if (i3 + 36 < i2) {
                f10 = f9 + f8;
            }
            double radians2 = Math.toRadians(f10 % 360.0f);
            if (z) {
                if (-1.0d == d2) {
                    dM20845a = c3281f.m20845a((f9 - f4) / f5);
                }
                d2 = dM20845a;
                dM20845a = c3281f.m20845a(((f9 + f8) - f4) / f5);
            }
            int i5 = i3 + 1;
            double d4 = f6;
            int i6 = i2;
            float f11 = f6;
            fArr2[i3] = (float) (d4 * Math.sin(radians));
            int i7 = i5 + 1;
            double d5 = f7;
            float[] fArr4 = fArr2;
            float[] fArr5 = fArr3;
            float f12 = f7;
            fArr4[i5] = m20846a(d5, d3, d2, true);
            int i8 = i7 + 1;
            fArr4[i7] = (float) (d4 * Math.cos(radians));
            int i9 = i4 + 1;
            float f13 = (f9 - f4) / f5;
            fArr5[i4] = f13;
            int i10 = i9 + 1;
            int i11 = iCeil;
            fArr5[i9] = m20846a(1.0d, 1.0d, d2, false);
            if (zM20943v) {
                fArr = fArr5;
                m20849a(fArr5, i10 - 1, zM20934m, zM20935n, z, iM20929h, iM20930i);
            } else {
                fArr = fArr5;
            }
            int i12 = i8 + 1;
            fArr4[i8] = (float) (d4 * Math.sin(radians2));
            int i13 = i12 + 1;
            double d6 = dM20845a;
            fArr4[i12] = m20846a(d5, d3, d6, false);
            int i14 = i13 + 1;
            fArr4[i13] = (float) (d4 * Math.cos(radians2));
            int i15 = i10 + 1;
            f9 += f8;
            float f14 = (f9 - f4) / f5;
            fArr[i10] = f14;
            int i16 = i15 + 1;
            fArr[i15] = m20846a(1.0d, 1.0d, d6, true);
            if (zM20943v) {
                m20849a(fArr, i16 - 1, zM20934m, zM20935n, z, iM20929h, iM20930i);
            }
            int i17 = i14 + 1;
            fArr4[i14] = (float) (d4 * Math.sin(radians));
            int i18 = i17 + 1;
            double d7 = d2;
            fArr4[i17] = m20846a(d5, d3, d7, false);
            int i19 = i18 + 1;
            fArr4[i18] = (float) (d4 * Math.cos(radians));
            int i20 = i16 + 1;
            fArr[i16] = f13;
            int i21 = i20 + 1;
            fArr[i20] = m20846a(1.0d, 1.0d, d7, true);
            if (zM20943v) {
                m20849a(fArr, i21 - 1, zM20934m, zM20935n, z, iM20929h, iM20930i);
            }
            int i22 = i19 + 1;
            fArr4[i19] = (float) (d4 * Math.sin(radians));
            int i23 = i22 + 1;
            double d8 = d2;
            fArr4[i22] = m20846a(d5, d3, d8, true);
            int i24 = i23 + 1;
            fArr4[i23] = (float) (d4 * Math.cos(radians));
            int i25 = i21 + 1;
            fArr[i21] = f13;
            int i26 = i25 + 1;
            fArr[i25] = m20846a(1.0d, 1.0d, d8, false);
            if (zM20943v) {
                m20849a(fArr, i26 - 1, zM20934m, zM20935n, z, iM20929h, iM20930i);
            }
            int i27 = i24 + 1;
            fArr4[i24] = (float) (d4 * Math.sin(radians2));
            int i28 = i27 + 1;
            double d9 = dM20845a;
            fArr4[i27] = m20846a(d5, d3, d9, true);
            int i29 = i28 + 1;
            fArr4[i28] = (float) (d4 * Math.cos(radians2));
            int i30 = i26 + 1;
            fArr[i26] = f14;
            int i31 = i30 + 1;
            fArr[i30] = m20846a(1.0d, 1.0d, d9, false);
            if (zM20943v) {
                m20849a(fArr, i31 - 1, zM20934m, zM20935n, z, iM20929h, iM20930i);
            }
            int i32 = i29 + 1;
            fArr4[i29] = (float) (d4 * Math.sin(radians2));
            int i33 = i32 + 1;
            double d10 = dM20845a;
            fArr4[i32] = m20846a(d5, d3, d10, false);
            i3 = i33 + 1;
            fArr4[i33] = (float) (d4 * Math.cos(radians2));
            int i34 = i31 + 1;
            fArr[i31] = f14;
            i4 = i34 + 1;
            fArr[i34] = m20846a(1.0d, 1.0d, d10, true);
            if (zM20943v) {
                m20849a(fArr, i4 - 1, zM20934m, zM20935n, z, iM20929h, iM20930i);
            }
            fArr3 = fArr;
            fArr2 = fArr4;
            f7 = f12;
            i2 = i6;
            dM20990c = d3;
            iCeil = i11;
            f6 = f11;
            c3281f = this;
        }
        float[] fArr6 = fArr3;
        int i35 = iCeil;
        float[] fArr7 = fArr2;
        float[] fArr8 = new float[fArr7.length];
        for (int i36 = 0; i36 < fArr7.length; i36++) {
            if (i36 % 3 == 1) {
                fArr8[i36] = 0.0f;
            } else {
                fArr8[i36] = fArr7[i36];
            }
        }
        this.f19579i.add(Integer.valueOf(i35));
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr7.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr7);
        floatBufferAsFloatBuffer.position(0);
        this.f19580j.add(floatBufferAsFloatBuffer);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(fArr7.length * 4);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr8);
        floatBufferAsFloatBuffer2.position(0);
        this.f19582l.add(floatBufferAsFloatBuffer2);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(fArr6.length * 4);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        floatBufferAsFloatBuffer3.put(fArr6);
        floatBufferAsFloatBuffer3.position(0);
        this.f19581k.add(floatBufferAsFloatBuffer3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private double m20845a(double IntrinsicsJvm.kt_5) {
        if (0.0d <= IntrinsicsJvm.kt_5) {
            double d2 = 0.5f;
            if (d2 >= IntrinsicsJvm.kt_5) {
                double d3 = d2 - IntrinsicsJvm.kt_5;
                return d2 - Math.sqrt(0.25f - (d3 * d3));
            }
        }
        if (0.5f > IntrinsicsJvm.kt_5) {
            return 0.0d;
        }
        double d4 = 0.5f;
        double d5 = d4 - (1.0d - IntrinsicsJvm.kt_5);
        return d4 - Math.sqrt(0.25f - (d5 * d5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20849a(float[] fArr, int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3, int i2, int i3) {
        if (!z3) {
            m20850b(fArr, OplusGLSurfaceView_13);
        }
        if (z2) {
            m20850b(fArr, OplusGLSurfaceView_13);
        }
        if (z) {
            m20847a(fArr, OplusGLSurfaceView_13);
        }
        m20848a(fArr, OplusGLSurfaceView_13, i2, i3);
        m20852c(fArr, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20847a(float[] fArr, int OplusGLSurfaceView_13) {
        fArr[OplusGLSurfaceView_13] = 1.0f - fArr[OplusGLSurfaceView_13];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20848a(float[] fArr, int OplusGLSurfaceView_13, int i2, int i3) {
        float COUIBaseListPopupWindow_12 = i2;
        float f2 = i3;
        fArr[OplusGLSurfaceView_13] = ((1.0f - (COUIBaseListPopupWindow_12 / f2)) / 2.0f) + ((fArr[OplusGLSurfaceView_13] * COUIBaseListPopupWindow_12) / f2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20850b(float[] fArr, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 - 1;
        fArr[i2] = 1.0f - fArr[i2];
        fArr[OplusGLSurfaceView_13] = 1.0f - fArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20852c(float[] fArr, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 - 1;
        float COUIBaseListPopupWindow_12 = fArr[i2];
        fArr[i2] = fArr[OplusGLSurfaceView_13];
        fArr[OplusGLSurfaceView_13] = 1.0f - COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo20797b(Context context) {
        m20851c(context);
        m20853d(context);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20851c(Context context) {
        this.f19683D = OpenGLUtils.m24591a("vertex_tex.sh", context.getResources());
        this.f19684E = OpenGLUtils.m24591a("frag_tex.sh", context.getResources());
        this.f19698w = OpenGLUtils.m24596b(this.f19683D, this.f19684E);
        this.f19700y = GLES20.glGetAttribLocation(this.f19698w, "aPosition");
        this.f19701z = GLES20.glGetAttribLocation(this.f19698w, "aTexCoor");
        this.f19699x = GLES20.glGetUniformLocation(this.f19698w, "uMVPMatrix");
        this.f19681B = GLES20.glGetUniformLocation(this.f19698w, "uCamera");
        this.f19682C = GLES20.glGetUniformLocation(this.f19698w, "uLightLocation");
        this.f19680A = GLES20.glGetUniformLocation(this.f19698w, "uMMatrix");
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo20799c(int OplusGLSurfaceView_13, int i2) {
        GLES20Canvas.m14010i();
        GLES20.glUseProgram(this.f19698w);
        GLES20Canvas.m14010i();
        GLES20.glUniformMatrix4fv(this.f19699x, 1, false, MatrixState.m21017d(), 0);
        GLES20Canvas.m14010i();
        GLES20.glUniformMatrix4fv(this.f19680A, 1, false, MatrixState.m21018e(), 0);
        GLES20Canvas.m14010i();
        GLES20.glUniform3fv(this.f19681B, 1, MatrixState.m21019f());
        GLES20Canvas.m14010i();
        GLES20.glUniform3fv(this.f19682C, 1, MatrixState.m21020g());
        GLES20Canvas.m14010i();
        GLES20.glVertexAttribPointer(this.f19700y, 3, 5126, false, 12, (Buffer) this.f19580j.get(i2));
        GLES20.glVertexAttribPointer(this.f19701z, 2, 5126, false, 8, (Buffer) this.f19581k.get(i2));
        GLES20Canvas.m14010i();
        GLES20.glEnableVertexAttribArray(this.f19700y);
        GLES20.glEnableVertexAttribArray(this.f19701z);
        GLES20Canvas.m14010i();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glDrawArrays(4, 0, this.f19579i.get(i2).intValue());
        GLES20.glDisableVertexAttribArray(this.f19700y);
        GLES20.glDisableVertexAttribArray(this.f19701z);
        GLES20Canvas.m14010i();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo20802e(int OplusGLSurfaceView_13, int i2) {
        MatrixState.m21013b();
        GLES20.glViewport(0, 0, this.f19571a, this.f19572b);
        GLES20.glEnable(2929);
        GLES20.glEnable(2884);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 1);
        MatrixState.m21009a(0.0f, ((-MathUtil.m21000i()) / 2.0f) * 1.0f, 0.0f);
        GLES20.glUseProgram(this.f19698w);
        GLES20.glUniformMatrix4fv(this.f19699x, 1, false, MatrixState.m21017d(), 0);
        GLES20.glUniformMatrix4fv(this.f19680A, 1, false, MatrixState.m21018e(), 0);
        GLES20.glUniform3fv(this.f19681B, 1, MatrixState.m21019f());
        GLES20.glUniform3fv(this.f19682C, 1, MatrixState.m21020g());
        GLES20.glVertexAttribPointer(this.f19700y, 3, 5126, false, 12, (Buffer) this.f19580j.get(i2));
        GLES20.glVertexAttribPointer(this.f19701z, 2, 5126, false, 8, (Buffer) this.f19581k.get(i2));
        GLES20.glEnableVertexAttribArray(this.f19700y);
        GLES20.glEnableVertexAttribArray(this.f19701z);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glDrawArrays(4, 0, this.f19579i.get(i2).intValue());
        GLES20.glDisableVertexAttribArray(this.f19700y);
        GLES20.glDisableVertexAttribArray(this.f19701z);
        MatrixState.m21015c();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m20853d(Context context) {
        this.f19692M = OpenGLUtils.m24591a("vertex_tex.sh", context.getResources());
        this.f19693N = OpenGLUtils.m24591a("frag_oes_tex.sh", context.getResources());
        this.f19685F = OpenGLUtils.m24596b(this.f19692M, this.f19693N);
        this.f19687H = GLES20.glGetAttribLocation(this.f19685F, "aPosition");
        this.f19688I = GLES20.glGetAttribLocation(this.f19685F, "aTexCoor");
        this.f19686G = GLES20.glGetUniformLocation(this.f19685F, "uMVPMatrix");
        this.f19690K = GLES20.glGetUniformLocation(this.f19685F, "uCamera");
        this.f19691L = GLES20.glGetUniformLocation(this.f19685F, "uLightLocation");
        this.f19689J = GLES20.glGetUniformLocation(this.f19685F, "uMMatrix");
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo20804f(int OplusGLSurfaceView_13, int i2) {
        GLES20Canvas.m14010i();
        MatrixState.m21013b();
        MatrixState.m21009a(0.0f, ((-MathUtil.m21000i()) / 2.0f) * 1.0f, 0.0f);
        GLES20.glUseProgram(this.f19685F);
        GLES20.glUniformMatrix4fv(this.f19686G, 1, false, MatrixState.m21017d(), 0);
        GLES20.glUniformMatrix4fv(this.f19689J, 1, false, MatrixState.m21018e(), 0);
        GLES20.glUniform3fv(this.f19690K, 1, MatrixState.m21019f());
        GLES20.glUniform3fv(this.f19691L, 1, MatrixState.m21020g());
        GLES20.glVertexAttribPointer(this.f19687H, 3, 5126, false, 12, (Buffer) this.f19580j.get(i2));
        GLES20.glVertexAttribPointer(this.f19688I, 2, 5126, false, 8, (Buffer) this.f19581k.get(i2));
        GLES20.glEnableVertexAttribArray(this.f19687H);
        GLES20.glEnableVertexAttribArray(this.f19688I);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, OplusGLSurfaceView_13);
        GLES20.glDrawArrays(4, 0, this.f19579i.get(i2).intValue());
        GLES20.glDisableVertexAttribArray(this.f19687H);
        GLES20.glDisableVertexAttribArray(this.f19688I);
        MatrixState.m21015c();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseFilterMenuCanvas
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo20801d(int OplusGLSurfaceView_13, int i2) {
        GLES20Canvas.m14010i();
        MatrixState.m21013b();
        MatrixState.m21009a(0.0f, ((-MathUtil.m21000i()) / 2.0f) * 1.0f, 0.0f);
        mo20799c(OplusGLSurfaceView_13, i2);
        MatrixState.m21015c();
    }
}
