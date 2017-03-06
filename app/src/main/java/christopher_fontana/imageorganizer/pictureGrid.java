package christopher_fontana.imageorganizer;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class pictureGrid extends AppCompatActivity {

    Integer[] Parts = {R.drawable.turret,R.drawable.rockets,R.drawable.car1,R.drawable.monstertires};

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_grid);

        //grid view is instantiated
        GridView grid = (GridView) findViewById(R.id.gridView);

        // image view controller is instantiated
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);

        // textViews instanticated
        final TextView turretText = (TextView) findViewById(R.id.txtDescription);
        final TextView tireText = (TextView) findViewById(R.id.txtDescription);
        final TextView rocketText = (TextView) findViewById(R.id.txtDescription);
        final TextView carText = (TextView) findViewById(R.id.txtDescription);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Selected Part"+(position + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Parts[position]);

                switch(position){
                    case 0:

                        turretText.setText(R.string.txtTurret);
                        break;

                    case 1:

                        rocketText.setText(R.string.txtRockets);
                        break;

                    case 2:
                        carText.setText(R.string.txtCar);
                        break;

                    case 3:
                        tireText.setText(R.string.txtTires);
                        break;
                }

            }
        });
    }

    public class ImageAdapter extends BaseAdapter {

        private Context context;

        public ImageAdapter(Context c) {
            context = c;

        }

        @Override
        public int getCount() {
            return Parts.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            pic = new ImageView(context);
            pic.setImageResource(Parts[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(230,200));
            return pic;
        }
    }

}
