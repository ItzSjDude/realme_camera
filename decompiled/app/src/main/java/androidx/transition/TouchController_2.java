package androidx.transition;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class m_renamed implements java.lang.Cloneable {
    static final boolean DBG = false;
    private static final java.lang.String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final java.lang.String MATCH_ID_STR = "id_renamed";
    public static final int MATCH_INSTANCE = 1;
    private static final java.lang.String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final java.lang.String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final java.lang.String MATCH_NAME_STR = "name";
    private java.util.ArrayList<androidx.transition.t_renamed> mEndValuesList;
    private androidx.transition.m_renamed.c_renamed mEpicenterCallback;
    private androidx.collection.ArrayMap<java.lang.String, java.lang.String> mNameOverrides;
    androidx.transition.p_renamed mPropagation;
    private java.util.ArrayList<androidx.transition.t_renamed> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final androidx.transition.g_renamed STRAIGHT_PATH_MOTION = new androidx.transition.g_renamed() { // from class: androidx.transition.m_renamed.1
        @Override // androidx.transition.g_renamed
        public android.graphics.Path a_renamed(float f_renamed, float f2, float f3, float f4) {
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(f_renamed, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static java.lang.ThreadLocal<androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed>> sRunningAnimators = new java.lang.ThreadLocal<>();
    private java.lang.String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private android.animation.TimeInterpolator mInterpolator = null;
    java.util.ArrayList<java.lang.Integer> mTargetIds = new java.util.ArrayList<>();
    java.util.ArrayList<android.view.View> mTargets = new java.util.ArrayList<>();
    private java.util.ArrayList<java.lang.String> mTargetNames = null;
    private java.util.ArrayList<java.lang.Class<?>> mTargetTypes = null;
    private java.util.ArrayList<java.lang.Integer> mTargetIdExcludes = null;
    private java.util.ArrayList<android.view.View> mTargetExcludes = null;
    private java.util.ArrayList<java.lang.Class<?>> mTargetTypeExcludes = null;
    private java.util.ArrayList<java.lang.String> mTargetNameExcludes = null;
    private java.util.ArrayList<java.lang.Integer> mTargetIdChildExcludes = null;
    private java.util.ArrayList<android.view.View> mTargetChildExcludes = null;
    private java.util.ArrayList<java.lang.Class<?>> mTargetTypeChildExcludes = null;
    private androidx.transition.u_renamed mStartValues = new androidx.transition.u_renamed();
    private androidx.transition.u_renamed mEndValues = new androidx.transition.u_renamed();
    androidx.transition.q_renamed mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private android.view.ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    java.util.ArrayList<android.animation.Animator> mCurrentAnimators = new java.util.ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private java.util.ArrayList<androidx.transition.m_renamed.d_renamed> mListeners = null;
    private java.util.ArrayList<android.animation.Animator> mAnimators = new java.util.ArrayList<>();
    private androidx.transition.g_renamed mPathMotion = STRAIGHT_PATH_MOTION;

    /* compiled from: Transition.java */
    public static abstract class c_renamed {
        public abstract android.graphics.Rect a_renamed(androidx.transition.m_renamed mVar);
    }

    /* compiled from: Transition.java */
    public interface d_renamed {
        void a_renamed(androidx.transition.m_renamed mVar);

        void b_renamed(androidx.transition.m_renamed mVar);

        void c_renamed(androidx.transition.m_renamed mVar);

        void d_renamed(androidx.transition.m_renamed mVar);

        void e_renamed(androidx.transition.m_renamed mVar);
    }

    private static boolean isValidMatch(int i_renamed) {
        return i_renamed >= 1 && i_renamed <= 4;
    }

    public abstract void captureEndValues(androidx.transition.t_renamed tVar);

    public abstract void captureStartValues(androidx.transition.t_renamed tVar);

    public android.animation.Animator createAnimator(android.view.ViewGroup viewGroup, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        return null;
    }

    public java.lang.String[] getTransitionProperties() {
        return null;
    }

    public m_renamed() {
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public m_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.transition.l_renamed.f1731c);
        android.content.res.XmlResourceParser xmlResourceParser = (android.content.res.XmlResourceParser) attributeSet;
        long jA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayObtainStyledAttributes, (org.xmlpull.v1.XmlPullParser) xmlResourceParser, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, 1, -1);
        if (jA >= 0) {
            setDuration(jA);
        }
        long jA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayObtainStyledAttributes, (org.xmlpull.v1.XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (jA2 > 0) {
            setStartDelay(jA2);
        }
        int iC = androidx.core.a_renamed.a_renamed.g_renamed.c_renamed(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iC > 0) {
            setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(context, iC));
        }
        java.lang.String strA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strA != null) {
            setMatchOrder(parseMatchOrder(strA));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i_renamed = 0;
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String strTrim = stringTokenizer.nextToken().trim();
            if ("id_renamed".equalsIgnoreCase(strTrim)) {
                iArr[i_renamed] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(strTrim)) {
                iArr[i_renamed] = 1;
            } else if (MATCH_NAME_STR.equalsIgnoreCase(strTrim)) {
                iArr[i_renamed] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(strTrim)) {
                iArr[i_renamed] = 4;
            } else if (strTrim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                java.lang.System.arraycopy(iArr, 0, iArr2, 0, i_renamed);
                i_renamed--;
                iArr = iArr2;
            } else {
                throw new android.view.InflateException("Unknown match type in_renamed matchOrder: '" + strTrim + "'");
            }
            i_renamed++;
        }
        return iArr;
    }

    public androidx.transition.m_renamed setDuration(long j_renamed) {
        this.mDuration = j_renamed;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public androidx.transition.m_renamed setStartDelay(long j_renamed) {
        this.mStartDelay = j_renamed;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public androidx.transition.m_renamed setInterpolator(android.animation.TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public android.animation.TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            if (!isValidMatch(iArr[i_renamed])) {
                throw new java.lang.IllegalArgumentException("matches contains invalid value");
            }
            if (alreadyContains(iArr, i_renamed)) {
                throw new java.lang.IllegalArgumentException("matches contains a_renamed duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i_renamed) {
        int i2 = iArr[i_renamed];
        for (int i3 = 0; i3 < i_renamed; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap, androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap2) {
        androidx.transition.t_renamed tVarRemove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            android.view.View viewKeyAt = arrayMap.keyAt(size);
            if (viewKeyAt != null && isValidTarget(viewKeyAt) && (tVarRemove = arrayMap2.remove(viewKeyAt)) != null && isValidTarget(tVarRemove.f1755b)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(tVarRemove);
            }
        }
    }

    private void matchItemIds(androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap, androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap2, androidx.collection.LongSparseArray<android.view.View> longSparseArray, androidx.collection.LongSparseArray<android.view.View> longSparseArray2) {
        android.view.View view;
        int size = longSparseArray.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.View viewValueAt = longSparseArray.valueAt(i_renamed);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i_renamed))) != null && isValidTarget(view)) {
                androidx.transition.t_renamed tVar = arrayMap.get(viewValueAt);
                androidx.transition.t_renamed tVar2 = arrayMap2.get(view);
                if (tVar != null && tVar2 != null) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchIds(androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap, androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap2, android.util.SparseArray<android.view.View> sparseArray, android.util.SparseArray<android.view.View> sparseArray2) {
        android.view.View view;
        int size = sparseArray.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.View viewValueAt = sparseArray.valueAt(i_renamed);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i_renamed))) != null && isValidTarget(view)) {
                androidx.transition.t_renamed tVar = arrayMap.get(viewValueAt);
                androidx.transition.t_renamed tVar2 = arrayMap2.get(view);
                if (tVar != null && tVar2 != null) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap, androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap2, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap3, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap4) {
        android.view.View view;
        int size = arrayMap3.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.View viewValueAt = arrayMap3.valueAt(i_renamed);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i_renamed))) != null && isValidTarget(view)) {
                androidx.transition.t_renamed tVar = arrayMap.get(viewValueAt);
                androidx.transition.t_renamed tVar2 = arrayMap2.get(view);
                if (tVar != null && tVar2 != null) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void addUnmatched(androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap, androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap2) {
        for (int i_renamed = 0; i_renamed < arrayMap.size(); i_renamed++) {
            androidx.transition.t_renamed tVarValueAt = arrayMap.valueAt(i_renamed);
            if (isValidTarget(tVarValueAt.f1755b)) {
                this.mStartValuesList.add(tVarValueAt);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            androidx.transition.t_renamed tVarValueAt2 = arrayMap2.valueAt(i2);
            if (isValidTarget(tVarValueAt2.f1755b)) {
                this.mEndValuesList.add(tVarValueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(androidx.transition.u_renamed uVar, androidx.transition.u_renamed uVar2) {
        androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap = new androidx.collection.ArrayMap<>(uVar.f1757a);
        androidx.collection.ArrayMap<android.view.View, androidx.transition.t_renamed> arrayMap2 = new androidx.collection.ArrayMap<>(uVar2.f1757a);
        int i_renamed = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i_renamed < iArr.length) {
                int i2 = iArr[i_renamed];
                if (i2 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    matchNames(arrayMap, arrayMap2, uVar.d_renamed, uVar2.d_renamed);
                } else if (i2 == 3) {
                    matchIds(arrayMap, arrayMap2, uVar.f1758b, uVar2.f1758b);
                } else if (i2 == 4) {
                    matchItemIds(arrayMap, arrayMap2, uVar.f1759c, uVar2.f1759c);
                }
                i_renamed++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void createAnimators(android.view.ViewGroup r21, androidx.transition.u_renamed r22, androidx.transition.u_renamed r23, java.util.ArrayList<androidx.transition.t_renamed> r24, java.util.ArrayList<androidx.transition.t_renamed> r25) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.m_renamed.createAnimators(android.view.ViewGroup, androidx.transition.u_renamed, androidx.transition.u_renamed, java.util.ArrayList, java.util.ArrayList):void");
    }

    boolean isValidTarget(android.view.View view) {
        java.util.ArrayList<java.lang.Class<?>> arrayList;
        java.util.ArrayList<java.lang.String> arrayList2;
        int id_renamed = view.getId();
        java.util.ArrayList<java.lang.Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(java.lang.Integer.valueOf(id_renamed))) {
            return false;
        }
        java.util.ArrayList<android.view.View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        java.util.ArrayList<java.lang.Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                if (this.mTargetTypeExcludes.get(i_renamed).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && androidx.core.h_renamed.v_renamed.q_renamed(view) != null && this.mTargetNameExcludes.contains(androidx.core.h_renamed.v_renamed.q_renamed(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(java.lang.Integer.valueOf(id_renamed)) || this.mTargets.contains(view)) {
            return true;
        }
        java.util.ArrayList<java.lang.String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(androidx.core.h_renamed.v_renamed.q_renamed(view))) {
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

    private static androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> getRunningAnimators() {
        androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> arrayMap2 = new androidx.collection.ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    protected void runAnimators() {
        start();
        androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> runningAnimators = getRunningAnimators();
        java.util.Iterator<android.animation.Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            android.animation.Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(android.animation.Animator animator, final androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> arrayMap) {
        if (animator != null) {
            animator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.transition.m_renamed.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator2) {
                    androidx.transition.m_renamed.this.mCurrentAnimators.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator2) {
                    arrayMap.remove(animator2);
                    androidx.transition.m_renamed.this.mCurrentAnimators.remove(animator2);
                }
            });
            animate(animator);
        }
    }

    public androidx.transition.m_renamed addTarget(android.view.View view) {
        this.mTargets.add(view);
        return this;
    }

    public androidx.transition.m_renamed addTarget(int i_renamed) {
        if (i_renamed != 0) {
            this.mTargetIds.add(java.lang.Integer.valueOf(i_renamed));
        }
        return this;
    }

    public androidx.transition.m_renamed addTarget(java.lang.String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new java.util.ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public androidx.transition.m_renamed addTarget(java.lang.Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new java.util.ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public androidx.transition.m_renamed removeTarget(android.view.View view) {
        this.mTargets.remove(view);
        return this;
    }

    public androidx.transition.m_renamed removeTarget(int i_renamed) {
        if (i_renamed != 0) {
            this.mTargetIds.remove(java.lang.Integer.valueOf(i_renamed));
        }
        return this;
    }

    public androidx.transition.m_renamed removeTarget(java.lang.String str) {
        java.util.ArrayList<java.lang.String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public androidx.transition.m_renamed removeTarget(java.lang.Class<?> cls) {
        java.util.ArrayList<java.lang.Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    private static <T_renamed> java.util.ArrayList<T_renamed> excludeObject(java.util.ArrayList<T_renamed> arrayList, T_renamed t_renamed, boolean z_renamed) {
        if (t_renamed == null) {
            return arrayList;
        }
        if (z_renamed) {
            return androidx.transition.m_renamed.b_renamed.a_renamed(arrayList, t_renamed);
        }
        return androidx.transition.m_renamed.b_renamed.b_renamed(arrayList, t_renamed);
    }

    public androidx.transition.m_renamed excludeTarget(android.view.View view, boolean z_renamed) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z_renamed);
        return this;
    }

    public androidx.transition.m_renamed excludeTarget(int i_renamed, boolean z_renamed) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i_renamed, z_renamed);
        return this;
    }

    public androidx.transition.m_renamed excludeTarget(java.lang.String str, boolean z_renamed) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z_renamed);
        return this;
    }

    public androidx.transition.m_renamed excludeChildren(android.view.View view, boolean z_renamed) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z_renamed);
        return this;
    }

    public androidx.transition.m_renamed excludeChildren(int i_renamed, boolean z_renamed) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i_renamed, z_renamed);
        return this;
    }

    private java.util.ArrayList<java.lang.Integer> excludeId(java.util.ArrayList<java.lang.Integer> arrayList, int i_renamed, boolean z_renamed) {
        if (i_renamed <= 0) {
            return arrayList;
        }
        if (z_renamed) {
            return androidx.transition.m_renamed.b_renamed.a_renamed(arrayList, java.lang.Integer.valueOf(i_renamed));
        }
        return androidx.transition.m_renamed.b_renamed.b_renamed(arrayList, java.lang.Integer.valueOf(i_renamed));
    }

    private java.util.ArrayList<android.view.View> excludeView(java.util.ArrayList<android.view.View> arrayList, android.view.View view, boolean z_renamed) {
        if (view == null) {
            return arrayList;
        }
        if (z_renamed) {
            return androidx.transition.m_renamed.b_renamed.a_renamed(arrayList, view);
        }
        return androidx.transition.m_renamed.b_renamed.b_renamed(arrayList, view);
    }

    public androidx.transition.m_renamed excludeTarget(java.lang.Class<?> cls, boolean z_renamed) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z_renamed);
        return this;
    }

    public androidx.transition.m_renamed excludeChildren(java.lang.Class<?> cls, boolean z_renamed) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z_renamed);
        return this;
    }

    private java.util.ArrayList<java.lang.Class<?>> excludeType(java.util.ArrayList<java.lang.Class<?>> arrayList, java.lang.Class<?> cls, boolean z_renamed) {
        if (cls == null) {
            return arrayList;
        }
        if (z_renamed) {
            return androidx.transition.m_renamed.b_renamed.a_renamed(arrayList, cls);
        }
        return androidx.transition.m_renamed.b_renamed.b_renamed(arrayList, cls);
    }

    public java.util.List<java.lang.Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public java.util.List<android.view.View> getTargets() {
        return this.mTargets;
    }

    public java.util.List<java.lang.String> getTargetNames() {
        return this.mTargetNames;
    }

    public java.util.List<java.lang.Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    void captureValues(android.view.ViewGroup viewGroup, boolean z_renamed) {
        java.util.ArrayList<java.lang.String> arrayList;
        java.util.ArrayList<java.lang.Class<?>> arrayList2;
        androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap;
        clearValues(z_renamed);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i_renamed = 0; i_renamed < this.mTargetIds.size(); i_renamed++) {
                android.view.View viewFindViewById = viewGroup.findViewById(this.mTargetIds.get(i_renamed).intValue());
                if (viewFindViewById != null) {
                    androidx.transition.t_renamed tVar = new androidx.transition.t_renamed(viewFindViewById);
                    if (z_renamed) {
                        captureStartValues(tVar);
                    } else {
                        captureEndValues(tVar);
                    }
                    tVar.f1756c.add(this);
                    capturePropagationValues(tVar);
                    if (z_renamed) {
                        addViewValues(this.mStartValues, viewFindViewById, tVar);
                    } else {
                        addViewValues(this.mEndValues, viewFindViewById, tVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                android.view.View view = this.mTargets.get(i2);
                androidx.transition.t_renamed tVar2 = new androidx.transition.t_renamed(view);
                if (z_renamed) {
                    captureStartValues(tVar2);
                } else {
                    captureEndValues(tVar2);
                }
                tVar2.f1756c.add(this);
                capturePropagationValues(tVar2);
                if (z_renamed) {
                    addViewValues(this.mStartValues, view, tVar2);
                } else {
                    addViewValues(this.mEndValues, view, tVar2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z_renamed);
        }
        if (z_renamed || (arrayMap = this.mNameOverrides) == null) {
            return;
        }
        int size = arrayMap.size();
        java.util.ArrayList arrayList3 = new java.util.ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.mStartValues.d_renamed.remove(this.mNameOverrides.keyAt(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            android.view.View view2 = (android.view.View) arrayList3.get(i4);
            if (view2 != null) {
                this.mStartValues.d_renamed.put(this.mNameOverrides.valueAt(i4), view2);
            }
        }
    }

    private static void addViewValues(androidx.transition.u_renamed uVar, android.view.View view, androidx.transition.t_renamed tVar) {
        uVar.f1757a.put(view, tVar);
        int id_renamed = view.getId();
        if (id_renamed >= 0) {
            if (uVar.f1758b.indexOfKey(id_renamed) >= 0) {
                uVar.f1758b.put(id_renamed, null);
            } else {
                uVar.f1758b.put(id_renamed, view);
            }
        }
        java.lang.String strQ = androidx.core.h_renamed.v_renamed.q_renamed(view);
        if (strQ != null) {
            if (uVar.d_renamed.containsKey(strQ)) {
                uVar.d_renamed.put(strQ, null);
            } else {
                uVar.d_renamed.put(strQ, view);
            }
        }
        if (view.getParent() instanceof android.widget.ListView) {
            android.widget.ListView listView = (android.widget.ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (uVar.f1759c.indexOfKey(itemIdAtPosition) >= 0) {
                    android.view.View view2 = uVar.f1759c.get(itemIdAtPosition);
                    if (view2 != null) {
                        androidx.core.h_renamed.v_renamed.a_renamed(view2, false);
                        uVar.f1759c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                androidx.core.h_renamed.v_renamed.a_renamed(view, true);
                uVar.f1759c.put(itemIdAtPosition, view);
            }
        }
    }

    void clearValues(boolean z_renamed) {
        if (z_renamed) {
            this.mStartValues.f1757a.clear();
            this.mStartValues.f1758b.clear();
            this.mStartValues.f1759c.clear();
        } else {
            this.mEndValues.f1757a.clear();
            this.mEndValues.f1758b.clear();
            this.mEndValues.f1759c.clear();
        }
    }

    private void captureHierarchy(android.view.View view, boolean z_renamed) {
        if (view == null) {
            return;
        }
        int id_renamed = view.getId();
        java.util.ArrayList<java.lang.Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(java.lang.Integer.valueOf(id_renamed))) {
            java.util.ArrayList<android.view.View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                java.util.ArrayList<java.lang.Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                        if (this.mTargetTypeExcludes.get(i_renamed).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof android.view.ViewGroup) {
                    androidx.transition.t_renamed tVar = new androidx.transition.t_renamed(view);
                    if (z_renamed) {
                        captureStartValues(tVar);
                    } else {
                        captureEndValues(tVar);
                    }
                    tVar.f1756c.add(this);
                    capturePropagationValues(tVar);
                    if (z_renamed) {
                        addViewValues(this.mStartValues, view, tVar);
                    } else {
                        addViewValues(this.mEndValues, view, tVar);
                    }
                }
                if (view instanceof android.view.ViewGroup) {
                    java.util.ArrayList<java.lang.Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(java.lang.Integer.valueOf(id_renamed))) {
                        java.util.ArrayList<android.view.View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            java.util.ArrayList<java.lang.Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z_renamed);
                            }
                        }
                    }
                }
            }
        }
    }

    public androidx.transition.t_renamed getTransitionValues(android.view.View view, boolean z_renamed) {
        androidx.transition.q_renamed qVar = this.mParent;
        if (qVar != null) {
            return qVar.getTransitionValues(view, z_renamed);
        }
        return (z_renamed ? this.mStartValues : this.mEndValues).f1757a.get(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:21:0x002e, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:22:0x0030, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:23:0x0032, code lost:
    
        r6 = r6.mEndValuesList;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:24:0x0035, code lost:
    
        r6 = r6.mStartValuesList;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:26:0x003e, code lost:
    
        return r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.transition.t_renamed getMatchedTransitionValues(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            androidx.transition.q_renamed r0 = r6.mParent
            if (r0 == 0) goto L9
            androidx.transition.t_renamed r6 = r0.getMatchedTransitionValues(r7, r8)
            return r6
        L9:
            if (r8 == 0) goto Le
            java.util.ArrayList<androidx.transition.t_renamed> r0 = r6.mStartValuesList
            goto L10
        Le:
            java.util.ArrayList<androidx.transition.t_renamed> r0 = r6.mEndValuesList
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
            androidx.transition.t_renamed r5 = (androidx.transition.t_renamed) r5
            if (r5 != 0) goto L25
            return r1
        L25:
            android.view.View r5 = r5.f1755b
            if (r5 != r7) goto L2b
            r3 = r4
            goto L2e
        L2b:
            int r4 = r4 + 1
            goto L1a
        L2e:
            if (r3 < 0) goto L3e
            if (r8 == 0) goto L35
            java.util.ArrayList<androidx.transition.t_renamed> r6 = r6.mEndValuesList
            goto L37
        L35:
            java.util.ArrayList<androidx.transition.t_renamed> r6 = r6.mStartValuesList
        L37:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            androidx.transition.t_renamed r1 = (androidx.transition.t_renamed) r1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.m_renamed.getMatchedTransitionValues(android.view.View, boolean):androidx.transition.t_renamed");
    }

    public void pause(android.view.View view) {
        if (this.mEnded) {
            return;
        }
        androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        androidx.transition.an_renamed anVarB = androidx.transition.ad_renamed.b_renamed(view);
        for (int i_renamed = size - 1; i_renamed >= 0; i_renamed--) {
            androidx.transition.m_renamed.a_renamed aVarValueAt = runningAnimators.valueAt(i_renamed);
            if (aVarValueAt.f1735a != null && anVarB.equals(aVarValueAt.d_renamed)) {
                androidx.transition.a_renamed.a_renamed(runningAnimators.keyAt(i_renamed));
            }
        }
        java.util.ArrayList<androidx.transition.m_renamed.d_renamed> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            java.util.ArrayList arrayList2 = (java.util.ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((androidx.transition.m_renamed.d_renamed) arrayList2.get(i2)).c_renamed(this);
            }
        }
        this.mPaused = true;
    }

    public void resume(android.view.View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                androidx.transition.an_renamed anVarB = androidx.transition.ad_renamed.b_renamed(view);
                for (int i_renamed = size - 1; i_renamed >= 0; i_renamed--) {
                    androidx.transition.m_renamed.a_renamed aVarValueAt = runningAnimators.valueAt(i_renamed);
                    if (aVarValueAt.f1735a != null && anVarB.equals(aVarValueAt.d_renamed)) {
                        androidx.transition.a_renamed.b_renamed(runningAnimators.keyAt(i_renamed));
                    }
                }
                java.util.ArrayList<androidx.transition.m_renamed.d_renamed> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    java.util.ArrayList arrayList2 = (java.util.ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((androidx.transition.m_renamed.d_renamed) arrayList2.get(i2)).d_renamed(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    void playTransition(android.view.ViewGroup viewGroup) {
        androidx.transition.m_renamed.a_renamed aVar;
        this.mStartValuesList = new java.util.ArrayList<>();
        this.mEndValuesList = new java.util.ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        androidx.transition.an_renamed anVarB = androidx.transition.ad_renamed.b_renamed(viewGroup);
        for (int i_renamed = size - 1; i_renamed >= 0; i_renamed--) {
            android.animation.Animator animatorKeyAt = runningAnimators.keyAt(i_renamed);
            if (animatorKeyAt != null && (aVar = runningAnimators.get(animatorKeyAt)) != null && aVar.f1735a != null && anVarB.equals(aVar.d_renamed)) {
                androidx.transition.t_renamed tVar = aVar.f1737c;
                android.view.View view = aVar.f1735a;
                androidx.transition.t_renamed transitionValues = getTransitionValues(view, true);
                androidx.transition.t_renamed matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f1757a.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && aVar.e_renamed.isTransitionRequired(tVar, matchedTransitionValues)) {
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

    public boolean isTransitionRequired(androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        if (tVar == null || tVar2 == null) {
            return false;
        }
        java.lang.String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (java.lang.String str : transitionProperties) {
                if (!isValueChanged(tVar, tVar2, str)) {
                }
            }
            return false;
        }
        java.util.Iterator<java.lang.String> it = tVar.f1754a.keySet().iterator();
        while (it.hasNext()) {
            if (isValueChanged(tVar, tVar2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2, java.lang.String str) {
        java.lang.Object obj = tVar.f1754a.get(str);
        java.lang.Object obj2 = tVar2.f1754a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void animate(android.animation.Animator animator) {
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
        animator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.transition.m_renamed.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator2) {
                androidx.transition.m_renamed.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    protected void start() {
        if (this.mNumInstances == 0) {
            java.util.ArrayList<androidx.transition.m_renamed.d_renamed> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                java.util.ArrayList arrayList2 = (java.util.ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    ((androidx.transition.m_renamed.d_renamed) arrayList2.get(i_renamed)).e_renamed(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    protected void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            java.util.ArrayList<androidx.transition.m_renamed.d_renamed> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                java.util.ArrayList arrayList2 = (java.util.ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    ((androidx.transition.m_renamed.d_renamed) arrayList2.get(i_renamed)).b_renamed(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.f1759c.size(); i2++) {
                android.view.View viewValueAt = this.mStartValues.f1759c.valueAt(i2);
                if (viewValueAt != null) {
                    androidx.core.h_renamed.v_renamed.a_renamed(viewValueAt, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.f1759c.size(); i3++) {
                android.view.View viewValueAt2 = this.mEndValues.f1759c.valueAt(i3);
                if (viewValueAt2 != null) {
                    androidx.core.h_renamed.v_renamed.a_renamed(viewValueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void forceToEnd(android.view.ViewGroup viewGroup) {
        androidx.collection.ArrayMap<android.animation.Animator, androidx.transition.m_renamed.a_renamed> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        androidx.transition.an_renamed anVarB = androidx.transition.ad_renamed.b_renamed(viewGroup);
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(runningAnimators);
        runningAnimators.clear();
        for (int i_renamed = size - 1; i_renamed >= 0; i_renamed--) {
            androidx.transition.m_renamed.a_renamed aVar = (androidx.transition.m_renamed.a_renamed) arrayMap.valueAt(i_renamed);
            if (aVar.f1735a != null && anVarB != null && anVarB.equals(aVar.d_renamed)) {
                ((android.animation.Animator) arrayMap.keyAt(i_renamed)).end();
            }
        }
    }

    protected void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        java.util.ArrayList<androidx.transition.m_renamed.d_renamed> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        java.util.ArrayList arrayList2 = (java.util.ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i_renamed = 0; i_renamed < size2; i_renamed++) {
            ((androidx.transition.m_renamed.d_renamed) arrayList2.get(i_renamed)).a_renamed(this);
        }
    }

    public androidx.transition.m_renamed addListener(androidx.transition.m_renamed.d_renamed dVar) {
        if (this.mListeners == null) {
            this.mListeners = new java.util.ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public androidx.transition.m_renamed removeListener(androidx.transition.m_renamed.d_renamed dVar) {
        java.util.ArrayList<androidx.transition.m_renamed.d_renamed> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(androidx.transition.g_renamed gVar) {
        if (gVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = gVar;
        }
    }

    public androidx.transition.g_renamed getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(androidx.transition.m_renamed.c_renamed cVar) {
        this.mEpicenterCallback = cVar;
    }

    public androidx.transition.m_renamed.c_renamed getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public android.graphics.Rect getEpicenter() {
        androidx.transition.m_renamed.c_renamed cVar = this.mEpicenterCallback;
        if (cVar == null) {
            return null;
        }
        return cVar.a_renamed(this);
    }

    public void setPropagation(androidx.transition.p_renamed pVar) {
        this.mPropagation = pVar;
    }

    public androidx.transition.p_renamed getPropagation() {
        return this.mPropagation;
    }

    void capturePropagationValues(androidx.transition.t_renamed tVar) {
        java.lang.String[] strArrA;
        if (this.mPropagation == null || tVar.f1754a.isEmpty() || (strArrA = this.mPropagation.a_renamed()) == null) {
            return;
        }
        boolean z_renamed = false;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= strArrA.length) {
                z_renamed = true;
                break;
            } else if (!tVar.f1754a.containsKey(strArrA[i_renamed])) {
                break;
            } else {
                i_renamed++;
            }
        }
        if (z_renamed) {
            return;
        }
        this.mPropagation.a_renamed(tVar);
    }

    androidx.transition.m_renamed setSceneRoot(android.view.ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    void setCanRemoveViews(boolean z_renamed) {
        this.mCanRemoveViews = z_renamed;
    }

    public java.lang.String toString() {
        return toString("");
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public androidx.transition.m_renamed mo2clone() {
        try {
            androidx.transition.m_renamed mVar = (androidx.transition.m_renamed) super.clone();
            mVar.mAnimators = new java.util.ArrayList<>();
            mVar.mStartValues = new androidx.transition.u_renamed();
            mVar.mEndValues = new androidx.transition.u_renamed();
            mVar.mStartValuesList = null;
            mVar.mEndValuesList = null;
            return mVar;
        } catch (java.lang.CloneNotSupportedException unused) {
            return null;
        }
    }

    public java.lang.String getName() {
        return this.mName;
    }

    java.lang.String toString(java.lang.String str) {
        java.lang.String str2 = str + getClass().getSimpleName() + "@" + java.lang.Integer.toHexString(hashCode()) + ": ";
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
        java.lang.String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            java.lang.String str4 = str3;
            for (int i_renamed = 0; i_renamed < this.mTargetIds.size(); i_renamed++) {
                if (i_renamed > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.mTargetIds.get(i_renamed);
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
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.view.View f1735a;

        /* renamed from: b_renamed, reason: collision with root package name */
        java.lang.String f1736b;

        /* renamed from: c_renamed, reason: collision with root package name */
        androidx.transition.t_renamed f1737c;
        androidx.transition.an_renamed d_renamed;
        androidx.transition.m_renamed e_renamed;

        a_renamed(android.view.View view, java.lang.String str, androidx.transition.m_renamed mVar, androidx.transition.an_renamed anVar, androidx.transition.t_renamed tVar) {
            this.f1735a = view;
            this.f1736b = str;
            this.f1737c = tVar;
            this.d_renamed = anVar;
            this.e_renamed = mVar;
        }
    }

    /* compiled from: Transition.java */
    private static class b_renamed {
        static <T_renamed> java.util.ArrayList<T_renamed> a_renamed(java.util.ArrayList<T_renamed> arrayList, T_renamed t_renamed) {
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
            }
            if (!arrayList.contains(t_renamed)) {
                arrayList.add(t_renamed);
            }
            return arrayList;
        }

        static <T_renamed> java.util.ArrayList<T_renamed> b_renamed(java.util.ArrayList<T_renamed> arrayList, T_renamed t_renamed) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t_renamed);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }
}
