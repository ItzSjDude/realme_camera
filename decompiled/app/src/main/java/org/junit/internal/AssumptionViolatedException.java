package org.junit.internal;

import org.p222a.StringDescription;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* loaded from: classes2.dex */
public class AssumptionViolatedException extends RuntimeException implements SelfDescribing {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final Matcher<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z, Object obj, Matcher<?> interfaceC4039f) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = interfaceC4039f;
        this.fValueMatcher = z;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, Matcher<?> interfaceC4039f) {
        this(null, true, obj, interfaceC4039f);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, Matcher<?> interfaceC4039f) {
        this(str, true, obj, interfaceC4039f);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringDescription.m26073c(this);
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        String str = this.fAssumption;
        if (str != null) {
            interfaceC4037d.mo26018a(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                interfaceC4037d.mo26018a(": ");
            }
            interfaceC4037d.mo26018a("got: ");
            interfaceC4037d.mo26017a(this.fValue);
            if (this.fMatcher != null) {
                interfaceC4037d.mo26018a(", expected: ");
                interfaceC4037d.mo26020a((SelfDescribing) this.fMatcher);
            }
        }
    }
}
