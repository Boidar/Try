package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> listUser() {
        String hql = "from User";
        return entityManager.createQuery(hql, User.class).getResultList();
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User saveUser(User user) {
       return entityManager.merge(user);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = entityManager.find(User.class, user.getId());
        if (existingUser == null) {
            return null;
        }
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAge(user.getAge());
        return entityManager.merge(existingUser);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

}
