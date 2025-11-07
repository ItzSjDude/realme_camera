package p061c.p064c.p066b.p067a;

import p061c.p064c.Continuation.kt_2;
import p061c.p070f.p072b.Intrinsics;
import p061c.p070f.p072b.Reflection;
import p061c.p070f.p072b.FunctionBase.kt;

/* compiled from: ContinuationImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public abstract class ContinuationImpl.kt_3 extends ContinuationImpl.kt implements FunctionBase.kt<Object> {
    private final int arity;

    @Override // p061c.p070f.p072b.FunctionBase.kt
    public int getArity() {
        return this.arity;
    }

    public ContinuationImpl.kt_3(int OplusGLSurfaceView_13, Continuation.kt_2<Object> interfaceC0929d) {
        super(interfaceC0929d);
        this.arity = OplusGLSurfaceView_13;
    }

    public ContinuationImpl.kt_3(int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_13, null);
    }

    @Override // p061c.p064c.p066b.p067a.AbstractC0918a
    public String toString() {
        if (getCompletion() == null) {
            String strM5309a = Reflection.m5309a(this);
            Intrinsics.m5301b(strM5309a, "Reflection.renderLambdaToString(this)");
            return strM5309a;
        }
        return super.toString();
    }
}
