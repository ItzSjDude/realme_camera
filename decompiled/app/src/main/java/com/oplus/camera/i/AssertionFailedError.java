package com.oplus.camera.i_renamed;

/* compiled from: FeatureFactory.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.String, com.oplus.camera.i_renamed.e_renamed> f4716a = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.i_renamed.b_renamed f4717b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.String, java.lang.String> f4718c = new java.util.HashMap();
    private com.oplus.camera.capmode.a_renamed d_renamed = null;
    private com.oplus.camera.ui.CameraUIInterface e_renamed = null;
    private android.content.SharedPreferences f_renamed = null;

    static {
        f4718c.put(com.oplus.ocs.camera.CameraParameter.FLASH_MODE.getKeyName(), com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
        f4718c.put(com.oplus.ocs.camera.CameraParameter.CAPTURE_HDR_MODE.getKeyName(), com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
    }

    private b_renamed() {
    }

    public static com.oplus.camera.i_renamed.b_renamed a_renamed() {
        if (f4717b == null) {
            synchronized (com.oplus.camera.i_renamed.b_renamed.class) {
                if (f4717b == null) {
                    f4717b = new com.oplus.camera.i_renamed.b_renamed();
                }
            }
        }
        return f4717b;
    }

    public void a_renamed(com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.d_renamed = aVar;
        this.e_renamed = cameraUIInterface;
        this.f_renamed = this.d_renamed.t_renamed();
        f4716a.clear();
    }

    public void b_renamed() {
        this.d_renamed = null;
        this.e_renamed = null;
    }

    public void a_renamed(java.lang.String str) {
        com.oplus.camera.i_renamed.e_renamed eVarB;
        com.oplus.camera.capmode.a_renamed aVar = this.d_renamed;
        if (aVar == null || this.e_renamed == null || aVar.aE_renamed() == null) {
            com.oplus.camera.e_renamed.e_renamed("FeatureFactory", "updateConflictFeatures, not init yet, return.");
            return;
        }
        com.oplus.camera.i_renamed.e_renamed eVarB2 = b_renamed(str);
        if (eVarB2 == null) {
            com.oplus.camera.e_renamed.e_renamed("FeatureFactory", "updateConflictFeatures, feature not support, return. prefKey: " + str);
            return;
        }
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfoAE = this.d_renamed.aE_renamed();
        java.lang.String string = this.f_renamed.getString(str, eVarB2.c_renamed());
        java.lang.String strB = eVarB2.b_renamed();
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> conflictParameter = cameraDeviceInfoAE.getConflictParameter(strB, string);
        com.oplus.camera.e_renamed.a_renamed("FeatureFactory", "updateConflictFeatures, conflictFeatureKey: " + strB + ", featureValue: " + string + ", conflictMap: " + conflictParameter);
        if (conflictParameter == null || conflictParameter.size() <= 0) {
            return;
        }
        for (java.lang.String str2 : conflictParameter.keySet()) {
            java.lang.String str3 = f4718c.get(str2);
            if (str3 != null && (eVarB = b_renamed(str3)) != null) {
                java.lang.String string2 = this.f_renamed.getString(str3, eVarB.c_renamed());
                java.util.List<java.lang.String> list = conflictParameter.get(str2);
                if (list != null && list.contains(string2)) {
                    eVarB.a_renamed();
                }
            }
        }
    }

    private com.oplus.camera.i_renamed.e_renamed b_renamed(java.lang.String str) {
        com.oplus.camera.i_renamed.e_renamed eVarC = f4716a.get(str);
        if (eVarC == null && (eVarC = c_renamed(str)) != null) {
            f4716a.put(str, eVarC);
        }
        return eVarC;
    }

    private com.oplus.camera.i_renamed.e_renamed c_renamed(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return new com.oplus.camera.i_renamed.c_renamed(this.d_renamed, this.e_renamed);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str)) {
            return new com.oplus.camera.i_renamed.d_renamed(this.d_renamed, this.e_renamed);
        }
        return null;
    }
}
