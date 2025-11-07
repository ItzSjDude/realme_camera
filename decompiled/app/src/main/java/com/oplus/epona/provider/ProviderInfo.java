package com.oplus.epona.provider;

/* loaded from: classes2.dex */
public class ProviderInfo {
    private java.lang.String mClassName;
    private java.util.Map<java.lang.String, java.lang.reflect.Method> mMethodCache = new java.util.HashMap();
    private java.util.Map<java.lang.String, com.oplus.epona.provider.ProviderMethodInfo> mMethods;
    private java.lang.String mName;
    private boolean mNeedIPC;

    public ProviderInfo(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, com.oplus.epona.provider.ProviderMethodInfo> map, boolean z_renamed) {
        this.mName = str;
        this.mClassName = str2;
        this.mMethods = map;
        this.mNeedIPC = z_renamed;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getClassName() {
        return this.mClassName;
    }

    public boolean needIPC() {
        return this.mNeedIPC;
    }

    public boolean containsAction(java.lang.String str) {
        java.util.Map<java.lang.String, com.oplus.epona.provider.ProviderMethodInfo> map = this.mMethods;
        if (map == null) {
            return false;
        }
        return map.containsKey(str);
    }

    public java.lang.reflect.Method getMethod(java.lang.String str) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method method = this.mMethodCache.get(str);
        if (method != null) {
            return method;
        }
        com.oplus.epona.provider.ProviderMethodInfo providerMethodInfo = this.mMethods.get(str);
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(this.mClassName).getDeclaredMethod(providerMethodInfo.getMethodName(), params(providerMethodInfo.getMethodParams()));
            this.mMethodCache.put(str, declaredMethod);
            return declaredMethod;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public com.oplus.epona.provider.ProviderMethodInfo getMethodInfo(java.lang.String str) {
        return this.mMethods.get(str);
    }

    private java.lang.Class<?>[] params(java.lang.String[] strArr) throws java.lang.ClassNotFoundException {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        java.lang.Class<?>[] clsArr = new java.lang.Class[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            clsArr[i_renamed] = java.lang.Class.forName(strArr[i_renamed]);
        }
        return clsArr;
    }
}
