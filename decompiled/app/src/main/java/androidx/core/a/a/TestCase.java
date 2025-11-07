package androidx.core.a_renamed.a_renamed;

/* compiled from: GrowingArrayUtils.java */
/* loaded from: classes.dex */
final class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final /* synthetic */ boolean f794a = !androidx.core.a_renamed.a_renamed.e_renamed.class.desiredAssertionStatus();

    public static int a_renamed(int i_renamed) {
        if (i_renamed <= 4) {
            return 8;
        }
        return i_renamed * 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.lang.Object[]] */
    public static <T_renamed> T_renamed[] a_renamed(T_renamed[] tArr, int i_renamed, T_renamed t_renamed) {
        if (!f794a && i_renamed > tArr.length) {
            throw new java.lang.AssertionError();
        }
        if (i_renamed + 1 > tArr.length) {
            java.lang.Object[] objArr = (java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), a_renamed(i_renamed));
            java.lang.System.arraycopy(tArr, 0, objArr, 0, i_renamed);
            tArr = objArr;
        }
        tArr[i_renamed] = t_renamed;
        return tArr;
    }

    public static int[] a_renamed(int[] iArr, int i_renamed, int i2) {
        if (!f794a && i_renamed > iArr.length) {
            throw new java.lang.AssertionError();
        }
        if (i_renamed + 1 > iArr.length) {
            int[] iArr2 = new int[a_renamed(i_renamed)];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i_renamed);
            iArr = iArr2;
        }
        iArr[i_renamed] = i2;
        return iArr;
    }

    private e_renamed() {
    }
}
