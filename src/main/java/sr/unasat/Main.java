package sr.unasat;

import sr.unasat.mapper.ProductDTOMapper;
import sr.unasat.service.BestellingProductService;
import sr.unasat.service.BestellingService;
import sr.unasat.service.KlantService;
import sr.unasat.service.ProductService;

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
//        productService.createProduct("Bluestone", 50, "Henkilaan2", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\Bluestone.jpg");
//        productService.createProduct("White Sand", 100, "Henkilaan2", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\White_Sand_SML.jpg");


//        klantService.createKlant("Henk", "Blaad", "vergeetmenietstraat", "889235");
//        bestellingService.createBestelling(1, 2023, 3, 18);
//        bestellingService.deleteBestelling(1);

        BestellingProductService bestellingProductService = new BestellingProductService();

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

    }
}