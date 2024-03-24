package com.tdtu.lihitiShop.config;

import jakarta.persistence.Entity;

public interface convertDataTypeInterface <E,D>
{
     D mapToDto(E entity) ;

     E mapToEntity(D dto);

}
