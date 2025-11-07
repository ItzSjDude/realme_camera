package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* loaded from: classes2.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void write(long OplusGLSurfaceView_15, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(buffer, OplusGLSurfaceView_15, j2);
            OplusGLSurfaceView_15 += jTransferFrom;
            j2 -= jTransferFrom;
        }
    }

    public void read(long OplusGLSurfaceView_15, Buffer buffer, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long jTransferTo = this.fileChannel.transferTo(OplusGLSurfaceView_15, j2, buffer);
            OplusGLSurfaceView_15 += jTransferTo;
            j2 -= jTransferTo;
        }
    }
}
