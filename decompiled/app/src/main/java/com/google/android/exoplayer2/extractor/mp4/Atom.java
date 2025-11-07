package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
abstract class Atom {
    public static final int DEFINES_LARGE_SIZE = 1;
    public static final int EXTENDS_TO_END_SIZE = 0;
    public static final int FULL_HEADER_SIZE = 12;
    public static final int HEADER_SIZE = 8;
    public static final int LONG_HEADER_SIZE = 16;
    public final int type;
    public static final int TYPE_ftyp = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ftyp");
    public static final int TYPE_avc1 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("avc1");
    public static final int TYPE_avc3 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("avc3");
    public static final int TYPE_hvc1 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hvc1");
    public static final int TYPE_hev1 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hev1");
    public static final int TYPE_s263 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("s263");
    public static final int TYPE_d263 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("d263");
    public static final int TYPE_mdat = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mdat");
    public static final int TYPE_mp4a = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mp4a");
    public static final int TYPE__mp3 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString(com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory.MP3_FILE_EXTENSION);
    public static final int TYPE_wave = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("wave");
    public static final int TYPE_lpcm = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("lpcm");
    public static final int TYPE_sowt = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sowt");
    public static final int TYPE_ac_3 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ac_renamed-3");
    public static final int TYPE_dac3 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dac3");
    public static final int TYPE_ec_3 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ec_renamed-3");
    public static final int TYPE_dec3 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dec3");
    public static final int TYPE_ac_4 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ac_renamed-4");
    public static final int TYPE_dac4 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dac4");
    public static final int TYPE_dtsc = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dtsc");
    public static final int TYPE_dtsh = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dtsh");
    public static final int TYPE_dtsl = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dtsl");
    public static final int TYPE_dtse = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dtse");
    public static final int TYPE_ddts = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ddts");
    public static final int TYPE_tfdt = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tfdt");
    public static final int TYPE_tfhd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tfhd");
    public static final int TYPE_trex = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("trex");
    public static final int TYPE_trun = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("trun");
    public static final int TYPE_sidx = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sidx");
    public static final int TYPE_moov = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("moov");
    public static final int TYPE_mvhd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mvhd");
    public static final int TYPE_trak = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("trak");
    public static final int TYPE_mdia = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mdia");
    public static final int TYPE_minf = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("minf");
    public static final int TYPE_stbl = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stbl");
    public static final int TYPE_avcC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("avcC");
    public static final int TYPE_hvcC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hvcC");
    public static final int TYPE_esds = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("esds");
    public static final int TYPE_moof = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("moof");
    public static final int TYPE_traf = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("traf");
    public static final int TYPE_mvex = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mvex");
    public static final int TYPE_mehd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mehd");
    public static final int TYPE_tkhd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tkhd");
    public static final int TYPE_edts = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("edts");
    public static final int TYPE_elst = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("elst");
    public static final int TYPE_mdhd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mdhd");
    public static final int TYPE_hdlr = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hdlr");
    public static final int TYPE_stsd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stsd");
    public static final int TYPE_pssh = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("pssh");
    public static final int TYPE_sinf = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sinf");
    public static final int TYPE_schm = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("schm");
    public static final int TYPE_schi = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("schi");
    public static final int TYPE_tenc = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tenc");
    public static final int TYPE_encv = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("encv");
    public static final int TYPE_enca = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("enca");
    public static final int TYPE_frma = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("frma");
    public static final int TYPE_saiz = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("saiz");
    public static final int TYPE_saio = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("saio");
    public static final int TYPE_sbgp = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sbgp");
    public static final int TYPE_sgpd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sgpd");
    public static final int TYPE_uuid = com.google.android.exoplayer2.util.Util.getIntegerCodeForString(com.heytap.accessory.constant.AFConstants.EXTRA_UUID);
    public static final int TYPE_senc = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("senc");
    public static final int TYPE_pasp = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("pasp");
    public static final int TYPE_TTML = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("TTML");
    public static final int TYPE_vmhd = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vmhd");
    public static final int TYPE_mp4v = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mp4v");
    public static final int TYPE_stts = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stts");
    public static final int TYPE_stss = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stss");
    public static final int TYPE_ctts = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ctts");
    public static final int TYPE_stsc = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stsc");
    public static final int TYPE_stsz = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stsz");
    public static final int TYPE_stz2 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stz2");
    public static final int TYPE_stco = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stco");
    public static final int TYPE_co64 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("co64");
    public static final int TYPE_tx3g = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tx3g");
    public static final int TYPE_wvtt = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("wvtt");
    public static final int TYPE_stpp = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("stpp");
    public static final int TYPE_c608 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("c608");
    public static final int TYPE_samr = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("samr");
    public static final int TYPE_sawb = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sawb");
    public static final int TYPE_udta = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("udta");
    public static final int TYPE_meta = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("meta");
    public static final int TYPE_keys = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("keys");
    public static final int TYPE_ilst = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ilst");
    public static final int TYPE_mean = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mean");
    public static final int TYPE_name = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("name");
    public static final int TYPE_data = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("data");
    public static final int TYPE_emsg = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("emsg");
    public static final int TYPE_st3d = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("st3d");
    public static final int TYPE_sv3d = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sv3d");
    public static final int TYPE_proj = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("proj");
    public static final int TYPE_vp08 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vp08");
    public static final int TYPE_vp09 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vp09");
    public static final int TYPE_vpcC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vpcC");
    public static final int TYPE_camm = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("camm");
    public static final int TYPE_alac = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("alac");
    public static final int TYPE_alaw = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("alaw");
    public static final int TYPE_ulaw = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ulaw");
    public static final int TYPE_Opus = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("Opus");
    public static final int TYPE_dOps = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dOps");
    public static final int TYPE_fLaC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("fLaC");
    public static final int TYPE_dfLa = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dfLa");
    public static final int TYPE_av01 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("av01");
    public static final int TYPE_av1C = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("av1C");

    public static int parseFullAtomFlags(int i_renamed) {
        return i_renamed & 16777215;
    }

    public static int parseFullAtomVersion(int i_renamed) {
        return (i_renamed >> 24) & 255;
    }

    public Atom(int i_renamed) {
        this.type = i_renamed;
    }

    public java.lang.String toString() {
        return getAtomTypeString(this.type);
    }

    static final class LeafAtom extends com.google.android.exoplayer2.extractor.mp4.Atom {
        public final com.google.android.exoplayer2.util.ParsableByteArray data;

        public LeafAtom(int i_renamed, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            super(i_renamed);
            this.data = parsableByteArray;
        }
    }

    static final class ContainerAtom extends com.google.android.exoplayer2.extractor.mp4.Atom {
        public final java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom> containerChildren;
        public final long endPosition;
        public final java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom> leafChildren;

        public ContainerAtom(int i_renamed, long j_renamed) {
            super(i_renamed);
            this.endPosition = j_renamed;
            this.leafChildren = new java.util.ArrayList();
            this.containerChildren = new java.util.ArrayList();
        }

        public void add(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom) {
            this.leafChildren.add(leafAtom);
        }

        public void add(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) {
            this.containerChildren.add(containerAtom);
        }

        public com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom getLeafAtomOfType(int i_renamed) {
            int size = this.leafChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = this.leafChildren.get(i2);
                if (leafAtom.type == i_renamed) {
                    return leafAtom;
                }
            }
            return null;
        }

        public com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom getContainerAtomOfType(int i_renamed) {
            int size = this.containerChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom = this.containerChildren.get(i2);
                if (containerAtom.type == i_renamed) {
                    return containerAtom;
                }
            }
            return null;
        }

        public int getChildAtomOfTypeCount(int i_renamed) {
            int size = this.leafChildren.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (this.leafChildren.get(i3).type == i_renamed) {
                    i2++;
                }
            }
            int size2 = this.containerChildren.size();
            for (int i4 = 0; i4 < size2; i4++) {
                if (this.containerChildren.get(i4).type == i_renamed) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.Atom
        public java.lang.String toString() {
            return getAtomTypeString(this.type) + " leaves: " + java.util.Arrays.toString(this.leafChildren.toArray()) + " containers: " + java.util.Arrays.toString(this.containerChildren.toArray());
        }
    }

    public static java.lang.String getAtomTypeString(int i_renamed) {
        return "" + ((char) ((i_renamed >> 24) & 255)) + ((char) ((i_renamed >> 16) & 255)) + ((char) ((i_renamed >> 8) & 255)) + ((char) (i_renamed & 255));
    }
}
