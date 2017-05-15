package climb.boulder.bupaboulder;

/**
 * Created by marius on 5/13/17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.graphics.Color.rgb;

public class BoulderAdapter extends RecyclerView.Adapter<BoulderAdapter.BoulderItemView> {
    private static final String TAG = "BoulderAdapter";

    private int nItems;
    private int instanceItems = 0;

    public BoulderAdapter(int numberItems) {
        nItems = numberItems;
    }

    @Override
    public BoulderItemView onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutItemID = R.layout.boulder_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutItemID, viewGroup, false);
        instanceItems = instanceItems + 1;
        BoulderItemView boulderItem = new BoulderItemView(view, instanceItems);

        int taint = 255-(instanceItems * 20) / 4;
        int color = rgb(taint, taint, taint);
        boulderItem.setBackground(color);

        return boulderItem;
    }

    @Override
    public void onBindViewHolder(BoulderItemView boulderItem, int position) {
        Log.d(TAG, "Binding BoulderItemView #" + position);
        boulderItem.bind(position);
    }

    @Override
    public int getItemCount() {
        return nItems;
    }

    public class BoulderItemView extends RecyclerView.ViewHolder {
        TextView listItemNumberView;
        TextView listItemInfo;
        private int nItemView;

        public BoulderItemView(View itemView, int nThisItemView) {
            super(itemView);
            nItemView = nThisItemView;
            listItemNumberView = (TextView) itemView.findViewById(R.id.boulder_number);

            listItemInfo = (TextView) itemView.findViewById(R.id.boulder_info);
            listItemInfo.setText(String.valueOf(nItemView));
        }

        void bind(int number){
            listItemNumberView.setText(String.valueOf(number));
        }

        void setBackground(int color) {
            itemView.setBackgroundColor(color);
        }
    }

}