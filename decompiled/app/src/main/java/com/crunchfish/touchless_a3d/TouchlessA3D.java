package com.crunchfish.touchless_a3d;

/* loaded from: classes.dex */
public class TouchlessA3D implements java.io.Closeable {
    private java.util.Set<com.crunchfish.touchless_a3d.active_area.ActiveArea.Listener> mActiveAreaListeners;
    private android.util.SparseArray<java.util.List<com.crunchfish.touchless_a3d.deprecated_gestures.Gesture.Listener>> mListeners;
    private final java.util.concurrent.locks.ReentrantReadWriteLock mNativeLock;
    private long mNativeObj;

    public enum Rotate {
        DO_NOT_ROTATE,
        ROTATE_90,
        ROTATE_180,
        ROTATE_270
    }

    private static native long cAlloc(com.crunchfish.touchless_a3d.TouchlessA3D touchlessA3D, int i_renamed, int i2, int i3, int i4, android.content.Context context);

    private static native void cFree(long j_renamed);

    private static native int cGetParameter(long j_renamed, int i_renamed);

    private static native void cHandleImage(long j_renamed, long j2, byte[] bArr, int i_renamed, java.util.ArrayList<com.crunchfish.touchless_a3d.deprecated_gestures.Gesture> arrayList, java.util.ArrayList<com.crunchfish.touchless_a3d.gesture.Event> arrayList2, com.crunchfish.touchless_a3d.active_area.ActiveArea activeArea);

    private static native void cRegisterActiveAreaListener(long j_renamed);

    private static native void cRegisterGesture(long j_renamed, com.crunchfish.touchless_a3d.gesture.Gesture gesture);

    private static native void cRegisterListener(long j_renamed, int i_renamed);

    private static native void cSetParameter(long j_renamed, int i_renamed, int i2);

    private static native void cUnregisterActiveAreaListener(long j_renamed);

    private static native void cUnregisterGesture(long j_renamed, com.crunchfish.touchless_a3d.gesture.Gesture gesture);

    private static native void cUnregisterListener(long j_renamed, int i_renamed);

    static {
        java.lang.System.loadLibrary("touchless_a3d");
        java.lang.System.loadLibrary("touchless_a3d_jni");
    }

    public class Parameters {
        public static final int EXTENDED_RANGE = 1002;

        public Parameters() {
        }
    }

    public TouchlessA3D(int i_renamed, int i2, android.content.Context context) throws com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException, com.crunchfish.touchless_a3d.exception.LicenseNotValidException {
        this(i_renamed, i2, i_renamed, 0, context);
    }

    public TouchlessA3D(int i_renamed, int i2, int i3, android.content.Context context) throws com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException, com.crunchfish.touchless_a3d.exception.LicenseNotValidException {
        this(i_renamed, i2, i3, 0, context);
    }

    public TouchlessA3D(int i_renamed, int i2, int i3, int i4, android.content.Context context) throws com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException, com.crunchfish.touchless_a3d.exception.LicenseNotValidException {
        this.mNativeObj = 0L;
        this.mNativeLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.mListeners = new android.util.SparseArray<>();
        this.mActiveAreaListeners = new java.util.HashSet();
        this.mNativeObj = cAlloc(this, i_renamed, i2, i3, i4, context);
    }

    private void freeNativeObject() {
        this.mNativeLock.writeLock().lock();
        try {
            if (0 != this.mNativeObj) {
                cFree(this.mNativeObj);
                this.mNativeObj = 0L;
            }
        } finally {
            this.mNativeLock.writeLock().unlock();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        freeNativeObject();
    }

    public void finalize() {
        freeNativeObject();
    }

    public void setParameter(int i_renamed, int i2) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
            }
            cSetParameter(this.mNativeObj, i_renamed, i2);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public int getParameter(int i_renamed) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
            }
            return cGetParameter(this.mNativeObj, i_renamed);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void registerGestureListener(int i_renamed, com.crunchfish.touchless_a3d.deprecated_gestures.Gesture.Listener listener) {
        java.util.List<com.crunchfish.touchless_a3d.deprecated_gestures.Gesture.Listener> arrayList = this.mListeners.get(i_renamed);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mListeners.put(i_renamed, arrayList);
            this.mNativeLock.readLock().lock();
            try {
                if (0 == this.mNativeObj) {
                    throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
                }
                cRegisterListener(this.mNativeObj, i_renamed);
            } finally {
                this.mNativeLock.readLock().unlock();
            }
        }
        arrayList.add(listener);
    }

    public void unregisterGestureListener(int i_renamed, com.crunchfish.touchless_a3d.deprecated_gestures.Gesture.Listener listener) {
        java.util.List<com.crunchfish.touchless_a3d.deprecated_gestures.Gesture.Listener> list = this.mListeners.get(i_renamed);
        if (list != null) {
            list.remove(listener);
            if (list.isEmpty()) {
                this.mListeners.remove(i_renamed);
                this.mNativeLock.readLock().lock();
                try {
                    if (0 == this.mNativeObj) {
                        throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
                    }
                    cUnregisterListener(this.mNativeObj, i_renamed);
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void registerGesture(com.crunchfish.touchless_a3d.gesture.Gesture gesture) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
            }
            cRegisterGesture(this.mNativeObj, gesture);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void unregisterGesture(com.crunchfish.touchless_a3d.gesture.Gesture gesture) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
            }
            cUnregisterGesture(this.mNativeObj, gesture);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void registerActiveAreaListener(com.crunchfish.touchless_a3d.active_area.ActiveArea.Listener listener) {
        synchronized (this.mActiveAreaListeners) {
            boolean zIsEmpty = this.mActiveAreaListeners.isEmpty();
            this.mActiveAreaListeners.add(listener);
            if (zIsEmpty) {
                this.mNativeLock.readLock().lock();
                try {
                    if (0 == this.mNativeObj) {
                        throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
                    }
                    cRegisterActiveAreaListener(this.mNativeObj);
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void unregisterActiveAreaListener(com.crunchfish.touchless_a3d.active_area.ActiveArea.Listener listener) {
        synchronized (this.mActiveAreaListeners) {
            this.mActiveAreaListeners.remove(listener);
            if (this.mActiveAreaListeners.isEmpty()) {
                this.mNativeLock.readLock().lock();
                try {
                    if (0 == this.mNativeObj) {
                        throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
                    }
                    cUnregisterActiveAreaListener(this.mNativeObj);
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void handleImage(long j_renamed, byte[] bArr, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate rotate) {
        java.util.ArrayList arrayList;
        com.crunchfish.touchless_a3d.active_area.ActiveArea activeArea = new com.crunchfish.touchless_a3d.active_area.ActiveArea();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new com.crunchfish.touchless_a3d.exception.DeadInstanceException();
            }
            cHandleImage(this.mNativeObj, j_renamed, bArr, rotate.ordinal(), arrayList2, arrayList3, activeArea);
            this.mNativeLock.readLock().unlock();
            synchronized (this.mActiveAreaListeners) {
                arrayList = new java.util.ArrayList(this.mActiveAreaListeners);
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.crunchfish.touchless_a3d.active_area.ActiveArea.Listener) it.next()).onActiveArea(activeArea);
            }
            java.util.Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                com.crunchfish.touchless_a3d.deprecated_gestures.Gesture gesture = (com.crunchfish.touchless_a3d.deprecated_gestures.Gesture) it2.next();
                java.util.Iterator it3 = new java.util.ArrayList(this.mListeners.get(gesture.getType())).iterator();
                while (it3.hasNext()) {
                    ((com.crunchfish.touchless_a3d.deprecated_gestures.Gesture.Listener) it3.next()).onGesture(gesture);
                }
            }
            java.util.Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                ((com.crunchfish.touchless_a3d.gesture.Event) it4.next()).dispatch();
            }
        } catch (java.lang.Throwable th) {
            this.mNativeLock.readLock().unlock();
            throw th;
        }
    }

    public void handleImage(long j_renamed, byte[] bArr) {
        handleImage(j_renamed, bArr, com.crunchfish.touchless_a3d.TouchlessA3D.Rotate.DO_NOT_ROTATE);
    }
}
