package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
final class MetadataUtil {
    private static final java.lang.String LANGUAGE_UNDEFINED = "und";
    private static final java.lang.String MDTA_KEY_ANDROID_CAPTURE_FPS = "com.android.capture.fps";
    private static final int MDTA_TYPE_INDICATOR_FLOAT = 23;
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final java.lang.String TAG = "MetadataUtil";
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int SHORT_TYPE_NAME_1 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("nam");
    private static final int SHORT_TYPE_NAME_2 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("trk");
    private static final int SHORT_TYPE_COMMENT = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("cmt");
    private static final int SHORT_TYPE_YEAR = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("day");
    private static final int SHORT_TYPE_ARTIST = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ART");
    private static final int SHORT_TYPE_ENCODER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("too");
    private static final int SHORT_TYPE_ALBUM = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("alb");
    private static final int SHORT_TYPE_COMPOSER_1 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("com");
    private static final int SHORT_TYPE_COMPOSER_2 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("wrt");
    private static final int SHORT_TYPE_LYRICS = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("lyr");
    private static final int SHORT_TYPE_GENRE = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("gen");
    private static final int TYPE_COVER_ART = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("covr");
    private static final int TYPE_GENRE = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("gnre");
    private static final int TYPE_GROUPING = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("grp");
    private static final int TYPE_DISK_NUMBER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("disk");
    private static final int TYPE_TRACK_NUMBER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("trkn");
    private static final int TYPE_TEMPO = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tmpo");
    private static final int TYPE_COMPILATION = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("cpil");
    private static final int TYPE_ALBUM_ARTIST = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("aART");
    private static final int TYPE_SORT_TRACK_NAME = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sonm");
    private static final int TYPE_SORT_ALBUM = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("soal");
    private static final int TYPE_SORT_ARTIST = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("soar");
    private static final int TYPE_SORT_ALBUM_ARTIST = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("soaa");
    private static final int TYPE_SORT_COMPOSER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("soco");
    private static final int TYPE_RATING = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("rtng");
    private static final int TYPE_GAPLESS_ALBUM = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("pgap");
    private static final int TYPE_TV_SORT_SHOW = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sosn");
    private static final int TYPE_TV_SHOW = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tvsh");
    private static final int TYPE_INTERNAL = com.google.android.exoplayer2.util.Util.getIntegerCodeForString(com.google.android.exoplayer2.metadata.id3.InternalFrame.ID_renamed);
    private static final java.lang.String[] STANDARD_GENRES = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R_renamed&B_renamed", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A_renamed capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private MetadataUtil() {
    }

    public static com.google.android.exoplayer2.Format getFormatWithMetadata(int i_renamed, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.metadata.Metadata metadata, com.google.android.exoplayer2.metadata.Metadata metadata2, com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder) {
        if (i_renamed == 1) {
            if (gaplessInfoHolder.hasGaplessInfo()) {
                format = format.copyWithGaplessInfo(gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding);
            }
            return metadata != null ? format.copyWithMetadata(metadata) : format;
        }
        if (i_renamed != 2 || metadata2 == null) {
            return format;
        }
        com.google.android.exoplayer2.Format formatCopyWithMetadata = format;
        for (int i2 = 0; i2 < metadata2.length(); i2++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata2.get(i2);
            if (entry instanceof com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry) {
                com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry mdtaMetadataEntry = (com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry) entry;
                if (MDTA_KEY_ANDROID_CAPTURE_FPS.equals(mdtaMetadataEntry.key) && mdtaMetadataEntry.typeIndicator == 23) {
                    try {
                        formatCopyWithMetadata = formatCopyWithMetadata.copyWithFrameRate(java.nio.ByteBuffer.wrap(mdtaMetadataEntry.value).asFloatBuffer().get()).copyWithMetadata(new com.google.android.exoplayer2.metadata.Metadata(mdtaMetadataEntry));
                    } catch (java.lang.NumberFormatException unused) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring invalid framerate");
                    }
                }
            }
        }
        return formatCopyWithMetadata;
    }

    public static com.google.android.exoplayer2.metadata.Metadata.Entry parseIlstElement(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int i_renamed = parsableByteArray.readInt();
        int i2 = (i_renamed >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 253) {
                int i3 = 16777215 & i_renamed;
                if (i3 == SHORT_TYPE_COMMENT) {
                    return parseCommentAttribute(i_renamed, parsableByteArray);
                }
                if (i3 != SHORT_TYPE_NAME_1 && i3 != SHORT_TYPE_NAME_2) {
                    if (i3 != SHORT_TYPE_COMPOSER_1 && i3 != SHORT_TYPE_COMPOSER_2) {
                        if (i3 == SHORT_TYPE_YEAR) {
                            return parseTextAttribute(i_renamed, "TDRC", parsableByteArray);
                        }
                        if (i3 == SHORT_TYPE_ARTIST) {
                            return parseTextAttribute(i_renamed, "TPE1", parsableByteArray);
                        }
                        if (i3 == SHORT_TYPE_ENCODER) {
                            return parseTextAttribute(i_renamed, "TSSE", parsableByteArray);
                        }
                        if (i3 == SHORT_TYPE_ALBUM) {
                            return parseTextAttribute(i_renamed, "TALB", parsableByteArray);
                        }
                        if (i3 == SHORT_TYPE_LYRICS) {
                            return parseTextAttribute(i_renamed, "USLT", parsableByteArray);
                        }
                        if (i3 == SHORT_TYPE_GENRE) {
                            return parseTextAttribute(i_renamed, "TCON", parsableByteArray);
                        }
                        if (i3 == TYPE_GROUPING) {
                            return parseTextAttribute(i_renamed, "TIT1", parsableByteArray);
                        }
                    }
                    return parseTextAttribute(i_renamed, "TCOM", parsableByteArray);
                }
                return parseTextAttribute(i_renamed, "TIT2", parsableByteArray);
            }
            if (i_renamed == TYPE_GENRE) {
                return parseStandardGenreAttribute(parsableByteArray);
            }
            if (i_renamed == TYPE_DISK_NUMBER) {
                return parseIndexAndCountAttribute(i_renamed, "TPOS", parsableByteArray);
            }
            if (i_renamed == TYPE_TRACK_NUMBER) {
                return parseIndexAndCountAttribute(i_renamed, "TRCK", parsableByteArray);
            }
            if (i_renamed == TYPE_TEMPO) {
                return parseUint8Attribute(i_renamed, "TBPM", parsableByteArray, true, false);
            }
            if (i_renamed == TYPE_COMPILATION) {
                return parseUint8Attribute(i_renamed, "TCMP", parsableByteArray, true, true);
            }
            if (i_renamed == TYPE_COVER_ART) {
                return parseCoverArt(parsableByteArray);
            }
            if (i_renamed == TYPE_ALBUM_ARTIST) {
                return parseTextAttribute(i_renamed, "TPE2", parsableByteArray);
            }
            if (i_renamed == TYPE_SORT_TRACK_NAME) {
                return parseTextAttribute(i_renamed, "TSOT", parsableByteArray);
            }
            if (i_renamed == TYPE_SORT_ALBUM) {
                return parseTextAttribute(i_renamed, "TSO2", parsableByteArray);
            }
            if (i_renamed == TYPE_SORT_ARTIST) {
                return parseTextAttribute(i_renamed, "TSOA", parsableByteArray);
            }
            if (i_renamed == TYPE_SORT_ALBUM_ARTIST) {
                return parseTextAttribute(i_renamed, "TSOP", parsableByteArray);
            }
            if (i_renamed == TYPE_SORT_COMPOSER) {
                return parseTextAttribute(i_renamed, "TSOC", parsableByteArray);
            }
            if (i_renamed == TYPE_RATING) {
                return parseUint8Attribute(i_renamed, "ITUNESADVISORY", parsableByteArray, false, false);
            }
            if (i_renamed == TYPE_GAPLESS_ALBUM) {
                return parseUint8Attribute(i_renamed, "ITUNESGAPLESS", parsableByteArray, false, true);
            }
            if (i_renamed == TYPE_TV_SORT_SHOW) {
                return parseTextAttribute(i_renamed, "TVSHOWSORT", parsableByteArray);
            }
            if (i_renamed == TYPE_TV_SHOW) {
                return parseTextAttribute(i_renamed, "TVSHOW", parsableByteArray);
            }
            if (i_renamed == TYPE_INTERNAL) {
                return parseInternalAttribute(parsableByteArray, position);
            }
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Skipped unknown metadata entry: " + com.google.android.exoplayer2.extractor.mp4.Atom.getAtomTypeString(i_renamed));
            return null;
        } finally {
            parsableByteArray.setPosition(position);
        }
    }

    public static com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, java.lang.String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i_renamed) {
                return null;
            }
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data) {
                int i3 = parsableByteArray.readInt();
                int i4 = parsableByteArray.readInt();
                int i5 = i2 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                return new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry(str, bArr, i4, i3);
            }
            parsableByteArray.setPosition(position + i2);
        }
    }

    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame parseTextAttribute(int i_renamed, java.lang.String str, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data) {
            parsableByteArray.skipBytes(8);
            return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, parsableByteArray.readNullTerminatedString(i2 - 16));
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to parse text attribute: " + com.google.android.exoplayer2.extractor.mp4.Atom.getAtomTypeString(i_renamed));
        return null;
    }

    private static com.google.android.exoplayer2.metadata.id3.CommentFrame parseCommentAttribute(int i_renamed, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data) {
            parsableByteArray.skipBytes(8);
            java.lang.String nullTerminatedString = parsableByteArray.readNullTerminatedString(i2 - 16);
            return new com.google.android.exoplayer2.metadata.id3.CommentFrame("und", nullTerminatedString, nullTerminatedString);
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to parse comment attribute: " + com.google.android.exoplayer2.extractor.mp4.Atom.getAtomTypeString(i_renamed));
        return null;
    }

    private static com.google.android.exoplayer2.metadata.id3.Id3Frame parseUint8Attribute(int i_renamed, java.lang.String str, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z_renamed, boolean z2) {
        int uint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (z2) {
            uint8AttributeValue = java.lang.Math.min(1, uint8AttributeValue);
        }
        if (uint8AttributeValue >= 0) {
            if (z_renamed) {
                return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, java.lang.Integer.toString(uint8AttributeValue));
            }
            return new com.google.android.exoplayer2.metadata.id3.CommentFrame("und", str, java.lang.Integer.toString(uint8AttributeValue));
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to parse uint8 attribute: " + com.google.android.exoplayer2.extractor.mp4.Atom.getAtomTypeString(i_renamed));
        return null;
    }

    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame parseIndexAndCountAttribute(int i_renamed, java.lang.String str, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data && i2 >= 22) {
            parsableByteArray.skipBytes(10);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (unsignedShort > 0) {
                java.lang.String str2 = "" + unsignedShort;
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    str2 = str2 + "/" + unsignedShort2;
                }
                return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, str2);
            }
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to parse index/count attribute: " + com.google.android.exoplayer2.extractor.mp4.Atom.getAtomTypeString(i_renamed));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray r3) {
        /*
            int r3 = parseUint8AttributeValue(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.google.android.exoplayer2.extractor.mp4.MetadataUtil.STANDARD_GENRES
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.Log.w_renamed(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static com.google.android.exoplayer2.metadata.id3.ApicFrame parseCoverArt(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i_renamed = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data) {
            int fullAtomFlags = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(parsableByteArray.readInt());
            java.lang.String str = fullAtomFlags == 13 ? "image/jpeg" : fullAtomFlags == 14 ? "image/png" : null;
            if (str == null) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unrecognized cover art flags: " + fullAtomFlags);
                return null;
            }
            parsableByteArray.skipBytes(4);
            byte[] bArr = new byte[i_renamed - 16];
            parsableByteArray.readBytes(bArr, 0, bArr.length);
            return new com.google.android.exoplayer2.metadata.id3.ApicFrame(str, null, 3, bArr);
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to parse cover art attribute");
        return null;
    }

    private static com.google.android.exoplayer2.metadata.id3.Id3Frame parseInternalAttribute(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        int i2 = -1;
        int i3 = -1;
        java.lang.String nullTerminatedString = null;
        java.lang.String nullTerminatedString2 = null;
        while (parsableByteArray.getPosition() < i_renamed) {
            int position = parsableByteArray.getPosition();
            int i4 = parsableByteArray.readInt();
            int i5 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (i5 == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mean) {
                nullTerminatedString = parsableByteArray.readNullTerminatedString(i4 - 12);
            } else if (i5 == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_name) {
                nullTerminatedString2 = parsableByteArray.readNullTerminatedString(i4 - 12);
            } else {
                if (i5 == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data) {
                    i2 = position;
                    i3 = i4;
                }
                parsableByteArray.skipBytes(i4 - 12);
            }
        }
        if (nullTerminatedString == null || nullTerminatedString2 == null || i2 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i2);
        parsableByteArray.skipBytes(16);
        return new com.google.android.exoplayer2.metadata.id3.InternalFrame(nullTerminatedString, nullTerminatedString2, parsableByteArray.readNullTerminatedString(i3 - 16));
    }

    private static int parseUint8AttributeValue(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_data) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to parse uint8 attribute value");
        return -1;
    }
}
