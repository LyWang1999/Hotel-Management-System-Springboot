package cn.zjut.hotel.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kuluo
 */
public class JavaDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext context) throws IOException, JsonProcessingException {
        if (!StringUtils.isEmpty(p.getValueAsString())) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return format.parse(p.getValueAsString());
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
