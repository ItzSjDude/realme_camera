package com.oplus.camera.p181w;

import android.content.ContentResolver;
import android.content.Context;
import com.meicam.sdk.NvsStreamingContext;
import com.oplus.camera.CameraLog;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.util.Util;
import com.oplus.p188d.AppSettings;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: CameraDataCollection.java */
/* renamed from: com.oplus.camera.w.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CameraDataCollection {

    /* renamed from: PlatformImplementations.kt_3 */
    private static CameraDataCollection f23136a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ExecutorService f23137b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f23138c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f23139d = -1;

    /* renamed from: PlatformImplementations.kt_3 */
    public static CameraDataCollection m24685a() {
        CameraDataCollection c3561a;
        synchronized (CameraDataCollection.class) {
            if (f23136a == null) {
                f23136a = new CameraDataCollection();
            }
            c3561a = f23136a;
        }
        return c3561a;
    }

    private CameraDataCollection() {
        this.f23137b = null;
        this.f23137b = Executors.newSingleThreadExecutor();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24687b() {
        synchronized (CameraDataCollection.class) {
            if (f23136a != null) {
                f23136a.m24688d();
            }
            f23136a = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m24688d() {
        ExecutorService executorService = this.f23137b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f23137b = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24690a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f23138c) {
            this.f23138c = OplusGLSurfaceView_13;
            m24691a(Util.m24472l(), "face_num", Integer.valueOf(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24692b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f23139d) {
            this.f23139d = OplusGLSurfaceView_13;
            m24691a(Util.m24472l(), NvsStreamingContext.COMPILE_FPS, Integer.valueOf(this.f23139d));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24691a(final Context context, final String str, final Object obj) {
        ExecutorService executorService = this.f23137b;
        if (executorService == null || context == null || str == null || obj == null) {
            return;
        }
        try {
            executorService.submit(new Runnable() { // from class: com.oplus.camera.w.-$$Lambda$PlatformImplementations.kt_3$ou1v9QylIU-9lKurTtSs0IRdkSg
                @Override // java.lang.Runnable
                public final void run() {
                    CameraDataCollection.m24686a(str, obj, context);
                }
            });
        } catch (RejectedExecutionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m24686a(String str, Object obj, Context context) {
        CameraLog.m12959b("CameraDataCollection", String.format("putSetting, %s: %s", str, obj));
        if (obj instanceof Integer) {
            if (CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE.equals(str)) {
                CameraLog.m12959b("CameraDataCollection", String.format("putSetting, %s: 0x%x", str, obj));
            }
            AppSettings.IntrinsicsJvm.kt_5.m24996c(context.getContentResolver(), str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            AppSettings.IntrinsicsJvm.kt_5.m24994a(context.getContentResolver(), str, (String) obj);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24693c() {
        ExecutorService executorService = this.f23137b;
        if (executorService == null) {
            return;
        }
        try {
            executorService.submit(new Runnable() { // from class: com.oplus.camera.w.-$$Lambda$PlatformImplementations.kt_3$rolP4q_0IxnnV1qcP2s8Yeqkq58
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m24689e();
                }
            });
        } catch (RejectedExecutionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m24689e() {
        CameraLog.m12959b("CameraDataCollection", "clear");
        ContentResolver contentResolver = Util.m24472l().getContentResolver();
        AppSettings.IntrinsicsJvm.kt_5.m24994a(contentResolver, "connected_camera_ids", "shutdown");
        AppSettings.IntrinsicsJvm.kt_5.m24994a(contentResolver, "flash_mode", "shutdown");
        AppSettings.IntrinsicsJvm.kt_5.m24994a(contentResolver, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, "shutdown");
        AppSettings.IntrinsicsJvm.kt_5.m24994a(contentResolver, "stream_size", "shutdown");
        AppSettings.IntrinsicsJvm.kt_5.m24996c(contentResolver, "active_camera_type", -1);
        this.f23138c = -1;
        AppSettings.IntrinsicsJvm.kt_5.m24996c(contentResolver, "face_num", this.f23138c);
        this.f23139d = -1;
        AppSettings.IntrinsicsJvm.kt_5.m24996c(contentResolver, NvsStreamingContext.COMPILE_FPS, this.f23139d);
    }
}
