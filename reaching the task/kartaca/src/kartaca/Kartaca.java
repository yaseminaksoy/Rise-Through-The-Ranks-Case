/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartaca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Kartaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File f = new File("C:\\Users\\Asus\\Desktop\\kartaca");
        File[] files = f.listFiles();
        
        ArrayList<File> birinciAsama = new ArrayList<>();
        ArrayList<File> ikinciAsama = new ArrayList<>();

        
        
        ArrayList<File> nHarfiBir = new ArrayList<>();
        ArrayList<File> nHarfiIki = new ArrayList<>();
        ArrayList<File> nHarfiUc = new ArrayList<>();
        ArrayList<File> mHarfi = new ArrayList<>();
        ArrayList<File> mHarfiUc = new ArrayList<>();
        
        ArrayList<File> oHarfiBir = new ArrayList<>();
        ArrayList<File> oHarfiIki = new ArrayList<>();

        
        // a==
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(1) >= 'a' && files[i].getName().contains("==")) {
                ikinciAsama.add(files[i]);
            }
        }
        
        // A==
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(1) >= 'A' && files[i].getName().charAt(1) < 'a'&& files[i].getName().contains("==")) {
                birinciAsama.add(files[i]);
            }
        }
        
        ArrayList<File> birlesim = new ArrayList<>();
        birlesim.add(birinciAsama.get(0)); //MA==
        birlesim.add(birinciAsama.get(1)); //MQ==
        
        birlesim.add(ikinciAsama.get(0));  //Mg==
        birlesim.add(ikinciAsama.get(1));
        birlesim.add(birinciAsama.get(2)); //NA==
        birlesim.add(birinciAsama.get(3));
        birlesim.add(ikinciAsama.get(2));
        birlesim.add(ikinciAsama.get(3));
        
        birlesim.add(birinciAsama.get(4));
        birlesim.add(birinciAsama.get(5));

        String harf = "";
        int decimal = 0;
        for (File file : birlesim) {
            if (file.isFile()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String currentLine = reader.readLine();
                //System.out.println(file.getName());
                //System.out.println(currentLine);
                for (int j = 0; j < currentLine.length(); j++) {
                    if (currentLine.charAt(j) != ' ') {
                        harf += currentLine.charAt(j);
                    } else {
                        decimal = Integer.parseInt(harf, 2);
                        System.out.print((char) decimal);
                        harf = "";
                    }
                    if (j == currentLine.length() - 1) {
                        decimal = Integer.parseInt(harf, 2);
                        System.out.print((char) decimal);
                        harf = "";
                    }
                }

            }
        }

        // AA=
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) == '=' && files[i].getName().charAt(1) >= 'A' && files[i].getName().charAt(1) < 'a' && files[i].getName().charAt(2) >= 'A' && files[i].getName().charAt(2) < 'a') {
                if (files[i].getName().charAt(0) == 'M') {
                    mHarfi.add(files[i]);
                } else if (files[i].getName().charAt(0) == 'N') {
                    nHarfiBir.add(files[i]);
                } else {
                    oHarfiBir.add(files[i]);
                }
            }
        }

        // Aa=
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) == '=' && files[i].getName().charAt(1) >= 'A' && files[i].getName().charAt(1) < 'a' && files[i].getName().charAt(2) >= 'a') {
                if (files[i].getName().charAt(0) == 'M') {
                    mHarfi.add(files[i]);
                } else if (files[i].getName().charAt(0) == 'N') {
                    nHarfiBir.add(files[i]);
                } else {
                    oHarfiBir.add(files[i]);
                }
            }
        }
        for (File file : mHarfi) {
            if (file.isFile()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String currentLine = reader.readLine();
                for (int j = 0; j < currentLine.length(); j++) {
                    if (currentLine.charAt(j) != ' ') {
                        harf += currentLine.charAt(j);
                    } else {
                        decimal = Integer.parseInt(harf, 2);
                        System.out.print((char) decimal);
                        harf = "";
                    }
                    if (j == currentLine.length() - 1) {
                        decimal = Integer.parseInt(harf, 2);
                        System.out.print((char) decimal);
                        harf = "";
                    }
                }
            }
        }
//         aA=

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) == '=' && files[i].getName().charAt(2) >= 'A' && files[i].getName().charAt(2) < 'a' && files[i].getName().charAt(1) >= 'a') {

                if (files[i].getName().charAt(0) == 'M') {
                    mHarfi.add(files[i]);
                } else if (files[i].getName().charAt(0) == 'N') {
                    nHarfiIki.add(files[i]);
                } else {
                    oHarfiIki.add(files[i]);
                }
            }
        }
        // aa=

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) == '=' && files[i].getName().charAt(1) >= 'a' && files[i].getName().charAt(2) >= 'a') {
                if (files[i].getName().charAt(0) == 'M') {
                    mHarfi.add(files[i]);
                } else if (files[i].getName().charAt(0) == 'N') {
                    nHarfiIki.add(files[i]);
                } else {
                    oHarfiIki.add(files[i]);
                }
            }
        }

        harf = "";
        decimal = 0;
        int m = 0;
        while (m < 4) {
            for (File file : mHarfi) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    if (m == 0 && file.getName().charAt(2) < 'a' && file.getName().charAt(1) == 'j') {

                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 1 && file.getName().charAt(2) >= 'a' && file.getName().charAt(1) == 'j') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 2 && file.getName().charAt(2) < 'a' && file.getName().charAt(1) == 'z') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 3 && file.getName().charAt(2) >= 'a' && file.getName().charAt(1) == 'z') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }

            }
            m++;
        }
        harf = "";
        decimal = 0;
        for (int k = 0; k < 2; k++) {
            for (File file : nHarfiBir) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    if (k == 0 && file.getName().charAt(1) == 'D') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (k == 1 && file.getName().charAt(1) == 'T') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }
        }
        harf = "";
        decimal = 0;
        m = 0;
        while (m < 4) {
            for (File file : nHarfiIki) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    if (m == 0 && file.getName().charAt(1) == 'j' && file.getName().charAt(2) < 'a') {

                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 1 && file.getName().charAt(1) == 'j' && file.getName().charAt(2) >= 'a') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 2 && file.getName().charAt(1) == 'z' && file.getName().charAt(2) < 'a') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 3 && file.getName().charAt(1) == 'z' && file.getName().charAt(2) >= 'a') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }

            }
            m++;
        }
        harf = "";
        decimal = 0;
        for (int k = 0; k < 2; k++) {
            for (File file : oHarfiBir) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    if (k == 0 && file.getName().charAt(1) == 'D') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (k == 1 && file.getName().charAt(1) == 'T') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }
        }
        harf = "";
        decimal = 0;
        m = 0;
        while (m < 4) {
            for (File file : oHarfiIki) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    if (m == 0 && file.getName().charAt(1) == 'j' && file.getName().charAt(2) < 'a') {

                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 1 && file.getName().charAt(1) == 'j' && file.getName().charAt(2) >= 'a') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 2 && file.getName().charAt(1) == 'z' && file.getName().charAt(2) < 'a') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    } else if (m == 3 && file.getName().charAt(1) == 'z' && file.getName().charAt(2) >= 'a') {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }

            }
            m++;
        }

        // Aw
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) >= 'w' && files[i].getName().charAt(2) >= 'A' && files[i].getName().charAt(2) < 'a') {
                if (files[i].getName().charAt(0) == 'M') {

                    mHarfiUc.add(files[i]);
                } else {
                    nHarfiUc.add(files[i]);
                }
            }
        }

        // A0 
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) >= '0' && files[i].getName().charAt(3) <= '9' && files[i].getName().charAt(2) >= 'A' && files[i].getName().charAt(2) < 'a') {
                if (files[i].getName().charAt(0) == 'M') {
                    mHarfiUc.add(files[i]);
                } else {
                    nHarfiUc.add(files[i]);
                }
            }
        }

        // aw
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) >= 'w' && files[i].getName().charAt(2) >= 'a') {
                if (files[i].getName().charAt(0) == 'M') {
                    mHarfiUc.add(files[i]);
                } else {
                    nHarfiUc.add(files[i]);
                }
            }
        }

        // a0
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().charAt(3) >= '0' && files[i].getName().charAt(3) <= '9' && files[i].getName().charAt(2) >= 'a') {
                if (files[i].getName().charAt(0) == 'M') {
                    mHarfiUc.add(files[i]);
                } else {
                    nHarfiUc.add(files[i]);
                }
            }
        }
        harf = "";
        decimal = 0;
        for (int i = 0; i < 25; i += 4) {
            for (File file : mHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "MT";
                    h += (char) ((int) 'A' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }
        harf = "";
        decimal = 0;
        for (int i = 0; i < 9; i += 4) {
            for (File file : mHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "MT";
                    h += (char) ((int) 'c' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }
        harf = "";
        decimal = 0;
        for (int i = 0; i < 25; i += 4) {
            for (File file : mHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "Mj";
                    h += (char) ((int) 'A' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }

        harf = "";
        decimal = 0;
        for (int i = 0; i < 9; i += 4) {
            for (File file : mHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "Mj";
                    h += (char) ((int) 'c' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }

        harf = "";
        decimal = 0;
        for (int i = 0; i < 25; i += 4) {
            for (File file : mHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "Mz";
                    h += (char) ((int) 'A' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }
        harf = "";
        decimal = 0;
        for (int i = 0; i < 9; i += 4) {
            for (File file : mHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "Mz";
                    h += (char) ((int) 'c' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }

        harf = "";
        decimal = 0;
        for (int i = 0; i < 25; i += 4) {
            for (File file : nHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "ND";
                    h += (char) ((int) 'A' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }
        harf = "";
        decimal = 0;
        for (int i = 0; i < 5; i += 4) {
            for (File file : nHarfiUc) {
                if (file.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String currentLine = reader.readLine();
                    String h = "ND";
                    h += (char) ((int) 'c' + i);
                    if (file.getName().contains(h)) {
                        for (int j = 0; j < currentLine.length(); j++) {
                            if (currentLine.charAt(j) != ' ') {
                                harf += currentLine.charAt(j);
                            } else {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                            if (j == currentLine.length() - 1) {
                                decimal = Integer.parseInt(harf, 2);
                                System.out.print((char) decimal);
                                harf = "";
                            }
                        }
                    }

                }
            }

        }

    }
}
