package com.oplus.camera.p152k;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import androidx.p023c.HeifWriter;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.jni.IccProfile;
import com.oplus.camera.util.Util;
import com.oplus.exif.OplusExifInterface;
import com.oplus.media.OplusHeifWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: HeicProcessor.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class HeicProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private HandlerThread f14493a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Handler f14494b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ParcelFileDescriptor f14495c = null;

    public HeicProcessor(boolean z) {
        this.f14493a = null;
        this.f14494b = null;
        CameraLog.m12959b("HeicProcessor", "HeicProcessor constructor, is8bits: " + z);
        if (z) {
            this.f14493a = new HandlerThread("HeifThread", -2);
            this.f14493a.start();
            this.f14494b = new Handler(this.f14493a.getLooper());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private byte[] m14503a(OplusExifInterface oplusExifInterface) {
        if (oplusExifInterface == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream exifWriterStream = oplusExifInterface.getExifWriterStream(byteArrayOutputStream);
            byte[] bArr = {-1, -40};
            Arrays.fill(bArr, (byte) 0);
            oplusExifInterface.writeExif(bArr, exifWriterStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("HeicProcessor", "exif io exception:" + COUIBaseListPopupWindow_8.toString());
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14506a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2, OplusExifInterface oplusExifInterface, ContentResolver contentResolver, Uri uri) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        m14501a(bitmap, bitmap.getWidth(), bitmap.getHeight(), OplusGLSurfaceView_13, i2, oplusExifInterface, contentResolver, uri);
        CameraLog.m12959b("HeicProcessor", "process, use bitmap, end, costTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14507a(byte[] bArr, OplusExifInterface oplusExifInterface, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, ContentResolver contentResolver, Uri uri) {
        if (bArr == null || contentResolver == null || uri == null) {
            CameraLog.m12967f("HeicProcessor", "process error, resolver: " + contentResolver + ", uri: " + uri + ", heicData: " + bArr);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        FileDescriptor fileDescriptorM14504b = m14504b(contentResolver, uri);
        byte[] bArrM14503a = m14503a(oplusExifInterface);
        if (bArrM14503a != null) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrM14503a, 6, bArrM14503a.length);
            try {
                OplusHeifWriter oplusHeifWriter = new OplusHeifWriter();
                oplusHeifWriter.createPrimaryImage(OplusGLSurfaceView_13, i2, i3, i4, i5, i6, i7);
                oplusHeifWriter.processPrimaryImage(bArr, bArrCopyOfRange, fileDescriptorM14504b);
            } finally {
                m14502a(this.f14495c);
                this.f14495c = null;
            }
        }
        m14500a(contentResolver, uri);
        CameraLog.m12959b("HeicProcessor", "process, use heicData, end, costTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14500a(ContentResolver contentResolver, Uri uri) throws IOException {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            try {
                try {
                    CameraLog.m12967f("HeicProcessor", "addIccProfile, add icc_profile start.");
                    m14504b(contentResolver, uri);
                    IccProfile.writeHeifIccProfile(this.f14495c != null ? this.f14495c.detachFd() : -1);
                } catch (Exception unused) {
                    CameraLog.m12967f("HeicProcessor", "addIccProfile, add icc_profile error");
                }
            } finally {
                m14502a(this.f14495c);
                this.f14495c = null;
                CameraLog.m12967f("HeicProcessor", "addIccProfile, add icc_profile end.");
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14501a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2, int i3, int i4, OplusExifInterface oplusExifInterface, ContentResolver contentResolver, Uri uri) throws IOException {
        HeifWriter c0361dM1820a;
        CameraLog.m12959b("HeicProcessor", "encodeHeicByBitmap started, bitmap: " + bitmap);
        if (contentResolver == null || uri == null) {
            CameraLog.m12967f("HeicProcessor", "encodeHeicByBitmap error, resolver: " + contentResolver + ", uri: " + uri);
            return;
        }
        FileDescriptor fileDescriptorM14504b = m14504b(contentResolver, uri);
        if (!Util.m24169C()) {
            try {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(byteBufferAllocate);
                byte[] bArrM14503a = m14503a(oplusExifInterface);
                byte[] bArrCopyOfRange = bArrM14503a != null ? Arrays.copyOfRange(bArrM14503a, 6, bArrM14503a.length) : null;
                CameraLog.m12959b("HeicProcessor", "encodeHeicByBitmap, use internal heif writer");
                OplusHeifWriter oplusHeifWriter = new OplusHeifWriter();
                oplusHeifWriter.createPrimaryImage(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, 2, i4, i3);
                oplusHeifWriter.processPrimaryImage(byteBufferAllocate.array(), bArrCopyOfRange, fileDescriptorM14504b);
            } finally {
                m14502a(this.f14495c);
                this.f14495c = null;
            }
        } else {
            try {
                c0361dM1820a = new HeifWriter.PlatformImplementations.kt_3(fileDescriptorM14504b, OplusGLSurfaceView_13, i2, 2).m1817a(i3).m1819a(true).m1822c(1).m1821b(i4).m1823d(0).m1818a(this.f14494b).m1820a();
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                c0361dM1820a = null;
            }
            if (c0361dM1820a == null) {
                return;
            }
            c0361dM1820a.m1811a();
            byte[] bArrM14503a2 = m14503a(oplusExifInterface);
            if (bArrM14503a2 != null) {
                c0361dM1820a.m1812a(0, bArrM14503a2, 6, bArrM14503a2.length - 6);
            }
            c0361dM1820a.m1814a(bitmap);
            try {
                try {
                    c0361dM1820a.m1813a(0L);
                } catch (Exception e2) {
                    CameraLog.m12965d("HeicProcessor", "encodeHeicByBitmap, stop heifWriter error, heifWriter: " + c0361dM1820a, e2);
                }
            } finally {
                c0361dM1820a.close();
            }
        }
        m14500a(contentResolver, uri);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FileDescriptor m14504b(ContentResolver contentResolver, Uri uri) throws IOException {
        try {
            this.f14495c = contentResolver.openFileDescriptor(uri, "rw");
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("HeicProcessor", "getFileDescriptor, dup fd error, uri: " + uri, COUIBaseListPopupWindow_8);
        }
        FileDescriptor fileDescriptor = this.f14495c != null ? this.f14495c.getFileDescriptor() : null;
        if (fileDescriptor != null && fileDescriptor.valid()) {
            return fileDescriptor;
        }
        CameraLog.m12967f("HeicProcessor", "getFileDescriptor, fd error, uri: " + uri);
        m14502a(this.f14495c);
        this.f14495c = null;
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14505a() {
        HandlerThread handlerThread = this.f14493a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.f14493a.join();
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14502a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d("HeicProcessor", "closeParcelFD, close parcelFD error, parcelFD: " + parcelFileDescriptor, COUIBaseListPopupWindow_8);
            }
        }
    }
}
