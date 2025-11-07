package com.oplus.camera.tuningupgrade;

/* loaded from: classes2.dex */
public class TuningParameterUpgradeReceiver extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.String stringExtra;
        java.lang.String stringExtra2;
        java.lang.String stringExtra3 = "";
        if ("com.oplusos.sau.DATARES_UPDATE".equalsIgnoreCase(intent.getAction())) {
            try {
                stringExtra = intent.getStringExtra("code");
                try {
                    stringExtra2 = intent.getStringExtra(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed = e_renamed;
                    stringExtra2 = "";
                }
            } catch (java.lang.Exception e2) {
                e_renamed = e2;
                stringExtra = "";
                stringExtra2 = stringExtra;
            }
            try {
                stringExtra3 = intent.getStringExtra("from");
            } catch (java.lang.Exception e3) {
                e_renamed = e3;
                com.oplus.camera.e_renamed.a_renamed("TuningParameterUpgradeReceiver", "onReceive, error: " + e_renamed.toString());
                com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + stringExtra + ", version: " + stringExtra2 + ", from: " + stringExtra3);
                android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.oplus.camera.tuningupgrade.TuningParameterUpgradeService.class);
                intent2.setAction("com.oplus.camera.TUNING_UPGRADE");
                intent2.putExtra("from", stringExtra3);
                intent2.putExtra(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION, stringExtra2);
                intent2.putExtra("code", stringExtra);
                context.startService(intent2);
            }
            com.oplus.camera.e_renamed.b_renamed("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + stringExtra + ", version: " + stringExtra2 + ", from: " + stringExtra3);
            android.content.Intent intent22 = new android.content.Intent(context, (java.lang.Class<?>) com.oplus.camera.tuningupgrade.TuningParameterUpgradeService.class);
            intent22.setAction("com.oplus.camera.TUNING_UPGRADE");
            intent22.putExtra("from", stringExtra3);
            intent22.putExtra(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION, stringExtra2);
            intent22.putExtra("code", stringExtra);
            context.startService(intent22);
        }
    }
}
