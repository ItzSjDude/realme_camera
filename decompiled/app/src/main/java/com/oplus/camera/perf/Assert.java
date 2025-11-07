package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class Performance {
    private static final int COUNT_LIMIT = 5;
    private static final java.lang.String FILE_NAME_PREFIX = "camera_data_";
    private static final boolean PERFORMANCE_WRITE_FILE_SWITCH = false;
    private static final java.lang.String TAG = "Performance";
    private static android.content.Context sContext = com.oplus.camera.MyApplication.d_renamed();
    private static java.lang.String sFilePath = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOCUMENTS).getPath();
    private static java.lang.String sMarkFilePath = sFilePath + java.io.File.separator + "switch_mark";
    private static java.util.concurrent.atomic.AtomicInteger sCount = new java.util.concurrent.atomic.AtomicInteger(0);
    private static com.oplus.camera.perf.Performance.a_renamed sPerformanceData = new com.oplus.camera.perf.Performance.a_renamed();
    private static com.google.gson.Gson sGson = new com.google.gson.Gson();

    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.List<com.oplus.camera.perf.LaunchPerformance.LaunchPerformanceData> f5002a = new java.util.ArrayList();

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.Map<java.lang.Long, com.oplus.camera.perf.CapturePerformance.CapturePerformanceData> f5003b = new java.util.HashMap();

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.util.List<com.oplus.camera.perf.SwitchModePerformance.SwitchModePerformanceData> f5004c = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.SwitchCameraPerformance.SwitchCameraPerformanceData> d_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.VideoRecordPerformance.VideoRecordPerformanceData> e_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.VideoSavePerformance.VideoSavePerformanceData> f_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.PictureSavePerformance.PictureSavePerformanceData> g_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.CameraExitPerformance.CameraExitPerformanceData> h_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.ContinuousCapturePerformance.ContinuousCapturePerformanceData> i_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.ComprehensivePerformance.PerformanceRecordData> j_renamed = new java.util.ArrayList();
        private java.util.List<com.oplus.camera.perf.FluencyPerformance.FluencyPerformanceData> k_renamed = new java.util.ArrayList();

        public void a_renamed() {
            this.f5002a.clear();
            this.f5003b.clear();
            this.f5004c.clear();
            this.d_renamed.clear();
            this.e_renamed.clear();
            this.f_renamed.clear();
            this.g_renamed.clear();
            this.h_renamed.clear();
            this.i_renamed.clear();
            this.j_renamed.clear();
            this.k_renamed.clear();
        }
    }

    public static void add(com.oplus.camera.perf.ContinuousCapturePerformance.ContinuousCapturePerformanceData continuousCapturePerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, continuousCapturePerformanceData: " + sGson.toJson(continuousCapturePerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportContinuousCapture(sContext, continuousCapturePerformanceData);
        sPerformanceData.i_renamed.add(continuousCapturePerformanceData);
        count();
    }

    public static void add(com.oplus.camera.perf.CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, cameraExitPerformanceData: " + sGson.toJson(cameraExitPerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportCameraExit(sContext, cameraExitPerformanceData);
        sPerformanceData.h_renamed.add(cameraExitPerformanceData);
        count();
    }

    public static void add(com.oplus.camera.perf.PictureSavePerformance.PictureSavePerformanceData pictureSavePerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, pictureSavePerformanceData: " + sGson.toJson(pictureSavePerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportPictureSave(sContext, pictureSavePerformanceData);
        com.oplus.camera.f_renamed.a_renamed.b_renamed(pictureSavePerformanceData.getPictureSaveTime());
        sPerformanceData.g_renamed.add(pictureSavePerformanceData);
        count();
    }

    public static void add(com.oplus.camera.perf.VideoSavePerformance.VideoSavePerformanceData videoSavePerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, videoSavePerformanceData: " + sGson.toJson(videoSavePerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportVideoSave(sContext, videoSavePerformanceData);
        com.oplus.camera.f_renamed.a_renamed.c_renamed(videoSavePerformanceData.getVideoSaveTime());
        sPerformanceData.f_renamed.add(videoSavePerformanceData);
        count();
    }

    public static void add(com.oplus.camera.perf.VideoRecordPerformance.VideoRecordPerformanceData videoRecordPerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, videoRecordPerformanceData: " + sGson.toJson(videoRecordPerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportStartVideoRecord(sContext, videoRecordPerformanceData);
        sPerformanceData.e_renamed.add(videoRecordPerformanceData);
        count();
    }

    public static void add(com.oplus.camera.perf.SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, switchCameraPerformanceData: " + sGson.toJson(switchCameraPerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportSwitchCamera(sContext, switchCameraPerformanceData);
        sPerformanceData.d_renamed.add(switchCameraPerformanceData);
        count();
        if (switchCameraPerformanceData.isNeedReport()) {
            report2EAP(com.oplus.camera.statistics.QualityReport.EVENT_ID_SWITCH_CAMERA, sGson.toJson(switchCameraPerformanceData));
        }
    }

    public static void add(com.oplus.camera.perf.SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, switchModePerformanceData: " + sGson.toJson(switchModePerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportSwitchMode(sContext, switchModePerformanceData);
        sPerformanceData.f5004c.add(switchModePerformanceData);
        count();
        if (switchModePerformanceData.isNeedReport()) {
            report2EAP(com.oplus.camera.statistics.QualityReport.EVENT_ID_SWITCH_MODE, sGson.toJson(switchModePerformanceData));
        }
    }

    public static void add(com.oplus.camera.perf.LaunchPerformance.LaunchPerformanceData launchPerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, launchPerformanceData: " + sGson.toJson(launchPerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportLaunch(sContext, launchPerformanceData);
        com.oplus.camera.f_renamed.a_renamed.a_renamed(launchPerformanceData.launchTime());
        sPerformanceData.f5002a.add(launchPerformanceData);
        count();
        if (launchPerformanceData.isNeedReport()) {
            report2EAP(com.oplus.camera.statistics.QualityReport.EVENT_ID_START, sGson.toJson(launchPerformanceData));
        }
    }

    public static void add(long j_renamed, com.oplus.camera.perf.CapturePerformance.CapturePerformanceData capturePerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, capturePerformanceData: " + sGson.toJson(capturePerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportCapture(sContext, capturePerformanceData);
        sPerformanceData.f5003b.put(java.lang.Long.valueOf(j_renamed), capturePerformanceData);
        count();
        if (capturePerformanceData.isNeedReport()) {
            report2EAP(com.oplus.camera.statistics.QualityReport.EVENT_ID_CAPTURE_THUMBNAIL_STUCK, sGson.toJson(capturePerformanceData));
        }
    }

    public static void add(com.oplus.camera.perf.ComprehensivePerformance.PerformanceRecordData performanceRecordData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, performanceRecordData: " + sGson.toJson(performanceRecordData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportComprehensive(sContext, performanceRecordData);
        sPerformanceData.j_renamed.add(performanceRecordData);
        count();
        if (performanceRecordData.isNeedReport()) {
            report2EAP(com.oplus.camera.statistics.QualityReport.EVENT_ID_CAPTURE_TOTAL_STUCK, sGson.toJson(performanceRecordData));
        }
        if (performanceRecordData.isModeNeedReport()) {
            com.oplus.camera.f_renamed.a_renamed.b_renamed(performanceRecordData.getPictureSaveTime());
        }
    }

    public static void add(com.oplus.camera.perf.FluencyPerformance.FluencyPerformanceData fluencyPerformanceData) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "add, fluencyPerformanceData: " + sGson.toJson(fluencyPerformanceData));
        com.oplus.camera.statistics.model.PerfMonitorMsgData.reportFluency(sContext, fluencyPerformanceData);
        sPerformanceData.k_renamed.add(fluencyPerformanceData);
        count();
    }

    private static void count() {
        if (!new java.io.File(sMarkFilePath).exists()) {
            sPerformanceData.a_renamed();
        } else {
            com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.perf.Performance.1
                @Override // java.lang.Runnable
                public void run() throws java.lang.Throwable {
                    if (com.oplus.camera.perf.Performance.sCount.incrementAndGet() >= 5) {
                        com.oplus.camera.perf.Performance.sCount.set(0);
                        com.oplus.camera.perf.Performance.writeToFile();
                        com.oplus.camera.perf.Performance.sPerformanceData.a_renamed();
                    } else {
                        com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.perf.Performance.TAG, "count, sCount: " + com.oplus.camera.perf.Performance.sCount.get());
                    }
                }
            }, "Perf write file");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeToFile() throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(sFilePath + java.io.File.separator + generateFileName());
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.io.IOException e_renamed) {
                    e_renamed.printStackTrace();
                    return;
                }
            } catch (java.io.IOException e2) {
                e_renamed = e2;
            }
        } catch (java.lang.Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(new com.google.gson.Gson().toJson(sPerformanceData).getBytes());
            fileOutputStream.close();
        } catch (java.io.IOException e3) {
            e_renamed = e3;
            fileOutputStream2 = fileOutputStream;
            e_renamed.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static java.lang.String generateFileName() {
        return FILE_NAME_PREFIX + new java.text.SimpleDateFormat("yyyy-MM-dd_hh-mm-ss", java.util.Locale.CHINA).format(new java.util.Date(java.lang.System.currentTimeMillis())) + ".txt";
    }

    private static void report2EAP(final int i_renamed, final java.lang.String str) {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.perf.Performance.2
            @Override // java.lang.Runnable
            public void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                com.oplus.camera.statistics.QualityReport.report(i_renamed, str);
            }
        }, "EAP report");
    }
}
