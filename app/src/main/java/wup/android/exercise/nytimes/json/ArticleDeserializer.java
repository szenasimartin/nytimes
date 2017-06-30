package wup.android.exercise.nytimes.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import wup.android.exercise.nytimes.models.Article;
import wup.android.exercise.nytimes.models.Media;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public class ArticleDeserializer implements JsonDeserializer<Article> {
    @Override
    public Article deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Article article = new Article();
        JsonObject jObj = json.getAsJsonObject();

        JsonElement jElement = jObj.get("media");
        List<Media> medias = Collections.emptyList();
        if (jElement.isJsonArray()) {
            medias = context.deserialize(jElement.getAsJsonArray(), new TypeToken<List<Media>>() {
            }.getType());
        }
        article.setMedia(medias);

        jElement = jObj.get("des_facet");
        List<String> desFacet = Collections.emptyList();
        if (jElement.isJsonArray()) {
            desFacet = context.deserialize(jElement.getAsJsonArray(), new TypeToken<List<String>>() {
            }.getType());
        }
        article.setDesFacet(desFacet);

        jElement = jObj.get("org_facet");
        List<String> orgFacet = Collections.emptyList();
        if (jElement.isJsonArray()) {
            orgFacet = context.deserialize(jElement.getAsJsonArray(), new TypeToken<List<String>>() {
            }.getType());
        }
        article.setOrgFacet(orgFacet);

        jElement = jObj.get("per_facet");
        List<String> perFacet = Collections.emptyList();
        if (jElement.isJsonArray()) {
            perFacet = context.deserialize(jElement.getAsJsonArray(), new TypeToken<List<String>>() {
            }.getType());
        }
        article.setPerFacet(perFacet);

        jElement = jObj.get("geo_facet");
        List<String> geoFacet = Collections.emptyList();
        if (jElement.isJsonArray()) {
            geoFacet = context.deserialize(jElement.getAsJsonArray(), new TypeToken<List<String>>() {
            }.getType());
        }
        article.setGeoFacet(geoFacet);

        article.setUrl(jObj.getAsJsonPrimitive("url").getAsString());
        article.setAdxKeywords(jObj.getAsJsonPrimitive("adx_keywords").getAsString());
        article.setColumn(jObj.getAsJsonPrimitive("column").getAsString());
        article.setSection(jObj.getAsJsonPrimitive("section").getAsString());
        article.setByline(jObj.getAsJsonPrimitive("byline").getAsString());
        article.setType(jObj.getAsJsonPrimitive("type").getAsString());
        article.setTitle(jObj.getAsJsonPrimitive("title").getAsString());
        article.setAbstract(jObj.getAsJsonPrimitive("abstract").getAsString());
        article.setPublishedDate(jObj.getAsJsonPrimitive("published_date").getAsString());
        article.setSource(jObj.getAsJsonPrimitive("source").getAsString());
        article.setId(jObj.getAsJsonPrimitive("id").getAsLong());
        article.setAssetId(jObj.getAsJsonPrimitive("asset_id").getAsLong());
        article.setViews(jObj.getAsJsonPrimitive("views").getAsInt());
        return article;
    }
}
