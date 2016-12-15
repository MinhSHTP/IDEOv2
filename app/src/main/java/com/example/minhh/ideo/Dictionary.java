package com.example.minhh.ideo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Dictionary extends AppCompatActivity {
    ListView _lvVoca;
    SearchView _searchView;
    ArrayAdapter adapter;
    WordInDictionary _listWord = new WordInDictionary();
    List<String> resultList = new ArrayList<String>();
    public static String _wordItemSelected = "";
    public static String _IDItemSelected = "";

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        _searchView = (SearchView) findViewById(R.id.searchView1);
        initList();
//        showToast("" + Locale.getDefault().getDisplayLanguage());
        adapter = new ArrayAdapter<String>(this,
                R.layout.row_in_list_voca, R.id.word, _listWord.getName());

        _lvVoca = (ListView) findViewById(R.id.listVoca);
        _lvVoca.setAdapter(adapter);

        _lvVoca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                _wordItemSelected = _listWord.GetNameToTo(i);
//                _IDItemSelected = _listWord.GetIdToTo(i);
//                showToast(_lvVoca.getItemAtPosition(i).toString());
                _wordItemSelected = _lvVoca.getItemAtPosition(i).toString();
                for (int f = 0; f < resultList.size(); f++) {
                    if (_wordItemSelected == resultList.get(f)) {
                        _IDItemSelected = String.valueOf(f);
                        break;
                    }
                }
                Intent home = new Intent(Dictionary.this, ShowThisWord.class);
                startActivity(home);
            }
        });

        _searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.getFilter().filter("");
                    _lvVoca.clearTextFilter();
                } else {
                    adapter.getFilter().filter(newText.toString());
                }
                return true;
            }
        });

    }

    public void initList() {
        //region List word in vocabulary vietnamese
        resultList.add("A");
        resultList.add("Á hậu");
        resultList.add("Ai?");

        /*add*/resultList.add("Ai cập");/*add*/

        resultList.add("AIDS (bệnh AIDS)");
        resultList.add("Ám ảnh");

        /*add*/resultList.add("An táng");
        resultList.add("An toàn");
        resultList.add("An ủi");
        resultList.add("Anh (quốc gia)");
        resultList.add("Anh ấy / chị ấy");
        resultList.add("Ảnh hưởng");
        resultList.add("Anh trai");
        resultList.add("Anh / chị / bạn");
        resultList.add("Ao");
        resultList.add("Áo");
        resultList.add("Áo (quốc gia)");
        resultList.add("Áo bà ba");
        resultList.add("Áo dài");
        resultList.add("Áo đầm");
        resultList.add("Áo khoác");
        resultList.add("Áo mưa");
        resultList.add("Áo ngực");
        resultList.add("Áo sát nách");
        resultList.add("Áo sơ mi");
        resultList.add("Ảo thuật");
        resultList.add("Áo thun");
        resultList.add("Áp dụng");
        resultList.add("Áp lực");
        /*add*/resultList.add("Argentina (quốc gia)");

        resultList.add("Ă");
        resultList.add("Ẵm em");
        resultList.add("Ăn");
        resultList.add("Ăn bánh quy");
        resultList.add("Ăn cá");

        /*add*/resultList.add("Ăn cam");
        resultList.add("Ăn cắp");
        resultList.add("Ăn cháo");
        resultList.add("Ăn chè");
        resultList.add("Ăn cỏ");
        resultList.add("Ăn cóc");
        resultList.add("Ăn cơm");
        resultList.add("Ăn dưa hấu");
        resultList.add("Ăn đùi gà");
        resultList.add("Ăn gian");
        resultList.add("Ăn hỏi");
        resultList.add("Ăn nho");
        resultList.add("Ăn ổi");
        resultList.add("Ăn táo");
        resultList.add("Ăn vú sữa (1)");
        resultList.add("Ăn vú sữa (2)");
        resultList.add("Ăn xoài");
        resultList.add("Ăn xương");
        /*add*/resultList.add("Ăng-ten");

        resultList.add("Â");
        resultList.add("Âm lịch");
        resultList.add("Âm mưu");
        resultList.add("Ấm áp");
        resultList.add("Ẩn dụ");

        /*add*/resultList.add("Ấn độ (1)");
        resultList.add("Ấn độ (2)");
        /*add*/resultList.add("Ẩu");

        resultList.add("B");

        /*add*/resultList.add("Bà");/*add*/

        resultList.add("Ba (danh từ)");
        resultList.add("Ba (số từ)");

        /*add*/resultList.add("Ba là (1)");
        resultList.add("Ba là (2)");
        resultList.add("Ba Lan");
        resultList.add("Ba lần");
        resultList.add("Ba lô");
        resultList.add("Ba mươi");
        resultList.add("Ba năm");
        /*add*/resultList.add("Ba ngàn đồng");

        resultList.add("Bà ngoại");
        resultList.add("Bà nội");

        /*add*/resultList.add("Ba tháng");
        resultList.add("Ba tiếng");
        resultList.add("Ba tiết");
        resultList.add("Ba trăm");
        resultList.add("Ba trăm ngàn đồng");
        resultList.add("Ba tuần");
        resultList.add("Bác (1)");
        resultList.add("Bác (2)");
        resultList.add("Bạc (màu)");
        resultList.add("Bác Hồ");
        resultList.add("Bác sĩ");
        resultList.add("Bài");
        resultList.add("Bãi biển");
        resultList.add("Bài tập");
        resultList.add("Bàn");
        resultList.add("Bán");
        /*add*/resultList.add("Bàn bạc / thảo luận");

        resultList.add("Bạn bè");

        /*add*/resultList.add("Bàn cầu");
        resultList.add("Bàn chải đánh răng");
        resultList.add("Ban công");
        resultList.add("Bàn cờ");
        resultList.add("Bàn để ủi");
        resultList.add("Bản đồ");
        resultList.add("Bạn học");
        resultList.add("Bạn thân");
        resultList.add("Bàn thờ");
        resultList.add("Bánh");
        resultList.add("Bánh bao");
        resultList.add("Bánh canh");
        resultList.add("Bánh chưng");
        resultList.add("Bánh kem (1)");
        resultList.add("Bánh kem (2)");
        resultList.add("Bánh mì");
        resultList.add("Bánh quy");
        resultList.add("Bánh ướt");
        resultList.add("Bánh xèo");
        resultList.add("Bão");
        resultList.add("Báo (bạn báo tôi)");
        resultList.add("Bào (danh từ)");
        resultList.add("Báo (danh từ)");
        resultList.add("Bào (động từ)");
        resultList.add("Báo (nó báo anh ấy)");
        resultList.add("Báo (tôi báo bạn)");
        resultList.add("Bao lâu?");
        /*add*/resultList.add("Bao nhiêu?");

        resultList.add("Bao nhiêu tiền?");

        /*add*/resultList.add("Bảo vệ (danh từ)");
        resultList.add("Bảo vệ (động từ)");
        resultList.add("Bảy");
        resultList.add("Bay (chim)");
        resultList.add("Bay (máy bay)");
        resultList.add("Bay (trực thăng)");
        resultList.add("Bảy lần");
        resultList.add("Bảy mươi");
        resultList.add("Bảy năm");
        resultList.add("Bảy ngàn đồng");
        resultList.add("Bảy tháng");
        resultList.add("Bảy tiếng");
        resultList.add("Bảy trăm");
        resultList.add("Bảy trăm ngàn đồng");
        resultList.add("Bắc cực");
        resultList.add("Bắc Mỹ");
        resultList.add("Băm (thịt)");
        resultList.add("Bắn (súng ngắn)");
        resultList.add("Bắn (súng trường)");
        resultList.add("Bắn cung");
        resultList.add("Băn khoăn");
        resultList.add("Băng");
        resultList.add("Bằng cấp");
        resultList.add("Bằng nhau");
        resultList.add("Bắp");
        resultList.add("Bắp cải");
        resultList.add("Bắt buộc");
        resultList.add("Bắt chước");
        resultList.add("Bắt đầu");
        resultList.add("Bắt động vật");
        resultList.add("Bấm chuông");
        resultList.add("Bầm tím");
        resultList.add("Bận");
        /*add*/resultList.add("Bận không?");

        resultList.add("Bẩn");

        /*add*/resultList.add("Bất cứ");
        resultList.add("Bất ngờ");
        resultList.add("Bầu cử");
        resultList.add("Bậy bạ");
        resultList.add("Bây giờ");
        resultList.add("Bèo (1)");
        resultList.add("Bèo (2)");
        resultList.add("Bế mạc");
        /*add*/resultList.add("Bệnh viện");

        resultList.add("Bệnh/ốm");

        /*add*/resultList.add("Bếp điện");
        resultList.add("Bếp ga");
        resultList.add("Bỉ (quốc gia)");
        resultList.add("Bí đỏ");
        resultList.add("Bí mật");
        /*add*/resultList.add("Bia");

        resultList.add("Biển");

        /*add*/resultList.add("Biến dạng");
        resultList.add("Biên giới");
        resultList.add("Biết (1)");
        resultList.add("Biết (2)");
        resultList.add("Biết không (1)");
        resultList.add("Biết không (2)");
        resultList.add("Biết ơn");
        resultList.add("Biệt thự");
        resultList.add("Biếu");
        resultList.add("Biểu tình");
        resultList.add("Bình đẳng");
        resultList.add("Bình tĩnh");
        resultList.add("Bịp bợm");
        resultList.add("Bỏ");
        resultList.add("Bò bít tết");
        resultList.add("Bò cạp");
        resultList.add("Bói");
        resultList.add("Bom");
        resultList.add("Bóng");
        resultList.add("Bóng bàn");
        resultList.add("Bóng bầu dục");
        resultList.add("Bong bóng");
        resultList.add("Bóng chày");
        resultList.add("Bóng chuyền");
        resultList.add("Bóng đá");
        resultList.add("Bóng rổ");
        resultList.add("Bồ");
        resultList.add("Bò Đào Nha");
        resultList.add("Bộ đội");
        resultList.add("Bộ phận");
        resultList.add("Bổ sung");
        resultList.add("Bốn");
        resultList.add("Bốn là (1)");
        resultList.add("Bốn là (2)");
        resultList.add("Bốn lần");
        resultList.add("Bốn mươi");
        resultList.add("Bốn năm");
        resultList.add("Bốn ngàn đồng");
        resultList.add("Bồn rửa");
        resultList.add("Bồn tắm");
        resultList.add("Bốn tháng");
        resultList.add("Bốn tiếng");
        resultList.add("Bốn tiết");
        resultList.add("Bốn trăm");
        resultList.add("Bốn trăm ngàn đồng");
        resultList.add("Bông tai");
        resultList.add("Bơi (1)");
        resultList.add("Bơi (2)");
        resultList.add("Bớt");
        resultList.add("Brazil");
        resultList.add("Brunây");
        resultList.add("Bún");
        resultList.add("Bungari");
        resultList.add("Buồn");
        resultList.add("Buôn bán");
        resultList.add("Buôn mê thuột");
        resultList.add("Buồn ngủ");
        resultList.add("Bút bi bấm");
        resultList.add("Bút bi đậy nắp");
        resultList.add("Bút chì");
        resultList.add("Bút mực");
        resultList.add("Bút xóa");
        resultList.add("Bừa bộn");
        resultList.add("Bực bội");
        resultList.add("Bưởi");
        resultList.add("Bướm");
        /*add*/resultList.add("Bưu điện");

        resultList.add("C");
        resultList.add("Cá");
        resultList.add("Cà chua");
        resultList.add("Cá heo");

        /*add*/resultList.add("Cá ngựa");
        resultList.add("Cá nhân");
        /*add*/resultList.add("Cà phê");

        resultList.add("Cà rốt");
        resultList.add("Cá sấu");

        /*add*/resultList.add("Ca sỹ");
        resultList.add("Cá trê");
        /*add*/resultList.add("Cà vạt");

        resultList.add("Các bạn");

        /*add*/resultList.add("Cãi lộn");
        resultList.add("Cái nào?");
        resultList.add("Cái nào? (trong 3 cái)");
        resultList.add("Cái nào? (trong 4 cái)");
        resultList.add("Cái nào? (trong 5 cái)");
        resultList.add("Cái nào lớn hơn");
        resultList.add("Cải xanh");
        resultList.add("Cam (màu)");
        resultList.add("Cam (trái cây)");
        resultList.add("Cảm cúm");
        resultList.add("Cám dỗ");
        /*add*/resultList.add("Cảm động");

        resultList.add("Cảm ơn");

        /*add*/resultList.add("Cảm xúc");
        resultList.add("Campuchia");
        resultList.add("Can đảm");
        resultList.add("Canada");
        /*add*/resultList.add("Canh");

        resultList.add("Cánh đồng");

        /*add*/resultList.add("Cánh gà");
        resultList.add("Cạnh tranh");
        resultList.add("Cao");
        resultList.add("Cao (người)");
        resultList.add("Cao (nhà)");
        resultList.add("Cao đẳng");
        resultList.add("Cạo râu");
        resultList.add("Cao su");
        resultList.add("Cáu");
        resultList.add("Cay");
        resultList.add("Cằm");
        resultList.add("Cằm nhọn");
        resultList.add("Căn tin");
        resultList.add("Căng thẳng");
        resultList.add("Cặp táp");
        resultList.add("Cắt");
        resultList.add("Cắt tóc (nam)");
        resultList.add("Cắt tóc (nữ)");
        resultList.add("Cấm");
        resultList.add("Cần");
        resultList.add("Cân nặng");
        resultList.add("Cẩn thận");
        resultList.add("Cần Thơ");
        resultList.add("Cất cánh");
        resultList.add("Câu");
        resultList.add("Cầu");
        resultList.add("Cậu");
        resultList.add("Câu lạc bộ");
        resultList.add("Cầu lông");
        resultList.add("Cầu mây");
        resultList.add("Cấu tạo");
        resultList.add("Cầu thang");
        resultList.add("Cầu vồng");
        resultList.add("Cây");
        resultList.add("Cây lâu nhà");
        resultList.add("Chải tóc");
        resultList.add("Chán");
        resultList.add("Chanh");
        resultList.add("Cháo");
        resultList.add("Chào (dưới trên)");
        resultList.add("Chào (ngang vai)");
        resultList.add("Cháu");
        resultList.add("Cháy");
        resultList.add("Chảy (máu)");
        resultList.add("Chạy (người)");
        resultList.add("Chạy (tàu)");
        resultList.add("Chạy (thuyền)");
        resultList.add("Chạy (xe 2 bánh)");
        resultList.add("Chạy (xe 4 bánh)");
        resultList.add("Chạy (xe lửa");
        resultList.add("Chắc chắn (1)");
        resultList.add("Chắc chắn (2)");
        resultList.add("Chăm chỉ");
        resultList.add("Chăm sóc");
        resultList.add("Chấp nhận");
        resultList.add("Chật (áo)");
        resultList.add("Chất bột");
        resultList.add("Châu Á");
        resultList.add("Châu Á Thái Bình Dương");
        resultList.add("Châu Âu");
        resultList.add("Châu lục");
        resultList.add("Châu Mỹ");
        resultList.add("Châu Nam Cực");
        resultList.add("Châu Phi (1)");
        resultList.add("Châu Phi (2)");
        resultList.add("Châu Úc");
        resultList.add("Chè");
        resultList.add("Chê");
        resultList.add("Chết (1)");
        resultList.add("Chết (2)");
        resultList.add("Chết (3)");
        resultList.add("Chị gái");
        resultList.add("Chỉ nha khoa");
        resultList.add("Chiên (1)");
        resultList.add("Chiên (2)");
        resultList.add("Chiến tranh");
        resultList.add("Chiều (hướng)");
        resultList.add("Chiều (thời gian)");
        resultList.add("Chi-lê");
        resultList.add("Chim (1)");
        resultList.add("Chim (2)");
        resultList.add("Chim cánh cụt");
        resultList.add("Chín (1)");
        resultList.add("Chín (2)");
        resultList.add("Chín mươi");
        resultList.add("Chín năm");
        resultList.add("Chín tháng");
        resultList.add("Chín tiếng");
        resultList.add("Chín tiết");
        resultList.add("Chín trăm");
        resultList.add("Cho");
        resultList.add("Chó");
        resultList.add("Chọn");
        resultList.add("Chóng mặt");
        resultList.add("Chổi");
        resultList.add("Chôm chôm");
        resultList.add("Chồng");
        resultList.add("Chờ");
        resultList.add("Chở");
        resultList.add("Chợ (1)");
        resultList.add("Chợ (2)");
        resultList.add("Chở ba người");
        resultList.add("Chở hai người");
        resultList.add("Chớp");
        resultList.add("Chú");
        resultList.add("Chủ");
        resultList.add("Chủ nhật");
        resultList.add("Chua");
        resultList.add("Chui (hang)");
        resultList.add("Chung");
        resultList.add("Chung cư");
        resultList.add("Chúng nó");
        resultList.add("Chúng ta");
        resultList.add("Chuối");
        resultList.add("Chuông đèn");
        resultList.add("Chuông điện");
        resultList.add("Chưa");
        resultList.add("Chưa bao giờ");
        resultList.add("Có");
        resultList.add("Cỏ");
        resultList.add("Có bao giờ?");
        resultList.add("Có thể");
        resultList.add("Cóc (trái cây)");
        /*add*/resultList.add("Compa");

        resultList.add("Con");

        /*add*/resultList.add("Còn");
        resultList.add("Cọp");
        resultList.add("Costa Rica");
        resultList.add("Cô");
        resultList.add("Côn đảo");
        resultList.add("Công");
        resultList.add("Cổng");
        resultList.add("Công an");
        resultList.add("Công dân (môn học)");
        resultList.add("Công nhân");
        resultList.add("Công ty");
        resultList.add("Cột cờ");
        resultList.add("Cởi áo");
        resultList.add("Cởi quần");
        resultList.add("Cơm");
        resultList.add("Cũ");
        resultList.add("Cua");
        resultList.add("Của ai");
        resultList.add("Của bạn");
        resultList.add("Của chúng nó");
        resultList.add("Của tôi");
        resultList.add("Cuba");
        resultList.add("Cùi");
        resultList.add("Cũng được");
        resultList.add("Cuối cùng");
        resultList.add("Cuối tuần");
        resultList.add("Cử tạ");
        resultList.add("Cửa cuốn");
        resultList.add("Cửa ra vào");
        resultList.add("Cửa sổ (1)");
        resultList.add("Cửa sổ (2)");
        resultList.add("Cửa sổ (3)");
        resultList.add("Cứng");
        /*add*/resultList.add("Cười");

        resultList.add("D");
        resultList.add("Da");

        /*add*/resultList.add("Dài");
        resultList.add("Dài (tay áo)");
        resultList.add("Dài (thân áo)");
        resultList.add("Dao");
        resultList.add("Dao bào");
        resultList.add("Dao cạo râu");
        resultList.add("Dao nhỏ");
        resultList.add("Dao to");
        resultList.add("Dày");
        /*add*/resultList.add("Dạy");

        resultList.add("Dầu gội");
        resultList.add("Dấu hỏi");
        resultList.add("Dấu huyền (1)");
        resultList.add("Dấu huyền (2)");

        /*add*/resultList.add("Dấu mũ");
        resultList.add("Dấu nặng");
        resultList.add("Dấu ngã");
        resultList.add("Dấu ngừa");
        resultList.add("Dấu sắc (1)");
        resultList.add("Dấu sắc (2)");
        resultList.add("Dây");
        resultList.add("Dây chuyền (1)");
        resultList.add("Dây chuyền (2)");
        resultList.add("Dây nịt");
        resultList.add("Dép");
        resultList.add("Dễ dàng");
        resultList.add("Dì");
        resultList.add("Diễn viên");
        resultList.add("Dinh dưỡng");
        /*add*/resultList.add("Dịu dàng");

        resultList.add("Dọn dẹp");//DOWNLOADED

        /*add*/resultList.add("Dở");
        resultList.add("Dơi");
        /*add*/resultList.add("Dù");

        resultList.add("Du lịch");//DOWNLOADED

        /*add*/resultList.add("Dụng cụ học tập");
        resultList.add("Dư");
        resultList.add("Dừa");
        resultList.add("Dưa hấu");
        resultList.add("Dưa leo");
        /*add*/resultList.add("Dưới");

        resultList.add("Đ");

        /*add*/resultList.add("Đá (danh từ)");
        resultList.add("Đá (động từ");
        resultList.add("Đá cầu");
        resultList.add("Đà Lạt");
        resultList.add("Đà Nẵng");
        resultList.add("Đài Loan");
        resultList.add("Đám cưới");
        resultList.add("Đan Mạch");
        resultList.add("Đánh vần");
        resultList.add("Đạo đức");
        /*add*/resultList.add("Đau");//inndicate 13

        resultList.add("Đau bụng");
        resultList.add("Đau răng");
        resultList.add("Đất nước");
        resultList.add("Đầu");
        resultList.add("E");
        resultList.add("Em");
        resultList.add("Em bé");
        resultList.add("Ê");
        resultList.add("Ế/Ế ẩm");
        resultList.add("Ếch");
        resultList.add("F");
        resultList.add("G");
        resultList.add("Gà");
        resultList.add("Gái");
        resultList.add("Gãy");
        resultList.add("Gặp");
        resultList.add("Gần");
        resultList.add("Gia đình");
        resultList.add("Giáo viên");
        resultList.add("Giày");
        resultList.add("Giúp");
        resultList.add("Gội đầu");
        resultList.add("H");
        resultList.add("Hạ cánh");
        resultList.add("Hà Nội");//DOWNLOADED
        resultList.add("Hàng rào");
        resultList.add("Hạnh phúc");
        resultList.add("Hát");
        resultList.add("Hâm mộ");
        resultList.add("Hấp dẫn");
        resultList.add("Heo");
        resultList.add("Ho");
        resultList.add("Học sinh");
        resultList.add("I");
        resultList.add("Ích kỷ");
        resultList.add("Im lặng");
        resultList.add("Indonesia");
        resultList.add("Iran");
        resultList.add("Irắc");
        resultList.add("Ít");
        resultList.add("Ít khi");
        resultList.add("J");
        resultList.add("Jamaica");
        resultList.add("Judo");
        resultList.add("K");
        resultList.add("Karate");
        resultList.add("Kem");
        resultList.add("Kẹt xe");
        resultList.add("Khỉ (1)");
        resultList.add("Khỉ (2)");
        resultList.add("Khí hậu");
        resultList.add("Không đủ");
        resultList.add("Không thích");
        resultList.add("Ký hiệu");
        resultList.add("Khuya");//DOWNLOADED
        resultList.add("L");
        resultList.add("Lá");
        resultList.add("Làm");
        resultList.add("Làng");
        resultList.add("Lịch sử");
        resultList.add("Lo lắng");
        resultList.add("Lũ lụt");
        resultList.add("Lười biếng (1)");
        resultList.add("Lười biếng (2)");
        resultList.add("M");
        resultList.add("Malaysia");
        resultList.add("Mạnh");
        resultList.add("Mát mẻ");
        resultList.add("Máu");
        resultList.add("Màu sắc");
        resultList.add("Máy bay");
        resultList.add("Mẹ/má");
        resultList.add("Mèo");
        resultList.add("Miệng");
        resultList.add("Máy vi tính");//DOWNLOADED
        resultList.add("N");
        resultList.add("Nai");
        resultList.add("Nắng");
        resultList.add("Nâu");
        resultList.add("Ngã tư");
        resultList.add("Ngày mai");
        resultList.add("Nghỉ");
        resultList.add("Ngôi sao");
        resultList.add("Nhà vệ sinh");
        resultList.add("No");
        resultList.add("Ngoan");//DOWNLOADED
        resultList.add("O");
        resultList.add("Ói");
        resultList.add("Ô");
        resultList.add("Ổi");
        resultList.add("Ốm/gầy (1)");
        resultList.add("Ốm/gầy (2)");
        resultList.add("Ồn ào");
        resultList.add("Ông");
        resultList.add("Ở");
        resultList.add("Ở dưới");
        resultList.add("Ở đâu?");
        resultList.add("Ở lại");
        resultList.add("Ở trên");
        resultList.add("Ớt");
        resultList.add("P");
        resultList.add("Phá");
        resultList.add("Phát triển");
        resultList.add("Phía sau");
        resultList.add("Phía trước");
        resultList.add("Phó");
        resultList.add("Phòng");
        resultList.add("Phụ nữ");
        resultList.add("Phút");
        resultList.add("Q");
        resultList.add("Quần áo");
        resultList.add("Quê hương");
        resultList.add("Quýt");
        resultList.add("R");
        resultList.add("Rảnh không ?");
        resultList.add("Rau quả");
        resultList.add("Rắn");
        resultList.add("Răng");
        resultList.add("Rừng");
        resultList.add("S");
        resultList.add("Sách");
        resultList.add("Sạch sẽ");
        resultList.add("Sinh nhật");
        resultList.add("So sánh");
        resultList.add("Suối");
        resultList.add("T");
        resultList.add("Tai");
        resultList.add("Thăm");
        resultList.add("Thẳng");
        resultList.add("Thất vọng");
        resultList.add("U");
        resultList.add("Ung thư");
        resultList.add("Uống");
        resultList.add("Ư");
        resultList.add("Ước mơ");
        resultList.add("V");
        resultList.add("Vội vàng");
        resultList.add("Việt Nam");
        resultList.add("Vịt");
        resultList.add("Voi");
        resultList.add("Vợ chồng");
        resultList.add("Vua");
        resultList.add("Vui vẻ");
        resultList.add("X");
        resultList.add("Xa");
        resultList.add("Xà bông");
        resultList.add("Xà lách");
        resultList.add("Xanh lá");
        resultList.add("Xấu hổ");
        resultList.add("Xây dựng");
        resultList.add("Xe buýt");
        resultList.add("Xe đạp");
        resultList.add("Xuân");
        resultList.add("Xương");
        resultList.add("Y");
        resultList.add("Y tá");
        resultList.add("Yếu");
        resultList.add("Yêu (1)");
        resultList.add("Yêu (2)");
        resultList.add("Yêu (bạn yêu tôi)");
        resultList.add("Yêu (tôi yêu bạn)");
        resultList.add("Yêu thương");
        resultList.add("Yogurt");
        resultList.add("Ý");
        //endregion
//        Collections.sort(resultList);
        _listWord.setName(resultList);
    }

}
