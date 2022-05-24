package encapsulation_Inheritance;

import java.util.Scanner;

public class QLMuonSach {

    private BanDoc banDoc;
    private MuonSach muonSach[];

    public static int nhapInt(Scanner scanner) {
        int result = 0;
        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập lại số!");
            nhapInt(scanner);
        }
        return result;
    }

    private boolean kiemTra(Sach[] sachs, String title) {
        int count = 0;
        for (int i = 0; i < sachs.length; i++) {
            if (sachs[i] == null) {
                break;
            }
            if (sachs[i].getChuyenNganh().equals(title)) {
                count++;
            }
        }
        if (count > 3) {
            return false;
        }
        return true;
    }

    public void nhap(Scanner scanner) {
        System.out.println("=== Thêm mới ===");
    }

    public String hienThi() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mã: ");
        return builder.toString();
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public MuonSach[] getMuonSach() {
        return muonSach;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public void setMuonSach(MuonSach[] muonSach) {
        this.muonSach = muonSach;
    }
}
