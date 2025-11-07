package com.oplus.camera.ui.menu;

/* compiled from: PreferenceMenuOptionGroup.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Class<?>[] f6444a = {android.content.Context.class, android.util.AttributeSet.class};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String f6445b = com.oplus.camera.ui.menu.PreferenceMenuOptionInfo.class.getPackage().getName();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> f6446c = new java.util.HashMap<>();
    private java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.b_renamed> d_renamed;
    private android.content.Context e_renamed;
    private boolean f_renamed;

    public h_renamed(android.content.Context context, int i_renamed, boolean z_renamed) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.io.IOException, java.lang.SecurityException {
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = false;
        this.e_renamed = context;
        this.d_renamed = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.f_renamed = z_renamed;
        a_renamed(i_renamed);
    }

    private void a_renamed(int i_renamed) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.io.IOException, java.lang.SecurityException {
        com.oplus.camera.e_renamed.a_renamed("PreferenceMenuOptionGroup", "inflate");
        if (i_renamed == 0) {
            com.oplus.camera.e_renamed.f_renamed("PreferenceMenuOptionGroup", "Invalid resources id_renamed!");
            return;
        }
        this.d_renamed.clear();
        android.content.res.XmlResourceParser xml = this.e_renamed.getResources().getXml(i_renamed);
        java.lang.Object[] objArr = {this.e_renamed, android.util.Xml.asAttributeSet(xml)};
        while (true) {
            try {
                int next = xml.next();
                if (next == 1) {
                    break;
                }
                if (next == 2 && !xml.getName().equals("PreferenceMenuOptionGroup")) {
                    com.oplus.camera.ui.menu.b_renamed bVarA = a_renamed(xml.getName(), objArr);
                    if (this.f_renamed || com.oplus.camera.aps.config.CameraConfig.checkKeyInMenuList(com.oplus.camera.entry.b_renamed.d_renamed(bVarA.getOptionKey()))) {
                        this.d_renamed.add(bVarA);
                    } else {
                        bVarA.release();
                    }
                }
            } catch (java.io.IOException e_renamed) {
                throw new android.view.InflateException(xml.getPositionDescription(), e_renamed);
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                throw new android.view.InflateException(e2);
            }
        }
        if (this.d_renamed.size() == 0) {
            throw new android.view.InflateException("No root element found");
        }
        com.oplus.camera.e_renamed.a_renamed("PreferenceMenuOptionGroup", "inflate X_renamed");
    }

    private com.oplus.camera.ui.menu.b_renamed a_renamed(java.lang.String str, java.lang.Object[] objArr) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.String str2 = f6445b + "." + str;
        java.lang.reflect.Constructor<?> constructor = f6446c.get(str2);
        if (constructor == null) {
            try {
                constructor = this.e_renamed.getClassLoader().loadClass(str2).getConstructor(f6444a);
                f6446c.put(str2, constructor);
            } catch (java.lang.ClassNotFoundException e_renamed) {
                throw new android.view.InflateException("No such class: " + str2, e_renamed);
            } catch (java.lang.NoSuchMethodException e2) {
                throw new android.view.InflateException("Error inflating class " + str2, e2);
            } catch (java.lang.Exception e3) {
                throw new android.view.InflateException("While create instance of_renamed" + str2, e3);
            }
        }
        return (com.oplus.camera.ui.menu.b_renamed) constructor.newInstance(objArr);
    }

    public com.oplus.camera.ui.menu.b_renamed a_renamed(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.b_renamed> copyOnWriteArrayList;
        if (str == null || str.equals("") || (copyOnWriteArrayList = this.d_renamed) == null) {
            return null;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.b_renamed> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.b_renamed next = it.next();
            if (next != null && next.getOptionKey().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.b_renamed> copyOnWriteArrayList = this.d_renamed;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.b_renamed> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.b_renamed next = it.next();
                if (next != null) {
                    next.release();
                }
            }
            this.d_renamed.clear();
            this.d_renamed = null;
        }
    }
}
