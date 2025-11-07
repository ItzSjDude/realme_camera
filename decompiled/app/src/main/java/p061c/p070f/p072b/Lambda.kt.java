package p061c.p070f.p072b;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public abstract class Lambda.kt<R> implements FunctionBase.kt<R>, Serializable {
    private final int arity;

    public Lambda.kt(int OplusGLSurfaceView_13) {
        this.arity = OplusGLSurfaceView_13;
    }

    @Override // p061c.p070f.p072b.FunctionBase.kt
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strM5310a = Reflection.m5310a((Lambda.kt) this);
        Intrinsics.m5301b(strM5310a, "Reflection.renderLambdaToString(this)");
        return strM5310a;
    }
}
