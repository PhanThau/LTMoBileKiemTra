package com.example.tes1sanpham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    DBHelper dbHelper;
    public ProductDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public List<Product> GetAll()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<Product> listProduct = new ArrayList<>();
        String query = "SELECT * FROM product";
        Cursor c =  db.rawQuery(query, null);
        while (c.moveToNext())
        {
            Product temp = new Product();
            temp.setId(c.getInt(0));
            temp.setName(c.getString(1));
            temp.setImage(c.getString(2));
            temp.setPrice(c.getFloat(3));
            listProduct.add(temp);
        }
        return listProduct;
    }
    public void Insert(Product p) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //c1: sử dụng contentValues
        ContentValues values = new ContentValues();
        // values.put("id", p.getId());
        values.put("name", p.getName());
        values.put("image", p.getImage());
        values.put("price", p.getPrice());
        db.insert("product", null, values);
        //c2: sử dụng câu queyry thuần
        // String query = String.format("INSERT INTO %s VALUES('%s','%s',%f, '%s')", "product", p.getId(),p.getName(), p.getImage(), p.getPrice());
        //db.execSQL(query);
    }
    public void Delete(int productId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //c1: sử dụng delete
        db.delete("product", "id=?", new String[] { String.valueOf(productId) });
        //c2: sử dụng câu queyry thuần
        // String query = String.format("delete * from %s where id = %d", "product", productId);
        //db.execSQL(query);
    }
}
