package com.meicam.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class NvsSystemVariableManager {
    public static int getSystemVariableInt(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, 0);
    }

    public static void setSystemVariableInt(Context context, String str, int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(str, OplusGLSurfaceView_13);
        editorEdit.commit();
    }

    public static String getSystemVariableString(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, "");
    }

    public static void setSystemVariableString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static Set<String> getSystemVariableStringSet(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet(str, new HashSet());
    }

    public static void setSystemVariableStringSet(Context context, String str, Set<String> set) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.remove(str);
        editorEdit.putStringSet(str, set);
        editorEdit.commit();
    }
}
