package com.oplus.camera;

/* compiled from: LocationManager.java */
/* loaded from: classes2.dex */
public class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f5288a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f5289b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.location.LocationManager f5290c;
    private java.lang.String d_renamed;
    private java.lang.String e_renamed;
    private android.os.Handler f_renamed;
    private android.os.HandlerThread g_renamed;
    private java.lang.Runnable h_renamed;
    private java.lang.Runnable i_renamed;
    private java.util.ArrayList<com.oplus.camera.q_renamed.f_renamed> j_renamed;
    private java.lang.String k_renamed;
    private com.oplus.camera.q_renamed.e_renamed[] l_renamed;

    /* compiled from: LocationManager.java */
    public interface f_renamed {
        void a_renamed(android.location.Location location, boolean z_renamed);
    }

    public static com.oplus.camera.q_renamed a_renamed() {
        return com.oplus.camera.q_renamed.d_renamed.f5300a;
    }

    private q_renamed() {
        this.f5288a = 0L;
        this.f5289b = null;
        this.f5290c = null;
        this.d_renamed = "off";
        this.e_renamed = "off";
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = new com.oplus.camera.q_renamed.e_renamed[]{new com.oplus.camera.q_renamed.e_renamed("gps"), new com.oplus.camera.q_renamed.e_renamed(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK)};
        this.f5289b = com.oplus.camera.MyApplication.d_renamed();
        this.j_renamed = new java.util.ArrayList<>();
        this.g_renamed = new android.os.HandlerThread("LocationManagerHandlerThread");
        this.g_renamed.start();
        this.f_renamed = new android.os.Handler(this.g_renamed.getLooper());
        this.h_renamed = new com.oplus.camera.q_renamed.b_renamed();
        this.i_renamed = new com.oplus.camera.q_renamed.c_renamed();
    }

    public synchronized void a_renamed(com.oplus.camera.q_renamed.f_renamed fVar) {
        com.oplus.camera.e_renamed.a_renamed("LocationManager", "registerLocationListener, listener: " + fVar);
        if (fVar != null && !this.j_renamed.contains(fVar)) {
            this.j_renamed.add(fVar);
        }
    }

    public synchronized void b_renamed(com.oplus.camera.q_renamed.f_renamed fVar) {
        com.oplus.camera.e_renamed.a_renamed("LocationManager", "unRegisterLocationListener, listener: " + fVar);
        if (fVar == null) {
            return;
        }
        this.j_renamed.remove(fVar);
        if (!g_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "unRegisterLocationListener, remove");
            m_renamed();
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "unRegisterLocationListener, stopReceivingLocationUpdates start");
            k_renamed();
        }
    }

    public java.lang.String b_renamed() {
        java.lang.String str = this.k_renamed;
        return str != null ? str : "";
    }

    public void a_renamed(java.lang.String str) {
        this.k_renamed = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean g_renamed() {
        return !this.j_renamed.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a_renamed(android.location.Location location, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LocationManager", "callbackAllListener, hasRegisterListener: " + g_renamed());
        if (g_renamed()) {
            java.util.Iterator<com.oplus.camera.q_renamed.f_renamed> it = this.j_renamed.iterator();
            while (it.hasNext()) {
                it.next().a_renamed(location, z_renamed);
            }
        }
    }

    public android.location.Location c_renamed() {
        if (("off".equals(this.d_renamed) && "off".equals(this.e_renamed)) || this.l_renamed == null) {
            return null;
        }
        int i_renamed = 0;
        while (true) {
            com.oplus.camera.q_renamed.e_renamed[] eVarArr = this.l_renamed;
            if (i_renamed < eVarArr.length) {
                android.location.Location locationA = eVarArr[i_renamed].a_renamed();
                if (locationA != null) {
                    return locationA;
                }
                i_renamed++;
            } else {
                com.oplus.camera.e_renamed.a_renamed("LocationManager", "getCurrentLocation, No location received yet.");
                return null;
            }
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public android.location.Location d_renamed() {
        android.location.LocationManager locationManager = this.f5290c;
        if (locationManager != null) {
            android.location.Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            android.location.Location lastKnownLocation2 = this.f5290c.getLastKnownLocation(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
            if (lastKnownLocation == null) {
                lastKnownLocation = null;
            }
            if (lastKnownLocation2 == null) {
                lastKnownLocation2 = lastKnownLocation;
            }
            if (lastKnownLocation2 != null) {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - lastKnownLocation2.getTime();
                if (600000 > jCurrentTimeMillis) {
                    return lastKnownLocation2;
                }
                com.oplus.camera.e_renamed.a_renamed("LocationManager", "last location past time: " + jCurrentTimeMillis);
            }
        }
        return null;
    }

    public void a_renamed(com.oplus.camera.ComboPreferences comboPreferences) {
        if (com.oplus.camera.util.Util.x_renamed(this.f5289b)) {
            this.d_renamed = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, this.f5289b.getString(com.oplus.camera.R_renamed.string.camera_location_default_value));
            this.e_renamed = com.oplus.camera.c_renamed.a_renamed(this.f5289b, comboPreferences) ? "on_renamed" : "off";
        } else {
            this.d_renamed = "off";
            this.e_renamed = "off";
            com.oplus.camera.c_renamed.b_renamed(this.f5289b, comboPreferences);
            android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "off");
            editorEdit.apply();
        }
        boolean zC = c_renamed(comboPreferences);
        com.oplus.camera.e_renamed.a_renamed("LocationManager", "updateAllState, mRecordLocationState: " + this.d_renamed + ", isLocationSloganOpen: " + f_renamed() + ", allowNetworkAccess: " + zC);
        if (("on_renamed".equals(this.d_renamed) || f_renamed()) && zC) {
            if (java.lang.System.currentTimeMillis() - this.f5288a >= 600000) {
                com.oplus.camera.e_renamed.a_renamed("LocationManager", "updateAllState, location is_renamed invalid");
                com.oplus.camera.q_renamed.e_renamed[] eVarArr = this.l_renamed;
                if (eVarArr[0] != null) {
                    eVarArr[0].a_renamed(false);
                }
                com.oplus.camera.q_renamed.e_renamed[] eVarArr2 = this.l_renamed;
                if (eVarArr2[1] != null) {
                    eVarArr2[1].a_renamed(false);
                }
            }
            b_renamed(comboPreferences);
        }
    }

    public void a_renamed(android.content.SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            if (com.oplus.camera.util.Util.x_renamed(this.f5289b)) {
                sharedPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "on_renamed").apply();
                this.d_renamed = "on_renamed";
            } else {
                sharedPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "off").apply();
                this.d_renamed = "off";
            }
        }
    }

    public java.lang.String e_renamed() {
        return this.d_renamed;
    }

    public boolean f_renamed() {
        return "on_renamed".equals(this.e_renamed);
    }

    public void b_renamed(com.oplus.camera.ComboPreferences comboPreferences) {
        if (g_renamed() && h_renamed() && c_renamed(comboPreferences)) {
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "requestLocation");
            if ("on_renamed".equals(this.d_renamed) || "on_renamed".equals(this.e_renamed)) {
                i_renamed();
            } else {
                k_renamed();
                m_renamed();
            }
        }
    }

    private boolean h_renamed() {
        return this.f5289b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private void i_renamed() {
        android.location.Location lastKnownLocation;
        if (this.f5290c == null) {
            this.f5290c = (android.location.LocationManager) this.f5289b.getApplicationContext().getSystemService(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_LOCATION);
        }
        android.location.LocationManager locationManager = this.f5290c;
        if (locationManager != null && (lastKnownLocation = locationManager.getLastKnownLocation(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK)) != null && g_renamed() && java.lang.System.currentTimeMillis() - lastKnownLocation.getTime() < 360000) {
            a_renamed(lastKnownLocation, true);
        }
        android.location.LocationManager locationManager2 = this.f5290c;
        if (locationManager2 != null) {
            boolean zIsProviderEnabled = locationManager2.isProviderEnabled(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "startReceivingLocationUpdates, ntpEnable: " + zIsProviderEnabled);
            if (zIsProviderEnabled) {
                try {
                    this.f5290c.requestLocationUpdates(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, 1000L, 300.0f, this.l_renamed[1]);
                } catch (java.lang.IllegalArgumentException e2) {
                    com.oplus.camera.e_renamed.b_renamed("LocationManager", "startReceivingLocationUpdates, provider does not exist" + e2.getMessage());
                } catch (java.lang.SecurityException e3) {
                    com.oplus.camera.e_renamed.b_renamed("LocationManager", "startReceivingLocationUpdates, fail to request location update", e3);
                }
                this.f_renamed.postDelayed(this.h_renamed, 3000L);
                return;
            }
            j_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("LocationManager", "startGpsReceivingLocationUpdates, hasRegisterListener: " + g_renamed());
        if (g_renamed()) {
            if (this.f5290c == null) {
                this.f5290c = (android.location.LocationManager) this.f5289b.getApplicationContext().getSystemService(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_LOCATION);
            }
            this.f_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.q_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.oplus.camera.e_renamed.b_renamed("LocationManager", "startGpsReceivingLocationUpdates, requestLocationUpdates post to handler thread");
                        com.oplus.camera.q_renamed.this.f5290c.requestLocationUpdates("gps", 1000L, 300.0f, com.oplus.camera.q_renamed.this.l_renamed[0]);
                    } catch (java.lang.IllegalArgumentException e2) {
                        com.oplus.camera.e_renamed.f_renamed("LocationManager", "startGpsReceivingLocationUpdates, provider does not exist" + e2.getMessage());
                    } catch (java.lang.SecurityException e3) {
                        com.oplus.camera.e_renamed.d_renamed("LocationManager", "startGpsReceivingLocationUpdates, fail to request location update", e3);
                    }
                    if (com.oplus.camera.q_renamed.this.f_renamed != null) {
                        com.oplus.camera.q_renamed.this.f_renamed.postDelayed(com.oplus.camera.q_renamed.this.i_renamed, 45000L);
                    }
                    com.oplus.camera.e_renamed.a_renamed("LocationManager", "startGpsReceivingLocationUpdates, post GPS timeout runnable");
                }
            });
        }
    }

    private void k_renamed() {
        if (this.f5290c == null) {
            return;
        }
        int i_renamed = 0;
        while (true) {
            com.oplus.camera.q_renamed.e_renamed[] eVarArr = this.l_renamed;
            if (i_renamed < eVarArr.length) {
                try {
                    this.f5290c.removeUpdates(eVarArr[i_renamed]);
                } catch (java.lang.Exception e2) {
                    com.oplus.camera.e_renamed.a_renamed("LocationManager", "stopReceivingLocationUpdates, fail to remove location listners", e2);
                }
                i_renamed++;
            } else {
                com.oplus.camera.e_renamed.a_renamed("LocationManager", "stopReceivingLocationUpdates");
                return;
            }
        }
    }

    /* compiled from: LocationManager.java */
    public class b_renamed implements java.lang.Runnable {
        public b_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.oplus.camera.q_renamed.this.l_renamed != null && com.oplus.camera.q_renamed.this.c_renamed() == null && com.oplus.camera.q_renamed.this.g_renamed()) {
                com.oplus.camera.q_renamed.this.j_renamed();
            }
        }
    }

    /* compiled from: LocationManager.java */
    public class c_renamed implements java.lang.Runnable {
        public c_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.oplus.camera.q_renamed.this.l_renamed();
        }
    }

    /* compiled from: LocationManager.java */
    private class e_renamed implements android.location.LocationListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.location.Location f5302b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f5303c = false;
        private java.lang.String d_renamed;

        @Override // android.location.LocationListener
        public void onProviderEnabled(java.lang.String str) {
        }

        public e_renamed(java.lang.String str) {
            this.d_renamed = str;
            this.f5302b = new android.location.Location(this.d_renamed);
        }

        public void a_renamed(boolean z_renamed) {
            this.f5303c = z_renamed;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(android.location.Location location) {
            if (location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) {
                return;
            }
            if (!com.oplus.camera.q_renamed.this.g_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("LocationManager", "onLocationChanged when listener is_renamed Empty, so return");
                return;
            }
            com.oplus.camera.e_renamed.b_renamed("LocationManager", "LocationListener, onLocationChanged, mProvider: " + this.d_renamed + ", mbValid: " + this.f5303c);
            com.oplus.camera.q_renamed.this.f5288a = java.lang.System.currentTimeMillis();
            this.f5302b.set(location);
            this.f5303c = true;
            com.oplus.camera.q_renamed.this.a_renamed(location, false);
            com.oplus.camera.q_renamed.this.l_renamed();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(java.lang.String str) {
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "onProviderDisabled, mbValid: " + this.f5303c);
            this.f5303c = false;
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(java.lang.String str, int i_renamed, android.os.Bundle bundle) {
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "onStatusChanged, status: " + i_renamed + ", mbValid: " + this.f5303c);
            if (i_renamed != 0) {
                return;
            }
            this.f5303c = false;
        }

        public android.location.Location a_renamed() {
            if (this.f5303c) {
                return this.f5302b;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        m_renamed();
        android.location.LocationManager locationManager = this.f5290c;
        if (locationManager != null) {
            com.oplus.camera.q_renamed.e_renamed[] eVarArr = this.l_renamed;
            if (eVarArr[0] == null) {
                return;
            }
            try {
                locationManager.removeUpdates(eVarArr[0]);
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.a_renamed("LocationManager", "stopGpsReceivingLocationUpdates, fail to remove location listeners", e2);
            }
            com.oplus.camera.e_renamed.a_renamed("LocationManager", "stopGpsReceivingLocationUpdates X_renamed");
        }
    }

    private void m_renamed() {
        android.os.Handler handler = this.f_renamed;
        if (handler != null) {
            handler.removeCallbacks(this.h_renamed);
            this.f_renamed.removeCallbacks(this.i_renamed);
        }
    }

    private boolean c_renamed(com.oplus.camera.ComboPreferences comboPreferences) {
        return com.oplus.camera.l_renamed.c_renamed.c_renamed() || comboPreferences.getBoolean("pref_allow_network_access", false);
    }

    /* compiled from: LocationManager.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public java.lang.String f5292a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.lang.String f5293b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.lang.String f5294c = null;
        public java.lang.String d_renamed = null;
        public java.lang.String e_renamed = null;
        public java.lang.String f_renamed = null;
        public java.lang.String g_renamed = null;
        public java.lang.String h_renamed = null;
        public android.location.Location i_renamed = null;

        public void a_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.g_renamed = str;
            }
        }

        public void b_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.f_renamed = str;
            }
        }

        public void c_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.e_renamed = str;
            }
        }

        public void d_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.d_renamed = str;
            }
        }

        public void e_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.f5294c = str;
            }
        }

        public void f_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.f5293b = str;
            }
        }

        public void g_renamed(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str) || !a_renamed().contains(str)) {
                this.f5292a = str;
            }
        }

        public void h_renamed(java.lang.String str) {
            this.h_renamed = str;
        }

        private java.util.HashSet<java.lang.String> a_renamed() {
            java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet<>();
            hashSet.add(this.g_renamed);
            hashSet.add(this.f_renamed);
            hashSet.add(this.e_renamed);
            hashSet.add(this.d_renamed);
            hashSet.add(this.f5294c);
            hashSet.add(this.f5293b);
            hashSet.add(this.f5292a);
            return hashSet;
        }

        public java.lang.String toString() {
            return this.g_renamed + "_" + this.f_renamed + "_" + this.e_renamed + "_" + this.d_renamed + "_" + this.f5294c + "_" + this.f5293b + "_" + this.f5292a + "_";
        }
    }

    /* compiled from: LocationManager.java */
    private static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        @android.annotation.SuppressLint({"StaticFieldLeak"})
        private static com.oplus.camera.q_renamed f5300a = new com.oplus.camera.q_renamed();
    }
}
