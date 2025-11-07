package androidx.core.app;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class m_renamed implements java.lang.Iterable<android.content.Intent> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.ArrayList<android.content.Intent> f850a = new java.util.ArrayList<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.Context f851b;

    /* compiled from: TaskStackBuilder.java */
    public interface a_renamed {
        android.content.Intent f_renamed();
    }

    private m_renamed(android.content.Context context) {
        this.f851b = context;
    }

    public static androidx.core.app.m_renamed a_renamed(android.content.Context context) {
        return new androidx.core.app.m_renamed(context);
    }

    public androidx.core.app.m_renamed a_renamed(android.content.Intent intent) {
        this.f850a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public androidx.core.app.m_renamed a_renamed(android.app.Activity activity) {
        android.content.Intent intentF = activity instanceof androidx.core.app.m_renamed.a_renamed ? ((androidx.core.app.m_renamed.a_renamed) activity).f_renamed() : null;
        if (intentF == null) {
            intentF = androidx.core.app.f_renamed.a_renamed(activity);
        }
        if (intentF != null) {
            android.content.ComponentName component = intentF.getComponent();
            if (component == null) {
                component = intentF.resolveActivity(this.f851b.getPackageManager());
            }
            a_renamed(component);
            a_renamed(intentF);
        }
        return this;
    }

    public androidx.core.app.m_renamed a_renamed(android.content.ComponentName componentName) {
        int size = this.f850a.size();
        try {
            android.content.Intent intentA = androidx.core.app.f_renamed.a_renamed(this.f851b, componentName);
            while (intentA != null) {
                this.f850a.add(size, intentA);
                intentA = androidx.core.app.f_renamed.a_renamed(this.f851b, intentA.getComponent());
            }
            return this;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            android.util.Log.e_renamed("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new java.lang.IllegalArgumentException(e_renamed);
        }
    }

    @Override // java.lang.Iterable
    @java.lang.Deprecated
    public java.util.Iterator<android.content.Intent> iterator() {
        return this.f850a.iterator();
    }

    public void a_renamed() {
        a_renamed((android.os.Bundle) null);
    }

    public void a_renamed(android.os.Bundle bundle) {
        if (this.f850a.isEmpty()) {
            throw new java.lang.IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        java.util.ArrayList<android.content.Intent> arrayList = this.f850a;
        android.content.Intent[] intentArr = (android.content.Intent[]) arrayList.toArray(new android.content.Intent[arrayList.size()]);
        intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.a_renamed.a_renamed.a_renamed(this.f851b, intentArr, bundle)) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(com.google.android.exoplayer2.C_renamed.ENCODING_PCM_MU_LAW);
        this.f851b.startActivity(intent);
    }
}
