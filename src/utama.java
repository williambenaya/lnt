import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class utama {


	public utama() {
		Menu();
	}
	Scanner scan = new Scanner(System.in);
	ArrayList<karyawan> listkaryawan = new ArrayList<karyawan>();
	
	void Clear() {
		for(int a = 0; a < 30; a++) {
			System.out.println("");
		}
	}
	void Menu() {
		int chooseMenu;
		do {
			Clear();
			
			System.out.println("1. Add new data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update karyawan");
			System.out.println("4. Delete karyawan");
			System.out.println("5. Exit");
			System.out.print(">> ");
			chooseMenu = scan.nextInt();
			scan.nextLine();
		}while(chooseMenu < 1 || chooseMenu > 5);
		
		switch(chooseMenu) {
		case 1:
			addkaryawan();
			break;
		case 2:
			viewkaryawan();
			break;
		case 3:
			updatekaryawan();
			break;
		case 4:
			deletekaryawan();
			break;
		case 5:
			Clear();
			return;
		}
	}
	void viewkaryawan() {
		sorting();
		Clear();
		Viewkaryawandetail();
		System.out.println("\n Enter untuk kembali");
		scan.nextLine();
		Menu();
	}
   void addkaryawan () {
	   String Nama, Jeniskelamin, Jabatan;
	   int count = 0, Gaji;
	   String Kode;
	String bonus;
	   Clear();
	   System.out.print("Imput kode karyawan : ");
		Kode = scan.nextLine();
	   System.out.print("Imput nama karyawan [>=3]: ");
		Nama = scan.nextLine();
		System.out.print("Imput jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		Jeniskelamin = scan.nextLine();
		System.out.print("Imput jabatan  [Manager | Supervisor | Admin] (Case Sensitive): ");
		Jabatan = scan.nextLine();
		
   if(listkaryawan.size() > 1) {
	   for(int i=0;i<listkaryawan.size()-1;i++){
		   if(listkaryawan.get(i).getJabatan().contentEquals(Jabatan)) {
			   count++;
		   }
	   }
   }
   System.out.print("Berhasil menambahkan  karyawan dengan id "+ Kode);
   if(Jabatan.contentEquals("Manager")) {
	   Gaji = 8000000;
   }else if (Jabatan.contentEquals("Supervisor")) {
	   Gaji = 6000000;
   }else {
	   Gaji = 4000000;
   }
   karyawan ambil = new karyawan(Nama,Kode,Jeniskelamin,Jabatan,Gaji);
   listkaryawan.add(ambil);
   if(count>=3) {
	   count=0;
	   float tambahan;
	if(Jabatan.contentEquals("Manager")) {
		   bonus = "10%";
		   tambahan = (float)1/10;
		   
	   }else if(Jabatan.contentEquals("Supervisor")) {
			   bonus = "7.5%";
			   tambahan = (float)75/1000;
			   
	   }else {
		   bonus = "5%";
		   tambahan = (float)5/100;
	   }
	System.out.print("Bonus sebesar "+ bonus +"telah di berikan kepada karyawan dengan id ");
	for(int a = 0 ;a < listkaryawan.size()-1;a++ ) {
		if(listkaryawan.get(a).getJabatan().contentEquals(Jabatan)) {
			int tambah = listkaryawan.get(a).getGaji();
			tambah += tambah*tambahan;
			listkaryawan.get(a).setGaji(tambah);
			if(count!=0) {
				System.out.print(",");
			}
			System.out.print(listkaryawan.get(a).getKode());
			count++;
		}
	}
   }
   System.out.println("\nEnter untuk kembali");
   scan.nextLine();
   Menu();
   }
   
   void Viewkaryawandetail () {
	   Clear();
	   sorting();
	   for (int i=1 ; i<=100 ;i++) {
		   if(i==1 || i==24 || i==55 || i==71 || i==86) {
			   System.out.print("|");
		   }else if(i==100) {
			   System.out.println("|");
		   }else {
			   System.out.print("-");
		   }
	   }
	   System.out.print("|No  |");
	   System.out.print("Kode Karyawan    |");
	   System.out.print("Nama Karyawan                 |");
	   System.out.print("Jenis kelamin   |");
	   System.out.print("Jabatan        |");
	   System.out.println("Gaji Karyawan |");
	   for (int i=1 ; i<=100 ;i++) {
		   if(i==1 || i==24 || i==55 || i==71 || i==86) {
			   System.out.print("|");
		   }else if(i==100) {
			   System.out.println("|");
		   }else {
			   System.out.print("-");
		   }
	   }
	   for (int i=0 ; i<listkaryawan.size() ;i++) {
		   System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n",i+1,
		   listkaryawan.get(i).getKode(),
		   listkaryawan.get(i).getNama(),
		   listkaryawan.get(i).getJeniskelamin(),
		   listkaryawan.get(i).getJabatan(),
		   listkaryawan.get(i).getGaji());
	   }
	   for (int i=1 ; i<=100 ;i++) {
		   if(i==1 || i==24 || i==55 || i==71 || i==86) {
			   System.out.print("|");
		   }else if(i==100) {
			   System.out.println("|");
		   }else {
			   System.out.print("-");
		   }
	   }
}
   void updatekaryawan () {
	   String Kode,Nama,Jeniskelamin,Jabatan;
	   int Gaji;
	   int ChooseNumber;
	   char []temp = new char[8];
	   Viewkaryawandetail();
	   System.out.println("Data yang mau di ubah?");
	   System.out.print(">> ");
	   ChooseNumber = scan.nextInt();
		scan.nextLine();
		 System.out.print("Imput kode karyawan Baru : ");
			Kode = scan.nextLine();
		   System.out.print("Imput nama karyawan Baru [>=3]: ");
			Nama = scan.nextLine();
			System.out.print("Imput jenis kelamin  Baru [Laki-laki | Perempuan] (Case Sensitive): ");
			Jeniskelamin = scan.nextLine();
			System.out.print("Imput jabatan Baru  [Manager | Supervisor | Admin] (Case Sensitive): ");
			Jabatan = scan.nextLine();
			
	   int count = 0;
	if(listkaryawan.size() > 1) {
		   for(int i=0;i<listkaryawan.size()-1;i++){
			   if(listkaryawan.get(i).getJabatan().contentEquals(Jabatan)) {
				   count++;
			   }
		   }
	   }
	   System.out.println("Berhasil menambahkan karyawan dengan id "+ Kode);
	   if(Jabatan.contentEquals("Manager")) {
		   Gaji = 8000000;
	   }else if (Jabatan.contentEquals("Supervisor")) {
		   Gaji = 6000000;
	   }else {
		   Gaji = 4000000;
	   }
	   karyawan ambil = new karyawan(Nama,Kode,Jeniskelamin,Jabatan,Gaji);
	   listkaryawan.add(ambil);
	   if(count>=3) {
		   
		   float tambahan;
		String bonus;
		if(Jabatan.contentEquals("Manager")) {
			   bonus = "10%";
			   tambahan = (float)1/10;
			   
		   }else if(Jabatan.contentEquals("Supervisor")) {
				   bonus = "7.5%";
				   tambahan = (float)75/1000;
				   
		   }else {
			   bonus = "5%";
			   tambahan = (float)5/100;
		   }
		System.out.print("Bonus sebesar "+ bonus +"telah di berikan kepada karyawan dengan id ");
		for(int a = 0 ;a < listkaryawan.size()-1;a++ ) {
			if(listkaryawan.get(a).getJabatan().contentEquals(Jabatan)) {
				int tambah = listkaryawan.get(a).getGaji();
				tambah += tambah*tambahan;
				listkaryawan.get(a).setGaji(tambah);
				if(count!=0) {
					System.out.print(",");
				}
				System.out.print(listkaryawan.get(a).getKode());
				count++;
			}
		
	   
	  
   
	   listkaryawan.get(ChooseNumber-1).setKode(Kode);
	   listkaryawan.get(ChooseNumber-1).setNama(Nama);
	   listkaryawan.get(ChooseNumber-1).setJeniskelamin(Jeniskelamin);
	   listkaryawan.get(ChooseNumber-1).setJabatan(Jabatan);
	   listkaryawan.get(ChooseNumber-1).setGaji(Gaji);
	   
	   System.out.println("Data berhasil di ubah");
       System.out.println("\nEnter untuk kembali");
       scan.nextLine();
       Menu();
		}
	   }
   }
   void deletekaryawan () {
	   String Kode;
	   int ChooseNumber;
	   if(listkaryawan.isEmpty()) {
		   System.out.println("tidak ada data karyawan ");
		   System.out.println("\nEnter untuk kembali");
		   scan.nextLine();
	       Menu();
	   }else {
		   do {
			   Viewkaryawandetail();
			   System.out.println("pilih angka [1-"+ listkaryawan.size()+"] untuk di hapus");
			   System.out.println("0 balik ke menu");
			   ChooseNumber = scan.nextInt();
			   scan.nextLine();
		   }while(ChooseNumber<0 && ChooseNumber>listkaryawan.size());
		   if(ChooseNumber==0) {
			   Clear();
			   Menu();
			  
		   }else {
			   Kode = listkaryawan.get(ChooseNumber-1).getKode();
			   listkaryawan.remove(ChooseNumber-1);
			   System.out.println("berhasil di hapus");
			   do {
				   System.out.println("lanjut?[Iya | Tidak] (Case Sensitive)");
				   Kode = scan.nextLine();
			   }while(!(Kode.contentEquals("Iya")|| Kode.contains("Tidak")));
			   if(Kode.contains("Iya")) {
				   deletekaryawan();   
			   }else {
				   Menu();
			   }
		   }
	   }
   }
   void sorting() {
	   for (int i=0;i<listkaryawan.size();i++) {
		   for (int j=listkaryawan.size()-1;j>0;j--) {
			   if(listkaryawan.get(j-1).getNama().compareTo(listkaryawan.get(j).getNama())>0) {
				   Collections.swap(listkaryawan, j-1, j);
			   }
		   }
	   }
   }
   public static void main(String[] args) {
		
		new utama();
	}
   }
