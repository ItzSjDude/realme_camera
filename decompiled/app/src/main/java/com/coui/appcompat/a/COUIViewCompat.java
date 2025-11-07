package com.coui.appcompat.a_renamed;

/* compiled from: COUIThemeOverlay.java */
/* loaded from: classes.dex */
public class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.coui.appcompat.a_renamed.t_renamed f2404a;
    private static java.lang.String d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.util.SparseIntArray f2405b = new android.util.SparseIntArray();

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<java.lang.Boolean>> f2406c = new java.util.HashMap<>();

    public static com.coui.appcompat.a_renamed.t_renamed a_renamed() {
        if (f2404a == null) {
            synchronized (com.coui.appcompat.a_renamed.t_renamed.class) {
                if (f2404a == null) {
                    f2404a = new com.coui.appcompat.a_renamed.t_renamed();
                }
            }
        }
        return f2404a;
    }

    public void a_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        b_renamed();
        d_renamed(context);
        for (int i_renamed = 0; i_renamed < this.f2405b.size(); i_renamed++) {
            context.setTheme(this.f2405b.valueAt(i_renamed));
        }
    }

    public boolean b_renamed(android.content.Context context) throws java.lang.ClassNotFoundException {
        long jA = a_renamed(context.getResources().getConfiguration());
        return jA > 0 && (jA & 2097151) != 0;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f2405b.put(i_renamed, i2);
    }

    public void b_renamed() {
        this.f2405b.clear();
    }

    public boolean c_renamed(android.content.Context context) throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls;
        long jLongValue;
        boolean zF;
        android.content.res.Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null || !d_renamed()) {
            return false;
        }
        oplus.content.res.OplusExtraConfiguration oplusExtraConfigurationB = b_renamed(context.getResources().getConfiguration());
        if (oplusExtraConfigurationB != null) {
            jLongValue = oplusExtraConfigurationB.mThemeChangedFlags;
        } else {
            d_renamed = c_renamed() ? "com.oplus.inner.content.res.ConfigurationWrapper" : com.coui.appcompat.a_renamed.c_renamed.a_renamed().e_renamed();
            try {
                cls = java.lang.Class.forName(d_renamed);
            } catch (java.lang.Exception e_renamed) {
                com.coui.appcompat.a_renamed.i_renamed.a_renamed("COUIThemeOverlay", "isRejectTheme e_renamed: " + e_renamed);
            }
            jLongValue = cls.newInstance() != null ? ((java.lang.Long) cls.getMethod("getThemeChangedFlags", android.content.res.Configuration.class).invoke(null, configuration)).longValue() : 0L;
        }
        if ((1 & jLongValue) == 0) {
            zF = false;
        } else if ((jLongValue & 256) != 0) {
            zF = e_renamed(context);
        } else {
            zF = f_renamed(context);
        }
        return zF && (configuration.uiMode & 48) != 32;
    }

    private void d_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        int i_renamed;
        if (context == null) {
            return;
        }
        long jA = a_renamed(context.getResources().getConfiguration());
        int i2 = (int) (65535 & jA);
        int i3 = (int) (196608 & jA);
        if (jA != 0) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            int integer = context.getTheme().obtainStyledAttributes(new int[]{coui.support.appcompat.R_renamed.attr.couiThemeIdentifier}).getInteger(0, 0);
            if (c_renamed(context)) {
                return;
            }
            if (i3 == 131072) {
                a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_global_theme, coui.support.appcompat.R_renamed.style.SupportOverlay_Theme_Single_First);
                return;
            }
            if (i3 == 0) {
                int iA = a_renamed(i2);
                i2 = integer - 1;
                i_renamed = iA;
            } else if (i3 == 65536) {
                i_renamed = coui.support.appcompat.R_renamed.array.coui_theme_arrays_single;
            } else {
                i2 = -1;
                i_renamed = 0;
            }
            if (i_renamed == 0 || i2 == -1) {
                return;
            }
            android.content.res.TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(i_renamed);
            for (int i4 = 0; i4 < typedArrayObtainTypedArray.length(); i4++) {
                if (i4 == i2) {
                    a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_global_theme, typedArrayObtainTypedArray.getResourceId(i4, 0));
                    return;
                }
            }
        }
    }

    public long a_renamed(android.content.res.Configuration configuration) throws java.lang.ClassNotFoundException {
        if (!d_renamed()) {
            return 0L;
        }
        oplus.content.res.OplusExtraConfiguration oplusExtraConfigurationB = b_renamed(configuration);
        if (oplusExtraConfigurationB != null) {
            return oplusExtraConfigurationB.mMaterialColor;
        }
        d_renamed = c_renamed() ? "com.oplus.inner.content.res.ConfigurationWrapper" : com.coui.appcompat.a_renamed.c_renamed.a_renamed().e_renamed();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(d_renamed);
            if (cls.newInstance() != null) {
                return ((java.lang.Long) cls.getMethod("getMaterialColor", android.content.res.Configuration.class).invoke(null, configuration)).longValue();
            }
            return 0L;
        } catch (java.lang.Exception e_renamed) {
            com.coui.appcompat.a_renamed.i_renamed.a_renamed("COUIThemeOverlay", "getCOUITheme e_renamed: " + e_renamed);
            return 0L;
        }
    }

    private boolean c_renamed() throws java.lang.ClassNotFoundException {
        try {
            java.lang.Class.forName("com.oplus.inner.content.res.ConfigurationWrapper");
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean d_renamed() throws java.lang.ClassNotFoundException {
        try {
            java.lang.Class.forName("android.content.res.OplusBaseConfiguration");
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private oplus.content.res.OplusExtraConfiguration b_renamed(android.content.res.Configuration configuration) {
        android.content.res.OplusBaseConfiguration oplusBaseConfiguration = (android.content.res.OplusBaseConfiguration) a_renamed(android.content.res.OplusBaseConfiguration.class, configuration);
        if (oplusBaseConfiguration == null) {
            return null;
        }
        return oplusBaseConfiguration.mOplusExtraConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T_renamed> T_renamed a_renamed(java.lang.Class<T_renamed> cls, java.lang.Object obj) {
        if (obj == 0 || !cls.isInstance(obj)) {
            return null;
        }
        return obj;
    }

    private int a_renamed(int i_renamed) {
        int i2;
        boolean z_renamed = e_renamed() < 12000;
        if (i_renamed == 1) {
            i2 = z_renamed ? coui.support.appcompat.R_renamed.array.coui_theme_arrays_first_compat : coui.support.appcompat.R_renamed.array.coui_theme_arrays_first;
        } else if (i_renamed == 2) {
            i2 = z_renamed ? coui.support.appcompat.R_renamed.array.coui_theme_arrays_second_compat : coui.support.appcompat.R_renamed.array.coui_theme_arrays_second;
        } else if (i_renamed == 3) {
            i2 = z_renamed ? coui.support.appcompat.R_renamed.array.coui_theme_arrays_third_compat : coui.support.appcompat.R_renamed.array.coui_theme_arrays_third;
        } else {
            if (i_renamed != 4) {
                return 0;
            }
            i2 = z_renamed ? coui.support.appcompat.R_renamed.array.coui_theme_arrays_fourth_compat : coui.support.appcompat.R_renamed.array.coui_theme_arrays_fourth;
        }
        return i2;
    }

    private int e_renamed() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        int i_renamed;
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.String.class);
            java.lang.String str = (java.lang.String) method.invoke(null, "ro.oplus.theme.version");
            i_renamed = !android.text.TextUtils.isEmpty(str) ? java.lang.Integer.parseInt(str.trim()) : 0;
            if (i_renamed != 0) {
                return i_renamed;
            }
            try {
                java.lang.String str2 = (java.lang.String) method.invoke(null, com.coui.appcompat.a_renamed.c_renamed.a_renamed().f_renamed());
                return !android.text.TextUtils.isEmpty(str2) ? java.lang.Integer.parseInt(str2.trim()) : i_renamed;
            } catch (java.lang.Exception e_renamed) {
                e_renamed = e_renamed;
                com.coui.appcompat.a_renamed.i_renamed.a_renamed("COUIThemeOverlay", "getCompatVersion e_renamed: " + e_renamed);
                return i_renamed;
            }
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            i_renamed = 0;
        }
    }

    private boolean e_renamed(android.content.Context context) {
        java.io.File file = new java.io.File(com.oplus.theme.OplusThemeUtil.CUSTOM_THEME_PATH);
        if (!file.exists()) {
            return false;
        }
        if (new java.io.File(file, context.getPackageName()).exists()) {
            return true;
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return false;
        }
        java.lang.String string = android.provider.Settings.System.getString(context.getContentResolver(), "custom_theme_path_setting");
        if (android.text.TextUtils.isEmpty(string)) {
            return false;
        }
        return new java.io.File(string, context.getPackageName()).exists();
    }

    private boolean f_renamed(android.content.Context context) {
        oplus.content.res.OplusExtraConfiguration oplusExtraConfigurationB = b_renamed(context.getResources().getConfiguration());
        int i_renamed = oplusExtraConfigurationB != null ? oplusExtraConfigurationB.mUserId : 0;
        java.lang.String str = "/data/theme/";
        if (i_renamed > 0) {
            str = "/data/theme/" + i_renamed;
        }
        return new java.io.File(str, context.getPackageName()).exists();
    }
}
