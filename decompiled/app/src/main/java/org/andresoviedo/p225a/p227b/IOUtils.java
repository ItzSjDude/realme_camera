package org.andresoviedo.p225a.p227b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* compiled from: IOUtils.java */
/* renamed from: org.andresoviedo.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class IOUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m26129a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[512];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int OplusGLSurfaceView_13 = inputStream.read(bArr, 0, bArr.length);
            if (OplusGLSurfaceView_13 != -1) {
                byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IntBuffer m26128a(int OplusGLSurfaceView_13) {
        return m26131c(OplusGLSurfaceView_13 * 4).asIntBuffer();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ShortBuffer m26130b(int OplusGLSurfaceView_13) {
        return m26131c(OplusGLSurfaceView_13 * 2).asShortBuffer();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static ByteBuffer m26131c(int OplusGLSurfaceView_13) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(OplusGLSurfaceView_13);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        return byteBufferAllocateDirect;
    }
}
