package org.smaszno.payu.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.smaszno.payu.serializers.ProductListingDateConsts.DATE_MASK;

/**
 * Created by smaszno on 04/06/2017.
 */
public class ProductListingDateSerializer extends JsonSerializer<Date>{

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if (date == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeString(new SimpleDateFormat(DATE_MASK).format(date.getTime()));
        }
    }
}
