package org.acme.demo.profile;

import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findProfileById(Long id);
}
