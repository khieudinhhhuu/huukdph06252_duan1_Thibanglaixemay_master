package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.AnswerAdapter;
import com.khieuthichien.thibanglaixemay.model.Answer;
import com.khieuthichien.thibanglaixemay.model.Cauhoi;
import com.khieuthichien.thibanglaixemay.model.MyResource;

import java.util.ArrayList;
import java.util.List;

public class HLTkhainiemvaquytacActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private ImageView imgback;
    private TextView question;
    private ImageView imageQuestion;
    private ListView lvkhainiemvaquytac;
    private ImageButton btnBack;
    private ImageButton btnCheck;
    private ImageButton btnNext;
    private DrawerLayout drawer;
    private ListView lvdrawer;

    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle mToggle;
    private MyResource myResource;
    private int rowIndexSelected;
    private AdapterView adapterView;
    private Cauhoi cauhoi;
    private int indexBegin, indexEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hltkhainiemvaquytac);



        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HLTkhainiemvaquytacActivity.this, HoclythuyetActivity.class));
                finish();
            }
        });

        question = findViewById(R.id.question);
        imageQuestion = findViewById(R.id.image_question);
        lvkhainiemvaquytac = findViewById(R.id.lvkhainiemvaquytac);
        btnBack = findViewById(R.id.btnBack);
        btnCheck = findViewById(R.id.btnCheck);
        btnNext = findViewById(R.id.btnNext);
        drawer = findViewById(R.id.drawer);
        lvdrawer = findViewById(R.id.lvdrawer);

        try {
            setIndexBegin(Integer.parseInt(getIntent().getStringExtra("begin")));
            setIndexEnd(Integer.parseInt(getIntent().getStringExtra("end")));
            createListViewNavigation();
            createToggle();
            setMyResource(new MyResource(getResources(),R.raw.resource));
            createListViewAnswer(getIndexBegin());
        }catch (Exception e){
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnBack:
                        try {
                            createListViewAnswer(getRowIndexSelected()-1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
//                    case R.id.btnCheck:
//                        View view;
//                        for(int i:getCauhoi().getResult()){
//                            view = lvkhainiemvaquytac.getChildAt(i);
//                            view.setBackgroundResource(R.color.colorPrimary6);
//                        }
//                        break;
                    case R.id.btnNext:
                        try {
                            createListViewAnswer(getRowIndexSelected()+1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        Toast.makeText(HLTkhainiemvaquytacActivity.this, "Không tồn tại chức năng này", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    // Sự kiện click vào Toggle trên Actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Tạo menu chọn câu hỏi
    private void createListViewNavigation() throws Exception{
        ArrayList<String> arrList = new ArrayList<>();
        for (int i=getIndexBegin(); i<=getIndexEnd(); i++){
            arrList.add("Câu "+(i+1));
        }
        String [] arr = arrList.toArray(new String[arrList.size()]);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arr);
        lvdrawer.setAdapter(adapter);
        lvdrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {

                    createListViewAnswer(getIndexBegin() + position);
                } catch (Exception e) {
                    Toast.makeText(HLTkhainiemvaquytacActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                drawer.closeDrawers();
            }
        });
    }

    // Tạo custom listview các đáp án
    private void createListViewAnswer(int index) throws Exception{
        ArrayList<Answer> array = new ArrayList<>();
        Cauhoi cauhoi = getMyResource().getIndex(index);
        setCauhoi(cauhoi);

        for(String answer : cauhoi.getAnswer()){
            array.add(new Answer(answer,false));
        }

        AnswerAdapter adapter = new AnswerAdapter(this,R.layout.item_hlt_learn,array);
        lvkhainiemvaquytac.setAdapter(adapter);

        lvkhainiemvaquytac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setAdapterView(parent);
                Answer row = (Answer) parent.getItemAtPosition(position);
                row.setBit(!row.isBit());
                CheckBox cbchon = view.findViewById(R.id.cbchon);
                cbchon.setBackgroundResource(row.isBit()?R.color.colorPrimary:R.color.white);
            }
        });
        setRowIndexSelected(index);
        // update layout
        updateLayout(index,cauhoi.getDescription());
    }

    // Cập nhật câu hỏi và title trên Actionbar
    private void updateLayout(int index, String des){

        btnBack.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);

        if (index==getIndexBegin())
            btnBack.setVisibility(View.INVISIBLE);
        if(index==getIndexEnd())
            btnNext.setVisibility(View.INVISIBLE);

        getSupportActionBar().setTitle("Câu số "+(index+1));
        setDescription(des);
        loadImage(index);
    }

    // Tạo Toogle(Button trên ActionBar dùng để đóng mở menu chọn lựa đáp án)
    private void createToggle(){
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Load hình ảnh nếu có
    private void loadImage(int index){
        try{
            String path = myResource.getIndex(index).getPathImage();
            Drawable drawable = myResource.getDrawable(getAssets(),"image/"+path);
            imageQuestion.setImageDrawable(drawable);
            if (path.equals("")){
                imageQuestion.setMaxHeight(0);
                imageQuestion.setMinimumHeight(0);
            }
            else{
                imageQuestion.setMinimumHeight(300);
                imageQuestion.setMaxHeight(300);
            }
        }catch(Exception e){}
    }


    public MyResource getMyResource() {
        return myResource;
    }

    public void setMyResource(MyResource myResource) {
        this.myResource = myResource;
    }


    public void setDescription(String description) {
        this.question.setText(description);
    }

    public Cauhoi getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(Cauhoi cauhoi) {
        this.cauhoi = cauhoi;
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
