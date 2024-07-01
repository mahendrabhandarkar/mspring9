package com.ks.mspring9.auditing;
/**
 * @CreatedBy or @LastModifiedBy
 */
/*
import com.ks.mspring9.entity.Users;
import org.apache.maven.artifact.repository.Authentication;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<Users> {

    @Override
    public Optional<Users> getCurrentAuditor() {
       // return Optional.empty();
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAutentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(Users.class::cast);
    }
}
*/