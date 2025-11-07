package androidx.versionedparcelable;

/* compiled from: VersionedParcel.java */
/* loaded from: classes.dex */
public abstract class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> f1795a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected final androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> f1796b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected final androidx.collection.ArrayMap<java.lang.String, java.lang.Class> f1797c;

    protected abstract void a_renamed(int i_renamed);

    protected abstract void a_renamed(android.os.Parcelable parcelable);

    protected abstract void a_renamed(java.lang.CharSequence charSequence);

    protected abstract void a_renamed(java.lang.String str);

    protected abstract void a_renamed(boolean z_renamed);

    public void a_renamed(boolean z_renamed, boolean z2) {
    }

    protected abstract void a_renamed(byte[] bArr);

    public boolean a_renamed() {
        return false;
    }

    protected abstract void b_renamed();

    protected abstract boolean b_renamed(int i_renamed);

    protected abstract androidx.versionedparcelable.a_renamed c_renamed();

    protected abstract void c_renamed(int i_renamed);

    protected abstract int d_renamed();

    protected abstract java.lang.String e_renamed();

    protected abstract byte[] f_renamed();

    protected abstract java.lang.CharSequence g_renamed();

    protected abstract <T_renamed extends android.os.Parcelable> T_renamed h_renamed();

    protected abstract boolean i_renamed();

    public a_renamed(androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap, androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap2, androidx.collection.ArrayMap<java.lang.String, java.lang.Class> arrayMap3) {
        this.f1795a = arrayMap;
        this.f1796b = arrayMap2;
        this.f1797c = arrayMap3;
    }

    public void a_renamed(boolean z_renamed, int i_renamed) {
        c_renamed(i_renamed);
        a_renamed(z_renamed);
    }

    public void a_renamed(byte[] bArr, int i_renamed) {
        c_renamed(i_renamed);
        a_renamed(bArr);
    }

    public void a_renamed(java.lang.CharSequence charSequence, int i_renamed) {
        c_renamed(i_renamed);
        a_renamed(charSequence);
    }

    public void a_renamed(int i_renamed, int i2) {
        c_renamed(i2);
        a_renamed(i_renamed);
    }

    public void a_renamed(java.lang.String str, int i_renamed) {
        c_renamed(i_renamed);
        a_renamed(str);
    }

    public void a_renamed(android.os.Parcelable parcelable, int i_renamed) {
        c_renamed(i_renamed);
        a_renamed(parcelable);
    }

    public boolean b_renamed(boolean z_renamed, int i_renamed) {
        return !b_renamed(i_renamed) ? z_renamed : i_renamed();
    }

    public int b_renamed(int i_renamed, int i2) {
        return !b_renamed(i2) ? i_renamed : d_renamed();
    }

    public java.lang.String b_renamed(java.lang.String str, int i_renamed) {
        return !b_renamed(i_renamed) ? str : e_renamed();
    }

    public byte[] b_renamed(byte[] bArr, int i_renamed) {
        return !b_renamed(i_renamed) ? bArr : f_renamed();
    }

    public <T_renamed extends android.os.Parcelable> T_renamed b_renamed(T_renamed t_renamed, int i_renamed) {
        return !b_renamed(i_renamed) ? t_renamed : (T_renamed) h_renamed();
    }

    public java.lang.CharSequence b_renamed(java.lang.CharSequence charSequence, int i_renamed) {
        return !b_renamed(i_renamed) ? charSequence : g_renamed();
    }

    public void a_renamed(androidx.versionedparcelable.c_renamed cVar, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        c_renamed(i_renamed);
        a_renamed(cVar);
    }

    protected void a_renamed(androidx.versionedparcelable.c_renamed cVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (cVar == null) {
            a_renamed((java.lang.String) null);
            return;
        }
        b_renamed(cVar);
        androidx.versionedparcelable.a_renamed aVarC = c_renamed();
        a_renamed((androidx.versionedparcelable.a_renamed) cVar, aVarC);
        aVarC.b_renamed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b_renamed(androidx.versionedparcelable.c_renamed cVar) {
        try {
            a_renamed(b_renamed((java.lang.Class<? extends androidx.versionedparcelable.c_renamed>) cVar.getClass()).getName());
        } catch (java.lang.ClassNotFoundException e_renamed) {
            throw new java.lang.RuntimeException(cVar.getClass().getSimpleName() + " does not have a_renamed Parcelizer", e_renamed);
        }
    }

    public <T_renamed extends androidx.versionedparcelable.c_renamed> T_renamed b_renamed(T_renamed t_renamed, int i_renamed) {
        return !b_renamed(i_renamed) ? t_renamed : (T_renamed) j_renamed();
    }

    protected <T_renamed extends androidx.versionedparcelable.c_renamed> T_renamed j_renamed() {
        java.lang.String strE = e_renamed();
        if (strE == null) {
            return null;
        }
        return (T_renamed) a_renamed(strE, c_renamed());
    }

    protected <T_renamed extends androidx.versionedparcelable.c_renamed> T_renamed a_renamed(java.lang.String str, androidx.versionedparcelable.a_renamed aVar) {
        try {
            return (T_renamed) b_renamed(str).invoke(null, aVar);
        } catch (java.lang.ClassNotFoundException e_renamed) {
            throw new java.lang.RuntimeException("VersionedParcel encountered ClassNotFoundException", e_renamed);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new java.lang.RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            if (e4.getCause() instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) e4.getCause());
            }
            throw new java.lang.RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    protected <T_renamed extends androidx.versionedparcelable.c_renamed> void a_renamed(T_renamed t_renamed, androidx.versionedparcelable.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            a_renamed(t_renamed.getClass()).invoke(null, t_renamed, aVar);
        } catch (java.lang.ClassNotFoundException e_renamed) {
            throw new java.lang.RuntimeException("VersionedParcel encountered ClassNotFoundException", e_renamed);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new java.lang.RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            if (e4.getCause() instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) e4.getCause());
            }
            throw new java.lang.RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    private java.lang.reflect.Method b_renamed(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
        java.lang.reflect.Method method = this.f1795a.get(str);
        if (method != null) {
            return method;
        }
        java.lang.System.currentTimeMillis();
        java.lang.reflect.Method declaredMethod = java.lang.Class.forName(str, true, androidx.versionedparcelable.a_renamed.class.getClassLoader()).getDeclaredMethod("read", androidx.versionedparcelable.a_renamed.class);
        this.f1795a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.lang.reflect.Method a_renamed(java.lang.Class cls) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        java.lang.reflect.Method method = this.f1796b.get(cls.getName());
        if (method != null) {
            return method;
        }
        java.lang.Class clsB = b_renamed((java.lang.Class<? extends androidx.versionedparcelable.c_renamed>) cls);
        java.lang.System.currentTimeMillis();
        java.lang.reflect.Method declaredMethod = clsB.getDeclaredMethod("write", cls, androidx.versionedparcelable.a_renamed.class);
        this.f1796b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private java.lang.Class b_renamed(java.lang.Class<? extends androidx.versionedparcelable.c_renamed> cls) throws java.lang.ClassNotFoundException {
        java.lang.Class cls2 = this.f1797c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        java.lang.Class<?> cls3 = java.lang.Class.forName(java.lang.String.format("%s_renamed.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f1797c.put(cls.getName(), cls3);
        return cls3;
    }
}
