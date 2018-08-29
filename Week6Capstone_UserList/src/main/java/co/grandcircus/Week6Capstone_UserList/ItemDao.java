package co.grandcircus.Week6Capstone_UserList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {

	public List<Item> findAllByUser(User user);
}
