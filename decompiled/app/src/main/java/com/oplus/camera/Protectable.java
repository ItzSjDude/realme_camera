package com.oplus.camera;

/* compiled from: BaseSloganUtil.java */
/* loaded from: classes2.dex */
public class c_renamed {
    private static final java.lang.String[] Z_renamed = {"150W"};

    /* renamed from: a_renamed, reason: collision with root package name */
    protected static android.graphics.Typeface f4174a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected static android.graphics.Typeface f4175b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected static android.graphics.Typeface f4176c;
    protected static java.util.Map<java.lang.String, android.graphics.Bitmap> d_renamed;
    protected int D_renamed;
    protected java.lang.String L_renamed;
    private java.lang.String U_renamed;
    protected java.lang.String j_renamed;
    protected android.app.Activity k_renamed;
    protected com.oplus.camera.ComboPreferences l_renamed;
    protected com.oplus.camera.jni.FormatConverter m_renamed;
    protected android.content.res.Resources n_renamed;
    protected int r_renamed;
    protected float s_renamed;
    protected float t_renamed;
    protected float u_renamed;
    protected final android.os.ConditionVariable e_renamed = new android.os.ConditionVariable(true);
    protected boolean f_renamed = false;
    protected int g_renamed = 0;
    protected int h_renamed = 0;
    protected java.lang.String i_renamed = "";
    protected java.util.Set<java.lang.String> o_renamed = new java.util.HashSet();
    protected com.oplus.camera.jni.OplusSloganJNI p_renamed = null;
    protected android.util.Size q_renamed = null;
    protected android.graphics.Bitmap v_renamed = null;
    protected android.graphics.Bitmap w_renamed = null;
    protected boolean x_renamed = false;
    protected boolean y_renamed = false;
    protected boolean z_renamed = false;
    protected boolean A_renamed = false;
    protected boolean B_renamed = false;
    protected int C_renamed = 0;
    protected int E_renamed = 0;
    protected java.lang.String F_renamed = "";
    protected java.lang.String G_renamed = "";
    protected java.lang.String H_renamed = "";
    protected java.lang.String I_renamed = "";
    protected java.lang.String J_renamed = null;
    protected java.lang.String K_renamed = "";
    protected java.lang.String M_renamed = "";
    protected volatile int N_renamed = 0;
    protected volatile int O_renamed = 0;
    protected volatile long P_renamed = 0;
    protected long Q_renamed = 0;
    protected com.oplus.camera.c_renamed.e_renamed R_renamed = new com.oplus.camera.c_renamed.e_renamed();
    private com.oplus.camera.c_renamed.a_renamed S_renamed = new com.oplus.camera.c_renamed.a_renamed();
    private java.util.HashMap<java.lang.Integer, com.oplus.camera.c_renamed.a_renamed> T_renamed = new java.util.HashMap<>();
    private android.graphics.Paint V_renamed = null;
    private java.lang.String W_renamed = "";
    private boolean X_renamed = false;
    private boolean Y_renamed = false;

    protected boolean h_renamed() {
        return false;
    }

    protected boolean i_renamed() {
        return false;
    }

    protected boolean j_renamed() {
        return false;
    }

    /* compiled from: BaseSloganUtil.java */
    public static class e_renamed implements java.lang.Cloneable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public android.util.Size f4192a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.lang.String f4193b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.lang.String f4194c = null;
        public java.lang.String d_renamed = null;
        public java.lang.String e_renamed = "";
        public int f_renamed = -1;
        public int g_renamed = 0;
        public boolean h_renamed = false;
        public boolean i_renamed = true;
        public boolean j_renamed = true;

        public java.lang.String toString() {
            return "YuvInfo, size: " + this.f4192a + ", mWatermarkAuthor: " + this.f4193b + ", mWatermarkTime: " + this.f4194c + ", mWatermarkLocation: " + this.d_renamed + ", mOrientation: " + this.g_renamed + ", mWatermarkMakeupKey: " + this.e_renamed + ", mbAllowLocation: " + this.j_renamed;
        }

        public java.lang.Object clone() {
            try {
                return (com.oplus.camera.c_renamed.e_renamed) super.clone();
            } catch (java.lang.CloneNotSupportedException e_renamed) {
                e_renamed.printStackTrace();
                return null;
            }
        }
    }

    public c_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, int i_renamed) {
        java.lang.String str;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.r_renamed = 0;
        this.s_renamed = 0.0f;
        this.t_renamed = 0.0f;
        this.u_renamed = 0.0f;
        this.D_renamed = 0;
        this.L_renamed = "";
        this.U_renamed = "";
        this.k_renamed = activity;
        this.l_renamed = comboPreferences;
        this.D_renamed = i_renamed;
        this.L_renamed = com.oplus.camera.util.Util.v_renamed();
        this.U_renamed = com.oplus.camera.util.Util.i_renamed("ro.hw.phone.color");
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "SloganUtil, mMarketName: " + this.L_renamed + ", mColorFlag: " + this.U_renamed);
        if ("00FFF002".equals(this.U_renamed) && (str = this.L_renamed) != null && !str.toLowerCase().contains("Lamborghini".toLowerCase())) {
            this.L_renamed += " Lamborghini";
        }
        k_renamed();
        this.n_renamed = this.k_renamed.getResources();
        this.s_renamed = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_shadow_radius);
        this.t_renamed = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_shadow_x);
        this.u_renamed = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slogan_text_shadow_y);
        this.r_renamed = this.n_renamed.getColor(com.oplus.camera.R_renamed.color.slogan_text_shadow_color);
        this.m_renamed = new com.oplus.camera.jni.FormatConverter();
        java.io.File internalSdDirectory = com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(this.k_renamed);
        if (internalSdDirectory != null) {
            this.j_renamed = internalSdDirectory.getAbsolutePath() + java.io.File.separator + ".SLOGAN" + java.io.File.separator;
            if (new java.io.File(this.j_renamed).exists()) {
                return;
            }
            n_renamed();
            if (com.oplus.camera.q_renamed.a_renamed.f_renamed(this.j_renamed)) {
                return;
            }
            this.j_renamed = null;
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "file directory is_renamed not exist");
            return;
        }
        n_renamed();
        this.j_renamed = null;
        com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "interDir is_renamed null");
    }

    private void k_renamed() {
        java.lang.String str = this.L_renamed;
        if (str != null && (str.contains("GT Exp. Master Edition") || this.L_renamed.contains("GT Master Edition"))) {
            this.L_renamed = "GT Master";
        }
        int i_renamed = 0;
        while (true) {
            java.lang.String[] strArr = Z_renamed;
            if (i_renamed >= strArr.length || a_renamed(strArr[i_renamed])) {
                break;
            } else {
                i_renamed++;
            }
        }
        if (this.L_renamed == null || com.oplus.camera.util.Util.ak_renamed()) {
            return;
        }
        this.L_renamed = this.L_renamed.replace("realme ", "");
    }

    private boolean a_renamed(java.lang.String str) {
        java.lang.String str2 = this.L_renamed;
        if (str2 != null) {
            java.lang.String[] strArrSplit = str2.split(" ");
            if (strArrSplit.length > 1 && strArrSplit[strArrSplit.length - 1].equals(str)) {
                this.L_renamed = this.L_renamed.substring(0, this.L_renamed.lastIndexOf(str) - 1);
                return true;
            }
        }
        return false;
    }

    public void a_renamed(android.util.Size size, com.oplus.camera.q_renamed.a_renamed aVar, java.util.HashSet<java.lang.String> hashSet, boolean z_renamed, int i_renamed, int i2, boolean z2, java.lang.String str) {
        android.util.Size sizeA;
        android.graphics.Bitmap bitmap;
        android.graphics.Bitmap bitmap2;
        if (i_renamed == 0 || 180 == i_renamed) {
            sizeA = a_renamed(size);
            this.N_renamed = 0;
        } else {
            this.N_renamed = 1;
            sizeA = size;
        }
        this.O_renamed = com.oplus.camera.util.Util.d_renamed(sizeA.getHeight(), sizeA.getWidth());
        this.o_renamed = hashSet;
        this.P_renamed = java.lang.System.currentTimeMillis();
        boolean z3 = i2 != 0;
        java.lang.String strF = f_renamed();
        java.lang.String strA = com.oplus.camera.util.h_renamed.a_renamed(this.k_renamed, aVar);
        java.lang.String strQ = q_renamed();
        this.f_renamed = false;
        com.oplus.camera.q_renamed.a_renamed().a_renamed(strA);
        java.util.Set<java.lang.String> stringSet = this.l_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        java.lang.String[] stringArray = this.k_renamed.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        boolean zContains = stringSet.contains(stringArray[0]);
        boolean zContains2 = stringSet.contains(stringArray[1]);
        boolean zContains3 = stringSet.contains(stringArray[2]);
        if (str.isEmpty()) {
            if (this.z_renamed != zContains) {
                this.z_renamed = zContains;
                this.f_renamed = true;
            }
            if (this.x_renamed != zContains3) {
                this.x_renamed = zContains3;
                this.f_renamed = true;
            }
            if (this.y_renamed != zContains2) {
                this.y_renamed = zContains2;
                this.f_renamed = true;
            }
            java.lang.String string = this.l_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "");
            if (!string.isEmpty() && !this.M_renamed.equals(string)) {
                this.M_renamed = string;
                this.f_renamed = true;
            }
            this.f_renamed = this.f_renamed || a_renamed(strQ, strF, strA, stringSet) || this.A_renamed != z3;
        }
        if (!this.W_renamed.equals(str) || this.N_renamed != this.E_renamed) {
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "updateSloganYuv, mMakeupKey: " + this.W_renamed + " -> " + str + ", mSloganOrientation: " + this.E_renamed + " -> " + this.N_renamed);
            this.W_renamed = str;
            this.f_renamed = true;
        }
        this.f_renamed = this.h_renamed != 1 && (this.f_renamed || (i_renamed == 0 || 180 == i_renamed ? !(!z3 || z_renamed || ((bitmap = this.v_renamed) != null && !bitmap.isRecycled())) : !(!z3 || z_renamed || ((bitmap2 = this.w_renamed) != null && !bitmap2.isRecycled()))) || ((z3 && z_renamed != this.B_renamed) || !sizeA.equals(this.q_renamed) || 3 == i2 || (z3 && j_renamed() && i_renamed())));
        this.B_renamed = z_renamed;
        this.A_renamed = z3;
        this.Q_renamed = this.P_renamed;
        if (this.f_renamed) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) && !z2) {
                m_renamed();
            } else {
                b_renamed(this.i_renamed);
            }
            this.h_renamed = 1;
            com.oplus.camera.c_renamed.e_renamed eVar = this.R_renamed;
            eVar.f4192a = sizeA;
            eVar.f4193b = strQ;
            eVar.f4194c = strF;
            eVar.d_renamed = strA;
            eVar.g_renamed = this.N_renamed;
            com.oplus.camera.c_renamed.e_renamed eVar2 = this.R_renamed;
            eVar2.e_renamed = this.W_renamed;
            eVar2.i_renamed = zContains;
            this.e_renamed.close();
            a_renamed(this.R_renamed, i2);
            this.e_renamed.open();
            this.F_renamed = strQ;
            this.G_renamed = strF;
            this.H_renamed = strA;
            this.I_renamed = this.L_renamed;
            this.J_renamed = this.l_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, null);
            this.K_renamed = "2.0.3";
            this.C_renamed = this.D_renamed;
            this.E_renamed = this.N_renamed;
            this.q_renamed = sizeA;
            this.h_renamed = 0;
        }
    }

    public void a_renamed(com.oplus.camera.c_renamed.e_renamed eVar, int i_renamed) throws android.content.res.Resources.NotFoundException {
        float height;
        int screenHeight;
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s0:create bitmap start");
        if ("".equals(eVar.e_renamed)) {
            this.S_renamed = a_renamed(this.k_renamed, this.l_renamed, eVar);
        } else {
            this.S_renamed = a_renamed(this.k_renamed, eVar, this.l_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s1:create yuv prepare");
        com.oplus.camera.c_renamed.a_renamed aVar = this.S_renamed;
        if (aVar != null) {
            android.graphics.Bitmap bitmapF = aVar.f_renamed();
            this.T_renamed.put(java.lang.Integer.valueOf(this.N_renamed), this.S_renamed);
            int dimensionPixelSize = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.normal_slogan_text_margin_left);
            if (com.oplus.camera.util.Util.u_renamed()) {
                if (eVar.f4192a.getHeight() >= eVar.f4192a.getWidth()) {
                    height = (eVar.f4192a.getWidth() * 1.0f) / com.oplus.camera.util.Util.getScreenHeight();
                    screenHeight = com.oplus.camera.util.Util.getScreenWidth();
                } else {
                    height = (eVar.f4192a.getHeight() * 1.0f) / com.oplus.camera.util.Util.getScreenHeight();
                    screenHeight = com.oplus.camera.util.Util.getScreenHeight();
                }
            } else if (eVar.f4192a.getHeight() >= eVar.f4192a.getWidth()) {
                height = (eVar.f4192a.getWidth() * 1.0f) / com.oplus.camera.util.Util.getScreenWidth();
                screenHeight = com.oplus.camera.util.Util.getScreenWidth();
            } else {
                height = (eVar.f4192a.getHeight() * 1.0f) / com.oplus.camera.util.Util.getScreenWidth();
                screenHeight = com.oplus.camera.util.Util.getScreenHeight();
            }
            int i2 = screenHeight - (dimensionPixelSize * 2);
            int iFloor = (int) java.lang.Math.floor(bitmapF.getWidth() / height);
            if (iFloor > i2 + dimensionPixelSize) {
                float f_renamed = (i2 * 1.0f) / (iFloor - dimensionPixelSize);
                int width = (int) (bitmapF.getWidth() * f_renamed);
                int height2 = (int) (bitmapF.getHeight() * f_renamed);
                if (width % 2 != 0) {
                    width++;
                }
                if (height2 % 2 != 0) {
                    height2++;
                }
                bitmapF = android.graphics.Bitmap.createScaledBitmap(bitmapF, width, height2, true);
                iFloor = i2 + (dimensionPixelSize * 2);
            }
            this.S_renamed.a_renamed(new android.util.Size(bitmapF.getWidth(), bitmapF.getHeight()));
            this.S_renamed.a_renamed(iFloor);
            this.i_renamed = ".slogan_" + java.lang.System.currentTimeMillis() + "_" + bitmapF.getWidth() + "x_renamed" + bitmapF.getHeight() + "_" + iFloor + ".yuv";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("generateSloganBuffer, waterMarkBitmap width: ");
            sb.append(bitmapF.getWidth());
            sb.append(", height(): ");
            sb.append(bitmapF.getHeight());
            sb.append(", watermarkWidthInScreen: ");
            sb.append(iFloor);
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", sb.toString());
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s2:create yuv start");
            boolean zA = a_renamed(bitmapF, this.A_renamed && this.B_renamed, "".equals(eVar.e_renamed));
            if (this.A_renamed && !this.B_renamed) {
                a_renamed(bitmapF);
            } else {
                bitmapF.recycle();
            }
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "generateSloganBuffer,slogan buffer build " + zA);
        }
    }

    private boolean a_renamed(android.graphics.Bitmap bitmap, boolean z_renamed, boolean z2) {
        if (bitmap == null || bitmap.isRecycled()) {
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "generateYuvFile fail, bitmap: " + bitmap);
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i_renamed = width * height;
        int i2 = (int) (i_renamed * 1.5f);
        byte[] bArr = new byte[i2 + i_renamed];
        byte[] bArr2 = new byte[i_renamed];
        com.oplus.camera.jni.FormatConverter formatConverter = this.m_renamed;
        int sloganBuffer = -1;
        int iArgbToNv21 = formatConverter != null ? formatConverter.argbToNv21(bitmap, bArr, bArr2, 0, z2) : -1;
        java.lang.System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "generateYuvBuffer, width: " + width + ", height: " + height + ", flag: " + iArgbToNv21 + ", isPremultiplied: " + z2);
        if (iArgbToNv21 < 0) {
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "generateYuvBuffer fail, yuvData: " + bArr);
            return false;
        }
        com.oplus.camera.c_renamed.a_renamed aVar = this.S_renamed;
        if (aVar != null) {
            aVar.a_renamed(bArr);
        }
        boolean zA = true;
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && z_renamed && l_renamed() != null) {
            sloganBuffer = l_renamed().setSloganBuffer(bArr, width, height, bArr.length, this.i_renamed);
        }
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion()) {
            zA = com.oplus.camera.q_renamed.a_renamed.a_renamed(this.j_renamed + this.i_renamed, "application/octet-stream", bArr);
        }
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "generateYuvFile, setBufferResult: " + sloganBuffer);
        return zA;
    }

    private com.oplus.camera.jni.OplusSloganJNI l_renamed() {
        if (this.p_renamed == null) {
            this.p_renamed = new com.oplus.camera.jni.OplusSloganJNI();
        }
        return this.p_renamed;
    }

    private void b_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "deleteDir, yuvFileDir: " + str);
        if (this.j_renamed == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (!file.isDirectory()) {
            com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "deleteDir, dir is_renamed not directory");
            return;
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "deleteDir, fileList is_renamed null");
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            if (file2 != null && file2.isFile()) {
                java.lang.String name = file2.getName();
                java.lang.String absolutePath = file2.getAbsolutePath();
                java.lang.String[] strArrSplit = name.split("_");
                if (strArrSplit.length == 4) {
                    java.lang.String str2 = strArrSplit[1];
                    com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "deleteDir, timeStamp: " + str2 + ", mYuvDoneTimeStamp: " + this.Q_renamed + ", filePath: " + absolutePath);
                    try {
                        if (android.text.TextUtils.isEmpty(str2) || !android.text.TextUtils.isDigitsOnly(str2)) {
                            com.oplus.camera.q_renamed.a_renamed.c_renamed(absolutePath);
                        } else if (java.lang.Math.abs(this.Q_renamed - java.lang.Long.parseLong(str2)) >= 300000 && !this.o_renamed.contains(absolutePath)) {
                            com.oplus.camera.q_renamed.a_renamed.c_renamed(absolutePath);
                        }
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        m_renamed();
    }

    private void m_renamed() {
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && this.A_renamed && l_renamed() != null) {
            com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "deleteDir, JNI sloganFileDeleteAll result: " + l_renamed().sloganFileDeleteAll());
        }
    }

    private boolean a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Set<java.lang.String> set) throws android.content.res.Resources.NotFoundException {
        java.lang.String str4;
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "isSloganInfoChange, currentAuthor: " + str + ", mWatermarkAuthor: " + this.F_renamed + ", currentTime: " + str2 + ", mWatermarkTime: " + this.G_renamed + ", VERSION: 2.0.3, mSloganVersion: " + this.K_renamed + ", mMarketName: " + this.L_renamed + ", mWatermarkMarketName: " + this.I_renamed + ", mEnterType: " + this.D_renamed + ", mSloganEnterType: " + this.C_renamed + ", mCurrentOrientation" + this.N_renamed + ", mSloganOrientation" + this.E_renamed + ", mWatermarkSize: " + this.J_renamed);
        java.lang.String[] stringArray = this.k_renamed.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        boolean zContains = set.contains(stringArray[1]);
        boolean zContains2 = set.contains(stringArray[2]);
        java.lang.String string = this.l_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, null);
        if (!str.equals(this.F_renamed)) {
            return true;
        }
        if (str2.equals(this.G_renamed) || !zContains) {
            return ((str3.equals(this.H_renamed) || !zContains2) && this.L_renamed.equals(this.I_renamed) && "2.0.3".equals(this.K_renamed) && this.D_renamed == this.C_renamed && this.N_renamed == this.E_renamed && (str4 = this.J_renamed) != null && str4.equals(string)) ? false : true;
        }
        return true;
    }

    private void n_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "clearAllPrefValue");
        this.F_renamed = "";
        this.G_renamed = "";
        this.H_renamed = "";
        this.I_renamed = "";
        this.K_renamed = "";
        this.C_renamed = 0;
        this.E_renamed = 0;
    }

    private static java.lang.String c_renamed(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strReplaceAll = java.util.regex.Pattern.compile("[一-龥]").matcher(str).replaceAll("");
        com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "removeChineseOfString, repickStr: " + strReplaceAll);
        return strReplaceAll;
    }

    protected static android.graphics.Typeface a_renamed() {
        android.graphics.Typeface typeface = f4174a;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 850");
            f4174a = builder.build();
        } catch (java.lang.Exception unused) {
            f4174a = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "getMarketFontTypeface, create special typeface fail");
        }
        return f4174a;
    }

    private static android.graphics.Typeface o_renamed() {
        android.graphics.Typeface typeface = f4175b;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 700");
            f4175b = builder.build();
        } catch (java.lang.Exception unused) {
            f4175b = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "getNormalFontTypeface, create special typeface fail");
        }
        return f4175b;
    }

    private static android.graphics.Typeface p_renamed() {
        android.graphics.Typeface typeface = f4176c;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 1000");
            f4176c = builder.build();
        } catch (java.lang.Exception unused) {
            f4176c = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "getMakeupFontTypeface, create special typeface fail");
        }
        return f4176c;
    }

    private static float a_renamed(android.content.Context context, com.oplus.camera.c_renamed.e_renamed eVar, int i_renamed) {
        int height;
        float f_renamed = 1.0f;
        if (!eVar.h_renamed) {
            if (eVar.f4192a.getWidth() < eVar.f4192a.getHeight()) {
                height = eVar.f4192a.getWidth();
            } else {
                height = eVar.f4192a.getHeight();
            }
            f_renamed = (height * 1.0f) / i_renamed;
        }
        return com.oplus.camera.util.Util.t_renamed() ? (f_renamed * 480.0f) / 440.0f : f_renamed;
    }

    public com.oplus.camera.c_renamed.a_renamed b_renamed() {
        this.e_renamed.block(3000L);
        return this.S_renamed;
    }

    public com.oplus.camera.c_renamed.a_renamed a_renamed(int i_renamed) {
        this.e_renamed.block(3000L);
        com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "getVideoWatermarkBitmap, orientation: " + i_renamed);
        com.oplus.camera.c_renamed.a_renamed aVar = this.S_renamed;
        if (aVar == null) {
            return null;
        }
        if (i_renamed == 0 || 180 == i_renamed) {
            this.S_renamed.a_renamed(this.v_renamed);
        } else {
            aVar.a_renamed(this.w_renamed);
        }
        return this.S_renamed;
    }

    public java.util.Map<java.lang.Integer, com.oplus.camera.c_renamed.a_renamed> c_renamed() {
        this.e_renamed.block(3000L);
        return this.T_renamed;
    }

    public java.lang.String d_renamed() {
        this.e_renamed.block(3000L);
        java.lang.String str = this.j_renamed + this.i_renamed;
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion()) {
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "getYuvFilePath, return path: " + this.i_renamed);
            return this.i_renamed;
        }
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "getYuvFilePath, return path: " + str);
        return str;
    }

    public int e_renamed() {
        this.g_renamed = 0;
        if (android.text.TextUtils.isEmpty(q_renamed())) {
            this.g_renamed = 1;
        } else {
            this.g_renamed = 2;
        }
        return this.g_renamed;
    }

    public static java.lang.String f_renamed() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy.MM.dd_renamed HH:mm", java.util.Locale.getDefault());
        java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
        if (!timeZone.equals(simpleDateFormat.getTimeZone())) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat.format(new java.util.Date(java.lang.System.currentTimeMillis()));
    }

    private java.lang.String q_renamed() {
        java.lang.String string = this.l_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "getWatermarkAuthor, author: " + string);
        return string;
    }

    protected static com.oplus.camera.c_renamed.d_renamed a_renamed(android.content.Context context, float f_renamed, com.oplus.camera.ComboPreferences comboPreferences) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.c_renamed.d_renamed dVar = new com.oplus.camera.c_renamed.d_renamed();
        dVar.f4189a = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_preview_transverse, com.oplus.camera.util.Util.f7297a) * f_renamed);
        dVar.f4190b = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_preview_text_interval, com.oplus.camera.util.Util.f7297a) * f_renamed);
        dVar.f4191c = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_preview_logo_corner_portrait_interval, com.oplus.camera.util.Util.f7297a) * f_renamed);
        dVar.d_renamed = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_preview_logo_portrait_interval, com.oplus.camera.util.Util.f7297a) * f_renamed);
        dVar.e_renamed = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_self_transverse_interval, com.oplus.camera.util.Util.f7297a) * f_renamed);
        dVar.g_renamed = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_logo_text_transverse, com.oplus.camera.util.Util.f7297a) * f_renamed);
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values);
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            dVar.f_renamed = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_self_portrait_interval_large, com.oplus.camera.util.Util.f7297a) * f_renamed);
        } else if (stringArray[1].equals(string)) {
            dVar.f_renamed = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_self_portrait_interval_default, com.oplus.camera.util.Util.f7297a) * f_renamed);
        } else {
            dVar.f_renamed = (int) (com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_self_portrait_interval_small, com.oplus.camera.util.Util.f7297a) * f_renamed);
        }
        return dVar;
    }

    private static int d_renamed(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            if (str.charAt(i_renamed) != ' ') {
                return i_renamed;
            }
        }
        return 0;
    }

    private static java.lang.String a_renamed(java.lang.String str, android.graphics.Paint paint, int i_renamed, java.lang.String str2) {
        if (a_renamed(paint, str, i_renamed)) {
            int iMeasureText = str2 != null ? (int) paint.measureText(str2) : 0;
            int iD = d_renamed(str);
            int iMeasureText2 = str.startsWith(" ") ? (int) paint.measureText(str, 0, iD) : 0;
            int iMeasureText3 = (int) paint.measureText(str, iD, iD + 1);
            int i2 = (i_renamed - iMeasureText) - iMeasureText2;
            int length = (i2 / iMeasureText3) + iD;
            java.lang.String strSubstring = length > 0 ? str.substring(0, length) : "";
            if (length >= strSubstring.length()) {
                length = strSubstring.length();
            }
            java.lang.String strSubstring2 = strSubstring.substring(0, length);
            if (str2 != null) {
                strSubstring2 = strSubstring2 + str2;
            }
            int iMeasureText4 = (int) ((i_renamed - paint.measureText(strSubstring2)) / iMeasureText3);
            int i3 = length + iMeasureText4;
            java.lang.String strSubstring3 = i3 > 0 ? str.substring(0, i3) : "";
            if (str2 != null) {
                str = strSubstring3 + str2;
            } else {
                str = strSubstring3;
            }
            com.oplus.camera.e_renamed.b_renamed("BaseSloganUtil", "createSplitString, inputString: " + strSubstring2 + ", endSymbol:" + str2 + ", endSymbolWidth: " + iMeasureText + ", remainingWidth: " + i2 + ", contentSize: " + i3 + ", limit: " + i_renamed + ", deviationSize: " + iMeasureText4 + ", outputString: " + str);
        }
        return str;
    }

    private static boolean a_renamed(android.graphics.Paint paint, java.lang.String str, int i_renamed) {
        return paint.measureText(str) > ((float) i_renamed);
    }

    private void a_renamed(android.graphics.Bitmap bitmap) {
        if (this.R_renamed.f4192a == null || bitmap == null) {
            return;
        }
        if (this.N_renamed == 0 || 180 == this.N_renamed) {
            this.v_renamed = bitmap;
        } else {
            this.w_renamed = bitmap;
        }
    }

    public static android.util.Size a_renamed(android.util.Size size) {
        if (size != null) {
            return new android.util.Size(size.getHeight(), size.getWidth());
        }
        return null;
    }

    public void g_renamed() throws android.content.res.Resources.NotFoundException {
        if (com.oplus.camera.util.Util.x_renamed(this.k_renamed)) {
            return;
        }
        java.lang.String[] stringArray = this.k_renamed.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        java.util.Set<java.lang.String> stringSet = this.l_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        boolean zRemove = stringSet.remove(stringArray[2]);
        android.content.SharedPreferences.Editor editorEdit = this.l_renamed.edit();
        if (zRemove) {
            editorEdit.putStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, stringSet);
        }
        if (stringSet.isEmpty()) {
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, true);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off");
        }
        editorEdit.apply();
    }

    public void a_renamed(boolean z_renamed) {
        this.X_renamed = z_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.Y_renamed = z_renamed;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:168:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:169:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:69:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.camera.c_renamed.a_renamed a_renamed(android.content.Context r32, com.oplus.camera.ComboPreferences r33, com.oplus.camera.c_renamed.e_renamed r34) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.c_renamed.a_renamed(android.content.Context, com.oplus.camera.ComboPreferences, com.oplus.camera.c_renamed$e_renamed):com.oplus.camera.c_renamed$a_renamed");
    }

    public static android.util.Size b_renamed(android.util.Size size) {
        int width = (int) (size.getWidth() * 1.0999999f);
        int width2 = (int) ((size.getWidth() * 0.32000002f) + size.getHeight());
        if (width % 2 != 0) {
            width++;
        }
        if (width2 % 2 != 0) {
            width2++;
        }
        return new android.util.Size(width, width2);
    }

    public static com.oplus.camera.c_renamed.a_renamed a_renamed(android.content.Context context, com.oplus.camera.c_renamed.e_renamed eVar, android.content.SharedPreferences sharedPreferences) {
        com.oplus.camera.c_renamed.a_renamed aVar = new com.oplus.camera.c_renamed.a_renamed();
        android.graphics.Paint paint = new android.graphics.Paint();
        int iC = com.oplus.camera.util.Util.c_renamed(context, com.oplus.camera.R_renamed.drawable.bg_watermark_makeup_visualization, 1.0f, com.oplus.camera.util.Util.f7297a);
        int width = eVar.f4192a.getWidth();
        if (!eVar.h_renamed) {
            eVar.f4192a = b_renamed(eVar.f4192a);
        }
        float fA_renamed = a_renamed(context, eVar, iC);
        java.util.Map<java.lang.String, com.oplus.camera.c_renamed.BaseSloganUtil_6> mapA = a_renamed(context, fA_renamed, eVar, (com.oplus.camera.ComboPreferences) sharedPreferences);
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c = mapA.get("key_watermark_part_a_line");
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c2 = mapA.get("key_watermark_part_b_line");
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c3 = mapA.get("key_watermark_part_name_line");
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c4 = mapA.get("key_watermark_part_c_line");
        if (c0092c == null || c0092c2 == null || c0092c4 == null || c0092c3 == null) {
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkMakeupBitmapHold, hold is_renamed null");
            return null;
        }
        android.graphics.Bitmap bitmap = c0092c3.f_renamed;
        int iA = (int) a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_transverse, fA_renamed);
        int iA2 = (int) a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_portrait, fA_renamed);
        int iA3 = (int) a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_a_self_portrait, fA_renamed);
        int iA4 = (int) a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_b_self_portrait, fA_renamed);
        int iA5 = (int) a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_c_self_portrait, fA_renamed);
        int iB = b_renamed(context, eVar, eVar.f4192a.getWidth());
        int iA6 = (int) a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_first_max_width, fA_renamed);
        if (!eVar.h_renamed) {
            iA4 = (int) (iA4 - 3.0f);
            iA5 = (int) (iA5 - 3.0f);
            iA3 = (int) (iA3 - 3.0f);
        }
        int i_renamed = iB - (iA * 2);
        int height = bitmap.getHeight() + c0092c.d_renamed() + c0092c4.d_renamed();
        if (i_renamed % 2 != 0) {
            i_renamed++;
        }
        if (height % 2 != 0) {
            height++;
        }
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(i_renamed, height, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapA);
        canvas.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.drawText(c0092c.a_renamed(), 0.0f, ((bitmap.getHeight() + c0092c.d_renamed()) - c0092c.g_renamed()) - iA3, c0092c.f_renamed());
        if (c0092c4.c_renamed() > iA6) {
            java.lang.String strA = c0092c4.a_renamed();
            java.lang.String strA2 = a_renamed(strA, c0092c4.f_renamed(), iA6, "");
            java.lang.String strReplace = c0092c4.a_renamed().replace(strA2, "");
            boolean z_renamed = c0092c4.e_renamed && (strA2.contains("Bobbi Brown") || strReplace.contains("Bobbi Brown"));
            int iIndexOf = strA.indexOf("Bobbi Brown");
            if (!z_renamed && -1 != iIndexOf) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(strA2);
                sb.replace(iIndexOf, strA2.length(), "");
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(strReplace);
                sb2.replace(0, 11 - (strA2.length() - iIndexOf), "Bobbi Brown");
                strA2 = sb.toString();
                strReplace = sb2.toString();
            }
            canvas.drawText(c0092c2.a_renamed(), i_renamed - c0092c2.c_renamed(), (((height - (c0092c4.d_renamed() * 2)) - c0092c2.g_renamed()) - iA5) - iA4, c0092c2.f_renamed());
            float f_renamed = i_renamed;
            canvas.drawText(strA2, f_renamed - c0092c4.f_renamed().measureText(strA2), ((height - c0092c4.g_renamed()) - iA5) - c0092c4.d_renamed(), c0092c4.f_renamed());
            canvas.drawText(strReplace, f_renamed - c0092c4.f_renamed().measureText(strReplace), (height - c0092c4.g_renamed()) - iA5, c0092c4.f_renamed());
        } else {
            canvas.drawText(c0092c2.a_renamed(), i_renamed - c0092c2.c_renamed(), ((((height - c0092c4.d_renamed()) - c0092c2.g_renamed()) - iA5) - iA4) - c0092c4.d_renamed(), c0092c2.f_renamed());
            canvas.drawText(c0092c4.a_renamed(), i_renamed - c0092c4.c_renamed(), ((height - c0092c4.g_renamed()) - iA5) - c0092c4.d_renamed(), c0092c4.f_renamed());
        }
        aVar.a_renamed(bitmapA);
        aVar.b_renamed(iA);
        aVar.c_renamed(iA2 - c0092c4.d_renamed());
        aVar.a_renamed(eVar);
        if (!eVar.h_renamed) {
            int i2 = (int) (width * 0.05f);
            int i3 = i2 % 2;
            int i4 = i3 != 0 ? i2 + 1 : i2;
            if (i3 != 0) {
                i2++;
            }
            aVar.g_renamed(eVar.f4192a.getWidth());
            aVar.h_renamed(eVar.f4192a.getHeight());
            aVar.i_renamed(i4);
            aVar.j_renamed(i2);
        }
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkMakeupBitmapHold, imageWidth: " + aVar.j_renamed() + ", imageHeight: " + aVar.k_renamed() + ", x_renamed: " + aVar.l_renamed() + ", y_renamed: " + aVar.m_renamed() + ", watermarkWidth: " + i_renamed + ", watermarkHeight: " + height + ", scale: " + fA_renamed);
        return aVar;
    }

    private static android.graphics.Bitmap a_renamed(android.content.Context context, float f_renamed, java.lang.String str, int i_renamed) {
        if (d_renamed == null) {
            d_renamed = new java.util.HashMap();
        }
        android.graphics.Bitmap bitmap = d_renamed.get(str + f_renamed);
        if (bitmap != null) {
            return bitmap;
        }
        android.graphics.Bitmap bitmapB = com.oplus.camera.util.Util.b_renamed(context, i_renamed, f_renamed, com.oplus.camera.util.Util.f7297a);
        d_renamed.put(str + f_renamed, bitmapB);
        return bitmapB;
    }

    private static int b_renamed(android.content.Context context, com.oplus.camera.c_renamed.e_renamed eVar, int i_renamed) {
        return !eVar.h_renamed ? eVar.f4192a.getWidth() : i_renamed;
    }

    private static java.util.Map<java.lang.String, com.oplus.camera.c_renamed.BaseSloganUtil_6> a_renamed(android.content.Context context, float f_renamed, com.oplus.camera.c_renamed.e_renamed eVar, com.oplus.camera.ComboPreferences comboPreferences) {
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkMakeupText");
        com.oplus.camera.c_renamed.b_renamed bVarA = a_renamed(context, eVar, f_renamed);
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c = new com.oplus.camera.c_renamed.BaseSloganUtil_6(context, comboPreferences, 1.0f);
        c0092c.f_renamed = bVarA.f4185c;
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c2 = new com.oplus.camera.c_renamed.BaseSloganUtil_6(context, comboPreferences, 1.0f, false);
        c0092c2.f_renamed().setTextSize(a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_name_size, f_renamed));
        c0092c2.f_renamed().setColor(bVarA.f4184b);
        c0092c2.f_renamed().setTypeface(o_renamed());
        c0092c2.b_renamed(bVarA.f4183a);
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c3 = new com.oplus.camera.c_renamed.BaseSloganUtil_6(context, comboPreferences, 1.0f, false);
        c0092c3.f_renamed().setTextSize(a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_device_size, f_renamed));
        c0092c3.f_renamed().setColor(context.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency));
        c0092c3.f_renamed().setTypeface(p_renamed());
        c0092c3.b_renamed(c_renamed(com.oplus.camera.util.Util.v_renamed()));
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c4 = new com.oplus.camera.c_renamed.BaseSloganUtil_6(context, comboPreferences, 1.0f, false);
        c0092c4.f_renamed().setTextSize(a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_makeup_slogan_device, f_renamed));
        c0092c4.f_renamed().setColor(context.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency));
        c0092c4.f_renamed().setTypeface(o_renamed());
        if (!bVarA.d_renamed) {
            c0092c4.b_renamed(context.getString(com.oplus.camera.R_renamed.string.camera_beauty_makeup_watermark_normal_slogan));
        } else {
            c0092c4.e_renamed = true;
            c0092c4.b_renamed(context.getString(com.oplus.camera.R_renamed.string.camera_beauty_makeup_watermark_custom_slogan));
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("key_watermark_part_a_line", c0092c2);
        map.put("key_watermark_part_b_line", c0092c3);
        map.put("key_watermark_part_c_line", c0092c4);
        map.put("key_watermark_part_name_line", c0092c);
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkMakeupText, X_renamed");
        return map;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.c_renamed.b_renamed a_renamed(android.content.Context r7, com.oplus.camera.c_renamed.e_renamed r8, float r9) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.c_renamed.a_renamed(android.content.Context, com.oplus.camera.c_renamed$e_renamed, float):com.oplus.camera.c_renamed$b_renamed");
    }

    private static float a_renamed(android.content.Context context, int i_renamed, float f_renamed) {
        return com.oplus.camera.util.Util.a_renamed(context, i_renamed, com.oplus.camera.util.Util.f7297a) * f_renamed;
    }

    private static boolean e_renamed(java.lang.String str) {
        return com.google.android.exoplayer2.text.ttml.TtmlNode.CENTER.equals(str);
    }

    private static void a_renamed(com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c, int i_renamed) {
        if (i_renamed >= c0092c.c_renamed()) {
            return;
        }
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        int i2 = (string == null || string.isEmpty()) ? 0 : 1;
        for (int i3 = 0; i3 < c0092c.b_renamed().size(); i3++) {
            if (i3 != i2) {
                i_renamed = (int) (((int) (((int) ((i_renamed - c0092c.b_renamed(i3)) - c0092c.h_renamed())) - c0092c.i_renamed())) - c0092c.j_renamed());
            }
        }
        c0092c.a_renamed(a_renamed(c0092c.a_renamed(i2), c0092c.f_renamed(), i_renamed, "..."), i2);
    }

    private static java.util.Map<java.lang.String, com.oplus.camera.c_renamed.BaseSloganUtil_6> a_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, float f_renamed, com.oplus.camera.c_renamed.e_renamed eVar) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed;
        boolean zContains;
        boolean zContains2;
        java.util.Set<java.lang.String> stringSet = comboPreferences.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        if ((stringSet == null || stringSet.isEmpty()) && ((string == null || string.isEmpty()) && 1 != com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEVICE_SERIES))) {
            com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkText, chooseDisplayValues is_renamed null or empty");
            return new java.util.HashMap();
        }
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String strC = c_renamed(com.oplus.camera.util.Util.v_renamed());
        if (stringSet == null || stringSet.isEmpty()) {
            z_renamed = false;
            zContains = false;
            zContains2 = false;
        } else {
            zContains = stringSet.contains(stringArray[0]);
            zContains2 = stringSet.contains(stringArray[1]);
            z_renamed = stringSet.contains(stringArray[2]) && eVar.j_renamed;
        }
        if (string != null && !string.isEmpty()) {
            arrayList.add(string);
        }
        if (z_renamed) {
            arrayList.add(eVar.d_renamed);
        }
        if (zContains2) {
            arrayList.add(eVar.f4194c);
        }
        com.oplus.camera.e_renamed.a_renamed("BaseSloganUtil", "createWatermarkText, isWatermarkDevice: " + zContains + ", isWatermarkTime: " + zContains2 + ", isWatermarkLocation: " + z_renamed);
        java.util.HashMap map = new java.util.HashMap();
        float fA_renamed = a_renamed(context, comboPreferences, f_renamed, false);
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c = new com.oplus.camera.c_renamed.BaseSloganUtil_6(context, comboPreferences, f_renamed);
        map.put("key_watermark_part_a_line", c0092c);
        if (!zContains) {
            c0092c.a_renamed(fA_renamed);
            c0092c.a_renamed(o_renamed());
            if (!eVar.h_renamed) {
                c0092c.f_renamed().setLetterSpacing(0.007f);
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                java.lang.String str = (java.lang.String) it.next();
                if (!str.isEmpty()) {
                    c0092c.a_renamed(str);
                }
            }
            if (arrayList.isEmpty()) {
                c0092c.a_renamed(context.getString(com.oplus.camera.R_renamed.string.camera_watermark_default_slogan));
            }
            return map;
        }
        if (!strC.isEmpty()) {
            c0092c.a_renamed(strC);
        }
        c0092c.a_renamed(a_renamed(context, comboPreferences, f_renamed, true));
        c0092c.a_renamed(a_renamed());
        c0092c.f_renamed().setLetterSpacing(0.03f);
        com.oplus.camera.c_renamed.BaseSloganUtil_6 c0092c2 = new com.oplus.camera.c_renamed.BaseSloganUtil_6(context, comboPreferences, f_renamed);
        c0092c2.a_renamed(fA_renamed);
        c0092c2.a_renamed(o_renamed());
        if (!eVar.h_renamed) {
            c0092c2.f_renamed().setLetterSpacing(0.007f);
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            java.lang.String str2 = (java.lang.String) it2.next();
            if (!str2.isEmpty()) {
                c0092c2.a_renamed(str2);
            }
        }
        map.put("key_watermark_part_b_line", c0092c2);
        return map;
    }

    private static float a_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, float f_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values);
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            i_renamed = z_renamed ? com.oplus.camera.R_renamed.dimen.watermark_text_device_large : com.oplus.camera.R_renamed.dimen.watermark_text_large;
        } else {
            i_renamed = stringArray[1].equals(string) ? z_renamed ? com.oplus.camera.R_renamed.dimen.watermark_text_device_default : com.oplus.camera.R_renamed.dimen.watermark_text_default : z_renamed ? com.oplus.camera.R_renamed.dimen.watermark_text_device_small : com.oplus.camera.R_renamed.dimen.watermark_text_small;
        }
        return com.oplus.camera.util.Util.a_renamed(context, i_renamed, com.oplus.camera.util.Util.f7297a) * f_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float b_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, float f_renamed) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values);
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            i_renamed = com.oplus.camera.R_renamed.dimen.watermark_divider_large_height;
        } else {
            i_renamed = stringArray[1].equals(string) ? com.oplus.camera.R_renamed.dimen.watermark_divider_default_height : com.oplus.camera.R_renamed.dimen.watermark_divider_small_height;
        }
        return com.oplus.camera.util.Util.a_renamed(context, i_renamed, com.oplus.camera.util.Util.f7297a) * f_renamed;
    }

    private static android.graphics.Bitmap c_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, float f_renamed) throws android.content.res.Resources.NotFoundException {
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values);
        java.lang.String string = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, stringArray[1]);
        if (stringArray[2].equals(string)) {
            return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_copyright_large, f_renamed, com.oplus.camera.util.Util.f7297a);
        }
        if (stringArray[1].equals(string)) {
            return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_copyright_default, f_renamed, com.oplus.camera.util.Util.f7297a);
        }
        return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_copyright_small, f_renamed, com.oplus.camera.util.Util.f7297a);
    }

    private static android.graphics.Bitmap b_renamed(android.graphics.Bitmap bitmap) {
        return android.graphics.Bitmap.createScaledBitmap(bitmap.extractAlpha(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    private static android.graphics.Paint a_renamed(android.content.Context context) {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setMaskFilter(new android.graphics.BlurMaskFilter(4.0f, android.graphics.BlurMaskFilter.Blur.OUTER));
        paint.setColor(context.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
        return paint;
    }

    public android.graphics.Bitmap a_renamed(android.content.Context context, float f_renamed) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_watermark_logo_type_fold, f_renamed / 4.0f, com.oplus.camera.util.Util.f7297a);
        }
        if ("00FFF006".equals(this.U_renamed) && this.z_renamed) {
            return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.salah_logan, f_renamed / 2.77777f, com.oplus.camera.util.Util.f7297a);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEVICE_SERIES) == 0) {
            return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_watermark_logo_type_reno, f_renamed / 4.0f, com.oplus.camera.util.Util.f7297a);
        }
        if (1 == com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEVICE_SERIES)) {
            return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_watermark_logo_type_find, f_renamed / 4.0f, com.oplus.camera.util.Util.f7297a);
        }
        return com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.drawable.ic_watermark_logo_type_reno, f_renamed / 4.0f, com.oplus.camera.util.Util.f7297a);
    }

    public static boolean a_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences) {
        java.util.Set<java.lang.String> stringSet = comboPreferences.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        if (stringSet == null || stringSet.isEmpty()) {
            com.oplus.camera.e_renamed.f_renamed("BaseSloganUtil", "isWatermarkLocationOpen, chooseDisplayValues is_renamed : " + stringSet);
            return false;
        }
        return stringSet.contains(context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values)[2]);
    }

    public static void b_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences) throws android.content.res.Resources.NotFoundException {
        java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        java.util.Set<java.lang.String> stringSet = comboPreferences.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        if (stringSet != null && stringSet.remove(stringArray[2])) {
            comboPreferences.edit().putStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, stringSet).apply();
        }
    }

    /* compiled from: BaseSloganUtil.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.util.Size f4177a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        private byte[] f4178b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f4179c = 0;
        private int d_renamed = 0;
        private int e_renamed = 0;
        private android.graphics.Bitmap f_renamed = null;
        private int g_renamed = 0;
        private int h_renamed = 0;
        private int i_renamed = 0;
        private com.oplus.camera.c_renamed.e_renamed j_renamed = null;
        private int k_renamed = 0;
        private int l_renamed = 0;
        private int m_renamed = 0;
        private int n_renamed = 0;

        public android.util.Size a_renamed() {
            return this.f4177a;
        }

        public void a_renamed(android.util.Size size) {
            this.f4177a = size;
        }

        public byte[] b_renamed() {
            return this.f4178b;
        }

        public void a_renamed(byte[] bArr) {
            this.f4178b = bArr;
        }

        public int c_renamed() {
            return this.f4179c;
        }

        public void a_renamed(int i_renamed) {
            this.f4179c = i_renamed;
        }

        public int d_renamed() {
            return this.d_renamed;
        }

        public void b_renamed(int i_renamed) {
            this.d_renamed = i_renamed;
        }

        public int e_renamed() {
            return this.e_renamed;
        }

        public void c_renamed(int i_renamed) {
            this.e_renamed = i_renamed;
        }

        public android.graphics.Bitmap f_renamed() {
            return this.f_renamed;
        }

        public void a_renamed(android.graphics.Bitmap bitmap) {
            this.f_renamed = bitmap;
        }

        public int g_renamed() {
            return this.g_renamed;
        }

        public void d_renamed(int i_renamed) {
            this.g_renamed = i_renamed;
        }

        public void e_renamed(int i_renamed) {
            this.h_renamed = i_renamed;
        }

        public int h_renamed() {
            return this.i_renamed;
        }

        public void f_renamed(int i_renamed) {
            this.i_renamed = i_renamed;
        }

        public com.oplus.camera.c_renamed.e_renamed i_renamed() {
            return this.j_renamed;
        }

        public void a_renamed(com.oplus.camera.c_renamed.e_renamed eVar) {
            this.j_renamed = eVar;
        }

        public int j_renamed() {
            return this.k_renamed;
        }

        public void g_renamed(int i_renamed) {
            this.k_renamed = i_renamed;
        }

        public int k_renamed() {
            return this.l_renamed;
        }

        public void h_renamed(int i_renamed) {
            this.l_renamed = i_renamed;
        }

        public int l_renamed() {
            return this.m_renamed;
        }

        public void i_renamed(int i_renamed) {
            this.m_renamed = i_renamed;
        }

        public int m_renamed() {
            return this.n_renamed;
        }

        public void j_renamed(int i_renamed) {
            this.n_renamed = i_renamed;
        }
    }

    /* compiled from: BaseSloganUtil.java */
    private static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f4189a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4190b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f4191c;
        public int d_renamed;
        public int e_renamed;
        public int f_renamed;
        public int g_renamed;

        private d_renamed() {
            this.f4189a = 0;
            this.f4190b = 0;
            this.f4191c = 0;
            this.d_renamed = 0;
            this.e_renamed = 0;
            this.f_renamed = 0;
            this.g_renamed = 0;
        }

        public java.lang.String toString() {
            return "WatermarkTextParameter, mPaddingTransverse: " + this.f4189a + ", mTextInterval: " + this.f4190b + ", mLogoCornerPortraitInterval: " + this.f4191c + ", mLogoPortraitInterval: " + this.d_renamed + ", mWatermarkTransverseInterval: " + this.e_renamed + ", mWatermarkPortraitInterval: " + this.f_renamed;
        }
    }

    /* compiled from: BaseSloganUtil.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public java.lang.String f4183a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4184b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public android.graphics.Bitmap f4185c;
        public boolean d_renamed;

        private b_renamed() {
            this.f4183a = "";
            this.f4184b = 0;
            this.f4185c = null;
            this.d_renamed = false;
        }
    }

    /* compiled from: BaseSloganUtil.java */
    /* renamed from: com.oplus.camera.c_renamed$c_renamed, reason: collision with other inner class name */
    private static class BaseSloganUtil_6 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.ArrayList<java.lang.String> f4186a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.graphics.Paint.FontMetrics f4187b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.text.TextPaint f4188c;
        private boolean d_renamed;
        private boolean e_renamed;
        private android.graphics.Bitmap f_renamed;
        private float g_renamed;
        private float h_renamed;
        private float i_renamed;
        private float j_renamed;

        public BaseSloganUtil_6(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, float f_renamed) {
            this(context, comboPreferences, f_renamed, true);
        }

        public BaseSloganUtil_6(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, float f_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
            this.f4186a = null;
            this.f4187b = null;
            this.f4188c = null;
            this.d_renamed = false;
            this.e_renamed = false;
            this.f_renamed = null;
            this.g_renamed = 0.0f;
            this.h_renamed = 0.0f;
            this.i_renamed = 0.0f;
            this.j_renamed = 0.0f;
            this.g_renamed = com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_divider_left, com.oplus.camera.util.Util.f7297a) * f_renamed;
            this.h_renamed = com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_divider_right, com.oplus.camera.util.Util.f7297a) * f_renamed;
            this.i_renamed = com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.watermark_divider_width, com.oplus.camera.util.Util.f7297a) * f_renamed;
            this.j_renamed = com.oplus.camera.c_renamed.b_renamed(context, comboPreferences, f_renamed);
            this.f4186a = new java.util.ArrayList<>();
            this.f4188c = new android.text.TextPaint();
            this.f4188c.setFlags(1);
            this.f4188c.setColor(context.getResources().getColor(com.oplus.camera.R_renamed.color.camera_white));
            if (z_renamed) {
                this.f4188c.setShadowLayer(com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.slogan_text_shadow_radius, com.oplus.camera.util.Util.f7297a), com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.slogan_text_shadow_x, com.oplus.camera.util.Util.f7297a), com.oplus.camera.util.Util.a_renamed(context, com.oplus.camera.R_renamed.dimen.slogan_text_shadow_y, com.oplus.camera.util.Util.f7297a), context.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
            }
        }

        public void a_renamed(java.lang.String str) {
            this.f4186a.add(str);
        }

        public void a_renamed(java.lang.String str, int i_renamed) {
            this.f4186a.add(i_renamed, str);
        }

        public void b_renamed(java.lang.String str) {
            this.f4186a.clear();
            this.f4186a.add(str);
        }

        public java.lang.String a_renamed() {
            return java.lang.String.join("", this.f4186a);
        }

        public java.util.ArrayList<java.lang.String> b_renamed() {
            return this.f4186a;
        }

        public java.lang.String a_renamed(int i_renamed) {
            return this.f4186a.remove(i_renamed);
        }

        public int c_renamed() {
            return ((int) java.lang.Math.ceil(this.f4188c.measureText(a_renamed()))) + (((int) java.lang.Math.ceil(this.g_renamed)) * (this.f4186a.size() - 1)) + (((int) java.lang.Math.ceil(this.h_renamed)) * (this.f4186a.size() - 1)) + (((int) java.lang.Math.ceil(this.i_renamed)) * (this.f4186a.size() - 1));
        }

        public int b_renamed(int i_renamed) {
            if (i_renamed < 0) {
                return 0;
            }
            return (int) this.f4188c.measureText(b_renamed().get(i_renamed));
        }

        public int d_renamed() {
            if (this.f4187b == null) {
                this.f4187b = this.f4188c.getFontMetrics();
            }
            return (int) java.lang.Math.abs(this.f4187b.descent - this.f4187b.ascent);
        }

        public boolean e_renamed() {
            return this.d_renamed;
        }

        public void a_renamed(float f_renamed) {
            this.f4187b = null;
            this.f4188c.setTextSize(f_renamed);
        }

        public void a_renamed(android.graphics.Typeface typeface) {
            this.f4188c.setTypeface(typeface);
        }

        public android.graphics.Paint f_renamed() {
            return this.f4188c;
        }

        public void a_renamed(android.graphics.Paint.Align align) {
            this.f4188c.setTextAlign(align);
        }

        public int g_renamed() {
            if (this.f4187b == null) {
                this.f4187b = this.f4188c.getFontMetrics();
            }
            return (int) this.f4187b.descent;
        }

        public float h_renamed() {
            return this.g_renamed;
        }

        public float i_renamed() {
            return this.h_renamed;
        }

        public float j_renamed() {
            return this.i_renamed;
        }

        public float k_renamed() {
            return this.j_renamed;
        }
    }
}
