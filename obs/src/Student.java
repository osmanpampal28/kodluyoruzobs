public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
        this.mat.sozlu=0.2;
        this.fizik.sozlu=0.2;
        this.kimya.sozlu=0.25;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya,int matsozlu,int fiziksozlu,int kimyasozlu) {

        if (mat >= 0 && mat <= 100 && matsozlu>=0 && matsozlu<=100) {
            this.mat.note = mat;
            this.mat.sozlunote=matsozlu;
        }

        if (fizik >= 0 && fizik <= 100 && fiziksozlu>=0 && fiziksozlu<=100) {
            this.fizik.note = fizik;
            this.fizik.sozlunote=fiziksozlu;
        }

        if (kimya >= 0 && kimya <= 100 && kimyasozlu>=0 && kimyasozlu<=100) {
            this.kimya.note = kimya;
            this.kimya.sozlunote=kimyasozlu;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        double fizikort=(this.fizik.sozlunote*this.fizik.sozlu)+(this.fizik.note*(1-this.fizik.sozlu));
        double kimyaort=(this.kimya.sozlunote*this.kimya.sozlu)+(this.kimya.note*(1-this.kimya.sozlu));
        double matort=(this.mat.sozlunote*this.mat.sozlu)+(this.mat.note*(1-this.mat.sozlu));
        this.avarage = (fizikort+kimyaort+matort) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Matematik  Sözlü Notu : "+this.mat.sozlunote);
        System.out.println("Fizik Sözlü Notu : "+this.fizik.sozlunote);
        System.out.println("Kimya Sözlü Notu : "+this.kimya.sozlunote);
    }

}
