package com.example.admin.onthia11.a1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.admin.onthia11.MainActivity;
import com.example.admin.onthia11.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BienBaoFragment extends Fragment {

    HinhAnhAdapter hinhAnhAdapter;
    GridView gviewHinhAnh;
    ArrayList<HinhAnh> arr_Image;

    public BienBaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Biển Báo Giao Thông");
        return inflater.inflate(R.layout.fragment_bien_bao, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gviewHinhAnh = getActivity().findViewById(R.id.gviewHinhAnh);
        arr_Image = new ArrayList<>();
        arr_Image.add(new HinhAnh("Biển báo cấm quay đầu xe", R.drawable.bien_bao_cam_quay_dau_xe));
        arr_Image.add(new HinhAnh("Biển báo cầm xe gắn máy", R.drawable.bien_bao_cam_xe_gan_may));
        arr_Image.add(new HinhAnh("Biển báo đoạn đường hay xảy ra tai nạn", R.drawable.bien_bao_doan_duong_hay_xay_ra_tai_nan));
        arr_Image.add(new HinhAnh("Biển báo đường cấm", R.drawable.bien_bao_duong_cam));
        arr_Image.add(new HinhAnh("Biển bắt đầu đoạn đường ưu tiên", R.drawable.bien_bat_dau_doan_duong_uu_tien));
        arr_Image.add(new HinhAnh("Biển các tuyến đường cung cấp", R.drawable.bien_cac_tuyen_duong_cung_cap));
        arr_Image.add(new HinhAnh("Biển cấm đi ngược chiều", R.drawable.bien_cam_di_nguoc_chieu));
        arr_Image.add(new HinhAnh("Biển cấm người đi bộ", R.drawable.bien_cam_nguoi_di_bo));
        arr_Image.add(new HinhAnh("Biển cám ô tô - mô tô 3 bánh", R.drawable.bien_cam_oto_moto_3_banh));
        arr_Image.add(new HinhAnh("Biển cấm ô tô - mô tô đi về trái và phải", R.drawable.bien_cam_oto_moto_di_ve_trai_va_phai));
        arr_Image.add(new HinhAnh("Biển cấm rẽ trái", R.drawable.bien_cam_re_trai));
        arr_Image.add(new HinhAnh("Biển cấm xe công nông", R.drawable.bien_cam_xe_cong_nong));
        arr_Image.add(new HinhAnh("Biển cấm xe mô tô", R.drawable.bien_cam_xe_moto));
        arr_Image.add(new HinhAnh("Biển chỉ được rẽ trái", R.drawable.bien_chi_duoc_re_trai));
        arr_Image.add(new HinhAnh("Biển đi thẳng rẽ phải", R.drawable.bien_di_thang_re_phai));
        arr_Image.add(new HinhAnh("Biển đường hai chiều", R.drawable.bien_duong_hai_chieu));
        arr_Image.add(new HinhAnh("Biển giao nhau có tín hiệu đèn", R.drawable.bien_giao_nhau_co_tin_hieu_den));
        arr_Image.add(new HinhAnh("Biển giao nhau với đường hai chiều", R.drawable.bien_giao_nhau_voi_duong_hai_chieu));
        arr_Image.add(new HinhAnh("Biển giao nhau với đường sắt có rào chắn", R.drawable.bien_giao_nhau_voi_duong_sat_co_rao_chan));
        arr_Image.add(new HinhAnh("Biển giao nhau với đường ưu tiên", R.drawable.bien_giao_nhau_voi_duong_uu_tien));
        arr_Image.add(new HinhAnh("Biển hết đoạn đường ưu tiên", R.drawable.bien_het_doan_duong_uu_tien));
        arr_Image.add(new HinhAnh("Biển hướng thẳng phải theo", R.drawable.bien_huong_thang_phai_theo));
        arr_Image.add(new HinhAnh("Biển nhường đường cho người đi bộ", R.drawable.bien_nhuong_duong_cho_nguoi_di_bo));
        arr_Image.add(new HinhAnh("Biển nhường đường xe cơ giới ngược chiều qua đường hẹp", R.drawable.bien_nhuong_duong_xe_co_gioi_nguoc_chieu_qua_duong_hep));
        arr_Image.add(new HinhAnh("Biển rẽ phải rẽ trái", R.drawable.bien_re_phai_re_trai));
        arr_Image.add(new HinhAnh("Biển stop", R.drawable.bien_stop));
        arr_Image.add(new HinhAnh("Biển cấm dừng xe và đỗ xe", R.drawable.cam_dung_xe_va_do_xe));

        hinhAnhAdapter = new HinhAnhAdapter(getActivity(), arr_Image);
        gviewHinhAnh.setAdapter(hinhAnhAdapter);
        gviewHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), arr_Image.get(position).getTen(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
