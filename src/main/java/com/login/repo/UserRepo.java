
package com.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.UserDetail;

@Repository
public interface UserRepo extends JpaRepository<UserDetail, Integer> {

	UserDetail findByEmailIgnoreCase(String email);


}
