package com.oplus.tblplayer.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ReflectUtil {
    public static String TAG = "ReflectUtils";

    public static Object invoke(String str, Object obj, String str2, Class[] clsArr, Object... objArr) throws Exception {
        return invoke(Class.forName(str), obj, str2, clsArr, objArr);
    }

    public static Object invoke(Class cls, Object obj, String str, Class[] clsArr, Object... objArr) throws Exception {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Object invokeNoException(String str, Object obj, String str2, Class[] clsArr, Object... objArr) {
        try {
            return invokeNoException(Class.forName(str), obj, str2, clsArr, objArr);
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Object invokeNoException(Class cls, Object obj, String str, Class[] clsArr, Object... objArr) {
        try {
            return invoke(cls, obj, str, clsArr, objArr);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Object getInstance(String str, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static boolean checkIsType(String str, Object obj) {
        try {
            return obj.getClass().isAssignableFrom(Class.forName(str));
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    public static <FieldType> FieldType getField(Object obj, Class<FieldType> cls, String str) {
        FieldType fieldtype;
        Class<?> superclass = obj.getClass();
        while (superclass != null) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                fieldtype = (FieldType) declaredField.get(obj);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            } catch (Throwable unused2) {
                return null;
            }
            if (fieldtype != null && cls.isInstance(fieldtype)) {
                return fieldtype;
            }
            superclass = superclass.getSuperclass();
        }
        return null;
    }

    public static <FieldType> boolean setField(Object obj, Class<FieldType> cls, String str, Object obj2) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
                return true;
            } catch (NoSuchFieldException unused) {
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }
}
