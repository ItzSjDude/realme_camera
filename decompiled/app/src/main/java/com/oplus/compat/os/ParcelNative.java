package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class ParcelNative {
    private static final java.lang.String TAG = "ParcelNative";

    private static java.lang.Object readArraySetCompat(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
        return null;
    }

    private static java.lang.Object readStringArrayCompat(android.os.Parcel parcel) {
        return null;
    }

    private static void writeArraySetCompat(android.os.Parcel parcel, android.util.ArraySet<? extends java.lang.Object> arraySet) {
    }

    private ParcelNative() {
    }

    public static final java.lang.String[] readStringArray(android.os.Parcel parcel) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return parcel.readStringArray();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.ParcelWrapper.readStringArray(parcel);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.lang.String[]) readStringArrayCompat(parcel);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return parcel.readStringArray();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static android.util.ArraySet<? extends java.lang.Object> readArraySet(android.os.Parcel parcel, java.lang.ClassLoader classLoader) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return parcel.readArraySet(classLoader);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.ParcelWrapper.readArraySet(parcel, classLoader);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (android.util.ArraySet) readArraySetCompat(parcel, classLoader);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static void writeArraySet(android.os.Parcel parcel, android.util.ArraySet<? extends java.lang.Object> arraySet) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            parcel.writeArraySet(arraySet);
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            com.oplus.inner.os.ParcelWrapper.writeArraySet(parcel, arraySet);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                writeArraySetCompat(parcel, arraySet);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
        }
    }
}
