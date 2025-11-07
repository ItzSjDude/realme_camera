package co_renamed.polarr.renderer;

/* loaded from: classes.dex */
public class PolarrRenderThread extends android.os.HandlerThread {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final android.content.res.Resources f1939a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.d_renamed f1940b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.c_renamed.c_renamed f1941c;
    public android.os.Handler d_renamed;
    public boolean e_renamed;

    public class porender_YuvEf implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final /* synthetic */ android.graphics.Bitmap f1942a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final /* synthetic */ java.util.List f1943b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final /* synthetic */ co_renamed.polarr.renderer.RenderCallback f1944c;

        public porender_YuvEf(android.graphics.Bitmap bitmap, java.util.List list, co_renamed.polarr.renderer.RenderCallback renderCallback) {
            this.f1942a = bitmap;
            this.f1943b = list;
            this.f1944c = renderCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            co_renamed.polarr.renderer.PolarrRenderThread.this.f1940b.c_renamed(this.f1942a.getWidth(), this.f1942a.getHeight());
            java.util.Iterator it = this.f1943b.iterator();
            while (it.hasNext()) {
                arrayList.add(co_renamed.polarr.renderer.PolarrRenderThread.this.f1940b.a_renamed(this.f1942a, (java.lang.String) it.next()));
            }
            this.f1944c.onRenderBitmap(arrayList);
        }
    }

    public class porender_iuAiH implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final /* synthetic */ co_renamed.polarr.renderer.RenderCallback f1945a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final /* synthetic */ android.graphics.Bitmap f1946b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final /* synthetic */ java.util.List f1947c;

        public porender_iuAiH(co_renamed.polarr.renderer.RenderCallback renderCallback, android.graphics.Bitmap bitmap, java.util.List list) {
            this.f1945a = renderCallback;
            this.f1946b = bitmap;
            this.f1947c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1945a != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                co_renamed.polarr.renderer.PolarrRenderThread.this.f1940b.c_renamed(this.f1946b.getWidth(), this.f1946b.getHeight());
                java.util.Iterator it = this.f1947c.iterator();
                while (it.hasNext()) {
                    arrayList.add(co_renamed.polarr.renderer.PolarrRenderThread.this.f1940b.a_renamed(this.f1946b, (java.util.Map<java.lang.String, java.lang.Object>) it.next()));
                }
                this.f1945a.onRenderBitmap(arrayList);
            }
        }
    }

    public class porender_pefpG implements java.lang.Runnable {
        public porender_pefpG() {
        }

        @Override // java.lang.Runnable
        public void run() {
            co_renamed.polarr.renderer.PolarrRenderThread.this.b_renamed();
            co_renamed.polarr.renderer.PolarrRenderThread.super.interrupt();
            co_renamed.polarr.renderer.PolarrRenderThread.this.d_renamed.getLooper().quit();
            co_renamed.polarr.renderer.PolarrRenderThread.this.d_renamed = null;
        }
    }

    public class porender_qbdmL implements java.lang.Runnable {
        public porender_qbdmL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            co_renamed.polarr.renderer.PolarrRenderThread.this.a_renamed();
        }
    }

    public PolarrRenderThread(android.content.res.Resources resources) {
        super("PolarrRenderThread");
        this.f1940b = null;
        this.e_renamed = false;
        this.f1939a = resources;
    }

    public final void a_renamed() {
        this.f1941c = new a_renamed.a_renamed.b_renamed.c_renamed.c_renamed();
        this.f1941c.a_renamed(100, 100);
        this.f1940b = new a_renamed.a_renamed.b_renamed.d_renamed();
        this.f1940b.a_renamed(this.f1939a, 1, 1, !this.e_renamed, 0);
        this.f1940b.f_renamed();
    }

    public final void b_renamed() {
        this.f1940b.u_renamed();
        this.f1941c.a_renamed();
    }

    @Override // java.lang.Thread
    public void interrupt() {
        this.d_renamed.post(new co_renamed.polarr.renderer.PolarrRenderThread.porender_pefpG());
    }

    public void renderBitmap(android.graphics.Bitmap bitmap, java.util.List<java.lang.String> list, co_renamed.polarr.renderer.RenderCallback renderCallback) {
        if (renderCallback == null || bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return;
        }
        this.d_renamed.post(new co_renamed.polarr.renderer.PolarrRenderThread.porender_YuvEf(bitmap, list, renderCallback));
    }

    public void renderBitmapByStates(android.graphics.Bitmap bitmap, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, co_renamed.polarr.renderer.RenderCallback renderCallback) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return;
        }
        this.d_renamed.post(new co_renamed.polarr.renderer.PolarrRenderThread.porender_iuAiH(renderCallback, bitmap, list));
    }

    @Override // java.lang.Thread
    public void start() {
        synchronized (this) {
            super.start();
            this.d_renamed = new android.os.Handler(getLooper());
            this.d_renamed.post(new co_renamed.polarr.renderer.PolarrRenderThread.porender_qbdmL());
        }
    }
}
