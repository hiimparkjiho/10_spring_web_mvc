package com.ohgiraffers.viewtest.comp.model;

import com.ohgiraffers.viewtest.comp.dto.CompDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompDao {
    List<CompDTO> selectAllComp();
}
