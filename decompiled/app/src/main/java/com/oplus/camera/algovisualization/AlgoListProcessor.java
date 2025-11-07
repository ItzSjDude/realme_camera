package com.oplus.camera.algovisualization;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: AlgoListProcessor.java */
/* renamed from: com.oplus.camera.algovisualization.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AlgoListProcessor {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11599a(SpannableStringBuilder spannableStringBuilder, String str) {
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append(": ");
        spannableStringBuilder.append("\OplusGLSurfaceView_11");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0059. Please report as an issue. */
    /* renamed from: PlatformImplementations.kt_3 */
    public static ArrayList<SpannableStringBuilder> m11597a(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, int OplusGLSurfaceView_13, String str3, String str4, int i2) {
        ArrayList<SpannableStringBuilder> arrayList3 = new ArrayList<>();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split(";");
            String[] strArrSplit2 = str2.split(";");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                if (14 == i3 || 16 == i3 || !"none".equals(strArrSplit2[i3])) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 == 9) {
                                        m11599a(spannableStringBuilder, strArrSplit[i3]);
                                        SpannableString spannableString = new SpannableString(String.valueOf(strArrSplit2[i3]));
                                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, spannableString.length(), 34);
                                        spannableStringBuilder2.append((CharSequence) spannableString);
                                        spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                    } else {
                                        switch (i3) {
                                            case 13:
                                                m11599a(spannableStringBuilder, strArrSplit[i3]);
                                                spannableStringBuilder2.append((CharSequence) m11594a(strArrSplit2[i3].split(","), Integer.parseInt(strArrSplit2[i3 - 1])));
                                                spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                                break;
                                            case 14:
                                                if (arrayList.size() != 0 || !"none".equals(strArrSplit2[i3])) {
                                                    m11599a(spannableStringBuilder, strArrSplit[i3]);
                                                    String strM11596a = m11596a(strArrSplit2[i3].split(","), arrayList, strArrSplit2[i3 + 1], str3);
                                                    if (strM11596a.length() > 20) {
                                                        m11600a(strM11596a, 4, spannableStringBuilder, spannableStringBuilder2);
                                                        break;
                                                    } else {
                                                        spannableStringBuilder2.append((CharSequence) strM11596a);
                                                        spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 15:
                                                break;
                                            case 16:
                                                if (arrayList2.size() == 0 && "none".equals(strArrSplit2[i3])) {
                                                    spannableStringBuilder.append((CharSequence) "PreAlgoList: ");
                                                    spannableStringBuilder.append((CharSequence) "\OplusGLSurfaceView_11");
                                                    if (DataProcessorUtils.m11624b() > 0) {
                                                        spannableStringBuilder2.append((CharSequence) "[ASD:0ms, FB:0ms]");
                                                    } else {
                                                        spannableStringBuilder2.append((CharSequence) "[ASD:0ms]");
                                                    }
                                                    spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                                } else {
                                                    m11599a(spannableStringBuilder, strArrSplit[i3]);
                                                    String strM11595a = m11595a(strArrSplit2[i3].split(","), arrayList2);
                                                    if (strM11595a.length() > 20) {
                                                        m11600a(strM11595a, 2, spannableStringBuilder, spannableStringBuilder2);
                                                    } else {
                                                        spannableStringBuilder2.append((CharSequence) strM11595a);
                                                        spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                                    }
                                                    break;
                                                }
                                                break;
                                            default:
                                                if (strArrSplit2[i3].length() > 20) {
                                                    m11600a(strArrSplit2[i3], 3, spannableStringBuilder, spannableStringBuilder2);
                                                } else {
                                                    m11599a(spannableStringBuilder, strArrSplit[i3]);
                                                    spannableStringBuilder2.append((CharSequence) strArrSplit2[i3]);
                                                    spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    m11599a(spannableStringBuilder, strArrSplit[i3]);
                                    spannableStringBuilder.append((CharSequence) "\OplusGLSurfaceView_11");
                                    if (OplusGLSurfaceView_13 >= 42) {
                                        SpannableString spannableString2 = new SpannableString(String.valueOf(OplusGLSurfaceView_13));
                                        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), 0, spannableString2.length(), 34);
                                        spannableStringBuilder2.append((CharSequence) spannableString2);
                                    } else {
                                        spannableStringBuilder2.append((CharSequence) String.valueOf(OplusGLSurfaceView_13));
                                    }
                                    spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                    spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                }
                            } else {
                                m11599a(spannableStringBuilder, strArrSplit[i3]);
                                if (strArrSplit2[i3] != null) {
                                    DataProcessorUtils.m11622a(Integer.parseInt(strArrSplit2[i3]));
                                    spannableStringBuilder2.append((CharSequence) strArrSplit2[i3]);
                                    spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                                }
                            }
                        } else {
                            m11599a(spannableStringBuilder, strArrSplit[i3]);
                            spannableStringBuilder2.append((CharSequence) str4);
                            spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                        }
                    } else {
                        m11599a(spannableStringBuilder, strArrSplit[i3]);
                        if ("none".equals(strArrSplit2[i3])) {
                            spannableStringBuilder2.append((CharSequence) String.valueOf(i2));
                            spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                        }
                        spannableStringBuilder2.append((CharSequence) strArrSplit2[i3]);
                        spannableStringBuilder2.append((CharSequence) "\OplusGLSurfaceView_11");
                    }
                }
            }
            arrayList3.add(spannableStringBuilder);
            arrayList3.add(spannableStringBuilder2);
        }
        return arrayList3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11600a(String str, int OplusGLSurfaceView_13, SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2) {
        String[] strArrSplit = str.split(",");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            if (i3 != strArrSplit.length - 1) {
                if ((i3 + 1) % OplusGLSurfaceView_13 == 0) {
                    i2++;
                    sb.append(strArrSplit[i3]);
                    sb.append(",");
                    sb.append("\OplusGLSurfaceView_11");
                } else {
                    sb.append(strArrSplit[i3]);
                    sb.append(",");
                }
            } else {
                sb.append(strArrSplit[i3]);
            }
        }
        spannableStringBuilder2.append((CharSequence) sb);
        spannableStringBuilder2.append("\OplusGLSurfaceView_11");
        m11598a(spannableStringBuilder, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11598a(SpannableStringBuilder spannableStringBuilder, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            spannableStringBuilder.append("\OplusGLSurfaceView_11");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11594a(String[] strArr, int OplusGLSurfaceView_13) {
        if (strArr == null) {
            return "[0]";
        }
        String[] strArr2 = new String[OplusGLSurfaceView_13];
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            strArr2[i2] = strArr[i2];
        }
        return Arrays.toString(strArr2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11596a(String[] strArr, ArrayList<String> arrayList, String str, String str2) {
        String string;
        String str3 = "[" + str + "]";
        if (strArr == null && arrayList == null) {
            string = "[]";
        } else {
            int OplusGLSurfaceView_13 = 0;
            if (arrayList != null && strArr == null) {
                ArrayList arrayList2 = new ArrayList();
                while (OplusGLSurfaceView_13 < arrayList.size()) {
                    if (!TextUtils.equals(arrayList.get(OplusGLSurfaceView_13), "none")) {
                        arrayList2.add(arrayList.get(OplusGLSurfaceView_13));
                    }
                    OplusGLSurfaceView_13++;
                }
                string = arrayList2.toString();
            } else if (arrayList == null) {
                ArrayList arrayList3 = new ArrayList();
                while (OplusGLSurfaceView_13 < strArr.length) {
                    if (!TextUtils.equals(strArr[OplusGLSurfaceView_13], "none")) {
                        arrayList3.add(strArr[OplusGLSurfaceView_13]);
                    }
                    OplusGLSurfaceView_13++;
                }
                string = arrayList3.toString();
            } else {
                ArrayList arrayList4 = new ArrayList(Arrays.asList(strArr));
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                arrayList5.addAll(arrayList4);
                arrayList5.addAll(arrayList);
                while (OplusGLSurfaceView_13 < arrayList5.size()) {
                    if (!TextUtils.equals((CharSequence) arrayList5.get(OplusGLSurfaceView_13), "none")) {
                        arrayList6.add((String) arrayList5.get(OplusGLSurfaceView_13));
                    }
                    OplusGLSurfaceView_13++;
                }
                string = arrayList6.toString();
            }
        }
        if (!TextUtils.equals(str2, "portrait")) {
            return string;
        }
        return string + str3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11595a(String[] strArr, ArrayList<String> arrayList) {
        if (strArr == null && arrayList == null) {
            return "[]";
        }
        if (arrayList != null && strArr == null) {
            return m11593a(arrayList);
        }
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
                if (!TextUtils.equals(strArr[OplusGLSurfaceView_13], "none")) {
                    arrayList2.add(strArr[OplusGLSurfaceView_13]);
                }
            }
            return arrayList2.toString();
        }
        ArrayList arrayList3 = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList3);
        arrayList4.addAll(arrayList);
        return m11593a(arrayList4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11593a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            if (!TextUtils.equals(list.get(OplusGLSurfaceView_13), "none")) {
                arrayList.add(list.get(OplusGLSurfaceView_13));
            }
        }
        return arrayList.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11592a(long OplusGLSurfaceView_15, long j2) {
        return ((j2 - OplusGLSurfaceView_15) / 1000000) + "ms";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static long m11591a() {
        return System.nanoTime();
    }
}
