package com.oplus.camera.util;

/* loaded from: classes2.dex */
public class Util {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f7297a = 480;
    private static java.text.DecimalFormat aw_renamed = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static int f7298b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static float f7299c = 0.0f;
    public static int d_renamed = 20;
    private static java.lang.reflect.Field l_renamed;
    private static final java.lang.String m_renamed = com.oplus.camera.v_renamed.d_renamed();
    private static final java.lang.String n_renamed = com.oplus.camera.v_renamed.b_renamed();
    private static float o_renamed = 1.0f;
    private static com.oplus.camera.util.Util.a_renamed p_renamed = null;
    private static boolean q_renamed = false;
    private static boolean r_renamed = false;
    private static boolean s_renamed = false;
    private static boolean t_renamed = false;
    private static boolean u_renamed = false;
    private static boolean v_renamed = false;
    private static boolean w_renamed = false;
    private static boolean x_renamed = false;
    private static boolean y_renamed = false;
    public static java.lang.String e_renamed = null;
    private static java.lang.String z_renamed = null;
    private static java.lang.String A_renamed = null;
    private static android.graphics.Typeface B_renamed = null;
    private static java.lang.String C_renamed = null;
    private static java.lang.String D_renamed = null;
    private static java.lang.String E_renamed = null;
    private static java.lang.String F_renamed = null;
    private static java.lang.Object G_renamed = new java.lang.Object();
    private static java.lang.Object H_renamed = new java.lang.Object();
    private static android.location.LocationManager I_renamed = null;
    private static android.content.Context J_renamed = null;
    private static android.os.Handler K_renamed = null;
    private static com.coui.appcompat.dialog.app.b_renamed L_renamed = null;
    private static java.lang.Thread M_renamed = null;
    private static android.renderscript.RenderScript N_renamed = null;
    private static android.renderscript.ScriptIntrinsicBlur O_renamed = null;
    private static java.util.HashMap<java.lang.String, java.lang.Boolean> P_renamed = null;
    private static android.os.HandlerThread Q_renamed = null;
    private static android.os.Handler R_renamed = null;
    private static android.view.Display S_renamed = null;
    private static android.util.ArrayMap<java.lang.Integer, java.lang.Integer> T_renamed = new android.util.ArrayMap<>();
    private static android.graphics.Typeface U_renamed = null;
    private static android.graphics.Typeface V_renamed = null;
    private static android.graphics.Typeface W_renamed = null;
    private static android.graphics.Typeface X_renamed = null;
    private static android.graphics.Typeface Y_renamed = null;
    private static android.graphics.Typeface Z_renamed = null;
    private static android.graphics.Typeface aa_renamed = null;
    private static int ab_renamed = 0;
    private static int ac_renamed = 0;
    private static int ad_renamed = 0;
    private static int ae_renamed = 0;
    private static int af_renamed = 0;
    private static int ag_renamed = 0;
    private static int ah_renamed = 0;
    private static int ai_renamed = 0;
    private static int aj_renamed = 0;
    private static int ak_renamed = 0;
    private static int al_renamed = 0;
    private static int am_renamed = 120000;
    private static double an_renamed = 0.8d;
    private static boolean ao_renamed = false;
    private static boolean ap_renamed = false;
    private static boolean aq_renamed = false;
    private static boolean ar_renamed = false;
    private static boolean as_renamed = false;
    private static java.lang.Object at_renamed = new java.lang.Object();
    private static java.lang.Object au_renamed = new java.lang.Object();
    private static java.lang.Boolean av_renamed = null;
    private static java.util.HashMap<java.lang.Integer, android.animation.AnimatorSet> ax_renamed = new java.util.HashMap<>();
    private static android.util.Size ay_renamed = new android.util.Size(0, 0);
    private static java.lang.Boolean az_renamed = null;
    private static java.lang.Boolean aA_renamed = null;
    public static int f_renamed = 4;
    public static int g_renamed = 8;
    public static int h_renamed = 0;
    public static int i_renamed = -1;
    public static int j_renamed = -2;
    public static boolean k_renamed = false;
    private static android.view.WindowManager aB_renamed = null;
    private static int aC_renamed = -1;
    private static boolean aD_renamed = false;
    private static final int[] aE_renamed = new int[2];

    public static int V_renamed() {
        return 988;
    }

    public static float a_renamed(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public static int a_renamed(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static java.lang.String a_renamed(int i2) {
        if (i2 == 17) {
            return "yuv420sp";
        }
        if (i2 == 32) {
            return "raw";
        }
        if (i2 == 256) {
            return com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
        }
        switch (i2) {
            case 35:
                return "yuv420sp";
            case 36:
            case 37:
            case 38:
                return "raw";
            default:
                return null;
        }
    }

    public static boolean a_renamed(android.net.Uri uri, java.lang.String str, int i2, int i3) {
        return uri != null && str != null && i2 < 0 && i3 < 0;
    }

    public static boolean ak_renamed() {
        return true;
    }

    public static float b_renamed(float f2) {
        float f3 = 4.0f > f2 ? 5.0f * ((f2 - 1.0f) / 3.0f) : 5.0f;
        if (0.0f > f3) {
            return 0.0f;
        }
        return f3;
    }

    public static int b_renamed(int i2, int i3) {
        if (i2 > 45) {
            return 180;
        }
        if (i2 < -45) {
            return 0;
        }
        if (i3 >= 45) {
            return 90;
        }
        return i3 > -45 ? 0 : 270;
    }

    public static java.lang.String b_renamed(boolean z2) {
        return z2 ? com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    public static boolean d_renamed(int i2) {
        return i2 == 1 || i2 == 5;
    }

    public static boolean g_renamed(int i2) {
        return i2 == 2;
    }

    public static native boolean nativeGetYuvDataWithoutPadding(android.hardware.HardwareBuffer hardwareBuffer, java.nio.ByteBuffer byteBuffer, int i2);

    static {
        java.lang.System.loadLibrary("preview_show");
        T_renamed.put(java.lang.Integer.valueOf(com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT), 420);
        T_renamed.put(java.lang.Integer.valueOf(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT), java.lang.Integer.valueOf(com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480));
        T_renamed.put(1440, 640);
    }

    public static void a_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed("Util", "attachBaseContext, context: " + context);
        J_renamed = context;
    }

    public static void b_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed("attachApplication");
        J_renamed = context;
        q_renamed = h_renamed("oplus.software.video.wnr_support");
        com.oplus.camera.e_renamed.b_renamed("attachApplication");
    }

    public static synchronized void c_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed("Util", "initialize, sbInit: " + ar_renamed);
        if (!ar_renamed) {
            com.oplus.camera.e_renamed.a_renamed("initialize");
            com.oplus.camera.ui.control.e_renamed.a_renamed();
            at_renamed();
            com.oplus.camera.q_renamed.a_renamed.a_renamed(context, (com.oplus.camera.q_renamed.a_renamed.DocumentUtil_2) null);
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            com.oplus.camera.e_renamed.a_renamed("Util", "displaycontent, getDefaultDisplay().getHeight(): " + windowManager.getDefaultDisplay().getHeight() + " wm.getDefaultDisplay().getWidth(): " + windowManager.getDefaultDisplay().getWidth() + " metrics.density: " + displayMetrics.density + " metrics.densityDpi: " + displayMetrics.densityDpi);
            o_renamed = displayMetrics.density;
            K_renamed = new android.os.Handler(context.getMainLooper());
            f_renamed(context);
            q_renamed(J_renamed);
            m_renamed();
            a_renamed(true);
            ad_renamed();
            com.oplus.camera.e_renamed.b_renamed("initialize");
        }
        com.oplus.camera.e_renamed.a_renamed("Util", "initialize X_renamed");
    }

    public static synchronized void d_renamed(android.content.Context context) {
        if (!as_renamed) {
            H_renamed(context);
            I_renamed(context);
            e_renamed(context);
            as_renamed = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:8:0x0024, code lost:
    
        com.oplus.camera.util.Util.x_renamed = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void H_renamed(android.content.Context r2) {
        /*
            java.lang.String r0 = "audio"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            java.util.List r2 = r2.getMicrophones()     // Catch: java.io.IOException -> L28
            java.util.Iterator r2 = r2.iterator()     // Catch: java.io.IOException -> L28
        L10:
            boolean r0 = r2.hasNext()     // Catch: java.io.IOException -> L28
            if (r0 == 0) goto L2c
            java.lang.Object r0 = r2.next()     // Catch: java.io.IOException -> L28
            android.media.MicrophoneInfo r0 = (android.media.MicrophoneInfo) r0     // Catch: java.io.IOException -> L28
            r1 = 15
            int r0 = r0.getType()     // Catch: java.io.IOException -> L28
            if (r1 != r0) goto L10
            r2 = 1
            com.oplus.camera.util.Util.x_renamed = r2     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r2 = move-exception
            r2.printStackTrace()
        L2c:
            boolean r2 = com.oplus.camera.util.Util.x_renamed
            if (r2 != 0) goto L37
            java.lang.String r2 = "Util"
            java.lang.String r0 = "checkMicrophoneDevice, No Microphone Device!"
            com.oplus.camera.e_renamed.f_renamed(r2, r0)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.H_renamed(android.content.Context):void");
    }

    private static void I_renamed(android.content.Context context) {
        android.media.AudioManager audioManager = (android.media.AudioManager) context.getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
        E_renamed = audioManager.getParameters("surround_record");
        F_renamed = audioManager.getParameters("vendor_audiorecord_track_support");
        com.oplus.camera.e_renamed.c_renamed("Util", "checkAudioSurroundRecord, sSurroundRecord: " + E_renamed);
    }

    public static void e_renamed(android.content.Context context) {
        if ("yes".equals(((android.media.AudioManager) context.getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO)).getParameters("binaural_recording_standby"))) {
            ap_renamed = true;
        }
        com.oplus.camera.e_renamed.c_renamed("Util", "checkAudioBinauralRecord, sbBinauralRecordSupport: " + ap_renamed);
    }

    public static boolean a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("Util", "isBinauralRecordSupport, sbBinauralRecordSupport: " + ap_renamed);
        return ap_renamed;
    }

    public static boolean b_renamed() {
        return s_renamed;
    }

    public static boolean c_renamed() {
        return t_renamed;
    }

    public static boolean d_renamed() {
        return u_renamed;
    }

    public static synchronized void f_renamed(android.content.Context context) {
        boolean zY = y_renamed(context);
        if (S_renamed.getDisplayId() == 0 && zY) {
            f7297a = T_renamed.get(java.lang.Integer.valueOf(S_renamed.getMode().getPhysicalWidth())).intValue();
        } else {
            try {
                f7297a = com.oplus.compat.view.WindowManagerNative.getInitialDisplayDensity(0);
            } catch (android.os.RemoteException | com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
                e2.printStackTrace();
            }
        }
        if (-1 != aC_renamed) {
            i_renamed = aC_renamed;
        } else {
            i_renamed = e_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("Util", "initializeDefaultDisplay, acquire sDefaultDensity: " + f7297a);
    }

    public static int e_renamed() {
        int i2 = android.provider.Settings.Global.getInt(J_renamed.getContentResolver(), "oplus_system_folding_angle", -1);
        com.oplus.camera.e_renamed.a_renamed("Util", "getFolderAngle, folderAngle: " + i2);
        return i2;
    }

    public static void f_renamed() {
        int i2 = aC_renamed;
        if (i2 != -1) {
            i_renamed = i2;
        } else {
            i_renamed = e_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("Util", "updateFolderAngle, sFoldAngle: " + i_renamed);
    }

    public static int g_renamed() {
        int i2;
        if (t_renamed()) {
            i2 = u_renamed() ? 1 : 0;
        } else {
            i2 = -1;
        }
        com.oplus.camera.e_renamed.b_renamed("Util", "getFoldingMode, foldingMode: " + i2);
        return i2;
    }

    public static int h_renamed() {
        return android.provider.Settings.Global.getInt(J_renamed.getContentResolver(), "oplus_emulate_software_folding_mode", -1);
    }

    public static void a_renamed(int i2, int i3) {
        int[] iArr = aE_renamed;
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public static boolean i_renamed() {
        boolean z2;
        com.oplus.camera.e_renamed.a_renamed("Util", "getInitState, sbInit: " + ar_renamed);
        synchronized (at_renamed) {
            z2 = ar_renamed;
        }
        return z2;
    }

    public static void a_renamed(boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("Util", "setInitState, sbInit: " + z2);
        synchronized (at_renamed) {
            ar_renamed = z2;
        }
    }

    public static void j_renamed() {
        synchronized (au_renamed) {
            if (Q_renamed == null) {
                Q_renamed = new android.os.HandlerThread("WorkerThread");
                Q_renamed.start();
            }
            if (R_renamed == null) {
                R_renamed = new android.os.Handler(Q_renamed.getLooper());
            }
        }
    }

    public static void a_renamed(java.lang.Runnable runnable) {
        if (R_renamed == null) {
            j_renamed();
        }
        R_renamed.post(runnable);
    }

    public static void b_renamed(java.lang.Runnable runnable) {
        android.os.Handler handler = R_renamed;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static void k_renamed() {
        android.os.Handler handler = R_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            R_renamed = null;
        }
        android.os.HandlerThread handlerThread = Q_renamed;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            Q_renamed = null;
        }
    }

    public static android.content.Context l_renamed() {
        return J_renamed;
    }

    public static void m_renamed() {
        if (M_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("Util", "initRenderScript, sRSInitThread not null, so return");
        } else {
            M_renamed = new java.lang.Thread(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.e_renamed.b_renamed("Util", "intRenderScript");
                    if (com.oplus.camera.util.Util.J_renamed == null) {
                        return;
                    }
                    synchronized (com.oplus.camera.util.Util.G_renamed) {
                        android.renderscript.RenderScript unused = com.oplus.camera.util.Util.N_renamed = android.renderscript.RenderScript.create(com.oplus.camera.util.Util.J_renamed);
                        android.renderscript.ScriptIntrinsicBlur unused2 = com.oplus.camera.util.Util.O_renamed = android.renderscript.ScriptIntrinsicBlur.create(com.oplus.camera.util.Util.N_renamed, android.renderscript.Element.U8_4(com.oplus.camera.util.Util.N_renamed));
                    }
                    com.oplus.camera.e_renamed.b_renamed("Util", "intRenderScript X_renamed");
                }
            });
            M_renamed.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x003d A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a_renamed(android.graphics.Bitmap r3, int r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 == 0) goto L46
            boolean r1 = r3.isRecycled()
            if (r1 == 0) goto La
            goto L46
        La:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r1.<init>()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            r3.compress(r2, r4, r1)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            byte[] r3 = r1.toByteArray()     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            int r4 = r4.length     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            byte[] r0 = java.util.Arrays.copyOf(r3, r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3a
            r1.close()     // Catch: java.lang.Exception -> L25
            goto L39
        L25:
            r3 = move-exception
            r3.printStackTrace()
            goto L39
        L2a:
            r3 = move-exception
            goto L31
        L2c:
            r3 = move-exception
            r1 = r0
            goto L3b
        L2f:
            r3 = move-exception
            r1 = r0
        L31:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.lang.Exception -> L25
        L39:
            return r0
        L3a:
            r3 = move-exception
        L3b:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Exception -> L41
            goto L45
        L41:
            r4 = move-exception
            r4.printStackTrace()
        L45:
            throw r3
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.a_renamed(android.graphics.Bitmap, int):byte[]");
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static android.graphics.Bitmap b_renamed(android.graphics.Bitmap bitmap) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(1.0f, -1.0f);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void n_renamed() throws java.lang.InterruptedException {
        java.lang.Thread thread = M_renamed;
        if (thread != null) {
            try {
                thread.join();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        synchronized (G_renamed) {
            if (O_renamed != null) {
                O_renamed.destroy();
                O_renamed = null;
            }
            if (N_renamed != null) {
                try {
                    N_renamed.destroy();
                    N_renamed = null;
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    com.oplus.camera.e_renamed.f_renamed("Util", "finishRSInitThread, renderScript destroy, exception: " + e3.getMessage());
                }
            }
        }
        com.oplus.camera.e_renamed.b_renamed("Util", "finishRSInitThread X_renamed");
    }

    public static int a_renamed(float f2) {
        return java.lang.Math.round(o_renamed * f2);
    }

    public static float o_renamed() {
        return o_renamed;
    }

    public static android.graphics.Bitmap b_renamed(android.graphics.Bitmap bitmap, int i2) {
        return a_renamed(bitmap, i2, false);
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i2, boolean z2) {
        if ((i2 == 0 && !z2) || bitmap == null) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        if (z2) {
            matrix.postScale(-1.0f, 1.0f);
            i2 = (i2 + 360) % 360;
            if (i2 == 0 || i2 == 180) {
                matrix.postTranslate(bitmap.getWidth(), 0.0f);
            } else if (i2 == 90 || i2 == 270) {
                matrix.postTranslate(bitmap.getHeight(), 0.0f);
            } else {
                throw new java.lang.IllegalArgumentException("Invalid degrees: " + i2);
            }
        }
        if (i2 != 0) {
            matrix.postRotate(i2, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        }
        try {
            android.graphics.Bitmap bitmapA = a_renamed(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapA) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapA;
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static int a_renamed(android.graphics.BitmapFactory.Options options, int i2, int i3) {
        int iB = b_renamed(options, i2, i3);
        if (iB > 8) {
            return 8 * ((iB + 7) / 8);
        }
        int i4 = 1;
        while (i4 < iB) {
            i4 <<= 1;
        }
        return i4;
    }

    private static int b_renamed(android.graphics.BitmapFactory.Options options, int i2, int i3) {
        int iMin;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int iCeil = i3 < 0 ? 1 : (int) java.lang.Math.ceil(java.lang.Math.sqrt((d2 * d3) / i3));
        if (i2 < 0) {
            iMin = 128;
        } else {
            double d4 = i2;
            iMin = (int) java.lang.Math.min(java.lang.Math.floor(d2 / d4), java.lang.Math.floor(d3 / d4));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i3 >= 0 || i2 >= 0) {
            return i2 < 0 ? iCeil : iMin;
        }
        return 1;
    }

    public static android.graphics.Bitmap a_renamed(byte[] bArr, int i2) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                options.inSampleSize = a_renamed(options, -1, i2);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
                return android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            return null;
        } catch (java.lang.OutOfMemoryError e2) {
            com.oplus.camera.e_renamed.d_renamed("Util", "Got oom exception ", e2);
            return null;
        }
    }

    public static void a_renamed(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean p_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = L_renamed;
        return bVar != null && bVar.isShowing();
    }

    public static void a_renamed(final android.app.Activity activity, final int i2) {
        com.oplus.camera.e_renamed.f_renamed("Util", "showErrorAndFinish, Some Error occurs, Error id_renamed: " + i2 + ", activty: " + activity);
        if (activity == null) {
            return;
        }
        K_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.3
            @Override // java.lang.Runnable
            public void run() {
                android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.util.Util.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(android.content.DialogInterface dialogInterface, int i3) {
                        activity.finish();
                    }
                };
                if (com.oplus.camera.util.Util.L_renamed != null) {
                    com.oplus.camera.util.Util.L_renamed.cancel();
                    com.coui.appcompat.dialog.app.b_renamed unused = com.oplus.camera.util.Util.L_renamed = null;
                }
                com.coui.appcompat.dialog.app.b_renamed unused2 = com.oplus.camera.util.Util.L_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).setCancelable(false).setIconAttribute(android.R_renamed.attr.alertDialogIcon).setTitle(i2).setNeutralButton(com.oplus.camera.R_renamed.string.camera_button_ok, onClickListener).show();
            }
        });
    }

    public static void q_renamed() {
        android.os.Handler handler = K_renamed;
        if (handler == null || L_renamed == null) {
            return;
        }
        handler.post(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.4
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("Util", "cancleOpenCameraFailDialog(), sOpenCameraFailDialog: " + com.oplus.camera.util.Util.L_renamed);
                if (com.oplus.camera.util.Util.L_renamed != null) {
                    com.oplus.camera.util.Util.L_renamed.cancel();
                    com.coui.appcompat.dialog.app.b_renamed unused = com.oplus.camera.util.Util.L_renamed = null;
                }
            }
        });
    }

    public static int a_renamed(android.app.Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static int c_renamed(int i2, int i3) {
        boolean z2 = true;
        if (i3 != -1) {
            int iAbs = java.lang.Math.abs(i2 - i3);
            if (java.lang.Math.min(iAbs, 360 - iAbs) < 65) {
                z2 = false;
            }
        }
        return z2 ? (((i2 + 30) / 90) * 90) % 360 : i3;
    }

    public static android.util.Size a_renamed(java.util.List<android.util.Size> list, double d2) {
        return a_renamed(list, d2, 0);
    }

    public static android.util.Size a_renamed(java.util.List<android.util.Size> list, double d2, int i2) {
        android.util.Size size = null;
        if (list == null) {
            return null;
        }
        int iAbs = Integer.MAX_VALUE;
        int i3 = ab_renamed;
        for (android.util.Size size2 : list) {
            double width = size2.getWidth() / size2.getHeight();
            double d3 = 538982489 == i2 ? 0.002d : 0.01d;
            if (java.lang.Math.abs(width - d2) <= d3) {
                if (u_renamed()) {
                    i3 = java.lang.Math.abs(width - 0.9333333333333333d) < d3 ? 1440 : com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT;
                }
                int iAbs2 = java.lang.Math.abs(size2.getHeight() - i3);
                if (iAbs2 < iAbs) {
                    iAbs = java.lang.Math.abs(size2.getHeight() - i3);
                } else if (iAbs2 != iAbs || size2.getHeight() <= i3) {
                }
                size = size2;
            }
        }
        if (size == null) {
            for (android.util.Size size3 : list) {
                if (java.lang.Math.abs((size3.getWidth() / size3.getHeight()) - d2) <= 0.03d) {
                    int iAbs3 = java.lang.Math.abs(size3.getHeight() - i3);
                    if (iAbs3 < iAbs) {
                        iAbs = java.lang.Math.abs(size3.getHeight() - i3);
                    } else if (iAbs3 != iAbs || size3.getHeight() <= i3) {
                    }
                    size = size3;
                }
            }
        }
        if (size != null) {
            com.oplus.camera.e_renamed.a_renamed("Util", "getOptimalPreviewSize, screen: " + ab_renamed + "x_renamed" + ac_renamed + ", targetRatio: " + d2 + ", optimalSize: " + size.getHeight() + "x_renamed" + size.getWidth());
        } else {
            com.oplus.camera.e_renamed.f_renamed("Util", "getOptimalPreviewSize, optimalSize is_renamed null");
        }
        return size;
    }

    public static boolean a_renamed(android.util.Size size, double d2) {
        return java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - d2) < 0.05d;
    }

    public static android.util.Size a_renamed(java.util.List<android.util.Size> list, final int i2, final int i3) {
        if (list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("Util", "getOptimalBigSizeByTargetSize, size is_renamed empty");
            return null;
        }
        return list.stream().filter(com.oplus.camera.util.$$Lambda$bdDB5qtJ9up3KI34bjHEph1ELg.INSTANCE).filter(new java.util.function.Predicate() { // from class: com.oplus.camera.util.-$$Lambda$Util$DBGNOagioPDoHzan1N4T4F80efc
            @Override // java.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.oplus.camera.util.Util.a_renamed(i2, i3, (android.util.Size) obj);
            }
        }).min(new java.util.Comparator() { // from class: com.oplus.camera.util.-$$Lambda$Util$bocYwBQLMmJRgXeP5jItCElMHEU
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.oplus.camera.util.Util.b_renamed((android.util.Size) obj, (android.util.Size) obj2);
            }
        }).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a_renamed(int i2, int i3, android.util.Size size) {
        return 0.05d >= java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - (((double) i2) / ((double) i3))) && size.getWidth() >= i2 && size.getHeight() >= i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b_renamed(android.util.Size size, android.util.Size size2) {
        return (size.getHeight() + size.getWidth()) - (size2.getWidth() + size2.getHeight());
    }

    public static android.util.Size b_renamed(java.util.List<android.util.Size> list, double d2) {
        return b_renamed(list, d2, -1);
    }

    public static android.util.Size b_renamed(java.util.List<android.util.Size> list, double d2, int i2) {
        return a_renamed(list, d2, i2, -1);
    }

    public static android.util.Size a_renamed(java.util.List<android.util.Size> list, double d2, int i2, int i3) {
        android.util.Size size = null;
        if (list != null && list.size() != 0) {
            for (android.util.Size size2 : list) {
                if (java.lang.Math.abs((size2.getWidth() / size2.getHeight()) - d2) <= 0.01d && (-1 == i2 || size2.getHeight() <= i2)) {
                    if (-1 == i3 || size2.getWidth() <= i3) {
                        if (size == null || size.getHeight() < size2.getHeight()) {
                            size = size2;
                        }
                    }
                }
            }
            if (size != null) {
                com.oplus.camera.e_renamed.a_renamed("Util", "getMaxSizeByRatio, size: " + size.getHeight() + "x_renamed" + size.getWidth() + ", targetRatio: " + d2);
            } else {
                com.oplus.camera.e_renamed.f_renamed("Util", "getMaxSizeByRatio, optimalSize is_renamed null");
            }
        }
        return size;
    }

    public static android.util.Size c_renamed(java.util.List<android.util.Size> list, double d2) {
        return c_renamed(list, d2, -1);
    }

    public static android.util.Size c_renamed(java.util.List<android.util.Size> list, double d2, int i2) {
        android.util.Size size = null;
        if (list != null && list.size() != 0) {
            for (android.util.Size size2 : list) {
                if (java.lang.Math.abs((size2.getWidth() / size2.getHeight()) - d2) <= 0.05d && (-1 == i2 || size2.getHeight() <= i2)) {
                    if (size == null || size.getHeight() < size2.getHeight()) {
                        size = size2;
                    }
                }
            }
            if (size != null) {
                com.oplus.camera.e_renamed.a_renamed("Util", "getImpreciseMaxSizeByRatio, size: " + size.getHeight() + "x_renamed" + size.getWidth() + ", targetRatio: " + d2);
            } else {
                com.oplus.camera.e_renamed.f_renamed("Util", "getImpreciseMaxSizeByRatio, optimalSize is_renamed null");
            }
        }
        return size;
    }

    public static android.util.Size a_renamed(int i2, java.util.List<android.util.Size> list, double d2) {
        int iAbs = Integer.MAX_VALUE;
        android.util.Size size = null;
        for (android.util.Size size2 : list) {
            if (java.lang.Math.abs((size2.getWidth() / size2.getHeight()) - d2) <= 0.01d && java.lang.Math.abs(size2.getHeight() - i2) < iAbs) {
                iAbs = java.lang.Math.abs(size2.getHeight() - i2);
                size = size2;
            }
        }
        return size;
    }

    public static int a_renamed(java.lang.String str) {
        if ("standard".equals(str) || "standard_high".equals(str)) {
            return 0;
        }
        if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(str)) {
            return Y_renamed();
        }
        if ("square".equals(str)) {
            return 2;
        }
        return "16_9".equals(str) ? 1 : -1;
    }

    public static java.lang.String a_renamed(android.util.Size size, int i2) {
        if (size == null) {
            return com.oplus.camera.statistics.model.DcsMsgData.FULL;
        }
        android.util.Size sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, i2);
        return (sizeConfigValue != null && sizeConfigValue.getWidth() == size.getWidth() && sizeConfigValue.getHeight() == size.getHeight()) ? "standard_high" : java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.3333333333333333d) < 0.01d ? "standard" : java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.0d) < 0.01d ? "square" : java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.7777777777777777d) < 0.01d ? "16_9" : com.oplus.camera.statistics.model.DcsMsgData.FULL;
    }

    public static android.util.Size a_renamed(java.util.List<android.util.Size> list, java.lang.String str, int i2) {
        android.util.Size size = null;
        if (list == null || list.size() == 0 || str == null) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getMinDiffPictureSize error!");
            return null;
        }
        long jAbs = Long.MAX_VALUE;
        for (android.util.Size size2 : list) {
            if (d_renamed(size2.getWidth(), size2.getHeight()) == i2 && jAbs > java.lang.Math.abs(java.lang.Long.valueOf(str).longValue() - (size2.getWidth() * size2.getHeight()))) {
                jAbs = java.lang.Math.abs(java.lang.Long.valueOf(str).longValue() - (size2.getWidth() * size2.getHeight()));
                size = size2;
            }
        }
        return size;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x00b5 A_renamed[Catch: all -> 0x00d0, PHI: r2
      0x00b5: PHI (r2v1 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v2 android.database.Cursor) binds: [B_renamed:47:0x00c1, B_renamed:40:0x00b3] A_renamed[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B_renamed:8:0x0024, B_renamed:18:0x0049, B_renamed:30:0x009a, B_renamed:36:0x00aa, B_renamed:41:0x00b5, B_renamed:53:0x00cc, B_renamed:54:0x00cf, B_renamed:20:0x0063, B_renamed:22:0x0069, B_renamed:24:0x0088, B_renamed:28:0x0093, B_renamed:34:0x00a3, B_renamed:46:0x00bc), top: B_renamed:66:0x001c, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:75:0x00d3 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a_renamed(android.net.Uri r12, android.content.ContentResolver r13) throws java.lang.Throwable {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isUriValid, uri: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Util"
            com.oplus.camera.e_renamed.a_renamed(r1, r0)
            r0 = 0
            if (r12 != 0) goto L1a
            return r0
        L1a:
            r2 = 0
            r3 = 1
            java.lang.String r4 = "r_renamed"
            android.os.ParcelFileDescriptor r4 = r13.openFileDescriptor(r12, r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            if (r4 != 0) goto L3e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            r5.<init>()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            java.lang.String r6 = "isUriValid, Fail to open uri: "
            r5.append(r6)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            r5.append(r12)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            com.oplus.camera.e_renamed.f_renamed(r1, r5)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> Ld0
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Exception -> L3d
        L3d:
            return r0
        L3e:
            if (r4 == 0) goto L43
            r4.close()     // Catch: java.lang.Exception -> L43
        L43:
            return r3
        L44:
            r12 = move-exception
            r4 = r2
            goto Ld1
        L48:
            r4 = r2
        L49:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            r5.<init>()     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r6 = "isUriValid, IOException: "
            r5.append(r6)     // Catch: java.lang.Throwable -> Ld0
            r5.append(r12)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Ld0
            com.oplus.camera.e_renamed.f_renamed(r1, r5)     // Catch: java.lang.Throwable -> Ld0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r6 = r13
            r7 = r12
            android.database.Cursor r2 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r2 == 0) goto Lb3
            r2.moveToFirst()     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r12 = "_data"
            int r12 = r2.getColumnIndex(r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r12 = r2.getString(r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r13 = "is_pending"
            int r13 = r2.getColumnIndex(r13)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            int r13 = r2.getInt(r13)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            java.lang.String r5 = "_tmp"
            boolean r5 = r12.contains(r5)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r5 != 0) goto La3
            java.lang.String r5 = "dng"
            boolean r12 = r12.contains(r5)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r12 == 0) goto L91
            goto La3
        L91:
            if (r3 != r13) goto Lb3
            java.lang.String r12 = "isUriValid, but from IS_PENDING file!"
            com.oplus.camera.e_renamed.f_renamed(r1, r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r2 == 0) goto L9d
            r2.close()     // Catch: java.lang.Throwable -> Ld0
        L9d:
            if (r4 == 0) goto La2
            r4.close()     // Catch: java.lang.Exception -> La2
        La2:
            return r3
        La3:
            java.lang.String r12 = "isUriValid, but from tmp file!"
            com.oplus.camera.e_renamed.f_renamed(r1, r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            if (r2 == 0) goto Lad
            r2.close()     // Catch: java.lang.Throwable -> Ld0
        Lad:
            if (r4 == 0) goto Lb2
            r4.close()     // Catch: java.lang.Exception -> Lb2
        Lb2:
            return r3
        Lb3:
            if (r2 == 0) goto Lc4
        Lb5:
            r2.close()     // Catch: java.lang.Throwable -> Ld0
            goto Lc4
        Lb9:
            r12 = move-exception
            goto Lca
        Lbb:
            r12 = move-exception
            java.lang.String r13 = "isUriValid, get cursor failed!"
            com.oplus.camera.e_renamed.d_renamed(r1, r13, r12)     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto Lc4
            goto Lb5
        Lc4:
            if (r4 == 0) goto Lc9
            r4.close()     // Catch: java.lang.Exception -> Lc9
        Lc9:
            return r0
        Lca:
            if (r2 == 0) goto Lcf
            r2.close()     // Catch: java.lang.Throwable -> Ld0
        Lcf:
            throw r12     // Catch: java.lang.Throwable -> Ld0
        Ld0:
            r12 = move-exception
        Ld1:
            if (r4 == 0) goto Ld6
            r4.close()     // Catch: java.lang.Exception -> Ld6
        Ld6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.a_renamed(android.net.Uri, android.content.ContentResolver):boolean");
    }

    public static synchronized java.lang.String a_renamed(long j2) {
        return a_renamed(j2, false);
    }

    public static synchronized java.lang.String a_renamed(long j2, boolean z2) {
        if (p_renamed == null) {
            p_renamed = new com.oplus.camera.util.Util.a_renamed(J_renamed.getString(com.oplus.camera.R_renamed.string.camera_image_file_name_format));
        }
        return p_renamed.a_renamed(j2, z2);
    }

    public static synchronized java.lang.String b_renamed(long j2) {
        if (p_renamed == null) {
            p_renamed = new com.oplus.camera.util.Util.a_renamed(J_renamed.getString(com.oplus.camera.R_renamed.string.camera_image_file_name_format));
        }
        return p_renamed.a_renamed(j2);
    }

    public static void a_renamed(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < (i2 >> 1); i8++) {
                int i9 = i6 + i8;
                byte b2 = bArr[i9];
                int i10 = ((i6 + i2) - 1) - i8;
                bArr[i9] = bArr[i10];
                bArr[i10] = b2;
            }
            i6 += i4;
        }
        int i11 = i5 * i4;
        for (int i12 = 0; i12 < (i3 >> 1); i12++) {
            for (int i13 = 0; i13 < (i2 >> 1); i13 += 2) {
                int i14 = i11 + i13;
                byte b3 = bArr[i14];
                int i15 = i11 + i2;
                int i16 = (i15 - 2) - i13;
                bArr[i14] = bArr[i16];
                bArr[i16] = b3;
                int i17 = i14 + 1;
                byte b4 = bArr[i17];
                int i18 = (i15 - 1) - i13;
                bArr[i17] = bArr[i18];
                bArr[i18] = b4;
            }
            i11 += i4;
        }
    }

    public static byte[] a_renamed(byte[] bArr, int i2, int i3, int i4, int i5, boolean z2) {
        byte[] bArr2 = new byte[((i2 * i3) * 3) >> 1];
        int i6 = i3 >> 1;
        int i7 = (i3 - 1) * i4;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i2) {
            int i10 = i7;
            int i11 = i9;
            int i12 = 0;
            while (i12 < i3) {
                bArr2[i11] = bArr[i10 + i8];
                i10 -= i4;
                i12++;
                i11++;
            }
            i8++;
            i9 = i11;
        }
        int i13 = (((i3 / 2) + i5) - 1) * i4;
        for (int i14 = 0; i14 < i2; i14 += 2) {
            int i15 = i13;
            for (int i16 = 0; i16 < i6; i16++) {
                if (z2) {
                    int i17 = i9 + 1;
                    bArr2[i9] = bArr[i15 + 1 + i14];
                    i9 = i17 + 1;
                    bArr2[i17] = bArr[i15 + i14];
                } else {
                    int i18 = i9 + 1;
                    bArr2[i9] = bArr[i15 + i14];
                    i9 = i18 + 1;
                    bArr2[i18] = bArr[i15 + 1 + i14];
                }
                i15 -= i4;
            }
        }
        return bArr2;
    }

    public static byte[] a_renamed(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[(i4 * 3) >> 1];
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = i3 - 1;
            while (i7 >= 0) {
                bArr2[i5] = bArr[(i2 * i7) + i6];
                i7--;
                i5++;
            }
        }
        for (int i8 = 0; i8 < i2; i8 += 2) {
            for (int i9 = (i3 >> 1) - 1; i9 >= 0; i9--) {
                int i10 = (i2 * i9) + i4 + i8;
                bArr2[i5] = bArr[i10];
                bArr2[i5 + 1] = bArr[i10 + 1];
                i5 += 2;
            }
        }
        return bArr2;
    }

    public static byte[] b_renamed(byte[] bArr, int i2, int i3) {
        int i4 = i3 >> 1;
        int i5 = i2 * i3;
        byte[] bArr2 = new byte[(i5 * 3) >> 1];
        int i6 = i2 - 1;
        int i7 = i6;
        int i8 = 0;
        while (i7 >= 0) {
            int i9 = i8;
            int i10 = 0;
            while (i10 < i3) {
                bArr2[i9] = bArr[(i2 * i10) + i7];
                i10++;
                i9++;
            }
            i7--;
            i8 = i9;
        }
        while (i6 > 0) {
            for (int i11 = 0; i11 < i4; i11++) {
                int i12 = i8 + 1;
                int i13 = (i2 * i11) + i5 + i6;
                bArr2[i8] = bArr[i13 - 1];
                i8 = i12 + 1;
                bArr2[i12] = bArr[i13];
            }
            i6 -= 2;
        }
        return bArr2;
    }

    public static void a_renamed(android.graphics.Bitmap bitmap, java.io.File file) throws java.io.IOException {
        try {
            java.io.OutputStream outputStreamA = com.oplus.camera.q_renamed.a_renamed.a_renamed(file.getAbsolutePath(), "image/png");
            try {
                bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, outputStreamA);
                outputStreamA.flush();
                if (outputStreamA != null) {
                    outputStreamA.close();
                }
            } finally {
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a_renamed(android.graphics.Bitmap bitmap, java.lang.String str) throws java.io.IOException {
        java.lang.String absolutePath = J_renamed.getExternalFilesDir(str).getAbsolutePath();
        if (!new java.io.File(absolutePath).exists() && !com.oplus.camera.q_renamed.a_renamed.f_renamed(absolutePath)) {
            com.oplus.camera.e_renamed.f_renamed("Util", "saveBitmap, mkdirs fail");
            return;
        }
        a_renamed(bitmap, new java.io.File(absolutePath, a_renamed(java.lang.System.currentTimeMillis()) + ".png"));
    }

    public static synchronized void r_renamed() {
        if (p_renamed != null) {
            p_renamed.a_renamed();
        }
    }

    public static java.lang.String[] b_renamed(int i2, int i3, int i4) {
        int i5 = (((((i2 * (-38)) - (i3 * 74)) + (i4 * 112)) + 128) >> 8) + 128;
        int i6 = (((((i2 * 112) - (i3 * 94)) - (i4 * 18)) + 128) >> 8) + 128;
        int i7 = 255;
        if (i6 < 0) {
            i6 = 0;
        } else if (i6 > 255) {
            i6 = 255;
        }
        if (i5 < 0) {
            i7 = 0;
        } else if (i5 <= 255) {
            i7 = i5;
        }
        return new java.lang.String[]{java.lang.String.valueOf(i6), java.lang.String.valueOf(i7)};
    }

    public static void a_renamed(android.content.Context context, java.lang.String str) {
        if (str != null) {
            android.media.MediaScannerConnection.scanFile(context, new java.lang.String[]{str}, null, null);
        }
    }

    public static void a_renamed(android.content.Context context, android.net.Uri uri, java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("Util", "broadcastNewPicture, uri: " + uri);
        context.sendBroadcast(new android.content.Intent("android.hardware.action.NEW_PICTURE", uri));
        context.sendBroadcast(new android.content.Intent("com.android.camera.NEW_PICTURE", uri));
        a_renamed(context, uri, "com.oplus.camera.NEW_PICTURE", aP_renamed());
        a_renamed(context, uri, "com.oplus.camera.NEW_PICTURE", "com.heytap.cloud");
        if (str != null) {
            android.media.MediaScannerConnection.scanFile(context, new java.lang.String[]{str}, null, null);
        }
        com.oplus.camera.e_renamed.a_renamed("Util", "++broadcastNewPicture, uri: " + uri);
    }

    public static void a_renamed(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(str, uri);
        intent.setPackage(str2);
        context.sendBroadcast(intent);
    }

    public static void a_renamed(final android.view.View view, final int i2, int i3, android.view.animation.Interpolator interpolator, android.animation.Animator.AnimatorListener animatorListener) {
        if (view == null || i3 < 0) {
            return;
        }
        if (i3 == 0) {
            view.setBackgroundColor(i2);
            return;
        }
        view.animate().cancel();
        android.graphics.drawable.Drawable background = view.getBackground();
        final int alpha = background != null ? background.getAlpha() : 0;
        final int iAlpha = android.graphics.Color.alpha(i2) - alpha;
        if (iAlpha == 0) {
            return;
        }
        view.animate().setInterpolator(interpolator).setListener(animatorListener).setUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.util.Util.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                java.lang.Float f2 = (java.lang.Float) valueAnimator.getAnimatedValue();
                android.view.View view2 = view;
                if (view2 != null) {
                    view2.setBackgroundColor(android.graphics.Color.argb(alpha + ((int) (iAlpha * f2.floatValue())), android.graphics.Color.red(i2), android.graphics.Color.green(i2), android.graphics.Color.blue(i2)));
                }
            }
        }).setDuration(i3).start();
    }

    public static void a_renamed(android.view.View view, int i2, android.view.animation.Animation.AnimationListener animationListener, long j2) {
        a_renamed(view, i2, animationListener, j2, 0L, (android.view.animation.Interpolator) null);
    }

    public static void a_renamed(android.view.View view, int i2, android.view.animation.Animation.AnimationListener animationListener, long j2, long j3, android.view.animation.Interpolator interpolator) {
        a_renamed(view, i2, animationListener, j2, j3, interpolator, 0.0f, 0.0f);
    }

    public static void a_renamed(android.view.View view, int i2, android.view.animation.Animation.AnimationListener animationListener, long j2, long j3, android.view.animation.Interpolator interpolator, float f2, float f3) {
        android.view.animation.AlphaAnimation alphaAnimation;
        android.view.animation.TranslateAnimation translateAnimation;
        if (view == null || view.getVisibility() == i2) {
            return;
        }
        if (8 == i2 && 4 == view.getVisibility()) {
            return;
        }
        if (4 == i2 && 8 == view.getVisibility()) {
            return;
        }
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        if (i2 == 0) {
            alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        }
        animationSet.addAnimation(alphaAnimation);
        if (i2 == 0) {
            translateAnimation = new android.view.animation.TranslateAnimation(f2, 0.0f, f3, 0.0f);
        } else {
            translateAnimation = new android.view.animation.TranslateAnimation(0.0f, f2, 0.0f, f3);
        }
        animationSet.addAnimation(translateAnimation);
        if (animationListener == null) {
            view.setVisibility(i2);
        }
        if (interpolator != null) {
            animationSet.setInterpolator(interpolator);
        }
        animationSet.setAnimationListener(animationListener);
        animationSet.setDuration(j2);
        animationSet.setStartOffset(j3);
        view.clearAnimation();
        view.startAnimation(animationSet);
    }

    public static void a_renamed(android.view.View view, int i2, float f2, float f3, android.view.animation.Interpolator interpolator, long j2, android.view.animation.Interpolator interpolator2, long j3, android.view.animation.Animation.AnimationListener animationListener, long j4) {
        android.view.animation.AlphaAnimation alphaAnimation;
        android.view.animation.TranslateAnimation translateAnimation;
        if (view == null || view.getVisibility() == i2) {
            return;
        }
        if (8 == i2 && 4 == view.getVisibility()) {
            return;
        }
        if (4 == i2 && 8 == view.getVisibility()) {
            return;
        }
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        if (i2 == 0) {
            alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        }
        if (interpolator != null) {
            alphaAnimation.setInterpolator(interpolator);
        }
        alphaAnimation.setDuration(j2);
        animationSet.addAnimation(alphaAnimation);
        if (i2 == 0) {
            translateAnimation = new android.view.animation.TranslateAnimation(f2, 0.0f, f3, 0.0f);
        } else {
            translateAnimation = new android.view.animation.TranslateAnimation(0.0f, f2, 0.0f, f3);
        }
        if (interpolator2 != null) {
            animationSet.setInterpolator(interpolator2);
        }
        translateAnimation.setDuration(j3);
        animationSet.addAnimation(translateAnimation);
        if (animationListener == null) {
            view.setVisibility(i2);
        }
        animationSet.setAnimationListener(animationListener);
        animationSet.setStartOffset(j4);
        view.clearAnimation();
        view.startAnimation(animationSet);
    }

    public static void a_renamed(final android.view.View view, final boolean z2, float f2, float f3, android.animation.TimeInterpolator timeInterpolator, long j2, android.animation.TimeInterpolator timeInterpolator2, long j3, android.animation.Animator.AnimatorListener animatorListener, long j4) {
        android.animation.ObjectAnimator objectAnimatorOfFloat;
        android.animation.ObjectAnimator objectAnimatorOfFloat2;
        android.animation.Animator.AnimatorListener animatorListener2 = animatorListener;
        com.oplus.camera.e_renamed.a_renamed("Util", "setViewVisibilityWithAnimator, view: " + view + ", visible: " + z2 + ", listener: " + animatorListener2);
        if (view == null) {
            return;
        }
        if (ax_renamed.get(java.lang.Integer.valueOf(view.getId())) != null) {
            ax_renamed.get(java.lang.Integer.valueOf(view.getId())).end();
            ax_renamed.remove(java.lang.Integer.valueOf(view.getId()));
        }
        if (z2) {
            objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        }
        android.animation.ObjectAnimator objectAnimator = objectAnimatorOfFloat;
        objectAnimator.setInterpolator(timeInterpolator);
        objectAnimator.setDuration(j2);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        android.animation.AnimatorSet.Builder builderPlay = animatorSet.play(objectAnimator);
        final float translationX = view.getTranslationX();
        final float translationY = view.getTranslationY();
        view.setTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation, new android.graphics.PointF(translationX, translationY));
        if (z2) {
            if (0.0f != f2) {
                objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "translationX", translationX + f2, translationX);
            } else {
                objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "translationY", translationY + f3, translationY);
            }
        } else if (0.0f != f2) {
            objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "translationX", translationX, translationX + f2);
        } else {
            objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "translationY", translationY, translationY + f3);
        }
        android.animation.ObjectAnimator objectAnimator2 = objectAnimatorOfFloat2;
        objectAnimator2.setInterpolator(timeInterpolator2);
        objectAnimator2.setDuration(j3);
        builderPlay.with(objectAnimator2);
        animatorSet.setStartDelay(j4);
        final boolean zIsClickable = view.isClickable();
        if (animatorListener2 == null) {
            animatorListener2 = new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.util.Util.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (z2) {
                        view.setAlpha(0.0f);
                    } else {
                        view.setAlpha(1.0f);
                    }
                    view.setVisibility(0);
                    view.setClickable(false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.a_renamed("Util", "onAnimationCancel, view: " + view + ", visible: " + z2);
                    view.setVisibility(z2 ? 0 : 8);
                    view.setAlpha(z2 ? 1.0f : 0.0f);
                    java.lang.Object tag = view.getTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation);
                    if (tag instanceof android.graphics.PointF) {
                        android.graphics.PointF pointF = (android.graphics.PointF) tag;
                        view.setTranslationX(pointF.x_renamed);
                        view.setTranslationY(pointF.y_renamed);
                    } else {
                        view.setTranslationX(translationX);
                        view.setTranslationY(translationY);
                    }
                    view.setClickable(zIsClickable);
                    com.oplus.camera.util.Util.ax_renamed.remove(java.lang.Integer.valueOf(view.getId()));
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.a_renamed("Util", "onAnimationEnd, view: " + view + ", visible: " + z2);
                    if (!z2) {
                        view.setVisibility(4);
                    }
                    view.setAlpha(z2 ? 1.0f : 0.0f);
                    java.lang.Object tag = view.getTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation);
                    if (tag instanceof android.graphics.PointF) {
                        android.graphics.PointF pointF = (android.graphics.PointF) tag;
                        view.setTranslationX(pointF.x_renamed);
                        view.setTranslationY(pointF.y_renamed);
                    } else {
                        view.setTranslationX(translationX);
                        view.setTranslationY(translationY);
                    }
                    com.oplus.camera.util.Util.ax_renamed.remove(java.lang.Integer.valueOf(view.getId()));
                    view.setClickable(zIsClickable);
                }
            };
        }
        ax_renamed.put(java.lang.Integer.valueOf(view.getId()), animatorSet);
        animatorSet.addListener(animatorListener2);
        animatorSet.start();
    }

    public static void a_renamed(android.view.View view, float f2, float f3, long j2, long j3, android.view.animation.Animation.AnimationListener animationListener, android.view.animation.Interpolator interpolator) {
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(f2, f3);
        alphaAnimation.setAnimationListener(animationListener);
        alphaAnimation.setDuration(j2);
        alphaAnimation.setStartOffset(j3);
        if (interpolator != null) {
            alphaAnimation.setInterpolator(interpolator);
        }
        view.startAnimation(alphaAnimation);
    }

    public static void a_renamed(android.view.View view, float f2, float f3, long j2, android.view.animation.Animation.AnimationListener animationListener, android.view.animation.Interpolator interpolator) {
        a_renamed(view, f2, f3, j2, 0L, animationListener, interpolator);
    }

    public static void a_renamed(android.view.View view) {
        a_renamed(view, 400);
    }

    public static void a_renamed(android.view.View view, int i2) {
        if (view == null) {
            return;
        }
        a_renamed(view, 0.0f, 1.0f, i2, (android.view.animation.Animation.AnimationListener) null, (android.view.animation.Interpolator) null);
        view.setEnabled(true);
    }

    public static void a_renamed(android.view.View view, int i2, android.view.animation.Interpolator interpolator) {
        if (view == null) {
            return;
        }
        a_renamed(view, 0.0f, 1.0f, i2, (android.view.animation.Animation.AnimationListener) null, interpolator);
        view.setEnabled(true);
    }

    public static void b_renamed(android.view.View view) {
        b_renamed(view, 400);
    }

    public static void b_renamed(android.view.View view, int i2) {
        a_renamed(view, i2, 0, (android.view.animation.Interpolator) null);
    }

    public static void a_renamed(android.view.View view, int i2, int i3, android.view.animation.Interpolator interpolator) {
        if (view != null && view.getVisibility() == 0) {
            view.setEnabled(false);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(i2);
            alphaAnimation.setStartOffset(i3);
            if (interpolator != null) {
                alphaAnimation.setInterpolator(interpolator);
            }
            view.startAnimation(alphaAnimation);
            view.setVisibility(8);
        }
    }

    public static android.graphics.Bitmap c_renamed(android.graphics.Bitmap bitmap) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(bitmap.getWidth(), 0.0f);
        try {
            android.graphics.Bitmap bitmapA = a_renamed(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapA) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapA;
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static void s_renamed() {
        synchronized (H_renamed) {
            if (P_renamed != null) {
                P_renamed.clear();
                P_renamed = null;
            }
        }
    }

    public static byte[] a_renamed(byte[] bArr, int i2, int i3, int i4) {
        if (bArr == null) {
            com.oplus.camera.e_renamed.f_renamed("Util", "cutYUV420SP, Error: data is_renamed null!");
            return null;
        }
        int i5 = i2 * i3;
        if (bArr.length < i5 * 1.5f) {
            com.oplus.camera.e_renamed.f_renamed("Util", "cutYUV420SP, Error, width: " + i2 + ", height: " + i3 + ", data.length: " + bArr.length);
            return null;
        }
        int i6 = (i2 - (i2 % i4)) / i4;
        int i7 = (i3 - (i3 % i4)) / i4;
        if (i7 % 2 != 0) {
            i7++;
        }
        byte[] bArr2 = new byte[((i6 * i7) * 3) / 2];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            for (int i11 = 0; i11 < i6; i11++) {
                bArr2[i10] = bArr[(i8 * i4 * i2) + (i11 * i4)];
                i10++;
            }
            i8++;
            i9 = i10;
        }
        int i12 = 0;
        while (i12 < i7 / 2) {
            int i13 = i9;
            for (int i14 = 0; i14 < i6 / 2; i14++) {
                int i15 = (i12 * i4 * i2) + i5;
                int i16 = i14 * 2 * i4;
                bArr2[i13] = bArr[i15 + i16];
                int i17 = i13 + 1;
                bArr2[i17] = bArr[i15 + i16 + 1];
                i13 = i17 + 1;
            }
            i12++;
            i9 = i13;
        }
        return bArr2;
    }

    public static int[] c_renamed(byte[] bArr, int i2, int i3) {
        com.oplus.camera.e_renamed.a_renamed("Util", "decodeYUV420SP, width: " + i2 + ", height: " + i3);
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = 0;
            int i8 = 0;
            int i9 = ((i5 >> 1) * i2) + i4;
            int i10 = i6;
            int i11 = 0;
            while (i11 < i2) {
                int i12 = (bArr[i10] & 255) - 16;
                if (i12 < 0) {
                    i12 = 0;
                }
                if ((i11 & 1) == 0) {
                    int i13 = i9 + 1;
                    int i14 = (bArr[i9] & 255) - 128;
                    int i15 = i13 + 1;
                    i7 = (bArr[i13] & 255) - 128;
                    i8 = i14;
                    i9 = i15;
                }
                int i16 = (i12 + 10) * 1192;
                int i17 = (i8 * 1634) + i16;
                int i18 = (i16 - (i8 * 833)) - (i7 * 400);
                int i19 = i16 + (i7 * 2066);
                int i20 = 262143;
                if (i17 < 0) {
                    i17 = 0;
                } else if (i17 > 262143) {
                    i17 = 262143;
                }
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                if (i19 < 0) {
                    i20 = 0;
                } else if (i19 <= 262143) {
                    i20 = i19;
                }
                iArr[i10] = (-16777216) | ((i17 << 6) & 16711680) | ((i18 >> 2) & 65280) | ((i20 >> 10) & 255);
                i11++;
                i10++;
            }
            i5++;
            i6 = i10;
        }
        com.oplus.camera.e_renamed.a_renamed("Util", "decodeYUV420SP X_renamed");
        return iArr;
    }

    public static byte[] b_renamed(byte[] bArr, int i2, int i3, int i4, int i5) {
        com.oplus.camera.e_renamed.a_renamed("Util", "yuvDropPadding, nv21: " + bArr + ", width: " + i2 + ", height: " + i3 + ", stride: " + i4 + ", scanLine: " + i5);
        if (i2 == i4 && i3 == i5) {
            return bArr;
        }
        if (i5 > i3) {
            bArr = c_renamed(bArr, i4, i3, i5);
        }
        return i4 > i2 ? b_renamed(bArr, i2, i3, i4) : bArr;
    }

    private static byte[] b_renamed(byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2 = new byte[((i3 * i2) * 3) >> 1];
        int i5 = 0;
        int i6 = 0;
        while (i5 < bArr.length) {
            java.lang.System.arraycopy(bArr, i5, bArr2, i6, i2);
            i6 += i2;
            i5 += i4;
        }
        return bArr2;
    }

    private static byte[] c_renamed(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i3 * i2;
        int i6 = i2 * i4;
        int i7 = (i5 * 3) >> 1;
        byte[] bArr2 = new byte[i7];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i5);
        java.lang.System.arraycopy(bArr, i6, bArr2, i5, i7 - i5);
        return bArr2;
    }

    public static void d_renamed(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = (i4 * 3) >> 1;
        while (i4 < i5) {
            byte b2 = bArr[i4];
            int i6 = i4 + 1;
            bArr[i4] = bArr[i6];
            bArr[i6] = b2;
            i4 += 2;
        }
    }

    public static byte[] e_renamed(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[(i4 * 3) >> 1];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i4);
        int i5 = i4 - 1;
        int i6 = (i4 * 5) / 4;
        int i7 = 0;
        for (int i8 = 0; i8 < i4 / 2; i8 += 2) {
            bArr2[i4 + i7] = bArr[i5 + i8];
            bArr2[i6 + i7] = bArr[i4 + i8];
            i7++;
        }
        return bArr2;
    }

    public static android.graphics.Bitmap b_renamed(byte[] bArr, int i2, int i3, int i4, int i5, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("Util", "yuvToBitmap, width: " + i2 + ", height: " + i3 + ", orientation: " + i4 + ", scale: " + i5 + ", mirror: " + z2);
        int i6 = i3 / i5;
        if (i6 % 2 != 0) {
            i6++;
        }
        byte[] bArrA = a_renamed(bArr, i2, i3, i5);
        if (bArrA == null) {
            return null;
        }
        int i7 = i2 / i5;
        android.graphics.Bitmap bitmapA = a_renamed(a_renamed(c_renamed(bArrA, i7, i6), i7, i6, android.graphics.Bitmap.Config.ARGB_8888), i4, z2);
        com.oplus.camera.e_renamed.a_renamed("Util", "yuvToBitmap X_renamed, bitmap width: " + bitmapA.getWidth() + ", height: " + bitmapA.getHeight());
        return bitmapA;
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, float f2) {
        android.graphics.Bitmap bitmapA;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        synchronized (G_renamed) {
            if (N_renamed == null) {
                N_renamed = android.renderscript.RenderScript.create(J_renamed);
            }
            if (O_renamed == null) {
                O_renamed = android.renderscript.ScriptIntrinsicBlur.create(N_renamed, android.renderscript.Element.U8_4(N_renamed));
            }
            java.lang.System.currentTimeMillis();
            O_renamed.setRadius(f2);
            bitmapA = a_renamed(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            android.renderscript.Allocation allocationCreateFromBitmap = android.renderscript.Allocation.createFromBitmap(N_renamed, bitmap);
            android.renderscript.Allocation allocationCreateFromBitmap2 = android.renderscript.Allocation.createFromBitmap(N_renamed, bitmapA);
            O_renamed.setInput(allocationCreateFromBitmap);
            O_renamed.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapA);
            allocationCreateFromBitmap.destroy();
            allocationCreateFromBitmap2.destroy();
        }
        return bitmapA;
    }

    public static void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, java.lang.String str) throws java.io.IOException {
        com.oplus.camera.e_renamed.f_renamed("Util", "dumpAndSaveTexture, dumpDir: " + str);
        a_renamed(c_renamed(cVar.e_renamed(), cVar.h_renamed(), cVar.i_renamed()), str);
    }

    public static void a_renamed(int i2, int i3, int i4, java.lang.String str) throws java.io.IOException {
        com.oplus.camera.e_renamed.f_renamed("Util", "dumpAndSaveTexture, dumpDir: " + str);
        a_renamed(c_renamed(i2, i3, i4), str);
    }

    public static android.graphics.Bitmap c_renamed(int i2, int i3, int i4) {
        int[] iArr = new int[1];
        android.graphics.Bitmap bitmapA = a_renamed(i3, i4, android.graphics.Bitmap.Config.ARGB_8888);
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, iArr[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        new com.oplus.camera.jni.FormatConverter().glReadPixelsToBitmap(bitmapA, i3, i4, 6408, 5121);
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr, 0);
        return bitmapA;
    }

    private static java.lang.String aZ_renamed() {
        java.lang.String strI = i_renamed("ro.vendor.oplus.market.watermark");
        com.oplus.camera.e_renamed.f_renamed("Util", "getVendorMarketName, marketName: " + strI);
        if (!android.text.TextUtils.equals(strI, "")) {
            return strI;
        }
        java.lang.String strI2 = i_renamed("ro.vendor.oplus.market.enname");
        return android.text.TextUtils.equals(strI2, "") ? i_renamed("ro.vendor.oplus.market.name") : strI2;
    }

    public static boolean t_renamed() {
        if (aB_renamed == null) {
            aB_renamed = (android.view.WindowManager) J_renamed.getSystemService("window");
            android.graphics.Point point = new android.graphics.Point();
            aB_renamed.getDefaultDisplay().getRealSize(point);
            aD_renamed = 988 == java.lang.Math.min(point.x_renamed, point.y_renamed) || 1920 == java.lang.Math.max(point.x_renamed, point.y_renamed);
        }
        return aD_renamed;
    }

    public static boolean u_renamed() {
        if (!t_renamed()) {
            return false;
        }
        if (aB_renamed == null) {
            aB_renamed = (android.view.WindowManager) J_renamed.getSystemService("window");
        }
        android.graphics.Point point = new android.graphics.Point();
        aB_renamed.getDefaultDisplay().getRealSize(point);
        return 988 != java.lang.Math.min(point.x_renamed, point.y_renamed);
    }

    public static java.lang.String v_renamed() {
        java.lang.String str = z_renamed;
        if (str != null) {
            return str;
        }
        z_renamed = aZ_renamed();
        if (!android.text.TextUtils.isEmpty(z_renamed)) {
            return z_renamed;
        }
        z_renamed = i_renamed("ro.vendor.oplus.market.enname");
        if (android.text.TextUtils.equals(z_renamed, "")) {
            z_renamed = i_renamed("ro.vendor.oplus.market.name");
            if (android.text.TextUtils.equals(z_renamed, "")) {
                z_renamed = android.os.Build.MODEL;
            }
        }
        return z_renamed;
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0059: MOVE (r1 I_renamed:??[long, double]) = (r9 I_renamed:??[long, double]), block:B_renamed:30:0x0058 */
    public static long[] w_renamed() throws java.lang.Throwable {
        long j2;
        java.io.FileReader fileReader;
        long j3;
        long j4;
        java.io.BufferedReader bufferedReader;
        int i2;
        long j5 = -1;
        try {
            fileReader = new java.io.FileReader("/proc/meminfo");
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            j2 = -1;
        }
        try {
            try {
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader, 8192);
                } catch (java.lang.Exception e3) {
                    e_renamed = e3;
                    e_renamed.printStackTrace();
                    return new long[]{j2, j5};
                }
                try {
                    java.lang.String line = bufferedReader.readLine();
                    bufferedReader.readLine();
                    java.lang.String line2 = bufferedReader.readLine();
                    j2 = (line == null ? 0 : java.lang.Integer.parseInt(line.split("\\s_renamed+")[1])) * 1024;
                    if (line2 == null) {
                        i2 = 0;
                    } else {
                        try {
                            i2 = java.lang.Integer.parseInt(line2.split("\\s_renamed+")[1]);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    j5 = i2 * 1024;
                    bufferedReader.close();
                    fileReader.close();
                    return new long[]{j2, j5};
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                j3 = -1;
                try {
                    try {
                        fileReader.close();
                    } catch (java.lang.Throwable th5) {
                        th.addSuppressed(th5);
                    }
                    throw th;
                } catch (java.lang.Exception e4) {
                    e_renamed = e4;
                    j2 = j5;
                    j5 = j3;
                    e_renamed.printStackTrace();
                    return new long[]{j2, j5};
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            j3 = -1;
            j5 = j4;
            fileReader.close();
            throw th;
        }
    }

    public static android.app.ActivityManager.MemoryInfo g_renamed(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
        } catch (java.lang.Exception unused) {
        }
        com.oplus.camera.e_renamed.f_renamed("Util", "getMemoryInfo, mi.totalMem" + memoryInfo.totalMem + ", mi.availMem: " + memoryInfo.availMem);
        return memoryInfo;
    }

    public static boolean h_renamed(android.content.Context context) {
        return com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 >= g_renamed(context).totalMem;
    }

    public static boolean i_renamed(android.content.Context context) {
        return 3221225472L >= g_renamed(context).totalMem;
    }

    public static void j_renamed(android.content.Context context) {
        if (i_renamed(context)) {
            d_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LOW_MEMORY_MAX_BURST_SHOT_NUM);
        } else {
            d_renamed = 20;
        }
    }

    public static long k_renamed(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
        } catch (java.lang.Exception unused) {
        }
        com.oplus.camera.e_renamed.f_renamed("Util", "getAvailMemory, mi.availMem: " + memoryInfo.availMem);
        return memoryInfo.availMem;
    }

    public static int a_renamed(android.content.Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static android.graphics.Typeface l_renamed(android.content.Context context) {
        if (B_renamed == null) {
            B_renamed = a_renamed(context, false);
        }
        return B_renamed;
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, boolean z2) {
        android.graphics.Typeface typefaceBuild;
        android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
        try {
            android.content.res.OplusBaseConfiguration oplusBaseConfiguration = (android.content.res.OplusBaseConfiguration) com.oplus.util.OplusTypeCastingHelper.typeCasting(android.content.res.OplusBaseConfiguration.class, context.getResources().getConfiguration());
            int i2 = (oplusBaseConfiguration.mOplusExtraConfiguration.mFontVariationSettings & 61440) >> 12;
            int i3 = oplusBaseConfiguration.mOplusExtraConfiguration.mFontVariationSettings & 4095;
            if (com.oplus.util.OplusFontUtils.isFlipFontUsed) {
                return typeface;
            }
            int i4 = 700;
            try {
                if (i2 != 0) {
                    android.graphics.Typeface.Builder fontVariationSettings = new android.graphics.Typeface.Builder("sys-sans-en_renamed").setFontVariationSettings("'wght' " + i3);
                    if (!z2) {
                        i4 = 400;
                    }
                    typefaceBuild = fontVariationSettings.setWeight(i4).build();
                } else {
                    android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("sys-sans-en_renamed");
                    if (!z2) {
                        i4 = 400;
                    }
                    typefaceBuild = builder.setWeight(i4).build();
                }
                typeface = typefaceBuild;
                return typeface;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return typeface;
            }
        } catch (java.lang.NoSuchFieldError | java.lang.NoSuchMethodError e3) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getFontTypeface, error: " + e3.getMessage());
            return typeface;
        }
    }

    public static android.graphics.Typeface c_renamed(boolean z2) {
        android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
        if (z2) {
            try {
                return android.graphics.Typeface.create("sys-sans-en_renamed", 1);
            } catch (java.lang.RuntimeException unused) {
                com.oplus.camera.e_renamed.e_renamed("Util", "getSansEnTypeface, Create Typeface from /system/fonts/SysSans-En-Medium.otf failed!");
                return android.graphics.Typeface.DEFAULT_BOLD;
            }
        }
        try {
            return android.graphics.Typeface.create("sys-sans-en_renamed", 0);
        } catch (java.lang.RuntimeException unused2) {
            com.oplus.camera.e_renamed.e_renamed("Util", "getSansEnTypeface, Create Typeface from /system/fonts/SysSans-En-Regular.otf failed!");
            return android.graphics.Typeface.DEFAULT;
        }
    }

    public static android.graphics.Typeface x_renamed() {
        android.graphics.Typeface typeface = aa_renamed;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 550");
            aa_renamed = builder.build();
        } catch (java.lang.Exception unused) {
            aa_renamed = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("Util", "getSansEnRegularTypeface, create special typeface fail");
        }
        return aa_renamed;
    }

    public static android.graphics.Typeface y_renamed() {
        android.graphics.Typeface typeface = Y_renamed;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 350");
            Y_renamed = builder.build();
        } catch (java.lang.Exception unused) {
            Y_renamed = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("Util", "getSansEnLightTypeface, create special typeface fail");
        }
        return Y_renamed;
    }

    public static android.graphics.Typeface z_renamed() {
        android.graphics.Typeface typeface = U_renamed;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf");
            builder.setFontVariationSettings("'wght' 350");
            U_renamed = builder.build();
        } catch (java.lang.Exception unused) {
            U_renamed = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("Util", "getSansEnLightTypeface, create 350 weight sans typeface fail");
        }
        return U_renamed;
    }

    public static android.graphics.Typeface A_renamed() {
        android.graphics.Typeface typeface = Z_renamed;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("sys-sans-en_renamed");
            builder.setFontVariationSettings("'wght' 750");
            Z_renamed = builder.build();
        } catch (java.lang.Exception unused) {
            Z_renamed = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("Util", "getSansEnMediumTypeface, create special typeface fail");
        }
        return Z_renamed;
    }

    public static void B_renamed() {
        B_renamed = null;
        C_renamed = null;
        D_renamed = null;
        az_renamed = null;
        aA_renamed = null;
    }

    public static java.lang.String a_renamed(byte[] bArr, java.lang.String str, java.lang.String str2) {
        com.oplus.camera.e_renamed.a_renamed("Util", "saveBytesToFile, bytes: " + bArr + ", customDir: " + str + ", fileName: " + str2);
        if (bArr == null || bArr.length == 0) {
            com.oplus.camera.e_renamed.f_renamed("Util", "saveBytesToJpeg, bytes is_renamed empty");
            return null;
        }
        java.lang.String absolutePath = new java.io.File(J_renamed.getExternalFilesDir(str).getAbsolutePath(), str2).getAbsolutePath();
        if (com.oplus.camera.q_renamed.a_renamed.b_renamed(absolutePath, "image/jpeg", bArr)) {
            return absolutePath;
        }
        return null;
    }

    public static byte[] a_renamed(java.io.File file) {
        return com.oplus.camera.q_renamed.a_renamed.d_renamed(file.getAbsolutePath());
    }

    public static boolean C_renamed() {
        return y_renamed;
    }

    public static void d_renamed(boolean z2) {
        y_renamed = z2;
    }

    public static boolean m_renamed(android.content.Context context) {
        try {
            android.view.Display displayA = com.oplus.compat.content.a_renamed.a_renamed(context);
            if (displayA != null) {
                return com.oplus.compat.view.WindowManagerNative.hasNavigationBar(displayA.getDisplayId());
            }
            return false;
        } catch (android.os.RemoteException | com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a_renamed(java.lang.Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    public static boolean D_renamed() {
        return q_renamed;
    }

    public static boolean E_renamed() {
        java.lang.String str = E_renamed;
        return str == null || android.text.TextUtils.isEmpty(str) || "surround_record=ozo".equals(E_renamed);
    }

    public static boolean F_renamed() {
        return "surround_record=lvacfs".equals(E_renamed);
    }

    public static boolean G_renamed() {
        return "vendor_audiorecord_track_support=true".equals(F_renamed);
    }

    public static boolean a_renamed(android.util.Size size) {
        return c_renamed(d_renamed(size.getWidth(), size.getHeight()));
    }

    public static void b_renamed(int i2) {
        com.oplus.camera.e_renamed.a_renamed("Util", "setSizeRatioType, type: " + i2);
        h_renamed = i2;
    }

    public static int H_renamed() {
        return h_renamed;
    }

    public static void b_renamed(android.util.Size size) {
        com.oplus.camera.e_renamed.b_renamed("Util", "setPreviewSize, size: " + size);
        ay_renamed = size;
    }

    public static android.util.Size I_renamed() {
        return ay_renamed;
    }

    public static int d_renamed(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return -1;
        }
        double d2 = i2 / i3;
        if (java.lang.Math.abs(d2 - 1.3333333333333333d) < 0.01d) {
            return 0;
        }
        if (java.lang.Math.abs(d2 - 1.7777777777777777d) < 0.01d) {
            return 1;
        }
        if (java.lang.Math.abs(d2 - 1.0d) < 0.01d) {
            return 2;
        }
        if (java.lang.Math.abs(d2 - 1.5d) < 0.01d) {
            return 3;
        }
        if (java.lang.Math.abs(d2 - 1.2222222222222223d) < 0.01d) {
            return 4;
        }
        if (java.lang.Math.abs(d2 - 0.9333333333333333d) < 0.01d) {
            return 6;
        }
        if (java.lang.Math.abs(d2 - 2.3333333333333335d) < 0.01d) {
            return 7;
        }
        if (java.lang.Math.abs(d2 - X_renamed()) >= 0.01d) {
            return (!am_renamed() || java.lang.Math.abs(d2 - X_renamed()) >= 0.03d) ? -1 : 5;
        }
        return 5;
    }

    public static boolean c_renamed(int i2) {
        return !(i2 != 1 || r_renamed || t_renamed()) || i2 == 5;
    }

    public static boolean c_renamed(android.util.Size size) {
        return d_renamed(d_renamed(size.getWidth(), size.getHeight()));
    }

    public static void b_renamed(android.app.Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        int i2 = !u_renamed() ? 1 : 0;
        if (requestedOrientation != i2) {
            com.oplus.camera.e_renamed.a_renamed("Util", "setRequestedOrientation: " + requestedOrientation + " -> " + i2);
            activity.setRequestedOrientation(i2);
        }
    }

    public static void e_renamed(int i2) {
        if (i_renamed != i2) {
            com.oplus.camera.e_renamed.b_renamed("Util", "setFolderAngle, sFoldAngle: " + i_renamed + ", current: " + i2);
        }
        aC_renamed = i2;
        i_renamed = i2;
    }

    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.String f7315a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.text.SimpleDateFormat f7316b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f7317c;
        private int d_renamed;

        public a_renamed(java.lang.String str) {
            this.f7315a = str;
            this.f7316b = new java.text.SimpleDateFormat(this.f7315a, java.util.Locale.US);
        }

        public void a_renamed() {
            java.lang.String str = this.f7315a;
            if (str != null) {
                this.f7316b = new java.text.SimpleDateFormat(str, java.util.Locale.US);
            }
        }

        public java.lang.String a_renamed(long j_renamed, boolean z_renamed) {
            java.util.Date date = new java.util.Date(j_renamed);
            java.lang.String str = this.f7316b.format(date);
            if (z_renamed) {
                if (j_renamed / 1000 != this.f7317c / 1000) {
                    this.f7317c = j_renamed;
                    this.d_renamed = 0;
                }
                if (this.d_renamed < 10) {
                    str = str + "_BURST00" + this.d_renamed;
                } else {
                    str = str + "_BURST0" + this.d_renamed;
                }
                if (this.d_renamed == 0) {
                    str = str + "_COVER";
                }
                this.d_renamed++;
            } else if (j_renamed / 1000 == this.f7317c / 1000) {
                this.d_renamed++;
                if (this.d_renamed < 10) {
                    str = str + "_0" + this.d_renamed;
                } else {
                    str = str + "_" + this.d_renamed;
                }
            } else {
                this.f7317c = j_renamed;
                this.d_renamed = 0;
            }
            if (!com.oplus.camera.util.Util.am_renamed() || !z_renamed || !com.oplus.camera.util.Util.aK_renamed()) {
                return str;
            }
            java.lang.String str2 = new java.text.SimpleDateFormat("'IMG_'yyyyMMdd'_'HHmmss", java.util.Locale.US).format(date);
            if (j_renamed / 1000 != this.f7317c / 1000) {
                this.f7317c = j_renamed;
                this.d_renamed = 0;
            }
            if (this.d_renamed < 10) {
                return str2 + "_00" + this.d_renamed;
            }
            return str2 + "_0" + this.d_renamed;
        }

        public java.lang.String a_renamed(long j_renamed) {
            return this.f7316b.format(new java.util.Date(j_renamed));
        }
    }

    public static float b_renamed(byte[] bArr, int i2) {
        if (bArr == null) {
            return 0.0f;
        }
        return java.lang.Float.intBitsToFloat((int) ((bArr[i2 + 3] << 24) | (((int) ((((int) ((bArr[i2 + 0] & 255) | (bArr[i2 + 1] << 8))) & com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) | (bArr[i2 + 2] << 16))) & 16777215)));
    }

    public static int f_renamed(byte[] bArr, int i2, int i3) {
        if (i2 < 0 || bArr == null) {
            com.oplus.camera.e_renamed.f_renamed("Util", "parseDataByteToInt, from index or data is_renamed error!");
            return 0;
        }
        if (bArr.length < i3) {
            com.oplus.camera.e_renamed.f_renamed("Util", "parseDataByteToInt, to index is_renamed error!");
            return 0;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("");
        while (i2 <= i3) {
            java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer(java.lang.Integer.toBinaryString(bArr[i2]));
            if (stringBuffer2.length() > 8) {
                stringBuffer2 = new java.lang.StringBuffer(stringBuffer2.substring(stringBuffer2.length() - 8));
            } else if (stringBuffer2.length() < 8) {
                while (stringBuffer2.length() < 8) {
                    java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer("0");
                    stringBuffer3.append(stringBuffer2);
                    stringBuffer2 = stringBuffer3;
                }
            }
            stringBuffer2.append(stringBuffer);
            i2++;
            stringBuffer = stringBuffer2;
        }
        return new java.math.BigInteger(stringBuffer.toString(), 2).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.media.ExifInterface a_renamed(byte[] r4) throws java.io.IOException {
        /*
            r0 = 0
            if (r4 != 0) goto L4_renamed
            return r0
        L4_renamed:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.io.IOException -> L1f
            r1.<init>(r4)     // Catch: java.io.IOException -> L1f
            android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch: java.lang.Throwable -> L15 java.io.IOException -> L1f
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L15 java.io.IOException -> L1f
            r1.close()     // Catch: java.io.IOException -> L12
            goto L3c
        L12:
            r0 = move-exception
            r1 = r0
            goto L21
        L15:
            r2 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1f
            goto L1e
        L1a:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.io.IOException -> L1f
        L1e:
            throw r2     // Catch: java.io.IOException -> L1f
        L1f:
            r1 = move-exception
            r2 = r0
        L21:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getExif error, jpeg: "
            r0.append(r3)
            if (r4 != 0) goto L2f
            r4 = -1
            goto L30
        L2f:
            int r4 = r4.length
        L30:
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "Util"
            com.oplus.camera.e_renamed.d_renamed(r0, r4, r1)
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.a_renamed(byte[]):android.media.ExifInterface");
    }

    public static android.media.ExifInterface b_renamed(java.lang.String str) {
        try {
            return new android.media.ExifInterface(str);
        } catch (java.io.IOException e2) {
            com.oplus.camera.e_renamed.d_renamed("Util", "getExif error, path: " + str, e2);
            return null;
        }
    }

    public static android.location.Location a_renamed(android.media.ExifInterface exifInterface) {
        if (exifInterface == null) {
            return null;
        }
        if (!exifInterface.getLatLong(new float[2])) {
            return null;
        }
        android.location.Location location = new android.location.Location(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
        location.setLatitude(r1[0]);
        location.setLongitude(r1[1]);
        return location;
    }

    public static void J_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.view.Display defaultDisplay = ((android.view.WindowManager) J_renamed.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        defaultDisplay.getRealSize(point);
        com.oplus.camera.e_renamed.f_renamed("Util", "initScreenHeightWidth, point: " + point.toString());
        if (u_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("Util", "initScreenHeightWidth, open");
            ac_renamed = java.lang.Math.min(point.x_renamed, point.y_renamed);
            ab_renamed = java.lang.Math.max(point.x_renamed, point.y_renamed);
            boolean zContains = J_renamed.getResources().getConfiguration().toString().contains("oplus-magic-windows");
            com.oplus.camera.e_renamed.f_renamed("Util", "initScreenHeightWidth, isInMagicWindow: " + zContains);
            if (zContains) {
                try {
                    java.lang.Object objInvoke = android.hardware.display.DisplayManager.class.getDeclaredMethod("getStableDisplaySize", new java.lang.Class[0]).invoke((android.hardware.display.DisplayManager) J_renamed.getSystemService("display"), new java.lang.Object[0]);
                    if (objInvoke instanceof android.graphics.Point) {
                        android.graphics.Point point2 = (android.graphics.Point) objInvoke;
                        ac_renamed = java.lang.Math.min(point2.x_renamed, point2.y_renamed);
                        ab_renamed = java.lang.Math.max(point2.x_renamed, point2.y_renamed);
                    }
                    com.oplus.camera.e_renamed.f_renamed("Util", "initScreenHeightWidth, sScreenHeight: " + ac_renamed + ", sScreenWidth: " + ab_renamed);
                    return;
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("Util", "initScreenHeightWidth, fold");
        ac_renamed = java.lang.Math.max(point.x_renamed, point.y_renamed);
        ab_renamed = java.lang.Math.min(point.x_renamed, point.y_renamed);
    }

    public static void n_renamed(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.content.res.Resources resources = J_renamed.getResources();
        J_renamed();
        double d2 = ac_renamed / ab_renamed;
        r_renamed = d2 > 1.7777777777777777d;
        ad_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.top_bar_layout_height);
        ae_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_layout_height);
        ai_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_height);
        af_renamed = (int) ((getScreenHeight() - ae_renamed) - (getScreenWidth() * 1.3333333333333333d));
        if (t_renamed()) {
            af_renamed = (int) (((getScreenHeight() - ae_renamed) - (getScreenWidth() * 1.3333333333333333d)) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_button_height_fold_offset));
        }
        if (m_renamed(context)) {
            al_renamed = K_renamed();
        }
        if (r_renamed) {
            ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_button_height);
            int i2 = ae_renamed;
            ah_renamed = i2;
            aj_renamed = i2;
            ak_renamed = al_renamed;
        } else {
            ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_button_height);
            ah_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_tool_item_size);
            aj_renamed = 0;
            ak_renamed = 0;
        }
        com.oplus.camera.k_renamed.a_renamed(context);
        com.oplus.camera.e_renamed.b_renamed("Util", "initMenuControlPanelHeight, sbLongScreen: " + r_renamed + ", isFoldProject: " + t_renamed() + ", sSettingMenuPanelHeight: " + ae_renamed + ", sControlPanelHeight: " + af_renamed + ", sControlPanelButtonHeight: " + ag_renamed + ", sSettingMenuItemHeight: " + ah_renamed + ", sPreviewMarginTop: " + aj_renamed + ", sHeadLineHeight: " + ai_renamed + ", sNavigationBarHeight: " + al_renamed + ", ratio: " + d2 + ", screenHeight: " + getScreenHeight());
    }

    public static int K_renamed() {
        int identifier = J_renamed.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return J_renamed.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int L_renamed() {
        if (t_renamed()) {
            return J_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.top_margin_1_1);
        }
        return J_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.top_margin_1_1_normal);
    }

    public static int M_renamed() {
        return J_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.top_margin_16_9);
    }

    public static int getSettingMenuPanelHeight() {
        return ae_renamed;
    }

    public static int N_renamed() {
        return ad_renamed;
    }

    public static int O_renamed() {
        return af_renamed;
    }

    public static int P_renamed() {
        return ag_renamed;
    }

    public static int Q_renamed() {
        return ah_renamed;
    }

    public static int R_renamed() {
        return aj_renamed;
    }

    public static int S_renamed() {
        return ak_renamed;
    }

    public static int T_renamed() {
        return ai_renamed;
    }

    public static int getScreenHeight() {
        return ac_renamed;
    }

    public static int U_renamed() {
        return getScreenHeight() - al_renamed;
    }

    public static int getScreenWidth() {
        return ab_renamed;
    }

    public static boolean W_renamed() {
        return r_renamed;
    }

    public static double X_renamed() {
        return ac_renamed / ab_renamed;
    }

    public static int Y_renamed() {
        return java.lang.Math.abs((((double) ac_renamed) / ((double) ab_renamed)) - 1.7777777777777777d) < 0.01d ? 1 : 5;
    }

    public static int b_renamed(byte[] bArr) {
        int i2;
        int i3;
        if (bArr == null) {
            return 0;
        }
        int i4 = 0;
        while (i4 + 3 < bArr.length) {
            int i5 = i4 + 1;
            if ((bArr[i4] & 255) == 255) {
                int i6 = bArr[i5] & 255;
                if (i6 != 255) {
                    i5++;
                    if (i6 != 216 && i6 != 1) {
                        if (i6 != 217 && i6 != 218) {
                            int iA = a_renamed(bArr, i5, 2, false);
                            if (iA < 2 || (i3 = i5 + iA) > bArr.length) {
                                com.oplus.camera.e_renamed.f_renamed("Util", "getOrientation, Invalid length");
                                return 0;
                            }
                            if (i6 == 225 && iA >= 8 && a_renamed(bArr, i5 + 2, 4, false) == 1165519206 && a_renamed(bArr, i5 + 6, 2, false) == 0) {
                                i4 = i5 + 8;
                                i2 = iA - 8;
                                break;
                            }
                            i4 = i3;
                        }
                    }
                }
                i4 = i5;
            }
            i4 = i5;
        }
        i2 = 0;
        if (i2 > 8) {
            int iA2 = a_renamed(bArr, i4, 4, false);
            if (iA2 != 1229531648 && iA2 != 1296891946) {
                com.oplus.camera.e_renamed.f_renamed("Util", "getOrientation, Invalid byte order");
                return 0;
            }
            boolean z2 = iA2 == 1229531648;
            int iA3 = a_renamed(bArr, i4 + 4, 4, z2) + 2;
            if (iA3 < 10 || iA3 > i2) {
                com.oplus.camera.e_renamed.f_renamed("Util", "getOrientation, Invalid offset");
                return 0;
            }
            int i7 = i4 + iA3;
            int i8 = i2 - iA3;
            int iA4 = a_renamed(bArr, i7 - 2, 2, z2);
            while (true) {
                int i9 = iA4 - 1;
                if (iA4 <= 0 || i8 < 12) {
                    break;
                }
                if (a_renamed(bArr, i7, 2, z2) == 274) {
                    int iA5 = a_renamed(bArr, i7 + 8, 2, z2);
                    if (iA5 == 1) {
                        return 0;
                    }
                    if (iA5 == 3) {
                        return 180;
                    }
                    if (iA5 == 6) {
                        return 90;
                    }
                    if (iA5 == 8) {
                        return 270;
                    }
                    com.oplus.camera.e_renamed.c_renamed("Util", "getOrientation, Unsupported orientation");
                    return 0;
                }
                i7 += 12;
                i8 -= 12;
                iA4 = i9;
            }
        }
        com.oplus.camera.e_renamed.c_renamed("Util", "getOrientation, Orientation not found");
        return 0;
    }

    private static int a_renamed(byte[] bArr, int i2, int i3, boolean z2) {
        int i4;
        if (z2) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                return i5;
            }
            i5 = (bArr[i2] & 255) | (i5 << 8);
            i2 += i4;
            i3 = i6;
        }
    }

    public static byte[] c_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("Util", "getThumbnail, filepath: " + str);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            android.media.ExifInterface exifInterface = new android.media.ExifInterface(str);
            if (exifInterface.hasThumbnail()) {
                return exifInterface.getThumbnail();
            }
            return null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int a_renamed(int i2, int i3, int i4, int i5) {
        double dMin = java.lang.Math.min(i2 / i4, i3 / i5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > dMin) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    public static int Z_renamed() {
        return al_renamed;
    }

    public static int o_renamed(android.content.Context context) throws android.provider.Settings.SettingNotFoundException {
        int i2;
        try {
            i2 = android.provider.Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture");
        } catch (android.provider.Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        int iK = i2 == 0 ? K_renamed() : 0;
        com.oplus.camera.e_renamed.a_renamed("Util", "getNavigationBarHeight, navBarHeight: " + iK);
        al_renamed = iK;
        return iK;
    }

    public static boolean p_renamed(android.content.Context context) {
        return al_renamed != o_renamed(context);
    }

    public static boolean aa_renamed() {
        int i2 = android.provider.Settings.Secure.getInt(J_renamed.getContentResolver(), "hide_navigationbar_enable", 0);
        return (2 == i2 || 3 == i2) ? false : true;
    }

    public static boolean ab_renamed() {
        return 2 == android.provider.Settings.Secure.getInt(J_renamed.getContentResolver(), "navigation_mode", 0);
    }

    public static android.location.Address a_renamed(android.content.Context context, android.location.Location location, boolean z2) throws java.io.IOException {
        android.location.Geocoder geocoder;
        com.oplus.camera.e_renamed.a_renamed("Util", "getAddressFromLocation");
        android.location.Address address = null;
        if (location != null && context != null) {
            if (z2) {
                geocoder = new android.location.Geocoder(context);
            } else {
                geocoder = new android.location.Geocoder(context, java.util.Locale.ENGLISH);
            }
            try {
                java.util.List<android.location.Address> fromLocation = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation != null && fromLocation.size() > 0) {
                    address = fromLocation.get(0);
                }
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.f_renamed("Util", "getAddressFromLocation, Error: " + e2.getMessage().toString());
            }
            if (address != null) {
                address.setLatitude(location.getLatitude());
                address.setLongitude(location.getLongitude());
            }
        }
        return address;
    }

    public static boolean ac_renamed() {
        try {
            return com.oplus.compat.os.UserHandleNative.myUserId() == 0;
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getCurrentUser Exception " + e2);
            return true;
        }
    }

    public static void ad_renamed() {
        ao_renamed = android.app.ActivityManager.isUserAMonkey();
        try {
            aq_renamed = c_renamed("persist.sys.oplus.autotest.monkeyRunning", false);
        } catch (java.lang.NoSuchMethodError e2) {
            com.oplus.camera.e_renamed.f_renamed("Util", "updateMonkeyRunningState, error: " + e2.getMessage());
        }
    }

    public static boolean ae_renamed() {
        return ao_renamed || aq_renamed;
    }

    public static boolean af_renamed() {
        return ao_renamed;
    }

    public static boolean ag_renamed() {
        return aq_renamed;
    }

    public static boolean ah_renamed() {
        return c_renamed("sys.oplus.otest.monkey.enable", false);
    }

    public static boolean ai_renamed() {
        return h_renamed("oplus.software.display.screen_heteromorphism");
    }

    public static int aj_renamed() {
        if (ai_renamed()) {
            return ba_renamed();
        }
        return 0;
    }

    public static int f_renamed(int i2) {
        if (!al_renamed()) {
            return i2;
        }
        switch (i2) {
            case com.oplus.camera.R_renamed.string.camera_long_exposure_type_busy_traffic /* 2131755557 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_painting /* 2131755559 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_rail_portrait /* 2131755561 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_pi_off_hint /* 2131755724 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_pi_on_hint /* 2131755728 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_pi_title /* 2131755731 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_scene_ultra_dark_mode_tips /* 2131755823 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_super_eis_pro /* 2131756068 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_switch_main /* 2131756079 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_switch_ultra_wide /* 2131756084 */:
                break;
            case com.oplus.camera.R_renamed.string.camera_switch_ultra_wide_micro_lens /* 2131756085 */:
                break;
        }
        return i2;
    }

    public static boolean al_renamed() {
        return "OPLUS_R".equals(com.oplus.camera.v_renamed.e_renamed());
    }

    public static boolean am_renamed() {
        return "OPLUS_P".equals(com.oplus.camera.v_renamed.e_renamed());
    }

    public static boolean an_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HASSELBLAD_WATERMARK);
    }

    public static boolean ao_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_USE_HASSELBLAD_STYLE);
    }

    public static boolean ap_renamed() {
        return (l_renamed().getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static int ba_renamed() {
        int identifier = J_renamed.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return J_renamed.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x0040 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d_renamed(java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getAssertData, close stream failed!"
            java.lang.String r1 = "Util"
            r2 = 0
            android.content.Context r3 = com.oplus.camera.util.Util.J_renamed     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            java.io.InputStream r6 = r3.open(r6)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            int r3 = r6.available()     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            r6.read(r3)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            java.lang.String r4 = new java.lang.String     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            r4.<init>(r3)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3d
            if (r6 == 0) goto L26
            r6.close()     // Catch: java.io.IOException -> L23
            goto L26
        L23:
            com.oplus.camera.e_renamed.f_renamed(r1, r0)
        L26:
            return r4
        L27:
            r3 = move-exception
            goto L30
        L29:
            r6 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L3e
        L2e:
            r3 = move-exception
            r6 = r2
        L30:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r6 == 0) goto L3c
            r6.close()     // Catch: java.io.IOException -> L39
            goto L3c
        L39:
            com.oplus.camera.e_renamed.f_renamed(r1, r0)
        L3c:
            return r2
        L3d:
            r2 = move-exception
        L3e:
            if (r6 == 0) goto L47
            r6.close()     // Catch: java.io.IOException -> L44
            goto L47
        L44:
            com.oplus.camera.e_renamed.f_renamed(r1, r0)
        L47:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.d_renamed(java.lang.String):java.lang.String");
    }

    public static boolean e_renamed(int i2, int i3) {
        return ai_renamed() && i2 != i3 && (i2 == 1 || i3 == 1);
    }

    public static byte[] a_renamed(android.media.Image image, int i2) {
        return a_renamed(image, i2, (byte[]) null);
    }

    public static byte[] a_renamed(android.media.Image image, int i2, byte[] bArr) {
        if (image == null || image.getFormat() != 35) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getYuvDataWithoutPadding, only support YUV_420_888");
            return null;
        }
        int width = image.getWidth();
        int height = image.getHeight();
        int format = image.getFormat();
        android.graphics.Rect cropRect = image.getCropRect();
        int iWidth = ((cropRect.width() * cropRect.height()) * android.graphics.ImageFormat.getBitsPerPixel(format)) / 8;
        if (bArr == null || (bArr != null && bArr.length < iWidth)) {
            bArr = new byte[iWidth];
        }
        android.media.Image.Plane[] planes = image.getPlanes();
        int i3 = 0;
        java.nio.ByteBuffer buffer = planes[0].getBuffer();
        java.nio.ByteBuffer buffer2 = planes[1].getBuffer();
        if (17 == i2) {
            buffer2 = planes[2].getBuffer();
        }
        if (image.getPlanes()[0].getRowStride() == image.getWidth()) {
            buffer.get(bArr, 0, buffer.remaining());
            buffer2.get(bArr, buffer.position(), buffer2.remaining());
        } else {
            int rowStride = image.getPlanes()[0].getRowStride() - width;
            int i4 = 0;
            int i5 = 0;
            while (i4 < height) {
                buffer.get(bArr, i5, width);
                if (i4 != height - 1) {
                    buffer.position(buffer.position() + rowStride);
                }
                i4++;
                i5 += width;
            }
            while (true) {
                int i6 = height / 2;
                if (i3 >= i6) {
                    break;
                }
                if (i3 != i6 - 1) {
                    buffer2.get(bArr, i5, width);
                    buffer2.position(buffer2.position() + rowStride);
                } else {
                    buffer2.get(bArr, i5, width - 1);
                }
                i3++;
                i5 += width;
            }
        }
        return bArr;
    }

    public static boolean a_renamed(java.util.List<android.util.Size> list, android.util.Size size) {
        if (list != null && size != null) {
            for (android.util.Size size2 : list) {
                if (size2 != null && size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float h_renamed(int i2) {
        return J_renamed.getResources().getDimensionPixelSize(i2);
    }

    public static int i_renamed(int i2) {
        return J_renamed.getResources().getDimensionPixelOffset(i2);
    }

    public static boolean a_renamed(final android.view.View view, final int i2, int i3, boolean z2, boolean z3, final android.view.animation.Animation.AnimationListener animationListener) throws android.content.res.Resources.NotFoundException {
        if (view == null) {
            com.oplus.camera.e_renamed.a_renamed("Util", "setViewVisibilityWithAnimation, view: " + view);
            return false;
        }
        int iC = c_renamed(view);
        if (iC == i2) {
            com.oplus.camera.e_renamed.a_renamed("Util", "setViewVisibilityWithAnimation, viewVisibilityOrAnimationTo is_renamed same as_renamed visibility (" + i2 + ")");
            return false;
        }
        if ((8 == i2 && 4 == iC) || (4 == i2 && 8 == iC)) {
            com.oplus.camera.e_renamed.a_renamed("Util", "setViewVisibilityWithAnimation, visibility: " + i2 + ", viewVisibilityOrAnimationTo: " + iC);
            return false;
        }
        if (view.getAnimation() != null && !view.getAnimation().hasEnded()) {
            if (z2) {
                view.clearAnimation();
            } else {
                com.oplus.camera.e_renamed.a_renamed("Util", "setViewVisibilityWithAnimation, view had animation but not cancel");
                return false;
            }
        }
        android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), i3);
        if (animationLoadAnimation == null) {
            com.oplus.camera.e_renamed.a_renamed("Util", "setViewVisibilityWithAnimation, animation: " + animationLoadAnimation);
            return false;
        }
        animationLoadAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.util.Util.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationStart(animation);
                    return;
                }
                int i4 = i2;
                if (i4 == 0) {
                    view.setVisibility(i4);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationEnd(animation);
                    return;
                }
                int i4 = i2;
                if (i4 != 0) {
                    view.setVisibility(i4);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
                android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationRepeat(animation);
                }
            }
        });
        view.setTag(com.oplus.camera.R_renamed.id_renamed.view_tag_key_animation_visibility, java.lang.Integer.valueOf(i2));
        view.startAnimation(animationLoadAnimation);
        return true;
    }

    private static int c_renamed(android.view.View view) {
        android.view.animation.Animation animation = view.getAnimation();
        if (animation != null && (!animation.hasStarted() || !animation.hasEnded())) {
            java.lang.Object tag = view.getTag(com.oplus.camera.R_renamed.id_renamed.view_tag_key_animation_visibility);
            com.oplus.camera.e_renamed.a_renamed("Util", "getViewVisibilityOrAnimationTo, visibilityObj: " + tag);
            return tag == null ? view.getVisibility() : ((java.lang.Integer) tag).intValue();
        }
        return view.getVisibility();
    }

    public static android.content.Context q_renamed(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT > 23) {
            android.content.res.Configuration configuration = context.getResources().getConfiguration();
            if (f7298b == 0) {
                f7298b = configuration.densityDpi;
            }
            configuration.densityDpi = f7297a;
            com.oplus.camera.e_renamed.b_renamed("Util", "setDefaultDisplay, config sDefaultDensity: " + f7297a + ", sysDensityDpi: " + f7298b);
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        return context;
    }

    public static android.content.Context r_renamed(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT > 23) {
            android.content.res.Configuration configuration = context.getResources().getConfiguration();
            if (f7298b != 0) {
                com.oplus.camera.e_renamed.b_renamed("Util", "followSystemDisplay, densityDpi: " + configuration.densityDpi + " -> " + f7298b);
                configuration.densityDpi = f7298b;
            }
            if (0.0f != f7299c) {
                com.oplus.camera.e_renamed.b_renamed("Util", "followSystemDisplay, fontScale: " + configuration.fontScale + " -> " + f7299c);
                configuration.fontScale = f7299c;
            }
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        return context;
    }

    public static android.graphics.Bitmap a_renamed(int i2, int i3, android.graphics.Bitmap.Config config) {
        return e_renamed(android.graphics.Bitmap.createBitmap(i2, i3, config));
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i2, int i3, int i4, int i5, android.graphics.Matrix matrix, boolean z2) {
        return e_renamed(android.graphics.Bitmap.createBitmap(bitmap, i2, i3, i4, i5, matrix, z2));
    }

    public static android.graphics.Bitmap a_renamed(int[] iArr, int i2, int i3, android.graphics.Bitmap.Config config) {
        return e_renamed(android.graphics.Bitmap.createBitmap(iArr, i2, i3, config));
    }

    public static android.graphics.Bitmap d_renamed(android.graphics.Bitmap bitmap) {
        return e_renamed(android.graphics.Bitmap.createBitmap(bitmap));
    }

    private static android.graphics.Bitmap e_renamed(android.graphics.Bitmap bitmap) {
        bitmap.setDensity(f7297a);
        return bitmap;
    }

    public static android.graphics.drawable.BitmapDrawable a_renamed(android.content.Context context, android.graphics.Bitmap bitmap) {
        context.getResources().getDisplayMetrics().densityDpi = f7297a;
        return new android.graphics.drawable.BitmapDrawable(context.getResources(), bitmap);
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.drawable.Drawable drawable) {
        android.graphics.Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        } else {
            config = android.graphics.Bitmap.Config.RGB_565;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static android.graphics.Bitmap b_renamed(android.graphics.Bitmap bitmap, float f2) {
        if (f2 <= 0.0f || bitmap == null) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(f2, f2);
        try {
            return a_renamed(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, float f2, android.util.Size size, int i2) {
        int height;
        int height2;
        int i3;
        int i4;
        if (f2 <= 0.0f || bitmap == null) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(f2, f2);
        if (size.getWidth() >= size.getHeight()) {
            height = bitmap.getWidth();
            height2 = (int) (bitmap.getWidth() * ((size.getHeight() * 1.0f) / size.getWidth()));
        } else {
            height = (int) (((bitmap.getHeight() * size.getWidth()) * 1.0f) / size.getHeight());
            height2 = bitmap.getHeight();
        }
        com.oplus.camera.e_renamed.a_renamed("Util", "scaleBitmap, newWidth: " + height + ", newHeight: " + height2 + " targetSize: " + size);
        if (height2 < height || (bitmap.getWidth() == bitmap.getHeight() && (90 == i2 || 270 == i2))) {
            i3 = height;
            i4 = height2;
        } else {
            i4 = height;
            i3 = height2;
        }
        try {
            return a_renamed(bitmap, 0, 0, i4, i3, matrix, true);
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean s_renamed(android.content.Context context) {
        java.util.Locale localeBb = bb_renamed();
        return a_renamed(localeBb) && b_renamed(localeBb);
    }

    public static boolean aq_renamed() {
        return a_renamed(bb_renamed());
    }

    public static boolean t_renamed(android.content.Context context) {
        java.util.Locale locale;
        android.os.LocaleList locales = context.getResources().getConfiguration().getLocales();
        return (locales == null || locales.isEmpty() || (locale = locales.get(0)) == null || (!"zh".equalsIgnoreCase(locale.getLanguage()) && !"cn_renamed".equalsIgnoreCase(locale.getCountry()))) ? false : true;
    }

    private static java.util.Locale bb_renamed() {
        android.os.LocaleList locales = com.oplus.camera.MyApplication.d_renamed().getResources().getConfiguration().getLocales();
        if (locales == null || locales.isEmpty()) {
            return null;
        }
        return locales.get(0);
    }

    private static boolean a_renamed(java.util.Locale locale) {
        return locale != null && "zh".equalsIgnoreCase(locale.getLanguage());
    }

    private static boolean b_renamed(java.util.Locale locale) {
        return locale != null && "cn_renamed".equalsIgnoreCase(locale.getCountry());
    }

    public static boolean ar_renamed() {
        try {
            java.lang.String str = com.oplus.compat.os.SystemPropertiesNative.get("ro.build.version.ota");
            java.lang.String str2 = com.oplus.compat.os.SystemPropertiesNative.get("ro.build.mea");
            if (str == null || !str.toLowerCase(java.util.Locale.US).contains("pre")) {
                if (str2 == null) {
                    return false;
                }
                if (!str2.equals("1")) {
                    return false;
                }
            }
            return true;
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
            com.oplus.camera.e_renamed.f_renamed("Util", "isMeaVersion Exception " + e2);
            return false;
        }
    }

    public static double a_renamed(android.content.Context context, android.util.Size size) {
        if (size != null) {
            return (size.getWidth() * size.getHeight()) / 1000000.0f;
        }
        return 0.0d;
    }

    public static void u_renamed(android.content.Context context) {
        try {
            android.content.pm.ShortcutManager shortcutManager = (android.content.pm.ShortcutManager) context.getSystemService("shortcut");
            java.util.List<android.content.pm.ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            if (dynamicShortcuts != null && dynamicShortcuts.size() > 0) {
                shortcutManager.removeAllDynamicShortcuts();
            }
            com.oplus.camera.e_renamed.c_renamed("Util", "removeDynamicShortcuts, successful.");
        } catch (java.lang.Exception unused) {
            com.oplus.camera.e_renamed.c_renamed("Util", "removeDynamicShortcuts, failed.");
        }
    }

    public static boolean as_renamed() {
        return x_renamed;
    }

    public static synchronized boolean at_renamed() {
        if (av_renamed != null) {
            return av_renamed.booleanValue();
        }
        java.util.List<java.lang.String> supportedList = com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, 0);
        if (supportedList != null) {
            if (supportedList.contains("video_size_8k")) {
                av_renamed = java.lang.Boolean.valueOf(g_renamed(com.oplus.camera.capmode.w_renamed.VIDEO_8K_FRAME_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_8K_FRAME_HEIGHT));
            } else if (supportedList.contains("video_size_4kuhd")) {
                av_renamed = java.lang.Boolean.valueOf(g_renamed(com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_HEIGHT));
            } else if (supportedList.contains("video_size_1080p")) {
                av_renamed = java.lang.Boolean.valueOf(g_renamed(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT));
            } else if (supportedList.contains("video_size_720p")) {
                av_renamed = java.lang.Boolean.valueOf(g_renamed(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT));
            }
        }
        if (av_renamed == null) {
            av_renamed = false;
        }
        return av_renamed.booleanValue();
    }

    private static boolean g_renamed(int i2, int i3) {
        android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType;
        android.media.MediaCodecInfo[] codecInfos = new android.media.MediaCodecList(1).getCodecInfos();
        boolean z2 = false;
        if (codecInfos != null) {
            boolean z3 = false;
            for (android.media.MediaCodecInfo mediaCodecInfo : codecInfos) {
                java.lang.String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (supportedTypes != null && mediaCodecInfo.isEncoder()) {
                    int length = supportedTypes.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            java.lang.String str = supportedTypes[i4];
                            if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265.equals(str) && (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str)) != null && capabilitiesForType.getVideoCapabilities() != null && capabilitiesForType.getVideoCapabilities().isSizeSupported(i2, i3)) {
                                z3 = true;
                                break;
                            }
                            i4++;
                        }
                    }
                }
            }
            z2 = z3;
        }
        com.oplus.camera.e_renamed.a_renamed("Util", "isSupportH265Encoder, width: " + i2 + ", height: " + i3 + ", support: " + z2);
        return z2;
    }

    public static boolean au_renamed() {
        return (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT, 1, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_FRONT_PORTRAIT_SUPERNIGHT) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_SUPERNIGHT_SUPPORT);
    }

    public static boolean av_renamed() {
        return com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, 1, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SUPERPHOTO);
    }

    public static boolean b_renamed(android.content.Context context, java.lang.String str) {
        boolean z2 = false;
        if (context == null) {
            return false;
        }
        try {
            z2 = context.getPackageManager().getPackageInfo(aP_renamed(), 128).applicationInfo.metaData.getBoolean(str);
            com.oplus.camera.e_renamed.c_renamed("Util", "isGallerySupportFeature, feature: " + str + ", support: " + z2);
            return z2;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return z2;
        }
    }

    public static boolean v_renamed(android.content.Context context) {
        if (aA_renamed == null) {
            aA_renamed = java.lang.Boolean.valueOf(b_renamed(context, "isSupportAIIDPhoto"));
        }
        return aA_renamed.booleanValue();
    }

    public static boolean w_renamed(android.content.Context context) {
        if (az_renamed == null) {
            az_renamed = java.lang.Boolean.valueOf(b_renamed(context, "isSupportQuickPhoto"));
        }
        return az_renamed.booleanValue();
    }

    public static boolean x_renamed(android.content.Context context) {
        if (I_renamed == null) {
            I_renamed = (android.location.LocationManager) context.getApplicationContext().getSystemService(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_LOCATION);
        }
        boolean zIsLocationEnabled = I_renamed.isLocationEnabled();
        boolean zIsProviderEnabled = I_renamed.isProviderEnabled(com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
        com.oplus.camera.e_renamed.b_renamed("Util", "getLocationAvailable, locationAvailable: " + zIsLocationEnabled + ", netAvailable: " + zIsProviderEnabled);
        return zIsLocationEnabled && zIsProviderEnabled;
    }

    public static java.lang.String aw_renamed() {
        if (C_renamed == null) {
            C_renamed = i_renamed("persist.sys.oplus.region");
        }
        return C_renamed;
    }

    public static java.lang.String ax_renamed() {
        if (D_renamed == null) {
            try {
                D_renamed = com.oplus.compat.os.SystemPropertiesNative.get("persist.sys.locale");
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
                e2.printStackTrace();
            }
        }
        return D_renamed;
    }

    public static boolean a_renamed(java.lang.String[] strArr, java.lang.String str) {
        if (strArr != null) {
            for (java.lang.String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static byte[] c_renamed(long j2) {
        byte[] bArr = new byte[g_renamed];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = java.lang.Long.valueOf(255 & j2).byteValue();
            j2 >>= g_renamed;
        }
        return bArr;
    }

    public static byte[] a_renamed(int i2, byte[] bArr) {
        if (bArr == null || bArr.length != f_renamed) {
            bArr = new byte[f_renamed];
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = java.lang.Integer.valueOf(i2 & 255).byteValue();
            i2 >>= g_renamed;
        }
        return bArr;
    }

    private static boolean b_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String[] configStringArrayValue;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (configStringArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(str2)) == null || configStringArrayValue.length <= 0) {
            return false;
        }
        for (java.lang.String str3 : configStringArrayValue) {
            if (str.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a_renamed(java.lang.String str, boolean z2) {
        return b_renamed(str, z2 ? com.oplus.camera.aps.config.ConfigDataBase.KEY_NONE_SAT_FRONT_MODE : com.oplus.camera.aps.config.ConfigDataBase.KEY_NONE_SAT_REAR_MODE);
    }

    public static boolean b_renamed(java.lang.String str, boolean z2) {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT) && a_renamed(str, z2);
    }

    public static boolean e_renamed(java.lang.String str) {
        return b_renamed(str, com.oplus.camera.aps.config.ConfigDataBase.KEY_PROFESSIONAL_RAW_CAMERA_TYPE_SUPPORT);
    }

    public static int[] a_renamed(int[] iArr) {
        return (iArr == null || iArr.length != 8) ? iArr : new int[]{iArr[0], iArr[1], iArr[5], iArr[4], iArr[2], iArr[3], iArr[6], iArr[7]};
    }

    public static int[] b_renamed(int[] iArr) {
        return (iArr == null || iArr.length != 8) ? iArr : new int[]{iArr[0], iArr[1], iArr[4], iArr[5], iArr[3], iArr[2], iArr[6], iArr[7]};
    }

    public static android.os.Handler ay_renamed() {
        if (K_renamed == null) {
            K_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        return K_renamed;
    }

    public static void c_renamed(java.lang.Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (java.lang.Thread.currentThread().equals(android.os.Looper.getMainLooper().getThread())) {
            runnable.run();
        } else {
            ay_renamed().post(runnable);
        }
    }

    public static int c_renamed(int... iArr) {
        if (iArr == null) {
            return 0;
        }
        int i2 = 1;
        for (int i3 : iArr) {
            i2 = ((i2 << 5) - i2) ^ i3;
        }
        return i2;
    }

    public static boolean c_renamed(android.content.Context context, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        } catch (java.lang.Exception e2) {
            com.oplus.camera.e_renamed.d_renamed("Util", "isPackageExist, packageName: " + str + ", e_renamed: ", e2);
            applicationInfo = null;
        }
        return applicationInfo != null;
    }

    public static <K_renamed, V_renamed> boolean a_renamed(java.util.Map<K_renamed, V_renamed> map) {
        return map == null || map.size() <= 0;
    }

    public static <K_renamed, V_renamed> boolean b_renamed(java.util.Map<K_renamed, V_renamed> map) {
        return !a_renamed(map);
    }

    public static void j_renamed(int i2) {
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i2) && aA_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("Util", "broadcastFrontCameraOpened");
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.8
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.util.Util.J_renamed.sendBroadcast(new android.content.Intent("oplus.intent.action.start.PINHOLE"));
                }
            });
        }
    }

    public static void k_renamed(int i2) {
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i2) && aA_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("Util", "broadcastFrontCameraClosed");
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.9
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.util.Util.J_renamed.sendBroadcast(new android.content.Intent("oplus.intent.action.stop.PINHOLE"));
                }
            });
        }
    }

    public static java.lang.String az_renamed() {
        return i_renamed("ro.oplus.display.screenhole.positon");
    }

    public static boolean aA_renamed() {
        return !android.text.TextUtils.isEmpty(az_renamed());
    }

    public static android.graphics.Rect f_renamed(java.lang.String str) {
        if (aA_renamed()) {
            try {
                java.lang.String[] strArrSplit = str.split(":");
                java.lang.String[] strArrSplit2 = strArrSplit[0].split(",");
                java.lang.String[] strArrSplit3 = strArrSplit[1].split(",");
                return new android.graphics.Rect(java.lang.Integer.parseInt(strArrSplit2[0]), java.lang.Integer.parseInt(strArrSplit2[1]), java.lang.Integer.parseInt(strArrSplit3[0]), java.lang.Integer.parseInt(strArrSplit3[1]));
            } catch (java.lang.Exception unused) {
                com.oplus.camera.e_renamed.f_renamed("Util", "getScreenHolePosition, hole position is_renamed incorrect");
            }
        }
        return null;
    }

    public static int f_renamed(int i2, int i3) {
        return (((i2 + i3) - 1) / i3) * i3;
    }

    public static java.lang.String aB_renamed() {
        return java.lang.String.valueOf(am_renamed);
    }

    public static java.lang.String aC_renamed() {
        return java.lang.String.valueOf(an_renamed);
    }

    public static boolean a_renamed(android.net.Uri uri) {
        return (uri == null || uri.toString().contains("/video/media")) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public static int aD_renamed() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.lang.Exception e2;
        java.io.BufferedReader bufferedReader;
        com.oplus.camera.e_renamed.b_renamed("Util", "getTotalRam");
        ?? r1 = "/proc/meminfo";
        try {
            try {
                try {
                    fileReader = new java.io.FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new java.io.BufferedReader(fileReader, 8192);
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            java.lang.String str = line != null ? line.split("\\s_renamed+")[1] : null;
                            iCeil = str != null ? (int) java.lang.Math.ceil(new java.lang.Float(java.lang.Float.valueOf(str).floatValue() / 1048576.0f).doubleValue()) : 0;
                            bufferedReader.close();
                            fileReader.close();
                        } catch (java.lang.Exception e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            com.oplus.camera.e_renamed.b_renamed("Util", "getTotalRam X_renamed, totalRam: " + iCeil);
                            return iCeil;
                        }
                    } catch (java.lang.Exception e4) {
                        e2 = e4;
                        bufferedReader = null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r1 = 0;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (java.io.IOException e6) {
                    e6.printStackTrace();
                }
            } catch (java.lang.Exception e7) {
                fileReader = null;
                e2 = e7;
                bufferedReader = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                r1 = 0;
                fileReader = null;
            }
            com.oplus.camera.e_renamed.b_renamed("Util", "getTotalRam X_renamed, totalRam: " + iCeil);
            return iCeil;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static void aE_renamed() {
        if (aw_renamed == null) {
            aw_renamed = new java.text.DecimalFormat();
        }
    }

    public static void aF_renamed() {
        aw_renamed = null;
    }

    public static java.lang.String l_renamed(int i2) {
        java.text.DecimalFormat decimalFormat = aw_renamed;
        if (decimalFormat == null) {
            return java.lang.String.valueOf(i2);
        }
        return decimalFormat.format(i2);
    }

    public static int aG_renamed() throws android.provider.Settings.SettingNotFoundException {
        int i2;
        try {
            i2 = android.provider.Settings.Secure.getInt(J_renamed.getContentResolver(), "navigation_mode");
        } catch (android.provider.Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (2 == i2) {
            return 0;
        }
        return Z_renamed();
    }

    public static int aH_renamed() {
        double dA_renamed = a_renamed((android.content.Context) null, com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE));
        com.oplus.camera.e_renamed.a_renamed("Util", "getHighPictureSize, highPictureSize: " + dA_renamed);
        if (java.lang.Math.abs(dA_renamed - 48.0d) < 1.0d) {
            return 48;
        }
        if (java.lang.Math.abs(dA_renamed - 50.0d) < 1.0d) {
            return 50;
        }
        if (java.lang.Math.abs(dA_renamed - 64.0d) < 1.0d) {
            return 64;
        }
        return java.lang.Math.abs(dA_renamed - 108.0d) < 1.0d ? 108 : -1;
    }

    public static boolean y_renamed(android.content.Context context) {
        S_renamed = ((android.hardware.display.DisplayManager) context.getSystemService("display")).getDisplay(0);
        android.view.Display.Mode[] supportedModes = S_renamed.getSupportedModes();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i2 = 0; i2 < supportedModes.length; i2++) {
            if (-1 == arrayList.indexOf(java.lang.Integer.valueOf(supportedModes[i2].getPhysicalWidth()))) {
                arrayList.add(java.lang.Integer.valueOf(supportedModes[i2].getPhysicalWidth()));
                com.oplus.camera.e_renamed.a_renamed("Util", "supportResolutionSwitch, getPhysicalWidth: " + supportedModes[i2].getPhysicalWidth());
            }
        }
        return 1 != arrayList.size() && 1 < arrayList.size();
    }

    public static boolean z_renamed(android.content.Context context) {
        if (!w_renamed && context.checkCallingOrSelfPermission("android.permission.CAMERA") != 0) {
            com.oplus.camera.e_renamed.f_renamed("Util", "checkCameraPermission not granted");
            return false;
        }
        w_renamed = true;
        return true;
    }

    public static float a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        android.hardware.camera2.CaptureResult.Key<float[]> key = com.oplus.camera.e_renamed.b_renamed.U_renamed;
        if (key == null) {
            return 0.0f;
        }
        try {
            float[] fArr = (float[]) captureResult.get(key);
            if (fArr == null || fArr.length <= 0) {
                return 0.0f;
            }
            return fArr[0];
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public static float m_renamed(int i2) {
        return (float) ((5.0d / java.lang.Math.log10(com.oplus.camera.capmode.x_renamed.f4343a)) * java.lang.Math.log10(i2));
    }

    public static java.lang.String g_renamed(java.lang.String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        if (str.startsWith("HTTP://")) {
            return "http" + str.substring(4);
        }
        if (str.startsWith("HTTPS://")) {
            return "https" + str.substring(5);
        }
        return "http://" + str;
    }

    public static float a_renamed(float f2, float f3) {
        return new java.math.BigDecimal(java.lang.Float.toString(f2)).subtract(new java.math.BigDecimal(java.lang.Float.toString(f3))).floatValue();
    }

    public static android.graphics.Bitmap a_renamed(android.content.Context context, int i2) {
        android.graphics.drawable.Drawable drawableA = androidx.core.a_renamed.a_renamed.a_renamed(context, i2);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableA.draw(canvas);
        e_renamed(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static android.graphics.Bitmap a_renamed(android.content.Context context, int i2, float f2, int i3) {
        int intrinsicWidth;
        int intrinsicHeight;
        android.graphics.drawable.Drawable drawableA = androidx.core.a_renamed.a_renamed.a_renamed(context, i2);
        if (context.getResources().getDisplayMetrics().densityDpi != i3) {
            float f3 = i3;
            intrinsicWidth = (int) (((drawableA.getIntrinsicWidth() * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f3 * f2);
            intrinsicHeight = (int) (((drawableA.getIntrinsicHeight() * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f3 * f2);
        } else {
            intrinsicWidth = (int) (drawableA.getIntrinsicWidth() * f2);
            intrinsicHeight = (int) (drawableA.getIntrinsicHeight() * f2);
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableA.draw(canvas);
        bitmapCreateBitmap.setDensity(f7297a);
        return bitmapCreateBitmap;
    }

    public static android.graphics.Bitmap b_renamed(android.content.Context context, int i2, float f2, int i3) {
        int i4;
        int i5;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeResource(context.getResources(), i2, options);
        if (context.getResources().getDisplayMetrics().densityDpi != i3) {
            float f3 = i3;
            i4 = (int) (((options.outWidth * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f3 * f2);
            i5 = (int) (((options.outHeight * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * f3 * f2);
        } else {
            i4 = (int) (options.outWidth * f2);
            i5 = (int) (options.outHeight * f2);
        }
        options.inJustDecodeBounds = false;
        return android.graphics.Bitmap.createScaledBitmap(android.graphics.BitmapFactory.decodeResource(context.getResources(), i2, options), i4, i5, false);
    }

    public static int c_renamed(android.content.Context context, int i2, float f2, int i3) {
        int i4;
        float f3;
        int i5;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeResource(context.getResources(), i2, options);
        if (!y_renamed(context)) {
            if (context.getResources().getDisplayMetrics().densityDpi != i3) {
                f3 = options.outWidth * 1.0f;
                i4 = context.getResources().getDisplayMetrics().densityDpi;
            } else {
                i5 = (int) (options.outWidth * f2);
                com.oplus.camera.e_renamed.a_renamed("Util", "getBitmapFromVectorDrawableWidth, options.outWidth: " + options.outWidth + ", width: " + i5);
                return i5;
            }
        } else {
            i4 = com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480;
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEVICE_ULTRA_HIGH_DENSITY_SUPPORT)) {
                i4 = f7297a;
            }
            f3 = options.outWidth * 1.0f;
        }
        i5 = (int) ((f3 / i4) * i3 * f2);
        com.oplus.camera.e_renamed.a_renamed("Util", "getBitmapFromVectorDrawableWidth, options.outWidth: " + options.outWidth + ", width: " + i5);
        return i5;
    }

    public static float a_renamed(android.content.Context context, int i2, int i3) {
        return ((context.getResources().getDimensionPixelSize(i2) * 1.0f) / context.getResources().getDisplayMetrics().densityDpi) * i3;
    }

    public static android.graphics.Bitmap n_renamed(int i2) {
        return d_renamed(android.graphics.BitmapFactory.decodeResource(com.oplus.camera.MyApplication.d_renamed().getResources(), i2));
    }

    public static boolean h_renamed(java.lang.String str) {
        return false;
    }

    public static java.lang.String i_renamed(java.lang.String str) {
        try {
            return android.os.OplusSystemProperties.get(str, "");
        } catch (java.lang.Throwable unused) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getSystemProperties fail, return default value");
            return "";
        }
    }

    public static int a_renamed(java.lang.String str, int i2) {
        try {
            return android.os.OplusSystemProperties.getInt(str, i2);
        } catch (java.lang.Exception unused) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getSystemProperties fail, return default value");
            return i2;
        }
    }

    public static boolean c_renamed(java.lang.String str, boolean z2) {
        try {
            return android.os.OplusSystemProperties.getBoolean(str, z2);
        } catch (java.lang.Exception unused) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getSystemProperties fail, return default value");
            return z2;
        }
    }

    public static boolean aI_renamed() {
        try {
            java.lang.String str = com.oplus.compat.os.SystemPropertiesNative.get("ro.oplus.flashlight.rio.switch");
            com.oplus.camera.e_renamed.a_renamed("Util", "isRioFlashLightFuncOpen, key: " + str);
            if (!android.text.TextUtils.isEmpty(str)) {
                return 1 == com.oplus.compat.os.SystemPropertiesNative.getInt(str, 0);
            }
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean aJ_renamed() {
        try {
            return "12".equals(com.oplus.compat.os.SystemPropertiesNative.get("ro.build.version.release"));
        } catch (java.lang.Throwable unused) {
            com.oplus.camera.e_renamed.f_renamed("Util", "isAndroidSMigrationAvailable, fail to check system property: ro.build.version.release");
            return false;
        }
    }

    public static boolean aK_renamed() {
        try {
            return com.oplus.camera.statistics.model.FocusAimMsgData.KEY_SEPARATE_METERING_FOCUS.equals(com.oplus.compat.os.SystemPropertiesNative.get("ro.build.version.release"));
        } catch (java.lang.Throwable unused) {
            com.oplus.camera.e_renamed.f_renamed("Util", "isAndroidRMigrationAvailable, fail to check system property: ro.build.version.release");
            return false;
        }
    }

    public static int A_renamed(android.content.Context context) {
        return com.coui.appcompat.a_renamed.d_renamed.a_renamed(context, com.oplus.camera.R_renamed.attr.couiTintControlNormal, context.getColor(com.oplus.camera.R_renamed.color.color_primary_light_yellow));
    }

    public static android.graphics.drawable.Drawable b_renamed(android.content.Context context, int i2) {
        return a_renamed(context, context.getDrawable(i2));
    }

    public static android.graphics.drawable.Drawable a_renamed(android.content.Context context, android.graphics.drawable.Drawable drawable) {
        if (drawable == null || !ao_renamed()) {
            return (drawable == null || !com.coui.appcompat.a_renamed.t_renamed.a_renamed().b_renamed(context)) ? drawable : com.coui.appcompat.a_renamed.w_renamed.a_renamed(drawable, A_renamed(context));
        }
        return com.coui.appcompat.a_renamed.w_renamed.a_renamed(drawable, context.getColor(com.oplus.camera.R_renamed.color.color_primary_light_hasselblad));
    }

    public static boolean a_renamed(android.app.Activity activity, java.util.List<java.lang.String> list) {
        for (java.lang.String str : list) {
            if (activity.checkSelfPermission(str) != 0) {
                com.oplus.camera.e_renamed.a_renamed("Util", "checkRuntimePermission, ungrant permission: " + str);
                return false;
            }
        }
        return true;
    }

    public static int j_renamed(java.lang.String str) {
        try {
            return ((java.lang.Integer) java.lang.Class.forName("android.view.KeyEvent").getField(str).get(null)).intValue();
        } catch (java.lang.Exception e2) {
            com.oplus.camera.e_renamed.f_renamed("Util", "getFingerKeyCode, exception: " + e2);
            return -1;
        }
    }

    public static boolean B_renamed(android.content.Context context) {
        return c_renamed(context, "com.heytap.market");
    }

    public static boolean d_renamed(android.content.Context context, java.lang.String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    public static void e_renamed(final android.content.Context context, final java.lang.String str) {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.10
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    if (android.text.TextUtils.isEmpty(com.oplus.camera.util.Util.m_renamed)) {
                        com.oplus.camera.e_renamed.e_renamed("Util", "notifyAthena, cleaner package is_renamed null");
                        return;
                    }
                    android.content.Intent intent = new android.content.Intent("oplus.intent.action.SCENE_CHANGE_NOTIFY");
                    intent.setPackage(com.oplus.camera.util.Util.m_renamed);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString(com.oplus.camera.statistics.CameraStatisticsUtil.CALLER_PACKAGE, context.getPackageName());
                    bundle.putString("scene", str);
                    intent.putExtras(bundle);
                    context.startService(intent);
                    com.oplus.camera.e_renamed.e_renamed("Util", "notifyAthena, started service, action: oplus.intent.action.SCENE_CHANGE_NOTIFY, scene: " + str);
                    return;
                }
                com.oplus.camera.e_renamed.f_renamed("Util", "notifyAthena, activity is_renamed recycled, return.");
            }
        }, "notifyAthena");
    }

    public static void aL_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ATHENA_SUPPORT)) {
            long configFloatValue = (long) (com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ATHENA_MEMORY_THRESHOLD) * 1.07374182E9f);
            long j2 = g_renamed(com.oplus.camera.MyApplication.d_renamed()).availMem;
            long j3 = w_renamed()[1];
            com.oplus.camera.e_renamed.a_renamed("Util", "checkNotifyAthena, athenaMemoryThreshold: " + configFloatValue + ", availableMemoryFromProc: " + j3 + ", availableMemory: " + j2);
            if (j3 > 0) {
                j2 = j3;
            }
            if (h_renamed(com.oplus.camera.MyApplication.d_renamed()) || (configFloatValue > 0 && j2 < configFloatValue)) {
                C_renamed(com.oplus.camera.MyApplication.d_renamed());
            }
        }
    }

    public static void C_renamed(final android.content.Context context) {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.util.Util.2
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    if (android.text.TextUtils.isEmpty(com.oplus.camera.util.Util.m_renamed)) {
                        com.oplus.camera.e_renamed.e_renamed("Util", "notifyAthena, cleaner package is_renamed null");
                        return;
                    }
                    try {
                        android.content.Intent intent = new android.content.Intent("oplus.intent.action.REQUEST_APP_CLEAN_RUNNING");
                        intent.setPackage(com.oplus.camera.util.Util.m_renamed);
                        intent.putExtra(com.oplus.camera.statistics.CameraStatisticsUtil.CALLER_PACKAGE, context.getPackageName());
                        intent.putExtra("reason", "camera_startup_clear");
                        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
                        arrayList.add("com.oplus.gallery3d.provider.GalleryOpenProvider");
                        arrayList.add(com.oplus.camera.util.Util.n_renamed);
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putStringArrayList(com.oplus.camera.statistics.CameraStatisticsUtil.FILTER_APP_LIST, arrayList);
                        intent.putExtras(bundle);
                        context.startService(intent);
                        com.oplus.camera.e_renamed.e_renamed("Util", "notifyAthena, started service, action: oplus.intent.action.REQUEST_APP_CLEAN_RUNNING");
                        return;
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                com.oplus.camera.e_renamed.f_renamed("Util", "notifyAthena, activity is_renamed recycled, return.");
            }
        }, "notifyAthena");
    }

    public static boolean a_renamed(android.content.Context context, java.lang.String str, int i2) throws android.content.pm.PackageManager.NameNotFoundException {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return false;
            }
            return ((long) i2) <= packageInfo.getLongVersionCode();
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean D_renamed(android.content.Context context) {
        java.lang.String string;
        boolean z2;
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            com.oplus.camera.e_renamed.f_renamed("Util", "isSoloopSupported, project config is_renamed off.");
            return false;
        }
        android.content.SharedPreferences sharedPreferences = J_renamed.getSharedPreferences("rom_update_info", 0);
        if (sharedPreferences != null) {
            string = sharedPreferences.getString("soloop_switch", "on_renamed");
            com.oplus.camera.e_renamed.e_renamed("Util", "isSoloopSupported, soloopSwitch: " + string);
        } else {
            string = "on_renamed";
        }
        if (!android.text.TextUtils.equals(string, "on_renamed")) {
            com.oplus.camera.e_renamed.f_renamed("Util", "isSoloopSupported, rus switch is_renamed off.");
            return false;
        }
        android.content.SharedPreferences sharedPreferences2 = J_renamed.getSharedPreferences("soloop_info", 0);
        if (sharedPreferences2 != null) {
            z2 = sharedPreferences2.getBoolean("key_market_soloop_support_jump", false);
            com.oplus.camera.e_renamed.e_renamed("Util", "isSoloopSupported, isMarketSoloopSupportJump: " + z2);
        } else {
            z2 = false;
        }
        return z2 || a_renamed(context, "com.oplus.videoeditor", 12400);
    }

    public static java.lang.String aM_renamed() {
        java.util.Locale locale;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            locale = android.os.LocaleList.getDefault().get(0);
        } else {
            locale = java.util.Locale.getDefault();
        }
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean aN_renamed() {
        try {
            return !"0".equals(com.oplus.compat.os.SystemPropertiesNative.get("vendor.camera.mem.debug.enable", "0"));
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
            com.oplus.camera.e_renamed.d_renamed("Util", "debugApsMem error.", e2);
            return false;
        }
    }

    public static java.io.File E_renamed(android.content.Context context) {
        java.io.File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = new java.io.File(com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + java.io.File.separator + "Android" + java.io.File.separator + "data" + java.io.File.separator + context.getPackageName() + java.io.File.separator + "cache");
            if (!externalCacheDir.exists() && !externalCacheDir.mkdirs()) {
                com.oplus.camera.e_renamed.f_renamed("Util", "getExternalCacheDir, cacheDir.mkdirs fail");
            }
        }
        return externalCacheDir;
    }

    public static android.util.Size a_renamed(android.util.Size[] sizeArr) {
        return (android.util.Size) java.util.Arrays.stream(sizeArr).filter(com.oplus.camera.util.$$Lambda$bdDB5qtJ9up3KI34bjHEph1ELg.INSTANCE).max(new java.util.Comparator() { // from class: com.oplus.camera.util.-$$Lambda$Util$pyPrMXEwCpKAIaarngXQqcplqhE
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.oplus.camera.util.Util.a_renamed((android.util.Size) obj, (android.util.Size) obj2);
            }
        }).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a_renamed(android.util.Size size, android.util.Size size2) {
        return (size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight());
    }

    public static int d_renamed(long j2) {
        java.lang.String str = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date(j2));
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        return java.lang.Integer.parseInt(str);
    }

    public static java.lang.String F_renamed(android.content.Context context) {
        return (context == null || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) ? "off" : context.getResources().getString(com.oplus.camera.R_renamed.string.camera_torch_mode_default_value);
    }

    public static java.util.List<java.lang.String> c_renamed(android.content.Context context, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(context.getResources().getStringArray(com.oplus.camera.R_renamed.array.video_resolution_values)));
        if (!b_renamed("video_size_720p", i2)) {
            arrayList.remove(context.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_720p));
        }
        if (!b_renamed("video_size_4kuhd", i2)) {
            arrayList.remove(context.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_4k));
        }
        if (!b_renamed("video_size_8k", i2)) {
            arrayList.remove(context.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_8k));
        }
        return arrayList;
    }

    public static boolean b_renamed(java.lang.String str, int i2) {
        java.util.List<java.lang.String> supportedList = com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, i2);
        boolean z2 = false;
        if (supportedList != null) {
            java.util.Iterator<java.lang.String> it = supportedList.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public static boolean a_renamed(int i2, java.lang.String str) {
        if ("video_size_720p".equals(str)) {
            return !com.oplus.camera.e_renamed.a_renamed.a_renamed(i2) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS);
        }
        if ("video_size_1080p".equals(str)) {
            if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i2)) {
                return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS);
            }
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS);
        }
        if ("video_size_4kuhd".equals(str)) {
            return !com.oplus.camera.e_renamed.a_renamed.a_renamed(i2) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS);
        }
        return false;
    }

    public static java.lang.String o_renamed(int i2) {
        return (com.oplus.camera.e_renamed.a_renamed.a_renamed(i2) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO)) ? "video_size_1080p" : "video_size_720p";
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String[] list;
        com.oplus.camera.e_renamed.a_renamed("Util", "copySourceToTarget, sourcePath: " + str + " , targetPath: " + str2);
        if (!android.text.TextUtils.isEmpty(str) && (list = new java.io.File(str).list()) != null && list.length > 0) {
            for (java.lang.String str3 : list) {
                try {
                    a_renamed(new java.io.FileInputStream(str + java.io.File.separator + str3), str2 + java.io.File.separator + str3);
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        com.oplus.camera.e_renamed.a_renamed("Util", "copySourceToTarget X_renamed");
    }

    private static void a_renamed(java.io.InputStream inputStream, java.lang.String str) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(new java.io.File(str));
                } catch (java.lang.Exception e2) {
                    e_renamed = e2;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (-1 == i2) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i2);
                    }
                }
                fileOutputStream.flush();
                if (inputStream != null) {
                    inputStream.close();
                }
                fileOutputStream.close();
            } catch (java.lang.Exception e3) {
                e_renamed = e3;
                fileOutputStream2 = fileOutputStream;
                e_renamed.printStackTrace();
                fileOutputStream2.flush();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    fileOutputStream2.flush();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (java.io.IOException e5) {
            e5.printStackTrace();
        }
    }

    public static boolean b_renamed(java.lang.String[] strArr, java.lang.String str) {
        if (strArr == null) {
            return false;
        }
        for (java.lang.String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean aO_renamed() {
        com.oplus.camera.e_renamed.a_renamed("Util", "requestKeyguard");
        try {
            new android.view.OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            return true;
        } catch (android.os.RemoteException | java.lang.NoSuchMethodError e2) {
            com.oplus.camera.e_renamed.f_renamed("Util", "requestKeyguard: " + e2.toString());
            return false;
        }
    }

    public static boolean G_renamed(android.content.Context context) {
        boolean z2 = false;
        if (context == null) {
            return false;
        }
        try {
            z2 = context.getPackageManager().getPackageInfo(aP_renamed(), 128).applicationInfo.metaData.getBoolean("isSupportDoubleExposure");
            com.oplus.camera.e_renamed.c_renamed("Util", "isGallerySupportDoubleExposure, support: " + z2);
            return z2;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return z2;
        }
    }

    public static java.lang.String aP_renamed() {
        return com.oplus.camera.v_renamed.b_renamed();
    }

    public static byte[] k_renamed(java.lang.String str) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[102400];
        try {
            fileInputStream = new java.io.FileInputStream(str);
            while (true) {
                try {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (java.io.IOException unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            try {
                fileInputStream.close();
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException unused2) {
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:95:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String l_renamed(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.l_renamed(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a_renamed(int r1, android.content.Context r2, boolean r3) {
        /*
            r0 = 2
            if (r1 == r0) goto L46
            r0 = 4
            if (r1 == r0) goto L43
            r0 = 16
            if (r1 == r0) goto L3e
            r0 = 18
            if (r1 == r0) goto L3b
            r0 = 29
            if (r1 == r0) goto L38
            r0 = 31
            if (r1 == r0) goto L35
            r0 = 13
            if (r1 == r0) goto L32
            r0 = 14
            if (r1 == r0) goto L2f
            r0 = 26
            if (r1 == r0) goto L2a
            r3 = 27
            if (r1 == r3) goto L27
            goto L4b
        L27:
            java.lang.String r1 = "long_exposure_reddot_show"
            goto L4c
        L2a:
            if (r3 != 0) goto L4b
            java.lang.String r1 = "street_reddot_show"
            goto L4c
        L2f:
            java.lang.String r1 = "multi_video_reddot_show"
            goto L4c
        L32:
            java.lang.String r1 = "id_photo_reddot_show"
            goto L4c
        L35:
            java.lang.String r1 = "mode_high_pixel_reddot_show"
            goto L4c
        L38:
            java.lang.String r1 = "fish_eye_reddot_show"
            goto L4c
        L3b:
            java.lang.String r1 = "double_exposure_reddot_show"
            goto L4c
        L3e:
            if (r3 != 0) goto L4b
            java.lang.String r1 = "microscope_reddot_show"
            goto L4c
        L43:
            java.lang.String r1 = "profession_reddot_show"
            goto L4c
        L46:
            if (r3 != 0) goto L4b
            java.lang.String r1 = "slow_video_high_frame_reddot_show"
            goto L4c
        L4b:
            r1 = 0
        L4c:
            if (r1 == 0) goto L5e
            android.content.SharedPreferences r2 = androidx.preference.j_renamed.a_renamed(r2)
            android.content.SharedPreferences$Editor r2 = r2.edit()
            r3 = 0
            android.content.SharedPreferences$Editor r1 = r2.putBoolean(r1, r3)
            r1.apply()
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.Util.a_renamed(int, android.content.Context, boolean):void");
    }

    public static java.util.ArrayList<java.lang.String> getModeNameByRank(java.lang.String str) {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        java.util.List<com.oplus.camera.ui.modepanel.i_renamed> listA = com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(str);
        if (listA != null && !listA.isEmpty()) {
            java.util.Iterator it = ((java.util.List) listA.stream().sorted(java.util.Comparator.comparing(new java.util.function.Function() { // from class: com.oplus.camera.util.-$$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4
                @Override // java.util.function.Function
                public final java.lang.Object apply(java.lang.Object obj) {
                    return java.lang.Integer.valueOf(((com.oplus.camera.ui.modepanel.i_renamed) obj).d_renamed());
                }
            })).collect(java.util.stream.Collectors.toList())).iterator();
            while (it.hasNext()) {
                arrayList.add(((com.oplus.camera.ui.modepanel.i_renamed) it.next()).a_renamed());
            }
        }
        return arrayList;
    }

    public static void a_renamed(java.util.List<android.util.Size> list, final boolean z2) {
        if (list != null) {
            java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.oplus.camera.util.-$$Lambda$Util$_wWOSaQw6lIk4_hbUdcJDEydh44
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return com.oplus.camera.util.Util.a_renamed(z2, (android.util.Size) obj, (android.util.Size) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a_renamed(boolean z2, android.util.Size size, android.util.Size size2) {
        int width = (size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight());
        return z2 ? width : -width;
    }

    public static android.view.MotionEvent a_renamed(android.view.MotionEvent motionEvent, int i2) {
        int i3;
        int i4;
        int pointerCount = motionEvent.getPointerCount();
        int i5 = 0;
        int pointerId = 0;
        while (true) {
            if (i5 >= pointerCount) {
                break;
            }
            pointerId |= 1 << motionEvent.getPointerId(i5);
            i5++;
        }
        com.oplus.camera.e_renamed.b_renamed("Util", "split, idBitsTemp: " + pointerId);
        android.view.MotionEvent.PointerProperties[] pointerPropertiesArr = new android.view.MotionEvent.PointerProperties[pointerCount];
        android.view.MotionEvent.PointerCoords[] pointerCoordsArr = new android.view.MotionEvent.PointerCoords[pointerCount];
        int[] iArr = new int[pointerCount];
        for (int i6 = 0; i6 < pointerCount; i6++) {
            pointerPropertiesArr[i6] = new android.view.MotionEvent.PointerProperties();
            pointerCoordsArr[i6] = new android.view.MotionEvent.PointerCoords();
        }
        int action = motionEvent.getAction();
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int i7 = 0;
        int i8 = -1;
        for (int i9 = 0; i9 < pointerCount; i9++) {
            motionEvent.getPointerProperties(i9, pointerPropertiesArr[i7]);
            if (((1 << pointerPropertiesArr[i7].id_renamed) & i2) != 0) {
                if (i9 == actionIndex) {
                    i8 = i7;
                }
                iArr[i7] = i9;
                i7++;
            }
        }
        if (i7 == 0) {
            return null;
        }
        if (5 == actionMasked || 6 == actionMasked) {
            if (i8 < 0) {
                i3 = 2;
            } else if (1 == i7) {
                i4 = actionMasked == 5 ? 0 : 1;
            } else {
                i3 = (i8 << 8) | actionMasked;
            }
            i4 = i3;
        } else {
            i4 = action;
        }
        for (int i10 = 0; i10 < i7; i10++) {
            motionEvent.getPointerCoords(iArr[i10], pointerCoordsArr[i10]);
        }
        return android.view.MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i4, i7, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
    }

    public static boolean aQ_renamed() {
        try {
            return "0".equals(com.oplus.compat.os.SystemPropertiesNative.get("persist.sys.oplus.camera.open.torch", "1"));
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
            com.oplus.camera.e_renamed.d_renamed("Util", "isGovernmentTorchDisable error.", e2);
            return false;
        }
    }

    public static java.lang.String e_renamed(boolean z2) {
        return z2 ? com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_FRONT_OPEN_DEFAULT_SUPPORT) ? "on_renamed" : "off" : com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_REAR_OPEN_DEFAULT_SUPPORT) ? "on_renamed" : "off";
    }

    public static boolean a_renamed(android.view.View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        return f3 >= ((float) i3) && f3 <= ((float) (view.getMeasuredHeight() + i3)) && f2 >= ((float) i2) && f2 <= ((float) (view.getMeasuredWidth() + i2));
    }

    public static boolean m_renamed(java.lang.String str) {
        return "video_size_1080p".equals(str) || ("video_size_4kuhd".equals(str) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_4K));
    }

    public static java.lang.String b_renamed(android.net.Uri uri) {
        java.lang.String string = uri.toString();
        return string.substring(string.lastIndexOf(47) + 1);
    }

    public static boolean aR_renamed() {
        return android.os.Looper.getMainLooper().getThread().getId() == java.lang.Thread.currentThread().getId();
    }

    public static void a_renamed(android.app.Activity activity, int i2, boolean z2) {
        android.view.KeyEvent.Callback callbackFindViewById = activity.findViewById(i2);
        if (callbackFindViewById != null && (callbackFindViewById instanceof com.oplus.camera.ui.n_renamed)) {
            ((com.oplus.camera.ui.n_renamed) callbackFindViewById).setLightBackground(z2);
        }
    }

    public static void a_renamed(android.app.Activity activity, int i2, int i3) {
        android.view.View viewFindViewById = activity.findViewById(i2);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(i3);
        }
    }

    public static void a_renamed(android.widget.TextView textView) throws android.content.res.Resources.NotFoundException {
        android.content.Context context = textView.getContext();
        float fA_renamed = a_renamed(textView.getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, f7297a);
        int color = context.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
        int i2 = (int) fA_renamed;
        textView.setPadding(i2, i2, i2, i2);
        textView.setShadowLayer(fA_renamed, 0.0f, 0.0f, color);
    }

    public static boolean a_renamed(android.view.View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getHitRect(rect);
        android.graphics.Rect rect2 = (android.graphics.Rect) view.getTag(com.oplus.camera.R_renamed.id_renamed.touch_area_tag);
        if (rect2 == null) {
            return rect.contains(i2, i3);
        }
        if (!rect2.contains(i2, i3)) {
            view.getDrawingRect(rect2);
        }
        android.graphics.Rect rect3 = new android.graphics.Rect();
        rect3.set(rect2);
        rect3.offset(rect.left, rect.top);
        return rect3.contains(i2, i3);
    }

    public static android.graphics.Bitmap b_renamed(android.graphics.drawable.Drawable drawable) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        e_renamed(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static java.lang.String a_renamed(int i2, int i3, java.lang.Object[] objArr) {
        try {
            return l_renamed().getResources().getQuantityString(i2, i3, objArr);
        } catch (java.lang.Exception unused) {
            return l_renamed().getResources().getQuantityString(i2, i3);
        }
    }

    public static java.lang.String a_renamed(int i2, java.lang.Object[] objArr) {
        try {
            return l_renamed().getResources().getString(i2, objArr);
        } catch (java.lang.Exception unused) {
            return l_renamed().getResources().getString(i2);
        }
    }

    public static int p_renamed(int i2) {
        int i3 = 1;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                i3 = 4;
                if (i2 != 4) {
                    if (i2 != 13) {
                        if (i2 == 21) {
                            return 3;
                        }
                        if (i2 != 22) {
                            throw new java.lang.IllegalArgumentException("Bad audio format " + i2);
                        }
                    }
                }
            }
            return i3;
        }
        return 2;
    }

    public static java.lang.String a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return str.replaceFirst(str2, new java.lang.String(android.util.Base64.decode(str3, 0), java.nio.charset.StandardCharsets.UTF_8));
    }
}
