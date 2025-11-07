package com.oplus.camera.p172ui.control;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.camera.CameraLog;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThumbnailLoadExecutor.java */
/* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class ThumbnailLoadExecutor implements Executor {

    /* renamed from: PlatformImplementations.kt_3 */
    private ThreadPoolExecutor f18305a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ArrayDeque<Runnable> f18306b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Runnable f18307c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Handler f18308d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private HashMap<String, Thread> f18309e;

    private ThumbnailLoadExecutor() {
        this.f18305a = null;
        this.f18306b = new ArrayDeque<>();
        this.f18307c = null;
        this.f18308d = null;
        this.f18309e = new HashMap<>();
        this.f18305a = new ThreadPoolExecutor(1, 20, 3L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.oplus.camera.ui.control.COUIBaseListPopupWindow_10.1

            /* renamed from: IntrinsicsJvm.kt_4 */
            private final AtomicInteger f18311b = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ThumbnailLoad AsyncTask #" + this.f18311b.getAndIncrement());
            }
        });
        if (this.f18308d == null) {
            HandlerThread handlerThread = new HandlerThread("ObserverHandlerThread");
            handlerThread.start();
            this.f18308d = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.ui.control.COUIBaseListPopupWindow_10.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Thread thread;
                    String str = (String) message.obj;
                    CameraLog.m12954a("ThumbnailLoadExecutor", "handleMessage, receive message over: " + str);
                    if (message.what == 1 && (thread = (Thread) ThumbnailLoadExecutor.this.f18309e.get(str)) != null && thread.isAlive()) {
                        CameraLog.m12967f("ThumbnailLoadExecutor", "handleMessage, interrupt thread name: " + str);
                        thread.interrupt();
                    }
                }
            };
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.f18306b.offer(new Runnable() { // from class: com.oplus.camera.ui.control.COUIBaseListPopupWindow_10.3
            @Override // java.lang.Runnable
            public void run() {
                Thread threadCurrentThread = Thread.currentThread();
                String name = threadCurrentThread.getName();
                ThumbnailLoadExecutor.this.f18309e.put(name, threadCurrentThread);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = name;
                ThumbnailLoadExecutor.this.f18308d.sendMessageDelayed(messageObtain, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    runnable.run();
                } finally {
                    ThumbnailLoadExecutor.this.f18308d.removeCallbacksAndMessages(null);
                    ThumbnailLoadExecutor.this.f18309e.remove(name);
                    CameraLog.m12959b("ThumbnailLoadExecutor", "execute, Thumbnail thread cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    ThumbnailLoadExecutor.this.m19305b();
                }
            }
        });
        if (this.f18307c == null) {
            m19305b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m19305b() {
        Runnable runnablePoll = this.f18306b.poll();
        this.f18307c = runnablePoll;
        if (runnablePoll != null) {
            this.f18305a.execute(this.f18307c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ThumbnailLoadExecutor m19302a() {
        return PlatformImplementations.kt_3.f18315a;
    }

    /* compiled from: ThumbnailLoadExecutor.java */
    /* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static ThumbnailLoadExecutor f18315a = new ThumbnailLoadExecutor();
    }
}
