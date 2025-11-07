package androidx.p044e.p045a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* renamed from: androidx.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final Object f3340f = new Object();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static LocalBroadcastManager f3341g;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f3342a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final HashMap<BroadcastReceiver, ArrayList<IntrinsicsJvm.kt_4>> f3343b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final HashMap<String, ArrayList<IntrinsicsJvm.kt_4>> f3344c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ArrayList<PlatformImplementations.kt_3> f3345d = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Handler f3346e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: androidx.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static final class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        final IntentFilter f3350a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final BroadcastReceiver f3351b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f3352c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f3353d;

        IntrinsicsJvm.kt_4(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f3350a = intentFilter;
            this.f3351b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f3351b);
            sb.append(" filter=");
            sb.append(this.f3350a);
            if (this.f3353d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: androidx.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Intent f3348a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final ArrayList<IntrinsicsJvm.kt_4> f3349b;

        PlatformImplementations.kt_3(Intent intent, ArrayList<IntrinsicsJvm.kt_4> arrayList) {
            this.f3348a = intent;
            this.f3349b = arrayList;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LocalBroadcastManager m3241a(Context context) {
        LocalBroadcastManager c0554a;
        synchronized (f3340f) {
            if (f3341g == null) {
                f3341g = new LocalBroadcastManager(context.getApplicationContext());
            }
            c0554a = f3341g;
        }
        return c0554a;
    }

    private LocalBroadcastManager(Context context) {
        this.f3342a = context;
        this.f3346e = new Handler(context.getMainLooper()) { // from class: androidx.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.m3242a();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3244a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f3343b) {
            IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(intentFilter, broadcastReceiver);
            ArrayList<IntrinsicsJvm.kt_4> arrayList = this.f3343b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f3343b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < intentFilter.countActions(); OplusGLSurfaceView_13++) {
                String action = intentFilter.getAction(OplusGLSurfaceView_13);
                ArrayList<IntrinsicsJvm.kt_4> arrayList2 = this.f3344c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f3344c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3243a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f3343b) {
            ArrayList<IntrinsicsJvm.kt_4> arrayListRemove = this.f3343b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                IntrinsicsJvm.kt_4 bVar = arrayListRemove.get(size);
                bVar.f3353d = true;
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bVar.f3350a.countActions(); OplusGLSurfaceView_13++) {
                    String action = bVar.f3350a.getAction(OplusGLSurfaceView_13);
                    ArrayList<IntrinsicsJvm.kt_4> arrayList = this.f3344c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            IntrinsicsJvm.kt_4 bVar2 = arrayList.get(size2);
                            if (bVar2.f3351b == broadcastReceiver) {
                                bVar2.f3353d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f3344c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3245a(Intent intent) {
        String str;
        ArrayList arrayList;
        int OplusGLSurfaceView_13;
        ArrayList<IntrinsicsJvm.kt_4> arrayList2;
        String str2;
        synchronized (this.f3343b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f3342a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<IntrinsicsJvm.kt_4> arrayList3 = this.f3344c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    IntrinsicsJvm.kt_4 bVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.f3350a);
                    }
                    if (bVar.f3352c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        OplusGLSurfaceView_13 = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        OplusGLSurfaceView_13 = i2;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = bVar.f3350a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f3352c = true;
                            i2 = OplusGLSurfaceView_13 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : CameraParameter.TiltShiftParamKeys.TYPE : "data" : AFConstants.EXTRA_INTENT_ACTION : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = OplusGLSurfaceView_13 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((IntrinsicsJvm.kt_4) arrayList5.get(i3)).f3352c = false;
                    }
                    this.f3345d.add(new PlatformImplementations.kt_3(intent, arrayList5));
                    if (!this.f3346e.hasMessages(1)) {
                        this.f3346e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3242a() {
        PlatformImplementations.kt_3[] aVarArr;
        while (true) {
            synchronized (this.f3343b) {
                int size = this.f3345d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new PlatformImplementations.kt_3[size];
                this.f3345d.toArray(aVarArr);
                this.f3345d.clear();
            }
            for (PlatformImplementations.kt_3 aVar : aVarArr) {
                int size2 = aVar.f3349b.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size2; OplusGLSurfaceView_13++) {
                    IntrinsicsJvm.kt_4 bVar = aVar.f3349b.get(OplusGLSurfaceView_13);
                    if (!bVar.f3353d) {
                        bVar.f3351b.onReceive(this.f3342a, aVar.f3348a);
                    }
                }
            }
        }
    }
}
