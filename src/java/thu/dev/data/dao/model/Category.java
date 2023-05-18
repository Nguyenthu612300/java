/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thu.dev.data.dao.model;

import java.util.List;
import thu.dev.data.dao.DatabaseDao;

/**
 *
 * @author User
 */
public class Category {

    private int id;
    private String name;
    private String image;

    public static Category find(int id) {
        return DatabaseDao.getInstance().getCategoryDao().find(id);
    }

    public static List<Category> all() {
        return DatabaseDao.getInstance().getCategoryDao().all();
    }

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getimage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setimage(String image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
