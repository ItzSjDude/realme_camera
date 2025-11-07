package okhttp3.internal.http2;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    Settings set(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 >= 0) {
            int[] iArr = this.values;
            if (OplusGLSurfaceView_13 < iArr.length) {
                this.set = (1 << OplusGLSurfaceView_13) | this.set;
                iArr[OplusGLSurfaceView_13] = i2;
            }
        }
        return this;
    }

    boolean isSet(int OplusGLSurfaceView_13) {
        return (this.set & (1 << OplusGLSurfaceView_13)) != 0;
    }

    int get(int OplusGLSurfaceView_13) {
        return this.values[OplusGLSurfaceView_13];
    }

    int size() {
        return Integer.bitCount(this.set);
    }

    int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    int getMaxConcurrentStreams(int OplusGLSurfaceView_13) {
        return (this.set & 16) != 0 ? this.values[4] : OplusGLSurfaceView_13;
    }

    int getMaxFrameSize(int OplusGLSurfaceView_13) {
        return (this.set & 32) != 0 ? this.values[5] : OplusGLSurfaceView_13;
    }

    int getMaxHeaderListSize(int OplusGLSurfaceView_13) {
        return (this.set & 64) != 0 ? this.values[6] : OplusGLSurfaceView_13;
    }

    int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    void merge(Settings settings) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 10; OplusGLSurfaceView_13++) {
            if (settings.isSet(OplusGLSurfaceView_13)) {
                set(OplusGLSurfaceView_13, settings.get(OplusGLSurfaceView_13));
            }
        }
    }
}
