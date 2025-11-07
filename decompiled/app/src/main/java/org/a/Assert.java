package org.a_renamed;

/* compiled from: BaseDescription.java */
/* loaded from: classes2.dex */
public abstract class a_renamed implements org.a_renamed.d_renamed {
    protected abstract void a_renamed(char c2);

    @Override // org.a_renamed.d_renamed
    public org.a_renamed.d_renamed a_renamed(java.lang.String str) {
        b_renamed(str);
        return this;
    }

    @Override // org.a_renamed.d_renamed
    public org.a_renamed.d_renamed a_renamed(org.a_renamed.h_renamed hVar) {
        hVar.describeTo(this);
        return this;
    }

    @Override // org.a_renamed.d_renamed
    public org.a_renamed.d_renamed a_renamed(java.lang.Object obj) {
        if (obj == null) {
            b_renamed("null");
        } else if (obj instanceof java.lang.String) {
            c_renamed((java.lang.String) obj);
        } else if (obj instanceof java.lang.Character) {
            a_renamed('\"');
            b_renamed(((java.lang.Character) obj).charValue());
            a_renamed('\"');
        } else if (obj instanceof java.lang.Short) {
            a_renamed('<');
            b_renamed(b_renamed(obj));
            b_renamed("s_renamed>");
        } else if (obj instanceof java.lang.Long) {
            a_renamed('<');
            b_renamed(b_renamed(obj));
            b_renamed("L_renamed>");
        } else if (obj instanceof java.lang.Float) {
            a_renamed('<');
            b_renamed(b_renamed(obj));
            b_renamed("F_renamed>");
        } else if (obj.getClass().isArray()) {
            a_renamed("[", ", ", "]", new org.a_renamed.b_renamed.a_renamed(obj));
        } else {
            a_renamed('<');
            b_renamed(b_renamed(obj));
            a_renamed('>');
        }
        return this;
    }

    private java.lang.String b_renamed(java.lang.Object obj) {
        try {
            return java.lang.String.valueOf(obj);
        } catch (java.lang.Exception unused) {
            return obj.getClass().getName() + "@" + java.lang.Integer.toHexString(obj.hashCode());
        }
    }

    private <T_renamed> org.a_renamed.d_renamed a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Iterator<T_renamed> it) {
        return b_renamed(str, str2, str3, new org.a_renamed.b_renamed.d_renamed(it));
    }

    @Override // org.a_renamed.d_renamed
    public org.a_renamed.d_renamed a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Iterable<? extends org.a_renamed.h_renamed> iterable) {
        return b_renamed(str, str2, str3, iterable.iterator());
    }

    private org.a_renamed.d_renamed b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Iterator<? extends org.a_renamed.h_renamed> it) {
        b_renamed(str);
        boolean z_renamed = false;
        while (it.hasNext()) {
            if (z_renamed) {
                b_renamed(str2);
            }
            a_renamed(it.next());
            z_renamed = true;
        }
        b_renamed(str3);
        return this;
    }

    protected void b_renamed(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            a_renamed(str.charAt(i_renamed));
        }
    }

    private void c_renamed(java.lang.String str) {
        a_renamed('\"');
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            b_renamed(str.charAt(i_renamed));
        }
        a_renamed('\"');
    }

    private void b_renamed(char c2) {
        if (c2 == '\t_renamed') {
            b_renamed("\\t_renamed");
            return;
        }
        if (c2 == '\n_renamed') {
            b_renamed("\\n_renamed");
            return;
        }
        if (c2 == '\r_renamed') {
            b_renamed("\\r_renamed");
        } else if (c2 == '\"') {
            b_renamed("\\\"");
        } else {
            a_renamed(c2);
        }
    }
}
