package com.google.android.apps.lens.library.base;

/* loaded from: classes.dex */
public class LensSdkParamsReader {
    public static final java.lang.String LENS_AR_STICKERS_ACTIVITY = "com.google.vr.apps.ornament.app.MainActivity";
    public static final java.lang.String LENS_AR_STICKERS_PACKAGE = "com.google.ar_renamed.lens";
    private static final java.lang.String LENS_SDK_VERSION = "0.1.0";
    private static final int MIN_AR_CORE_VERSION = 24;
    private static final java.lang.String TAG = "LensSdkParamsReader";
    private final java.util.List<com.google.android.apps.lens.library.base.LensSdkParamsReader.LensSdkParamsCallback> callbacks;
    private final android.content.Context context;
    private com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams lensSdkParams;
    private boolean lensSdkParamsReady;
    private final android.content.pm.PackageManager packageManager;
    public static final java.lang.String AGSA_AUTHORITY = "com.google.android.googlequicksearchbox.GsaPublicContentProvider";
    public static final java.lang.String LENS_AVAILABILITY_PROVIDER_URI = java.lang.String.format("content://%s_renamed/publicvalue/lens_oem_availability", AGSA_AUTHORITY);
    private static final com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams DEFAULT_PARAMS = new com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams();

    public interface LensSdkParamsCallback {
        void onLensSdkParamsAvailable(com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams lensSdkParams);
    }

    static {
        com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto.LensSdkParams lensSdkParams = DEFAULT_PARAMS;
        lensSdkParams.lensSdkVersion = LENS_SDK_VERSION;
        lensSdkParams.agsaVersionName = "";
        lensSdkParams.lensAvailabilityStatus = -1;
        lensSdkParams.arStickersAvailabilityStatus = -1;
    }

    public LensSdkParamsReader(android.content.Context context) {
        this(context, context.getPackageManager());
    }

    LensSdkParamsReader(android.content.Context context, android.content.pm.PackageManager packageManager) throws android.content.pm.PackageManager.NameNotFoundException {
        this.callbacks = new java.util.ArrayList();
        this.context = context;
        this.packageManager = packageManager;
        updateParams();
    }

    public java.lang.String getLensSdkVersion() {
        return this.lensSdkParams.lensSdkVersion;
    }

    public java.lang.String getAgsaVersionName() {
        return this.lensSdkParams.agsaVersionName;
    }

    public int getArStickersAvailability() {
        return this.lensSdkParams.arStickersAvailabilityStatus;
    }

    public void getParams(com.google.android.apps.lens.library.base.LensSdkParamsReader.LensSdkParamsCallback lensSdkParamsCallback) {
        if (this.lensSdkParamsReady) {
            lensSdkParamsCallback.onLensSdkParamsAvailable(this.lensSdkParams);
        } else {
            this.callbacks.add(lensSdkParamsCallback);
        }
    }

    private void updateParams() throws android.content.pm.PackageManager.NameNotFoundException {
        this.lensSdkParamsReady = false;
        this.lensSdkParams = DEFAULT_PARAMS.mo19clone();
        try {
            android.content.pm.PackageInfo packageInfo = this.packageManager.getPackageInfo("com.google.android.googlequicksearchbox", 0);
            if (packageInfo != null) {
                this.lensSdkParams.agsaVersionName = packageInfo.versionName;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            android.util.Log.e_renamed(TAG, "Unable to find agsa package: com.google.android.googlequicksearchbox");
        }
        this.lensSdkParams.arStickersAvailabilityStatus = 1;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName(LENS_AR_STICKERS_PACKAGE, LENS_AR_STICKERS_ACTIVITY);
            if (this.packageManager.resolveActivity(intent, 0) != null) {
                this.lensSdkParams.arStickersAvailabilityStatus = 0;
            }
        }
        new com.google.android.apps.lens.library.base.LensSdkParamsReader.QueryGsaTask().execute(new java.lang.Void[0]);
    }

    private class QueryGsaTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Integer> {
        private QueryGsaTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public java.lang.Integer doInBackground(java.lang.Void... voidArr) {
            android.database.Cursor cursor = null;
            try {
                android.database.Cursor cursorQuery = com.google.android.apps.lens.library.base.LensSdkParamsReader.this.context.getContentResolver().query(android.net.Uri.parse(com.google.android.apps.lens.library.base.LensSdkParamsReader.LENS_AVAILABILITY_PROVIDER_URI), null, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    int i_renamed = java.lang.Integer.parseInt(cursorQuery.getString(0));
                    if (i_renamed > 6) {
                        i_renamed = 6;
                    }
                    java.lang.Integer numValueOf = java.lang.Integer.valueOf(i_renamed);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return numValueOf;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 4;
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Integer num) {
            java.lang.String strValueOf = java.lang.String.valueOf(num);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(strValueOf).length() + 25);
            sb.append("Lens availability result:");
            sb.append(strValueOf);
            android.util.Log.i_renamed(com.google.android.apps.lens.library.base.LensSdkParamsReader.TAG, sb.toString());
            com.google.android.apps.lens.library.base.LensSdkParamsReader.this.lensSdkParams.lensAvailabilityStatus = num.intValue();
            com.google.android.apps.lens.library.base.LensSdkParamsReader.this.lensSdkParamsReady = true;
            java.util.Iterator it = com.google.android.apps.lens.library.base.LensSdkParamsReader.this.callbacks.iterator();
            while (it.hasNext()) {
                ((com.google.android.apps.lens.library.base.LensSdkParamsReader.LensSdkParamsCallback) it.next()).onLensSdkParamsAvailable(com.google.android.apps.lens.library.base.LensSdkParamsReader.this.lensSdkParams);
            }
            com.google.android.apps.lens.library.base.LensSdkParamsReader.this.callbacks.clear();
        }
    }
}
