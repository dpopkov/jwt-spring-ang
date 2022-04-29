package learn.springang.umsportal.services.impl;

import learn.springang.umsportal.domain.User;
import learn.springang.umsportal.domain.UserPrincipal;
import learn.springang.umsportal.repositories.UserRepository;
import learn.springang.umsportal.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isEmpty()) {
            log.error("User not found by username {}", username);
            throw new UsernameNotFoundException("User not found by username");
        }
        User user = byUsername.get();
        user.setLastLoginDateDisplay(user.getLastLoginDate());
        user.setLastLoginDate(new Date());
        userRepository.save(user);
        UserDetails userDetails = new UserPrincipal(user);
        log.info("User found by username {}", userDetails.getUsername());
        return userDetails;
    }
}
