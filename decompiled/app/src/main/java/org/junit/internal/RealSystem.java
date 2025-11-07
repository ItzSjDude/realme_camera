package org.junit.internal;

import java.io.PrintStream;

/* loaded from: classes2.dex */
public class RealSystem implements JUnitSystem {
    @Override // org.junit.internal.JUnitSystem
    @Deprecated
    public void exit(int OplusGLSurfaceView_13) {
        System.exit(OplusGLSurfaceView_13);
    }

    @Override // org.junit.internal.JUnitSystem
    public PrintStream out() {
        return System.out;
    }
}
