package com.migafgarcia.redditimagedownloader.model;


import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class ThingDeserializer implements JsonDeserializer<Thing> {


    @Override
    public Thing deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String kind = jsonObject.get("kind").getAsString();

        Log.d("DESERIALIZER", kind);

        switch(kind) {
            case "Listing":
                Thing thing = new Thing(null, null, kind, (Listing) context.deserialize(jsonObject.get("data"), Listing.class));
                return thing;
            case "t3":
                return new Thing(null, null, kind, (Link) context.deserialize(jsonObject.get("data"), Link.class));
            case "t5":
                return new Thing(null, null, kind, (Subreddit) context.deserialize(jsonObject.get("data"), Subreddit.class));
            default:
                return null;

        }
    }
}
