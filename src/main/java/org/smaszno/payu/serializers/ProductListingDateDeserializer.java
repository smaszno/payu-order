package org.smaszno.payu.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.smaszno.payu.serializers.ProductListingDateConsts.DATE_MASK;

/**
 * Created by smaszno on 04/06/2017.
 */
public class ProductListingDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String dateAsString = jsonParser.getText();
        try {
            Date date = new SimpleDateFormat(DATE_MASK).parse(dateAsString);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
