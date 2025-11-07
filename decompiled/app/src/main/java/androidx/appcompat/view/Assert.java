package androidx.appcompat.view;

/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f321a;

    public static androidx.appcompat.view.a_renamed a_renamed(android.content.Context context) {
        return new androidx.appcompat.view.a_renamed(context);
    }

    private a_renamed(android.content.Context context) {
        this.f321a = context;
    }

    public int a_renamed() {
        android.content.res.Configuration configuration = this.f321a.getResources().getConfiguration();
        int i_renamed = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i_renamed > 600) {
            return 5;
        }
        if (i_renamed > 960 && i2 > 720) {
            return 5;
        }
        if (i_renamed > 720 && i2 > 960) {
            return 5;
        }
        if (i_renamed >= 500) {
            return 4;
        }
        if (i_renamed > 640 && i2 > 480) {
            return 4;
        }
        if (i_renamed <= 480 || i2 <= 640) {
            return i_renamed >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean b_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !android.view.ViewConfiguration.get(this.f321a).hasPermanentMenuKey();
    }

    public int c_renamed() {
        return this.f321a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d_renamed() {
        return this.f321a.getResources().getBoolean(androidx.appcompat.R_renamed.bool.abc_action_bar_embed_tabs);
    }

    public int e_renamed() {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.f321a.obtainStyledAttributes(null, androidx.appcompat.R_renamed.styleable.ActionBar, androidx.appcompat.R_renamed.attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(androidx.appcompat.R_renamed.styleable.ActionBar_height, 0);
        android.content.res.Resources resources = this.f321a.getResources();
        if (!d_renamed()) {
            layoutDimension = java.lang.Math.min(layoutDimension, resources.getDimensionPixelSize(androidx.appcompat.R_renamed.dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f_renamed() {
        return this.f321a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g_renamed() {
        return this.f321a.getResources().getDimensionPixelSize(androidx.appcompat.R_renamed.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
