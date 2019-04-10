package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Role;
import com.turchanovskyi.mediasphere.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Set<Role> findByName(RoleName roleName);
}
