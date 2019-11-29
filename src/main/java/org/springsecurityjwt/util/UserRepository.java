package org.springsecurityjwt.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: ykhatri
 * Date: 28-11-2019
 */
@Repository
public interface UserRepository extends JpaRepository<Users, String> {
}
