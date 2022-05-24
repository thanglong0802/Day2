package encapsulation_Inheritance;

public class MuonSach {
    private Sach sach;
    private int soLuong;

    public Sach getSach() {
        return sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String hienThi() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sách: ").append(sach).
                append(", số lượng: ").append(soLuong);
        return builder.toString();
    }
}
