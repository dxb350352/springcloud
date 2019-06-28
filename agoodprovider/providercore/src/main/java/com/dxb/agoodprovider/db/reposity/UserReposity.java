package com.dxb.agoodprovider.db.reposity;

import com.dxb.agoodprovider.db.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 18/1/8.
 */
public interface UserReposity extends JpaRepository<User, Long> {

}
