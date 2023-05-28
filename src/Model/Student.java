package Model;

public class Student {
    String nom;
    String prenom;
    String CNE;
    String note;
    String tel;
    String email;

    public Student(String nom, String prenom, String CNE, String note, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.CNE = CNE;
        this.note = note;
        this.tel = tel;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", CNE='" + CNE + '\'' +
                ", note='" + note + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
