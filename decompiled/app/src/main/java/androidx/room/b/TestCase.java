package androidx.room.b_renamed;

/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final java.lang.String f1581a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final java.util.Map<java.lang.String, androidx.room.b_renamed.e_renamed.a_renamed> f1582b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final java.util.Set<androidx.room.b_renamed.e_renamed.b_renamed> f1583c;
    public final java.util.Set<androidx.room.b_renamed.e_renamed.d_renamed> d_renamed;

    public e_renamed(java.lang.String str, java.util.Map<java.lang.String, androidx.room.b_renamed.e_renamed.a_renamed> map, java.util.Set<androidx.room.b_renamed.e_renamed.b_renamed> set, java.util.Set<androidx.room.b_renamed.e_renamed.d_renamed> set2) {
        this.f1581a = str;
        this.f1582b = java.util.Collections.unmodifiableMap(map);
        this.f1583c = java.util.Collections.unmodifiableSet(set);
        this.d_renamed = set2 == null ? null : java.util.Collections.unmodifiableSet(set2);
    }

    public boolean equals(java.lang.Object obj) {
        java.util.Set<androidx.room.b_renamed.e_renamed.d_renamed> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        androidx.room.b_renamed.e_renamed eVar = (androidx.room.b_renamed.e_renamed) obj;
        java.lang.String str = this.f1581a;
        if (str == null ? eVar.f1581a != null : !str.equals(eVar.f1581a)) {
            return false;
        }
        java.util.Map<java.lang.String, androidx.room.b_renamed.e_renamed.a_renamed> map = this.f1582b;
        if (map == null ? eVar.f1582b != null : !map.equals(eVar.f1582b)) {
            return false;
        }
        java.util.Set<androidx.room.b_renamed.e_renamed.b_renamed> set2 = this.f1583c;
        if (set2 == null ? eVar.f1583c != null : !set2.equals(eVar.f1583c)) {
            return false;
        }
        java.util.Set<androidx.room.b_renamed.e_renamed.d_renamed> set3 = this.d_renamed;
        if (set3 == null || (set = eVar.d_renamed) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        java.lang.String str = this.f1581a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.util.Map<java.lang.String, androidx.room.b_renamed.e_renamed.a_renamed> map = this.f1582b;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        java.util.Set<androidx.room.b_renamed.e_renamed.b_renamed> set = this.f1583c;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "TableInfo{name='" + this.f1581a + "', columns=" + this.f1582b + ", foreignKeys=" + this.f1583c + ", indices=" + this.d_renamed + '}';
    }

    public static androidx.room.b_renamed.e_renamed a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, java.lang.String str) {
        return new androidx.room.b_renamed.e_renamed(str, c_renamed(bVar, str), b_renamed(bVar, str), d_renamed(bVar, str));
    }

    private static java.util.Set<androidx.room.b_renamed.e_renamed.b_renamed> b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, java.lang.String str) {
        java.util.HashSet hashSet = new java.util.HashSet();
        android.database.Cursor cursorB = bVar.b_renamed("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorB.getColumnIndex(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID);
            int columnIndex2 = cursorB.getColumnIndex("seq");
            int columnIndex3 = cursorB.getColumnIndex("table");
            int columnIndex4 = cursorB.getColumnIndex("on_delete");
            int columnIndex5 = cursorB.getColumnIndex("on_update");
            java.util.List<androidx.room.b_renamed.e_renamed.c_renamed> listA = a_renamed(cursorB);
            int count = cursorB.getCount();
            for (int i_renamed = 0; i_renamed < count; i_renamed++) {
                cursorB.moveToPosition(i_renamed);
                if (cursorB.getInt(columnIndex2) == 0) {
                    int i2 = cursorB.getInt(columnIndex);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    for (androidx.room.b_renamed.e_renamed.c_renamed cVar : listA) {
                        if (cVar.f1590a == i2) {
                            arrayList.add(cVar.f1592c);
                            arrayList2.add(cVar.d_renamed);
                        }
                    }
                    hashSet.add(new androidx.room.b_renamed.e_renamed.b_renamed(cursorB.getString(columnIndex3), cursorB.getString(columnIndex4), cursorB.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            cursorB.close();
        }
    }

    private static java.util.List<androidx.room.b_renamed.e_renamed.c_renamed> a_renamed(android.database.Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < count; i_renamed++) {
            cursor.moveToPosition(i_renamed);
            arrayList.add(new androidx.room.b_renamed.e_renamed.c_renamed(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        java.util.Collections.sort(arrayList);
        return arrayList;
    }

    private static java.util.Map<java.lang.String, androidx.room.b_renamed.e_renamed.a_renamed> c_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, java.lang.String str) {
        android.database.Cursor cursorB = bVar.b_renamed("PRAGMA table_info(`" + str + "`)");
        java.util.HashMap map = new java.util.HashMap();
        try {
            if (cursorB.getColumnCount() > 0) {
                int columnIndex = cursorB.getColumnIndex("name");
                int columnIndex2 = cursorB.getColumnIndex(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE);
                int columnIndex3 = cursorB.getColumnIndex("notnull");
                int columnIndex4 = cursorB.getColumnIndex("pk");
                int columnIndex5 = cursorB.getColumnIndex("dflt_value");
                while (cursorB.moveToNext()) {
                    java.lang.String string = cursorB.getString(columnIndex);
                    map.put(string, new androidx.room.b_renamed.e_renamed.a_renamed(string, cursorB.getString(columnIndex2), cursorB.getInt(columnIndex3) != 0, cursorB.getInt(columnIndex4), cursorB.getString(columnIndex5), 2));
                }
            }
            return map;
        } finally {
            cursorB.close();
        }
    }

    private static java.util.Set<androidx.room.b_renamed.e_renamed.d_renamed> d_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, java.lang.String str) {
        android.database.Cursor cursorB = bVar.b_renamed("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorB.getColumnIndex("name");
            int columnIndex2 = cursorB.getColumnIndex(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_ORIGIN);
            int columnIndex3 = cursorB.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                java.util.HashSet hashSet = new java.util.HashSet();
                while (cursorB.moveToNext()) {
                    if ("c_renamed".equals(cursorB.getString(columnIndex2))) {
                        java.lang.String string = cursorB.getString(columnIndex);
                        boolean z_renamed = true;
                        if (cursorB.getInt(columnIndex3) != 1) {
                            z_renamed = false;
                        }
                        androidx.room.b_renamed.e_renamed.d_renamed dVarA = a_renamed(bVar, string, z_renamed);
                        if (dVarA == null) {
                            return null;
                        }
                        hashSet.add(dVarA);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            cursorB.close();
        }
    }

    private static androidx.room.b_renamed.e_renamed.d_renamed a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, java.lang.String str, boolean z_renamed) {
        android.database.Cursor cursorB = bVar.b_renamed("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorB.getColumnIndex("seqno");
            int columnIndex2 = cursorB.getColumnIndex("cid");
            int columnIndex3 = cursorB.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                java.util.TreeMap treeMap = new java.util.TreeMap();
                while (cursorB.moveToNext()) {
                    if (cursorB.getInt(columnIndex2) >= 0) {
                        treeMap.put(java.lang.Integer.valueOf(cursorB.getInt(columnIndex)), cursorB.getString(columnIndex3));
                    }
                }
                java.util.ArrayList arrayList = new java.util.ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new androidx.room.b_renamed.e_renamed.d_renamed(str, z_renamed, arrayList);
            }
            return null;
        } finally {
            cursorB.close();
        }
    }

    /* compiled from: TableInfo.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.lang.String f1584a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final java.lang.String f1585b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final int f1586c;
        public final boolean d_renamed;
        public final int e_renamed;
        public final java.lang.String f_renamed;
        private final int g_renamed;

        public a_renamed(java.lang.String str, java.lang.String str2, boolean z_renamed, int i_renamed, java.lang.String str3, int i2) {
            this.f1584a = str;
            this.f1585b = str2;
            this.d_renamed = z_renamed;
            this.e_renamed = i_renamed;
            this.f1586c = a_renamed(str2);
            this.f_renamed = str3;
            this.g_renamed = i2;
        }

        private static int a_renamed(java.lang.String str) {
            if (str == null) {
                return 5;
            }
            java.lang.String upperCase = str.toUpperCase(java.util.Locale.US);
            if (upperCase.contains(com.meicam.sdk.NvsFxDescription.ParamInfoObject.PARAM_TYPE_INT)) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains(com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_TEXT)) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(java.lang.Object obj) {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            androidx.room.b_renamed.e_renamed.a_renamed aVar = (androidx.room.b_renamed.e_renamed.a_renamed) obj;
            if (android.os.Build.VERSION.SDK_INT >= 20) {
                if (this.e_renamed != aVar.e_renamed) {
                    return false;
                }
            } else if (a_renamed() != aVar.a_renamed()) {
                return false;
            }
            if (!this.f1584a.equals(aVar.f1584a) || this.d_renamed != aVar.d_renamed) {
                return false;
            }
            if (this.g_renamed == 1 && aVar.g_renamed == 2 && (str3 = this.f_renamed) != null && !str3.equals(aVar.f_renamed)) {
                return false;
            }
            if (this.g_renamed == 2 && aVar.g_renamed == 1 && (str2 = aVar.f_renamed) != null && !str2.equals(this.f_renamed)) {
                return false;
            }
            int i_renamed = this.g_renamed;
            return (i_renamed == 0 || i_renamed != aVar.g_renamed || ((str = this.f_renamed) == null ? aVar.f_renamed == null : str.equals(aVar.f_renamed))) && this.f1586c == aVar.f1586c;
        }

        public boolean a_renamed() {
            return this.e_renamed > 0;
        }

        public int hashCode() {
            return (((((this.f1584a.hashCode() * 31) + this.f1586c) * 31) + (this.d_renamed ? 1231 : 1237)) * 31) + this.e_renamed;
        }

        public java.lang.String toString() {
            return "Column{name='" + this.f1584a + "', type='" + this.f1585b + "', affinity='" + this.f1586c + "', notNull=" + this.d_renamed + ", primaryKeyPosition=" + this.e_renamed + ", defaultValue='" + this.f_renamed + "'}";
        }
    }

    /* compiled from: TableInfo.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.lang.String f1587a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final java.lang.String f1588b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final java.lang.String f1589c;
        public final java.util.List<java.lang.String> d_renamed;
        public final java.util.List<java.lang.String> e_renamed;

        public b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
            this.f1587a = str;
            this.f1588b = str2;
            this.f1589c = str3;
            this.d_renamed = java.util.Collections.unmodifiableList(list);
            this.e_renamed = java.util.Collections.unmodifiableList(list2);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            androidx.room.b_renamed.e_renamed.b_renamed bVar = (androidx.room.b_renamed.e_renamed.b_renamed) obj;
            if (this.f1587a.equals(bVar.f1587a) && this.f1588b.equals(bVar.f1588b) && this.f1589c.equals(bVar.f1589c) && this.d_renamed.equals(bVar.d_renamed)) {
                return this.e_renamed.equals(bVar.e_renamed);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f1587a.hashCode() * 31) + this.f1588b.hashCode()) * 31) + this.f1589c.hashCode()) * 31) + this.d_renamed.hashCode()) * 31) + this.e_renamed.hashCode();
        }

        public java.lang.String toString() {
            return "ForeignKey{referenceTable='" + this.f1587a + "', onDelete='" + this.f1588b + "', onUpdate='" + this.f1589c + "', columnNames=" + this.d_renamed + ", referenceColumnNames=" + this.e_renamed + '}';
        }
    }

    /* compiled from: TableInfo.java */
    static class c_renamed implements java.lang.Comparable<androidx.room.b_renamed.e_renamed.c_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        final int f1590a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final int f1591b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final java.lang.String f1592c;
        final java.lang.String d_renamed;

        c_renamed(int i_renamed, int i2, java.lang.String str, java.lang.String str2) {
            this.f1590a = i_renamed;
            this.f1591b = i2;
            this.f1592c = str;
            this.d_renamed = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compareTo(androidx.room.b_renamed.e_renamed.c_renamed cVar) {
            int i_renamed = this.f1590a - cVar.f1590a;
            return i_renamed == 0 ? this.f1591b - cVar.f1591b : i_renamed;
        }
    }

    /* compiled from: TableInfo.java */
    public static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.lang.String f1593a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final boolean f1594b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final java.util.List<java.lang.String> f1595c;

        public d_renamed(java.lang.String str, boolean z_renamed, java.util.List<java.lang.String> list) {
            this.f1593a = str;
            this.f1594b = z_renamed;
            this.f1595c = list;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            androidx.room.b_renamed.e_renamed.d_renamed dVar = (androidx.room.b_renamed.e_renamed.d_renamed) obj;
            if (this.f1594b != dVar.f1594b || !this.f1595c.equals(dVar.f1595c)) {
                return false;
            }
            if (this.f1593a.startsWith("index_")) {
                return dVar.f1593a.startsWith("index_");
            }
            return this.f1593a.equals(dVar.f1593a);
        }

        public int hashCode() {
            int iHashCode;
            if (this.f1593a.startsWith("index_")) {
                iHashCode = "index_".hashCode();
            } else {
                iHashCode = this.f1593a.hashCode();
            }
            return (((iHashCode * 31) + (this.f1594b ? 1 : 0)) * 31) + this.f1595c.hashCode();
        }

        public java.lang.String toString() {
            return "Index{name='" + this.f1593a + "', unique=" + this.f1594b + ", columns=" + this.f1595c + '}';
        }
    }
}
