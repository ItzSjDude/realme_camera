package androidx.core.p033e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import androidx.core.p027a.p028a.ResourcesCompat;
import androidx.core.p033e.SelfDestructiveThread;
import androidx.core.p035g.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class FontsContractCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    static final LruCache<String, Typeface> f2847a = new LruCache<>(16);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final SelfDestructiveThread f2850d = new SelfDestructiveThread("fonts", 10, 10000);

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final Object f2848b = new Object();

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3>>> f2849c = new SimpleArrayMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Comparator<byte[]> f2851e = new Comparator<byte[]>() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4.4
        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length != bArr2.length) {
                length = bArr.length;
                length2 = bArr2.length;
            } else {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
                    if (bArr[OplusGLSurfaceView_13] != bArr2[OplusGLSurfaceView_13]) {
                        length = bArr[OplusGLSurfaceView_13];
                        length2 = bArr2[OplusGLSurfaceView_13];
                    }
                }
                return 0;
            }
            return length - length2;
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    static IntrinsicsJvm.kt_3 m2459a(Context context, FontRequest c0445a, int OplusGLSurfaceView_13) {
        try {
            PlatformImplementations.kt_3 aVarM2458a = m2458a(context, (CancellationSignal) null, c0445a);
            if (aVarM2458a.m2468a() == 0) {
                Typeface typefaceM2609a = TypefaceCompat.m2609a(context, null, aVarM2458a.m2469b(), OplusGLSurfaceView_13);
                return new IntrinsicsJvm.kt_3(typefaceM2609a, typefaceM2609a != null ? 0 : -3);
            }
            return new IntrinsicsJvm.kt_3(null, aVarM2458a.m2468a() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new IntrinsicsJvm.kt_3(null, -1);
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    private static final class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Typeface f2866a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final int f2867b;

        IntrinsicsJvm.kt_3(Typeface typeface, int OplusGLSurfaceView_13) {
            this.f2866a = typeface;
            this.f2867b = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2457a(final Context context, final FontRequest c0445a, final ResourcesCompat.PlatformImplementations.kt_3 aVar, final Handler handler, boolean z, int OplusGLSurfaceView_13, final int i2) {
        final String str = c0445a.m2455f() + "-" + i2;
        Typeface typeface = f2847a.get(str);
        if (typeface != null) {
            if (aVar != null) {
                aVar.onFontRetrieved(typeface);
            }
            return typeface;
        }
        if (z && OplusGLSurfaceView_13 == -1) {
            IntrinsicsJvm.kt_3 cVarM2459a = m2459a(context, c0445a, i2);
            if (aVar != null) {
                if (cVarM2459a.f2867b == 0) {
                    aVar.callbackSuccessAsync(cVarM2459a.f2866a, handler);
                } else {
                    aVar.callbackFailAsync(cVarM2459a.f2867b, handler);
                }
            }
            return cVarM2459a.f2866a;
        }
        Callable<IntrinsicsJvm.kt_3> callable = new Callable<IntrinsicsJvm.kt_3>() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4.1
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public IntrinsicsJvm.kt_3 call() throws Exception {
                IntrinsicsJvm.kt_3 cVarM2459a2 = FontsContractCompat.m2459a(context, c0445a, i2);
                if (cVarM2459a2.f2866a != null) {
                    FontsContractCompat.f2847a.put(str, cVarM2459a2.f2866a);
                }
                return cVarM2459a2;
            }
        };
        if (z) {
            try {
                return ((IntrinsicsJvm.kt_3) f2850d.m2476a(callable, OplusGLSurfaceView_13)).f2866a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3> aVar2 = aVar == null ? null : new SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3>() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4.2
            @Override // androidx.core.p033e.SelfDestructiveThread.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2466a(IntrinsicsJvm.kt_3 cVar) {
                if (cVar == null) {
                    aVar.callbackFailAsync(1, handler);
                } else if (cVar.f2867b == 0) {
                    aVar.callbackSuccessAsync(cVar.f2866a, handler);
                } else {
                    aVar.callbackFailAsync(cVar.f2867b, handler);
                }
            }
        };
        synchronized (f2848b) {
            ArrayList<SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3>> arrayList = f2849c.get(str);
            if (arrayList != null) {
                if (aVar2 != null) {
                    arrayList.add(aVar2);
                }
                return null;
            }
            if (aVar2 != null) {
                ArrayList<SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3>> arrayList2 = new ArrayList<>();
                arrayList2.add(aVar2);
                f2849c.put(str, arrayList2);
            }
            f2850d.m2479a(callable, new SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3>() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4.3
                @Override // androidx.core.p033e.SelfDestructiveThread.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo2466a(IntrinsicsJvm.kt_3 cVar) {
                    synchronized (FontsContractCompat.f2848b) {
                        ArrayList<SelfDestructiveThread.PlatformImplementations.kt_3<IntrinsicsJvm.kt_3>> arrayList3 = FontsContractCompat.f2849c.get(str);
                        if (arrayList3 == null) {
                            return;
                        }
                        FontsContractCompat.f2849c.remove(str);
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            arrayList3.get(i3).mo2466a(cVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Uri f2861a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f2862b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f2863c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final boolean f2864d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f2865e;

        public IntrinsicsJvm.kt_4(Uri uri, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
            this.f2861a = (Uri) Preconditions.m2536a(uri);
            this.f2862b = OplusGLSurfaceView_13;
            this.f2863c = i2;
            this.f2864d = z;
            this.f2865e = i3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Uri m2470a() {
            return this.f2861a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m2471b() {
            return this.f2862b;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m2472c() {
            return this.f2863c;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m2473d() {
            return this.f2864d;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int m2474e() {
            return this.f2865e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f2859a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final IntrinsicsJvm.kt_4[] f2860b;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, IntrinsicsJvm.kt_4[] bVarArr) {
            this.f2859a = OplusGLSurfaceView_13;
            this.f2860b = bVarArr;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m2468a() {
            return this.f2859a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_4[] m2469b() {
            return this.f2860b;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Map<Uri, ByteBuffer> m2462a(Context context, IntrinsicsJvm.kt_4[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (IntrinsicsJvm.kt_4 bVar : bVarArr) {
            if (bVar.m2474e() == 0) {
                Uri uriM2470a = bVar.m2470a();
                if (!map.containsKey(uriM2470a)) {
                    map.put(uriM2470a, TypefaceCompatUtil.m2651a(context, cancellationSignal, uriM2470a));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 m2458a(Context context, CancellationSignal cancellationSignal, FontRequest c0445a) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoM2456a = m2456a(context.getPackageManager(), c0445a, context.getResources());
        if (providerInfoM2456a == null) {
            return new PlatformImplementations.kt_3(1, null);
        }
        return new PlatformImplementations.kt_3(0, m2464a(context, c0445a, providerInfoM2456a.authority, cancellationSignal));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ProviderInfo m2456a(PackageManager packageManager, FontRequest c0445a, Resources resources) throws PackageManager.NameNotFoundException {
        String strM2450a = c0445a.m2450a();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strM2450a, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strM2450a);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(c0445a.m2451b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strM2450a + ", but package was not " + c0445a.m2451b());
        }
        List<byte[]> listM2461a = m2461a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listM2461a, f2851e);
        List<List<byte[]>> listM2460a = m2460a(c0445a, resources);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM2460a.size(); OplusGLSurfaceView_13++) {
            ArrayList arrayList = new ArrayList(listM2460a.get(OplusGLSurfaceView_13));
            Collections.sort(arrayList, f2851e);
            if (m2463a(listM2461a, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<List<byte[]>> m2460a(FontRequest c0445a, Resources resources) {
        if (c0445a.m2453d() != null) {
            return c0445a.m2453d();
        }
        return FontResourcesParserCompat.m2275a(resources, c0445a.m2454e());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2463a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            if (!Arrays.equals(list.get(OplusGLSurfaceView_13), list2.get(OplusGLSurfaceView_13))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<byte[]> m2461a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static IntrinsicsJvm.kt_4[] m2464a(Context context, FontRequest c0445a, String str, CancellationSignal cancellationSignal) {
        Uri uriWithAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorQuery = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursorQuery = context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0445a.m2452c()}, null, cancellationSignal);
            } else {
                cursorQuery = context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0445a.m2452c()}, null);
            }
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    int OplusGLSurfaceView_13 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2));
                    } else {
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3));
                    }
                    arrayList2.add(new IntrinsicsJvm.kt_4(uriWithAppendedId, i2, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, OplusGLSurfaceView_13));
                }
                arrayList = arrayList2;
            }
            return (IntrinsicsJvm.kt_4[]) arrayList.toArray(new IntrinsicsJvm.kt_4[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
