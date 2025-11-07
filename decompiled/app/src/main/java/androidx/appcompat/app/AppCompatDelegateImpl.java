package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils_2;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.p036h.ViewPropertyAnimatorListenerAdapter;
import androidx.core.p036h.WindowInsetsCompat;
import androidx.core.p036h.KeyEventDispatcher;
import androidx.core.p036h.LayoutInflaterCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import androidx.core.p036h.ViewPropertyAnimatorListener;
import androidx.core.p036h.OnApplyWindowInsetsListener;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class AppCompatDelegateImpl extends AppCompatDelegate implements LayoutInflater.Factory2, MenuBuilder.PlatformImplementations.kt_3 {

    /* renamed from: t */
    private static final Map<Class<?>, Integer> f906t = new ArrayMap();

    /* renamed from: u */
    private static final boolean f907u;

    /* renamed from: v */
    private static final int[] f908v;

    /* renamed from: w */
    private static boolean f909w;

    /* renamed from: x */
    private static final boolean f910x;

    /* renamed from: A */
    private DecorContentParent f911A;

    /* renamed from: B */
    private C0194a f912B;

    /* renamed from: C */
    private C0201h f913C;

    /* renamed from: D */
    private boolean f914D;

    /* renamed from: E */
    private boolean f915E;

    /* renamed from: F */
    private ViewGroup f916F;

    /* renamed from: G */
    private TextView f917G;

    /* renamed from: H */
    private View f918H;

    /* renamed from: I */
    private boolean f919I;

    /* renamed from: J */
    private boolean f920J;

    /* renamed from: K */
    private boolean f921K;

    /* renamed from: L */
    private PanelFeatureState[] f922L;

    /* renamed from: M */
    private PanelFeatureState f923M;

    /* renamed from: N */
    private boolean f924N;

    /* renamed from: O */
    private boolean f925O;

    /* renamed from: P */
    private boolean f926P;

    /* renamed from: Q */
    private boolean f927Q;

    /* renamed from: R */
    private int f928R;

    /* renamed from: S */
    private int f929S;

    /* renamed from: T */
    private boolean f930T;

    /* renamed from: U */
    private boolean f931U;

    /* renamed from: V */
    private AbstractC0198e f932V;

    /* renamed from: W */
    private AbstractC0198e f933W;

    /* renamed from: X */
    private final Runnable f934X;

    /* renamed from: Y */
    private boolean f935Y;

    /* renamed from: Z */
    private Rect f936Z;

    /* renamed from: PlatformImplementations.kt_3 */
    final Object f937a;

    /* renamed from: aa */
    private Rect f938aa;

    /* renamed from: ab */
    private AppCompatViewInflater f939ab;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Context f940b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Window f941c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final AppCompatCallback f942d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    ActionBar f943e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    MenuInflater f944f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    ActionMode f945g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    ActionBarContextView f946h;

    /* renamed from: OplusGLSurfaceView_13 */
    PopupWindow f947i;

    /* renamed from: OplusGLSurfaceView_15 */
    Runnable f948j;

    /* renamed from: OplusGLSurfaceView_5 */
    ViewPropertyAnimatorCompat f949k;

    /* renamed from: OplusGLSurfaceView_14 */
    boolean f950l;

    /* renamed from: OplusGLSurfaceView_6 */
    boolean f951m;

    /* renamed from: OplusGLSurfaceView_11 */
    boolean f952n;

    /* renamed from: o */
    boolean f953o;

    /* renamed from: p */
    boolean f954p;

    /* renamed from: q */
    boolean f955q;

    /* renamed from: r */
    boolean f956r;

    /* renamed from: s */
    int f957s;

    /* renamed from: y */
    private C0196c f958y;

    /* renamed from: z */
    private CharSequence f959z;

    /* renamed from: PlatformImplementations.kt_3 */
    void m807a(ViewGroup viewGroup) {
    }

    static {
        boolean z = false;
        f907u = Build.VERSION.SDK_INT < 21;
        f908v = new int[]{R.attr.windowBackground};
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25) {
            z = true;
        }
        f910x = z;
        if (!f907u || f909w) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (m848a(th)) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is PlatformImplementations.kt_3 vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            /* renamed from: PlatformImplementations.kt_3 */
            private boolean m848a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        f909w = true;
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback interfaceC0206d) {
        this(activity, null, interfaceC0206d, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback interfaceC0206d) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0206d, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback interfaceC0206d, Object obj) {
        Integer num;
        AppCompatActivity activityC0205cM769B;
        this.f949k = null;
        this.f914D = true;
        this.f928R = -100;
        this.f934X = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImpl.this.f957s & 1) != 0) {
                    AppCompatDelegateImpl.this.m833h(0);
                }
                if ((AppCompatDelegateImpl.this.f957s & 4096) != 0) {
                    AppCompatDelegateImpl.this.m833h(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.f956r = false;
                appCompatDelegateImpl.f957s = 0;
            }
        };
        this.f940b = context;
        this.f942d = interfaceC0206d;
        this.f937a = obj;
        if (this.f928R == -100 && (this.f937a instanceof Dialog) && (activityC0205cM769B = m769B()) != null) {
            this.f928R = activityC0205cM769B.m917h().mo834i();
        }
        if (this.f928R == -100 && (num = f906t.get(this.f937a.getClass())) != null) {
            this.f928R = num.intValue();
            f906t.remove(this.f937a.getClass());
        }
        if (window != null) {
            m774a(window);
        }
        AppCompatDrawableManager.m1664a();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo802a(Context context) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException {
        m780a(false);
        this.f925O = true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo804a(Bundle bundle) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException {
        this.f925O = true;
        m780a(false);
        m792x();
        Object obj = this.f937a;
        if (obj instanceof Activity) {
            String strM2373b = null;
            try {
                strM2373b = NavUtils.m2373b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strM2373b != null) {
                ActionBar abstractC0203aM837k = m837k();
                if (abstractC0203aM837k == null) {
                    this.f935Y = true;
                } else {
                    abstractC0203aM837k.mo887d(true);
                }
            }
        }
        this.f926P = true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo817b(Bundle bundle) {
        m793y();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public ActionBar mo798a() {
        m790v();
        return this.f943e;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    final ActionBar m837k() {
        return this.f943e;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    final Window.Callback m838l() {
        return this.f941c.getCallback();
    }

    /* renamed from: v */
    private void m790v() {
        m793y();
        if (this.f950l && this.f943e == null) {
            Object obj = this.f937a;
            if (obj instanceof Activity) {
                this.f943e = new WindowDecorActionBar((Activity) obj, this.f951m);
            } else if (obj instanceof Dialog) {
                this.f943e = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar abstractC0203a = this.f943e;
            if (abstractC0203a != null) {
                abstractC0203a.mo887d(this.f935Y);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo810a(Toolbar toolbar) {
        if (this.f937a instanceof Activity) {
            ActionBar abstractC0203aMo798a = mo798a();
            if (abstractC0203aMo798a instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use PlatformImplementations.kt_3 Toolbar instead.");
            }
            this.f944f = null;
            if (abstractC0203aMo798a != null) {
                abstractC0203aMo798a.mo893g();
            }
            if (toolbar != null) {
                ToolbarActionBar c0211i = new ToolbarActionBar(toolbar, m840n(), this.f958y);
                this.f943e = c0211i;
                this.f941c.setCallback(c0211i.m933h());
            } else {
                this.f943e = null;
                this.f941c.setCallback(this.f958y);
            }
            mo828f();
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    final Context m839m() {
        ActionBar abstractC0203aMo798a = mo798a();
        Context contextMo883b = abstractC0203aMo798a != null ? abstractC0203aMo798a.mo883b() : null;
        return contextMo883b == null ? this.f940b : contextMo883b;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_4 */
    public MenuInflater mo814b() {
        if (this.f944f == null) {
            m790v();
            ActionBar abstractC0203a = this.f943e;
            this.f944f = new SupportMenuInflater(abstractC0203a != null ? abstractC0203a.mo883b() : this.f940b);
        }
        return this.f944f;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_4 */
    public <T extends View> T mo815b(int OplusGLSurfaceView_13) {
        m793y();
        return (T) this.f941c.findViewById(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo803a(Configuration configuration) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException {
        ActionBar abstractC0203aMo798a;
        if (this.f950l && this.f915E && (abstractC0203aMo798a = mo798a()) != null) {
            abstractC0203aMo798a.mo878a(configuration);
        }
        AppCompatDrawableManager.m1666b().m1670a(this.f940b);
        m780a(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo820c() {
        this.f927Q = true;
        m846t();
        m921a(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo824d() {
        this.f927Q = false;
        m922b(this);
        ActionBar abstractC0203aMo798a = mo798a();
        if (abstractC0203aMo798a != null) {
            abstractC0203aMo798a.mo889e(false);
        }
        if (this.f937a instanceof Dialog) {
            m791w();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo826e() {
        ActionBar abstractC0203aMo798a = mo798a();
        if (abstractC0203aMo798a != null) {
            abstractC0203aMo798a.mo889e(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo805a(View view) {
        m793y();
        ViewGroup viewGroup = (ViewGroup) this.f916F.findViewById(R.id_renamed.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f958y.m1086a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo821c(int OplusGLSurfaceView_13) {
        m793y();
        ViewGroup viewGroup = (ViewGroup) this.f916F.findViewById(R.id_renamed.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f940b).inflate(OplusGLSurfaceView_13, viewGroup);
        this.f958y.m1086a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo806a(View view, ViewGroup.LayoutParams layoutParams) {
        m793y();
        ViewGroup viewGroup = (ViewGroup) this.f916F.findViewById(R.id_renamed.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f958y.m1086a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo818b(View view, ViewGroup.LayoutParams layoutParams) {
        m793y();
        ((ViewGroup) this.f916F.findViewById(R.id_renamed.content)).addView(view, layoutParams);
        this.f958y.m1086a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo822c(Bundle bundle) {
        if (this.f928R != -100) {
            f906t.put(this.f937a.getClass(), Integer.valueOf(this.f928R));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo830g() {
        m922b(this);
        if (this.f956r) {
            this.f941c.getDecorView().removeCallbacks(this.f934X);
        }
        this.f927Q = false;
        this.f955q = true;
        ActionBar abstractC0203a = this.f943e;
        if (abstractC0203a != null) {
            abstractC0203a.mo893g();
        }
        m791w();
    }

    /* renamed from: w */
    private void m791w() {
        AbstractC0198e abstractC0198e = this.f932V;
        if (abstractC0198e != null) {
            abstractC0198e.m872e();
        }
        AbstractC0198e abstractC0198e2 = this.f933W;
        if (abstractC0198e2 != null) {
            abstractC0198e2.m872e();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo800a(int OplusGLSurfaceView_13) {
        this.f929S = OplusGLSurfaceView_13;
    }

    /* renamed from: x */
    private void m792x() {
        if (this.f941c == null) {
            Object obj = this.f937a;
            if (obj instanceof Activity) {
                m774a(((Activity) obj).getWindow());
            }
        }
        if (this.f941c == null) {
            throw new IllegalStateException("We have not been given PlatformImplementations.kt_3 Window");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m774a(Window window) {
        if (this.f941c != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof C0196c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f958y = new C0196c(callback);
        window.setCallback(this.f958y);
        TintTypedArray c0322arM1540a = TintTypedArray.m1540a(this.f940b, (AttributeSet) null, f908v);
        Drawable drawableM1550b = c0322arM1540a.m1550b(0);
        if (drawableM1550b != null) {
            window.setBackgroundDrawable(drawableM1550b);
        }
        c0322arM1540a.m1551b();
        this.f941c = window;
    }

    /* renamed from: y */
    private void m793y() {
        if (this.f915E) {
            return;
        }
        this.f916F = m794z();
        CharSequence charSequenceM840n = m840n();
        if (!TextUtils.isEmpty(charSequenceM840n)) {
            DecorContentParent interfaceC0353y = this.f911A;
            if (interfaceC0353y != null) {
                interfaceC0353y.setWindowTitle(charSequenceM840n);
            } else if (m837k() != null) {
                m837k().mo879a(charSequenceM840n);
            } else {
                TextView textView = this.f917G;
                if (textView != null) {
                    textView.setText(charSequenceM840n);
                }
            }
        }
        m768A();
        m807a(this.f916F);
        this.f915E = true;
        PanelFeatureState panelFeatureStateM796a = m796a(0, false);
        if (this.f955q) {
            return;
        }
        if (panelFeatureStateM796a == null || panelFeatureStateM796a.f977j == null) {
            m788k(108);
        }
    }

    /* renamed from: z */
    private ViewGroup m794z() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        Context c0223d;
        TypedArray typedArrayObtainStyledAttributes = this.f940b.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use PlatformImplementations.kt_3 Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            mo825d(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            mo825d(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            mo825d(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            mo825d(10);
        }
        this.f953o = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        m792x();
        this.f941c.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f940b);
        if (!this.f954p) {
            if (this.f953o) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f951m = false;
                this.f950l = false;
            } else if (this.f950l) {
                TypedValue typedValue = new TypedValue();
                this.f940b.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c0223d = new ContextThemeWrapper(this.f940b, typedValue.resourceId);
                } else {
                    c0223d = this.f940b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(c0223d).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.f911A = (DecorContentParent) viewGroup.findViewById(androidx.appcompat.R.id_renamed.decor_content_parent);
                this.f911A.setWindowCallback(m838l());
                if (this.f951m) {
                    this.f911A.mo1233a(109);
                }
                if (this.f919I) {
                    this.f911A.mo1233a(2);
                }
                if (this.f920J) {
                    this.f911A.mo1233a(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            if (this.f952n) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.m2855a(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                    @Override // androidx.core.p036h.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat c0490ad) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        int iM2761b = c0490ad.m2761b();
                        int iM835i = AppCompatDelegateImpl.this.m835i(iM2761b);
                        if (iM2761b != iM835i) {
                            c0490ad = c0490ad.m2760a(c0490ad.m2759a(), iM835i, c0490ad.m2762c(), c0490ad.m2763d());
                        }
                        return ViewCompat.m2839a(view, c0490ad);
                    }
                });
            } else {
                ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.PlatformImplementations.kt_3() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                    @Override // androidx.appcompat.widget.FitWindowsViewGroup.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo849a(Rect rect) {
                        rect.top = AppCompatDelegateImpl.this.m835i(rect.top);
                    }
                });
            }
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f950l + ", windowActionBarOverlay: " + this.f951m + ", android:windowIsFloating: " + this.f953o + ", windowActionModeOverlay: " + this.f952n + ", windowNoTitle: " + this.f954p + " }");
        }
        if (this.f911A == null) {
            this.f917G = (TextView) viewGroup.findViewById(androidx.appcompat.R.id_renamed.title);
        }
        ViewUtils_2.m1624b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id_renamed.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f941c.findViewById(R.id_renamed.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id_renamed.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f941c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.InterfaceC0276a() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.InterfaceC0276a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo850a() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.InterfaceC0276a
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo851b() {
                AppCompatDelegateImpl.this.m845s();
            }
        });
        return viewGroup;
    }

    /* renamed from: A */
    private void m768A() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f916F.findViewById(R.id_renamed.content);
        View decorView = this.f941c.getDecorView();
        contentFrameLayout.m1326a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f940b.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo825d(int OplusGLSurfaceView_13) {
        int iM789l = m789l(OplusGLSurfaceView_13);
        if (this.f954p && iM789l == 108) {
            return false;
        }
        if (this.f950l && iM789l == 1) {
            this.f950l = false;
        }
        if (iM789l == 1) {
            m770C();
            this.f954p = true;
            return true;
        }
        if (iM789l == 2) {
            m770C();
            this.f919I = true;
            return true;
        }
        if (iM789l == 5) {
            m770C();
            this.f920J = true;
            return true;
        }
        if (iM789l == 10) {
            m770C();
            this.f952n = true;
            return true;
        }
        if (iM789l == 108) {
            m770C();
            this.f950l = true;
            return true;
        }
        if (iM789l == 109) {
            m770C();
            this.f951m = true;
            return true;
        }
        return this.f941c.requestFeature(iM789l);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo811a(CharSequence charSequence) {
        this.f959z = charSequence;
        DecorContentParent interfaceC0353y = this.f911A;
        if (interfaceC0353y != null) {
            interfaceC0353y.setWindowTitle(charSequence);
            return;
        }
        if (m837k() != null) {
            m837k().mo879a(charSequence);
            return;
        }
        TextView textView = this.f917G;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    final CharSequence m840n() {
        Object obj = this.f937a;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f959z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m827e(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 108) {
            ActionBar abstractC0203aMo798a = mo798a();
            if (abstractC0203aMo798a != null) {
                abstractC0203aMo798a.mo891f(false);
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            PanelFeatureState panelFeatureStateM796a = m796a(OplusGLSurfaceView_13, true);
            if (panelFeatureStateM796a.f982o) {
                m808a(panelFeatureStateM796a, false);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    void m829f(int OplusGLSurfaceView_13) {
        ActionBar abstractC0203aMo798a;
        if (OplusGLSurfaceView_13 != 108 || (abstractC0203aMo798a = mo798a()) == null) {
            return;
        }
        abstractC0203aMo798a.mo891f(true);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
    public boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateM797a;
        Window.Callback callbackM838l = m838l();
        if (callbackM838l == null || this.f955q || (panelFeatureStateM797a = m797a((Menu) c0236h.getRootMenu())) == null) {
            return false;
        }
        return callbackM838l.onMenuItemSelected(panelFeatureStateM797a.f968a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
    public void onMenuModeChange(MenuBuilder c0236h) {
        m776a(c0236h, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ActionMode m799a(ActionMode.PlatformImplementations.kt_3 aVar) {
        AppCompatCallback interfaceC0206d;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        ActionMode abstractC0221b = this.f945g;
        if (abstractC0221b != null) {
            abstractC0221b.mo973c();
        }
        C0195b c0195b = new C0195b(aVar);
        ActionBar abstractC0203aMo798a = mo798a();
        if (abstractC0203aMo798a != null) {
            this.f945g = abstractC0203aMo798a.mo876a(c0195b);
            ActionMode abstractC0221b2 = this.f945g;
            if (abstractC0221b2 != null && (interfaceC0206d = this.f942d) != null) {
                interfaceC0206d.onSupportActionModeStarted(abstractC0221b2);
            }
        }
        if (this.f945g == null) {
            this.f945g = m816b(c0195b);
        }
        return this.f945g;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo828f() {
        ActionBar abstractC0203aMo798a = mo798a();
        if (abstractC0203aMo798a == null || !abstractC0203aMo798a.mo890e()) {
            m788k(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    ActionMode m816b(ActionMode.PlatformImplementations.kt_3 aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ActionMode abstractC0221bOnWindowStartingSupportActionMode;
        Context c0223d;
        AppCompatCallback interfaceC0206d;
        m843q();
        ActionMode abstractC0221b = this.f945g;
        if (abstractC0221b != null) {
            abstractC0221b.mo973c();
        }
        if (!(aVar instanceof C0195b)) {
            aVar = new C0195b(aVar);
        }
        AppCompatCallback interfaceC0206d2 = this.f942d;
        if (interfaceC0206d2 == null || this.f955q) {
            abstractC0221bOnWindowStartingSupportActionMode = null;
        } else {
            try {
                abstractC0221bOnWindowStartingSupportActionMode = interfaceC0206d2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (abstractC0221bOnWindowStartingSupportActionMode != null) {
            this.f945g = abstractC0221bOnWindowStartingSupportActionMode;
        } else {
            if (this.f946h == null) {
                if (this.f953o) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f940b.getTheme();
                    theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f940b.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        c0223d = new ContextThemeWrapper(this.f940b, 0);
                        c0223d.getTheme().setTo(themeNewTheme);
                    } else {
                        c0223d = this.f940b;
                    }
                    this.f946h = new ActionBarContextView(c0223d);
                    this.f947i = new PopupWindow(c0223d, (AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.m3040a(this.f947i, 2);
                    this.f947i.setContentView(this.f946h);
                    this.f947i.setWidth(-1);
                    c0223d.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.f946h.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0223d.getResources().getDisplayMetrics()));
                    this.f947i.setHeight(-2);
                    this.f948j = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImpl.this.f947i.showAtLocation(AppCompatDelegateImpl.this.f946h, 55, 0, 0);
                            AppCompatDelegateImpl.this.m843q();
                            if (AppCompatDelegateImpl.this.m841o()) {
                                AppCompatDelegateImpl.this.f946h.setAlpha(0.0f);
                                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                                appCompatDelegateImpl.f949k = ViewCompat.m2895n(appCompatDelegateImpl.f946h).m2946a(1.0f);
                                AppCompatDelegateImpl.this.f949k.m2949a(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6.1
                                    @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
                                    /* renamed from: PlatformImplementations.kt_3 */
                                    public void mo852a(View view) {
                                        AppCompatDelegateImpl.this.f946h.setVisibility(0);
                                    }

                                    @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
                                    /* renamed from: IntrinsicsJvm.kt_4 */
                                    public void mo853b(View view) {
                                        AppCompatDelegateImpl.this.f946h.setAlpha(1.0f);
                                        AppCompatDelegateImpl.this.f949k.m2949a((ViewPropertyAnimatorListener) null);
                                        AppCompatDelegateImpl.this.f949k = null;
                                    }
                                });
                                return;
                            }
                            AppCompatDelegateImpl.this.f946h.setAlpha(1.0f);
                            AppCompatDelegateImpl.this.f946h.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f916F.findViewById(androidx.appcompat.R.id_renamed.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m839m()));
                        this.f946h = (ActionBarContextView) viewStubCompat.m1385a();
                    }
                }
            }
            if (this.f946h != null) {
                m843q();
                this.f946h.m1222c();
                StandaloneActionMode c0224e = new StandaloneActionMode(this.f946h.getContext(), this.f946h, aVar, this.f947i == null);
                if (aVar.mo864a(c0224e, c0224e.mo970b())) {
                    c0224e.mo974d();
                    this.f946h.m1219a(c0224e);
                    this.f945g = c0224e;
                    if (m841o()) {
                        this.f946h.setAlpha(0.0f);
                        this.f949k = ViewCompat.m2895n(this.f946h).m2946a(1.0f);
                        this.f949k.m2949a(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.7
                            @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
                            /* renamed from: PlatformImplementations.kt_3 */
                            public void mo852a(View view) {
                                AppCompatDelegateImpl.this.f946h.setVisibility(0);
                                AppCompatDelegateImpl.this.f946h.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImpl.this.f946h.getParent() instanceof View) {
                                    ViewCompat.m2900s((View) AppCompatDelegateImpl.this.f946h.getParent());
                                }
                            }

                            @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
                            /* renamed from: IntrinsicsJvm.kt_4 */
                            public void mo853b(View view) {
                                AppCompatDelegateImpl.this.f946h.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.f949k.m2949a((ViewPropertyAnimatorListener) null);
                                AppCompatDelegateImpl.this.f949k = null;
                            }
                        });
                    } else {
                        this.f946h.setAlpha(1.0f);
                        this.f946h.setVisibility(0);
                        this.f946h.sendAccessibilityEvent(32);
                        if (this.f946h.getParent() instanceof View) {
                            ViewCompat.m2900s((View) this.f946h.getParent());
                        }
                    }
                    if (this.f947i != null) {
                        this.f941c.getDecorView().post(this.f948j);
                    }
                } else {
                    this.f945g = null;
                }
            }
        }
        ActionMode abstractC0221b2 = this.f945g;
        if (abstractC0221b2 != null && (interfaceC0206d = this.f942d) != null) {
            interfaceC0206d.onSupportActionModeStarted(abstractC0221b2);
        }
        return this.f945g;
    }

    /* renamed from: o */
    final boolean m841o() {
        ViewGroup viewGroup;
        return this.f915E && (viewGroup = this.f916F) != null && ViewCompat.m2823A(viewGroup);
    }

    /* renamed from: p */
    public boolean m842p() {
        return this.f914D;
    }

    /* renamed from: q */
    void m843q() {
        ViewPropertyAnimatorCompat c0517z = this.f949k;
        if (c0517z != null) {
            c0517z.m2953b();
        }
    }

    /* renamed from: r */
    boolean m844r() {
        ActionMode abstractC0221b = this.f945g;
        if (abstractC0221b != null) {
            abstractC0221b.mo973c();
            return true;
        }
        ActionBar abstractC0203aMo798a = mo798a();
        return abstractC0203aMo798a != null && abstractC0203aMo798a.mo892f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m812a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        ActionBar abstractC0203aMo798a = mo798a();
        if (abstractC0203aMo798a != null && abstractC0203aMo798a.mo881a(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f923M;
        if (panelFeatureState != null && m779a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.f923M;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f981n = true;
            }
            return true;
        }
        if (this.f923M == null) {
            PanelFeatureState panelFeatureStateM796a = m796a(0, true);
            m783b(panelFeatureStateM796a, keyEvent);
            boolean zM779a = m779a(panelFeatureStateM796a, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateM796a.f980m = false;
            if (zM779a) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m813a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f937a;
        if (((obj instanceof KeyEventDispatcher.PlatformImplementations.kt_3) || (obj instanceof AppCompatDialog)) && (decorView = this.f941c.getDecorView()) != null && KeyEventDispatcher.m2779a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f958y.m1086a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m823c(keyCode, keyEvent) : m819b(keyCode, keyEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m819b(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 == 4) {
            boolean z = this.f924N;
            this.f924N = false;
            PanelFeatureState panelFeatureStateM796a = m796a(0, false);
            if (panelFeatureStateM796a != null && panelFeatureStateM796a.f982o) {
                if (!z) {
                    m808a(panelFeatureStateM796a, true);
                }
                return true;
            }
            if (m844r()) {
                return true;
            }
        } else if (OplusGLSurfaceView_13 == 82) {
            m787e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m823c(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 == 4) {
            this.f924N = (keyEvent.getFlags() & 128) != 0;
        } else if (OplusGLSurfaceView_13 == 82) {
            m786d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public View m795a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zM777a = false;
        if (this.f939ab == null) {
            String string = this.f940b.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme).getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f939ab = new AppCompatViewInflater();
            } else {
                try {
                    this.f939ab = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.OplusGLSurfaceView_13("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f939ab = new AppCompatViewInflater();
                }
            }
        }
        if (f907u) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zM777a = true;
                }
            } else {
                zM777a = m777a((ViewParent) view);
            }
        }
        return this.f939ab.createView(view, str, context, attributeSet, zM777a, f907u, true, VectorEnabledTintResources.m1619a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m777a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f941c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.m2826D((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo832h() throws IllegalAccessException, IllegalArgumentException {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f940b);
        if (layoutInflaterFrom.getFactory() == null) {
            LayoutInflaterCompat.m2781a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.OplusGLSurfaceView_13("AppCompatDelegate", "The Activity's LayoutInflater already has PlatformImplementations.kt_3 Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m795a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* renamed from: B */
    private AppCompatActivity m769B() {
        for (Context baseContext = this.f940b; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m775a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int OplusGLSurfaceView_13;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.f982o || this.f955q) {
            return;
        }
        if (panelFeatureState.f968a == 0) {
            if ((this.f940b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackM838l = m838l();
        if (callbackM838l != null && !callbackM838l.onMenuOpened(panelFeatureState.f968a, panelFeatureState.f977j)) {
            m808a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f940b.getSystemService("window");
        if (windowManager != null && m783b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.f974g == null || panelFeatureState.f984q) {
                if (panelFeatureState.f974g == null) {
                    if (!m778a(panelFeatureState) || panelFeatureState.f974g == null) {
                        return;
                    }
                } else if (panelFeatureState.f984q && panelFeatureState.f974g.getChildCount() > 0) {
                    panelFeatureState.f974g.removeAllViews();
                }
                if (!m785c(panelFeatureState) || !panelFeatureState.m857a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f975h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.f974g.setBackgroundResource(panelFeatureState.f969b);
                ViewParent parent = panelFeatureState.f975h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.f975h);
                }
                panelFeatureState.f974g.addView(panelFeatureState.f975h, layoutParams2);
                if (!panelFeatureState.f975h.hasFocus()) {
                    panelFeatureState.f975h.requestFocus();
                }
            } else {
                if (panelFeatureState.f976i != null && (layoutParams = panelFeatureState.f976i.getLayoutParams()) != null && layoutParams.width == -1) {
                    OplusGLSurfaceView_13 = -1;
                }
                panelFeatureState.f981n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(OplusGLSurfaceView_13, -2, panelFeatureState.f971d, panelFeatureState.f972e, 1002, 8519680, -3);
                layoutParams3.gravity = panelFeatureState.f970c;
                layoutParams3.windowAnimations = panelFeatureState.f973f;
                windowManager.addView(panelFeatureState.f974g, layoutParams3);
                panelFeatureState.f982o = true;
            }
            OplusGLSurfaceView_13 = -2;
            panelFeatureState.f981n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(OplusGLSurfaceView_13, -2, panelFeatureState.f971d, panelFeatureState.f972e, 1002, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.f970c;
            layoutParams32.windowAnimations = panelFeatureState.f973f;
            windowManager.addView(panelFeatureState.f974g, layoutParams32);
            panelFeatureState.f982o = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m778a(PanelFeatureState panelFeatureState) {
        panelFeatureState.m855a(m839m());
        panelFeatureState.f974g = new C0200g(panelFeatureState.f979l);
        panelFeatureState.f970c = 81;
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m776a(MenuBuilder c0236h, boolean z) {
        DecorContentParent interfaceC0353y = this.f911A;
        if (interfaceC0353y != null && interfaceC0353y.mo1239e() && (!ViewConfiguration.get(this.f940b).hasPermanentMenuKey() || this.f911A.mo1241g())) {
            Window.Callback callbackM838l = m838l();
            if (!this.f911A.mo1240f() || !z) {
                if (callbackM838l == null || this.f955q) {
                    return;
                }
                if (this.f956r && (this.f957s & 1) != 0) {
                    this.f941c.getDecorView().removeCallbacks(this.f934X);
                    this.f934X.run();
                }
                PanelFeatureState panelFeatureStateM796a = m796a(0, true);
                if (panelFeatureStateM796a.f977j == null || panelFeatureStateM796a.f985r || !callbackM838l.onPreparePanel(0, panelFeatureStateM796a.f976i, panelFeatureStateM796a.f977j)) {
                    return;
                }
                callbackM838l.onMenuOpened(108, panelFeatureStateM796a.f977j);
                this.f911A.mo1242h();
                return;
            }
            this.f911A.mo1243i();
            if (this.f955q) {
                return;
            }
            callbackM838l.onPanelClosed(108, m796a(0, true).f977j);
            return;
        }
        PanelFeatureState panelFeatureStateM796a2 = m796a(0, true);
        panelFeatureStateM796a2.f984q = true;
        m808a(panelFeatureStateM796a2, false);
        m775a(panelFeatureStateM796a2, (KeyEvent) null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m782b(PanelFeatureState panelFeatureState) {
        Context context = this.f940b;
        if ((panelFeatureState.f968a == 0 || panelFeatureState.f968a == 108) && this.f911A != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                ContextThemeWrapper c0223d = new ContextThemeWrapper(context, 0);
                c0223d.getTheme().setTo(themeNewTheme);
                context = c0223d;
            }
        }
        MenuBuilder c0236h = new MenuBuilder(context);
        c0236h.setCallback(this);
        panelFeatureState.m856a(c0236h);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m785c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f976i != null) {
            panelFeatureState.f975h = panelFeatureState.f976i;
            return true;
        }
        if (panelFeatureState.f977j == null) {
            return false;
        }
        if (this.f913C == null) {
            this.f913C = new C0201h();
        }
        panelFeatureState.f975h = (View) panelFeatureState.m854a(this.f913C);
        return panelFeatureState.f975h != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m783b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent interfaceC0353y;
        DecorContentParent interfaceC0353y2;
        DecorContentParent interfaceC0353y3;
        if (this.f955q) {
            return false;
        }
        if (panelFeatureState.f980m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f923M;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            m808a(panelFeatureState2, false);
        }
        Window.Callback callbackM838l = m838l();
        if (callbackM838l != null) {
            panelFeatureState.f976i = callbackM838l.onCreatePanelView(panelFeatureState.f968a);
        }
        boolean z = panelFeatureState.f968a == 0 || panelFeatureState.f968a == 108;
        if (z && (interfaceC0353y3 = this.f911A) != null) {
            interfaceC0353y3.mo1244j();
        }
        if (panelFeatureState.f976i == null && (!z || !(m837k() instanceof ToolbarActionBar))) {
            if (panelFeatureState.f977j == null || panelFeatureState.f985r) {
                if (panelFeatureState.f977j == null && (!m782b(panelFeatureState) || panelFeatureState.f977j == null)) {
                    return false;
                }
                if (z && this.f911A != null) {
                    if (this.f912B == null) {
                        this.f912B = new C0194a();
                    }
                    this.f911A.mo1234a(panelFeatureState.f977j, this.f912B);
                }
                panelFeatureState.f977j.stopDispatchingItemsChanged();
                if (!callbackM838l.onCreatePanelMenu(panelFeatureState.f968a, panelFeatureState.f977j)) {
                    panelFeatureState.m856a((MenuBuilder) null);
                    if (z && (interfaceC0353y = this.f911A) != null) {
                        interfaceC0353y.mo1234a(null, this.f912B);
                    }
                    return false;
                }
                panelFeatureState.f985r = false;
            }
            panelFeatureState.f977j.stopDispatchingItemsChanged();
            if (panelFeatureState.f986s != null) {
                panelFeatureState.f977j.restoreActionViewStates(panelFeatureState.f986s);
                panelFeatureState.f986s = null;
            }
            if (!callbackM838l.onPreparePanel(0, panelFeatureState.f976i, panelFeatureState.f977j)) {
                if (z && (interfaceC0353y2 = this.f911A) != null) {
                    interfaceC0353y2.mo1234a(null, this.f912B);
                }
                panelFeatureState.f977j.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.f983p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f977j.setQwertyMode(panelFeatureState.f983p);
            panelFeatureState.f977j.startDispatchingItemsChanged();
        }
        panelFeatureState.f980m = true;
        panelFeatureState.f981n = false;
        this.f923M = panelFeatureState;
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m809a(MenuBuilder c0236h) {
        if (this.f921K) {
            return;
        }
        this.f921K = true;
        this.f911A.mo1245k();
        Window.Callback callbackM838l = m838l();
        if (callbackM838l != null && !this.f955q) {
            callbackM838l.onPanelClosed(108, c0236h);
        }
        this.f921K = false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void m831g(int OplusGLSurfaceView_13) {
        m808a(m796a(OplusGLSurfaceView_13, true), true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m808a(PanelFeatureState panelFeatureState, boolean z) {
        DecorContentParent interfaceC0353y;
        if (z && panelFeatureState.f968a == 0 && (interfaceC0353y = this.f911A) != null && interfaceC0353y.mo1240f()) {
            m809a(panelFeatureState.f977j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f940b.getSystemService("window");
        if (windowManager != null && panelFeatureState.f982o && panelFeatureState.f974g != null) {
            windowManager.removeView(panelFeatureState.f974g);
            if (z) {
                m801a(panelFeatureState.f968a, panelFeatureState, null);
            }
        }
        panelFeatureState.f980m = false;
        panelFeatureState.f981n = false;
        panelFeatureState.f982o = false;
        panelFeatureState.f975h = null;
        panelFeatureState.f984q = true;
        if (this.f923M == panelFeatureState) {
            this.f923M = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m786d(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateM796a = m796a(OplusGLSurfaceView_13, true);
        if (panelFeatureStateM796a.f982o) {
            return false;
        }
        return m783b(panelFeatureStateM796a, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* renamed from: COUIBaseListPopupWindow_8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m787e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.view.IntrinsicsJvm.kt_4 r0 = r3.f945g
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r3.m796a(r4, r0)
            if (r4 != 0) goto L43
            androidx.appcompat.widget.y r4 = r3.f911A
            if (r4 == 0) goto L43
            boolean r4 = r4.mo1239e()
            if (r4 == 0) goto L43
            android.content.Context r4 = r3.f940b
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L43
            androidx.appcompat.widget.y r4 = r3.f911A
            boolean r4 = r4.mo1240f()
            if (r4 != 0) goto L3c
            boolean r4 = r3.f955q
            if (r4 != 0) goto L63
            boolean r4 = r3.m783b(r2, r5)
            if (r4 == 0) goto L63
            androidx.appcompat.widget.y r4 = r3.f911A
            boolean r4 = r4.mo1242h()
            goto L6a
        L3c:
            androidx.appcompat.widget.y r4 = r3.f911A
            boolean r4 = r4.mo1243i()
            goto L6a
        L43:
            boolean r4 = r2.f982o
            if (r4 != 0) goto L65
            boolean r4 = r2.f981n
            if (r4 == 0) goto L4c
            goto L65
        L4c:
            boolean r4 = r2.f980m
            if (r4 == 0) goto L63
            boolean r4 = r2.f985r
            if (r4 == 0) goto L5b
            r2.f980m = r1
            boolean r4 = r3.m783b(r2, r5)
            goto L5c
        L5b:
            r4 = r0
        L5c:
            if (r4 == 0) goto L63
            r3.m775a(r2, r5)
            r4 = r0
            goto L6a
        L63:
            r4 = r1
            goto L6a
        L65:
            boolean r4 = r2.f982o
            r3.m808a(r2, r0)
        L6a:
            if (r4 == 0) goto L83
            android.content.Context r3 = r3.f940b
            java.lang.String r5 = "audio"
            java.lang.Object r3 = r3.getSystemService(r5)
            android.media.AudioManager r3 = (android.media.AudioManager) r3
            if (r3 == 0) goto L7c
            r3.playSoundEffect(r1)
            goto L83
        L7c:
            java.lang.String r3 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r3, r5)
        L83:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m787e(int, android.view.KeyEvent):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m801a(int OplusGLSurfaceView_13, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && OplusGLSurfaceView_13 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f922L;
                if (OplusGLSurfaceView_13 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[OplusGLSurfaceView_13];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f977j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f982o) && !this.f955q) {
            this.f958y.m1086a().onPanelClosed(OplusGLSurfaceView_13, menu);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    PanelFeatureState m797a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f922L;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[OplusGLSurfaceView_13];
            if (panelFeatureState != null && panelFeatureState.f977j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected PanelFeatureState m796a(int OplusGLSurfaceView_13, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f922L;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= OplusGLSurfaceView_13) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[OplusGLSurfaceView_13 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f922L = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[OplusGLSurfaceView_13];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(OplusGLSurfaceView_13);
        panelFeatureStateArr[OplusGLSurfaceView_13] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m779a(PanelFeatureState panelFeatureState, int OplusGLSurfaceView_13, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f980m || m783b(panelFeatureState, keyEvent)) && panelFeatureState.f977j != null) {
            zPerformShortcut = panelFeatureState.f977j.performShortcut(OplusGLSurfaceView_13, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.f911A == null) {
            m808a(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m788k(int OplusGLSurfaceView_13) {
        this.f957s = (1 << OplusGLSurfaceView_13) | this.f957s;
        if (this.f956r) {
            return;
        }
        ViewCompat.m2857a(this.f941c.getDecorView(), this.f934X);
        this.f956r = true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m833h(int OplusGLSurfaceView_13) {
        PanelFeatureState panelFeatureStateM796a;
        PanelFeatureState panelFeatureStateM796a2 = m796a(OplusGLSurfaceView_13, true);
        if (panelFeatureStateM796a2.f977j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateM796a2.f977j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateM796a2.f986s = bundle;
            }
            panelFeatureStateM796a2.f977j.stopDispatchingItemsChanged();
            panelFeatureStateM796a2.f977j.clear();
        }
        panelFeatureStateM796a2.f985r = true;
        panelFeatureStateM796a2.f984q = true;
        if ((OplusGLSurfaceView_13 != 108 && OplusGLSurfaceView_13 != 0) || this.f911A == null || (panelFeatureStateM796a = m796a(0, false)) == null) {
            return;
        }
        panelFeatureStateM796a.f980m = false;
        m783b(panelFeatureStateM796a, (KeyEvent) null);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    int m835i(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.f946h;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f946h.getLayoutParams();
            if (this.f946h.isShown()) {
                if (this.f936Z == null) {
                    this.f936Z = new Rect();
                    this.f938aa = new Rect();
                }
                Rect rect = this.f936Z;
                Rect rect2 = this.f938aa;
                rect.set(0, OplusGLSurfaceView_13, 0, 0);
                ViewUtils_2.m1622a(this.f916F, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? OplusGLSurfaceView_13 : 0)) {
                    marginLayoutParams.topMargin = OplusGLSurfaceView_13;
                    View view = this.f918H;
                    if (view == null) {
                        this.f918H = new View(this.f940b);
                        this.f918H.setBackgroundColor(this.f940b.getResources().getColor(androidx.appcompat.R.color.abc_input_method_navigation_guard));
                        this.f916F.addView(this.f918H, -1, new ViewGroup.LayoutParams(-1, OplusGLSurfaceView_13));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != OplusGLSurfaceView_13) {
                            layoutParams.height = OplusGLSurfaceView_13;
                            this.f918H.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.f918H != null;
                if (!this.f952n && z) {
                    OplusGLSurfaceView_13 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = true;
                z = false;
            } else {
                z2 = false;
                z = false;
            }
            if (z2) {
                this.f946h.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.f918H;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: C */
    private void m770C() {
        if (this.f915E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private int m789l(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 8) {
            Log.OplusGLSurfaceView_13("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id_renamed when requesting this feature.");
            return 108;
        }
        if (OplusGLSurfaceView_13 != 9) {
            return OplusGLSurfaceView_13;
        }
        Log.OplusGLSurfaceView_13("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id_renamed when requesting this feature.");
        return 109;
    }

    /* renamed from: s */
    void m845s() {
        DecorContentParent interfaceC0353y = this.f911A;
        if (interfaceC0353y != null) {
            interfaceC0353y.mo1245k();
        }
        if (this.f947i != null) {
            this.f941c.getDecorView().removeCallbacks(this.f948j);
            if (this.f947i.isShowing()) {
                try {
                    this.f947i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f947i = null;
        }
        m843q();
        PanelFeatureState panelFeatureStateM796a = m796a(0, false);
        if (panelFeatureStateM796a == null || panelFeatureStateM796a.f977j == null) {
            return;
        }
        panelFeatureStateM796a.f977j.close();
    }

    /* renamed from: t */
    public boolean m846t() {
        return m780a(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m780a(boolean z) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException {
        if (this.f955q) {
            return false;
        }
        int iM771D = m771D();
        boolean zM781b = m781b(m836j(iM771D), z);
        if (iM771D == 0) {
            m847u().m871d();
        } else {
            AbstractC0198e abstractC0198e = this.f932V;
            if (abstractC0198e != null) {
                abstractC0198e.m872e();
            }
        }
        if (iM771D == 3) {
            m772E().m871d();
        } else {
            AbstractC0198e abstractC0198e2 = this.f933W;
            if (abstractC0198e2 != null) {
                abstractC0198e2.m872e();
            }
        }
        return zM781b;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    /* renamed from: OplusGLSurfaceView_13 */
    public int mo834i() {
        return this.f928R;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    int m836j(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -100) {
            return -1;
        }
        if (OplusGLSurfaceView_13 != -1) {
            if (OplusGLSurfaceView_13 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f940b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    return m847u().mo868a();
                }
                return -1;
            }
            if (OplusGLSurfaceView_13 != 1 && OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    return m772E().mo868a();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: D */
    private int m771D() {
        int OplusGLSurfaceView_13 = this.f928R;
        return OplusGLSurfaceView_13 != -100 ? OplusGLSurfaceView_13 : m924j();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m781b(int OplusGLSurfaceView_13, boolean z) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException {
        int i2 = this.f940b.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        int i3 = OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? i2 : 32 : 16;
        boolean zM773F = m773F();
        boolean z3 = false;
        if ((f910x || i3 != i2) && !zM773F && Build.VERSION.SDK_INT >= 17 && !this.f925O && (this.f937a instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i3;
            try {
                ((ContextThemeWrapper) this.f937a).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", COUIBaseListPopupWindow_8);
            }
        }
        int i4 = this.f940b.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i4 != i3 && z && !zM773F && this.f925O && (Build.VERSION.SDK_INT >= 17 || this.f926P)) {
            Object obj = this.f937a;
            if (obj instanceof Activity) {
                ActivityCompat.m2349b((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i4 == i3) {
            z2 = z3;
        } else {
            m784c(i3, zM773F);
        }
        if (z2) {
            Object obj2 = this.f937a;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).m907a(OplusGLSurfaceView_13);
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m784c(int OplusGLSurfaceView_13, boolean z) throws IllegalAccessException, IllegalArgumentException {
        Resources resources = this.f940b.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = OplusGLSurfaceView_13 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            ResourcesFlusher.m926a(resources);
        }
        int i2 = this.f929S;
        if (i2 != 0) {
            this.f940b.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f940b.getTheme().applyStyle(this.f929S, true);
            }
        }
        if (z) {
            Object obj = this.f937a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity).getLifecycle().mo3638a().isAtLeast(Lifecycle.IntrinsicsJvm.kt_4.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.f927Q) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    /* renamed from: u */
    final AbstractC0198e m847u() {
        if (this.f932V == null) {
            this.f932V = new C0199f(TwilightManager.m939a(this.f940b));
        }
        return this.f932V;
    }

    /* renamed from: E */
    private AbstractC0198e m772E() {
        if (this.f933W == null) {
            this.f933W = new C0197d(this.f940b);
        }
        return this.f933W;
    }

    /* renamed from: F */
    private boolean m773F() throws PackageManager.NameNotFoundException {
        if (!this.f931U && (this.f937a instanceof Activity)) {
            PackageManager packageManager = this.f940b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f940b, this.f937a.getClass()), 0);
                this.f930T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
                Log.IntrinsicsJvm.kt_5("AppCompatDelegate", "Exception while getting ActivityInfo", COUIBaseListPopupWindow_8);
                this.f930T = false;
            }
        }
        this.f931U = true;
        return this.f930T;
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$IntrinsicsJvm.kt_4 */
    class C0195b implements ActionMode.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ActionMode.PlatformImplementations.kt_3 f989b;

        public C0195b(ActionMode.PlatformImplementations.kt_3 aVar) {
            this.f989b = aVar;
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo864a(ActionMode abstractC0221b, Menu menu) {
            return this.f989b.mo864a(abstractC0221b, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo866b(ActionMode abstractC0221b, Menu menu) {
            return this.f989b.mo866b(abstractC0221b, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo865a(ActionMode abstractC0221b, MenuItem menuItem) {
            return this.f989b.mo865a(abstractC0221b, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo863a(ActionMode abstractC0221b) {
            this.f989b.mo863a(abstractC0221b);
            if (AppCompatDelegateImpl.this.f947i != null) {
                AppCompatDelegateImpl.this.f941c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f948j);
            }
            if (AppCompatDelegateImpl.this.f946h != null) {
                AppCompatDelegateImpl.this.m843q();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.f949k = ViewCompat.m2895n(appCompatDelegateImpl.f946h).m2946a(0.0f);
                AppCompatDelegateImpl.this.f949k.m2949a(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.IntrinsicsJvm.kt_4.1
                    @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
                    /* renamed from: IntrinsicsJvm.kt_4 */
                    public void mo853b(View view) {
                        AppCompatDelegateImpl.this.f946h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.f947i != null) {
                            AppCompatDelegateImpl.this.f947i.dismiss();
                        } else if (AppCompatDelegateImpl.this.f946h.getParent() instanceof View) {
                            ViewCompat.m2900s((View) AppCompatDelegateImpl.this.f946h.getParent());
                        }
                        AppCompatDelegateImpl.this.f946h.removeAllViews();
                        AppCompatDelegateImpl.this.f949k.m2949a((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImpl.this.f949k = null;
                    }
                });
            }
            if (AppCompatDelegateImpl.this.f942d != null) {
                AppCompatDelegateImpl.this.f942d.onSupportActionModeFinished(AppCompatDelegateImpl.this.f945g);
            }
            AppCompatDelegateImpl.this.f945g = null;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$COUIBaseListPopupWindow_10 */
    private final class C0201h implements MenuPresenter.PlatformImplementations.kt_3 {
        C0201h() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo861a(MenuBuilder c0236h, boolean z) {
            MenuBuilder rootMenu = c0236h.getRootMenu();
            boolean z2 = rootMenu != c0236h;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                c0236h = rootMenu;
            }
            PanelFeatureState panelFeatureStateM797a = appCompatDelegateImpl.m797a((Menu) c0236h);
            if (panelFeatureStateM797a != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.m801a(panelFeatureStateM797a.f968a, panelFeatureStateM797a, rootMenu);
                    AppCompatDelegateImpl.this.m808a(panelFeatureStateM797a, true);
                } else {
                    AppCompatDelegateImpl.this.m808a(panelFeatureStateM797a, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo862a(MenuBuilder c0236h) {
            Window.Callback callbackM838l;
            if (c0236h != null || !AppCompatDelegateImpl.this.f950l || (callbackM838l = AppCompatDelegateImpl.this.m838l()) == null || AppCompatDelegateImpl.this.f955q) {
                return true;
            }
            callbackM838l.onMenuOpened(108, c0236h);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$PlatformImplementations.kt_3 */
    private final class C0194a implements MenuPresenter.PlatformImplementations.kt_3 {
        C0194a() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo862a(MenuBuilder c0236h) {
            Window.Callback callbackM838l = AppCompatDelegateImpl.this.m838l();
            if (callbackM838l == null) {
                return true;
            }
            callbackM838l.onMenuOpened(108, c0236h);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo861a(MenuBuilder c0236h, boolean z) {
            AppCompatDelegateImpl.this.m809a(c0236h);
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: PlatformImplementations.kt_3 */
        int f968a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f969b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f970c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f971d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f972e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f973f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        ViewGroup f974g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        View f975h;

        /* renamed from: OplusGLSurfaceView_13 */
        View f976i;

        /* renamed from: OplusGLSurfaceView_15 */
        MenuBuilder f977j;

        /* renamed from: OplusGLSurfaceView_5 */
        ListMenuPresenter f978k;

        /* renamed from: OplusGLSurfaceView_14 */
        Context f979l;

        /* renamed from: OplusGLSurfaceView_6 */
        boolean f980m;

        /* renamed from: OplusGLSurfaceView_11 */
        boolean f981n;

        /* renamed from: o */
        boolean f982o;

        /* renamed from: p */
        public boolean f983p;

        /* renamed from: q */
        boolean f984q = false;

        /* renamed from: r */
        boolean f985r;

        /* renamed from: s */
        Bundle f986s;

        PanelFeatureState(int OplusGLSurfaceView_13) {
            this.f968a = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m857a() {
            if (this.f975h == null) {
                return false;
            }
            return this.f976i != null || this.f978k.m1147a().getCount() > 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m855a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper c0223d = new ContextThemeWrapper(context, 0);
            c0223d.getTheme().setTo(themeNewTheme);
            this.f979l = c0223d;
            TypedArray typedArrayObtainStyledAttributes = c0223d.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            this.f969b = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f973f = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m856a(MenuBuilder c0236h) {
            ListMenuPresenter c0234f;
            MenuBuilder c0236h2 = this.f977j;
            if (c0236h == c0236h2) {
                return;
            }
            if (c0236h2 != null) {
                c0236h2.removeMenuPresenter(this.f978k);
            }
            this.f977j = c0236h;
            if (c0236h == null || (c0234f = this.f978k) == null) {
                return;
            }
            c0236h.addMenuPresenter(c0234f);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        MenuView m854a(MenuPresenter.PlatformImplementations.kt_3 aVar) {
            if (this.f977j == null) {
                return null;
            }
            if (this.f978k == null) {
                this.f978k = new ListMenuPresenter(this.f979l, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                this.f978k.setCallback(aVar);
                this.f977j.addMenuPresenter(this.f978k);
            }
            return this.f978k.m1148a(this.f974g);
        }

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int OplusGLSurfaceView_13) {
                    return new SavedState[OplusGLSurfaceView_13];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                savedState.isOpen = parcel.readInt() == 1;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$COUIBaseListPopupWindow_11 */
    private class C0200g extends ContentFrameLayout {
        public C0200g(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m813a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && m873a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.m831g(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int OplusGLSurfaceView_13) {
            setBackgroundDrawable(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m873a(int OplusGLSurfaceView_13, int i2) {
            return OplusGLSurfaceView_13 < -5 || i2 < -5 || OplusGLSurfaceView_13 > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$IntrinsicsJvm.kt_3 */
    class C0196c extends WindowCallbackWrapper {
        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        C0196c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m813a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.m812a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int OplusGLSurfaceView_13, Menu menu) {
            if (OplusGLSurfaceView_13 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(OplusGLSurfaceView_13, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int OplusGLSurfaceView_13, View view, Menu menu) {
            MenuBuilder c0236h = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (OplusGLSurfaceView_13 == 0 && c0236h == null) {
                return false;
            }
            if (c0236h != null) {
                c0236h.setOverrideVisibleItems(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(OplusGLSurfaceView_13, view, menu);
            if (c0236h != null) {
                c0236h.setOverrideVisibleItems(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int OplusGLSurfaceView_13, Menu menu) {
            super.onMenuOpened(OplusGLSurfaceView_13, menu);
            AppCompatDelegateImpl.this.m829f(OplusGLSurfaceView_13);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int OplusGLSurfaceView_13, Menu menu) {
            super.onPanelClosed(OplusGLSurfaceView_13, menu);
            AppCompatDelegateImpl.this.m827e(OplusGLSurfaceView_13);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.m842p()) {
                return m867a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        final ActionMode m867a(ActionMode.Callback callback) {
            SupportActionModeWrapper.PlatformImplementations.kt_3 aVar = new SupportActionModeWrapper.PlatformImplementations.kt_3(AppCompatDelegateImpl.this.f940b, callback);
            ActionMode abstractC0221bM799a = AppCompatDelegateImpl.this.m799a(aVar);
            if (abstractC0221bM799a != null) {
                return aVar.m1064b(abstractC0221bM799a);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int OplusGLSurfaceView_13) {
            if (AppCompatDelegateImpl.this.m842p() && OplusGLSurfaceView_13 == 0) {
                return m867a(callback);
            }
            return super.onWindowStartingActionMode(callback, OplusGLSurfaceView_13);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int OplusGLSurfaceView_13) {
            PanelFeatureState panelFeatureStateM796a = AppCompatDelegateImpl.this.m796a(0, true);
            if (panelFeatureStateM796a != null && panelFeatureStateM796a.f977j != null) {
                super.onProvideKeyboardShortcuts(list, panelFeatureStateM796a.f977j, OplusGLSurfaceView_13);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$COUIBaseListPopupWindow_8 */
    abstract class AbstractC0198e {

        /* renamed from: PlatformImplementations.kt_3 */
        private BroadcastReceiver f994a;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract int mo868a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        abstract void mo869b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        abstract IntentFilter mo870c();

        AbstractC0198e() {
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void m871d() {
            m872e();
            IntentFilter intentFilterMo870c = mo870c();
            if (intentFilterMo870c == null || intentFilterMo870c.countActions() == 0) {
                return;
            }
            if (this.f994a == null) {
                this.f994a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.COUIBaseListPopupWindow_8.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AbstractC0198e.this.mo869b();
                    }
                };
            }
            AppCompatDelegateImpl.this.f940b.registerReceiver(this.f994a, intentFilterMo870c);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        void m872e() {
            if (this.f994a != null) {
                try {
                    AppCompatDelegateImpl.this.f940b.unregisterReceiver(this.f994a);
                } catch (IllegalArgumentException unused) {
                }
                this.f994a = null;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$COUIBaseListPopupWindow_12 */
    private class C0199f extends AbstractC0198e {

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final TwilightManager f998c;

        C0199f(TwilightManager c0213k) {
            super();
            this.f998c = c0213k;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0198e
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo868a() {
            return this.f998c.m943a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0198e
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo869b() {
            AppCompatDelegateImpl.this.m846t();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0198e
        /* renamed from: IntrinsicsJvm.kt_3 */
        IntentFilter mo870c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$IntrinsicsJvm.kt_5 */
    private class C0197d extends AbstractC0198e {

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final PowerManager f993c;

        C0197d(Context context) {
            super();
            this.f993c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0198e
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo868a() {
            return (Build.VERSION.SDK_INT < 21 || !this.f993c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0198e
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo869b() {
            AppCompatDelegateImpl.this.m846t();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0198e
        /* renamed from: IntrinsicsJvm.kt_3 */
        IntentFilter mo870c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }
}
