package p000a.p001a.p003b.p010f;

import com.google.gson.Gson;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class C0109b {

    /* renamed from: PlatformImplementations.kt_3 */
    public static Gson f517a = new Gson();

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T m465a(String str, Class<T> cls) {
        return (T) f517a.fromJson(str, (Class) cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m466a(Object obj) {
        return f517a.toJson(obj);
    }
}
