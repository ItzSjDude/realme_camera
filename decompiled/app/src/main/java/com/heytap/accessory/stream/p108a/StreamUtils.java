package com.heytap.accessory.stream.p108a;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamUtils.java */
/* renamed from: com.heytap.accessory.stream.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class StreamUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9676a = "PlatformImplementations.kt_3";

    /* renamed from: PlatformImplementations.kt_3 */
    public static ParcelFileDescriptor m8709a(InputStream inputStream, int OplusGLSurfaceView_13) throws IOException {
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
        new PlatformImplementations.kt_3(inputStream, OplusGLSurfaceView_13, new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1])).start();
        return parcelFileDescriptor;
    }

    /* compiled from: StreamUtils.java */
    /* renamed from: com.heytap.accessory.stream.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends Thread {

        /* renamed from: PlatformImplementations.kt_3 */
        InputStream f9677a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        OutputStream f9678b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f9679c;

        PlatformImplementations.kt_3(InputStream inputStream, int OplusGLSurfaceView_13, OutputStream outputStream) {
            super("ParcelFileDescriptor Transfer Thread");
            this.f9677a = inputStream;
            this.f9678b = outputStream;
            int i2 = 32768;
            if (OplusGLSurfaceView_13 == 1) {
                i2 = 64888;
            } else if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 != 4) {
                    Log.w(StreamUtils.f9676a, "unsupported transport time, return default packet length");
                } else {
                    i2 = 4840;
                }
            }
            this.f9679c = i2;
            setDaemon(true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws IOException {
            byte[] bArr = new byte[this.f9679c];
            while (true) {
                try {
                    try {
                        int OplusGLSurfaceView_13 = this.f9677a.read(bArr);
                        if (OplusGLSurfaceView_13 <= 0) {
                            break;
                        } else {
                            this.f9678b.write(bArr, 0, OplusGLSurfaceView_13);
                        }
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        Log.COUIBaseListPopupWindow_8("TransferThread", COUIBaseListPopupWindow_8.getMessage());
                        try {
                            this.f9677a.close();
                            this.f9677a = null;
                        } catch (IOException unused) {
                        }
                        try {
                            this.f9678b.close();
                            this.f9678b = null;
                            return;
                        } catch (IOException unused2) {
                            return;
                        }
                    }
                } finally {
                }
            }
            this.f9678b.flush();
            try {
                this.f9677a.close();
                this.f9677a = null;
            } catch (IOException unused3) {
            }
            try {
                this.f9678b.close();
                this.f9678b = null;
            } catch (IOException unused4) {
            }
        }
    }
}
