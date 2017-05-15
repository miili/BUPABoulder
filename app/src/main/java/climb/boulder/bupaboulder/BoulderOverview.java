package climb.boulder.bupaboulder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.util.Log;


public class BoulderOverview extends AppCompatActivity {
    private BoulderAdapter mBoulderAdapter;
    private RecyclerView mBoulderList;
    private static final String TAG = "BoulderOverview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Building View...");

        setContentView(R.layout.activity_boulder_overview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBoulderList = (RecyclerView) findViewById(R.id.boulder_list);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        mBoulderList.setLayoutManager(layout);
        mBoulderList.setHasFixedSize(false);

        mBoulderAdapter = new BoulderAdapter(100);
        mBoulderList.setAdapter(mBoulderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_boulder_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void buildProblemItems() {

    }
}
