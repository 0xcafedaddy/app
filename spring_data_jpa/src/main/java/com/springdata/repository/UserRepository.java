package com.springdata.repository;

import com.springdata.entity.Tb_user;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface UserRepository extends JpaRepository<Tb_user,Long> {

    Tb_user save(Tb_user tb_user);

    Tb_user findById(Long id);
}
