package sr.unasat;

import sr.unasat.service.ChauffeurService;

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


//    public static Image readImg(byte[] photo) {
//        InputStream inputStream = new ByteArrayInputStream(photo);
//        Image img;
//        {
//            try {
//                img = ImageIO.read(inputStream);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return img;
//    }

//    public static void displayImg(Image img) {
//        JLabel label = new JLabel(new ImageIcon(img));
//        JFrame frame = new JFrame();
//        frame.getContentPane().add(label);
//        frame.pack();
//        frame.setVisible(true);
//    }

    public static void main(String[] args) {

//        KlantService ks = new KlantService();
//        ks.createKlant("jane", "hendriks", "anaWeg 34", "8893257");


//        KlantDTOMapper klantDTOMapper = new KlantDTOMapper();
//        KlantService klantService = new KlantService();

        ChauffeurService chauffeurService = new ChauffeurService();

        chauffeurService.createChauffeur("Jake", "Bord", "8734562", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person_1.jpg");
        chauffeurService.createChauffeur("Mark", "Xander", "8734562", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person_3.jpg");
        chauffeurService.createChauffeur("Wendy", "Bendy", "7102358", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person-1.jpg");
        chauffeurService.createChauffeur("Lisa", "Borger", "7160732", "C:\\Users\\Migue\\Documents\\GitHub\\logistiekWebApp\\src\\main\\webapp\\images\\person_4.jpg");
    }

}