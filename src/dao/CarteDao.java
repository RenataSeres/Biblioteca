package dao;

import model.Autor;
import model.Carti;
import model.Genuri;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDao {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "renata";


    public Carti findById(int id) {
        Carti carti = new Carti();

        String query = "select  c.id,c.denumire,c.editura,c.an_aparitie, a.id, a.nume,a.prenume,g.id,g.denumire " +
                "from carti c\n" +
                "inner join autor a on c.id_autor = a.id\n" +
                "inner join genuri g on c.id_gen= g.id\n" +
                "where c.id = ?";


        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                carti.setId(resultSet.getInt("c.id"));
                carti.setDenumire(resultSet.getString("c.denumire"));
                carti.setAn_aparitie(resultSet.getDate("c.an_aparitie"));
                carti.setEditura(resultSet.getString("c.editura"));

                Autor autor = new Autor();
                autor.setId(resultSet.getInt("a.id"));
                autor.setNume(resultSet.getString("a.nume"));
                autor.setPrenume(resultSet.getString("a.prenume"));
                carti.setAutor(autor);

                Genuri genuri = new Genuri();
                genuri.setId(resultSet.getInt("g.id"));
                genuri.setDenumire(resultSet.getString("g.denumire"));
                carti.setGenuri(genuri);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carti;
    }


    public List<Carti> findAll() {
        List<Carti> cartis = new ArrayList<>();
        String query = "select  c.id,c.denumire,c.editura,c.an_aparitie, a.id, a.nume,a.prenume,g.id,g.denumire " +
                "from carti c\n" +
                "inner join autor a on c.id_autor = a.id\n" +
                "inner join genuri g on c.id_gen= g.id\n";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Carti carti = new Carti();
                carti.setId(resultSet.getInt("c.id"));
                carti.setDenumire(resultSet.getString("c.denumire"));
                carti.setAn_aparitie(resultSet.getDate("c.an_aparitie"));
                carti.setEditura(resultSet.getString("c.editura"));

                Autor autor = new Autor();
                autor.setId(resultSet.getInt("a.id"));
                autor.setNume(resultSet.getString("a.nume"));
                autor.setPrenume(resultSet.getString("a.prenume"));
                carti.setAutor(autor);

                Genuri genuri = new Genuri();
                genuri.setId(resultSet.getInt("g.id"));
                genuri.setDenumire(resultSet.getString("g.denumire"));
                carti.setGenuri(genuri);

                cartis.add(carti);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cartis;
    }

    public boolean save(Carti carti) {
        String query = "INSERT INTO carti(denumire,editura,id_autor,id_gen) VALUES(?,?,?,?)";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carti.getDenumire());
            preparedStatement.setString(2, carti.getEditura());
            preparedStatement.setInt(3, carti.getAutor().getId());
            preparedStatement.setInt(4, carti.getGenuri().getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return true;
    }

}