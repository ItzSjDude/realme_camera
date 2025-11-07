package com.oplus.camera.p141e;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: OplusCameraCharacteristics.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class OplusCameraCharacteristics {

    /* renamed from: PlatformImplementations.kt_3 */
    private final CameraDeviceInfo f13534a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Map<Integer, List<Size>> f13535b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Map<String, List<Size>> f13536c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<Size> f13537d = null;

    public OplusCameraCharacteristics(CameraDeviceInfo cameraDeviceInfo) {
        this.f13534a = cameraDeviceInfo;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<Size> m13258a(int OplusGLSurfaceView_13) {
        List<Size> listM13246C;
        synchronized (this) {
            if (this.f13535b == null) {
                this.f13535b = new HashMap();
            } else if (this.f13535b.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
                return this.f13535b.get(Integer.valueOf(OplusGLSurfaceView_13));
            }
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f13534a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                ArrayList arrayList = new ArrayList();
                if (streamConfigurationMap != null && streamConfigurationMap.getOutputSizes(OplusGLSurfaceView_13) != null) {
                    for (Size size : streamConfigurationMap.getOutputSizes(OplusGLSurfaceView_13)) {
                        arrayList.add(size);
                    }
                    Size[] highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(OplusGLSurfaceView_13);
                    if (highResolutionOutputSizes != null) {
                        for (Size size2 : highResolutionOutputSizes) {
                            arrayList.add(size2);
                        }
                    }
                }
                if (32 != OplusGLSurfaceView_13 && (listM13246C = m13246C()) != null) {
                    for (Size size3 : listM13246C) {
                        if (!Util.m24298a(arrayList, size3)) {
                            arrayList.add(size3);
                        }
                    }
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SORT_CAPTURE_SIZE_SUPPORT)) {
                    Util.m24281a((List<Size>) arrayList, false);
                }
                synchronized (this) {
                    this.f13535b.put(Integer.valueOf(OplusGLSurfaceView_13), arrayList);
                }
                return arrayList;
            } catch (Exception unused) {
                CameraLog.m12967f("OplusCameraCharacteristics", "Unable to obtain picture sizes");
                ArrayList arrayList2 = new ArrayList(0);
                this.f13535b.put(Integer.valueOf(OplusGLSurfaceView_13), arrayList2);
                return arrayList2;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<Size> m13259a(int OplusGLSurfaceView_13, CameraCharacteristics cameraCharacteristics, String str) {
        synchronized (this) {
            if (this.f13536c == null) {
                this.f13536c = new HashMap();
            } else if (this.f13536c.containsKey(str)) {
                return this.f13536c.get(str);
            }
            StreamConfigurationMap streamConfigurationMap = null;
            if (cameraCharacteristics != null) {
                try {
                    streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                } catch (Exception unused) {
                    CameraLog.m12967f("OplusCameraCharacteristics", "getSupportedPhysicalPictureSizes, Unable to obtain picture sizes");
                    ArrayList arrayList = new ArrayList(0);
                    this.f13536c.put(str, arrayList);
                    return arrayList;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (streamConfigurationMap != null && streamConfigurationMap.getOutputSizes(OplusGLSurfaceView_13) != null) {
                for (Size size : streamConfigurationMap.getOutputSizes(OplusGLSurfaceView_13)) {
                    arrayList2.add(size);
                }
                Size[] highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(OplusGLSurfaceView_13);
                if (highResolutionOutputSizes != null) {
                    for (Size size2 : highResolutionOutputSizes) {
                        arrayList2.add(size2);
                    }
                }
            }
            List<Size> listM13246C = m13246C();
            if (listM13246C != null) {
                for (Size size3 : listM13246C) {
                    if (!Util.m24298a(arrayList2, size3)) {
                        arrayList2.add(size3);
                    }
                }
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SORT_CAPTURE_SIZE_SUPPORT)) {
                Util.m24281a((List<Size>) arrayList2, false);
            }
            this.f13536c.put(str, arrayList2);
            return arrayList2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<Size> m13257a() {
        List<Size> list;
        synchronized (this) {
            if (this.f13537d != null) {
                return this.f13537d;
            }
            CameraDeviceInfo cameraDeviceInfo = this.f13534a;
            List<Size> supportPreviewSize = cameraDeviceInfo != null ? cameraDeviceInfo.getSupportPreviewSize(2, null) : null;
            synchronized (this) {
                this.f13537d = supportPreviewSize;
                list = this.f13537d;
            }
            return list;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13264b() {
        return ((Integer) this.f13534a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m13267c() {
        return ((Integer) this.f13534a.get(CameraCharacteristics.LENS_FACING)).intValue();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Rect m13269d() {
        return (Rect) this.f13534a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m13270e() {
        return ((Float) this.f13534a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m13271f() {
        if (this.f13534a.get(CameraMetadataKey.f13284aW) != null) {
            return ((Integer) this.f13534a.get(CameraMetadataKey.f13284aW)).intValue();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float[] m13272g() {
        try {
            if (this.f13534a != null) {
                return (float[]) this.f13534a.get(CameraMetadataKey.f13268aG);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> T m13256a(CameraCharacteristics.Key<T> key) {
        try {
            if (this.f13534a != null) {
                return (T) this.f13534a.get(key);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float[] m13273h() {
        try {
            if (this.f13534a != null) {
                return (float[]) this.f13534a.get(CameraMetadataKey.f13269aH);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float[] m13261a(ZoomConfigure c2614af) {
        float[] fArr;
        try {
            if (this.f13534a != null) {
                if (c2614af.m11337d()) {
                    if (c2614af.m11335c()) {
                        fArr = null;
                    } else {
                        fArr = c2614af.f12308a ? (float[]) m13256a(CameraMetadataKey.f13272aK) : null;
                        if (fArr == null) {
                            fArr = (float[]) m13256a(CameraMetadataKey.f13271aJ);
                        }
                    }
                    return fArr == null ? m13272g() : fArr;
                }
                if (c2614af.m11347i() || c2614af.m11339e()) {
                    return m13273h();
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("OplusCameraCharacteristics", "getSupportedZoomRange, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8.getMessage());
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float[] m13274i() {
        try {
            if (this.f13534a != null) {
                return (float[]) this.f13534a.get(CameraMetadataKey.f13269aH);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public float[] m13275j() {
        try {
            if (this.f13534a != null) {
                return (float[]) this.f13534a.get(CameraMetadataKey.f13285aX);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("OplusCameraCharacteristics", "getFovAngle error: " + COUIBaseListPopupWindow_8.toString());
        }
        CameraLog.m12954a("OplusCameraCharacteristics", "getFovAngle enter, return null");
        return null;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public byte[] m13276k() {
        try {
            if (this.f13534a != null) {
                return (byte[]) this.f13534a.get(CameraMetadataKey.f13282aU);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public float[] m13277l() {
        try {
            if (this.f13534a != null) {
                return (float[]) this.f13534a.get(CameraMetadataKey.f13270aI);
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Rect m13255a(Size size) {
        Rect rectM13269d = m13269d();
        float width = size.getWidth() / size.getHeight();
        if (width - (rectM13269d.width() / rectM13269d.height()) > -0.015f) {
            int iHeight = (rectM13269d.height() - ((int) (rectM13269d.width() / width))) / 2;
            return new Rect(rectM13269d.left, rectM13269d.top + iHeight, rectM13269d.right, rectM13269d.bottom - iHeight);
        }
        int iWidth = (rectM13269d.width() - ((int) (rectM13269d.height() * width))) / 2;
        return new Rect(rectM13269d.left + iWidth, rectM13269d.top, rectM13269d.right - iWidth, rectM13269d.bottom);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m13263b(ZoomConfigure c2614af) {
        if (c2614af.m11351k() || c2614af.m11353l()) {
            return CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_PORTRAIT_ZOOM_VALUE_DEFAULT);
        }
        if (c2614af.m11317K()) {
            return m13266c(c2614af);
        }
        float[] fArrM13277l = null;
        if (c2614af.m11337d()) {
            fArrM13277l = m13261a(c2614af);
        } else if (c2614af.m11347i()) {
            fArrM13277l = m13274i();
        } else if (c2614af.m11341f()) {
            fArrM13277l = m13277l();
        }
        if (fArrM13277l != null) {
            return fArrM13277l[2];
        }
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m13266c(ZoomConfigure c2614af) {
        if (!c2614af.m11297A() && !c2614af.m11301C()) {
            float[] fArrM13261a = m13261a(c2614af);
            if (fArrM13261a != null) {
                return fArrM13261a[0];
            }
            if (c2614af.m11355m() || c2614af.m11337d()) {
                return 0.6f;
            }
            if (c2614af.m11339e() && c2614af.m11343g()) {
                return 0.6f;
            }
        }
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m13268d(ZoomConfigure c2614af) {
        float[] fArrM13261a = m13261a(c2614af);
        if (c2614af.m11349j() || c2614af.m11371u()) {
            return 1.0f;
        }
        if (c2614af.m11301C()) {
            return 5.0f;
        }
        if (c2614af.m11299B()) {
            return CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_OPLUS_NIGHT_ZOOM_MAX_VALUE_DEFAULT);
        }
        if (c2614af.m11339e()) {
            return 5.0f;
        }
        if (fArrM13261a != null && fArrM13261a.length >= 4) {
            return fArrM13261a[1];
        }
        if (c2614af.m11351k() || c2614af.m11353l()) {
            return 2.0f;
        }
        if (c2614af.m11377x()) {
            return 20.0f;
        }
        if (c2614af.m11319M() || c2614af.m11309G() || c2614af.m11321O()) {
            return 1.0f;
        }
        if (c2614af.m11341f()) {
            return c2614af.m11328b();
        }
        if (c2614af.m11355m() || c2614af.m11375w()) {
            return 1.0f;
        }
        if (c2614af.m11373v() || c2614af.m11297A()) {
            return 5.0f;
        }
        if (c2614af.m11303D()) {
            return 3.0f;
        }
        if (c2614af.m11305E()) {
            return 2.0f;
        }
        if (c2614af.m11345h() && !c2614af.f12308a && !c2614af.f12309b) {
            return 20.0f;
        }
        if (c2614af.m11327a()) {
            return 5.0f;
        }
        return m13270e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13260a(ZoomConfigure c2614af, float COUIBaseListPopupWindow_12) {
        return Float.compare(COUIBaseListPopupWindow_12, m13266c(c2614af)) >= 0 && Float.compare(COUIBaseListPopupWindow_12, m13268d(c2614af)) <= 0;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public float m13278m() {
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null) {
            return 0.0f;
        }
        try {
            return ((Float) cameraDeviceInfo.get(CameraCharacteristics.LENS_INFO_HYPERFOCAL_DISTANCE)).floatValue();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public float m13279n() {
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null) {
            return 0.0f;
        }
        try {
            return ((Float) cameraDeviceInfo.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)).floatValue();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: o */
    public boolean m13280o() {
        Range range = (Range) this.f13534a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        return (((Integer) range.getLower()).intValue() == 0 && ((Integer) range.getUpper()).intValue() == 0) ? false : true;
    }

    /* renamed from: p */
    public int m13281p() {
        if (m13280o()) {
            return ((Integer) ((Range) this.f13534a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getLower()).intValue();
        }
        return -1;
    }

    /* renamed from: q */
    public int m13282q() {
        if (m13280o()) {
            return ((Integer) ((Range) this.f13534a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getUpper()).intValue();
        }
        return -1;
    }

    /* renamed from: r */
    public float m13283r() {
        if (!m13280o()) {
            return -1.0f;
        }
        Rational rational = (Rational) this.f13534a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        return rational.getNumerator() / rational.getDenominator();
    }

    /* renamed from: s */
    public boolean m13284s() {
        Integer num = (Integer) this.f13534a.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        return num != null && num.intValue() > 0;
    }

    /* renamed from: t */
    public boolean m13285t() {
        Integer num = (Integer) this.f13534a.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        return num != null && num.intValue() > 0;
    }

    /* renamed from: u */
    public int m13286u() {
        Range range;
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null || (range = (Range) cameraDeviceInfo.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null) {
            return -1;
        }
        return ((Integer) range.getUpper()).intValue();
    }

    /* renamed from: v */
    public int m13287v() {
        Range range;
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null || (range = (Range) cameraDeviceInfo.get(CameraCharacteristics.CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE)) == null) {
            return -1;
        }
        return ((Integer) range.getUpper()).intValue() + 1;
    }

    /* renamed from: w */
    public int m13288w() {
        Range range;
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null || (range = (Range) cameraDeviceInfo.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null) {
            return -1;
        }
        return ((Integer) range.getLower()).intValue();
    }

    /* renamed from: x */
    public long m13289x() {
        Range range;
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null || (range = (Range) cameraDeviceInfo.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null) {
            return -1L;
        }
        return ((Long) range.getUpper()).longValue();
    }

    /* renamed from: y */
    public long m13290y() {
        Range range;
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo == null || (range = (Range) cameraDeviceInfo.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null) {
            return -1L;
        }
        return ((Long) range.getLower()).longValue();
    }

    /* renamed from: z */
    public Range<Integer>[] m13291z() {
        return (Range[]) this.f13534a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    }

    /* renamed from: A */
    public int[] m13244A() {
        return (int[]) this.f13534a.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
    }

    /* renamed from: B */
    public List<Integer> m13245B() {
        return this.f13534a.getPreviewParameterRange(CameraParameter.COLOR_TEMPERATURE_RANGE);
    }

    /* renamed from: C */
    public List<Size> m13246C() {
        int OplusGLSurfaceView_13;
        ArrayList arrayList = new ArrayList();
        try {
            int[] iArr = (int[]) this.f13534a.get(CameraMetadataKey.f13364u);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 % 2 == 0 && (OplusGLSurfaceView_13 = i2 + 1) < iArr.length) {
                    arrayList.add(new Size(iArr[i2], iArr[OplusGLSurfaceView_13]));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int[] m13265b(CameraCharacteristics.Key<?> key) {
        if (key == null) {
            return null;
        }
        try {
            return (int[]) this.f13534a.get(key);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12959b("OplusCameraCharacteristics", "getIntArrayConfig, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8.getMessage());
            return null;
        }
    }

    /* renamed from: D */
    public boolean m13247D() {
        boolean z;
        boolean z2;
        int[] iArrM13265b = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13366w);
        int[] iArrM13265b2 = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13367x);
        if (iArrM13265b == null || iArrM13265b.length <= 0) {
            z = false;
        } else {
            for (int OplusGLSurfaceView_13 : iArrM13265b) {
                if (OplusGLSurfaceView_13 == 1) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (iArrM13265b2 == null || iArrM13265b2.length <= 0) {
            z2 = false;
        } else {
            for (int i2 : iArrM13265b2) {
                if (i2 == 1) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        return z && z2;
    }

    /* renamed from: E */
    public boolean m13248E() {
        if (Util.m24169C()) {
            return true;
        }
        int[] iArrM13265b = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13367x);
        if (iArrM13265b == null || iArrM13265b.length <= 0) {
            return false;
        }
        for (int OplusGLSurfaceView_13 : iArrM13265b) {
            if (OplusGLSurfaceView_13 == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: F */
    public CameraDeviceInfo m13249F() {
        return this.f13534a;
    }

    /* renamed from: G */
    public boolean m13250G() {
        return !Util.m24169C();
    }

    /* renamed from: H */
    public boolean m13251H() {
        int[] iArrM13265b = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13311ax);
        if (iArrM13265b == null || iArrM13265b.length <= 0) {
            return false;
        }
        for (int OplusGLSurfaceView_13 : iArrM13265b) {
            if (OplusGLSurfaceView_13 == 3) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: I */
    public int m13252I() {
        int[] iArrM13265b;
        if (Util.m24169C()) {
            iArrM13265b = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13273aL);
        } else {
            iArrM13265b = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13274aM);
        }
        if (iArrM13265b != null && iArrM13265b.length > 0) {
            return iArrM13265b[0];
        }
        CameraLog.m12967f("OplusCameraCharacteristics", "getLogicalCameraType, cameraTypeArray is null or the length is 0");
        return 0;
    }

    /* renamed from: J */
    public boolean m13253J() {
        return m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13283aV) != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int[] m13262a(String str) {
        int[] iArr = new int[2];
        int[] iArrM13265b = m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13283aV);
        int OplusGLSurfaceView_13 = str.equals("video_size_720p") ? VideoMode.VIDEO_720P_HEIGHT : VideoMode.VIDEO_1080P_HEIGHT;
        if (iArrM13265b == null || iArrM13265b.length <= 0) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= iArrM13265b.length) {
                break;
            }
            if (iArrM13265b[i2] == OplusGLSurfaceView_13) {
                iArr[0] = iArrM13265b[i2 + 1];
                iArr[1] = iArrM13265b[i2 + 2];
                break;
            }
            i2++;
        }
        CameraLog.m12959b("OplusCameraCharacteristics", "getAvailableSMVRModes, fps: " + iArr[0] + ", batch num: " + iArr[1]);
        return iArr;
    }

    /* renamed from: K */
    public List<Size> m13254K() {
        CameraDeviceInfo cameraDeviceInfo = this.f13534a;
        if (cameraDeviceInfo != null) {
            return cameraDeviceInfo.getSupportVideoSize();
        }
        return null;
    }
}
