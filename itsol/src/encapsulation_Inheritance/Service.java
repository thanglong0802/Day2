package encapsulation_Inheritance;

public class Service {
    BanDoc[] banDoc = new BanDoc[50];
    Sach[] sachs = new Sach[50];
    QLMuonSach [] managements = new QLMuonSach[50];

    //  quan ly muon sach cho tung ban doc va in ra man hinh
    public void bookBorrowManagement() {
        if (banDoc[0] == null || sachs[0] == null) {
            System.out.println("chua co du lieu ban doc hoac du lieu sach");
        }
        for (int i = 0; i < banDoc.length; i++) {
            if (banDoc[i] == null) break;
            managements[i] = new QLMuonSach();
            managements[i].borrowBook(banDoc[i], sachs);
        }
        System.out.println("BANG QUAN LY MUON SACH:");
        System.out.println("=======================================================================================");
        for (int i = 0; i < managements.length; i++) {
            if (managements[i] == null) break;
            managements[i].showBookBorrow();
            System.out.println("=======================================================================================");
        }
    }
}
