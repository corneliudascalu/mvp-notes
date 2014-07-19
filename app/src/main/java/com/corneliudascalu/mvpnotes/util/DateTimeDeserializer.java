package com.corneliudascalu.mvpnotes.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.joda.time.DateTime;

import java.lang.reflect.Type;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class DateTimeDeserializer implements JsonDeserializer<DateTime> {

    @Override
    public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return new DateTime(json.getAsJsonPrimitive().getAsString());
    }
}
