package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes.dex */
public final class f_renamed {
    public static final java.lang.StackTraceElement a_renamed(c_renamed.c_renamed.b_renamed.a_renamed.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        java.lang.String strE;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(aVar, "$this$getStackTraceElementImpl");
        c_renamed.c_renamed.b_renamed.a_renamed.e_renamed eVarB = b_renamed(aVar);
        if (eVarB == null) {
            return null;
        }
        a_renamed(1, eVarB.a_renamed());
        int iC = c_renamed(aVar);
        int i_renamed = iC < 0 ? -1 : eVarB.c_renamed()[iC];
        java.lang.String strA = c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.f1892b.a_renamed(aVar);
        if (strA == null) {
            strE = eVarB.e_renamed();
        } else {
            strE = strA + '/' + eVarB.e_renamed();
        }
        return new java.lang.StackTraceElement(strE, eVarB.d_renamed(), eVarB.b_renamed(), i_renamed);
    }

    private static final c_renamed.c_renamed.b_renamed.a_renamed.e_renamed b_renamed(c_renamed.c_renamed.b_renamed.a_renamed.a_renamed aVar) {
        return (c_renamed.c_renamed.b_renamed.a_renamed.e_renamed) aVar.getClass().getAnnotation(c_renamed.c_renamed.b_renamed.a_renamed.e_renamed.class);
    }

    private static final int c_renamed(c_renamed.c_renamed.b_renamed.a_renamed.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        try {
            java.lang.reflect.Field declaredField = aVar.getClass().getDeclaredField("label");
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(declaredField, "field");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(aVar);
            if (!(obj instanceof java.lang.Integer)) {
                obj = null;
            }
            java.lang.Integer num = (java.lang.Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    private static final void a_renamed(int i_renamed, int i2) {
        if (i2 <= i_renamed) {
            return;
        }
        throw new java.lang.IllegalStateException(("Debug metadata version mismatch. Expected: " + i_renamed + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }
}
