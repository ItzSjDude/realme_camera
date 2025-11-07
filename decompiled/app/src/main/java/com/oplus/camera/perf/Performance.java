package com.oplus.camera.perf;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.oplus.camera.CameraLog;
import com.oplus.camera.MyApplication;
import com.oplus.camera.p143f.DiagnosisTools;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.perf.CameraExitPerformance;
import com.oplus.camera.perf.CapturePerformance;
import com.oplus.camera.perf.ComprehensivePerformance;
import com.oplus.camera.perf.ContinuousCapturePerformance;
import com.oplus.camera.perf.FluencyPerformance;
import com.oplus.camera.perf.LaunchPerformance;
import com.oplus.camera.perf.PictureSavePerformance;
import com.oplus.camera.perf.SwitchCameraPerformance;
import com.oplus.camera.perf.SwitchModePerformance;
import com.oplus.camera.perf.VideoRecordPerformance;
import com.oplus.camera.perf.VideoSavePerformance;
import com.oplus.camera.statistics.QualityReport;
import com.oplus.camera.statistics.model.PerfMonitorMsgData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Keep
/* loaded from: classes2.dex */
public class Performance {
    private static final int COUNT_LIMIT = 5;
    private static final String FILE_NAME_PREFIX = "camera_data_";
    private static final boolean PERFORMANCE_WRITE_FILE_SWITCH = false;
    private static final String TAG = "Performance";
    private static Context sContext = MyApplication.m11092d();
    private static String sFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath();
    private static String sMarkFilePath = sFilePath + File.separator + "switch_mark";
    private static AtomicInteger sCount = new AtomicInteger(0);
    private static C2860a sPerformanceData = new C2860a();
    private static Gson sGson = new Gson();

    /* renamed from: com.oplus.camera.perf.Performance$PlatformImplementations.kt_3 */
    public static class C2860a {

        /* renamed from: PlatformImplementations.kt_3 */
        private List<LaunchPerformance.LaunchPerformanceData> f15150a = new ArrayList();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Map<Long, CapturePerformance.CapturePerformanceData> f15151b = new HashMap();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private List<SwitchModePerformance.SwitchModePerformanceData> f15152c = new ArrayList();

        /* renamed from: IntrinsicsJvm.kt_5 */
        private List<SwitchCameraPerformance.SwitchCameraPerformanceData> f15153d = new ArrayList();

        /* renamed from: COUIBaseListPopupWindow_8 */
        private List<VideoRecordPerformance.VideoRecordPerformanceData> f15154e = new ArrayList();

        /* renamed from: COUIBaseListPopupWindow_12 */
        private List<VideoSavePerformance.VideoSavePerformanceData> f15155f = new ArrayList();

        /* renamed from: COUIBaseListPopupWindow_11 */
        private List<PictureSavePerformance.PictureSavePerformanceData> f15156g = new ArrayList();

        /* renamed from: COUIBaseListPopupWindow_10 */
        private List<CameraExitPerformance.CameraExitPerformanceData> f15157h = new ArrayList();

        /* renamed from: OplusGLSurfaceView_13 */
        private List<ContinuousCapturePerformance.ContinuousCapturePerformanceData> f15158i = new ArrayList();

        /* renamed from: OplusGLSurfaceView_15 */
        private List<ComprehensivePerformance.PerformanceRecordData> f15159j = new ArrayList();

        /* renamed from: OplusGLSurfaceView_5 */
        private List<FluencyPerformance.FluencyPerformanceData> f15160k = new ArrayList();

        /* renamed from: PlatformImplementations.kt_3 */
        public void m15176a() {
            this.f15150a.clear();
            this.f15151b.clear();
            this.f15152c.clear();
            this.f15153d.clear();
            this.f15154e.clear();
            this.f15155f.clear();
            this.f15156g.clear();
            this.f15157h.clear();
            this.f15158i.clear();
            this.f15159j.clear();
            this.f15160k.clear();
        }
    }

    public static void add(ContinuousCapturePerformance.ContinuousCapturePerformanceData continuousCapturePerformanceData) {
        CameraLog.m12954a(TAG, "add, continuousCapturePerformanceData: " + sGson.toJson(continuousCapturePerformanceData));
        PerfMonitorMsgData.reportContinuousCapture(sContext, continuousCapturePerformanceData);
        sPerformanceData.f15158i.add(continuousCapturePerformanceData);
        count();
    }

    public static void add(CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData) {
        CameraLog.m12954a(TAG, "add, cameraExitPerformanceData: " + sGson.toJson(cameraExitPerformanceData));
        PerfMonitorMsgData.reportCameraExit(sContext, cameraExitPerformanceData);
        sPerformanceData.f15157h.add(cameraExitPerformanceData);
        count();
    }

    public static void add(PictureSavePerformance.PictureSavePerformanceData pictureSavePerformanceData) {
        CameraLog.m12954a(TAG, "add, pictureSavePerformanceData: " + sGson.toJson(pictureSavePerformanceData));
        PerfMonitorMsgData.reportPictureSave(sContext, pictureSavePerformanceData);
        DiagnosisTools.m13376b(pictureSavePerformanceData.getPictureSaveTime());
        sPerformanceData.f15156g.add(pictureSavePerformanceData);
        count();
    }

    public static void add(VideoSavePerformance.VideoSavePerformanceData videoSavePerformanceData) {
        CameraLog.m12954a(TAG, "add, videoSavePerformanceData: " + sGson.toJson(videoSavePerformanceData));
        PerfMonitorMsgData.reportVideoSave(sContext, videoSavePerformanceData);
        DiagnosisTools.m13378c(videoSavePerformanceData.getVideoSaveTime());
        sPerformanceData.f15155f.add(videoSavePerformanceData);
        count();
    }

    public static void add(VideoRecordPerformance.VideoRecordPerformanceData videoRecordPerformanceData) {
        CameraLog.m12954a(TAG, "add, videoRecordPerformanceData: " + sGson.toJson(videoRecordPerformanceData));
        PerfMonitorMsgData.reportStartVideoRecord(sContext, videoRecordPerformanceData);
        sPerformanceData.f15154e.add(videoRecordPerformanceData);
        count();
    }

    public static void add(SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData) {
        CameraLog.m12954a(TAG, "add, switchCameraPerformanceData: " + sGson.toJson(switchCameraPerformanceData));
        PerfMonitorMsgData.reportSwitchCamera(sContext, switchCameraPerformanceData);
        sPerformanceData.f15153d.add(switchCameraPerformanceData);
        count();
        if (switchCameraPerformanceData.isNeedReport()) {
            report2EAP(QualityReport.EVENT_ID_SWITCH_CAMERA, sGson.toJson(switchCameraPerformanceData));
        }
    }

    public static void add(SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData) {
        CameraLog.m12954a(TAG, "add, switchModePerformanceData: " + sGson.toJson(switchModePerformanceData));
        PerfMonitorMsgData.reportSwitchMode(sContext, switchModePerformanceData);
        sPerformanceData.f15152c.add(switchModePerformanceData);
        count();
        if (switchModePerformanceData.isNeedReport()) {
            report2EAP(QualityReport.EVENT_ID_SWITCH_MODE, sGson.toJson(switchModePerformanceData));
        }
    }

    public static void add(LaunchPerformance.LaunchPerformanceData launchPerformanceData) {
        CameraLog.m12954a(TAG, "add, launchPerformanceData: " + sGson.toJson(launchPerformanceData));
        PerfMonitorMsgData.reportLaunch(sContext, launchPerformanceData);
        DiagnosisTools.m13371a(launchPerformanceData.launchTime());
        sPerformanceData.f15150a.add(launchPerformanceData);
        count();
        if (launchPerformanceData.isNeedReport()) {
            report2EAP(QualityReport.EVENT_ID_START, sGson.toJson(launchPerformanceData));
        }
    }

    public static void add(long OplusGLSurfaceView_15, CapturePerformance.CapturePerformanceData capturePerformanceData) {
        CameraLog.m12954a(TAG, "add, capturePerformanceData: " + sGson.toJson(capturePerformanceData));
        PerfMonitorMsgData.reportCapture(sContext, capturePerformanceData);
        sPerformanceData.f15151b.put(Long.valueOf(OplusGLSurfaceView_15), capturePerformanceData);
        count();
        if (capturePerformanceData.isNeedReport()) {
            report2EAP(QualityReport.EVENT_ID_CAPTURE_THUMBNAIL_STUCK, sGson.toJson(capturePerformanceData));
        }
    }

    public static void add(ComprehensivePerformance.PerformanceRecordData performanceRecordData) {
        CameraLog.m12954a(TAG, "add, performanceRecordData: " + sGson.toJson(performanceRecordData));
        PerfMonitorMsgData.reportComprehensive(sContext, performanceRecordData);
        sPerformanceData.f15159j.add(performanceRecordData);
        count();
        if (performanceRecordData.isNeedReport()) {
            report2EAP(QualityReport.EVENT_ID_CAPTURE_TOTAL_STUCK, sGson.toJson(performanceRecordData));
        }
        if (performanceRecordData.isModeNeedReport()) {
            DiagnosisTools.m13376b(performanceRecordData.getPictureSaveTime());
        }
    }

    public static void add(FluencyPerformance.FluencyPerformanceData fluencyPerformanceData) {
        CameraLog.m12954a(TAG, "add, fluencyPerformanceData: " + sGson.toJson(fluencyPerformanceData));
        PerfMonitorMsgData.reportFluency(sContext, fluencyPerformanceData);
        sPerformanceData.f15160k.add(fluencyPerformanceData);
        count();
    }

    private static void count() {
        if (!new File(sMarkFilePath).exists()) {
            sPerformanceData.m15176a();
        } else {
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.perf.Performance.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    if (Performance.sCount.incrementAndGet() >= 5) {
                        Performance.sCount.set(0);
                        Performance.writeToFile();
                        Performance.sPerformanceData.m15176a();
                    } else {
                        CameraLog.m12967f(Performance.TAG, "count, sCount: " + Performance.sCount.get());
                    }
                }
            }, "Perf write file");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeToFile() throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(sFilePath + File.separator + generateFileName());
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return;
                }
            } catch (IOException e2) {
                COUIBaseListPopupWindow_8 = e2;
            }
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(new Gson().toJson(sPerformanceData).getBytes());
            fileOutputStream.close();
        } catch (IOException e3) {
            COUIBaseListPopupWindow_8 = e3;
            fileOutputStream2 = fileOutputStream;
            COUIBaseListPopupWindow_8.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static String generateFileName() {
        return FILE_NAME_PREFIX + new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss", Locale.CHINA).format(new Date(System.currentTimeMillis())) + ".txt";
    }

    private static void report2EAP(final int OplusGLSurfaceView_13, final String str) {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.perf.Performance.2
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                QualityReport.report(OplusGLSurfaceView_13, str);
            }
        }, "EAP report");
    }
}
