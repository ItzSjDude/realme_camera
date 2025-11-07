package com.google.android.material.internal;

/* loaded from: classes.dex */
public final class StateListAnimator {
    private final java.util.ArrayList<com.google.android.material.internal.StateListAnimator.Tuple> tuples = new java.util.ArrayList<>();
    private com.google.android.material.internal.StateListAnimator.Tuple lastMatch = null;
    android.animation.ValueAnimator runningAnimator = null;
    private final android.animation.Animator.AnimatorListener animationListener = new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (com.google.android.material.internal.StateListAnimator.this.runningAnimator == animator) {
                com.google.android.material.internal.StateListAnimator.this.runningAnimator = null;
            }
        }
    };

    public void addState(int[] iArr, android.animation.ValueAnimator valueAnimator) {
        com.google.android.material.internal.StateListAnimator.Tuple tuple = new com.google.android.material.internal.StateListAnimator.Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(tuple);
    }

    public void setState(int[] iArr) {
        com.google.android.material.internal.StateListAnimator.Tuple tuple;
        int size = this.tuples.size();
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= size) {
                tuple = null;
                break;
            }
            tuple = this.tuples.get(i_renamed);
            if (android.util.StateSet.stateSetMatches(tuple.specs, iArr)) {
                break;
            } else {
                i_renamed++;
            }
        }
        com.google.android.material.internal.StateListAnimator.Tuple tuple2 = this.lastMatch;
        if (tuple == tuple2) {
            return;
        }
        if (tuple2 != null) {
            cancel();
        }
        this.lastMatch = tuple;
        if (tuple != null) {
            start(tuple);
        }
    }

    private void start(com.google.android.material.internal.StateListAnimator.Tuple tuple) {
        this.runningAnimator = tuple.animator;
        this.runningAnimator.start();
    }

    private void cancel() {
        android.animation.ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    public void jumpToCurrentState() {
        android.animation.ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.runningAnimator = null;
        }
    }

    static class Tuple {
        final android.animation.ValueAnimator animator;
        final int[] specs;

        Tuple(int[] iArr, android.animation.ValueAnimator valueAnimator) {
            this.specs = iArr;
            this.animator = valueAnimator;
        }
    }
}
