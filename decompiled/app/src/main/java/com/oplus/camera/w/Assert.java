package com.oplus.camera.w_renamed;

/* compiled from: CameraDataCollection.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.w_renamed.a_renamed f7388a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.concurrent.ExecutorService f7389b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7390c = -1;
    private int d_renamed = -1;

    public static com.oplus.camera.w_renamed.a_renamed a_renamed() {
        com.oplus.camera.w_renamed.a_renamed aVar;
        synchronized (com.oplus.camera.w_renamed.a_renamed.class) {
            if (f7388a == null) {
                f7388a = new com.oplus.camera.w_renamed.a_renamed();
            }
            aVar = f7388a;
        }
        return aVar;
    }

    private a_renamed() {
        this.f7389b = null;
        this.f7389b = java.util.concurrent.Executors.newSingleThreadExecutor();
    }

    public static void b_renamed() {
        synchronized (com.oplus.camera.w_renamed.a_renamed.class) {
            if (f7388a != null) {
                f7388a.d_renamed();
            }
            f7388a = null;
        }
    }

    private void d_renamed() {
        java.util.concurrent.ExecutorService executorService = this.f7389b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f7389b = null;
        }
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed != this.f7390c) {
            this.f7390c = i_renamed;
            a_renamed(com.oplus.camera.util.Util.l_renamed(), "face_num", java.lang.Integer.valueOf(i_renamed));
        }
    }

    public void b_renamed(int i_renamed) {
        if (i_renamed != this.d_renamed) {
            this.d_renamed = i_renamed;
            a_renamed(com.oplus.camera.util.Util.l_renamed(), com.meicam.sdk.NvsStreamingContext.COMPILE_FPS, java.lang.Integer.valueOf(this.d_renamed));
        }
    }

    public void a_renamed(final android.content.Context context, final java.lang.String str, final java.lang.Object obj) {
        java.util.concurrent.ExecutorService executorService = this.f7389b;
        if (executorService == null || context == null || str == null || obj == null) {
            return;
        }
        try {
            executorService.submit(new java.lang.Runnable() { // from class: com.oplus.camera.w_renamed.-$$Lambda$a_renamed$ou1v9QylIU-9lKurTtSs0IRdkSg
                @Override // java.lang.Runnable
                public final void run() {
                    com.oplus.camera.w_renamed.a_renamed.a_renamed(str, obj, context);
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(java.lang.String str, java.lang.Object obj, android.content.Context context) {
        com.oplus.camera.e_renamed.b_renamed("CameraDataCollection", java.lang.String.format("putSetting, %s_renamed: %s_renamed", str, obj));
        if (obj instanceof java.lang.Integer) {
            if (com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE.equals(str)) {
                com.oplus.camera.e_renamed.b_renamed("CameraDataCollection", java.lang.String.format("putSetting, %s_renamed: 0x%x_renamed", str, obj));
            }
            com.oplus.d_renamed.a_renamed.d_renamed.c_renamed(context.getContentResolver(), str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.String) {
            com.oplus.d_renamed.a_renamed.d_renamed.a_renamed(context.getContentResolver(), str, (java.lang.String) obj);
        }
    }

    public void c_renamed() {
        java.util.concurrent.ExecutorService executorService = this.f7389b;
        if (executorService == null) {
            return;
        }
        try {
            executorService.submit(new java.lang.Runnable() { // from class: com.oplus.camera.w_renamed.-$$Lambda$a_renamed$rolP4q_0IxnnV1qcP2s8Yeqkq58
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.e_renamed();
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraDataCollection", "clear");
        android.content.ContentResolver contentResolver = com.oplus.camera.util.Util.l_renamed().getContentResolver();
        com.oplus.d_renamed.a_renamed.d_renamed.a_renamed(contentResolver, "connected_camera_ids", "shutdown");
        com.oplus.d_renamed.a_renamed.d_renamed.a_renamed(contentResolver, "flash_mode", "shutdown");
        com.oplus.d_renamed.a_renamed.d_renamed.a_renamed(contentResolver, com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, "shutdown");
        com.oplus.d_renamed.a_renamed.d_renamed.a_renamed(contentResolver, "stream_size", "shutdown");
        com.oplus.d_renamed.a_renamed.d_renamed.c_renamed(contentResolver, "active_camera_type", -1);
        this.f7390c = -1;
        com.oplus.d_renamed.a_renamed.d_renamed.c_renamed(contentResolver, "face_num", this.f7390c);
        this.d_renamed = -1;
        com.oplus.d_renamed.a_renamed.d_renamed.c_renamed(contentResolver, com.meicam.sdk.NvsStreamingContext.COMPILE_FPS, this.d_renamed);
    }
}
