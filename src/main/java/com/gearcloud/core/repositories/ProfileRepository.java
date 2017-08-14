package com.gearcloud.core.repositories;

import com.gearcloud.core.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
