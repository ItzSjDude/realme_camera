package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.R;

/* compiled from: ActionBarPolicy.java */
/* renamed from: androidx.appcompat.view.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class ActionBarPolicy {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f1167a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static ActionBarPolicy m1047a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f1167a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1048a() {
        Configuration configuration = this.f1167a.getResources().getConfiguration();
        int OplusGLSurfaceView_13 = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || OplusGLSurfaceView_13 > 600) {
            return 5;
        }
        if (OplusGLSurfaceView_13 > 960 && i2 > 720) {
            return 5;
        }
        if (OplusGLSurfaceView_13 > 720 && i2 > 960) {
            return 5;
        }
        if (OplusGLSurfaceView_13 >= 500) {
            return 4;
        }
        if (OplusGLSurfaceView_13 > 640 && i2 > 480) {
            return 4;
        }
        if (OplusGLSurfaceView_13 <= 480 || i2 <= 640) {
            return OplusGLSurfaceView_13 >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m1049b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f1167a).hasPermanentMenuKey();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m1050c() {
        return this.f1167a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m1051d() {
        return this.f1167a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m1052e() {
        TypedArray typedArrayObtainStyledAttributes = this.f1167a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f1167a.getResources();
        if (!m1051d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m1053f() {
        return this.f1167a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m1054g() {
        return this.f1167a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
