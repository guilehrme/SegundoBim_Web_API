package LPIII_N2_WEB_API.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String STRING_CONEXAO = "jdbc:mysql://localhost:3306/movehealth?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    private String tabela;

    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
            return null;
        }
    }

    protected void setTabela(String value){
        tabela = value;
    }
}
