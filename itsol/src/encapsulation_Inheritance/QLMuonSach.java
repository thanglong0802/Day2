package encapsulation_Inheritance;

import java.util.Scanner;

public class QLMuonSach {

    static BanDoc banDoc = new BanDoc();
    static Sach[] sachs = new Sach[15];
    QLMuonSach quanLy[] = new QLMuonSach[50];

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

    public void nhap(Scanner scanner) {
        System.out.println("=== Thêm mới ===");
    }

    public String hienThi() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mã: ");
        return builder.toString();
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

    //    ham tim kiem sach muon
    private Sach searchBook(Sach[] sachs, int bookId) {
        for (int i = 0; i < sachs.length; i++) {
            if (sachs[i] == null) break;
            if (sachs[i].getMaSach() == bookId) return sachs[i];
        }
        return null;
    }

    //  ham them sach da muon vao danh sach muon
    private void addBook(Sach sach, Sach[] sachs) {
        for (int i = 0; i < sachs.length; i++) {
            if (sachs[i] == null) {
                sachs[i] = sach;
                break;
            }
        }
    }

    // ham quan ly muon sach
    public void borrowBook(BanDoc banDoc, Sach[] sachs) {
        this.banDoc = banDoc;
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("nhap vao so luong sach ma ban doc " + banDoc.getMaBanDoc() + " muon: ");
            n = input.nextInt();
            if (n < 1 || n > 15) System.out.println("So luong muon khong hop le. Xin moi nhap lai!");
        } while (n < 1 || n > 15);
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (this.sachs[this.sachs.length - 1] != null) {
                System.out.println("khong the muon them sach vi so luong sach da muon toi da");
                break;
            }
            if (this.sachs[i] == null) {
                do {
                    System.out.println("nhap ma sach thu " + index + "ma ban doc muon: ");
                    int id = input.nextInt();
                    if (searchBook(sachs, id) == null) {
                        System.out.println("khong ton tai ID nay, Nhap lai id.");
                        continue;
                    }
                    index++;
                    Sach s = searchBook(sachs, id);
                    if (kiemTra(this.sachs, s.getChuyenNganh())) {
                        addBook(s, this.sachs);
                        break;
                    } else {
                        System.out.println("qua so luong sach cua 1 dau sach, hay chon sach khac");
                        index--;
                    }
                } while (true);
            }
        }
    }

    //    ham hien thi danh sach sach da muon cua ban doc
    public void showBookBorrow() {
        System.out.println("Ban doc " + banDoc.getMaBanDoc() + ":" + banDoc.getHoTen() + " da muon cac sach:");
        for (int i = 0; i < sachs.length; i++) {
            if (sachs[i] == null) break;
            System.out.print("\t");
            System.out.println(sachs[i].toString());
        }
    }

}
