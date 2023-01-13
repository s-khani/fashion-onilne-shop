package com.example.FashionOnlineShop.application;

public interface Converter<E,D> {

    D fromEntityToDto(E entity);
    E fromDtoToEntity(D dto);
}
