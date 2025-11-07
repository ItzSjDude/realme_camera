package androidx.core.app;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static androidx.core.app.RemoteActionCompat read(androidx.versionedparcelable.a_renamed aVar) {
        androidx.core.app.RemoteActionCompat remoteActionCompat = new androidx.core.app.RemoteActionCompat();
        remoteActionCompat.f805a = (androidx.core.graphics.drawable.IconCompat) aVar.b_renamed((androidx.versionedparcelable.a_renamed) remoteActionCompat.f805a, 1);
        remoteActionCompat.f806b = aVar.b_renamed(remoteActionCompat.f806b, 2);
        remoteActionCompat.f807c = aVar.b_renamed(remoteActionCompat.f807c, 3);
        remoteActionCompat.d_renamed = (android.app.PendingIntent) aVar.b_renamed((androidx.versionedparcelable.a_renamed) remoteActionCompat.d_renamed, 4);
        remoteActionCompat.e_renamed = aVar.b_renamed(remoteActionCompat.e_renamed, 5);
        remoteActionCompat.f_renamed = aVar.b_renamed(remoteActionCompat.f_renamed, 6);
        return remoteActionCompat;
    }

    public static void write(androidx.core.app.RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        aVar.a_renamed(false, false);
        aVar.a_renamed(remoteActionCompat.f805a, 1);
        aVar.a_renamed(remoteActionCompat.f806b, 2);
        aVar.a_renamed(remoteActionCompat.f807c, 3);
        aVar.a_renamed(remoteActionCompat.d_renamed, 4);
        aVar.a_renamed(remoteActionCompat.e_renamed, 5);
        aVar.a_renamed(remoteActionCompat.f_renamed, 6);
    }
}
