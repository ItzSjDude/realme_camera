package androidx.room.b_renamed;

/* compiled from: FileUtil.java */
/* loaded from: classes.dex */
public class d_renamed {
    @android.annotation.SuppressLint({"LambdaLast"})
    public static void a_renamed(java.nio.channels.ReadableByteChannel readableByteChannel, java.nio.channels.FileChannel fileChannel) throws java.io.IOException {
        try {
            if (android.os.Build.VERSION.SDK_INT > 23) {
                fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            } else {
                java.io.InputStream inputStreamNewInputStream = java.nio.channels.Channels.newInputStream(readableByteChannel);
                java.io.OutputStream outputStreamNewOutputStream = java.nio.channels.Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int i_renamed = inputStreamNewInputStream.read(bArr);
                    if (i_renamed <= 0) {
                        break;
                    } else {
                        outputStreamNewOutputStream.write(bArr, 0, i_renamed);
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
