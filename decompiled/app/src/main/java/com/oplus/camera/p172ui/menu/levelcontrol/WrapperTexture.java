package com.oplus.camera.p172ui.menu.levelcontrol;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import java.nio.ByteBuffer;

/* compiled from: WrapperTexture.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.t */
/* loaded from: classes2.dex */
public class WrapperTexture {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f19888a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f19889b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f19890c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f19891d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19892e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m21043g() {
        return 3553;
    }

    public WrapperTexture() {
        this(-1);
    }

    public WrapperTexture(int OplusGLSurfaceView_13) {
        this(-1, -1, OplusGLSurfaceView_13);
    }

    public WrapperTexture(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f19888a = 0;
        this.f19889b = -1;
        this.f19890c = -1;
        this.f19891d = -1;
        this.f19892e = -1;
        this.f19890c = i3;
        this.f19891d = OplusGLSurfaceView_13;
        this.f19892e = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21036a(Bitmap bitmap) {
        try {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f19889b = iArr[0];
            GLES20.glBindTexture(3553, m21039c());
            GLES20Canvas.m14010i();
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            GLES20Canvas.m14010i();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        CameraLog.m12954a("WrapperTexture", "prepare, textureId: " + m21039c() + ", mState: " + this.f19888a);
        this.f19888a = 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21038b(Bitmap bitmap) {
        GLES20.glBindTexture(3553, m21039c());
        GLES20Canvas.m14010i();
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        GLES20Canvas.m14010i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21035a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f19889b = iArr[0];
        int iM21043g = m21043g();
        GLES20.glBindTexture(iM21043g, m21039c());
        GLES20Canvas.m14010i();
        GLES20.glTexImage2D(iM21043g, 0, 6408, this.f19891d, this.f19892e, 0, 6408, 5121, ByteBuffer.allocate(this.f19891d * this.f19892e * 4));
        GLES20Canvas.m14010i();
        GLES20.glBindTexture(iM21043g, m21039c());
        GLES20Canvas.m14010i();
        GLES20.glTexParameteri(iM21043g, 10242, 33071);
        GLES20Canvas.m14010i();
        GLES20.glTexParameteri(iM21043g, 10243, 33071);
        GLES20Canvas.m14010i();
        GLES20.glTexParameterf(iM21043g, 10241, 9729.0f);
        GLES20Canvas.m14010i();
        GLES20.glTexParameterf(iM21043g, 10240, 9729.0f);
        GLES20Canvas.m14010i();
        CameraLog.m12954a("WrapperTexture", "prepare, textureId: " + m21039c() + ", mState: " + this.f19888a + ", width: " + this.f19891d + ", height: " + this.f19892e);
        this.f19888a = 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21037b() {
        CameraLog.m12954a("WrapperTexture", "recycle, textureId: " + m21039c() + ", mState: " + this.f19888a);
        if (m21044h()) {
            GLES20.glDeleteTextures(1, new int[]{this.f19889b}, 0);
            GLES20Canvas.m14010i();
        }
        this.f19888a = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m21039c() {
        return this.f19889b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m21040d() {
        return this.f19890c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m21041e() {
        return this.f19891d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m21042f() {
        return this.f19892e;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m21044h() {
        return this.f19888a == 1;
    }
}
