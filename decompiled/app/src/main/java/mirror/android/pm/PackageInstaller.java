package mirror.android.pm;

/* loaded from: classes2.dex */
public class PackageInstaller {
    private static java.lang.Class<?> TYPE = com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) mirror.android.pm.PackageInstaller.class, (java.lang.Class<?>) android.content.pm.PackageInstaller.class);
    public static com.oplus.utils.reflect.RefObject<android.os.IInterface> mInstaller;

    public static class Session {
        private static java.lang.Class<?> TYPE = com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) mirror.android.pm.PackageInstaller.Session.class, (java.lang.Class<?>) android.content.pm.PackageInstaller.Session.class);
        public static com.oplus.utils.reflect.RefObject<android.os.IInterface> mSession;

        public static void setSession(android.content.pm.PackageInstaller.Session session, android.os.IBinder iBinder) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
            mSession.set(session, android.content.pm.IPackageInstallerSession.Stub.asInterface(iBinder));
        }

        public static android.os.IInterface getSession(android.content.pm.PackageInstaller.Session session) {
            return mSession.get(session);
        }
    }
}
