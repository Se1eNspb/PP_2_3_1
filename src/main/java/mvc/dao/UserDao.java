package mvc.dao;

import mvc.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User read(int id);
    void create(User user);
    void update(int id, User user);
    void delete(int id);
}
