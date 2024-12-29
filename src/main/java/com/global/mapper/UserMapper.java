package com.global.mapper;

import com.global.dto.AppuserDto;
import com.global.dto.RoleDto;
import com.global.entity.AppUser;
import com.global.entity.Roles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public AppUser unmap(AppuserDto dto){
        return   mapper.map(dto,AppUser.class);
    }

    public AppuserDto map(AppUser entity){
        return   mapper.map(entity,AppuserDto.class);
    }

    public List<AppUser> unmapList(List<AppuserDto> dtoList){
        return dtoList.stream()
                .map( dto-> mapper.map(dto,AppUser.class))
                .collect(Collectors.toList());
    }

    public List<AppuserDto> mapList(List<AppUser> entityList){

        return  entityList.stream()
                .map(entity-> mapper.map(entity,AppuserDto.class))
                .collect(Collectors.toList());
    }

}
