package com.global.mapper;


import com.global.dto.RoleDto;
import com.global.entity.Roles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    @Autowired
    private  ModelMapper mapper;

    public Roles unmap(RoleDto dto){
      return   mapper.map(dto,Roles.class);
    }

    public RoleDto map(Roles entity){
        return   mapper.map(entity,RoleDto.class);
    }

    public List<Roles> unmapList(List<RoleDto> dtoList){
        return dtoList.stream()
                .map( dto-> mapper.map(dto,Roles.class))
                .collect(Collectors.toList());
    }

    public List<RoleDto> mapList(List<Roles> entityList){

        return  entityList.stream()
                .map(entity-> mapper.map(entity,RoleDto.class))
                .collect(Collectors.toList());
    }

}
