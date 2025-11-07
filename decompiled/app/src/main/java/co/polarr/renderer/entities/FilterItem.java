package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class FilterItem {
    public java.util.Map<java.lang.String, java.lang.Object> comments;
    public java.lang.String description;
    public java.lang.String id_renamed;
    public java.lang.Object name;
    public java.util.Map<java.lang.String, java.lang.Object> state;

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0039 A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String filterName(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.name
            boolean r1 = r0 instanceof java.util.Map
            if (r1 == 0) goto L4d
            if (r4 == 0) goto L2f
            java.util.Map r0 = (java.util.Map) r0
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2f
            java.lang.Object r1 = r0.next()
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L12
            java.lang.Object r3 = r3.name
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r3 = r3.get(r1)
        L2a:
            java.lang.String r3 = r3.toString()
            return r3
        L2f:
            java.lang.Object r4 = r3.name
            java.util.Map r4 = (java.util.Map) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L3c
            java.lang.String r3 = ""
            return r3
        L3c:
            java.lang.Object r3 = r3.name
            java.util.Map r3 = (java.util.Map) r3
            java.util.Collection r3 = r3.values()
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r3 = r3.next()
            goto L2a
        L4d:
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: co_renamed.polarr.renderer.entities.FilterItem.filterName(java.lang.String):java.lang.String");
    }

    public void updateStates() {
        java.util.Map<java.lang.String, java.lang.Object> map = this.state;
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                this.state.put(str, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(str, this.state.get(str)));
            }
        }
    }
}
