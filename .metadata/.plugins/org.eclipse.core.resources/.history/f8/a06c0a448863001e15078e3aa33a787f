package harjoitustyo.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import harjoitustyo.harjoitustyo.domain.AppUser;
import harjoitustyo.harjoitustyo.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private final AppUserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(AppUserRepository urepository) {
		this.repository = urepository;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
			curruser.getPassword(),
			AuthorityUtils.createAuthorityList(curruser.getRole()));
	return user;
	}
}
