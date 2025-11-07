package android.support.v4.media;

/* loaded from: classes.dex */
public final class MediaMetadataCompat implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.support.v4.media.MediaMetadataCompat> CREATOR;
    static final androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> METADATA_KEYS_TYPE = new androidx.collection.ArrayMap<>();
    public static final java.lang.String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final java.lang.String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final java.lang.String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final java.lang.String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final java.lang.String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final java.lang.String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final java.lang.String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final java.lang.String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final java.lang.String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final java.lang.String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final java.lang.String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final java.lang.String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final java.lang.String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final java.lang.String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final java.lang.String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final java.lang.String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final java.lang.String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final java.lang.String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final java.lang.String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final java.lang.String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final java.lang.String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final java.lang.String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final java.lang.String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final java.lang.String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final java.lang.String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final java.lang.String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final java.lang.String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final java.lang.String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final java.lang.String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final java.lang.String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final java.lang.String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final java.lang.String[] PREFERRED_BITMAP_ORDER;
    private static final java.lang.String[] PREFERRED_DESCRIPTION_ORDER;
    private static final java.lang.String[] PREFERRED_URI_ORDER;
    private static final java.lang.String TAG = "MediaMetadata";
    final android.os.Bundle mBundle;
    private android.support.v4.media.MediaDescriptionCompat mDescription;
    private java.lang.Object mMetadataObj;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BitmapKey {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LongKey {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RatingKey {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TextKey {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        METADATA_KEYS_TYPE.put(METADATA_KEY_TITLE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ARTIST, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DURATION, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_AUTHOR, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_WRITER, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPOSER, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPILATION, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DATE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_YEAR, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_GENRE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_TRACK_NUMBER, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_NUM_TRACKS, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISC_NUMBER, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ARTIST, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART, 2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART_URI, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART, 2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART_URI, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_USER_RATING, 3);
        METADATA_KEYS_TYPE.put(METADATA_KEY_RATING, 3);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_TITLE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON, 2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_ID, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_URI, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ADVERTISEMENT, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new java.lang.String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new java.lang.String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new java.lang.String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.MediaMetadataCompat>() { // from class: android.support.v4.media.MediaMetadataCompat.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaMetadataCompat createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.MediaMetadataCompat(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaMetadataCompat[] newArray(int i_renamed) {
                return new android.support.v4.media.MediaMetadataCompat[i_renamed];
            }
        };
    }

    MediaMetadataCompat(android.os.Bundle bundle) {
        this.mBundle = new android.os.Bundle(bundle);
        android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(this.mBundle);
    }

    MediaMetadataCompat(android.os.Parcel parcel) {
        this.mBundle = parcel.readBundle(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
    }

    public boolean containsKey(java.lang.String str) {
        return this.mBundle.containsKey(str);
    }

    public java.lang.CharSequence getText(java.lang.String str) {
        return this.mBundle.getCharSequence(str);
    }

    public java.lang.String getString(java.lang.String str) {
        java.lang.CharSequence charSequence = this.mBundle.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public long getLong(java.lang.String str) {
        return this.mBundle.getLong(str, 0L);
    }

    public android.support.v4.media.RatingCompat getRating(java.lang.String str) {
        android.support.v4.media.RatingCompat ratingCompatFromRating;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                ratingCompatFromRating = android.support.v4.media.RatingCompat.fromRating(this.mBundle.getParcelable(str));
            } else {
                ratingCompatFromRating = (android.support.v4.media.RatingCompat) this.mBundle.getParcelable(str);
            }
            return ratingCompatFromRating;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.w_renamed(TAG, "Failed to retrieve a_renamed key as_renamed Rating.", e_renamed);
            return null;
        }
    }

    public android.graphics.Bitmap getBitmap(java.lang.String str) {
        try {
            return (android.graphics.Bitmap) this.mBundle.getParcelable(str);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.w_renamed(TAG, "Failed to retrieve a_renamed key as_renamed Bitmap.", e_renamed);
            return null;
        }
    }

    public android.support.v4.media.MediaDescriptionCompat getDescription() {
        android.graphics.Bitmap bitmap;
        android.net.Uri uri;
        android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        java.lang.String string = getString(METADATA_KEY_MEDIA_ID);
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[3];
        java.lang.CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (!android.text.TextUtils.isEmpty(text)) {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        } else {
            int i_renamed = 0;
            int i2 = 0;
            while (i_renamed < charSequenceArr.length) {
                java.lang.String[] strArr = PREFERRED_DESCRIPTION_ORDER;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                java.lang.CharSequence text2 = getText(strArr[i2]);
                if (!android.text.TextUtils.isEmpty(text2)) {
                    charSequenceArr[i_renamed] = text2;
                    i_renamed++;
                }
                i2 = i3;
            }
        }
        int i4 = 0;
        while (true) {
            java.lang.String[] strArr2 = PREFERRED_BITMAP_ORDER;
            if (i4 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = getBitmap(strArr2[i4]);
            if (bitmap != null) {
                break;
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            java.lang.String[] strArr3 = PREFERRED_URI_ORDER;
            if (i5 >= strArr3.length) {
                uri = null;
                break;
            }
            java.lang.String string2 = getString(strArr3[i5]);
            if (!android.text.TextUtils.isEmpty(string2)) {
                uri = android.net.Uri.parse(string2);
                break;
            }
            i5++;
        }
        java.lang.String string3 = getString(METADATA_KEY_MEDIA_URI);
        android.net.Uri uri2 = android.text.TextUtils.isEmpty(string3) ? null : android.net.Uri.parse(string3);
        android.support.v4.media.MediaDescriptionCompat.Builder builder = new android.support.v4.media.MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri);
        builder.setMediaUri(uri2);
        android.os.Bundle bundle = new android.os.Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            bundle.putLong(android.support.v4.media.MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            bundle.putLong(android.support.v4.media.MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        this.mDescription = builder.build();
        return this.mDescription;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeBundle(this.mBundle);
    }

    public int size() {
        return this.mBundle.size();
    }

    public java.util.Set<java.lang.String> keySet() {
        return this.mBundle.keySet();
    }

    public android.os.Bundle getBundle() {
        return new android.os.Bundle(this.mBundle);
    }

    public static android.support.v4.media.MediaMetadataCompat fromMediaMetadata(java.lang.Object obj) {
        if (obj == null || android.os.Build.VERSION.SDK_INT < 21) {
            return null;
        }
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.support.v4.media.MediaMetadataCompatApi21.writeToParcel(obj, parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        android.support.v4.media.MediaMetadataCompat mediaMetadataCompatCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        mediaMetadataCompatCreateFromParcel.mMetadataObj = obj;
        return mediaMetadataCompatCreateFromParcel;
    }

    public java.lang.Object getMediaMetadata() {
        if (this.mMetadataObj == null && android.os.Build.VERSION.SDK_INT >= 21) {
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            this.mMetadataObj = android.support.v4.media.MediaMetadataCompatApi21.createFromParcel(parcelObtain);
            parcelObtain.recycle();
        }
        return this.mMetadataObj;
    }

    public static final class Builder {
        private final android.os.Bundle mBundle;

        public Builder() {
            this.mBundle = new android.os.Bundle();
        }

        public Builder(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            this.mBundle = new android.os.Bundle(mediaMetadataCompat.mBundle);
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(this.mBundle);
        }

        public Builder(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat, int i_renamed) {
            this(mediaMetadataCompat);
            for (java.lang.String str : this.mBundle.keySet()) {
                java.lang.Object obj = this.mBundle.get(str);
                if (obj instanceof android.graphics.Bitmap) {
                    android.graphics.Bitmap bitmap = (android.graphics.Bitmap) obj;
                    if (bitmap.getHeight() > i_renamed || bitmap.getWidth() > i_renamed) {
                        putBitmap(str, scaleBitmap(bitmap, i_renamed));
                    }
                }
            }
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putText(java.lang.String str, java.lang.CharSequence charSequence) {
            if (android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.get(str).intValue() != 1) {
                throw new java.lang.IllegalArgumentException("The " + str + " key cannot be_renamed used to put a_renamed CharSequence");
            }
            this.mBundle.putCharSequence(str, charSequence);
            return this;
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putString(java.lang.String str, java.lang.String str2) {
            if (android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.get(str).intValue() != 1) {
                throw new java.lang.IllegalArgumentException("The " + str + " key cannot be_renamed used to put a_renamed String");
            }
            this.mBundle.putCharSequence(str, str2);
            return this;
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putLong(java.lang.String str, long j_renamed) {
            if (android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.get(str).intValue() != 0) {
                throw new java.lang.IllegalArgumentException("The " + str + " key cannot be_renamed used to put a_renamed long");
            }
            this.mBundle.putLong(str, j_renamed);
            return this;
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putRating(java.lang.String str, android.support.v4.media.RatingCompat ratingCompat) {
            if (android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.get(str).intValue() != 3) {
                throw new java.lang.IllegalArgumentException("The " + str + " key cannot be_renamed used to put a_renamed Rating");
            }
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                this.mBundle.putParcelable(str, (android.os.Parcelable) ratingCompat.getRating());
            } else {
                this.mBundle.putParcelable(str, ratingCompat);
            }
            return this;
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putBitmap(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE.get(str).intValue() != 2) {
                throw new java.lang.IllegalArgumentException("The " + str + " key cannot be_renamed used to put a_renamed Bitmap");
            }
            this.mBundle.putParcelable(str, bitmap);
            return this;
        }

        public android.support.v4.media.MediaMetadataCompat build() {
            return new android.support.v4.media.MediaMetadataCompat(this.mBundle);
        }

        private android.graphics.Bitmap scaleBitmap(android.graphics.Bitmap bitmap, int i_renamed) {
            float f_renamed = i_renamed;
            float fMin = java.lang.Math.min(f_renamed / bitmap.getWidth(), f_renamed / bitmap.getHeight());
            return android.graphics.Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), true);
        }
    }
}
