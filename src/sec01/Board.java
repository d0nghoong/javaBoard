package sec01;

import java.io.Serializable;

public class Board implements Serializable {
int pno;
String name;
int price;
int stock;

public int getPno() {return pno;}
public String getName() {return name;}
public int getPrice() {return price;}
public int getStock() {return stock;}


}
