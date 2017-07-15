package com.springdata.entity;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "entityCache")
@Cacheable
public class Tb_user {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String address;
  private Date gmt_created;
  private Date gmt_modified;

}
