package com.oplus.camera.watch;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.oplus.camera.CameraLog;
import com.oplus.camera.watch.proto.WatchAgentProto;

/* compiled from: WatchAgentParser.java */
/* renamed from: com.oplus.camera.watch.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class WatchAgentParser {
    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24783a(byte[] bArr, int OplusGLSurfaceView_13) {
        byte[] bArr2 = new byte[bArr.length + bArr.length];
        byte[] bArr3 = {0, (byte) OplusGLSurfaceView_13};
        System.arraycopy(bArr3, 0, bArr2, 0, 2);
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m24782a(byte[] bArr) {
        byte[] bArrM24781a = m24781a(bArr.length);
        byte[] bArr2 = new byte[bArr.length + bArr.length + bArrM24781a.length];
        byte[] bArr3 = {0, 3};
        System.arraycopy(bArr3, 0, bArr2, 0, 2);
        System.arraycopy(bArrM24781a, 0, bArr2, 2, bArrM24781a.length);
        System.arraycopy(bArr, 0, bArr2, bArrM24781a.length + 2, bArr.length);
        return bArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static byte[] m24781a(int OplusGLSurfaceView_13) {
        return new byte[]{(byte) ((OplusGLSurfaceView_13 >> 24) & 255), (byte) ((OplusGLSurfaceView_13 >> 16) & 255), (byte) ((OplusGLSurfaceView_13 >> 8) & 255), (byte) (OplusGLSurfaceView_13 & 255)};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static PlatformImplementations.kt_3 m24784b(byte[] bArr) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
        try {
            byte[] bArrM24786d = m24786d(bArr);
            int iM24785c = m24785c(bArr);
            AbstractMessage from = null;
            if (iM24785c == 1) {
                from = WatchAgentProto.WatchConnectPreviewMessage.parseFrom(bArrM24786d);
            } else if (iM24785c == 5) {
                from = WatchAgentProto.WatchCaptureMessage.parseFrom(bArrM24786d);
            }
            aVar.m24789a(from);
            aVar.m24788a(iM24785c);
        } catch (InvalidProtocolBufferException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m24785c(byte[] bArr) {
        return bArr[1];
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static byte[] m24786d(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 2];
        System.arraycopy(bArr, 2, bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* compiled from: WatchAgentParser.java */
    /* renamed from: com.oplus.camera.watch.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f23203a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private AbstractMessage f23204b;

        /* renamed from: PlatformImplementations.kt_3 */
        public int m24787a() {
            return this.f23203a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24788a(int OplusGLSurfaceView_13) {
            this.f23203a = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public AbstractMessage m24790b() {
            return this.f23204b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24789a(AbstractMessage abstractMessage) {
            this.f23204b = abstractMessage;
        }

        public String toString() {
            return ("mCommandId: " + this.f23203a + ", mMessage:" + this.f23204b).replaceAll("\OplusGLSurfaceView_11", ", ");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m24780a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2) {
        float height;
        if (bitmap == null || bitmap.isRecycled()) {
            CameraLog.m12954a("WatchAgentParser", "scaleBitmap, bitmap is null or recycled");
            return null;
        }
        int height2 = bitmap.getHeight();
        int width = bitmap.getWidth();
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = i2;
        float f3 = COUIBaseListPopupWindow_12 / f2;
        float width2 = bitmap.getWidth() / bitmap.getHeight();
        if (f3 > width2) {
            height = COUIBaseListPopupWindow_12 / bitmap.getWidth();
        } else {
            height = f2 / bitmap.getHeight();
        }
        CameraLog.m12954a("WatchAgentParser", "scaleBitmap, targetRatio: " + f3 + ", originRatio: " + width2 + ", scale: " + height);
        Matrix matrix = new Matrix();
        matrix.postScale(height, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height2, matrix, false);
        bitmap.recycle();
        CameraLog.m12954a("WatchAgentParser", "scaleBitmap X");
        return bitmapCreateBitmap;
    }
}
