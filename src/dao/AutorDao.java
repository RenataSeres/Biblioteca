package dao;

import model.Autor;
import model.Carti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "renata";

    public Autor findById(int id) {
        Autor autor = new Autor();


        String query = "select * " +
                "from autor where id = " + id;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                autor.setId(resultSet.getInt(1));
                autor.setNume(resultSet.getString(2));
                autor.setPrenume(resultSet.getString(3));
            }
            return autor;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void save(Autor autor) {

        String query = "INSERT INTO autor(nume,prenume) VALUES(?,?)";
        Connection connection = null; // added commentary
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, autor.getNume());
            preparedStatement.setString(2, autor.getPrenume());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Autor> getAll() {
        List<Autor> autors = new ArrayList<>();

        String query = "SELECT * FROM autor";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Autor autor = new Autor();
                autor.setId(resultSet.getInt(1));
                autor.setNume(resultSet.getString(2));
                autor.setPrenume(resultSet.getString(3));
                autors.add(autor);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return autors;

    }

    public void deleteById(int id) {
        String query = "DELETE FROM autor WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Carti findById() {
        Carti carti = new Carti();
        String query = "SELECT c.id,c.denumire,c.editura,c.an_aparitie,a.id,a.nume,a.prenume,g.id,g.denumire * FROM carti";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                carti.setId(resultSet.getInt(1));
                carti.setDenumire(resultSet.getString(2));
                carti.setEditura(resultSet.getString(3));
                carti.setAn_aparitie(resultSet.getDate(4));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carti;


    }

    //2 metode care sa ne aduca toate datele despre ultimulMSQL , 2 clase cartoDao,insert,delet pt carti
    //FOUND PT CLIENTI, INSERT SI DELET
    //IMPRUMUTdAO INSERARE NOU IMPRUMUT,PT AFISAREA IMPRUMUTURILOR PT CARE CARTILE NU AU FOST RETURNATE + DATE DESPRE CARTI (DENUMIRE SI ID)


}

