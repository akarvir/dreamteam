package com.football.footballplayerdatabase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    User findByUsername(String username);
    boolean existsByUsername(String username);
    
}
