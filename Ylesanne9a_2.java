//package ph11ndl;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************** *
 * Programmeerimisharjutused. LTAT.03.007
 * 2019/2020 kevadsemester
 *
 * Kodutöö. Ülesanne nr 9a-2
 * Teema:
 * 		Rekursioon III
 *
 *
 * Autor: Carmen Akkermann
 ******************************************************************************/

public class Ylesanne9a_2 {

    /**
     * Meetod tagastab etteantud täisarvu märgi.
     * @param n täisarv, mille m'rki soovitakse määrata.
     * @return '+', kui on tegu positiivse arvuga, '-', kui on tegemist on negatiivse arvuga, '0', muidu.
     */
    private static char misMärk(int n) {
        if (n>0) return '+';
        else if (n<0) return '-';
        else return '0';
    }

    /**
     * Meetod leiab iteratiivselt järjendis märgimuutude arvu.
     * @param järjend - etteantud järjend, milles otsitakse märgimuutude arvu.
     * @return märgimuutude arv etteantud järjendis.
     */
    private static int iteratiivselt(List<Integer> järjend) {
        int mituMärgimuutust = 0;

        // Eemaldame massiivist nullid, sest need ei ole ülesande lahendamise seisukohast olulised (s.t ei mõjuta tulemust).
        for (int i = 0; i < järjend.size(); i++) {
            if (järjend.get(i) == 0) {
                järjend.remove(i);
                i--;
            }
        }

        for (int i = 0; i < järjend.size()-1; i++) {
            char selleMärk = misMärk(järjend.get(i));
            char järgmiseMärk = misMärk(järjend.get(i+1));
            if (selleMärk != järgmiseMärk && selleMärk != '0' && järgmiseMärk != '0') mituMärgimuutust++;
        }

        return mituMärgimuutust;
    }


    /**
     * Meetod leiab etteantud järjendis esinevate märgimuutude arvu (unaar-rekursiivselt).
     * @param järjend - etteantud järjend, milles otsitakse märgimuutude arvu.
     * @param i - loendur, mis peab järge, mitmendat elementi uuritakse.
     * @return märgimuutude arv.
     */
    private static int unaarRekAbi(List<Integer> järjend, int i) {
        // Baas.
        if (i == järjend.size()) {
            return 0;
        }
        // Samm.
        char selleMärk = misMärk(järjend.get(i-1));
        char järgmiseMärk = misMärk(järjend.get(i));
        if (selleMärk != järgmiseMärk) {
            return 1+unaarRekAbi(järjend, i+1);
        } else return unaarRekAbi(järjend, i+1);
    }

    /**
     * Meetod väljastab järjendis märgimuutude arvu, kasutades abimeetodit unaarRekAbi.
     * @param järjend - etteantud järjend, milles otsitakse märgimuutude arvu.
     */
    private static void unaarrekursiivselt(List<Integer> järjend) {
        // Eemaldame massiivist nullid, sest need ei ole ülesande lahendamise seisukohast olulised (s.t ei mõjuta tulemust).
        for (int i = 0; i < järjend.size(); i++) {
            if (järjend.get(i) == 0) {
                järjend.remove(i);
                i--;
            }
        }
        System.out.println(unaarRekAbi(järjend, 1));
    }


    /*private static int binaarRekAbi(List<Integer> järjend, int i) {
        System.out.println("i = " + i);
        // Baas.
        if (i == 1 || i == järjend.size()) return 0;
        // Samm.
        char selleMärk = misMärk(järjend.get(i-1));
        char järgmiseMärk = misMärk(järjend.get(i));
        if (selleMärk != järgmiseMärk) {
            System.out.println(järjend.get(i-1) + " ja " + järjend.get(i) + " on erineva märgiga");
            return 1+binaarRekAbi(järjend, i+1) + binaarRekAbi(järjend, i-1);
        } else {
            System.out.println(järjend.get(i-1) + " ja " + järjend.get(i) + " on sama märgiga");
            return binaarRekAbi(järjend, i+1) + binaarRekAbi(järjend, i-1);
        }
    }

    private static void binaarrekursiivselt(List<Integer> järjend) {
        // Eemaldame massiivist nullid, sest need ei ole ülesande lahendamise seisukohast olulised (s.t ei mõjuta tulemust).
        for (int i = 0; i < järjend.size(); i++) {
            if (järjend.get(i) == 0) {
                järjend.remove(i);
                i--;
            }
        }
        System.out.println("järjend " + järjend);
        System.out.println("järjendi pikkus = " + järjend.size());
        int keskkoht = järjend.size() / 2;
        System.out.println("järjendi keskkoht (i) = " + keskkoht);
        char enneKeskkohtaMärk = misMärk(järjend.get(keskkoht-1));
        char pärastKeskkontaMärk = misMärk(järjend.get(keskkoht));
        // Kui poolituskoha kõrval on erimärgilised elemendid, siis lisab rekursiivse funktsiooni tulemusele 1.
        //if (enneKeskkohtaMärk != pärastKeskkontaMärk) System.out.println(1 + binaarRekAbi(järjend, keskkoht));
        //else
        //äkki pole neid risu üldse vaja
            System.out.println("binaarse tulemus: " + binaarRekAbi(järjend, keskkoht));
    }*/


    public static void main(String[] args) {
        System.out.println("Ülesanne 9a-2.                          Programmi väljund");
        System.out.println("=========================================================:\n");

        List<Integer> a = new ArrayList<>();
        int[][] massiivid = { {0, 0, 4, 0, 0, 0, 0, 0, 0, 0, -9, 0, 0, 0},
                {22, 0, -9, 8, -9, 0, 0, -12, 18, 0, 28, 0, 25, 0, 25, 0, 10},
                {24, 0, 0, -1, -6, 0, 0, 38, 19, 0, 28, 0, -2, 0, 9},
                {33, 0, -8, 3, -11, 27, 0, -4, 16, -4, 0, 24, 4, -15, 0, 0},
                {29, 35, 26, -1, -3, 34, 17, 20, 11, 2, 1}};
        for (int[] massiiv : massiivid) {
            for (int i : massiiv) {
                a.add(i);
            }
            System.out.println("\nAntud: " + a);
            System.out.println("Märgimuute, iteratiivselt:        " + iteratiivselt(a));
            System.out.print("Märgimuute, unaar-rekutsiivselt:  "); unaarrekursiivselt(a);
            System.out.print("Märgimuute, binaar-rekursiivselt: "); unaarrekursiivselt(a);
            // Binaarrekursiivne meetod on olemas, aga ei tööta päris nii, nagu vaja oleks
            a = new ArrayList<>();
        }

        System.out.println("\n=========================================================.");
        System.out.println("Carmen Akkermann                  "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }

}
