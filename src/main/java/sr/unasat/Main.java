package sr.unasat;

import sr.unasat.mapper.ProductDTOMapper;
import sr.unasat.service.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
//html, in index, add producten. hardcoden maar met index werken als dat kan.
//Html in about, Chaffuers toevoegen, ook hardcoden. sos als index/producten
//test je api, test je frontend.
//maak een log in en sign up maar laat het een klant create zijn,
//maak een log in if statement, als username en password is equal to x, admin page.
//zoek een manier om te weten welke de meest gekochte goederen zijn, en wat er moet gebeuren als dat niet zo is.
//admin page heeft toegang tot alle crud handelingen en alle data die ik maak.
//regel je dto
//cart, regel je bestelling logica daar, let op bestelling id en levering id. let ook op de kosten, klant en datum.
//gebruik je check out om verder te gaan met de levering en andere informatie nadat de bestelling al opgenomen is.
//Shop heeft alleen nog producten nodig en logica.

//    public static void main(String[] args) {
//        ConsoleFacade cf = new ConsoleFacade();
//        cf.start();
//    }


//    public static byte[] findPhoto(String path) {
//        byte[] imageData = new byte[0];
//        try {
//            imageData = Files.readAllBytes(Paths.get(path));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return imageData;
//    }


    public static Image readImg(byte[] photo) {
        InputStream inputStream = new ByteArrayInputStream(photo);
        Image img;
        {
            try {
                img = ImageIO.read(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return img;
    }

    public static void displayImg(Image img) {
        JLabel label = new JLabel(new ImageIcon(img));
        JFrame frame = new JFrame();
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ProductDTOMapper productDTOMapper = new ProductDTOMapper();
        ProductService productService = new ProductService(productDTOMapper);
        BestellingService bestellingService = new BestellingService();
        KlantService klantService = new KlantService();
        BestellingProductService bestellingProductService = new BestellingProductService();
        ChauffeurService chauffeurService = new ChauffeurService();
        VoertuigService vs = new VoertuigService();
//        productService.createProduct("Bluestone", 50, "Henkilaan2", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\Bluestone.jpg");
//        productService.createProduct("White Sand", 100, "Henkilaan2", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\White_Sand_SML.jpg");


//        klantService.createKlant("Henk", "Blaad", "vergeetmenietstraat", "889235");
//        bestellingService.createBestelling(1, 2023, 3, 18);
//        bestellingService.deleteBestelling(1);



//        List<String> product = new ArrayList<>();
//        List<Integer> am = new ArrayList<>();
//        product.add("Bluestone");
//        am.add(5);
//
//        bestellingProductService.createBestellingProduct(bestellingService.findBestellingById(1), product, am);

//        System.out.println(bestellingProductService.findBestellingProductByid(1));
//        bestellingProductService.updateBestellingProduct(2, "Bluestone", 2);

//        bestellingService.deleteBestelling(52);
//        bestellingProductService.deleteBestellingProduct(52);

//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person_1.jpg");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person_2.jpg");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person_3.jpg");

//        vs.createVoertuig("vrachtwagen", "Toyota", 10, "EV 12-23");
//        vs.createVoertuig("vrachtwagen", "Ford", 20, "89-54 AV");
//        vs.createVoertuig("vrachtwagen", "Mercedes", 2, "39-08 CV");
//        vs.createVoertuig("vrachtwagen", "Daf", 5, "EV 11-22");
//        vs.createVoertuig("vrachtwagen", "Man", 4, "88-55 BV");
//        vs.createVoertuig("vrachtwagen", "Man", 3, "30-80 DV");

//        productService.createProduct("Double Washing Sand", 75, "Vergeetmenietstraat 3", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\double_washing_sand.jpeg");
//        productService.createProduct("MasonrySand", 25, "Hindilaan 20", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\Masonry_Sand.jpg");
//        productService.createProduct("River Jack", 55, "Javaweg 102", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\River_Jack.jpg");
//        productService.createProduct("Washed Gravel", 125, "Indra ghandi weg 458", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\Washed_Gravel_SML.jpg");
//        productService.createProduct("White Gravel", 85.5, "Indra ghandi weg 458", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\White_Gravel.jpg");

    }
}