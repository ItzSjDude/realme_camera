package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public class DefaultTrackSelector extends com.google.android.exoplayer2.trackselection.MappingTrackSelector {
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final int[] NO_TRACKS = new int[0];
    private static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    private final com.google.android.exoplayer2.trackselection.TrackSelection.Factory adaptiveTrackSelectionFactory;
    private final java.util.concurrent.atomic.AtomicReference<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters> parametersReference;

    private static int compareFormatValues(int i_renamed, int i2) {
        if (i_renamed == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i_renamed - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareInts(int i_renamed, int i2) {
        if (i_renamed > i2) {
            return 1;
        }
        return i2 > i_renamed ? -1 : 0;
    }

    protected static boolean isSupported(int i_renamed, boolean z_renamed) {
        int i2 = i_renamed & 7;
        return i2 == 4 || (z_renamed && i2 == 3);
    }

    public static final class ParametersBuilder {
        private boolean allowMixedMimeAdaptiveness;
        private boolean allowNonSeamlessAdaptiveness;
        private int disabledTextTrackSelectionFlags;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private java.lang.String preferredAudioLanguage;
        private java.lang.String preferredTextLanguage;
        private final android.util.SparseBooleanArray rendererDisabledFlags;
        private boolean selectUndeterminedTextLanguage;
        private final android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        public ParametersBuilder() {
            this(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.DEFAULT);
        }

        private ParametersBuilder(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
            this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
            this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
            this.preferredAudioLanguage = parameters.preferredAudioLanguage;
            this.preferredTextLanguage = parameters.preferredTextLanguage;
            this.selectUndeterminedTextLanguage = parameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = parameters.disabledTextTrackSelectionFlags;
            this.forceLowestBitrate = parameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = parameters.forceHighestSupportedBitrate;
            this.allowMixedMimeAdaptiveness = parameters.allowMixedMimeAdaptiveness;
            this.allowNonSeamlessAdaptiveness = parameters.allowNonSeamlessAdaptiveness;
            this.maxVideoWidth = parameters.maxVideoWidth;
            this.maxVideoHeight = parameters.maxVideoHeight;
            this.maxVideoFrameRate = parameters.maxVideoFrameRate;
            this.maxVideoBitrate = parameters.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.viewportWidth = parameters.viewportWidth;
            this.viewportHeight = parameters.viewportHeight;
            this.viewportOrientationMayChange = parameters.viewportOrientationMayChange;
            this.tunnelingAudioSessionId = parameters.tunnelingAudioSessionId;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setPreferredAudioLanguage(java.lang.String str) {
            this.preferredAudioLanguage = str;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setPreferredTextLanguage(java.lang.String str) {
            this.preferredTextLanguage = str;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setSelectUndeterminedTextLanguage(boolean z_renamed) {
            this.selectUndeterminedTextLanguage = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setDisabledTextTrackSelectionFlags(int i_renamed) {
            this.disabledTextTrackSelectionFlags = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setForceLowestBitrate(boolean z_renamed) {
            this.forceLowestBitrate = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setForceHighestSupportedBitrate(boolean z_renamed) {
            this.forceHighestSupportedBitrate = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowMixedMimeAdaptiveness(boolean z_renamed) {
            this.allowMixedMimeAdaptiveness = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowNonSeamlessAdaptiveness(boolean z_renamed) {
            this.allowNonSeamlessAdaptiveness = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoSize(int i_renamed, int i2) {
            this.maxVideoWidth = i_renamed;
            this.maxVideoHeight = i2;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoFrameRate(int i_renamed) {
            this.maxVideoFrameRate = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoBitrate(int i_renamed) {
            this.maxVideoBitrate = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z_renamed) {
            this.exceedVideoConstraintsIfNecessary = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z_renamed) {
            this.exceedRendererCapabilitiesIfNecessary = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setViewportSizeToPhysicalDisplaySize(android.content.Context context, boolean z_renamed) {
            android.graphics.Point physicalDisplaySize = com.google.android.exoplayer2.util.Util.getPhysicalDisplaySize(context);
            return setViewportSize(physicalDisplaySize.x_renamed, physicalDisplaySize.y_renamed, z_renamed);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setViewportSize(int i_renamed, int i2, boolean z_renamed) {
            this.viewportWidth = i_renamed;
            this.viewportHeight = i2;
            this.viewportOrientationMayChange = z_renamed;
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setRendererDisabled(int i_renamed, boolean z_renamed) {
            if (this.rendererDisabledFlags.get(i_renamed) == z_renamed) {
                return this;
            }
            if (z_renamed) {
                this.rendererDisabledFlags.put(i_renamed, true);
            } else {
                this.rendererDisabledFlags.delete(i_renamed);
            }
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i_renamed);
            if (map == null) {
                map = new java.util.HashMap<>();
                this.selectionOverrides.put(i_renamed, map);
            }
            if (map.containsKey(trackGroupArray) && com.google.android.exoplayer2.util.Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i_renamed);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.selectionOverrides.remove(i_renamed);
                }
            }
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearSelectionOverrides(int i_renamed) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i_renamed);
            if (map != null && !map.isEmpty()) {
                this.selectionOverrides.remove(i_renamed);
            }
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setTunnelingAudioSessionId(int i_renamed) {
            if (this.tunnelingAudioSessionId != i_renamed) {
                this.tunnelingAudioSessionId = i_renamed;
            }
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters build() {
            return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters(this.selectionOverrides, this.rendererDisabledFlags, this.preferredAudioLanguage, this.preferredTextLanguage, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.tunnelingAudioSessionId);
        }

        private static android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> cloneSelectionOverrides(android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray) {
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray2 = new android.util.SparseArray<>();
            for (int i_renamed = 0; i_renamed < sparseArray.size(); i_renamed++) {
                sparseArray2.put(sparseArray.keyAt(i_renamed), new java.util.HashMap(sparseArray.valueAt(i_renamed)));
            }
            return sparseArray2;
        }
    }

    public static final class Parameters implements android.os.Parcelable {
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final int disabledTextTrackSelectionFlags;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final java.lang.String preferredAudioLanguage;
        public final java.lang.String preferredTextLanguage;
        private final android.util.SparseBooleanArray rendererDisabledFlags;
        public final boolean selectUndeterminedTextLanguage;
        private final android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;
        public static final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters DEFAULT = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters();
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters>() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters[] newArray(int i_renamed) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters[i_renamed];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private Parameters() {
            this(new android.util.SparseArray(), new android.util.SparseBooleanArray(), null, null, false, 0, false, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        Parameters(android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray, android.util.SparseBooleanArray sparseBooleanArray, java.lang.String str, java.lang.String str2, boolean z_renamed, int i_renamed, boolean z2, boolean z3, boolean z4, boolean z5, int i2, int i3, int i4, int i5, boolean z6, boolean z7, int i6, int i7, boolean z8, int i8) {
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
            this.preferredAudioLanguage = com.google.android.exoplayer2.util.Util.normalizeLanguageCode(str);
            this.preferredTextLanguage = com.google.android.exoplayer2.util.Util.normalizeLanguageCode(str2);
            this.selectUndeterminedTextLanguage = z_renamed;
            this.disabledTextTrackSelectionFlags = i_renamed;
            this.forceLowestBitrate = z2;
            this.forceHighestSupportedBitrate = z3;
            this.allowMixedMimeAdaptiveness = z4;
            this.allowNonSeamlessAdaptiveness = z5;
            this.maxVideoWidth = i2;
            this.maxVideoHeight = i3;
            this.maxVideoFrameRate = i4;
            this.maxVideoBitrate = i5;
            this.exceedVideoConstraintsIfNecessary = z6;
            this.exceedRendererCapabilitiesIfNecessary = z7;
            this.viewportWidth = i6;
            this.viewportHeight = i7;
            this.viewportOrientationMayChange = z8;
            this.tunnelingAudioSessionId = i8;
        }

        Parameters(android.os.Parcel parcel) {
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = parcel.readSparseBooleanArray();
            this.preferredAudioLanguage = parcel.readString();
            this.preferredTextLanguage = parcel.readString();
            this.selectUndeterminedTextLanguage = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.disabledTextTrackSelectionFlags = parcel.readInt();
            this.forceLowestBitrate = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.forceHighestSupportedBitrate = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowMixedMimeAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowNonSeamlessAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
        }

        public final boolean getRendererDisabled(int i_renamed) {
            return this.rendererDisabledFlags.get(i_renamed);
        }

        public final boolean hasSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i_renamed);
            return map != null && map.containsKey(trackGroupArray);
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride getSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i_renamed);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon() {
            return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder(this);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) obj;
            return this.selectUndeterminedTextLanguage == parameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == parameters.disabledTextTrackSelectionFlags && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && android.text.TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && android.text.TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage) && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides);
        }

        public int hashCode() {
            int i_renamed = (((((((((((((((((((((((((((((((this.selectUndeterminedTextLanguage ? 1 : 0) * 31) + this.disabledTextTrackSelectionFlags) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxVideoBitrate) * 31) + this.tunnelingAudioSessionId) * 31;
            java.lang.String str = this.preferredAudioLanguage;
            int iHashCode = (i_renamed + (str == null ? 0 : str.hashCode())) * 31;
            java.lang.String str2 = this.preferredTextLanguage;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
            parcel.writeString(this.preferredAudioLanguage);
            parcel.writeString(this.preferredTextLanguage);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
            parcel.writeInt(this.disabledTextTrackSelectionFlags);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.forceLowestBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.forceHighestSupportedBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowMixedMimeAdaptiveness);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowNonSeamlessAdaptiveness);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.tunnelingAudioSessionId);
        }

        private static android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> readSelectionOverrides(android.os.Parcel parcel) {
            int i_renamed = parcel.readInt();
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray = new android.util.SparseArray<>(i_renamed);
            for (int i2 = 0; i2 < i_renamed; i2++) {
                int i3 = parcel.readInt();
                int i4 = parcel.readInt();
                java.util.HashMap map = new java.util.HashMap(i4);
                for (int i5 = 0; i5 < i4; i5++) {
                    map.put((com.google.android.exoplayer2.source.TrackGroupArray) parcel.readParcelable(com.google.android.exoplayer2.source.TrackGroupArray.class.getClassLoader()), (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride) parcel.readParcelable(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(i3, map);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(android.os.Parcel parcel, android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                int iKeyAt = sparseArray.keyAt(i_renamed);
                java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> mapValueAt = sparseArray.valueAt(i_renamed);
                int size2 = mapValueAt.size();
                parcel.writeInt(iKeyAt);
                parcel.writeInt(size2);
                for (java.util.Map.Entry<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> entry : mapValueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        private static boolean areRendererDisabledFlagsEqual(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i_renamed)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray, android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i_renamed));
                if (iIndexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i_renamed), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (java.util.Map.Entry<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> entry : map.entrySet()) {
                com.google.android.exoplayer2.source.TrackGroupArray key = entry.getKey();
                if (!map2.containsKey(key) || !com.google.android.exoplayer2.util.Util.areEqual(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class SelectionOverride implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride[] newArray(int i_renamed) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride[i_renamed];
            }
        };
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SelectionOverride(int i_renamed, int... iArr) {
            this.groupIndex = i_renamed;
            this.tracks = java.util.Arrays.copyOf(iArr, iArr.length);
            this.length = iArr.length;
            java.util.Arrays.sort(this.tracks);
        }

        SelectionOverride(android.os.Parcel parcel) {
            this.groupIndex = parcel.readInt();
            this.length = parcel.readByte();
            this.tracks = new int[this.length];
            parcel.readIntArray(this.tracks);
        }

        public boolean containsTrack(int i_renamed) {
            for (int i2 : this.tracks) {
                if (i2 == i_renamed) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.groupIndex * 31) + java.util.Arrays.hashCode(this.tracks);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride) obj;
            return this.groupIndex == selectionOverride.groupIndex && java.util.Arrays.equals(this.tracks, selectionOverride.tracks);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
        }
    }

    public DefaultTrackSelector() {
        this(new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory());
    }

    @java.lang.Deprecated
    public DefaultTrackSelector(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        this(new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory(bandwidthMeter));
    }

    public DefaultTrackSelector(com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.parametersReference = new java.util.concurrent.atomic.AtomicReference<>(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.DEFAULT);
    }

    public void setParameters(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(parameters);
        if (this.parametersReference.getAndSet(parameters).equals(parameters)) {
            return;
        }
        invalidate();
    }

    public void setParameters(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters getParameters() {
        return this.parametersReference.get();
    }

    public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    @java.lang.Deprecated
    public final void setRendererDisabled(int i_renamed, boolean z_renamed) {
        setParameters(buildUponParameters().setRendererDisabled(i_renamed, z_renamed));
    }

    @java.lang.Deprecated
    public final boolean getRendererDisabled(int i_renamed) {
        return getParameters().getRendererDisabled(i_renamed);
    }

    @java.lang.Deprecated
    public final void setSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride) {
        setParameters(buildUponParameters().setSelectionOverride(i_renamed, trackGroupArray, selectionOverride));
    }

    @java.lang.Deprecated
    public final boolean hasSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
        return getParameters().hasSelectionOverride(i_renamed, trackGroupArray);
    }

    @java.lang.Deprecated
    public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride getSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
        return getParameters().getSelectionOverride(i_renamed, trackGroupArray);
    }

    @java.lang.Deprecated
    public final void clearSelectionOverride(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
        setParameters(buildUponParameters().clearSelectionOverride(i_renamed, trackGroupArray));
    }

    @java.lang.Deprecated
    public final void clearSelectionOverrides(int i_renamed) {
        setParameters(buildUponParameters().clearSelectionOverrides(i_renamed));
    }

    @java.lang.Deprecated
    public final void clearSelectionOverrides() {
        setParameters(buildUponParameters().clearSelectionOverrides());
    }

    @java.lang.Deprecated
    public void setTunnelingAudioSessionId(int i_renamed) {
        setParameters(buildUponParameters().setTunnelingAudioSessionId(i_renamed));
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    protected final android.util.Pair<com.google.android.exoplayer2.RendererConfiguration[], com.google.android.exoplayer2.trackselection.TrackSelection[]> selectTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArrSelectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        for (int i_renamed = 0; i_renamed < rendererCount; i_renamed++) {
            if (parameters.getRendererDisabled(i_renamed)) {
                trackSelectionArrSelectAllTracks[i_renamed] = null;
            } else {
                com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i_renamed);
                if (parameters.hasSelectionOverride(i_renamed, trackGroups)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = parameters.getSelectionOverride(i_renamed, trackGroups);
                    if (selectionOverride == null) {
                        trackSelectionArrSelectAllTracks[i_renamed] = null;
                    } else if (selectionOverride.length == 1) {
                        trackSelectionArrSelectAllTracks[i_renamed] = new com.google.android.exoplayer2.trackselection.FixedTrackSelection(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks[0]);
                    } else {
                        trackSelectionArrSelectAllTracks[i_renamed] = ((com.google.android.exoplayer2.trackselection.TrackSelection.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.adaptiveTrackSelectionFactory)).createTrackSelection(trackGroups.get(selectionOverride.groupIndex), getBandwidthMeter(), selectionOverride.tracks);
                    }
                }
            }
        }
        com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurationArr = new com.google.android.exoplayer2.RendererConfiguration[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            rendererConfigurationArr[i2] = !parameters.getRendererDisabled(i2) && (mappedTrackInfo.getRendererType(i2) == 6 || trackSelectionArrSelectAllTracks[i2] != null) ? com.google.android.exoplayer2.RendererConfiguration.DEFAULT : null;
        }
        maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, trackSelectionArrSelectAllTracks, parameters.tunnelingAudioSessionId);
        return android.util.Pair.create(rendererConfigurationArr, trackSelectionArrSelectAllTracks);
    }

    protected com.google.android.exoplayer2.trackselection.TrackSelection[] selectAllTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) throws com.google.android.exoplayer2.ExoPlaybackException {
        int i_renamed;
        int i2;
        int i3;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore;
        int i4;
        int i5;
        int rendererCount = mappedTrackInfo.getRendererCount();
        com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr = new com.google.android.exoplayer2.trackselection.TrackSelection[rendererCount];
        int i6 = 0;
        boolean z_renamed = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i_renamed = 2;
            if (i7 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo.getRendererType(i7)) {
                if (!z_renamed) {
                    trackSelectionArr[i7] = selectVideoTrack(mappedTrackInfo.getTrackGroups(i7), iArr[i7], iArr2[i7], parameters, this.adaptiveTrackSelectionFactory);
                    z_renamed = trackSelectionArr[i7] != null;
                }
                i8 |= mappedTrackInfo.getTrackGroups(i7).length <= 0 ? 0 : 1;
            }
            i7++;
        }
        int iIntValue = Integer.MIN_VALUE;
        int i9 = -1;
        int i10 = -1;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore2 = null;
        while (i6 < rendererCount) {
            int rendererType = mappedTrackInfo.getRendererType(i6);
            if (rendererType != i2) {
                if (rendererType != i_renamed) {
                    if (rendererType == 3) {
                        android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection, java.lang.Integer> pairSelectTextTrack = selectTextTrack(mappedTrackInfo.getTrackGroups(i6), iArr[i6], parameters);
                        if (pairSelectTextTrack != null && ((java.lang.Integer) pairSelectTextTrack.second).intValue() > iIntValue) {
                            if (i10 != -1) {
                                trackSelectionArr[i10] = null;
                            }
                            trackSelectionArr[i6] = (com.google.android.exoplayer2.trackselection.TrackSelection) pairSelectTextTrack.first;
                            iIntValue = ((java.lang.Integer) pairSelectTextTrack.second).intValue();
                            i10 = i6;
                            i6++;
                            i_renamed = 2;
                            i2 = 1;
                        }
                    } else {
                        trackSelectionArr[i6] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i6), iArr[i6], parameters);
                    }
                }
                i3 = i9;
                audioTrackScore = audioTrackScore2;
                i4 = i10;
                i5 = iIntValue;
            } else {
                i3 = i9;
                audioTrackScore = audioTrackScore2;
                i4 = i10;
                i5 = iIntValue;
                android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> pairSelectAudioTrack = selectAudioTrack(mappedTrackInfo.getTrackGroups(i6), iArr[i6], iArr2[i6], parameters, i8 != 0 ? null : this.adaptiveTrackSelectionFactory);
                if (pairSelectAudioTrack != null && (audioTrackScore == null || ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) pairSelectAudioTrack.second).compareTo(audioTrackScore) > 0)) {
                    if (i3 != -1) {
                        trackSelectionArr[i3] = null;
                    }
                    trackSelectionArr[i6] = (com.google.android.exoplayer2.trackselection.TrackSelection) pairSelectAudioTrack.first;
                    audioTrackScore2 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) pairSelectAudioTrack.second;
                    i9 = i6;
                }
                i10 = i4;
                iIntValue = i5;
                i6++;
                i_renamed = 2;
                i2 = 1;
            }
            audioTrackScore2 = audioTrackScore;
            i9 = i3;
            i10 = i4;
            iIntValue = i5;
            i6++;
            i_renamed = 2;
            i2 = 1;
        }
        return trackSelectionArr;
    }

    protected com.google.android.exoplayer2.trackselection.TrackSelection selectVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, int i_renamed, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelectionSelectAdaptiveVideoTrack = (parameters.forceHighestSupportedBitrate || parameters.forceLowestBitrate || factory == null) ? null : selectAdaptiveVideoTrack(trackGroupArray, iArr, i_renamed, parameters, factory, getBandwidthMeter());
        return trackSelectionSelectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, parameters) : trackSelectionSelectAdaptiveVideoTrack;
    }

    private static com.google.android.exoplayer2.trackselection.TrackSelection selectAdaptiveVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, int i_renamed, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray2 = trackGroupArray;
        int i2 = parameters.allowNonSeamlessAdaptiveness ? 24 : 16;
        boolean z_renamed = parameters.allowMixedMimeAdaptiveness && (i_renamed & i2) != 0;
        int i3 = 0;
        while (i3 < trackGroupArray2.length) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray2.get(i3);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i3], z_renamed, i2, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoFrameRate, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return ((com.google.android.exoplayer2.trackselection.TrackSelection.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory)).createTrackSelection(trackGroup, bandwidthMeter, adaptiveVideoTracksForGroup);
            }
            i3++;
            trackGroupArray2 = trackGroupArray;
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, boolean z_renamed, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        java.lang.String str;
        int adaptiveVideoTrackCountForMimeType;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        java.util.List<java.lang.Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i6, i7, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (z_renamed) {
            str = null;
        } else {
            java.util.HashSet hashSet = new java.util.HashSet();
            java.lang.String str2 = null;
            int i8 = 0;
            for (int i9 = 0; i9 < viewportFilteredTrackIndices.size(); i9++) {
                java.lang.String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i9).intValue()).sampleMimeType;
                if (hashSet.add(str3) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i_renamed, str3, i2, i3, i4, i5, viewportFilteredTrackIndices)) > i8) {
                    i8 = adaptiveVideoTrackCountForMimeType;
                    str2 = str3;
                }
            }
            str = str2;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i_renamed, str, i2, i3, i4, i5, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : com.google.android.exoplayer2.util.Util.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, int i_renamed, java.lang.String str, int i2, int i3, int i4, int i5, java.util.List<java.lang.Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int iIntValue = list.get(i7).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(iIntValue), str, iArr[iIntValue], i_renamed, i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, int i_renamed, java.lang.String str, int i2, int i3, int i4, int i5, java.util.List<java.lang.Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(iIntValue), str, iArr[iIntValue], i_renamed, i2, i3, i4, i5)) {
                list.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(com.google.android.exoplayer2.Format format, java.lang.String str, int i_renamed, int i2, int i3, int i4, int i5, int i6) {
        if (!isSupported(i_renamed, false) || (i_renamed & i2) == 0) {
            return false;
        }
        if (str != null && !com.google.android.exoplayer2.util.Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        if (format.width != -1 && format.width > i3) {
            return false;
        }
        if (format.height != -1 && format.height > i4) {
            return false;
        }
        if (format.frameRate == -1.0f || format.frameRate <= i5) {
            return format.bitrate == -1 || format.bitrate <= i6;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:48:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.trackselection.TrackSelection selectFixedVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray r19, int[][] r20, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r21) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.selectFixedVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.TrackSelection");
    }

    protected android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> selectAudioTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, int i_renamed, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.TrackSelection fixedTrackSelection = null;
        int i2 = 0;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore = null;
        int i3 = -1;
        int i4 = -1;
        while (i2 < trackGroupArray.length) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray.get(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore2 = audioTrackScore;
            int i6 = i3;
            for (int i7 = 0; i7 < trackGroup.length; i7++) {
                if (isSupported(iArr2[i7], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore3 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore(trackGroup.getFormat(i7), parameters, iArr2[i7]);
                    if (audioTrackScore2 == null || audioTrackScore3.compareTo(audioTrackScore2) > 0) {
                        i6 = i2;
                        i5 = i7;
                        audioTrackScore2 = audioTrackScore3;
                    }
                }
            }
            i2++;
            i3 = i6;
            audioTrackScore = audioTrackScore2;
            i4 = i5;
        }
        if (i3 == -1) {
            return null;
        }
        com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i3);
        if (!parameters.forceHighestSupportedBitrate && !parameters.forceLowestBitrate && factory != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i3], parameters.allowMixedMimeAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                fixedTrackSelection = factory.createTrackSelection(trackGroup2, getBandwidthMeter(), adaptiveAudioTracks);
            }
        }
        if (fixedTrackSelection == null) {
            fixedTrackSelection = new com.google.android.exoplayer2.trackselection.FixedTrackSelection(trackGroup2, i4);
        }
        return android.util.Pair.create(fixedTrackSelection, com.google.android.exoplayer2.util.Assertions.checkNotNull(audioTrackScore));
    }

    private static int[] getAdaptiveAudioTracks(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, boolean z_renamed) {
        int adaptiveAudioTrackCount;
        java.util.HashSet hashSet = new java.util.HashSet();
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple audioConfigurationTuple = null;
        int i_renamed = 0;
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            com.google.android.exoplayer2.Format format = trackGroup.getFormat(i2);
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple audioConfigurationTuple2 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple(format.channelCount, format.sampleRate, z_renamed ? null : format.sampleMimeType);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i_renamed) {
                i_renamed = adaptiveAudioTrackCount;
                audioConfigurationTuple = audioConfigurationTuple2;
            }
        }
        if (i_renamed > 1) {
            int[] iArr2 = new int[i_renamed];
            int i3 = 0;
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i4), iArr[i4], (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple) com.google.android.exoplayer2.util.Assertions.checkNotNull(audioConfigurationTuple))) {
                    iArr2[i3] = i4;
                    i3++;
                }
            }
            return iArr2;
        }
        return NO_TRACKS;
    }

    private static int getAdaptiveAudioTrackCount(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple audioConfigurationTuple) {
        int i_renamed = 0;
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i2), iArr[i2], audioConfigurationTuple)) {
                i_renamed++;
            }
        }
        return i_renamed;
    }

    private static boolean isSupportedAdaptiveAudioTrack(com.google.android.exoplayer2.Format format, int i_renamed, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple audioConfigurationTuple) {
        if (isSupported(i_renamed, false) && format.channelCount == audioConfigurationTuple.channelCount && format.sampleRate == audioConfigurationTuple.sampleRate) {
            return audioConfigurationTuple.mimeType == null || android.text.TextUtils.equals(audioConfigurationTuple.mimeType, format.sampleMimeType);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection, java.lang.Integer> selectTextTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) throws com.google.android.exoplayer2.ExoPlaybackException {
        int i_renamed = 0;
        int i2 = 0;
        int i3 = 0;
        com.google.android.exoplayer2.source.TrackGroup trackGroup = null;
        while (i_renamed < trackGroupArray.length) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i_renamed);
            int[] iArr2 = iArr[i_renamed];
            int i4 = i3;
            int i5 = i2;
            com.google.android.exoplayer2.source.TrackGroup trackGroup3 = trackGroup;
            for (int i6 = 0; i6 < trackGroup2.length; i6++) {
                if (isSupported(iArr2[i6], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    com.google.android.exoplayer2.Format format = trackGroup2.getFormat(i6);
                    int i7 = format.selectionFlags & (~parameters.disabledTextTrackSelectionFlags);
                    int i8 = 1;
                    java.lang.Object[] objArr = (i7 & 1) != 0;
                    java.lang.Object[] objArr2 = (i7 & 2) != 0;
                    boolean hasLanguage = formatHasLanguage(format, parameters.preferredTextLanguage);
                    if (hasLanguage || (parameters.selectUndeterminedTextLanguage && formatHasNoLanguage(format))) {
                        i8 = (objArr != false ? 8 : objArr2 == false ? 6 : 4) + (hasLanguage ? 1 : 0);
                    } else if (objArr == true) {
                        i8 = 3;
                    } else if (objArr2 != false) {
                        if (formatHasLanguage(format, parameters.preferredAudioLanguage)) {
                            i8 = 2;
                        }
                    }
                    if (isSupported(iArr2[i6], false)) {
                        i8 += 1000;
                    }
                    if (i8 > i4) {
                        i5 = i6;
                        trackGroup3 = trackGroup2;
                        i4 = i8;
                    }
                }
            }
            i_renamed++;
            trackGroup = trackGroup3;
            i2 = i5;
            i3 = i4;
        }
        if (trackGroup == null) {
            return null;
        }
        return android.util.Pair.create(new com.google.android.exoplayer2.trackselection.FixedTrackSelection(trackGroup, i2), java.lang.Integer.valueOf(i3));
    }

    protected com.google.android.exoplayer2.trackselection.TrackSelection selectOtherTrack(int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.source.TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < trackGroupArray.length) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            int i6 = i3;
            com.google.android.exoplayer2.source.TrackGroup trackGroup3 = trackGroup;
            for (int i7 = 0; i7 < trackGroup2.length; i7++) {
                if (isSupported(iArr2[i7], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i8 = (trackGroup2.getFormat(i7).selectionFlags & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr2[i7], false)) {
                        i8 += 1000;
                    }
                    if (i8 > i5) {
                        i6 = i7;
                        trackGroup3 = trackGroup2;
                        i5 = i8;
                    }
                }
            }
            i2++;
            trackGroup = trackGroup3;
            i3 = i6;
            i4 = i5;
        }
        if (trackGroup == null) {
            return null;
        }
        return new com.google.android.exoplayer2.trackselection.FixedTrackSelection(trackGroup, i3);
    }

    private static void maybeConfigureRenderersForTunneling(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurationArr, com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, int i_renamed) {
        boolean z_renamed;
        if (i_renamed == 0) {
            return;
        }
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < mappedTrackInfo.getRendererCount(); i4++) {
            int rendererType = mappedTrackInfo.getRendererType(i4);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i4];
            if ((rendererType == 1 || rendererType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i4], mappedTrackInfo.getTrackGroups(i4), trackSelection)) {
                if (rendererType == 1) {
                    if (i3 != -1) {
                        z_renamed = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z_renamed = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z_renamed = true;
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z_renamed && z2) {
            com.google.android.exoplayer2.RendererConfiguration rendererConfiguration = new com.google.android.exoplayer2.RendererConfiguration(i_renamed);
            rendererConfigurationArr[i3] = rendererConfiguration;
            rendererConfigurationArr[i2] = rendererConfiguration;
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int iIndexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i_renamed = 0; i_renamed < trackSelection.length(); i_renamed++) {
            if ((iArr[iIndexOf][trackSelection.getIndexInTrackGroup(i_renamed)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean formatHasNoLanguage(com.google.android.exoplayer2.Format format) {
        return android.text.TextUtils.isEmpty(format.language) || formatHasLanguage(format, com.google.android.exoplayer2.C_renamed.LANGUAGE_UNDETERMINED);
    }

    protected static boolean formatHasLanguage(com.google.android.exoplayer2.Format format, java.lang.String str) {
        return str != null && android.text.TextUtils.equals(str, com.google.android.exoplayer2.util.Util.normalizeLanguageCode(format.language));
    }

    private static java.util.List<java.lang.Integer> getViewportFilteredTrackIndices(com.google.android.exoplayer2.source.TrackGroup trackGroup, int i_renamed, int i2, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList(trackGroup.length);
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            arrayList.add(java.lang.Integer.valueOf(i3));
        }
        if (i_renamed != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                com.google.android.exoplayer2.Format format = trackGroup.getFormat(i5);
                if (format.width > 0 && format.height > 0) {
                    android.graphics.Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z_renamed, i_renamed, i2, format.width, format.height);
                    int i6 = format.width * format.height;
                    if (format.width >= ((int) (maxVideoSizeInViewport.x_renamed * FRACTION_TO_CONSIDER_FULLSCREEN)) && format.height >= ((int) (maxVideoSizeInViewport.y_renamed * FRACTION_TO_CONSIDER_FULLSCREEN)) && i6 < i4) {
                        i4 = i6;
                    }
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((java.lang.Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i4) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = r3
            goto L9
        L8:
            r1 = r0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = r0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class AudioTrackScore implements java.lang.Comparable<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final int defaultSelectionFlagScore;
        private final int matchLanguageScore;
        private final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters;
        private final int sampleRate;
        private final int withinRendererCapabilitiesScore;

        public AudioTrackScore(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i_renamed) {
            this.parameters = parameters;
            this.withinRendererCapabilitiesScore = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i_renamed, false) ? 1 : 0;
            this.matchLanguageScore = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.formatHasLanguage(format, parameters.preferredAudioLanguage) ? 1 : 0;
            this.defaultSelectionFlagScore = (format.selectionFlags & 1) == 0 ? 0 : 1;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore) {
            int iCompareInts;
            int i_renamed = this.withinRendererCapabilitiesScore;
            int i2 = audioTrackScore.withinRendererCapabilitiesScore;
            if (i_renamed != i2) {
                return com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(i_renamed, i2);
            }
            int i3 = this.matchLanguageScore;
            int i4 = audioTrackScore.matchLanguageScore;
            if (i3 != i4) {
                return com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(i3, i4);
            }
            int i5 = this.defaultSelectionFlagScore;
            int i6 = audioTrackScore.defaultSelectionFlagScore;
            if (i5 != i6) {
                return com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(i5, i6);
            }
            if (this.parameters.forceLowestBitrate) {
                return com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(audioTrackScore.bitrate, this.bitrate);
            }
            int i7 = this.withinRendererCapabilitiesScore != 1 ? -1 : 1;
            int i8 = this.channelCount;
            int i9 = audioTrackScore.channelCount;
            if (i8 != i9) {
                iCompareInts = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(i8, i9);
            } else {
                int i10 = this.sampleRate;
                int i11 = audioTrackScore.sampleRate;
                iCompareInts = i10 != i11 ? com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(i10, i11) : com.google.android.exoplayer2.trackselection.DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
            }
            return i7 * iCompareInts;
        }
    }

    private static final class AudioConfigurationTuple {
        public final int channelCount;
        public final java.lang.String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i_renamed, int i2, java.lang.String str) {
            this.channelCount = i_renamed;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple audioConfigurationTuple = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple) obj;
            return this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && android.text.TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType);
        }

        public int hashCode() {
            int i_renamed = ((this.channelCount * 31) + this.sampleRate) * 31;
            java.lang.String str = this.mimeType;
            return i_renamed + (str != null ? str.hashCode() : 0);
        }
    }
}
