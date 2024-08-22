package dev.app.paymentPortal.repositories;

import dev.app.paymentPortal.domain.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    @Query("SELECT a FROM User a where a.address LIKE %:location%")
    Iterable<User> locationInLocality(@Param("location") String location);
}
