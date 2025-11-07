package org.junit.internal;

/* loaded from: classes2.dex */
public class RealSystem implements org.junit.internal.JUnitSystem {
    @Override // org.junit.internal.JUnitSystem
    @java.lang.Deprecated
    public void exit(int i_renamed) {
        java.lang.System.exit(i_renamed);
    }

    @Override // org.junit.internal.JUnitSystem
    public java.io.PrintStream out() {
        return java.lang.System.out;
    }
}
