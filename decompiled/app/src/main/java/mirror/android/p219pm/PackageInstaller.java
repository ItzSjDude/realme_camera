package mirror.android.p219pm;

import android.content.pm.IPackageInstallerSession;
import android.content.pm.PackageInstaller;
import android.os.IBinder;
import android.os.IInterface;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes2.dex */
public class PackageInstaller {
    private static Class<?> TYPE = RefClass.load((Class<?>) PackageInstaller.class, (Class<?>) android.content.pm.PackageInstaller.class);
    public static RefObject<IInterface> mInstaller;

    public static class Session {
        private static Class<?> TYPE = RefClass.load((Class<?>) Session.class, (Class<?>) PackageInstaller.Session.class);
        public static RefObject<IInterface> mSession;

        public static void setSession(PackageInstaller.Session session, IBinder iBinder) throws IllegalAccessException, IllegalArgumentException {
            mSession.set(session, IPackageInstallerSession.Stub.asInterface(iBinder));
        }

        public static IInterface getSession(PackageInstaller.Session session) {
            return mSession.get(session);
        }
    }
}
