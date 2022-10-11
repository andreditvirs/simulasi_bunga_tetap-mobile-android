package com.uwika.simulasibungatetap;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editTxt_jumlah_pinjaman, editTxt_lama_pinjaman, editTxt_bunga_pinjaman;
    TextView txtV_angsuran_pokok_per_bulan, txtV_angsuran_bunga_per_bulan, txtV_total_angsuran_per_bulan;
    Button kalkulasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTxt_jumlah_pinjaman = findViewById(R.id.jumlah_pinjaman);
        this.editTxt_lama_pinjaman = findViewById(R.id.lama_pinjaman);
        this.editTxt_bunga_pinjaman = findViewById(R.id.bunga_pinjaman);
        this.txtV_angsuran_pokok_per_bulan = findViewById(R.id.angsuran_pokok_per_bulan);
        this.txtV_angsuran_bunga_per_bulan = findViewById(R.id.angsuran_bunga_per_bulan);
        this.txtV_total_angsuran_per_bulan = findViewById(R.id.total_angsuran_per_bulan);
        this.kalkulasi = findViewById(R.id.btn_kalkulasi);
    }

    public void calculate(View v)
    {
        float angsuran_pokok_per_bulan, angsuran_bunga_per_bulan, total_angsuran_per_bulan;
        float jumlah_pinjaman = Float.parseFloat(this.editTxt_jumlah_pinjaman.getText().toString());
        int lama_pinjaman = Integer.parseInt(this.editTxt_lama_pinjaman.getText().toString());
        float bunga_pinjaman = Float.parseFloat(this.editTxt_bunga_pinjaman.getText().toString());
        angsuran_pokok_per_bulan = jumlah_pinjaman/lama_pinjaman;
        angsuran_bunga_per_bulan = (jumlah_pinjaman * (bunga_pinjaman/100))/12;
        total_angsuran_per_bulan = angsuran_pokok_per_bulan + angsuran_bunga_per_bulan;

        this.txtV_angsuran_pokok_per_bulan.setText("Angsuran Pokok per Bulan: Rp. "+ NumberFormat.getNumberInstance(Locale.US).format(angsuran_pokok_per_bulan) +", 00");
        this.txtV_angsuran_bunga_per_bulan.setText("Angsuran Bunga per Bulan: Rp. "+ NumberFormat.getNumberInstance(Locale.US).format(angsuran_bunga_per_bulan) +", 00");
        this.txtV_total_angsuran_per_bulan.setText("Total Angsuran per Bulan: Rp. "+ NumberFormat.getNumberInstance(Locale.US).format(total_angsuran_per_bulan) +", 00");
        return;
    }
}