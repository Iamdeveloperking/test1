package test.function.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class TestListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Test> TestList;

    public TestListAdapter(Context context, int layout, ArrayList<Test> TestList) {
        this.context = context;
        this.layout = layout;
        this.TestList = TestList;
    }

    @Override
    public int getCount() {
        return TestList.size();
    }

    @Override
    public Object getItem(int position) {
        return TestList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtaddress;
    }

    public void setFilter(ArrayList<Test> newList){
        TestList= new ArrayList<>();
        TestList.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtaddress = (TextView) row.findViewById(R.id.txtaddress);
            holder.imageView = (ImageView) row.findViewById(R.id.imgTest);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Test test = TestList.get(position);

        holder.txtName.setText(test.getName());
        holder.txtaddress.setText(test.getPrice());

        byte[] testImage = test.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(testImage, 0, testImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
