    package com.example.tes1sanpham;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.List;

    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
        private List<Product> listProduct;
        public ProductAdapter(List<Product> listProduct){
            this.listProduct =listProduct;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View monhocView = inflater.inflate(R.layout.item_product,parent,false);
            return new ViewHolder(monhocView);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position){
            Product p= listProduct.get(position);
            holder.txtName.setText(p.getName());
            holder.txtPrice.setText(String.valueOf(p.getPrice()));
        }
        @Override
        public int getItemCount(){return listProduct.size();}
        public int deleteItem(int pos){
            Product p = listProduct.get(pos);
            listProduct.remove(p);
            return p.getId();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imgView;
            TextView txtName;
            TextView txtPrice;

            public ViewHolder(@NonNull View itemview){
                super(itemview);
                imgView = (ImageView) itemview.findViewById(R.id.imgProduct);
                txtName = (TextView) itemview.findViewById(R.id.txtName);
                txtPrice = (TextView) itemview.findViewById(R.id.txtPrice);
            }
        }
    }
