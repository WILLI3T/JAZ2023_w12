package com.users.updater;

public interface IMap<TDto, TEntity> {

    TEntity map(TDto dto);
}
