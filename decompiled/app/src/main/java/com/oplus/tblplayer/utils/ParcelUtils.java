package com.oplus.tblplayer.utils;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.oplus.tblplayer.exception.IPCException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class ParcelUtils {
    private static final int ARRAY_MASK = 1073741824;
    private static final int ARRAY_SHIFT = 30;
    private static final int EX_IPC = -83214;
    private static final int FLAG_ARRAY = 1073741824;
    private static final int TYPE_BINDER = 9;
    private static final int TYPE_BOOLEAN = 2;
    private static final int TYPE_BYTE = 3;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_FLOAT = 6;
    private static final int TYPE_INT = 4;
    private static final int TYPE_IO_EXCEPTION = 15;
    private static final int TYPE_LIST = 16;
    private static final int TYPE_LONG = 5;
    private static final int TYPE_NULL = 1;
    private static final int TYPE_OBJECTS = 14;
    private static final int TYPE_PARCEL = 10;
    private static final int TYPE_SERIAL = 13;
    private static final int TYPE_STRING = 8;

    public static Object invokeRemoteMethod(IBinder iBinder, String str, int OplusGLSurfaceView_13, Object... objArr) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken(str);
        writeInParcel(parcelObtain, objArr);
        try {
            iBinder.transact(OplusGLSurfaceView_13, parcelObtain, parcelObtain2, 0);
            readException(parcelObtain2);
            return readParcel(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public static void invokeVoidRemoteMethod(IBinder iBinder, int OplusGLSurfaceView_13, Object[] objArr) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        writeInParcel(parcelObtain, objArr);
        try {
            iBinder.transact(OplusGLSurfaceView_13, parcelObtain, null, 0);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static void writeInParcel(Parcel parcel, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(objArr.length);
        for (Object obj : objArr) {
            writeObject(parcel, obj);
        }
    }

    public static void writeObject(Parcel parcel, Object obj) {
        if (obj == null) {
            parcel.writeInt(1);
            return;
        }
        if (obj instanceof Boolean) {
            parcel.writeInt(2);
            parcel.writeInt(((Boolean) obj).booleanValue() ? 1 : 0);
            return;
        }
        if (obj instanceof Byte) {
            parcel.writeInt(3);
            parcel.writeByte(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Integer) {
            parcel.writeInt(4);
            parcel.writeInt(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            parcel.writeInt(5);
            parcel.writeLong(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            parcel.writeInt(6);
            parcel.writeFloat(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            parcel.writeInt(7);
            parcel.writeDouble(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            parcel.writeInt(8);
            parcel.writeString((String) obj);
            return;
        }
        if (obj instanceof IBinder) {
            parcel.writeInt(9);
            parcel.writeStrongBinder((IBinder) obj);
            return;
        }
        if (obj instanceof IInterface) {
            parcel.writeInt(9);
            parcel.writeStrongBinder(((IInterface) obj).asBinder());
            return;
        }
        if (obj instanceof Parcelable) {
            parcel.writeInt(10);
            parcel.writeParcelable((Parcelable) obj, 0);
            return;
        }
        if (obj instanceof boolean[]) {
            parcel.writeInt(1073741826);
            parcel.writeBooleanArray((boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            parcel.writeInt(1073741827);
            parcel.writeByteArray((byte[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            parcel.writeInt(1073741828);
            parcel.writeIntArray((int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            parcel.writeInt(1073741829);
            parcel.writeLongArray((long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            parcel.writeInt(1073741830);
            parcel.writeFloatArray((float[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            parcel.writeInt(1073741831);
            parcel.writeDoubleArray((double[]) obj);
            return;
        }
        if (obj instanceof String[]) {
            parcel.writeInt(1073741832);
            parcel.writeStringArray((String[]) obj);
            return;
        }
        if (obj instanceof IBinder[]) {
            parcel.writeInt(1073741833);
            parcel.writeBinderArray((IBinder[]) obj);
            return;
        }
        if (obj instanceof Parcelable[]) {
            parcel.writeInt(1073741834);
            parcel.writeString(obj.getClass().getComponentType().getName());
            parcel.writeParcelableArray((Parcelable[]) obj, 0);
            return;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            parcel.writeInt(1073741834);
            parcel.writeString(obj.getClass().getComponentType().getName());
            parcel.writeParcelableArray((Parcelable[]) obj, 0);
            return;
        }
        if (obj instanceof Object[]) {
            parcel.writeInt(14);
            Object[] objArr = (Object[]) obj;
            parcel.writeInt(objArr.length);
            for (Object obj2 : objArr) {
                writeObject(parcel, obj2);
            }
            return;
        }
        if (obj instanceof List) {
            parcel.writeInt(16);
            List list = (List) obj;
            parcel.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                writeObject(parcel, it.next());
            }
            return;
        }
        if (obj instanceof IOException) {
            parcel.writeInt(15);
            IPCException.toIPCException((IOException) obj).writeToParcel(parcel, 0);
        } else if (obj instanceof Serializable) {
            parcel.writeInt(13);
            parcel.writeSerializable((Serializable) obj);
        } else {
            throw new IllegalArgumentException("Wrong arg." + obj.getClass());
        }
    }

    public static void writeNoException(Parcel parcel) {
        writeException(parcel, null);
    }

    public static void writeException(Parcel parcel, Exception exc) {
        if (exc == null) {
            parcel.writeInt(0);
            parcel.writeNoException();
        } else if (exc instanceof IPCException) {
            parcel.writeInt(EX_IPC);
            ((IPCException) exc).writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
            parcel.writeException(exc);
        }
    }

    public static void readException(Parcel parcel) {
        if (parcel.readInt() == EX_IPC) {
            throw new IPCException(parcel);
        }
        parcel.readException();
    }

    public static void writeToReply(Parcel parcel, Object obj) {
        parcel.writeNoException();
        writeObject(parcel, obj);
    }

    public static Object[] readParcels(Parcel parcel) {
        int OplusGLSurfaceView_13 = parcel.readInt();
        if (OplusGLSurfaceView_13 == 0) {
            return new Object[0];
        }
        Object[] objArr = new Object[OplusGLSurfaceView_13];
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            objArr[i2] = readParcel(parcel);
        }
        return objArr;
    }

    public static Object readParcel(Parcel parcel) {
        Object objValueOf;
        int OplusGLSurfaceView_13 = parcel.readInt();
        boolean z = (OplusGLSurfaceView_13 & 1073741824) == 1073741824;
        switch (OplusGLSurfaceView_13 & (-1073741825)) {
            case 1:
            case 11:
            case 12:
            default:
                return null;
            case 2:
                if (z) {
                    objValueOf = parcel.createBooleanArray();
                    break;
                } else {
                    objValueOf = Boolean.valueOf(parcel.readInt() != 0);
                    break;
                }
            case 3:
                if (z) {
                    objValueOf = parcel.createByteArray();
                    break;
                } else {
                    objValueOf = Byte.valueOf(parcel.readByte());
                    break;
                }
            case 4:
                if (z) {
                    objValueOf = parcel.createIntArray();
                    break;
                } else {
                    objValueOf = Integer.valueOf(parcel.readInt());
                    break;
                }
            case 5:
                if (z) {
                    objValueOf = parcel.createLongArray();
                    break;
                } else {
                    objValueOf = Long.valueOf(parcel.readLong());
                    break;
                }
            case 6:
                if (z) {
                    objValueOf = parcel.createFloatArray();
                    break;
                } else {
                    objValueOf = Float.valueOf(parcel.readFloat());
                    break;
                }
            case 7:
                if (z) {
                    objValueOf = parcel.createDoubleArray();
                    break;
                } else {
                    objValueOf = Double.valueOf(parcel.readDouble());
                    break;
                }
            case 8:
                if (z) {
                    objValueOf = parcel.createStringArray();
                    break;
                } else {
                    objValueOf = parcel.readString();
                    break;
                }
            case 9:
                if (z) {
                    objValueOf = parcel.createBinderArray();
                    break;
                } else {
                    objValueOf = parcel.readStrongBinder();
                    break;
                }
            case 10:
                ClassLoader classLoader = ParcelUtils.class.getClassLoader();
                if (z) {
                    String string = parcel.readString();
                    Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
                    if (string.equals(Parcelable.class.getName())) {
                        return null;
                    }
                    int length = parcelableArray.length;
                    try {
                        Parcelable[] parcelableArr = (Parcelable[]) Array.newInstance(Class.forName(string), length);
                        System.arraycopy(parcelableArray, 0, parcelableArr, 0, length);
                        return parcelableArr;
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        throw new RuntimeException(COUIBaseListPopupWindow_8);
                    }
                }
                return parcel.readParcelable(ParcelUtils.class.getClassLoader());
            case 13:
                return parcel.readSerializable();
            case 14:
                return readParcels(parcel);
            case 15:
                IPCException iPCException = new IPCException(parcel);
                IPCException iPCException2 = (IPCException) iPCException.getCause();
                if (iPCException2 != null) {
                    return iPCException2.toIOException();
                }
                return iPCException.toIOException();
            case 16:
                int i2 = parcel.readInt();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < i2; i3++) {
                    Object parcel2 = readParcel(parcel);
                    if (parcel2 != null) {
                        arrayList.add(parcel2);
                    }
                }
                return arrayList;
        }
        return objValueOf;
    }
}
