package kz.yerbolov.restApiSeptember.services;


import kz.yerbolov.restApiSeptember.entities.Client;
import kz.yerbolov.restApiSeptember.repositories.ClientRepository;
import kz.yerbolov.restApiSeptember.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findAllByEmail(username);
        if(client == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return client;
    }
}
