package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* compiled from: ContextThemeWrapper.java */
/* renamed from: androidx.appcompat.view.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f1170a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Resources.Theme f1171b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LayoutInflater f1172c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Configuration f1173d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Resources f1174e;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.f1170a = OplusGLSurfaceView_13;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f1171b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m1060a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Resources m1060a() {
        if (this.f1174e == null) {
            if (this.f1173d == null) {
                this.f1174e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f1174e = createConfigurationContext(this.f1173d).getResources();
            }
        }
        return this.f1174e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int OplusGLSurfaceView_13) {
        if (this.f1170a != OplusGLSurfaceView_13) {
            this.f1170a = OplusGLSurfaceView_13;
            m1061b();
        }
    }

    public int getThemeResId() {
        return this.f1170a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1171b;
        if (theme != null) {
            return theme;
        }
        if (this.f1170a == 0) {
            this.f1170a = R.style.Theme_AppCompat_Light;
        }
        m1061b();
        return this.f1171b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f1172c == null) {
                this.f1172c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f1172c;
        }
        return getBaseContext().getSystemService(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m1062a(Resources.Theme theme, int OplusGLSurfaceView_13, boolean z) {
        theme.applyStyle(OplusGLSurfaceView_13, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1061b() {
        boolean z = this.f1171b == null;
        if (z) {
            this.f1171b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1171b.setTo(theme);
            }
        }
        m1062a(this.f1171b, this.f1170a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
