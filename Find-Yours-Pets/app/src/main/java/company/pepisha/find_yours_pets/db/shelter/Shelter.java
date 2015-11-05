package company.pepisha.find_yours_pets.db.shelter;


public class Shelter {
    private int idShelter;
    private String name;
    private String phone;
    private int idAddress;
    private String description;
    private String mail;
    private String operationalHours;
    private int idFacebook;
    private int idTwitter;
    private int idInstagram;

    public int getIdInstagram() {
        return idInstagram;
    }

    public void setIdInstagram(int idInstagram) {
        this.idInstagram = idInstagram;
    }

    public int getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(int idFacebook) {
        this.idFacebook = idFacebook;
    }

    public int getIdTwitter() {
        return idTwitter;
    }

    public void setIdTwitter(int idTwitter) {
        this.idTwitter = idTwitter;
    }

    public String getOperationalHours() {
        return operationalHours;
    }

    public void setOperationalHours(String operationalHours) {
        this.operationalHours = operationalHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdShelter() {
        return idShelter;
    }

    public void setIdShelter(int idShelter) {
        this.idShelter = idShelter;
    }
}