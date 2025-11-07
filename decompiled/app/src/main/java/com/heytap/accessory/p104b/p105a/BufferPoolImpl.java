package com.heytap.accessory.p104b.p105a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import java.util.LinkedList;
import java.util.TreeMap;

/* compiled from: BufferPoolImpl.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class BufferPoolImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9475a = "COUIBaseListPopupWindow_8";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final TreeMap<Integer, Object> f9476b = new TreeMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final SparseArray<PlatformImplementations.kt_3> f9477c = new SparseArray<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Object f9478d = new Object();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f9479e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static int f9480f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static int f9481g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static int f9482h;

    /* renamed from: OplusGLSurfaceView_13 */
    private static int f9483i;

    /* renamed from: OplusGLSurfaceView_15 */
    private static boolean f9484j;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8548a(Context context) {
        m8549a(BufferPoolConfig.m8544a(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B:10:0x0014, B:12:0x001f, B:14:0x0027, B:16:0x0030, B:25:0x004b, B:27:0x005d, B:30:0x0064, B:31:0x0067, B:32:0x006c, B:34:0x0073, B:36:0x007c, B:37:0x009c, B:35:0x0079, B:15:0x002c, B:17:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x0047, B:39:0x009e, B:40:0x00c2), top: B:46:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073 A[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B:10:0x0014, B:12:0x001f, B:14:0x0027, B:16:0x0030, B:25:0x004b, B:27:0x005d, B:30:0x0064, B:31:0x0067, B:32:0x006c, B:34:0x0073, B:36:0x007c, B:37:0x009c, B:35:0x0079, B:15:0x002c, B:17:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x0047, B:39:0x009e, B:40:0x00c2), top: B:46:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079 A[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B:10:0x0014, B:12:0x001f, B:14:0x0027, B:16:0x0030, B:25:0x004b, B:27:0x005d, B:30:0x0064, B:31:0x0067, B:32:0x006c, B:34:0x0073, B:36:0x007c, B:37:0x009c, B:35:0x0079, B:15:0x002c, B:17:0x0033, B:19:0x0037, B:21:0x003d, B:23:0x0047, B:39:0x009e, B:40:0x00c2), top: B:46:0x0014 }] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m8549a(com.heytap.accessory.p104b.p105a.BufferPoolConfig r5) {
        /*
            boolean r0 = m8550a()
            if (r0 == 0) goto Le
            java.lang.String r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9475a
            java.lang.String r0 = "BufferPool already initialised!"
            android.util.Log.w(r5, r0)
            return
        Le:
            if (r5 == 0) goto Lc6
            java.lang.Object r0 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9478d
            monitor-enter(r0)
            r1 = 0
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9483i = r1     // Catch: java.lang.Throwable -> Lc3
            boolean r1 = r5.f9474d     // Catch: java.lang.Throwable -> Lc3
            r2 = 24
            r3 = 66560(0x10400, float:9.327E-41)
            if (r1 == 0) goto L33
            android.content.Context r5 = r5.f9471a     // Catch: java.lang.Throwable -> Lc3
            boolean r5 = m8554b(r5)     // Catch: java.lang.Throwable -> Lc3
            if (r5 == 0) goto L2c
            r5 = 2097152(0x200000, float:2.938736E-39)
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9479e = r5     // Catch: java.lang.Throwable -> Lc3
            goto L30
        L2c:
            r5 = 4194304(0x400000, float:5.877472E-39)
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9479e = r5     // Catch: java.lang.Throwable -> Lc3
        L30:
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f = r3     // Catch: java.lang.Throwable -> Lc3
            goto L4a
        L33:
            int r1 = r5.f9473c     // Catch: java.lang.Throwable -> Lc3
            if (r1 < r2) goto L9e
            int r1 = r5.f9472b     // Catch: java.lang.Throwable -> Lc3
            int r4 = r5.f9473c     // Catch: java.lang.Throwable -> Lc3
            if (r1 < r4) goto L9e
            int r1 = r5.f9472b     // Catch: java.lang.Throwable -> Lc3
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9479e = r1     // Catch: java.lang.Throwable -> Lc3
            int r5 = r5.f9473c     // Catch: java.lang.Throwable -> Lc3
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f = r5     // Catch: java.lang.Throwable -> Lc3
            if (r5 > r3) goto L4a
            int r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f     // Catch: java.lang.Throwable -> Lc3
            goto L4b
        L4a:
            r5 = r3
        L4b:
            int r1 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9479e     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1 / 4
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9481g = r1     // Catch: java.lang.Throwable -> Lc3
            int r1 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9479e     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1 / 2
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9482h = r1     // Catch: java.lang.Throwable -> Lc3
            r1 = 36
            r4 = r1
            r1 = r2
        L5b:
            if (r1 > r5) goto L6c
            m8561f(r1)     // Catch: java.lang.Throwable -> Lc3
            if (r1 == r2) goto L67
            if (r4 > r5) goto L67
            m8561f(r4)     // Catch: java.lang.Throwable -> Lc3
        L67:
            int r1 = r1 * 2
            int r4 = r4 * 2
            goto L5b
        L6c:
            m8560e()     // Catch: java.lang.Throwable -> Lc3
            int r1 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f     // Catch: java.lang.Throwable -> Lc3
            if (r1 <= r3) goto L79
            int r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f     // Catch: java.lang.Throwable -> Lc3
            m8561f(r5)     // Catch: java.lang.Throwable -> Lc3
            goto L7c
        L79:
            m8561f(r5)     // Catch: java.lang.Throwable -> Lc3
        L7c:
            r5 = 1
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9484j = r5     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9475a     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "BufferPool[v1.0.2] initialised with capacity "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc3
            int r2 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9479e     // Catch: java.lang.Throwable -> Lc3
            r3 = 1048576(0x100000, float:1.469368E-39)
            int r2 = r2 / r3
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "MB"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            android.util.Log.OplusGLSurfaceView_13(r5, r1)     // Catch: java.lang.Throwable -> Lc3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc3
            return
        L9e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "Failed to initialise the Bufferpool! [Cache size="
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            int r3 = r5.f9472b     // Catch: java.lang.Throwable -> Lc3
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "; Max chunk size="
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            int r5 = r5.f9473c     // Catch: java.lang.Throwable -> Lc3
            r2.append(r5)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "]"
            r2.append(r5)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> Lc3
            r1.<init>(r5)     // Catch: java.lang.Throwable -> Lc3
            throw r1     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc3
            throw r5
        Lc6:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "Failed to initialise the Bufferpool!"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.p104b.p105a.BufferPoolImpl.m8549a(com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m8550a() {
        boolean z;
        synchronized (f9478d) {
            z = f9484j;
        }
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Buffer m8545a(int OplusGLSurfaceView_13) {
        if (!m8550a()) {
            throw new RuntimeException("Bufferpool not initialised!");
        }
        return m8547a(OplusGLSurfaceView_13, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Buffer m8552b(int OplusGLSurfaceView_13) {
        if (!m8550a()) {
            throw new RuntimeException("Bufferpool not initialised!");
        }
        return m8547a(OplusGLSurfaceView_13, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa A[PHI: r2
      0x00aa: PHI (r2v1 com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3) = (r2v0 com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3), (r2v2 com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3) binds: [B:11:0x0034, B:35:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.heytap.accessory.p104b.p105a.Buffer m8547a(int r6, boolean r7) {
        /*
            java.lang.Object r0 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9478d
            monitor-enter(r0)
            int r1 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f     // Catch: java.lang.Throwable -> Lad
            if (r6 <= r1) goto L28
            java.lang.String r7 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9475a     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "Buffer '"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lad
            r1.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "' is not matching with the pool sizes! creating new..."
            r1.append(r2)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad
            android.util.Log.w(r7, r1)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 r7 = new com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3     // Catch: java.lang.Throwable -> Lad
            byte[] r1 = new byte[r6]     // Catch: java.lang.Throwable -> Lad
            r7.<init>(r1, r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        L28:
            if (r7 == 0) goto L2c
            r1 = r6
            goto L30
        L2c:
            int r1 = m8558d(r6)     // Catch: java.lang.Throwable -> Lad
        L30:
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 r2 = m8546a(r1, r6, r7)     // Catch: java.lang.Throwable -> Lad
            if (r2 != 0) goto Laa
            r3 = 1
            r4 = r1
        L38:
            if (r2 != 0) goto L86
            r5 = 3
            if (r3 > r5) goto L86
            if (r7 == 0) goto L5c
            int r5 = m8558d(r6)     // Catch: java.lang.Throwable -> Lad
            if (r6 != r5) goto L46
            goto L5c
        L46:
            java.util.TreeMap<java.lang.Integer, java.lang.Object> r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9476b     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.Object r4 = r5.lowerKey(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lad
            if (r4 != 0) goto L57
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L72
        L57:
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lad
            goto L72
        L5c:
            java.util.TreeMap<java.lang.Integer, java.lang.Object> r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9476b     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.Object r4 = r5.higherKey(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lad
            if (r4 != 0) goto L6e
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L72
        L6e:
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lad
        L72:
            r5 = 24
            if (r4 < r5) goto L86
            r5 = 66560(0x10400, float:9.327E-41)
            if (r4 > r5) goto L86
            int r5 = com.heytap.accessory.p104b.p105a.BufferPoolImpl.f9480f     // Catch: java.lang.Throwable -> Lad
            if (r4 > r5) goto L86
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 r2 = m8546a(r4, r6, r7)     // Catch: java.lang.Throwable -> Lad
            int r3 = r3 + 1
            goto L38
        L86:
            if (r2 != 0) goto Laa
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 r7 = new com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3     // Catch: java.lang.Throwable -> Lad
            byte[] r2 = new byte[r1]     // Catch: java.lang.Throwable -> Lad
            r7.<init>(r2, r6)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r6 = m8559e(r1)     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto L99
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.PlatformImplementations.kt_3.m8562a(r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        L99:
            m8561f(r1)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r6 = m8559e(r1)     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto Lab
            com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r6 = m8559e(r1)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.p104b.p105a.BufferPoolImpl.PlatformImplementations.kt_3.m8562a(r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        Laa:
            r7 = r2
        Lab:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lad
            return r7
        Lad:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lad
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.p104b.p105a.BufferPoolImpl.m8547a(int, boolean):com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Buffer m8546a(int OplusGLSurfaceView_13, int i2, boolean z) {
        byte[] bArrRemoveLast;
        synchronized (f9478d) {
            PlatformImplementations.kt_3 aVarM8559e = m8559e(OplusGLSurfaceView_13);
            Buffer c2153a = null;
            if (aVarM8559e == null) {
                return null;
            }
            LinkedList<byte[]> linkedListM8565b = aVarM8559e.m8565b();
            if (linkedListM8565b == null || linkedListM8565b.isEmpty()) {
                return null;
            }
            if (z) {
                if (OplusGLSurfaceView_13 == i2) {
                    if (linkedListM8565b.getLast().length == i2) {
                        bArrRemoveLast = linkedListM8565b.removeLast();
                    }
                } else if (linkedListM8565b.getFirst().length == i2) {
                    bArrRemoveLast = linkedListM8565b.removeFirst();
                }
                bArrRemoveLast = null;
            } else {
                bArrRemoveLast = linkedListM8565b.removeLast();
            }
            if (bArrRemoveLast != null) {
                f9483i -= bArrRemoveLast.length;
                PlatformImplementations.kt_3.m8562a(aVarM8559e);
                c2153a = new Buffer(bArrRemoveLast, i2);
            }
            return c2153a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m8551a(byte[] bArr) {
        if (!m8550a()) {
            Log.w(f9475a, "Failed to recycle buffer - Bufferpool not initialised!");
            return false;
        }
        if (bArr == null) {
            Log.w(f9475a, "Cannot recycle null buffer!");
            return false;
        }
        int length = bArr.length;
        synchronized (f9478d) {
            if (length > f9480f) {
                Log.w(f9475a, "Cannot recycle buffer '" + length + "', Non-matcing size!");
                return false;
            }
            Integer numFloorKey = f9476b.floorKey(Integer.valueOf(length));
            int iIntValue = numFloorKey == null ? length : numFloorKey.intValue();
            synchronized (f9478d) {
                PlatformImplementations.kt_3 aVarM8559e = m8559e(iIntValue);
                if (aVarM8559e == null) {
                    return false;
                }
                LinkedList<byte[]> linkedListM8564a = aVarM8559e.m8564a();
                if (!aVarM8559e.m8568e()) {
                    return false;
                }
                if (f9483i + length > f9479e) {
                    int iM8567d = ((int) aVarM8559e.m8567d()) / iIntValue;
                    if (linkedListM8564a.size() >= iM8567d) {
                        Log.w(f9475a, "Cannot recycle buffer '" + iIntValue + "', Buffer chunk count(" + linkedListM8564a.size() + ") exceeded the limit" + iM8567d + "!");
                        return false;
                    }
                    m8557d();
                    if (f9483i + length > f9479e) {
                        Log.w(f9475a, "Cannot recycle buffer '" + iIntValue + "', Buffer cache limit exceeded!!!");
                        return false;
                    }
                }
                if (iIntValue == length) {
                    linkedListM8564a.addLast(bArr);
                } else {
                    linkedListM8564a.addFirst(bArr);
                }
                f9483i += length;
                return true;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m8556c(int OplusGLSurfaceView_13) {
        int i2;
        if (!m8550a()) {
            Log.w(f9475a, "Failed to clear cache - Bufferpool not initialised!");
            return false;
        }
        synchronized (f9478d) {
            try {
                if (OplusGLSurfaceView_13 == 5) {
                    i2 = f9481g;
                } else if (OplusGLSurfaceView_13 == 10) {
                    i2 = f9482h;
                } else {
                    if (OplusGLSurfaceView_13 != 15) {
                        if (OplusGLSurfaceView_13 != 40) {
                            if (OplusGLSurfaceView_13 != 60) {
                                if (OplusGLSurfaceView_13 != 80) {
                                    return false;
                                }
                            }
                            i2 = f9482h;
                        }
                        i2 = f9481g;
                    }
                    i2 = 0;
                }
                Log.v(f9475a, "ClearCache[" + OplusGLSurfaceView_13 + "] : Cache Size BEFORE = " + f9483i);
                if (f9483i <= i2) {
                    Log.w(f9475a, "ClearCache : Current cache size is lesser than the threshold of ".concat(String.valueOf(i2)));
                    return false;
                }
                int size = f9477c.size();
                for (int i3 = 0; i3 < size; i3++) {
                    LinkedList<byte[]> linkedListM8565b = f9477c.valueAt(i3).m8565b();
                    if (linkedListM8565b != null) {
                        while (!linkedListM8565b.isEmpty() && f9483i > i2) {
                            f9483i -= linkedListM8565b.removeLast().length;
                        }
                    }
                    if (f9483i <= i2) {
                        break;
                    }
                }
                Log.IntrinsicsJvm.kt_5(f9475a, "ClearCache : Cache Size AFTER = " + f9483i);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int m8557d() {
        int OplusGLSurfaceView_13;
        synchronized (f9478d) {
            int i2 = f9483i;
            int size = f9477c.size();
            for (int i3 = 0; i3 < size; i3++) {
                PlatformImplementations.kt_3 aVarValueAt = f9477c.valueAt(i3);
                if (aVarValueAt != null) {
                    int iM8567d = (int) (aVarValueAt.m8567d() / aVarValueAt.m8566c());
                    LinkedList<byte[]> linkedListM8565b = aVarValueAt.m8565b();
                    int size2 = linkedListM8565b == null ? 0 : linkedListM8565b.size();
                    while (size2 > iM8567d) {
                        if (linkedListM8565b != null) {
                            f9483i -= linkedListM8565b.removeLast().length;
                            size2--;
                        }
                    }
                }
            }
            Log.w(f9475a, "Pool Stabilized; Cache size reduced from  " + i2 + " -> " + f9483i);
            OplusGLSurfaceView_13 = i2 - f9483i;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int m8558d(int OplusGLSurfaceView_13) {
        Integer numCeilingKey = f9476b.ceilingKey(Integer.valueOf(OplusGLSurfaceView_13));
        return numCeilingKey == null ? OplusGLSurfaceView_13 : numCeilingKey.intValue();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static PlatformImplementations.kt_3 m8559e(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar;
        synchronized (f9478d) {
            aVar = f9477c.get(OplusGLSurfaceView_13);
        }
        return aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m8554b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            Log.w(f9475a, "isLowMemoryDevice(): ActivityManager is null!");
            return true;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return activityManager.getMemoryClass() < 128;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static void m8560e() {
        int[] iArr = {30731, 32779, 61451, 65541};
        synchronized (f9478d) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
                m8561f(iArr[OplusGLSurfaceView_13]);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static boolean m8561f(int OplusGLSurfaceView_13) {
        synchronized (f9478d) {
            byte b2 = 0;
            if (OplusGLSurfaceView_13 > f9480f || f9477c.indexOfKey(OplusGLSurfaceView_13) >= 0) {
                return false;
            }
            f9476b.put(Integer.valueOf(OplusGLSurfaceView_13), null);
            f9477c.put(OplusGLSurfaceView_13, new PlatformImplementations.kt_3(OplusGLSurfaceView_13, b2));
            return true;
        }
    }

    private BufferPoolImpl() {
    }

    /* compiled from: BufferPoolImpl.java */
    /* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static int f9485a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f9486b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private LinkedList<byte[]> f9487c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f9488d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f9489e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f9490f;

        /* synthetic */ PlatformImplementations.kt_3(int OplusGLSurfaceView_13, byte b2) {
            this(OplusGLSurfaceView_13);
        }

        private PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.f9486b = OplusGLSurfaceView_13;
            this.f9488d = 0;
            this.f9489e = 0;
            this.f9487c = null;
            this.f9490f = 1;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m8562a(PlatformImplementations.kt_3 aVar) {
            aVar.m8563f();
            f9485a++;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        final synchronized LinkedList<byte[]> m8564a() {
            if (this.f9487c == null) {
                this.f9487c = new LinkedList<>();
            }
            return this.f9487c;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        final synchronized LinkedList<byte[]> m8565b() {
            return this.f9487c;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        final synchronized int m8566c() {
            return this.f9486b;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        final float m8567d() {
            float COUIBaseListPopupWindow_12;
            synchronized (BufferPoolImpl.f9478d) {
                COUIBaseListPopupWindow_12 = BufferPoolImpl.f9479e * (this.f9488d / f9485a);
            }
            return COUIBaseListPopupWindow_12;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        private synchronized void m8563f() {
            this.f9488d++;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        final synchronized boolean m8568e() {
            float COUIBaseListPopupWindow_12;
            this.f9489e++;
            if (this.f9487c.size() == this.f9490f) {
                if (this.f9489e == 0.0f) {
                    COUIBaseListPopupWindow_12 = this.f9488d;
                } else {
                    COUIBaseListPopupWindow_12 = this.f9488d / this.f9489e;
                }
                if (COUIBaseListPopupWindow_12 < 0.9f) {
                    return false;
                }
                this.f9490f = ((this.f9490f * 3) / 2) + 1;
            }
            return true;
        }
    }
}
