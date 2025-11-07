package com.google.android.material.animation;

/* loaded from: classes.dex */
public class MotionSpec {
    private static final java.lang.String TAG = "MotionSpec";
    private final androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.material.animation.MotionTiming> timings = new androidx.collection.SimpleArrayMap<>();
    private final androidx.collection.SimpleArrayMap<java.lang.String, android.animation.PropertyValuesHolder[]> propertyValues = new androidx.collection.SimpleArrayMap<>();

    public boolean hasTiming(java.lang.String str) {
        return this.timings.get(str) != null;
    }

    public com.google.android.material.animation.MotionTiming getTiming(java.lang.String str) {
        if (!hasTiming(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return this.timings.get(str);
    }

    public void setTiming(java.lang.String str, com.google.android.material.animation.MotionTiming motionTiming) {
        this.timings.put(str, motionTiming);
    }

    public boolean hasPropertyValues(java.lang.String str) {
        return this.propertyValues.get(str) != null;
    }

    public android.animation.PropertyValuesHolder[] getPropertyValues(java.lang.String str) {
        if (!hasPropertyValues(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return clonePropertyValuesHolder(this.propertyValues.get(str));
    }

    public void setPropertyValues(java.lang.String str, android.animation.PropertyValuesHolder[] propertyValuesHolderArr) {
        this.propertyValues.put(str, propertyValuesHolderArr);
    }

    private android.animation.PropertyValuesHolder[] clonePropertyValuesHolder(android.animation.PropertyValuesHolder[] propertyValuesHolderArr) {
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr2 = new android.animation.PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i_renamed = 0; i_renamed < propertyValuesHolderArr.length; i_renamed++) {
            propertyValuesHolderArr2[i_renamed] = propertyValuesHolderArr[i_renamed].clone();
        }
        return propertyValuesHolderArr2;
    }

    public <T_renamed> android.animation.ObjectAnimator getAnimator(java.lang.String str, T_renamed t_renamed, android.util.Property<T_renamed, ?> property) {
        android.animation.ObjectAnimator objectAnimatorOfPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(t_renamed, getPropertyValues(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        getTiming(str).apply(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public long getTotalDuration() {
        int size = this.timings.size();
        long jMax = 0;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.material.animation.MotionTiming motionTimingValueAt = this.timings.valueAt(i_renamed);
            jMax = java.lang.Math.max(jMax, motionTimingValueAt.getDelay() + motionTimingValueAt.getDuration());
        }
        return jMax;
    }

    public static com.google.android.material.animation.MotionSpec createFromAttribute(android.content.Context context, android.content.res.TypedArray typedArray, int i_renamed) {
        int resourceId;
        if (!typedArray.hasValue(i_renamed) || (resourceId = typedArray.getResourceId(i_renamed, 0)) == 0) {
            return null;
        }
        return createFromResource(context, resourceId);
    }

    public static com.google.android.material.animation.MotionSpec createFromResource(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        try {
            android.animation.Animator animatorLoadAnimator = android.animation.AnimatorInflater.loadAnimator(context, i_renamed);
            if (animatorLoadAnimator instanceof android.animation.AnimatorSet) {
                return createSpecFromAnimators(((android.animation.AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(animatorLoadAnimator);
            return createSpecFromAnimators(arrayList);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.w_renamed(TAG, "Can't_renamed load animation resource ID_renamed #0x" + java.lang.Integer.toHexString(i_renamed), e_renamed);
            return null;
        }
    }

    private static com.google.android.material.animation.MotionSpec createSpecFromAnimators(java.util.List<android.animation.Animator> list) {
        com.google.android.material.animation.MotionSpec motionSpec = new com.google.android.material.animation.MotionSpec();
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            addInfoFromAnimator(motionSpec, list.get(i_renamed));
        }
        return motionSpec;
    }

    private static void addInfoFromAnimator(com.google.android.material.animation.MotionSpec motionSpec, android.animation.Animator animator) {
        if (animator instanceof android.animation.ObjectAnimator) {
            android.animation.ObjectAnimator objectAnimator = (android.animation.ObjectAnimator) animator;
            motionSpec.setPropertyValues(objectAnimator.getPropertyName(), objectAnimator.getValues());
            motionSpec.setTiming(objectAnimator.getPropertyName(), com.google.android.material.animation.MotionTiming.createFromAnimator(objectAnimator));
        } else {
            throw new java.lang.IllegalArgumentException("Animator must be_renamed an_renamed ObjectAnimator: " + animator);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.google.android.material.animation.MotionSpec) {
            return this.timings.equals(((com.google.android.material.animation.MotionSpec) obj).timings);
        }
        return false;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public java.lang.String toString() {
        return '\n_renamed' + getClass().getName() + '{' + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " timings: " + this.timings + "}\n_renamed";
    }
}
