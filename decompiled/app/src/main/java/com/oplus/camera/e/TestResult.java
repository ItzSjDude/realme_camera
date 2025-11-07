package com.oplus.camera.e_renamed;

/* compiled from: OplusCameraCharacteristics.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.ocs.camera.CameraDeviceInfo f4454a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.Map<java.lang.Integer, java.util.List<android.util.Size>> f4455b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.Map<java.lang.String, java.util.List<android.util.Size>> f4456c = null;
    private java.util.List<android.util.Size> d_renamed = null;

    public h_renamed(com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo) {
        this.f4454a = cameraDeviceInfo;
    }

    public java.util.List<android.util.Size> a_renamed(int i_renamed) {
        java.util.List<android.util.Size> listC;
        synchronized (this) {
            if (this.f4455b == null) {
                this.f4455b = new java.util.HashMap();
            } else if (this.f4455b.containsKey(java.lang.Integer.valueOf(i_renamed))) {
                return this.f4455b.get(java.lang.Integer.valueOf(i_renamed));
            }
            try {
                android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (streamConfigurationMap != null && streamConfigurationMap.getOutputSizes(i_renamed) != null) {
                    for (android.util.Size size : streamConfigurationMap.getOutputSizes(i_renamed)) {
                        arrayList.add(size);
                    }
                    android.util.Size[] highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i_renamed);
                    if (highResolutionOutputSizes != null) {
                        for (android.util.Size size2 : highResolutionOutputSizes) {
                            arrayList.add(size2);
                        }
                    }
                }
                if (32 != i_renamed && (listC = C_renamed()) != null) {
                    for (android.util.Size size3 : listC) {
                        if (!com.oplus.camera.util.Util.a_renamed(arrayList, size3)) {
                            arrayList.add(size3);
                        }
                    }
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SORT_CAPTURE_SIZE_SUPPORT)) {
                    com.oplus.camera.util.Util.a_renamed((java.util.List<android.util.Size>) arrayList, false);
                }
                synchronized (this) {
                    this.f4455b.put(java.lang.Integer.valueOf(i_renamed), arrayList);
                }
                return arrayList;
            } catch (java.lang.Exception unused) {
                com.oplus.camera.e_renamed.f_renamed("OplusCameraCharacteristics", "Unable to obtain picture sizes");
                java.util.ArrayList arrayList2 = new java.util.ArrayList(0);
                this.f4455b.put(java.lang.Integer.valueOf(i_renamed), arrayList2);
                return arrayList2;
            }
        }
    }

    public java.util.List<android.util.Size> a_renamed(int i_renamed, android.hardware.camera2.CameraCharacteristics cameraCharacteristics, java.lang.String str) {
        synchronized (this) {
            if (this.f4456c == null) {
                this.f4456c = new java.util.HashMap();
            } else if (this.f4456c.containsKey(str)) {
                return this.f4456c.get(str);
            }
            android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = null;
            if (cameraCharacteristics != null) {
                try {
                    streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                } catch (java.lang.Exception unused) {
                    com.oplus.camera.e_renamed.f_renamed("OplusCameraCharacteristics", "getSupportedPhysicalPictureSizes, Unable to obtain picture sizes");
                    java.util.ArrayList arrayList = new java.util.ArrayList(0);
                    this.f4456c.put(str, arrayList);
                    return arrayList;
                }
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (streamConfigurationMap != null && streamConfigurationMap.getOutputSizes(i_renamed) != null) {
                for (android.util.Size size : streamConfigurationMap.getOutputSizes(i_renamed)) {
                    arrayList2.add(size);
                }
                android.util.Size[] highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i_renamed);
                if (highResolutionOutputSizes != null) {
                    for (android.util.Size size2 : highResolutionOutputSizes) {
                        arrayList2.add(size2);
                    }
                }
            }
            java.util.List<android.util.Size> listC = C_renamed();
            if (listC != null) {
                for (android.util.Size size3 : listC) {
                    if (!com.oplus.camera.util.Util.a_renamed(arrayList2, size3)) {
                        arrayList2.add(size3);
                    }
                }
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SORT_CAPTURE_SIZE_SUPPORT)) {
                com.oplus.camera.util.Util.a_renamed((java.util.List<android.util.Size>) arrayList2, false);
            }
            this.f4456c.put(str, arrayList2);
            return arrayList2;
        }
    }

    public java.util.List<android.util.Size> a_renamed() {
        java.util.List<android.util.Size> list;
        synchronized (this) {
            if (this.d_renamed != null) {
                return this.d_renamed;
            }
            com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
            java.util.List<android.util.Size> supportPreviewSize = cameraDeviceInfo != null ? cameraDeviceInfo.getSupportPreviewSize(2, null) : null;
            synchronized (this) {
                this.d_renamed = supportPreviewSize;
                list = this.d_renamed;
            }
            return list;
        }
    }

    public int b_renamed() {
        return ((java.lang.Integer) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    public int c_renamed() {
        return ((java.lang.Integer) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING)).intValue();
    }

    public android.graphics.Rect d_renamed() {
        return (android.graphics.Rect) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }

    public float e_renamed() {
        return ((java.lang.Float) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
    }

    public int f_renamed() {
        if (this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aW_renamed) != null) {
            return ((java.lang.Integer) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aW_renamed)).intValue();
        }
        return 0;
    }

    public float[] g_renamed() {
        try {
            if (this.f4454a != null) {
                return (float[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aG_renamed);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public <T_renamed> T_renamed a_renamed(android.hardware.camera2.CameraCharacteristics.Key<T_renamed> key) {
        try {
            if (this.f4454a != null) {
                return (T_renamed) this.f4454a.get(key);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public float[] h_renamed() {
        try {
            if (this.f4454a != null) {
                return (float[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aH_renamed);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public float[] a_renamed(com.oplus.camera.af_renamed afVar) {
        float[] fArr;
        try {
            if (this.f4454a != null) {
                if (afVar.d_renamed()) {
                    if (afVar.c_renamed()) {
                        fArr = null;
                    } else {
                        fArr = afVar.f4103a ? (float[]) a_renamed(com.oplus.camera.e_renamed.b_renamed.aK_renamed) : null;
                        if (fArr == null) {
                            fArr = (float[]) a_renamed(com.oplus.camera.e_renamed.b_renamed.aJ_renamed);
                        }
                    }
                    return fArr == null ? g_renamed() : fArr;
                }
                if (afVar.i_renamed() || afVar.e_renamed()) {
                    return h_renamed();
                }
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("OplusCameraCharacteristics", "getSupportedZoomRange, e_renamed: " + e_renamed.getMessage());
        }
        return null;
    }

    public float[] i_renamed() {
        try {
            if (this.f4454a != null) {
                return (float[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aH_renamed);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public float[] j_renamed() {
        try {
            if (this.f4454a != null) {
                return (float[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aX_renamed);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("OplusCameraCharacteristics", "getFovAngle error: " + e_renamed.toString());
        }
        com.oplus.camera.e_renamed.a_renamed("OplusCameraCharacteristics", "getFovAngle enter, return null");
        return null;
    }

    public byte[] k_renamed() {
        try {
            if (this.f4454a != null) {
                return (byte[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aU_renamed);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public float[] l_renamed() {
        try {
            if (this.f4454a != null) {
                return (float[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.aI_renamed);
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public android.graphics.Rect a_renamed(android.util.Size size) {
        android.graphics.Rect rectD = d_renamed();
        float width = size.getWidth() / size.getHeight();
        if (width - (rectD.width() / rectD.height()) > -0.015f) {
            int iHeight = (rectD.height() - ((int) (rectD.width() / width))) / 2;
            return new android.graphics.Rect(rectD.left, rectD.top + iHeight, rectD.right, rectD.bottom - iHeight);
        }
        int iWidth = (rectD.width() - ((int) (rectD.height() * width))) / 2;
        return new android.graphics.Rect(rectD.left + iWidth, rectD.top, rectD.right - iWidth, rectD.bottom);
    }

    public float b_renamed(com.oplus.camera.af_renamed afVar) {
        if (afVar.k_renamed() || afVar.l_renamed()) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_ZOOM_VALUE_DEFAULT);
        }
        if (afVar.K_renamed()) {
            return c_renamed(afVar);
        }
        float[] fArrL = null;
        if (afVar.d_renamed()) {
            fArrL = a_renamed(afVar);
        } else if (afVar.i_renamed()) {
            fArrL = i_renamed();
        } else if (afVar.f_renamed()) {
            fArrL = l_renamed();
        }
        if (fArrL != null) {
            return fArrL[2];
        }
        return 1.0f;
    }

    public float c_renamed(com.oplus.camera.af_renamed afVar) {
        if (!afVar.A_renamed() && !afVar.C_renamed()) {
            float[] fArrA = a_renamed(afVar);
            if (fArrA != null) {
                return fArrA[0];
            }
            if (afVar.m_renamed() || afVar.d_renamed()) {
                return 0.6f;
            }
            if (afVar.e_renamed() && afVar.g_renamed()) {
                return 0.6f;
            }
        }
        return 1.0f;
    }

    public float d_renamed(com.oplus.camera.af_renamed afVar) {
        float[] fArrA = a_renamed(afVar);
        if (afVar.j_renamed() || afVar.u_renamed()) {
            return 1.0f;
        }
        if (afVar.C_renamed()) {
            return 5.0f;
        }
        if (afVar.B_renamed()) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_NIGHT_ZOOM_MAX_VALUE_DEFAULT);
        }
        if (afVar.e_renamed()) {
            return 5.0f;
        }
        if (fArrA != null && fArrA.length >= 4) {
            return fArrA[1];
        }
        if (afVar.k_renamed() || afVar.l_renamed()) {
            return 2.0f;
        }
        if (afVar.x_renamed()) {
            return 20.0f;
        }
        if (afVar.M_renamed() || afVar.G_renamed() || afVar.O_renamed()) {
            return 1.0f;
        }
        if (afVar.f_renamed()) {
            return afVar.b_renamed();
        }
        if (afVar.m_renamed() || afVar.w_renamed()) {
            return 1.0f;
        }
        if (afVar.v_renamed() || afVar.A_renamed()) {
            return 5.0f;
        }
        if (afVar.D_renamed()) {
            return 3.0f;
        }
        if (afVar.E_renamed()) {
            return 2.0f;
        }
        if (afVar.h_renamed() && !afVar.f4103a && !afVar.f4104b) {
            return 20.0f;
        }
        if (afVar.a_renamed()) {
            return 5.0f;
        }
        return e_renamed();
    }

    public boolean a_renamed(com.oplus.camera.af_renamed afVar, float f_renamed) {
        return java.lang.Float.compare(f_renamed, c_renamed(afVar)) >= 0 && java.lang.Float.compare(f_renamed, d_renamed(afVar)) <= 0;
    }

    public float m_renamed() {
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null) {
            return 0.0f;
        }
        try {
            return ((java.lang.Float) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.LENS_INFO_HYPERFOCAL_DISTANCE)).floatValue();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return 0.0f;
        }
    }

    public float n_renamed() {
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null) {
            return 0.0f;
        }
        try {
            return ((java.lang.Float) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)).floatValue();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return 0.0f;
        }
    }

    public boolean o_renamed() {
        android.util.Range range = (android.util.Range) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        return (((java.lang.Integer) range.getLower()).intValue() == 0 && ((java.lang.Integer) range.getUpper()).intValue() == 0) ? false : true;
    }

    public int p_renamed() {
        if (o_renamed()) {
            return ((java.lang.Integer) ((android.util.Range) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getLower()).intValue();
        }
        return -1;
    }

    public int q_renamed() {
        if (o_renamed()) {
            return ((java.lang.Integer) ((android.util.Range) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getUpper()).intValue();
        }
        return -1;
    }

    public float r_renamed() {
        if (!o_renamed()) {
            return -1.0f;
        }
        android.util.Rational rational = (android.util.Rational) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        return rational.getNumerator() / rational.getDenominator();
    }

    public boolean s_renamed() {
        java.lang.Integer num = (java.lang.Integer) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        return num != null && num.intValue() > 0;
    }

    public boolean t_renamed() {
        java.lang.Integer num = (java.lang.Integer) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        return num != null && num.intValue() > 0;
    }

    public int u_renamed() {
        android.util.Range range;
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null || (range = (android.util.Range) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null) {
            return -1;
        }
        return ((java.lang.Integer) range.getUpper()).intValue();
    }

    public int v_renamed() {
        android.util.Range range;
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null || (range = (android.util.Range) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE)) == null) {
            return -1;
        }
        return ((java.lang.Integer) range.getUpper()).intValue() + 1;
    }

    public int w_renamed() {
        android.util.Range range;
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null || (range = (android.util.Range) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null) {
            return -1;
        }
        return ((java.lang.Integer) range.getLower()).intValue();
    }

    public long x_renamed() {
        android.util.Range range;
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null || (range = (android.util.Range) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null) {
            return -1L;
        }
        return ((java.lang.Long) range.getUpper()).longValue();
    }

    public long y_renamed() {
        android.util.Range range;
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo == null || (range = (android.util.Range) cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null) {
            return -1L;
        }
        return ((java.lang.Long) range.getLower()).longValue();
    }

    public android.util.Range<java.lang.Integer>[] z_renamed() {
        return (android.util.Range[]) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    }

    public int[] A_renamed() {
        return (int[]) this.f4454a.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
    }

    public java.util.List<java.lang.Integer> B_renamed() {
        return this.f4454a.getPreviewParameterRange(com.oplus.ocs.camera.CameraParameter.COLOR_TEMPERATURE_RANGE);
    }

    public java.util.List<android.util.Size> C_renamed() {
        int i_renamed;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            int[] iArr = (int[]) this.f4454a.get(com.oplus.camera.e_renamed.b_renamed.u_renamed);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 % 2 == 0 && (i_renamed = i2 + 1) < iArr.length) {
                    arrayList.add(new android.util.Size(iArr[i2], iArr[i_renamed]));
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return arrayList;
    }

    public int[] b_renamed(android.hardware.camera2.CameraCharacteristics.Key<?> key) {
        if (key == null) {
            return null;
        }
        try {
            return (int[]) this.f4454a.get(key);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.b_renamed("OplusCameraCharacteristics", "getIntArrayConfig, e_renamed: " + e_renamed.getMessage());
            return null;
        }
    }

    public boolean D_renamed() {
        boolean z_renamed;
        boolean z2;
        int[] iArrB = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.w_renamed);
        int[] iArrB2 = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.x_renamed);
        if (iArrB == null || iArrB.length <= 0) {
            z_renamed = false;
        } else {
            for (int i_renamed : iArrB) {
                if (i_renamed == 1) {
                    z_renamed = true;
                    break;
                }
            }
            z_renamed = false;
        }
        if (iArrB2 == null || iArrB2.length <= 0) {
            z2 = false;
        } else {
            for (int i2 : iArrB2) {
                if (i2 == 1) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        return z_renamed && z2;
    }

    public boolean E_renamed() {
        if (com.oplus.camera.util.Util.C_renamed()) {
            return true;
        }
        int[] iArrB = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.x_renamed);
        if (iArrB == null || iArrB.length <= 0) {
            return false;
        }
        for (int i_renamed : iArrB) {
            if (i_renamed == 1) {
                return true;
            }
        }
        return false;
    }

    public com.oplus.ocs.camera.CameraDeviceInfo F_renamed() {
        return this.f4454a;
    }

    public boolean G_renamed() {
        return !com.oplus.camera.util.Util.C_renamed();
    }

    public boolean H_renamed() {
        int[] iArrB = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.ax_renamed);
        if (iArrB == null || iArrB.length <= 0) {
            return false;
        }
        for (int i_renamed : iArrB) {
            if (i_renamed == 3) {
                return true;
            }
        }
        return false;
    }

    public int I_renamed() {
        int[] iArrB;
        if (com.oplus.camera.util.Util.C_renamed()) {
            iArrB = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aL_renamed);
        } else {
            iArrB = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aM_renamed);
        }
        if (iArrB != null && iArrB.length > 0) {
            return iArrB[0];
        }
        com.oplus.camera.e_renamed.f_renamed("OplusCameraCharacteristics", "getLogicalCameraType, cameraTypeArray is_renamed null or the length is_renamed 0");
        return 0;
    }

    public boolean J_renamed() {
        return b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aV_renamed) != null;
    }

    public int[] a_renamed(java.lang.String str) {
        int[] iArr = new int[2];
        int[] iArrB = b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aV_renamed);
        int i_renamed = str.equals("video_size_720p") ? com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT : com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT;
        if (iArrB == null || iArrB.length <= 0) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= iArrB.length) {
                break;
            }
            if (iArrB[i2] == i_renamed) {
                iArr[0] = iArrB[i2 + 1];
                iArr[1] = iArrB[i2 + 2];
                break;
            }
            i2++;
        }
        com.oplus.camera.e_renamed.b_renamed("OplusCameraCharacteristics", "getAvailableSMVRModes, fps: " + iArr[0] + ", batch num: " + iArr[1]);
        return iArr;
    }

    public java.util.List<android.util.Size> K_renamed() {
        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = this.f4454a;
        if (cameraDeviceInfo != null) {
            return cameraDeviceInfo.getSupportVideoSize();
        }
        return null;
    }
}
