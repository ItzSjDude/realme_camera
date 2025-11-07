package b_renamed.b_renamed;

/* compiled from: Assert.java */
@java.lang.Deprecated
/* loaded from: classes.dex */
public class a_renamed {
    protected a_renamed() {
    }

    public static void a_renamed(java.lang.String str, boolean z_renamed) {
        if (z_renamed) {
            return;
        }
        a_renamed(str);
    }

    public static void a_renamed(java.lang.String str) {
        if (str == null) {
            throw new b_renamed.b_renamed.b_renamed();
        }
        throw new b_renamed.b_renamed.b_renamed(str);
    }

    public static void a_renamed(java.lang.String str, java.lang.Object obj) {
        a_renamed(str, obj != null);
    }
}
