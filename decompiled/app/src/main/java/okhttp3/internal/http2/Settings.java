package okhttp3.internal.http2;

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
        java.util.Arrays.fill(this.values, 0);
    }

    okhttp3.internal.http2.Settings set(int i_renamed, int i2) {
        if (i_renamed >= 0) {
            int[] iArr = this.values;
            if (i_renamed < iArr.length) {
                this.set = (1 << i_renamed) | this.set;
                iArr[i_renamed] = i2;
            }
        }
        return this;
    }

    boolean isSet(int i_renamed) {
        return (this.set & (1 << i_renamed)) != 0;
    }

    int get(int i_renamed) {
        return this.values[i_renamed];
    }

    int size() {
        return java.lang.Integer.bitCount(this.set);
    }

    int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    boolean getEnablePush(boolean z_renamed) {
        return ((this.set & 4) != 0 ? this.values[2] : z_renamed ? 1 : 0) == 1;
    }

    int getMaxConcurrentStreams(int i_renamed) {
        return (this.set & 16) != 0 ? this.values[4] : i_renamed;
    }

    int getMaxFrameSize(int i_renamed) {
        return (this.set & 32) != 0 ? this.values[5] : i_renamed;
    }

    int getMaxHeaderListSize(int i_renamed) {
        return (this.set & 64) != 0 ? this.values[6] : i_renamed;
    }

    int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    void merge(okhttp3.internal.http2.Settings settings) {
        for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
            if (settings.isSet(i_renamed)) {
                set(i_renamed, settings.get(i_renamed));
            }
        }
    }
}
