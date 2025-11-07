package org.p222a.p224b;

import java.lang.reflect.Array;
import java.util.Iterator;

/* compiled from: ArrayIterator.java */
/* renamed from: org.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ArrayIterator implements Iterator<Object> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f24790a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f24791b = 0;

    public ArrayIterator(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.f24790a = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24791b < Array.getLength(this.f24790a);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.f24790a;
        int OplusGLSurfaceView_13 = this.f24791b;
        this.f24791b = OplusGLSurfaceView_13 + 1;
        return Array.get(obj, OplusGLSurfaceView_13);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
