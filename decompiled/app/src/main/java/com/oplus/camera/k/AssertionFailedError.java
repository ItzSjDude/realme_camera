package com.oplus.camera.k_renamed;

/* compiled from: HeicProcessor.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.os.HandlerThread f4782a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.os.Handler f4783b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.ParcelFileDescriptor f4784c = null;

    public b_renamed(boolean z_renamed) {
        this.f4782a = null;
        this.f4783b = null;
        com.oplus.camera.e_renamed.b_renamed("HeicProcessor", "HeicProcessor constructor, is8bits: " + z_renamed);
        if (z_renamed) {
            this.f4782a = new android.os.HandlerThread("HeifThread", -2);
            this.f4782a.start();
            this.f4783b = new android.os.Handler(this.f4782a.getLooper());
        }
    }

    private byte[] a_renamed(com.oplus.exif.OplusExifInterface oplusExifInterface) {
        if (oplusExifInterface == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.io.OutputStream exifWriterStream = oplusExifInterface.getExifWriterStream(byteArrayOutputStream);
            byte[] bArr = {-1, -40};
            java.util.Arrays.fill(bArr, (byte) 0);
            oplusExifInterface.writeExif(bArr, exifWriterStream);
            return byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "exif io exception:" + e_renamed.toString());
            return null;
        }
    }

    public void a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2, com.oplus.exif.OplusExifInterface oplusExifInterface, android.content.ContentResolver contentResolver, android.net.Uri uri) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        a_renamed(bitmap, bitmap.getWidth(), bitmap.getHeight(), i_renamed, i2, oplusExifInterface, contentResolver, uri);
        com.oplus.camera.e_renamed.b_renamed("HeicProcessor", "process, use bitmap, end, costTime: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void a_renamed(byte[] bArr, com.oplus.exif.OplusExifInterface oplusExifInterface, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, android.content.ContentResolver contentResolver, android.net.Uri uri) {
        if (bArr == null || contentResolver == null || uri == null) {
            com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "process error, resolver: " + contentResolver + ", uri: " + uri + ", heicData: " + bArr);
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.io.FileDescriptor fileDescriptorB = b_renamed(contentResolver, uri);
        byte[] bArrA = a_renamed(oplusExifInterface);
        if (bArrA != null) {
            byte[] bArrCopyOfRange = java.util.Arrays.copyOfRange(bArrA, 6, bArrA.length);
            try {
                com.oplus.media.OplusHeifWriter oplusHeifWriter = new com.oplus.media.OplusHeifWriter();
                oplusHeifWriter.createPrimaryImage(i_renamed, i2, i3, i4, i5, i6, i7);
                oplusHeifWriter.processPrimaryImage(bArr, bArrCopyOfRange, fileDescriptorB);
            } finally {
                a_renamed(this.f4784c);
                this.f4784c = null;
            }
        }
        a_renamed(contentResolver, uri);
        com.oplus.camera.e_renamed.b_renamed("HeicProcessor", "process, use heicData, end, costTime: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void a_renamed(android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            try {
                try {
                    com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "addIccProfile, add icc_profile start.");
                    b_renamed(contentResolver, uri);
                    com.oplus.camera.jni.IccProfile.writeHeifIccProfile(this.f4784c != null ? this.f4784c.detachFd() : -1);
                } catch (java.lang.Exception unused) {
                    com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "addIccProfile, add icc_profile error");
                }
            } finally {
                a_renamed(this.f4784c);
                this.f4784c = null;
                com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "addIccProfile, add icc_profile end.");
            }
        }
    }

    private void a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2, int i3, int i4, com.oplus.exif.OplusExifInterface oplusExifInterface, android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        androidx.c_renamed.d_renamed dVarA;
        com.oplus.camera.e_renamed.b_renamed("HeicProcessor", "encodeHeicByBitmap started, bitmap: " + bitmap);
        if (contentResolver == null || uri == null) {
            com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "encodeHeicByBitmap error, resolver: " + contentResolver + ", uri: " + uri);
            return;
        }
        java.io.FileDescriptor fileDescriptorB = b_renamed(contentResolver, uri);
        if (!com.oplus.camera.util.Util.C_renamed()) {
            try {
                java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(byteBufferAllocate);
                byte[] bArrA = a_renamed(oplusExifInterface);
                byte[] bArrCopyOfRange = bArrA != null ? java.util.Arrays.copyOfRange(bArrA, 6, bArrA.length) : null;
                com.oplus.camera.e_renamed.b_renamed("HeicProcessor", "encodeHeicByBitmap, use internal heif writer");
                com.oplus.media.OplusHeifWriter oplusHeifWriter = new com.oplus.media.OplusHeifWriter();
                oplusHeifWriter.createPrimaryImage(i_renamed, i2, i_renamed, i2, 2, i4, i3);
                oplusHeifWriter.processPrimaryImage(byteBufferAllocate.array(), bArrCopyOfRange, fileDescriptorB);
            } finally {
                a_renamed(this.f4784c);
                this.f4784c = null;
            }
        } else {
            try {
                dVarA = new androidx.c_renamed.d_renamed.a_renamed(fileDescriptorB, i_renamed, i2, 2).a_renamed(i3).a_renamed(true).c_renamed(1).b_renamed(i4).d_renamed(0).a_renamed(this.f4783b).a_renamed();
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
                dVarA = null;
            }
            if (dVarA == null) {
                return;
            }
            dVarA.a_renamed();
            byte[] bArrA2 = a_renamed(oplusExifInterface);
            if (bArrA2 != null) {
                dVarA.a_renamed(0, bArrA2, 6, bArrA2.length - 6);
            }
            dVarA.a_renamed(bitmap);
            try {
                try {
                    dVarA.a_renamed(0L);
                } catch (java.lang.Exception e2) {
                    com.oplus.camera.e_renamed.d_renamed("HeicProcessor", "encodeHeicByBitmap, stop heifWriter error, heifWriter: " + dVarA, e2);
                }
            } finally {
                dVarA.close();
            }
        }
        a_renamed(contentResolver, uri);
    }

    private java.io.FileDescriptor b_renamed(android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        try {
            this.f4784c = contentResolver.openFileDescriptor(uri, "rw");
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("HeicProcessor", "getFileDescriptor, dup fd_renamed error, uri: " + uri, e_renamed);
        }
        java.io.FileDescriptor fileDescriptor = this.f4784c != null ? this.f4784c.getFileDescriptor() : null;
        if (fileDescriptor != null && fileDescriptor.valid()) {
            return fileDescriptor;
        }
        com.oplus.camera.e_renamed.f_renamed("HeicProcessor", "getFileDescriptor, fd_renamed error, uri: " + uri);
        a_renamed(this.f4784c);
        this.f4784c = null;
        return null;
    }

    public void a_renamed() {
        android.os.HandlerThread handlerThread = this.f4782a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.f4782a.join();
            } catch (java.lang.InterruptedException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    private void a_renamed(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed("HeicProcessor", "closeParcelFD, close parcelFD error, parcelFD: " + parcelFileDescriptor, e_renamed);
            }
        }
    }
}
