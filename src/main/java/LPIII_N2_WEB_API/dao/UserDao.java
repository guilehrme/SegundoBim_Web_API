package LPIII_N2_WEB_API.dao;

import LPIII_N2_WEB_API.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, String name,String nomePiloto1, String nomePiloto2,String nomePiloto3);
    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user.getName(), user.getPilotoFav1(), user.getPilotoFav2(), user.getPilotoFav3());
    }

    int insertUser(UUID id, User user);

    List <User> getAllUser();

    int deleteUser(UUID id);

    int deleteUser();
}
