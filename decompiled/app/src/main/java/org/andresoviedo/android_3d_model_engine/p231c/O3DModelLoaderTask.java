package org.andresoviedo.android_3d_model_engine.p231c;

import android.app.Activity;
import com.p094b.p095a.Log;
import com.p094b.p095a.O3DPHOTO_MODEL;
import com.p094b.p095a.WavefrontLoaderO3d;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import org.andresoviedo.android_3d_model_engine.p230b.Object3DData;
import org.andresoviedo.p225a.p226a.GL;
import org.andresoviedo.p225a.p226a.GLUtil;

/* compiled from: O3DModelLoaderTask.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class O3DModelLoaderTask extends LoaderTask {

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final String f24970b = "IntrinsicsJvm.kt_3";

    /* renamed from: IntrinsicsJvm.kt_3 */
    O3DPHOTO_MODEL[] f24971c;

    public O3DModelLoaderTask(Activity activity, O3DPHOTO_MODEL[] c1236gArr, LoadListener interfaceC4061a) {
        super(activity, null, interfaceC4061a);
        this.f24971c = c1236gArr;
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoaderTask
    /* renamed from: PlatformImplementations.kt_3 */
    protected List<Object3DData> mo26259a() throws IOException {
        ArrayList arrayList = new ArrayList();
        for (O3DPHOTO_MODEL c1236g : this.f24971c) {
            WavefrontLoaderO3d c1244o = new WavefrontLoaderO3d();
            c1244o.m6366a(c1236g);
            Object3DData c4060g = new Object3DData(c1244o.m6365a(), c1244o.m6367b());
            c4060g.f24941a = c1236g.f6193d != null;
            c4060g.m26218a("O3DPHOTO_MODEL " + c1236g);
            c4060g.m26223a(c1244o);
            GL c4047c = GL.f24804a;
            c4060g.m26217a(4);
            c4060g.m26222a(c1244o.m6369c());
            arrayList.add(c4060g);
        }
        return arrayList;
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoaderTask
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo26262b(List<Object3DData> list) throws Exception {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24971c.length; OplusGLSurfaceView_13++) {
            try {
                m26264a(this.f24971c[OplusGLSurfaceView_13], list.get(OplusGLSurfaceView_13));
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26264a(O3DPHOTO_MODEL c1236g, Object3DData c4060g) throws Exception {
        float COUIBaseListPopupWindow_12;
        try {
            c4060g.m26243k().m6368b(c1236g);
            int OplusGLSurfaceView_13 = 0;
            c4060g.m26230b(new float[]{5.0f, 5.0f, 5.0f});
            GL c4047c = GL.f24804a;
            c4060g.m26217a(4);
            WavefrontLoaderO3d c1244oM26243k = c4060g.m26243k();
            FloatBuffer floatBufferM26127b = GLUtil.m26127b(c1244oM26243k.f6279d * 3 * 4);
            c4060g.m26232c(floatBufferM26127b);
            c4060g.m26220a(true);
            List<WavefrontLoaderO3d.PlatformImplementations.kt_3> list = c1244oM26243k == null ? null : c1244oM26243k.f6281f;
            if (list != null && list.size() == c1244oM26243k.f6277b) {
                FloatBuffer floatBufferM26127b2 = GLUtil.m26127b(c1244oM26243k.f6279d * 3 * 4);
                FloatBuffer floatBufferM26127b3 = c1236g.f6193d != null ? GLUtil.m26127b(c1244oM26243k.f6279d * 3) : null;
                int i2 = 0;
                while (i2 < c1244oM26243k.f6279d) {
                    for (int i3 = OplusGLSurfaceView_13; i3 < 3; i3++) {
                        int i4 = (i2 * 3) + i3;
                        int i5 = c1244oM26243k.f6280e.get(i4);
                        int i6 = i4 * 3;
                        floatBufferM26127b.put(i6, c1244oM26243k.m6365a().get(c1244oM26243k.f6280e.get(i4) * 3));
                        floatBufferM26127b.put(i6 + 1, c1244oM26243k.m6365a().get((c1244oM26243k.f6280e.get(i4) * 3) + 1));
                        floatBufferM26127b.put(i6 + 2, c1244oM26243k.m6365a().get((c1244oM26243k.f6280e.get(i4) * 3) + 2));
                        WavefrontLoaderO3d.PlatformImplementations.kt_3 aVar = c1244oM26243k.f6281f.get(i5);
                        floatBufferM26127b2.put(aVar.f6284a).put(aVar.f6285b).put(aVar.f6286c).put(aVar.f6287d);
                        if (c1236g.f6193d != null) {
                            floatBufferM26127b3.put(c1236g.f6193d[i5] & 255);
                        }
                    }
                    i2++;
                    OplusGLSurfaceView_13 = 0;
                }
                c4060g.m26234d(floatBufferM26127b2);
                if (c1236g.f6193d != null) {
                    c4060g.m26235e(floatBufferM26127b3);
                }
            }
            if (c1236g.f6190a.length > 0) {
                FloatBuffer floatBufferM26127b4 = GLUtil.m26127b(c1244oM26243k.f6279d * 3 * 2);
                for (int i7 = 0; i7 < c1244oM26243k.f6279d; i7++) {
                    for (int i8 = 0; i8 < 3; i8++) {
                        int i9 = c1244oM26243k.f6280e.get((i7 * 3) + i8) * 3;
                        float f2 = 1.0f - ((c1236g.f6190a[i9 + 0] + 1.0f) / 2.0f);
                        float f3 = 1.0f - ((c1236g.f6190a[i9 + 1] + 1.0f) / 2.0f);
                        if (c1236g.f6195f) {
                            COUIBaseListPopupWindow_12 = 1.0f - f2;
                        } else {
                            COUIBaseListPopupWindow_12 = f3;
                            f3 = f2;
                        }
                        floatBufferM26127b4.put(f3).put(COUIBaseListPopupWindow_12);
                    }
                }
                c4060g.m26238g(floatBufferM26127b4);
            }
            c4060g.m26229a(c1236g.f6197h);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.m6275a(f24970b, COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
            throw COUIBaseListPopupWindow_8;
        }
    }
}
