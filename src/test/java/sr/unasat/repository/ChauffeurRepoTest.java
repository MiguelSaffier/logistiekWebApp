//package sr.unasat.repository;
//
//class ChauffeurRepoTest {
//
//    ChauffeurService chauffeurService = new ChauffeurService();
//
//
//    @Test
//    void createThreeRecords() {
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//        assertEquals(3, chauffeurService.getChauffeur().size());
//        //3 objecten zijn gecreëerd en de getAll method heeft de juiste aantal objecten gevonden
//    }
//
//    @Test
//    void findOneChauffeur(){
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//        assertEquals("8993552", chauffeurService.findChauffeurByName("Lijpe", "zanger").getTelefoon());
//    }
//
//    @Test
//    void findChauffeurById(){
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//        assertEquals("8993552", chauffeurService.findChauffeurById(2).getTelefoon());
//    }
//
//    @Test
//    void  updateNaam(){
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//        chauffeurService.updateNaam(2, "Ronnie", "Flex");
//
//        assertEquals("Ronnie", chauffeurService.findChauffeurById(2).getVoornaam());
//
//    }
//
//    @Test
//    void  updateTelefoon(){
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//        chauffeurService.updateTelefoon(2, "77788899");
//
//        assertEquals("77788899", chauffeurService.findChauffeurById(2).getTelefoon());
//    }
//
//    @Test
//    void  delete(){
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//        chauffeurService.deleteChauffeur(2);
//
//        assertEquals(2, chauffeurService.getChauffeur().size());
//    }
//
//
//}