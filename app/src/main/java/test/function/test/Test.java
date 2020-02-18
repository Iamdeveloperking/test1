package test.function.test;



public class Test {
    private int id;
    private String name;
    private String address;
    private byte[] image;

    public Test(String name, String price, byte[] image, int id) {
        this.name = name;
        this.address = price;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return address;
    }

    public void setPrice(String price) {
        this.address = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
