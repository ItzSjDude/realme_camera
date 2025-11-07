package kotlinx.coroutines.internal;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes2.dex */
public final class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.e_renamed f7867a = new kotlinx.coroutines.internal.e_renamed();

    private e_renamed() {
    }

    public final java.util.List<kotlinx.coroutines.internal.MainDispatcherFactory.kt> a_renamed() {
        kotlinx.coroutines.internal.MainDispatcherFactory.kt mainDispatcherFactory;
        kotlinx.coroutines.internal.MainDispatcherFactory.kt mainDispatcherFactory2;
        if (!kotlinx.coroutines.internal.f_renamed.a_renamed()) {
            return b_renamed(kotlinx.coroutines.internal.MainDispatcherFactory.kt.class, kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.getClassLoader());
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            try {
                mainDispatcherFactory = (kotlinx.coroutines.internal.MainDispatcherFactory.kt) kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.cast(java.lang.Class.forName("kotlinx.coroutines.android.HandlerDispatcher.kt_2", true, kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.getClassLoader()).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
            } catch (java.lang.ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (kotlinx.coroutines.internal.MainDispatcherFactory.kt) kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.cast(java.lang.Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.getClassLoader()).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
            } catch (java.lang.ClassNotFoundException unused2) {
                mainDispatcherFactory2 = null;
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            return arrayList;
        } catch (java.lang.Throwable unused3) {
            return b_renamed(kotlinx.coroutines.internal.MainDispatcherFactory.kt.class, kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.getClassLoader());
        }
    }

    private final <S_renamed> java.util.List<S_renamed> b_renamed(java.lang.Class<S_renamed> cls, java.lang.ClassLoader classLoader) {
        try {
            return a_renamed(cls, classLoader);
        } catch (java.lang.Throwable unused) {
            return c_renamed.a_renamed.h_renamed.a_renamed((java.lang.Iterable) java.util.ServiceLoader.load(cls, classLoader));
        }
    }

    public final <S_renamed> java.util.List<S_renamed> a_renamed(java.lang.Class<S_renamed> cls, java.lang.ClassLoader classLoader) {
        java.util.ArrayList list = java.util.Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(list, "java.util.Collections.list(this)");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            c_renamed.a_renamed.h_renamed.a_renamed((java.util.Collection) arrayList, (java.lang.Iterable) f7867a.a_renamed((java.net.URL) it.next()));
        }
        java.util.Set setC = c_renamed.a_renamed.h_renamed.c_renamed(arrayList);
        if (!(!setC.isEmpty())) {
            throw new java.lang.IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        java.util.Set set = setC;
        java.util.ArrayList arrayList2 = new java.util.ArrayList(c_renamed.a_renamed.h_renamed.a_renamed(set, 10));
        java.util.Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f7867a.a_renamed((java.lang.String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    private final <S_renamed> S_renamed a_renamed(java.lang.String str, java.lang.ClassLoader classLoader, java.lang.Class<S_renamed> cls) throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls2 = java.lang.Class.forName(str, false, classLoader);
        if (!cls.isAssignableFrom(cls2)) {
            throw new java.lang.IllegalArgumentException(("Expected service of_renamed class " + cls + ", but found " + cls2).toString());
        }
        return cls.cast(cls2.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
    }

    private final java.util.List<java.lang.String> a_renamed(java.net.URL url) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.lang.String string = url.toString();
        if (c_renamed.k_renamed.d_renamed.a_renamed(string, "jar", false, 2, (java.lang.Object) null)) {
            java.lang.String strA = c_renamed.k_renamed.d_renamed.a_renamed(c_renamed.k_renamed.d_renamed.b_renamed(string, "jar:file:", (java.lang.String) null, 2, (java.lang.Object) null), '!', (java.lang.String) null, 2, (java.lang.Object) null);
            java.lang.String strB = c_renamed.k_renamed.d_renamed.b_renamed(string, "!/", (java.lang.String) null, 2, (java.lang.Object) null);
            java.util.jar.JarFile jarFile = new java.util.jar.JarFile(strA, false);
            java.lang.Throwable th2 = (java.lang.Throwable) null;
            try {
                th = (java.lang.Throwable) null;
                try {
                    java.util.List<java.lang.String> listA = f7867a.a_renamed(new java.io.BufferedReader(new java.io.InputStreamReader(jarFile.getInputStream(new java.util.zip.ZipEntry(strB)), "UTF-8")));
                    jarFile.close();
                    return listA;
                } finally {
                }
            } catch (java.lang.Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (java.lang.Throwable th4) {
                    if (th2 == null) {
                        throw th4;
                    }
                    c_renamed.a_renamed.a_renamed(th2, th4);
                    throw th2;
                }
            }
        }
        th = (java.lang.Throwable) null;
        try {
            return f7867a.a_renamed(new java.io.BufferedReader(new java.io.InputStreamReader(url.openStream())));
        } finally {
        }
    }

    private final java.util.List<java.lang.String> a_renamed(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        boolean z_renamed;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line != null) {
                java.lang.String strA = c_renamed.k_renamed.d_renamed.a_renamed(line, "#", (java.lang.String) null, 2, (java.lang.Object) null);
                if (strA == null) {
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.CharSequence");
                }
                java.lang.String string = c_renamed.k_renamed.d_renamed.a_renamed((java.lang.CharSequence) strA).toString();
                java.lang.String str = string;
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= str.length()) {
                        z_renamed = true;
                        break;
                    }
                    char cCharAt = str.charAt(i_renamed);
                    if (!(cCharAt == '.' || java.lang.Character.isJavaIdentifierPart(cCharAt))) {
                        z_renamed = false;
                        break;
                    }
                    i_renamed++;
                }
                if (!z_renamed) {
                    throw new java.lang.IllegalArgumentException(("Illegal service provider class name: " + string).toString());
                }
                if (str.length() > 0) {
                    linkedHashSet.add(string);
                }
            } else {
                return c_renamed.a_renamed.h_renamed.a_renamed((java.lang.Iterable) linkedHashSet);
            }
        }
    }
}
