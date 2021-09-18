package com.melon.sx.study.mapper;

import com.melon.sx.study.domain.SensitiveWordDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SensitiveWordMapper {

    boolean insert(SensitiveWordDomain sensitiveWordDomain);

    SensitiveWordDomain findByWord(String word);
}
