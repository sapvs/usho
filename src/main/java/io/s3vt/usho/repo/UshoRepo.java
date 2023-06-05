package io.s3vt.usho.repo;

import io.s3vt.usho.model.UshoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UshoRepo extends JpaRepository<UshoEntity, String> {
}
