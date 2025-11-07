package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.core.p036h.ViewCompat;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Transition.java */
/* renamed from: androidx.transition.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id_renamed";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<TransitionValues> mEndValuesList;
    private IntrinsicsJvm.kt_3 mEpicenterCallback;
    private ArrayMap<String, String> mNameOverrides;
    TransitionPropagation mPropagation;
    private ArrayList<TransitionValues> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() { // from class: androidx.transition.OplusGLSurfaceView_6.1
        @Override // androidx.transition.PathMotion
        /* renamed from: PlatformImplementations.kt_3 */
        public Path mo4787a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(COUIBaseListPopupWindow_12, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, PlatformImplementations.kt_3>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<IntrinsicsJvm.kt_5> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* compiled from: Transition.java */
    /* renamed from: androidx.transition.OplusGLSurfaceView_6$IntrinsicsJvm.kt_3 */
    public static abstract class IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract Rect mo4785a(Transition abstractC0791m);
    }

    /* compiled from: Transition.java */
    /* renamed from: androidx.transition.OplusGLSurfaceView_6$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo4762a(Transition abstractC0791m);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4757b(Transition abstractC0791m);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo4758c(Transition abstractC0791m);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo4759d(Transition abstractC0791m);

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo4763e(Transition abstractC0791m);
    }

    private static boolean isValidMatch(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 4;
    }

    public abstract void captureEndValues(TransitionValues c0797t);

    public abstract void captureStartValues(TransitionValues c0797t);

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues c0797t, TransitionValues c0797t2) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Transition() {
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f4628c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jM2308a = TypedArrayUtils.m2308a(typedArrayObtainStyledAttributes, (XmlPullParser) xmlResourceParser, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, 1, -1);
        if (jM2308a >= 0) {
            setDuration(jM2308a);
        }
        long jM2308a2 = TypedArrayUtils.m2308a(typedArrayObtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (jM2308a2 > 0) {
            setStartDelay(jM2308a2);
        }
        int iM2322c = TypedArrayUtils.m2322c(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iM2322c > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, iM2322c));
        }
        String strM2314a = TypedArrayUtils.m2314a(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strM2314a != null) {
            setMatchOrder(parseMatchOrder(strM2314a));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int OplusGLSurfaceView_13 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id_renamed".equalsIgnoreCase(strTrim)) {
                iArr[OplusGLSurfaceView_13] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(strTrim)) {
                iArr[OplusGLSurfaceView_13] = 1;
            } else if (MATCH_NAME_STR.equalsIgnoreCase(strTrim)) {
                iArr[OplusGLSurfaceView_13] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(strTrim)) {
                iArr[OplusGLSurfaceView_13] = 4;
            } else if (strTrim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, OplusGLSurfaceView_13);
                OplusGLSurfaceView_13--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
            }
            OplusGLSurfaceView_13++;
        }
        return iArr;
    }

    public Transition setDuration(long OplusGLSurfaceView_15) {
        this.mDuration = OplusGLSurfaceView_15;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Transition setStartDelay(long OplusGLSurfaceView_15) {
        this.mStartDelay = OplusGLSurfaceView_15;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            if (!isValidMatch(iArr[OplusGLSurfaceView_13])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (alreadyContains(iArr, OplusGLSurfaceView_13)) {
                throw new IllegalArgumentException("matches contains PlatformImplementations.kt_3 duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int OplusGLSurfaceView_13) {
        int i2 = iArr[OplusGLSurfaceView_13];
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues c0797tRemove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View viewKeyAt = arrayMap.keyAt(size);
            if (viewKeyAt != null && isValidTarget(viewKeyAt) && (c0797tRemove = arrayMap2.remove(viewKeyAt)) != null && isValidTarget(c0797tRemove.f4664b)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(c0797tRemove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            View viewValueAt = longSparseArray.valueAt(OplusGLSurfaceView_13);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(OplusGLSurfaceView_13))) != null && isValidTarget(view)) {
                TransitionValues c0797t = arrayMap.get(viewValueAt);
                TransitionValues c0797t2 = arrayMap2.get(view);
                if (c0797t != null && c0797t2 != null) {
                    this.mStartValuesList.add(c0797t);
                    this.mEndValuesList.add(c0797t2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            View viewValueAt = sparseArray.valueAt(OplusGLSurfaceView_13);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(OplusGLSurfaceView_13))) != null && isValidTarget(view)) {
                TransitionValues c0797t = arrayMap.get(viewValueAt);
                TransitionValues c0797t2 = arrayMap2.get(view);
                if (c0797t != null && c0797t2 != null) {
                    this.mStartValuesList.add(c0797t);
                    this.mEndValuesList.add(c0797t2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            View viewValueAt = arrayMap3.valueAt(OplusGLSurfaceView_13);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = arrayMap4.get(arrayMap3.keyAt(OplusGLSurfaceView_13))) != null && isValidTarget(view)) {
                TransitionValues c0797t = arrayMap.get(viewValueAt);
                TransitionValues c0797t2 = arrayMap2.get(view);
                if (c0797t != null && c0797t2 != null) {
                    this.mStartValuesList.add(c0797t);
                    this.mEndValuesList.add(c0797t2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayMap.size(); OplusGLSurfaceView_13++) {
            TransitionValues c0797tValueAt = arrayMap.valueAt(OplusGLSurfaceView_13);
            if (isValidTarget(c0797tValueAt.f4664b)) {
                this.mStartValuesList.add(c0797tValueAt);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            TransitionValues c0797tValueAt2 = arrayMap2.valueAt(i2);
            if (isValidTarget(c0797tValueAt2.f4664b)) {
                this.mEndValuesList.add(c0797tValueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps c0798u, TransitionValuesMaps c0798u2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(c0798u.f4666a);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(c0798u2.f4666a);
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (OplusGLSurfaceView_13 < iArr.length) {
                int i2 = iArr[OplusGLSurfaceView_13];
                if (i2 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    matchNames(arrayMap, arrayMap2, c0798u.f4669d, c0798u2.f4669d);
                } else if (i2 == 3) {
                    matchIds(arrayMap, arrayMap2, c0798u.f4667b, c0798u2.f4667b);
                } else if (i2 == 4) {
                    matchItemIds(arrayMap, arrayMap2, c0798u.f4668c, c0798u2.f4668c);
                }
                OplusGLSurfaceView_13++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void createAnimators(android.view.ViewGroup r21, androidx.transition.TransitionValuesMaps r22, androidx.transition.TransitionValuesMaps r23, java.util.ArrayList<androidx.transition.TransitionValues> r24, java.util.ArrayList<androidx.transition.TransitionValues> r25) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.createAnimators(android.view.ViewGroup, androidx.transition.u, androidx.transition.u, java.util.ArrayList, java.util.ArrayList):void");
    }

    boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id_renamed = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id_renamed))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                if (this.mTargetTypeExcludes.get(OplusGLSurfaceView_13).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.m2898q(view) != null && this.mTargetNameExcludes.contains(ViewCompat.m2898q(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id_renamed)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.m2898q(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayMap<Animator, PlatformImplementations.kt_3> getRunningAnimators() {
        ArrayMap<Animator, PlatformImplementations.kt_3> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, PlatformImplementations.kt_3> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    protected void runAnimators() {
        start();
        ArrayMap<Animator, PlatformImplementations.kt_3> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, PlatformImplementations.kt_3> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.OplusGLSurfaceView_6.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.mCurrentAnimators.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.mCurrentAnimators.remove(animator2);
                }
            });
            animate(animator);
        }
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            this.mTargetIds.add(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return this;
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            this.mTargetIds.remove(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t == null) {
            return arrayList;
        }
        if (z) {
            return IntrinsicsJvm.kt_4.m4795a(arrayList, t);
        }
        return IntrinsicsJvm.kt_4.m4796b(arrayList, t);
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(int OplusGLSurfaceView_13, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, OplusGLSurfaceView_13, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeChildren(int OplusGLSurfaceView_13, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, OplusGLSurfaceView_13, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 <= 0) {
            return arrayList;
        }
        if (z) {
            return IntrinsicsJvm.kt_4.m4795a(arrayList, Integer.valueOf(OplusGLSurfaceView_13));
        }
        return IntrinsicsJvm.kt_4.m4796b(arrayList, Integer.valueOf(OplusGLSurfaceView_13));
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return IntrinsicsJvm.kt_4.m4795a(arrayList, view);
        }
        return IntrinsicsJvm.kt_4.m4796b(arrayList, view);
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return IntrinsicsJvm.kt_4.m4795a(arrayList, cls);
        }
        return IntrinsicsJvm.kt_4.m4796b(arrayList, cls);
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mTargetIds.size(); OplusGLSurfaceView_13++) {
                View viewFindViewById = viewGroup.findViewById(this.mTargetIds.get(OplusGLSurfaceView_13).intValue());
                if (viewFindViewById != null) {
                    TransitionValues c0797t = new TransitionValues(viewFindViewById);
                    if (z) {
                        captureStartValues(c0797t);
                    } else {
                        captureEndValues(c0797t);
                    }
                    c0797t.f4665c.add(this);
                    capturePropagationValues(c0797t);
                    if (z) {
                        addViewValues(this.mStartValues, viewFindViewById, c0797t);
                    } else {
                        addViewValues(this.mEndValues, viewFindViewById, c0797t);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                TransitionValues c0797t2 = new TransitionValues(view);
                if (z) {
                    captureStartValues(c0797t2);
                } else {
                    captureEndValues(c0797t2);
                }
                c0797t2.f4665c.add(this);
                capturePropagationValues(c0797t2);
                if (z) {
                    addViewValues(this.mStartValues, view, c0797t2);
                } else {
                    addViewValues(this.mEndValues, view, c0797t2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (z || (arrayMap = this.mNameOverrides) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.mStartValues.f4669d.remove(this.mNameOverrides.keyAt(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.mStartValues.f4669d.put(this.mNameOverrides.valueAt(i4), view2);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps c0798u, View view, TransitionValues c0797t) {
        c0798u.f4666a.put(view, c0797t);
        int id_renamed = view.getId();
        if (id_renamed >= 0) {
            if (c0798u.f4667b.indexOfKey(id_renamed) >= 0) {
                c0798u.f4667b.put(id_renamed, null);
            } else {
                c0798u.f4667b.put(id_renamed, view);
            }
        }
        String strM2898q = ViewCompat.m2898q(view);
        if (strM2898q != null) {
            if (c0798u.f4669d.containsKey(strM2898q)) {
                c0798u.f4669d.put(strM2898q, null);
            } else {
                c0798u.f4669d.put(strM2898q, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c0798u.f4668c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = c0798u.f4668c.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.m2860a(view2, false);
                        c0798u.f4668c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.m2860a(view, true);
                c0798u.f4668c.put(itemIdAtPosition, view);
            }
        }
    }

    void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f4666a.clear();
            this.mStartValues.f4667b.clear();
            this.mStartValues.f4668c.clear();
        } else {
            this.mEndValues.f4666a.clear();
            this.mEndValues.f4667b.clear();
            this.mEndValues.f4668c.clear();
        }
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id_renamed = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id_renamed))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                        if (this.mTargetTypeExcludes.get(OplusGLSurfaceView_13).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues c0797t = new TransitionValues(view);
                    if (z) {
                        captureStartValues(c0797t);
                    } else {
                        captureEndValues(c0797t);
                    }
                    c0797t.f4665c.add(this);
                    capturePropagationValues(c0797t);
                    if (z) {
                        addViewValues(this.mStartValues, view, c0797t);
                    } else {
                        addViewValues(this.mEndValues, view, c0797t);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id_renamed))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        TransitionSet c0795q = this.mParent;
        if (c0795q != null) {
            return c0795q.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f4666a.get(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        r6 = r6.mEndValuesList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r6 = r6.mStartValuesList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        return r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.transition.TransitionValues getMatchedTransitionValues(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            androidx.transition.q r0 = r6.mParent
            if (r0 == 0) goto L9
            androidx.transition.t r6 = r0.getMatchedTransitionValues(r7, r8)
            return r6
        L9:
            if (r8 == 0) goto Le
            java.util.ArrayList<androidx.transition.t> r0 = r6.mStartValuesList
            goto L10
        Le:
            java.util.ArrayList<androidx.transition.t> r0 = r6.mEndValuesList
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1a:
            if (r4 >= r2) goto L2e
            java.lang.Object r5 = r0.get(r4)
            androidx.transition.t r5 = (androidx.transition.TransitionValues) r5
            if (r5 != 0) goto L25
            return r1
        L25:
            android.view.View r5 = r5.f4664b
            if (r5 != r7) goto L2b
            r3 = r4
            goto L2e
        L2b:
            int r4 = r4 + 1
            goto L1a
        L2e:
            if (r3 < 0) goto L3e
            if (r8 == 0) goto L35
            java.util.ArrayList<androidx.transition.t> r6 = r6.mEndValuesList
            goto L37
        L35:
            java.util.ArrayList<androidx.transition.t> r6 = r6.mStartValuesList
        L37:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            androidx.transition.t r1 = (androidx.transition.TransitionValues) r1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.getMatchedTransitionValues(android.view.View, boolean):androidx.transition.t");
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        ArrayMap<Animator, PlatformImplementations.kt_3> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl interfaceC0779anM4732b = ViewUtils.m4732b(view);
        for (int OplusGLSurfaceView_13 = size - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            PlatformImplementations.kt_3 aVarValueAt = runningAnimators.valueAt(OplusGLSurfaceView_13);
            if (aVarValueAt.f4640a != null && interfaceC0779anM4732b.equals(aVarValueAt.f4643d)) {
                AnimatorUtils.m4713a(runningAnimators.keyAt(OplusGLSurfaceView_13));
            }
        }
        ArrayList<IntrinsicsJvm.kt_5> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((IntrinsicsJvm.kt_5) arrayList2.get(i2)).mo4758c(this);
            }
        }
        this.mPaused = true;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, PlatformImplementations.kt_3> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdImpl interfaceC0779anM4732b = ViewUtils.m4732b(view);
                for (int OplusGLSurfaceView_13 = size - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
                    PlatformImplementations.kt_3 aVarValueAt = runningAnimators.valueAt(OplusGLSurfaceView_13);
                    if (aVarValueAt.f4640a != null && interfaceC0779anM4732b.equals(aVarValueAt.f4643d)) {
                        AnimatorUtils.m4715b(runningAnimators.keyAt(OplusGLSurfaceView_13));
                    }
                }
                ArrayList<IntrinsicsJvm.kt_5> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((IntrinsicsJvm.kt_5) arrayList2.get(i2)).mo4759d(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    void playTransition(ViewGroup viewGroup) {
        PlatformImplementations.kt_3 aVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, PlatformImplementations.kt_3> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl interfaceC0779anM4732b = ViewUtils.m4732b(viewGroup);
        for (int OplusGLSurfaceView_13 = size - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            Animator animatorKeyAt = runningAnimators.keyAt(OplusGLSurfaceView_13);
            if (animatorKeyAt != null && (aVar = runningAnimators.get(animatorKeyAt)) != null && aVar.f4640a != null && interfaceC0779anM4732b.equals(aVar.f4643d)) {
                TransitionValues c0797t = aVar.f4642c;
                View view = aVar.f4640a;
                TransitionValues transitionValues = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f4666a.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && aVar.f4644e.isTransitionRequired(c0797t, matchedTransitionValues)) {
                    if (animatorKeyAt.isRunning() || animatorKeyAt.isStarted()) {
                        animatorKeyAt.cancel();
                    } else {
                        runningAnimators.remove(animatorKeyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(TransitionValues c0797t, TransitionValues c0797t2) {
        if (c0797t == null || c0797t2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(c0797t, c0797t2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = c0797t.f4663a.keySet().iterator();
        while (it.hasNext()) {
            if (isValueChanged(c0797t, c0797t2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(TransitionValues c0797t, TransitionValues c0797t2, String str) {
        Object obj = c0797t.f4663a.get(str);
        Object obj2 = c0797t2.f4663a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.OplusGLSurfaceView_6.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    protected void start() {
        if (this.mNumInstances == 0) {
            ArrayList<IntrinsicsJvm.kt_5> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    ((IntrinsicsJvm.kt_5) arrayList2.get(OplusGLSurfaceView_13)).mo4763e(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    protected void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            ArrayList<IntrinsicsJvm.kt_5> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    ((IntrinsicsJvm.kt_5) arrayList2.get(OplusGLSurfaceView_13)).mo4757b(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.f4668c.size(); i2++) {
                View viewValueAt = this.mStartValues.f4668c.valueAt(i2);
                if (viewValueAt != null) {
                    ViewCompat.m2860a(viewValueAt, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.f4668c.size(); i3++) {
                View viewValueAt2 = this.mEndValues.f4668c.valueAt(i3);
                if (viewValueAt2 != null) {
                    ViewCompat.m2860a(viewValueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, PlatformImplementations.kt_3> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        WindowIdImpl interfaceC0779anM4732b = ViewUtils.m4732b(viewGroup);
        ArrayMap arrayMap = new ArrayMap(runningAnimators);
        runningAnimators.clear();
        for (int OplusGLSurfaceView_13 = size - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) arrayMap.valueAt(OplusGLSurfaceView_13);
            if (aVar.f4640a != null && interfaceC0779anM4732b != null && interfaceC0779anM4732b.equals(aVar.f4643d)) {
                ((Animator) arrayMap.keyAt(OplusGLSurfaceView_13)).end();
            }
        }
    }

    protected void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<IntrinsicsJvm.kt_5> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size2; OplusGLSurfaceView_13++) {
            ((IntrinsicsJvm.kt_5) arrayList2.get(OplusGLSurfaceView_13)).mo4762a(this);
        }
    }

    public Transition addListener(IntrinsicsJvm.kt_5 dVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public Transition removeListener(IntrinsicsJvm.kt_5 dVar) {
        ArrayList<IntrinsicsJvm.kt_5> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(PathMotion abstractC0785g) {
        if (abstractC0785g == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = abstractC0785g;
        }
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(IntrinsicsJvm.kt_3 cVar) {
        this.mEpicenterCallback = cVar;
    }

    public IntrinsicsJvm.kt_3 getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public Rect getEpicenter() {
        IntrinsicsJvm.kt_3 cVar = this.mEpicenterCallback;
        if (cVar == null) {
            return null;
        }
        return cVar.mo4785a(this);
    }

    public void setPropagation(TransitionPropagation abstractC0794p) {
        this.mPropagation = abstractC0794p;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    void capturePropagationValues(TransitionValues c0797t) {
        String[] strArrM4804a;
        if (this.mPropagation == null || c0797t.f4663a.isEmpty() || (strArrM4804a = this.mPropagation.m4804a()) == null) {
            return;
        }
        boolean z = false;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= strArrM4804a.length) {
                z = true;
                break;
            } else if (!c0797t.f4663a.containsKey(strArrM4804a[OplusGLSurfaceView_13])) {
                break;
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.m4803a(c0797t);
    }

    Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Transition mo26268clone() {
        try {
            Transition abstractC0791m = (Transition) super.clone();
            abstractC0791m.mAnimators = new ArrayList<>();
            abstractC0791m.mStartValues = new TransitionValuesMaps();
            abstractC0791m.mEndValues = new TransitionValuesMaps();
            abstractC0791m.mStartValuesList = null;
            abstractC0791m.mEndValuesList = null;
            return abstractC0791m;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            String str4 = str3;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mTargetIds.size(); OplusGLSurfaceView_13++) {
                if (OplusGLSurfaceView_13 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.mTargetIds.get(OplusGLSurfaceView_13);
            }
            str3 = str4;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }

    /* compiled from: Transition.java */
    /* renamed from: androidx.transition.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        View f4640a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        String f4641b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        TransitionValues f4642c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        WindowIdImpl f4643d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        Transition f4644e;

        PlatformImplementations.kt_3(View view, String str, Transition abstractC0791m, WindowIdImpl interfaceC0779an, TransitionValues c0797t) {
            this.f4640a = view;
            this.f4641b = str;
            this.f4642c = c0797t;
            this.f4643d = interfaceC0779an;
            this.f4644e = abstractC0791m;
        }
    }

    /* compiled from: Transition.java */
    /* renamed from: androidx.transition.OplusGLSurfaceView_6$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        static <T> ArrayList<T> m4795a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        static <T> ArrayList<T> m4796b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }
}
