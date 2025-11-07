package org.junit.experimental.theories.internal;

/* loaded from: classes2.dex */
public class ParameterizedAssertionError extends java.lang.AssertionError {
    private static final long serialVersionUID = 1;

    public ParameterizedAssertionError(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        super(java.lang.String.format("%s_renamed(%s_renamed)", str, join(", ", objArr)));
        initCause(th);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof org.junit.experimental.theories.internal.ParameterizedAssertionError) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public static java.lang.String join(java.lang.String str, java.lang.Object... objArr) {
        return join(str, java.util.Arrays.asList(objArr));
    }

    public static java.lang.String join(java.lang.String str, java.util.Collection<java.lang.Object> collection) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.Object> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(stringValueOf(it.next()));
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static java.lang.String stringValueOf(java.lang.Object obj) {
        try {
            return java.lang.String.valueOf(obj);
        } catch (java.lang.Throwable unused) {
            return "[toString failed]";
        }
    }
}
