package com.customerapp.customerappdemo.mappers;

import com.customerapp.customerappdemo.entity.PositionEntity;
import com.customerapp.customerappdemo.model.Position;
import org.mapstruct.Mapper;

@Mapper
public interface PositionMapper {

    Position positionEntityToPosition(PositionEntity positionEntity);
    PositionEntity positionToPositionEntity(Position position);
}
