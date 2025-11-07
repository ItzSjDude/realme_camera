package com.oplus.camera.p150i;

import android.content.SharedPreferences;
import com.oplus.camera.CameraLog;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraParameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FeatureFactory.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_13.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class FeatureFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<String, FeatureInterface> f14371a = new ConcurrentHashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static volatile FeatureFactory f14372b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Map<String, String> f14373c = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraInterface f14374d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CameraUIInterface f14375e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SharedPreferences f14376f = null;

    static {
        f14373c.put(CameraParameter.FLASH_MODE.getKeyName(), CameraUIInterface.KEY_FLASH_MODE);
        f14373c.put(CameraParameter.CAPTURE_HDR_MODE.getKeyName(), CameraUIInterface.KEY_CAMERA_HDR_MODE);
    }

    private FeatureFactory() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static FeatureFactory m14365a() {
        if (f14372b == null) {
            synchronized (FeatureFactory.class) {
                if (f14372b == null) {
                    f14372b = new FeatureFactory();
                }
            }
        }
        return f14372b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14368a(CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.f14374d = interfaceC2646a;
        this.f14375e = cameraUIInterface;
        this.f14376f = this.f14374d.mo10590t();
        f14371a.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14370b() {
        this.f14374d = null;
        this.f14375e = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14369a(String str) {
        FeatureInterface interfaceC2783eM14366b;
        CameraInterface interfaceC2646a = this.f14374d;
        if (interfaceC2646a == null || this.f14375e == null || interfaceC2646a.mo10503aE() == null) {
            CameraLog.m12966e("FeatureFactory", "updateConflictFeatures, not init yet, return.");
            return;
        }
        FeatureInterface interfaceC2783eM14366b2 = m14366b(str);
        if (interfaceC2783eM14366b2 == null) {
            CameraLog.m12966e("FeatureFactory", "updateConflictFeatures, feature not support, return. prefKey: " + str);
            return;
        }
        CameraDeviceInfo cameraDeviceInfoMo10503aE = this.f14374d.mo10503aE();
        String string = this.f14376f.getString(str, interfaceC2783eM14366b2.mo14373c());
        String strMo14372b = interfaceC2783eM14366b2.mo14372b();
        Map<String, List<String>> conflictParameter = cameraDeviceInfoMo10503aE.getConflictParameter(strMo14372b, string);
        CameraLog.m12954a("FeatureFactory", "updateConflictFeatures, conflictFeatureKey: " + strMo14372b + ", featureValue: " + string + ", conflictMap: " + conflictParameter);
        if (conflictParameter == null || conflictParameter.size() <= 0) {
            return;
        }
        for (String str2 : conflictParameter.keySet()) {
            String str3 = f14373c.get(str2);
            if (str3 != null && (interfaceC2783eM14366b = m14366b(str3)) != null) {
                String string2 = this.f14376f.getString(str3, interfaceC2783eM14366b.mo14373c());
                List<String> list = conflictParameter.get(str2);
                if (list != null && list.contains(string2)) {
                    interfaceC2783eM14366b.mo14371a();
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FeatureInterface m14366b(String str) {
        FeatureInterface interfaceC2783eM14367c = f14371a.get(str);
        if (interfaceC2783eM14367c == null && (interfaceC2783eM14367c = m14367c(str)) != null) {
            f14371a.put(str, interfaceC2783eM14367c);
        }
        return interfaceC2783eM14367c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private FeatureInterface m14367c(String str) {
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return new FeatureFlash(this.f14374d, this.f14375e);
        }
        if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str)) {
            return new FeatureHDR(this.f14374d, this.f14375e);
        }
        return null;
    }
}
