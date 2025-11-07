package com.oplus.camera.tuningupgrade;

/* loaded from: classes2.dex */
public class TuningParameterUpgradeService extends android.app.IntentService {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.tuningupgrade.a_renamed f5725a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5726b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f5727c;
    private java.lang.String d_renamed;

    public TuningParameterUpgradeService() {
        super("TuningParameterUpgradeService");
        this.f5725a = null;
        this.f5726b = null;
        this.f5727c = null;
        this.d_renamed = null;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(android.content.Intent intent) throws java.lang.Throwable {
        if (intent == null || !"com.oplus.camera.TUNING_UPGRADE".equalsIgnoreCase(intent.getAction())) {
            return;
        }
        this.f5726b = intent.getStringExtra("code");
        if ("camera_rio_upgrade".equals(this.f5726b)) {
            this.f5727c = "data/.camera/";
            this.d_renamed = "camera_rio_upgrade";
        } else {
            this.f5727c = "/data/vendor/camera_update/";
            this.d_renamed = "camera_tuning_upgrade";
        }
        java.lang.String str = "/data/oplus/common/sau_res/res/" + this.f5726b + java.io.File.separator;
        java.lang.String stringExtra = intent.getStringExtra(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION);
        java.lang.String stringExtra2 = intent.getStringExtra("from");
        com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "onHandleIntent, call from broadcast version: " + stringExtra + ", from: " + stringExtra2 + ", oldPath: " + str);
        android.content.SharedPreferences.Editor editorEdit = androidx.preference.j_renamed.a_renamed(this).edit();
        editorEdit.putInt("copy_tuning_file_state", 1);
        editorEdit.apply();
        if (this.f5725a == null) {
            this.f5725a = new com.oplus.camera.tuningupgrade.a_renamed(this);
        }
        this.f5725a.a_renamed();
        if (!"TuningParameterUpgradeService".equals(stringExtra2) && !"MyApplication".equals(stringExtra2)) {
            c_renamed("-1");
            boolean zA = a_renamed(str);
            c_renamed("0");
            com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "onHandleIntent, copy result: " + zA);
        } else if ("MyApplication".equals(stringExtra2)) {
            a_renamed();
        }
        editorEdit.putInt("copy_tuning_file_state", 2);
        editorEdit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:150:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:91:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:93:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tuningupgrade.TuningParameterUpgradeService.a_renamed(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a_renamed(java.util.HashMap map, java.util.Map map2, java.io.File file) {
        return file.exists() && file.canRead() && map.containsKey(file.getName()) && map2.containsKey(file.getName());
    }

    private boolean a_renamed(java.io.File file, java.io.File file2) throws java.io.IOException {
        com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "copyFile, " + file2.getAbsolutePath());
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    if (file2.exists() && file2.canWrite()) {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i_renamed = fileInputStream.read(bArr);
                            if (i_renamed != -1) {
                                fileOutputStream.write(bArr, 0, i_renamed);
                            } else {
                                file2.setReadable(true, false);
                                fileOutputStream.close();
                                fileInputStream.close();
                                return true;
                            }
                        }
                    }
                    com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "copyFile, cannot create file " + file2.getAbsolutePath());
                    fileOutputStream.close();
                    fileInputStream.close();
                    return false;
                } catch (java.lang.Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
            }
        } catch (java.io.IOException e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "copyFile, create or copy file " + file2.getAbsolutePath() + " failed");
            e_renamed.printStackTrace();
            return false;
        }
    }

    private boolean a_renamed(java.io.File file, java.lang.String str) throws java.io.IOException {
        if (!file.exists() || file.isDirectory()) {
            com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "checkFileMD5, File " + file.getAbsolutePath() + " doesn't_renamed exist");
            return false;
        }
        java.security.MessageDigest messageDigest = null;
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                messageDigest = java.security.MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                while (true) {
                    int i_renamed = fileInputStream.read(bArr, 0, 1024);
                    if (i_renamed == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i_renamed);
                }
                fileInputStream.close();
            } finally {
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("TuningParameterUpgradeService", "checkFileMD5, getFileMD5:", e_renamed);
        }
        if (messageDigest == null) {
            com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "checkFileMD5, cannot get digest");
            return false;
        }
        java.lang.String strA = a_renamed(messageDigest.digest());
        if (strA.equals(str)) {
            com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "checkFileMD5, " + file.getAbsolutePath() + " pass");
            return true;
        }
        com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "checkFileMD5, " + strA + " " + str);
        return false;
    }

    private void b_renamed(java.lang.String str) {
        java.io.FileWriter fileWriter;
        java.io.BufferedWriter bufferedWriter;
        if (str == null || str.length() == 0) {
            com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "updateInfoFile, info is_renamed invalided");
            return;
        }
        java.io.File file = new java.io.File(this.f5727c + "updateInfo");
        try {
            fileWriter = new java.io.FileWriter(file, true);
            try {
                bufferedWriter = new java.io.BufferedWriter(fileWriter);
            } finally {
            }
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        try {
            if (file.exists() && file.canWrite()) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                file.setReadable(true, false);
                file.setWritable(true, false);
                bufferedWriter.close();
                fileWriter.close();
                com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "updateInfoFile, success!");
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "updateInfoFile, File " + file.getAbsolutePath() + " is_renamed invalided");
            bufferedWriter.close();
            fileWriter.close();
        } catch (java.lang.Throwable th) {
            try {
                bufferedWriter.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void a_renamed() throws java.lang.Throwable {
        try {
            java.io.File file = new java.io.File(this.f5727c);
            if (file.exists() && file.isDirectory()) {
                if ("-1".equals(b_renamed())) {
                    boolean zA = a_renamed("/data/oplus/common/sau_res/res/" + this.d_renamed);
                    c_renamed("0");
                    com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "checkCopyTuningFiles, copyRes: " + zA);
                    return;
                }
                return;
            }
            com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "checkCopyTuningFiles, no update dir");
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("TuningParameterUpgradeService", "checkCopyTuningFiles ", e_renamed);
        }
    }

    private void c_renamed(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(this.f5727c + "updateFlag");
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                if (file.exists() && file.canWrite()) {
                    fileOutputStream.write(str.getBytes());
                    file.setWritable(true, false);
                    file.setReadable(true, false);
                    com.oplus.camera.e_renamed.a_renamed("TuningParameterUpgradeService", "setFlag, " + str + ": success!");
                    fileOutputStream.close();
                    return;
                }
                com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "setFlag, File " + file.getAbsolutePath() + " is_renamed invalided");
                fileOutputStream.close();
            } finally {
            }
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("TuningParameterUpgradeService", "setFlag, failed!");
        }
    }

    private java.lang.String b_renamed() throws java.io.IOException {
        java.lang.String str;
        java.io.File file = new java.io.File(this.f5727c + "updateFlag");
        str = "-2";
        if (!file.exists() || file.isDirectory()) {
            com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "getFlag, flag file don't_renamed exist");
            return "-2";
        }
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                str = fileInputStream.read(bArr) != -1 ? new java.lang.String(bArr, java.nio.charset.StandardCharsets.UTF_8) : "-2";
                fileInputStream.close();
            } finally {
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeService", "getFlag, " + str);
        return str;
    }

    private java.lang.String a_renamed(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            if (2 > hexString.length()) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
