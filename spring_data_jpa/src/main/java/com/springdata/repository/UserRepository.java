package com.springdata.repository;

import com.springdata.entity.Tb_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface UserRepository extends JpaRepository<Tb_user,Long> {

    Tb_user save(Tb_user tb_user);

    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
            @QueryHint(name = "org.hibernate.cacheRegion", value = "entityCache")
    })
    Tb_user findById(Long id);
}
