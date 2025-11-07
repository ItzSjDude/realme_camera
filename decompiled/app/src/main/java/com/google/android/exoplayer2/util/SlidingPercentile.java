package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public class SlidingPercentile {
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private int totalWeight;
    private static final java.util.Comparator<com.google.android.exoplayer2.util.SlidingPercentile.Sample> INDEX_COMPARATOR = new java.util.Comparator() { // from class: com.google.android.exoplayer2.util.-$$Lambda$SlidingPercentile$IHMSNRVWSvKImU2XQD2j4ISb4-U_renamed
        @Override // java.util.Comparator
        public final int compare(java.lang.Object obj, java.lang.Object obj2) {
            return com.google.android.exoplayer2.util.SlidingPercentile.lambda$static$0((com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj, (com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj2);
        }
    };
    private static final java.util.Comparator<com.google.android.exoplayer2.util.SlidingPercentile.Sample> VALUE_COMPARATOR = new java.util.Comparator() { // from class: com.google.android.exoplayer2.util.-$$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE
        @Override // java.util.Comparator
        public final int compare(java.lang.Object obj, java.lang.Object obj2) {
            return java.lang.Float.compare(((com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj).value, ((com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj2).value);
        }
    };
    private final com.google.android.exoplayer2.util.SlidingPercentile.Sample[] recycledSamples = new com.google.android.exoplayer2.util.SlidingPercentile.Sample[5];
    private final java.util.ArrayList<com.google.android.exoplayer2.util.SlidingPercentile.Sample> samples = new java.util.ArrayList<>();
    private int currentSortOrder = -1;

    static /* synthetic */ int lambda$static$0(com.google.android.exoplayer2.util.SlidingPercentile.Sample sample, com.google.android.exoplayer2.util.SlidingPercentile.Sample sample2) {
        return sample.index - sample2.index;
    }

    public SlidingPercentile(int i_renamed) {
        this.maxWeight = i_renamed;
    }

    public void addSample(int i_renamed, float f_renamed) {
        com.google.android.exoplayer2.util.SlidingPercentile.Sample sample;
        ensureSortedByIndex();
        int i2 = this.recycledSampleCount;
        if (i2 > 0) {
            com.google.android.exoplayer2.util.SlidingPercentile.Sample[] sampleArr = this.recycledSamples;
            int i3 = i2 - 1;
            this.recycledSampleCount = i3;
            sample = sampleArr[i3];
        } else {
            sample = new com.google.android.exoplayer2.util.SlidingPercentile.Sample();
        }
        int i4 = this.nextSampleIndex;
        this.nextSampleIndex = i4 + 1;
        sample.index = i4;
        sample.weight = i_renamed;
        sample.value = f_renamed;
        this.samples.add(sample);
        this.totalWeight += i_renamed;
        while (true) {
            int i5 = this.totalWeight;
            int i6 = this.maxWeight;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            com.google.android.exoplayer2.util.SlidingPercentile.Sample sample2 = this.samples.get(0);
            if (sample2.weight <= i7) {
                this.totalWeight -= sample2.weight;
                this.samples.remove(0);
                int i8 = this.recycledSampleCount;
                if (i8 < 5) {
                    com.google.android.exoplayer2.util.SlidingPercentile.Sample[] sampleArr2 = this.recycledSamples;
                    this.recycledSampleCount = i8 + 1;
                    sampleArr2[i8] = sample2;
                }
            } else {
                sample2.weight -= i7;
                this.totalWeight -= i7;
            }
        }
    }

    public float getPercentile(float f_renamed) {
        ensureSortedByValue();
        float f2 = f_renamed * this.totalWeight;
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.samples.size(); i2++) {
            com.google.android.exoplayer2.util.SlidingPercentile.Sample sample = this.samples.get(i2);
            i_renamed += sample.weight;
            if (i_renamed >= f2) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        return this.samples.get(r4.size() - 1).value;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            java.util.Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            java.util.Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }
}
