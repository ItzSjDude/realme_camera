package com.oplus.camera.ui.control;

/* compiled from: ThumbnailLoadExecutor.java */
/* loaded from: classes2.dex */
public class h_renamed implements java.util.concurrent.Executor {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.concurrent.ThreadPoolExecutor f6067a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.ArrayDeque<java.lang.Runnable> f6068b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.Runnable f6069c;
    private android.os.Handler d_renamed;
    private java.util.HashMap<java.lang.String, java.lang.Thread> e_renamed;

    private h_renamed() {
        this.f6067a = null;
        this.f6068b = new java.util.ArrayDeque<>();
        this.f6069c = null;
        this.d_renamed = null;
        this.e_renamed = new java.util.HashMap<>();
        this.f6067a = new java.util.concurrent.ThreadPoolExecutor(1, 20, 3L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new java.util.concurrent.ThreadFactory() { // from class: com.oplus.camera.ui.control.h_renamed.1

            /* renamed from: b_renamed, reason: collision with root package name */
            private final java.util.concurrent.atomic.AtomicInteger f6071b = new java.util.concurrent.atomic.AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public java.lang.Thread newThread(java.lang.Runnable runnable) {
                return new java.lang.Thread(runnable, "ThumbnailLoad AsyncTask #" + this.f6071b.getAndIncrement());
            }
        });
        if (this.d_renamed == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("ObserverHandlerThread");
            handlerThread.start();
            this.d_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.ui.control.h_renamed.2
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    java.lang.Thread thread;
                    java.lang.String str = (java.lang.String) message.obj;
                    com.oplus.camera.e_renamed.a_renamed("ThumbnailLoadExecutor", "handleMessage, receive message over: " + str);
                    if (message.what == 1 && (thread = (java.lang.Thread) com.oplus.camera.ui.control.h_renamed.this.e_renamed.get(str)) != null && thread.isAlive()) {
                        com.oplus.camera.e_renamed.f_renamed("ThumbnailLoadExecutor", "handleMessage, interrupt thread name: " + str);
                        thread.interrupt();
                    }
                }
            };
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final java.lang.Runnable runnable) {
        this.f6068b.offer(new java.lang.Runnable() { // from class: com.oplus.camera.ui.control.h_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
                java.lang.String name = threadCurrentThread.getName();
                com.oplus.camera.ui.control.h_renamed.this.e_renamed.put(name, threadCurrentThread);
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = name;
                com.oplus.camera.ui.control.h_renamed.this.d_renamed.sendMessageDelayed(messageObtain, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                try {
                    runnable.run();
                } finally {
                    com.oplus.camera.ui.control.h_renamed.this.d_renamed.removeCallbacksAndMessages(null);
                    com.oplus.camera.ui.control.h_renamed.this.e_renamed.remove(name);
                    com.oplus.camera.e_renamed.b_renamed("ThumbnailLoadExecutor", "execute, Thumbnail thread cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                    com.oplus.camera.ui.control.h_renamed.this.b_renamed();
                }
            }
        });
        if (this.f6069c == null) {
            b_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b_renamed() {
        java.lang.Runnable runnablePoll = this.f6068b.poll();
        this.f6069c = runnablePoll;
        if (runnablePoll != null) {
            this.f6067a.execute(this.f6069c);
        }
    }

    public static com.oplus.camera.ui.control.h_renamed a_renamed() {
        return com.oplus.camera.ui.control.h_renamed.a_renamed.f6075a;
    }

    /* compiled from: ThumbnailLoadExecutor.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static com.oplus.camera.ui.control.h_renamed f6075a = new com.oplus.camera.ui.control.h_renamed();
    }
}
