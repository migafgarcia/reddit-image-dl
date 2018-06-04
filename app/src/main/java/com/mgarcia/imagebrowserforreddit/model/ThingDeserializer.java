package com.mgarcia.imagebrowserforreddit.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class ThingDeserializer implements JsonDeserializer<Thing> {


    private static final String TAG = ThingDeserializer.class.getName();

    @Override
    public Thing deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String kind = jsonObject.get("kind").getAsString();

        switch(kind) {
            case "Listing":
                return new Thing(null, null, kind, (Listing) context.deserialize(jsonObject.get("data"), Listing.class));
            case "t3":
                return new Thing(null, null, kind, (Link) context.deserialize(jsonObject.get("data"), Link.class));
            case "t5":
                return new Thing(null, null, kind, (Subreddit) context.deserialize(jsonObject.get("data"), Subreddit.class));
            default:
                return null;

        }
    }
}
