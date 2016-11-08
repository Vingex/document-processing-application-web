/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Staffs.Person;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Алексей
 */

public class PersonConverter implements JsonSerializer<Person>{ //не используемы класс
    

    @Override
    public JsonElement serialize(Person pers, java.lang.reflect.Type type, JsonSerializationContext jsc) {
        JsonObject object = new JsonObject();        
        try {
            object.addProperty("Name", URLEncoder.encode( pers.getName(), "UTF-8"));
            object.addProperty("Surname", URLEncoder.encode( pers.getSurname(), "UTF-8")); 
            object.addProperty("Patronymic", URLEncoder.encode( pers.getPatronymic(), "UTF-8")); 
            } 
        catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();  
            }
        object.addProperty("Position", pers.getPosition()); 
        object.addProperty("identifier", pers.getidentifier()); 
        return object;
    }

    

    
}
