package androidx.preference;

/* compiled from: PreferenceManager.java */
/* loaded from: classes.dex */
public class j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f1371a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f1373c;
    private androidx.preference.e_renamed d_renamed;
    private android.content.SharedPreferences.Editor e_renamed;
    private boolean f_renamed;
    private java.lang.String g_renamed;
    private int h_renamed;
    private androidx.preference.PreferenceScreen j_renamed;
    private androidx.preference.j_renamed.d_renamed k_renamed;
    private androidx.preference.j_renamed.c_renamed l_renamed;
    private androidx.preference.j_renamed.a_renamed m_renamed;
    private androidx.preference.j_renamed.b_renamed n_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f1372b = 0;
    private int i_renamed = 0;

    /* compiled from: PreferenceManager.java */
    public interface a_renamed {
        void b_renamed(androidx.preference.Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    public interface b_renamed {
        void b_renamed(androidx.preference.PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager.java */
    public interface c_renamed {
        boolean a_renamed(androidx.preference.Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    public static abstract class d_renamed {
        public abstract boolean a_renamed(androidx.preference.Preference preference, androidx.preference.Preference preference2);

        public abstract boolean b_renamed(androidx.preference.Preference preference, androidx.preference.Preference preference2);
    }

    private static int j_renamed() {
        return 0;
    }

    public j_renamed(android.content.Context context) {
        this.f1371a = context;
        a_renamed(b_renamed(context));
    }

    public static android.content.SharedPreferences a_renamed(android.content.Context context) {
        return context.getSharedPreferences(b_renamed(context), j_renamed());
    }

    private static java.lang.String b_renamed(android.content.Context context) {
        return context.getPackageName() + "_preferences";
    }

    public static void a_renamed(android.content.Context context, int i_renamed, boolean z_renamed) {
        a_renamed(context, b_renamed(context), j_renamed(), i_renamed, z_renamed);
    }

    public static void a_renamed(android.content.Context context, java.lang.String str, int i_renamed, int i2, boolean z_renamed) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("_has_set_default_values", 0);
        if (z_renamed || !sharedPreferences.getBoolean("_has_set_default_values", false)) {
            androidx.preference.j_renamed jVar = new androidx.preference.j_renamed(context);
            jVar.a_renamed(str);
            jVar.a_renamed(i_renamed);
            jVar.a_renamed(context, i2, (androidx.preference.PreferenceScreen) null);
            sharedPreferences.edit().putBoolean("_has_set_default_values", true).apply();
        }
    }

    public androidx.preference.PreferenceScreen a_renamed(android.content.Context context, int i_renamed, androidx.preference.PreferenceScreen preferenceScreen) {
        a_renamed(true);
        androidx.preference.PreferenceScreen preferenceScreen2 = (androidx.preference.PreferenceScreen) new androidx.preference.i_renamed(context, this).a_renamed(i_renamed, preferenceScreen);
        preferenceScreen2.a_renamed(this);
        a_renamed(false);
        return preferenceScreen2;
    }

    long a_renamed() {
        long j_renamed;
        synchronized (this) {
            j_renamed = this.f1372b;
            this.f1372b = 1 + j_renamed;
        }
        return j_renamed;
    }

    public void a_renamed(java.lang.String str) {
        this.g_renamed = str;
        this.f1373c = null;
    }

    public void a_renamed(int i_renamed) {
        this.h_renamed = i_renamed;
        this.f1373c = null;
    }

    public androidx.preference.e_renamed b_renamed() {
        return this.d_renamed;
    }

    public android.content.SharedPreferences c_renamed() {
        android.content.Context contextB;
        if (b_renamed() != null) {
            return null;
        }
        if (this.f1373c == null) {
            if (this.i_renamed == 1) {
                contextB = androidx.core.a_renamed.a_renamed.b_renamed(this.f1371a);
            } else {
                contextB = this.f1371a;
            }
            this.f1373c = contextB.getSharedPreferences(this.g_renamed, this.h_renamed);
        }
        return this.f1373c;
    }

    public androidx.preference.PreferenceScreen d_renamed() {
        return this.j_renamed;
    }

    public boolean a_renamed(androidx.preference.PreferenceScreen preferenceScreen) {
        androidx.preference.PreferenceScreen preferenceScreen2 = this.j_renamed;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.P_renamed();
        }
        this.j_renamed = preferenceScreen;
        return true;
    }

    public <T_renamed extends androidx.preference.Preference> T_renamed a_renamed(java.lang.CharSequence charSequence) {
        androidx.preference.PreferenceScreen preferenceScreen = this.j_renamed;
        if (preferenceScreen == null) {
            return null;
        }
        return (T_renamed) preferenceScreen.d_renamed(charSequence);
    }

    android.content.SharedPreferences.Editor e_renamed() {
        if (this.d_renamed != null) {
            return null;
        }
        if (this.f_renamed) {
            if (this.e_renamed == null) {
                this.e_renamed = c_renamed().edit();
            }
            return this.e_renamed;
        }
        return c_renamed().edit();
    }

    boolean f_renamed() {
        return !this.f_renamed;
    }

    private void a_renamed(boolean z_renamed) {
        android.content.SharedPreferences.Editor editor;
        if (!z_renamed && (editor = this.e_renamed) != null) {
            editor.apply();
        }
        this.f_renamed = z_renamed;
    }

    public androidx.preference.j_renamed.d_renamed g_renamed() {
        return this.k_renamed;
    }

    public void a_renamed(androidx.preference.j_renamed.a_renamed aVar) {
        this.m_renamed = aVar;
    }

    public void a_renamed(androidx.preference.Preference preference) {
        androidx.preference.j_renamed.a_renamed aVar = this.m_renamed;
        if (aVar != null) {
            aVar.b_renamed(preference);
        }
    }

    public void a_renamed(androidx.preference.j_renamed.c_renamed cVar) {
        this.l_renamed = cVar;
    }

    public androidx.preference.j_renamed.c_renamed h_renamed() {
        return this.l_renamed;
    }

    public void a_renamed(androidx.preference.j_renamed.b_renamed bVar) {
        this.n_renamed = bVar;
    }

    public androidx.preference.j_renamed.b_renamed i_renamed() {
        return this.n_renamed;
    }
}
