package p000a.p001a.p003b.p010f;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.SpotItem;
import java.util.List;
import p000a.p001a.p003b.p005b.C0030as;
import p000a.p001a.p003b.p005b.C0040bb;
import p000a.p001a.p003b.p005b.C0048bj;
import p000a.p001a.p003b.p005b.C0050bl;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class C0110c {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m467a(Context context, Resources resources) {
        List list = (List) context.renderStates.get("spots");
        List list2 = (List) context.renderStates.get("zPrevSpots");
        if (list != null && !list.isEmpty() && !C0123p.m577a(list2, list)) {
            list2 = (List) C0123p.m574a((Object) list, (Class) list.getClass());
            m469c(context, resources);
        }
        context.renderStates.put("zPrevSpots", list2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m468b(Context context, Resources resources) {
        AbstractC0008a abstractC0008aM160a;
        GLES20.glDisable(3042);
        int[] iArr = context.textures;
        if (iArr == null || iArr.length <= 0) {
            abstractC0008aM160a = C0048bj.m160a(resources, context);
            abstractC0008aM160a.m42a(C0125r.m596a());
        } else {
            abstractC0008aM160a = C0030as.m130a(resources, context);
            abstractC0008aM160a.m42a(C0125r.m596a());
        }
        C0097g.m299a(context, context.imageTexture.f387a, context.readableTexture, abstractC0008aM160a, false);
        List list = (List) context.renderStates.get("spots");
        C0040bb c0040bbM148a = C0040bb.m148a(resources, context);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            SpotItem spotItem = (SpotItem) list.get(OplusGLSurfaceView_13);
            float fMin = Math.min(1, OplusGLSurfaceView_13);
            c0040bbM148a.f181r = spotItem.feather;
            c0040bbM148a.f182s = spotItem.size;
            c0040bbM148a.f183t = C0123p.m580a(spotItem.position);
            c0040bbM148a.f184u = C0123p.m580a(spotItem.sourcePosition);
            c0040bbM148a.f185v = spotItem.size[0] * 6.0f;
            c0040bbM148a.f186w = fMin;
            C0097g.m299a(context, context.readableTexture.f387a, context.writableTexture, (AbstractC0008a) c0040bbM148a, false);
            C0097g.m304b(context);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m469c(Context context, Resources resources) {
        C0094d c0094d = context.paintTexture;
        int OplusGLSurfaceView_13 = c0094d.f388b;
        int i2 = c0094d.f389c;
        C0094d c0094d2 = context.readableTexture;
        int i3 = c0094d2.f388b;
        int i4 = c0094d2.f389c;
        C0113f.m490b(context.retouchTexture, OplusGLSurfaceView_13, i2);
        C0113f.m490b(context.readableTexture, OplusGLSurfaceView_13, i2);
        C0113f.m490b(context.writableTexture, OplusGLSurfaceView_13, i2);
        m468b(context, resources);
        C0050bl c0050blM164a = C0050bl.m164a(resources, context);
        c0050blM164a.m56a(context);
        c0050blM164a.f222r = new float[]{0.0f, (OplusGLSurfaceView_13 / i2) * 0.036f};
        C0097g.m299a(context, context.readableTexture.f387a, context.writableTexture, (AbstractC0008a) c0050blM164a, true);
        c0050blM164a.f222r = new float[]{0.036f, 0.0f};
        C0097g.m299a(context, context.writableTexture.f387a, context.retouchTexture, (AbstractC0008a) c0050blM164a, false);
        C0113f.m490b(context.readableTexture, i3, i4);
        C0113f.m490b(context.writableTexture, i3, i4);
    }
}
