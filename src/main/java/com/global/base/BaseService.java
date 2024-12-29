package com.global.base;

import com.global.error.EntityNotFoundException;
import jakarta.persistence.MappedSuperclass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>,ID extends Number> {

    @Autowired
    private  BaseRepository<T,ID> baseRepository;

        public T findById(ID id){
         Optional<T> entity = baseRepository.findById(id);
         if(entity.isPresent()){
             return entity.get();
         }
         else {
           throw  new EntityNotFoundException("entity not found ");
         }
        }

      public List<T> findAll(){
            return baseRepository.findAll();
      }

      public T insert(T entity){
          if (entity.getId() != null) {
              throw new RuntimeException();
          }
            return baseRepository.save(entity);
      }

      @Transactional
      public List<T> insert(List<T> entities){
            return baseRepository.saveAll(entities);
      }


      public void deleteById(ID id){
            baseRepository.deleteById(id);
      }

    public T update(T entity){
        return baseRepository.save(entity);
    }

}

