package android.support.v4.media;

/* loaded from: classes.dex */
class ParceledListSliceAdapterApi21 {
    private static java.lang.reflect.Constructor sConstructor;

    static {
        try {
            sConstructor = java.lang.Class.forName("android.content.pm.ParceledListSlice").getConstructor(java.util.List.class);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    static java.lang.Object newInstance(java.util.List<android.media.browse.MediaBrowser.MediaItem> list) {
        try {
            return sConstructor.newInstance(list);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    private ParceledListSliceAdapterApi21() {
    }
}
