import java.io.*;

class dbfile {
  public static void main(String args[]) throws IOException {
    int i=9876;
    float f=1234.56789F+1;
//    try (FileWriter fout = new FileWriter("dbf1.txt")) {
    try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.write(String.valueOf(i).getBytes()); // String Number
	fout.seek(16);
	fout.write(String.valueOf(f).getBytes()); // String Float
	fout.seek(32);
	fout.write("TEST-Прошлого файла".getBytes());
	fout.write(13); //0Dh
	fout.close();
    } catch(IOException e) {
      System.out.println("I/O Error: " + e);
    }
  }
}
