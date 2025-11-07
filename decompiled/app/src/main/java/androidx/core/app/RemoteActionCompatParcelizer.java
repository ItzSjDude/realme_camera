package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel abstractC0814a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2715a = (IconCompat) abstractC0814a.m4933b((VersionedParcel) remoteActionCompat.f2715a, 1);
        remoteActionCompat.f2716b = abstractC0814a.m4934b(remoteActionCompat.f2716b, 2);
        remoteActionCompat.f2717c = abstractC0814a.m4934b(remoteActionCompat.f2717c, 3);
        remoteActionCompat.f2718d = (PendingIntent) abstractC0814a.m4932b((VersionedParcel) remoteActionCompat.f2718d, 4);
        remoteActionCompat.f2719e = abstractC0814a.m4938b(remoteActionCompat.f2719e, 5);
        remoteActionCompat.f2720f = abstractC0814a.m4938b(remoteActionCompat.f2720f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel abstractC0814a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0814a.m4927a(false, false);
        abstractC0814a.m4919a(remoteActionCompat.f2715a, 1);
        abstractC0814a.m4922a(remoteActionCompat.f2716b, 2);
        abstractC0814a.m4922a(remoteActionCompat.f2717c, 3);
        abstractC0814a.m4917a(remoteActionCompat.f2718d, 4);
        abstractC0814a.m4926a(remoteActionCompat.f2719e, 5);
        abstractC0814a.m4926a(remoteActionCompat.f2720f, 6);
    }
}
