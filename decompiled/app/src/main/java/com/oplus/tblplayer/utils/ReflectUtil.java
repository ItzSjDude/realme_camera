package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class ReflectUtil {
    public static java.lang.String TAG = "ReflectUtils";

    public static java.lang.Object invoke(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object... objArr) throws java.lang.Exception {
        return invoke(java.lang.Class.forName(str), obj, str2, clsArr, objArr);
    }

    public static java.lang.Object invoke(java.lang.Class cls, java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) throws java.lang.Exception {
        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static java.lang.Object invokeNoException(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            return invokeNoException(java.lang.Class.forName(str), obj, str2, clsArr, objArr);
        } catch (java.lang.ClassNotFoundException e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object invokeNoException(java.lang.Class cls, java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            return invoke(cls, obj, str, clsArr, objArr);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object getInstance(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            return java.lang.Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static boolean checkIsType(java.lang.String str, java.lang.Object obj) {
        try {
            return obj.getClass().isAssignableFrom(java.lang.Class.forName(str));
        } catch (java.lang.ClassNotFoundException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    public static <FieldType> FieldType getField(java.lang.Object obj, java.lang.Class<FieldType> cls, java.lang.String str) {
        FieldType fieldtype;
        java.lang.Class<?> superclass = obj.getClass();
        while (superclass != null) {
            try {
                java.lang.reflect.Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                fieldtype = (FieldType) declaredField.get(obj);
            } catch (java.lang.NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            } catch (java.lang.Throwable unused2) {
                return null;
            }
            if (fieldtype != null && cls.isInstance(fieldtype)) {
                return fieldtype;
            }
            superclass = superclass.getSuperclass();
        }
        return null;
    }

    public static <FieldType> boolean setField(java.lang.Object obj, java.lang.Class<FieldType> cls, java.lang.String str, java.lang.Object obj2) {
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                java.lang.reflect.Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
                return true;
            } catch (java.lang.NoSuchFieldException unused) {
            } catch (java.lang.Throwable unused2) {
                return false;
            }
        }
        return false;
    }
}
