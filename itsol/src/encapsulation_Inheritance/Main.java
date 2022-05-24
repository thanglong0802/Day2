package encapsulation_Inheritance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLMuonSach arrQLMuonSach[] = new QLMuonSach[50];
        int indexSach = 0;
        int indexBanDoc = 0;
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Nhập sách và bạn đọc");
            System.out.println("2. Xem danh sách bạn đọc đã mượn sách");
            System.out.println("3. Sắp xếp danh sách quản lý mượn sách");
            System.out.println("4. Tìm kiếm (hiển thị danh sách theo tên bạn đọc)");
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
//                    System.out.println("3. Hiển thị danh sách");
                    int choice = QLMuonSach.nhapInt(scanner);
                    if (choice == 1) {
                        QLMuonSach sach = new Sach();
                        sach.nhap(scanner);
                        arrQLMuonSach[indexSach++] = sach;
                        for (int i = 0; i < indexSach; i++) {
                            System.out.println(arrQLMuonSach[i].hienThi());
                        }
                        break;
                    } if (choice == 2) {
                        QLMuonSach banDoc = new BanDoc();
                        banDoc.nhap(scanner);
                        arrQLMuonSach[indexBanDoc++] = banDoc;
                        for (int i = 0; i < indexBanDoc; i++) {
                            System.out.println(arrQLMuonSach[i].hienThi());
                        }
                        break;
                    } else {
                        System.out.println("Nhập lại số!");
                    }
                }
            } else if (choiceMainMenu == 2) {
                int maSach;
                do {
                    System.out.println("Nhập mã sách: ");
                    maSach = scanner.nextInt();
                    if (maSach == indexSach) {

                    }
                } while (maSach < 0);
            } else if (choiceMainMenu == 3) {

            } else {
                System.out.println("Phần cuối");
            }
        }
        System.out.println("Thoát chương trình");
    }

}
