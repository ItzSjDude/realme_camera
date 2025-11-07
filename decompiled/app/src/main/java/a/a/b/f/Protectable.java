package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class c_renamed {
    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        java.util.List list = (java.util.List) context.renderStates.get("spots");
        java.util.List list2 = (java.util.List) context.renderStates.get("zPrevSpots");
        if (list != null && !list.isEmpty() && !a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(list2, list)) {
            list2 = (java.util.List) a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed((java.lang.Object) list, (java.lang.Class) list.getClass());
            c_renamed(context, resources);
        }
        context.renderStates.put("zPrevSpots", list2);
    }

    public static void b_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarA;
        android.opengl.GLES20.glDisable(3042);
        int[] iArr = context.textures;
        if (iArr == null || iArr.length <= 0) {
            aVarA = a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed.a_renamed(resources, context);
            aVarA.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        } else {
            aVarA = a_renamed.a_renamed.b_renamed.b_renamed.as_renamed.a_renamed(resources, context);
            aVarA.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        }
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(context, context.imageTexture.f34a, context.readableTexture, aVarA, false);
        java.util.List list = (java.util.List) context.renderStates.get("spots");
        a_renamed.a_renamed.b_renamed.b_renamed.bb_renamed bbVarA = a_renamed.a_renamed.b_renamed.b_renamed.bb_renamed.a_renamed(resources, context);
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            co_renamed.polarr.renderer.entities.SpotItem spotItem = (co_renamed.polarr.renderer.entities.SpotItem) list.get(i_renamed);
            float fMin = java.lang.Math.min(1, i_renamed);
            bbVarA.r_renamed = spotItem.feather;
            bbVarA.s_renamed = spotItem.size;
            bbVarA.t_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(spotItem.position);
            bbVarA.u_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(spotItem.sourcePosition);
            bbVarA.v_renamed = spotItem.size[0] * 6.0f;
            bbVarA.w_renamed = fMin;
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) bbVarA, false);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed(context);
        }
    }

    public static void c_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.paintTexture;
        int i_renamed = dVar.f35b;
        int i2 = dVar.f36c;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.readableTexture;
        int i3 = dVar2.f35b;
        int i4 = dVar2.f36c;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.retouchTexture, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i_renamed, i2);
        b_renamed(context, resources);
        a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed blVarA = a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed.a_renamed(resources, context);
        blVarA.a_renamed(context);
        blVarA.r_renamed = new float[]{0.0f, (i_renamed / i2) * 0.036f};
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) blVarA, true);
        blVarA.r_renamed = new float[]{0.036f, 0.0f};
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(context, context.writableTexture.f34a, context.retouchTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) blVarA, false);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i3, i4);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i3, i4);
    }
}
