package cn.zjut.hotel.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JacksonUtilsTest {

    @Test
    public void testAdd() {
        List<String> list = new ArrayList<>(5);
        list.add("hahaha");
        list.add("lalalala");
        String jsonStr = JacksonUtil.add("{}", "items", list);
        jsonStr = JacksonUtil.add(jsonStr, "total", list.size());
        System.out.println(JacksonUtil.format(jsonStr));
    }
}
