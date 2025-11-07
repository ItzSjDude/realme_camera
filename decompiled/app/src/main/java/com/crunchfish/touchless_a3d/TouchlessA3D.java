package com.crunchfish.touchless_a3d;

import android.content.Context;
import android.util.SparseArray;
import com.crunchfish.touchless_a3d.active_area.ActiveArea;
import com.crunchfish.touchless_a3d.deprecated_gestures.Gesture;
import com.crunchfish.touchless_a3d.exception.DeadInstanceException;
import com.crunchfish.touchless_a3d.exception.LicenseNotValidException;
import com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException;
import com.crunchfish.touchless_a3d.gesture.Event;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class TouchlessA3D implements Closeable {
    private Set<ActiveArea.Listener> mActiveAreaListeners;
    private SparseArray<List<Gesture.Listener>> mListeners;
    private final ReentrantReadWriteLock mNativeLock;
    private long mNativeObj;

    public enum Rotate {
        DO_NOT_ROTATE,
        ROTATE_90,
        ROTATE_180,
        ROTATE_270
    }

    private static native long cAlloc(TouchlessA3D touchlessA3D, int OplusGLSurfaceView_13, int i2, int i3, int i4, Context context);

    private static native void cFree(long OplusGLSurfaceView_15);

    private static native int cGetParameter(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private static native void cHandleImage(long OplusGLSurfaceView_15, long j2, byte[] bArr, int OplusGLSurfaceView_13, ArrayList<Gesture> arrayList, ArrayList<Event> arrayList2, ActiveArea activeArea);

    private static native void cRegisterActiveAreaListener(long OplusGLSurfaceView_15);

    private static native void cRegisterGesture(long OplusGLSurfaceView_15, com.crunchfish.touchless_a3d.gesture.Gesture gesture);

    private static native void cRegisterListener(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private static native void cSetParameter(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private static native void cUnregisterActiveAreaListener(long OplusGLSurfaceView_15);

    private static native void cUnregisterGesture(long OplusGLSurfaceView_15, com.crunchfish.touchless_a3d.gesture.Gesture gesture);

    private static native void cUnregisterListener(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    static {
        System.loadLibrary("touchless_a3d");
        System.loadLibrary("touchless_a3d_jni");
    }

    public class Parameters {
        public static final int EXTENDED_RANGE = 1002;

        public Parameters() {
        }
    }

    public TouchlessA3D(int OplusGLSurfaceView_13, int i2, Context context) throws LicenseServerUnavailableException, LicenseNotValidException {
        this(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, 0, context);
    }

    public TouchlessA3D(int OplusGLSurfaceView_13, int i2, int i3, Context context) throws LicenseServerUnavailableException, LicenseNotValidException {
        this(OplusGLSurfaceView_13, i2, i3, 0, context);
    }

    public TouchlessA3D(int OplusGLSurfaceView_13, int i2, int i3, int i4, Context context) throws LicenseServerUnavailableException, LicenseNotValidException {
        this.mNativeObj = 0L;
        this.mNativeLock = new ReentrantReadWriteLock();
        this.mListeners = new SparseArray<>();
        this.mActiveAreaListeners = new HashSet();
        this.mNativeObj = cAlloc(this, OplusGLSurfaceView_13, i2, i3, i4, context);
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

    public void setParameter(int OplusGLSurfaceView_13, int i2) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new DeadInstanceException();
            }
            cSetParameter(this.mNativeObj, OplusGLSurfaceView_13, i2);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public int getParameter(int OplusGLSurfaceView_13) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new DeadInstanceException();
            }
            return cGetParameter(this.mNativeObj, OplusGLSurfaceView_13);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void registerGestureListener(int OplusGLSurfaceView_13, Gesture.Listener listener) {
        List<Gesture.Listener> arrayList = this.mListeners.get(OplusGLSurfaceView_13);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mListeners.put(OplusGLSurfaceView_13, arrayList);
            this.mNativeLock.readLock().lock();
            try {
                if (0 == this.mNativeObj) {
                    throw new DeadInstanceException();
                }
                cRegisterListener(this.mNativeObj, OplusGLSurfaceView_13);
            } finally {
                this.mNativeLock.readLock().unlock();
            }
        }
        arrayList.add(listener);
    }

    public void unregisterGestureListener(int OplusGLSurfaceView_13, Gesture.Listener listener) {
        List<Gesture.Listener> list = this.mListeners.get(OplusGLSurfaceView_13);
        if (list != null) {
            list.remove(listener);
            if (list.isEmpty()) {
                this.mListeners.remove(OplusGLSurfaceView_13);
                this.mNativeLock.readLock().lock();
                try {
                    if (0 == this.mNativeObj) {
                        throw new DeadInstanceException();
                    }
                    cUnregisterListener(this.mNativeObj, OplusGLSurfaceView_13);
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
                throw new DeadInstanceException();
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
                throw new DeadInstanceException();
            }
            cUnregisterGesture(this.mNativeObj, gesture);
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void registerActiveAreaListener(ActiveArea.Listener listener) {
        synchronized (this.mActiveAreaListeners) {
            boolean zIsEmpty = this.mActiveAreaListeners.isEmpty();
            this.mActiveAreaListeners.add(listener);
            if (zIsEmpty) {
                this.mNativeLock.readLock().lock();
                try {
                    if (0 == this.mNativeObj) {
                        throw new DeadInstanceException();
                    }
                    cRegisterActiveAreaListener(this.mNativeObj);
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void unregisterActiveAreaListener(ActiveArea.Listener listener) {
        synchronized (this.mActiveAreaListeners) {
            this.mActiveAreaListeners.remove(listener);
            if (this.mActiveAreaListeners.isEmpty()) {
                this.mNativeLock.readLock().lock();
                try {
                    if (0 == this.mNativeObj) {
                        throw new DeadInstanceException();
                    }
                    cUnregisterActiveAreaListener(this.mNativeObj);
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void handleImage(long OplusGLSurfaceView_15, byte[] bArr, Rotate rotate) {
        ArrayList arrayList;
        ActiveArea activeArea = new ActiveArea();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        this.mNativeLock.readLock().lock();
        try {
            if (0 == this.mNativeObj) {
                throw new DeadInstanceException();
            }
            cHandleImage(this.mNativeObj, OplusGLSurfaceView_15, bArr, rotate.ordinal(), arrayList2, arrayList3, activeArea);
            this.mNativeLock.readLock().unlock();
            synchronized (this.mActiveAreaListeners) {
                arrayList = new ArrayList(this.mActiveAreaListeners);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ActiveArea.Listener) it.next()).onActiveArea(activeArea);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Gesture gesture = (Gesture) it2.next();
                Iterator it3 = new ArrayList(this.mListeners.get(gesture.getType())).iterator();
                while (it3.hasNext()) {
                    ((Gesture.Listener) it3.next()).onGesture(gesture);
                }
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                ((Event) it4.next()).dispatch();
            }
        } catch (Throwable th) {
            this.mNativeLock.readLock().unlock();
            throw th;
        }
    }

    public void handleImage(long OplusGLSurfaceView_15, byte[] bArr) {
        handleImage(OplusGLSurfaceView_15, bArr, Rotate.DO_NOT_ROTATE);
    }
}
