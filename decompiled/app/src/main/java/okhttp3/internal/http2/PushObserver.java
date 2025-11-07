package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* loaded from: classes2.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() { // from class: okhttp3.internal.http2.PushObserver.1
        @Override // okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int OplusGLSurfaceView_13, List<Header> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onRequest(int OplusGLSurfaceView_13, List<Header> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public void onReset(int OplusGLSurfaceView_13, ErrorCode errorCode) {
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onData(int OplusGLSurfaceView_13, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }
    };

    boolean onData(int OplusGLSurfaceView_13, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int OplusGLSurfaceView_13, List<Header> list, boolean z);

    boolean onRequest(int OplusGLSurfaceView_13, List<Header> list);

    void onReset(int OplusGLSurfaceView_13, ErrorCode errorCode);
}
