package encapsulation_Inheritance;

import java.util.Scanner;

public class Main {
    public static Sach SACH[] = new Sach[50];
    public static BanDoc BANDOC[] = new BanDoc[50];
    public static QLMuonSach QLMUONSACH[] = new QLMuonSach[50];
    public static Scanner scanner = new Scanner(System.in);
    public static int INDEXARR = 0;

    public static void main(String[] args) {
        int indexSach = 0;
        int indexBD = 0;
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Nhập sách và bạn đọc");
            System.out.println("2. Hiển thị tất cả danh sách sách và bạn đọc");
            System.out.println("3. Xem danh sách bạn đọc đã mượn sách");
            System.out.println("4. Sắp xếp danh sách quản lý mượn sách");
            System.out.println("5. Tìm kiếm theo tên bạn đọc)");
            System.out.println("0. Thoát chương trình");
            System.out.println("===========================");
            System.out.println("Chọn: ");
            int choiceMainMenu = QLMuonSach.nhapInt(scanner);
            if (choiceMainMenu == 0) {
                break;
            } else if (choiceMainMenu == 1) {
                while (true) {
                    System.out.println("1. Nhập sách");
                    System.out.println("2. Nhập bạn đọc");
                    int choice = QLMuonSach.nhapInt(scanner);
                    if (choice == 1) {
                        Sach sach = new Sach();
                        sach.nhap(scanner);
                        SACH[indexSach++] = sach;
                        System.out.println("Nhập thành công");
                        break;
                    }
                    if (choice == 2) {
                        BanDoc banDoc = new BanDoc();
                        banDoc.nhap(scanner);
                        BANDOC[indexBD++] = banDoc;
                        System.out.println("Nhập thành công");
                        break;
                    } else {
                        System.out.println("Nhập lại số!");
                    }
                }
            } else if (choiceMainMenu == 2) {
                while (true) {
                    System.out.println("1. Hiển thị danh sách sách");
                    System.out.println("2. Hiển thị danh sách bạn đọc");
                    int choiceTwo = QLMuonSach.nhapInt(scanner);
                    if (choiceTwo == 1) {
                        for (int i = 0; i < indexSach; i++) {
                            System.out.println(SACH[i].hienThi());
                        }
                        break;
                    } else if (choiceTwo == 2) {
                        for (int i = 0; i < indexBD; i++) {
                            System.out.println(BANDOC[i].hienThi());
                        }
                        break;
                    } else {
                        System.out.println("Nhập lại số!");
                    }
                }
            } else if (choiceMainMenu == 3) {
                quanLy();
                hienThiQLMS();
                break;
            } else if (choiceMainMenu == 4) {
                while (true) {
                    System.out.println("1. Sắp xếp theo tên bạn đọc");
                    System.out.println("2. Sắp xếp theo số lượng giảm dần");
                    int choiceFour = QLMuonSach.nhapInt(scanner);
                    if (choiceFour == 1) {
                        sxTheoBD();
                        hienThiQLMS();
                        break;
                    } else if (choiceFour == 2) {
                        sxTheoSL();
                        hienThiQLMS();
                        break;
                    } else {
                        System.out.println("Nhập lại số!");
                    }
                }
            } else if (choiceMainMenu == 5) {
                System.out.println("Nhập tên bạn đọc cần tìm kiếm: ");
                String keySearch = scanner.nextLine();
                for (int i = 0; i < BANDOC.length; i++) {
                    if (BANDOC[i].getHoTen().contains(keySearch)) {
                        System.out.println(BANDOC[i].hienThi());
                    }
                    break;
                }
            } else {
                System.out.println("Xin mời nhập lại theo menu");
            }
        }
        System.out.println("Thoát chương trình");
    }

    // Kiểm tra dữ liệu sách, bạn đọc
    public static boolean kiemTraDuLieu() {
        boolean duLieuSach = false;
        for (int i = 0; i < SACH.length; i++) {
            if (SACH[i] != null) {
                duLieuSach = true;
                break;
            }
        }
        boolean duLieuBD = false;
        for (int i = 0; i < BANDOC.length; i++) {
            if (BANDOC[i] != null) {
                duLieuBD = true;
                break;
            }
        }
        return duLieuSach && duLieuBD;
    }

    // Tìm kiếm sách theo mã sách
    public static Sach timKiemSachTheoID(int MaSach) {
        for (int i = 0; i < SACH.length; i++) {
            if (SACH[i] != null) {
                if (MaSach == SACH[i].getMaSach()) {
                    return SACH[i];
                }
            }
        }
        return null;
    }

    // Tìm kiếm bạn đọc theo mã bạn đọc
    public static BanDoc timKiemBDTheoID(int maBanDoc) {
        for (int i = 0; i < BANDOC.length; i++) {
            if (BANDOC[i] != null) {
                if (maBanDoc == BANDOC[i].getMaBanDoc()) {
                    return BANDOC[i];
                }
            }
        }
        return null;
    }

    // Kiểm tra mã sách trùng nhau
    private static boolean kiemTraMaTrung(int ma, MuonSach[] muonSach) {
        for (int i = 0; i < muonSach.length; i++) {
            if (muonSach[i] != null) {
                if (ma == muonSach[i].getSach().getMaSach()) {
                    return false;
                }
            }
        }
        return true;
    }

    // Lập bảng quản lý
    public static void quanLy() {
        QLMuonSach ql = new QLMuonSach();
        if (!kiemTraDuLieu()) {
            System.out.println("Chưa có dữ liệu của sách và bạn đọc");
            return;
        }

        int maBD;
        BanDoc maBanDoc;
        do {
            System.out.println("Nhập mã bạn đọc cần tìm: ");
            maBD = scanner.nextInt();
            maBanDoc = timKiemBDTheoID(maBD);
            if (maBanDoc != null) {
                break;
            } else {
                System.out.println("Mã bạn đọc không tồn tại. Nhập lại!");
            }
        } while (true);

        ql.setBanDoc(maBanDoc);

        int n;
        do {
            System.out.println("Nhập số lượng đầu sách muốn mượn: ");
            n = scanner.nextInt();
            if (n <= 5) {
                break;
            } else {
                System.out.println("Chỉ được mượn ít hơn 5 đầu sách");
            }
        } while (true);

        MuonSach muonSach[] = new MuonSach[n];
        for (int i = 0; i < n; i++) {
            int maSach;
            do {
                System.out.println("Nhập mã sách thứ " + (i + 1) + " : ");
                maSach = scanner.nextInt();
                if (timKiemSachTheoID(maSach) != null && kiemTraMaTrung(maSach, muonSach)) {
                    break;
                }
                System.out.println("Mã sách không tồn tại. Nhập lại!");
            } while (true);

            Sach s = timKiemSachTheoID(maSach);
            MuonSach m = new MuonSach();
            m.setSach(s);
            int sLuong;
            do {
                System.out.println("Nhập số lượng sách: ");
                sLuong = scanner.nextInt();
                if (sLuong <= 3) {
                    break;
                }
                System.out.println("Số lượng không được lớn hơn 3");
            } while (true);

            m.setSoLuong(sLuong);
            muonSach[i] = m;
        }
        ql.setMuonSach(muonSach);
        QLMUONSACH[INDEXARR++] = ql;
    }

    // Hiển thị bảng
    public static void hienThiQLMS() {
        for (int i = 0; i < QLMUONSACH.length; i++) {
            if (QLMUONSACH[i] != null) {
                System.out.println("Bạn đọc: " + QLMUONSACH[i].getBanDoc().getHoTen() + " đã mượn: ");
                for (int j = 0; j < QLMUONSACH[i].getMuonSach().length; j++) {
                    System.out.println(QLMUONSACH[i].getMuonSach()[j].getSach().getTenSach() + ", số lượng: " + QLMUONSACH[i].getMuonSach()[j].getSoLuong());
                }
            }
        }
    }

    public void sapXepSL(ESort eSort) {

    }

    public static void sxTheoBD() {
        boolean check = false;
        for (int i = 0; i < QLMUONSACH.length; i++) {
            if (QLMUONSACH[i] != null) {
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Chưa có dữ liệu. Xin mời nhập dữ liệu");
            return;
        }
        for (int i = 0; i < INDEXARR - 1; i++) {
            for (int j = i + 1; j < INDEXARR; j++) {
                if (QLMUONSACH[i].getBanDoc().getHoTen().compareTo(QLMUONSACH[j].getBanDoc().getHoTen()) > 0) {
                    QLMuonSach temp = QLMUONSACH[i];
                    QLMUONSACH[i] = QLMUONSACH[j];
                    QLMUONSACH[j] = temp;
                }
            }
        }
    }

    public static int tongSLSach(QLMuonSach ql) {
        int sum = 0;
        for (int i = 0; i < ql.getMuonSach().length; i++) {
            MuonSach muonSach = ql.getMuonSach()[i];
            if (muonSach != null) {
                sum += muonSach.getSoLuong();
            }
        }
        return sum;
    }

    public static void sxTheoSL() {
        boolean check = false;
        for (int i = 0; i < QLMUONSACH.length; i++) {
            if (QLMUONSACH[i] != null) {
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Chưa có dữ liệu. Xin mời nhập dữ liệu");
            return;
        }
        for (int i = 0; i < INDEXARR - 1; i++) {
            for (int j = i + 1; j < INDEXARR; j++) {
                if (tongSLSach(QLMUONSACH[i]) < tongSLSach(QLMUONSACH[j])) {
                    QLMuonSach temp = QLMUONSACH[i];
                    QLMUONSACH[i] = QLMUONSACH[j];
                    QLMUONSACH[j] = temp;
                }
            }
        }
    }

}
