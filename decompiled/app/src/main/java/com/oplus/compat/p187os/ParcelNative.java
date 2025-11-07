package com.oplus.compat.p187os;

import android.os.Parcel;
import android.util.ArraySet;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.ParcelWrapper;

/* loaded from: classes2.dex */
public class ParcelNative {
    private static final String TAG = "ParcelNative";

    private static Object readArraySetCompat(Parcel parcel, ClassLoader classLoader) {
        return null;
    }

    private static Object readStringArrayCompat(Parcel parcel) {
        return null;
    }

    private static void writeArraySetCompat(Parcel parcel, ArraySet<? extends Object> arraySet) {
    }

    private ParcelNative() {
    }

    public static final String[] readStringArray(Parcel parcel) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return parcel.readStringArray();
        }
        if (VersionUtils.m24886b()) {
            return ParcelWrapper.readStringArray(parcel);
        }
        if (VersionUtils.m24889e()) {
            return (String[]) readStringArrayCompat(parcel);
        }
        if (VersionUtils.m24895k()) {
            return parcel.readStringArray();
        }
        throw new UnSupportedApiVersionException();
    }

    public static ArraySet<? extends Object> readArraySet(Parcel parcel, ClassLoader classLoader) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return parcel.readArraySet(classLoader);
        }
        if (VersionUtils.m24886b()) {
            return ParcelWrapper.readArraySet(parcel, classLoader);
        }
        if (VersionUtils.m24889e()) {
            return (ArraySet) readArraySetCompat(parcel, classLoader);
        }
        throw new UnSupportedApiVersionException();
    }

    public static void writeArraySet(Parcel parcel, ArraySet<? extends Object> arraySet) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            parcel.writeArraySet(arraySet);
        } else if (VersionUtils.m24886b()) {
            ParcelWrapper.writeArraySet(parcel, arraySet);
        } else {
            if (VersionUtils.m24889e()) {
                writeArraySetCompat(parcel, arraySet);
                return;
            }
            throw new UnSupportedApiVersionException();
        }
    }
}
