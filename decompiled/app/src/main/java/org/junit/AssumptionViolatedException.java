package org.junit;

import org.p222a.Matcher;

/* loaded from: classes2.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t, Matcher<T> interfaceC4039f) {
        super((Object) t, (Matcher<?>) interfaceC4039f);
    }

    public <T> AssumptionViolatedException(String str, T t, Matcher<T> interfaceC4039f) {
        super(str, t, interfaceC4039f);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th) {
        super(str, th);
    }
}
