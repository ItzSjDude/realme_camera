package com.oplus.camera;

/* compiled from: SloganUtil.java */
/* loaded from: classes2.dex */
public class ad_renamed extends com.oplus.camera.c_renamed {
    private static android.graphics.Typeface S_renamed;
    private java.lang.String T_renamed;
    private java.lang.String U_renamed;
    private java.lang.String V_renamed;
    private java.lang.String W_renamed;
    private java.lang.String X_renamed;
    private java.lang.String Y_renamed;
    private java.lang.String Z_renamed;
    private java.lang.String aa_renamed;
    private java.lang.String ab_renamed;
    private java.lang.String ac_renamed;
    private java.lang.String ad_renamed;
    private java.lang.String ae_renamed;
    private boolean af_renamed;
    private int ag_renamed;
    private boolean ah_renamed;

    /* compiled from: SloganUtil.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f4096a = 0;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4097b = 0;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f4098c = 0;
        public int d_renamed = 0;
        public int e_renamed = 0;
        public int f_renamed = 0;
        public int g_renamed = 0;
        public int h_renamed = 0;
        public int i_renamed = 0;
        public int j_renamed = 0;
        public int k_renamed = 0;
        public int l_renamed = com.oplus.camera.R_renamed.drawable.slogan_copyright_normal;
        public int m_renamed = 0;
        public int n_renamed = 0;
        public int o_renamed = 0;
        public float p_renamed = 0.0f;
        public float q_renamed = 0.0f;
        public float r_renamed = 0.0f;
        public float s_renamed = 0.0f;
    }

    public ad_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super(activity, comboPreferences, i_renamed);
        this.T_renamed = null;
        this.U_renamed = null;
        this.V_renamed = "Shot on_renamed ";
        this.W_renamed = "Shot by_renamed ";
        this.X_renamed = "MP";
        this.Y_renamed = " AI ";
        this.Z_renamed = " Camera";
        this.aa_renamed = "";
        this.ab_renamed = "";
        this.ac_renamed = "";
        this.ad_renamed = "";
        this.ae_renamed = "";
        boolean z_renamed = false;
        this.af_renamed = false;
        this.ag_renamed = -1;
        this.ah_renamed = false;
        if (com.oplus.camera.util.Util.getScreenWidth() == 0 || com.oplus.camera.util.Util.getScreenHeight() == 0) {
            com.oplus.camera.util.Util.J_renamed();
        }
        if (!android.text.TextUtils.isEmpty(this.L_renamed) && ("realme 8".equals(this.L_renamed) || "realme 8 Pro".equals(this.L_renamed))) {
            z_renamed = true;
        }
        this.af_renamed = z_renamed;
    }

    public void a_renamed(android.util.Size size, com.oplus.camera.q_renamed.a_renamed aVar, java.util.HashSet<java.lang.String> hashSet, boolean z_renamed, int i_renamed, int i2, int i3, boolean z2, java.lang.String str) {
        this.R_renamed.f_renamed = i3;
        if (this.ag_renamed != i3) {
            this.ag_renamed = i3;
            this.ah_renamed = true;
        } else {
            this.ah_renamed = false;
        }
        super.a_renamed(size, aVar, hashSet, z_renamed, i_renamed, i2, z2, str);
    }

    @Override // com.oplus.camera.c_renamed
    protected boolean i_renamed() {
        return this.ah_renamed;
    }

    @Override // com.oplus.camera.c_renamed
    protected boolean j_renamed() {
        return this.af_renamed;
    }

    private float c_renamed(android.util.Size size) {
        float height;
        int screenWidth;
        if (size.getHeight() >= size.getWidth()) {
            height = size.getWidth() * 1.0f;
            screenWidth = com.oplus.camera.util.Util.getScreenWidth();
        } else {
            height = size.getHeight() * 1.0f;
            screenWidth = com.oplus.camera.util.Util.getScreenWidth();
        }
        return height / screenWidth;
    }

    private android.graphics.Typeface k_renamed() {
        android.graphics.Typeface typeface = S_renamed;
        if (typeface != null) {
            return typeface;
        }
        try {
            S_renamed = android.graphics.Typeface.createFromAsset(this.k_renamed.getAssets(), "fonts/RadomirTinkovGilroy-Medium.otf");
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "create RadomirTinkovGilroy-Medium.otf typeface successful");
        } catch (java.lang.Exception unused) {
            S_renamed = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "create RadomirTinkovGilroy-Medium.otf typeface fail");
        }
        return S_renamed;
    }

    private java.lang.String b_renamed(int i_renamed) {
        this.aa_renamed = this.V_renamed + this.L_renamed;
        if (!com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
            int iAH = com.oplus.camera.util.Util.aH_renamed();
            com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "getSloganInfo, highPictureMP: " + iAH);
            if (48 <= iAH) {
                this.ac_renamed = iAH + this.X_renamed;
            }
            if (this.af_renamed && iAH == 108) {
                this.aa_renamed += " | " + iAH + this.X_renamed;
            }
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_CAMERA_REAR_NUM);
            com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "getSloganInfo, physicalBackCameraNum: " + configIntValue);
            if (configIntValue == -1 || configIntValue == 1) {
                this.ad_renamed = null;
            } else if (configIntValue == 2) {
                this.ad_renamed = this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_watermark_back_camera_num_2);
            } else if (configIntValue == 3) {
                this.ad_renamed = this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_watermark_back_camera_num_3);
            } else if (configIntValue == 4) {
                this.ad_renamed = this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_watermark_back_camera_num_4);
            } else {
                this.ad_renamed = this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_watermark_back_camera_num_super);
            }
            if (this.ad_renamed != null) {
                this.ae_renamed = (this.ac_renamed + this.Y_renamed + this.ad_renamed + this.Z_renamed).trim().toUpperCase();
            } else {
                this.ae_renamed = (this.ac_renamed + this.Y_renamed + this.Z_renamed.trim()).trim().toUpperCase();
            }
        } else {
            this.ae_renamed = (this.Y_renamed + this.Z_renamed.trim()).trim().toUpperCase();
        }
        com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "getSloganInfo, mXXMPAIBackCameraNumCamera: " + this.ae_renamed);
        return this.ae_renamed;
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap, float f_renamed, float f2) {
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postTranslate(f_renamed, f2);
        paint.setAlpha(255);
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    private void a_renamed(android.graphics.Canvas canvas, java.lang.String str, float f_renamed, float f2, android.graphics.Paint paint) {
        canvas.drawText(str, f_renamed, f2, paint);
    }

    @Override // com.oplus.camera.c_renamed
    public com.oplus.camera.c_renamed.a_renamed a_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.c_renamed.e_renamed eVar) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        int iHeight;
        int iMeasureText;
        int iHeight2;
        java.lang.String str;
        int iMeasureText2;
        android.graphics.Canvas canvas;
        boolean z_renamed;
        com.oplus.camera.c_renamed.a_renamed aVar = new com.oplus.camera.c_renamed.a_renamed();
        int i2 = eVar.f_renamed;
        android.util.Size size = eVar.f4192a;
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        java.lang.String str2 = eVar.d_renamed;
        java.lang.String str3 = eVar.f4194c;
        java.lang.String string2 = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "bottom_left_corner");
        this.af_renamed = !android.text.TextUtils.isEmpty(this.L_renamed) && ("realme 8".equals(this.L_renamed) || "realme 8 Pro".equals(this.L_renamed));
        if (!"bottom_center".equals(string2)) {
            comboPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "bottom_center").apply();
        }
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkBitmapHold, cameraId: " + i2 + ", pictureSize: Width x_renamed Height = " + size.getWidth() + "x_renamed" + size.getHeight());
        java.util.Set<java.lang.String> stringSet = comboPreferences.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        if ((stringSet == null || stringSet.isEmpty()) && android.text.TextUtils.isEmpty(string)) {
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "chooseDisplayValues is_renamed null or empty");
            return null;
        }
        java.lang.String string3 = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values)[1]);
        java.lang.String[] stringArray = this.k_renamed.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        boolean zContains = stringSet.contains(stringArray[0]);
        boolean zContains2 = stringSet.contains(stringArray[1]);
        boolean zContains3 = stringSet.contains(stringArray[2]);
        com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "createWatermarkBitmapHold, deviceOn: " + zContains + ", locationOn: " + zContains3 + ", timeOn: " + zContains2);
        float dimensionPixelSize = (float) this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_shadow_radius);
        float dimensionPixelSize2 = (float) this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_shadow_x);
        float dimensionPixelSize3 = (float) this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_shadow_y);
        float fA_renamed = (a_renamed(context, string3) * c_renamed(size)) / 2.77777f;
        float dimensionPixelSize4 = ((float) this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_padding_ai_shot_gap)) * fA_renamed;
        float dimensionPixelSize5 = ((float) this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_padding_r_shot_gap)) * fA_renamed;
        int color = this.n_renamed.getColor(com.oplus.camera.R_renamed.color.slogan_text_shadow_color);
        float dimensionPixelSize6 = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_logo_shot_gap) * fA_renamed;
        com.oplus.camera.ad_renamed.a_renamed aVarA = a_renamed(fA_renamed);
        android.graphics.Bitmap bitmapA = a_renamed(aVarA.l_renamed, fA_renamed);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setTypeface(k_renamed());
        paint.setTextSize(aVarA.s_renamed);
        paint.setColor(this.k_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white));
        paint.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        paint.setAlpha(253);
        int height = aVarA.m_renamed + bitmapA.getHeight() + aVarA.g_renamed;
        if (zContains || !android.text.TextUtils.isEmpty(string)) {
            b_renamed(i2);
            if (!android.text.TextUtils.isEmpty(string)) {
                this.ab_renamed = this.W_renamed + string;
            }
            android.graphics.Rect rect = new android.graphics.Rect();
            java.lang.String str4 = this.ae_renamed;
            i_renamed = 0;
            paint.getTextBounds(str4, 0, str4.length(), rect);
            iHeight = rect.height();
        } else {
            iHeight = 0;
            i_renamed = 0;
        }
        if (zContains3) {
            iMeasureText = (int) paint.measureText(str2);
            android.graphics.Rect rect2 = new android.graphics.Rect();
            paint.getTextBounds(str2, i_renamed, str2.length(), rect2);
            iHeight2 = rect2.height();
        } else {
            iMeasureText = 0;
            iHeight2 = 0;
        }
        if (zContains2) {
            str = str3;
            iMeasureText2 = (int) paint.measureText(str);
        } else {
            str = str3;
            iMeasureText2 = 0;
        }
        int i3 = iMeasureText2 > iMeasureText ? iMeasureText2 : iMeasureText;
        if (iHeight > 0) {
            iHeight2 = iHeight;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str5 = str;
        sb.append("createWatermarkBitmapHold, timeWidth: ");
        sb.append(iMeasureText2);
        sb.append(", locationWidth:");
        sb.append(iMeasureText);
        sb.append(", locationHeight: ");
        sb.append(iHeight2);
        sb.append(", textAICameraHeight:");
        sb.append(iHeight);
        sb.append(", locationTimeMaxPadding: ");
        sb.append(i3);
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", sb.toString());
        int width = size.getWidth();
        if (width % 2 != 0) {
            width++;
        }
        int i4 = width;
        if (height % 2 != 0) {
            height++;
        }
        int i5 = height;
        com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "createWatermarkBitmapHold, composeWidth: " + i4 + ", composeHeight: " + i5);
        android.graphics.Bitmap bitmapA2 = com.oplus.camera.util.Util.a_renamed(i4, i5, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas2 = new android.graphics.Canvas(bitmapA2);
        canvas2.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
        if (zContains || !android.text.TextUtils.isEmpty(string)) {
            paint.setTextSize(aVarA.s_renamed);
            float width2 = (((size.getWidth() - paint.measureText(android.text.TextUtils.isEmpty(string) ? this.aa_renamed : this.ab_renamed)) - bitmapA.getWidth()) - dimensionPixelSize6) / 2.0f;
            a_renamed(canvas2, bitmapA, width2, aVarA.m_renamed);
            canvas = canvas2;
            z_renamed = zContains3;
            a_renamed(canvas2, android.text.TextUtils.isEmpty(string) ? this.aa_renamed : this.ab_renamed, width2 + bitmapA.getWidth() + dimensionPixelSize6, aVarA.m_renamed + dimensionPixelSize5, paint);
        } else {
            canvas = canvas2;
            z_renamed = zContains3;
        }
        if (z_renamed) {
            paint.setTextSize(aVarA.r_renamed);
            a_renamed(canvas, str2, (i4 - i3) - aVarA.f_renamed, aVarA.m_renamed + dimensionPixelSize5, paint);
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkBitmapHold, drawText mCurrentAdress: " + str2);
        }
        if (zContains2) {
            paint.setTextSize(aVarA.r_renamed);
            a_renamed(canvas, str5, (i4 - paint.measureText(str5)) / 2.0f, aVarA.m_renamed + dimensionPixelSize5 + dimensionPixelSize4, paint);
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkBitmapHold, drawText mDateTime: " + str5);
        }
        if (i4 > size.getWidth() && bitmapA2 != null) {
            float f_renamed = i4;
            float width3 = (1.0f * f_renamed) / size.getWidth();
            int i6 = (int) (f_renamed / width3);
            int i7 = (int) (i5 / width3);
            if (i6 % 2 != 0) {
                i6--;
            }
            if (i7 % 2 != 0) {
                i7--;
            }
            bitmapA2 = android.graphics.Bitmap.createScaledBitmap(bitmapA2, i6, i7, true);
            com.oplus.camera.e_renamed.e_renamed("BaseSloganUtil", "createWatermarkBitmapHold, createScaledBitmap now");
        }
        aVar.a_renamed(bitmapA2);
        aVar.a_renamed(eVar);
        return aVar;
    }

    private com.oplus.camera.ad_renamed.a_renamed a_renamed(float f_renamed) {
        com.oplus.camera.ad_renamed.a_renamed aVar = new com.oplus.camera.ad_renamed.a_renamed();
        aVar.l_renamed = com.oplus.camera.R_renamed.drawable.oplusr_slogan_copyright_normal;
        if (this.af_renamed) {
            aVar.l_renamed = com.oplus.camera.R_renamed.drawable.watermark_infinite_logo;
        }
        aVar.m_renamed = (int) (this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_margin_top) * f_renamed);
        aVar.f_renamed = (int) (this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_padding_left) * f_renamed);
        aVar.g_renamed = (int) (this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_padding_bottom) * f_renamed);
        aVar.r_renamed = (int) (this.n_renamed.getDimension(com.oplus.camera.R_renamed.dimen.slogan_ai_camera_text_size) * f_renamed);
        aVar.s_renamed = (int) (this.n_renamed.getDimension(com.oplus.camera.R_renamed.dimen.slogan_shot_on_by_text_size) * f_renamed);
        aVar.n_renamed = (int) (this.n_renamed.getDimension(com.oplus.camera.R_renamed.dimen.slogan_shot_on_by_text_size) * f_renamed);
        aVar.o_renamed = (int) (this.n_renamed.getDimension(com.oplus.camera.R_renamed.dimen.slogan_shot_on_by_text_size) * f_renamed);
        return aVar;
    }

    private android.graphics.Bitmap a_renamed(int i_renamed, float f_renamed) {
        android.graphics.Bitmap bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(this.k_renamed.getResources(), i_renamed);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(f_renamed, f_renamed);
        return android.graphics.Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
    }

    @Override // com.oplus.camera.c_renamed
    public android.graphics.Bitmap a_renamed(android.content.Context context, float f_renamed) {
        com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "getLogoBitmap");
        return a_renamed(com.oplus.camera.R_renamed.drawable.oplusr_slogan_copyright_normal, f_renamed);
    }

    private float a_renamed(android.content.Context context, java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "getSloganSize sizeType: " + str);
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values);
        if (stringArray[2].equals(str)) {
            return 1.1f;
        }
        return stringArray[0].equals(str) ? 0.9f : 1.0f;
    }
}
