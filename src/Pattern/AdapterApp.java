package Pattern;

public class AdapterApp {
    public static void main(String[] args) {
        // 1-й способ. Наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        // 2-й способ/ Композиция
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();
    }
}

/*
1-й способ. Реализация через наследование
Создаем класс, который используя интерфейс выполняет методы родительского класса
 */
interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}
class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

/*
2-й способ. Композиция
В классе реализуем интерфейс, в котором используем методы другого класса (переменная)
 */
class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics rasterGraphics = new RasterGraphics();

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}


