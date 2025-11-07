package com.oplus.camera.professional;

/* compiled from: PanelContainer.java */
/* loaded from: classes2.dex */
public class p_renamed extends android.widget.RelativeLayout implements com.oplus.camera.professional.q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected com.oplus.camera.capmode.a_renamed f5197a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.CameraUIInterface f5198b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.e_renamed.h_renamed f5199c;
    protected java.util.Map<java.lang.Integer, com.oplus.camera.professional.LevelPanel> d_renamed;
    protected java.util.Map<com.oplus.camera.professional.LevelPanel, android.animation.Animator> e_renamed;
    private final android.widget.RelativeLayout.LayoutParams f_renamed;
    private boolean g_renamed;
    private android.app.Activity h_renamed;
    private com.oplus.camera.professional.p_renamed.c_renamed i_renamed;
    private com.oplus.camera.professional.p_renamed.b_renamed j_renamed;
    private com.oplus.camera.professional.p_renamed.a_renamed k_renamed;
    private boolean l_renamed;
    private int m_renamed;
    private int n_renamed;

    /* compiled from: PanelContainer.java */
    public interface b_renamed {
        void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed);
    }

    /* compiled from: PanelContainer.java */
    public interface c_renamed {
        void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed);

        void b_renamed(int i_renamed, boolean z_renamed);
    }

    @Override // android.view.View
    public void clearAnimation() {
    }

    public p_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar) {
        super(context);
        this.f_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        this.f5197a = null;
        this.f5198b = null;
        this.f5199c = null;
        this.d_renamed = new java.util.HashMap();
        this.e_renamed = new java.util.HashMap();
        this.g_renamed = true;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = new com.oplus.camera.professional.p_renamed.a_renamed();
        this.l_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.h_renamed = (android.app.Activity) context;
        this.f5197a = aVar;
        this.f_renamed.addRule(14);
    }

    public p_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar, int i_renamed, int i2) {
        super(context);
        this.f_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        this.f5197a = null;
        this.f5198b = null;
        this.f5199c = null;
        this.d_renamed = new java.util.HashMap();
        this.e_renamed = new java.util.HashMap();
        this.g_renamed = true;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = new com.oplus.camera.professional.p_renamed.a_renamed();
        this.l_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.m_renamed = i_renamed;
        this.n_renamed = i2;
        this.h_renamed = (android.app.Activity) context;
        this.f5197a = aVar;
        this.f_renamed.addRule(14);
    }

    public void setCameraUIInterface(com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f5198b = cameraUIInterface;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.m_renamed = i_renamed;
        this.n_renamed = i2;
    }

    public void setSettleListener(com.oplus.camera.professional.p_renamed.c_renamed cVar) {
        this.i_renamed = cVar;
    }

    public void setMotionListener(com.oplus.camera.professional.p_renamed.b_renamed bVar) {
        this.j_renamed = bVar;
    }

    public void a_renamed(int i_renamed, int i2, int i3, android.os.Handler handler) {
        a_renamed(this.f_renamed, 1, false, a_renamed(i_renamed, i2, i3), 1, handler);
    }

    public void a_renamed(long j_renamed, long j2, java.util.List<android.util.Size> list, android.os.Handler handler) {
        a_renamed(this.f_renamed, 2, false, a_renamed(j_renamed, j2, list), 1, handler);
    }

    public void a_renamed(java.util.List<java.lang.Integer> list, android.os.Handler handler) {
        a_renamed(this.f_renamed, 5, false, b_renamed(list), 1, handler);
    }

    public void a_renamed(float f_renamed, float f2, android.os.Handler handler) {
        a_renamed(this.f_renamed, 4, false, a_renamed(f_renamed, f2), 1, handler);
    }

    public void a_renamed(int i_renamed, int i2, float f_renamed, android.os.Handler handler) {
        a_renamed(this.f_renamed, 3, false, a_renamed(i_renamed, i2, f_renamed), 2, handler);
    }

    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, android.os.Handler handler, com.oplus.camera.professional.p_renamed.a_renamed aVar) {
        a_renamed(hVar.u_renamed(), hVar.v_renamed(), hVar.w_renamed(), handler);
        a_renamed((aVar == null || aVar.f5203a <= 0) ? hVar.x_renamed() : aVar.f5203a, hVar.y_renamed(), hVar.a_renamed(256), handler);
        a_renamed(hVar.B_renamed(), handler);
        a_renamed(hVar.n_renamed(), hVar.m_renamed(), handler);
        a_renamed(hVar.p_renamed(), hVar.q_renamed(), hVar.r_renamed(), handler);
        e_renamed();
    }

    private int a_renamed(com.oplus.camera.professional.z_renamed zVar) {
        return zVar.f_renamed();
    }

    public java.lang.String getFocusValue() {
        if (g_renamed(4)) {
            return com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, 4);
        }
        return this.d_renamed.get(4).a_renamed(this.f5197a.t_renamed());
    }

    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> a_renamed(boolean z_renamed) {
        java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> arrayList = new java.util.ArrayList<>();
        if (z_renamed) {
            java.util.HashMap<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
            map.put("mainTitle", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.drawable.professional_mode_ic_reset));
            map.put("main_item_key", getResources().getString(com.oplus.camera.R_renamed.string.camera_face_beauty_menu_reset));
            map.put("main_item_index", 0);
            map.put("main_item_animation", java.lang.Integer.valueOf(com.oplus.camera.R_renamed.raw.pro_reset_animation));
            arrayList.add(map);
        }
        for (java.util.Map.Entry<java.lang.Integer, com.oplus.camera.professional.LevelPanel> entry : this.d_renamed.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            com.oplus.camera.professional.LevelPanel value = entry.getValue();
            java.util.HashMap<java.lang.String, java.lang.Object> map2 = new java.util.HashMap<>();
            map2.put("mainTitle", java.lang.Integer.valueOf(a_renamed(value.getSubModeBarData())));
            map2.put("main_item_key", value.a_renamed(this.f5197a.t_renamed()));
            map2.put("main_item_index", java.lang.Integer.valueOf(iIntValue));
            arrayList.add(map2);
        }
        return arrayList;
    }

    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, com.oplus.camera.professional.p_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        java.util.Map<java.lang.Integer, com.oplus.camera.professional.LevelPanel> map = this.d_renamed;
        if (map == null || map.size() == 0) {
            return;
        }
        d_renamed(hVar);
        b_renamed(hVar, aVar);
        c_renamed(hVar);
        b_renamed(hVar);
        a_renamed(hVar);
    }

    private void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (d_renamed(3).size() == 0) {
            a_renamed(this.d_renamed.get(3).getSubModeBarData(), hVar.p_renamed(), hVar.q_renamed(), hVar.r_renamed());
            this.d_renamed.get(3).d_renamed();
            if (this.i_renamed != null) {
                this.i_renamed.a_renamed(3, this.d_renamed.get(3).a_renamed(this.f5197a.t_renamed()), g_renamed(3));
            }
        }
    }

    private void b_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (d_renamed(4).size() == 0) {
            a_renamed(this.d_renamed.get(4).getSubModeBarData(), hVar.n_renamed(), hVar.m_renamed());
            this.d_renamed.get(4).d_renamed();
            if (this.i_renamed != null) {
                this.i_renamed.a_renamed(4, this.d_renamed.get(4).a_renamed(this.f5197a.t_renamed()), g_renamed(4));
            }
        }
    }

    private void c_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (d_renamed(5).size() == 0) {
            a_renamed(this.d_renamed.get(5).getSubModeBarData(), hVar.B_renamed());
            this.d_renamed.get(5).d_renamed();
            if (this.i_renamed != null) {
                this.i_renamed.a_renamed(5, this.d_renamed.get(5).a_renamed(this.f5197a.t_renamed()), g_renamed(5));
            }
        }
    }

    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, long j_renamed) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.professional.z_renamed subModeBarData = this.d_renamed.get(2).getSubModeBarData();
        subModeBarData.c_renamed().clear();
        subModeBarData.b_renamed().clear();
        subModeBarData.e_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_values);
        subModeBarData.f_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_names);
        a_renamed(subModeBarData, j_renamed, hVar.y_renamed(), hVar.a_renamed(256));
        this.d_renamed.get(2).d_renamed();
        if (this.i_renamed != null) {
            this.i_renamed.a_renamed(2, this.d_renamed.get(2).a_renamed(this.f5197a.t_renamed()), g_renamed(2));
        }
    }

    private void b_renamed(com.oplus.camera.e_renamed.h_renamed hVar, com.oplus.camera.professional.p_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.professional.z_renamed subModeBarData = this.d_renamed.get(2).getSubModeBarData();
        subModeBarData.c_renamed().clear();
        subModeBarData.b_renamed().clear();
        subModeBarData.e_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_values);
        subModeBarData.f_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_names);
        a_renamed(subModeBarData, (aVar == null || aVar.f5203a <= 0) ? hVar.x_renamed() : aVar.f5203a, hVar.y_renamed(), hVar.a_renamed(256));
        this.d_renamed.get(2).d_renamed();
        if (this.i_renamed != null) {
            this.i_renamed.a_renamed(2, this.d_renamed.get(2).a_renamed(this.f5197a.t_renamed()), g_renamed(2));
        }
    }

    private void d_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        a_renamed(this.d_renamed.get(1).getSubModeBarData(), hVar.u_renamed(), hVar.v_renamed(), hVar.w_renamed());
        this.d_renamed.get(1).d_renamed();
        if (this.i_renamed != null) {
            this.i_renamed.a_renamed(1, this.d_renamed.get(1).a_renamed(this.f5197a.t_renamed()), g_renamed(1));
        }
    }

    public java.util.ArrayList<java.lang.String> c_renamed(int i_renamed) {
        return this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).getParameterValueList();
    }

    public java.util.ArrayList<java.lang.String> d_renamed(int i_renamed) {
        return this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)) != null ? this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).getParameterNamesList() : new java.util.ArrayList<>();
    }

    @Override // android.view.View
    public void scrollTo(int i_renamed, int i2) {
        this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).a_renamed(i2, this.h_renamed);
    }

    public void b_renamed(int i_renamed, int i2) {
        this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).b_renamed(i2, this.h_renamed);
    }

    public void a_renamed(int i_renamed, int i2, java.lang.String str) {
        this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).a_renamed(i2, this.h_renamed, str);
    }

    public void a_renamed() {
        for (com.oplus.camera.professional.LevelPanel levelPanel : this.d_renamed.values()) {
            levelPanel.b_renamed(levelPanel.b_renamed(this.f5197a.t_renamed()));
        }
    }

    public boolean c_renamed(int i_renamed, int i2) {
        return this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).a_renamed(i2);
    }

    public java.lang.String e_renamed(int i_renamed) {
        return this.f5197a.t_renamed().getString(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed), com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, i_renamed));
    }

    public void a_renamed(int i_renamed, java.lang.String str, int i2) {
        if (this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)) != null) {
            java.util.ArrayList<java.lang.String> parameterValueList = this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).getParameterValueList();
            if (i2 < parameterValueList.size()) {
                android.content.SharedPreferences.Editor editorEdit = this.f5197a.t_renamed().edit();
                editorEdit.putString(str, parameterValueList.get(i2));
                editorEdit.putInt(str + "_manual", i2);
                editorEdit.apply();
            }
        }
    }

    public void b_renamed() {
        java.util.Map<java.lang.Integer, com.oplus.camera.professional.LevelPanel> map = this.d_renamed;
        if (map == null || map.size() == 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.f5197a.t_renamed().edit();
        java.util.Iterator<java.lang.Integer> it = this.d_renamed.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            editorEdit.putInt(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue) + "_manual", -1);
            editorEdit.putBoolean(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue) + "_manual_state", false);
            editorEdit.putString(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue), com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, iIntValue));
            editorEdit.putInt(com.oplus.camera.professional.x_renamed.a_renamed(iIntValue, null, "off") + "_manual", -1);
        }
        editorEdit.apply();
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.Integer, com.oplus.camera.professional.LevelPanel> map = this.d_renamed;
        if (map != null && map.size() != 0) {
            java.util.Iterator<java.lang.Integer> it = this.d_renamed.keySet().iterator();
            while (it.hasNext()) {
                if (!a_renamed(str, str2, it.next().intValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
        android.content.SharedPreferences sharedPreferencesT = this.f5197a.t_renamed();
        int i2 = sharedPreferencesT.getInt(com.oplus.camera.professional.x_renamed.a_renamed(i_renamed, str, str2) + "_manual", -1);
        int i3 = sharedPreferencesT.getInt(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed) + "_manual", -1);
        if (com.oplus.camera.professional.x_renamed.a_renamed(i_renamed)) {
            boolean zG = g_renamed(i_renamed);
            if (!zG || -1 == i2) {
                return zG || i2 == i3;
            }
            return false;
        }
        int iIndexOf = c_renamed(i_renamed).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, i_renamed));
        if (i2 == i3) {
            return true;
        }
        return (i2 == iIndexOf && -1 == i3) || (i3 == iIndexOf && -1 == i2);
    }

    public void b_renamed(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.Integer, com.oplus.camera.professional.LevelPanel> map = this.d_renamed;
        if (map == null || map.size() == 0) {
            return;
        }
        android.content.SharedPreferences sharedPreferencesT = this.f5197a.t_renamed();
        android.content.SharedPreferences.Editor editorEdit = sharedPreferencesT.edit();
        java.util.Iterator<java.lang.Integer> it = this.d_renamed.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int i_renamed = sharedPreferencesT.getInt(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue) + "_manual", -1);
            if (com.oplus.camera.professional.x_renamed.a_renamed(iIntValue) && g_renamed(iIntValue)) {
                i_renamed = -1;
            }
            editorEdit.putInt(com.oplus.camera.professional.x_renamed.a_renamed(iIntValue, str, str2) + "_manual", i_renamed);
        }
        editorEdit.apply();
    }

    public void c_renamed(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.Integer, com.oplus.camera.professional.LevelPanel> map = this.d_renamed;
        if (map == null || map.size() == 0) {
            return;
        }
        android.content.SharedPreferences sharedPreferencesT = this.f5197a.t_renamed();
        android.content.SharedPreferences.Editor editorEdit = sharedPreferencesT.edit();
        java.util.Iterator<java.lang.Integer> it = this.d_renamed.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int iIndexOf = sharedPreferencesT.getInt(com.oplus.camera.professional.x_renamed.a_renamed(iIntValue, str, str2) + "_manual", -1);
            if (!com.oplus.camera.professional.x_renamed.a_renamed(iIntValue) && -1 == iIndexOf) {
                iIndexOf = c_renamed(iIntValue).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, iIntValue));
            }
            if (iIndexOf >= c_renamed(iIntValue).size()) {
                iIndexOf = c_renamed(iIntValue).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, iIntValue));
            }
            editorEdit.putInt(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue) + "_manual", iIndexOf);
        }
        editorEdit.apply();
        java.util.Iterator<java.lang.Integer> it2 = this.d_renamed.keySet().iterator();
        while (it2.hasNext()) {
            int iIntValue2 = it2.next().intValue();
            if (!com.oplus.camera.professional.x_renamed.a_renamed(iIntValue2)) {
                a_renamed(false, iIntValue2);
                editorEdit.putBoolean(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue2) + "_manual_state", false);
                editorEdit.apply();
            }
        }
        java.util.Iterator<java.lang.Integer> it3 = this.d_renamed.keySet().iterator();
        while (it3.hasNext()) {
            int iIntValue3 = it3.next().intValue();
            if (com.oplus.camera.professional.x_renamed.a_renamed(iIntValue3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.oplus.camera.professional.x_renamed.b_renamed(iIntValue3));
                sb.append("_manual");
                a_renamed(!(-1 != sharedPreferencesT.getInt(sb.toString(), -1)), iIntValue3);
            }
        }
    }

    public int a_renamed(java.lang.String str) {
        return this.f5197a.t_renamed().getInt(str + "_manual", -1);
    }

    public java.lang.String a_renamed(int i_renamed, java.lang.String str) {
        int iA = a_renamed(str);
        if (iA < 0) {
            return null;
        }
        java.util.ArrayList<java.lang.String> parameterNamesList = this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).getParameterNamesList();
        if (iA > parameterNamesList.size() - 1) {
            return null;
        }
        return parameterNamesList.get(iA);
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, int i_renamed, int i2, float f_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PanelContainer", "generateExposureCompensationValues, minIndex: " + i_renamed + ", maxValue: " + i2 + ", step: " + f_renamed);
        if ((i_renamed == -1 && i2 == -1) || i_renamed > i2 || java.lang.Float.compare(f_renamed, 0.0f) == 0) {
            com.oplus.camera.e_renamed.f_renamed("PanelContainer", "generateExposureCompensationValues, return, minIndex: " + i_renamed + ", maxIndex: " + i2);
            return;
        }
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        arrayListB.clear();
        arrayListC.clear();
        while (i_renamed <= i2) {
            arrayListB.add(java.lang.String.valueOf(i_renamed));
            arrayListC.add(a_renamed(i_renamed, f_renamed));
            i_renamed++;
        }
    }

    public java.lang.String a_renamed(int i_renamed, float f_renamed) {
        float f2 = i_renamed * f_renamed;
        if (f2 <= 0.0f) {
            return java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2));
        }
        return "+" + java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2));
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, java.util.List<java.lang.Integer> list) {
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        if (list == null || list.size() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("PanelContainer", "generateWhiteBalanceValues, return, range: " + list);
            return;
        }
        arrayListB.clear();
        arrayListC.clear();
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            int iIntValue = list.get(i_renamed).intValue();
            arrayListB.add(java.lang.Integer.toString(iIntValue));
            arrayListC.add(iIntValue + com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS);
        }
    }

    public boolean c_renamed() {
        java.util.Iterator<com.oplus.camera.professional.LevelPanel> it = this.d_renamed.values().iterator();
        while (it.hasNext()) {
            if (it.next().getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public long a_renamed(java.util.List<android.util.Size> list) {
        long width = 0;
        for (android.util.Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        com.oplus.camera.e_renamed.a_renamed("PanelContainer", "getMaxPictureSize, max: " + width);
        return width;
    }

    protected void a_renamed(com.oplus.camera.professional.z_renamed zVar, long j_renamed, long j2, java.util.List<android.util.Size> list) throws java.lang.NumberFormatException {
        double d_renamed;
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        if (arrayListC != null && arrayListC.size() > 0 && arrayListB != null && arrayListB.size() > 0 && java.lang.Math.abs(1.0f - (a_renamed(list) / java.lang.Long.valueOf(com.oplus.camera.capmode.BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            arrayListC.remove(arrayListC.size() - 1);
            arrayListB.remove(arrayListB.size() - 1);
        }
        com.oplus.camera.e_renamed.b_renamed("PanelContainer", "generateShutterValues, max: " + j_renamed + ", min: " + j2 + ", before filtering, parameterNamesList: " + arrayListC);
        if (arrayListC == null || arrayListB == null) {
            return;
        }
        java.util.Iterator<java.lang.String> it = arrayListC.iterator();
        long j3 = -1;
        while (it.hasNext()) {
            java.lang.String[] strArrSplit = it.next().split("/");
            if (strArrSplit.length > 1) {
                d_renamed = java.lang.Double.parseDouble(strArrSplit[0]) / java.lang.Double.parseDouble(strArrSplit[1].split("s_renamed")[0]);
            } else {
                if (strArrSplit.length == 1) {
                    d_renamed = java.lang.Double.parseDouble(strArrSplit[0].split("s_renamed")[0]);
                }
                if (j3 >= j2 || j3 > j_renamed) {
                    it.remove();
                } else {
                    arrayListB.add(java.lang.String.valueOf(j3));
                }
            }
            j3 = (long) (d_renamed * 1.0E9d);
            if (j3 >= j2) {
            }
            it.remove();
        }
        long j4 = java.lang.Long.parseLong(arrayListB.get(arrayListB.size() - 1)) / com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
        long j5 = j_renamed / com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
        if (j4 < j5) {
            arrayListB.add(java.lang.String.valueOf(j_renamed));
            arrayListC.add(j5 + "s_renamed");
        }
        com.oplus.camera.e_renamed.b_renamed("PanelContainer", "generateShutterValues, after filtering, parameterValuesList: " + arrayListB + ", parameterNamesList: " + arrayListC);
        if (a_renamed("pref_professional_exposure_time_key") >= arrayListB.size()) {
            this.f5197a.t_renamed().edit().remove("pref_professional_exposure_time_key_manual").apply();
        }
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, float f_renamed, float f2) {
        if (f_renamed < f2) {
            f2 = f_renamed;
            f_renamed = f2;
        }
        if (java.lang.Float.compare(f_renamed, 0.0f) <= 0.0f || java.lang.Float.compare(f_renamed, f2) == 0) {
            com.oplus.camera.e_renamed.f_renamed("PanelContainer", "generateFocusValues, return, minFocusDistance: " + f_renamed);
            return;
        }
        float f3 = (f_renamed - f2) / 50.0f;
        com.oplus.camera.e_renamed.a_renamed("PanelContainer", "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + f_renamed);
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        arrayListB.clear();
        arrayListC.clear();
        for (int i_renamed = 0; i_renamed <= 50; i_renamed++) {
            float f4 = i_renamed;
            arrayListB.add(java.lang.Float.toString(f_renamed - (f3 * f4)));
            arrayListC.add(java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f4 * 0.02f)));
        }
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, int i_renamed, int i2, int i3) {
        if (i2 > i_renamed) {
            i_renamed = i2;
        }
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        if (i_renamed <= 0 || i3 <= 0 || i_renamed == i3) {
            com.oplus.camera.e_renamed.f_renamed("PanelContainer", "generateIsoValues, return null, maxISOValue: " + i_renamed + ", minISOValue: " + i3 + ", maxISOValue: " + i_renamed);
            return;
        }
        arrayListB.clear();
        arrayListC.clear();
        while (i3 <= i_renamed) {
            arrayListB.add(java.lang.Integer.toString(i3));
            arrayListC.add(java.lang.Integer.toString(i3));
            i3 += 100;
        }
    }

    private com.oplus.camera.professional.z_renamed b_renamed(java.util.List<java.lang.Integer> list) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(this.h_renamed).a_renamed(com.oplus.camera.R_renamed.string.camera_whitebalance_professional_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_wb).c_renamed(com.oplus.camera.R_renamed.id_renamed.awb_controller).a_renamed("awb_mode_key").b_renamed("pref_professional_whitebalance_key").d_renamed(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value);
        a_renamed(zVarD, list);
        return zVarD;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(int i_renamed, int i2, float f_renamed) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(this.h_renamed).a_renamed(com.oplus.camera.R_renamed.string.camera_exposure_compensation_professional_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_ev).c_renamed(com.oplus.camera.R_renamed.id_renamed.exposure_controller).a_renamed("iso_mode_key").b_renamed("pref_professional_exposure_compensation_key").d_renamed(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value);
        a_renamed(zVarD, i_renamed, i2, f_renamed);
        return zVarD;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(int i_renamed, int i2, int i3) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(this.h_renamed).a_renamed(com.oplus.camera.R_renamed.string.camera_iso_professional_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_iso).c_renamed(com.oplus.camera.R_renamed.id_renamed.iso_controller).a_renamed("exposure_mode_key").b_renamed("pref_professional_iso_key").d_renamed(com.oplus.camera.R_renamed.string.camera_iso_default_value);
        a_renamed(zVarD, i_renamed, i2, i3);
        return zVarD;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(long j_renamed, long j2, java.util.List<android.util.Size> list) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.professional.z_renamed zVarF = new com.oplus.camera.professional.z_renamed(this.h_renamed).a_renamed(com.oplus.camera.R_renamed.string.camera_exposure_time_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_s).c_renamed(com.oplus.camera.R_renamed.id_renamed.shutter_controller).a_renamed("shutter_mode_key").b_renamed("pref_professional_exposure_time_key").d_renamed(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).e_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_values).f_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_names);
        a_renamed(zVarF, j_renamed, j2, list);
        return zVarF;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(float f_renamed, float f2) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(this.h_renamed).a_renamed(com.oplus.camera.R_renamed.string.camera_focus_mode_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_af).c_renamed(com.oplus.camera.R_renamed.id_renamed.manual_focus_controller).a_renamed("manual_focus_mode_key").b_renamed("pref_professional_focus_mode_key").d_renamed(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value);
        a_renamed(zVarD, f_renamed, f2);
        return zVarD;
    }

    public void a_renamed(boolean z_renamed, int i_renamed) {
        if (z_renamed) {
            setAuto(i_renamed);
        } else {
            setManual(i_renamed);
        }
        com.oplus.camera.professional.p_renamed.c_renamed cVar = this.i_renamed;
        if (cVar != null) {
            cVar.b_renamed(i_renamed, z_renamed);
        }
    }

    public void d_renamed() {
        java.util.Iterator<com.oplus.camera.professional.LevelPanel> it = this.d_renamed.values().iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.d_renamed.clear();
        this.e_renamed.clear();
    }

    public void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams, final int i_renamed, boolean z_renamed, com.oplus.camera.professional.z_renamed zVar, int i2, android.os.Handler handler) {
        if (this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)) != null) {
            com.oplus.camera.e_renamed.f_renamed("PanelContainer", "addControllerPanel, return, size: " + this.d_renamed.size());
            return;
        }
        final com.oplus.camera.professional.LevelPanel levelPanel = new com.oplus.camera.professional.LevelPanel(this.h_renamed, true, handler, z_renamed, com.oplus.camera.professional.x_renamed.a_renamed(i_renamed), this.m_renamed, this.n_renamed, zVar, this.f5197a.t_renamed());
        levelPanel.setLayoutParams(layoutParams);
        levelPanel.setAlign(i2);
        addView(levelPanel);
        levelPanel.setValueChangeListener(new com.oplus.camera.professional.LevelPanel.ValueChangeListener() { // from class: com.oplus.camera.professional.p_renamed.1
            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onManualValueChange(int i3) {
                if (levelPanel.getVisibility() == 0 && 1.0f == levelPanel.getAlpha()) {
                    com.oplus.camera.professional.p_renamed.this.i_renamed(i3);
                    com.oplus.camera.professional.p_renamed pVar = com.oplus.camera.professional.p_renamed.this;
                    int i4 = i_renamed;
                    pVar.a_renamed(i4, com.oplus.camera.professional.x_renamed.b_renamed(i4), i3);
                    com.oplus.camera.professional.p_renamed.this.i_renamed.a_renamed(i_renamed, levelPanel.a_renamed(com.oplus.camera.professional.p_renamed.this.f5197a.t_renamed()), false);
                }
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoValueChange(int i3) {
                com.oplus.camera.professional.p_renamed.this.i_renamed.a_renamed(i_renamed, levelPanel.a_renamed(com.oplus.camera.professional.p_renamed.this.f5197a.t_renamed()), true);
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoButtonClick() {
                if (com.oplus.camera.professional.p_renamed.this.l_renamed) {
                    return;
                }
                if (com.oplus.camera.professional.p_renamed.this.g_renamed(i_renamed)) {
                    com.oplus.camera.professional.p_renamed.this.a_renamed(false, i_renamed);
                    com.oplus.camera.professional.p_renamed.this.j_renamed.a_renamed(i_renamed, com.oplus.camera.statistics.model.MenuClickMsgData.VALUE_PROFESSION_AUTO_OFF, false);
                } else {
                    com.oplus.camera.professional.p_renamed.this.a_renamed(true, i_renamed);
                    com.oplus.camera.professional.p_renamed.this.j_renamed.a_renamed(i_renamed, "auto", true);
                }
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onBarScrolling(boolean z2) {
                if (com.oplus.camera.professional.p_renamed.this.l_renamed && !z2) {
                    com.oplus.camera.professional.p_renamed.this.j_renamed.a_renamed(i_renamed, levelPanel.a_renamed(com.oplus.camera.professional.p_renamed.this.f5197a.t_renamed()), false);
                }
                com.oplus.camera.professional.p_renamed.this.l_renamed = z2;
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onActionUp() {
                if (com.oplus.camera.professional.p_renamed.this.l_renamed) {
                    return;
                }
                com.oplus.camera.professional.p_renamed.this.j_renamed.a_renamed(i_renamed, levelPanel.a_renamed(com.oplus.camera.professional.p_renamed.this.f5197a.t_renamed()), false);
            }
        });
        this.d_renamed.put(java.lang.Integer.valueOf(i_renamed), levelPanel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed(int i_renamed) {
        com.oplus.camera.ae_renamed aeVarAd;
        if (this.g_renamed && (aeVarAd = this.f5197a.ad_renamed()) != null) {
            if (i_renamed % 10 == 0) {
                aeVarAd.f_renamed();
            } else {
                aeVarAd.d_renamed();
            }
        }
    }

    public void b_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    public void f_renamed(int i_renamed) {
        a_renamed(i_renamed, false);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        boolean zC = c_renamed();
        if (z_renamed) {
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            setAllPopupInvisibility(aVar);
        } else {
            setAllPopupInvisibility(null);
        }
        com.oplus.camera.professional.LevelPanel levelPanel = this.d_renamed.get(java.lang.Integer.valueOf(i_renamed));
        android.animation.Animator animatorRemove = this.e_renamed.remove(levelPanel);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        levelPanel.setScaleBarTouchable(true);
        if (z_renamed) {
            com.oplus.camera.professional.u_renamed.a_renamed aVar2 = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar2.f5239a = true;
            aVar2.f5240b = 150;
            aVar2.f5241c = zC ? 250 : 400;
            aVar2.d_renamed = zC ? 0.0f : this.h_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_animation_offset);
            aVar2.e_renamed = 0.0f;
            aVar2.f_renamed = zC ? 0 : 150;
            aVar2.g_renamed = zC ? 0 : 400;
            aVar2.h_renamed = 1 == this.m_renamed ? "translationX" : "translationY";
            this.e_renamed.put(levelPanel, com.oplus.camera.professional.u_renamed.a_renamed(levelPanel, aVar2));
            return;
        }
        levelPanel.setVisibility(0);
    }

    public boolean g_renamed(int i_renamed) {
        if (i_renamed < 0 || this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)) == null) {
            return false;
        }
        android.content.SharedPreferences sharedPreferencesT = this.f5197a.t_renamed();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed));
        sb.append("_manual_state");
        return e_renamed(i_renamed).equals(com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, i_renamed)) && !sharedPreferencesT.getBoolean(sb.toString(), false);
    }

    public void setPreference(int i_renamed) {
        android.content.SharedPreferences.Editor editorEdit = this.f5197a.t_renamed().edit();
        editorEdit.putString(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed), com.oplus.camera.professional.x_renamed.a_renamed(this.h_renamed, i_renamed));
        editorEdit.putBoolean(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed) + "_manual_state", false);
        editorEdit.apply();
    }

    public void setPanelsBarAuto(int i_renamed) {
        b_renamed(i_renamed, true);
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).setBarAuto(z_renamed);
    }

    public void setAuto(int i_renamed) {
        setPreference(i_renamed);
        setPanelsBarAuto(i_renamed);
    }

    public void setManual(int i_renamed) {
        android.content.SharedPreferences.Editor editorEdit = this.f5197a.t_renamed().edit();
        editorEdit.putBoolean(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed) + "_manual_state", true);
        editorEdit.apply();
        int iA = a_renamed(com.oplus.camera.professional.x_renamed.b_renamed(i_renamed));
        if (iA >= 0) {
            a_renamed(i_renamed, iA, a_renamed(i_renamed, com.oplus.camera.professional.x_renamed.b_renamed(i_renamed)));
        } else {
            int currentIndex = this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).getCurrentIndex();
            a_renamed(i_renamed, currentIndex, this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).getParameterNamesList().get(currentIndex));
        }
        this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).setBarAuto(false);
    }

    public boolean h_renamed(int i_renamed) {
        if (g_renamed(i_renamed)) {
            this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).setBarAuto(true);
            return true;
        }
        this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).setBarAuto(false);
        return false;
    }

    public void e_renamed() {
        setAllPopupInvisibility(null);
    }

    public void setAllPopupInvisibility(com.oplus.camera.professional.u_renamed.a_renamed aVar) {
        for (com.oplus.camera.professional.LevelPanel levelPanel : this.d_renamed.values()) {
            android.animation.Animator animatorRemove = this.e_renamed.remove(levelPanel);
            if (animatorRemove != null) {
                animatorRemove.cancel();
            }
            levelPanel.setScaleBarTouchable(false);
            if (levelPanel.getVisibility() == 0 && aVar != null) {
                aVar.h_renamed = 1 == this.m_renamed ? "translationX" : "translationY";
                this.e_renamed.put(levelPanel, com.oplus.camera.professional.u_renamed.a_renamed(levelPanel, aVar));
            } else {
                levelPanel.setVisibility(4);
            }
        }
    }

    public void f_renamed() {
        java.util.Iterator<com.oplus.camera.professional.LevelPanel> it = this.d_renamed.values().iterator();
        while (it.hasNext()) {
            it.next().setValueChangeListener(null);
        }
        this.h_renamed = null;
    }

    @Override // com.oplus.camera.professional.q_renamed
    public boolean a_renamed(int i_renamed) {
        return g_renamed(i_renamed);
    }

    @Override // com.oplus.camera.professional.q_renamed
    public boolean b_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return (g_renamed(1) && g_renamed(2) && g_renamed(3) && g_renamed(4) && g_renamed(5)) ? false : true;
        }
        if (3 == i_renamed) {
            return g_renamed(1) || g_renamed(2);
        }
        return true;
    }

    public boolean g_renamed() {
        return this.l_renamed;
    }

    public void h_renamed() {
        this.l_renamed = false;
    }

    public com.oplus.camera.professional.p_renamed.a_renamed getConfigData() {
        return this.k_renamed;
    }

    /* compiled from: PanelContainer.java */
    public class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f5203a = 0;

        /* renamed from: b_renamed, reason: collision with root package name */
        public long f5204b = 0;

        public a_renamed() {
        }
    }

    public void d_renamed(int i_renamed, int i2) {
        com.oplus.camera.capmode.a_renamed aVar = this.f5197a;
        if (aVar != null && !aVar.G_renamed()) {
            this.f5197a.a_renamed(true, false);
            com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.f5198b;
            if (cameraUIInterface != null) {
                cameraUIInterface.g_renamed(0);
            }
        }
        e_renamed();
        a_renamed(i_renamed, i2);
    }
}
