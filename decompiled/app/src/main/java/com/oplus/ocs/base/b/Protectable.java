package com.oplus.ocs.base.b_renamed;

/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f7515a = "c_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.HashMap<java.lang.ClassLoader, java.util.HashMap<java.lang.String, android.os.Parcelable.Creator<?>>> f7516b = new java.util.HashMap<>();

    public static final <T_renamed extends android.os.Parcelable> T_renamed a_renamed(android.os.Parcel parcel, java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.NoSuchFieldException, java.lang.ClassNotFoundException {
        android.os.Parcelable.Creator<?> creatorB = b_renamed(parcel, classLoader, str);
        if (creatorB == null) {
            return null;
        }
        if (creatorB instanceof android.os.Parcelable.ClassLoaderCreator) {
            return (T_renamed) ((android.os.Parcelable.ClassLoaderCreator) creatorB).createFromParcel(parcel, classLoader);
        }
        return (T_renamed) creatorB.createFromParcel(parcel);
    }

    private static android.os.Parcelable.Creator<?> b_renamed(android.os.Parcel parcel, java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.NoSuchFieldException, java.lang.ClassNotFoundException {
        java.util.HashMap<java.lang.String, android.os.Parcelable.Creator<?>> map;
        android.os.Parcelable.Creator<?> creator;
        if (parcel.readString() == null) {
            return null;
        }
        synchronized (f7516b) {
            map = f7516b.get(classLoader);
            if (map == null) {
                map = new java.util.HashMap<>();
                f7516b.put(classLoader, map);
            }
            creator = map.get(str);
        }
        if (creator != null) {
            return creator;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str, false, classLoader);
            if (!android.os.Parcelable.class.isAssignableFrom(cls)) {
                throw new android.os.BadParcelableException("Parcelable protocol requires subclassing from Parcelable on_renamed class ".concat(java.lang.String.valueOf(str)));
            }
            java.lang.reflect.Field field = cls.getField("CREATOR");
            if ((field.getModifiers() & 8) == 0) {
                throw new android.os.BadParcelableException("Parcelable protocol requires the CREATOR object to be_renamed static on_renamed class ".concat(java.lang.String.valueOf(str)));
            }
            if (!android.os.Parcelable.Creator.class.isAssignableFrom(field.getType())) {
                throw new android.os.BadParcelableException("Parcelable protocol requires a_renamed Parcelable.Creator object called CREATOR on_renamed class ".concat(java.lang.String.valueOf(str)));
            }
            android.os.Parcelable.Creator<?> creator2 = (android.os.Parcelable.Creator) field.get(null);
            if (creator2 == null) {
                throw new android.os.BadParcelableException("Parcelable protocol requires a_renamed non-null Parcelable.Creator object called CREATOR on_renamed class ".concat(java.lang.String.valueOf(str)));
            }
            synchronized (f7516b) {
                map.put(str, creator2);
            }
            return creator2;
        } catch (java.lang.ClassNotFoundException e_renamed) {
            android.util.Log.e_renamed(f7515a, "Class not found when unmarshalling: ".concat(java.lang.String.valueOf(str)), e_renamed);
            throw new android.os.BadParcelableException("ClassNotFoundException when unmarshalling: ".concat(java.lang.String.valueOf(str)));
        } catch (java.lang.IllegalAccessException e2) {
            android.util.Log.e_renamed(f7515a, "Illegal access when unmarshalling: ".concat(java.lang.String.valueOf(str)), e2);
            throw new android.os.BadParcelableException("IllegalAccessException when unmarshalling: ".concat(java.lang.String.valueOf(str)));
        } catch (java.lang.NoSuchFieldException unused) {
            throw new android.os.BadParcelableException("Parcelable protocol requires a_renamed Parcelable.Creator object called CREATOR on_renamed class ".concat(java.lang.String.valueOf(str)));
        }
    }

    public static void a_renamed(android.os.Parcel parcel, android.os.Parcelable parcelable, java.lang.String str) {
        if (parcelable == null) {
            parcel.writeString(null);
        } else {
            parcel.writeString(str);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
