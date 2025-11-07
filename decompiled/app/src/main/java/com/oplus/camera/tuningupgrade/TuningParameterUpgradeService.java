package com.oplus.camera.tuningupgrade;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TuningParameterUpgradeService extends IntentService {

    /* renamed from: PlatformImplementations.kt_3 */
    private TuningParameterUpgradeDcsMsgData f17055a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f17056b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f17057c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f17058d;

    public TuningParameterUpgradeService() {
        super("TuningParameterUpgradeService");
        this.f17055a = null;
        this.f17056b = null;
        this.f17057c = null;
        this.f17058d = null;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        if (intent == null || !"com.oplus.camera.TUNING_UPGRADE".equalsIgnoreCase(intent.getAction())) {
            return;
        }
        this.f17056b = intent.getStringExtra("code");
        if ("camera_rio_upgrade".equals(this.f17056b)) {
            this.f17057c = "data/.camera/";
            this.f17058d = "camera_rio_upgrade";
        } else {
            this.f17057c = "/data/vendor/camera_update/";
            this.f17058d = "camera_tuning_upgrade";
        }
        String str = "/data/oplus/common/sau_res/res/" + this.f17056b + File.separator;
        String stringExtra = intent.getStringExtra(CameraStatisticsUtil.RUS_FILE_VERSION);
        String stringExtra2 = intent.getStringExtra("from");
        CameraLog.m12959b("TuningParameterUpgradeService", "onHandleIntent, call from broadcast version: " + stringExtra + ", from: " + stringExtra2 + ", oldPath: " + str);
        SharedPreferences.Editor editorEdit = PreferenceManager.m3981a(this).edit();
        editorEdit.putInt("copy_tuning_file_state", 1);
        editorEdit.apply();
        if (this.f17055a == null) {
            this.f17055a = new TuningParameterUpgradeDcsMsgData(this);
        }
        this.f17055a.m17942a();
        if (!"TuningParameterUpgradeService".equals(stringExtra2) && !"MyApplication".equals(stringExtra2)) {
            m17941c("-1");
            boolean zM17937a = m17937a(str);
            m17941c("0");
            CameraLog.m12959b("TuningParameterUpgradeService", "onHandleIntent, copy result: " + zM17937a);
        } else if ("MyApplication".equals(stringExtra2)) {
            m17934a();
        }
        editorEdit.putInt("copy_tuning_file_state", 2);
        editorEdit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019e  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m17937a(java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tuningupgrade.TuningParameterUpgradeService.m17937a(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ boolean m17938a(HashMap map, Map map2, File file) {
        return file.exists() && file.canRead() && map.containsKey(file.getName()) && map2.containsKey(file.getName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m17935a(File file, File file2) throws IOException {
        CameraLog.m12959b("TuningParameterUpgradeService", "copyFile, " + file2.getAbsolutePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    if (file2.exists() && file2.canWrite()) {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int OplusGLSurfaceView_13 = fileInputStream.read(bArr);
                            if (OplusGLSurfaceView_13 != -1) {
                                fileOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                            } else {
                                file2.setReadable(true, false);
                                fileOutputStream.close();
                                fileInputStream.close();
                                return true;
                            }
                        }
                    }
                    CameraLog.m12967f("TuningParameterUpgradeService", "copyFile, cannot create file " + file2.getAbsolutePath());
                    fileOutputStream.close();
                    fileInputStream.close();
                    return false;
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("TuningParameterUpgradeService", "copyFile, create or copy file " + file2.getAbsolutePath() + " failed");
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m17936a(File file, String str) throws IOException {
        if (!file.exists() || file.isDirectory()) {
            CameraLog.m12967f("TuningParameterUpgradeService", "checkFileMD5, File " + file.getAbsolutePath() + " doesn't exist");
            return false;
        }
        MessageDigest messageDigest = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                while (true) {
                    int OplusGLSurfaceView_13 = fileInputStream.read(bArr, 0, 1024);
                    if (OplusGLSurfaceView_13 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, OplusGLSurfaceView_13);
                }
                fileInputStream.close();
            } finally {
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("TuningParameterUpgradeService", "checkFileMD5, getFileMD5:", COUIBaseListPopupWindow_8);
        }
        if (messageDigest == null) {
            CameraLog.m12967f("TuningParameterUpgradeService", "checkFileMD5, cannot get digest");
            return false;
        }
        String strM17933a = m17933a(messageDigest.digest());
        if (strM17933a.equals(str)) {
            CameraLog.m12959b("TuningParameterUpgradeService", "checkFileMD5, " + file.getAbsolutePath() + " pass");
            return true;
        }
        CameraLog.m12959b("TuningParameterUpgradeService", "checkFileMD5, " + strM17933a + " " + str);
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17940b(String str) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        if (str == null || str.length() == 0) {
            CameraLog.m12967f("TuningParameterUpgradeService", "updateInfoFile, info is invalided");
            return;
        }
        File file = new File(this.f17057c + "updateInfo");
        try {
            fileWriter = new FileWriter(file, true);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } finally {
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        try {
            if (file.exists() && file.canWrite()) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                file.setReadable(true, false);
                file.setWritable(true, false);
                bufferedWriter.close();
                fileWriter.close();
                CameraLog.m12959b("TuningParameterUpgradeService", "updateInfoFile, success!");
                return;
            }
            CameraLog.m12967f("TuningParameterUpgradeService", "updateInfoFile, File " + file.getAbsolutePath() + " is invalided");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17934a() throws Throwable {
        try {
            File file = new File(this.f17057c);
            if (file.exists() && file.isDirectory()) {
                if ("-1".equals(m17939b())) {
                    boolean zM17937a = m17937a("/data/oplus/common/sau_res/res/" + this.f17058d);
                    m17941c("0");
                    CameraLog.m12959b("TuningParameterUpgradeService", "checkCopyTuningFiles, copyRes: " + zM17937a);
                    return;
                }
                return;
            }
            CameraLog.m12959b("TuningParameterUpgradeService", "checkCopyTuningFiles, no update dir");
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("TuningParameterUpgradeService", "checkCopyTuningFiles ", COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17941c(String str) throws IOException {
        File file = new File(this.f17057c + "updateFlag");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                if (file.exists() && file.canWrite()) {
                    fileOutputStream.write(str.getBytes());
                    file.setWritable(true, false);
                    file.setReadable(true, false);
                    CameraLog.m12954a("TuningParameterUpgradeService", "setFlag, " + str + ": success!");
                    fileOutputStream.close();
                    return;
                }
                CameraLog.m12967f("TuningParameterUpgradeService", "setFlag, File " + file.getAbsolutePath() + " is invalided");
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12967f("TuningParameterUpgradeService", "setFlag, failed!");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m17939b() throws IOException {
        String str;
        File file = new File(this.f17057c + "updateFlag");
        str = "-2";
        if (!file.exists() || file.isDirectory()) {
            CameraLog.m12959b("TuningParameterUpgradeService", "getFlag, flag file don't exist");
            return "-2";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                str = fileInputStream.read(bArr) != -1 ? new String(bArr, StandardCharsets.UTF_8) : "-2";
                fileInputStream.close();
            } finally {
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        CameraLog.m12959b("TuningParameterUpgradeService", "getFlag, " + str);
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m17933a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (2 > hexString.length()) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
