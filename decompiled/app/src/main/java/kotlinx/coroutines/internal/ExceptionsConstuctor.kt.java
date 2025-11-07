package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.Debug.common.kt;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p062a.C0881b;
import p061c.p063b.C0907a;
import p061c.p070f.JvmClassMapping.kt;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p072b.Lambda.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: ExceptionsConstuctor.kt */
/* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class ExceptionsConstuctor.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f24686a = m25833a(Throwable.class, -1);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ReentrantReadWriteLock f24687b = new ReentrantReadWriteLock();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final WeakHashMap<Class<? extends Throwable>, Functions.kt_3<Throwable, Throwable>> f24688c = new WeakHashMap<>();

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$COUIBaseListPopupWindow_12 */
    static final class COUIBaseListPopupWindow_12 extends Lambda.kt implements Functions.kt_3 {
        public static final COUIBaseListPopupWindow_12 INSTANCE = new COUIBaseListPopupWindow_12();

        COUIBaseListPopupWindow_12() {
            super(1);
        }

        @Override // p061c.p070f.p071a.Functions.kt_3
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$COUIBaseListPopupWindow_11 */
    static final class COUIBaseListPopupWindow_11 extends Lambda.kt implements Functions.kt_3 {
        public static final COUIBaseListPopupWindow_11 INSTANCE = new COUIBaseListPopupWindow_11();

        COUIBaseListPopupWindow_11() {
            super(1);
        }

        @Override // p061c.p070f.p071a.Functions.kt_3
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <E extends Throwable> E m25836a(E e2) {
        Object objM26270constructorimpl;
        ReentrantReadWriteLock.ReadLock lock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof Debug.common.kt) {
            try {
                Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(((Debug.common.kt) e2).createCopy());
            } catch (Throwable th) {
                Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
            }
            if (Result.kt.m26276isFailureimpl(objM26270constructorimpl)) {
                objM26270constructorimpl = null;
            }
            return (E) objM26270constructorimpl;
        }
        ReentrantReadWriteLock.ReadLock lock2 = f24687b.readLock();
        lock2.lock();
        try {
            Functions.kt_3<Throwable, Throwable> interfaceC0943b = f24688c.get(e2.getClass());
            if (interfaceC0943b != null) {
                return (E) interfaceC0943b.invoke(e2);
            }
            int OplusGLSurfaceView_13 = 0;
            if (f24686a != m25833a(e2.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = f24687b;
                lock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    lock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f24688c.put(e2.getClass(), COUIBaseListPopupWindow_12.INSTANCE);
                    Unit.kt c1025s = Unit.kt.f5071a;
                    return null;
                } finally {
                    while (OplusGLSurfaceView_13 < readHoldCount) {
                        lock.lock();
                        OplusGLSurfaceView_13++;
                    }
                    writeLock.unlock();
                }
            }
            Functions.kt_3<Throwable, Throwable> interfaceC0943bM25835a = (Functions.kt_3) null;
            Iterator it = C0881b.m5223c(e2.getClass().getConstructors(), new COUIBaseListPopupWindow_8()).iterator();
            while (it.hasNext() && (interfaceC0943bM25835a = m25835a((Constructor<?>) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f24687b;
            lock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                lock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f24688c.put(e2.getClass(), interfaceC0943bM25835a != null ? interfaceC0943bM25835a : COUIBaseListPopupWindow_11.INSTANCE);
                Unit.kt c1025s2 = Unit.kt.f5071a;
                while (OplusGLSurfaceView_13 < readHoldCount) {
                    lock.lock();
                    OplusGLSurfaceView_13++;
                }
                writeLock.unlock();
                if (interfaceC0943bM25835a != null) {
                    return (E) interfaceC0943bM25835a.invoke(e2);
                }
                return null;
            } finally {
                while (OplusGLSurfaceView_13 < readHoldCount) {
                    lock.lock();
                    OplusGLSurfaceView_13++;
                }
                writeLock.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Functions.kt_3<Throwable, Throwable> m25835a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new IntrinsicsJvm.kt_5(constructor);
        }
        if (length != 1) {
            if (length == 2 && Intrinsics.m5299a(parameterTypes[0], String.class) && Intrinsics.m5299a(parameterTypes[1], Throwable.class)) {
                return new PlatformImplementations.kt_3(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (!Intrinsics.m5299a(cls, Throwable.class)) {
            if (Intrinsics.m5299a(cls, String.class)) {
                return new IntrinsicsJvm.kt_3(constructor);
            }
            return null;
        }
        return new IntrinsicsJvm.kt_4(constructor);
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 extends Lambda.kt implements Functions.kt_3<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformImplementations.kt_3(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // p061c.p070f.p071a.Functions.kt_3
        public final Throwable invoke(Throwable th) {
            Object objM26270constructorimpl;
            Object objNewInstance;
            try {
                Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(th.getMessage(), th);
            } catch (Throwable th2) {
                Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th2));
            }
            if (objNewInstance != null) {
                objM26270constructorimpl = Result.kt.m26270constructorimpl((Throwable) objNewInstance);
                if (Result.kt.m26276isFailureimpl(objM26270constructorimpl)) {
                    objM26270constructorimpl = null;
                }
                return (Throwable) objM26270constructorimpl;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 extends Lambda.kt implements Functions.kt_3<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_4(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // p061c.p070f.p071a.Functions.kt_3
        public final Throwable invoke(Throwable th) {
            Object objM26270constructorimpl;
            Object objNewInstance;
            try {
                Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(th);
            } catch (Throwable th2) {
                Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th2));
            }
            if (objNewInstance != null) {
                objM26270constructorimpl = Result.kt.m26270constructorimpl((Throwable) objNewInstance);
                if (Result.kt.m26276isFailureimpl(objM26270constructorimpl)) {
                    objM26270constructorimpl = null;
                }
                return (Throwable) objM26270constructorimpl;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 extends Lambda.kt implements Functions.kt_3<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_3(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // p061c.p070f.p071a.Functions.kt_3
        public final Throwable invoke(Throwable th) {
            Object objM26270constructorimpl;
            Object objNewInstance;
            try {
                Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(th.getMessage());
            } catch (Throwable th2) {
                Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th2));
            }
            if (objNewInstance != null) {
                Throwable th3 = (Throwable) objNewInstance;
                th3.initCause(th);
                objM26270constructorimpl = Result.kt.m26270constructorimpl(th3);
                if (Result.kt.m26276isFailureimpl(objM26270constructorimpl)) {
                    objM26270constructorimpl = null;
                }
                return (Throwable) objM26270constructorimpl;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_5 */
    public static final class IntrinsicsJvm.kt_5 extends Lambda.kt implements Functions.kt_3<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_5(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // p061c.p070f.p071a.Functions.kt_3
        public final Throwable invoke(Throwable th) {
            Object objM26270constructorimpl;
            Object objNewInstance;
            try {
                Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(new Object[0]);
            } catch (Throwable th2) {
                Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th2));
            }
            if (objNewInstance != null) {
                Throwable th3 = (Throwable) objNewInstance;
                th3.initCause(th);
                objM26270constructorimpl = Result.kt.m26270constructorimpl(th3);
                if (Result.kt.m26276isFailureimpl(objM26270constructorimpl)) {
                    objM26270constructorimpl = null;
                }
                return (Throwable) objM26270constructorimpl;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int m25833a(Class<?> cls, int OplusGLSurfaceView_13) {
        Object objM26270constructorimpl;
        JvmClassMapping.kt.m5286a(cls);
        try {
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Integer.valueOf(m25834a(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
        }
        Integer numValueOf = Integer.valueOf(OplusGLSurfaceView_13);
        if (Result.kt.m26276isFailureimpl(objM26270constructorimpl)) {
            objM26270constructorimpl = numValueOf;
        }
        return ((Number) objM26270constructorimpl).intValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ int m25834a(Class cls, int OplusGLSurfaceView_13, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            OplusGLSurfaceView_13 = 0;
        }
        return m25837b(cls, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int m25837b(Class<?> cls, int OplusGLSurfaceView_13) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            OplusGLSurfaceView_13 += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return OplusGLSurfaceView_13;
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_5$COUIBaseListPopupWindow_8 */
    public static final class COUIBaseListPopupWindow_8<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return C0907a.m5248a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }
}
