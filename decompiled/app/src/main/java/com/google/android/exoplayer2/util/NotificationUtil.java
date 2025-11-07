package com.google.android.exoplayer2.util;

@android.annotation.SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class NotificationUtil {
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Importance {
    }

    public static void createNotificationChannel(android.content.Context context, java.lang.String str, int i_renamed, int i2) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
            ((android.app.NotificationManager) context.getSystemService("notification")).createNotificationChannel(new android.app.NotificationChannel(str, context.getString(i_renamed), i2));
        }
    }

    public static void setNotification(android.content.Context context, int i_renamed, android.app.Notification notification) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService("notification");
        if (notification != null) {
            notificationManager.notify(i_renamed, notification);
        } else {
            notificationManager.cancel(i_renamed);
        }
    }

    private NotificationUtil() {
    }
}
