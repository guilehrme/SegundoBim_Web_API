package LPIII_N2_WEB_API.dao;

import LPIII_N2_WEB_API.model.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.*;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();
    Connection connection = (Connection) ConnectionDB.conDB();
    PreparedStatement preparedStatement;

    CallableStatement callableStatement;
    @Override
    public int insertUser(UUID id, User user) {
        try {
            String insert = "INSERT INTO tb_student( id, nomeUser,PilotoFav1,PilotoFav2,PilotoFav3) VALUES (?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3,user.getPilotoFav1());
            preparedStatement.setString(4,user.getPilotoFav2());
            preparedStatement.setString(5,user.getPilotoFav3());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertUser(UUID id, String name, String nomePiloto1, String nomePiloto2, String nomePiloto3) {
        return 0;
    }

    @Override
    public int insertUser(User userModel) {
        return UserDao.super.insertUser(userModel);
    }

    @Override
    public List<User> getAllUser() {
        try {
            String select = "SELECT * FROM TrabEC7.user";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            ResultSet returnQueryUser = preparedStatement.executeQuery(select);
            while (returnQueryUser.next()) {
                UUID idUser = UUID.fromString(returnQueryUser.getString("idUser"));
                String nomeUser = returnQueryUser.getString("nomeUser");
                String pilotoFav1 = returnQueryUser.getString("PilotoFav1");
                String pilotoFav2 = returnQueryUser.getString("PilotoFav2");
                String pilotoFav3 = returnQueryUser.getString("PilotoFav3");
                User user = new User(idUser, nomeUser, pilotoFav1,pilotoFav2,pilotoFav3);
                DB.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return DB;
    }

    @Override
    public int deleteUser(UUID id) {
        try{
            String delete = "Delete * from TrabEC7.user where 'idUser' = '?'";
            preparedStatement = (PreparedStatement) connection.prepareStatement(delete);
            ResultSet returnQueryUser = preparedStatement.executeQuery(delete);
            callableStatement.setString(1, id.toString() );
            callableStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(){
        return 1;
    }
}
