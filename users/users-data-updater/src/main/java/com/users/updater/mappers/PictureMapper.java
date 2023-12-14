package com.users.updater.mappers;

import com.users.randomuser.contract.PictureDto;
import com.users.usersdata.model.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper implements IMap<PictureDto, Picture>{
    @Override
    public Picture toEntity(PictureDto pictureDto) {
        var picture = new Picture();
        picture.setLarge(pictureDto.getLarge());
        picture.setMedium(pictureDto.getMedium());
        picture.setThumbnail(pictureDto.getThumbnail());
        return picture;
    }
}
