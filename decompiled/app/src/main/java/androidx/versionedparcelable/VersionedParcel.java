package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VersionedParcel.java */
/* renamed from: androidx.versionedparcelable.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final ArrayMap<String, Method> f4776a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final ArrayMap<String, Method> f4777b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected final ArrayMap<String, Class> f4778c;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4914a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4916a(Parcelable parcelable);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4921a(CharSequence charSequence);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4923a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4925a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4927a(boolean z, boolean z2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4928a(byte[] bArr);

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m4930a() {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo4936b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract boolean mo4937b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected abstract VersionedParcel mo4940c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected abstract void mo4941c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected abstract int mo4942d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected abstract String mo4943e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected abstract byte[] mo4944f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected abstract CharSequence mo4945g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected abstract <T extends Parcelable> T mo4946h();

    /* renamed from: OplusGLSurfaceView_13 */
    protected abstract boolean mo4947i();

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f4776a = arrayMap;
        this.f4777b = arrayMap2;
        this.f4778c = arrayMap3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4926a(boolean z, int OplusGLSurfaceView_13) {
        mo4941c(OplusGLSurfaceView_13);
        mo4925a(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4929a(byte[] bArr, int OplusGLSurfaceView_13) {
        mo4941c(OplusGLSurfaceView_13);
        mo4928a(bArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4922a(CharSequence charSequence, int OplusGLSurfaceView_13) {
        mo4941c(OplusGLSurfaceView_13);
        mo4921a(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4915a(int OplusGLSurfaceView_13, int i2) {
        mo4941c(i2);
        mo4914a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4924a(String str, int OplusGLSurfaceView_13) {
        mo4941c(OplusGLSurfaceView_13);
        mo4923a(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4917a(Parcelable parcelable, int OplusGLSurfaceView_13) {
        mo4941c(OplusGLSurfaceView_13);
        mo4916a(parcelable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m4938b(boolean z, int OplusGLSurfaceView_13) {
        return !mo4937b(OplusGLSurfaceView_13) ? z : mo4947i();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m4931b(int OplusGLSurfaceView_13, int i2) {
        return !mo4937b(i2) ? OplusGLSurfaceView_13 : mo4942d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m4935b(String str, int OplusGLSurfaceView_13) {
        return !mo4937b(OplusGLSurfaceView_13) ? str : mo4943e();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public byte[] m4939b(byte[] bArr, int OplusGLSurfaceView_13) {
        return !mo4937b(OplusGLSurfaceView_13) ? bArr : mo4944f();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public <T extends Parcelable> T m4932b(T t, int OplusGLSurfaceView_13) {
        return !mo4937b(OplusGLSurfaceView_13) ? t : (T) mo4946h();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m4934b(CharSequence charSequence, int OplusGLSurfaceView_13) {
        return !mo4937b(OplusGLSurfaceView_13) ? charSequence : mo4945g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4919a(VersionedParcelable interfaceC0816c, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        mo4941c(OplusGLSurfaceView_13);
        m4918a(interfaceC0816c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m4918a(VersionedParcelable interfaceC0816c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0816c == null) {
            mo4923a((String) null);
            return;
        }
        m4912b(interfaceC0816c);
        VersionedParcel abstractC0814aMo4940c = mo4940c();
        m4920a((VersionedParcel) interfaceC0816c, abstractC0814aMo4940c);
        abstractC0814aMo4940c.mo4936b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4912b(VersionedParcelable interfaceC0816c) {
        try {
            mo4923a(m4910b((Class<? extends VersionedParcelable>) interfaceC0816c.getClass()).getName());
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(interfaceC0816c.getClass().getSimpleName() + " does not have PlatformImplementations.kt_3 Parcelizer", COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public <T extends VersionedParcelable> T m4933b(T t, int OplusGLSurfaceView_13) {
        return !mo4937b(OplusGLSurfaceView_13) ? t : (T) m4948j();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected <T extends VersionedParcelable> T m4948j() {
        String strMo4943e = mo4943e();
        if (strMo4943e == null) {
            return null;
        }
        return (T) m4913a(strMo4943e, mo4940c());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected <T extends VersionedParcelable> T m4913a(String str, VersionedParcel abstractC0814a) {
        try {
            return (T) m4911b(str).invoke(null, abstractC0814a);
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", COUIBaseListPopupWindow_8);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected <T extends VersionedParcelable> void m4920a(T t, VersionedParcel abstractC0814a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            m4909a(t.getClass()).invoke(null, t, abstractC0814a);
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", COUIBaseListPopupWindow_8);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Method m4911b(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Method method = this.f4776a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f4776a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private Method m4909a(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = this.f4777b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsM4910b = m4910b((Class<? extends VersionedParcelable>) cls);
        System.currentTimeMillis();
        Method declaredMethod = clsM4910b.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f4777b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Class m4910b(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.f4778c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f4778c.put(cls.getName(), cls3);
        return cls3;
    }
}
