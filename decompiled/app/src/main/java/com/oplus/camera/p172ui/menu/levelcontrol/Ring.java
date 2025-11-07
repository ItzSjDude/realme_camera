package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.opengl.GLES20;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

/* compiled from: Ring.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.q */
/* loaded from: classes2.dex */
public class Ring {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f19858a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f19859b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f19860c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f19861d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19862e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f19863f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f19864g;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f19866i;

    /* renamed from: OplusGLSurfaceView_15 */
    private String f19867j;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f19865h = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private ArrayList<FloatBuffer> f19868k = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_14 */
    private ArrayList<FloatBuffer> f19869l = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_6 */
    private ArrayList<FloatBuffer> f19870m = new ArrayList<>();

    public Ring(Context context) {
        m21021a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21022a() {
        this.f19868k.clear();
        this.f19869l.clear();
        this.f19870m.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21023a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5) {
        this.f19865h = 6;
        int OplusGLSurfaceView_13 = this.f19865h;
        float[] fArr = new float[OplusGLSurfaceView_13 * 3];
        float[] fArr2 = new float[OplusGLSurfaceView_13 * 2];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 1) {
            int i5 = i3 + 1;
            float f6 = i2;
            float f7 = 1;
            float f8 = f5 + ((f6 * COUIBaseListPopupWindow_12) / f7);
            fArr[i3] = f8;
            int i6 = i5 + 1;
            float f9 = (f4 - f2) / 2.0f;
            fArr[i5] = f9;
            int i7 = i6 + 1;
            fArr[i6] = f3;
            int i8 = i4 + 1;
            float f10 = (f6 * 1.0f) / f7;
            fArr2[i4] = f10;
            int i9 = i8 + 1;
            fArr2[i8] = 1.0f;
            int i10 = i7 + 1;
            i2++;
            float f11 = i2;
            float f12 = f5 + ((f11 * COUIBaseListPopupWindow_12) / f7);
            fArr[i7] = f12;
            int i11 = i10 + 1;
            float f13 = (f4 + f2) / 2.0f;
            fArr[i10] = f13;
            int i12 = i11 + 1;
            fArr[i11] = f3;
            int i13 = i9 + 1;
            float f14 = (f11 * 1.0f) / f7;
            fArr2[i9] = f14;
            int i14 = i13 + 1;
            fArr2[i13] = 0.0f;
            int i15 = i12 + 1;
            fArr[i12] = f8;
            int i16 = i15 + 1;
            fArr[i15] = f13;
            int i17 = i16 + 1;
            fArr[i16] = f3;
            int i18 = i14 + 1;
            fArr2[i14] = f10;
            int i19 = i18 + 1;
            fArr2[i18] = 0.0f;
            int i20 = i17 + 1;
            fArr[i17] = f8;
            int i21 = i20 + 1;
            fArr[i20] = f9;
            int i22 = i21 + 1;
            fArr[i21] = f3;
            int i23 = i19 + 1;
            fArr2[i19] = f10;
            int i24 = i23 + 1;
            fArr2[i23] = 1.0f;
            int i25 = i22 + 1;
            fArr[i22] = f12;
            int i26 = i25 + 1;
            fArr[i25] = f9;
            int i27 = i26 + 1;
            fArr[i26] = f3;
            int i28 = i24 + 1;
            fArr2[i24] = f14;
            int i29 = i28 + 1;
            fArr2[i28] = 1.0f;
            int i30 = i27 + 1;
            fArr[i27] = f12;
            int i31 = i30 + 1;
            fArr[i30] = f13;
            i3 = i31 + 1;
            fArr[i31] = f3;
            int i32 = i29 + 1;
            fArr2[i29] = f14;
            i4 = i32 + 1;
            fArr2[i32] = 0.0f;
        }
        float[] fArr3 = new float[fArr.length];
        for (int i33 = 0; i33 < fArr.length; i33++) {
            if (i33 % 3 == 1) {
                fArr3[i33] = 0.0f;
            } else {
                fArr3[i33] = fArr[i33];
            }
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        this.f19868k.add(floatBufferAsFloatBuffer);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr3);
        floatBufferAsFloatBuffer2.position(0);
        this.f19870m.add(floatBufferAsFloatBuffer2);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(fArr2.length * 4);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        floatBufferAsFloatBuffer3.put(fArr2);
        floatBufferAsFloatBuffer3.position(0);
        this.f19869l.add(floatBufferAsFloatBuffer3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21021a(Context context) {
        this.f19866i = OpenGLUtils.m24591a("vertex_tex.sh", context.getResources());
        this.f19867j = OpenGLUtils.m24591a("frag_tex.sh", context.getResources());
        this.f19858a = OpenGLUtils.m24596b(this.f19866i, this.f19867j);
        this.f19860c = GLES20.glGetAttribLocation(this.f19858a, "aPosition");
        this.f19861d = GLES20.glGetAttribLocation(this.f19858a, "aTexCoor");
        this.f19859b = GLES20.glGetUniformLocation(this.f19858a, "uMVPMatrix");
        this.f19863f = GLES20.glGetUniformLocation(this.f19858a, "uCamera");
        this.f19864g = GLES20.glGetUniformLocation(this.f19858a, "uLightLocation");
        this.f19862e = GLES20.glGetUniformLocation(this.f19858a, "uMMatrix");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21024a(int OplusGLSurfaceView_13, int i2) {
        GLES20.glUseProgram(this.f19858a);
        GLES20.glUniformMatrix4fv(this.f19859b, 1, false, MatrixState.m21017d(), 0);
        GLES20.glUniformMatrix4fv(this.f19862e, 1, false, MatrixState.m21018e(), 0);
        GLES20.glUniform3fv(this.f19863f, 1, MatrixState.m21019f());
        GLES20.glUniform3fv(this.f19864g, 1, MatrixState.m21020g());
        GLES20.glVertexAttribPointer(this.f19860c, 3, 5126, false, 12, (Buffer) this.f19868k.get(i2));
        GLES20.glVertexAttribPointer(this.f19861d, 2, 5126, false, 8, (Buffer) this.f19869l.get(i2));
        GLES20.glEnableVertexAttribArray(this.f19860c);
        GLES20.glEnableVertexAttribArray(this.f19861d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glDrawArrays(4, 0, this.f19865h);
        GLES20.glDisableVertexAttribArray(this.f19860c);
        GLES20.glDisableVertexAttribArray(this.f19861d);
    }
}
