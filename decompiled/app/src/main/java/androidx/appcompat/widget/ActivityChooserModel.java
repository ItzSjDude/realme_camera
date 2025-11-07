package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ActivityChooserModel.java */
/* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {

    /* renamed from: PlatformImplementations.kt_3 */
    static final String f1923a = "IntrinsicsJvm.kt_3";

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Object f1924e = new Object();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final Map<String, ActivityChooserModel> f1925f = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Context f1926b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final String f1927c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f1928d;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Object f1929g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final List<PlatformImplementations.kt_3> f1930h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final List<IntrinsicsJvm.kt_3> f1931i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Intent f1932j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_4 f1933k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f1934l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f1935m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f1936n;

    /* renamed from: o */
    private boolean f1937o;

    /* renamed from: p */
    private IntrinsicsJvm.kt_5 f1938p;

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m1641a(Intent intent, List<PlatformImplementations.kt_3> list, List<IntrinsicsJvm.kt_3> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m1642a(ActivityChooserModel c0331c, Intent intent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1634a() {
        int size;
        synchronized (this.f1929g) {
            m1628d();
            size = this.f1930h.size();
        }
        return size;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ResolveInfo m1636a(int OplusGLSurfaceView_13) {
        ResolveInfo resolveInfo;
        synchronized (this.f1929g) {
            m1628d();
            resolveInfo = this.f1930h.get(OplusGLSurfaceView_13).f1939a;
        }
        return resolveInfo;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1635a(ResolveInfo resolveInfo) {
        synchronized (this.f1929g) {
            m1628d();
            List<PlatformImplementations.kt_3> list = this.f1930h;
            int size = list.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                if (list.get(OplusGLSurfaceView_13).f1939a == resolveInfo) {
                    return OplusGLSurfaceView_13;
                }
            }
            return -1;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Intent m1637b(int OplusGLSurfaceView_13) {
        synchronized (this.f1929g) {
            if (this.f1932j == null) {
                return null;
            }
            m1628d();
            PlatformImplementations.kt_3 aVar = this.f1930h.get(OplusGLSurfaceView_13);
            ComponentName componentName = new ComponentName(aVar.f1939a.activityInfo.packageName, aVar.f1939a.activityInfo.name);
            Intent intent = new Intent(this.f1932j);
            intent.setComponent(componentName);
            if (this.f1938p != null) {
                if (this.f1938p.m1642a(this, new Intent(intent))) {
                    return null;
                }
            }
            m1626a(new IntrinsicsJvm.kt_3(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ResolveInfo m1638b() {
        synchronized (this.f1929g) {
            m1628d();
            if (this.f1930h.isEmpty()) {
                return null;
            }
            return this.f1930h.get(0).f1939a;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1639c(int OplusGLSurfaceView_13) {
        synchronized (this.f1929g) {
            m1628d();
            PlatformImplementations.kt_3 aVar = this.f1930h.get(OplusGLSurfaceView_13);
            PlatformImplementations.kt_3 aVar2 = this.f1930h.get(0);
            m1626a(new IntrinsicsJvm.kt_3(new ComponentName(aVar.f1939a.activityInfo.packageName, aVar.f1939a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1940b - aVar.f1940b) + 5.0f : 1.0f));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m1627c() {
        if (!this.f1935m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f1936n) {
            this.f1936n = false;
            if (TextUtils.isEmpty(this.f1927c)) {
                return;
            }
            new COUIBaseListPopupWindow_8().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f1931i), this.f1927c);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m1628d() {
        boolean zM1630f = m1630f() | m1631g();
        m1632h();
        if (zM1630f) {
            m1629e();
            notifyChanged();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m1629e() {
        if (this.f1933k == null || this.f1932j == null || this.f1930h.isEmpty() || this.f1931i.isEmpty()) {
            return false;
        }
        this.f1933k.m1641a(this.f1932j, this.f1930h, Collections.unmodifiableList(this.f1931i));
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m1630f() {
        if (!this.f1937o || this.f1932j == null) {
            return false;
        }
        this.f1937o = false;
        this.f1930h.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f1926b.getPackageManager().queryIntentActivities(this.f1932j, 0);
        int size = listQueryIntentActivities.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f1930h.add(new PlatformImplementations.kt_3(listQueryIntentActivities.get(OplusGLSurfaceView_13)));
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m1631g() throws IOException {
        if (!this.f1928d || !this.f1936n || TextUtils.isEmpty(this.f1927c)) {
            return false;
        }
        this.f1928d = false;
        this.f1935m = true;
        m1633i();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1626a(IntrinsicsJvm.kt_3 cVar) {
        boolean zAdd = this.f1931i.add(cVar);
        if (zAdd) {
            this.f1936n = true;
            m1632h();
            m1627c();
            m1629e();
            notifyChanged();
        }
        return zAdd;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m1632h() {
        int size = this.f1931i.size() - this.f1934l;
        if (size <= 0) {
            return;
        }
        this.f1936n = true;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f1931i.remove(0);
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final ComponentName f1941a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final long f1942b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final float f1943c;

        public IntrinsicsJvm.kt_3(String str, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
            this(ComponentName.unflattenFromString(str), OplusGLSurfaceView_15, COUIBaseListPopupWindow_12);
        }

        public IntrinsicsJvm.kt_3(ComponentName componentName, long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
            this.f1941a = componentName;
            this.f1942b = OplusGLSurfaceView_15;
            this.f1943c = COUIBaseListPopupWindow_12;
        }

        public int hashCode() {
            ComponentName componentName = this.f1941a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long OplusGLSurfaceView_15 = this.f1942b;
            return ((((iHashCode + 31) * 31) + ((int) (OplusGLSurfaceView_15 ^ (OplusGLSurfaceView_15 >>> 32)))) * 31) + Float.floatToIntBits(this.f1943c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IntrinsicsJvm.kt_3 cVar = (IntrinsicsJvm.kt_3) obj;
            ComponentName componentName = this.f1941a;
            if (componentName == null) {
                if (cVar.f1941a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.f1941a)) {
                return false;
            }
            return this.f1942b == cVar.f1942b && Float.floatToIntBits(this.f1943c) == Float.floatToIntBits(cVar.f1943c);
        }

        public String toString() {
            return "[; activity:" + this.f1941a + "; time:" + this.f1942b + "; weight:" + new BigDecimal(this.f1943c) + "]";
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 implements Comparable<PlatformImplementations.kt_3> {

        /* renamed from: PlatformImplementations.kt_3 */
        public final ResolveInfo f1939a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float f1940b;

        public PlatformImplementations.kt_3(ResolveInfo resolveInfo) {
            this.f1939a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1940b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1940b) == Float.floatToIntBits(((PlatformImplementations.kt_3) obj).f1940b);
        }

        @Override // java.lang.Comparable
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compareTo(PlatformImplementations.kt_3 aVar) {
            return Float.floatToIntBits(aVar.f1940b) - Float.floatToIntBits(this.f1940b);
        }

        public String toString() {
            return "[resolveInfo:" + this.f1939a.toString() + "; weight:" + new BigDecimal(this.f1940b) + "]";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return;
     */
    /* renamed from: OplusGLSurfaceView_13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1633i() throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "Error reading historical recrod file: "
            android.content.Context r1 = r10.f1926b     // Catch: java.io.FileNotFoundException -> Lc2
            java.lang.String r2 = r10.f1927c     // Catch: java.io.FileNotFoundException -> Lc2
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> Lc2
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r3 = "UTF-8"
            r2.setInput(r1, r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            r3 = 0
        L14:
            r4 = 1
            if (r3 == r4) goto L1f
            r5 = 2
            if (r3 == r5) goto L1f
            int r3 = r2.next()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            goto L14
        L1f:
            java.lang.String r3 = "historical-records"
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            boolean r3 = r3.equals(r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            if (r3 == 0) goto L7c
            java.util.List<androidx.appcompat.widget.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3> r3 = r10.f1931i     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            r3.clear()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
        L30:
            int r5 = r2.next()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            if (r5 != r4) goto L3d
            if (r1 == 0) goto Lbb
        L38:
            r1.close()     // Catch: java.io.IOException -> Lbb
            goto Lbb
        L3d:
            r6 = 3
            if (r5 == r6) goto L30
            r6 = 4
            if (r5 != r6) goto L44
            goto L30
        L44:
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r6 = "historical-record"
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            if (r5 == 0) goto L74
            java.lang.String r5 = "activity"
            r6 = 0
            java.lang.String r5 = r2.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r7 = "time"
            java.lang.String r7 = r2.getAttributeValue(r6, r7)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            long r7 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r9 = "weight"
            java.lang.String r6 = r2.getAttributeValue(r6, r9)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            androidx.appcompat.widget.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 r9 = new androidx.appcompat.widget.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            r9.<init>(r5, r7, r6)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            r3.add(r9)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            goto L30
        L74:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r3 = "Share records file not well-formed."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            throw r2     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
        L7c:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r3 = "Share records file does not start with historical-records tag."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
            throw r2     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 org.xmlpull.v1.XmlPullParserException -> La0
        L84:
            r10 = move-exception
            goto Lbc
        L86:
            r2 = move-exception
            java.lang.String r3 = androidx.appcompat.widget.ActivityChooserModel.f1923a     // Catch: java.lang.Throwable -> L84
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r4.<init>()     // Catch: java.lang.Throwable -> L84
            r4.append(r0)     // Catch: java.lang.Throwable -> L84
            java.lang.String r10 = r10.f1927c     // Catch: java.lang.Throwable -> L84
            r4.append(r10)     // Catch: java.lang.Throwable -> L84
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L84
            android.util.Log.COUIBaseListPopupWindow_8(r3, r10, r2)     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto Lbb
            goto L38
        La0:
            r2 = move-exception
            java.lang.String r3 = androidx.appcompat.widget.ActivityChooserModel.f1923a     // Catch: java.lang.Throwable -> L84
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r4.<init>()     // Catch: java.lang.Throwable -> L84
            r4.append(r0)     // Catch: java.lang.Throwable -> L84
            java.lang.String r10 = r10.f1927c     // Catch: java.lang.Throwable -> L84
            r4.append(r10)     // Catch: java.lang.Throwable -> L84
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L84
            android.util.Log.COUIBaseListPopupWindow_8(r3, r10, r2)     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto Lbb
            goto L38
        Lbb:
            return
        Lbc:
            if (r1 == 0) goto Lc1
            r1.close()     // Catch: java.io.IOException -> Lc1
        Lc1:
            throw r10
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.m1633i():void");
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_3$COUIBaseListPopupWindow_8 */
    private final class COUIBaseListPopupWindow_8 extends AsyncTask<Object, Void, Void> {
        COUIBaseListPopupWindow_8() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) throws IOException {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = ActivityChooserModel.this.f1926b.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                            xmlSerializerNewSerializer.startDocument("UTF-8", true);
                            xmlSerializerNewSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                                IntrinsicsJvm.kt_3 cVar = (IntrinsicsJvm.kt_3) list.remove(0);
                                xmlSerializerNewSerializer.startTag(null, "historical-record");
                                xmlSerializerNewSerializer.attribute(null, "activity", cVar.f1941a.flattenToString());
                                xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(cVar.f1942b));
                                xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(cVar.f1943c));
                                xmlSerializerNewSerializer.endTag(null, "historical-record");
                            }
                            xmlSerializerNewSerializer.endTag(null, "historical-records");
                            xmlSerializerNewSerializer.endDocument();
                            ActivityChooserModel.this.f1928d = true;
                        } catch (Throwable th) {
                            ActivityChooserModel.this.f1928d = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (IllegalStateException COUIBaseListPopupWindow_8) {
                        Log.COUIBaseListPopupWindow_8(ActivityChooserModel.f1923a, "Error writing historical record file: " + ActivityChooserModel.this.f1927c, COUIBaseListPopupWindow_8);
                        ActivityChooserModel.this.f1928d = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                        }
                    }
                } catch (IOException e2) {
                    Log.COUIBaseListPopupWindow_8(ActivityChooserModel.f1923a, "Error writing historical record file: " + ActivityChooserModel.this.f1927c, e2);
                    ActivityChooserModel.this.f1928d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                } catch (IllegalArgumentException e3) {
                    Log.COUIBaseListPopupWindow_8(ActivityChooserModel.f1923a, "Error writing historical record file: " + ActivityChooserModel.this.f1927c, e3);
                    ActivityChooserModel.this.f1928d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            } catch (FileNotFoundException e4) {
                Log.COUIBaseListPopupWindow_8(ActivityChooserModel.f1923a, "Error writing historical record file: " + str, e4);
                return null;
            }
        }
    }
}
