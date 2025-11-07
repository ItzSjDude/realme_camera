package com.google.lens.sdk;

/* loaded from: classes.dex */
public class LensApi {
    static final java.lang.String LENS_BITMAP_URI_KEY = "LensBitmapUriKey";
    static final java.lang.String LENS_DEEPLINKING_STRING = "googleapp://lens";
    static final android.net.Uri LENS_DEEPLINKING_URI = android.net.Uri.parse(LENS_DEEPLINKING_STRING);
    private static final java.lang.String TAG = "LensApi";
    private final android.content.Context context;
    private final com.google.android.apps.lens.library.base.LensSdkParamsReader paramsReader;
    private final com.google.android.apps.lens.library.base.LensServiceBridge serviceBridge;

    public interface LensAvailabilityCallback {
        void onAvailabilityStatusFetched(@com.google.lens.sdk.LensApi.LensAvailabilityStatus int i_renamed);
    }

    public @interface LensAvailabilityStatus {
        public static final int LENS_READY = 0;
        public static final int LENS_UNAVAILABLE = 1;
        public static final int LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE = 3;
        public static final int LENS_UNAVAILABLE_DEVICE_LOCKED = 5;
        public static final int LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED = 2;
        public static final int LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE = 6;
    }

    public @interface LensFeature {
        public static final int LENS_AR_STICKERS = 1;
        public static final int LENS_CORE = 0;
    }

    private static final class LensSdkParamsCallback implements com.google.android.apps.lens.library.base.LensSdkParamsReader.LensSdkParamsCallback {
        private final com.google.lens.sdk.LensApi.LensAvailabilityCallback lensAvailabilityCallback;

        LensSdkParamsCallback(com.google.lens.sdk.LensApi.LensAvailabilityCallback lensAvailabilityCallback) {
            this.lensAvailabilityCallback = lensAvailabilityCallback;
        }

        @Override // com.google.android.apps.lens.library.base.LensSdkParamsReader.LensSdkParamsCallback
        public void onLensSdkParamsAvailable(com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams lensSdkParams) {
            this.lensAvailabilityCallback.onAvailabilityStatusFetched(com.google.lens.sdk.LensApi.mapInternalLensAvailabilityToExternal(lensSdkParams.lensAvailabilityStatus));
        }
    }

    public LensApi(android.content.Context context) {
        this.context = context;
        this.paramsReader = new com.google.android.apps.lens.library.base.LensSdkParamsReader(context);
        this.serviceBridge = new com.google.android.apps.lens.library.base.LensServiceBridge(context);
    }

    public void onResume() {
        this.serviceBridge.bindService();
    }

    public void onPause() {
        this.serviceBridge.unbindService();
    }

    public void launchLensActivity(final android.app.Activity activity) {
        android.app.KeyguardManager keyguardManager = (android.app.KeyguardManager) activity.getSystemService("keyguard");
        if (keyguardManager.isKeyguardLocked()) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                keyguardManager.requestDismissKeyguard(activity, new android.app.KeyguardManager.KeyguardDismissCallback() { // from class: com.google.lens.sdk.LensApi.1
                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissSucceeded() {
                        android.util.Log.d_renamed(com.google.lens.sdk.LensApi.TAG, "Keyguard successfully dismissed");
                        com.google.lens.sdk.LensApi.this.startLensActivity(activity);
                    }

                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissError() {
                        android.util.Log.e_renamed(com.google.lens.sdk.LensApi.TAG, "Error dismissing keyguard");
                    }

                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissCancelled() {
                        android.util.Log.d_renamed(com.google.lens.sdk.LensApi.TAG, "Keyguard dismiss cancelled");
                    }
                });
                return;
            }
            int i_renamed = android.os.Build.VERSION.SDK_INT;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
            sb.append("Cannot start Lens when device is_renamed locked with Android ");
            sb.append(i_renamed);
            android.util.Log.e_renamed(TAG, sb.toString());
            return;
        }
        startLensActivity(activity);
    }

    public void launchLensActivity(android.app.Activity activity, @com.google.lens.sdk.LensApi.LensFeature int i_renamed) {
        if (i_renamed == 0) {
            launchLensActivity(activity);
            return;
        }
        if (i_renamed == 1) {
            if (this.paramsReader.getArStickersAvailability() == 0) {
                android.content.Intent intent = new android.content.Intent();
                intent.setClassName(com.google.android.apps.lens.library.base.LensSdkParamsReader.LENS_AR_STICKERS_PACKAGE, com.google.android.apps.lens.library.base.LensSdkParamsReader.LENS_AR_STICKERS_ACTIVITY);
                activity.startActivity(intent);
                return;
            }
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(34);
        sb.append("Invalid lens activity: ");
        sb.append(i_renamed);
        android.util.Log.w_renamed(TAG, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLensActivity(android.app.Activity activity) {
        if (this.serviceBridge.prewarmLensActivity()) {
            android.util.Log.i_renamed(TAG, "Lens is_renamed pre-warmed.");
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(LENS_DEEPLINKING_STRING));
        activity.startActivityForResult(intent, 0);
    }

    public void launchLensActivityWithBitmapUri(android.app.Activity activity, android.net.Uri uri) {
        if (uri == null) {
            android.util.Log.e_renamed(TAG, "Image URI is_renamed null!");
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(appendBitmapUri(LENS_DEEPLINKING_URI, uri));
        activity.startActivityForResult(intent, 0);
    }

    public void checkLensAvailability(com.google.lens.sdk.LensApi.LensAvailabilityCallback lensAvailabilityCallback) {
        if (((android.app.KeyguardManager) this.context.getSystemService("keyguard")).isKeyguardLocked() && android.os.Build.VERSION.SDK_INT < 26) {
            lensAvailabilityCallback.onAvailabilityStatusFetched(5);
        } else {
            this.paramsReader.getParams(new com.google.lens.sdk.LensApi.LensSdkParamsCallback(lensAvailabilityCallback));
        }
    }

    public void checkArStickersAvailability(com.google.lens.sdk.LensApi.LensAvailabilityCallback lensAvailabilityCallback) {
        lensAvailabilityCallback.onAvailabilityStatusFetched(mapInternalLensAvailabilityToExternal(this.paramsReader.getArStickersAvailability()));
    }

    private android.net.Uri appendBitmapUri(android.net.Uri uri, android.net.Uri uri2) {
        return (uri == null || uri2 == null) ? uri : uri.buildUpon().appendQueryParameter(LENS_BITMAP_URI_KEY, uri2.toString()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.lens.sdk.LensApi.LensAvailabilityStatus
    public static int mapInternalLensAvailabilityToExternal(int i_renamed) {
        if (i_renamed == 0 || i_renamed == 1 || i_renamed == 2 || i_renamed == 3 || i_renamed == 5 || i_renamed == 6) {
            return i_renamed;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
        sb.append("Internal error code: ");
        sb.append(i_renamed);
        android.util.Log.d_renamed(TAG, sb.toString());
        return 1;
    }
}
