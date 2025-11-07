package com.android.ui.menu;

/* loaded from: classes.dex */
public class CameraWatermarkVisualPreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.ImageView f2301a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f2302b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2303c;
    private boolean d_renamed;
    private boolean e_renamed;
    private android.graphics.Paint f_renamed;
    private android.graphics.Canvas g_renamed;
    private java.lang.String h_renamed;
    private android.graphics.Bitmap i_renamed;
    private android.graphics.Bitmap j_renamed;
    private android.graphics.Bitmap k_renamed;
    private float l_renamed;
    private boolean m_renamed;
    private com.oplus.camera.c_renamed n_renamed;

    public CameraWatermarkVisualPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f2301a = null;
        this.f2302b = null;
        this.f2303c = false;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = 0.0f;
        this.m_renamed = true;
        this.n_renamed = null;
    }

    public CameraWatermarkVisualPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2301a = null;
        this.f2302b = null;
        this.f2303c = false;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = 0.0f;
        this.m_renamed = true;
        this.n_renamed = null;
    }

    public CameraWatermarkVisualPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2301a = null;
        this.f2302b = null;
        this.f2303c = false;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = 0.0f;
        this.m_renamed = true;
        this.n_renamed = null;
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        android.widget.ImageView imageView;
        this.f2301a = (android.widget.ImageView) lVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.imageView_watermark_visual);
        b_renamed();
        android.graphics.Bitmap bitmap = this.f2302b;
        if (bitmap == null || (imageView = this.f2301a) == null || !this.f2303c) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        this.f2303c = false;
    }

    private void b_renamed() {
        if (this.d_renamed && this.f2301a != null && com.oplus.camera.util.Util.u_renamed()) {
            android.content.res.Resources resources = K_renamed().getResources();
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) this.f2301a.getLayoutParams();
            if (jVar == null) {
                jVar = new androidx.recyclerview.widget.RecyclerView.j_renamed(-1, -2);
            }
            jVar.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.watermark_visualization_margin_left_vertical));
            jVar.setMarginEnd(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.watermark_visualization_margin_left_vertical));
            jVar.bottomMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.watermark_visualization_margin_bottom);
            this.f2301a.setLayoutParams(jVar);
            this.f2301a.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
        }
    }

    private void a_renamed(com.oplus.camera.ComboPreferences comboPreferences) {
        if (this.i_renamed == null) {
            this.i_renamed = com.oplus.camera.util.Util.a_renamed(K_renamed(), com.oplus.camera.R_renamed.drawable.bg_watermark_visualization, 1.0f, com.oplus.camera.util.Util.f7297a);
            this.i_renamed.setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
        }
        if (this.k_renamed == null) {
            this.k_renamed = this.n_renamed.a_renamed(K_renamed(), 1.0f);
            this.k_renamed.setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
        }
        if (this.m_renamed || com.oplus.camera.util.Util.al_renamed()) {
            this.j_renamed = this.k_renamed;
        } else {
            this.j_renamed = android.graphics.Bitmap.createBitmap(1, this.k_renamed.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        this.l_renamed = com.oplus.camera.util.Util.a_renamed(K_renamed(), com.oplus.camera.R_renamed.dimen.watermark_preview_logo_corner_portrait_interval, com.oplus.camera.util.Util.f7297a) + (this.j_renamed.getHeight() / 2.0f);
        if (this.f_renamed == null) {
            this.f_renamed = new android.graphics.Paint();
            this.f_renamed.setAntiAlias(true);
        }
    }

    private com.oplus.camera.c_renamed.a_renamed b_renamed(com.oplus.camera.ComboPreferences comboPreferences) {
        com.oplus.camera.c_renamed.e_renamed eVar = new com.oplus.camera.c_renamed.e_renamed();
        eVar.f_renamed = 0;
        eVar.f4192a = new android.util.Size((!this.m_renamed || com.oplus.camera.util.Util.al_renamed()) ? this.i_renamed.getWidth() : (this.i_renamed.getWidth() - this.k_renamed.getWidth()) + 5, this.i_renamed.getHeight());
        eVar.f4194c = com.oplus.camera.c_renamed.f_renamed();
        eVar.h_renamed = true;
        eVar.i_renamed = this.m_renamed;
        eVar.d_renamed = com.oplus.camera.q_renamed.a_renamed().b_renamed();
        eVar.j_renamed = this.e_renamed;
        return this.n_renamed.a_renamed(K_renamed(), comboPreferences, eVar);
    }

    public void a_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences) {
        if (comboPreferences == null) {
            return;
        }
        this.m_renamed = comboPreferences.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet()).contains(K_renamed().getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values)[0]);
        if (this.n_renamed == null) {
            this.n_renamed = new com.oplus.camera.ad_renamed(activity, comboPreferences, 0);
        }
        a_renamed(comboPreferences);
        com.oplus.camera.c_renamed.a_renamed aVarB = b_renamed(comboPreferences);
        this.h_renamed = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "bottom_left_corner");
        com.oplus.camera.e_renamed.a_renamed("CameraWatermarkVisualPreference", "updatePreview, watermarkHold: " + aVarB);
        final android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(this.i_renamed.getWidth(), this.i_renamed.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        bitmapA.setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
        android.graphics.Bitmap bitmapA2 = null;
        if (aVarB != null) {
            aVarB.f_renamed().setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
            bitmapA2 = a_renamed(aVarB);
        }
        if (!this.m_renamed && bitmapA2 != null && !com.oplus.camera.util.Util.al_renamed()) {
            this.l_renamed = ((com.oplus.camera.util.Util.a_renamed(K_renamed(), com.oplus.camera.R_renamed.dimen.watermark_preview_logo_corner_portrait_interval, com.oplus.camera.util.Util.f7297a) + (this.j_renamed.getHeight() / 2.0f)) - ((this.j_renamed.getHeight() - bitmapA2.getHeight()) / 2)) - 4.0f;
        }
        this.g_renamed = new android.graphics.Canvas(bitmapA);
        a_renamed(bitmapA2, aVarB);
        if (this.f2301a == null) {
            this.f2303c = true;
        } else if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            this.f2301a.setImageBitmap(bitmapA);
        } else {
            this.f2301a.post(new java.lang.Runnable() { // from class: com.android.ui.menu.CameraWatermarkVisualPreference.1
                @Override // java.lang.Runnable
                public void run() {
                    com.android.ui.menu.CameraWatermarkVisualPreference.this.f2301a.setImageBitmap(bitmapA);
                }
            });
        }
        this.f2302b = bitmapA;
    }

    public void a_renamed(boolean z_renamed, com.oplus.camera.ComboPreferences comboPreferences) {
        if (comboPreferences == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraWatermarkVisualPreference", "updateMakeupPreview, mDisplayBitmap: " + this.f2302b);
        if (this.f2302b == null) {
            if (this.i_renamed == null) {
                this.i_renamed = com.oplus.camera.util.Util.a_renamed(K_renamed(), com.oplus.camera.R_renamed.drawable.bg_watermark_makeup_visualization, 1.0f, com.oplus.camera.util.Util.f7297a);
                this.i_renamed.setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
            }
            com.oplus.camera.c_renamed.e_renamed eVar = new com.oplus.camera.c_renamed.e_renamed();
            eVar.f4192a = new android.util.Size(this.i_renamed.getWidth(), this.i_renamed.getHeight());
            eVar.h_renamed = true;
            com.oplus.camera.c_renamed.a_renamed aVarA = com.oplus.camera.c_renamed.a_renamed(K_renamed(), eVar, comboPreferences);
            if (aVarA == null) {
                com.oplus.camera.e_renamed.a_renamed("CameraWatermarkVisualPreference", "updateMakeupPreview, hold is_renamed null");
                return;
            }
            android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(this.i_renamed.getWidth(), this.i_renamed.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            bitmapA.setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
            aVarA.f_renamed().setDensity(K_renamed().getResources().getDisplayMetrics().densityDpi);
            this.g_renamed = new android.graphics.Canvas(bitmapA);
            this.g_renamed.drawBitmap(this.i_renamed, 0.0f, 0.0f, this.f_renamed);
            this.g_renamed.drawBitmap(aVarA.f_renamed(), aVarA.d_renamed(), (this.i_renamed.getHeight() - aVarA.e_renamed()) - aVarA.f_renamed().getHeight(), this.f_renamed);
            this.f2302b = bitmapA;
        }
        if (this.f2301a == null) {
            this.f2303c = true;
        } else if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            this.f2301a.setImageBitmap(this.f2302b);
        } else {
            this.f2301a.post(new java.lang.Runnable() { // from class: com.android.ui.menu.CameraWatermarkVisualPreference.2
                @Override // java.lang.Runnable
                public void run() {
                    com.android.ui.menu.CameraWatermarkVisualPreference.this.f2301a.setImageBitmap(com.android.ui.menu.CameraWatermarkVisualPreference.this.f2302b);
                }
            });
        }
    }

    public void e_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    private void a_renamed(android.graphics.Bitmap bitmap, com.oplus.camera.c_renamed.a_renamed aVar) {
        b_renamed(bitmap, aVar);
    }

    private void b_renamed(android.graphics.Bitmap bitmap, com.oplus.camera.c_renamed.a_renamed aVar) {
        this.g_renamed.drawBitmap(this.i_renamed, 0.0f, 0.0f, this.f_renamed);
        if (aVar == null || bitmap == null) {
            return;
        }
        c_renamed(bitmap, aVar);
        d_renamed(bitmap, aVar);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap a_renamed(com.oplus.camera.c_renamed.a_renamed r11) {
        /*
            r10 = this;
            android.graphics.Bitmap r0 = r11.f_renamed()
            int r0 = r0.getWidth()
            android.graphics.Bitmap r1 = r11.f_renamed()
            int r1 = r1.getHeight()
            int r2 = r11.g_renamed()
            int r3 = r11.g_renamed()
            int r4 = r0 - r2
            int r5 = r1 - r3
            r6 = 1
            if (r4 == 0) goto Lb1
            if (r5 == 0) goto Lb1
            if (r1 == 0) goto Lb1
            if (r0 != 0) goto L27
            goto Lb1
        L27:
            java.lang.String r10 = r10.h_renamed
            r7 = -1
            int r8 = r10.hashCode()
            r9 = 0
            switch(r8) {
                case -1580828439: goto L78;
                case -1364013995: goto L6e;
                case -1297425040: goto L65;
                case -1027670443: goto L5b;
                case -994491540: goto L51;
                case -264573066: goto L47;
                case 495696886: goto L3d;
                case 643307897: goto L33;
                default: goto L32;
            }
        L32:
            goto L82
        L33:
            java.lang.String r6 = "bottom_left_corner"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = r9
            goto L83
        L3d:
            java.lang.String r6 = "oplus_c_watermark_position"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 7
            goto L83
        L47:
            java.lang.String r6 = "oplus_left_bottom_watermark_position"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 6
            goto L83
        L51:
            java.lang.String r6 = "bottom_right_corner"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 2
            goto L83
        L5b:
            java.lang.String r6 = "upper_right_corner"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 3
            goto L83
        L65:
            java.lang.String r8 = "upper_left_corner"
            boolean r10 = r10.equals(r8)
            if (r10 == 0) goto L82
            goto L83
        L6e:
            java.lang.String r6 = "center"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 4
            goto L83
        L78:
            java.lang.String r6 = "bottom_center"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 5
            goto L83
        L82:
            r6 = r7
        L83:
            switch(r6) {
                case 0: goto La8;
                case 1: goto La8;
                case 2: goto L9f;
                case 3: goto L9f;
                case 4: goto L96;
                case 5: goto L91;
                case 6: goto L88;
                case 7: goto L88;
                default: goto L86;
            }
        L86:
            r10 = 0
            goto Lb0
        L88:
            android.graphics.Bitmap r10 = r11.f_renamed()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r9, r9, r0, r1)
            goto Lb0
        L91:
            android.graphics.Bitmap r10 = r11.f_renamed()
            goto Lb0
        L96:
            android.graphics.Bitmap r10 = r11.f_renamed()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r9, r3, r0, r5)
            goto Lb0
        L9f:
            android.graphics.Bitmap r10 = r11.f_renamed()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r9, r9, r4, r1)
            goto Lb0
        La8:
            android.graphics.Bitmap r10 = r11.f_renamed()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r2, r9, r4, r1)
        Lb0:
            return r10
        Lb1:
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r10 = com.oplus.camera.util.Util.a_renamed(r6, r6, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ui.menu.CameraWatermarkVisualPreference.a_renamed(com.oplus.camera.c_renamed$a_renamed):android.graphics.Bitmap");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c_renamed(android.graphics.Bitmap r10, com.oplus.camera.c_renamed.a_renamed r11) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ui.menu.CameraWatermarkVisualPreference.c_renamed(android.graphics.Bitmap, com.oplus.camera.c_renamed$a_renamed):void");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d_renamed(android.graphics.Bitmap r9, com.oplus.camera.c_renamed.a_renamed r10) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ui.menu.CameraWatermarkVisualPreference.d_renamed(android.graphics.Bitmap, com.oplus.camera.c_renamed$a_renamed):void");
    }
}
