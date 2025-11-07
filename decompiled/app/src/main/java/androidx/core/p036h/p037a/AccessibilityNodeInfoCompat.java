package androidx.core.p036h.p037a;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.p036h.p037a.AccessibilityViewCommand;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.oplus.tblplayer.config.PreCacheConfig;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f2999d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AccessibilityNodeInfo f3001b;

    /* renamed from: PlatformImplementations.kt_3 */
    public int f3000a = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f3002c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static String m2670d(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            return "ACTION_FOCUS";
        }
        if (OplusGLSurfaceView_13 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (OplusGLSurfaceView_13) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE /* 262144 */:
                return "ACTION_EXPAND";
            case STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM /* 524288 */:
                return "ACTION_COLLAPSE";
            case PreCacheConfig.DEFAULT_MAX_CACHE_FILE_SIZE /* 2097152 */:
                return "ACTION_SET_TEXT";
            case R.id_renamed.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (OplusGLSurfaceView_13) {
                    case R.id_renamed.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id_renamed.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id_renamed.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id_renamed.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id_renamed.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id_renamed.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id_renamed.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id_renamed.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (OplusGLSurfaceView_13) {
                            case R.id_renamed.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id_renamed.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id_renamed.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id_renamed.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id_renamed.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id_renamed.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: A */
        public static final PlatformImplementations.kt_3 f3003A;

        /* renamed from: B */
        public static final PlatformImplementations.kt_3 f3004B;

        /* renamed from: C */
        public static final PlatformImplementations.kt_3 f3005C;

        /* renamed from: D */
        public static final PlatformImplementations.kt_3 f3006D;

        /* renamed from: E */
        public static final PlatformImplementations.kt_3 f3007E;

        /* renamed from: F */
        public static final PlatformImplementations.kt_3 f3008F;

        /* renamed from: G */
        public static final PlatformImplementations.kt_3 f3009G;

        /* renamed from: H */
        public static final PlatformImplementations.kt_3 f3010H;

        /* renamed from: I */
        public static final PlatformImplementations.kt_3 f3011I;

        /* renamed from: J */
        public static final PlatformImplementations.kt_3 f3012J;

        /* renamed from: K */
        public static final PlatformImplementations.kt_3 f3013K;

        /* renamed from: PlatformImplementations.kt_3 */
        public static final PlatformImplementations.kt_3 f3014a = new PlatformImplementations.kt_3(1, null);

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static final PlatformImplementations.kt_3 f3015b = new PlatformImplementations.kt_3(2, null);

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static final PlatformImplementations.kt_3 f3016c = new PlatformImplementations.kt_3(4, null);

        /* renamed from: IntrinsicsJvm.kt_5 */
        public static final PlatformImplementations.kt_3 f3017d = new PlatformImplementations.kt_3(8, null);

        /* renamed from: COUIBaseListPopupWindow_8 */
        public static final PlatformImplementations.kt_3 f3018e = new PlatformImplementations.kt_3(16, null);

        /* renamed from: COUIBaseListPopupWindow_12 */
        public static final PlatformImplementations.kt_3 f3019f = new PlatformImplementations.kt_3(32, null);

        /* renamed from: COUIBaseListPopupWindow_11 */
        public static final PlatformImplementations.kt_3 f3020g = new PlatformImplementations.kt_3(64, null);

        /* renamed from: COUIBaseListPopupWindow_10 */
        public static final PlatformImplementations.kt_3 f3021h = new PlatformImplementations.kt_3(128, null);

        /* renamed from: OplusGLSurfaceView_13 */
        public static final PlatformImplementations.kt_3 f3022i = new PlatformImplementations.kt_3(256, null, AccessibilityViewCommand.IntrinsicsJvm.kt_4.class);

        /* renamed from: OplusGLSurfaceView_15 */
        public static final PlatformImplementations.kt_3 f3023j = new PlatformImplementations.kt_3(512, null, AccessibilityViewCommand.IntrinsicsJvm.kt_4.class);

        /* renamed from: OplusGLSurfaceView_5 */
        public static final PlatformImplementations.kt_3 f3024k = new PlatformImplementations.kt_3(1024, null, AccessibilityViewCommand.IntrinsicsJvm.kt_3.class);

        /* renamed from: OplusGLSurfaceView_14 */
        public static final PlatformImplementations.kt_3 f3025l = new PlatformImplementations.kt_3(2048, null, AccessibilityViewCommand.IntrinsicsJvm.kt_3.class);

        /* renamed from: OplusGLSurfaceView_6 */
        public static final PlatformImplementations.kt_3 f3026m = new PlatformImplementations.kt_3(4096, null);

        /* renamed from: OplusGLSurfaceView_11 */
        public static final PlatformImplementations.kt_3 f3027n = new PlatformImplementations.kt_3(8192, null);

        /* renamed from: o */
        public static final PlatformImplementations.kt_3 f3028o = new PlatformImplementations.kt_3(16384, null);

        /* renamed from: p */
        public static final PlatformImplementations.kt_3 f3029p = new PlatformImplementations.kt_3(32768, null);

        /* renamed from: q */
        public static final PlatformImplementations.kt_3 f3030q = new PlatformImplementations.kt_3(65536, null);

        /* renamed from: r */
        public static final PlatformImplementations.kt_3 f3031r = new PlatformImplementations.kt_3(131072, null, AccessibilityViewCommand.COUIBaseListPopupWindow_11.class);

        /* renamed from: s */
        public static final PlatformImplementations.kt_3 f3032s = new PlatformImplementations.kt_3(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE, null);

        /* renamed from: t */
        public static final PlatformImplementations.kt_3 f3033t = new PlatformImplementations.kt_3(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM, null);

        /* renamed from: u */
        public static final PlatformImplementations.kt_3 f3034u = new PlatformImplementations.kt_3(ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, null);

        /* renamed from: v */
        public static final PlatformImplementations.kt_3 f3035v = new PlatformImplementations.kt_3(PreCacheConfig.DEFAULT_MAX_CACHE_FILE_SIZE, null, AccessibilityViewCommand.COUIBaseListPopupWindow_10.class);

        /* renamed from: w */
        public static final PlatformImplementations.kt_3 f3036w;

        /* renamed from: x */
        public static final PlatformImplementations.kt_3 f3037x;

        /* renamed from: y */
        public static final PlatformImplementations.kt_3 f3038y;

        /* renamed from: z */
        public static final PlatformImplementations.kt_3 f3039z;

        /* renamed from: L */
        final Object f3040L;

        /* renamed from: M */
        protected final AccessibilityViewCommand f3041M;

        /* renamed from: N */
        private final int f3042N;

        /* renamed from: O */
        private final Class<? extends AccessibilityViewCommand.PlatformImplementations.kt_3> f3043O;

        static {
            f3036w = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id_renamed.accessibilityActionShowOnScreen, null, null, null);
            f3037x = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id_renamed.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.COUIBaseListPopupWindow_8.class);
            f3038y = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id_renamed.accessibilityActionScrollUp, null, null, null);
            f3039z = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id_renamed.accessibilityActionScrollLeft, null, null, null);
            f3003A = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id_renamed.accessibilityActionScrollDown, null, null, null);
            f3004B = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id_renamed.accessibilityActionScrollRight, null, null, null);
            f3005C = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id_renamed.accessibilityActionPageUp, null, null, null);
            f3006D = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id_renamed.accessibilityActionPageDown, null, null, null);
            f3007E = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id_renamed.accessibilityActionPageLeft, null, null, null);
            f3008F = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id_renamed.accessibilityActionPageRight, null, null, null);
            f3009G = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id_renamed.accessibilityActionContextClick, null, null, null);
            f3010H = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id_renamed.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.COUIBaseListPopupWindow_12.class);
            f3011I = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id_renamed.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.IntrinsicsJvm.kt_5.class);
            f3012J = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id_renamed.accessibilityActionShowTooltip, null, null, null);
            f3013K = new PlatformImplementations.kt_3(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id_renamed.accessibilityActionHideTooltip, null, null, null);
        }

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, CharSequence charSequence) {
            this(null, OplusGLSurfaceView_13, charSequence, null, null);
        }

        PlatformImplementations.kt_3(Object obj) {
            this(obj, 0, null, null, null);
        }

        private PlatformImplementations.kt_3(int OplusGLSurfaceView_13, CharSequence charSequence, Class<? extends AccessibilityViewCommand.PlatformImplementations.kt_3> cls) {
            this(null, OplusGLSurfaceView_13, charSequence, null, cls);
        }

        PlatformImplementations.kt_3(Object obj, int OplusGLSurfaceView_13, CharSequence charSequence, AccessibilityViewCommand interfaceC0486g, Class<? extends AccessibilityViewCommand.PlatformImplementations.kt_3> cls) {
            this.f3042N = OplusGLSurfaceView_13;
            this.f3041M = interfaceC0486g;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f3040L = new AccessibilityNodeInfo.AccessibilityAction(OplusGLSurfaceView_13, charSequence);
            } else {
                this.f3040L = obj;
            }
            this.f3043O = cls;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m2736a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f3040L).getId();
            }
            return 0;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CharSequence m2739b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f3040L).getLabel();
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m2738a(View view, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            AccessibilityViewCommand.PlatformImplementations.kt_3 aVarNewInstance;
            if (this.f3041M == null) {
                return false;
            }
            AccessibilityViewCommand.PlatformImplementations.kt_3 aVar = null;
            Class<? extends AccessibilityViewCommand.PlatformImplementations.kt_3> cls = this.f3043O;
            if (cls != null) {
                try {
                    aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                }
                try {
                    aVarNewInstance.m2757a(bundle);
                    aVar = aVarNewInstance;
                } catch (Exception e2) {
                    COUIBaseListPopupWindow_8 = e2;
                    aVar = aVarNewInstance;
                    Class<? extends AccessibilityViewCommand.PlatformImplementations.kt_3> cls2 = this.f3043O;
                    Log.COUIBaseListPopupWindow_8("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), COUIBaseListPopupWindow_8);
                    return this.f3041M.perform(view, aVar);
                }
            }
            return this.f3041M.perform(view, aVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m2737a(CharSequence charSequence, AccessibilityViewCommand interfaceC0486g) {
            return new PlatformImplementations.kt_3(null, this.f3042N, charSequence, interfaceC0486g, this.f3043O);
        }

        public int hashCode() {
            Object obj = this.f3040L;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof PlatformImplementations.kt_3)) {
                return false;
            }
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) obj;
            Object obj2 = this.f3040L;
            return obj2 == null ? aVar.f3040L == null : obj2.equals(aVar.f3040L);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Object f3044a;

        /* renamed from: PlatformImplementations.kt_3 */
        public static IntrinsicsJvm.kt_4 m2741a(int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new IntrinsicsJvm.kt_4(AccessibilityNodeInfo.CollectionInfo.obtain(OplusGLSurfaceView_13, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new IntrinsicsJvm.kt_4(AccessibilityNodeInfo.CollectionInfo.obtain(OplusGLSurfaceView_13, i2, z));
            }
            return new IntrinsicsJvm.kt_4(null);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IntrinsicsJvm.kt_4 m2740a(int OplusGLSurfaceView_13, int i2, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new IntrinsicsJvm.kt_4(AccessibilityNodeInfo.CollectionInfo.obtain(OplusGLSurfaceView_13, i2, z));
            }
            return new IntrinsicsJvm.kt_4(null);
        }

        IntrinsicsJvm.kt_4(Object obj) {
            this.f3044a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Object f3045a;

        /* renamed from: PlatformImplementations.kt_3 */
        public static IntrinsicsJvm.kt_3 m2742a(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new IntrinsicsJvm.kt_3(AccessibilityNodeInfo.CollectionItemInfo.obtain(OplusGLSurfaceView_13, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new IntrinsicsJvm.kt_3(AccessibilityNodeInfo.CollectionItemInfo.obtain(OplusGLSurfaceView_13, i2, i3, i4, z));
            }
            return new IntrinsicsJvm.kt_3(null);
        }

        IntrinsicsJvm.kt_3(Object obj) {
            this.f3045a = obj;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m2743a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f3045a).getColumnIndex();
            }
            return 0;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m2744b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f3045a).getColumnSpan();
            }
            return 0;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m2745c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f3045a).getRowIndex();
            }
            return 0;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m2746d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f3045a).getRowSpan();
            }
            return 0;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m2747e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f3045a).isSelected();
            }
            return false;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Object f3046a;

        /* renamed from: PlatformImplementations.kt_3 */
        public static IntrinsicsJvm.kt_5 m2748a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2, float f3) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new IntrinsicsJvm.kt_5(AccessibilityNodeInfo.RangeInfo.obtain(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, f2, f3));
            }
            return new IntrinsicsJvm.kt_5(null);
        }

        IntrinsicsJvm.kt_5(Object obj) {
            this.f3046a = obj;
        }
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3001b = accessibilityNodeInfo;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AccessibilityNodeInfoCompat m2661a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AccessibilityNodeInfo m2675a() {
        return this.f3001b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AccessibilityNodeInfoCompat m2660a(View view) {
        return m2661a(AccessibilityNodeInfo.obtain(view));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static AccessibilityNodeInfoCompat m2666b() {
        return m2661a(AccessibilityNodeInfo.obtain());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AccessibilityNodeInfoCompat m2662a(AccessibilityNodeInfoCompat c0483d) {
        return m2661a(AccessibilityNodeInfo.obtain(c0483d.f3001b));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2678a(View view, int OplusGLSurfaceView_13) {
        this.f3002c = OplusGLSurfaceView_13;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3001b.setSource(view, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m2694c() {
        return this.f3001b.getChildCount();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2689b(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3001b.addChild(view, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m2699d() {
        return this.f3001b.getActions();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2676a(int OplusGLSurfaceView_13) {
        this.f3001b.addAction(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<Integer> m2663a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f3001b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f3001b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2679a(PlatformImplementations.kt_3 aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3001b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f3040L);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m2693b(PlatformImplementations.kt_3 aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f3001b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f3040L);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2685a(int OplusGLSurfaceView_13, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f3001b.performAction(OplusGLSurfaceView_13, bundle);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2688b(View view) {
        this.f3000a = -1;
        this.f3001b.setParent(view);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2696c(View view, int OplusGLSurfaceView_13) {
        this.f3000a = OplusGLSurfaceView_13;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3001b.setParent(view, OplusGLSurfaceView_13);
        }
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void m2677a(Rect rect) {
        this.f3001b.getBoundsInParent(rect);
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2687b(Rect rect) {
        this.f3001b.setBoundsInParent(rect);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2695c(Rect rect) {
        this.f3001b.getBoundsInScreen(rect);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m2700d(Rect rect) {
        this.f3001b.setBoundsInScreen(rect);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2704e() {
        return this.f3001b.isCheckable();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2684a(boolean z) {
        this.f3001b.setCheckable(z);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m2707f() {
        return this.f3001b.isChecked();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2692b(boolean z) {
        this.f3001b.setChecked(z);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m2710g() {
        return this.f3001b.isFocusable();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2698c(boolean z) {
        this.f3001b.setFocusable(z);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m2713h() {
        return this.f3001b.isFocused();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m2701d(boolean z) {
        this.f3001b.setFocused(z);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m2703e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3001b.setVisibleToUser(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2706f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3001b.setAccessibilityFocused(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m2716i() {
        return this.f3001b.isSelected();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m2718j() {
        return this.f3001b.isClickable();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m2709g(boolean z) {
        this.f3001b.setClickable(z);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m2720k() {
        return this.f3001b.isLongClickable();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m2722l() {
        return this.f3001b.isEnabled();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m2712h(boolean z) {
        this.f3001b.setEnabled(z);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m2724m() {
        return this.f3001b.isPassword();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m2725n() {
        return this.f3001b.isScrollable();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m2715i(boolean z) {
        this.f3001b.setScrollable(z);
    }

    /* renamed from: o */
    public CharSequence m2726o() {
        return this.f3001b.getPackageName();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2681a(CharSequence charSequence) {
        this.f3001b.setPackageName(charSequence);
    }

    /* renamed from: p */
    public CharSequence m2727p() {
        return this.f3001b.getClassName();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2690b(CharSequence charSequence) {
        this.f3001b.setClassName(charSequence);
    }

    /* renamed from: q */
    public CharSequence m2728q() {
        if (m2673y()) {
            List<Integer> listM2663a = m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> listM2663a2 = m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> listM2663a3 = m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> listM2663a4 = m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f3001b.getText(), 0, this.f3001b.getText().length()));
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM2663a.size(); OplusGLSurfaceView_13++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(listM2663a4.get(OplusGLSurfaceView_13).intValue(), this, m2734w().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listM2663a.get(OplusGLSurfaceView_13).intValue(), listM2663a2.get(OplusGLSurfaceView_13).intValue(), listM2663a3.get(OplusGLSurfaceView_13).intValue());
            }
            return spannableString;
        }
        return this.f3001b.getText();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2697c(CharSequence charSequence) {
        this.f3001b.setText(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2682a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        m2674z();
        m2672e(view);
        ClickableSpan[] clickableSpanArrM2671d = m2671d(charSequence);
        if (clickableSpanArrM2671d == null || clickableSpanArrM2671d.length <= 0) {
            return;
        }
        m2734w().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", androidx.core.R.id_renamed.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArrayM2667c = m2667c(view);
        for (int OplusGLSurfaceView_13 = 0; clickableSpanArrM2671d != null && OplusGLSurfaceView_13 < clickableSpanArrM2671d.length; OplusGLSurfaceView_13++) {
            int iM2659a = m2659a(clickableSpanArrM2671d[OplusGLSurfaceView_13], sparseArrayM2667c);
            sparseArrayM2667c.put(iM2659a, new WeakReference<>(clickableSpanArrM2671d[OplusGLSurfaceView_13]));
            m2665a(clickableSpanArrM2671d[OplusGLSurfaceView_13], (Spanned) charSequence, iM2659a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SparseArray<WeakReference<ClickableSpan>> m2667c(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayM2669d = m2669d(view);
        if (sparseArrayM2669d != null) {
            return sparseArrayM2669d;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(androidx.core.R.id_renamed.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SparseArray<WeakReference<ClickableSpan>> m2669d(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id_renamed.tag_accessibility_clickable_spans);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static ClickableSpan[] m2671d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m2659a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < sparseArray.size(); OplusGLSurfaceView_13++) {
                if (clickableSpan.equals(sparseArray.valueAt(OplusGLSurfaceView_13).get())) {
                    return sparseArray.keyAt(OplusGLSurfaceView_13);
                }
            }
        }
        int i2 = f2999d;
        f2999d = i2 + 1;
        return i2;
    }

    /* renamed from: y */
    private boolean m2673y() {
        return !m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* renamed from: z */
    private void m2674z() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f3001b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f3001b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f3001b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2665a(ClickableSpan clickableSpan, Spanned spanned, int OplusGLSurfaceView_13) {
        m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        m2663a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(OplusGLSurfaceView_13));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m2672e(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayM2669d = m2669d(view);
        if (sparseArrayM2669d != null) {
            ArrayList arrayList = new ArrayList();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < sparseArrayM2669d.size(); OplusGLSurfaceView_13++) {
                if (sparseArrayM2669d.valueAt(OplusGLSurfaceView_13).get() == null) {
                    arrayList.add(Integer.valueOf(OplusGLSurfaceView_13));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayM2669d.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    /* renamed from: r */
    public CharSequence m2729r() {
        return this.f3001b.getContentDescription();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m2702e(CharSequence charSequence) {
        this.f3001b.setContentDescription(charSequence);
    }

    /* renamed from: s */
    public void m2730s() {
        this.f3001b.recycle();
    }

    /* renamed from: t */
    public String m2731t() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f3001b.getViewIdResourceName();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2683a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((IntrinsicsJvm.kt_4) obj).f3044a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2691b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((IntrinsicsJvm.kt_3) obj).f3045a);
        }
    }

    /* renamed from: u */
    public IntrinsicsJvm.kt_3 m2732u() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.f3001b.getCollectionItemInfo()) == null) {
            return null;
        }
        return new IntrinsicsJvm.kt_3(collectionItemInfo);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2680a(IntrinsicsJvm.kt_5 dVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f3046a);
        }
    }

    /* renamed from: v */
    public List<PlatformImplementations.kt_3> m2733v() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f3001b.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                arrayList.add(new PlatformImplementations.kt_3(actionList.get(OplusGLSurfaceView_13)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2705f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3001b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m2708g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3001b.setError(charSequence);
        }
    }

    /* renamed from: w */
    public Bundle m2734w() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f3001b.getExtras();
        }
        return new Bundle();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2686b(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3001b.setMaxTextLength(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m2717j(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.setDismissable(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m2711h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3001b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m2719k(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3001b.setScreenReaderFocusable(z);
        } else {
            m2664a(1, z);
        }
    }

    /* renamed from: x */
    public boolean m2735x() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f3001b.isShowingHintText();
        }
        return m2668c(4);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m2721l(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3001b.setShowingHintText(z);
        } else {
            m2664a(4, z);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m2723m(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3001b.setHeading(z);
        } else {
            m2664a(2, z);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m2714i(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3001b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3001b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat c0483d = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3001b;
        if (accessibilityNodeInfo == null) {
            if (c0483d.f3001b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c0483d.f3001b)) {
            return false;
        }
        return this.f3002c == c0483d.f3002c && this.f3000a == c0483d.f3000a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m2677a(rect);
        sb.append("; boundsInParent: " + rect);
        m2695c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m2726o());
        sb.append("; className: ");
        sb.append(m2727p());
        sb.append("; text: ");
        sb.append(m2728q());
        sb.append("; contentDescription: ");
        sb.append(m2729r());
        sb.append("; viewId: ");
        sb.append(m2731t());
        sb.append("; checkable: ");
        sb.append(m2704e());
        sb.append("; checked: ");
        sb.append(m2707f());
        sb.append("; focusable: ");
        sb.append(m2710g());
        sb.append("; focused: ");
        sb.append(m2713h());
        sb.append("; selected: ");
        sb.append(m2716i());
        sb.append("; clickable: ");
        sb.append(m2718j());
        sb.append("; longClickable: ");
        sb.append(m2720k());
        sb.append("; enabled: ");
        sb.append(m2722l());
        sb.append("; password: ");
        sb.append(m2724m());
        sb.append("; scrollable: " + m2725n());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<PlatformImplementations.kt_3> listM2733v = m2733v();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM2733v.size(); OplusGLSurfaceView_13++) {
                PlatformImplementations.kt_3 aVar = listM2733v.get(OplusGLSurfaceView_13);
                String strM2670d = m2670d(aVar.m2736a());
                if (strM2670d.equals("ACTION_UNKNOWN") && aVar.m2739b() != null) {
                    strM2670d = aVar.m2739b().toString();
                }
                sb.append(strM2670d);
                if (OplusGLSurfaceView_13 != listM2733v.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iM2699d = m2699d();
            while (iM2699d != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iM2699d);
                iM2699d &= ~iNumberOfTrailingZeros;
                sb.append(m2670d(iNumberOfTrailingZeros));
                if (iM2699d != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2664a(int OplusGLSurfaceView_13, boolean z) {
        Bundle bundleM2734w = m2734w();
        if (bundleM2734w != null) {
            int i2 = bundleM2734w.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~OplusGLSurfaceView_13);
            if (!z) {
                OplusGLSurfaceView_13 = 0;
            }
            bundleM2734w.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", OplusGLSurfaceView_13 | i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m2668c(int OplusGLSurfaceView_13) {
        Bundle bundleM2734w = m2734w();
        return bundleM2734w != null && (bundleM2734w.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & OplusGLSurfaceView_13) == OplusGLSurfaceView_13;
    }
}
