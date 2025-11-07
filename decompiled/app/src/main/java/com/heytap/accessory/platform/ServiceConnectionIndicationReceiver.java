package com.heytap.accessory.platform;

@android.annotation.TargetApi(26)
/* loaded from: classes2.dex */
public final class ServiceConnectionIndicationReceiver extends android.content.BroadcastReceiver {
    private final java.lang.String TAG = com.heytap.accessory.platform.ServiceConnectionIndicationReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) throws java.lang.ClassNotFoundException {
        android.content.ComponentName componentNameStartService;
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "onReceive");
        if (intent == null || intent.getAction() == null || !"com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(intent.getAction())) {
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(this.TAG, "Incoming service connection request received.");
        try {
            new com.heytap.accessory.b_renamed.g_renamed(context);
            try {
                java.lang.String stringExtra = intent.getStringExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_IMPL_CLASS);
                if (stringExtra == null) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "Impl class not available in_renamed intent. Ignoring request");
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(this.TAG, "Connection request will be_renamed handled by_renamed :".concat(java.lang.String.valueOf(stringExtra)));
                java.lang.Class<?> cls = java.lang.Class.forName(stringExtra);
                if (isValidImplClass(context, cls.getName())) {
                    boolean zA = com.heytap.accessory.b_renamed.c_renamed.a_renamed(com.heytap.accessory.BaseJobAgent.class, cls);
                    boolean z_renamed = false;
                    int i_renamed = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
                    boolean z2 = android.os.Build.VERSION.SDK_INT >= 21 && i_renamed >= 21;
                    if (android.os.Build.VERSION.SDK_INT >= 26 && i_renamed >= 26) {
                        z_renamed = true;
                    }
                    intent.setClassName(context, stringExtra);
                    if (zA && z2) {
                        com.heytap.accessory.BaseJobService.scheduleSCJob(context.getApplicationContext(), stringExtra, intent.getLongExtra("transactionId", 0L), intent.getStringExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID), (com.heytap.accessory.bean.PeerAgent) intent.getParcelableExtra(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT));
                        return;
                    }
                    if (z_renamed) {
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "startForegroundService");
                        componentNameStartService = context.startForegroundService(intent);
                    } else {
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "startService");
                        componentNameStartService = context.startService(intent);
                    }
                    if (componentNameStartService == null) {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "Agent " + stringExtra + " not found. Check Accessory Service XML for serviceImpl attribute");
                    }
                }
            } catch (java.lang.ClassNotFoundException e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "Agent Impl class not found!".concat(java.lang.String.valueOf(e_renamed)));
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        } catch (com.heytap.accessory.bean.GeneralException e3) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "SDK config init failed.".concat(java.lang.String.valueOf(e3)));
        }
    }

    private synchronized boolean isValidImplClass(android.content.Context context, java.lang.String str) {
        boolean z_renamed;
        z_renamed = false;
        com.heytap.accessory.b_renamed.d_renamed dVarA = com.heytap.accessory.b_renamed.d_renamed.a_renamed(context);
        if (dVarA != null) {
            com.heytap.accessory.bean.ServiceProfile serviceProfileA = dVarA.a_renamed(str);
            if (serviceProfileA != null) {
                if (str.equalsIgnoreCase(serviceProfileA.getServiceImpl())) {
                    z_renamed = true;
                }
            } else {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "fetch service profile description failed !!");
            }
        } else {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "config  util default instance  creation failed !!");
        }
        return z_renamed;
    }
}
