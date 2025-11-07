package androidx.core.e_renamed;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> f858a = new androidx.collection.LruCache<>(16);
    private static final androidx.core.e_renamed.c_renamed d_renamed = new androidx.core.e_renamed.c_renamed("fonts", 10, 10000);

    /* renamed from: b_renamed, reason: collision with root package name */
    static final java.lang.Object f859b = new java.lang.Object();

    /* renamed from: c_renamed, reason: collision with root package name */
    static final androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed>>> f860c = new androidx.collection.SimpleArrayMap<>();
    private static final java.util.Comparator<byte[]> e_renamed = new java.util.Comparator<byte[]>() { // from class: androidx.core.e_renamed.b_renamed.4
        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length != bArr2.length) {
                length = bArr.length;
                length2 = bArr2.length;
            } else {
                for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
                    if (bArr[i_renamed] != bArr2[i_renamed]) {
                        length = bArr[i_renamed];
                        length2 = bArr2[i_renamed];
                    }
                }
                return 0;
            }
            return length - length2;
        }
    };

    static androidx.core.e_renamed.b_renamed.c_renamed a_renamed(android.content.Context context, androidx.core.e_renamed.a_renamed aVar, int i_renamed) {
        try {
            androidx.core.e_renamed.b_renamed.a_renamed aVarA = a_renamed(context, (android.os.CancellationSignal) null, aVar);
            if (aVarA.a_renamed() == 0) {
                android.graphics.Typeface typefaceA = androidx.core.graphics.f_renamed.a_renamed(context, null, aVarA.b_renamed(), i_renamed);
                return new androidx.core.e_renamed.b_renamed.c_renamed(typefaceA, typefaceA != null ? 0 : -3);
            }
            return new androidx.core.e_renamed.b_renamed.c_renamed(null, aVarA.a_renamed() == 1 ? -2 : -3);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return new androidx.core.e_renamed.b_renamed.c_renamed(null, -1);
        }
    }

    /* compiled from: FontsContractCompat.java */
    private static final class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.graphics.Typeface f872a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final int f873b;

        c_renamed(android.graphics.Typeface typeface, int i_renamed) {
            this.f872a = typeface;
            this.f873b = i_renamed;
        }
    }

    public static android.graphics.Typeface a_renamed(final android.content.Context context, final androidx.core.e_renamed.a_renamed aVar, final androidx.core.a_renamed.a_renamed.f_renamed.a_renamed aVar2, final android.os.Handler handler, boolean z_renamed, int i_renamed, final int i2) {
        final java.lang.String str = aVar.f_renamed() + "-" + i2;
        android.graphics.Typeface typeface = f858a.get(str);
        if (typeface != null) {
            if (aVar2 != null) {
                aVar2.onFontRetrieved(typeface);
            }
            return typeface;
        }
        if (z_renamed && i_renamed == -1) {
            androidx.core.e_renamed.b_renamed.c_renamed cVarA = a_renamed(context, aVar, i2);
            if (aVar2 != null) {
                if (cVarA.f873b == 0) {
                    aVar2.callbackSuccessAsync(cVarA.f872a, handler);
                } else {
                    aVar2.callbackFailAsync(cVarA.f873b, handler);
                }
            }
            return cVarA.f872a;
        }
        java.util.concurrent.Callable<androidx.core.e_renamed.b_renamed.c_renamed> callable = new java.util.concurrent.Callable<androidx.core.e_renamed.b_renamed.c_renamed>() { // from class: androidx.core.e_renamed.b_renamed.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.core.e_renamed.b_renamed.c_renamed call() throws java.lang.Exception {
                androidx.core.e_renamed.b_renamed.c_renamed cVarA2 = androidx.core.e_renamed.b_renamed.a_renamed(context, aVar, i2);
                if (cVarA2.f872a != null) {
                    androidx.core.e_renamed.b_renamed.f858a.put(str, cVarA2.f872a);
                }
                return cVarA2;
            }
        };
        if (z_renamed) {
            try {
                return ((androidx.core.e_renamed.b_renamed.c_renamed) d_renamed.a_renamed(callable, i_renamed)).f872a;
            } catch (java.lang.InterruptedException unused) {
                return null;
            }
        }
        androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed> aVar3 = aVar2 == null ? null : new androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed>() { // from class: androidx.core.e_renamed.b_renamed.2
            @Override // androidx.core.e_renamed.c_renamed.a_renamed
            public void a_renamed(androidx.core.e_renamed.b_renamed.c_renamed cVar) {
                if (cVar == null) {
                    aVar2.callbackFailAsync(1, handler);
                } else if (cVar.f873b == 0) {
                    aVar2.callbackSuccessAsync(cVar.f872a, handler);
                } else {
                    aVar2.callbackFailAsync(cVar.f873b, handler);
                }
            }
        };
        synchronized (f859b) {
            java.util.ArrayList<androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed>> arrayList = f860c.get(str);
            if (arrayList != null) {
                if (aVar3 != null) {
                    arrayList.add(aVar3);
                }
                return null;
            }
            if (aVar3 != null) {
                java.util.ArrayList<androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed>> arrayList2 = new java.util.ArrayList<>();
                arrayList2.add(aVar3);
                f860c.put(str, arrayList2);
            }
            d_renamed.a_renamed(callable, new androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed>() { // from class: androidx.core.e_renamed.b_renamed.3
                @Override // androidx.core.e_renamed.c_renamed.a_renamed
                public void a_renamed(androidx.core.e_renamed.b_renamed.c_renamed cVar) {
                    synchronized (androidx.core.e_renamed.b_renamed.f859b) {
                        java.util.ArrayList<androidx.core.e_renamed.c_renamed.a_renamed<androidx.core.e_renamed.b_renamed.c_renamed>> arrayList3 = androidx.core.e_renamed.b_renamed.f860c.get(str);
                        if (arrayList3 == null) {
                            return;
                        }
                        androidx.core.e_renamed.b_renamed.f860c.remove(str);
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            arrayList3.get(i3).a_renamed(cVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.e_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    public static class FontsContractCompat_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.net.Uri f869a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f870b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f871c;
        private final boolean d_renamed;
        private final int e_renamed;

        public FontsContractCompat_3(android.net.Uri uri, int i_renamed, int i2, boolean z_renamed, int i3) {
            this.f869a = (android.net.Uri) androidx.core.g_renamed.f_renamed.a_renamed(uri);
            this.f870b = i_renamed;
            this.f871c = i2;
            this.d_renamed = z_renamed;
            this.e_renamed = i3;
        }

        public android.net.Uri a_renamed() {
            return this.f869a;
        }

        public int b_renamed() {
            return this.f870b;
        }

        public int c_renamed() {
            return this.f871c;
        }

        public boolean d_renamed() {
            return this.d_renamed;
        }

        public int e_renamed() {
            return this.e_renamed;
        }
    }

    /* compiled from: FontsContractCompat.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final int f867a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] f868b;

        public a_renamed(int i_renamed, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] c0016bArr) {
            this.f867a = i_renamed;
            this.f868b = c0016bArr;
        }

        public int a_renamed() {
            return this.f867a;
        }

        public androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] b_renamed() {
            return this.f868b;
        }
    }

    public static java.util.Map<android.net.Uri, java.nio.ByteBuffer> a_renamed(android.content.Context context, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] c0016bArr, android.os.CancellationSignal cancellationSignal) {
        java.util.HashMap map = new java.util.HashMap();
        for (androidx.core.e_renamed.b_renamed.FontsContractCompat_3 c0016b : c0016bArr) {
            if (c0016b.e_renamed() == 0) {
                android.net.Uri uriA = c0016b.a_renamed();
                if (!map.containsKey(uriA)) {
                    map.put(uriA, androidx.core.graphics.m_renamed.a_renamed(context, cancellationSignal, uriA));
                }
            }
        }
        return java.util.Collections.unmodifiableMap(map);
    }

    public static androidx.core.e_renamed.b_renamed.a_renamed a_renamed(android.content.Context context, android.os.CancellationSignal cancellationSignal, androidx.core.e_renamed.a_renamed aVar) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ProviderInfo providerInfoA = a_renamed(context.getPackageManager(), aVar, context.getResources());
        if (providerInfoA == null) {
            return new androidx.core.e_renamed.b_renamed.a_renamed(1, null);
        }
        return new androidx.core.e_renamed.b_renamed.a_renamed(0, a_renamed(context, aVar, providerInfoA.authority, cancellationSignal));
    }

    public static android.content.pm.ProviderInfo a_renamed(android.content.pm.PackageManager packageManager, androidx.core.e_renamed.a_renamed aVar, android.content.res.Resources resources) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String strA = aVar.a_renamed();
        android.content.pm.ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strA, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new android.content.pm.PackageManager.NameNotFoundException("No package found for authority: " + strA);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(aVar.b_renamed())) {
            throw new android.content.pm.PackageManager.NameNotFoundException("Found content provider " + strA + ", but package was not " + aVar.b_renamed());
        }
        java.util.List<byte[]> listA = a_renamed(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        java.util.Collections.sort(listA, e_renamed);
        java.util.List<java.util.List<byte[]>> listA2 = a_renamed(aVar, resources);
        for (int i_renamed = 0; i_renamed < listA2.size(); i_renamed++) {
            java.util.ArrayList arrayList = new java.util.ArrayList(listA2.get(i_renamed));
            java.util.Collections.sort(arrayList, e_renamed);
            if (a_renamed(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    private static java.util.List<java.util.List<byte[]>> a_renamed(androidx.core.e_renamed.a_renamed aVar, android.content.res.Resources resources) {
        if (aVar.d_renamed() != null) {
            return aVar.d_renamed();
        }
        return androidx.core.a_renamed.a_renamed.c_renamed.a_renamed(resources, aVar.e_renamed());
    }

    private static boolean a_renamed(java.util.List<byte[]> list, java.util.List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            if (!java.util.Arrays.equals(list.get(i_renamed), list2.get(i_renamed))) {
                return false;
            }
        }
        return true;
    }

    private static java.util.List<byte[]> a_renamed(android.content.pm.Signature[] signatureArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.content.pm.Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    static androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] a_renamed(android.content.Context context, androidx.core.e_renamed.a_renamed aVar, java.lang.String str, android.os.CancellationSignal cancellationSignal) {
        android.net.Uri uriWithAppendedId;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.net.Uri uriBuild = new android.net.Uri.Builder().scheme("content").authority(str).build();
        android.net.Uri uriBuild2 = new android.net.Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        android.database.Cursor cursorQuery = null;
        try {
            if (android.os.Build.VERSION.SDK_INT > 16) {
                cursorQuery = context.getContentResolver().query(uriBuild, new java.lang.String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new java.lang.String[]{aVar.c_renamed()}, null, cancellationSignal);
            } else {
                cursorQuery = context.getContentResolver().query(uriBuild, new java.lang.String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new java.lang.String[]{aVar.c_renamed()}, null);
            }
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    int i_renamed = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uriWithAppendedId = android.content.ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2));
                    } else {
                        uriWithAppendedId = android.content.ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3));
                    }
                    arrayList2.add(new androidx.core.e_renamed.b_renamed.FontsContractCompat_3(uriWithAppendedId, i2, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i_renamed));
                }
                arrayList = arrayList2;
            }
            return (androidx.core.e_renamed.b_renamed.FontsContractCompat_3[]) arrayList.toArray(new androidx.core.e_renamed.b_renamed.FontsContractCompat_3[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
