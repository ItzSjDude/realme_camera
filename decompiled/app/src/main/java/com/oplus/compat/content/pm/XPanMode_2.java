package com.oplus.compat.content.pm;

/* loaded from: classes2.dex */
public class PackageManagerNative {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f7455a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static int f7456b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static int f7457c;
    public static int d_renamed;
    public static int e_renamed;
    public static int f_renamed;

    private static java.lang.Object a_renamed() {
        return null;
    }

    private static java.lang.Object b_renamed() {
        return null;
    }

    private static java.lang.Object c_renamed() {
        return null;
    }

    private static java.lang.Object d_renamed() {
        return null;
    }

    private static java.lang.Object e_renamed() {
        return null;
    }

    static {
        try {
            if (!com.oplus.compat.b_renamed.a_renamed.c_renamed.a_renamed()) {
                f7455a = 4194304;
            } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                f7455a = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("android.content.pm.PackageManager").setActionName("MATCH_ANY_USER").build()).execute().getBundle().getInt("result");
            } else {
                throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
            }
        } catch (java.lang.Exception e2) {
            android.util.Log.e_renamed("PackageManagerNative", e2.toString());
        }
        try {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
                f7456b = 2;
                f7457c = 64;
                d_renamed = 1;
                e_renamed = 2;
                f_renamed = -3;
                return;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
                f7456b = 2;
                f7457c = 64;
                d_renamed = 1;
                e_renamed = 2;
                f_renamed = -3;
                return;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                f7456b = ((java.lang.Integer) a_renamed()).intValue();
                f7457c = ((java.lang.Integer) b_renamed()).intValue();
                d_renamed = ((java.lang.Integer) c_renamed()).intValue();
                e_renamed = ((java.lang.Integer) d_renamed()).intValue();
                f_renamed = ((java.lang.Integer) e_renamed()).intValue();
                return;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
                f7456b = 2;
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed("PackageManagerNative", th.toString());
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$2, reason: invalid class name */
    static class XPanMode_2 extends android.content.pm.IPackageDeleteObserver.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.compat.content.pm.b_renamed f7458a;

        public void packageDeleted(java.lang.String str, int i_renamed) {
            this.f7458a.a_renamed(str, i_renamed);
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$4, reason: invalid class name */
    static class DoubleExposureMode_3 extends android.content.pm.IPackageDataObserver.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.compat.content.pm.a_renamed f7459a;

        public void onRemoveCompleted(java.lang.String str, boolean z_renamed) throws android.os.RemoteException {
            this.f7459a.a_renamed(str, z_renamed);
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$6, reason: invalid class name */
    static class AnonymousClass6 extends android.content.pm.IPackageDataObserver.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.compat.content.pm.a_renamed f7460a;

        public void onRemoveCompleted(java.lang.String str, boolean z_renamed) throws android.os.RemoteException {
            this.f7460a.a_renamed(str, z_renamed);
        }
    }

    /* renamed from: com.oplus.compat.content.pm.PackageManagerNative$7, reason: invalid class name */
    static class AnonymousClass7 extends android.content.pm.IPackageDataObserver.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.compat.content.pm.a_renamed f7461a;

        public void onRemoveCompleted(java.lang.String str, boolean z_renamed) throws android.os.RemoteException {
            this.f7461a.a_renamed(str, z_renamed);
        }
    }

    private static class PackageDataObserver extends android.content.pm.IPackageDataObserver.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private com.oplus.compat.content.pm.a_renamed f7462a;

        public void onRemoveCompleted(java.lang.String str, boolean z_renamed) throws android.os.RemoteException {
            com.oplus.compat.content.pm.a_renamed aVar = this.f7462a;
            if (aVar != null) {
                aVar.a_renamed(str, z_renamed);
            }
        }
    }
}
