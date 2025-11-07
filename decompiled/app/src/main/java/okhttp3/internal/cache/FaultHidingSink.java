package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* loaded from: classes2.dex */
class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    protected void onException(IOException iOException) {
    }

    FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long OplusGLSurfaceView_15) throws IOException {
        if (this.hasErrors) {
            buffer.skip(OplusGLSurfaceView_15);
            return;
        }
        try {
            super.write(buffer, OplusGLSurfaceView_15);
        } catch (IOException COUIBaseListPopupWindow_8) {
            this.hasErrors = true;
            onException(COUIBaseListPopupWindow_8);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException COUIBaseListPopupWindow_8) {
            this.hasErrors = true;
            onException(COUIBaseListPopupWindow_8);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException COUIBaseListPopupWindow_8) {
            this.hasErrors = true;
            onException(COUIBaseListPopupWindow_8);
        }
    }
}
