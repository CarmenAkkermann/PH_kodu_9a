package ph11ndl;

import java.util.Arrays;

/***************************************************************************** *
 * Programmeerimisharjutused. LTAT.03.007
 * 2019/2020 kevadsemester
 *
 * Kodutöö. Ülesanne nr 9a-1
 * Teema:
 * 		Rekursioon III
 *
 *
 * Autor: Carmen Akkermann
 ******************************************************************************/

public class Ylesanne9a_1 {

    /**
     * Meetod vahetab paarikaupa elementide asukohad.
     * @param massiiv - etteantud massiiv int[], mille elemente hakatakse vahetama.
     * @param i - loendur, mis peab järge, mitmendaid elemente vahetatakse.
     * @return paarikaupa vahetatud elementidega massiiv.
     */
    private static int[] vahetaPaare(int[] massiiv, int i) {
        int esimene = massiiv[i];
        int teine = massiiv[i+1];
        // Baas.
        if (massiiv.length % 2 == 0) { // Paarisarvulise pikkusega massiiv.
            if (i == massiiv.length-2) {
                return massiiv;
            }
        }
        else { // Paarituarvulise pikkusega massiiv.
            if (i == massiiv.length-3) {
                return massiiv;
            }
        }
        // Samm.
        esimene = esimene + teine;
        teine = esimene - teine;
        esimene = esimene - teine;
        massiiv[i] = esimene;
        massiiv[i+1] = teine;
        return vahetaPaare(massiiv, i+2);
    }




    public static void main(String[] args) {

        System.out.println("Ülesanne 9a-1.                          Programmi väljund");
        System.out.println("=========================================================:");

        int[] a1 = {47, 96, -32, 35, -64, -26, -61, -59, -9, -15, -90, -54, 57, -79, -77};
        int[] b = a1.clone();
        int[] uus = vahetaPaare(a1, 0);
        int[] tagasi = vahetaPaare(uus, 0);
        if (Arrays.equals(b, tagasi)) System.out.println("OK");
        else System.out.println("not OK");

        System.out.println("\n=========================================================.");
        System.out.println("Carmen Akkermann                  "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }

}
