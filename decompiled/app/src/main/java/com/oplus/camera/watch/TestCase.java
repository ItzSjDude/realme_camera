package com.oplus.camera.watch;

/* compiled from: WatchAgentParser.java */
/* loaded from: classes2.dex */
public class e_renamed {
    public static byte[] a_renamed(byte[] bArr, int i_renamed) {
        byte[] bArr2 = new byte[bArr.length + bArr.length];
        byte[] bArr3 = {0, (byte) i_renamed};
        java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 2);
        java.lang.System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public static byte[] a_renamed(byte[] bArr) {
        byte[] bArrA = a_renamed(bArr.length);
        byte[] bArr2 = new byte[bArr.length + bArr.length + bArrA.length];
        byte[] bArr3 = {0, 3};
        java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 2);
        java.lang.System.arraycopy(bArrA, 0, bArr2, 2, bArrA.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, bArrA.length + 2, bArr.length);
        return bArr2;
    }

    private static byte[] a_renamed(int i_renamed) {
        return new byte[]{(byte) ((i_renamed >> 24) & 255), (byte) ((i_renamed >> 16) & 255), (byte) ((i_renamed >> 8) & 255), (byte) (i_renamed & 255)};
    }

    public static com.oplus.camera.watch.e_renamed.a_renamed b_renamed(byte[] bArr) {
        com.oplus.camera.watch.e_renamed.a_renamed aVar = new com.oplus.camera.watch.e_renamed.a_renamed();
        try {
            byte[] bArrD = d_renamed(bArr);
            int iC = c_renamed(bArr);
            com.google.protobuf.AbstractMessage from = null;
            if (iC == 1) {
                from = com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.parseFrom(bArrD);
            } else if (iC == 5) {
                from = com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.parseFrom(bArrD);
            }
            aVar.a_renamed(from);
            aVar.a_renamed(iC);
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            e_renamed.printStackTrace();
        }
        return aVar;
    }

    private static int c_renamed(byte[] bArr) {
        return bArr[1];
    }

    private static byte[] d_renamed(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 2];
        java.lang.System.arraycopy(bArr, 2, bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* compiled from: WatchAgentParser.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f7420a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.google.protobuf.AbstractMessage f7421b;

        public int a_renamed() {
            return this.f7420a;
        }

        public void a_renamed(int i_renamed) {
            this.f7420a = i_renamed;
        }

        public com.google.protobuf.AbstractMessage b_renamed() {
            return this.f7421b;
        }

        public void a_renamed(com.google.protobuf.AbstractMessage abstractMessage) {
            this.f7421b = abstractMessage;
        }

        public java.lang.String toString() {
            return ("mCommandId: " + this.f7420a + ", mMessage:" + this.f7421b).replaceAll("\n_renamed", ", ");
        }
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2) {
        float height;
        if (bitmap == null || bitmap.isRecycled()) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentParser", "scaleBitmap, bitmap is_renamed null or recycled");
            return null;
        }
        int height2 = bitmap.getHeight();
        int width = bitmap.getWidth();
        float f_renamed = i_renamed;
        float f2 = i2;
        float f3 = f_renamed / f2;
        float width2 = bitmap.getWidth() / bitmap.getHeight();
        if (f3 > width2) {
            height = f_renamed / bitmap.getWidth();
        } else {
            height = f2 / bitmap.getHeight();
        }
        com.oplus.camera.e_renamed.a_renamed("WatchAgentParser", "scaleBitmap, targetRatio: " + f3 + ", originRatio: " + width2 + ", scale: " + height);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(height, height);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height2, matrix, false);
        bitmap.recycle();
        com.oplus.camera.e_renamed.a_renamed("WatchAgentParser", "scaleBitmap X_renamed");
        return bitmapCreateBitmap;
    }
}
