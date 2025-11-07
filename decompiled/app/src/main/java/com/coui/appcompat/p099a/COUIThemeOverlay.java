package com.coui.appcompat.p099a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.OplusBaseConfiguration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.oplus.theme.OplusThemeUtil;
import coui.support.appcompat.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import oplus.content.res.OplusExtraConfiguration;

/* compiled from: COUIThemeOverlay.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.t */
/* loaded from: classes.dex */
public class COUIThemeOverlay {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile COUIThemeOverlay f6349a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static String f6350d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SparseIntArray f6351b = new SparseIntArray();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private HashMap<String, WeakReference<Boolean>> f6352c = new HashMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUIThemeOverlay m6468a() {
        if (f6349a == null) {
            synchronized (COUIThemeOverlay.class) {
                if (f6349a == null) {
                    f6349a = new COUIThemeOverlay();
                }
            }
        }
        return f6349a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6479a(Context context) throws Resources.NotFoundException, ClassNotFoundException {
        m6480b();
        m6472d(context);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f6351b.size(); OplusGLSurfaceView_13++) {
            context.setTheme(this.f6351b.valueAt(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6481b(Context context) throws ClassNotFoundException {
        long jM6477a = m6477a(context.getResources().getConfiguration());
        return jM6477a > 0 && (jM6477a & 2097151) != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6478a(int OplusGLSurfaceView_13, int i2) {
        this.f6351b.put(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6480b() {
        this.f6351b.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m6482c(Context context) throws ClassNotFoundException {
        Class<?> cls;
        long jLongValue;
        boolean zM6476f;
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null || !m6473d()) {
            return false;
        }
        OplusExtraConfiguration oplusExtraConfigurationM6470b = m6470b(context.getResources().getConfiguration());
        if (oplusExtraConfigurationM6470b != null) {
            jLongValue = oplusExtraConfigurationM6470b.mThemeChangedFlags;
        } else {
            f6350d = m6471c() ? "com.oplus.inner.content.res.ConfigurationWrapper" : COUICompatUtil.m6393a().m6397e();
            try {
                cls = Class.forName(f6350d);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUILog.m6428a("COUIThemeOverlay", "isRejectTheme COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
            }
            jLongValue = cls.newInstance() != null ? ((Long) cls.getMethod("getThemeChangedFlags", Configuration.class).invoke(null, configuration)).longValue() : 0L;
        }
        if ((1 & jLongValue) == 0) {
            zM6476f = false;
        } else if ((jLongValue & 256) != 0) {
            zM6476f = m6475e(context);
        } else {
            zM6476f = m6476f(context);
        }
        return zM6476f && (configuration.uiMode & 48) != 32;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6472d(Context context) throws Resources.NotFoundException, ClassNotFoundException {
        int OplusGLSurfaceView_13;
        if (context == null) {
            return;
        }
        long jM6477a = m6477a(context.getResources().getConfiguration());
        int i2 = (int) (65535 & jM6477a);
        int i3 = (int) (196608 & jM6477a);
        if (jM6477a != 0) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            int integer = context.getTheme().obtainStyledAttributes(new int[]{R.attr.couiThemeIdentifier}).getInteger(0, 0);
            if (m6482c(context)) {
                return;
            }
            if (i3 == 131072) {
                m6478a(R.id_renamed.coui_global_theme, R.style.SupportOverlay_Theme_Single_First);
                return;
            }
            if (i3 == 0) {
                int iM6467a = m6467a(i2);
                i2 = integer - 1;
                OplusGLSurfaceView_13 = iM6467a;
            } else if (i3 == 65536) {
                OplusGLSurfaceView_13 = R.array.coui_theme_arrays_single;
            } else {
                i2 = -1;
                OplusGLSurfaceView_13 = 0;
            }
            if (OplusGLSurfaceView_13 == 0 || i2 == -1) {
                return;
            }
            TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(OplusGLSurfaceView_13);
            for (int i4 = 0; i4 < typedArrayObtainTypedArray.length(); i4++) {
                if (i4 == i2) {
                    m6478a(R.id_renamed.coui_global_theme, typedArrayObtainTypedArray.getResourceId(i4, 0));
                    return;
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m6477a(Configuration configuration) throws ClassNotFoundException {
        if (!m6473d()) {
            return 0L;
        }
        OplusExtraConfiguration oplusExtraConfigurationM6470b = m6470b(configuration);
        if (oplusExtraConfigurationM6470b != null) {
            return oplusExtraConfigurationM6470b.mMaterialColor;
        }
        f6350d = m6471c() ? "com.oplus.inner.content.res.ConfigurationWrapper" : COUICompatUtil.m6393a().m6397e();
        try {
            Class<?> cls = Class.forName(f6350d);
            if (cls.newInstance() != null) {
                return ((Long) cls.getMethod("getMaterialColor", Configuration.class).invoke(null, configuration)).longValue();
            }
            return 0L;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUILog.m6428a("COUIThemeOverlay", "getCOUITheme COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
            return 0L;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m6471c() throws ClassNotFoundException {
        try {
            Class.forName("com.oplus.inner.content.res.ConfigurationWrapper");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m6473d() throws ClassNotFoundException {
        try {
            Class.forName("android.content.res.OplusBaseConfiguration");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OplusExtraConfiguration m6470b(Configuration configuration) {
        OplusBaseConfiguration oplusBaseConfiguration = (OplusBaseConfiguration) m6469a(OplusBaseConfiguration.class, configuration);
        if (oplusBaseConfiguration == null) {
            return null;
        }
        return oplusBaseConfiguration.mOplusExtraConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private <T> T m6469a(Class<T> cls, Object obj) {
        if (obj == 0 || !cls.isInstance(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m6467a(int OplusGLSurfaceView_13) {
        int i2;
        boolean z = m6474e() < 12000;
        if (OplusGLSurfaceView_13 == 1) {
            i2 = z ? R.array.coui_theme_arrays_first_compat : R.array.coui_theme_arrays_first;
        } else if (OplusGLSurfaceView_13 == 2) {
            i2 = z ? R.array.coui_theme_arrays_second_compat : R.array.coui_theme_arrays_second;
        } else if (OplusGLSurfaceView_13 == 3) {
            i2 = z ? R.array.coui_theme_arrays_third_compat : R.array.coui_theme_arrays_third;
        } else {
            if (OplusGLSurfaceView_13 != 4) {
                return 0;
            }
            i2 = z ? R.array.coui_theme_arrays_fourth_compat : R.array.coui_theme_arrays_fourth;
        }
        return i2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m6474e() throws NoSuchMethodException, SecurityException {
        int OplusGLSurfaceView_13;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String str = (String) method.invoke(null, "ro.oplus.theme.version");
            OplusGLSurfaceView_13 = !TextUtils.isEmpty(str) ? Integer.parseInt(str.trim()) : 0;
            if (OplusGLSurfaceView_13 != 0) {
                return OplusGLSurfaceView_13;
            }
            try {
                String str2 = (String) method.invoke(null, COUICompatUtil.m6393a().m6398f());
                return !TextUtils.isEmpty(str2) ? Integer.parseInt(str2.trim()) : OplusGLSurfaceView_13;
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                COUILog.m6428a("COUIThemeOverlay", "getCompatVersion COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
                return OplusGLSurfaceView_13;
            }
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            OplusGLSurfaceView_13 = 0;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m6475e(Context context) {
        File file = new File(OplusThemeUtil.CUSTOM_THEME_PATH);
        if (!file.exists()) {
            return false;
        }
        if (new File(file, context.getPackageName()).exists()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return false;
        }
        String string = Settings.System.getString(context.getContentResolver(), "custom_theme_path_setting");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return new File(string, context.getPackageName()).exists();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m6476f(Context context) {
        OplusExtraConfiguration oplusExtraConfigurationM6470b = m6470b(context.getResources().getConfiguration());
        int OplusGLSurfaceView_13 = oplusExtraConfigurationM6470b != null ? oplusExtraConfigurationM6470b.mUserId : 0;
        String str = "/data/theme/";
        if (OplusGLSurfaceView_13 > 0) {
            str = "/data/theme/" + OplusGLSurfaceView_13;
        }
        return new File(str, context.getPackageName()).exists();
    }
}
