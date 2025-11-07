package androidx.room.p054b;

import android.database.Cursor;
import android.os.Build;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meicam.sdk.NvsFxDescription;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.tblplayer.misc.MediaInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class TableInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    public final String f4353a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Map<String, PlatformImplementations.kt_3> f4354b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final Set<IntrinsicsJvm.kt_4> f4355c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final Set<IntrinsicsJvm.kt_5> f4356d;

    public TableInfo(String str, Map<String, PlatformImplementations.kt_3> map, Set<IntrinsicsJvm.kt_4> set, Set<IntrinsicsJvm.kt_5> set2) {
        this.f4353a = str;
        this.f4354b = Collections.unmodifiableMap(map);
        this.f4355c = Collections.unmodifiableSet(set);
        this.f4356d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public boolean equals(Object obj) {
        Set<IntrinsicsJvm.kt_5> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo c0745e = (TableInfo) obj;
        String str = this.f4353a;
        if (str == null ? c0745e.f4353a != null : !str.equals(c0745e.f4353a)) {
            return false;
        }
        Map<String, PlatformImplementations.kt_3> map = this.f4354b;
        if (map == null ? c0745e.f4354b != null : !map.equals(c0745e.f4354b)) {
            return false;
        }
        Set<IntrinsicsJvm.kt_4> set2 = this.f4355c;
        if (set2 == null ? c0745e.f4355c != null : !set2.equals(c0745e.f4355c)) {
            return false;
        }
        Set<IntrinsicsJvm.kt_5> set3 = this.f4356d;
        if (set3 == null || (set = c0745e.f4356d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f4353a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, PlatformImplementations.kt_3> map = this.f4354b;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<IntrinsicsJvm.kt_4> set = this.f4355c;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f4353a + "', columns=" + this.f4354b + ", foreignKeys=" + this.f4355c + ", indices=" + this.f4356d + '}';
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static TableInfo m4600a(SupportSQLiteDatabase interfaceC0561b, String str) {
        return new TableInfo(str, m4603c(interfaceC0561b, str), m4602b(interfaceC0561b, str), m4604d(interfaceC0561b, str));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Set<IntrinsicsJvm.kt_4> m4602b(SupportSQLiteDatabase interfaceC0561b, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorMo3255b.getColumnIndex(TtmlNode.ATTR_ID);
            int columnIndex2 = cursorMo3255b.getColumnIndex("seq");
            int columnIndex3 = cursorMo3255b.getColumnIndex("table");
            int columnIndex4 = cursorMo3255b.getColumnIndex("on_delete");
            int columnIndex5 = cursorMo3255b.getColumnIndex("on_update");
            List<IntrinsicsJvm.kt_3> listM4601a = m4601a(cursorMo3255b);
            int count = cursorMo3255b.getCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < count; OplusGLSurfaceView_13++) {
                cursorMo3255b.moveToPosition(OplusGLSurfaceView_13);
                if (cursorMo3255b.getInt(columnIndex2) == 0) {
                    int i2 = cursorMo3255b.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (IntrinsicsJvm.kt_3 cVar : listM4601a) {
                        if (cVar.f4369a == i2) {
                            arrayList.add(cVar.f4371c);
                            arrayList2.add(cVar.f4372d);
                        }
                    }
                    hashSet.add(new IntrinsicsJvm.kt_4(cursorMo3255b.getString(columnIndex3), cursorMo3255b.getString(columnIndex4), cursorMo3255b.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            cursorMo3255b.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<IntrinsicsJvm.kt_3> m4601a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(TtmlNode.ATTR_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < count; OplusGLSurfaceView_13++) {
            cursor.moveToPosition(OplusGLSurfaceView_13);
            arrayList.add(new IntrinsicsJvm.kt_3(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Map<String, PlatformImplementations.kt_3> m4603c(SupportSQLiteDatabase interfaceC0561b, String str) {
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("PRAGMA table_info(`" + str + "`)");
        HashMap map = new HashMap();
        try {
            if (cursorMo3255b.getColumnCount() > 0) {
                int columnIndex = cursorMo3255b.getColumnIndex("name");
                int columnIndex2 = cursorMo3255b.getColumnIndex(CameraParameter.TiltShiftParamKeys.TYPE);
                int columnIndex3 = cursorMo3255b.getColumnIndex("notnull");
                int columnIndex4 = cursorMo3255b.getColumnIndex("pk");
                int columnIndex5 = cursorMo3255b.getColumnIndex("dflt_value");
                while (cursorMo3255b.moveToNext()) {
                    String string = cursorMo3255b.getString(columnIndex);
                    map.put(string, new PlatformImplementations.kt_3(string, cursorMo3255b.getString(columnIndex2), cursorMo3255b.getInt(columnIndex3) != 0, cursorMo3255b.getInt(columnIndex4), cursorMo3255b.getString(columnIndex5), 2));
                }
            }
            return map;
        } finally {
            cursorMo3255b.close();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Set<IntrinsicsJvm.kt_5> m4604d(SupportSQLiteDatabase interfaceC0561b, String str) {
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorMo3255b.getColumnIndex("name");
            int columnIndex2 = cursorMo3255b.getColumnIndex(TtmlNode.ATTR_TTS_ORIGIN);
            int columnIndex3 = cursorMo3255b.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (cursorMo3255b.moveToNext()) {
                    if ("IntrinsicsJvm.kt_3".equals(cursorMo3255b.getString(columnIndex2))) {
                        String string = cursorMo3255b.getString(columnIndex);
                        boolean z = true;
                        if (cursorMo3255b.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        IntrinsicsJvm.kt_5 dVarM4599a = m4599a(interfaceC0561b, string, z);
                        if (dVarM4599a == null) {
                            return null;
                        }
                        hashSet.add(dVarM4599a);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            cursorMo3255b.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static IntrinsicsJvm.kt_5 m4599a(SupportSQLiteDatabase interfaceC0561b, String str, boolean z) {
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorMo3255b.getColumnIndex("seqno");
            int columnIndex2 = cursorMo3255b.getColumnIndex("cid");
            int columnIndex3 = cursorMo3255b.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (cursorMo3255b.moveToNext()) {
                    if (cursorMo3255b.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(cursorMo3255b.getInt(columnIndex)), cursorMo3255b.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new IntrinsicsJvm.kt_5(str, z, arrayList);
            }
            return null;
        } finally {
            cursorMo3255b.close();
        }
    }

    /* compiled from: TableInfo.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final String f4357a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final String f4358b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final int f4359c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public final boolean f4360d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public final int f4361e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public final String f4362f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final int f4363g;

        public PlatformImplementations.kt_3(String str, String str2, boolean z, int OplusGLSurfaceView_13, String str3, int i2) {
            this.f4357a = str;
            this.f4358b = str2;
            this.f4360d = z;
            this.f4361e = OplusGLSurfaceView_13;
            this.f4359c = m4605a(str2);
            this.f4362f = str3;
            this.f4363g = i2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static int m4605a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains(NvsFxDescription.ParamInfoObject.PARAM_TYPE_INT)) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains(MediaInfo.RENDERER_TYPE_TEXT)) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f4361e != aVar.f4361e) {
                    return false;
                }
            } else if (m4606a() != aVar.m4606a()) {
                return false;
            }
            if (!this.f4357a.equals(aVar.f4357a) || this.f4360d != aVar.f4360d) {
                return false;
            }
            if (this.f4363g == 1 && aVar.f4363g == 2 && (str3 = this.f4362f) != null && !str3.equals(aVar.f4362f)) {
                return false;
            }
            if (this.f4363g == 2 && aVar.f4363g == 1 && (str2 = aVar.f4362f) != null && !str2.equals(this.f4362f)) {
                return false;
            }
            int OplusGLSurfaceView_13 = this.f4363g;
            return (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 != aVar.f4363g || ((str = this.f4362f) == null ? aVar.f4362f == null : str.equals(aVar.f4362f))) && this.f4359c == aVar.f4359c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4606a() {
            return this.f4361e > 0;
        }

        public int hashCode() {
            return (((((this.f4357a.hashCode() * 31) + this.f4359c) * 31) + (this.f4360d ? 1231 : 1237)) * 31) + this.f4361e;
        }

        public String toString() {
            return "Column{name='" + this.f4357a + "', type='" + this.f4358b + "', affinity='" + this.f4359c + "', notNull=" + this.f4360d + ", primaryKeyPosition=" + this.f4361e + ", defaultValue='" + this.f4362f + "'}";
        }
    }

    /* compiled from: TableInfo.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final String f4364a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final String f4365b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final String f4366c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public final List<String> f4367d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public final List<String> f4368e;

        public IntrinsicsJvm.kt_4(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f4364a = str;
            this.f4365b = str2;
            this.f4366c = str3;
            this.f4367d = Collections.unmodifiableList(list);
            this.f4368e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) obj;
            if (this.f4364a.equals(bVar.f4364a) && this.f4365b.equals(bVar.f4365b) && this.f4366c.equals(bVar.f4366c) && this.f4367d.equals(bVar.f4367d)) {
                return this.f4368e.equals(bVar.f4368e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f4364a.hashCode() * 31) + this.f4365b.hashCode()) * 31) + this.f4366c.hashCode()) * 31) + this.f4367d.hashCode()) * 31) + this.f4368e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f4364a + "', onDelete='" + this.f4365b + "', onUpdate='" + this.f4366c + "', columnNames=" + this.f4367d + ", referenceColumnNames=" + this.f4368e + '}';
        }
    }

    /* compiled from: TableInfo.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 implements Comparable<IntrinsicsJvm.kt_3> {

        /* renamed from: PlatformImplementations.kt_3 */
        final int f4369a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final int f4370b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final String f4371c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final String f4372d;

        IntrinsicsJvm.kt_3(int OplusGLSurfaceView_13, int i2, String str, String str2) {
            this.f4369a = OplusGLSurfaceView_13;
            this.f4370b = i2;
            this.f4371c = str;
            this.f4372d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compareTo(IntrinsicsJvm.kt_3 cVar) {
            int OplusGLSurfaceView_13 = this.f4369a - cVar.f4369a;
            return OplusGLSurfaceView_13 == 0 ? this.f4370b - cVar.f4370b : OplusGLSurfaceView_13;
        }
    }

    /* compiled from: TableInfo.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final String f4373a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final boolean f4374b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final List<String> f4375c;

        public IntrinsicsJvm.kt_5(String str, boolean z, List<String> list) {
            this.f4373a = str;
            this.f4374b = z;
            this.f4375c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IntrinsicsJvm.kt_5 dVar = (IntrinsicsJvm.kt_5) obj;
            if (this.f4374b != dVar.f4374b || !this.f4375c.equals(dVar.f4375c)) {
                return false;
            }
            if (this.f4373a.startsWith("index_")) {
                return dVar.f4373a.startsWith("index_");
            }
            return this.f4373a.equals(dVar.f4373a);
        }

        public int hashCode() {
            int iHashCode;
            if (this.f4373a.startsWith("index_")) {
                iHashCode = "index_".hashCode();
            } else {
                iHashCode = this.f4373a.hashCode();
            }
            return (((iHashCode * 31) + (this.f4374b ? 1 : 0)) * 31) + this.f4375c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f4373a + "', unique=" + this.f4374b + ", columns=" + this.f4375c + '}';
        }
    }
}
