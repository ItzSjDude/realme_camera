package com.oplus.camera.sticker.c_renamed;

/* compiled from: PrefUtils.java */
/* loaded from: classes2.dex */
public class d_renamed {
    public static long a_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getLong("local_data_version", 0L);
    }

    public static long b_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getLong("check_interval_in_minute", 0L);
    }

    public static long c_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getLong("last_request_time", 0L);
    }

    public static void a_renamed(android.content.Context context, long j_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("local_data_version", j_renamed);
        editorEdit.apply();
    }

    public static void b_renamed(android.content.Context context, long j_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("check_interval_in_minute", j_renamed);
        editorEdit.apply();
    }

    public static void c_renamed(android.content.Context context, long j_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("last_request_time", j_renamed);
        editorEdit.apply();
    }

    public static void a_renamed(android.content.Context context, boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("test_environment", z_renamed);
        editorEdit.apply();
        a_renamed(context, 0L);
        c_renamed(context, 0L);
    }

    public static boolean d_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getBoolean("test_environment", false);
    }

    public static void b_renamed(android.content.Context context, boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("trace_debug", z_renamed);
        editorEdit.apply();
    }

    public static boolean e_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getBoolean("trace_debug", false);
    }

    public static void a_renamed(android.content.Context context, int i_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt("auditing_mode", i_renamed);
        editorEdit.apply();
        a_renamed(context, 0L);
        c_renamed(context, 0L);
    }

    public static int f_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getInt("auditing_mode", 3);
    }

    public static void c_renamed(android.content.Context context, boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("dump_retention", z_renamed);
        editorEdit.apply();
    }

    public static boolean g_renamed(android.content.Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getBoolean("dump_retention", false);
    }
}
