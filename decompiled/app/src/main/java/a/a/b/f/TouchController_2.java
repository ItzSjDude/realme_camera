package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class m_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    public static a_renamed.a_renamed.b_renamed.f_renamed.k_renamed f104c;
    public static java.lang.String d_renamed;
    public java.util.Map<java.lang.String, org.json.JSONObject> f_renamed = new java.util.HashMap();

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.List<co_renamed.polarr.renderer.entities.HistoryItem> f102a = new java.util.ArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    public static int f103b = 0;
    public static a_renamed.a_renamed.b_renamed.f_renamed.m_renamed e_renamed = null;

    public static int a_renamed(byte[] bArr) {
        return java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static a_renamed.a_renamed.b_renamed.f_renamed.m_renamed a_renamed(android.content.res.Resources resources) {
        a_renamed.a_renamed.b_renamed.f_renamed.m_renamed mVar;
        synchronized (a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.class) {
            try {
                if (e_renamed == null) {
                    e_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.m_renamed();
                    e_renamed.b_renamed(resources);
                }
                mVar = e_renamed;
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public static java.lang.Object a_renamed(java.lang.String str, java.lang.Object obj) {
        float fFloatValue;
        co_renamed.polarr.renderer.entities.TextItem textItemFromDecodedHashMap;
        co_renamed.polarr.renderer.entities.FaceItem faceItemFromDecodedHashMap;
        co_renamed.polarr.renderer.entities.Adjustment adjustmentFromDecodedHashMap;
        co_renamed.polarr.renderer.entities.TextItem textItemFromDecodedHashMap2;
        co_renamed.polarr.renderer.entities.FaceItem faceItemFromDecodedHashMap2;
        co_renamed.polarr.renderer.entities.Adjustment adjustmentFromDecodedHashMap2;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.ArrayList) {
            if (str.equals(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT) || str.equals("zPrevText")) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = ((java.util.ArrayList) obj).iterator();
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    if (next instanceof java.util.HashMap) {
                        textItemFromDecodedHashMap2 = co_renamed.polarr.renderer.entities.TextItem.fromDecodedHashMap((java.util.HashMap) next);
                    } else if (next instanceof co_renamed.polarr.renderer.entities.TextItem) {
                        textItemFromDecodedHashMap2 = (co_renamed.polarr.renderer.entities.TextItem) next;
                    }
                    arrayList.add(textItemFromDecodedHashMap2);
                }
                return arrayList;
            }
            if (str.equals("faces") || str.equals("prevFaces")) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                java.util.Iterator it2 = ((java.util.ArrayList) obj).iterator();
                while (it2.hasNext()) {
                    java.lang.Object next2 = it2.next();
                    if (next2 instanceof java.util.HashMap) {
                        faceItemFromDecodedHashMap2 = co_renamed.polarr.renderer.entities.FaceItem.fromDecodedHashMap((java.util.HashMap) next2);
                    } else if (next2 instanceof co_renamed.polarr.renderer.entities.FaceItem) {
                        faceItemFromDecodedHashMap2 = (co_renamed.polarr.renderer.entities.FaceItem) next2;
                    }
                    arrayList2.add(faceItemFromDecodedHashMap2);
                }
                return arrayList2;
            }
            if (str.equals("face_features")) {
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                java.util.Iterator it3 = ((java.util.ArrayList) obj).iterator();
                while (it3.hasNext()) {
                    java.lang.Object next3 = it3.next();
                    arrayList3.add(next3 instanceof co_renamed.polarr.renderer.entities.Context.FaceFeaturesState ? (co_renamed.polarr.renderer.entities.Context.FaceFeaturesState) next3 : a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next3), co_renamed.polarr.renderer.entities.Context.FaceFeaturesState.class));
                }
                return arrayList3;
            }
            if (str.equals("spots") || str.equals("zPrevSpots")) {
                java.util.ArrayList arrayList4 = new java.util.ArrayList();
                java.util.Iterator it4 = ((java.util.ArrayList) obj).iterator();
                while (it4.hasNext()) {
                    java.lang.Object next4 = it4.next();
                    arrayList4.add(next4 instanceof co_renamed.polarr.renderer.entities.SpotItem ? (co_renamed.polarr.renderer.entities.SpotItem) next4 : a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next4), co_renamed.polarr.renderer.entities.SpotItem.class));
                }
                return arrayList4;
            }
            if (str.equals("prevBrushes")) {
                java.util.ArrayList arrayList5 = new java.util.ArrayList();
                java.util.Iterator it5 = ((java.util.ArrayList) obj).iterator();
                while (it5.hasNext()) {
                    java.lang.Object next5 = it5.next();
                    arrayList5.add(next5 instanceof co_renamed.polarr.renderer.entities.BrushItem ? (co_renamed.polarr.renderer.entities.BrushItem) next5 : a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next5), co_renamed.polarr.renderer.entities.BrushItem.class));
                }
                return arrayList5;
            }
            if (str.equals("local_adjustments")) {
                java.util.ArrayList arrayList6 = new java.util.ArrayList();
                java.util.Iterator it6 = ((java.util.ArrayList) obj).iterator();
                while (it6.hasNext()) {
                    java.lang.Object next6 = it6.next();
                    if (next6 instanceof java.util.HashMap) {
                        adjustmentFromDecodedHashMap2 = co_renamed.polarr.renderer.entities.Adjustment.fromDecodedHashMap((java.util.HashMap) next6);
                    } else if (next6 instanceof co_renamed.polarr.renderer.entities.Adjustment) {
                        adjustmentFromDecodedHashMap2 = (co_renamed.polarr.renderer.entities.Adjustment) next6;
                    }
                    arrayList6.add(adjustmentFromDecodedHashMap2);
                }
                return arrayList6;
            }
            java.util.ArrayList arrayList7 = (java.util.ArrayList) obj;
            java.util.ArrayList arrayList8 = new java.util.ArrayList();
            float[] fArr = new float[arrayList7.size()];
            java.util.Iterator it7 = arrayList7.iterator();
            boolean z_renamed = false;
            int i_renamed = 0;
            while (it7.hasNext()) {
                java.lang.Object next7 = it7.next();
                if (next7 instanceof java.util.ArrayList) {
                    z_renamed = true;
                }
                java.lang.Object objA = a_renamed(str, next7);
                if (!z_renamed && (objA instanceof java.lang.Float)) {
                    fArr[i_renamed] = ((java.lang.Float) objA).floatValue();
                    i_renamed++;
                } else {
                    arrayList8.add(objA);
                }
            }
            return (!z_renamed || arrayList8.isEmpty()) ? fArr : arrayList8.get(0) instanceof float[] ? arrayList8.toArray(new float[arrayList8.size()][]) : arrayList8.toArray();
        }
        if (!(obj instanceof com.google.gson.JsonArray)) {
            if ((obj instanceof java.lang.Boolean) || (obj instanceof java.util.HashMap) || (obj instanceof float[]) || (obj instanceof float[][])) {
                return obj;
            }
            if ("mosaic_pattern".equals(str) && (obj instanceof java.lang.String)) {
                return obj;
            }
            java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
            if (obj instanceof java.math.BigDecimal) {
                fFloatValue = ((java.math.BigDecimal) obj).floatValue();
            } else if (obj instanceof java.lang.Integer) {
                fFloatValue = ((java.lang.Integer) obj).intValue();
            } else {
                if (obj instanceof java.lang.Float) {
                    return (java.lang.Float) obj;
                }
                if (!(obj instanceof java.lang.Double)) {
                    return fValueOf;
                }
                fFloatValue = ((java.lang.Double) obj).floatValue();
            }
            return java.lang.Float.valueOf(fFloatValue);
        }
        if (str.equals(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT) || str.equals("zPrevText")) {
            java.util.ArrayList arrayList9 = new java.util.ArrayList();
            java.util.Iterator<com.google.gson.JsonElement> it8 = ((com.google.gson.JsonArray) obj).iterator();
            while (it8.hasNext()) {
                java.lang.Object next8 = it8.next();
                if (next8 instanceof java.util.HashMap) {
                    textItemFromDecodedHashMap = co_renamed.polarr.renderer.entities.TextItem.fromDecodedHashMap((java.util.HashMap) next8);
                } else {
                    if (next8 instanceof org.json.JSONObject) {
                        next8 = a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next8), co_renamed.polarr.renderer.entities.TextItem.class);
                    } else if (next8 instanceof co_renamed.polarr.renderer.entities.TextItem) {
                    }
                    textItemFromDecodedHashMap = (co_renamed.polarr.renderer.entities.TextItem) next8;
                }
                arrayList9.add(textItemFromDecodedHashMap);
            }
            return arrayList9;
        }
        if (str.equals("faces") || str.equals("prevFaces")) {
            java.util.ArrayList arrayList10 = new java.util.ArrayList();
            java.util.Iterator<com.google.gson.JsonElement> it9 = ((com.google.gson.JsonArray) obj).iterator();
            while (it9.hasNext()) {
                java.lang.Object next9 = it9.next();
                if (next9 instanceof java.util.HashMap) {
                    faceItemFromDecodedHashMap = co_renamed.polarr.renderer.entities.FaceItem.fromDecodedHashMap((java.util.HashMap) next9);
                } else {
                    if (next9 instanceof org.json.JSONObject) {
                        next9 = a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next9), co_renamed.polarr.renderer.entities.FaceItem.class);
                    } else if (next9 instanceof co_renamed.polarr.renderer.entities.FaceItem) {
                    }
                    faceItemFromDecodedHashMap = (co_renamed.polarr.renderer.entities.FaceItem) next9;
                }
                arrayList10.add(faceItemFromDecodedHashMap);
            }
            return arrayList10;
        }
        if (str.equals("face_features")) {
            java.util.ArrayList arrayList11 = new java.util.ArrayList();
            java.util.Iterator<com.google.gson.JsonElement> it10 = ((com.google.gson.JsonArray) obj).iterator();
            while (it10.hasNext()) {
                java.lang.Object next10 = it10.next();
                arrayList11.add(next10 instanceof co_renamed.polarr.renderer.entities.Context.FaceFeaturesState ? (co_renamed.polarr.renderer.entities.Context.FaceFeaturesState) next10 : a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next10), co_renamed.polarr.renderer.entities.Context.FaceFeaturesState.class));
            }
            return arrayList11;
        }
        if (str.equals("spots") || str.equals("zPrevSpots")) {
            java.util.ArrayList arrayList12 = new java.util.ArrayList();
            java.util.Iterator<com.google.gson.JsonElement> it11 = ((com.google.gson.JsonArray) obj).iterator();
            while (it11.hasNext()) {
                java.lang.Object next11 = it11.next();
                arrayList12.add(next11 instanceof co_renamed.polarr.renderer.entities.SpotItem ? (co_renamed.polarr.renderer.entities.SpotItem) next11 : a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next11), co_renamed.polarr.renderer.entities.SpotItem.class));
            }
            return arrayList12;
        }
        if (str.equals("prevBrushes")) {
            java.util.ArrayList arrayList13 = new java.util.ArrayList();
            java.util.Iterator<com.google.gson.JsonElement> it12 = ((com.google.gson.JsonArray) obj).iterator();
            while (it12.hasNext()) {
                java.lang.Object next12 = it12.next();
                arrayList13.add(next12 instanceof co_renamed.polarr.renderer.entities.BrushItem ? (co_renamed.polarr.renderer.entities.BrushItem) next12 : a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next12), co_renamed.polarr.renderer.entities.BrushItem.class));
            }
            return arrayList13;
        }
        if (str.equals("local_adjustments")) {
            java.util.ArrayList arrayList14 = new java.util.ArrayList();
            java.util.Iterator<com.google.gson.JsonElement> it13 = ((com.google.gson.JsonArray) obj).iterator();
            while (it13.hasNext()) {
                java.lang.Object next13 = it13.next();
                if (next13 instanceof java.util.HashMap) {
                    adjustmentFromDecodedHashMap = co_renamed.polarr.renderer.entities.Adjustment.fromDecodedHashMap((java.util.HashMap) next13);
                } else {
                    if (next13 instanceof org.json.JSONObject) {
                        next13 = a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(next13), co_renamed.polarr.renderer.entities.Adjustment.class);
                    } else if (next13 instanceof co_renamed.polarr.renderer.entities.Adjustment) {
                    }
                    adjustmentFromDecodedHashMap = (co_renamed.polarr.renderer.entities.Adjustment) next13;
                }
                arrayList14.add(adjustmentFromDecodedHashMap);
            }
            return arrayList14;
        }
        com.google.gson.JsonArray jsonArray = (com.google.gson.JsonArray) obj;
        java.util.ArrayList arrayList15 = new java.util.ArrayList();
        float[] fArr2 = new float[jsonArray.size()];
        java.util.Iterator<com.google.gson.JsonElement> it14 = jsonArray.iterator();
        boolean z2 = false;
        int i2 = 0;
        while (it14.hasNext()) {
            com.google.gson.JsonElement next14 = it14.next();
            if (next14 instanceof com.google.gson.JsonArray) {
                z2 = true;
            }
            java.lang.Object objA2 = a_renamed(str, next14);
            if (!z2 && (objA2 instanceof java.lang.Float)) {
                fArr2[i2] = ((java.lang.Float) objA2).floatValue();
                i2++;
            } else {
                arrayList15.add(objA2);
            }
        }
        return (!z2 || arrayList15.isEmpty()) ? fArr2 : arrayList15.get(0) instanceof float[] ? arrayList15.toArray(new float[arrayList15.size()][]) : arrayList15.toArray();
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        return str + ".glsl";
    }

    public static java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.bx_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.al_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.p_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.ad_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.f_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.c_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.ca_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.av_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.br_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.w_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.bh_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.v_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.bs_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.u_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.k_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.l_renamed(resources, context));
        return arrayList;
    }

    public static void a_renamed(java.lang.String str, java.util.List<co_renamed.polarr.renderer.entities.FaceItem> list, java.util.List<co_renamed.polarr.renderer.entities.Context.FaceFeaturesState> list2) {
        a_renamed.a_renamed.b_renamed.f_renamed.k_renamed kVar;
        java.util.List<co_renamed.polarr.renderer.entities.HistoryItem> list3;
        f103b = 0;
        f102a.clear();
        java.util.HashMap map = new java.util.HashMap();
        a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(map);
        if (list != null) {
            map.put("faces", list);
        }
        if (list2 != null) {
            map.put("face_features", list2);
        }
        co_renamed.polarr.renderer.entities.HistoryItem historyItem = new co_renamed.polarr.renderer.entities.HistoryItem("labels.original", map, "");
        d_renamed = str;
        java.lang.String str2 = d_renamed;
        java.util.List<co_renamed.polarr.renderer.entities.HistoryItem> list4 = null;
        if (str2 != null && (kVar = f104c) != null) {
            co_renamed.polarr.renderer.entities.HistoryStroeItem historyStroeItemA = kVar.a_renamed(str2);
            if (historyStroeItemA != null && (list3 = historyStroeItemA.historyItemList) != null) {
                f103b = historyStroeItemA.historyIndex;
                list4 = list3;
            }
            if (list4 != null && !list4.isEmpty()) {
                if (list4.get(0).message.equals("labels.original")) {
                    list4.remove(list4.get(0));
                }
                for (co_renamed.polarr.renderer.entities.HistoryItem historyItem2 : list4) {
                    java.util.Map<java.lang.String, java.lang.Object> mapA = a_renamed.a_renamed.b_renamed.f_renamed.j_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(historyItem2.state));
                    if (mapA.containsKey(co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_SCREEN)) {
                        mapA.remove(co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_SCREEN);
                    }
                    historyItem2.state = mapA;
                    java.util.HashMap map2 = new java.util.HashMap();
                    for (java.lang.String str3 : historyItem2.state.keySet()) {
                        map2.put(str3, a_renamed(str3, historyItem2.state.get(str3)));
                    }
                    historyItem2.state = map2;
                }
            }
        }
        if (list4 != null) {
            f102a.addAll(list4);
        }
        f102a.add(0, historyItem);
        f103b = java.lang.Math.min(f103b, f102a.size() - 1);
    }

    public static byte[] a_renamed(byte[] bArr, byte[] bArr2) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed> b_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.p_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.f_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.c_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.av_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.br_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.w_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.bh_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.bs_renamed(resources, context));
        arrayList.add(new a_renamed.a_renamed.b_renamed.b_renamed.u_renamed(resources, context));
        return arrayList;
    }

    public static byte[] b_renamed(byte[] bArr) {
        int i_renamed = 0;
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
        while (i_renamed < length - i4) {
            bArr2[i6] = (byte) bArr[i5];
            i_renamed++;
            i6++;
            i5++;
        }
        return a_renamed(bArr3, bArr2);
    }

    public java.lang.String a_renamed(android.content.res.Resources resources, java.lang.String str) throws java.io.IOException {
        if (!this.f_renamed.containsKey(str)) {
            return null;
        }
        org.json.JSONObject jSONObject = this.f_renamed.get(str);
        try {
            java.io.InputStream inputStreamOpen = resources.getAssets().open("res.dat");
            byte[] bArr = new byte[jSONObject.getInt("length")];
            inputStreamOpen.skip(jSONObject.getInt(com.google.android.exoplayer2.text.ttml.TtmlNode.START));
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            return new java.lang.String(b_renamed(bArr), "utf-8").replaceAll("\\r_renamed\\n_renamed", "\n_renamed");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a_renamed() {
        this.f_renamed.clear();
    }

    public void b_renamed(android.content.res.Resources resources) throws org.json.JSONException, java.io.IOException {
        if (this.f_renamed.isEmpty()) {
            try {
                java.io.InputStream inputStreamOpen = resources.getAssets().open("res.dat");
                byte[] bArr = new byte[4];
                inputStreamOpen.read(bArr);
                int iA = a_renamed(bArr);
                byte[] bArr2 = new byte[iA];
                inputStreamOpen.read(bArr2);
                org.json.JSONArray jSONArray = new org.json.JSONArray(new java.lang.String(b_renamed(bArr2), "utf-8"));
                for (int i_renamed = 0; i_renamed < jSONArray.length(); i_renamed++) {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i_renamed);
                    java.lang.String string = jSONObject.getString(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME);
                    jSONObject.put(com.google.android.exoplayer2.text.ttml.TtmlNode.START, jSONObject.getInt(com.google.android.exoplayer2.text.ttml.TtmlNode.START) + iA + 4);
                    this.f_renamed.put(string, jSONObject);
                }
                inputStreamOpen.close();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
