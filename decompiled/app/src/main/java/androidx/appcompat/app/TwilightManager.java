package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.p027a.PermissionChecker;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* renamed from: androidx.appcompat.app.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
class TwilightManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static TwilightManager f1040a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Context f1041b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LocationManager f1042c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final PlatformImplementations.kt_3 f1043d = new PlatformImplementations.kt_3();

    /* renamed from: PlatformImplementations.kt_3 */
    static TwilightManager m939a(Context context) {
        if (f1040a == null) {
            Context applicationContext = context.getApplicationContext();
            f1040a = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION));
        }
        return f1040a;
    }

    TwilightManager(Context context, LocationManager locationManager) {
        this.f1041b = context;
        this.f1042c = locationManager;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m943a() {
        PlatformImplementations.kt_3 aVar = this.f1043d;
        if (m942c()) {
            return aVar.f1044a;
        }
        Location locationM941b = m941b();
        if (locationM941b != null) {
            m940a(locationM941b);
            return aVar.f1044a;
        }
        Log.OplusGLSurfaceView_13("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int OplusGLSurfaceView_13 = Calendar.getInstance().get(11);
        return OplusGLSurfaceView_13 < 6 || OplusGLSurfaceView_13 >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: IntrinsicsJvm.kt_4 */
    private Location m941b() {
        Location locationM938a = PermissionChecker.m2335a(this.f1041b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m938a(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK) : null;
        Location locationM938a2 = PermissionChecker.m2335a(this.f1041b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? m938a("gps") : null;
        return (locationM938a2 == null || locationM938a == null) ? locationM938a2 != null ? locationM938a2 : locationM938a : locationM938a2.getTime() > locationM938a.getTime() ? locationM938a2 : locationM938a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Location m938a(String str) {
        try {
            if (this.f1042c.isProviderEnabled(str)) {
                return this.f1042c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.IntrinsicsJvm.kt_5("TwilightManager", "Failed to get last known location", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m942c() {
        return this.f1043d.f1049f > System.currentTimeMillis();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m940a(Location location) {
        long OplusGLSurfaceView_15;
        PlatformImplementations.kt_3 aVar = this.f1043d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        TwilightCalculator c0212jM936a = TwilightCalculator.m936a();
        c0212jM936a.m937a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = c0212jM936a.f1037a;
        c0212jM936a.m937a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = c0212jM936a.f1039c == 1;
        long j3 = c0212jM936a.f1038b;
        long j4 = c0212jM936a.f1037a;
        c0212jM936a.m937a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j5 = c0212jM936a.f1038b;
        if (j3 == -1 || j4 == -1) {
            OplusGLSurfaceView_15 = 43200000 + jCurrentTimeMillis;
        } else {
            OplusGLSurfaceView_15 = (jCurrentTimeMillis > j4 ? 0 + j5 : jCurrentTimeMillis > j3 ? 0 + j4 : 0 + j3) + DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
        }
        aVar.f1044a = z;
        aVar.f1045b = j2;
        aVar.f1046c = j3;
        aVar.f1047d = j4;
        aVar.f1048e = j5;
        aVar.f1049f = OplusGLSurfaceView_15;
    }

    /* compiled from: TwilightManager.java */
    /* renamed from: androidx.appcompat.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f1044a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        long f1045b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        long f1046c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        long f1047d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        long f1048e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        long f1049f;

        PlatformImplementations.kt_3() {
        }
    }
}
