package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static androidx.media.c_renamed read(androidx.versionedparcelable.a_renamed aVar) {
        androidx.media.c_renamed cVar = new androidx.media.c_renamed();
        cVar.f1273a = aVar.b_renamed(cVar.f1273a, 1);
        cVar.f1274b = aVar.b_renamed(cVar.f1274b, 2);
        cVar.f1275c = aVar.b_renamed(cVar.f1275c, 3);
        cVar.d_renamed = aVar.b_renamed(cVar.d_renamed, 4);
        return cVar;
    }

    public static void write(androidx.media.c_renamed cVar, androidx.versionedparcelable.a_renamed aVar) {
        aVar.a_renamed(false, false);
        aVar.a_renamed(cVar.f1273a, 1);
        aVar.a_renamed(cVar.f1274b, 2);
        aVar.a_renamed(cVar.f1275c, 3);
        aVar.a_renamed(cVar.d_renamed, 4);
    }
}
