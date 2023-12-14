package com.users.updater.mappers;

public interface IMap<TDto, TEntity> {

    TEntity toEntity(TDto dto);
}
