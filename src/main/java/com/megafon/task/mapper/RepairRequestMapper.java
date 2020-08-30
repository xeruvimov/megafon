package com.megafon.task.mapper;

import com.megafon.task.domain.RepairRequest;
import com.megafon.task.dto.RepairRequestDTORequest;
import com.megafon.task.dto.RepairRequestDTOResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairRequestMapper extends AbstractEntityMapper<RepairRequestDTOResponse, RepairRequest> {
}
