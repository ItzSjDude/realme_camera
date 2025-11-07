package p061c;

import java.io.Serializable;

/* compiled from: Lazy.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public final class Lazy.kt_4<T> implements Lazy.kt<T>, Serializable {
    private final T value;

    public boolean isInitialized() {
        return true;
    }

    public Lazy.kt_4(T t) {
        this.value = t;
    }

    @Override // p061c.Lazy.kt
    public T getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
