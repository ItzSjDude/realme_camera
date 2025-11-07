package androidx.media.a_renamed;

/* compiled from: MediaButtonReceiver.java */
/* loaded from: classes.dex */
public class a_renamed extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            android.util.Log.d_renamed("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        android.content.ComponentName componentNameA = a_renamed(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameA != null) {
            intent.setComponent(componentNameA);
            a_renamed(context, intent);
            return;
        }
        android.content.ComponentName componentNameA2 = a_renamed(context, "android.media.browse.MediaBrowserService");
        if (componentNameA2 != null) {
            android.content.BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            android.content.Context applicationContext = context.getApplicationContext();
            androidx.media.a_renamed.a_renamed.MediaButtonReceiver_2 c0035a = new androidx.media.a_renamed.a_renamed.MediaButtonReceiver_2(applicationContext, intent, pendingResultGoAsync);
            android.support.v4.media.MediaBrowserCompat mediaBrowserCompat = new android.support.v4.media.MediaBrowserCompat(applicationContext, componentNameA2, c0035a, null);
            c0035a.a_renamed(mediaBrowserCompat);
            mediaBrowserCompat.connect();
            return;
        }
        throw new java.lang.IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a_renamed media browser service.");
    }

    /* compiled from: MediaButtonReceiver.java */
    /* renamed from: androidx.media.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class MediaButtonReceiver_2 extends android.support.v4.media.MediaBrowserCompat.ConnectionCallback {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.content.Context f1268a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.content.Intent f1269b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.content.BroadcastReceiver.PendingResult f1270c;
        private android.support.v4.media.MediaBrowserCompat d_renamed;

        MediaButtonReceiver_2(android.content.Context context, android.content.Intent intent, android.content.BroadcastReceiver.PendingResult pendingResult) {
            this.f1268a = context;
            this.f1269b = intent;
            this.f1270c = pendingResult;
        }

        void a_renamed(android.support.v4.media.MediaBrowserCompat mediaBrowserCompat) {
            this.d_renamed = mediaBrowserCompat;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            try {
                new android.support.v4.media.session.MediaControllerCompat(this.f1268a, this.d_renamed.getSessionToken()).dispatchMediaButtonEvent((android.view.KeyEvent) this.f1269b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.e_renamed("MediaButtonReceiver", "Failed to create a_renamed media controller", e_renamed);
            }
            a_renamed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            a_renamed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            a_renamed();
        }

        private void a_renamed() {
            this.d_renamed.disconnect();
            this.f1270c.finish();
        }
    }

    public static android.content.ComponentName a_renamed(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        java.util.List<android.content.pm.ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            android.content.pm.ResolveInfo resolveInfo = listQueryBroadcastReceivers.get(0);
            return new android.content.ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        if (listQueryBroadcastReceivers.size() <= 1) {
            return null;
        }
        android.util.Log.w_renamed("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static void a_renamed(android.content.Context context, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    private static android.content.ComponentName a_renamed(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        android.content.Intent intent = new android.content.Intent(str);
        intent.setPackage(context.getPackageName());
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            android.content.pm.ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            return new android.content.ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        throw new java.lang.IllegalStateException("Expected 1 service that handles " + str + ", found " + listQueryIntentServices.size());
    }
}
