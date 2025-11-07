package com.heytap.accessory.platform;

@android.annotation.TargetApi(26)
/* loaded from: classes2.dex */
public final class MessageReceiver extends android.content.BroadcastReceiver {
    private static java.lang.String TAG = "MessageReceiver";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) throws java.lang.ClassNotFoundException {
        android.content.ComponentName componentNameStartService;
        if (intent != null && intent.getAction() != null) {
            if (com.heytap.accessory.BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(intent.getAction())) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Incoming Data Received!!!");
                try {
                    new com.heytap.accessory.b_renamed.g_renamed(context);
                    try {
                        java.lang.String stringExtra = intent.getStringExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_IMPL_CLASS);
                        if (stringExtra == null) {
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Impl class not available in_renamed intent. ignoring message received");
                            return;
                        }
                        java.lang.Class<?> cls = java.lang.Class.forName(stringExtra);
                        if (!isValidImplClass(context, cls.getName())) {
                            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "invalid impl class: " + cls.getName());
                            return;
                        }
                        boolean z_renamed = false;
                        int i_renamed = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
                        if (android.os.Build.VERSION.SDK_INT >= 26 && i_renamed >= 26) {
                            z_renamed = true;
                        }
                        intent.setClassName(context, stringExtra);
                        if (com.heytap.accessory.b_renamed.c_renamed.a_renamed(com.heytap.accessory.BaseJobAgent.class, cls) && z_renamed) {
                            com.heytap.accessory.BaseJobService.scheduleMessageJob(context.getApplicationContext(), stringExtra, intent.getLongExtra("transactionId", 0L), intent.getStringExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID), (com.heytap.accessory.bean.PeerAgent) intent.getParcelableExtra(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT));
                            return;
                        }
                        if (z_renamed) {
                            componentNameStartService = context.startForegroundService(intent);
                        } else {
                            componentNameStartService = context.startService(intent);
                        }
                        if (componentNameStartService == null) {
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Agent " + stringExtra + " not found. Check Accessory Service XML for serviceImpl attribute");
                            return;
                        }
                        return;
                    } catch (java.lang.ClassNotFoundException e_renamed) {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Agent Impl class not found!".concat(java.lang.String.valueOf(e_renamed)));
                        return;
                    } catch (java.lang.Exception e2) {
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "", e2);
                        return;
                    }
                } catch (com.heytap.accessory.bean.GeneralException e3) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "SDK config initialization failed.".concat(java.lang.String.valueOf(e3)));
                    return;
                }
            }
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "received null intent!");
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
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "fetch service profile description failed !!");
            }
        } else {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "config  util default instance  creation failed !!");
        }
        return z_renamed;
    }
}
