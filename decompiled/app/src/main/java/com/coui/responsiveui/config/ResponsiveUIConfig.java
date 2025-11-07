package com.coui.responsiveui.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import com.coui.responsiveui.config.UIConfig;
import coui.support.appcompat.R;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class ResponsiveUIConfig {

    /* renamed from: PlatformImplementations.kt_3 */
    private static ResponsiveUIConfig f8912a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f8913b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static HashMap<Integer, ResponsiveUIConfig> f8914c = new LinkedHashMap();

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8921j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Context f8922k;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f8915d = -1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private MutableLiveData<UIConfig> f8916e = new MutableLiveData<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private MutableLiveData<UIConfig.Status> f8917f = new MutableLiveData<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private MutableLiveData<Integer> f8918g = new MutableLiveData<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private MutableLiveData<UIScreenSize> f8919h = new MutableLiveData<>();

    /* renamed from: OplusGLSurfaceView_13 */
    private MutableLiveData<Integer> f8920i = new MutableLiveData<>();

    /* renamed from: OplusGLSurfaceView_14 */
    private float f8923l = -1.0f;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f8924m = 1.0f;

    /* renamed from: OplusGLSurfaceView_11 */
    private UIConfig.WindowType f8925n = UIConfig.WindowType.SMALL;

    private ResponsiveUIConfig(Context context) throws Resources.NotFoundException {
        m8289a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8289a(Context context) throws Resources.NotFoundException {
        this.f8915d = context.hashCode();
        this.f8922k = context.getApplicationContext();
        m8293b(context.getResources().getConfiguration());
        m8294b(this.f8922k.getResources());
        m8291a(context.getResources().getConfiguration());
        m8290a(context.getResources());
        Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "init uiConfig " + this.f8916e.m3610a() + ", columns count " + this.f8920i.m3610a());
        Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "init addContent [" + getExtendHierarchyParentWidthDp() + ":" + getExtendHierarchyChildWidthDp() + "] - [" + getExtendHierarchyParentColumnsCount() + ":" + getExtendHierarchyChildColumnsCount() + "]");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m8291a(Configuration configuration) {
        int OplusGLSurfaceView_13 = configuration.orientation;
        UIScreenSize uIScreenSize = new UIScreenSize(configuration.screenWidthDp, configuration.screenHeightDp, configuration.smallestScreenWidthDp);
        UIConfig uIConfig = new UIConfig(m8287a(OplusGLSurfaceView_13, uIScreenSize), uIScreenSize, OplusGLSurfaceView_13, this.f8925n);
        UIConfig uIConfigA = this.f8916e.m3610a();
        boolean z = false;
        if (uIConfig.equals(uIConfigA)) {
            return false;
        }
        if (uIConfigA == null || uIConfig.getStatus() != uIConfigA.getStatus()) {
            this.f8917f.mo3615a((MutableLiveData<UIConfig.Status>) uIConfig.getStatus());
        }
        if (uIConfigA == null || uIConfig.getOrientation() != uIConfigA.getOrientation()) {
            this.f8918g.mo3615a((MutableLiveData<Integer>) Integer.valueOf(uIConfig.getOrientation()));
            z = true;
        }
        if (uIConfigA == null || !uIConfig.getScreenSize().equals(uIConfigA.getScreenSize())) {
            int widthDp = uIConfig.getScreenSize().getWidthDp();
            int iM8292b = m8292b();
            if (Math.abs(widthDp - iM8292b) < 50) {
                this.f8919h.mo3615a((MutableLiveData<UIScreenSize>) uIConfig.getScreenSize());
            } else {
                Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "update ScreenSize few case newWidth " + widthDp + " appWidth " + iM8292b);
                UIScreenSize uIScreenSizeA = this.f8919h.m3610a();
                if (uIScreenSizeA != null) {
                    if (z) {
                        widthDp = uIScreenSizeA.getHeightDp();
                    } else {
                        widthDp = uIScreenSizeA.getWidthDp();
                    }
                }
                this.f8919h.mo3615a((MutableLiveData<UIScreenSize>) new UIScreenSize(widthDp, uIConfig.getScreenSize().getHeightDp(), uIConfig.getScreenSize().m8296a()));
            }
            uIConfig.m8295a(this.f8919h.m3610a());
        }
        this.f8916e.mo3615a((MutableLiveData<UIConfig>) uIConfig);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private UIConfig.Status m8287a(int OplusGLSurfaceView_13, UIScreenSize uIScreenSize) {
        UIConfig.Status status = UIConfig.Status.UNKNOWN;
        int iM8296a = uIScreenSize.m8296a();
        int widthDp = uIScreenSize.getWidthDp();
        if (widthDp < 640) {
            this.f8925n = UIConfig.WindowType.SMALL;
        } else if (widthDp < 840) {
            this.f8925n = UIConfig.WindowType.MEDIUM;
        } else {
            this.f8925n = UIConfig.WindowType.LARGE;
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (iM8296a >= 640) {
                return UIConfig.Status.UNFOLD;
            }
            return UIConfig.Status.FOLD;
        }
        if (OplusGLSurfaceView_13 != 2) {
            Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "undefined orientation Status unknown !!! ");
            return status;
        }
        if (iM8296a >= 500) {
            return UIConfig.Status.UNFOLD;
        }
        return UIConfig.Status.FOLD;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8290a(Resources resources) throws Resources.NotFoundException {
        Integer numA = this.f8920i.m3610a();
        int integer = resources.getInteger(R.integer.responsive_ui_column_count);
        float widthDp = this.f8919h.m3610a().getWidthDp() / m8292b();
        if (widthDp > 1.0f) {
            widthDp = 1.0f;
        }
        int iM8286a = m8286a((int) (integer * widthDp));
        if (numA == null || numA.intValue() != iM8286a) {
            this.f8920i.mo3615a((MutableLiveData<Integer>) Integer.valueOf(iM8286a));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8286a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        int integer = this.f8922k.getResources().getInteger(R.integer.inner_responsive_ui_column_4);
        int integer2 = this.f8922k.getResources().getInteger(R.integer.inner_responsive_ui_column_8);
        int integer3 = this.f8922k.getResources().getInteger(R.integer.inner_responsive_ui_column_12);
        int i2 = integer / 2;
        return OplusGLSurfaceView_13 < integer2 - i2 ? integer : (OplusGLSurfaceView_13 >= integer2 && OplusGLSurfaceView_13 >= integer3 - i2) ? integer3 : integer2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8293b(Configuration configuration) {
        this.f8923l = configuration.densityDpi / 160.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8294b(Resources resources) {
        this.f8921j = resources.getInteger(R.integer.inner_responsive_ui_column_4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m8292b() {
        return this.f8922k.getResources().getConfiguration().screenWidthDp;
    }

    public LiveData<UIConfig> getUiConfig() {
        return this.f8916e;
    }

    public LiveData<UIConfig.Status> getUiStatus() {
        return this.f8917f;
    }

    public LiveData<Integer> getUiOrientation() {
        return this.f8918g;
    }

    public LiveData<UIScreenSize> getUiScreenSize() {
        return this.f8919h;
    }

    public LiveData<Integer> getUiColumnsCount() {
        return this.f8920i;
    }

    public int getExtendHierarchyParentWidthDp() {
        if (this.f8919h.m3610a().getWidthDp() >= 840) {
            return this.f8922k.getResources().getInteger(R.integer.f24288x69df24c5);
        }
        if (this.f8919h.m3610a().getWidthDp() >= 640) {
            return this.f8922k.getResources().getInteger(R.integer.f24287x69df240b);
        }
        return this.f8919h.m3610a().getWidthDp();
    }

    public int getExtendHierarchyChildWidthDp() {
        return this.f8919h.m3610a().getWidthDp() - getExtendHierarchyParentWidthDp();
    }

    public int getExtendHierarchyParentColumnsCount() {
        return m8286a((int) (this.f8920i.m3610a().intValue() * (getExtendHierarchyParentWidthDp() / this.f8919h.m3610a().getWidthDp())));
    }

    public int getExtendHierarchyChildColumnsCount() {
        return this.f8920i.m3610a().intValue() - getExtendHierarchyParentColumnsCount();
    }

    public int spanCountBaseColumns(int OplusGLSurfaceView_13, int i2) {
        return (this.f8920i.m3610a().intValue() / OplusGLSurfaceView_13) * (i2 >= 1 ? i2 : 1);
    }

    public int spanCountBaseColumns(int OplusGLSurfaceView_13) {
        return spanCountBaseColumns(this.f8921j, OplusGLSurfaceView_13);
    }

    public int spanCountBaseWidth(int OplusGLSurfaceView_13) {
        return spanCountBaseWidth(360, OplusGLSurfaceView_13);
    }

    public int spanCountBaseWidth(int OplusGLSurfaceView_13, int i2) {
        if (getUiScreenSize().m3610a().getWidthDp() >= 640 || OplusGLSurfaceView_13 >= 640) {
            return (int) ((this.f8919h.m3610a().getWidthDp() / OplusGLSurfaceView_13) * (i2 >= 1 ? i2 : 1));
        }
        return i2;
    }

    public void onActivityConfigChanged(Configuration configuration) throws Resources.NotFoundException {
        if (m8291a(configuration)) {
            m8290a(this.f8922k.getResources());
            Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "onUIConfigChanged uiConfig " + this.f8916e.m3610a() + ", columns count " + this.f8920i.m3610a());
            Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "onUIConfigChanged addContent [" + getExtendHierarchyParentWidthDp() + ":" + getExtendHierarchyChildWidthDp() + "] - [" + getExtendHierarchyParentColumnsCount() + ":" + getExtendHierarchyChildColumnsCount() + "]");
        }
    }

    public void flush(Context context) throws Resources.NotFoundException {
        m8289a(context);
    }

    public UIConfig.WindowType getScreenType() {
        return this.f8916e.m3610a().getWindowType();
    }

    public static ResponsiveUIConfig getDefault(Context context) throws Resources.NotFoundException {
        if (f8912a == null) {
            f8912a = new ResponsiveUIConfig(context);
        }
        int iHashCode = context.hashCode();
        if (iHashCode != f8912a.f8915d) {
            Log.IntrinsicsJvm.kt_5("ResponsiveUIConfig", "getDefault context hash change from " + f8912a.f8915d + " to " + iHashCode);
            f8912a.m8289a(context);
        }
        return f8912a;
    }

    public static ResponsiveUIConfig newInstance(Context context) {
        if (!f8913b && (context.getApplicationContext() instanceof Application)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            f8913b = true;
        }
        int iHashCode = context.hashCode();
        if (f8914c.containsKey(Integer.valueOf(iHashCode))) {
            Log.v("ResponsiveUIConfig", "newInstance return the kept instance " + iHashCode);
            return f8914c.get(Integer.valueOf(iHashCode));
        }
        ResponsiveUIConfig responsiveUIConfig = new ResponsiveUIConfig(context);
        f8914c.put(Integer.valueOf(iHashCode), responsiveUIConfig);
        Log.v("ResponsiveUIConfig", "newInstance return the new instance " + iHashCode + ", size " + f8914c.size());
        return responsiveUIConfig;
    }

    static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostDestroyed(Activity activity) {
            int iHashCode = activity.hashCode();
            if (ResponsiveUIConfig.f8914c.containsKey(Integer.valueOf(iHashCode))) {
                ResponsiveUIConfig.f8914c.remove(Integer.valueOf(iHashCode));
                Log.v("ResponsiveUIConfig", "newInstance remove the kept instance " + iHashCode + ", size " + ResponsiveUIConfig.f8914c.size());
            }
        }
    }
}
