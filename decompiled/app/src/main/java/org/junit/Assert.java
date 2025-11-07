package org.junit;

/* loaded from: classes2.dex */
public class Assert {
    protected Assert() {
    }

    public static void assertTrue(java.lang.String str, boolean z_renamed) {
        if (z_renamed) {
            return;
        }
        fail(str);
    }

    public static void assertTrue(boolean z_renamed) {
        assertTrue(null, z_renamed);
    }

    public static void assertFalse(java.lang.String str, boolean z_renamed) {
        assertTrue(str, !z_renamed);
    }

    public static void assertFalse(boolean z_renamed) {
        assertFalse(null, z_renamed);
    }

    public static void fail(java.lang.String str) {
        if (str == null) {
            throw new java.lang.AssertionError();
        }
        throw new java.lang.AssertionError(str);
    }

    public static void fail() {
        fail(null);
    }

    public static void assertEquals(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            return;
        }
        if ((obj instanceof java.lang.String) && (obj2 instanceof java.lang.String)) {
            if (str == null) {
                str = "";
            }
            throw new org.junit.ComparisonFailure(str, (java.lang.String) obj, (java.lang.String) obj2);
        }
        failNotEquals(str, obj, obj2);
    }

    private static boolean equalsRegardingNull(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return isEquals(obj, obj2);
    }

    private static boolean isEquals(java.lang.Object obj, java.lang.Object obj2) {
        return obj.equals(obj2);
    }

    public static void assertEquals(java.lang.Object obj, java.lang.Object obj2) {
        assertEquals((java.lang.String) null, obj, obj2);
    }

    public static void assertNotEquals(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            failEquals(str, obj2);
        }
    }

    public static void assertNotEquals(java.lang.Object obj, java.lang.Object obj2) {
        assertNotEquals((java.lang.String) null, obj, obj2);
    }

    private static void failEquals(java.lang.String str, java.lang.Object obj) {
        java.lang.String str2;
        if (str != null) {
            str2 = str + ". ";
        } else {
            str2 = "Values should be_renamed different. ";
        }
        fail(str2 + "Actual: " + obj);
    }

    public static void assertNotEquals(java.lang.String str, long j_renamed, long j2) {
        if (j_renamed == j2) {
            failEquals(str, java.lang.Long.valueOf(j2));
        }
    }

    public static void assertNotEquals(long j_renamed, long j2) {
        assertNotEquals((java.lang.String) null, j_renamed, j2);
    }

    public static void assertNotEquals(java.lang.String str, double d_renamed, double d2, double d3) {
        if (doubleIsDifferent(d_renamed, d2, d3)) {
            return;
        }
        failEquals(str, java.lang.Double.valueOf(d2));
    }

    public static void assertNotEquals(double d_renamed, double d2, double d3) {
        assertNotEquals((java.lang.String) null, d_renamed, d2, d3);
    }

    public static void assertNotEquals(float f_renamed, float f2, float f3) {
        assertNotEquals((java.lang.String) null, f_renamed, f2, f3);
    }

    public static void assertArrayEquals(java.lang.String str, java.lang.Object[] objArr, java.lang.Object[] objArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, objArr, objArr2);
    }

    public static void assertArrayEquals(java.lang.Object[] objArr, java.lang.Object[] objArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, objArr, objArr2);
    }

    public static void assertArrayEquals(java.lang.String str, boolean[] zArr, boolean[] zArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, zArr, zArr2);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, zArr, zArr2);
    }

    public static void assertArrayEquals(java.lang.String str, byte[] bArr, byte[] bArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, bArr, bArr2);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, bArr, bArr2);
    }

    public static void assertArrayEquals(java.lang.String str, char[] cArr, char[] cArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, cArr, cArr2);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, cArr, cArr2);
    }

    public static void assertArrayEquals(java.lang.String str, short[] sArr, short[] sArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, sArr, sArr2);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, sArr, sArr2);
    }

    public static void assertArrayEquals(java.lang.String str, int[] iArr, int[] iArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, iArr, iArr2);
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, iArr, iArr2);
    }

    public static void assertArrayEquals(java.lang.String str, long[] jArr, long[] jArr2) throws org.junit.internal.ArrayComparisonFailure {
        internalArrayEquals(str, jArr, jArr2);
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, jArr, jArr2);
    }

    public static void assertArrayEquals(java.lang.String str, double[] dArr, double[] dArr2, double d_renamed) throws org.junit.internal.ArrayComparisonFailure {
        new org.junit.internal.InexactComparisonCriteria(d_renamed).arrayEquals(str, dArr, dArr2);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d_renamed) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, dArr, dArr2, d_renamed);
    }

    public static void assertArrayEquals(java.lang.String str, float[] fArr, float[] fArr2, float f_renamed) throws org.junit.internal.ArrayComparisonFailure {
        new org.junit.internal.InexactComparisonCriteria(f_renamed).arrayEquals(str, fArr, fArr2);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f_renamed) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals((java.lang.String) null, fArr, fArr2, f_renamed);
    }

    private static void internalArrayEquals(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) throws org.junit.internal.ArrayComparisonFailure {
        new org.junit.internal.ExactComparisonCriteria().arrayEquals(str, obj, obj2);
    }

    public static void assertEquals(java.lang.String str, double d_renamed, double d2, double d3) {
        if (doubleIsDifferent(d_renamed, d2, d3)) {
            failNotEquals(str, java.lang.Double.valueOf(d_renamed), java.lang.Double.valueOf(d2));
        }
    }

    public static void assertEquals(java.lang.String str, float f_renamed, float f2, float f3) {
        if (floatIsDifferent(f_renamed, f2, f3)) {
            failNotEquals(str, java.lang.Float.valueOf(f_renamed), java.lang.Float.valueOf(f2));
        }
    }

    public static void assertNotEquals(java.lang.String str, float f_renamed, float f2, float f3) {
        if (floatIsDifferent(f_renamed, f2, f3)) {
            return;
        }
        failEquals(str, java.lang.Float.valueOf(f2));
    }

    private static boolean doubleIsDifferent(double d_renamed, double d2, double d3) {
        return java.lang.Double.compare(d_renamed, d2) != 0 && java.lang.Math.abs(d_renamed - d2) > d3;
    }

    private static boolean floatIsDifferent(float f_renamed, float f2, float f3) {
        return java.lang.Float.compare(f_renamed, f2) != 0 && java.lang.Math.abs(f_renamed - f2) > f3;
    }

    public static void assertEquals(long j_renamed, long j2) {
        assertEquals((java.lang.String) null, j_renamed, j2);
    }

    public static void assertEquals(java.lang.String str, long j_renamed, long j2) {
        if (j_renamed != j2) {
            failNotEquals(str, java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(j2));
        }
    }

    @java.lang.Deprecated
    public static void assertEquals(double d_renamed, double d2) {
        assertEquals((java.lang.String) null, d_renamed, d2);
    }

    @java.lang.Deprecated
    public static void assertEquals(java.lang.String str, double d_renamed, double d2) {
        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertEquals(double d_renamed, double d2, double d3) {
        assertEquals((java.lang.String) null, d_renamed, d2, d3);
    }

    public static void assertEquals(float f_renamed, float f2, float f3) {
        assertEquals((java.lang.String) null, f_renamed, f2, f3);
    }

    public static void assertNotNull(java.lang.String str, java.lang.Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotNull(java.lang.Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNull(java.lang.String str, java.lang.Object obj) {
        if (obj == null) {
            return;
        }
        failNotNull(str, obj);
    }

    public static void assertNull(java.lang.Object obj) {
        assertNull(null, obj);
    }

    private static void failNotNull(java.lang.String str, java.lang.Object obj) {
        java.lang.String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected null, but was:<" + obj + ">");
    }

    public static void assertSame(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return;
        }
        failNotSame(str, obj, obj2);
    }

    public static void assertSame(java.lang.Object obj, java.lang.Object obj2) {
        assertSame(null, obj, obj2);
    }

    public static void assertNotSame(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNotSame(java.lang.Object obj, java.lang.Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    private static void failSame(java.lang.String str) {
        java.lang.String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    private static void failNotSame(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void failNotEquals(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        fail(format(str, obj, obj2));
    }

    static java.lang.String format(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        java.lang.String strValueOf = java.lang.String.valueOf(obj);
        java.lang.String strValueOf2 = java.lang.String.valueOf(obj2);
        if (strValueOf.equals(strValueOf2)) {
            return str2 + "expected: " + formatClassAndValue(obj, strValueOf) + " but was: " + formatClassAndValue(obj2, strValueOf2);
        }
        return str2 + "expected:<" + strValueOf + "> but was:<" + strValueOf2 + ">";
    }

    private static java.lang.String formatClassAndValue(java.lang.Object obj, java.lang.String str) {
        return (obj == null ? "null" : obj.getClass().getName()) + "<" + str + ">";
    }

    @java.lang.Deprecated
    public static void assertEquals(java.lang.String str, java.lang.Object[] objArr, java.lang.Object[] objArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals(str, objArr, objArr2);
    }

    @java.lang.Deprecated
    public static void assertEquals(java.lang.Object[] objArr, java.lang.Object[] objArr2) throws org.junit.internal.ArrayComparisonFailure {
        assertArrayEquals(objArr, objArr2);
    }

    public static <T_renamed> void assertThat(T_renamed t_renamed, org.a_renamed.f_renamed<? super T_renamed> fVar) {
        assertThat("", t_renamed, fVar);
    }

    public static <T_renamed> void assertThat(java.lang.String str, T_renamed t_renamed, org.a_renamed.f_renamed<? super T_renamed> fVar) {
        org.a_renamed.g_renamed.a_renamed(str, t_renamed, fVar);
    }
}
