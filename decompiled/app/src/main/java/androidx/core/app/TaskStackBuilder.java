package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.p027a.ContextCompat;
import com.google.android.exoplayer2.C1547C;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* renamed from: androidx.core.app.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ArrayList<Intent> f2834a = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Context f2835b;

    /* compiled from: TaskStackBuilder.java */
    /* renamed from: androidx.core.app.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: COUIBaseListPopupWindow_12 */
        Intent mo915f();
    }

    private TaskStackBuilder(Context context) {
        this.f2835b = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static TaskStackBuilder m2440a(Context context) {
        return new TaskStackBuilder(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public TaskStackBuilder m2443a(Intent intent) {
        this.f2834a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public TaskStackBuilder m2441a(Activity activity) {
        Intent intentMo915f = activity instanceof PlatformImplementations.kt_3 ? ((PlatformImplementations.kt_3) activity).mo915f() : null;
        if (intentMo915f == null) {
            intentMo915f = NavUtils.m2370a(activity);
        }
        if (intentMo915f != null) {
            ComponentName component = intentMo915f.getComponent();
            if (component == null) {
                component = intentMo915f.resolveActivity(this.f2835b.getPackageManager());
            }
            m2442a(component);
            m2443a(intentMo915f);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public TaskStackBuilder m2442a(ComponentName componentName) {
        int size = this.f2834a.size();
        try {
            Intent intentM2371a = NavUtils.m2371a(this.f2835b, componentName);
            while (intentM2371a != null) {
                this.f2834a.add(size, intentM2371a);
                intentM2371a = NavUtils.m2371a(this.f2835b, intentM2371a.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(COUIBaseListPopupWindow_8);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2834a.iterator();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2444a() {
        m2445a((Bundle) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2445a(Bundle bundle) {
        if (this.f2834a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f2834a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ContextCompat.m2249a(this.f2835b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(C1547C.ENCODING_PCM_MU_LAW);
        this.f2835b.startActivity(intent);
    }
}
