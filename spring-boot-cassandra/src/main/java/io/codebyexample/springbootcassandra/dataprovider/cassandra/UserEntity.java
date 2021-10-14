package io.codebyexample.springbootcassandra.dataprovider.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author huypva
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("User")
public class UserEntity {

  @PrimaryKey("user_id")
  private long userId;

  @Column("user_name")
  private String userName;

}
