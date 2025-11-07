package a_renamed.a_renamed.b_renamed.c_renamed;

/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static co_renamed.polarr.renderer.entities.Context f27a = new co_renamed.polarr.renderer.entities.Context();

    static {
        new co_renamed.polarr.renderer.entities.Context();
    }

    public static int a_renamed(byte b2) {
        return b2 & 255;
    }

    public static int a_renamed(android.content.res.Resources resources, int i_renamed, int i2, int i3) {
        int[] iArr = new int[1];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, i2, i3);
        int i4 = iArr[0];
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarA = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed((co_renamed.polarr.renderer.entities.Context) null);
        cVarA.a_renamed(co_renamed.polarr.renderer.filters.Basic.getInstance(resources));
        cVarA.a_renamed(i_renamed);
        cVarA.b_renamed(i4);
        cVarA.c_renamed(i2, i3);
        cVarA.draw();
        return i4;
    }

    public static int[] a_renamed(int i_renamed, int i2, int i3) {
        byte[] bArrArray = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed, i2, i3).array();
        int[] iArr = new int[bArrArray.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = bArrArray[i4] & 255;
        }
        return iArr;
    }

    public static int[] a_renamed(android.content.res.Resources resources, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, int i2) {
        int i3;
        if (dVar == null || (i3 = dVar.f34a) < 0) {
            return null;
        }
        if (i_renamed == dVar.f35b && i2 == dVar.f36c) {
            return a_renamed(i3, i_renamed, i2);
        }
        if (resources == null) {
            return null;
        }
        int iA = a_renamed(resources, i3, i_renamed, i2);
        int[] iArrA = a_renamed(iA, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iA);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(iA);
        return iArrA;
    }

    public static byte[] b_renamed(int i_renamed, int i2, int i3) {
        return a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed, i2, i3).array();
    }

    public static byte[] b_renamed(android.content.res.Resources resources, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, int i2) {
        int i3;
        if (dVar == null || (i3 = dVar.f34a) < 0) {
            return null;
        }
        if (i_renamed == dVar.f35b && i2 == dVar.f36c) {
            return b_renamed(i3, i_renamed, i2);
        }
        if (resources == null) {
            return null;
        }
        int iA = a_renamed(resources, i3, i_renamed, i2);
        byte[] bArrB = b_renamed(iA, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iA);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(iA);
        return bArrB;
    }
}
