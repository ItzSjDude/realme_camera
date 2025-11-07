package com.oplus.camera;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import com.crunchfish.touchless_a3d.exception.LicenseNotValidException;
import com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException;
import com.crunchfish.touchless_a3d.gesture.Event;
import com.crunchfish.touchless_a3d.gesture.Gesture;
import com.crunchfish.touchless_a3d.gesture.Pose;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: GestureEngineManager.java */
/* renamed from: com.oplus.camera.o */
/* loaded from: classes2.dex */
public class GestureEngineManager implements Closeable {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TouchlessA3D f14750d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Gesture f14751e;

    /* renamed from: OplusGLSurfaceView_13 */
    private Context f14755i;

    /* renamed from: o */
    private IntrinsicsJvm.kt_3 f14761o;

    /* renamed from: PlatformImplementations.kt_3 */
    private final ExecutorService f14747a = Executors.newSingleThreadExecutor();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object f14748b = new Object();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Gesture.Listener f14749c = new Gesture.Listener() { // from class: com.oplus.camera.o.1
        @Override // com.crunchfish.touchless_a3d.gesture.Gesture.Listener
        public void onEvent(Event event) {
            Pose pose;
            CameraLog.m12954a("GestureEngineManager", "GestureListener, onEvent, text: " + event.getText());
            synchronized (GestureEngineManager.this.f14748b) {
                if (GestureEngineManager.this.f14761o == null) {
                    return;
                }
                if (GestureEngineManager.this.m14776a(event, "open_hand") && (pose = (Pose) event.getIdentifiable("the_hand")) != null) {
                    GestureEngineManager.this.f14761o.mo10427a(pose.getBoundingArea());
                }
            }
        }
    };

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Object f14752f = new Object();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f14753g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f14754h = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private AsyncTask f14756j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private AsyncTask f14757k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private HashMap<Integer, TouchlessA3D.Rotate> f14758l = new HashMap<>();

    /* renamed from: OplusGLSurfaceView_6 */
    private HashMap<Integer, TouchlessA3D.Rotate> f14759m = new HashMap<>();

    /* renamed from: OplusGLSurfaceView_11 */
    private HashMap<Integer, HashMap<Integer, TouchlessA3D.Rotate>> f14760n = new HashMap<>();

    /* compiled from: GestureEngineManager.java */
    /* renamed from: com.oplus.camera.o$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10427a(Rect rect);
    }

    public GestureEngineManager() {
        this.f14758l.put(-1, TouchlessA3D.Rotate.ROTATE_270);
        this.f14758l.put(0, TouchlessA3D.Rotate.ROTATE_270);
        this.f14758l.put(90, TouchlessA3D.Rotate.ROTATE_180);
        this.f14758l.put(180, TouchlessA3D.Rotate.ROTATE_90);
        this.f14758l.put(270, TouchlessA3D.Rotate.DO_NOT_ROTATE);
        this.f14759m.put(-1, TouchlessA3D.Rotate.ROTATE_90);
        this.f14759m.put(0, TouchlessA3D.Rotate.ROTATE_90);
        this.f14759m.put(90, TouchlessA3D.Rotate.ROTATE_180);
        this.f14759m.put(180, TouchlessA3D.Rotate.ROTATE_270);
        this.f14759m.put(270, TouchlessA3D.Rotate.DO_NOT_ROTATE);
        this.f14760n.put(0, this.f14759m);
        this.f14760n.put(1, this.f14758l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14785a(Context context, int OplusGLSurfaceView_13, int i2) {
        this.f14753g = true;
        this.f14756j = new PlatformImplementations.kt_3(context, OplusGLSurfaceView_13, i2).executeOnExecutor(this.f14747a, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14776a(Event event, String str) {
        return event.getText().equals(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14786a(IntrinsicsJvm.kt_3 cVar) {
        synchronized (this.f14748b) {
            this.f14761o = cVar;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14787a(boolean z) {
        this.f14754h = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14789a() {
        return this.f14754h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14788a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f14752f) {
            if (this.f14750d != null) {
                this.f14750d.handleImage(System.currentTimeMillis(), bArr, this.f14760n.get(Integer.valueOf(OplusGLSurfaceView_13)).get(Integer.valueOf(i2)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14782e() {
        synchronized (this.f14752f) {
            if (this.f14751e != null) {
                this.f14751e.unregisterListener(this.f14749c);
            }
            if (this.f14750d != null) {
                this.f14750d.unregisterGesture(this.f14751e);
                this.f14750d.close();
                CameraLog.m12954a("GestureEngineManager", "gesture detect engine has released");
            }
            this.f14751e = null;
            this.f14750d = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f14753g = false;
        synchronized (this.f14748b) {
            this.f14761o = null;
        }
        this.f14757k = new IntrinsicsJvm.kt_4().executeOnExecutor(this.f14747a, new Void[0]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m14790b() {
        return this.f14753g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14791c() {
        AsyncTask asyncTask = this.f14756j;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f14756j = null;
        }
        AsyncTask asyncTask2 = this.f14757k;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.f14757k = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14792d() {
        HashMap<Integer, HashMap<Integer, TouchlessA3D.Rotate>> map = this.f14760n;
        if (map != null) {
            map.clear();
            this.f14760n = null;
        }
        HashMap<Integer, TouchlessA3D.Rotate> map2 = this.f14759m;
        if (map2 != null) {
            map2.clear();
            this.f14759m = null;
        }
        HashMap<Integer, TouchlessA3D.Rotate> map3 = this.f14758l;
        if (map3 != null) {
            map3.clear();
            this.f14758l = null;
        }
        this.f14755i = null;
        synchronized (this.f14748b) {
            this.f14761o = null;
        }
    }

    /* compiled from: GestureEngineManager.java */
    /* renamed from: com.oplus.camera.o$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends AsyncTask<Void, Void, Void> {
        private IntrinsicsJvm.kt_4() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            GestureEngineManager.this.m14782e();
            return null;
        }
    }

    /* compiled from: GestureEngineManager.java */
    /* renamed from: com.oplus.camera.o$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends AsyncTask<Void, Void, Void> {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f14764b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f14765c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f14766d = true;

        public PlatformImplementations.kt_3(Context context, int OplusGLSurfaceView_13, int i2) {
            GestureEngineManager.this.f14755i = context;
            this.f14764b = OplusGLSurfaceView_13;
            this.f14765c = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            GestureEngineManager.this.m14782e();
            if (GestureEngineManager.this.f14755i == null) {
                return null;
            }
            try {
                GestureEngineManager.this.f14750d = new TouchlessA3D(this.f14764b, this.f14765c, GestureEngineManager.this.f14755i);
                GestureEngineManager.this.f14750d.setParameter(1002, 1);
                CameraLog.m12954a("GestureEngineManager", "gesture detect engine has be inited mImageWidth:" + this.f14764b + " mImageHeight:" + this.f14765c);
                try {
                    GestureEngineManager.this.f14751e = m14793a("hand_wink.json");
                    if (GestureEngineManager.this.f14751e != null) {
                        GestureEngineManager.this.f14751e.registerListener(GestureEngineManager.this.f14749c);
                        GestureEngineManager.this.f14750d.registerGesture(GestureEngineManager.this.f14751e);
                    }
                    return null;
                } catch (IOException COUIBaseListPopupWindow_8) {
                    CameraLog.m12967f("GestureEngineManager", "GestureEngineLoadTask IOException: " + COUIBaseListPopupWindow_8);
                    return null;
                }
            } catch (LicenseNotValidException e2) {
                CameraLog.m12967f("GestureEngineManager", "GestureEngineLoadTask LicenseNotValidException: " + e2);
                this.f14766d = false;
                return null;
            } catch (LicenseServerUnavailableException e3) {
                CameraLog.m12967f("GestureEngineManager", "GestureEngineLoadTask LicenseServerUnavailableException: " + e3);
                this.f14766d = false;
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x001f A[PHI: r5 r6
          0x001f: PHI (r5v8 'this' ??) = (r5v5 'this' ??), (r5v12 'this' ??) binds: [B:20:0x0044, B:9:0x001d] A[DONT_GENERATE, DONT_INLINE]
          0x001f: PHI (r6v7 byte[]) = (r6v5 byte[]), (r6v11 byte[]) binds: [B:20:0x0044, B:9:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.oplus.camera.o$PlatformImplementations.kt_3] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.crunchfish.touchless_a3d.gesture.Gesture m14793a(java.lang.String r6) throws java.lang.Throwable {
            /*
                r5 = this;
                r0 = 0
                com.oplus.camera.o r5 = com.oplus.camera.GestureEngineManager.this     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                android.content.Context r5 = com.oplus.camera.GestureEngineManager.m14780d(r5)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                java.io.InputStream r5 = r5.open(r6)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
                int r6 = r5.available()     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L55
                byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L55
                int r1 = r5.read(r6)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L55
                r2 = -1
                if (r2 != r1) goto L1d
                r6 = r0
            L1d:
                if (r5 == 0) goto L47
            L1f:
                r5.close()
                goto L47
            L23:
                r1 = move-exception
                goto L2e
            L25:
                r1 = move-exception
                r6 = r0
                goto L2e
            L28:
                r6 = move-exception
                r5 = r0
                goto L56
            L2b:
                r1 = move-exception
                r5 = r0
                r6 = r5
            L2e:
                java.lang.String r2 = "GestureEngineManager"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
                r3.<init>()     // Catch: java.lang.Throwable -> L55
                java.lang.String r4 = "readGestureJson Exception: "
                r3.append(r4)     // Catch: java.lang.Throwable -> L55
                r3.append(r1)     // Catch: java.lang.Throwable -> L55
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L55
                com.oplus.camera.CameraLog.m12967f(r2, r1)     // Catch: java.lang.Throwable -> L55
                if (r5 == 0) goto L47
                goto L1f
            L47:
                if (r6 == 0) goto L54
                com.crunchfish.touchless_a3d.gesture.Gesture r5 = new com.crunchfish.touchless_a3d.gesture.Gesture
                java.lang.String r0 = new java.lang.String
                r0.<init>(r6)
                r5.<init>(r0)
                return r5
            L54:
                return r0
            L55:
                r6 = move-exception
            L56:
                if (r5 == 0) goto L5b
                r5.close()
            L5b:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.GestureEngineManager.PlatformImplementations.kt_3.m14793a(java.lang.String):com.crunchfish.touchless_a3d.gesture.Gesture");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            if (this.f14766d) {
                return;
            }
            CameraLog.m12967f("GestureEngineManager", "Gesture engine init fail");
        }
    }
}
