package cn.zjut.hotel.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.sql.Time;

/**
 * @author kuluo
 */
public class SqlTimeDeserializer extends JsonDeserializer<Time> {
    @Override
    public Time deserialize(JsonParser p, DeserializationContext context) throws IOException, JsonProcessingException {
        if (!StringUtils.isEmpty(p.getValueAsString())) {
            return Time.valueOf(p.getValueAsString());
        } else {
            return null;
        }
    }
}
