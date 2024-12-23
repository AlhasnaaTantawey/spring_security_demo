package com.global.base;

import jakarta.persistence.MappedSuperclass;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@MappedSuperclass
@RequiredArgsConstructor
public class BaseService<T extends BaseEntity<ID>,ID extends Number> {

    private final BaseRepository<T,ID> baseRepository;

//        public T findById(ID id){
//         Optional<T> entity = baseRepository.findById(id);
////         if(entity.isPresent()){
////             return entity.get();
////         }
//
////         else {
////
////         }
//        }
}
