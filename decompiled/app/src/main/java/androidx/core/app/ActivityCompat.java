package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.p027a.ContextCompat;

/* compiled from: ActivityCompat.java */
/* renamed from: androidx.core.app.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static IntrinsicsJvm.kt_4 f2721a;

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void onRequestPermissionsResult(int OplusGLSurfaceView_13, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2350a(Activity activity, int OplusGLSurfaceView_13, int i2, Intent intent);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2351a(Activity activity, String[] strArr, int OplusGLSurfaceView_13);
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo2352b(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IntrinsicsJvm.kt_4 m2343a() {
        return f2721a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2345a(Activity activity, Intent intent, int OplusGLSurfaceView_13, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, OplusGLSurfaceView_13, bundle);
        } else {
            activity.startActivityForResult(intent, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2346a(Activity activity, IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2344a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2347a(final Activity activity, final String[] strArr, final int OplusGLSurfaceView_13) {
        IntrinsicsJvm.kt_4 bVar = f2721a;
        if (bVar == null || !bVar.m2351a(activity, strArr, OplusGLSurfaceView_13)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof IntrinsicsJvm.kt_3) {
                    ((IntrinsicsJvm.kt_3) activity).mo2352b(OplusGLSurfaceView_13);
                }
                activity.requestPermissions(strArr, OplusGLSurfaceView_13);
            } else if (activity instanceof PlatformImplementations.kt_3) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.PlatformImplementations.kt_3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int[] iArr = new int[strArr.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                        }
                        ((PlatformImplementations.kt_3) activity).onRequestPermissionsResult(OplusGLSurfaceView_13, strArr, iArr);
                    }
                });
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2348a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2349b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            if (ActivityRecreator.m2355a(activity)) {
                return;
            }
            activity.recreate();
        }
    }
}
