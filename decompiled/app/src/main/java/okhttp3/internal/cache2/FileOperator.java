package okhttp3.internal.cache2;

/* loaded from: classes2.dex */
final class FileOperator {
    private final java.nio.channels.FileChannel fileChannel;

    FileOperator(java.nio.channels.FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void write(long j_renamed, okio.Buffer buffer, long j2) throws java.io.IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(buffer, j_renamed, j2);
            j_renamed += jTransferFrom;
            j2 -= jTransferFrom;
        }
    }

    public void read(long j_renamed, okio.Buffer buffer, long j2) throws java.io.IOException {
        if (j2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j_renamed, j2, buffer);
            j_renamed += jTransferTo;
            j2 -= jTransferTo;
        }
    }
}
