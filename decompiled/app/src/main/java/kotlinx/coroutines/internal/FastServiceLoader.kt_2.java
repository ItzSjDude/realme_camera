package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import p061c.Exceptions.kt_2;
import p061c.p062a.C0887h;
import p061c.p070f.p072b.Intrinsics;
import p061c.p077k.C1005d;

/* compiled from: FastServiceLoader.kt */
/* renamed from: kotlinx.coroutines.internal.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public final class FastServiceLoader.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final FastServiceLoader.kt_2 f24689a = new FastServiceLoader.kt_2();

    private FastServiceLoader.kt_2() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final List<MainDispatcherFactory.kt> m25842a() {
        MainDispatcherFactory.kt mainDispatcherFactory;
        MainDispatcherFactory.kt mainDispatcherFactory2;
        if (!FastServiceLoader.kt.m25844a()) {
            return m25841b(MainDispatcherFactory.kt.class, MainDispatcherFactory.kt.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            try {
                mainDispatcherFactory = (MainDispatcherFactory.kt) MainDispatcherFactory.kt.class.cast(Class.forName("kotlinx.coroutines.android.HandlerDispatcher.kt_3", true, MainDispatcherFactory.kt.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory.kt) MainDispatcherFactory.kt.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.kt.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
                mainDispatcherFactory2 = null;
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            return arrayList;
        } catch (Throwable unused3) {
            return m25841b(MainDispatcherFactory.kt.class, MainDispatcherFactory.kt.class.getClassLoader());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final <S> List<S> m25841b(Class<S> cls, ClassLoader classLoader) {
        try {
            return m25843a(cls, classLoader);
        } catch (Throwable unused) {
            return C0887h.m5236a((Iterable) ServiceLoader.load(cls, classLoader));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final <S> List<S> m25843a(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        Intrinsics.m5301b(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0887h.m5233a((Collection) arrayList, (Iterable) f24689a.m25840a((URL) it.next()));
        }
        Set setC = C0887h.m5239c(arrayList);
        if (!(!setC.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        Set set = setC;
        ArrayList arrayList2 = new ArrayList(C0887h.m5232a(set, 10));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f24689a.m25838a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final <S> S m25838a(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
        }
        return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<String> m25840a(URL url) throws Throwable {
        Throwable th;
        String string = url.toString();
        if (C1005d.m5356a(string, "jar", false, 2, (Object) null)) {
            String strA = C1005d.m5366a(C1005d.m5379b(string, "jar:file:", (String) null, 2, (Object) null), '!', (String) null, 2, (Object) null);
            String strB = C1005d.m5379b(string, "!/", (String) null, 2, (Object) null);
            JarFile jarFile = new JarFile(strA, false);
            Throwable th2 = (Throwable) null;
            try {
                th = (Throwable) null;
                try {
                    List<String> listM25839a = f24689a.m25839a(new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strB)), "UTF-8")));
                    jarFile.close();
                    return listM25839a;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    if (th2 == null) {
                        throw th4;
                    }
                    Exceptions.kt_2.m5247a(th2, th4);
                    throw th2;
                }
            }
        }
        th = (Throwable) null;
        try {
            return f24689a.m25839a(new BufferedReader(new InputStreamReader(url.openStream())));
        } finally {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<String> m25839a(BufferedReader bufferedReader) throws IOException {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String strA = C1005d.m5368a(line, "#", (String) null, 2, (Object) null);
                if (strA == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = C1005d.m5364a((CharSequence) strA).toString();
                String str = string;
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= str.length()) {
                        z = true;
                        break;
                    }
                    char cCharAt = str.charAt(OplusGLSurfaceView_13);
                    if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                        z = false;
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
                }
                if (str.length() > 0) {
                    linkedHashSet.add(string);
                }
            } else {
                return C0887h.m5236a((Iterable) linkedHashSet);
            }
        }
    }
}
