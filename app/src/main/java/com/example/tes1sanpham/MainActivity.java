package com.example.tes1sanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert product
        ProductDAO dao = new ProductDAO(this);
        List<Product> listProduct = dao.GetAll();

        ProductAdapter adapter = new ProductAdapter(listProduct);
        RecyclerView rcvProduct = findViewById(R.id.rcvProduct);
        rcvProduct.setAdapter(adapter);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);

        //Animators
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeIteam(adapter, this));
        itemTouchHelper.attachToRecyclerView(rcvProduct);


        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        // Inflate the custom dialog layout
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the custom dialog layout
                View viewDialog = getLayoutInflater().inflate(R.layout.dialog_product, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setView(viewDialog);
                AlertDialog alert = builder.create();
                alert.show();

                //tiếp tục viết sự kiện trong viewDialog
                EditText txtName = viewDialog.findViewById(R.id.edtName);
                EditText txtImage = viewDialog.findViewById(R.id.edtImage);
                EditText txtprice = viewDialog.findViewById(R.id.edtPrice);
                //sụ kien Save
                viewDialog.findViewById(R.id.btnDialogSaveProduct).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Product p = new Product(0, txtName.getText().toString(), txtImage.getText().toString(), Float.parseFloat(txtprice.getText().toString()));
                        dao.Insert(p);
                        listProduct.add(p); //đưa vào adapter
                        //thong bao thành công
                        Toast.makeText(viewDialog.getContext(), "thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        alert.dismiss(); //thoát khỏi dialog
                        adapter.notifyItemInserted(listProduct.size()-1);
                    }
                });
            }
        });
    }
}