package androidx.appcompat.view;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d_renamed extends android.content.ContextWrapper {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f324a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.res.Resources.Theme f325b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.LayoutInflater f326c;
    private android.content.res.Configuration d_renamed;
    private android.content.res.Resources e_renamed;

    public d_renamed() {
        super(null);
    }

    public d_renamed(android.content.Context context, int i_renamed) {
        super(context);
        this.f324a = i_renamed;
    }

    public d_renamed(android.content.Context context, android.content.res.Resources.Theme theme) {
        super(context);
        this.f325b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return a_renamed();
    }

    private android.content.res.Resources a_renamed() {
        if (this.e_renamed == null) {
            if (this.d_renamed == null) {
                this.e_renamed = super.getResources();
            } else if (android.os.Build.VERSION.SDK_INT >= 17) {
                this.e_renamed = createConfigurationContext(this.d_renamed).getResources();
            }
        }
        return this.e_renamed;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i_renamed) {
        if (this.f324a != i_renamed) {
            this.f324a = i_renamed;
            b_renamed();
        }
    }

    public int getThemeResId() {
        return this.f324a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources.Theme getTheme() {
        android.content.res.Resources.Theme theme = this.f325b;
        if (theme != null) {
            return theme;
        }
        if (this.f324a == 0) {
            this.f324a = androidx.appcompat.R_renamed.style.Theme_AppCompat_Light;
        }
        b_renamed();
        return this.f325b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f326c == null) {
                this.f326c = android.view.LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f326c;
        }
        return getBaseContext().getSystemService(str);
    }

    protected void a_renamed(android.content.res.Resources.Theme theme, int i_renamed, boolean z_renamed) {
        theme.applyStyle(i_renamed, true);
    }

    private void b_renamed() {
        boolean z_renamed = this.f325b == null;
        if (z_renamed) {
            this.f325b = getResources().newTheme();
            android.content.res.Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f325b.setTo(theme);
            }
        }
        a_renamed(this.f325b, this.f324a, z_renamed);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return getResources().getAssets();
    }
}
