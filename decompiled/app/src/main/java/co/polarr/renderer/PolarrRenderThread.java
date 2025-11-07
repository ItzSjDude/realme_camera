package co.polarr.renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.C0098d;
import p000a.p001a.p003b.p007c.C0093c;

/* loaded from: classes.dex */
public class PolarrRenderThread extends HandlerThread {

    /* renamed from: PlatformImplementations.kt_3 */
    public final Resources f5128a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public C0098d f5129b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public C0093c f5130c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Handler f5131d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean f5132e;

    public class porender_YuvEf implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        public final /* synthetic */ Bitmap f5133a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final /* synthetic */ List f5134b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final /* synthetic */ RenderCallback f5135c;

        public porender_YuvEf(Bitmap bitmap, List list, RenderCallback renderCallback) {
            this.f5133a = bitmap;
            this.f5134b = list;
            this.f5135c = renderCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            PolarrRenderThread.this.f5129b.m402c(this.f5133a.getWidth(), this.f5133a.getHeight());
            Iterator it = this.f5134b.iterator();
            while (it.hasNext()) {
                arrayList.add(PolarrRenderThread.this.f5129b.m353a(this.f5133a, (String) it.next()));
            }
            this.f5135c.onRenderBitmap(arrayList);
        }
    }

    public class porender_iuAiH implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        public final /* synthetic */ RenderCallback f5137a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final /* synthetic */ Bitmap f5138b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final /* synthetic */ List f5139c;

        public porender_iuAiH(RenderCallback renderCallback, Bitmap bitmap, List list) {
            this.f5137a = renderCallback;
            this.f5138b = bitmap;
            this.f5139c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5137a != null) {
                ArrayList arrayList = new ArrayList();
                PolarrRenderThread.this.f5129b.m402c(this.f5138b.getWidth(), this.f5138b.getHeight());
                Iterator it = this.f5139c.iterator();
                while (it.hasNext()) {
                    arrayList.add(PolarrRenderThread.this.f5129b.m356a(this.f5138b, (Map<String, Object>) it.next()));
                }
                this.f5137a.onRenderBitmap(arrayList);
            }
        }
    }

    public class porender_pefpG implements Runnable {
        public porender_pefpG() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PolarrRenderThread.this.m5424b();
            PolarrRenderThread.super.interrupt();
            PolarrRenderThread.this.f5131d.getLooper().quit();
            PolarrRenderThread.this.f5131d = null;
        }
    }

    public class porender_qbdmL implements Runnable {
        public porender_qbdmL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PolarrRenderThread.this.m5423a();
        }
    }

    public PolarrRenderThread(Resources resources) {
        super("PolarrRenderThread");
        this.f5129b = null;
        this.f5132e = false;
        this.f5128a = resources;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m5423a() {
        this.f5130c = new C0093c();
        this.f5130c.m278a(100, 100);
        this.f5129b = new C0098d();
        this.f5129b.m373a(this.f5128a, 1, 1, !this.f5132e, 0);
        this.f5129b.m409f();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m5424b() {
        this.f5129b.m430u();
        this.f5130c.m280a();
    }

    @Override // java.lang.Thread
    public void interrupt() {
        this.f5131d.post(new porender_pefpG());
    }

    public void renderBitmap(Bitmap bitmap, List<String> list, RenderCallback renderCallback) {
        if (renderCallback == null || bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return;
        }
        this.f5131d.post(new porender_YuvEf(bitmap, list, renderCallback));
    }

    public void renderBitmapByStates(Bitmap bitmap, List<Map<String, Object>> list, RenderCallback renderCallback) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return;
        }
        this.f5131d.post(new porender_iuAiH(renderCallback, bitmap, list));
    }

    @Override // java.lang.Thread
    public void start() {
        synchronized (this) {
            super.start();
            this.f5131d = new Handler(getLooper());
            this.f5131d.post(new porender_qbdmL());
        }
    }
}
