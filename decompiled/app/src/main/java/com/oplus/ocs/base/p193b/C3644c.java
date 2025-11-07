package com.oplus.ocs.base.p193b;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.HashMap;

/* renamed from: com.oplus.ocs.base.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class C3644c {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f23385a = "IntrinsicsJvm.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> f23386b = new HashMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T extends Parcelable> T m25026a(Parcel parcel, ClassLoader classLoader, String str) throws NoSuchFieldException, ClassNotFoundException {
        Parcelable.Creator<?> creatorM25028b = m25028b(parcel, classLoader, str);
        if (creatorM25028b == null) {
            return null;
        }
        if (creatorM25028b instanceof Parcelable.ClassLoaderCreator) {
            return (T) ((Parcelable.ClassLoaderCreator) creatorM25028b).createFromParcel(parcel, classLoader);
        }
        return (T) creatorM25028b.createFromParcel(parcel);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Parcelable.Creator<?> m25028b(Parcel parcel, ClassLoader classLoader, String str) throws NoSuchFieldException, ClassNotFoundException {
        HashMap<String, Parcelable.Creator<?>> map;
        Parcelable.Creator<?> creator;
        if (parcel.readString() == null) {
            return null;
        }
        synchronized (f23386b) {
            map = f23386b.get(classLoader);
            if (map == null) {
                map = new HashMap<>();
                f23386b.put(classLoader, map);
            }
            creator = map.get(str);
        }
        if (creator != null) {
            return creator;
        }
        try {
            Class<?> cls = Class.forName(str, false, classLoader);
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new BadParcelableException("Parcelable protocol requires subclassing from Parcelable on class ".concat(String.valueOf(str)));
            }
            Field field = cls.getField("CREATOR");
            if ((field.getModifiers() & 8) == 0) {
                throw new BadParcelableException("Parcelable protocol requires the CREATOR object to be static on class ".concat(String.valueOf(str)));
            }
            if (!Parcelable.Creator.class.isAssignableFrom(field.getType())) {
                throw new BadParcelableException("Parcelable protocol requires PlatformImplementations.kt_3 Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(str)));
            }
            Parcelable.Creator<?> creator2 = (Parcelable.Creator) field.get(null);
            if (creator2 == null) {
                throw new BadParcelableException("Parcelable protocol requires PlatformImplementations.kt_3 non-null Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(str)));
            }
            synchronized (f23386b) {
                map.put(str, creator2);
            }
            return creator2;
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(f23385a, "Class not found when unmarshalling: ".concat(String.valueOf(str)), COUIBaseListPopupWindow_8);
            throw new BadParcelableException("ClassNotFoundException when unmarshalling: ".concat(String.valueOf(str)));
        } catch (IllegalAccessException e2) {
            Log.COUIBaseListPopupWindow_8(f23385a, "Illegal access when unmarshalling: ".concat(String.valueOf(str)), e2);
            throw new BadParcelableException("IllegalAccessException when unmarshalling: ".concat(String.valueOf(str)));
        } catch (NoSuchFieldException unused) {
            throw new BadParcelableException("Parcelable protocol requires PlatformImplementations.kt_3 Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(str)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25027a(Parcel parcel, Parcelable parcelable, String str) {
        if (parcelable == null) {
            parcel.writeString(null);
        } else {
            parcel.writeString(str);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
