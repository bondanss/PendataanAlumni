package pnj.remedial.bondan.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseAlumni extends SQLiteOpenHelper {
    public static  String _NAMA_DATABASE = "db_alumnis";
    public  static int _VERSION = 1;
    public static String tb_alumni =
            "CREATE TABLE tb_alumni (nim INTEGER PRIMARY KEY, nama TEXT, tempat TEXT, tanggal TEXT, alamat TEXT, agama TEXT, tlp TEXT, thnMasuk TEXT, thnLulus TEXT, pekerjaan TEXT, jabatan TEXT)";

    public DatabaseAlumni(@Nullable Context context) {
        super(context, _NAMA_DATABASE, null, _VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tb_alumni);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE tb_alumni");
            db.execSQL(tb_alumni);
        }
    }
}
