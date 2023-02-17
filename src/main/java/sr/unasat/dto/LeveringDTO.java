package sr.unasat.dto;

public class LeveringDTO {


    private int id;
    private String status;
    private double totaleKosten;

//    kijk hoe een fk gedaan wordt


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotaleKosten() {
        return totaleKosten;
    }

    public void setTotaleKosten(double totaleKosten) {
        this.totaleKosten = totaleKosten;
    }
}
