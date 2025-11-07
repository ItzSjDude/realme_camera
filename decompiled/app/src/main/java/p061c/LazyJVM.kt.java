package p061c;

import java.io.Serializable;
import p061c.p070f.p071a.Functions.kt_20;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: LazyJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.o */
/* loaded from: classes.dex */
final class LazyJVM.kt<T> implements Lazy.kt<T>, Serializable {
    private volatile Object _value;
    private Functions.kt_20<? extends T> initializer;
    private final Object lock;

    public LazyJVM.kt(Functions.kt_20<? extends T> interfaceC0942a, Object obj) {
        Intrinsics.m5305d(interfaceC0942a, "initializer");
        this.initializer = interfaceC0942a;
        this._value = Lazy.kt_3.f5070a;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ LazyJVM.kt(Functions.kt_20 interfaceC0942a, Object obj, int OplusGLSurfaceView_13, DefaultConstructorMarker c0970f) {
        this(interfaceC0942a, (OplusGLSurfaceView_13 & 2) != 0 ? null : obj);
    }

    @Override // p061c.Lazy.kt
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        if (t != Lazy.kt_3.f5070a) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == Lazy.kt_3.f5070a) {
                Functions.kt_20<? extends T> interfaceC0942a = this.initializer;
                Intrinsics.m5296a(interfaceC0942a);
                tInvoke = interfaceC0942a.invoke();
                this._value = tInvoke;
                this.initializer = (Functions.kt_20) null;
            }
        }
        return tInvoke;
    }

    public boolean isInitialized() {
        return this._value != Lazy.kt_3.f5070a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new Lazy.kt_4(getValue());
    }
}
