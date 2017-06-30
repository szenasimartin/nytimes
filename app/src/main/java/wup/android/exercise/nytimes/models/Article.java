
package wup.android.exercise.nytimes.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article implements Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("column")
    @Expose
    private String column;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("asset_id")
    @Expose
    private Long assetId;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("des_facet")
    @Expose
    private List<String> desFacet;
    @SerializedName("org_facet")
    @Expose
    private List<String> orgFacet;
    @SerializedName("per_facet")
    @Expose
    private List<String> perFacet = null;
    @SerializedName("geo_facet")
    @Expose
    private List<String> geoFacet;
    @SerializedName("media")
    @Expose
    private List<Media> media = null;
    public final static Parcelable.Creator<Article> CREATOR = new Creator<Article>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Article createFromParcel(Parcel in) {
            Article instance = new Article();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.adxKeywords = ((String) in.readValue((String.class.getClassLoader())));
            instance.column = ((String) in.readValue((String.class.getClassLoader())));
            instance.section = ((String) in.readValue((String.class.getClassLoader())));
            instance.byline = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance._abstract = ((String) in.readValue((String.class.getClassLoader())));
            instance.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.source = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((Long) in.readValue((Integer.class.getClassLoader())));
            instance.assetId = ((Long) in.readValue((Integer.class.getClassLoader())));
            instance.views = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.desFacet, (java.lang.String.class.getClassLoader()));
            in.readList(instance.orgFacet, (java.lang.String.class.getClassLoader()));
            in.readList(instance.perFacet, (java.lang.String.class.getClassLoader()));
            in.readList(instance.geoFacet, (java.lang.String.class.getClassLoader()));
            in.readList(instance.media, (Media.class.getClassLoader()));
            return instance;
        }

        public Article[] newArray(int size) {
            return (new Article[size]);
        }

    }
    ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public List<String> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    public List<String> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(List<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(adxKeywords);
        dest.writeValue(column);
        dest.writeValue(section);
        dest.writeValue(byline);
        dest.writeValue(type);
        dest.writeValue(title);
        dest.writeValue(_abstract);
        dest.writeValue(publishedDate);
        dest.writeValue(source);
        dest.writeValue(id);
        dest.writeValue(assetId);
        dest.writeValue(views);
        dest.writeValue(desFacet);
        dest.writeValue(orgFacet);
        dest.writeList(perFacet);
        dest.writeValue(geoFacet);
        dest.writeList(media);
    }

    public int describeContents() {
        return  0;
    }

}
