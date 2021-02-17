package su.linka.pictures;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LinkaFileLoader {

    public static   void decompress(InputStream fin, String loc ){
try  {

                ZipInputStream zin = new ZipInputStream(fin);
                ZipEntry ze = null;
                while ((ze = zin.getNextEntry()) != null) {
                    Log.v("Decompress", "Unzipping " + ze.getName());

                    if(ze.isDirectory()) {
                     //   dirChecker(ze.getName());
                    } else {
                        FileOutputStream fout = new FileOutputStream(loc + ze.getName());
                        for (int c = zin.read(); c != -1; c = zin.read()) {
                            fout.write(c);
                        }

                        zin.closeEntry();
                        fout.close();
                    }

                }
                zin.close();
            } catch(Exception e) {
                Log.e("Decompress", "unzip", e);
            }

        }
}
