package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class InternalNano {
    protected static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
    protected static final java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.ISO_8859_1);
    public static final java.lang.Object LAZY_INIT_LOCK = new java.lang.Object();

    private InternalNano() {
    }

    public static java.lang.String stringDefaultValue(java.lang.String str) {
        return new java.lang.String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] bytesDefaultValue(java.lang.String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static byte[] copyFromUtf8(java.lang.String str) {
        return str.getBytes(UTF_8);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length == 0) {
            return iArr2 == null || iArr2.length == 0;
        }
        return java.util.Arrays.equals(iArr, iArr2);
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr == null || jArr.length == 0) {
            return jArr2 == null || jArr2.length == 0;
        }
        return java.util.Arrays.equals(jArr, jArr2);
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr.length == 0) {
            return fArr2 == null || fArr2.length == 0;
        }
        return java.util.Arrays.equals(fArr, fArr2);
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr.length == 0) {
            return dArr2 == null || dArr2.length == 0;
        }
        return java.util.Arrays.equals(dArr, dArr2);
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null || zArr.length == 0) {
            return zArr2 == null || zArr2.length == 0;
        }
        return java.util.Arrays.equals(zArr, zArr2);
    }

    public static boolean equals(byte[][] bArr, byte[][] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i_renamed = 0;
        int i2 = 0;
        while (true) {
            if (i_renamed >= length || bArr[i_renamed] != null) {
                while (i2 < length2 && bArr2[i2] == null) {
                    i2++;
                }
                boolean z_renamed = i_renamed >= length;
                boolean z2 = i2 >= length2;
                if (z_renamed && z2) {
                    return true;
                }
                if (z_renamed != z2 || !java.util.Arrays.equals(bArr[i_renamed], bArr2[i2])) {
                    return false;
                }
                i_renamed++;
                i2++;
            } else {
                i_renamed++;
            }
        }
    }

    public static boolean equals(java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i_renamed = 0;
        int i2 = 0;
        while (true) {
            if (i_renamed >= length || objArr[i_renamed] != null) {
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z_renamed = i_renamed >= length;
                boolean z2 = i2 >= length2;
                if (z_renamed && z2) {
                    return true;
                }
                if (z_renamed != z2 || !objArr[i_renamed].equals(objArr2[i2])) {
                    return false;
                }
                i_renamed++;
                i2++;
            } else {
                i_renamed++;
            }
        }
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return java.util.Arrays.hashCode(iArr);
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return java.util.Arrays.hashCode(jArr);
    }

    public static int hashCode(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return 0;
        }
        return java.util.Arrays.hashCode(fArr);
    }

    public static int hashCode(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return 0;
        }
        return java.util.Arrays.hashCode(dArr);
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr == null || zArr.length == 0) {
            return 0;
        }
        return java.util.Arrays.hashCode(zArr);
    }

    public static int hashCode(byte[][] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        int iHashCode = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            byte[] bArr2 = bArr[i_renamed];
            if (bArr2 != null) {
                iHashCode = (iHashCode * 31) + java.util.Arrays.hashCode(bArr2);
            }
        }
        return iHashCode;
    }

    public static int hashCode(java.lang.Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int iHashCode = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.Object obj = objArr[i_renamed];
            if (obj != null) {
                iHashCode = (iHashCode * 31) + obj.hashCode();
            }
        }
        return iHashCode;
    }

    public static void cloneUnknownFieldData(com.google.protobuf.nano.ExtendableMessageNano extendableMessageNano, com.google.protobuf.nano.ExtendableMessageNano extendableMessageNano2) {
        if (extendableMessageNano.unknownFieldData != null) {
            extendableMessageNano2.unknownFieldData = extendableMessageNano.unknownFieldData.m26clone();
        }
    }
}
