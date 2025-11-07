package kotlinx.coroutines.internal;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes2.dex */
public final class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int f7864a = a_renamed(java.lang.Throwable.class, -1);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.concurrent.locks.ReentrantReadWriteLock f7865b = new java.util.concurrent.locks.ReentrantReadWriteLock();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable>> f7866c = new java.util.WeakHashMap<>();

    /* compiled from: ExceptionsConstuctor.kt */
    static final class f_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed {
        public static final kotlinx.coroutines.internal.d_renamed.f_renamed INSTANCE = new kotlinx.coroutines.internal.d_renamed.f_renamed();

        f_renamed() {
            super(1);
        }

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public final java.lang.Void invoke(java.lang.Throwable th) {
            return null;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    static final class g_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed {
        public static final kotlinx.coroutines.internal.d_renamed.g_renamed INSTANCE = new kotlinx.coroutines.internal.d_renamed.g_renamed();

        g_renamed() {
            super(1);
        }

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public final java.lang.Void invoke(java.lang.Throwable th) {
            return null;
        }
    }

    public static final <E_renamed extends java.lang.Throwable> E_renamed a_renamed(E_renamed e2) {
        java.lang.Object objM4constructorimpl;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock lock;
        int readHoldCount;
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof kotlinx.coroutines.r_renamed) {
            try {
                c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(((kotlinx.coroutines.r_renamed) e2).createCopy());
            } catch (java.lang.Throwable th) {
                c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
            }
            if (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl)) {
                objM4constructorimpl = null;
            }
            return (E_renamed) objM4constructorimpl;
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock lock2 = f7865b.readLock();
        lock2.lock();
        try {
            c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> bVar = f7866c.get(e2.getClass());
            if (bVar != null) {
                return (E_renamed) bVar.invoke(e2);
            }
            int i_renamed = 0;
            if (f7864a != a_renamed(e2.getClass(), 0)) {
                java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = f7865b;
                lock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    lock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f7866c.put(e2.getClass(), kotlinx.coroutines.internal.d_renamed.f_renamed.INSTANCE);
                    c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                    return null;
                } finally {
                    while (i_renamed < readHoldCount) {
                        lock.lock();
                        i_renamed++;
                    }
                    writeLock.unlock();
                }
            }
            c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> bVarA = (c_renamed.f_renamed.a_renamed.b_renamed) null;
            java.util.Iterator it = c_renamed.a_renamed.b_renamed.c_renamed(e2.getClass().getConstructors(), new kotlinx.coroutines.internal.d_renamed.e_renamed()).iterator();
            while (it.hasNext() && (bVarA = a_renamed((java.lang.reflect.Constructor<?>) it.next())) == null) {
            }
            java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock2 = f7865b;
            lock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                lock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f7866c.put(e2.getClass(), bVarA != null ? bVarA : kotlinx.coroutines.internal.d_renamed.g_renamed.INSTANCE);
                c_renamed.s_renamed sVar2 = c_renamed.s_renamed.f1925a;
                while (i_renamed < readHoldCount) {
                    lock.lock();
                    i_renamed++;
                }
                writeLock.unlock();
                if (bVarA != null) {
                    return (E_renamed) bVarA.invoke(e2);
                }
                return null;
            } finally {
                while (i_renamed < readHoldCount) {
                    lock.lock();
                    i_renamed++;
                }
                writeLock.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }

    private static final c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> a_renamed(java.lang.reflect.Constructor<?> constructor) {
        java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new kotlinx.coroutines.internal.d_renamed.ExceptionsConstuctor.kt_7(constructor);
        }
        if (length != 1) {
            if (length == 2 && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(parameterTypes[0], java.lang.String.class) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(parameterTypes[1], java.lang.Throwable.class)) {
                return new kotlinx.coroutines.internal.d_renamed.a_renamed(constructor);
            }
            return null;
        }
        java.lang.Class<?> cls = parameterTypes[0];
        if (!c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(cls, java.lang.Throwable.class)) {
            if (c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(cls, java.lang.String.class)) {
                return new kotlinx.coroutines.internal.d_renamed.c_renamed(constructor);
            }
            return null;
        }
        return new kotlinx.coroutines.internal.d_renamed.b_renamed(constructor);
    }

    /* compiled from: ExceptionsConstuctor.kt */
    public static final class a_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> {
        final /* synthetic */ java.lang.reflect.Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public a_renamed(java.lang.reflect.Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public final java.lang.Throwable invoke(java.lang.Throwable th) {
            java.lang.Object objM4constructorimpl;
            java.lang.Object objNewInstance;
            try {
                c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(th.getMessage(), th);
            } catch (java.lang.Throwable th2) {
                c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th2));
            }
            if (objNewInstance != null) {
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl((java.lang.Throwable) objNewInstance);
                if (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl)) {
                    objM4constructorimpl = null;
                }
                return (java.lang.Throwable) objM4constructorimpl;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    public static final class b_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> {
        final /* synthetic */ java.lang.reflect.Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public b_renamed(java.lang.reflect.Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public final java.lang.Throwable invoke(java.lang.Throwable th) {
            java.lang.Object objM4constructorimpl;
            java.lang.Object objNewInstance;
            try {
                c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(th);
            } catch (java.lang.Throwable th2) {
                c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th2));
            }
            if (objNewInstance != null) {
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl((java.lang.Throwable) objNewInstance);
                if (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl)) {
                    objM4constructorimpl = null;
                }
                return (java.lang.Throwable) objM4constructorimpl;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    public static final class c_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> {
        final /* synthetic */ java.lang.reflect.Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public c_renamed(java.lang.reflect.Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public final java.lang.Throwable invoke(java.lang.Throwable th) {
            java.lang.Object objM4constructorimpl;
            java.lang.Object objNewInstance;
            try {
                c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(th.getMessage());
            } catch (java.lang.Throwable th2) {
                c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th2));
            }
            if (objNewInstance != null) {
                java.lang.Throwable th3 = (java.lang.Throwable) objNewInstance;
                th3.initCause(th);
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(th3);
                if (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl)) {
                    objM4constructorimpl = null;
                }
                return (java.lang.Throwable) objM4constructorimpl;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.Throwable");
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* renamed from: kotlinx.coroutines.internal.d_renamed$d_renamed, reason: collision with other inner class name */
    public static final class ExceptionsConstuctor.kt_7 extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, java.lang.Throwable> {
        final /* synthetic */ java.lang.reflect.Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public ExceptionsConstuctor.kt_7(java.lang.reflect.Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public final java.lang.Throwable invoke(java.lang.Throwable th) {
            java.lang.Object objM4constructorimpl;
            java.lang.Object objNewInstance;
            try {
                c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                objNewInstance = this.$constructor$inlined.newInstance(new java.lang.Object[0]);
            } catch (java.lang.Throwable th2) {
                c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th2));
            }
            if (objNewInstance != null) {
                java.lang.Throwable th3 = (java.lang.Throwable) objNewInstance;
                th3.initCause(th);
                objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(th3);
                if (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl)) {
                    objM4constructorimpl = null;
                }
                return (java.lang.Throwable) objM4constructorimpl;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.Throwable");
        }
    }

    private static final int a_renamed(java.lang.Class<?> cls, int i_renamed) {
        java.lang.Object objM4constructorimpl;
        c_renamed.f_renamed.a_renamed.a_renamed(cls);
        try {
            c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(java.lang.Integer.valueOf(a_renamed(cls, 0, 1, null)));
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
        }
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(i_renamed);
        if (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl)) {
            objM4constructorimpl = numValueOf;
        }
        return ((java.lang.Number) objM4constructorimpl).intValue();
    }

    static /* synthetic */ int a_renamed(java.lang.Class cls, int i_renamed, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i_renamed = 0;
        }
        return b_renamed(cls, i_renamed);
    }

    private static final int b_renamed(java.lang.Class<?> cls, int i_renamed) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!java.lang.reflect.Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            i_renamed += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i_renamed;
    }

    /* compiled from: Comparisons.kt */
    public static final class e_renamed<T_renamed> implements java.util.Comparator<T_renamed> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T_renamed t_renamed, T_renamed t2) {
            return c_renamed.b_renamed.a_renamed.a_renamed(java.lang.Integer.valueOf(((java.lang.reflect.Constructor) t2).getParameterTypes().length), java.lang.Integer.valueOf(((java.lang.reflect.Constructor) t_renamed).getParameterTypes().length));
        }
    }
}
