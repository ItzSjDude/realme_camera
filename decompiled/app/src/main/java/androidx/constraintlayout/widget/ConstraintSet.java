package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintSet.java */
/* renamed from: androidx.constraintlayout.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ConstraintSet {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f2565a = {0, 4, 8};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static SparseIntArray f2566c = new SparseIntArray();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HashMap<Integer, PlatformImplementations.kt_3> f2567b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m2188b(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 1:
                return TtmlNode.LEFT;
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return TtmlNode.START;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    static {
        f2566c.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f2566c.append(R.styleable.f2554xd8d194f9, 1);
        f2566c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f2566c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f2566c.append(R.styleable.ConstraintSet_android_orientation, 27);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f2566c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f2566c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f2566c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f2566c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f2566c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f2566c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f2566c.append(R.styleable.f2555x67112bd3, 41);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
        f2566c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f2566c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
        f2566c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
        f2566c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f2566c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
        f2566c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f2566c.append(R.styleable.ConstraintSet_android_layout_width, 23);
        f2566c.append(R.styleable.ConstraintSet_android_layout_height, 21);
        f2566c.append(R.styleable.ConstraintSet_android_visibility, 22);
        f2566c.append(R.styleable.ConstraintSet_android_alpha, 43);
        f2566c.append(R.styleable.ConstraintSet_android_elevation, 44);
        f2566c.append(R.styleable.ConstraintSet_android_rotationX, 45);
        f2566c.append(R.styleable.ConstraintSet_android_rotationY, 46);
        f2566c.append(R.styleable.ConstraintSet_android_rotation, 60);
        f2566c.append(R.styleable.ConstraintSet_android_scaleX, 47);
        f2566c.append(R.styleable.ConstraintSet_android_scaleY, 48);
        f2566c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
        f2566c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
        f2566c.append(R.styleable.ConstraintSet_android_translationX, 51);
        f2566c.append(R.styleable.ConstraintSet_android_translationY, 52);
        f2566c.append(R.styleable.ConstraintSet_android_translationZ, 53);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f2566c.append(R.styleable.ConstraintSet_android_id, 38);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f2566c.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f2566c.append(R.styleable.ConstraintSet_chainUseRtl, 71);
        f2566c.append(R.styleable.ConstraintSet_barrierDirection, 72);
        f2566c.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
        f2566c.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: androidx.constraintlayout.widget.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: A */
        public int f2568A;

        /* renamed from: B */
        public int f2569B;

        /* renamed from: C */
        public int f2570C;

        /* renamed from: D */
        public int f2571D;

        /* renamed from: E */
        public int f2572E;

        /* renamed from: F */
        public int f2573F;

        /* renamed from: G */
        public int f2574G;

        /* renamed from: H */
        public int f2575H;

        /* renamed from: I */
        public int f2576I;

        /* renamed from: J */
        public int f2577J;

        /* renamed from: K */
        public int f2578K;

        /* renamed from: L */
        public int f2579L;

        /* renamed from: M */
        public int f2580M;

        /* renamed from: N */
        public int f2581N;

        /* renamed from: O */
        public int f2582O;

        /* renamed from: P */
        public int f2583P;

        /* renamed from: Q */
        public float f2584Q;

        /* renamed from: R */
        public float f2585R;

        /* renamed from: S */
        public int f2586S;

        /* renamed from: T */
        public int f2587T;

        /* renamed from: U */
        public float f2588U;

        /* renamed from: V */
        public boolean f2589V;

        /* renamed from: W */
        public float f2590W;

        /* renamed from: X */
        public float f2591X;

        /* renamed from: Y */
        public float f2592Y;

        /* renamed from: Z */
        public float f2593Z;

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f2594a;

        /* renamed from: aa */
        public float f2595aa;

        /* renamed from: ab */
        public float f2596ab;

        /* renamed from: ac */
        public float f2597ac;

        /* renamed from: ad */
        public float f2598ad;

        /* renamed from: ae */
        public float f2599ae;

        /* renamed from: af */
        public float f2600af;

        /* renamed from: ag */
        public float f2601ag;

        /* renamed from: ah */
        public boolean f2602ah;

        /* renamed from: ai */
        public boolean f2603ai;

        /* renamed from: aj */
        public int f2604aj;

        /* renamed from: ak */
        public int f2605ak;

        /* renamed from: al */
        public int f2606al;

        /* renamed from: am */
        public int f2607am;

        /* renamed from: an */
        public int f2608an;

        /* renamed from: ao */
        public int f2609ao;

        /* renamed from: ap */
        public float f2610ap;

        /* renamed from: aq */
        public float f2611aq;

        /* renamed from: ar */
        public boolean f2612ar;

        /* renamed from: as */
        public int f2613as;

        /* renamed from: at */
        public int f2614at;

        /* renamed from: au */
        public int[] f2615au;

        /* renamed from: av */
        public String f2616av;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f2617b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f2618c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f2619d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f2620e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f2621f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public float f2622g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int f2623h;

        /* renamed from: OplusGLSurfaceView_13 */
        public int f2624i;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f2625j;

        /* renamed from: OplusGLSurfaceView_5 */
        public int f2626k;

        /* renamed from: OplusGLSurfaceView_14 */
        public int f2627l;

        /* renamed from: OplusGLSurfaceView_6 */
        public int f2628m;

        /* renamed from: OplusGLSurfaceView_11 */
        public int f2629n;

        /* renamed from: o */
        public int f2630o;

        /* renamed from: p */
        public int f2631p;

        /* renamed from: q */
        public int f2632q;

        /* renamed from: r */
        public int f2633r;

        /* renamed from: s */
        public int f2634s;

        /* renamed from: t */
        public int f2635t;

        /* renamed from: u */
        public float f2636u;

        /* renamed from: v */
        public float f2637v;

        /* renamed from: w */
        public String f2638w;

        /* renamed from: x */
        public int f2639x;

        /* renamed from: y */
        public int f2640y;

        /* renamed from: z */
        public float f2641z;

        private PlatformImplementations.kt_3() {
            this.f2594a = false;
            this.f2620e = -1;
            this.f2621f = -1;
            this.f2622g = -1.0f;
            this.f2623h = -1;
            this.f2624i = -1;
            this.f2625j = -1;
            this.f2626k = -1;
            this.f2627l = -1;
            this.f2628m = -1;
            this.f2629n = -1;
            this.f2630o = -1;
            this.f2631p = -1;
            this.f2632q = -1;
            this.f2633r = -1;
            this.f2634s = -1;
            this.f2635t = -1;
            this.f2636u = 0.5f;
            this.f2637v = 0.5f;
            this.f2638w = null;
            this.f2639x = -1;
            this.f2640y = 0;
            this.f2641z = 0.0f;
            this.f2568A = -1;
            this.f2569B = -1;
            this.f2570C = -1;
            this.f2571D = -1;
            this.f2572E = -1;
            this.f2573F = -1;
            this.f2574G = -1;
            this.f2575H = -1;
            this.f2576I = -1;
            this.f2577J = 0;
            this.f2578K = -1;
            this.f2579L = -1;
            this.f2580M = -1;
            this.f2581N = -1;
            this.f2582O = -1;
            this.f2583P = -1;
            this.f2584Q = 0.0f;
            this.f2585R = 0.0f;
            this.f2586S = 0;
            this.f2587T = 0;
            this.f2588U = 1.0f;
            this.f2589V = false;
            this.f2590W = 0.0f;
            this.f2591X = 0.0f;
            this.f2592Y = 0.0f;
            this.f2593Z = 0.0f;
            this.f2595aa = 1.0f;
            this.f2596ab = 1.0f;
            this.f2597ac = Float.NaN;
            this.f2598ad = Float.NaN;
            this.f2599ae = 0.0f;
            this.f2600af = 0.0f;
            this.f2601ag = 0.0f;
            this.f2602ah = false;
            this.f2603ai = false;
            this.f2604aj = 0;
            this.f2605ak = 0;
            this.f2606al = -1;
            this.f2607am = -1;
            this.f2608an = -1;
            this.f2609ao = -1;
            this.f2610ap = 1.0f;
            this.f2611aq = 1.0f;
            this.f2612ar = false;
            this.f2613as = -1;
            this.f2614at = -1;
        }

        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 clone() {
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
            aVar.f2594a = this.f2594a;
            aVar.f2617b = this.f2617b;
            aVar.f2618c = this.f2618c;
            aVar.f2620e = this.f2620e;
            aVar.f2621f = this.f2621f;
            aVar.f2622g = this.f2622g;
            aVar.f2623h = this.f2623h;
            aVar.f2624i = this.f2624i;
            aVar.f2625j = this.f2625j;
            aVar.f2626k = this.f2626k;
            aVar.f2627l = this.f2627l;
            aVar.f2628m = this.f2628m;
            aVar.f2629n = this.f2629n;
            aVar.f2630o = this.f2630o;
            aVar.f2631p = this.f2631p;
            aVar.f2632q = this.f2632q;
            aVar.f2633r = this.f2633r;
            aVar.f2634s = this.f2634s;
            aVar.f2635t = this.f2635t;
            aVar.f2636u = this.f2636u;
            aVar.f2637v = this.f2637v;
            aVar.f2638w = this.f2638w;
            aVar.f2568A = this.f2568A;
            aVar.f2569B = this.f2569B;
            aVar.f2636u = this.f2636u;
            aVar.f2636u = this.f2636u;
            aVar.f2636u = this.f2636u;
            aVar.f2636u = this.f2636u;
            aVar.f2636u = this.f2636u;
            aVar.f2570C = this.f2570C;
            aVar.f2571D = this.f2571D;
            aVar.f2572E = this.f2572E;
            aVar.f2573F = this.f2573F;
            aVar.f2574G = this.f2574G;
            aVar.f2575H = this.f2575H;
            aVar.f2576I = this.f2576I;
            aVar.f2577J = this.f2577J;
            aVar.f2578K = this.f2578K;
            aVar.f2579L = this.f2579L;
            aVar.f2580M = this.f2580M;
            aVar.f2581N = this.f2581N;
            aVar.f2582O = this.f2582O;
            aVar.f2583P = this.f2583P;
            aVar.f2584Q = this.f2584Q;
            aVar.f2585R = this.f2585R;
            aVar.f2586S = this.f2586S;
            aVar.f2587T = this.f2587T;
            aVar.f2588U = this.f2588U;
            aVar.f2589V = this.f2589V;
            aVar.f2590W = this.f2590W;
            aVar.f2591X = this.f2591X;
            aVar.f2592Y = this.f2592Y;
            aVar.f2593Z = this.f2593Z;
            aVar.f2595aa = this.f2595aa;
            aVar.f2596ab = this.f2596ab;
            aVar.f2597ac = this.f2597ac;
            aVar.f2598ad = this.f2598ad;
            aVar.f2599ae = this.f2599ae;
            aVar.f2600af = this.f2600af;
            aVar.f2601ag = this.f2601ag;
            aVar.f2602ah = this.f2602ah;
            aVar.f2603ai = this.f2603ai;
            aVar.f2604aj = this.f2604aj;
            aVar.f2605ak = this.f2605ak;
            aVar.f2606al = this.f2606al;
            aVar.f2607am = this.f2607am;
            aVar.f2608an = this.f2608an;
            aVar.f2609ao = this.f2609ao;
            aVar.f2610ap = this.f2610ap;
            aVar.f2611aq = this.f2611aq;
            aVar.f2613as = this.f2613as;
            aVar.f2614at = this.f2614at;
            int[] iArr = this.f2615au;
            if (iArr != null) {
                aVar.f2615au = Arrays.copyOf(iArr, iArr.length);
            }
            aVar.f2639x = this.f2639x;
            aVar.f2640y = this.f2640y;
            aVar.f2641z = this.f2641z;
            aVar.f2612ar = this.f2612ar;
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m2199a(ConstraintHelper abstractC0400b, int OplusGLSurfaceView_13, Constraints.PlatformImplementations.kt_3 aVar) {
            m2198a(OplusGLSurfaceView_13, aVar);
            if (abstractC0400b instanceof Barrier_2) {
                this.f2614at = 1;
                Barrier_2 c0399a = (Barrier_2) abstractC0400b;
                this.f2613as = c0399a.getType();
                this.f2615au = c0399a.getReferencedIds();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m2198a(int OplusGLSurfaceView_13, Constraints.PlatformImplementations.kt_3 aVar) {
            m2197a(OplusGLSurfaceView_13, (ConstraintLayout.C0398a) aVar);
            this.f2588U = aVar.f2643an;
            this.f2591X = aVar.f2646aq;
            this.f2592Y = aVar.f2647ar;
            this.f2593Z = aVar.f2648as;
            this.f2595aa = aVar.f2649at;
            this.f2596ab = aVar.f2650au;
            this.f2597ac = aVar.f2651av;
            this.f2598ad = aVar.f2652aw;
            this.f2599ae = aVar.f2653ax;
            this.f2600af = aVar.f2654ay;
            this.f2601ag = aVar.f2655az;
            this.f2590W = aVar.f2645ap;
            this.f2589V = aVar.f2644ao;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m2197a(int OplusGLSurfaceView_13, ConstraintLayout.C0398a c0398a) {
            this.f2619d = OplusGLSurfaceView_13;
            this.f2623h = c0398a.f2495d;
            this.f2624i = c0398a.f2496e;
            this.f2625j = c0398a.f2497f;
            this.f2626k = c0398a.f2498g;
            this.f2627l = c0398a.f2499h;
            this.f2628m = c0398a.f2500i;
            this.f2629n = c0398a.f2501j;
            this.f2630o = c0398a.f2502k;
            this.f2631p = c0398a.f2503l;
            this.f2632q = c0398a.f2507p;
            this.f2633r = c0398a.f2508q;
            this.f2634s = c0398a.f2509r;
            this.f2635t = c0398a.f2510s;
            this.f2636u = c0398a.f2517z;
            this.f2637v = c0398a.f2453A;
            this.f2638w = c0398a.f2454B;
            this.f2639x = c0398a.f2504m;
            this.f2640y = c0398a.f2505n;
            this.f2641z = c0398a.f2506o;
            this.f2568A = c0398a.f2469Q;
            this.f2569B = c0398a.f2470R;
            this.f2570C = c0398a.f2471S;
            this.f2622g = c0398a.f2494c;
            this.f2620e = c0398a.f2479a;
            this.f2621f = c0398a.f2493b;
            this.f2617b = c0398a.width;
            this.f2618c = c0398a.height;
            this.f2571D = c0398a.leftMargin;
            this.f2572E = c0398a.rightMargin;
            this.f2573F = c0398a.topMargin;
            this.f2574G = c0398a.bottomMargin;
            this.f2584Q = c0398a.f2458F;
            this.f2585R = c0398a.f2457E;
            this.f2587T = c0398a.f2460H;
            this.f2586S = c0398a.f2459G;
            this.f2602ah = c0398a.f2472T;
            this.f2603ai = c0398a.f2473U;
            this.f2604aj = c0398a.f2461I;
            this.f2605ak = c0398a.f2462J;
            this.f2602ah = c0398a.f2472T;
            this.f2606al = c0398a.f2465M;
            this.f2607am = c0398a.f2466N;
            this.f2608an = c0398a.f2463K;
            this.f2609ao = c0398a.f2464L;
            this.f2610ap = c0398a.f2467O;
            this.f2611aq = c0398a.f2468P;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f2575H = c0398a.getMarginEnd();
                this.f2576I = c0398a.getMarginStart();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2204a(ConstraintLayout.C0398a c0398a) {
            c0398a.f2495d = this.f2623h;
            c0398a.f2496e = this.f2624i;
            c0398a.f2497f = this.f2625j;
            c0398a.f2498g = this.f2626k;
            c0398a.f2499h = this.f2627l;
            c0398a.f2500i = this.f2628m;
            c0398a.f2501j = this.f2629n;
            c0398a.f2502k = this.f2630o;
            c0398a.f2503l = this.f2631p;
            c0398a.f2507p = this.f2632q;
            c0398a.f2508q = this.f2633r;
            c0398a.f2509r = this.f2634s;
            c0398a.f2510s = this.f2635t;
            c0398a.leftMargin = this.f2571D;
            c0398a.rightMargin = this.f2572E;
            c0398a.topMargin = this.f2573F;
            c0398a.bottomMargin = this.f2574G;
            c0398a.f2515x = this.f2583P;
            c0398a.f2516y = this.f2582O;
            c0398a.f2517z = this.f2636u;
            c0398a.f2453A = this.f2637v;
            c0398a.f2504m = this.f2639x;
            c0398a.f2505n = this.f2640y;
            c0398a.f2506o = this.f2641z;
            c0398a.f2454B = this.f2638w;
            c0398a.f2469Q = this.f2568A;
            c0398a.f2470R = this.f2569B;
            c0398a.f2458F = this.f2584Q;
            c0398a.f2457E = this.f2585R;
            c0398a.f2460H = this.f2587T;
            c0398a.f2459G = this.f2586S;
            c0398a.f2472T = this.f2602ah;
            c0398a.f2473U = this.f2603ai;
            c0398a.f2461I = this.f2604aj;
            c0398a.f2462J = this.f2605ak;
            c0398a.f2465M = this.f2606al;
            c0398a.f2466N = this.f2607am;
            c0398a.f2463K = this.f2608an;
            c0398a.f2464L = this.f2609ao;
            c0398a.f2467O = this.f2610ap;
            c0398a.f2468P = this.f2611aq;
            c0398a.f2471S = this.f2570C;
            c0398a.f2494c = this.f2622g;
            c0398a.f2479a = this.f2620e;
            c0398a.f2493b = this.f2621f;
            c0398a.width = this.f2617b;
            c0398a.height = this.f2618c;
            if (Build.VERSION.SDK_INT >= 17) {
                c0398a.setMarginStart(this.f2576I);
                c0398a.setMarginEnd(this.f2575H);
            }
            c0398a.m2175a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2192a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f2567b.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = constraintLayout.getChildAt(OplusGLSurfaceView_13);
            ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) childAt.getLayoutParams();
            int id_renamed = childAt.getId();
            if (id_renamed == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f2567b.containsKey(Integer.valueOf(id_renamed))) {
                this.f2567b.put(Integer.valueOf(id_renamed), new PlatformImplementations.kt_3());
            }
            PlatformImplementations.kt_3 aVar = this.f2567b.get(Integer.valueOf(id_renamed));
            aVar.m2197a(id_renamed, c0398a);
            aVar.f2577J = childAt.getVisibility();
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.f2588U = childAt.getAlpha();
                aVar.f2591X = childAt.getRotation();
                aVar.f2592Y = childAt.getRotationX();
                aVar.f2593Z = childAt.getRotationY();
                aVar.f2595aa = childAt.getScaleX();
                aVar.f2596ab = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    aVar.f2597ac = pivotX;
                    aVar.f2598ad = pivotY;
                }
                aVar.f2599ae = childAt.getTranslationX();
                aVar.f2600af = childAt.getTranslationY();
                if (Build.VERSION.SDK_INT >= 21) {
                    aVar.f2601ag = childAt.getTranslationZ();
                    if (aVar.f2589V) {
                        aVar.f2590W = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof Barrier_2) {
                Barrier_2 c0399a = (Barrier_2) childAt;
                aVar.f2612ar = c0399a.m2177a();
                aVar.f2615au = c0399a.getReferencedIds();
                aVar.f2613as = c0399a.getType();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2193a(Constraints c0402d) {
        int childCount = c0402d.getChildCount();
        this.f2567b.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = c0402d.getChildAt(OplusGLSurfaceView_13);
            Constraints.PlatformImplementations.kt_3 aVar = (Constraints.PlatformImplementations.kt_3) childAt.getLayoutParams();
            int id_renamed = childAt.getId();
            if (id_renamed == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f2567b.containsKey(Integer.valueOf(id_renamed))) {
                this.f2567b.put(Integer.valueOf(id_renamed), new PlatformImplementations.kt_3());
            }
            PlatformImplementations.kt_3 aVar2 = this.f2567b.get(Integer.valueOf(id_renamed));
            if (childAt instanceof ConstraintHelper) {
                aVar2.m2199a((ConstraintHelper) childAt, id_renamed, aVar);
            }
            aVar2.m2198a(id_renamed, aVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2195b(ConstraintLayout constraintLayout) {
        m2196c(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m2196c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2567b.keySet());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = constraintLayout.getChildAt(OplusGLSurfaceView_13);
            int id_renamed = childAt.getId();
            if (id_renamed == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f2567b.containsKey(Integer.valueOf(id_renamed))) {
                hashSet.remove(Integer.valueOf(id_renamed));
                PlatformImplementations.kt_3 aVar = this.f2567b.get(Integer.valueOf(id_renamed));
                if (childAt instanceof Barrier_2) {
                    aVar.f2614at = 1;
                }
                if (aVar.f2614at != -1 && aVar.f2614at == 1) {
                    Barrier_2 c0399a = (Barrier_2) childAt;
                    c0399a.setId(id_renamed);
                    c0399a.setType(aVar.f2613as);
                    c0399a.setAllowsGoneWidget(aVar.f2612ar);
                    if (aVar.f2615au != null) {
                        c0399a.setReferencedIds(aVar.f2615au);
                    } else if (aVar.f2616av != null) {
                        aVar.f2615au = m2187a(c0399a, aVar.f2616av);
                        c0399a.setReferencedIds(aVar.f2615au);
                    }
                }
                ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) childAt.getLayoutParams();
                aVar.m2204a(c0398a);
                childAt.setLayoutParams(c0398a);
                childAt.setVisibility(aVar.f2577J);
                if (Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.f2588U);
                    childAt.setRotation(aVar.f2591X);
                    childAt.setRotationX(aVar.f2592Y);
                    childAt.setRotationY(aVar.f2593Z);
                    childAt.setScaleX(aVar.f2595aa);
                    childAt.setScaleY(aVar.f2596ab);
                    if (!Float.isNaN(aVar.f2597ac)) {
                        childAt.setPivotX(aVar.f2597ac);
                    }
                    if (!Float.isNaN(aVar.f2598ad)) {
                        childAt.setPivotY(aVar.f2598ad);
                    }
                    childAt.setTranslationX(aVar.f2599ae);
                    childAt.setTranslationY(aVar.f2600af);
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.f2601ag);
                        if (aVar.f2589V) {
                            childAt.setElevation(aVar.f2590W);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            PlatformImplementations.kt_3 aVar2 = this.f2567b.get(num);
            if (aVar2.f2614at != -1 && aVar2.f2614at == 1) {
                Barrier_2 c0399a2 = new Barrier_2(constraintLayout.getContext());
                c0399a2.setId(num.intValue());
                if (aVar2.f2615au != null) {
                    c0399a2.setReferencedIds(aVar2.f2615au);
                } else if (aVar2.f2616av != null) {
                    aVar2.f2615au = m2187a(c0399a2, aVar2.f2616av);
                    c0399a2.setReferencedIds(aVar2.f2615au);
                }
                c0399a2.setType(aVar2.f2613as);
                ConstraintLayout.C0398a c0398aM2170a = constraintLayout.generateDefaultLayoutParams();
                c0399a2.m2180b();
                aVar2.m2204a(c0398aM2170a);
                constraintLayout.addView(c0399a2, c0398aM2170a);
            }
            if (aVar2.f2594a) {
                Guideline_2 c0403e = new Guideline_2(constraintLayout.getContext());
                c0403e.setId(num.intValue());
                ConstraintLayout.C0398a c0398aM2170a2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.m2204a(c0398aM2170a2);
                constraintLayout.addView(c0403e, c0398aM2170a2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2190a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (!this.f2567b.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            this.f2567b.put(Integer.valueOf(OplusGLSurfaceView_13), new PlatformImplementations.kt_3());
        }
        PlatformImplementations.kt_3 aVar = this.f2567b.get(Integer.valueOf(OplusGLSurfaceView_13));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    aVar.f2623h = i3;
                    aVar.f2624i = -1;
                    return;
                } else if (i4 == 2) {
                    aVar.f2624i = i3;
                    aVar.f2623h = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + m2188b(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    aVar.f2625j = i3;
                    aVar.f2626k = -1;
                    return;
                } else if (i4 == 2) {
                    aVar.f2626k = i3;
                    aVar.f2625j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m2188b(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    aVar.f2627l = i3;
                    aVar.f2628m = -1;
                    aVar.f2631p = -1;
                    return;
                } else if (i4 == 4) {
                    aVar.f2628m = i3;
                    aVar.f2627l = -1;
                    aVar.f2631p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m2188b(i4) + " undefined");
                }
            case 4:
                if (i4 == 4) {
                    aVar.f2630o = i3;
                    aVar.f2629n = -1;
                    aVar.f2631p = -1;
                    return;
                } else if (i4 == 3) {
                    aVar.f2629n = i3;
                    aVar.f2630o = -1;
                    aVar.f2631p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m2188b(i4) + " undefined");
                }
            case 5:
                if (i4 == 5) {
                    aVar.f2631p = i3;
                    aVar.f2630o = -1;
                    aVar.f2629n = -1;
                    aVar.f2627l = -1;
                    aVar.f2628m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + m2188b(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    aVar.f2633r = i3;
                    aVar.f2632q = -1;
                    return;
                } else if (i4 == 7) {
                    aVar.f2632q = i3;
                    aVar.f2633r = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m2188b(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    aVar.f2635t = i3;
                    aVar.f2634s = -1;
                    return;
                } else if (i4 == 6) {
                    aVar.f2634s = i3;
                    aVar.f2635t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m2188b(i4) + " undefined");
                }
            default:
                throw new IllegalArgumentException(m2188b(i2) + " to " + m2188b(i4) + " unknown");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2189a(int OplusGLSurfaceView_13, int i2) {
        m2184a(OplusGLSurfaceView_13).f2618c = i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2194b(int OplusGLSurfaceView_13, int i2) {
        m2184a(OplusGLSurfaceView_13).f2617b = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m2184a(int OplusGLSurfaceView_13) {
        if (!this.f2567b.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            this.f2567b.put(Integer.valueOf(OplusGLSurfaceView_13), new PlatformImplementations.kt_3());
        }
        return this.f2567b.get(Integer.valueOf(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2191a(Context context, int OplusGLSurfaceView_13) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(OplusGLSurfaceView_13);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    PlatformImplementations.kt_3 aVarM2185a = m2185a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarM2185a.f2594a = true;
                    }
                    this.f2567b.put(Integer.valueOf(aVarM2185a.f2619d), aVarM2185a);
                }
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2183a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        int resourceId = typedArray.getResourceId(OplusGLSurfaceView_13, i2);
        return resourceId == -1 ? typedArray.getInt(OplusGLSurfaceView_13, -1) : resourceId;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m2185a(Context context, AttributeSet attributeSet) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        m2186a(aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2186a(PlatformImplementations.kt_3 aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < indexCount; OplusGLSurfaceView_13++) {
            int index = typedArray.getIndex(OplusGLSurfaceView_13);
            int i2 = f2566c.get(index);
            switch (i2) {
                case 1:
                    aVar.f2631p = m2183a(typedArray, index, aVar.f2631p);
                    break;
                case 2:
                    aVar.f2574G = typedArray.getDimensionPixelSize(index, aVar.f2574G);
                    break;
                case 3:
                    aVar.f2630o = m2183a(typedArray, index, aVar.f2630o);
                    break;
                case 4:
                    aVar.f2629n = m2183a(typedArray, index, aVar.f2629n);
                    break;
                case 5:
                    aVar.f2638w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.f2568A = typedArray.getDimensionPixelOffset(index, aVar.f2568A);
                    break;
                case 7:
                    aVar.f2569B = typedArray.getDimensionPixelOffset(index, aVar.f2569B);
                    break;
                case 8:
                    aVar.f2575H = typedArray.getDimensionPixelSize(index, aVar.f2575H);
                    break;
                case 9:
                    aVar.f2635t = m2183a(typedArray, index, aVar.f2635t);
                    break;
                case 10:
                    aVar.f2634s = m2183a(typedArray, index, aVar.f2634s);
                    break;
                case 11:
                    aVar.f2581N = typedArray.getDimensionPixelSize(index, aVar.f2581N);
                    break;
                case 12:
                    aVar.f2582O = typedArray.getDimensionPixelSize(index, aVar.f2582O);
                    break;
                case 13:
                    aVar.f2578K = typedArray.getDimensionPixelSize(index, aVar.f2578K);
                    break;
                case 14:
                    aVar.f2580M = typedArray.getDimensionPixelSize(index, aVar.f2580M);
                    break;
                case 15:
                    aVar.f2583P = typedArray.getDimensionPixelSize(index, aVar.f2583P);
                    break;
                case 16:
                    aVar.f2579L = typedArray.getDimensionPixelSize(index, aVar.f2579L);
                    break;
                case 17:
                    aVar.f2620e = typedArray.getDimensionPixelOffset(index, aVar.f2620e);
                    break;
                case 18:
                    aVar.f2621f = typedArray.getDimensionPixelOffset(index, aVar.f2621f);
                    break;
                case 19:
                    aVar.f2622g = typedArray.getFloat(index, aVar.f2622g);
                    break;
                case 20:
                    aVar.f2636u = typedArray.getFloat(index, aVar.f2636u);
                    break;
                case 21:
                    aVar.f2618c = typedArray.getLayoutDimension(index, aVar.f2618c);
                    break;
                case 22:
                    aVar.f2577J = typedArray.getInt(index, aVar.f2577J);
                    aVar.f2577J = f2565a[aVar.f2577J];
                    break;
                case 23:
                    aVar.f2617b = typedArray.getLayoutDimension(index, aVar.f2617b);
                    break;
                case 24:
                    aVar.f2571D = typedArray.getDimensionPixelSize(index, aVar.f2571D);
                    break;
                case 25:
                    aVar.f2623h = m2183a(typedArray, index, aVar.f2623h);
                    break;
                case 26:
                    aVar.f2624i = m2183a(typedArray, index, aVar.f2624i);
                    break;
                case 27:
                    aVar.f2570C = typedArray.getInt(index, aVar.f2570C);
                    break;
                case 28:
                    aVar.f2572E = typedArray.getDimensionPixelSize(index, aVar.f2572E);
                    break;
                case 29:
                    aVar.f2625j = m2183a(typedArray, index, aVar.f2625j);
                    break;
                case 30:
                    aVar.f2626k = m2183a(typedArray, index, aVar.f2626k);
                    break;
                case 31:
                    aVar.f2576I = typedArray.getDimensionPixelSize(index, aVar.f2576I);
                    break;
                case 32:
                    aVar.f2632q = m2183a(typedArray, index, aVar.f2632q);
                    break;
                case 33:
                    aVar.f2633r = m2183a(typedArray, index, aVar.f2633r);
                    break;
                case 34:
                    aVar.f2573F = typedArray.getDimensionPixelSize(index, aVar.f2573F);
                    break;
                case 35:
                    aVar.f2628m = m2183a(typedArray, index, aVar.f2628m);
                    break;
                case 36:
                    aVar.f2627l = m2183a(typedArray, index, aVar.f2627l);
                    break;
                case 37:
                    aVar.f2637v = typedArray.getFloat(index, aVar.f2637v);
                    break;
                case 38:
                    aVar.f2619d = typedArray.getResourceId(index, aVar.f2619d);
                    break;
                case 39:
                    aVar.f2585R = typedArray.getFloat(index, aVar.f2585R);
                    break;
                case 40:
                    aVar.f2584Q = typedArray.getFloat(index, aVar.f2584Q);
                    break;
                case 41:
                    aVar.f2586S = typedArray.getInt(index, aVar.f2586S);
                    break;
                case 42:
                    aVar.f2587T = typedArray.getInt(index, aVar.f2587T);
                    break;
                case 43:
                    aVar.f2588U = typedArray.getFloat(index, aVar.f2588U);
                    break;
                case 44:
                    aVar.f2589V = true;
                    aVar.f2590W = typedArray.getDimension(index, aVar.f2590W);
                    break;
                case 45:
                    aVar.f2592Y = typedArray.getFloat(index, aVar.f2592Y);
                    break;
                case 46:
                    aVar.f2593Z = typedArray.getFloat(index, aVar.f2593Z);
                    break;
                case 47:
                    aVar.f2595aa = typedArray.getFloat(index, aVar.f2595aa);
                    break;
                case 48:
                    aVar.f2596ab = typedArray.getFloat(index, aVar.f2596ab);
                    break;
                case 49:
                    aVar.f2597ac = typedArray.getFloat(index, aVar.f2597ac);
                    break;
                case 50:
                    aVar.f2598ad = typedArray.getFloat(index, aVar.f2598ad);
                    break;
                case 51:
                    aVar.f2599ae = typedArray.getDimension(index, aVar.f2599ae);
                    break;
                case 52:
                    aVar.f2600af = typedArray.getDimension(index, aVar.f2600af);
                    break;
                case 53:
                    aVar.f2601ag = typedArray.getDimension(index, aVar.f2601ag);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            aVar.f2591X = typedArray.getFloat(index, aVar.f2591X);
                            break;
                        case 61:
                            aVar.f2639x = m2183a(typedArray, index, aVar.f2639x);
                            break;
                        case 62:
                            aVar.f2640y = typedArray.getDimensionPixelSize(index, aVar.f2640y);
                            break;
                        case 63:
                            aVar.f2641z = typedArray.getFloat(index, aVar.f2641z);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    aVar.f2610ap = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    aVar.f2611aq = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.COUIBaseListPopupWindow_8("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    aVar.f2613as = typedArray.getInt(index, aVar.f2613as);
                                    break;
                                case 73:
                                    aVar.f2616av = typedArray.getString(index);
                                    break;
                                case 74:
                                    aVar.f2612ar = typedArray.getBoolean(index, aVar.f2612ar);
                                    break;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2566c.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f2566c.get(index));
                                    break;
                            }
                    }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] m2187a(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objM2172a;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < strArrSplit.length) {
            String strTrim = strArrSplit[OplusGLSurfaceView_13].trim();
            try {
                iIntValue = R.id_renamed.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, TtmlNode.ATTR_ID, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objM2172a = ((ConstraintLayout) view.getParent()).m2172a(0, strTrim)) != null && (objM2172a instanceof Integer)) {
                iIntValue = ((Integer) objM2172a).intValue();
            }
            iArr[i2] = iIntValue;
            OplusGLSurfaceView_13++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }
}
