package org.andresoviedo.p225a.p226a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: GLUtil.java */
/* renamed from: org.andresoviedo.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class GLUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m26121a(int OplusGLSurfaceView_13, int i2, String[] strArr) {
        int iM26077a = GL.f24804a.m26077a();
        if (iM26077a != 0) {
            GL.f24804a.m26081a(iM26077a, OplusGLSurfaceView_13);
            GL.f24804a.m26081a(iM26077a, i2);
            if (strArr != null) {
                int length = strArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    GL.f24804a.m26086a(iM26077a, i3, strArr[i3]);
                }
            }
            GL.f24804a.m26117n(iM26077a);
            int[] iArr = new int[1];
            GL c4047c = GL.f24804a;
            GL c4047c2 = GL.f24804a;
            c4047c.m26089a(iM26077a, 35714, iArr, 0);
            if (iArr[0] == 0) {
                Log.COUIBaseListPopupWindow_8("GLUtil", "Error compiling program: " + GL.f24804a.m26115k(iM26077a));
                GL.f24804a.m26109e(iM26077a);
                iM26077a = 0;
            }
        }
        if (iM26077a != 0) {
            return iM26077a;
        }
        throw new RuntimeException("Error creating program.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m26122a(int OplusGLSurfaceView_13, String str) {
        int iM26105d = GL.f24804a.m26105d(OplusGLSurfaceView_13);
        GL.f24804a.m26103c(iM26105d, str);
        GL.f24804a.m26101c(iM26105d);
        int[] iArr = new int[1];
        GL c4047c = GL.f24804a;
        GL c4047c2 = GL.f24804a;
        c4047c.m26098b(iM26105d, 35713, iArr, 0);
        Log.IntrinsicsJvm.kt_5("GLUtil", "Shader compilation info: " + GL.f24804a.m26116l(iM26105d));
        if (iArr[0] == 0) {
            Log.COUIBaseListPopupWindow_8("GLUtil", "Shader error: " + GL.f24804a.m26116l(iM26105d) + "\OplusGLSurfaceView_11" + str);
            GL.f24804a.m26110f(iM26105d);
        }
        return iM26105d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m26123a(InputStream inputStream) {
        Log.v("GLUtil", "Loading texture from stream...");
        int[] iArr = new int[1];
        GL.f24804a.m26108d(1, iArr, 0);
        m26125a("glGenTextures");
        if (iArr[0] == 0) {
            throw new RuntimeException("Error loading texture.");
        }
        Log.v("GLUtil", "Handler: " + iArr[0]);
        Bitmap bitmapM26126b = m26126b(inputStream);
        GL c4047c = GL.f24804a;
        GL c4047c2 = GL.f24804a;
        c4047c.m26094b(3553, iArr[0]);
        m26125a("glBindTexture");
        GL c4047c3 = GL.f24804a;
        GLUtils.texImage2D(3553, 0, bitmapM26126b, 0);
        m26125a("texImage2D");
        bitmapM26126b.recycle();
        GL c4047c4 = GL.f24804a;
        GL c4047c5 = GL.f24804a;
        GL c4047c6 = GL.f24804a;
        GL c4047c7 = GL.f24804a;
        c4047c4.m26095b(3553, 10241, 9728);
        GL c4047c8 = GL.f24804a;
        GL c4047c9 = GL.f24804a;
        GL c4047c10 = GL.f24804a;
        GL c4047c11 = GL.f24804a;
        c4047c8.m26095b(3553, 10240, 9728);
        Log.v("GLUtil", "Loaded texture ok");
        return iArr[0];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Bitmap m26126b(InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new RuntimeException("couldn't load bitmap");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m26125a(String str) {
        boolean z = false;
        while (true) {
            int iM26091b = GL.f24804a.m26091b();
            GL c4047c = GL.f24804a;
            if (iM26091b == 0) {
                return z;
            }
            Log.COUIBaseListPopupWindow_8("GLUtil", str + ": glError " + iM26091b);
            z = true;
            Log.COUIBaseListPopupWindow_8("GLUtil", Thread.currentThread().getStackTrace()[3].toString());
            Log.COUIBaseListPopupWindow_8("GLUtil", Thread.currentThread().getStackTrace()[4].toString());
            Log.COUIBaseListPopupWindow_8("GLUtil", Thread.currentThread().getStackTrace()[5].toString());
            Log.COUIBaseListPopupWindow_8("GLUtil", Thread.currentThread().getStackTrace()[6].toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ByteBuffer m26124a(int OplusGLSurfaceView_13) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(OplusGLSurfaceView_13);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        return byteBufferAllocateDirect;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static FloatBuffer m26127b(int OplusGLSurfaceView_13) {
        return m26124a(OplusGLSurfaceView_13 * 4).asFloatBuffer();
    }
}
