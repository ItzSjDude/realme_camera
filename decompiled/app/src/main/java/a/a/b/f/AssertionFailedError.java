package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static com.google.gson.Gson f80a = new com.google.gson.Gson();

    public static <T_renamed> T_renamed a_renamed(java.lang.String str, java.lang.Class<T_renamed> cls) {
        return (T_renamed) f80a.fromJson(str, (java.lang.Class) cls);
    }

    public static java.lang.String a_renamed(java.lang.Object obj) {
        return f80a.toJson(obj);
    }
}
