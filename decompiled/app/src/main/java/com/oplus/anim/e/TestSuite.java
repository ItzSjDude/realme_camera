package com.oplus.anim.e_renamed;

/* compiled from: EffectiveCompositionParser.java */
/* loaded from: classes2.dex */
public class i_renamed {
    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x00de A_renamed[PHI: r18
      0x00de: PHI (r18v16 float) = 
      (r18v2 float)
      (r18v3 float)
      (r18v4 float)
      (r18v5 float)
      (r18v6 float)
      (r18v7 float)
      (r18v8 float)
      (r18v9 float)
      (r18v10 float)
      (r18v11 float)
      (r18v12 float)
      (r18v17 float)
     binds: [B_renamed:39:0x00da, B_renamed:36:0x00ce, B_renamed:33:0x00c1, B_renamed:30:0x00b5, B_renamed:27:0x00a9, B_renamed:24:0x009d, B_renamed:21:0x0090, B_renamed:18:0x0084, B_renamed:15:0x0076, B_renamed:12:0x0068, B_renamed:9:0x005a, B_renamed:7:0x004e] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.anim.a_renamed a_renamed(android.util.JsonReader r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.e_renamed.i_renamed.a_renamed(android.util.JsonReader):com.oplus.anim.a_renamed");
    }

    private static void a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, java.util.List<com.oplus.anim.c_renamed.c_renamed.d_renamed> list, android.util.LongSparseArray<com.oplus.anim.c_renamed.c_renamed.d_renamed> longSparseArray) throws java.io.IOException {
        jsonReader.beginArray();
        int i_renamed = 0;
        while (jsonReader.hasNext()) {
            com.oplus.anim.c_renamed.c_renamed.d_renamed dVarA = com.oplus.anim.e_renamed.t_renamed.a_renamed(jsonReader, aVar);
            if (dVarA.k_renamed() == com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.IMAGE) {
                i_renamed++;
            }
            list.add(dVarA);
            longSparseArray.put(dVarA.e_renamed(), dVarA);
            if (i_renamed > 4) {
                com.oplus.anim.k_renamed.b_renamed("You have " + i_renamed + " images. EffectiveAnimation should primarily be_renamed used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, java.util.Map<java.lang.String, java.util.List<com.oplus.anim.c_renamed.c_renamed.d_renamed>> map, java.util.Map<java.lang.String, com.oplus.anim.h_renamed> map2) throws java.io.IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            android.util.LongSparseArray longSparseArray = new android.util.LongSparseArray();
            jsonReader.beginObject();
            java.lang.String strNextString = null;
            java.lang.String strNextString2 = null;
            java.lang.String strNextString3 = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                java.lang.String strNextName = jsonReader.nextName();
                char c2 = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1109732030) {
                    if (iHashCode != 104) {
                        if (iHashCode != 112) {
                            if (iHashCode != 117) {
                                if (iHashCode != 119) {
                                    if (iHashCode == 3355 && strNextName.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID)) {
                                        c2 = 0;
                                    }
                                } else if (strNextName.equals("w_renamed")) {
                                    c2 = 2;
                                }
                            } else if (strNextName.equals("u_renamed")) {
                                c2 = 5;
                            }
                        } else if (strNextName.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P)) {
                            c2 = 4;
                        }
                    } else if (strNextName.equals("h_renamed")) {
                        c2 = 3;
                    }
                } else if (strNextName.equals("layers")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    strNextString = jsonReader.nextString();
                } else if (c2 == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.oplus.anim.c_renamed.c_renamed.d_renamed dVarA = com.oplus.anim.e_renamed.t_renamed.a_renamed(jsonReader, aVar);
                        longSparseArray.put(dVarA.e_renamed(), dVarA);
                        arrayList.add(dVarA);
                    }
                    jsonReader.endArray();
                } else if (c2 == 2) {
                    iNextInt = jsonReader.nextInt();
                } else if (c2 == 3) {
                    iNextInt2 = jsonReader.nextInt();
                } else if (c2 == 4) {
                    strNextString2 = jsonReader.nextString();
                } else if (c2 == 5) {
                    strNextString3 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.oplus.anim.h_renamed hVar = new com.oplus.anim.h_renamed(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(hVar.a_renamed(), hVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a_renamed(android.util.JsonReader jsonReader, java.util.Map<java.lang.String, com.oplus.anim.c_renamed.d_renamed> map) throws java.io.IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            if (strNextName.hashCode() == 3322014 && strNextName.equals("list")) {
                c2 = 0;
            }
            if (c2 == 0) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.oplus.anim.c_renamed.d_renamed dVarA = com.oplus.anim.e_renamed.l_renamed.a_renamed(jsonReader);
                    map.put(dVarA.b_renamed(), dVarA);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, androidx.collection.SparseArrayCompat<com.oplus.anim.c_renamed.e_renamed> sparseArrayCompat) throws java.io.IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.oplus.anim.c_renamed.e_renamed eVarA = com.oplus.anim.e_renamed.k_renamed.a_renamed(jsonReader, aVar);
            sparseArrayCompat.put(eVarA.hashCode(), eVarA);
        }
        jsonReader.endArray();
    }

    private static void a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, java.util.List<com.oplus.anim.c_renamed.h_renamed> list) throws java.io.IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            java.lang.String strNextString = null;
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                java.lang.String strNextName = jsonReader.nextName();
                char c2 = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3178) {
                    if (iHashCode != 3214) {
                        if (iHashCode == 3705 && strNextName.equals("tm")) {
                            c2 = 1;
                        }
                    } else if (strNextName.equals("dr_renamed")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals("cm_renamed")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    strNextString = jsonReader.nextString();
                } else if (c2 == 1) {
                    fNextDouble = (float) jsonReader.nextDouble();
                } else if (c2 == 2) {
                    fNextDouble2 = (float) jsonReader.nextDouble();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            list.add(new com.oplus.anim.c_renamed.h_renamed(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
