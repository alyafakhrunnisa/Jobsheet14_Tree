package Pertemuan14;
public class BinaryTreeArray02 {
    Mahasiswa02[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray02() {
        this.dataMahasiswa = new Mahasiswa02[10];
    }

    void populateData(Mahasiswa02 dataMhs[], int idxLast) {
        this.dataMahasiswa= dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }

    // TUGAS 4
    private void resize() {
        Mahasiswa02[] newArr = new Mahasiswa02[dataMahasiswa.length * 2];
        System.arraycopy(dataMahasiswa, 0, newArr, 0, dataMahasiswa.length);
        dataMahasiswa = newArr;
    }

    void add(Mahasiswa02 data) {
        // Pastikan array cukup besar
        if (dataMahasiswa.length < 1) resize();
        // Jika tree kosong
        if (dataMahasiswa[0] == null) {
            dataMahasiswa[0] = data;
            idxLast = 0;
            return;
        }
        // Traversal BST: kiri jika IPK lebih kecil, kanan jika lebih besar/sama
        int idx = 0;
        while (true) {
            if (data.ipk < dataMahasiswa[idx].ipk) {
                int left = 2 * idx + 1;
                while (left >= dataMahasiswa.length) resize();
                if (dataMahasiswa[left] == null) {
                    dataMahasiswa[left] = data;
                    if (left > idxLast) idxLast = left;
                    return;
                } else {
                    idx = left;
                }
            } else {
                int right = 2 * idx + 2;
                while (right >= dataMahasiswa.length) resize();
                if (dataMahasiswa[right] == null) {
                    dataMahasiswa[right] = data;
                    if (right > idxLast) idxLast = right;
                    return;
                } else {
                    idx = right;
                }
            }
        }
    }
 
    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                dataMahasiswa[idxStart].tampilInformasi();
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }
    }
}
