package com.unoffstars.dip.datacollection.repository;

import com.unoffstars.dip.datacollection.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
