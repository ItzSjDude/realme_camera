package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsSystemVariableManager {
    public static int getSystemVariableInt(android.content.Context context, java.lang.String str) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getInt(str, 0);
    }

    public static void setSystemVariableInt(android.content.Context context, java.lang.String str, int i_renamed) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(str, i_renamed);
        editorEdit.commit();
    }

    public static java.lang.String getSystemVariableString(android.content.Context context, java.lang.String str) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getString(str, "");
    }

    public static void setSystemVariableString(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static java.util.Set<java.lang.String> getSystemVariableStringSet(android.content.Context context, java.lang.String str) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getStringSet(str, new java.util.HashSet());
    }

    public static void setSystemVariableStringSet(android.content.Context context, java.lang.String str, java.util.Set<java.lang.String> set) {
        android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.remove(str);
        editorEdit.putStringSet(str, set);
        editorEdit.commit();
    }
}
