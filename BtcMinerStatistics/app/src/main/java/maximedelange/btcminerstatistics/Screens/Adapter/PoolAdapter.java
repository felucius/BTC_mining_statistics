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
        TextView blockInformation = (TextView) vi.findViewById(R.id.txtBlockInfo);
        TextView blockDescription = (TextView) vi.findViewById(R.id.txtDescription);

        TextView dateStarted = (TextView) vi.findViewById(R.id.txtDateStarted);
        TextView confirmation = (TextView) vi.findViewById(R.id.txtConfirmation);
        TextView totalScore = (TextView) vi.findViewById(R.id.txtTotalScores);
        TextView dateFound = (TextView) vi.findViewById(R.id.txtDateFound);
        TextView reward = (TextView) vi.findViewById(R.id.txtReward);
        TextView miningDuration = (TextView) vi.findViewById(R.id.txtMiningDuration);
        TextView hashrate = (TextView) vi.findViewById(R.id.txtHashRate);
        TextView totalShare = (TextView) vi.findViewById(R.id.txtTotalShares);
        TextView mature = (TextView) vi.findViewById(R.id.txtIsMature);

        blockInformation.setText("BLOCK INFO");
        blockDescription.setText("BLOCK DESCRIPTION");

        //blockNr.setText(String.valueOf("Block number: "));
        dateStarted.setText("DATE STARTED: " + data[position].getDateStarted());
        confirmation.setText(String.valueOf("CONFIRMATION: " + data[position].getConfirmation()));
        totalScore.setText(String.valueOf("Total score: " + data[position].getTotalScore()));
        dateFound.setText("DATE FOUND: " + data[position].getDateFound());
        reward.setText(String.valueOf("REWARD: " + data[position].getReward()));
        miningDuration.setText(String.valueOf("MINING DURATION: " + data[position].getMiningDuration()));
        hashrate.setText(String.valueOf("HASHRATE: " + data[position].getHash()));
        totalShare.setText(String.valueOf("TOTAL SHARE: " + data[position].getTotalShare()));
        mature.setText(String.valueOf("MATURE: " + data[position].getMature()));

        //System.out.println("Position: " + position + " datefound position: " + data[position].getDateFound());
        return vi;
    }
}
