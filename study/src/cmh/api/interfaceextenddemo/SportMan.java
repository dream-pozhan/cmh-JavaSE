package cmh.api.interfaceextenddemo;

public interface SportMan extends Law,People{
    void run();

}
//接口的多继承：整合多个接口为同一个接口，便于子类实现
//类和类：单继承；类和接口：多实现；接口和接口：多继承