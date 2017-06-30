
package wup.android.exercise.nytimes.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private Integer approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    private List<MediaMetadata> mediaMetadata = null;
    public final static Parcelable.Creator<Media> CREATOR = new Creator<Media>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Media createFromParcel(Parcel in) {
            Media instance = new Media();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.subtype = ((String) in.readValue((String.class.getClassLoader())));
            instance.caption = ((String) in.readValue((String.class.getClassLoader())));
            instance.copyright = ((String) in.readValue((String.class.getClassLoader())));
            instance.approvedForSyndication = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.mediaMetadata, (MediaMetadata.class.getClassLoader()));
            return instance;
        }

        public Media[] newArray(int size) {
            return (new Media[size]);
        }

    }
    ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Integer approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<MediaMetadata> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadata> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(subtype);
        dest.writeValue(caption);
        dest.writeValue(copyright);
        dest.writeValue(approvedForSyndication);
        dest.writeList(mediaMetadata);
    }

    public int describeContents() {
        return  0;
    }

}
