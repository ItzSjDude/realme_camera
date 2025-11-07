package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel abstractC0814a) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(abstractC0814a);
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel abstractC0814a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        androidx.core.app.RemoteActionCompatParcelizer.write(remoteActionCompat, abstractC0814a);
    }
}
