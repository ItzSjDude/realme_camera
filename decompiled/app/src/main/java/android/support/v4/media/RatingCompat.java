package android.support.v4.media;

/* loaded from: classes.dex */
public final class RatingCompat implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.support.v4.media.RatingCompat> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.RatingCompat createFromParcel(android.os.Parcel parcel) {
            return new android.support.v4.media.RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.RatingCompat[] newArray(int i_renamed) {
            return new android.support.v4.media.RatingCompat[i_renamed];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final java.lang.String TAG = "Rating";
    private java.lang.Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int i_renamed, float f_renamed) {
        this.mRatingStyle = i_renamed;
        this.mRatingValue = f_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.mRatingStyle);
        sb.append(" rating=");
        float f_renamed = this.mRatingValue;
        sb.append(f_renamed < 0.0f ? "unrated" : java.lang.String.valueOf(f_renamed));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }

    public static android.support.v4.media.RatingCompat newUnratedRating(int i_renamed) {
        switch (i_renamed) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new android.support.v4.media.RatingCompat(i_renamed, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public static android.support.v4.media.RatingCompat newHeartRating(boolean z_renamed) {
        return new android.support.v4.media.RatingCompat(1, z_renamed ? 1.0f : 0.0f);
    }

    public static android.support.v4.media.RatingCompat newThumbRating(boolean z_renamed) {
        return new android.support.v4.media.RatingCompat(2, z_renamed ? 1.0f : 0.0f);
    }

    public static android.support.v4.media.RatingCompat newStarRating(int i_renamed, float f_renamed) {
        float f2;
        if (i_renamed == 3) {
            f2 = 3.0f;
        } else if (i_renamed == 4) {
            f2 = 4.0f;
        } else {
            if (i_renamed != 5) {
                android.util.Log.e_renamed(TAG, "Invalid rating style (" + i_renamed + ") for a_renamed star rating");
                return null;
            }
            f2 = 5.0f;
        }
        if (f_renamed < 0.0f || f_renamed > f2) {
            android.util.Log.e_renamed(TAG, "Trying to set out of_renamed range star-based rating");
            return null;
        }
        return new android.support.v4.media.RatingCompat(i_renamed, f_renamed);
    }

    public static android.support.v4.media.RatingCompat newPercentageRating(float f_renamed) {
        if (f_renamed < 0.0f || f_renamed > 100.0f) {
            android.util.Log.e_renamed(TAG, "Invalid percentage-based rating value");
            return null;
        }
        return new android.support.v4.media.RatingCompat(6, f_renamed);
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public boolean hasHeart() {
        return this.mRatingStyle == 1 && this.mRatingValue == 1.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public float getStarRating() {
        int i_renamed = this.mRatingStyle;
        return ((i_renamed == 3 || i_renamed == 4 || i_renamed == 5) && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    public float getPercentRating() {
        return (this.mRatingStyle == 6 && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    public static android.support.v4.media.RatingCompat fromRating(java.lang.Object obj) {
        android.support.v4.media.RatingCompat ratingCompatNewUnratedRating = null;
        if (obj != null && android.os.Build.VERSION.SDK_INT >= 19) {
            android.media.Rating rating = (android.media.Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompatNewUnratedRating = newHeartRating(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompatNewUnratedRating = newThumbRating(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompatNewUnratedRating = newStarRating(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompatNewUnratedRating = newPercentageRating(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompatNewUnratedRating = newUnratedRating(ratingStyle);
            }
            ratingCompatNewUnratedRating.mRatingObj = obj;
        }
        return ratingCompatNewUnratedRating;
    }

    public java.lang.Object getRating() {
        if (this.mRatingObj == null && android.os.Build.VERSION.SDK_INT >= 19) {
            if (isRated()) {
                int i_renamed = this.mRatingStyle;
                switch (i_renamed) {
                    case 1:
                        this.mRatingObj = android.media.Rating.newHeartRating(hasHeart());
                        break;
                    case 2:
                        this.mRatingObj = android.media.Rating.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.mRatingObj = android.media.Rating.newStarRating(i_renamed, getStarRating());
                        break;
                    case 6:
                        this.mRatingObj = android.media.Rating.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.mRatingObj = android.media.Rating.newUnratedRating(this.mRatingStyle);
            }
        }
        return this.mRatingObj;
    }
}
