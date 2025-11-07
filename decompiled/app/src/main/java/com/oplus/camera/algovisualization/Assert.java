package com.oplus.camera.algovisualization;

/* compiled from: AlgoListProcessor.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static void a_renamed(android.text.SpannableStringBuilder spannableStringBuilder, java.lang.String str) {
        spannableStringBuilder.append((java.lang.CharSequence) str);
        spannableStringBuilder.append(": ");
        spannableStringBuilder.append("\n_renamed");
    }

    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:27:0x0059. Please report as_renamed an_renamed issue. */
    public static java.util.ArrayList<android.text.SpannableStringBuilder> a_renamed(java.lang.String str, java.lang.String str2, java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<java.lang.String> arrayList2, int i_renamed, java.lang.String str3, java.lang.String str4, int i2) {
        java.util.ArrayList<android.text.SpannableStringBuilder> arrayList3 = new java.util.ArrayList<>();
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            java.lang.String[] strArrSplit = str.split(";");
            java.lang.String[] strArrSplit2 = str2.split(";");
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            android.text.SpannableStringBuilder spannableStringBuilder2 = new android.text.SpannableStringBuilder();
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                if (14 == i3 || 16 == i3 || !"none".equals(strArrSplit2[i3])) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 == 9) {
                                        a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                        android.text.SpannableString spannableString = new android.text.SpannableString(java.lang.String.valueOf(strArrSplit2[i3]));
                                        spannableString.setSpan(new android.text.style.ForegroundColorSpan(android.graphics.Color.parseColor("#ffffff")), 0, spannableString.length(), 34);
                                        spannableStringBuilder2.append((java.lang.CharSequence) spannableString);
                                        spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                    } else {
                                        switch (i3) {
                                            case 13:
                                                a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                                spannableStringBuilder2.append((java.lang.CharSequence) a_renamed(strArrSplit2[i3].split(","), java.lang.Integer.parseInt(strArrSplit2[i3 - 1])));
                                                spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                                break;
                                            case 14:
                                                if (arrayList.size() != 0 || !"none".equals(strArrSplit2[i3])) {
                                                    a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                                    java.lang.String strA = a_renamed(strArrSplit2[i3].split(","), arrayList, strArrSplit2[i3 + 1], str3);
                                                    if (strA.length() > 20) {
                                                        a_renamed(strA, 4, spannableStringBuilder, spannableStringBuilder2);
                                                        break;
                                                    } else {
                                                        spannableStringBuilder2.append((java.lang.CharSequence) strA);
                                                        spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 15:
                                                break;
                                            case 16:
                                                if (arrayList2.size() == 0 && "none".equals(strArrSplit2[i3])) {
                                                    spannableStringBuilder.append((java.lang.CharSequence) "PreAlgoList: ");
                                                    spannableStringBuilder.append((java.lang.CharSequence) "\n_renamed");
                                                    if (com.oplus.camera.algovisualization.g_renamed.b_renamed() > 0) {
                                                        spannableStringBuilder2.append((java.lang.CharSequence) "[ASD:0ms, FB:0ms]");
                                                    } else {
                                                        spannableStringBuilder2.append((java.lang.CharSequence) "[ASD:0ms]");
                                                    }
                                                    spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                                } else {
                                                    a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                                    java.lang.String strA2 = a_renamed(strArrSplit2[i3].split(","), arrayList2);
                                                    if (strA2.length() > 20) {
                                                        a_renamed(strA2, 2, spannableStringBuilder, spannableStringBuilder2);
                                                    } else {
                                                        spannableStringBuilder2.append((java.lang.CharSequence) strA2);
                                                        spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                                    }
                                                    break;
                                                }
                                                break;
                                            default:
                                                if (strArrSplit2[i3].length() > 20) {
                                                    a_renamed(strArrSplit2[i3], 3, spannableStringBuilder, spannableStringBuilder2);
                                                } else {
                                                    a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                                    spannableStringBuilder2.append((java.lang.CharSequence) strArrSplit2[i3]);
                                                    spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                    spannableStringBuilder.append((java.lang.CharSequence) "\n_renamed");
                                    if (i_renamed >= 42) {
                                        android.text.SpannableString spannableString2 = new android.text.SpannableString(java.lang.String.valueOf(i_renamed));
                                        spannableString2.setSpan(new android.text.style.ForegroundColorSpan(android.graphics.Color.parseColor("#ff0000")), 0, spannableString2.length(), 34);
                                        spannableStringBuilder2.append((java.lang.CharSequence) spannableString2);
                                    } else {
                                        spannableStringBuilder2.append((java.lang.CharSequence) java.lang.String.valueOf(i_renamed));
                                    }
                                    spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                    spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                }
                            } else {
                                a_renamed(spannableStringBuilder, strArrSplit[i3]);
                                if (strArrSplit2[i3] != null) {
                                    com.oplus.camera.algovisualization.g_renamed.a_renamed(java.lang.Integer.parseInt(strArrSplit2[i3]));
                                    spannableStringBuilder2.append((java.lang.CharSequence) strArrSplit2[i3]);
                                    spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                                }
                            }
                        } else {
                            a_renamed(spannableStringBuilder, strArrSplit[i3]);
                            spannableStringBuilder2.append((java.lang.CharSequence) str4);
                            spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                        }
                    } else {
                        a_renamed(spannableStringBuilder, strArrSplit[i3]);
                        if ("none".equals(strArrSplit2[i3])) {
                            spannableStringBuilder2.append((java.lang.CharSequence) java.lang.String.valueOf(i2));
                            spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                        }
                        spannableStringBuilder2.append((java.lang.CharSequence) strArrSplit2[i3]);
                        spannableStringBuilder2.append((java.lang.CharSequence) "\n_renamed");
                    }
                }
            }
            arrayList3.add(spannableStringBuilder);
            arrayList3.add(spannableStringBuilder2);
        }
        return arrayList3;
    }

    public static void a_renamed(java.lang.String str, int i_renamed, android.text.SpannableStringBuilder spannableStringBuilder, android.text.SpannableStringBuilder spannableStringBuilder2) {
        java.lang.String[] strArrSplit = str.split(",");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            if (i3 != strArrSplit.length - 1) {
                if ((i3 + 1) % i_renamed == 0) {
                    i2++;
                    sb.append(strArrSplit[i3]);
                    sb.append(",");
                    sb.append("\n_renamed");
                } else {
                    sb.append(strArrSplit[i3]);
                    sb.append(",");
                }
            } else {
                sb.append(strArrSplit[i3]);
            }
        }
        spannableStringBuilder2.append((java.lang.CharSequence) sb);
        spannableStringBuilder2.append("\n_renamed");
        a_renamed(spannableStringBuilder, i2);
    }

    public static void a_renamed(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            spannableStringBuilder.append("\n_renamed");
        }
    }

    public static java.lang.String a_renamed(java.lang.String[] strArr, int i_renamed) {
        if (strArr == null) {
            return "[0]";
        }
        java.lang.String[] strArr2 = new java.lang.String[i_renamed];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            strArr2[i2] = strArr[i2];
        }
        return java.util.Arrays.toString(strArr2);
    }

    public static java.lang.String a_renamed(java.lang.String[] strArr, java.util.ArrayList<java.lang.String> arrayList, java.lang.String str, java.lang.String str2) {
        java.lang.String string;
        java.lang.String str3 = "[" + str + "]";
        if (strArr == null && arrayList == null) {
            string = "[]";
        } else {
            int i_renamed = 0;
            if (arrayList != null && strArr == null) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                while (i_renamed < arrayList.size()) {
                    if (!android.text.TextUtils.equals(arrayList.get(i_renamed), "none")) {
                        arrayList2.add(arrayList.get(i_renamed));
                    }
                    i_renamed++;
                }
                string = arrayList2.toString();
            } else if (arrayList == null) {
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                while (i_renamed < strArr.length) {
                    if (!android.text.TextUtils.equals(strArr[i_renamed], "none")) {
                        arrayList3.add(strArr[i_renamed]);
                    }
                    i_renamed++;
                }
                string = arrayList3.toString();
            } else {
                java.util.ArrayList arrayList4 = new java.util.ArrayList(java.util.Arrays.asList(strArr));
                java.util.ArrayList arrayList5 = new java.util.ArrayList();
                java.util.ArrayList arrayList6 = new java.util.ArrayList();
                arrayList5.addAll(arrayList4);
                arrayList5.addAll(arrayList);
                while (i_renamed < arrayList5.size()) {
                    if (!android.text.TextUtils.equals((java.lang.CharSequence) arrayList5.get(i_renamed), "none")) {
                        arrayList6.add((java.lang.String) arrayList5.get(i_renamed));
                    }
                    i_renamed++;
                }
                string = arrayList6.toString();
            }
        }
        if (!android.text.TextUtils.equals(str2, "portrait")) {
            return string;
        }
        return string + str3;
    }

    public static java.lang.String a_renamed(java.lang.String[] strArr, java.util.ArrayList<java.lang.String> arrayList) {
        if (strArr == null && arrayList == null) {
            return "[]";
        }
        if (arrayList != null && strArr == null) {
            return a_renamed(arrayList);
        }
        if (arrayList == null) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
                if (!android.text.TextUtils.equals(strArr[i_renamed], "none")) {
                    arrayList2.add(strArr[i_renamed]);
                }
            }
            return arrayList2.toString();
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList(java.util.Arrays.asList(strArr));
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        arrayList4.addAll(arrayList3);
        arrayList4.addAll(arrayList);
        return a_renamed(arrayList4);
    }

    public static java.lang.String a_renamed(java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            if (!android.text.TextUtils.equals(list.get(i_renamed), "none")) {
                arrayList.add(list.get(i_renamed));
            }
        }
        return arrayList.toString();
    }

    public static java.lang.String a_renamed(long j_renamed, long j2) {
        return ((j2 - j_renamed) / 1000000) + "ms";
    }

    public static long a_renamed() {
        return java.lang.System.nanoTime();
    }
}
