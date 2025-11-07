package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import co.polarr.renderer.entities.DrawingItem;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.screen.out.RenderConst;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

/* compiled from: FilterThumbDrawer.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class FilterThumbDrawer {

    /* renamed from: B */
    private int f21357B;

    /* renamed from: C */
    private int f21358C;

    /* renamed from: D */
    private FloatBuffer f21359D;

    /* renamed from: E */
    private FloatBuffer f21360E;

    /* renamed from: F */
    private FloatBuffer f21361F;

    /* renamed from: G */
    private FloatBuffer f21362G;

    /* renamed from: PlatformImplementations.kt_3 */
    private String f21365a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f21366b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f21367c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f21368d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f21369e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f21370f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float[] f21371g = new float[8];

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f21372h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f21373i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f21374j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int[] f21375k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21376l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21377m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21378n = 0;

    /* renamed from: o */
    private int f21379o = 0;

    /* renamed from: p */
    private int f21380p = 0;

    /* renamed from: q */
    private int f21381q = 0;

    /* renamed from: r */
    private int f21382r = 0;

    /* renamed from: s */
    private int f21383s = 0;

    /* renamed from: t */
    private int f21384t = 0;

    /* renamed from: u */
    private int f21385u = 0;

    /* renamed from: v */
    private int f21386v = 0;

    /* renamed from: w */
    private int f21387w = 0;

    /* renamed from: x */
    private int f21388x = 0;

    /* renamed from: y */
    private int f21389y = 0;

    /* renamed from: z */
    private int f21390z = 0;

    /* renamed from: A */
    private int f21356A = 0;

    /* renamed from: H */
    private Bitmap f21363H = null;

    /* renamed from: I */
    private Bitmap f21364I = null;

    public FilterThumbDrawer(Context context) {
        this.f21365a = null;
        this.f21366b = null;
        this.f21367c = null;
        this.f21368d = null;
        this.f21369e = null;
        this.f21370f = null;
        this.f21359D = null;
        this.f21360E = null;
        this.f21361F = null;
        this.f21362G = null;
        this.f21361F = m22662a(RenderConst.f16119a);
        this.f21359D = m22662a(RenderConst.f16120b);
        this.f21360E = m22662a(RenderConst.f16121c);
        this.f21362G = m22662a(RenderConst.f16120b);
        this.f21365a = m22661a(context.getResources().openRawResource(R.raw.fragment_shader));
        this.f21366b = m22661a(context.getResources().openRawResource(R.raw.fragment_shader_oes));
        this.f21367c = m22661a(context.getResources().openRawResource(R.raw.fragment_shader_common));
        this.f21368d = m22661a(context.getResources().openRawResource(R.raw.vertex_shader));
        this.f21369e = m22661a(context.getResources().openRawResource(R.raw.vertex_shader_oes));
        this.f21370f = m22661a(context.getResources().openRawResource(R.raw.vertex_shader_common));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22663a(int OplusGLSurfaceView_13) {
        Canvas canvas = new Canvas();
        this.f21363H = Bitmap.createBitmap(OplusGLSurfaceView_13, OplusGLSurfaceView_13, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(this.f21363H);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = (int) (0.5f * COUIBaseListPopupWindow_12);
        canvas.drawRoundRect(0.0f, 0.0f, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, f2, f2, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22671a() {
        int[] iArr = this.f21372h;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
        int[] iArr2 = this.f21375k;
        if (iArr2 != null) {
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FloatBuffer m22662a(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22672a(AncFilterSdk c3403b, List<DrawingItem> list, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        int i3;
        m22667b();
        Rect rect = list.get(0).rect;
        if (this.f21372h == null) {
            this.f21372h = new int[2];
            int[] iArr = this.f21372h;
            GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.f21372h;
            this.f21373i = iArr2[0];
            this.f21374j = iArr2[1];
        }
        if (this.f21375k == null || this.f21378n != rect.width() || this.f21379o != rect.height()) {
            int[] iArr3 = this.f21375k;
            if (iArr3 != null) {
                GLES20.glDeleteTextures(iArr3.length, iArr3, 0);
            }
            this.f21375k = new int[4];
            int[] iArr4 = this.f21375k;
            GLES20.glGenTextures(iArr4.length, iArr4, 0);
            this.f21376l = this.f21375k[0];
            m22665a(this.f21376l, rect);
            this.f21377m = this.f21375k[1];
            m22665a(this.f21377m, rect);
            this.f21381q = this.f21375k[2];
            m22663a(rect.height());
            m22664a(this.f21380p, this.f21363H);
            this.f21381q = this.f21375k[3];
            this.f21378n = rect.width();
            this.f21379o = rect.height();
            float[] fArr = RenderConst.f16121c;
            float[] fArr2 = this.f21371g;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            float fWidth = ((rect.width() - rect.height()) / 2.0f) / rect.width();
            int i4 = 0;
            while (true) {
                float[] fArr3 = this.f21371g;
                if (i4 >= fArr3.length) {
                    break;
                }
                fArr3[i4] = fArr3[i4] + (fArr3[i4] == 0.0f ? fWidth : -fWidth);
                i4 += 2;
            }
            DrawingItem drawingItem = list.get(list.size() - 1);
            this.f21364I = Bitmap.createBitmap(drawingItem.rect.right, drawingItem.rect.bottom, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            Canvas canvas = new Canvas(this.f21364I);
            for (DrawingItem drawingItem2 : list) {
                if (drawingItem2.overlayBitmap != null) {
                    int i5 = drawingItem2.overlayLeft + drawingItem2.rect.left;
                    int i6 = drawingItem2.overlayTop + drawingItem2.rect.top;
                    int i7 = drawingItem2.rect.bottom - (i6 - drawingItem2.rect.top);
                    canvas.drawBitmap(drawingItem2.overlayBitmap, new Rect(0, 0, drawingItem2.overlayBitmap.getWidth(), drawingItem2.overlayBitmap.getHeight()), new Rect(i5, i6, (((i7 - i6) * drawingItem2.overlayBitmap.getWidth()) / drawingItem2.overlayBitmap.getHeight()) + i5, i7), paint);
                }
            }
            m22664a(this.f21381q, this.f21364I);
        }
        int i8 = 36160;
        GLES20.glBindFramebuffer(36160, this.f21373i);
        int i9 = 36064;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f21376l, 0);
        GLES20.glViewport(0, 0, rect.width(), rect.height());
        GLES20.glUseProgram(this.f21388x);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, OplusGLSurfaceView_13);
        GLES20.glVertexAttribPointer(this.f21389y, 2, 5126, false, 8, (Buffer) this.f21361F);
        GLES20.glEnableVertexAttribArray(this.f21389y);
        GLES20.glVertexAttribPointer(this.f21390z, 2, 5126, false, 8, (Buffer) this.f21360E);
        GLES20.glEnableVertexAttribArray(this.f21390z);
        GLES20.glDrawArrays(5, 0, 4);
        int i10 = 0;
        while (i10 < list.size()) {
            DrawingItem drawingItem3 = list.get(i10);
            Rect rect2 = drawingItem3.rect;
            if ("default".equals(drawingItem3.filterId)) {
                i3 = this.f21376l;
            } else {
                GLES20.glViewport(0, 0, rect2.width(), rect2.height());
                c3403b.mo22238a(drawingItem3.filterId);
                c3403b.mo22242b(this.f21376l);
                c3403b.mo22236a(this.f21377m);
                c3403b.m22495a(rect2.width(), rect2.height());
                c3403b.mo22244d();
                i3 = this.f21377m;
            }
            GLES20.glBindFramebuffer(i8, this.f21374j);
            GLES20.glFramebufferTexture2D(i8, i9, 3553, i2, 0);
            GLES20.glViewport(rect2.left + ((rect2.width() - rect2.height()) / 2), rect2.top, rect2.height(), rect2.height());
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 0);
            GLES20.glUseProgram(this.f21382r);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i3);
            GLES20.glUniform1i(this.f21386v, 0);
            GLES20.glVertexAttribPointer(this.f21383s, 2, 5126, false, 8, (Buffer) this.f21361F);
            GLES20.glEnableVertexAttribArray(this.f21383s);
            this.f21362G.position(0);
            this.f21362G.put(this.f21371g);
            this.f21362G.position(0);
            GLES20.glVertexAttribPointer(this.f21384t, 2, 5126, false, 8, (Buffer) this.f21362G);
            GLES20.glEnableVertexAttribArray(this.f21384t);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.f21380p);
            GLES20.glUniform1i(this.f21387w, 1);
            GLES20.glVertexAttribPointer(this.f21385u, 2, 5126, false, 8, (Buffer) this.f21359D);
            GLES20.glEnableVertexAttribArray(this.f21385u);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisable(3042);
            i10++;
            i8 = 36160;
            i9 = 36064;
        }
        GLES20.glViewport(0, 0, this.f21364I.getWidth(), this.f21364I.getHeight());
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        GLES20.glUseProgram(this.f21356A);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f21381q);
        GLES20.glVertexAttribPointer(this.f21357B, 2, 5126, false, 8, (Buffer) this.f21361F);
        GLES20.glEnableVertexAttribArray(this.f21357B);
        GLES20.glVertexAttribPointer(this.f21358C, 2, 5126, false, 8, (Buffer) this.f21360E);
        GLES20.glEnableVertexAttribArray(this.f21358C);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisable(3042);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22665a(int OplusGLSurfaceView_13, Rect rect) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, rect.width(), rect.height(), 0, 6408, 5121, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22664a(int OplusGLSurfaceView_13, Bitmap bitmap) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22667b() {
        m22668c();
        m22669d();
        m22670e();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m22668c() {
        if (this.f21356A == 0) {
            this.f21356A = m22660a(this.f21370f, this.f21367c);
            this.f21357B = GLES20.glGetAttribLocation(this.f21356A, "aPosition");
            this.f21358C = GLES20.glGetAttribLocation(this.f21356A, "aTextureCoord");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m22669d() {
        if (this.f21382r == 0) {
            this.f21382r = m22660a(this.f21368d, this.f21365a);
            this.f21383s = GLES20.glGetAttribLocation(this.f21382r, "aPosition");
            this.f21384t = GLES20.glGetAttribLocation(this.f21382r, "aTextureCoord");
            this.f21386v = GLES20.glGetUniformLocation(this.f21382r, "aTexture");
            this.f21385u = GLES20.glGetAttribLocation(this.f21382r, "aTextureCoordMask");
            this.f21387w = GLES20.glGetUniformLocation(this.f21382r, "aTextureMask");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m22670e() {
        if (this.f21388x == 0) {
            this.f21388x = m22660a(this.f21369e, this.f21366b);
            this.f21389y = GLES20.glGetAttribLocation(this.f21388x, "aPosition");
            this.f21390z = GLES20.glGetAttribLocation(this.f21388x, "aTextureCoord");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m22661a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int OplusGLSurfaceView_13 = inputStream.read(bArr);
                        if (OplusGLSurfaceView_13 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m22660a(String str, String str2) {
        int iM22659a = m22659a(35633, str);
        if (iM22659a == 0) {
            CameraLog.m12967f("FilterThumbDrawer", "load vertex shader error");
        }
        int iM22659a2 = m22659a(35632, str2);
        if (iM22659a2 == 0) {
            CameraLog.m12967f("FilterThumbDrawer", "load fragment shader error");
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        m22666a("glCreateProgram");
        GLES20.glAttachShader(iGlCreateProgram, iM22659a);
        m22666a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iM22659a2);
        m22666a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m22659a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        m22666a("glCreateShader type = " + OplusGLSurfaceView_13);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22666a(String str) {
        for (int iGlGetError = GLES20.glGetError(); iGlGetError != 0; iGlGetError = GLES20.glGetError()) {
            CameraLog.m12967f("FilterThumbDrawer", str + ": glError " + iGlGetError);
        }
    }
}
