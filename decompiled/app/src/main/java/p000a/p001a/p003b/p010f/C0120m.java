package p000a.p001a.p003b.p010f;

import android.content.res.Resources;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.HistoryItem;
import co.polarr.renderer.entities.HistoryStroeItem;
import co.polarr.renderer.entities.SpotItem;
import co.polarr.renderer.entities.TextItem;
import co.polarr.renderer.utils.AnimationJson;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.C0007a;
import p000a.p001a.p003b.p005b.C0015ad;
import p000a.p001a.p003b.p005b.C0023al;
import p000a.p001a.p003b.p005b.C0033av;
import p000a.p001a.p003b.p005b.C0039ba;
import p000a.p001a.p003b.p005b.C0046bh;
import p000a.p001a.p003b.p005b.C0053bo;
import p000a.p001a.p003b.p005b.C0056br;
import p000a.p001a.p003b.p005b.C0057bs;
import p000a.p001a.p003b.p005b.C0062bx;
import p000a.p001a.p003b.p005b.C0065c;
import p000a.p001a.p003b.p005b.C0066ca;
import p000a.p001a.p003b.p005b.C0069f;
import p000a.p001a.p003b.p005b.C0074k;
import p000a.p001a.p003b.p005b.C0075l;
import p000a.p001a.p003b.p005b.C0079p;
import p000a.p001a.p003b.p005b.C0084u;
import p000a.p001a.p003b.p005b.C0085v;
import p000a.p001a.p003b.p005b.C0086w;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p005b.p006a.C0009b;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class C0120m {

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static InterfaceC0118k f549c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String f550d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Map<String, JSONObject> f552f = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    public static final List<HistoryItem> f547a = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int f548b = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static C0120m f551e = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m521a(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0120m m522a(Resources resources) {
        C0120m c0120m;
        synchronized (C0120m.class) {
            try {
                if (f551e == null) {
                    f551e = new C0120m();
                    f551e.m532b(resources);
                }
                c0120m = f551e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0120m;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m523a(String str, Object obj) {
        float fFloatValue;
        TextItem textItemFromDecodedHashMap;
        FaceItem faceItemFromDecodedHashMap;
        Adjustment adjustmentFromDecodedHashMap;
        TextItem textItemFromDecodedHashMap2;
        FaceItem faceItemFromDecodedHashMap2;
        Adjustment adjustmentFromDecodedHashMap2;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ArrayList) {
            if (str.equals(MimeTypes.BASE_TYPE_TEXT) || str.equals("zPrevText")) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof HashMap) {
                        textItemFromDecodedHashMap2 = TextItem.fromDecodedHashMap((HashMap) next);
                    } else if (next instanceof TextItem) {
                        textItemFromDecodedHashMap2 = (TextItem) next;
                    }
                    arrayList.add(textItemFromDecodedHashMap2);
                }
                return arrayList;
            }
            if (str.equals("faces") || str.equals("prevFaces")) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = ((ArrayList) obj).iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (next2 instanceof HashMap) {
                        faceItemFromDecodedHashMap2 = FaceItem.fromDecodedHashMap((HashMap) next2);
                    } else if (next2 instanceof FaceItem) {
                        faceItemFromDecodedHashMap2 = (FaceItem) next2;
                    }
                    arrayList2.add(faceItemFromDecodedHashMap2);
                }
                return arrayList2;
            }
            if (str.equals("face_features")) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it3 = ((ArrayList) obj).iterator();
                while (it3.hasNext()) {
                    Object next3 = it3.next();
                    arrayList3.add(next3 instanceof Context.FaceFeaturesState ? (Context.FaceFeaturesState) next3 : C0109b.m465a(C0109b.m466a(next3), Context.FaceFeaturesState.class));
                }
                return arrayList3;
            }
            if (str.equals("spots") || str.equals("zPrevSpots")) {
                ArrayList arrayList4 = new ArrayList();
                Iterator it4 = ((ArrayList) obj).iterator();
                while (it4.hasNext()) {
                    Object next4 = it4.next();
                    arrayList4.add(next4 instanceof SpotItem ? (SpotItem) next4 : C0109b.m465a(C0109b.m466a(next4), SpotItem.class));
                }
                return arrayList4;
            }
            if (str.equals("prevBrushes")) {
                ArrayList arrayList5 = new ArrayList();
                Iterator it5 = ((ArrayList) obj).iterator();
                while (it5.hasNext()) {
                    Object next5 = it5.next();
                    arrayList5.add(next5 instanceof BrushItem ? (BrushItem) next5 : C0109b.m465a(C0109b.m466a(next5), BrushItem.class));
                }
                return arrayList5;
            }
            if (str.equals("local_adjustments")) {
                ArrayList arrayList6 = new ArrayList();
                Iterator it6 = ((ArrayList) obj).iterator();
                while (it6.hasNext()) {
                    Object next6 = it6.next();
                    if (next6 instanceof HashMap) {
                        adjustmentFromDecodedHashMap2 = Adjustment.fromDecodedHashMap((HashMap) next6);
                    } else if (next6 instanceof Adjustment) {
                        adjustmentFromDecodedHashMap2 = (Adjustment) next6;
                    }
                    arrayList6.add(adjustmentFromDecodedHashMap2);
                }
                return arrayList6;
            }
            ArrayList arrayList7 = (ArrayList) obj;
            ArrayList arrayList8 = new ArrayList();
            float[] fArr = new float[arrayList7.size()];
            Iterator it7 = arrayList7.iterator();
            boolean z = false;
            int OplusGLSurfaceView_13 = 0;
            while (it7.hasNext()) {
                Object next7 = it7.next();
                if (next7 instanceof ArrayList) {
                    z = true;
                }
                Object objM523a = m523a(str, next7);
                if (!z && (objM523a instanceof Float)) {
                    fArr[OplusGLSurfaceView_13] = ((Float) objM523a).floatValue();
                    OplusGLSurfaceView_13++;
                } else {
                    arrayList8.add(objM523a);
                }
            }
            return (!z || arrayList8.isEmpty()) ? fArr : arrayList8.get(0) instanceof float[] ? arrayList8.toArray(new float[arrayList8.size()][]) : arrayList8.toArray();
        }
        if (!(obj instanceof JsonArray)) {
            if ((obj instanceof Boolean) || (obj instanceof HashMap) || (obj instanceof float[]) || (obj instanceof float[][])) {
                return obj;
            }
            if ("mosaic_pattern".equals(str) && (obj instanceof String)) {
                return obj;
            }
            Float fValueOf = Float.valueOf(0.0f);
            if (obj instanceof BigDecimal) {
                fFloatValue = ((BigDecimal) obj).floatValue();
            } else if (obj instanceof Integer) {
                fFloatValue = ((Integer) obj).intValue();
            } else {
                if (obj instanceof Float) {
                    return (Float) obj;
                }
                if (!(obj instanceof Double)) {
                    return fValueOf;
                }
                fFloatValue = ((Double) obj).floatValue();
            }
            return Float.valueOf(fFloatValue);
        }
        if (str.equals(MimeTypes.BASE_TYPE_TEXT) || str.equals("zPrevText")) {
            ArrayList arrayList9 = new ArrayList();
            Iterator<JsonElement> it8 = ((JsonArray) obj).iterator();
            while (it8.hasNext()) {
                Object next8 = it8.next();
                if (next8 instanceof HashMap) {
                    textItemFromDecodedHashMap = TextItem.fromDecodedHashMap((HashMap) next8);
                } else {
                    if (next8 instanceof JSONObject) {
                        next8 = C0109b.m465a(C0109b.m466a(next8), TextItem.class);
                    } else if (next8 instanceof TextItem) {
                    }
                    textItemFromDecodedHashMap = (TextItem) next8;
                }
                arrayList9.add(textItemFromDecodedHashMap);
            }
            return arrayList9;
        }
        if (str.equals("faces") || str.equals("prevFaces")) {
            ArrayList arrayList10 = new ArrayList();
            Iterator<JsonElement> it9 = ((JsonArray) obj).iterator();
            while (it9.hasNext()) {
                Object next9 = it9.next();
                if (next9 instanceof HashMap) {
                    faceItemFromDecodedHashMap = FaceItem.fromDecodedHashMap((HashMap) next9);
                } else {
                    if (next9 instanceof JSONObject) {
                        next9 = C0109b.m465a(C0109b.m466a(next9), FaceItem.class);
                    } else if (next9 instanceof FaceItem) {
                    }
                    faceItemFromDecodedHashMap = (FaceItem) next9;
                }
                arrayList10.add(faceItemFromDecodedHashMap);
            }
            return arrayList10;
        }
        if (str.equals("face_features")) {
            ArrayList arrayList11 = new ArrayList();
            Iterator<JsonElement> it10 = ((JsonArray) obj).iterator();
            while (it10.hasNext()) {
                Object next10 = it10.next();
                arrayList11.add(next10 instanceof Context.FaceFeaturesState ? (Context.FaceFeaturesState) next10 : C0109b.m465a(C0109b.m466a(next10), Context.FaceFeaturesState.class));
            }
            return arrayList11;
        }
        if (str.equals("spots") || str.equals("zPrevSpots")) {
            ArrayList arrayList12 = new ArrayList();
            Iterator<JsonElement> it11 = ((JsonArray) obj).iterator();
            while (it11.hasNext()) {
                Object next11 = it11.next();
                arrayList12.add(next11 instanceof SpotItem ? (SpotItem) next11 : C0109b.m465a(C0109b.m466a(next11), SpotItem.class));
            }
            return arrayList12;
        }
        if (str.equals("prevBrushes")) {
            ArrayList arrayList13 = new ArrayList();
            Iterator<JsonElement> it12 = ((JsonArray) obj).iterator();
            while (it12.hasNext()) {
                Object next12 = it12.next();
                arrayList13.add(next12 instanceof BrushItem ? (BrushItem) next12 : C0109b.m465a(C0109b.m466a(next12), BrushItem.class));
            }
            return arrayList13;
        }
        if (str.equals("local_adjustments")) {
            ArrayList arrayList14 = new ArrayList();
            Iterator<JsonElement> it13 = ((JsonArray) obj).iterator();
            while (it13.hasNext()) {
                Object next13 = it13.next();
                if (next13 instanceof HashMap) {
                    adjustmentFromDecodedHashMap = Adjustment.fromDecodedHashMap((HashMap) next13);
                } else {
                    if (next13 instanceof JSONObject) {
                        next13 = C0109b.m465a(C0109b.m466a(next13), Adjustment.class);
                    } else if (next13 instanceof Adjustment) {
                    }
                    adjustmentFromDecodedHashMap = (Adjustment) next13;
                }
                arrayList14.add(adjustmentFromDecodedHashMap);
            }
            return arrayList14;
        }
        JsonArray jsonArray = (JsonArray) obj;
        ArrayList arrayList15 = new ArrayList();
        float[] fArr2 = new float[jsonArray.size()];
        Iterator<JsonElement> it14 = jsonArray.iterator();
        boolean z2 = false;
        int i2 = 0;
        while (it14.hasNext()) {
            JsonElement next14 = it14.next();
            if (next14 instanceof JsonArray) {
                z2 = true;
            }
            Object objM523a2 = m523a(str, next14);
            if (!z2 && (objM523a2 instanceof Float)) {
                fArr2[i2] = ((Float) objM523a2).floatValue();
                i2++;
            } else {
                arrayList15.add(objM523a2);
            }
        }
        return (!z2 || arrayList15.isEmpty()) ? fArr2 : arrayList15.get(0) instanceof float[] ? arrayList15.toArray(new float[arrayList15.size()][]) : arrayList15.toArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m524a(String str) {
        return str + ".glsl";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<AbstractC0008a> m525a(Resources resources, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0062bx(resources, context));
        arrayList.add(new C0023al(resources, context));
        arrayList.add(new C0079p(resources, context));
        arrayList.add(new C0015ad(resources, context));
        arrayList.add(new C0069f(resources, context));
        arrayList.add(new C0065c(resources, context));
        arrayList.add(new C0007a(resources, context));
        arrayList.add(new C0066ca(resources, context));
        arrayList.add(new C0033av(resources, context));
        arrayList.add(new C0056br(resources, context));
        arrayList.add(new C0086w(resources, context));
        arrayList.add(new C0046bh(resources, context));
        arrayList.add(new C0085v(resources, context));
        arrayList.add(new C0053bo(resources, context));
        arrayList.add(new C0039ba(resources, context));
        arrayList.add(new C0057bs(resources, context));
        arrayList.add(new C0084u(resources, context));
        arrayList.add(new C0074k(resources, context));
        arrayList.add(new C0075l(resources, context));
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m526a(String str, List<FaceItem> list, List<Context.FaceFeaturesState> list2) {
        InterfaceC0118k interfaceC0118k;
        List<HistoryItem> list3;
        f548b = 0;
        f547a.clear();
        HashMap map = new HashMap();
        C0106f.m464a(map);
        if (list != null) {
            map.put("faces", list);
        }
        if (list2 != null) {
            map.put("face_features", list2);
        }
        HistoryItem historyItem = new HistoryItem("labels.original", map, "");
        f550d = str;
        String str2 = f550d;
        List<HistoryItem> list4 = null;
        if (str2 != null && (interfaceC0118k = f549c) != null) {
            HistoryStroeItem historyStroeItemM515a = interfaceC0118k.m515a(str2);
            if (historyStroeItemM515a != null && (list3 = historyStroeItemM515a.historyItemList) != null) {
                f548b = historyStroeItemM515a.historyIndex;
                list4 = list3;
            }
            if (list4 != null && !list4.isEmpty()) {
                if (list4.get(0).message.equals("labels.original")) {
                    list4.remove(list4.get(0));
                }
                for (HistoryItem historyItem2 : list4) {
                    Map<String, Object> mapM514a = C0117j.m514a(C0109b.m466a(historyItem2.state));
                    if (mapM514a.containsKey(AnimationJson.BLENDING_MODE_SCREEN)) {
                        mapM514a.remove(AnimationJson.BLENDING_MODE_SCREEN);
                    }
                    historyItem2.state = mapM514a;
                    HashMap map2 = new HashMap();
                    for (String str3 : historyItem2.state.keySet()) {
                        map2.put(str3, m523a(str3, historyItem2.state.get(str3)));
                    }
                    historyItem2.state = map2;
                }
            }
        }
        if (list4 != null) {
            f547a.addAll(list4);
        }
        f547a.add(0, historyItem);
        f548b = Math.min(f548b, f547a.size() - 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m527a(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static List<C0009b> m528b(Resources resources, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0079p(resources, context));
        arrayList.add(new C0069f(resources, context));
        arrayList.add(new C0065c(resources, context));
        arrayList.add(new C0033av(resources, context));
        arrayList.add(new C0056br(resources, context));
        arrayList.add(new C0086w(resources, context));
        arrayList.add(new C0046bh(resources, context));
        arrayList.add(new C0057bs(resources, context));
        arrayList.add(new C0084u(resources, context));
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m529b(byte[] bArr) {
        int OplusGLSurfaceView_13 = 0;
        int i2 = bArr[0];
        byte[] bArr2 = new byte[(bArr.length - i2) - 1];
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < i2) {
            if (i4 < bArr2.length) {
                bArr2[i4] = (byte) bArr[i5];
                i4++;
                i5++;
            }
            bArr3[i3] = (byte) bArr[i5];
            i3++;
            i5++;
        }
        int length = bArr2.length;
        int i6 = i4;
        while (OplusGLSurfaceView_13 < length - i4) {
            bArr2[i6] = (byte) bArr[i5];
            OplusGLSurfaceView_13++;
            i6++;
            i5++;
        }
        return m527a(bArr3, bArr2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m530a(Resources resources, String str) throws IOException {
        if (!this.f552f.containsKey(str)) {
            return null;
        }
        JSONObject jSONObject = this.f552f.get(str);
        try {
            InputStream inputStreamOpen = resources.getAssets().open("res.dat");
            byte[] bArr = new byte[jSONObject.getInt("length")];
            inputStreamOpen.skip(jSONObject.getInt(TtmlNode.START));
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            return new String(m529b(bArr), "utf-8").replaceAll("\\r\\OplusGLSurfaceView_11", "\OplusGLSurfaceView_11");
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m531a() {
        this.f552f.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m532b(Resources resources) throws JSONException, IOException {
        if (this.f552f.isEmpty()) {
            try {
                InputStream inputStreamOpen = resources.getAssets().open("res.dat");
                byte[] bArr = new byte[4];
                inputStreamOpen.read(bArr);
                int iM521a = m521a(bArr);
                byte[] bArr2 = new byte[iM521a];
                inputStreamOpen.read(bArr2);
                JSONArray jSONArray = new JSONArray(new String(m529b(bArr2), "utf-8"));
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jSONArray.length(); OplusGLSurfaceView_13++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(OplusGLSurfaceView_13);
                    String string = jSONObject.getString(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME);
                    jSONObject.put(TtmlNode.START, jSONObject.getInt(TtmlNode.START) + iM521a + 4);
                    this.f552f.put(string, jSONObject);
                }
                inputStreamOpen.close();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }
}
