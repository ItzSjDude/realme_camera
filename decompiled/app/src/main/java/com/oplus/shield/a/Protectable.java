package com.oplus.shield.a_renamed;

/* compiled from: SystemServiceMap.java */
/* loaded from: classes2.dex */
public class c_renamed implements com.oplus.shield.a_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.Integer, java.lang.String> f7606a = new java.util.HashMap<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f7607b;

    c_renamed(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException {
        this.f7607b = str;
        b_renamed();
    }

    private void b_renamed() throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(this.f7607b + "$Stub");
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                if (field.getName().startsWith("TRANSACTION_")) {
                    field.setAccessible(true);
                    this.f7606a.put(java.lang.Integer.valueOf(field.getInt(cls)), field.getName().replaceFirst("TRANSACTION_", ""));
                }
            }
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    @Override // com.oplus.shield.a_renamed.a_renamed
    public java.lang.String a_renamed(int i_renamed) {
        if (this.f7606a.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            return this.f7606a.get(java.lang.Integer.valueOf(i_renamed));
        }
        return null;
    }

    @Override // com.oplus.shield.a_renamed.a_renamed
    public java.lang.String a_renamed() {
        return this.f7607b;
    }
}
