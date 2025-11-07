package c_renamed.f_renamed;

/* compiled from: JvmClassMapping.kt */
/* loaded from: classes.dex */
public final class a_renamed {
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of_renamed "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is_renamed null
    	at_renamed jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at_renamed jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at_renamed jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at_renamed jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final <T_renamed> java.lang.Class<T_renamed> a_renamed(c_renamed.i_renamed.a_renamed<T_renamed> aVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(aVar, "$this$javaObjectType");
        java.lang.Class<T_renamed> cls = (java.lang.Class<T_renamed>) ((c_renamed.f_renamed.b_renamed.c_renamed) aVar).a_renamed();
        if (!cls.isPrimitive()) {
            if (cls != null) {
                return cls;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type java.lang.Class<T_renamed>");
        }
        java.lang.String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Double.class;
                        break;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Integer.class;
                        break;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Byte.class;
                        break;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Character.class;
                        break;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Long.class;
                        break;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Void.class;
                        break;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Boolean.class;
                        break;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Float.class;
                        break;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        cls = (java.lang.Class<T_renamed>) java.lang.Short.class;
                        break;
                    }
                    break;
            }
        }
        if (cls != null) {
            return cls;
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type java.lang.Class<T_renamed>");
    }

    public static final <T_renamed> c_renamed.i_renamed.a_renamed<T_renamed> a_renamed(java.lang.Class<T_renamed> cls) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cls, "$this$kotlin");
        return c_renamed.f_renamed.b_renamed.k_renamed.a_renamed(cls);
    }
}
