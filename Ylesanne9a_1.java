//package ph11ndl;

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
        if (massiiv.length == 0 || massiiv.length == 1) return massiiv;
        int esimene = massiiv[i];
        int teine = massiiv[i+1];
        // Baas.
        if (massiiv.length == 2 || massiiv.length == 3) {
            esimene = esimene + teine;
            teine = esimene - teine;
            esimene = esimene - teine;
            massiiv[0] = esimene;
            massiiv[1] = teine;
            return massiiv;
        }
        if (massiiv.length % 2 == 0) { // Paarisarvulise pikkusega massiiv.
            if (i == massiiv.length-2) {
                esimene = esimene + teine;
                teine = esimene - teine;
                esimene = esimene - teine;
                massiiv[i] = esimene;
                massiiv[i+1] = teine;
                return massiiv;
            }
        }
        else { // Paarituarvulise pikkusega massiiv.
            if (i == massiiv.length-3) {
                esimene = esimene + teine;
                teine = esimene - teine;
                esimene = esimene - teine;
                massiiv[i] = esimene;
                massiiv[i+1] = teine;
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
        System.out.println("=========================================================:\n");

        int[][] kõikMassiivid = {new int[0],
                juhuslik_jarjend(1, -100, 100),
                juhuslik_jarjend(2, -100, 100),
                juhuslik_jarjend(8, -100, 100),
                juhuslik_jarjend(15, -100, 100)};

        for (int[] a : kõikMassiivid) {
            System.out.print("            Antud: ");
            System.out.println(Arrays.toString(a));
            int[] b = a.clone();
            System.out.print("Pärast vahetamisi: ");
            System.out.println(Arrays.toString(vahetaPaare(a, 0)));
            // Vahetab uuesti paare ja kontrollib koopiaga.
            if (Arrays.equals(vahetaPaare(a, 0), b))
                System.out.println("                   Test OK.");
            else System.out.println("                   Tekkis viga.");
            System.out.println();
        }

        System.out.println("=========================================================.");
        System.out.println("Carmen Akkermann                  "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }

    
    // Ahti Pederi tehtud abimeetodid (klassist Massiivid) testimise lihtsustamiseks.

    public static int juhuslik(int a, int b){
        //Antud: pooll�ik [a,b)
        //Tagastab: juhusliku t�isarvu sellelt l�igult
        return (int)(Math.round(Math.random()*(b-a)+a));
    }

    public static int[] juhuslik_jarjend(int n, int a, int b){
        //Antud: n - elementide arv, pooll�ik [a,b)
        //Tagastab: n-elemendilise juhuslike t�isarvudega j�rjendi, elemendid l�igult [a,b)
        int[] x=new int[n];
        for(int i=0;i<n;i++)
            x[i]=juhuslik(a,b);
        return x;
    }
}
