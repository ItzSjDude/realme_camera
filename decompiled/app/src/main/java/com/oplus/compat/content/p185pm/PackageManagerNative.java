package com.oplus.compat.content.p185pm;

import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDeleteObserver;
import android.os.RemoteException;
import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;

/* loaded from: classes2.dex */
public class PackageManagerNative {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f23266a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int f23267b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int f23268c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int f23269d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static int f23270e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int f23271f;

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m24904a() {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m24905b() {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Object m24906c() {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Object m24907d() {
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Object m24908e() {
        return null;
    }

    static {
        try {
            if (!VersionUtils.m24885a()) {
                f23266a = 4194304;
            } else if (VersionUtils.m24888d()) {
                f23266a = Epona.newCall(new Request.Builder().setComponentName("android.content.pm.PackageManager").setActionName("MATCH_ANY_USER").build()).execute().getBundle().getInt("result");
            } else {
                throw new UnSupportedApiVersionException("not supported before R");
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("PackageManagerNative", COUIBaseListPopupWindow_8.toString());
        }
        try {
            if (VersionUtils.m24887c()) {
                f23267b = 2;
                f23268c = 64;
                f23269d = 1;
                f23270e = 2;
                f23271f = -3;
                return;
            }
            if (VersionUtils.m24886b()) {
                f23267b = 2;
                f23268c = 64;
                f23269d = 1;
                f23270e = 2;
                f23271f = -3;
                return;
            }
            if (VersionUtils.m24889e()) {
                f23267b = ((Integer) m24904a()).intValue();
                f23268c = ((Integer) m24905b()).intValue();
                f23269d = ((Integer) m24906c()).intValue();
                f23270e = ((Integer) m24907d()).intValue();
                f23271f = ((Integer) m24908e()).intValue();
                return;
            }
            if (VersionUtils.m24895k()) {
                f23267b = 2;
                return;
            }
            throw new UnSupportedApiVersionException();
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8("PackageManagerNative", th.toString());
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$2 */
    static class C36012 extends IPackageDeleteObserver.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ IPackageDeleteObserverNative f23272a;

        public void packageDeleted(String str, int OplusGLSurfaceView_13) {
            this.f23272a.m24910a(str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$4 */
    static class C36024 extends IPackageDataObserver.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ IPackageDataObserverNative f23273a;

        public void onRemoveCompleted(String str, boolean z) throws RemoteException {
            this.f23273a.m24909a(str, z);
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$6 */
    static class C36036 extends IPackageDataObserver.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ IPackageDataObserverNative f23274a;

        public void onRemoveCompleted(String str, boolean z) throws RemoteException {
            this.f23274a.m24909a(str, z);
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$7 */
    static class C36047 extends IPackageDataObserver.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ IPackageDataObserverNative f23275a;

        public void onRemoveCompleted(String str, boolean z) throws RemoteException {
            this.f23275a.m24909a(str, z);
        }
    }

    private static class PackageDataObserver extends IPackageDataObserver.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private IPackageDataObserverNative f23276a;

        public void onRemoveCompleted(String str, boolean z) throws RemoteException {
            IPackageDataObserverNative interfaceC3605a = this.f23276a;
            if (interfaceC3605a != null) {
                interfaceC3605a.m24909a(str, z);
            }
        }
    }
}
