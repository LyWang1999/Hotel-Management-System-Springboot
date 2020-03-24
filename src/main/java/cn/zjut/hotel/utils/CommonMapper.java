package cn.zjut.hotel.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author kuluo
 * @description 通用mapper工具接口
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
