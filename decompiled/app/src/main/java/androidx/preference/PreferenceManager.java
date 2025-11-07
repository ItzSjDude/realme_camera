package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.p027a.ContextCompat;

/* compiled from: PreferenceManager.java */
/* renamed from: androidx.preference.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class PreferenceManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f3922a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SharedPreferences f3924c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PreferenceDataStore f3925d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SharedPreferences.Editor f3926e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f3927f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f3928g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f3929h;

    /* renamed from: OplusGLSurfaceView_15 */
    private PreferenceScreen f3931j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_5 f3932k;

    /* renamed from: OplusGLSurfaceView_14 */
    private IntrinsicsJvm.kt_3 f3933l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PlatformImplementations.kt_3 f3934m;

    /* renamed from: OplusGLSurfaceView_11 */
    private IntrinsicsJvm.kt_4 f3935n;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f3923b = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f3930i = 0;

    /* compiled from: PreferenceManager.java */
    /* renamed from: androidx.preference.OplusGLSurfaceView_15$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3943b(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* renamed from: androidx.preference.OplusGLSurfaceView_15$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3944b(PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager.java */
    /* renamed from: androidx.preference.OplusGLSurfaceView_15$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo3940a(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* renamed from: androidx.preference.OplusGLSurfaceView_15$IntrinsicsJvm.kt_5 */
    public static abstract class IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract boolean m4005a(Preference preference, Preference preference2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract boolean m4006b(Preference preference, Preference preference2);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private static int m3986j() {
        return 0;
    }

    public PreferenceManager(Context context) {
        this.f3922a = context;
        m3995a(m3985b(context));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static SharedPreferences m3981a(Context context) {
        return context.getSharedPreferences(m3985b(context), m3986j());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String m3985b(Context context) {
        return context.getPackageName() + "_preferences";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3982a(Context context, int OplusGLSurfaceView_13, boolean z) {
        m3983a(context, m3985b(context), m3986j(), OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3983a(Context context, String str, int OplusGLSurfaceView_13, int i2, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("_has_set_default_values", 0);
        if (z || !sharedPreferences.getBoolean("_has_set_default_values", false)) {
            PreferenceManager c0666j = new PreferenceManager(context);
            c0666j.m3995a(str);
            c0666j.m3990a(OplusGLSurfaceView_13);
            c0666j.m3989a(context, i2, (PreferenceScreen) null);
            sharedPreferences.edit().putBoolean("_has_set_default_values", true).apply();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PreferenceScreen m3989a(Context context, int OplusGLSurfaceView_13, PreferenceScreen preferenceScreen) {
        m3984a(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).m3977a(OplusGLSurfaceView_13, preferenceScreen);
        preferenceScreen2.m3822a(this);
        m3984a(false);
        return preferenceScreen2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    long m3987a() {
        long OplusGLSurfaceView_15;
        synchronized (this) {
            OplusGLSurfaceView_15 = this.f3923b;
            this.f3923b = 1 + OplusGLSurfaceView_15;
        }
        return OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3995a(String str) {
        this.f3928g = str;
        this.f3924c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3990a(int OplusGLSurfaceView_13) {
        this.f3929h = OplusGLSurfaceView_13;
        this.f3924c = null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PreferenceDataStore m3997b() {
        return this.f3925d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SharedPreferences m3998c() {
        Context contextM2252b;
        if (m3997b() != null) {
            return null;
        }
        if (this.f3924c == null) {
            if (this.f3930i == 1) {
                contextM2252b = ContextCompat.m2252b(this.f3922a);
            } else {
                contextM2252b = this.f3922a;
            }
            this.f3924c = contextM2252b.getSharedPreferences(this.f3928g, this.f3929h);
        }
        return this.f3924c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public PreferenceScreen m3999d() {
        return this.f3931j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3996a(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f3931j;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.mo3805P();
        }
        this.f3931j = preferenceScreen;
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T extends Preference> T m3988a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f3931j;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.m3869d(charSequence);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    SharedPreferences.Editor m4000e() {
        if (this.f3925d != null) {
            return null;
        }
        if (this.f3927f) {
            if (this.f3926e == null) {
                this.f3926e = m3998c().edit();
            }
            return this.f3926e;
        }
        return m3998c().edit();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m4001f() {
        return !this.f3927f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3984a(boolean z) {
        SharedPreferences.Editor editor;
        if (!z && (editor = this.f3926e) != null) {
            editor.apply();
        }
        this.f3927f = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public IntrinsicsJvm.kt_5 m4002g() {
        return this.f3932k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3992a(PlatformImplementations.kt_3 aVar) {
        this.f3934m = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3991a(Preference preference) {
        PlatformImplementations.kt_3 aVar = this.f3934m;
        if (aVar != null) {
            aVar.mo3943b(preference);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3994a(IntrinsicsJvm.kt_3 cVar) {
        this.f3933l = cVar;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public IntrinsicsJvm.kt_3 m4003h() {
        return this.f3933l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3993a(IntrinsicsJvm.kt_4 bVar) {
        this.f3935n = bVar;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public IntrinsicsJvm.kt_4 m4004i() {
        return this.f3935n;
    }
}
