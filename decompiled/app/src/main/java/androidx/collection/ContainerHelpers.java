package androidx.collection;

/* loaded from: classes.dex */
class ContainerHelpers {
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    public static int idealByteArraySize(int OplusGLSurfaceView_13) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (OplusGLSurfaceView_13 <= i3) {
                return i3;
            }
        }
        return OplusGLSurfaceView_13;
    }

    public static int idealIntArraySize(int OplusGLSurfaceView_13) {
        return idealByteArraySize(OplusGLSurfaceView_13 * 4) / 4;
    }

    public static int idealLongArraySize(int OplusGLSurfaceView_13) {
        return idealByteArraySize(OplusGLSurfaceView_13 * 8) / 8;
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int binarySearch(int[] iArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    static int binarySearch(long[] jArr, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        int i2 = OplusGLSurfaceView_13 - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < OplusGLSurfaceView_15) {
                i3 = i4 + 1;
            } else {
                if (j2 <= OplusGLSurfaceView_15) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    private ContainerHelpers() {
    }
}
