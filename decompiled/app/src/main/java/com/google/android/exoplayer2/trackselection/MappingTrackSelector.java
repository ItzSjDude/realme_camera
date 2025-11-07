package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public abstract class MappingTrackSelector extends com.google.android.exoplayer2.trackselection.TrackSelector {
    private com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;

    protected abstract android.util.Pair<com.google.android.exoplayer2.RendererConfiguration[], com.google.android.exoplayer2.trackselection.TrackSelection[]> selectTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws com.google.android.exoplayer2.ExoPlaybackException;

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;

        @java.lang.Deprecated
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final com.google.android.exoplayer2.source.TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final com.google.android.exoplayer2.source.TrackGroupArray unmappedTrackGroups;

        MappedTrackInfo(int[] iArr, com.google.android.exoplayer2.source.TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererFormatSupports = iArr3;
            this.rendererMixedMimeTypeAdaptiveSupports = iArr2;
            this.unmappedTrackGroups = trackGroupArray;
            this.rendererCount = iArr.length;
            this.length = this.rendererCount;
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public int getRendererType(int i_renamed) {
            return this.rendererTrackTypes[i_renamed];
        }

        public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i_renamed) {
            return this.rendererTrackGroups[i_renamed];
        }

        public int getRendererSupport(int i_renamed) {
            int i2;
            int[][] iArr = this.rendererFormatSupports[i_renamed];
            int i3 = 0;
            int i4 = 0;
            while (i3 < iArr.length) {
                int iMax = i4;
                for (int i5 = 0; i5 < iArr[i3].length; i5++) {
                    int i6 = iArr[i3][i5] & 7;
                    if (i6 == 3) {
                        i2 = 2;
                    } else {
                        if (i6 == 4) {
                            return 3;
                        }
                        i2 = 1;
                    }
                    iMax = java.lang.Math.max(iMax, i2);
                }
                i3++;
                i4 = iMax;
            }
            return i4;
        }

        @java.lang.Deprecated
        public int getTrackTypeRendererSupport(int i_renamed) {
            return getTypeSupport(i_renamed);
        }

        public int getTypeSupport(int i_renamed) {
            int iMax = 0;
            for (int i2 = 0; i2 < this.rendererCount; i2++) {
                if (this.rendererTrackTypes[i2] == i_renamed) {
                    iMax = java.lang.Math.max(iMax, getRendererSupport(i2));
                }
            }
            return iMax;
        }

        @java.lang.Deprecated
        public int getTrackFormatSupport(int i_renamed, int i2, int i3) {
            return getTrackSupport(i_renamed, i2, i3);
        }

        public int getTrackSupport(int i_renamed, int i2, int i3) {
            return this.rendererFormatSupports[i_renamed][i2][i3] & 7;
        }

        public int getAdaptiveSupport(int i_renamed, int i2, boolean z_renamed) {
            int i3 = this.rendererTrackGroups[i_renamed].get(i2).length;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int trackSupport = getTrackSupport(i_renamed, i2, i5);
                if (trackSupport == 4 || (z_renamed && trackSupport == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return getAdaptiveSupport(i_renamed, i2, java.util.Arrays.copyOf(iArr, i4));
        }

        public int getAdaptiveSupport(int i_renamed, int i2, int[] iArr) {
            int i3 = 0;
            int iMin = 16;
            java.lang.String str = null;
            boolean z_renamed = false;
            int i4 = 0;
            while (i3 < iArr.length) {
                java.lang.String str2 = this.rendererTrackGroups[i_renamed].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i5 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z_renamed |= !com.google.android.exoplayer2.util.Util.areEqual(str, str2);
                }
                iMin = java.lang.Math.min(iMin, this.rendererFormatSupports[i_renamed][i2][i3] & 24);
                i3++;
                i4 = i5;
            }
            return z_renamed ? java.lang.Math.min(iMin, this.rendererMixedMimeTypeAdaptiveSupports[i_renamed]) : iMin;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.TrackGroupArray getUnassociatedTrackGroups() {
            return getUnmappedTrackGroups();
        }

        public com.google.android.exoplayer2.source.TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }
    }

    public final com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(java.lang.Object obj) {
        this.currentMappedTrackInfo = (com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo) obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult selectTracks(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) throws com.google.android.exoplayer2.ExoPlaybackException {
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        com.google.android.exoplayer2.source.TrackGroup[][] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[rendererCapabilitiesArr.length + 1][];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][][];
        for (int i_renamed = 0; i_renamed < trackGroupArr.length; i_renamed++) {
            trackGroupArr[i_renamed] = new com.google.android.exoplayer2.source.TrackGroup[trackGroupArray.length];
            iArr2[i_renamed] = new int[trackGroupArray.length][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray.get(i2);
            int iFindRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            int[] formatSupport = iFindRenderer == rendererCapabilitiesArr.length ? new int[trackGroup.length] : getFormatSupport(rendererCapabilitiesArr[iFindRenderer], trackGroup);
            int i3 = iArr[iFindRenderer];
            trackGroupArr[iFindRenderer][i3] = trackGroup;
            iArr2[iFindRenderer][i3] = formatSupport;
            iArr[iFindRenderer] = iArr[iFindRenderer] + 1;
        }
        com.google.android.exoplayer2.source.TrackGroupArray[] trackGroupArrayArr = new com.google.android.exoplayer2.source.TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            int i5 = iArr[i4];
            trackGroupArrayArr[i4] = new com.google.android.exoplayer2.source.TrackGroupArray((com.google.android.exoplayer2.source.TrackGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(trackGroupArr[i4], i5));
            iArr2[i4] = (int[][]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(iArr2[i4], i5);
            iArr3[i4] = rendererCapabilitiesArr[i4].getTrackType();
        }
        com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo = new com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr2, new com.google.android.exoplayer2.source.TrackGroupArray((com.google.android.exoplayer2.source.TrackGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length])));
        android.util.Pair<com.google.android.exoplayer2.RendererConfiguration[], com.google.android.exoplayer2.trackselection.TrackSelection[]> pairSelectTracks = selectTracks(mappedTrackInfo, iArr2, mixedMimeTypeAdaptationSupports);
        return new com.google.android.exoplayer2.trackselection.TrackSelectorResult((com.google.android.exoplayer2.RendererConfiguration[]) pairSelectTracks.first, (com.google.android.exoplayer2.trackselection.TrackSelection[]) pairSelectTracks.second, mappedTrackInfo);
    }

    private static int findRenderer(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.source.TrackGroup trackGroup) throws com.google.android.exoplayer2.ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < rendererCapabilitiesArr.length) {
            com.google.android.exoplayer2.RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i_renamed];
            int i3 = i2;
            int i4 = length;
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                int iSupportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i5)) & 7;
                if (iSupportsFormat > i3) {
                    if (iSupportsFormat == 4) {
                        return i_renamed;
                    }
                    i4 = i_renamed;
                    i3 = iSupportsFormat;
                }
            }
            i_renamed++;
            length = i4;
            i2 = i3;
        }
        return length;
    }

    private static int[] getFormatSupport(com.google.android.exoplayer2.RendererCapabilities rendererCapabilities, com.google.android.exoplayer2.source.TrackGroup trackGroup) throws com.google.android.exoplayer2.ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i_renamed = 0; i_renamed < trackGroup.length; i_renamed++) {
            iArr[i_renamed] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i_renamed));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr) throws com.google.android.exoplayer2.ExoPlaybackException {
        int[] iArr = new int[rendererCapabilitiesArr.length];
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            iArr[i_renamed] = rendererCapabilitiesArr[i_renamed].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }
}
