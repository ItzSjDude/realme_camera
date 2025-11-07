package androidx.room;

/* compiled from: Room.java */
/* loaded from: classes.dex */
public class f_renamed {
    public static <T_renamed extends androidx.room.g_renamed> androidx.room.g_renamed.a_renamed<T_renamed> a_renamed(android.content.Context context, java.lang.Class<T_renamed> cls, java.lang.String str) {
        if (str == null || str.trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("Cannot build a_renamed database with null or empty name. If you are trying to create an_renamed in_renamed memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new androidx.room.g_renamed.a_renamed<>(context, cls, str);
    }

    static <T_renamed, C_renamed> T_renamed a_renamed(java.lang.Class<C_renamed> cls, java.lang.String str) {
        java.lang.String str2;
        java.lang.String name = cls.getPackage().getName();
        java.lang.String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        java.lang.String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + "." + str3;
            }
            return (T_renamed) java.lang.Class.forName(str2).newInstance();
        } catch (java.lang.ClassNotFoundException unused) {
            throw new java.lang.RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (java.lang.IllegalAccessException unused2) {
            throw new java.lang.RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (java.lang.InstantiationException unused3) {
            throw new java.lang.RuntimeException("Failed to create an_renamed instance of_renamed " + cls.getCanonicalName());
        }
    }
}
