package com.heytap.accessory.b_renamed.a_renamed;

/* compiled from: BufferPoolImpl.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3260a = "e_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.TreeMap<java.lang.Integer, java.lang.Object> f3261b = new java.util.TreeMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.util.SparseArray<com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed> f3262c = new android.util.SparseArray<>();
    private static final java.lang.Object d_renamed = new java.lang.Object();
    private static int e_renamed;
    private static int f_renamed;
    private static int g_renamed;
    private static int h_renamed;
    private static int i_renamed;
    private static boolean j_renamed;

    public static void a_renamed(android.content.Context context) {
        a_renamed(com.heytap.accessory.b_renamed.a_renamed.d_renamed.a_renamed(context));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x005d A_renamed[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B_renamed:10:0x0014, B_renamed:12:0x001f, B_renamed:14:0x0027, B_renamed:16:0x0030, B_renamed:25:0x004b, B_renamed:27:0x005d, B_renamed:30:0x0064, B_renamed:31:0x0067, B_renamed:32:0x006c, B_renamed:34:0x0073, B_renamed:36:0x007c, B_renamed:37:0x009c, B_renamed:35:0x0079, B_renamed:15:0x002c, B_renamed:17:0x0033, B_renamed:19:0x0037, B_renamed:21:0x003d, B_renamed:23:0x0047, B_renamed:39:0x009e, B_renamed:40:0x00c2), top: B_renamed:46:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x0073 A_renamed[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B_renamed:10:0x0014, B_renamed:12:0x001f, B_renamed:14:0x0027, B_renamed:16:0x0030, B_renamed:25:0x004b, B_renamed:27:0x005d, B_renamed:30:0x0064, B_renamed:31:0x0067, B_renamed:32:0x006c, B_renamed:34:0x0073, B_renamed:36:0x007c, B_renamed:37:0x009c, B_renamed:35:0x0079, B_renamed:15:0x002c, B_renamed:17:0x0033, B_renamed:19:0x0037, B_renamed:21:0x003d, B_renamed:23:0x0047, B_renamed:39:0x009e, B_renamed:40:0x00c2), top: B_renamed:46:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0079 A_renamed[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B_renamed:10:0x0014, B_renamed:12:0x001f, B_renamed:14:0x0027, B_renamed:16:0x0030, B_renamed:25:0x004b, B_renamed:27:0x005d, B_renamed:30:0x0064, B_renamed:31:0x0067, B_renamed:32:0x006c, B_renamed:34:0x0073, B_renamed:36:0x007c, B_renamed:37:0x009c, B_renamed:35:0x0079, B_renamed:15:0x002c, B_renamed:17:0x0033, B_renamed:19:0x0037, B_renamed:21:0x003d, B_renamed:23:0x0047, B_renamed:39:0x009e, B_renamed:40:0x00c2), top: B_renamed:46:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a_renamed(com.heytap.accessory.b_renamed.a_renamed.d_renamed r5) {
        /*
            boolean r0 = a_renamed()
            if (r0 == 0) goto Le
            java.lang.String r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f3260a
            java.lang.String r0 = "BufferPool already initialised!"
            android.util.Log.w_renamed(r5, r0)
            return
        Le:
            if (r5 == 0) goto Lc6
            java.lang.Object r0 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.d_renamed
            monitor-enter(r0)
            r1 = 0
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.i_renamed = r1     // Catch: java.lang.Throwable -> Lc3
            boolean r1 = r5.d_renamed     // Catch: java.lang.Throwable -> Lc3
            r2 = 24
            r3 = 66560(0x10400, float:9.327E-41)
            if (r1 == 0) goto L33
            android.content.Context r5 = r5.f3257a     // Catch: java.lang.Throwable -> Lc3
            boolean r5 = b_renamed(r5)     // Catch: java.lang.Throwable -> Lc3
            if (r5 == 0) goto L2c
            r5 = 2097152(0x200000, float:2.938736E-39)
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed = r5     // Catch: java.lang.Throwable -> Lc3
            goto L30
        L2c:
            r5 = 4194304(0x400000, float:5.877472E-39)
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed = r5     // Catch: java.lang.Throwable -> Lc3
        L30:
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed = r3     // Catch: java.lang.Throwable -> Lc3
            goto L4a
        L33:
            int r1 = r5.f3259c     // Catch: java.lang.Throwable -> Lc3
            if (r1 < r2) goto L9e
            int r1 = r5.f3258b     // Catch: java.lang.Throwable -> Lc3
            int r4 = r5.f3259c     // Catch: java.lang.Throwable -> Lc3
            if (r1 < r4) goto L9e
            int r1 = r5.f3258b     // Catch: java.lang.Throwable -> Lc3
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed = r1     // Catch: java.lang.Throwable -> Lc3
            int r5 = r5.f3259c     // Catch: java.lang.Throwable -> Lc3
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed = r5     // Catch: java.lang.Throwable -> Lc3
            if (r5 > r3) goto L4a
            int r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed     // Catch: java.lang.Throwable -> Lc3
            goto L4b
        L4a:
            r5 = r3
        L4b:
            int r1 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1 / 4
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.g_renamed = r1     // Catch: java.lang.Throwable -> Lc3
            int r1 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1 / 2
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.h_renamed = r1     // Catch: java.lang.Throwable -> Lc3
            r1 = 36
            r4 = r1
            r1 = r2
        L5b:
            if (r1 > r5) goto L6c
            f_renamed(r1)     // Catch: java.lang.Throwable -> Lc3
            if (r1 == r2) goto L67
            if (r4 > r5) goto L67
            f_renamed(r4)     // Catch: java.lang.Throwable -> Lc3
        L67:
            int r1 = r1 * 2
            int r4 = r4 * 2
            goto L5b
        L6c:
            e_renamed()     // Catch: java.lang.Throwable -> Lc3
            int r1 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed     // Catch: java.lang.Throwable -> Lc3
            if (r1 <= r3) goto L79
            int r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed     // Catch: java.lang.Throwable -> Lc3
            f_renamed(r5)     // Catch: java.lang.Throwable -> Lc3
            goto L7c
        L79:
            f_renamed(r5)     // Catch: java.lang.Throwable -> Lc3
        L7c:
            r5 = 1
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.j_renamed = r5     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f3260a     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "BufferPool[v1.0.2] initialised with capacity "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc3
            int r2 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed     // Catch: java.lang.Throwable -> Lc3
            r3 = 1048576(0x100000, float:1.469368E-39)
            int r2 = r2 / r3
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "MB"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            android.util.Log.i_renamed(r5, r1)     // Catch: java.lang.Throwable -> Lc3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc3
            return
        L9e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "Failed to initialise the Bufferpool! [Cache size="
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            int r3 = r5.f3258b     // Catch: java.lang.Throwable -> Lc3
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "; Max chunk size="
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            int r5 = r5.f3259c     // Catch: java.lang.Throwable -> Lc3
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
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed(com.heytap.accessory.b_renamed.a_renamed.d_renamed):void");
    }

    public static boolean a_renamed() {
        boolean z_renamed;
        synchronized (d_renamed) {
            z_renamed = j_renamed;
        }
        return z_renamed;
    }

    public static com.heytap.accessory.b_renamed.a_renamed.a_renamed a_renamed(int i2) {
        if (!a_renamed()) {
            throw new java.lang.RuntimeException("Bufferpool not initialised!");
        }
        return a_renamed(i2, false);
    }

    public static com.heytap.accessory.b_renamed.a_renamed.a_renamed b_renamed(int i2) {
        if (!a_renamed()) {
            throw new java.lang.RuntimeException("Bufferpool not initialised!");
        }
        return a_renamed(i2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x00aa A_renamed[PHI: r2
      0x00aa: PHI (r2v1 com.heytap.accessory.b_renamed.a_renamed.a_renamed) = (r2v0 com.heytap.accessory.b_renamed.a_renamed.a_renamed), (r2v2 com.heytap.accessory.b_renamed.a_renamed.a_renamed) binds: [B_renamed:11:0x0034, B_renamed:35:0x0086] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.heytap.accessory.b_renamed.a_renamed.a_renamed a_renamed(int r6, boolean r7) {
        /*
            java.lang.Object r0 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.d_renamed
            monitor-enter(r0)
            int r1 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed     // Catch: java.lang.Throwable -> Lad
            if (r6 <= r1) goto L28
            java.lang.String r7 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f3260a     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "Buffer '"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lad
            r1.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "' is_renamed not matching with the pool sizes! creating new..."
            r1.append(r2)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad
            android.util.Log.w_renamed(r7, r1)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.b_renamed.a_renamed.a_renamed r7 = new com.heytap.accessory.b_renamed.a_renamed.a_renamed     // Catch: java.lang.Throwable -> Lad
            byte[] r1 = new byte[r6]     // Catch: java.lang.Throwable -> Lad
            r7.<init>(r1, r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        L28:
            if (r7 == 0) goto L2c
            r1 = r6
            goto L30
        L2c:
            int r1 = d_renamed(r6)     // Catch: java.lang.Throwable -> Lad
        L30:
            com.heytap.accessory.b_renamed.a_renamed.a_renamed r2 = a_renamed(r1, r6, r7)     // Catch: java.lang.Throwable -> Lad
            if (r2 != 0) goto Laa
            r3 = 1
            r4 = r1
        L38:
            if (r2 != 0) goto L86
            r5 = 3
            if (r3 > r5) goto L86
            if (r7 == 0) goto L5c
            int r5 = d_renamed(r6)     // Catch: java.lang.Throwable -> Lad
            if (r6 != r5) goto L46
            goto L5c
        L46:
            java.util.TreeMap<java.lang.Integer, java.lang.Object> r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f3261b     // Catch: java.lang.Throwable -> Lad
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
            java.util.TreeMap<java.lang.Integer, java.lang.Object> r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f3261b     // Catch: java.lang.Throwable -> Lad
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
            int r5 = com.heytap.accessory.b_renamed.a_renamed.e_renamed.f_renamed     // Catch: java.lang.Throwable -> Lad
            if (r4 > r5) goto L86
            com.heytap.accessory.b_renamed.a_renamed.a_renamed r2 = a_renamed(r4, r6, r7)     // Catch: java.lang.Throwable -> Lad
            int r3 = r3 + 1
            goto L38
        L86:
            if (r2 != 0) goto Laa
            com.heytap.accessory.b_renamed.a_renamed.a_renamed r7 = new com.heytap.accessory.b_renamed.a_renamed.a_renamed     // Catch: java.lang.Throwable -> Lad
            byte[] r2 = new byte[r1]     // Catch: java.lang.Throwable -> Lad
            r7.<init>(r2, r6)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.b_renamed.a_renamed.e_renamed$a_renamed r6 = e_renamed(r1)     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto L99
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed.a_renamed(r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        L99:
            f_renamed(r1)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.b_renamed.a_renamed.e_renamed$a_renamed r6 = e_renamed(r1)     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto Lab
            com.heytap.accessory.b_renamed.a_renamed.e_renamed$a_renamed r6 = e_renamed(r1)     // Catch: java.lang.Throwable -> Lad
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed.a_renamed(r6)     // Catch: java.lang.Throwable -> Lad
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
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed(int, boolean):com.heytap.accessory.b_renamed.a_renamed.a_renamed");
    }

    private static com.heytap.accessory.b_renamed.a_renamed.a_renamed a_renamed(int i2, int i3, boolean z_renamed) {
        byte[] bArrRemoveLast;
        synchronized (d_renamed) {
            com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed aVarE = e_renamed(i2);
            com.heytap.accessory.b_renamed.a_renamed.a_renamed aVar = null;
            if (aVarE == null) {
                return null;
            }
            java.util.LinkedList<byte[]> linkedListB = aVarE.b_renamed();
            if (linkedListB == null || linkedListB.isEmpty()) {
                return null;
            }
            if (z_renamed) {
                if (i2 == i3) {
                    if (linkedListB.getLast().length == i3) {
                        bArrRemoveLast = linkedListB.removeLast();
                    }
                } else if (linkedListB.getFirst().length == i3) {
                    bArrRemoveLast = linkedListB.removeFirst();
                }
                bArrRemoveLast = null;
            } else {
                bArrRemoveLast = linkedListB.removeLast();
            }
            if (bArrRemoveLast != null) {
                i_renamed -= bArrRemoveLast.length;
                com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed.a_renamed(aVarE);
                aVar = new com.heytap.accessory.b_renamed.a_renamed.a_renamed(bArrRemoveLast, i3);
            }
            return aVar;
        }
    }

    public static boolean a_renamed(byte[] bArr) {
        if (!a_renamed()) {
            android.util.Log.w_renamed(f3260a, "Failed to recycle buffer - Bufferpool not initialised!");
            return false;
        }
        if (bArr == null) {
            android.util.Log.w_renamed(f3260a, "Cannot recycle null buffer!");
            return false;
        }
        int length = bArr.length;
        synchronized (d_renamed) {
            if (length > f_renamed) {
                android.util.Log.w_renamed(f3260a, "Cannot recycle buffer '" + length + "', Non-matcing size!");
                return false;
            }
            java.lang.Integer numFloorKey = f3261b.floorKey(java.lang.Integer.valueOf(length));
            int iIntValue = numFloorKey == null ? length : numFloorKey.intValue();
            synchronized (d_renamed) {
                com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed aVarE = e_renamed(iIntValue);
                if (aVarE == null) {
                    return false;
                }
                java.util.LinkedList<byte[]> linkedListA = aVarE.a_renamed();
                if (!aVarE.e_renamed()) {
                    return false;
                }
                if (i_renamed + length > e_renamed) {
                    int iD = ((int) aVarE.d_renamed()) / iIntValue;
                    if (linkedListA.size() >= iD) {
                        android.util.Log.w_renamed(f3260a, "Cannot recycle buffer '" + iIntValue + "', Buffer chunk count(" + linkedListA.size() + ") exceeded the limit" + iD + "!");
                        return false;
                    }
                    d_renamed();
                    if (i_renamed + length > e_renamed) {
                        android.util.Log.w_renamed(f3260a, "Cannot recycle buffer '" + iIntValue + "', Buffer cache limit exceeded!!!");
                        return false;
                    }
                }
                if (iIntValue == length) {
                    linkedListA.addLast(bArr);
                } else {
                    linkedListA.addFirst(bArr);
                }
                i_renamed += length;
                return true;
            }
        }
    }

    public static boolean c_renamed(int i2) {
        int i3;
        if (!a_renamed()) {
            android.util.Log.w_renamed(f3260a, "Failed to clear cache - Bufferpool not initialised!");
            return false;
        }
        synchronized (d_renamed) {
            try {
                if (i2 == 5) {
                    i3 = g_renamed;
                } else if (i2 == 10) {
                    i3 = h_renamed;
                } else {
                    if (i2 != 15) {
                        if (i2 != 40) {
                            if (i2 != 60) {
                                if (i2 != 80) {
                                    return false;
                                }
                            }
                            i3 = h_renamed;
                        }
                        i3 = g_renamed;
                    }
                    i3 = 0;
                }
                android.util.Log.v_renamed(f3260a, "ClearCache[" + i2 + "] : Cache Size BEFORE = " + i_renamed);
                if (i_renamed <= i3) {
                    android.util.Log.w_renamed(f3260a, "ClearCache : Current cache size is_renamed lesser than the threshold of_renamed ".concat(java.lang.String.valueOf(i3)));
                    return false;
                }
                int size = f3262c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    java.util.LinkedList<byte[]> linkedListB = f3262c.valueAt(i4).b_renamed();
                    if (linkedListB != null) {
                        while (!linkedListB.isEmpty() && i_renamed > i3) {
                            i_renamed -= linkedListB.removeLast().length;
                        }
                    }
                    if (i_renamed <= i3) {
                        break;
                    }
                }
                android.util.Log.d_renamed(f3260a, "ClearCache : Cache Size AFTER = " + i_renamed);
                return true;
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    private static int d_renamed() {
        int i2;
        synchronized (d_renamed) {
            int i3 = i_renamed;
            int size = f3262c.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed aVarValueAt = f3262c.valueAt(i4);
                if (aVarValueAt != null) {
                    int iD = (int) (aVarValueAt.d_renamed() / aVarValueAt.c_renamed());
                    java.util.LinkedList<byte[]> linkedListB = aVarValueAt.b_renamed();
                    int size2 = linkedListB == null ? 0 : linkedListB.size();
                    while (size2 > iD) {
                        if (linkedListB != null) {
                            i_renamed -= linkedListB.removeLast().length;
                            size2--;
                        }
                    }
                }
            }
            android.util.Log.w_renamed(f3260a, "Pool Stabilized; Cache size reduced from  " + i3 + " -> " + i_renamed);
            i2 = i3 - i_renamed;
        }
        return i2;
    }

    private static int d_renamed(int i2) {
        java.lang.Integer numCeilingKey = f3261b.ceilingKey(java.lang.Integer.valueOf(i2));
        return numCeilingKey == null ? i2 : numCeilingKey.intValue();
    }

    private static com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed e_renamed(int i2) {
        com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed aVar;
        synchronized (d_renamed) {
            aVar = f3262c.get(i2);
        }
        return aVar;
    }

    public static boolean b_renamed(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            android.util.Log.w_renamed(f3260a, "isLowMemoryDevice(): ActivityManager is_renamed null!");
            return true;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return activityManager.getMemoryClass() < 128;
    }

    private static void e_renamed() {
        int[] iArr = {30731, 32779, 61451, 65541};
        synchronized (d_renamed) {
            for (int i2 = 0; i2 < 4; i2++) {
                f_renamed(iArr[i2]);
            }
        }
    }

    private static boolean f_renamed(int i2) {
        synchronized (d_renamed) {
            byte b2 = 0;
            if (i2 > f_renamed || f3262c.indexOfKey(i2) >= 0) {
                return false;
            }
            f3261b.put(java.lang.Integer.valueOf(i2), null);
            f3262c.put(i2, new com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed(i2, b2));
            return true;
        }
    }

    private e_renamed() {
    }

    /* compiled from: BufferPoolImpl.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static int f3263a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f3264b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.util.LinkedList<byte[]> f3265c;
        private int d_renamed;
        private int e_renamed;
        private int f_renamed;

        /* synthetic */ a_renamed(int i_renamed, byte b2) {
            this(i_renamed);
        }

        private a_renamed(int i_renamed) {
            this.f3264b = i_renamed;
            this.d_renamed = 0;
            this.e_renamed = 0;
            this.f3265c = null;
            this.f_renamed = 1;
        }

        public static void a_renamed(com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed aVar) {
            aVar.f_renamed();
            f3263a++;
        }

        final synchronized java.util.LinkedList<byte[]> a_renamed() {
            if (this.f3265c == null) {
                this.f3265c = new java.util.LinkedList<>();
            }
            return this.f3265c;
        }

        final synchronized java.util.LinkedList<byte[]> b_renamed() {
            return this.f3265c;
        }

        final synchronized int c_renamed() {
            return this.f3264b;
        }

        final float d_renamed() {
            float f_renamed;
            synchronized (com.heytap.accessory.b_renamed.a_renamed.e_renamed.d_renamed) {
                f_renamed = com.heytap.accessory.b_renamed.a_renamed.e_renamed.e_renamed * (this.d_renamed / f3263a);
            }
            return f_renamed;
        }

        private synchronized void f_renamed() {
            this.d_renamed++;
        }

        final synchronized boolean e_renamed() {
            float f_renamed;
            this.e_renamed++;
            if (this.f3265c.size() == this.f_renamed) {
                if (this.e_renamed == 0.0f) {
                    f_renamed = this.d_renamed;
                } else {
                    f_renamed = this.d_renamed / this.e_renamed;
                }
                if (f_renamed < 0.9f) {
                    return false;
                }
                this.f_renamed = ((this.f_renamed * 3) / 2) + 1;
            }
            return true;
        }
    }
}
