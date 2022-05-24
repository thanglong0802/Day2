package encapsulation_Inheritance;

import java.util.Scanner;

public class Sach extends QLMuonSach {
    private int maSach, namXuatBan;
    private String tenSach, tacGia, chuyenNganh;

    private static int MASACH_AUTO = -1;

    public static final String KHOA_HOC = "Khoa học tự nhiên";
    public static final String VAN_NGHE = "Văn học - Nghệ thuật";
    public static final String DIEN_TU = "Điện tử viễn thông";
    public static final String CONG_NGHE = "Công nghệ thông tin";

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public Sach() {
        if (MASACH_AUTO == -1) {
            MASACH_AUTO = 10000;
            this.maSach = MASACH_AUTO;
            return;
        }
        this.maSach = ++MASACH_AUTO;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.println("===== Nhập thông tin sách =====");
        System.out.println("Nhập tên sách: ");
        this.tenSach = scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        this.tacGia = scanner.nextLine();
        System.out.println("Nhập chuyên ngành: ");
        System.out.println(" 1. Khoa học tự nhiên \n 2. Văn học - Nghệ thuật \n 3. Điện tử viễn thông \n 4. Công nghệ thông tin");
        int choice = -1;
        do {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                this.chuyenNganh = Sach.KHOA_HOC;
                break;
            case 2:
                this.chuyenNganh = Sach.VAN_NGHE;
                break;
            case 3:
                this.chuyenNganh = Sach.DIEN_TU;
                break;
            case 4:
                this.chuyenNganh = Sach.CONG_NGHE;
                break;
        }
        System.out.println("Nhập năm xuất bản: ");
        this.namXuatBan = nhapInt(scanner);
    }

    @Override
    public String hienThi() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.hienThi()).append(getMaSach()).
                append(", tên sách: ").append(getTenSach()).
                append(", tác giả: ").append(getTacGia()).
                append(", năm xuất bản: ").append(getNamXuatBan()).
                append(", chuyên ngành: ").append(getChuyenNganh());
//        System.out.println(builder);
        return builder.toString();
    }
}
