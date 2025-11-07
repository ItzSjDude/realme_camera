package com.oplus.camera.tuningupgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.camera.CameraLog;
import com.oplus.camera.statistics.CameraStatisticsUtil;

/* loaded from: classes2.dex */
public class TuningParameterUpgradeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3 = "";
        if ("com.oplusos.sau.DATARES_UPDATE".equalsIgnoreCase(intent.getAction())) {
            try {
                stringExtra = intent.getStringExtra("code");
                try {
                    stringExtra2 = intent.getStringExtra(CameraStatisticsUtil.RUS_FILE_VERSION);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                    stringExtra2 = "";
                }
            } catch (Exception e2) {
                COUIBaseListPopupWindow_8 = e2;
                stringExtra = "";
                stringExtra2 = stringExtra;
            }
            try {
                stringExtra3 = intent.getStringExtra("from");
            } catch (Exception e3) {
                COUIBaseListPopupWindow_8 = e3;
                CameraLog.m12954a("TuningParameterUpgradeReceiver", "onReceive, error: " + COUIBaseListPopupWindow_8.toString());
                CameraLog.m12959b("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + stringExtra + ", version: " + stringExtra2 + ", from: " + stringExtra3);
                Intent intent2 = new Intent(context, (Class<?>) TuningParameterUpgradeService.class);
                intent2.setAction("com.oplus.camera.TUNING_UPGRADE");
                intent2.putExtra("from", stringExtra3);
                intent2.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, stringExtra2);
                intent2.putExtra("code", stringExtra);
                context.startService(intent2);
            }
            CameraLog.m12959b("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + stringExtra + ", version: " + stringExtra2 + ", from: " + stringExtra3);
            Intent intent22 = new Intent(context, (Class<?>) TuningParameterUpgradeService.class);
            intent22.setAction("com.oplus.camera.TUNING_UPGRADE");
            intent22.putExtra("from", stringExtra3);
            intent22.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, stringExtra2);
            intent22.putExtra("code", stringExtra);
            context.startService(intent22);
        }
    }
}
