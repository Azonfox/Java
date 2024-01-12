//import java.Math

// Описание Родительского класса всех датчиков
class dsxxx {
    int  idfabric;
    double idname=0;
    double temperatura=0;
    // Конструктор1
    dsxxx(){ 
	idfabric=1000; 
    }
    // Конструктор2
    dsxxx(int idfab){ 
	idfabric=idfab; 
    }

    // Выдаем значение температуры - несколько способов
    public void readtemp(){  
	System.out.printf("%7.2f %15d\n", temperatura,  idfabric); 
    }
    // Переопределение метода readtemp
    public void readtemp(String namedat){  
	System.out.printf("%7.2f %s\n", temperatura,"        "+namedat); 
    }
    // Переопределение метода readtemp
    public void readtemp(int idfab){  
	System.out.printf("%7.2f %15d\n", temperatura,  idfab); 
    }

    // Получить показания датчика  - случайное число
    public void gettemp() { 
	temperatura=Math.floor((-50+170*Math.random())*100)/100;
    }
}

// Дочерний класс датчика - микросхема ds18b20
class ds18b20 extends dsxxx {
    // Конструктор1
    ds18b20(){ 
	idfabric=1000; 
    }
    // Конструктор2
    ds18b20(int idfab){ 
	idfabric=idfab; 
    }
}

// Дочерний класс датчика - микросхема ds1920
class ds1920 extends dsxxx {
    // Конструктор1
    ds1920(){ 
	idfabric=2000; 
    }
    // Конструктор2
    ds1920(int idfab){ 
	idfabric=idfab; 
    }
}

// Собственно работа программы - метод main
class datchik {
    public static void main(String args[]) {
	// Создаем объекты-датчики с номерами и без них
	ds18b20 ds18_1 = new ds18b20();
	ds18b20 ds18_2 = new ds18b20(1820122000);
	ds1920  ds19_1 = new ds1920();
	ds1920  ds19_2 = new ds1920(1920222);

	// Запрашиваем измерения от датчиков
	// При этом датчики заполняют свою память  значениями температуры
	ds18_1.gettemp(); 
	ds18_2.gettemp();
	ds19_1.gettemp(); 
	ds19_2.gettemp();

	// Печатаем шапку таблицы
	System.out.println("-------------------------"); 
	System.out.println("Температура      Датчик  "); 
	System.out.println("-------------------------"); 
	// Запрашиваем значение памяти датчика о температуре 
	ds18_1.readtemp(ds18_1.idfabric);
	ds18_2.readtemp();
	ds19_1.readtemp("Внутренний термометр");
	ds19_2.readtemp();
	System.out.println("-------------------------"); 
    }
}
