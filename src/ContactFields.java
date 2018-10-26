class ContactFields {

    private String name;
    private String surname;
    private String DOB;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zipCode;

    //CONSTRUCTOR
    public ContactFields(String name, String surname, String DOB, String email, String address, String city, String state, Integer zipCode){
        this.name = name;
        this.surname = surname;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //METHODS
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getDOB() { return DOB; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public Integer getZipCode() { return zipCode; }


}