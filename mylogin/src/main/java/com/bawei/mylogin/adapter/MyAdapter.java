package com.bawei.mylogin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.mylogin.R;
import com.bawei.mylogin.bean.UserBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Hander> implements View.OnClickListener {

    private List<UserBean.ResultBean> list;
    private Context context;

    public MyAdapter(List<UserBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Hander onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.recycle_item, null);
        inflate.setOnClickListener(this);
        Hander hander=new Hander(inflate);
        return hander;
    }

    @Override
    public void onBindViewHolder(@NonNull Hander hander, int i) {
         hander.name.setText(list.get(i).getName());
         hander.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Hander extends RecyclerView.ViewHolder {
        private TextView name;
        public Hander(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }

   public interface setOnClick{
          void OnClickitem(View view,int position);
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
