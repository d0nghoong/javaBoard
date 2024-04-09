package test2;

import java.io.Serializable;

public class Board implements Serializable {
int pno;
String name;
int price;
int stock;

public int getPno() {return pno;}
public void setPno(int pno) {this.pno=pno;}
public String getName() {return name;}
public void setName(String name) {this.name=name;}
public int  getPrice() {return price;}
public void setPrice(int price) {this.price=price;}
public int getStock() {return stock;}
public void setStock(int stock) {this.stock=stock;}


}
