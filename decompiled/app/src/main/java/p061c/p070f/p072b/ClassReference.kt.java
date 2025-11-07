package p061c.p070f.p072b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p061c.Tuples.kt_2;
import p061c.Tuples.kt;
import p061c.Function.kt;
import p061c.p062a.C0887h;
import p061c.p062a.C0903x;
import p061c.p070f.JvmClassMapping.kt;
import p061c.p070f.p071a.Functions.kt_20;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_11;
import p061c.p070f.p071a.Functions.kt_16;
import p061c.p070f.p071a.Functions.kt;
import p061c.p070f.p071a.Functions.kt_8;
import p061c.p070f.p071a.Functions.kt_17;
import p061c.p070f.p071a.Functions.kt_7;
import p061c.p070f.p071a.Functions.kt_2;
import p061c.p070f.p071a.Functions.kt_13;
import p061c.p070f.p071a.Functions.kt_5;
import p061c.p070f.p071a.Functions.kt_18;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p071a.Functions.kt_14;
import p061c.p070f.p071a.Functions.kt_23;
import p061c.p070f.p071a.Functions.kt_15;
import p061c.p070f.p071a.Functions.kt_9;
import p061c.p070f.p071a.Functions.kt_10;
import p061c.p070f.p071a.Functions.kt_6;
import p061c.p070f.p071a.Functions.kt_22;
import p061c.p070f.p071a.Functions.kt_12;
import p061c.p070f.p071a.Functions.kt_21;
import p061c.p070f.p071a.Functions.kt_4;
import p061c.p075i.KClass.kt;
import p061c.p077k.C1005d;

/* compiled from: ClassReference.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public final class ClassReference.kt implements ClassBasedDeclarationContainer.kt, KClass.kt<Object> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PlatformImplementations.kt_3 f5045a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Map<Class<? extends Function.kt<?>>, Integer> f5046c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final HashMap<String, String> f5047d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final HashMap<String, String> f5048e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final HashMap<String, String> f5049f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final Map<String, String> f5050g;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Class<?> f5051b;

    public ClassReference.kt(Class<?> cls) {
        Intrinsics.m5305d(cls, "jClass");
        this.f5051b = cls;
    }

    @Override // p061c.p070f.p072b.ClassBasedDeclarationContainer.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public Class<?> mo5289a() {
        return this.f5051b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference.kt) && Intrinsics.m5299a(JvmClassMapping.kt.m5287a(this), JvmClassMapping.kt.m5287a((KClass.kt) obj));
    }

    public int hashCode() {
        return JvmClassMapping.kt.m5287a(this).hashCode();
    }

    public String toString() {
        return mo5289a().toString() + " (Kotlin reflection is not available)";
    }

    /* compiled from: ClassReference.kt */
    /* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    static {
        int OplusGLSurfaceView_13 = 0;
        List listA = C0887h.m5229a((Object[]) new Class[]{Functions.kt_20.class, Functions.kt_3.class, Functions.kt_19.class, Functions.kt_9.class, Functions.kt_10.class, Functions.kt_6.class, Functions.kt_22.class, Functions.kt_12.class, Functions.kt_21.class, Functions.kt_4.class, Functions.kt_11.class, Functions.kt_16.class, Functions.kt.class, Functions.kt_8.class, Functions.kt_17.class, Functions.kt_7.class, Functions.kt_2.class, Functions.kt_13.class, Functions.kt_5.class, Functions.kt_18.class, Functions.kt_14.class, Functions.kt_23.class, Functions.kt_15.class});
        ArrayList arrayList = new ArrayList(C0887h.m5232a(listA, 10));
        for (Object obj : listA) {
            int i2 = OplusGLSurfaceView_13 + 1;
            if (OplusGLSurfaceView_13 < 0) {
                C0887h.m5231b();
            }
            arrayList.add(Tuples.kt.m5382a((Class) obj, Integer.valueOf(OplusGLSurfaceView_13)));
            OplusGLSurfaceView_13 = i2;
        }
        f5046c = C0903x.m5207a(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f5047d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f5048e = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(f5047d);
        map3.putAll(f5048e);
        Collection<String> collectionValues = f5047d.values();
        Intrinsics.m5301b(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.m5301b(str, "kotlinName");
            sb.append(C1005d.m5377b(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            Tuples.kt_2 c1018lM5382a = Tuples.kt.m5382a(sb.toString(), str + ".Companion");
            map3.put(c1018lM5382a.getFirst(), c1018lM5382a.getSecond());
        }
        for (Map.Entry<Class<? extends Function.kt<?>>, Integer> entry : f5046c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f5049f = map3;
        HashMap<String, String> map4 = f5049f;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C0903x.m5244a(map4.size()));
        Iterator<T> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), C1005d.m5377b((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        f5050g = linkedHashMap;
    }
}
