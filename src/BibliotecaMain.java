import dao.AutorDao;
import dao.CarteDao;
import model.Autor;
import model.Carti;
import model.Genuri;

import java.util.List;

public class BibliotecaMain {
    public static void main(String[] args) {
        AutorDao autorDao = new AutorDao();
        Autor autor = autorDao.findById(3);

        System.out.println(autor);


        Autor autor1 = new Autor();
        autor1.setNume("Pop");
        autor1.setPrenume("Maria");
        autorDao.save(autor1);

        List<Autor> autorList = autorDao.getAll();
        System.out.println(autor);

        autorDao.deleteById(15);

        CarteDao carteDao = new CarteDao();
        Carti carti = carteDao.findById(4);
        System.out.println(carti);

        List<Carti> cartiList = carteDao.findAll();
        System.out.println(cartiList);

        Carti carti1 = new Carti();

        carti1.setDenumire("KLOOuj");
        carti1.setEditura("Leda");
        carti1.setId(1);
        carti1.setAutor(new Autor(1));
        carti1.setGenuri(new Genuri(1));
        carteDao.save(carti1);


    }


}
