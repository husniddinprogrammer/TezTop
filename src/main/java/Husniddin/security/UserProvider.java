package Husniddin.security;

import Husniddin.entity.User;
import Husniddin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserProvider implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> ou = userRepository.findByUsername(username);
        if(ou.isPresent()) {
            User u = ou.get();
            UserMaxsus um =  new UserMaxsus(u);
            um.setLavozimlar(u.getLavozimlar());
            return um;
        }
        throw new UsernameNotFoundException("Topilmadi");

    }


}
