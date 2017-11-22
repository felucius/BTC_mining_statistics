package maximedelange.btcminerstatistics.Screens.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import maximedelange.btcminerstatistics.R;
import maximedelange.btcminerstatistics.Screens.Domain.BlockNumber;

/**
 * Created by M on 11/19/2017.
 */

public class PoolAdapter extends BaseAdapter {
    Context context;
    BlockNumber[] data;
    private static LayoutInflater inflater = null;

    public PoolAdapter(Context context, BlockNumber[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.pool_listview, null);
        TextView blockNr = (TextView) vi.findViewById(R.id.txtBlockNr);
        ImageView blockImage = (ImageView) vi.findViewById(R.id.imageBlock);

        blockNr.setText(String.valueOf("BLOCK # " + data[position].getID()));
        blockImage.setImageResource(R.mipmap.datablockblack);

        return vi;
    }
}
