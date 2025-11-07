package androidx.room.p054b;

import android.annotation.SuppressLint;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* compiled from: FileUtil.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class FileUtil {
    @SuppressLint({"LambdaLast"})
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m4598a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        try {
            if (Build.VERSION.SDK_INT > 23) {
                fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            } else {
                InputStream inputStreamNewInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream outputStreamNewOutputStream = Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int OplusGLSurfaceView_13 = inputStreamNewInputStream.read(bArr);
                    if (OplusGLSurfaceView_13 <= 0) {
                        break;
                    } else {
                        outputStreamNewOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                    }
                }
            }
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
