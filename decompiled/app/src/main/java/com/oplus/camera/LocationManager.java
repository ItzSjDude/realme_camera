package com.oplus.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: LocationManager.java */
/* renamed from: com.oplus.camera.q */
/* loaded from: classes2.dex */
public class LocationManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f15826a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f15827b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LocationManager f15828c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f15829d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f15830e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Handler f15831f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private HandlerThread f15832g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Runnable f15833h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Runnable f15834i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ArrayList<COUIBaseListPopupWindow_12> f15835j;

    /* renamed from: OplusGLSurfaceView_5 */
    private String f15836k;

    /* renamed from: OplusGLSurfaceView_14 */
    private COUIBaseListPopupWindow_8[] f15837l;

    /* compiled from: LocationManager.java */
    /* renamed from: com.oplus.camera.q$COUIBaseListPopupWindow_12 */
    public interface COUIBaseListPopupWindow_12 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10913a(Location location, boolean z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LocationManager m16155a() {
        return IntrinsicsJvm.kt_5.f15854a;
    }

    private LocationManager() {
        this.f15826a = 0L;
        this.f15827b = null;
        this.f15828c = null;
        this.f15829d = "off";
        this.f15830e = "off";
        this.f15831f = null;
        this.f15832g = null;
        this.f15833h = null;
        this.f15834i = null;
        this.f15835j = null;
        this.f15836k = null;
        this.f15837l = new COUIBaseListPopupWindow_8[]{new COUIBaseListPopupWindow_8("gps"), new COUIBaseListPopupWindow_8(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK)};
        this.f15827b = MyApplication.m11092d();
        this.f15835j = new ArrayList<>();
        this.f15832g = new HandlerThread("LocationManagerHandlerThread");
        this.f15832g.start();
        this.f15831f = new Handler(this.f15832g.getLooper());
        this.f15833h = new IntrinsicsJvm.kt_4();
        this.f15834i = new IntrinsicsJvm.kt_3();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m16175a(COUIBaseListPopupWindow_12 fVar) {
        CameraLog.m12954a("LocationManager", "registerLocationListener, listener: " + fVar);
        if (fVar != null && !this.f15835j.contains(fVar)) {
            this.f15835j.add(fVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m16179b(COUIBaseListPopupWindow_12 fVar) {
        CameraLog.m12954a("LocationManager", "unRegisterLocationListener, listener: " + fVar);
        if (fVar == null) {
            return;
        }
        this.f15835j.remove(fVar);
        if (!m16166g()) {
            CameraLog.m12954a("LocationManager", "unRegisterLocationListener, remove");
            m16172m();
            CameraLog.m12954a("LocationManager", "unRegisterLocationListener, stopReceivingLocationUpdates start");
            m16170k();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m16177b() {
        String str = this.f15836k;
        return str != null ? str : "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16176a(String str) {
        this.f15836k = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized boolean m16166g() {
        return !this.f15835j.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m16156a(Location location, boolean z) {
        CameraLog.m12954a("LocationManager", "callbackAllListener, hasRegisterListener: " + m16166g());
        if (m16166g()) {
            Iterator<COUIBaseListPopupWindow_12> it = this.f15835j.iterator();
            while (it.hasNext()) {
                it.next().mo10913a(location, z);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Location m16180c() {
        if (("off".equals(this.f15829d) && "off".equals(this.f15830e)) || this.f15837l == null) {
            return null;
        }
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            COUIBaseListPopupWindow_8[] eVarArr = this.f15837l;
            if (OplusGLSurfaceView_13 < eVarArr.length) {
                Location locationM16217a = eVarArr[OplusGLSurfaceView_13].m16217a();
                if (locationM16217a != null) {
                    return locationM16217a;
                }
                OplusGLSurfaceView_13++;
            } else {
                CameraLog.m12954a("LocationManager", "getCurrentLocation, No location received yet.");
                return null;
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: IntrinsicsJvm.kt_5 */
    public Location m16181d() {
        LocationManager locationManager = this.f15828c;
        if (locationManager != null) {
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            Location lastKnownLocation2 = this.f15828c.getLastKnownLocation(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
            if (lastKnownLocation == null) {
                lastKnownLocation = null;
            }
            if (lastKnownLocation2 == null) {
                lastKnownLocation2 = lastKnownLocation;
            }
            if (lastKnownLocation2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - lastKnownLocation2.getTime();
                if (600000 > jCurrentTimeMillis) {
                    return lastKnownLocation2;
                }
                CameraLog.m12954a("LocationManager", "last location past time: " + jCurrentTimeMillis);
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16174a(ComboPreferences comboPreferences) {
        if (Util.m24504x(this.f15827b)) {
            this.f15829d = comboPreferences.getString(CameraUIInterface.KEY_RECORD_LOCATION, this.f15827b.getString(R.string.camera_location_default_value));
            this.f15830e = BaseSloganUtil.m11672a(this.f15827b, comboPreferences) ? "on" : "off";
        } else {
            this.f15829d = "off";
            this.f15830e = "off";
            BaseSloganUtil.m11681b(this.f15827b, comboPreferences);
            SharedPreferences.Editor editorEdit = comboPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_RECORD_LOCATION, "off");
            editorEdit.apply();
        }
        boolean zM16161c = m16161c(comboPreferences);
        CameraLog.m12954a("LocationManager", "updateAllState, mRecordLocationState: " + this.f15829d + ", isLocationSloganOpen: " + m16183f() + ", allowNetworkAccess: " + zM16161c);
        if (("on".equals(this.f15829d) || m16183f()) && zM16161c) {
            if (System.currentTimeMillis() - this.f15826a >= 600000) {
                CameraLog.m12954a("LocationManager", "updateAllState, location is invalid");
                COUIBaseListPopupWindow_8[] eVarArr = this.f15837l;
                if (eVarArr[0] != null) {
                    eVarArr[0].m16218a(false);
                }
                COUIBaseListPopupWindow_8[] eVarArr2 = this.f15837l;
                if (eVarArr2[1] != null) {
                    eVarArr2[1].m16218a(false);
                }
            }
            m16178b(comboPreferences);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16173a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            if (Util.m24504x(this.f15827b)) {
                sharedPreferences.edit().putString(CameraUIInterface.KEY_RECORD_LOCATION, "on").apply();
                this.f15829d = "on";
            } else {
                sharedPreferences.edit().putString(CameraUIInterface.KEY_RECORD_LOCATION, "off").apply();
                this.f15829d = "off";
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m16182e() {
        return this.f15829d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m16183f() {
        return "on".equals(this.f15830e);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16178b(ComboPreferences comboPreferences) {
        if (m16166g() && m16167h() && m16161c(comboPreferences)) {
            CameraLog.m12954a("LocationManager", "requestLocation");
            if ("on".equals(this.f15829d) || "on".equals(this.f15830e)) {
                m16168i();
            } else {
                m16170k();
                m16172m();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m16167h() {
        return this.f15827b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: OplusGLSurfaceView_13 */
    private void m16168i() {
        Location lastKnownLocation;
        if (this.f15828c == null) {
            this.f15828c = (LocationManager) this.f15827b.getApplicationContext().getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION);
        }
        LocationManager locationManager = this.f15828c;
        if (locationManager != null && (lastKnownLocation = locationManager.getLastKnownLocation(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK)) != null && m16166g() && System.currentTimeMillis() - lastKnownLocation.getTime() < 360000) {
            m16156a(lastKnownLocation, true);
        }
        LocationManager locationManager2 = this.f15828c;
        if (locationManager2 != null) {
            boolean zIsProviderEnabled = locationManager2.isProviderEnabled(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
            CameraLog.m12954a("LocationManager", "startReceivingLocationUpdates, ntpEnable: " + zIsProviderEnabled);
            if (zIsProviderEnabled) {
                try {
                    this.f15828c.requestLocationUpdates(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, 1000L, 300.0f, this.f15837l[1]);
                } catch (IllegalArgumentException e2) {
                    CameraLog.m12959b("LocationManager", "startReceivingLocationUpdates, provider does not exist" + e2.getMessage());
                } catch (SecurityException e3) {
                    CameraLog.m12960b("LocationManager", "startReceivingLocationUpdates, fail to request location update", e3);
                }
                this.f15831f.postDelayed(this.f15833h, 3000L);
                return;
            }
            m16169j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m16169j() {
        CameraLog.m12954a("LocationManager", "startGpsReceivingLocationUpdates, hasRegisterListener: " + m16166g());
        if (m16166g()) {
            if (this.f15828c == null) {
                this.f15828c = (LocationManager) this.f15827b.getApplicationContext().getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION);
            }
            this.f15831f.post(new Runnable() { // from class: com.oplus.camera.q.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CameraLog.m12959b("LocationManager", "startGpsReceivingLocationUpdates, requestLocationUpdates post to handler thread");
                        LocationManager.this.f15828c.requestLocationUpdates("gps", 1000L, 300.0f, LocationManager.this.f15837l[0]);
                    } catch (IllegalArgumentException e2) {
                        CameraLog.m12967f("LocationManager", "startGpsReceivingLocationUpdates, provider does not exist" + e2.getMessage());
                    } catch (SecurityException e3) {
                        CameraLog.m12965d("LocationManager", "startGpsReceivingLocationUpdates, fail to request location update", e3);
                    }
                    if (LocationManager.this.f15831f != null) {
                        LocationManager.this.f15831f.postDelayed(LocationManager.this.f15834i, 45000L);
                    }
                    CameraLog.m12954a("LocationManager", "startGpsReceivingLocationUpdates, post GPS timeout runnable");
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m16170k() {
        if (this.f15828c == null) {
            return;
        }
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            COUIBaseListPopupWindow_8[] eVarArr = this.f15837l;
            if (OplusGLSurfaceView_13 < eVarArr.length) {
                try {
                    this.f15828c.removeUpdates(eVarArr[OplusGLSurfaceView_13]);
                } catch (Exception e2) {
                    CameraLog.m12956a("LocationManager", "stopReceivingLocationUpdates, fail to remove location listners", e2);
                }
                OplusGLSurfaceView_13++;
            } else {
                CameraLog.m12954a("LocationManager", "stopReceivingLocationUpdates");
                return;
            }
        }
    }

    /* compiled from: LocationManager.java */
    /* renamed from: com.oplus.camera.q$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 implements Runnable {
        public IntrinsicsJvm.kt_4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationManager.this.f15837l != null && LocationManager.this.m16180c() == null && LocationManager.this.m16166g()) {
                LocationManager.this.m16169j();
            }
        }
    }

    /* compiled from: LocationManager.java */
    /* renamed from: com.oplus.camera.q$IntrinsicsJvm.kt_3 */
    public class IntrinsicsJvm.kt_3 implements Runnable {
        public IntrinsicsJvm.kt_3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationManager.this.m16171l();
        }
    }

    /* compiled from: LocationManager.java */
    /* renamed from: com.oplus.camera.q$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 implements LocationListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Location f15856b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f15857c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f15858d;

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        public COUIBaseListPopupWindow_8(String str) {
            this.f15858d = str;
            this.f15856b = new Location(this.f15858d);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m16218a(boolean z) {
            this.f15857c = z;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) {
                return;
            }
            if (!LocationManager.this.m16166g()) {
                CameraLog.m12954a("LocationManager", "onLocationChanged when listener is Empty, so return");
                return;
            }
            CameraLog.m12959b("LocationManager", "LocationListener, onLocationChanged, mProvider: " + this.f15858d + ", mbValid: " + this.f15857c);
            LocationManager.this.f15826a = System.currentTimeMillis();
            this.f15856b.set(location);
            this.f15857c = true;
            LocationManager.this.m16156a(location, false);
            LocationManager.this.m16171l();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            CameraLog.m12954a("LocationManager", "onProviderDisabled, mbValid: " + this.f15857c);
            this.f15857c = false;
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int OplusGLSurfaceView_13, Bundle bundle) {
            CameraLog.m12954a("LocationManager", "onStatusChanged, status: " + OplusGLSurfaceView_13 + ", mbValid: " + this.f15857c);
            if (OplusGLSurfaceView_13 != 0) {
                return;
            }
            this.f15857c = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Location m16217a() {
            if (this.f15857c) {
                return this.f15856b;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m16171l() {
        m16172m();
        LocationManager locationManager = this.f15828c;
        if (locationManager != null) {
            COUIBaseListPopupWindow_8[] eVarArr = this.f15837l;
            if (eVarArr[0] == null) {
                return;
            }
            try {
                locationManager.removeUpdates(eVarArr[0]);
            } catch (Exception e2) {
                CameraLog.m12956a("LocationManager", "stopGpsReceivingLocationUpdates, fail to remove location listeners", e2);
            }
            CameraLog.m12954a("LocationManager", "stopGpsReceivingLocationUpdates X");
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m16172m() {
        Handler handler = this.f15831f;
        if (handler != null) {
            handler.removeCallbacks(this.f15833h);
            this.f15831f.removeCallbacks(this.f15834i);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m16161c(ComboPreferences comboPreferences) {
        return RegionCommonFeatureAdapter.m14534c() || comboPreferences.getBoolean("pref_allow_network_access", false);
    }

    /* compiled from: LocationManager.java */
    /* renamed from: com.oplus.camera.q$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public String f15839a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String f15840b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String f15841c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public String f15842d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public String f15843e = null;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public String f15844f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public String f15845g = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public String f15846h = null;

        /* renamed from: OplusGLSurfaceView_13 */
        public Location f15847i = null;

        /* renamed from: PlatformImplementations.kt_3 */
        public void m16185a(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15845g = str;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m16186b(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15844f = str;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m16187c(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15843e = str;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m16188d(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15842d = str;
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m16189e(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15841c = str;
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m16190f(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15840b = str;
            }
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m16191g(String str) {
            if (TextUtils.isEmpty(str) || !m16184a().contains(str)) {
                this.f15839a = str;
            }
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public void m16192h(String str) {
            this.f15846h = str;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private HashSet<String> m16184a() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(this.f15845g);
            hashSet.add(this.f15844f);
            hashSet.add(this.f15843e);
            hashSet.add(this.f15842d);
            hashSet.add(this.f15841c);
            hashSet.add(this.f15840b);
            hashSet.add(this.f15839a);
            return hashSet;
        }

        public String toString() {
            return this.f15845g + "_" + this.f15844f + "_" + this.f15843e + "_" + this.f15842d + "_" + this.f15841c + "_" + this.f15840b + "_" + this.f15839a + "_";
        }
    }

    /* compiled from: LocationManager.java */
    /* renamed from: com.oplus.camera.q$IntrinsicsJvm.kt_5 */
    private static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        @SuppressLint({"StaticFieldLeak"})
        private static LocationManager f15854a = new LocationManager();
    }
}
