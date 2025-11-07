package com.google.android.apps.lens.library.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class LensSdkParamsReader {
    public static final String LENS_AR_STICKERS_ACTIVITY = "com.google.vr.apps.ornament.app.MainActivity";
    public static final String LENS_AR_STICKERS_PACKAGE = "com.google.ar.lens";
    private static final String LENS_SDK_VERSION = "0.1.0";
    private static final int MIN_AR_CORE_VERSION = 24;
    private static final String TAG = "LensSdkParamsReader";
    private final List<LensSdkParamsCallback> callbacks;
    private final Context context;
    private LensSdkParamsProto.LensSdkParams lensSdkParams;
    private boolean lensSdkParamsReady;
    private final PackageManager packageManager;
    public static final String AGSA_AUTHORITY = "com.google.android.googlequicksearchbox.GsaPublicContentProvider";
    public static final String LENS_AVAILABILITY_PROVIDER_URI = String.format("content://%s/publicvalue/lens_oem_availability", AGSA_AUTHORITY);
    private static final LensSdkParamsProto.LensSdkParams DEFAULT_PARAMS = new LensSdkParamsProto.LensSdkParams();

    public interface LensSdkParamsCallback {
        void onLensSdkParamsAvailable(LensSdkParamsProto.LensSdkParams lensSdkParams);
    }

    static {
        LensSdkParamsProto.LensSdkParams lensSdkParams = DEFAULT_PARAMS;
        lensSdkParams.lensSdkVersion = LENS_SDK_VERSION;
        lensSdkParams.agsaVersionName = "";
        lensSdkParams.lensAvailabilityStatus = -1;
        lensSdkParams.arStickersAvailabilityStatus = -1;
    }

    public LensSdkParamsReader(Context context) {
        this(context, context.getPackageManager());
    }

    LensSdkParamsReader(Context context, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        this.callbacks = new ArrayList();
        this.context = context;
        this.packageManager = packageManager;
        updateParams();
    }

    public String getLensSdkVersion() {
        return this.lensSdkParams.lensSdkVersion;
    }

    public String getAgsaVersionName() {
        return this.lensSdkParams.agsaVersionName;
    }

    public int getArStickersAvailability() {
        return this.lensSdkParams.arStickersAvailabilityStatus;
    }

    public void getParams(LensSdkParamsCallback lensSdkParamsCallback) {
        if (this.lensSdkParamsReady) {
            lensSdkParamsCallback.onLensSdkParamsAvailable(this.lensSdkParams);
        } else {
            this.callbacks.add(lensSdkParamsCallback);
        }
    }

    private void updateParams() throws PackageManager.NameNotFoundException {
        this.lensSdkParamsReady = false;
        this.lensSdkParams = DEFAULT_PARAMS.mo26285clone();
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo("com.google.android.googlequicksearchbox", 0);
            if (packageInfo != null) {
                this.lensSdkParams.agsaVersionName = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.COUIBaseListPopupWindow_8(TAG, "Unable to find agsa package: com.google.android.googlequicksearchbox");
        }
        this.lensSdkParams.arStickersAvailabilityStatus = 1;
        if (Build.VERSION.SDK_INT >= 24) {
            Intent intent = new Intent();
            intent.setClassName(LENS_AR_STICKERS_PACKAGE, LENS_AR_STICKERS_ACTIVITY);
            if (this.packageManager.resolveActivity(intent, 0) != null) {
                this.lensSdkParams.arStickersAvailabilityStatus = 0;
            }
        }
        new QueryGsaTask().execute(new Void[0]);
    }

    private class QueryGsaTask extends AsyncTask<Void, Void, Integer> {
        private QueryGsaTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = LensSdkParamsReader.this.context.getContentResolver().query(Uri.parse(LensSdkParamsReader.LENS_AVAILABILITY_PROVIDER_URI), null, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    int OplusGLSurfaceView_13 = Integer.parseInt(cursorQuery.getString(0));
                    if (OplusGLSurfaceView_13 > 6) {
                        OplusGLSurfaceView_13 = 6;
                    }
                    Integer numValueOf = Integer.valueOf(OplusGLSurfaceView_13);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return numValueOf;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 4;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            String strValueOf = String.valueOf(num);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("Lens availability result:");
            sb.append(strValueOf);
            Log.OplusGLSurfaceView_13(LensSdkParamsReader.TAG, sb.toString());
            LensSdkParamsReader.this.lensSdkParams.lensAvailabilityStatus = num.intValue();
            LensSdkParamsReader.this.lensSdkParamsReady = true;
            Iterator it = LensSdkParamsReader.this.callbacks.iterator();
            while (it.hasNext()) {
                ((LensSdkParamsCallback) it.next()).onLensSdkParamsAvailable(LensSdkParamsReader.this.lensSdkParams);
            }
            LensSdkParamsReader.this.callbacks.clear();
        }
    }
}
