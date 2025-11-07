package com.oplus.camera.perf;

/* compiled from: CameraPerformance.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.oplus.camera.perf.a_renamed f5008a = new com.oplus.camera.perf.a_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static com.oplus.camera.perf.b_renamed.a_renamed f5009b = com.oplus.camera.perf.b_renamed.a_renamed.STATE_CLOSED;

    /* compiled from: CameraPerformance.java */
    private enum a_renamed {
        STATE_CLOSED,
        STATE_LAUNCHING,
        STATE_SWITCHING_CAMERA,
        STATE_SWITCH_MODE,
        STATE_PAUSE,
        STATE_PREVIEW
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a_renamed(java.lang.String r2) {
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
            com.oplus.camera.perf.b_renamed$a_renamed r2 = com.oplus.camera.perf.b_renamed.a_renamed.STATE_SWITCH_MODE
            com.oplus.camera.perf.b_renamed.f5009b = r2
            goto L92
        L7f:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.CapturePerformance.addClickShutterTime(r0)
            goto L92
        L87:
            long r0 = java.lang.System.currentTimeMillis()
            com.oplus.camera.perf.SwitchCameraPerformance.setSwitchCameraStartTime(r0)
            com.oplus.camera.perf.b_renamed$a_renamed r2 = com.oplus.camera.perf.b_renamed.a_renamed.STATE_SWITCHING_CAMERA
            com.oplus.camera.perf.b_renamed.f5009b = r2
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.b_renamed.a_renamed(java.lang.String):void");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b_renamed(java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.b_renamed.b_renamed(java.lang.String):void");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c_renamed(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.b_renamed.c_renamed(java.lang.String):void");
    }

    /* compiled from: CameraPerformance.java */
    /* renamed from: com.oplus.camera.perf.b_renamed$3, reason: invalid class name */
    static /* synthetic */ class ParameterContainer_6 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f5010a = new int[com.oplus.camera.perf.b_renamed.a_renamed.values().length];

        static {
            try {
                f5010a[com.oplus.camera.perf.b_renamed.a_renamed.STATE_LAUNCHING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f5010a[com.oplus.camera.perf.b_renamed.a_renamed.STATE_SWITCH_MODE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f5010a[com.oplus.camera.perf.b_renamed.a_renamed.STATE_SWITCHING_CAMERA.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private static void b_renamed() {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.perf.b_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.b_renamed("CameraPerformance", "setLaunchEndCpuInfo");
                com.oplus.camera.perf.b_renamed.f5008a.b_renamed();
                com.oplus.camera.perf.b_renamed.f5008a.c_renamed();
                if (com.oplus.camera.perf.b_renamed.f5008a.d_renamed()) {
                    com.oplus.camera.perf.LaunchPerformance.setLaunchCpuInfo(com.oplus.camera.perf.b_renamed.f5008a.toString());
                } else {
                    com.oplus.camera.perf.LaunchPerformance.setLaunchCpuInfo("");
                }
                if (com.oplus.camera.perf.ComprehensivePerformance.c_renamed()) {
                    return;
                }
                com.oplus.camera.perf.b_renamed.f5008a.a_renamed(false);
            }
        }, "read performance");
    }

    public static void a_renamed(java.lang.String str, int i_renamed) {
        if (30 >= android.os.Build.VERSION.SDK_INT) {
            return;
        }
        int iMyPid = android.os.Process.myPid();
        com.oplus.camera.e_renamed.b_renamed("CameraPerformance", "setUxThreadValue: pid is_renamed: " + iMyPid + ", tid is_renamed " + i_renamed + " value is_renamed " + str);
        if (iMyPid == 0 || i_renamed == 0) {
            com.oplus.camera.e_renamed.f_renamed("CameraPerformance", "setUxThreadValue fail");
            return;
        }
        try {
            com.oplus.uifirst.OplusUIFirstManager.getInstance().setUxThreadValue(iMyPid, i_renamed, str);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }
}
