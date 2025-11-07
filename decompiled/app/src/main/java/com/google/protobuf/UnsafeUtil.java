package com.google.protobuf;

/* loaded from: classes.dex */
final class UnsafeUtil {
    static final boolean IS_BIG_ENDIAN;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(com.google.protobuf.UnsafeUtil.class.getName());
    private static final sun.misc.Unsafe UNSAFE = getUnsafe();
    private static final java.lang.Class<?> MEMORY_CLASS = com.google.protobuf.Android.getMemoryClass();
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(java.lang.Long.TYPE);
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(java.lang.Integer.TYPE);
    private static final com.google.protobuf.UnsafeUtil.MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
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
    private static final long OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(java.lang.Object[].class);
    private static final long OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(java.lang.Object[].class);
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT = (int) (BYTE_ARRAY_BASE_OFFSET & 7);

    static {
        IS_BIG_ENDIAN = java.nio.ByteOrder.nativeOrder() == java.nio.ByteOrder.BIG_ENDIAN;
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

    static <T_renamed> T_renamed allocateInstance(java.lang.Class<T_renamed> cls) {
        try {
            return (T_renamed) UNSAFE.allocateInstance(cls);
        } catch (java.lang.InstantiationException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed);
        }
    }

    static long objectFieldOffset(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    private static int arrayBaseOffset(java.lang.Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(java.lang.Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    static byte getByte(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getByte(obj, j_renamed);
    }

    static void putByte(java.lang.Object obj, long j_renamed, byte b2) {
        MEMORY_ACCESSOR.putByte(obj, j_renamed, b2);
    }

    static int getInt(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getInt(obj, j_renamed);
    }

    static void putInt(java.lang.Object obj, long j_renamed, int i_renamed) {
        MEMORY_ACCESSOR.putInt(obj, j_renamed, i_renamed);
    }

    static long getLong(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getLong(obj, j_renamed);
    }

    static void putLong(java.lang.Object obj, long j_renamed, long j2) {
        MEMORY_ACCESSOR.putLong(obj, j_renamed, j2);
    }

    static boolean getBoolean(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getBoolean(obj, j_renamed);
    }

    static void putBoolean(java.lang.Object obj, long j_renamed, boolean z_renamed) {
        MEMORY_ACCESSOR.putBoolean(obj, j_renamed, z_renamed);
    }

    static float getFloat(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getFloat(obj, j_renamed);
    }

    static void putFloat(java.lang.Object obj, long j_renamed, float f_renamed) {
        MEMORY_ACCESSOR.putFloat(obj, j_renamed, f_renamed);
    }

    static double getDouble(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getDouble(obj, j_renamed);
    }

    static void putDouble(java.lang.Object obj, long j_renamed, double d_renamed) {
        MEMORY_ACCESSOR.putDouble(obj, j_renamed, d_renamed);
    }

    static java.lang.Object getObject(java.lang.Object obj, long j_renamed) {
        return MEMORY_ACCESSOR.getObject(obj, j_renamed);
    }

    static void putObject(java.lang.Object obj, long j_renamed, java.lang.Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j_renamed, obj2);
    }

    static byte getByte(byte[] bArr, long j_renamed) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j_renamed);
    }

    static void putByte(byte[] bArr, long j_renamed, byte b2) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j_renamed, b2);
    }

    static int getInt(int[] iArr, long j_renamed) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j_renamed * INT_ARRAY_INDEX_SCALE));
    }

    static void putInt(int[] iArr, long j_renamed, int i_renamed) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j_renamed * INT_ARRAY_INDEX_SCALE), i_renamed);
    }

    static long getLong(long[] jArr, long j_renamed) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j_renamed * LONG_ARRAY_INDEX_SCALE));
    }

    static void putLong(long[] jArr, long j_renamed, long j2) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (j_renamed * LONG_ARRAY_INDEX_SCALE), j2);
    }

    static boolean getBoolean(boolean[] zArr, long j_renamed) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j_renamed * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    static void putBoolean(boolean[] zArr, long j_renamed, boolean z_renamed) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j_renamed * BOOLEAN_ARRAY_INDEX_SCALE), z_renamed);
    }

    static float getFloat(float[] fArr, long j_renamed) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j_renamed * FLOAT_ARRAY_INDEX_SCALE));
    }

    static void putFloat(float[] fArr, long j_renamed, float f_renamed) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j_renamed * FLOAT_ARRAY_INDEX_SCALE), f_renamed);
    }

    static double getDouble(double[] dArr, long j_renamed) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j_renamed * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static void putDouble(double[] dArr, long j_renamed, double d_renamed) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j_renamed * DOUBLE_ARRAY_INDEX_SCALE), d_renamed);
    }

    static java.lang.Object getObject(java.lang.Object[] objArr, long j_renamed) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j_renamed * OBJECT_ARRAY_INDEX_SCALE));
    }

    static void putObject(java.lang.Object[] objArr, long j_renamed, java.lang.Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j_renamed * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    static void copyMemory(byte[] bArr, long j_renamed, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(bArr, j_renamed, j2, j3);
    }

    static void copyMemory(long j_renamed, byte[] bArr, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(j_renamed, bArr, j2, j3);
    }

    static void copyMemory(byte[] bArr, long j_renamed, byte[] bArr2, long j2, long j3) {
        java.lang.System.arraycopy(bArr, (int) j_renamed, bArr2, (int) j2, (int) j3);
    }

    static byte getByte(long j_renamed) {
        return MEMORY_ACCESSOR.getByte(j_renamed);
    }

    static void putByte(long j_renamed, byte b2) {
        MEMORY_ACCESSOR.putByte(j_renamed, b2);
    }

    static int getInt(long j_renamed) {
        return MEMORY_ACCESSOR.getInt(j_renamed);
    }

    static void putInt(long j_renamed, int i_renamed) {
        MEMORY_ACCESSOR.putInt(j_renamed, i_renamed);
    }

    static long getLong(long j_renamed) {
        return MEMORY_ACCESSOR.getLong(j_renamed);
    }

    static void putLong(long j_renamed, long j2) {
        MEMORY_ACCESSOR.putLong(j_renamed, j2);
    }

    static long addressOffset(java.nio.ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    static java.lang.Object getStaticObject(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static sun.misc.Unsafe getUnsafe() {
        try {
            return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new java.security.PrivilegedExceptionAction<sun.misc.Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public sun.misc.Unsafe run() throws java.lang.Exception {
                    for (java.lang.reflect.Field field : sun.misc.Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        java.lang.Object obj = field.get(null);
                        if (sun.misc.Unsafe.class.isInstance(obj)) {
                            return (sun.misc.Unsafe) sun.misc.Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static com.google.protobuf.UnsafeUtil.MemoryAccessor getMemoryAccessor() {
        if (UNSAFE == null) {
            return null;
        }
        if (com.google.protobuf.Android.isOnAndroidDevice()) {
            if (IS_ANDROID_64) {
                return new com.google.protobuf.UnsafeUtil.Android64MemoryAccessor(UNSAFE);
            }
            if (IS_ANDROID_32) {
                return new com.google.protobuf.UnsafeUtil.Android32MemoryAccessor(UNSAFE);
            }
            return null;
        }
        return new com.google.protobuf.UnsafeUtil.JvmMemoryAccessor(UNSAFE);
    }

    private static boolean supportsUnsafeArrayOperations() {
        sun.misc.Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            java.lang.Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
            cls.getMethod("arrayBaseOffset", java.lang.Class.class);
            cls.getMethod("arrayIndexScale", java.lang.Class.class);
            cls.getMethod("getInt", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putInt", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Integer.TYPE);
            cls.getMethod("getLong", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putLong", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Long.TYPE);
            cls.getMethod("getObject", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putObject", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Object.class);
            if (com.google.protobuf.Android.isOnAndroidDevice()) {
                return true;
            }
            cls.getMethod("getByte", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putByte", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Byte.TYPE);
            cls.getMethod("getBoolean", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putBoolean", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Boolean.TYPE);
            cls.getMethod("getFloat", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putFloat", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Float.TYPE);
            cls.getMethod("getDouble", java.lang.Object.class, java.lang.Long.TYPE);
            cls.getMethod("putDouble", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Double.TYPE);
            return true;
        } catch (java.lang.Throwable th) {
            logger.log(java.util.logging.Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        sun.misc.Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            java.lang.Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
            cls.getMethod("getLong", java.lang.Object.class, java.lang.Long.TYPE);
            if (bufferAddressField() == null) {
                return false;
            }
            if (com.google.protobuf.Android.isOnAndroidDevice()) {
                return true;
            }
            cls.getMethod("getByte", java.lang.Long.TYPE);
            cls.getMethod("putByte", java.lang.Long.TYPE, java.lang.Byte.TYPE);
            cls.getMethod("getInt", java.lang.Long.TYPE);
            cls.getMethod("putInt", java.lang.Long.TYPE, java.lang.Integer.TYPE);
            cls.getMethod("getLong", java.lang.Long.TYPE);
            cls.getMethod("putLong", java.lang.Long.TYPE, java.lang.Long.TYPE);
            cls.getMethod("copyMemory", java.lang.Long.TYPE, java.lang.Long.TYPE, java.lang.Long.TYPE);
            cls.getMethod("copyMemory", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Object.class, java.lang.Long.TYPE, java.lang.Long.TYPE);
            return true;
        } catch (java.lang.Throwable th) {
            logger.log(java.util.logging.Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean determineAndroidSupportByAddressSize(java.lang.Class<?> cls) {
        if (!com.google.protobuf.Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            java.lang.Class<?> cls2 = MEMORY_CLASS;
            cls2.getMethod("peekLong", cls, java.lang.Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, java.lang.Long.TYPE, java.lang.Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, java.lang.Integer.TYPE, java.lang.Boolean.TYPE);
            cls2.getMethod("peekInt", cls, java.lang.Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, java.lang.Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, java.lang.Integer.TYPE, java.lang.Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, java.lang.Integer.TYPE, java.lang.Integer.TYPE);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static java.lang.reflect.Field bufferAddressField() {
        java.lang.reflect.Field field;
        if (com.google.protobuf.Android.isOnAndroidDevice() && (field = field(java.nio.Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        java.lang.reflect.Field field2 = field(java.nio.Buffer.class, "address");
        if (field2 == null || field2.getType() != java.lang.Long.TYPE) {
            return null;
        }
        return field2;
    }

    private static int firstDifferingByteIndexNativeEndian(long j_renamed, long j2) {
        int iNumberOfTrailingZeros;
        if (IS_BIG_ENDIAN) {
            iNumberOfTrailingZeros = java.lang.Long.numberOfLeadingZeros(j_renamed ^ j2);
        } else {
            iNumberOfTrailingZeros = java.lang.Long.numberOfTrailingZeros(j_renamed ^ j2);
        }
        return iNumberOfTrailingZeros >> 3;
    }

    static int mismatch(byte[] bArr, int i_renamed, byte[] bArr2, int i2, int i3) {
        if (i_renamed < 0 || i2 < 0 || i3 < 0 || i_renamed + i3 > bArr.length || i2 + i3 > bArr2.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            for (int i5 = (BYTE_ARRAY_ALIGNMENT + i_renamed) & 7; i4 < i3 && (i5 & 7) != 0; i5++) {
                if (bArr[i_renamed + i4] != bArr2[i2 + i4]) {
                    return i4;
                }
                i4++;
            }
            int i6 = ((i3 - i4) & (-8)) + i4;
            while (i4 < i6) {
                long j_renamed = i4;
                long j2 = getLong((java.lang.Object) bArr, BYTE_ARRAY_BASE_OFFSET + i_renamed + j_renamed);
                long j3 = getLong((java.lang.Object) bArr2, BYTE_ARRAY_BASE_OFFSET + i2 + j_renamed);
                if (j2 != j3) {
                    return i4 + firstDifferingByteIndexNativeEndian(j2, j3);
                }
                i4 += 8;
            }
        }
        while (i4 < i3) {
            if (bArr[i_renamed + i4] != bArr2[i2 + i4]) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private static long fieldOffset(java.lang.reflect.Field field) {
        com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1L;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static java.lang.reflect.Field field(java.lang.Class<?> cls, java.lang.String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static abstract class MemoryAccessor {
        sun.misc.Unsafe unsafe;

        public abstract void copyMemory(long j_renamed, byte[] bArr, long j2, long j3);

        public abstract void copyMemory(byte[] bArr, long j_renamed, long j2, long j3);

        public abstract boolean getBoolean(java.lang.Object obj, long j_renamed);

        public abstract byte getByte(long j_renamed);

        public abstract byte getByte(java.lang.Object obj, long j_renamed);

        public abstract double getDouble(java.lang.Object obj, long j_renamed);

        public abstract float getFloat(java.lang.Object obj, long j_renamed);

        public abstract int getInt(long j_renamed);

        public abstract long getLong(long j_renamed);

        public abstract java.lang.Object getStaticObject(java.lang.reflect.Field field);

        public abstract void putBoolean(java.lang.Object obj, long j_renamed, boolean z_renamed);

        public abstract void putByte(long j_renamed, byte b2);

        public abstract void putByte(java.lang.Object obj, long j_renamed, byte b2);

        public abstract void putDouble(java.lang.Object obj, long j_renamed, double d_renamed);

        public abstract void putFloat(java.lang.Object obj, long j_renamed, float f_renamed);

        public abstract void putInt(long j_renamed, int i_renamed);

        public abstract void putLong(long j_renamed, long j2);

        MemoryAccessor(sun.misc.Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final long objectFieldOffset(java.lang.reflect.Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public final int getInt(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getInt(obj, j_renamed);
        }

        public final void putInt(java.lang.Object obj, long j_renamed, int i_renamed) {
            this.unsafe.putInt(obj, j_renamed, i_renamed);
        }

        public final long getLong(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getLong(obj, j_renamed);
        }

        public final void putLong(java.lang.Object obj, long j_renamed, long j2) {
            this.unsafe.putLong(obj, j_renamed, j2);
        }

        public final java.lang.Object getObject(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getObject(obj, j_renamed);
        }

        public final void putObject(java.lang.Object obj, long j_renamed, java.lang.Object obj2) {
            this.unsafe.putObject(obj, j_renamed, obj2);
        }

        public final int arrayBaseOffset(java.lang.Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(java.lang.Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }
    }

    private static final class JvmMemoryAccessor extends com.google.protobuf.UnsafeUtil.MemoryAccessor {
        JvmMemoryAccessor(sun.misc.Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j_renamed) {
            return this.unsafe.getByte(j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j_renamed, byte b2) {
            this.unsafe.putByte(j_renamed, b2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j_renamed) {
            return this.unsafe.getInt(j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j_renamed, int i_renamed) {
            this.unsafe.putInt(j_renamed, i_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j_renamed) {
            return this.unsafe.getLong(j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j_renamed, long j2) {
            this.unsafe.putLong(j_renamed, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getByte(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(java.lang.Object obj, long j_renamed, byte b2) {
            this.unsafe.putByte(obj, j_renamed, b2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getBoolean(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(java.lang.Object obj, long j_renamed, boolean z_renamed) {
            this.unsafe.putBoolean(obj, j_renamed, z_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getFloat(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(java.lang.Object obj, long j_renamed, float f_renamed) {
            this.unsafe.putFloat(obj, j_renamed, f_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(java.lang.Object obj, long j_renamed) {
            return this.unsafe.getDouble(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(java.lang.Object obj, long j_renamed, double d_renamed) {
            this.unsafe.putDouble(obj, j_renamed, d_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j_renamed, byte[] bArr, long j2, long j3) {
            this.unsafe.copyMemory((java.lang.Object) null, j_renamed, bArr, com.google.protobuf.UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j2, j3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j_renamed, long j2, long j3) {
            this.unsafe.copyMemory(bArr, com.google.protobuf.UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j_renamed, (java.lang.Object) null, j2, j3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public java.lang.Object getStaticObject(java.lang.reflect.Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }
    }

    private static final class Android64MemoryAccessor extends com.google.protobuf.UnsafeUtil.MemoryAccessor {
        Android64MemoryAccessor(sun.misc.Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j_renamed, byte b2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j_renamed, int i_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j_renamed, long j2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(java.lang.Object obj, long j_renamed) {
            return com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN ? com.google.protobuf.UnsafeUtil.getByteBigEndian(obj, j_renamed) : com.google.protobuf.UnsafeUtil.getByteLittleEndian(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(java.lang.Object obj, long j_renamed, byte b2) {
            if (com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN) {
                com.google.protobuf.UnsafeUtil.putByteBigEndian(obj, j_renamed, b2);
            } else {
                com.google.protobuf.UnsafeUtil.putByteLittleEndian(obj, j_renamed, b2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(java.lang.Object obj, long j_renamed) {
            return com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN ? com.google.protobuf.UnsafeUtil.getBooleanBigEndian(obj, j_renamed) : com.google.protobuf.UnsafeUtil.getBooleanLittleEndian(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(java.lang.Object obj, long j_renamed, boolean z_renamed) {
            if (com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN) {
                com.google.protobuf.UnsafeUtil.putBooleanBigEndian(obj, j_renamed, z_renamed);
            } else {
                com.google.protobuf.UnsafeUtil.putBooleanLittleEndian(obj, j_renamed, z_renamed);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(java.lang.Object obj, long j_renamed) {
            return java.lang.Float.intBitsToFloat(getInt(obj, j_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(java.lang.Object obj, long j_renamed, float f_renamed) {
            putInt(obj, j_renamed, java.lang.Float.floatToIntBits(f_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(java.lang.Object obj, long j_renamed) {
            return java.lang.Double.longBitsToDouble(getLong(obj, j_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(java.lang.Object obj, long j_renamed, double d_renamed) {
            putLong(obj, j_renamed, java.lang.Double.doubleToLongBits(d_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j_renamed, byte[] bArr, long j2, long j3) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j_renamed, long j2, long j3) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public java.lang.Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (java.lang.IllegalAccessException unused) {
                return null;
            }
        }
    }

    private static final class Android32MemoryAccessor extends com.google.protobuf.UnsafeUtil.MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        private static int smallAddress(long j_renamed) {
            return (int) (j_renamed & (-1));
        }

        Android32MemoryAccessor(sun.misc.Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j_renamed, byte b2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j_renamed, int i_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j_renamed, long j2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(java.lang.Object obj, long j_renamed) {
            return com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN ? com.google.protobuf.UnsafeUtil.getByteBigEndian(obj, j_renamed) : com.google.protobuf.UnsafeUtil.getByteLittleEndian(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(java.lang.Object obj, long j_renamed, byte b2) {
            if (com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN) {
                com.google.protobuf.UnsafeUtil.putByteBigEndian(obj, j_renamed, b2);
            } else {
                com.google.protobuf.UnsafeUtil.putByteLittleEndian(obj, j_renamed, b2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(java.lang.Object obj, long j_renamed) {
            return com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN ? com.google.protobuf.UnsafeUtil.getBooleanBigEndian(obj, j_renamed) : com.google.protobuf.UnsafeUtil.getBooleanLittleEndian(obj, j_renamed);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(java.lang.Object obj, long j_renamed, boolean z_renamed) {
            if (com.google.protobuf.UnsafeUtil.IS_BIG_ENDIAN) {
                com.google.protobuf.UnsafeUtil.putBooleanBigEndian(obj, j_renamed, z_renamed);
            } else {
                com.google.protobuf.UnsafeUtil.putBooleanLittleEndian(obj, j_renamed, z_renamed);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(java.lang.Object obj, long j_renamed) {
            return java.lang.Float.intBitsToFloat(getInt(obj, j_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(java.lang.Object obj, long j_renamed, float f_renamed) {
            putInt(obj, j_renamed, java.lang.Float.floatToIntBits(f_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(java.lang.Object obj, long j_renamed) {
            return java.lang.Double.longBitsToDouble(getLong(obj, j_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(java.lang.Object obj, long j_renamed, double d_renamed) {
            putLong(obj, j_renamed, java.lang.Double.doubleToLongBits(d_renamed));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j_renamed, byte[] bArr, long j2, long j3) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j_renamed, long j2, long j3) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public java.lang.Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (java.lang.IllegalAccessException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteBigEndian(java.lang.Object obj, long j_renamed) {
        return (byte) ((getInt(obj, (-4) & j_renamed) >>> ((int) (((~j_renamed) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteLittleEndian(java.lang.Object obj, long j_renamed) {
        return (byte) ((getInt(obj, (-4) & j_renamed) >>> ((int) ((j_renamed & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteBigEndian(java.lang.Object obj, long j_renamed, byte b2) {
        long j2 = (-4) & j_renamed;
        int i_renamed = getInt(obj, j2);
        int i2 = ((~((int) j_renamed)) & 3) << 3;
        putInt(obj, j2, ((255 & b2) << i2) | (i_renamed & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteLittleEndian(java.lang.Object obj, long j_renamed, byte b2) {
        long j2 = (-4) & j_renamed;
        int i_renamed = (((int) j_renamed) & 3) << 3;
        putInt(obj, j2, ((255 & b2) << i_renamed) | (getInt(obj, j2) & (~(255 << i_renamed))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanBigEndian(java.lang.Object obj, long j_renamed) {
        return getByteBigEndian(obj, j_renamed) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(java.lang.Object obj, long j_renamed) {
        return getByteLittleEndian(obj, j_renamed) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanBigEndian(java.lang.Object obj, long j_renamed, boolean z_renamed) {
        putByteBigEndian(obj, j_renamed, z_renamed ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanLittleEndian(java.lang.Object obj, long j_renamed, boolean z_renamed) {
        putByteLittleEndian(obj, j_renamed, z_renamed ? (byte) 1 : (byte) 0);
    }
}
