package com.vtb.zolotarev.spring.boot.repositories;

import com.vtb.zolotarev.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
