package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Telefonos {

    private String id;
    private String title;
    private String description;
    private String price;
    private String discountPercentage;
    private String rating;
    private String stock;
    private String brand;
    private String category;
    private String thumbnail;
    private String [] images;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;}

    public String getDiscountPercentage() {return discountPercentage;}

    public void setDiscountPercentage(String discountPercentage) {this.discountPercentage = discountPercentage;}

    public String getRating() {return rating;}

    public void setRating(String rating) {this.rating = rating;}

    public String getStock() {return stock;}

    public void setStock(String stock) {this.stock = stock;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public String getThumbnail() {return thumbnail;}

    public void setThumbnail(String thumbnail) {this.thumbnail = thumbnail;}

    public String[] getImages() {return images;}

    public void setImages(String[] images) {this.images = images;}


    public Telefonos(JSONObject a) throws JSONException {
        id = a.getString("id").toString();
        title = "TITLE: "+ a.getString("title").toString();
        price = "PRICE: "+ "$" + a.getString("price").toString() ;
        rating = "RANTIG: " + a.getString("rating").toString() ;
        description = "DESCRIPTION: " + a.getString("description").toString();
        thumbnail = a.getString("thumbnail").toString() ;

        //Obtener el array de las imagenes
        JSONArray listaImagenes = a.getJSONArray("images");
        images = new String[listaImagenes.length()];

        //Recorrer el array de las imagenes
        for (int i = 0;i<listaImagenes.length();i++){
            images[i] = listaImagenes.get(i).toString();
        }

    }
    public static ArrayList<Telefonos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Telefonos> telefonos = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            telefonos.add(new Telefonos(datos.getJSONObject(i)));
        }
        return telefonos;
    }

}
