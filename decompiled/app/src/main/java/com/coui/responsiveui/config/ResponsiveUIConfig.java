package com.coui.responsiveui.config;

/* loaded from: classes.dex */
public class ResponsiveUIConfig {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.coui.responsiveui.config.ResponsiveUIConfig f3144a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f3145b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.HashMap<java.lang.Integer, com.coui.responsiveui.config.ResponsiveUIConfig> f3146c = new java.util.LinkedHashMap();
    private int j_renamed;
    private android.content.Context k_renamed;
    private int d_renamed = -1;
    private androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIConfig> e_renamed = new androidx.lifecycle.m_renamed<>();
    private androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIConfig.Status> f_renamed = new androidx.lifecycle.m_renamed<>();
    private androidx.lifecycle.m_renamed<java.lang.Integer> g_renamed = new androidx.lifecycle.m_renamed<>();
    private androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIScreenSize> h_renamed = new androidx.lifecycle.m_renamed<>();
    private androidx.lifecycle.m_renamed<java.lang.Integer> i_renamed = new androidx.lifecycle.m_renamed<>();
    private float l_renamed = -1.0f;
    private float m_renamed = 1.0f;
    private com.coui.responsiveui.config.UIConfig.WindowType n_renamed = com.coui.responsiveui.config.UIConfig.WindowType.SMALL;

    private ResponsiveUIConfig(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        this.d_renamed = context.hashCode();
        this.k_renamed = context.getApplicationContext();
        b_renamed(context.getResources().getConfiguration());
        b_renamed(this.k_renamed.getResources());
        a_renamed(context.getResources().getConfiguration());
        a_renamed(context.getResources());
        android.util.Log.d_renamed("ResponsiveUIConfig", "init uiConfig " + this.e_renamed.a_renamed() + ", columns count " + this.i_renamed.a_renamed());
        android.util.Log.d_renamed("ResponsiveUIConfig", "init addContent [" + getExtendHierarchyParentWidthDp() + ":" + getExtendHierarchyChildWidthDp() + "] - [" + getExtendHierarchyParentColumnsCount() + ":" + getExtendHierarchyChildColumnsCount() + "]");
    }

    private boolean a_renamed(android.content.res.Configuration configuration) {
        int i_renamed = configuration.orientation;
        com.coui.responsiveui.config.UIScreenSize uIScreenSize = new com.coui.responsiveui.config.UIScreenSize(configuration.screenWidthDp, configuration.screenHeightDp, configuration.smallestScreenWidthDp);
        com.coui.responsiveui.config.UIConfig uIConfig = new com.coui.responsiveui.config.UIConfig(a_renamed(i_renamed, uIScreenSize), uIScreenSize, i_renamed, this.n_renamed);
        com.coui.responsiveui.config.UIConfig uIConfigA = this.e_renamed.a_renamed();
        boolean z_renamed = false;
        if (uIConfig.equals(uIConfigA)) {
            return false;
        }
        if (uIConfigA == null || uIConfig.getStatus() != uIConfigA.getStatus()) {
            this.f_renamed.a_renamed((androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIConfig.Status>) uIConfig.getStatus());
        }
        if (uIConfigA == null || uIConfig.getOrientation() != uIConfigA.getOrientation()) {
            this.g_renamed.a_renamed((androidx.lifecycle.m_renamed<java.lang.Integer>) java.lang.Integer.valueOf(uIConfig.getOrientation()));
            z_renamed = true;
        }
        if (uIConfigA == null || !uIConfig.getScreenSize().equals(uIConfigA.getScreenSize())) {
            int widthDp = uIConfig.getScreenSize().getWidthDp();
            int iB = b_renamed();
            if (java.lang.Math.abs(widthDp - iB) < 50) {
                this.h_renamed.a_renamed((androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIScreenSize>) uIConfig.getScreenSize());
            } else {
                android.util.Log.d_renamed("ResponsiveUIConfig", "update ScreenSize few case newWidth " + widthDp + " appWidth " + iB);
                com.coui.responsiveui.config.UIScreenSize uIScreenSizeA = this.h_renamed.a_renamed();
                if (uIScreenSizeA != null) {
                    if (z_renamed) {
                        widthDp = uIScreenSizeA.getHeightDp();
                    } else {
                        widthDp = uIScreenSizeA.getWidthDp();
                    }
                }
                this.h_renamed.a_renamed((androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIScreenSize>) new com.coui.responsiveui.config.UIScreenSize(widthDp, uIConfig.getScreenSize().getHeightDp(), uIConfig.getScreenSize().a_renamed()));
            }
            uIConfig.a_renamed(this.h_renamed.a_renamed());
        }
        this.e_renamed.a_renamed((androidx.lifecycle.m_renamed<com.coui.responsiveui.config.UIConfig>) uIConfig);
        return true;
    }

    private com.coui.responsiveui.config.UIConfig.Status a_renamed(int i_renamed, com.coui.responsiveui.config.UIScreenSize uIScreenSize) {
        com.coui.responsiveui.config.UIConfig.Status status = com.coui.responsiveui.config.UIConfig.Status.UNKNOWN;
        int iA = uIScreenSize.a_renamed();
        int widthDp = uIScreenSize.getWidthDp();
        if (widthDp < 640) {
            this.n_renamed = com.coui.responsiveui.config.UIConfig.WindowType.SMALL;
        } else if (widthDp < 840) {
            this.n_renamed = com.coui.responsiveui.config.UIConfig.WindowType.MEDIUM;
        } else {
            this.n_renamed = com.coui.responsiveui.config.UIConfig.WindowType.LARGE;
        }
        if (i_renamed == 1) {
            if (iA >= 640) {
                return com.coui.responsiveui.config.UIConfig.Status.UNFOLD;
            }
            return com.coui.responsiveui.config.UIConfig.Status.FOLD;
        }
        if (i_renamed != 2) {
            android.util.Log.d_renamed("ResponsiveUIConfig", "undefined orientation Status unknown !!! ");
            return status;
        }
        if (iA >= 500) {
            return com.coui.responsiveui.config.UIConfig.Status.UNFOLD;
        }
        return com.coui.responsiveui.config.UIConfig.Status.FOLD;
    }

    private void a_renamed(android.content.res.Resources resources) throws android.content.res.Resources.NotFoundException {
        java.lang.Integer numA = this.i_renamed.a_renamed();
        int integer = resources.getInteger(coui.support.appcompat.R_renamed.integer.responsive_ui_column_count);
        float widthDp = this.h_renamed.a_renamed().getWidthDp() / b_renamed();
        if (widthDp > 1.0f) {
            widthDp = 1.0f;
        }
        int iA = a_renamed((int) (integer * widthDp));
        if (numA == null || numA.intValue() != iA) {
            this.i_renamed.a_renamed((androidx.lifecycle.m_renamed<java.lang.Integer>) java.lang.Integer.valueOf(iA));
        }
    }

    private int a_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        int integer = this.k_renamed.getResources().getInteger(coui.support.appcompat.R_renamed.integer.inner_responsive_ui_column_4);
        int integer2 = this.k_renamed.getResources().getInteger(coui.support.appcompat.R_renamed.integer.inner_responsive_ui_column_8);
        int integer3 = this.k_renamed.getResources().getInteger(coui.support.appcompat.R_renamed.integer.inner_responsive_ui_column_12);
        int i2 = integer / 2;
        return i_renamed < integer2 - i2 ? integer : (i_renamed >= integer2 && i_renamed >= integer3 - i2) ? integer3 : integer2;
    }

    private void b_renamed(android.content.res.Configuration configuration) {
        this.l_renamed = configuration.densityDpi / 160.0f;
    }

    private void b_renamed(android.content.res.Resources resources) {
        this.j_renamed = resources.getInteger(coui.support.appcompat.R_renamed.integer.inner_responsive_ui_column_4);
    }

    private int b_renamed() {
        return this.k_renamed.getResources().getConfiguration().screenWidthDp;
    }

    public androidx.lifecycle.LiveData<com.coui.responsiveui.config.UIConfig> getUiConfig() {
        return this.e_renamed;
    }

    public androidx.lifecycle.LiveData<com.coui.responsiveui.config.UIConfig.Status> getUiStatus() {
        return this.f_renamed;
    }

    public androidx.lifecycle.LiveData<java.lang.Integer> getUiOrientation() {
        return this.g_renamed;
    }

    public androidx.lifecycle.LiveData<com.coui.responsiveui.config.UIScreenSize> getUiScreenSize() {
        return this.h_renamed;
    }

    public androidx.lifecycle.LiveData<java.lang.Integer> getUiColumnsCount() {
        return this.i_renamed;
    }

    public int getExtendHierarchyParentWidthDp() {
        if (this.h_renamed.a_renamed().getWidthDp() >= 840) {
            return this.k_renamed.getResources().getInteger(coui.support.appcompat.R_renamed.integer.inner_responsive_ui_extend_hierarchy_parent_width_360);
        }
        if (this.h_renamed.a_renamed().getWidthDp() >= 640) {
            return this.k_renamed.getResources().getInteger(coui.support.appcompat.R_renamed.integer.inner_responsive_ui_extend_hierarchy_parent_width_300);
        }
        return this.h_renamed.a_renamed().getWidthDp();
    }

    public int getExtendHierarchyChildWidthDp() {
        return this.h_renamed.a_renamed().getWidthDp() - getExtendHierarchyParentWidthDp();
    }

    public int getExtendHierarchyParentColumnsCount() {
        return a_renamed((int) (this.i_renamed.a_renamed().intValue() * (getExtendHierarchyParentWidthDp() / this.h_renamed.a_renamed().getWidthDp())));
    }

    public int getExtendHierarchyChildColumnsCount() {
        return this.i_renamed.a_renamed().intValue() - getExtendHierarchyParentColumnsCount();
    }

    public int spanCountBaseColumns(int i_renamed, int i2) {
        return (this.i_renamed.a_renamed().intValue() / i_renamed) * (i2 >= 1 ? i2 : 1);
    }

    public int spanCountBaseColumns(int i_renamed) {
        return spanCountBaseColumns(this.j_renamed, i_renamed);
    }

    public int spanCountBaseWidth(int i_renamed) {
        return spanCountBaseWidth(360, i_renamed);
    }

    public int spanCountBaseWidth(int i_renamed, int i2) {
        if (getUiScreenSize().a_renamed().getWidthDp() >= 640 || i_renamed >= 640) {
            return (int) ((this.h_renamed.a_renamed().getWidthDp() / i_renamed) * (i2 >= 1 ? i2 : 1));
        }
        return i2;
    }

    public void onActivityConfigChanged(android.content.res.Configuration configuration) throws android.content.res.Resources.NotFoundException {
        if (a_renamed(configuration)) {
            a_renamed(this.k_renamed.getResources());
            android.util.Log.d_renamed("ResponsiveUIConfig", "onUIConfigChanged uiConfig " + this.e_renamed.a_renamed() + ", columns count " + this.i_renamed.a_renamed());
            android.util.Log.d_renamed("ResponsiveUIConfig", "onUIConfigChanged addContent [" + getExtendHierarchyParentWidthDp() + ":" + getExtendHierarchyChildWidthDp() + "] - [" + getExtendHierarchyParentColumnsCount() + ":" + getExtendHierarchyChildColumnsCount() + "]");
        }
    }

    public void flush(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        a_renamed(context);
    }

    public com.coui.responsiveui.config.UIConfig.WindowType getScreenType() {
        return this.e_renamed.a_renamed().getWindowType();
    }

    public static com.coui.responsiveui.config.ResponsiveUIConfig getDefault(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        if (f3144a == null) {
            f3144a = new com.coui.responsiveui.config.ResponsiveUIConfig(context);
        }
        int iHashCode = context.hashCode();
        if (iHashCode != f3144a.d_renamed) {
            android.util.Log.d_renamed("ResponsiveUIConfig", "getDefault context hash change from " + f3144a.d_renamed + " to " + iHashCode);
            f3144a.a_renamed(context);
        }
        return f3144a;
    }

    public static com.coui.responsiveui.config.ResponsiveUIConfig newInstance(android.content.Context context) {
        if (!f3145b && (context.getApplicationContext() instanceof android.app.Application)) {
            ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new com.coui.responsiveui.config.ResponsiveUIConfig.LifecycleCallbacks());
            f3145b = true;
        }
        int iHashCode = context.hashCode();
        if (f3146c.containsKey(java.lang.Integer.valueOf(iHashCode))) {
            android.util.Log.v_renamed("ResponsiveUIConfig", "newInstance return the kept instance " + iHashCode);
            return f3146c.get(java.lang.Integer.valueOf(iHashCode));
        }
        com.coui.responsiveui.config.ResponsiveUIConfig responsiveUIConfig = new com.coui.responsiveui.config.ResponsiveUIConfig(context);
        f3146c.put(java.lang.Integer.valueOf(iHashCode), responsiveUIConfig);
        android.util.Log.v_renamed("ResponsiveUIConfig", "newInstance return the new instance " + iHashCode + ", size " + f3146c.size());
        return responsiveUIConfig;
    }

    static class LifecycleCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }

        LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostDestroyed(android.app.Activity activity) {
            int iHashCode = activity.hashCode();
            if (com.coui.responsiveui.config.ResponsiveUIConfig.f3146c.containsKey(java.lang.Integer.valueOf(iHashCode))) {
                com.coui.responsiveui.config.ResponsiveUIConfig.f3146c.remove(java.lang.Integer.valueOf(iHashCode));
                android.util.Log.v_renamed("ResponsiveUIConfig", "newInstance remove the kept instance " + iHashCode + ", size " + com.coui.responsiveui.config.ResponsiveUIConfig.f3146c.size());
            }
        }
    }
}
