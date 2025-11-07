package com.oplus.tblplayer.utils;

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

    public static java.lang.Object invokeRemoteMethod(android.os.IBinder iBinder, java.lang.String str, int i_renamed, java.lang.Object... objArr) throws android.os.RemoteException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        parcelObtain.writeInterfaceToken(str);
        writeInParcel(parcelObtain, objArr);
        try {
            iBinder.transact(i_renamed, parcelObtain, parcelObtain2, 0);
            readException(parcelObtain2);
            return readParcel(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public static void invokeVoidRemoteMethod(android.os.IBinder iBinder, int i_renamed, java.lang.Object[] objArr) throws android.os.RemoteException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        writeInParcel(parcelObtain, objArr);
        try {
            iBinder.transact(i_renamed, parcelObtain, null, 0);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static void writeInParcel(android.os.Parcel parcel, java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(objArr.length);
        for (java.lang.Object obj : objArr) {
            writeObject(parcel, obj);
        }
    }

    public static void writeObject(android.os.Parcel parcel, java.lang.Object obj) {
        if (obj == null) {
            parcel.writeInt(1);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            parcel.writeInt(2);
            parcel.writeInt(((java.lang.Boolean) obj).booleanValue() ? 1 : 0);
            return;
        }
        if (obj instanceof java.lang.Byte) {
            parcel.writeInt(3);
            parcel.writeByte(((java.lang.Byte) obj).byteValue());
            return;
        }
        if (obj instanceof java.lang.Integer) {
            parcel.writeInt(4);
            parcel.writeInt(((java.lang.Integer) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Long) {
            parcel.writeInt(5);
            parcel.writeLong(((java.lang.Long) obj).longValue());
            return;
        }
        if (obj instanceof java.lang.Float) {
            parcel.writeInt(6);
            parcel.writeFloat(((java.lang.Float) obj).floatValue());
            return;
        }
        if (obj instanceof java.lang.Double) {
            parcel.writeInt(7);
            parcel.writeDouble(((java.lang.Double) obj).doubleValue());
            return;
        }
        if (obj instanceof java.lang.String) {
            parcel.writeInt(8);
            parcel.writeString((java.lang.String) obj);
            return;
        }
        if (obj instanceof android.os.IBinder) {
            parcel.writeInt(9);
            parcel.writeStrongBinder((android.os.IBinder) obj);
            return;
        }
        if (obj instanceof android.os.IInterface) {
            parcel.writeInt(9);
            parcel.writeStrongBinder(((android.os.IInterface) obj).asBinder());
            return;
        }
        if (obj instanceof android.os.Parcelable) {
            parcel.writeInt(10);
            parcel.writeParcelable((android.os.Parcelable) obj, 0);
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
        if (obj instanceof java.lang.String[]) {
            parcel.writeInt(1073741832);
            parcel.writeStringArray((java.lang.String[]) obj);
            return;
        }
        if (obj instanceof android.os.IBinder[]) {
            parcel.writeInt(1073741833);
            parcel.writeBinderArray((android.os.IBinder[]) obj);
            return;
        }
        if (obj instanceof android.os.Parcelable[]) {
            parcel.writeInt(1073741834);
            parcel.writeString(obj.getClass().getComponentType().getName());
            parcel.writeParcelableArray((android.os.Parcelable[]) obj, 0);
            return;
        }
        if (obj.getClass().isArray() && android.os.Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            parcel.writeInt(1073741834);
            parcel.writeString(obj.getClass().getComponentType().getName());
            parcel.writeParcelableArray((android.os.Parcelable[]) obj, 0);
            return;
        }
        if (obj instanceof java.lang.Object[]) {
            parcel.writeInt(14);
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            parcel.writeInt(objArr.length);
            for (java.lang.Object obj2 : objArr) {
                writeObject(parcel, obj2);
            }
            return;
        }
        if (obj instanceof java.util.List) {
            parcel.writeInt(16);
            java.util.List list = (java.util.List) obj;
            parcel.writeInt(list.size());
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                writeObject(parcel, it.next());
            }
            return;
        }
        if (obj instanceof java.io.IOException) {
            parcel.writeInt(15);
            com.oplus.tblplayer.exception.IPCException.toIPCException((java.io.IOException) obj).writeToParcel(parcel, 0);
        } else if (obj instanceof java.io.Serializable) {
            parcel.writeInt(13);
            parcel.writeSerializable((java.io.Serializable) obj);
        } else {
            throw new java.lang.IllegalArgumentException("Wrong arg." + obj.getClass());
        }
    }

    public static void writeNoException(android.os.Parcel parcel) {
        writeException(parcel, null);
    }

    public static void writeException(android.os.Parcel parcel, java.lang.Exception exc) {
        if (exc == null) {
            parcel.writeInt(0);
            parcel.writeNoException();
        } else if (exc instanceof com.oplus.tblplayer.exception.IPCException) {
            parcel.writeInt(EX_IPC);
            ((com.oplus.tblplayer.exception.IPCException) exc).writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
            parcel.writeException(exc);
        }
    }

    public static void readException(android.os.Parcel parcel) {
        if (parcel.readInt() == EX_IPC) {
            throw new com.oplus.tblplayer.exception.IPCException(parcel);
        }
        parcel.readException();
    }

    public static void writeToReply(android.os.Parcel parcel, java.lang.Object obj) {
        parcel.writeNoException();
        writeObject(parcel, obj);
    }

    public static java.lang.Object[] readParcels(android.os.Parcel parcel) {
        int i_renamed = parcel.readInt();
        if (i_renamed == 0) {
            return new java.lang.Object[0];
        }
        java.lang.Object[] objArr = new java.lang.Object[i_renamed];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            objArr[i2] = readParcel(parcel);
        }
        return objArr;
    }

    public static java.lang.Object readParcel(android.os.Parcel parcel) {
        java.lang.Object objValueOf;
        int i_renamed = parcel.readInt();
        boolean z_renamed = (i_renamed & 1073741824) == 1073741824;
        switch (i_renamed & (-1073741825)) {
            case 1:
            case 11:
            case 12:
            default:
                return null;
            case 2:
                if (z_renamed) {
                    objValueOf = parcel.createBooleanArray();
                    break;
                } else {
                    objValueOf = java.lang.Boolean.valueOf(parcel.readInt() != 0);
                    break;
                }
            case 3:
                if (z_renamed) {
                    objValueOf = parcel.createByteArray();
                    break;
                } else {
                    objValueOf = java.lang.Byte.valueOf(parcel.readByte());
                    break;
                }
            case 4:
                if (z_renamed) {
                    objValueOf = parcel.createIntArray();
                    break;
                } else {
                    objValueOf = java.lang.Integer.valueOf(parcel.readInt());
                    break;
                }
            case 5:
                if (z_renamed) {
                    objValueOf = parcel.createLongArray();
                    break;
                } else {
                    objValueOf = java.lang.Long.valueOf(parcel.readLong());
                    break;
                }
            case 6:
                if (z_renamed) {
                    objValueOf = parcel.createFloatArray();
                    break;
                } else {
                    objValueOf = java.lang.Float.valueOf(parcel.readFloat());
                    break;
                }
            case 7:
                if (z_renamed) {
                    objValueOf = parcel.createDoubleArray();
                    break;
                } else {
                    objValueOf = java.lang.Double.valueOf(parcel.readDouble());
                    break;
                }
            case 8:
                if (z_renamed) {
                    objValueOf = parcel.createStringArray();
                    break;
                } else {
                    objValueOf = parcel.readString();
                    break;
                }
            case 9:
                if (z_renamed) {
                    objValueOf = parcel.createBinderArray();
                    break;
                } else {
                    objValueOf = parcel.readStrongBinder();
                    break;
                }
            case 10:
                java.lang.ClassLoader classLoader = com.oplus.tblplayer.utils.ParcelUtils.class.getClassLoader();
                if (z_renamed) {
                    java.lang.String string = parcel.readString();
                    android.os.Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
                    if (string.equals(android.os.Parcelable.class.getName())) {
                        return null;
                    }
                    int length = parcelableArray.length;
                    try {
                        android.os.Parcelable[] parcelableArr = (android.os.Parcelable[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName(string), length);
                        java.lang.System.arraycopy(parcelableArray, 0, parcelableArr, 0, length);
                        return parcelableArr;
                    } catch (java.lang.Exception e_renamed) {
                        throw new java.lang.RuntimeException(e_renamed);
                    }
                }
                return parcel.readParcelable(com.oplus.tblplayer.utils.ParcelUtils.class.getClassLoader());
            case 13:
                return parcel.readSerializable();
            case 14:
                return readParcels(parcel);
            case 15:
                com.oplus.tblplayer.exception.IPCException iPCException = new com.oplus.tblplayer.exception.IPCException(parcel);
                com.oplus.tblplayer.exception.IPCException iPCException2 = (com.oplus.tblplayer.exception.IPCException) iPCException.getCause();
                if (iPCException2 != null) {
                    return iPCException2.toIOException();
                }
                return iPCException.toIOException();
            case 16:
                int i2 = parcel.readInt();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i3 = 0; i3 < i2; i3++) {
                    java.lang.Object parcel2 = readParcel(parcel);
                    if (parcel2 != null) {
                        arrayList.add(parcel2);
                    }
                }
                return arrayList;
        }
        return objValueOf;
    }
}
