package androidx.media.p052a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* compiled from: MediaButtonReceiver.java */
/* renamed from: androidx.media.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.IntrinsicsJvm.kt_5("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName componentNameM3714a = m3714a(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameM3714a != null) {
            intent.setComponent(componentNameM3714a);
            m3715a(context, intent);
            return;
        }
        ComponentName componentNameM3714a2 = m3714a(context, "android.media.browse.MediaBrowserService");
        if (componentNameM3714a2 != null) {
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(applicationContext, intent, pendingResultGoAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameM3714a2, aVar, null);
            aVar.m3717a(mediaBrowserCompat);
            mediaBrowserCompat.connect();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements PlatformImplementations.kt_3 media browser service.");
    }

    /* compiled from: MediaButtonReceiver.java */
    /* renamed from: androidx.media.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Context f3682a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Intent f3683b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final BroadcastReceiver.PendingResult f3684c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private MediaBrowserCompat f3685d;

        PlatformImplementations.kt_3(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f3682a = context;
            this.f3683b = intent;
            this.f3684c = pendingResult;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3717a(MediaBrowserCompat mediaBrowserCompat) {
            this.f3685d = mediaBrowserCompat;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            try {
                new MediaControllerCompat(this.f3682a, this.f3685d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f3683b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("MediaButtonReceiver", "Failed to create PlatformImplementations.kt_3 media controller", COUIBaseListPopupWindow_8);
            }
            m3716a();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            m3716a();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            m3716a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m3716a() {
            this.f3685d.disconnect();
            this.f3684c.finish();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ComponentName m3713a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = listQueryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        if (listQueryBroadcastReceivers.size() <= 1) {
            return null;
        }
        Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3715a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ComponentName m3714a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + listQueryIntentServices.size());
    }
}
