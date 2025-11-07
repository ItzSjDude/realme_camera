package com.oplus.camera.perf;

import android.os.Build;
import android.os.Process;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.uifirst.OplusUIFirstManager;

/* compiled from: CameraPerformance.java */
/* renamed from: com.oplus.camera.perf.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CameraPerformance {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final CPURunningInfo f15180a = new CPURunningInfo();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static PlatformImplementations.kt_3 f15181b = PlatformImplementations.kt_3.STATE_CLOSED;

    /* compiled from: CameraPerformance.java */
    /* renamed from: com.oplus.camera.perf.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private enum PlatformImplementations.kt_3 {
        STATE_CLOSED,
        STATE_LAUNCHING,
        STATE_SWITCHING_CAMERA,
        STATE_SWITCH_MODE,
        STATE_PAUSE,
        STATE_PREVIEW
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m15185a(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -1617888575: goto L44;
                case -1013464554: goto L3a;
                case -785871842: goto L30;
                case 552585030: goto L26;
                case 793950546: goto L1c;
                case 1432307344: goto L12;
                case 2129173454: goto L8;
                default: goto L7;
            }
        L7:
            goto L4e
        L8:
            java.lang.String r0 = "switch_mode"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 2
            goto L4f
        L12:
            java.lang.String r0 = "switch_camera"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 0
            goto L4f
        L1c:
            java.lang.String r0 = "start_video_record"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 3
            goto L4f
        L26:
            java.lang.String r0 = "capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 1
            goto L4f
        L30:
            java.lang.String r0 = "picture_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 5
            goto L4f
        L3a:
            java.lang.String r0 = "continuous_capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 6
            goto L4f
        L44:
            java.lang.String r0 = "video_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 4
            goto L4f
        L4e:
            r2 = -1
        L4f:
            switch(r2) {
                case 0: goto L87;
                case 1: goto L7f;
                case 2: goto L73;
                case 3: goto L6b;
                case 4: goto L63;
                case 5: goto L5b;
                case 6: goto L53;
                default: goto L52;
            }
        L52:
            goto L92
        L53:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.ContinuousCapturePerformance.setContinuousCaptureStartTime(r0)
            goto L92
        L5b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.PictureSavePerformance.setPictureSaveStartTime(r0)
            goto L92
        L63:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.VideoSavePerformance.setVideoSaveStartTime(r0)
            goto L92
        L6b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.VideoRecordPerformance.setStartVideoRecordStartTime(r0)
            goto L92
        L73:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.SwitchModePerformance.setSwitchModeStartTime(r0)
            com.oplus.camera.perf.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 r2 = com.oplus.camera.perf.CameraPerformance.PlatformImplementations.kt_3.STATE_SWITCH_MODE
            com.oplus.camera.perf.CameraPerformance.f15181b = r2
            goto L92
        L7f:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.CapturePerformance.addClickShutterTime(r0)
            goto L92
        L87:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.SwitchCameraPerformance.setSwitchCameraStartTime(r0)
            com.oplus.camera.perf.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 r2 = com.oplus.camera.perf.CameraPerformance.PlatformImplementations.kt_3.STATE_SWITCHING_CAMERA
            com.oplus.camera.perf.CameraPerformance.f15181b = r2
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.CameraPerformance.m15185a(java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m15188b(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -1617888575: goto L44;
                case -1013464554: goto L3a;
                case -785871842: goto L30;
                case 552585030: goto L26;
                case 793950546: goto L1c;
                case 1432307344: goto L12;
                case 2129173454: goto L8;
                default: goto L7;
            }
        L7:
            goto L4e
        L8:
            java.lang.String r0 = "switch_mode"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 2
            goto L4f
        L12:
            java.lang.String r0 = "switch_camera"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 0
            goto L4f
        L1c:
            java.lang.String r0 = "start_video_record"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 3
            goto L4f
        L26:
            java.lang.String r0 = "capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 1
            goto L4f
        L30:
            java.lang.String r0 = "picture_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 5
            goto L4f
        L3a:
            java.lang.String r0 = "continuous_capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 6
            goto L4f
        L44:
            java.lang.String r0 = "video_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 4
            goto L4f
        L4e:
            r2 = -1
        L4f:
            switch(r2) {
                case 0: goto L83;
                case 1: goto L7b;
                case 2: goto L73;
                case 3: goto L6b;
                case 4: goto L63;
                case 5: goto L5b;
                case 6: goto L53;
                default: goto L52;
            }
        L52:
            goto L8a
        L53:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.ContinuousCapturePerformance.setContinuousCaptureEndTime(r0)
            goto L8a
        L5b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.PictureSavePerformance.setPictureSaveEndTime(r0)
            goto L8a
        L63:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.VideoSavePerformance.setVideoSaveEndTime(r0)
            goto L8a
        L6b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.VideoRecordPerformance.setStartVideoRecordEndTime(r0)
            goto L8a
        L73:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.SwitchModePerformance.setSwitchModeEndTime(r0)
            goto L8a
        L7b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.CapturePerformance.addShowThumbnailTime(r0)
            goto L8a
        L83:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.SwitchCameraPerformance.setSwitchCameraEndTime(r0)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.CameraPerformance.m15188b(java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m15189c(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.CameraPerformance.m15189c(java.lang.String):void");
    }

    /* compiled from: CameraPerformance.java */
    /* renamed from: com.oplus.camera.perf.IntrinsicsJvm.kt_4$3, reason: invalid class name */
    static /* synthetic */ class ZoomSeekBar_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f15182a = new int[PlatformImplementations.kt_3.values().length];

        static {
            try {
                f15182a[PlatformImplementations.kt_3.STATE_LAUNCHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15182a[PlatformImplementations.kt_3.STATE_SWITCH_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15182a[PlatformImplementations.kt_3.STATE_SWITCHING_CAMERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m15187b() {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.perf.IntrinsicsJvm.kt_4.2
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12959b("CameraPerformance", "setLaunchEndCpuInfo");
                CameraPerformance.f15180a.m15181b();
                CameraPerformance.f15180a.m15182c();
                if (CameraPerformance.f15180a.m15183d()) {
                    LaunchPerformance.setLaunchCpuInfo(CameraPerformance.f15180a.toString());
                } else {
                    LaunchPerformance.setLaunchCpuInfo("");
                }
                if (ComprehensivePerformance.m15120c()) {
                    return;
                }
                CameraPerformance.f15180a.m15180a(false);
            }
        }, "read performance");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15186a(String str, int OplusGLSurfaceView_13) {
        if (30 >= Build.VERSION.SDK_INT) {
            return;
        }
        int iMyPid = Process.myPid();
        CameraLog.m12959b("CameraPerformance", "setUxThreadValue: pid is: " + iMyPid + ", tid is " + OplusGLSurfaceView_13 + " value is " + str);
        if (iMyPid == 0 || OplusGLSurfaceView_13 == 0) {
            CameraLog.m12967f("CameraPerformance", "setUxThreadValue fail");
            return;
        }
        try {
            OplusUIFirstManager.getInstance().setUxThreadValue(iMyPid, OplusGLSurfaceView_13, str);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
