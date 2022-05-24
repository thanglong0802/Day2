package encapsulation_Inheritance;

import java.util.Scanner;

public class BanDoc extends QLMuonSach {
    private static int AUTO_ID = -1;

    private int maBanDoc, soDienThoai;
    private String hoTen, diaChi, loaiBanDoc;

    public static final String SINH_VIEN = "Sinh viên";
    public static final String HOC_VIEN_CAO_HOC = "Học viên cao học";
    public static final String GIAO_VIEN = "Giáo viên";

    public BanDoc() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.maBanDoc = AUTO_ID;
            return;
        }
        this.maBanDoc = ++AUTO_ID;
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public void setMaBanDoc(int maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(String loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.println("===== Nhập thông tin bạn đọc =====");
        System.out.println("Nhập họ tên: ");
        this.hoTen = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.soDienThoai = nhapInt(scanner);
        System.out.println("Nhập loại bạn đọc: ");
        System.out.println(" 1. Sinh viên \n 2. Học viên cao học \n 3. Giáo viên \n Xin mời nhập lựa chọn của bạn: ");
        int choice = -1;
        do {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (choice > 3 || choice < 1);
        switch (choice) {
            case 1:
                this.loaiBanDoc = BanDoc.SINH_VIEN;
                break;
            case 2:
                this.loaiBanDoc = BanDoc.HOC_VIEN_CAO_HOC;
                break;
            case 3:
                this.loaiBanDoc = BanDoc.GIAO_VIEN;
                break;
        }
//        Sach sach = new Sach();
//        sach.nhap(scanner);
    }

    @Override
    public String hienThi() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.hienThi()).append(getMaBanDoc()).
                append(", họ tên: ").append(getHoTen()).
                append(", địa chỉ: ").append(getDiaChi()).
                append(", số điện thoại: ").append(getSoDienThoai()).
                append(", loại bạn đọc: ").append(getLoaiBanDoc());
//        System.out.println(builder);
        return builder.toString();
    }
}
