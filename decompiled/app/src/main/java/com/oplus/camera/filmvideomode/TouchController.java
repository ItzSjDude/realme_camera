package com.oplus.camera.filmvideomode;

/* compiled from: FilmSlideBarContainer.java */
/* loaded from: classes2.dex */
public class l_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f4506a = "l_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.util.Map<java.lang.Integer, com.oplus.camera.filmvideomode.c_renamed> f4507b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected java.util.Map<com.oplus.camera.professional.LevelPanel, android.animation.Animator> f4508c;
    private com.oplus.camera.capmode.a_renamed d_renamed;
    private android.content.SharedPreferences e_renamed;
    private android.widget.RelativeLayout.LayoutParams f_renamed;
    private com.oplus.camera.filmvideomode.l_renamed.a_renamed g_renamed;
    private com.oplus.camera.professional.p_renamed.b_renamed h_renamed;
    private com.oplus.camera.filmvideomode.k_renamed.a_renamed i_renamed;
    private boolean j_renamed;
    private int k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;

    /* compiled from: FilmSlideBarContainer.java */
    public interface a_renamed {
        void a_renamed(int i_renamed, int i2, boolean z_renamed);

        void b_renamed(int i_renamed, boolean z_renamed);
    }

    public l_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar) {
        super(context);
        this.d_renamed = null;
        this.e_renamed = null;
        this.f4507b = new java.util.HashMap();
        this.f4508c = new java.util.HashMap();
        this.f_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = false;
        this.k_renamed = 0;
        this.l_renamed = true;
        this.m_renamed = false;
        this.f_renamed.addRule(14);
        this.f_renamed.height = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_slide_bar_click_height);
        if (com.oplus.camera.util.Util.u_renamed()) {
            this.f_renamed.width = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_width);
            this.f_renamed.bottomMargin = 0;
        } else {
            this.f_renamed.bottomMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_slide_bar_margin_bottom);
        }
        this.d_renamed = aVar;
        this.e_renamed = aVar.t_renamed();
        this.k_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_slide_bar_touch_rect_height);
    }

    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, android.os.Handler handler) {
        a_renamed(hVar.u_renamed(), hVar.v_renamed(), hVar.w_renamed(), handler);
        a_renamed(java.lang.Math.min(125000000L, hVar.x_renamed()), hVar.y_renamed(), hVar.a_renamed(256), handler);
        a_renamed(hVar.B_renamed(), handler);
        a_renamed(hVar.n_renamed(), hVar.m_renamed(), handler);
        a_renamed(hVar.p_renamed(), hVar.q_renamed(), hVar.r_renamed(), handler);
        b_renamed();
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

    public void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams, final int i_renamed, boolean z_renamed, com.oplus.camera.professional.z_renamed zVar, int i2, android.os.Handler handler) {
        if (this.f4507b.get(java.lang.Integer.valueOf(i_renamed)) != null) {
            com.oplus.camera.e_renamed.f_renamed(f4506a, "addControllerPanel, return, size: " + this.f4507b.size());
            return;
        }
        final com.oplus.camera.filmvideomode.c_renamed cVar = new com.oplus.camera.filmvideomode.c_renamed(getContext(), true, handler, z_renamed, com.oplus.camera.professional.x_renamed.a_renamed(i_renamed), zVar, this.d_renamed.t_renamed());
        cVar.setLayoutParams(layoutParams);
        cVar.setAlign(i2);
        addView(cVar);
        cVar.setValueChangeListener(new com.oplus.camera.professional.LevelPanel.ValueChangeListener() { // from class: com.oplus.camera.filmvideomode.l_renamed.1
            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onManualValueChange(int i3) {
                com.oplus.camera.filmvideomode.l_renamed.this.i_renamed(i3);
                com.oplus.camera.filmvideomode.l_renamed.this.a_renamed(i_renamed, cVar.getPreferencesKey(), i3);
                com.oplus.camera.filmvideomode.l_renamed.this.g_renamed.a_renamed(i_renamed, i3, false);
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoValueChange(int i3) {
                com.oplus.camera.filmvideomode.l_renamed.this.g_renamed.a_renamed(i_renamed, i3, true);
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoButtonClick() {
                if (com.oplus.camera.filmvideomode.l_renamed.this.j_renamed) {
                    return;
                }
                if (com.oplus.camera.filmvideomode.l_renamed.this.e_renamed(i_renamed)) {
                    com.oplus.camera.filmvideomode.l_renamed.this.a_renamed(false, i_renamed);
                    com.oplus.camera.filmvideomode.l_renamed.this.h_renamed.a_renamed(i_renamed, com.oplus.camera.statistics.model.MenuClickMsgData.VALUE_PROFESSION_AUTO_OFF, false);
                } else {
                    com.oplus.camera.filmvideomode.l_renamed.this.a_renamed(true, i_renamed);
                    com.oplus.camera.filmvideomode.l_renamed.this.h_renamed.a_renamed(i_renamed, "auto", true);
                }
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onBarScrolling(boolean z2) {
                if (com.oplus.camera.filmvideomode.l_renamed.this.j_renamed && !z2) {
                    com.oplus.camera.filmvideomode.l_renamed.this.h_renamed.a_renamed(i_renamed, cVar.a_renamed(com.oplus.camera.filmvideomode.l_renamed.this.d_renamed.t_renamed()), false);
                }
                com.oplus.camera.filmvideomode.l_renamed.this.j_renamed = z2;
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onActionUp() {
                if (com.oplus.camera.filmvideomode.l_renamed.this.j_renamed) {
                    return;
                }
                com.oplus.camera.filmvideomode.l_renamed.this.h_renamed.a_renamed(i_renamed, cVar.a_renamed(com.oplus.camera.filmvideomode.l_renamed.this.d_renamed.t_renamed()), false);
            }
        });
        this.f4507b.put(java.lang.Integer.valueOf(i_renamed), cVar);
    }

    public java.util.Map<java.lang.Integer, com.oplus.camera.filmvideomode.c_renamed> getPanelMap() {
        return this.f4507b;
    }

    public java.lang.String a_renamed(int i_renamed) {
        java.util.ArrayList<java.lang.String> parameterValueList;
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar != null && (parameterValueList = cVar.getParameterValueList()) != null && parameterValueList.size() > 0) {
            int currentIndex = cVar.getCurrentIndex();
            if (currentIndex >= 0 && currentIndex < parameterValueList.size()) {
                return parameterValueList.get(currentIndex);
            }
            java.lang.String strD = d_renamed(i_renamed);
            if (!"".equals(strD) && !"auto".equals(strD)) {
                return strD;
            }
        }
        return "0";
    }

    public java.lang.String a_renamed(int i_renamed, int i2) {
        java.util.ArrayList<java.lang.String> parameterValueList;
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar != null && (parameterValueList = cVar.getParameterValueList()) != null && parameterValueList.size() > 0) {
            if (i2 >= 0 && i2 < parameterValueList.size()) {
                return parameterValueList.get(i2);
            }
            java.lang.String strD = d_renamed(i_renamed);
            if (!"".equals(strD) && !"auto".equals(strD)) {
                return strD;
            }
        }
        return "0";
    }

    public java.util.ArrayList<java.lang.String> b_renamed(int i_renamed) {
        return this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).getParameterValueList();
    }

    public java.util.ArrayList<java.lang.String> c_renamed(int i_renamed) {
        return this.f4507b.get(java.lang.Integer.valueOf(i_renamed)) != null ? this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).getParameterNamesList() : new java.util.ArrayList<>();
    }

    public void a_renamed(int i_renamed, java.lang.String str, int i2) {
        if (this.f4507b.get(java.lang.Integer.valueOf(i_renamed)) != null) {
            java.util.ArrayList<java.lang.String> parameterValueList = this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).getParameterValueList();
            if (i2 < parameterValueList.size()) {
                android.content.SharedPreferences.Editor editorEdit = this.d_renamed.t_renamed().edit();
                editorEdit.putString(str, parameterValueList.get(i2));
                editorEdit.putInt(str + "_manual", i2);
                editorEdit.apply();
            }
        }
    }

    private com.oplus.camera.professional.z_renamed b_renamed(java.util.List<java.lang.Integer> list) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(getContext()).a_renamed(com.oplus.camera.R_renamed.string.camera_whitebalance_professional_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_wb).c_renamed(com.oplus.camera.R_renamed.id_renamed.awb_controller).a_renamed("awb_mode_key").b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE).d_renamed(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value);
        a_renamed(zVarD, list);
        return zVarD;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(int i_renamed, int i2, float f_renamed) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(getContext()).a_renamed(com.oplus.camera.R_renamed.string.camera_exposure_compensation_professional_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_ev).c_renamed(com.oplus.camera.R_renamed.id_renamed.exposure_controller).a_renamed("iso_mode_key").b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE).d_renamed(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value);
        a_renamed(zVarD, i_renamed, i2, f_renamed);
        return zVarD;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(int i_renamed, int i2, int i3) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(getContext()).a_renamed(com.oplus.camera.R_renamed.string.camera_iso_professional_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_iso).c_renamed(com.oplus.camera.R_renamed.id_renamed.iso_controller).a_renamed("exposure_mode_key").b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO).d_renamed(com.oplus.camera.R_renamed.string.camera_iso_default_value);
        a_renamed(zVarD, i_renamed, i2, i3);
        return zVarD;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(long j_renamed, long j2, java.util.List<android.util.Size> list) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.professional.z_renamed zVarF = new com.oplus.camera.professional.z_renamed(getContext()).a_renamed(com.oplus.camera.R_renamed.string.camera_exposure_time_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_s).c_renamed(com.oplus.camera.R_renamed.id_renamed.shutter_controller).a_renamed("shutter_mode_key").b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER).d_renamed(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value_auto).e_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_values).f_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_names);
        a_renamed(zVarF, j_renamed, j2, list);
        return zVarF;
    }

    private com.oplus.camera.professional.z_renamed a_renamed(float f_renamed, float f2) {
        com.oplus.camera.professional.z_renamed zVarD = new com.oplus.camera.professional.z_renamed(getContext()).a_renamed(com.oplus.camera.R_renamed.string.camera_focus_mode_title).b_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_af).c_renamed(com.oplus.camera.R_renamed.id_renamed.manual_focus_controller).a_renamed("manual_focus_mode_key").b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS).d_renamed(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value);
        a_renamed(zVarD, f_renamed, f2);
        return zVarD;
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, int i_renamed, int i2, float f_renamed) {
        if ((i_renamed == -1 && i2 == -1) || i_renamed > i2 || java.lang.Float.compare(f_renamed, 0.0f) == 0) {
            com.oplus.camera.e_renamed.f_renamed(f4506a, "generateExposureCompensationValues, return, minIndex: " + i_renamed + ", maxIndex: " + i2);
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

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, java.util.List<java.lang.Integer> list) {
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        if (list == null || list.size() <= 0) {
            com.oplus.camera.e_renamed.f_renamed(f4506a, "generateWhiteBalanceValues, return, range: " + list);
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

    protected void a_renamed(com.oplus.camera.professional.z_renamed zVar, long j_renamed, long j2, java.util.List<android.util.Size> list) throws java.lang.NumberFormatException {
        double d_renamed;
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        if (arrayListC != null && arrayListC.size() > 0 && arrayListB != null && arrayListB.size() > 0 && java.lang.Math.abs(1.0f - (a_renamed(list) / java.lang.Long.valueOf(com.oplus.camera.capmode.BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            arrayListC.remove(arrayListC.size() - 1);
            arrayListB.remove(arrayListB.size() - 1);
        }
        com.oplus.camera.e_renamed.b_renamed(f4506a, "generateShutterValues, max: " + j_renamed + ", min: " + j2 + ", before filtering, parameterNamesList: " + arrayListC);
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
        com.oplus.camera.e_renamed.b_renamed(f4506a, "generateShutterValues, after filtering, parameterValuesList: " + arrayListB + ", parameterNamesList: " + arrayListC);
        if (a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER) >= arrayListB.size()) {
            this.d_renamed.t_renamed().edit().remove("pref_film_mode_shutter_manual").apply();
        }
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, float f_renamed, float f2) {
        if (f_renamed < f2) {
            f2 = f_renamed;
            f_renamed = f2;
        }
        if (java.lang.Float.compare(f_renamed, 0.0f) <= 0.0f || java.lang.Float.compare(f_renamed, f2) == 0) {
            com.oplus.camera.e_renamed.f_renamed(f4506a, "generateFocusValues, return, minFocusDistance: " + f_renamed);
            return;
        }
        float f3 = (f_renamed - f2) / 50.0f;
        com.oplus.camera.e_renamed.a_renamed(f4506a, "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + f_renamed);
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
            com.oplus.camera.e_renamed.f_renamed(f4506a, "generateIsoValues, return null, maxISOValue: " + i_renamed + ", minISOValue: " + i3 + ", maxISOValue: " + i_renamed);
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

    public java.lang.String a_renamed(int i_renamed, float f_renamed) {
        float f2 = i_renamed * f_renamed;
        if (f2 <= 0.0f) {
            return java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2));
        }
        return "+" + java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2));
    }

    public long a_renamed(java.util.List<android.util.Size> list) {
        long width = 0;
        for (android.util.Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        com.oplus.camera.e_renamed.a_renamed(f4506a, "getMaxPictureSize, max: " + width);
        return width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed(int i_renamed) {
        com.oplus.camera.ae_renamed aeVarAd;
        if (!this.l_renamed || this.m_renamed || (aeVarAd = this.d_renamed.ad_renamed()) == null) {
            return;
        }
        if (i_renamed % 10 == 0) {
            aeVarAd.f_renamed();
        } else {
            aeVarAd.d_renamed();
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        boolean zA = a_renamed();
        com.oplus.camera.filmvideomode.k_renamed.a_renamed aVar = this.i_renamed;
        if (aVar != null) {
            aVar.e_renamed(true);
        }
        if (z_renamed) {
            com.oplus.camera.professional.u_renamed.a_renamed aVar2 = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar2.f5239a = false;
            aVar2.f5241c = 250;
            setAllPopupInvisibility(aVar2);
        } else {
            setAllPopupInvisibility(null);
        }
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        android.animation.Animator animatorRemove = this.f4508c.remove(cVar);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        if (cVar == null) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.professional.u_renamed.a_renamed aVar3 = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar3.f5239a = true;
            aVar3.f5240b = 150;
            aVar3.f5241c = zA ? 250 : 400;
            aVar3.d_renamed = zA ? 0.0f : getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_animation_offset);
            aVar3.e_renamed = 0.0f;
            aVar3.f_renamed = zA ? 0 : 150;
            aVar3.g_renamed = zA ? 0 : 400;
            this.f4508c.put(cVar, com.oplus.camera.professional.u_renamed.a_renamed(cVar, aVar3));
            return;
        }
        cVar.setVisibility(0);
    }

    public boolean a_renamed() {
        java.util.Iterator<com.oplus.camera.filmvideomode.c_renamed> it = this.f4507b.values().iterator();
        while (it.hasNext()) {
            if (it.next().getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public int getVisibilityPanelIndex() {
        for (java.util.Map.Entry<java.lang.Integer, com.oplus.camera.filmvideomode.c_renamed> entry : this.f4507b.entrySet()) {
            if (entry.getValue().getVisibility() == 0) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public void b_renamed() {
        setAllPopupInvisibility(null);
    }

    public void setAllPopupInvisibility(com.oplus.camera.professional.u_renamed.a_renamed aVar) {
        for (com.oplus.camera.filmvideomode.c_renamed cVar : this.f4507b.values()) {
            android.animation.Animator animatorRemove = this.f4508c.remove(cVar);
            if (animatorRemove != null) {
                animatorRemove.cancel();
            }
            if (cVar.getVisibility() == 0 && aVar != null) {
                this.f4508c.put(cVar, com.oplus.camera.professional.u_renamed.a_renamed(cVar, aVar));
            } else {
                cVar.setVisibility(4);
            }
        }
    }

    public void setParamsStateListener(com.oplus.camera.filmvideomode.k_renamed.a_renamed aVar) {
        this.i_renamed = aVar;
    }

    public void a_renamed(boolean z_renamed, int i_renamed) {
        if (e_renamed(i_renamed) == z_renamed) {
            com.oplus.camera.e_renamed.b_renamed(f4506a, "onManualClick, no change, isAuto: " + z_renamed);
            return;
        }
        if (z_renamed) {
            setAuto(i_renamed);
        } else {
            setManual(i_renamed);
        }
        com.oplus.camera.filmvideomode.l_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            aVar.b_renamed(i_renamed, z_renamed);
        }
    }

    public void setPanelsBarAuto(int i_renamed) {
        this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).setBarAuto(true);
    }

    public void setAuto(int i_renamed) {
        setPreferenceAuto(i_renamed);
        setPanelsBarAuto(i_renamed);
    }

    public void setManual(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar == null) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.d_renamed.t_renamed().edit();
        editorEdit.putBoolean(cVar.getPreferencesKey() + "_manual_state", true);
        editorEdit.apply();
        int iA = a_renamed(cVar.getPreferencesKey());
        if (iA >= 0) {
            a_renamed(i_renamed, iA, a_renamed(i_renamed, cVar.getPreferencesKey()));
        } else {
            int currentIndex = cVar.getCurrentIndex();
            a_renamed(i_renamed, currentIndex, cVar.getParameterNamesList().get(currentIndex));
        }
        cVar.setBarAuto(false);
    }

    public int a_renamed(java.lang.String str) {
        return this.d_renamed.t_renamed().getInt(str + "_manual", -1);
    }

    public java.lang.String a_renamed(int i_renamed, java.lang.String str) {
        int iA = a_renamed(str);
        if (iA < 0) {
            return null;
        }
        java.util.ArrayList<java.lang.String> parameterNamesList = this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).getParameterNamesList();
        if (iA > parameterNamesList.size() - 1) {
            return null;
        }
        return parameterNamesList.get(iA);
    }

    public void setPreferenceAuto(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar == null) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.d_renamed.t_renamed().edit();
        editorEdit.putString(cVar.getPreferencesKey(), cVar.getDefaultValue());
        editorEdit.putBoolean(cVar.getPreferencesKey() + "_manual_state", false);
        editorEdit.apply();
    }

    public java.lang.String d_renamed(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        return cVar == null ? "" : this.d_renamed.t_renamed().getString(cVar.getPreferencesKey(), cVar.getDefaultValue());
    }

    public void b_renamed(int i_renamed, int i2) {
        this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).b_renamed(i2, (android.app.Activity) getContext());
    }

    public void a_renamed(int i_renamed, int i2, java.lang.String str) {
        this.f4507b.get(java.lang.Integer.valueOf(i_renamed)).a_renamed(i2, (android.app.Activity) getContext(), str);
    }

    public boolean e_renamed(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar == null) {
            return false;
        }
        android.content.SharedPreferences sharedPreferencesT = this.d_renamed.t_renamed();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cVar.getPreferencesKey());
        sb.append("_manual_state");
        return d_renamed(i_renamed).equals(cVar.getDefaultValue()) && !sharedPreferencesT.getBoolean(sb.toString(), false);
    }

    public void setMotionListener(com.oplus.camera.professional.p_renamed.b_renamed bVar) {
        this.h_renamed = bVar;
    }

    public void setValueListener(com.oplus.camera.filmvideomode.l_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }

    public void c_renamed() {
        java.util.Map<java.lang.Integer, com.oplus.camera.filmvideomode.c_renamed> map = this.f4507b;
        if (map == null || map.size() == 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.d_renamed.t_renamed().edit();
        for (com.oplus.camera.filmvideomode.c_renamed cVar : this.f4507b.values()) {
            editorEdit.putInt(cVar.getPreferencesKey() + "_manual", -1);
            editorEdit.putBoolean(cVar.getPreferencesKey() + "_manual_state", false);
            editorEdit.putString(cVar.getPreferencesKey(), cVar.getDefaultValue());
        }
        editorEdit.apply();
    }

    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        java.util.Map<java.lang.Integer, com.oplus.camera.filmvideomode.c_renamed> map = this.f4507b;
        if (map == null || map.size() == 0) {
            return;
        }
        f_renamed(hVar);
        e_renamed(hVar);
        d_renamed(hVar);
        c_renamed(hVar);
        b_renamed(hVar);
    }

    private void b_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        a_renamed(this.f4507b.get(3).getSubModeBarData(), hVar.p_renamed(), hVar.q_renamed(), hVar.r_renamed());
        this.f4507b.get(3).d_renamed();
        if (this.g_renamed != null) {
            this.g_renamed.a_renamed(3, this.f4507b.get(3).b_renamed(this.d_renamed.t_renamed()), e_renamed(3));
        }
    }

    private void c_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        a_renamed(this.f4507b.get(4).getSubModeBarData(), hVar.n_renamed(), hVar.m_renamed());
        this.f4507b.get(4).d_renamed();
        this.f4507b.get(4).setBarAuto(e_renamed(4));
        if (this.g_renamed != null) {
            this.g_renamed.a_renamed(4, this.f4507b.get(4).b_renamed(this.d_renamed.t_renamed()), e_renamed(4));
        }
    }

    private void d_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        a_renamed(this.f4507b.get(5).getSubModeBarData(), hVar.B_renamed());
        this.f4507b.get(5).d_renamed();
        this.f4507b.get(5).setBarAuto(e_renamed(5));
        if (this.g_renamed != null) {
            this.g_renamed.a_renamed(5, this.f4507b.get(5).b_renamed(this.d_renamed.t_renamed()), e_renamed(5));
        }
    }

    private void e_renamed(com.oplus.camera.e_renamed.h_renamed hVar) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.professional.z_renamed subModeBarData = this.f4507b.get(2).getSubModeBarData();
        subModeBarData.c_renamed().clear();
        subModeBarData.b_renamed().clear();
        subModeBarData.e_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_values);
        subModeBarData.f_renamed(com.oplus.camera.R_renamed.array.professional_exposure_time_names);
        a_renamed(subModeBarData, java.lang.Math.min(125000000L, hVar.x_renamed()), hVar.y_renamed(), hVar.a_renamed(256));
        this.f4507b.get(2).d_renamed();
        this.f4507b.get(2).setBarAuto(e_renamed(2));
        if (this.g_renamed != null) {
            this.g_renamed.a_renamed(2, this.f4507b.get(2).b_renamed(this.d_renamed.t_renamed()), e_renamed(2));
        }
    }

    private void f_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        a_renamed(this.f4507b.get(1).getSubModeBarData(), hVar.u_renamed(), hVar.v_renamed(), hVar.w_renamed());
        this.f4507b.get(1).d_renamed();
        this.f4507b.get(1).setBarAuto(e_renamed(1));
        if (this.g_renamed != null) {
            this.g_renamed.a_renamed(1, this.f4507b.get(1).b_renamed(this.d_renamed.t_renamed()), e_renamed(1));
        }
    }

    @Override // android.view.View
    public void scrollTo(int i_renamed, int i2) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (!(getContext() instanceof android.app.Activity) || cVar == null) {
            return;
        }
        cVar.a_renamed(i2, (android.app.Activity) getContext());
    }

    public java.lang.String f_renamed(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar != null) {
            return cVar.a_renamed(this.e_renamed);
        }
        return null;
    }

    public java.lang.String g_renamed(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar != null) {
            return cVar.a_renamed(f_renamed(i_renamed));
        }
        return null;
    }

    public java.lang.String h_renamed(int i_renamed) {
        com.oplus.camera.filmvideomode.c_renamed cVar = this.f4507b.get(java.lang.Integer.valueOf(i_renamed));
        if (cVar != null) {
            return cVar.getSubModeBarData().d_renamed();
        }
        return null;
    }

    public void d_renamed() {
        for (com.oplus.camera.filmvideomode.c_renamed cVar : this.f4507b.values()) {
            cVar.b_renamed(cVar.b_renamed(this.d_renamed.t_renamed()));
        }
    }

    public android.graphics.Rect getTouchAreaRect() {
        return new android.graphics.Rect(getLeft(), getBottom() - this.k_renamed, getRight(), getBottom());
    }

    public void e_renamed() {
        this.m_renamed = true;
    }

    public void f_renamed() {
        this.m_renamed = false;
    }
}
