package com.landkay.springboot.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 90818
 * @Title: CustomJsonDateDeserializer
 * @ProjectName myspringboot
 * @Description: TODO
 * @date 2019/11/2817:02H
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = jsonParser.getText();
        try {
            return sf.parse(date);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }
}
