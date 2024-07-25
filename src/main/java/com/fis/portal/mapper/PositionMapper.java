package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Position;

@Mapper
public interface PositionMapper {
	List<Position> search(Position payload);
    int count(Position payload);
    int update(Position position);
    int create(Position position);
    Position findByCode(String code);
    List<Position> getAllpositions();

}
