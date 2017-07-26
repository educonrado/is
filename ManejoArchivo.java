package org.live.vector.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author excz010715
 */
public class ManejoArchivo {

    public void crearArchivo(List<int[]> matrizResultante) {
        String nombreArchivo = "matriz" + crearSecuenciaAleatoria() + ".txt";
        File file = new File(nombreArchivo);
        BufferedWriter bw;
        int vcIncremento = 1;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (int[] is : matrizResultante) {
                bw.write("VC" + vcIncremento++ + "= [");
                for (int i = 0; i < is.length; i++) {
                    bw.write(is[i] + "\u0020");
                }
                bw.write("]\r\n");
            }

            System.out.printf("Archivo creado!!!\n El nombre del archivo es: %s", nombreArchivo);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String crearSecuenciaAleatoria() {
        LocalDateTime ahora = LocalDateTime.now();
        StringBuilder secuencia = new StringBuilder();
        secuencia.append(ahora.getYear());
        secuencia.append(ahora.getMonthValue());
        secuencia.append(ahora.getDayOfMonth());
        secuencia.append(ahora.getHour());
        secuencia.append(ahora.getMinute());
        secuencia.append(ahora.getSecond());
        return secuencia.toString();
    }

}
