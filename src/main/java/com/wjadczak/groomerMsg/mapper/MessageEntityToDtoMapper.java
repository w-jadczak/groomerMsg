package com.wjadczak.groomerMsg.mapper;

import com.wjadczak.groomerMsg.dto.MessageDto;
import com.wjadczak.groomerMsg.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MessageEntityToDtoMapper {

        MessageEntityToDtoMapper messageEntityToDtoMapper = Mappers.getMapper(MessageEntityToDtoMapper.class);
        MessageDto mapMessageToDto(MessageEntity messageEntity);
        List<MessageDto> mapMessagesToDtos(List<MessageEntity> messageEntities);

}
