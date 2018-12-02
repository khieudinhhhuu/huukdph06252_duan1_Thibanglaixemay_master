package com.khieuthichien.thibanglaixemay.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.AnswerAdapter;
import com.khieuthichien.thibanglaixemay.model.Answer;
import com.khieuthichien.thibanglaixemay.model.QuestionHLT;
import com.khieuthichien.thibanglaixemay.model.myResource;

import java.util.ArrayList;

public class HLTkhainiemvaquytacActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle mToggle;
    private com.khieuthichien.thibanglaixemay.model.myResource myResource;

    private QuestionHLT questionHLT;

    private int rowIndexSelected;
    private AdapterView adapterView;

    private int indexBegin;
    private int indexEnd;

    private DrawerLayout hlt_drawerLayout;
    private ImageButton hlt_btnBack;
    private ImageButton hlt_btnNext;
    private ImageView hlt_imganhcauhoi;
    private TextView hlt_tvcauhoi;
    private ListView hlt_lvnavigation;
    private ListView hlt_lvcacdapanluachon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hltkhainiemvaquytac);

        hlt_lvnavigation = findViewById(R.id.hlt_lvnavigation);
        hlt_lvcacdapanluachon =  findViewById(R.id.hlt_lvcacdapanluachon);
        hlt_tvcauhoi = findViewById(R.id.hlt_tvcauhoi);
        hlt_btnBack = findViewById(R.id.hlt_btnBack);
        hlt_btnNext =  findViewById(R.id.hlt_btnNext);
        hlt_imganhcauhoi =  findViewById(R.id.hlt_imganhcauhoi);

        try {
            setIndexBegin(Integer.parseInt(getIntent().getStringExtra("begin")));
            setIndexEnd(Integer.parseInt(getIntent().getStringExtra("end")));
            createListViewNavigation();
            createToggle();
            setMyResource(new myResource(getResources(),R.raw.resource));
            createListViewAnswer(getIndexBegin());
        }catch (Exception e){
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }


    // Sự kiện click vào Toggle trên Actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Sự kiện click vào các view tương ứng
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.hlt_btnBack:
                try {
                    createListViewAnswer(getRowIndexSelected()-1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.hlt_btnCheckdapan:
                View view;
                for(int i: getQuestionHLT().getResult()){
                    view = hlt_lvcacdapanluachon.getChildAt(i);
                    view.setBackgroundResource(R.color.colorPrimary3);
                }
                break;
            case R.id.hlt_btnNext:
                try {
                    createListViewAnswer(getRowIndexSelected()+1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                Toast.makeText(this, "Không tồn tại chức năng này", Toast.LENGTH_SHORT).show();
                break;
        }
    }




    // Tạo menu chọn câu hỏi
    private void createListViewNavigation() throws Exception {
        ArrayList<String> arrList = new ArrayList<>();
        for (int i=getIndexBegin(); i<=getIndexEnd(); i++){
            arrList.add("Câu "+(i+1));
        }
        String[] arr = arrList.toArray(new String[arrList.size()]);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arr);
        hlt_lvnavigation.setAdapter(adapter);
        hlt_lvnavigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    createListViewAnswer(getIndexBegin() + position);
                } catch (Exception e) {
                    Toast.makeText(HLTkhainiemvaquytacActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                hlt_drawerLayout.closeDrawers();
            }
        });
    }

    // Tạo custom listview các đáp án
    private void createListViewAnswer(int index) throws Exception {
        ArrayList<Answer> array = new ArrayList<>();
        QuestionHLT questionHLT = getMyResource().getIndex(index);
        setQuestionHLT(questionHLT);

        for(String answer : questionHLT.getAnswer()){
            array.add(new Answer(answer,false));
        }

        AnswerAdapter adapter = new AnswerAdapter(HLTkhainiemvaquytacActivity.this,R.layout.item_listview_hoclythuyet,array);
        hlt_lvcacdapanluachon.setAdapter(adapter);

        hlt_lvcacdapanluachon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setAdapterView(parent);
                Answer row = (Answer) parent.getItemAtPosition(position);
                row.setBit(!row.isBit());
                Button btnchondapan = view.findViewById(R.id.btnchondapan);
                btnchondapan.setBackgroundResource(row.isBit()?R.color.colorPrimary2:R.color.white);
            }
        });
        setRowIndexSelected(index);
        // update layout
        updateLayout(index, questionHLT.getDescription());
    }

    // Cập nhật câu hỏi và title trên Actionbar
    private void updateLayout(int index, String des){

        hlt_btnBack.setVisibility(View.VISIBLE);
        hlt_btnNext.setVisibility(View.VISIBLE);

        if (index==getIndexBegin())
            hlt_btnBack.setVisibility(View.INVISIBLE);
        if(index==getIndexEnd())
            hlt_btnNext.setVisibility(View.INVISIBLE);

        getSupportActionBar().setTitle("Câu số "+(index+1));
        setHlt_tvcauhoi(des);
        loadImage(index);
    }

    // Tạo Toogle(Button trên ActionBar dùng để đóng mở menu chọn lựa đáp án)
    private void createToggle(){
        hlt_drawerLayout = findViewById(R.id.hlt_drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, hlt_drawerLayout ,R.string.open ,R.string.close);
        hlt_drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Load hình ảnh nếu có
    private void loadImage(int index){
        try{
            String path = myResource.getIndex(index).getPathImage();
            Drawable drawable = myResource.getDrawable(getAssets(),"image/"+path);
            hlt_imganhcauhoi.setImageDrawable(drawable);
            if (path.equals("")){
                hlt_imganhcauhoi.setMaxHeight(0);
                hlt_imganhcauhoi.setMinimumHeight(0);
            }
            else{
                hlt_imganhcauhoi.setMinimumHeight(300);
                hlt_imganhcauhoi.setMaxHeight(300);
            }
        }catch(Exception e){}
    }


    public myResource getMyResource() {
        return myResource;
    }

    public void setMyResource(myResource myResource) {
        this.myResource = myResource;
    }

    public void setHlt_tvcauhoi(String hlt_tvcauhoi) {
        this.hlt_tvcauhoi.setText(hlt_tvcauhoi);
    }

    public QuestionHLT getQuestionHLT() {
        return questionHLT;
    }

    public void setQuestionHLT(QuestionHLT questionHLT) {
        this.questionHLT = questionHLT;
    }

    public int getRowIndexSelected() {
        return rowIndexSelected;
    }

    public void setRowIndexSelected(int rowIndexSelected) {
        this.rowIndexSelected = rowIndexSelected;
    }

    public AdapterView getAdapterView() {
        return adapterView;
    }

    public void setAdapterView(AdapterView adapterView) {
        this.adapterView = adapterView;
    }

    public int getIndexBegin() {
        return indexBegin;
    }

    public void setIndexBegin(int indexBegin) {
        this.indexBegin = indexBegin;
    }

    public int getIndexEnd() {
        return indexEnd;
    }

    public void setIndexEnd(int indexEnd) {
        this.indexEnd = indexEnd;
    }


}
