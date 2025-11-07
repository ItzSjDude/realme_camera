package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class UnsafeUtil {
    static final boolean IS_BIG_ENDIAN;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
    private static final Unsafe UNSAFE = getUnsafe();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    static final long BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset(byte[].class);
    private static final long BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
    private static final long BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
    private static final long INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
    private static final long INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
    private static final long LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
    private static final long LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
    private static final long FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
    private static final long FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
    private static final long DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
    private static final long DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
    private static final long OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
    private static final long OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT = (int) (BYTE_ARRAY_BASE_OFFSET & 7);

    static {
        IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private UnsafeUtil() {
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8);
        }
    }

    static long objectFieldOffset(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    static byte getByte(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getByte(obj, OplusGLSurfaceView_15);
    }

    static void putByte(Object obj, long OplusGLSurfaceView_15, byte b2) {
        MEMORY_ACCESSOR.putByte(obj, OplusGLSurfaceView_15, b2);
    }

    static int getInt(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getInt(obj, OplusGLSurfaceView_15);
    }

    static void putInt(Object obj, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        MEMORY_ACCESSOR.putInt(obj, OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    static long getLong(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getLong(obj, OplusGLSurfaceView_15);
    }

    static void putLong(Object obj, long OplusGLSurfaceView_15, long j2) {
        MEMORY_ACCESSOR.putLong(obj, OplusGLSurfaceView_15, j2);
    }

    static boolean getBoolean(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getBoolean(obj, OplusGLSurfaceView_15);
    }

    static void putBoolean(Object obj, long OplusGLSurfaceView_15, boolean z) {
        MEMORY_ACCESSOR.putBoolean(obj, OplusGLSurfaceView_15, z);
    }

    static float getFloat(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getFloat(obj, OplusGLSurfaceView_15);
    }

    static void putFloat(Object obj, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
        MEMORY_ACCESSOR.putFloat(obj, OplusGLSurfaceView_15, COUIBaseListPopupWindow_12);
    }

    static double getDouble(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getDouble(obj, OplusGLSurfaceView_15);
    }

    static void putDouble(Object obj, long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5) {
        MEMORY_ACCESSOR.putDouble(obj, OplusGLSurfaceView_15, IntrinsicsJvm.kt_5);
    }

    static Object getObject(Object obj, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getObject(obj, OplusGLSurfaceView_15);
    }

    static void putObject(Object obj, long OplusGLSurfaceView_15, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, OplusGLSurfaceView_15, obj2);
    }

    static byte getByte(byte[] bArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + OplusGLSurfaceView_15);
    }

    static void putByte(byte[] bArr, long OplusGLSurfaceView_15, byte b2) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + OplusGLSurfaceView_15, b2);
    }

    static int getInt(int[] iArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * INT_ARRAY_INDEX_SCALE));
    }

    static void putInt(int[] iArr, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * INT_ARRAY_INDEX_SCALE), OplusGLSurfaceView_13);
    }

    static long getLong(long[] jArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * LONG_ARRAY_INDEX_SCALE));
    }

    static void putLong(long[] jArr, long OplusGLSurfaceView_15, long j2) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * LONG_ARRAY_INDEX_SCALE), j2);
    }

    static boolean getBoolean(boolean[] zArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    static void putBoolean(boolean[] zArr, long OplusGLSurfaceView_15, boolean z) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * BOOLEAN_ARRAY_INDEX_SCALE), z);
    }

    static float getFloat(float[] fArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * FLOAT_ARRAY_INDEX_SCALE));
    }

    static void putFloat(float[] fArr, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * FLOAT_ARRAY_INDEX_SCALE), COUIBaseListPopupWindow_12);
    }

    static double getDouble(double[] dArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static void putDouble(double[] dArr, long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * DOUBLE_ARRAY_INDEX_SCALE), IntrinsicsJvm.kt_5);
    }

    static Object getObject(Object[] objArr, long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * OBJECT_ARRAY_INDEX_SCALE));
    }

    static void putObject(Object[] objArr, long OplusGLSurfaceView_15, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (OplusGLSurfaceView_15 * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    static void copyMemory(byte[] bArr, long OplusGLSurfaceView_15, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(bArr, OplusGLSurfaceView_15, j2, j3);
    }

    static void copyMemory(long OplusGLSurfaceView_15, byte[] bArr, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(OplusGLSurfaceView_15, bArr, j2, j3);
    }

    static void copyMemory(byte[] bArr, long OplusGLSurfaceView_15, byte[] bArr2, long j2, long j3) {
        System.arraycopy(bArr, (int) OplusGLSurfaceView_15, bArr2, (int) j2, (int) j3);
    }

    static byte getByte(long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getByte(OplusGLSurfaceView_15);
    }

    static void putByte(long OplusGLSurfaceView_15, byte b2) {
        MEMORY_ACCESSOR.putByte(OplusGLSurfaceView_15, b2);
    }

    static int getInt(long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getInt(OplusGLSurfaceView_15);
    }

    static void putInt(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        MEMORY_ACCESSOR.putInt(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    static long getLong(long OplusGLSurfaceView_15) {
        return MEMORY_ACCESSOR.getLong(OplusGLSurfaceView_15);
    }

    static void putLong(long OplusGLSurfaceView_15, long j2) {
        MEMORY_ACCESSOR.putLong(OplusGLSurfaceView_15, j2);
    }

    static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    static Object getStaticObject(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws Exception {
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    private static MemoryAccessor getMemoryAccessor() {
        if (UNSAFE == null) {
            return null;
        }
        if (Android.isOnAndroidDevice()) {
            if (IS_ANDROID_64) {
                return new Android64MemoryAccessor(UNSAFE);
            }
            if (IS_ANDROID_32) {
                return new Android32MemoryAccessor(UNSAFE);
            }
            return null;
        }
        return new JvmMemoryAccessor(UNSAFE);
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (Android.isOnAndroidDevice()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (bufferAddressField() == null) {
                return false;
            }
            if (Android.isOnAndroidDevice()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls2 = MEMORY_CLASS;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static java.lang.reflect.Field bufferAddressField() {
        java.lang.reflect.Field field;
        if (Android.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        java.lang.reflect.Field field2 = field(Buffer.class, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    private static int firstDifferingByteIndexNativeEndian(long OplusGLSurfaceView_15, long j2) {
        int iNumberOfTrailingZeros;
        if (IS_BIG_ENDIAN) {
            iNumberOfTrailingZeros = Long.numberOfLeadingZeros(OplusGLSurfaceView_15 ^ j2);
        } else {
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(OplusGLSurfaceView_15 ^ j2);
        }
        return iNumberOfTrailingZeros >> 3;
    }

    static int mismatch(byte[] bArr, int OplusGLSurfaceView_13, byte[] bArr2, int i2, int i3) {
        if (OplusGLSurfaceView_13 < 0 || i2 < 0 || i3 < 0 || OplusGLSurfaceView_13 + i3 > bArr.length || i2 + i3 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            for (int i5 = (BYTE_ARRAY_ALIGNMENT + OplusGLSurfaceView_13) & 7; i4 < i3 && (i5 & 7) != 0; i5++) {
                if (bArr[OplusGLSurfaceView_13 + i4] != bArr2[i2 + i4]) {
                    return i4;
                }
                i4++;
            }
            int i6 = ((i3 - i4) & (-8)) + i4;
            while (i4 < i6) {
                long OplusGLSurfaceView_15 = i4;
                long j2 = getLong((Object) bArr, BYTE_ARRAY_BASE_OFFSET + OplusGLSurfaceView_13 + OplusGLSurfaceView_15);
                long j3 = getLong((Object) bArr2, BYTE_ARRAY_BASE_OFFSET + i2 + OplusGLSurfaceView_15);
                if (j2 != j3) {
                    return i4 + firstDifferingByteIndexNativeEndian(j2, j3);
                }
                i4 += 8;
            }
        }
        while (i4 < i3) {
            if (bArr[OplusGLSurfaceView_13 + i4] != bArr2[i2 + i4]) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private static long fieldOffset(java.lang.reflect.Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1L;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static java.lang.reflect.Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        public abstract void copyMemory(long OplusGLSurfaceView_15, byte[] bArr, long j2, long j3);

        public abstract void copyMemory(byte[] bArr, long OplusGLSurfaceView_15, long j2, long j3);

        public abstract boolean getBoolean(Object obj, long OplusGLSurfaceView_15);

        public abstract byte getByte(long OplusGLSurfaceView_15);

        public abstract byte getByte(Object obj, long OplusGLSurfaceView_15);

        public abstract double getDouble(Object obj, long OplusGLSurfaceView_15);

        public abstract float getFloat(Object obj, long OplusGLSurfaceView_15);

        public abstract int getInt(long OplusGLSurfaceView_15);

        public abstract long getLong(long OplusGLSurfaceView_15);

        public abstract Object getStaticObject(java.lang.reflect.Field field);

        public abstract void putBoolean(Object obj, long OplusGLSurfaceView_15, boolean z);

        public abstract void putByte(long OplusGLSurfaceView_15, byte b2);

        public abstract void putByte(Object obj, long OplusGLSurfaceView_15, byte b2);

        public abstract void putDouble(Object obj, long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5);

        public abstract void putFloat(Object obj, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

        public abstract void putInt(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

        public abstract void putLong(long OplusGLSurfaceView_15, long j2);

        MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final long objectFieldOffset(java.lang.reflect.Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public final int getInt(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getInt(obj, OplusGLSurfaceView_15);
        }

        public final void putInt(Object obj, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            this.unsafe.putInt(obj, OplusGLSurfaceView_15, OplusGLSurfaceView_13);
        }

        public final long getLong(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getLong(obj, OplusGLSurfaceView_15);
        }

        public final void putLong(Object obj, long OplusGLSurfaceView_15, long j2) {
            this.unsafe.putLong(obj, OplusGLSurfaceView_15, j2);
        }

        public final Object getObject(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getObject(obj, OplusGLSurfaceView_15);
        }

        public final void putObject(Object obj, long OplusGLSurfaceView_15, Object obj2) {
            this.unsafe.putObject(obj, OplusGLSurfaceView_15, obj2);
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long OplusGLSurfaceView_15) {
            return this.unsafe.getByte(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long OplusGLSurfaceView_15, byte b2) {
            this.unsafe.putByte(OplusGLSurfaceView_15, b2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long OplusGLSurfaceView_15) {
            return this.unsafe.getInt(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            this.unsafe.putInt(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long OplusGLSurfaceView_15) {
            return this.unsafe.getLong(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long OplusGLSurfaceView_15, long j2) {
            this.unsafe.putLong(OplusGLSurfaceView_15, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getByte(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long OplusGLSurfaceView_15, byte b2) {
            this.unsafe.putByte(obj, OplusGLSurfaceView_15, b2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getBoolean(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long OplusGLSurfaceView_15, boolean z) {
            this.unsafe.putBoolean(obj, OplusGLSurfaceView_15, z);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getFloat(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
            this.unsafe.putFloat(obj, OplusGLSurfaceView_15, COUIBaseListPopupWindow_12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long OplusGLSurfaceView_15) {
            return this.unsafe.getDouble(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5) {
            this.unsafe.putDouble(obj, OplusGLSurfaceView_15, IntrinsicsJvm.kt_5);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long OplusGLSurfaceView_15, byte[] bArr, long j2, long j3) {
            this.unsafe.copyMemory((Object) null, OplusGLSurfaceView_15, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j2, j3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long OplusGLSurfaceView_15, long j2, long j3) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + OplusGLSurfaceView_15, (Object) null, j2, j3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long OplusGLSurfaceView_15) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long OplusGLSurfaceView_15, byte b2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long OplusGLSurfaceView_15) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long OplusGLSurfaceView_15) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long OplusGLSurfaceView_15, long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long OplusGLSurfaceView_15) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(obj, OplusGLSurfaceView_15) : UnsafeUtil.getByteLittleEndian(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long OplusGLSurfaceView_15, byte b2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, OplusGLSurfaceView_15, b2);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, OplusGLSurfaceView_15, b2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long OplusGLSurfaceView_15) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, OplusGLSurfaceView_15) : UnsafeUtil.getBooleanLittleEndian(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long OplusGLSurfaceView_15, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, OplusGLSurfaceView_15, z);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, OplusGLSurfaceView_15, z);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long OplusGLSurfaceView_15) {
            return Float.intBitsToFloat(getInt(obj, OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
            putInt(obj, OplusGLSurfaceView_15, Float.floatToIntBits(COUIBaseListPopupWindow_12));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long OplusGLSurfaceView_15) {
            return Double.longBitsToDouble(getLong(obj, OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5) {
            putLong(obj, OplusGLSurfaceView_15, Double.doubleToLongBits(IntrinsicsJvm.kt_5));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long OplusGLSurfaceView_15, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long OplusGLSurfaceView_15, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
    }

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        private static int smallAddress(long OplusGLSurfaceView_15) {
            return (int) (OplusGLSurfaceView_15 & (-1));
        }

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long OplusGLSurfaceView_15) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long OplusGLSurfaceView_15, byte b2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long OplusGLSurfaceView_15) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long OplusGLSurfaceView_15) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long OplusGLSurfaceView_15, long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long OplusGLSurfaceView_15) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(obj, OplusGLSurfaceView_15) : UnsafeUtil.getByteLittleEndian(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long OplusGLSurfaceView_15, byte b2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, OplusGLSurfaceView_15, b2);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, OplusGLSurfaceView_15, b2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long OplusGLSurfaceView_15) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, OplusGLSurfaceView_15) : UnsafeUtil.getBooleanLittleEndian(obj, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long OplusGLSurfaceView_15, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, OplusGLSurfaceView_15, z);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, OplusGLSurfaceView_15, z);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long OplusGLSurfaceView_15) {
            return Float.intBitsToFloat(getInt(obj, OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
            putInt(obj, OplusGLSurfaceView_15, Float.floatToIntBits(COUIBaseListPopupWindow_12));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long OplusGLSurfaceView_15) {
            return Double.longBitsToDouble(getLong(obj, OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5) {
            putLong(obj, OplusGLSurfaceView_15, Double.doubleToLongBits(IntrinsicsJvm.kt_5));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long OplusGLSurfaceView_15, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long OplusGLSurfaceView_15, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long OplusGLSurfaceView_15) {
        return (byte) ((getInt(obj, (-4) & OplusGLSurfaceView_15) >>> ((int) (((~OplusGLSurfaceView_15) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long OplusGLSurfaceView_15) {
        return (byte) ((getInt(obj, (-4) & OplusGLSurfaceView_15) >>> ((int) ((OplusGLSurfaceView_15 & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long OplusGLSurfaceView_15, byte b2) {
        long j2 = (-4) & OplusGLSurfaceView_15;
        int OplusGLSurfaceView_13 = getInt(obj, j2);
        int i2 = ((~((int) OplusGLSurfaceView_15)) & 3) << 3;
        putInt(obj, j2, ((255 & b2) << i2) | (OplusGLSurfaceView_13 & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long OplusGLSurfaceView_15, byte b2) {
        long j2 = (-4) & OplusGLSurfaceView_15;
        int OplusGLSurfaceView_13 = (((int) OplusGLSurfaceView_15) & 3) << 3;
        putInt(obj, j2, ((255 & b2) << OplusGLSurfaceView_13) | (getInt(obj, j2) & (~(255 << OplusGLSurfaceView_13))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long OplusGLSurfaceView_15) {
        return getByteBigEndian(obj, OplusGLSurfaceView_15) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long OplusGLSurfaceView_15) {
        return getByteLittleEndian(obj, OplusGLSurfaceView_15) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long OplusGLSurfaceView_15, boolean z) {
        putByteBigEndian(obj, OplusGLSurfaceView_15, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long OplusGLSurfaceView_15, boolean z) {
        putByteLittleEndian(obj, OplusGLSurfaceView_15, z ? (byte) 1 : (byte) 0);
    }
}
