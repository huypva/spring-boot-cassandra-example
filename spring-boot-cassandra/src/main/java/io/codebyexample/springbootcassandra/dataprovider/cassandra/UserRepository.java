package io.codebyexample.springbootcassandra.dataprovider.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huypva
 */
@Repository
public interface UserRepository extends CassandraRepository<UserEntity, Long> {

}
