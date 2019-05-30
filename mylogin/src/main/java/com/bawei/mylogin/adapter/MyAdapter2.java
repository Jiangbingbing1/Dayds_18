package com.bawei.mylogin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.mylogin.R;
import com.bawei.mylogin.bean.UserBean;
import com.bawei.mylogin.bean.UserBean2;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Hander> implements View.OnClickListener {

    private List<UserBean2.ResultBean> list;
    private Context context;

    public MyAdapter2(List<UserBean2.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Hander onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.recycle_item2, null);
        inflate.setOnClickListener(this);
        Hander hander=new Hander(inflate);
        return hander;
    }

    @Override
    public void onBindViewHolder(@NonNull Hander hander, int i) {
        Glide.with(context).load(list.get(i).getMasterPic()).into(hander.img);
         hander.name.setText(list.get(i).getCommodityName());
         hander.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Hander extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView img;
        public Hander(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
        }
    }

   public interface setOnClick{
          void OnClickitem(View view, int position);
    }
    private setOnClick setOnClick;
    public void OnsetItem(setOnClick setOnClick){
          this.setOnClick=setOnClick;
    }

    @Override
    public void onClick(View v) {
          if (setOnClick!=null){
                setOnClick.OnClickitem(v, (Integer) v.getTag());
          }
    }

}
