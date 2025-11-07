package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;

/* compiled from: Room.java */
/* renamed from: androidx.room.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class Room {
    /* renamed from: PlatformImplementations.kt_3 */
    public static <T extends RoomDatabase> RoomDatabase.PlatformImplementations.kt_3<T> m4630a(Context context, Class<T> cls, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot build PlatformImplementations.kt_3 database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.PlatformImplementations.kt_3<>(context, cls, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static <T, C> T m4631a(Class<C> cls, String str) {
        String str2;
        String name = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + "." + str3;
            }
            return (T) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }
}
