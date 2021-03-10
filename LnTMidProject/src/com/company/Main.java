package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    Scanner scan = new Scanner(System.in);
    Vector<String> vNama = new Vector<>();
    Vector<String> vKelamin = new Vector<>();
    Vector<String> vJabatan = new Vector<>();
    Vector<String> vID = new Vector<>();
    Vector<Double> vGaji = new Vector<>();
    Vector<String> vIDAdmin = new Vector<>();
    Vector<String> vIDSupervisor = new Vector<>();
    Vector<String> vIDManager = new Vector<>();

    Vector<String> vManager = new Vector<>();
    Vector<String> vAdmin = new Vector<>();
    Vector<String> vSupervisor = new Vector<>();
    Random ran = new Random();

    public Main(){
        int choose = 0;

        do {
            System.out.println("PT. Mentol");
            System.out.println("==========");
            System.out.println("1. Insert Data Karyawan");
            System.out.println("2. View Data Karyawan");
            System.out.println("3. Update Data Karyawan");
            System.out.println("4. Delete Data Karyawan");
            System.out.println("5. Exit");
            System.out.print(">>");
            try {
                choose=scan.nextInt();
            }catch (Exception e){
                System.err.println("Harap input angka");
                choose = 0;
            }scan.nextLine();

            switch (choose){
                case 1:
                    Input();
                    break;
                case 2:
                    View();
                    break;
                case 3:
                    Update();
                    break;
                case 4:
                    Delete();
                    break;
            }
        }while (choose!=5);
    }

    void Input(){
        String Nama = "";
        String Kelamin ="";
        String Jabatan = "";
        String ID = "";
        Double Gaji = 0.0;

        do {
            System.out.print("Input nama karyawan [>= 3]: ");
            Nama = scan.nextLine();
        } while (Nama.length() < 3);

        do {
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            Kelamin = scan.nextLine();
        } while (!Kelamin.equals("Laki-laki") && !Kelamin.equals("Perempuan"));

        do {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            Jabatan = scan.nextLine();
        } while (!Jabatan.equals("Manager") && !Jabatan.equals("Supervisor") && !Jabatan.equals("Admin"));

        ID = "" + (char)('A' + ran.nextInt(26)) + (char)('A' + ran.nextInt(26)) + "-" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + + ran.nextInt(10);

        System.out.println("Berhasil menambahkan karyawan dengan id " + ID);

        if (Jabatan.equals("Manager")) {
            Gaji = 8000000.0;
            vManager.add(Jabatan);
            vIDManager.add(ID);
        }
        else if (Jabatan.equals("Supervisor")) {
            Gaji = 6000000.0;
            vSupervisor.add(Jabatan);
            vIDSupervisor.add(ID);
        }
        else if (Jabatan.equals("Admin")) {
            Gaji = 4000000.0;
            vAdmin.add(Jabatan);
            vIDAdmin.add(ID);
        }

        vNama.add(Nama);
        vKelamin.add(Kelamin);
        vJabatan.add(Jabatan);
        vID.add(ID);
        vGaji.add(Gaji);

        if (vManager.size() % 3 == 0) {
            for (int i = 0; i < vManager.size(); i++) {
                vGaji.set(i, (vGaji.get(i) + (Gaji * 10 / 100)));
            }
            System.out.println("Gaji Sebesar 10% telah diberikan kepada karyawan dengan id "+vIDManager.get(0)+","+vIDManager.get(1)+","+vIDManager.get(2));
        }

        else if (vSupervisor.size() % 3 == 0) {
            for (int i = 0; i < vSupervisor.size(); i++) {
                vGaji.set(i, (vGaji.get(i) + (Gaji * 7.5 / 100)));
            }
            System.out.println("Gaji Sebesar 7.5% telah diberikan kepada karyawan dengan id "+vIDSupervisor.get(0)+","+vIDSupervisor.get(1)+","+vIDSupervisor.get(2));
        }

        else if (vAdmin.size() % 3 == 0) {
            for (int i = 0; i < vAdmin.size(); i++) {
                vGaji.set(i, (vGaji.get(i) + (Gaji * 5 / 100)));
            }
            System.out.println("Gaji Sebesar 5% telah diberikan kepada karyawan dengan id "+vIDAdmin.get(0)+","+vIDAdmin.get(1)+","+vIDAdmin.get(2));
        }

        vGaji.add(Gaji);

        System.out.println("ENTER to return");
        scan.nextLine();
    }

    void View() {
        String tempNama = "", tempJenisKelamin = "", tempJabatan = "", tempID = "";
        double tempGaji = 0.0;

        if (vNama.isEmpty()) {
            System.out.println("No Karyawan found!");
            System.out.println("ENTER to return");
            scan.nextLine();
        } else {
            for (int i = 0; i < vNama.size() - 1; i++) {
                for (int j = i + 1; j < vNama.size(); j++) {
                    if (vNama.get(i).compareToIgnoreCase(vNama.get(j)) > 0) {
                        tempNama = vNama.get(i);
                        vNama.set(i, vNama.get(j));
                        vNama.set(j, tempNama);

                        tempJenisKelamin = vKelamin.get(i);
                        vKelamin.set(i, vKelamin.get(j));
                        vKelamin.set(j, tempJenisKelamin);

                        tempJabatan = vJabatan.get(i);
                        vJabatan.set(i, vJabatan.get(j));
                        vJabatan.set(j, tempJabatan);

                        tempID = vID.get(i);
                        vID.set(i, vID.get(j));
                        vID.set(j, tempID);

                        tempGaji = vGaji.get(i);
                        vGaji.set(i, vGaji.get(j));
                        vGaji.set(j, tempGaji);

                    }
                }
            }

            for (int i = 0; i < vNama.size(); i++) {
                System.out.println("No." + (i + 1));
                System.out.println("Kode Karyawan : " + vID.get(i));
                System.out.println("Nama Karyawan : " + vNama.get(i));
                System.out.println("Jenis Kelamin : " + vKelamin.get(i));
                System.out.println("Jabatan       : " + vJabatan.get(i));
                System.out.println("Gaji Karyawan : " + vGaji.get(i));
                System.out.println("");
            }
        }
    }

    public void Update() {
        String tempNama = "", tempJenisKelamin = "", tempJabatan = "", tempID = "", nama = "", jenisKelamin = "", jabatan = "", ID = "";
        ;
        int number = -1;
        double gaji = 0.0, tempGaji = 0.0;

        if (vNama.size() == 0) {
            System.out.println("No Karyawan found!");
            System.out.println("ENTER to return");
            scan.nextLine();
        } else {
            for (int i = 0; i < vNama.size() - 1; i++) {
                for (int j = i + 1; j < vNama.size(); j++) {
                    if (vNama.get(i).compareToIgnoreCase(vNama.get(j)) > 0) {
                        tempNama = vNama.get(i);
                        vNama.set(i, vNama.get(j));
                        vNama.set(j, tempNama);

                        tempJenisKelamin = vKelamin.get(i);
                        vKelamin.set(i, vKelamin.get(j));
                        vKelamin.set(j, tempJenisKelamin);

                        tempJabatan = vJabatan.get(i);
                        vJabatan.set(i, vJabatan.get(j));
                        vJabatan.set(j, tempJabatan);

                        tempID = vID.get(i);
                        vID.set(i, vID.get(j));
                        vID.set(j, tempID);

                        tempGaji = vGaji.get(i);
                        vGaji.set(i, vGaji.get(j));
                        vGaji.set(j, tempGaji);

                    }
                }
            }

            for (int i = 0; i < vNama.size(); i++) {
                System.out.println("No." + (i + 1));
                System.out.println("Kode Karyawan : " + vID.get(i));
                System.out.println("Nama Karyawan : " + vNama.get(i));
                System.out.println("Jenis Kelamin : " + vKelamin.get(i));
                System.out.println("Jabatan       : " + vJabatan.get(i));
                System.out.println("Gaji Karyawan : " + vGaji.get(i));
                System.out.println("");
            }

            do {
                try {
                    System.out.print("Pilih nomor karyawan yang ingin diupdate [1..." + vNama.size() + "]: ");
                    number = scan.nextInt();
                } catch (Exception e) {

                }
                scan.nextLine();
            } while (number < 1 || number > vNama.size());


            do {
                System.out.print("Input nama karyawan [>= 3]: ");
                nama = scan.nextLine();
            } while (nama.length() < 3);

            do {
                System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
                jenisKelamin = scan.nextLine();
            } while (!jenisKelamin.equals("Laki-laki") && !jenisKelamin.equals("Perempuan"));

            do {
                System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
                jabatan = scan.nextLine();
            } while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));

            Random rand = new Random();
            ID = "" + (char) ('A' + rand.nextInt(26)) + (char) ('A' + rand.nextInt(26)) + "-" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + +rand.nextInt(10);

            System.out.println("Berhasil menambahkan karyawan dengan id " + ID);

            if (vJabatan.get(number - 1).equals("Manager")) {
                vManager.remove(-1);
            } else if (vJabatan.get(number - 1).equals("Supervisor")) {
                vSupervisor.remove(-1);
            } else if (vJabatan.get(number - 1).equals("Admin")) {
                vAdmin.remove(-1);
            }

            if (jabatan.equals("Manager")) {
                gaji = 8000000;
                vManager.add(jabatan);
            } else if (jabatan.equals("Supervisor")) {
                gaji = 6000000;
                vSupervisor.add(jabatan);
            } else if (jabatan.equals("Admin")) {
                gaji = 4000000;
                vAdmin.add(jabatan);
            }

            vNama.set((number - 1), nama);
            vKelamin.set((number - 1), jenisKelamin);
            vJabatan.set((number - 1), jabatan);
            vID.set((number - 1), ID);
            vGaji.set((number - 1), gaji);

            if (vManager.size() % 3 == 0) {
                for (int i = 0; i < vManager.size(); i++) {
                    vGaji.set(i, (vGaji.get(i) + (gaji * 10 / 100)));
                }
            }

            if (vSupervisor.size() % 3 == 0) {
                for (int i = 0; i < vSupervisor.size(); i++) {
                    vGaji.set(i, (vGaji.get(i) + (gaji * 7.5 / 100)));
                }
            }

            if (vAdmin.size() % 3 == 0) {
                for (int i = 0; i < vAdmin.size(); i++) {
                    vGaji.set(i, (vGaji.get(i) + (gaji * 5 / 100)));
                }
            }
        }
    }

    void Delete() {
        String tempNama = "", tempJenisKelamin = "", tempJabatan = "", tempID = "";
        int deleteNum = -1;
        double tempGaji = 0.0;

        if (vNama.size() == 0) {
            System.out.println("No Karyawan found!");
            System.out.println("ENTER to return");
            scan.nextLine();
        } else {
            for (int i = 0; i < vNama.size() - 1; i++) {
                for (int j = i + 1; j < vNama.size(); j++) {
                    if (vNama.get(i).compareToIgnoreCase(vNama.get(j)) > 0) {
                        tempNama = vNama.get(i);
                        vNama.set(i, vNama.get(j));
                        vNama.set(j, tempNama);

                        tempJenisKelamin = vKelamin.get(i);
                        vKelamin.set(i, vKelamin.get(j));
                        vKelamin.set(j, tempJenisKelamin);

                        tempJabatan = vJabatan.get(i);
                        vJabatan.set(i, vJabatan.get(j));
                        vJabatan.set(j, tempJabatan);

                        tempID = vID.get(i);
                        vID.set(i, vID.get(j));
                        vID.set(j, tempID);

                        tempGaji = vGaji.get(i);
                        vGaji.set(i, vGaji.get(j));
                        vGaji.set(j, tempGaji);

                    }
                }
            }

            for (int i = 0; i < vNama.size(); i++) {
                System.out.println("No." + (i + 1));
                System.out.println("Kode Karyawan : " + vID.get(i));
                System.out.println("Nama Karyawan : " + vNama.get(i));
                System.out.println("Jenis Kelamin : " + vKelamin.get(i));
                System.out.println("Jabatan       : " + vJabatan.get(i));
                System.out.println("Gaji Karyawan : " + vGaji.get(i));
                System.out.println("");
            }


        do {
            try {
                System.out.println("Pilih nomor karyawan yang ingin dihapus [1..." + vNama.size() + "]");
                deleteNum = scan.nextInt();
            } catch (Exception e) {

            }
            scan.nextLine();
        } while (deleteNum < 1 || deleteNum > vNama.size());

        vNama.remove(deleteNum - 1);
        vKelamin.remove(deleteNum - 1);
        vJabatan.remove(deleteNum - 1);
        vID.remove(deleteNum - 1);
        vGaji.remove(deleteNum - 1);
    }
    }

    public static void main(String[] args) {
	new Main();
    }
}