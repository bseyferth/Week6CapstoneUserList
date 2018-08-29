package co.grandcircus.Week6Capstone_UserList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
