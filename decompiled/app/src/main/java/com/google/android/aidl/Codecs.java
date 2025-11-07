package com.google.android.aidl;

/* loaded from: classes.dex */
public class Codecs {
    private static final java.lang.ClassLoader CLASS_LOADER = com.google.android.aidl.Codecs.class.getClassLoader();
    private static final int PARCELABLE_NO_FLAGS = 0;

    private Codecs() {
    }

    public static boolean createBoolean(android.os.Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(android.os.Parcel parcel, boolean z_renamed) {
        parcel.writeInt(z_renamed ? 1 : 0);
    }

    public static java.lang.CharSequence createCharSequence(android.os.Parcel parcel) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public static void writeCharSequence(android.os.Parcel parcel, java.lang.CharSequence charSequence) {
        if (charSequence != null) {
            parcel.writeInt(1);
            android.text.TextUtils.writeToParcel(charSequence, parcel, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeCharSequenceAsReturnValue(android.os.Parcel parcel, java.lang.CharSequence charSequence) {
        if (charSequence != null) {
            parcel.writeInt(1);
            android.text.TextUtils.writeToParcel(charSequence, parcel, 1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static <T_renamed extends android.os.Parcelable> T_renamed createParcelable(android.os.Parcel parcel, android.os.Parcelable.Creator<T_renamed> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void writeParcelable(android.os.Parcel parcel, android.os.Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void writeParcelableAsReturnValue(android.os.Parcel parcel, android.os.Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 1);
        }
    }

    public static void writeStrongBinder(android.os.Parcel parcel, android.os.IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static java.util.ArrayList createList(android.os.Parcel parcel) {
        return parcel.readArrayList(CLASS_LOADER);
    }

    public static void readList(android.os.Parcel parcel, java.util.List<?> list) {
        parcel.readList(list, CLASS_LOADER);
    }

    public static java.util.HashMap createMap(android.os.Parcel parcel) {
        return parcel.readHashMap(CLASS_LOADER);
    }

    public static void readMap(android.os.Parcel parcel, java.util.Map<?, ?> map) {
        parcel.readMap(map, CLASS_LOADER);
    }
}
