package androidx.appcompat.app;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static androidx.appcompat.app.k_renamed f285a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.Context f286b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.location.LocationManager f287c;
    private final androidx.appcompat.app.k_renamed.a_renamed d_renamed = new androidx.appcompat.app.k_renamed.a_renamed();

    static androidx.appcompat.app.k_renamed a_renamed(android.content.Context context) {
        if (f285a == null) {
            android.content.Context applicationContext = context.getApplicationContext();
            f285a = new androidx.appcompat.app.k_renamed(applicationContext, (android.location.LocationManager) applicationContext.getSystemService(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_LOCATION));
        }
        return f285a;
    }

    k_renamed(android.content.Context context, android.location.LocationManager locationManager) {
        this.f286b = context;
        this.f287c = locationManager;
    }

    boolean a_renamed() {
        androidx.appcompat.app.k_renamed.a_renamed aVar = this.d_renamed;
        if (c_renamed()) {
            return aVar.f288a;
        }
        android.location.Location locationB = b_renamed();
        if (locationB != null) {
            a_renamed(locationB);
            return aVar.f288a;
        }
        android.util.Log.i_renamed("TwilightManager", "Could not get last known location. This is_renamed probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i_renamed = java.util.Calendar.getInstance().get(11);
        return i_renamed < 6 || i_renamed >= 22;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private android.location.Location b_renamed() {
        android.location.Location locationA = androidx.core.a_renamed.c_renamed.a_renamed(this.f286b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a_renamed(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK) : null;
        android.location.Location locationA2 = androidx.core.a_renamed.c_renamed.a_renamed(this.f286b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a_renamed("gps") : null;
        return (locationA2 == null || locationA == null) ? locationA2 != null ? locationA2 : locationA : locationA2.getTime() > locationA.getTime() ? locationA2 : locationA;
    }

    private android.location.Location a_renamed(java.lang.String str) {
        try {
            if (this.f287c.isProviderEnabled(str)) {
                return this.f287c.getLastKnownLocation(str);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.d_renamed("TwilightManager", "Failed to get last known location", e_renamed);
            return null;
        }
    }

    private boolean c_renamed() {
        return this.d_renamed.f_renamed > java.lang.System.currentTimeMillis();
    }

    private void a_renamed(android.location.Location location) {
        long j_renamed;
        androidx.appcompat.app.k_renamed.a_renamed aVar = this.d_renamed;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        androidx.appcompat.app.j_renamed jVarA = androidx.appcompat.app.j_renamed.a_renamed();
        jVarA.a_renamed(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = jVarA.f282a;
        jVarA.a_renamed(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z_renamed = jVarA.f284c == 1;
        long j3 = jVarA.f283b;
        long j4 = jVarA.f282a;
        jVarA.a_renamed(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j5 = jVarA.f283b;
        if (j3 == -1 || j4 == -1) {
            j_renamed = 43200000 + jCurrentTimeMillis;
        } else {
            j_renamed = (jCurrentTimeMillis > j4 ? 0 + j5 : jCurrentTimeMillis > j3 ? 0 + j4 : 0 + j3) + com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
        }
        aVar.f288a = z_renamed;
        aVar.f289b = j2;
        aVar.f290c = j3;
        aVar.d_renamed = j4;
        aVar.e_renamed = j5;
        aVar.f_renamed = j_renamed;
    }

    /* compiled from: TwilightManager.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f288a;

        /* renamed from: b_renamed, reason: collision with root package name */
        long f289b;

        /* renamed from: c_renamed, reason: collision with root package name */
        long f290c;
        long d_renamed;
        long e_renamed;
        long f_renamed;

        a_renamed() {
        }
    }
}
