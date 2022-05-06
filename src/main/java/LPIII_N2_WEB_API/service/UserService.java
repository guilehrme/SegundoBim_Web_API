package LPIII_N2_WEB_API.service;

import LPIII_N2_WEB_API.dao.UserDao;
import LPIII_N2_WEB_API.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("fakeDao") UserDao userDao) {
        this.userDao = userDao;
    }
        public int addUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> listUser(){
        return userDao.getAllUser();
    }

}
