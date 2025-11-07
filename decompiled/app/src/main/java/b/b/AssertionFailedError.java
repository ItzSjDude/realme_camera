package b_renamed.b_renamed;

/* compiled from: AssertionFailedError.java */
/* loaded from: classes.dex */
public class b_renamed extends java.lang.AssertionError {
    private static final long serialVersionUID = 1;

    private static java.lang.String defaultString(java.lang.String str) {
        return str == null ? "" : str;
    }

    public b_renamed() {
    }

    public b_renamed(java.lang.String str) {
        super(defaultString(str));
    }
}
